/*******************************************************************************
 * Copyright (c) 2024 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *	 E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.sirius;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSelector;
import org.eclipse.sirius.business.internal.session.SessionTransientAttachment;
import org.eclipse.sirius.business.internal.session.danalysis.DAnalysisSessionImpl;
import org.eclipse.sirius.business.internal.session.danalysis.DAnalysisSessionServicesImpl;
import org.eclipse.sirius.diagram.business.api.query.EObjectQuery;
import org.eclipse.sirius.ui.business.api.dialect.DialectUIManager;
import org.eclipse.sirius.ui.business.api.session.EditingSessionEvent;
import org.eclipse.sirius.ui.business.api.session.IEditingSession;
import org.eclipse.sirius.ui.business.api.session.SessionUIManager;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.ui.business.internal.commands.ChangeViewpointSelectionCommand;
import org.eclipse.sirius.ui.tools.internal.views.common.modelingproject.OpenRepresentationsFileJob;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.provider.Messages;
import org.eclipse.sirius.viewpoint.provider.SiriusEditPlugin;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * InitializeDiagramJob provides a non-interactive sequencing of the three interactive activities.
 * OpenRepresentationsFileJob to establish a Session, ChangeViewpointSelectionCommand to establish a DView,
 * and CreateRepresentationCommand to create a DDiagram. The job ends by opening an editor.
 */
public class InitializeDiagramJob extends OpenRepresentationsFileJob
{
	protected static class InitializeDiagramCreate extends WorkspaceModifyOperation // ?? implements Runnable
	{
		private static class AIRDFileCreationOperation extends WorkspaceModifyOperation		// from org.eclipse.sirius.ui.tools.internal.wizards.ExtractRepresentationsWizard
		{
			public static @Nullable Resource create(@NonNull ResourceSet resourceSet, @NonNull URI representationFileURI) {
				AIRDFileCreationOperation op = new AIRDFileCreationOperation(resourceSet, representationFileURI);
				try {
					new ProgressMonitorDialog(null).run(false, true, op);
				} catch (final InterruptedException e) {
			//		return true;
				} catch (final InvocationTargetException e) {
					if (e.getTargetException() instanceof CoreException) {
						openError(Messages.ExtractRepresentationsWizard_resourceCreationError, null, e.getTargetException());
					} else {
					//	SiriusTransPlugin.getPlugin().error(Messages.ExtractRepresentationsWizard_airdCreationError, e.getTargetException());
						openError(Messages.ExtractRepresentationsWizard_airdCreationError, null, e.getTargetException());
					}
			//		return true;
				}
				return op.resource;
			}

			protected final @NonNull ResourceSet resourceSet;
			protected final @NonNull URI representationFileURI;
			private @Nullable Resource resource = null;

			protected AIRDFileCreationOperation(@NonNull ResourceSet resourceSet, @NonNull URI representationFileURI) {
				super(null);
				this.resourceSet = resourceSet;
				this.representationFileURI = representationFileURI;
			}

			@Override
			protected void execute(final IProgressMonitor monitor) throws CoreException, InterruptedException
			{
				resource = resourceSet.createResource(representationFileURI);
			}

			public @Nullable Resource getResource() {
				return resource;
			}
		}

		protected static void create(@NonNull Session session, @NonNull RepresentationDescription registryRepresentationDescription, @NonNull URI representationFileURI, @NonNull String representationDiagramName, @NonNull List<@NonNull EObject> modelObjects) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable()
			{
				@Override
				public void run() {																	// run on main
					try {
						WorkspaceModifyOperation op = new InitializeDiagramCreate(session, registryRepresentationDescription, representationFileURI, representationDiagramName, modelObjects);
						new ProgressMonitorDialog(null).run(true, true, op);
					} catch (InvocationTargetException | InterruptedException e) {
						SiriusEditPlugin.getPlugin().getLog().log(new Status(IStatus.ERROR, SiriusEditPlugin.ID, e.getLocalizedMessage(), e));
					}
				}
			});
		}

		protected final @NonNull Session session;
		protected final @NonNull RepresentationDescription registryRepresentationDescription;
		protected final @NonNull URI representationFileURI;
		protected final @NonNull List<@NonNull EObject> modelObjects;
		protected final @NonNull String representationDiagramName;

		protected InitializeDiagramCreate(@NonNull Session session, @NonNull RepresentationDescription registryRepresentationDescription, @NonNull URI representationFileURI, @NonNull String representationDiagramName, @NonNull List<@NonNull EObject> modelObjects) {													// ctor on main
			this.session = session;
			this.registryRepresentationDescription = registryRepresentationDescription;
			this.representationFileURI = representationFileURI;
			this.representationDiagramName = representationDiagramName;
			this.modelObjects = modelObjects;
			assert modelObjects.size() >= 1;
		}

		protected @Nullable Resource createAIRDFile() {
			TransactionalEditingDomain transactionalEditingDomain = session.getTransactionalEditingDomain();
			ResourceSet resourceSet = transactionalEditingDomain.getResourceSet();
			assert resourceSet != null;
			if (!resourceSet.getURIConverter().exists(representationFileURI, null)) {
				return AIRDFileCreationOperation.create(resourceSet, representationFileURI);
			}
			else {
				return resourceSet.getResource(representationFileURI, true);
			}
		}

		protected @Nullable DRepresentation createRepresentation(IProgressMonitor monitor, RepresentationDescription editingDomainRepresentationDescription) {
			TransactionalEditingDomain transactionalEditingDomain = session.getTransactionalEditingDomain();
			EObject modelObject = modelObjects.get(0);
			CommandStack commandStack = transactionalEditingDomain.getCommandStack();
			assert commandStack != null;
			ResourceSet resourceSet = transactionalEditingDomain.getResourceSet();
			assert resourceSet != null;
			IEditingSession editingSession = SessionUIManager.INSTANCE.getUISession(session);
			MyCreateRepresentationCommand createRepresentationCommand = new MyCreateRepresentationCommand(session, editingDomainRepresentationDescription, modelObject, representationDiagramName,
					new SubProgressMonitor(monitor, 4));
			DAnalysis dAnalysis = getDAnalysis(resourceSet);

			Session semanticSession = new EObjectQuery(modelObject).getSession();
			if (semanticSession == null) {				// If not (yet) known to representations.aird
				modelObject.eResource().eAdapters().add(new SessionTransientAttachment(session));
				semanticSession = new EObjectQuery(modelObject).getSession();
				assert semanticSession != null;
			}

			editingSession.notify(EditingSessionEvent.REPRESENTATION_ABOUT_TO_BE_CREATED_BEFORE_OPENING);
			if (!createRepresentationCommand.canExecute()) {
				openError(null, "Unable to create \"" +  registryRepresentationDescription.getLabel() + "\"\nFIXME need to break out canExecute failures", null);
				return null;
			}
			commandStack.execute(createRepresentationCommand);
			editingSession.notify(EditingSessionEvent.REPRESENTATION_CREATED_BEFORE_OPENING);
			return createRepresentationCommand.getCreatedRepresentation();
		}

		@Override
		protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {		// execute on main
			try {
				monitor.beginTask(org.eclipse.sirius.viewpoint.provider.Messages.CreateRepresentationAction_creationTask, 15);

				EObject modelObject = modelObjects.get(0);
				if (!session.getSemanticResources().contains(modelObject.eResource())) {
					session.close(monitor);
					session.getSemanticResources();
				}

				Resource airdResource = createAIRDFile();
				if (airdResource == null) {
					return;
				}
				Viewpoint registryViewpoint = selectViewpoint(monitor);

				// XXX wrap above in a ProgressMonitorDialog cf ViewpointHelper.applyNewViewpointSelection

				Viewpoint editingDomainViewpoint = SiriusResourceHelper.getCorrespondingViewpoint(session, registryViewpoint);	// XXX error dialog
				if (editingDomainViewpoint == null) {
					openError(null, "Failed to localize \"" +  registryViewpoint.getLabel() + "\" Viewpoint", null);
					return;
				}
				String representationDescriptionName = registryRepresentationDescription.getName();
				RepresentationDescription editingDomainRepresentationDescription = getRepresentationDescription(editingDomainViewpoint, representationDescriptionName);
				if (editingDomainRepresentationDescription == null) {
					openError(null, "Failed to localize \"" +  registryRepresentationDescription.getLabel() + "\" RepresentationDesacription", null);
					return;
				}
			//	new ViewpointSelector(session).selectViewpoint(registryViewpoint, createNewRepresentations, monitor);

				DRepresentation createdDRepresentation = createRepresentation(monitor, editingDomainRepresentationDescription);
				monitor.worked(1);

				IRunnableWithProgress runnable = new InitializeDiagramEdit(session, createdDRepresentation);
			//	Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				IRunnableContext context = new ProgressMonitorDialog(null);
				PlatformUI.getWorkbench().getProgressService().runInUI(context, runnable, null);
			} catch (Exception e) {
				openError(null, e.getLocalizedMessage(), e);
			} finally {
				monitor.done();
			}
		}

		protected @NonNull DAnalysis getDAnalysis(@NonNull ResourceSet resourceSet) {
			DAnalysis dAnalysis = null;
			if (representationFileURI != null) {
				EList<DAnalysis> analyses = ((DAnalysisSessionImpl)session).getAnalyses();
			//	Collection<Resource> semanticResources = ((DAnalysisSessionImpl)session).getSemanticResources();
				Resource resource = resourceSet.getResource(representationFileURI, true);  // XXX Create if doesn't exist - see org.eclipse.sirius.ui.tools.internal.wizards.ExtractRepresentationsWizard
				for (EObject eObject : resource.getContents()) {
					if (eObject instanceof DAnalysis) {
						dAnalysis = (DAnalysis)eObject;
						break;
					}
				}
				assert dAnalysis != null;			// XXX
			}
			else {
				dAnalysis = ((DAnalysisSessionImpl)session).getMainAnalysis();
			}
			final DAnalysis finalDAnalysis = dAnalysis;


			((DAnalysisSessionServicesImpl)session.getServices()).setAnalysisSelector(new DAnalysisSelector() {

				@Override
				public DAnalysis selectSmartlyAnalysisForAddedResource(Resource resource, Collection<DAnalysis> allAnalysis) {
					return finalDAnalysis;//allAnalysis.iterator().next();
				}

				@Override
				public DAnalysis selectSmartlyAnalysisForAddedRepresentation(DRepresentation representation, Collection<DAnalysis> allAnalysis) {
					return finalDAnalysis;//allAnalysis.iterator().next();
				}
			});
			return finalDAnalysis;
		}

		private RepresentationDescription getRepresentationDescription(Viewpoint viewpoint, final String representationName) {
			for (final RepresentationDescription representationDescription : viewpoint.getOwnedRepresentations()) {
				if (representationName.equals(representationDescription.getName())) {
					return representationDescription;
				}
			}
			return null;
		}

		protected @NonNull Viewpoint selectViewpoint(@NonNull IProgressMonitor monitor) {
			TransactionalEditingDomain transactionalEditingDomain = session.getTransactionalEditingDomain();
			CommandStack commandStack = transactionalEditingDomain.getCommandStack();
			assert commandStack != null;
			Viewpoint registryViewpoint = (Viewpoint) registryRepresentationDescription.eContainer();
			assert registryViewpoint != null;
			ViewpointSelectionCallback callback = new ViewpointSelectionCallback();
			Set<Viewpoint> registryViewpoints = Collections.singleton(registryViewpoint);
			boolean createNewRepresentations = true;
			ChangeViewpointSelectionCommand changeViewpointSelectionCommand = new ChangeViewpointSelectionCommand(session, callback, registryViewpoints, Collections.EMPTY_SET, createNewRepresentations,
					new SubProgressMonitor(monitor, 4));
			commandStack.execute(changeViewpointSelectionCommand);	// XXX canCreate should use selected elements
			return registryViewpoint;
		}
	}

	protected static class InitializeDiagramEdit implements IRunnableWithProgress
	{
		protected final Session session;
		protected final DRepresentation createdDRepresentation;

		public InitializeDiagramEdit(Session session, DRepresentation createdDRepresentation) {
			this.session = session;
			this.createdDRepresentation = createdDRepresentation;
		}

		@Override
		public void run(final IProgressMonitor monitor) {
			try {
				monitor.beginTask(org.eclipse.sirius.viewpoint.provider.Messages.CreateRepresentationAction_openingTask, 1);
				DialectUIManager.INSTANCE.openEditor(session, createdDRepresentation, new SubProgressMonitor(monitor, 1));
			} finally {
				monitor.done();
			}
		}
	}

	/**
	 * Launch this derived OpenRepresentationsFileJob job when all other OpenRepresentationsFileJob job are finished.
	 * @param representationDescription
	 * @param representationName
	 *
	 * @param representationsFileURI
	 *			The URI of the representations file to open.
	 * @param user
	 *			<code>true</code> if this job is a user-initiated job, and <code>false</code> otherwise.
	 * @param isDirectUserActionLoading
	 *			<code>true</code> if this session opening comes from a direct user action, </code>false<code>
	 *			otherwise
	 */
	public static void scheduleNewWhenPossible(@NonNull URI sessionURI, @NonNull RepresentationDescription representationDescription, @NonNull URI representationFileURI, @NonNull String representationDiagramName, @NonNull List<@NonNull URI> modelObjectURIs) {
		Job job = new InitializeDiagramJob(sessionURI, representationDescription, representationFileURI, representationDiagramName, modelObjectURIs);
		job.setUser(true);
		job.setPriority(Job.SHORT);
		job.schedule();
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow != null) {
			PlatformUI.getWorkbench().getProgressService().showInDialog(activeWorkbenchWindow.getShell(), job);
		}
	}

	protected final @NonNull URI sessionURI;
	protected final @NonNull RepresentationDescription registryRepresentationDescription;
	protected final @NonNull URI representationFileURI;		// Null for shared into ModelingProject.DEFAULT_REPRESENTATIONS_FILE_NAME
	protected final @NonNull String representationDiagramName;
	protected final @NonNull List<@NonNull URI> modelObjectURIs;

	private Session session;

	/**
	 * Constructor to open only one representations file.
	 * @param representationName
	 *
	 * @param representationsFileURI
	 *			The URI of the representations file to open.
	 * @param isDirectUserActionLoading
	 *			<code>true</code> if this session opening comes from a direct user action, </code>false<code>
	 *			otherwise
	 */
	private InitializeDiagramJob(@NonNull URI sessionURI, @NonNull RepresentationDescription registryRepresentationDescription, @NonNull URI representationFileURI, @NonNull String representationDiagramName, @NonNull List<@NonNull URI> modelObjectURIs) {
		super(sessionURI, true);
		this.sessionURI = sessionURI;
		this.registryRepresentationDescription = registryRepresentationDescription;
		this.representationFileURI = representationFileURI;
		this.representationDiagramName = representationDiagramName;
		this.modelObjectURIs = modelObjectURIs;
		assert modelObjectURIs.size() >= 1;
	}

	protected @NonNull List<@NonNull EObject> getModelObjects(@NonNull ResourceSet resourceSet) {
		List<@NonNull EObject> modelObjects = new ArrayList<>(modelObjectURIs.size());
		for (@NonNull URI modelURI : modelObjectURIs) {
			EObject modelObject = resourceSet.getEObject(modelURI, true);
			assert modelObject != null;
			modelObjects.add(modelObject);
		}
		return modelObjects;
	}

	public static void openError(String message, String reason, @Nullable Throwable e) {
		Bundle bundle = FrameworkUtil.getBundle(InitializeDiagramHandler.class);
		Status status = new Status(IStatus.ERROR, bundle.getSymbolicName(), 0, reason, e);
		Display.getDefault().asyncExec(new Runnable()
		{
			@Override
			public void run() {
				ErrorDialog.openError(null, "Initialize Diagram Error", message, status);
			}
		});
	}


	@Override
	public IStatus runInWorkspace(IProgressMonitor monitor) {
		this.session = SessionManager.INSTANCE.getExistingSession(sessionURI);
		if (session == null) {
			IStatus status = super.runInWorkspace(monitor);
			if (!status.isOK()) {
				return status;
			}
			session = SessionManager.INSTANCE.getExistingSession(sessionURI);
		}
		Session session2 = session;
		assert session2 != null;
		ResourceSet resourceSet = session.getSessionResource().getResourceSet();
		assert resourceSet != null;
		List<@NonNull EObject> modelObjects = getModelObjects(resourceSet);
		InitializeDiagramCreate.create(session2, registryRepresentationDescription, representationFileURI, representationDiagramName, modelObjects);
		return Status.OK_STATUS;
	}
}
