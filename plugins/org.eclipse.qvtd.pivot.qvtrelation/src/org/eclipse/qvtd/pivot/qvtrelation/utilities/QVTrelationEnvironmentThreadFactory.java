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
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.messages.StatusCodes.Severity;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.ocl.pivot.utilities.AbstractEnvironmentThread.AbstractEnvironmentThreadFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentFactory;

/**
 * QVTrelationEnvironmentThreadFactory transports the construction requirements from an invoking context to
 * the QVTrelationEnvironmentThread on which the QVTr processing is performed.
 */
public class QVTrelationEnvironmentThreadFactory extends AbstractEnvironmentThreadFactory<@NonNull QVTimperativeEnvironmentFactory>
{
	private @Nullable Severity severity = null;

	public QVTrelationEnvironmentThreadFactory(@NonNull ProjectManager projectManager) {
		super(projectManager);
	}

	@Override
	public @NonNull OCLInternal createEnvironment(@NonNull QVTimperativeEnvironmentFactory environmentFactory) {
		return QVTrelation.newInstance(environmentFactory);
	}

	@Override
	public @NonNull QVTimperativeEnvironmentFactory createEnvironmentFactory() {
		//	ClassLoader cl0 = getClass().getClassLoader();
		//	assert cl0 != null;
		QVTimperativeEnvironmentFactory environmentFactory = new QVTimperativeEnvironmentFactory(projectManager, null, QVTrelationEnvironmentStrategy.INSTANCE);
		//	PivotMetamodelManager metamodelManager = environmentFactory.getMetamodelManager();
		//	ImplementationManager implementationManager = metamodelManager.getImplementationManager();
		//	@NonNull List<@NonNull ClassLoader> classLoaders = implementationManager.getClassLoaders();
		//	if (!classLoaders.contains(cl0)) {
		//		implementationManager.addClassLoader(cl0);
		//	}
		if (severity != null) {
			environmentFactory.setSafeNavigationValidationSeverity(severity);
		}
		return environmentFactory;
	}

	public void setSeverity(@NonNull Severity severity) {
		this.severity = severity;
	}
}