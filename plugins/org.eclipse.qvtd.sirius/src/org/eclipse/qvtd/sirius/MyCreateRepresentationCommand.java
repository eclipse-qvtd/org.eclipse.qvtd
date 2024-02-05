package org.eclipse.qvtd.sirius;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.logger.RuntimeLoggerManager;
import org.eclipse.sirius.business.api.query.DRepresentationQuery;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreter;
import org.eclipse.sirius.common.tools.api.util.StringUtil;
import org.eclipse.sirius.tools.api.Messages;
import org.eclipse.sirius.viewpoint.DAnalysis;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.tool.RepresentationCreationDescription;
import org.eclipse.sirius.viewpoint.description.tool.ToolPackage;

/**
 * Create representation command.
 *
 * @author mchauvin
 * @since 0.9.0
 */
public class MyCreateRepresentationCommand extends RecordingCommand {

	private RepresentationDescription description;

	private Session masterSession;
	private DAnalysis dAnalysis;

	private EObject semantic;

	private String name;

	private DRepresentation representation;

//	private boolean isInitialOperation;

	private RepresentationCreationDescription creationDescription;

	private IProgressMonitor monitor;

	/**
	 * Construct a new instance with {@link IProgressMonitor}.
	 *
	 * @param session
	 *			the session
	 * @param description
	 *			the representation description
	 * @param eObject
	 *			the semantic element on which to create the representation
	 * @param name
	 *			the representation name
	 * @param monitor
	 *			a {@link IProgressMonitor} to report progression of representation creation
	 */
	public MyCreateRepresentationCommand(Session masterSession, @NonNull DAnalysis dAnalysis, RepresentationDescription description, EObject eObject, String name, IProgressMonitor monitor) {
		super(masterSession.getTransactionalEditingDomain(), Messages.CreateRepresentationCommand_label);
		this.masterSession = masterSession;
		this.dAnalysis = dAnalysis;
		this.description = description;
		this.semantic = eObject;
		this.name = name;
		this.monitor = monitor;

/*		RepresentationElementMapping mapping = dde.getMapping();
		if (mapping != null) {
			EObject sessionFinder = null;
			final EList<EObject> semanticElements = dde.getSemanticElements();
			if (semanticElements != null && !semanticElements.isEmpty()) {
				sessionFinder = semanticElements.get(0);
			} else if (dde.getTarget() != null) {
				sessionFinder = dde.getTarget();
			}
			final Session session = sessionFinder != null ? SessionManager.INSTANCE.getSession(sessionFinder) : null;
			if (session != null) {
				for (RepresentationCreationDescription desc : mapping.getDetailDescriptions()) {
		*/

	 //   this.creationDescription = description.getRepresentationDescription();
	}

	/**
	 * Set if there is an initial operation or not.
	 *
	 * @param creationDesc
	 *			the creation tool
	 *
	public void setInitialOperation(final RepresentationCreationDescription creationDesc) {
		this.creationDescription = creationDesc;
		isInitialOperation = creationDesc.getInitialOperation() != null && creationDesc.getInitialOperation().getFirstModelOperations() != null;
	} */

	public @Nullable DRepresentation basicGetCreatedRepresentation() {
		return representation;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.common.command.AbstractCommand#canExecute()
	 */
	@Override
	public boolean canExecute() {
		/*
		 * if there is an initial operation an semantic element could be added and used after on precondition
		 *
		if (isInitialOperation) {
			return super.canExecute();
		} */
		final EObject root = computeRepresentationRoot(masterSession.getInterpreter(), creationDescription, semantic);
		return DialectManager.INSTANCE.canCreate(root, description);
	}

	private void clearData() {
		this.representation = null;
		this.masterSession = null;
		this.dAnalysis = null;
		this.description = null;
		this.semantic = null;
		this.name = null;
		this.creationDescription = null;
		this.label = null;
		this.monitor = null;
	}

	private static EObject computeRepresentationRoot(final IInterpreter interpreter, final RepresentationCreationDescription desc, final EObject initialRoot) {
		EObject newRepresentationRoot = initialRoot;
		if (desc != null && !StringUtil.isEmpty(desc.getBrowseExpression())) {
			try {
				newRepresentationRoot = interpreter.evaluateEObject(newRepresentationRoot, desc.getBrowseExpression());
			} catch (final EvaluationException e) {
				RuntimeLoggerManager.INSTANCE.warning(newRepresentationRoot, ToolPackage.eINSTANCE.getRepresentationCreationDescription_BrowseExpression(), e);
			}
			if (newRepresentationRoot == null) {
				RuntimeLoggerManager.INSTANCE.warning(initialRoot, ToolPackage.eINSTANCE.getRepresentationCreationDescription_BrowseExpression(),
						MessageFormat.format(Messages.CreateRepresentationCommand_nullExpresionWarningMsg, desc.getBrowseExpression()));
			}
		}
		return newRepresentationRoot;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void doExecute() {
		final EObject root = computeRepresentationRoot(masterSession.getInterpreter(), creationDescription, semantic);
		representation = DialectManager.INSTANCE.createRepresentation(this.name, root, this.description, this.masterSession, monitor);
		if (representation != null) {
			new DRepresentationQuery(representation).getRepresentationDescriptor().setName(name);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.common.command.AbstractCommand#getResult()
	 */
	@Override
	public Collection<?> getResult() {
		final Set<DRepresentation> result = new HashSet<>();
		result.add(representation);
		/* do not leak */
		clearData();
		return result;
	}

	/**
	 * Get the created representation.
	 *
	 * @return the created representation
	 */
	public DRepresentation getCreatedRepresentation() {
		return (DRepresentation) getResult().iterator().next();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.transaction.RecordingCommand#dispose()
	 */
	@Override
	public void dispose() {
		super.dispose();
		clearData();
	}

	@Override
	protected void postExecute() {
		assert representation != null;
		dAnalysis.eResource().getContents().add(representation);
	}

}
