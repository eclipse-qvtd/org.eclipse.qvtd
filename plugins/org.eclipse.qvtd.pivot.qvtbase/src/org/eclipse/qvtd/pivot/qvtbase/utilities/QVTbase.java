/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;
import org.eclipse.ocl.pivot.resource.ProjectManager;

/**
 * The QVTbase facade refines the OCL facade to enforce use of the QVTbase Standard Library.
 */
public /*abstract*/ class QVTbase extends OCLInternal
{
	public static @NonNull QVTbase newInstance(@NonNull ProjectManager projectManager) {
		return newInstance(projectManager, null);
	}

	public static @NonNull QVTbase newInstance(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {
		QVTbaseEnvironmentFactory environmentFactory = new QVTbaseEnvironmentFactory(projectManager, externalResourceSet, null);
		QVTbase qvt = new QVTbase(environmentFactory);
		return qvt;
	}

	public QVTbase(@NonNull QVTbaseEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @NonNull QVTbaseEnvironmentFactory getEnvironmentFactory() {
		return (QVTbaseEnvironmentFactory)super.getEnvironmentFactory();
	}
}