/*******************************************************************************
 * Copyright (c) 2007,2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.environment;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTEnvironment;

public abstract class QVTrEnvironment<P extends IQVTrEnvironment> extends QVTEnvironment<IQVTrEnvironment, P> implements IQVTrEnvironment
{
	protected QVTrEnvironment(EPackage.Registry reg) {
		super(reg);
	}

	protected QVTrEnvironment(EPackage.Registry reg, Resource resource) {
		super(reg, resource);
	}
	
	protected QVTrEnvironment(P parent, CSTNode cstNode) {
		super(parent, cstNode);
	}	
	
	@Override
	public QVTrFormattingHelper createFormatter() {
		return new QVTrFormattingHelper(this);
	}

	public Variable createVariableDeclaration(IdentifierCS identifierCS, EClassifier type) {
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.createVariableDeclaration(identifierCS, type);
		else
			return null;
	}

	public List<Function> getQueries(String queryName, List<OCLExpression> args) {
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.getQueries(queryName, args);
		else
			return null;
	}

	public Relation getRelation(List<String> pathName, String name) {
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.getRelation(pathName, name);
		else
			return null;
	}
	
	public RelationalTransformation getRelationalTransformation() {
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.getRelationalTransformation();
		else
			return null;
	}
	
	public RelationalTransformation getRelationalTransformation(List<String> pathName) {
		P parent = getParentEnvironment();
		if (parent != null)
			return parent.getRelationalTransformation(pathName);
		else
			return null;
	}
}
