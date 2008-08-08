/*******************************************************************************
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.utils;

import org.eclipse.ocl.cst.CSTNode;

/**
 * ICommonCSTVisitor defines an API for a visitor to a CSTNode-based CST.
 */
public interface ICommonCSTVisitor<T>
{
	public boolean preVisit(CSTNode cstNode);

	public T postVisit(CSTNode cstNode);

	public T visit(CSTNode cstNode);
}
