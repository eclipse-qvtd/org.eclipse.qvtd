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

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS;

public class QVTrDomainEnvironment extends QVTrEnvironment<QVTrRelationEnvironment>
{
	private final RelationDomain domain;
//	private final String metaModelId;
	private final TypedModel typedModel;
	
	public QVTrDomainEnvironment(QVTrRelationEnvironment env, DomainCS domainCS) {
		super(env, domainCS);
		domain = QVTRelationFactory.eINSTANCE.createRelationDomain();
		env.initASTMapping(domain, domainCS);
		IdentifierCS modelIdCS = domainCS.getModelId();
		String modelId = modelIdCS.getValue();
		domain.setName(modelId);
		QVTrTransformationEnvironment txEnv = env.getParentEnvironment();
//		metaModelId = txEnv.getMetaModelId(modelId);
		RelationalTransformation transformation = txEnv.getRelationalTransformation();
		TypedModel typedModel = transformation.getModelParameter(modelId);
		if (typedModel == null) {
			String message = "Domain identifier '" + modelId + "' must refer to a model parameter";
			analyzerError(message, "DomainCS", modelIdCS);
		}
		domain.setTypedModel(typedModel);		
		this.typedModel = typedModel;
	}
	
	public QVTrDomainEnvironment(QVTrRelationEnvironment env, PrimitiveTypeDomainCS domainCS) {
		super(env, domainCS);
		domain = QVTRelationFactory.eINSTANCE.createRelationDomain();
		typedModel = null;
		env.initASTMapping(domain, domainCS);
	}

	public void createVariableDeclaration(VariableExpCS variableExpCS, EClassifier type) {
		getParentEnvironment().createVariableDeclaration(variableExpCS, type, domain, false);
	}

	public RelationDomain getDomain() {
		return domain;
	}

	@Override public String getModelName(EObject object) {
		QVTrTypedModelEnvironment env = getParentEnvironment().getParentEnvironment().getEnvironment(typedModel);
		if (env != null)
			return env.getModelName(object);
		else
			return super.getModelName(object);
	}	

	public EClass lookupImportedClass(String name) {
		if (typedModel != null) {
			for (EPackage ePackage : typedModel.getUsedPackage()) {
				EClassifier eClassifier = ePackage.getEClassifier(name);
				if (eClassifier instanceof EClass)
					return (EClass) eClassifier;
			}
		}
		return null;
	}

	public EClassifier lookupImportedClassifier(String name) {
		if (typedModel != null) {
			for (EPackage ePackage : typedModel.getUsedPackage()) {
				EClassifier eClassifier = ePackage.getEClassifier(name);
				if (eClassifier != null)
					return eClassifier;
			}
		}
		return null;
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		if (typedModel != null) {
			EClassifier eClassifier = tryLookupClassifier(typedModel.getUsedPackage(), names);
			if (eClassifier != null)
				return eClassifier;
		}
		return super.tryLookupClassifier(names);
	}
}
