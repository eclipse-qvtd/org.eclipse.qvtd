/*******************************************************************************
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;
import org.eclipse.ocl.examples.codegen.utilities.AbstractCGModelResourceFactory;
import org.eclipse.ocl.examples.codegen.utilities.CGModelResourceFactory;
import org.eclipse.qvtd.codegen.qvticgmodel.utilities.QVTiCGModelCG2StringVisitor;

/**
 * The <b>Resource Factory</b> associated with the package.
 */
public class QVTiCGModelResourceFactory extends AbstractCGModelResourceFactory
{
	public static final @NonNull CGModelResourceFactory INSTANCE = new QVTiCGModelResourceFactory();

	@Override
	public @NonNull CG2StringVisitor createToStringVisitor() {
		return new QVTiCGModelCG2StringVisitor();
	}
}
