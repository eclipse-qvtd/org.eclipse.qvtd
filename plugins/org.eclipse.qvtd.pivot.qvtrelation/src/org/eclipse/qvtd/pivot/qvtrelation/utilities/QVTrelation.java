/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;

/**
 * The QVTcore facade refines the QVTbase and OCL facades to enforce use of the QVTbase Standard Library.
 */
public class QVTrelation extends QVTbase
{
	public static @NonNull QVTrelation newInstance(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {	
		QVTrEnvironmentFactory environmentFactory = new QVTrEnvironmentFactory(projectManager, externalResourceSet);
		QVTrelation qvt = new QVTrelation(environmentFactory);
		if (externalResourceSet != null) {
			environmentFactory.adapt(externalResourceSet);
		}
		return qvt;
	}
	
	public QVTrelation(@NonNull QVTrEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @NonNull QVTrEnvironmentFactory getEnvironmentFactory() {
		return (QVTrEnvironmentFactory) super.getEnvironmentFactory();
	}
}