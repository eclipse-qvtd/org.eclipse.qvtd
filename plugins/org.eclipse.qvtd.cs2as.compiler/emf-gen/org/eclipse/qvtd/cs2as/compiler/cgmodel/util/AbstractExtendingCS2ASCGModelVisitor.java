/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.cs2as.compiler/model/cs2ascgmodel.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.cs2as.compiler.cgmodel.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingCS2ASCGModelVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingCS2ASCGModelVisitor<R, C>
	extends org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractExtendingCGModelVisitor<R, C>
	implements CS2ASCGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractExtendingCS2ASCGModelVisitor(C context) {
		super(context);
	}	

	@Override
	public R visitCGLookupCallExp(org.eclipse.qvtd.cs2as.compiler.cgmodel.@NonNull CGLookupCallExp object) {
		return visitCGOperationCallExp(object);
	}
}
