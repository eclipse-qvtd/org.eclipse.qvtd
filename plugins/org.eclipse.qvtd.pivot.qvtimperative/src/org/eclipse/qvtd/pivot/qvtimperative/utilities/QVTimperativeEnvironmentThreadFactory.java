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
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes.Severity;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread.AbstractEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

/**
 * QVTimperativeEnvironmentThreadFactory transports the construction requirements from an invoking context to
 * the QVTimperativeEnvironmentThread on which the QVTi processing is performed.
 */
public class QVTimperativeEnvironmentThreadFactory extends AbstractEnvironmentThreadFactory<@NonNull QVTiEnvironmentFactory>
{
	private @Nullable Severity severity = null;

	public QVTimperativeEnvironmentThreadFactory(@NonNull ProjectManager projectManager) {
		super(projectManager);
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

	public void setSeverity(@NonNull Severity severity) {
		this.severity = severity;
	}
}