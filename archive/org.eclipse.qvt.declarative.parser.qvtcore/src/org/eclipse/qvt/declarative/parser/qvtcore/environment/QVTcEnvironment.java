/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtcore.environment;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTEnvironment;

public abstract class QVTcEnvironment<E extends IQVTcNodeEnvironment, P extends E, AST extends EModelElement, CST extends CSTNode> extends QVTEnvironment<E,P, AST, CST> implements IQVTcNodeEnvironment
{
	protected QVTcEnvironment(P parent, AST astNode, CST cstNode) {
		super(parent, astNode, cstNode);
	}

	public QVTcNestedEnvironment createNestedEnvironment(CSTNode cstNode) {
		return new QVTcNestedEnvironment(this, cstNode);
	}

	@Override
	public QVTcUnresolvedEnvironment getUnresolvedEnvironment() {
		return (QVTcUnresolvedEnvironment) super.getUnresolvedEnvironment();
	}

	public Mapping tryLookupMapping(String name) throws LookupException {
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupMapping(name);
		else
			return null;
	}
}
