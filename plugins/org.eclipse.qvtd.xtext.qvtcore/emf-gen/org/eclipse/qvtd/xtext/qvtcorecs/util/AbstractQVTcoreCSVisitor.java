/*******************************************************************************
 * Copyright (c) 2013, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.xtext.qvtcore/model/QVTcoreCS.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.xtext.qvtcorecs.util;


/*
 * An AbstractQVTcoreCSVisitor provides a default implementation of the visitor framework
 * but n implementations of the visitXXX methods..
 */
public abstract class AbstractQVTcoreCSVisitor<R, C>
	extends org.eclipse.qvtd.xtext.qvtbasecs.util.AbstractQVTbaseCSVisitor<R, C>
	implements QVTcoreCSVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractQVTcoreCSVisitor(C context) {
		super(context);
	}
}
