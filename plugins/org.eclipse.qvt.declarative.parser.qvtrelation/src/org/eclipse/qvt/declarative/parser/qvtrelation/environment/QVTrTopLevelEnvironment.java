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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.modelregistry.environment.AbstractFileHandle;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvt.environment.QVTTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.QVTrAnalyzer;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS;

public class QVTrTopLevelEnvironment extends QVTTopLevelEnvironment<IQVTrEnvironment> implements IQVTrEnvironment
{
	private Map<TransformationCS, QVTrTransformationEnvironment> txEnvMap = new HashMap<TransformationCS, QVTrTransformationEnvironment>(); 
	private final Map<String, RelationalTransformation> transformationMap = new HashMap<String, RelationalTransformation>();
	
//	public QVTrTopLevelEnvironment(EPackage.Registry reg, CSTNode cstNode) {
//		super(reg, cstNode);
//	}
	
	public QVTrTopLevelEnvironment(AbstractFileHandle file, ResourceSet resourceSet) {
		super(file, resourceSet);
	}

	@Override protected QVTrAnalyzer createAnalyzer() {
		return new QVTrAnalyzer(this);
	}

	public QVTrTransformationEnvironment createEnvironment(TransformationCS transformationCS) {
		QVTrTransformationEnvironment environment = new QVTrTransformationEnvironment(this, transformationCS);
		RelationalTransformation relationalTransformation = environment.getRelationalTransformation();
		txEnvMap.put(transformationCS, environment);
		String name = relationalTransformation.getName();
		transformationMap.put(name, relationalTransformation);	// FIXME duplicates
		addPackage(relationalTransformation);	
		return environment;
	}
	
	@Override
	public QVTrFormattingHelper createFormatter() {
		return new QVTrFormattingHelper(this);
	}

	public Variable createVariableDeclaration(IdentifierCS identifierCS,
			EClassifier type) {
		throw new UnsupportedOperationException(getClass().getName() + ".createVariableDeclaration");
	}

	@Override
	protected String getContentTypeIdentifier() {
		return QVTRelationPackage.eCONTENT_TYPE;
	}

	public QVTrTransformationEnvironment getEnvironment(TransformationCS transformationCS) {
		return txEnvMap.get(transformationCS);
	}

	@Override
	public String getModelName(EObject object) {
		for (QVTrTransformationEnvironment txEnv : txEnvMap.values()) {
			String modelName = txEnv.getModelName(object);
			if (modelName != null)
				return modelName;
		}
		return super.getModelName(object);
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
