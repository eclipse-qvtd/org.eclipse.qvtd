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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.parser.environment.CSTChildEnvironment;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.QVTrFormattingHelper;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS;

public class QVTrTopLevelEnvironment extends QVTTopLevelEnvironment<IQVTrNodeEnvironment, TopLevelCS> implements IQVTrNodeEnvironment
{
	private Map<TransformationCS, QVTrTransformationEnvironment> txEnvMap = new HashMap<TransformationCS, QVTrTransformationEnvironment>(); 
	private final Map<String, RelationalTransformation> transformationMap = new HashMap<String, RelationalTransformation>();
	
	public QVTrTopLevelEnvironment(QVTrFileEnvironment parent, XMIResource astResource, TopLevelCS cstNode) {
		super(parent, astResource, cstNode);
	}

	public QVTrTransformationEnvironment createEnvironment(TransformationCS transformationCS) {
		QVTrTransformationEnvironment environment = new QVTrTransformationEnvironment(this, transformationCS);
		RelationalTransformation relationalTransformation = environment.getRelationalTransformation();
		ast.getContents().add(relationalTransformation);
		txEnvMap.put(transformationCS, environment);
		String name = relationalTransformation.getName();
		transformationMap.put(name, relationalTransformation);	// FIXME duplicates
		addPackage(relationalTransformation);	
		return environment;
	}

	@Override
	public QVTrFormattingHelper createFormattingHelper() {
		return new QVTrFormattingHelper(this);
	}

	public QVTrNestedEnvironment createNestedEnvironment(CSTNode cstNode) {
		return new QVTrNestedEnvironment(this, cstNode);
	}

	public Variable createVariableDeclaration(IdentifierCS identifierCS,
			EClassifier type) {
		throw new UnsupportedOperationException(getClass().getName() + ".createVariableDeclaration");
	}

	public QVTrTransformationEnvironment getEnvironment(TransformationCS transformationCS) {
		return CSTChildEnvironment.getEnvironmentFromAST((Notifier)transformationCS.getAst(), QVTrTransformationEnvironment.class);
	}

	@Override
	public String getModelName(EObject object) {
		for (QVTrTransformationEnvironment txEnv : txEnvMap.values()) {
			String modelName = txEnv.getModelName(object);
			if (modelName != null)
				return modelName;
		}
		return null;
	}

	public List<Function> getQueries(String queryName, List<OCLExpression> args) {
		throw new UnsupportedOperationException(getClass().getName() + ".getQueries");
	}

	public Relation getRelation(List<String> pathName, String name) {
		return null;
	}

	public RelationalTransformation getRelationalTransformation() {
		return null;
	}

	public RelationalTransformation getRelationalTransformation(List<String> pathName) {
		if (pathName == null)
			return null;
		if (pathName.size() != 1)
			return null;
		return transformationMap.get(pathName.get(0));		// FIXME use path
	}
}
