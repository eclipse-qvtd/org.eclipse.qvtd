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

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTEnvironment;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTFormattingHelper;

public abstract class QVTcEnvironment<E extends IQVTcEnvironment, P extends E> extends QVTEnvironment<E,P> implements IQVTcEnvironment
{
	protected QVTcEnvironment(EPackage.Registry reg) {
		super(reg);
	}

	protected QVTcEnvironment(EPackage.Registry reg, Resource resource) {
		super(reg, resource);
	}
	
	protected QVTcEnvironment(P parent, CSTNode cstNode) {
		super(parent, cstNode);
	}

	@Override
	protected QVTFormattingHelper createFormatter() {
		return new QVTcFormattingHelper(this);
	}

	public Mapping tryLookupMapping(String name) throws LookupException {
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupMapping(name);
		else
			return null;
	}
}
