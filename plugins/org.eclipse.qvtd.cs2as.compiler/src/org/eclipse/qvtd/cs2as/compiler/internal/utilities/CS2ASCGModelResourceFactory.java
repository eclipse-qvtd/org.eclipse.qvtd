/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.cs2as.compiler.internal.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.analyzer.CG2StringVisitor;
import org.eclipse.ocl.examples.codegen.utilities.AbstractCGModelResourceFactory;

/**
 * The <b>Resource Factory</b> associated with the package.
 */
public class CS2ASCGModelResourceFactory extends AbstractCGModelResourceFactory
{
	public static final @NonNull CS2ASCGModelResourceFactory INSTANCE = new CS2ASCGModelResourceFactory();

	@Override
	public @NonNull CG2StringVisitor createToStringVisitor() {
		return new CS2ASCG2StringVisitor();
	}
}
