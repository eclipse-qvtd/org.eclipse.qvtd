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
package org.eclipse.qvtd.pivot.qvtimperative.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtimperative.evaluation.QVTiEnvironmentFactory;

/**
 * The QVTimperative facade refines the QVTbase and OCL facades to enforce use of the QVTimperative Standard Library.
 */
public class QVTimperative extends QVTbase
{
	public static @NonNull QVTimperative newInstance(@NonNull ProjectManager projectManager) {
		return newInstance(projectManager, null);
	}

	public static @NonNull QVTimperative newInstance(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {
		QVTiEnvironmentFactory environmentFactory = new QVTiEnvironmentFactory(projectManager, externalResourceSet);
		QVTimperative qvt = new QVTimperative(environmentFactory);
		if (externalResourceSet != null) {
			environmentFactory.adapt(externalResourceSet);
		}
		return qvt;
	}

	public QVTimperative(@NonNull QVTimperativeEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @NonNull QVTimperativeEnvironmentFactory getEnvironmentFactory() {
		return (QVTimperativeEnvironmentFactory) super.getEnvironmentFactory();
	}
}