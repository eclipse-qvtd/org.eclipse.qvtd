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
package org.eclipse.qvt.declarative.parser.qvtrelation.environment;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvt.environment.IQVTNodeEnvironment;

public interface IQVTrNodeEnvironment extends IQVTNodeEnvironment, IQVTrEnvironment
{
	public Variable createVariableDeclaration(IdentifierCS identifierCS, EClassifier type);
	public List<Function> getQueries(String queryName, List<OCLExpression> args);
	public Relation getRelation(List<String> pathName, String name);
	public RelationalTransformation getRelationalTransformation();
	public RelationalTransformation getRelationalTransformation(List<String> pathName);
}
