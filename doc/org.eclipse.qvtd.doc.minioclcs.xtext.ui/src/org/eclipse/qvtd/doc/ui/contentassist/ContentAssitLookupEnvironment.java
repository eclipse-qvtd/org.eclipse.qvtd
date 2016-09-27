package org.eclipse.qvtd.doc.ui.contentassist;


import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.pivot.evaluation.Executor;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorManager;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.qvtd.doc.miniocl.NamedElement;
import org.eclipse.qvtd.doc.miniocl.lookup.LookupEnvironment;
import org.eclipse.qvtd.doc.miniocl.lookup.impl.LookupEnvironmentImpl;
	

public class ContentAssitLookupEnvironment extends LookupEnvironmentImpl {
	
	private EcoreExecutorManager executor;
	
	public ContentAssitLookupEnvironment(EObject object) {
		executor = new EcoreExecutorManager(object, new ExecutorStandardLibrary()); // FIXME 
	}
	
	
	@Override
	public LookupEnvironment addElements( NamedElement namedElement) {
		if (namedElement != null) {
			EList<NamedElement> elements = getNamedElements();
			if (!elements.contains(namedElement)) { 	// FIXME use a set ?
				elements.add(namedElement);
			}
		}
		return this;
	}
	
	@Override
	public <NE extends NamedElement > LookupEnvironment addElements(Collection<NE> namedElements) {
		if (namedElements != null) {
			for (NamedElement namedElement : namedElements) {
				addElements(namedElement);
			}	
		}
		return this;
	}
	
	@Override
	public boolean hasFinalResult() {	
		return false; // So all the possible results are gathered
	}
	
	@Override
	public Executor getExecutor() {
		return executor;
	}
}
