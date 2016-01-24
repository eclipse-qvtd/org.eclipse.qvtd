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


/*
 * An AbstractCS2ASCGModelVisitor provides a default implementation of the visitor framework
 * but n implementations of the visitXXX methods..
 */
public abstract class AbstractCS2ASCGModelVisitor<R, C>
	extends org.eclipse.ocl.examples.codegen.cgmodel.util.AbstractCGModelVisitor<R, C>
	implements CS2ASCGModelVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractCS2ASCGModelVisitor(C context) {
		super(context);
	}
}
