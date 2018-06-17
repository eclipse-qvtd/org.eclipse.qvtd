/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
	public QVTbase(@NonNull QVTbaseEnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	@Override
	public @NonNull QVTbaseEnvironmentFactory getEnvironmentFactory() {
		return (QVTbaseEnvironmentFactory)super.getEnvironmentFactory();
	}
}