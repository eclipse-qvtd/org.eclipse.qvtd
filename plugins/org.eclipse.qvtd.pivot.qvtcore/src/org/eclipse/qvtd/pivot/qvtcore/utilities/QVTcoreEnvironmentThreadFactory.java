package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes.Severity;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.OCLThread.AbstractEnvironmentThreadFactory;

/**
 * QVTcoreEnvironmentThreadFactory transports the construction requirements from an invoking context to
 * the QVTcoreEnvironmentThread on which the QVTc processing is performed.
 */
public class QVTcoreEnvironmentThreadFactory extends AbstractEnvironmentThreadFactory<@NonNull QVTcEnvironmentFactory>
{
	private final @Nullable Severity severity;

	public QVTcoreEnvironmentThreadFactory(@NonNull ProjectManager projectManager, @Nullable Severity severity) {
		super(projectManager);
		this.severity = severity;
	}

	@Override
	public @NonNull OCLInternal createEnvironment(@NonNull QVTcEnvironmentFactory environmentFactory) {
		return QVTcore.newInstance(environmentFactory);
	}

	@Override
	public @NonNull QVTcEnvironmentFactory createEnvironmentFactory() {
		QVTcEnvironmentFactory environmentFactory = new QVTcEnvironmentFactory(projectManager, null);
		if (severity != null) {
			environmentFactory.setSafeNavigationValidationSeverity(severity);
		}
		return environmentFactory;
	}
}