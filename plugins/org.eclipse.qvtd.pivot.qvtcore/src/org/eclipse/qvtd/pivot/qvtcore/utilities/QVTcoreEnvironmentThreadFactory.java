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
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeEnvironmentThreadFactory;

/**
 * QVTcoreEnvironmentThreadFactory transports the construction requirements from an invoking context to
 * the QVTcoreEnvironmentThread on which the QVTc processing is performed.
 */
public class QVTcoreEnvironmentThreadFactory extends QVTimperativeEnvironmentThreadFactory
{
	public QVTcoreEnvironmentThreadFactory(@NonNull ProjectManager projectManager) {
		super(projectManager);
	}

	//	@Override
	//	public @NonNull QVTcore createEnvironment(@NonNull QVTimperativeEnvironmentFactory environmentFactory) {
	//		return new QVTcore(environmentFactory);
	//	}
}