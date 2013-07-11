/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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
 * from: org.eclipse.qvtd.xtext.qvtimperative/model/QVTimperativeCST.genmodel
 *
 * Do not edit it.
 */
package	org.eclipse.qvtd.xtext.qvtimperativecst.util;

import org.eclipse.jdt.annotation.NonNull;

/*
 * An AbstractQVTimperativeCSVisitor provides a default implementation of the visitor framework
 * but n implementations of the visitXXX methods..
 */
public abstract class AbstractQVTimperativeCSVisitor<R, C>
	extends org.eclipse.qvtd.xtext.qvtcorebasecst.util.AbstractQVTcoreBaseCSVisitor<R, C>
	implements QVTimperativeCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 * 
	 * @param context my initial result value
	 */
	protected AbstractQVTimperativeCSVisitor(@NonNull C context) {
		super(context);
	}
}
