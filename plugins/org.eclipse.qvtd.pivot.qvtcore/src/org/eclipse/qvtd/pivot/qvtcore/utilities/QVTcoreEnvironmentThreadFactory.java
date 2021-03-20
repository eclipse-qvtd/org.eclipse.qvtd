/*******************************************************************************
 * Copyright (c) 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes.Severity;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread.AbstractEnvironmentThreadFactory;

/**
 * QVTcoreEnvironmentThreadFactory transports the construction requirements from an invoking context to
 * the QVTcoreEnvironmentThread on which the QVTc processing is performed.
 */
public class QVTcoreEnvironmentThreadFactory extends AbstractEnvironmentThreadFactory<@NonNull QVTcEnvironmentFactory>
{
	private @Nullable Severity severity = null;

	public QVTcoreEnvironmentThreadFactory(@NonNull ProjectManager projectManager) {
		super(projectManager);
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

	public void setSeverity(@NonNull Severity severity) {
		this.severity = severity;
	}
}