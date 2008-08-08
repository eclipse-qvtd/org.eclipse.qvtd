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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.cst.CSTNode;

/**
 * CommonCSTVisitor defines a default visitor for a CSTNode-based CST
 * using cstNode.eContents() to perform tree descent.
 */
public abstract class CommonCSTVisitor<T> implements ICommonCSTVisitor<T>
{
	public static <T, V extends CommonCSTVisitor<T>> T acceptAt(V v, CSTNode cstNode) {
		return cstNode != null ? v.visit(cstNode) : null;
	}

	protected T result = null;

	public boolean preVisit(CSTNode cstNode) {
		return true;
	}

	public T postVisit(CSTNode cstNode) {
		return result;
	}

	public T visit(CSTNode cstNode) {
		if (!preVisit(cstNode))
			return null;
		for (EObject eObject : cstNode.eContents()) {
			if (eObject instanceof CSTNode)
				acceptAt(this, ((CSTNode) eObject));
		}
		return postVisit(cstNode);		
	}
}