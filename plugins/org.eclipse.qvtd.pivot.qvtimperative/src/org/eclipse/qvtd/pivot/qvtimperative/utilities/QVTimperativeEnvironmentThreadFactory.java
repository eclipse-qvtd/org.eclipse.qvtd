package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes.Severity;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.OCLThread.AbstractEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

/**
 * QVTimperativeEnvironmentThreadFactory transports the construction requirements from an invoking context to
 * the QVTimperativeEnvironmentThread on which the QVTi processing is performed.
 */
public class QVTimperativeEnvironmentThreadFactory extends AbstractEnvironmentThreadFactory<@NonNull QVTiEnvironmentFactory>
{
	private final @Nullable Severity severity;

	public QVTimperativeEnvironmentThreadFactory(@NonNull ProjectManager projectManager, @Nullable Severity severity) {
		super(projectManager);
		this.severity = severity;
	}

	@Override
	public @NonNull OCLInternal createEnvironment(@NonNull QVTiEnvironmentFactory environmentFactory) {
		return QVTimperative.newInstance(environmentFactory);
	}

	@Override
	public @NonNull QVTiEnvironmentFactory createEnvironmentFactory() {
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(projectManager, null);
		if (severity != null) {
			environmentFactory.setSafeNavigationValidationSeverity(severity);
		}
		return environmentFactory;
	}
}