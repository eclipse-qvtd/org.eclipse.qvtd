package org.eclipse.qvt.declarative.editor.ui.text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;
import org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector;
import org.eclipse.ui.texteditor.spelling.SpellingAnnotation;
import org.eclipse.ui.texteditor.spelling.SpellingProblem;
import org.eclipse.ui.texteditor.spelling.SpellingReconcileStrategy;
import org.eclipse.ui.texteditor.spelling.SpellingService;

//
//	This class introduces the fix for Bug 195416 from SpellingReconcileStrategy 1.12, which
//	is in the Eclipse 3.3 maintenance stream.
//
// FIXME Eliminate getReconciler as soon as Eclipse 3.3.1 dependence acceptable.
//
@Deprecated // Use UniversalTextEditor
public class QVTTextSourceViewerConfiguration extends TextSourceViewerConfiguration
{
	/**
	 * Spelling problem collector.
	 */
	private class SpellingProblemCollector implements ISpellingProblemCollector {

		/** Annotation model. */
		private IAnnotationModel fAnnotationModel;

		/** Annotations to add. */
		private Map<Object,Object> fAddAnnotations;
		
		/** Lock object for modifying the annotations. */
		private Object fLockObject;

		/**
		 * Initializes this collector with the given annotation model.
		 *
		 * @param annotationModel the annotation model
		 */
		public SpellingProblemCollector(IAnnotationModel annotationModel) {
			Assert.isLegal(annotationModel != null);
			fAnnotationModel= annotationModel;
			if (fAnnotationModel instanceof ISynchronizable)
				fLockObject= ((ISynchronizable)fAnnotationModel).getLockObject();
			else
				fLockObject= fAnnotationModel;
		}

		/*
		 * @see org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector#accept(org.eclipse.ui.texteditor.spelling.SpellingProblem)
		 */
		public void accept(SpellingProblem problem) {
			fAddAnnotations.put(new SpellingAnnotation(problem), new Position(problem.getOffset(), problem.getLength()));
		}

		/*
		 * @see org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector#beginCollecting()
		 */
		public void beginCollecting() {
			fAddAnnotations= new HashMap<Object,Object>();
		}

		/*
		 * @see org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector#endCollecting()
		 */
		public void endCollecting() {
			
			List<Object> toRemove= new ArrayList<Object>();
			
			synchronized (fLockObject) {
				Iterator<?> iter= fAnnotationModel.getAnnotationIterator();
				while (iter.hasNext()) { 
					Annotation annotation= (Annotation)iter.next(); 
					if (SpellingAnnotation.TYPE.equals(annotation.getType())) 
						toRemove.add(annotation); 
				} 
				Annotation[] annotationsToRemove= toRemove.toArray(new Annotation[toRemove.size()]);

				if (fAnnotationModel instanceof IAnnotationModelExtension)
					((IAnnotationModelExtension)fAnnotationModel).replaceAnnotations(annotationsToRemove, fAddAnnotations);
				else {
					for (int i= 0; i < annotationsToRemove.length; i++)
						fAnnotationModel.removeAnnotation(annotationsToRemove[i]);
					for (iter= fAddAnnotations.keySet().iterator(); iter.hasNext();) {
						Annotation annotation= (Annotation)iter.next();
						fAnnotationModel.addAnnotation(annotation, (Position)fAddAnnotations.get(annotation));
					}
				}
			}

			fAddAnnotations= null;
		}
	}

	public QVTTextSourceViewerConfiguration(IPreferenceStore preferenceStore) {
		super(preferenceStore);
	}
	
	@Override public IReconciler getReconciler(ISourceViewer sourceViewer) {
		if (fPreferenceStore == null || !fPreferenceStore.getBoolean(SpellingService.PREFERENCE_SPELLING_ENABLED))
			return null;

		SpellingService spellingService= EditorsUI.getSpellingService();
		if (spellingService.getActiveSpellingEngineDescriptor(fPreferenceStore) == null)
			return null;
		
		IReconcilingStrategy strategy= new SpellingReconcileStrategy(sourceViewer, spellingService)
		{

			/**
			 * Creates a new spelling problem collector.
			 * 
			 * @return the collector or <code>null</code> if none is available
			 */
			@Override protected ISpellingProblemCollector createSpellingProblemCollector() {
				IAnnotationModel model= getAnnotationModel();
				if (model == null)
					return null;
				return new SpellingProblemCollector(model);
			}
			
		}; 
		MonoReconciler reconciler= new MonoReconciler(strategy, false);
		reconciler.setIsIncrementalReconciler(false);
		reconciler.setProgressMonitor(new NullProgressMonitor());
		reconciler.setDelay(500);
		return reconciler;
	}
}
