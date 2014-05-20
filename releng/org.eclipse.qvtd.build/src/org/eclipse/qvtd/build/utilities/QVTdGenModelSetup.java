/*******************************************************************************
 * Copyright (c) 2010, 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.build.utilities;

import org.eclipse.ocl.examples.build.utilities.OCLGenModelSetup;
import org.eclipse.qvtd.build.modelspecs.QVTdCGTypedElementModelSpec;
import org.eclipse.qvtd.build.modelspecs.QVTdCGValuedElementModelSpec;

/**
 * Initializes QVTd genmodel support by first registering OCL support then adding the additional MOdelSpecs for QVTd.
 */
public class QVTdGenModelSetup extends OCLGenModelSetup
{
	public QVTdGenModelSetup() {
	    QVTdCGTypedElementModelSpec.register();
	    QVTdCGValuedElementModelSpec.register();
	}
}
