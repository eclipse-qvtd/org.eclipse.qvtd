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

import org.eclipse.emf.common.notify.Notifier;

/**
 * ICommonASTVisitor defines an API for a visitor to a Notifier-based
 * (EObject or Resource or ResourceSet) AST.
 */
public interface ICommonASTVisitor<T>
{
	public boolean preVisit(Notifier astNode);

	public T postVisit(Notifier astNode);

	public T visit(Notifier astNode);
}
