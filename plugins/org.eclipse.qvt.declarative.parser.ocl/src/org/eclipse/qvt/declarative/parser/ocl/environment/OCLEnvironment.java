/**
 * <copyright>
 * 
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: OCLEnvironment.java,v 1.1 2008/08/14 07:52:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.ocl.environment;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.qvt.declarative.parser.environment.CSTEnvironment;

public class OCLEnvironment extends CSTEnvironment<OCLEnvironment, OCLEnvironment>
{
	protected OCLEnvironment(EPackage.Registry reg) {
		super(reg);
	}

	protected OCLEnvironment(EPackage.Registry reg, Resource resource) {
		super(reg, resource);
	}
	
	protected OCLEnvironment(OCLEnvironment parent, CSTNode cstNode) {
		super(parent, cstNode);
		setFactory(parent.getFactory());
		setASTNodeToCSTNodeMap(parent.getASTNodeToCSTNodeMap());
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		EPackage contextPackage = getContextPackage();
		if (contextPackage != null) {
			EClassifier eClassifier = super.tryLookupClassifier(names);
			if (eClassifier != null)
				return eClassifier;
		}
		OCLEnvironment parent = getParentEnvironment();
		if (parent != null)
			return parent.tryLookupClassifier(names);
		return null;
	}

	@Override public EPackage tryLookupPackage(List<String> path) throws LookupException {
		OCLEnvironment parent = getParentEnvironment();
		if (parent == null)
			return super.tryLookupPackage(path);
		else
			return parent.tryLookupPackage(path);
	}
}
