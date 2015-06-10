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
package org.eclipse.qvtd.pivot.qvtbase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.utilities.OCLInternal;

/**
 * The QVTbase facade refines the OCL facade to enforce use of the QVTbase Standard Library.
 */
public abstract class QVTbase extends OCLInternal
{	
/*	public static @NonNull QVTbase newInstance(@NonNull ProjectManager projectManager, @Nullable ResourceSet externalResourceSet) {	
		QVTbaseEnvironmentFactory environmentFactory = new QVTbaseEnvironmentFactory(projectManager, externalResourceSet);
		QVTbase qvt = new QVTbase(environmentFactory);
		if (externalResourceSet != null) {
			environmentFactory.adapt(externalResourceSet);
		}
		return qvt;
	} */
	
	public QVTbase(@NonNull QVTbaseEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}
	
	@Override
	public @NonNull QVTbaseEnvironmentFactory getEnvironmentFactory() {
		return (QVTbaseEnvironmentFactory)super.getEnvironmentFactory();
	}
}