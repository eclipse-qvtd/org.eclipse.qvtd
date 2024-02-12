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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.sirius.business.api.dialect.command.MoveRepresentationCommand;
import org.eclipse.sirius.business.api.helper.SiriusResourceHelper;
import org.eclipse.sirius.business.api.resource.ResourceDescriptor;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.danalysis.DAnalysisSession;
import org.eclipse.sirius.business.internal.session.SessionTransientAttachment;
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
import org.eclipse.sirius.viewpoint.DRepresentationDescriptor;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.ViewpointFactory;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.sirius.viewpoint.provider.Messages;
import org.eclipse.sirius.viewpoint.provider.SiriusEditPlugin;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * InitializeDiagramJob provides a non-interactive sequencing of the three interactive activities.
 * OpenRepresentationsFileJob to establish a Session, ChangeViewpointSelectionCommand to establish a DView,
 * and CreateRepresentationCommand to create a DDiagram. The job ends by opening an editor.
 */
public class InitializeDiagramJob extends OpenRepresentationsFileJob
{
	protected static class DAnalysisPreparationCommand extends RecordingCommand	// from org.eclipse.sirius.tools.internal.command.PrepareNewAnalysisCommand
	{
		protected final @NonNull DAnalysisSession session;
		protected final @NonNull DAnalysis slaveAnalysis;
		protected final @NonNull Resource resource;

	    public DAnalysisPreparationCommand(@NonNull DAnalysisSession session, @NonNull Resource resource) {
	        super(session.getTransactionalEditingDomain(), org.eclipse.sirius.tools.api.Messages.PrepareNewAnalysisCommand_label);
	        DAnalysis dAnalysis = ViewpointFactory.eINSTANCE.createDAnalysis();
	        assert dAnalysis != null;
			this.slaveAnalysis = dAnalysis;
	        this.resource = resource;
	        this.session = session;
	    }

	    @Override
	    protected void doExecute() {
	        resource.getContents().add(slaveAnalysis);
	        session.addReferencedAnalysis(slaveAnalysis);
            for (final Resource semResource : session.getSemanticResources()) {
                if (!semResource.getContents().isEmpty()) {
                    slaveAnalysis.getSemanticResources().add(new ResourceDescriptor(semResource.getURI()));
                }
            }
	    }

	    @Override
	    public boolean canUndo() {
	        return false;
	    }
	}

	protected static class DAnalysisPreparationOperation extends WorkspaceModifyOperation		// from org.eclipse.sirius.ui.tools.internal.wizards.ExtractRepresentationsWizard
	{
		private static @NonNull DAnalysis createDAnalysis(@NonNull DAnalysisSession session, @NonNull Resource resource) {
			TransactionalEditingDomain domain = session.getTransactionalEditingDomain();
			DAnalysisPreparationCommand command = new DAnalysisPreparationCommand(session, resource);
			domain.getCommandStack().execute(command);
			return command.slaveAnalysis;
		}

		private static @Nullable Resource createResource(@NonNull IProgressMonitor monitor, @NonNull ResourceSet resourceSet, @NonNull URI representationFileURI) {
			DAnalysisPreparationOperation op = new DAnalysisPreparationOperation(resourceSet, representationFileURI);
			PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable()
			{
				@Override
				public void run() {																	// run on main
					try {
						new ProgressMonitorDialog(null).run(false, true, op);
					} catch (final InterruptedException e) {
				//		return true;
					} catch (final InvocationTargetException e) {
						if (e.getTargetException() instanceof CoreException) {
							InitializeDiagramUtils.openError(Messages.ExtractRepresentationsWizard_resourceCreationError, null, e.getTargetException());
						} else {
						//	SiriusTransPlugin.getPlugin().error(Messages.ExtractRepresentationsWizard_airdCreationError, e.getTargetException());
							InitializeDiagramUtils.openError(Messages.ExtractRepresentationsWizard_airdCreationError, null, e.getTargetException());
						}
				//		return true;
					}
				}
			});
			return op.resource;
		}

		public static @Nullable DAnalysis prepare(@NonNull IProgressMonitor monitor, @NonNull DAnalysisSession session, @NonNull URI representationFileURI) {
			TransactionalEditingDomain transactionalEditingDomain = session.getTransactionalEditingDomain();
			ResourceSet resourceSet = transactionalEditingDomain.getResourceSet();
			assert resourceSet != null;
			Resource resource;
		    DAnalysis dAnalysis = null;
		    boolean needsSave = false;
			if (!resourceSet.getURIConverter().exists(representationFileURI, null)) {
				resource = createResource(monitor, resourceSet, representationFileURI);
				needsSave = true;
			}
			else {
				resource = resourceSet.getResource(representationFileURI, true);
				for (EObject eObject : resource.getContents()) {
					if (eObject instanceof DAnalysis) {
						dAnalysis = (DAnalysis)eObject;
						break;
					}
				}
			}
			assert resource != null;
			if (dAnalysis == null) {
			    dAnalysis = createDAnalysis(session, resource);					// ?? later
				needsSave = true;
			}
			assert resource.getContents().contains(dAnalysis);
		/*	if (needsSave) {
				try {
					resource.save(null);			// XXX if needsSAve
				} catch (IOException e) {
					String message = "Failed to save " + representationFileURI;
					InitializeDiagramUtils.openError(message, null, e);
					return null;
				}
			} */
			final DAnalysis finalDAnalysis = dAnalysis;
		/*	((DAnalysisSessionServicesImpl)session.getServices()).setAnalysisSelector(new DAnalysisSelector() {

				@Override
				public DAnalysis selectSmartlyAnalysisForAddedResource(Resource resource, Collection<DAnalysis> allAnalysis) {
					return finalDAnalysis;//allAnalysis.iterator().next();
				}

				@Override
				public DAnalysis selectSmartlyAnalysisForAddedRepresentation(DRepresentation representation, Collection<DAnalysis> allAnalysis) {
					return finalDAnalysis;//allAnalysis.iterator().next();
				}
			}); */
			return finalDAnalysis;
		}

		protected final @NonNull ResourceSet resourceSet;
		protected final @NonNull URI representationFileURI;
		private @Nullable Resource resource = null;

		protected DAnalysisPreparationOperation(@NonNull ResourceSet resourceSet, @NonNull URI representationFileURI) {
			super(null);
			this.resourceSet = resourceSet;
			this.representationFileURI = representationFileURI;
		}

		@Override
		protected void execute(final IProgressMonitor monitor) throws CoreException, InterruptedException
		{
			resource = resourceSet.createResource(representationFileURI);
		}
	}

	protected static class DiagramCreateOperation extends WorkspaceModifyOperation // ?? implements Runnable
	{
		protected static void create(@NonNull DAnalysisSession session, @NonNull RepresentationDescription registryRepresentationDescription, @NonNull URI representationFileURI, @NonNull String representationDiagramName, @NonNull List<@NonNull EObject> modelObjects) {
			PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable()
			{
				@Override
				public void run() {																	// run on main
					try {
						WorkspaceModifyOperation op = new DiagramCreateOperation(session, registryRepresentationDescription, representationFileURI, representationDiagramName, modelObjects);
						new ProgressMonitorDialog(null).run(true, true, op);
					} catch (InvocationTargetException | InterruptedException e) {
						SiriusEditPlugin.getPlugin().getLog().log(new Status(IStatus.ERROR, SiriusEditPlugin.ID, e.getLocalizedMessage(), e));
					}
				}
			});
		}

		protected final @NonNull DAnalysisSession session;
		protected final @NonNull RepresentationDescription registryRepresentationDescription;
		protected final @NonNull URI representationFileURI;
		protected final @NonNull List<@NonNull EObject> modelObjects;
		protected final @NonNull String representationDiagramName;

		protected DiagramCreateOperation(@NonNull DAnalysisSession session, @NonNull RepresentationDescription registryRepresentationDescription, @NonNull URI representationFileURI, @NonNull String representationDiagramName, @NonNull List<@NonNull EObject> modelObjects) {													// ctor on main
			this.session = session;
			this.registryRepresentationDescription = registryRepresentationDescription;
			this.representationFileURI = representationFileURI;
			this.representationDiagramName = representationDiagramName;
			this.modelObjects = modelObjects;
			assert modelObjects.size() >= 1;
		}

		protected @Nullable DRepresentation createRepresentation(@NonNull IProgressMonitor monitor, @NonNull RepresentationDescription editingDomainRepresentationDescription) {
			TransactionalEditingDomain transactionalEditingDomain = session.getTransactionalEditingDomain();
			EObject modelObject = modelObjects.get(0);
			CommandStack commandStack = transactionalEditingDomain.getCommandStack();
			assert commandStack != null;
			ResourceSet resourceSet = transactionalEditingDomain.getResourceSet();
			assert resourceSet != null;
			IEditingSession editingSession = SessionUIManager.INSTANCE.getUISession(session);
			MyCreateRepresentationCommand createRepresentationCommand = new MyCreateRepresentationCommand(session, editingDomainRepresentationDescription, modelObject, representationDiagramName,
					new SubProgressMonitor(monitor, 4));
		//	DAnalysis dAnalysis = getDAnalysis(resourceSet);

			Session semanticSession = new EObjectQuery(modelObject).getSession();
			if (semanticSession == null) {				// If not (yet) known to representations.aird
				modelObject.eResource().eAdapters().add(new SessionTransientAttachment(session));
				semanticSession = new EObjectQuery(modelObject).getSession();
				assert semanticSession != null;
			}

			editingSession.notify(EditingSessionEvent.REPRESENTATION_ABOUT_TO_BE_CREATED_BEFORE_OPENING);
			if (!createRepresentationCommand.canExecute()) {
				InitializeDiagramUtils.openError("Failed to create diagram representation", "Unable to create \"" +  registryRepresentationDescription.getLabel() + "\"\nFIXME need to break out canExecute failures", null);
				return null;
			}
			commandStack.execute(createRepresentationCommand);
			editingSession.notify(EditingSessionEvent.REPRESENTATION_CREATED_BEFORE_OPENING);
			return createRepresentationCommand.basicGetCreatedRepresentation();
		}

		protected void editDiagram(@NonNull DRepresentation createdDRepresentation) throws InvocationTargetException, InterruptedException {
			IRunnableWithProgress runnable = new DiagramEditRunnable(session, createdDRepresentation);
			IRunnableContext context = new ProgressMonitorDialog(null);
			PlatformUI.getWorkbench().getProgressService().runInUI(context, runnable, null);
		}

		@Override
		protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {		// execute on main
			String mainMessage = "Failed to create diagram";
			try {
				monitor.beginTask(org.eclipse.sirius.viewpoint.provider.Messages.CreateRepresentationAction_creationTask, 15);

				EObject modelObject = modelObjects.get(0);
				if (!session.getSemanticResources().contains(modelObject.eResource())) {
					session.close(monitor);
					session.getSemanticResources();
				}

				Viewpoint registryViewpoint = selectViewpoint(monitor);

				// XXX wrap above in a ProgressMonitorDialog cf ViewpointHelper.applyNewViewpointSelection

				Viewpoint editingDomainViewpoint = SiriusResourceHelper.getCorrespondingViewpoint(session, registryViewpoint);	// XXX error dialog
				if (editingDomainViewpoint == null) {
					InitializeDiagramUtils.openError(mainMessage, "Failed to localize \"" +  registryViewpoint.getLabel() + "\" Viewpoint", null);
					return;
				}
				String representationDescriptionName = registryRepresentationDescription.getName();
				RepresentationDescription editingDomainRepresentationDescription = getRepresentationDescription(editingDomainViewpoint, representationDescriptionName);
				if (editingDomainRepresentationDescription == null) {
					InitializeDiagramUtils.openError(mainMessage, "Failed to localize \"" +  registryRepresentationDescription.getLabel() + "\" RepresentationDesacription", null);
					return;
				}
			//	new ViewpointSelector(session).selectViewpoint(registryViewpoint, createNewRepresentations, monitor);

				DRepresentation createdDRepresentation = createRepresentation(monitor, editingDomainRepresentationDescription);
				if (representationFileURI != session.getSessionResource().getURI()) {
					List<DRepresentationDescriptor> repDescriptors = new ArrayList<>();;
					DAnalysis dAnalysis = session.getSharedMainDAnalysis().get();
					for (DView dView : dAnalysis.getOwnedViews()) {
						for (DRepresentationDescriptor dRepresentationDescriptor : dView.getOwnedRepresentationDescriptors()) {
							if (dRepresentationDescriptor.getRepresentation() == createdDRepresentation) {
								repDescriptors.add(dRepresentationDescriptor);
							}
						}
					}
					DAnalysis slaveAnalysis = DAnalysisPreparationOperation.prepare(monitor, session, representationFileURI);
					if (slaveAnalysis == null) {
						return;
					}
					moveRepresentations(slaveAnalysis, repDescriptors);
				}

				monitor.worked(1);
				if (createdDRepresentation != null) {
					editDiagram(createdDRepresentation);
				}
			} catch (Exception e) {
				InitializeDiagramUtils.openError(mainMessage, e.getLocalizedMessage(), e);
			} finally {
				monitor.done();
			}
		}

		private RepresentationDescription getRepresentationDescription(Viewpoint viewpoint, final String representationName) {
			for (RepresentationDescription representationDescription : viewpoint.getOwnedRepresentations()) {
				if (representationName.equals(representationDescription.getName())) {
					return representationDescription;
				}
			}
			return null;
		}

		protected void moveRepresentations(final DAnalysis slaveAnalysis, List<DRepresentationDescriptor> repDescriptors) {		// from org.eclipse.sirius.ui.tools.internal.wizards.ExtractRepresentationsWizard
		//	final IRunnableWithProgress moveReps = new IRunnableWithProgress() {
		//		@Override
		//		public void run(final IProgressMonitor mon) {
		//			session.getTransactionalEditingDomain().getCommandStack().execute(new MoveRepresentationCommand(session, slaveAnalysis, repDescriptors));
		//		}
		//	};
		//	try {
		//		new ProgressMonitorDialog(null).run(false, true, moveReps);
				session.getTransactionalEditingDomain().getCommandStack().execute(new MoveRepresentationCommand(session, slaveAnalysis, repDescriptors));
		//	} catch (final InterruptedException e) {
		//		SiriusPlugin.getDefault().warning(Messages.ExtractRepresentationsWizard_moveInterrupted, e);
		//	} catch (final InvocationTargetException e) {
		//		SiriusPlugin.getDefault().error(Messages.ExtractRepresentationsWizard_moveFailed, e);
		//	}
		}

		protected @NonNull Viewpoint selectViewpoint(@NonNull IProgressMonitor monitor) {
			TransactionalEditingDomain transactionalEditingDomain = session.getTransactionalEditingDomain();
			CommandStack commandStack = transactionalEditingDomain.getCommandStack();
			assert commandStack != null;
			Viewpoint registryViewpoint = (Viewpoint)registryRepresentationDescription.eContainer();
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

	protected static class DiagramEditRunnable implements IRunnableWithProgress
	{
		protected final Session session;
		protected final DRepresentation createdDRepresentation;

		public DiagramEditRunnable(Session session, DRepresentation createdDRepresentation) {
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
	protected final @NonNull URI representationFileURI;
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
		DAnalysisSession session2 = (DAnalysisSession)session;
		assert session2 != null;
		ResourceSet resourceSet = session2.getTransactionalEditingDomain().getResourceSet();
		assert resourceSet != null;
		List<@NonNull EObject> modelObjects = getModelObjects(resourceSet);
		DiagramCreateOperation.create(session2, registryRepresentationDescription, representationFileURI, representationDiagramName, modelObjects);
		return Status.OK_STATUS;
	}
}
