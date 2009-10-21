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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.parser.AbstractQVTAnalyzer;
import org.eclipse.qvt.declarative.parser.environment.CSTChildEnvironment;
import org.eclipse.qvt.declarative.parser.plugin.QVTParserPlugin;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.utils.CSTUtils;

public class QVTcQueryEnvironment extends QVTcEnvironment<IQVTcNodeEnvironment, QVTcTransformationEnvironment, Function, QueryCS>
{
	private final String name;
	private final List<FunctionParameter> parameters = new ArrayList<FunctionParameter>();
	
	public QVTcQueryEnvironment(QVTcTransformationEnvironment env, QueryCS queryCS) {
		super(env, null, queryCS);
		List<String> names = AbstractQVTAnalyzer.createSequenceOfNames(queryCS.getPathName(), null);
		name = names.get(names.size()-1);
	}

	public void addParameter(FunctionParameter parameter) {
		parameters.add(parameter);
		addElement(parameter.getName(), parameter, true);
	}

	@Override protected void addedVariable(String name, Variable<EClassifier, EParameter> variable, boolean isExplicit) {
		if (variable == null)
			return;
		if (!(variable instanceof FunctionParameter))
			QVTParserPlugin.logError("non-derived FunctionParameter in " + getClass().getName() + ".addedVariable", null);
	}

	public Function getQuery() {
		return ast;
	}

	public Function resolveQuery(EClassifier returnType) {
		Transformation transformation = getTransformation();	// FIXME scoping
		Function match = findMatchingQuery(transformation, name, parameters);
		if (match == null) {
			internalSetAST(QVTBaseFactory.eINSTANCE.createFunction());
			internalSetAdapter();
			rootEnvironment.initASTMapping(ast, cst);
			cst.getPathName().setAst(ast);
			ast.setName(name);
			ast.setEType(returnType);
			ast.getEParameters().addAll(parameters);
			transformation.getEOperations().add(ast);
			return ast;
		}
		if (match.getEType() != returnType) {
			String message = "Inconsistent return type previously '" + formatType(match.getEType()) + "'";
			analyzerError(message, "QueryCS", cst);
		}
		ast = match;
		cst.setAst(ast);
		cst.getPathName().setAst(ast);
		OCLExpressionCS thisExpression = cst.getOclExpression();
		if (thisExpression != null) {
			QueryCS otherQuery = CSTChildEnvironment.getEnvironmentFromAST(ast, QVTcQueryEnvironment.class).getCSTNode();
			OCLExpressionCS otherExpression = otherQuery.getOclExpression();
			if (otherExpression != null) {
				String message = "Redefinition of '" + formatName(ast) + "' ignored";
				analyzerError(message, "QueryCS", cst);
				CSTUtils.setASTErrorNode(thisExpression, message);
			}
			else {
				ast.getEParameters().clear();
				ast.getEParameters().addAll(parameters);
			}
		}
		return null;
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		return getParentEnvironment().tryLookupClassifier(names);
	}
}
