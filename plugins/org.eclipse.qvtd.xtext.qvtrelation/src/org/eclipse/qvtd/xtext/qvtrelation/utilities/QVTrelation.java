/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelation.utilities;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.resource.ProjectManager;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbase;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;

/**
 * The QVTimperative facade refines the QVTbase and OCL facades to enforce use of the QVTimperative Standard Library.
 */
public class QVTrelation extends QVTbase
{
	public static @NonNull QVTrelation newInstance(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {	
		QVTbaseEnvironmentFactory environmentFactory = new QVTbaseEnvironmentFactory(projectManager, externalResourceSet);
		QVTrelation qvt = new QVTrelation(environmentFactory);
		if (externalResourceSet != null) {
			environmentFactory.adapt(externalResourceSet);
		}
		return qvt;
	}
	
	public QVTrelation(@NonNull QVTbaseEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

//	@Override
//	public @NonNull QVTiEnvironmentFactory getEnvironmentFactory() {
//		return (QVTiEnvironmentFactory) super.getEnvironmentFactory();
//	}
}