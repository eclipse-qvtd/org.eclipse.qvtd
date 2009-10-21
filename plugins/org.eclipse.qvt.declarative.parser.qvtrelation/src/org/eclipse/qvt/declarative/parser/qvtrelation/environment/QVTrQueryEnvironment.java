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
package org.eclipse.qvt.declarative.parser.qvtrelation.environment;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.parser.AbstractQVTAnalyzer;
import org.eclipse.qvt.declarative.parser.plugin.QVTParserPlugin;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS;

public class QVTrQueryEnvironment extends QVTrEnvironment<QVTrTransformationEnvironment, Function, QueryCS>
{
	private Function query = null;
	private final String name;
	private final List<FunctionParameter> parameters = new ArrayList<FunctionParameter>();
	
	public QVTrQueryEnvironment(QVTrTransformationEnvironment env, QueryCS queryCS) {
		super(env, null, queryCS);
		List<String> names = AbstractQVTAnalyzer.createSequenceOfNames(queryCS.getPathName(), null);	// FIXME scoping
		if (names.size() != 1)
			analyzerError("Unqualified name expected for query", "pathNameCS", queryCS.getPathName());
//		else
//			query.setName(names.get(0));
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
		return query;
	}

	public Function resolveQuery(EClassifier returnType) {
		RelationalTransformation transformation = getRelationalTransformation();	// FIXME scoping
		Function match = findMatchingQuery(transformation, name, parameters);
		if (match == null) {
			query = QVTBaseFactory.eINSTANCE.createFunction();
			initASTMapping(query, cst);
			cst.getPathName().setAst(query);
			query.setName(name);
			query.setEType(returnType);
			query.getEParameters().addAll(parameters);
			transformation.getEOperations().add(query);
			return query;
		}
		CSTNode cstNode = getCSTNode();
		if (match.getEType() != returnType) {
			String message = "Inconsistent return type previously '" + formatType(match.getEType()) + "'";
			analyzerError(message, "queryCS", cstNode);
		}
		query = match;
		initASTMapping(query, cst);
		cst.getPathName().setAst(query);
		if (((QueryCS)cstNode).getOclExpression() != null) {
			if (query.getQueryExpression() != null) {
				String message = "Redefinition of '" + formatName(query) + "' ignored";
				analyzerError(message, "queryCS", cstNode);
			}
			else {
				query.getEParameters().clear();
				query.getEParameters().addAll(parameters);
			}
		}
		return null;
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		return getParentEnvironment().tryLookupClassifier(names);
	}
}
