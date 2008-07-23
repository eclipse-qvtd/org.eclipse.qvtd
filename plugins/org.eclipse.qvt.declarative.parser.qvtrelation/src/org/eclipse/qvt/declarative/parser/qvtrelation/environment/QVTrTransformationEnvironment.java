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

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS;

public class QVTrTransformationEnvironment extends QVTrEnvironment<QVTrTopLevelEnvironment>
{
	private final RelationalTransformation transformation;
	private Map<RelationCS, QVTrRelationEnvironment> relEnvMap = new HashMap<RelationCS, QVTrRelationEnvironment>(); 
	private Map<QueryCS, QVTrQueryEnvironment> queryEnvMap = new HashMap<QueryCS, QVTrQueryEnvironment>(); 
	private Map<String, QVTrTypedModelEnvironment> modelIdToTypedModelEnvironment = new HashMap<String, QVTrTypedModelEnvironment>(); 
	private final Map<String,Set<EPackage>> metaModelIdToPackages = new HashMap<String,Set<EPackage>>();
	private final Set<EPackage> allMetaModelPackages = new HashSet<EPackage>();

	public QVTrTransformationEnvironment(QVTrTopLevelEnvironment env, TransformationCS transformationCS) {
		super(env, transformationCS);
		transformation = QVTRelationFactory.eINSTANCE.createRelationalTransformation();
		env.initASTMapping(transformation, transformationCS);
		String name = transformationCS.getIdentifier().getValue();
		transformation.setName(name);
		Variable variable = EcoreFactory.eINSTANCE.createVariable();
		initASTMapping(variable, transformationCS.getIdentifier());
		variable.setName("self"); //QvtrEnvironmentFactory.SELF_NAME);
		variable.setType(transformation);
		setSelfVariable(variable);
		IdentifierCS identifierCS = transformationCS.getExtends();
		if (identifierCS != null) {
			Transformation extendedTransformation = env.lookupImportedTransformation(identifierCS.getValue());
			transformation.setExtends(extendedTransformation);
		}
	}

	public void addMetaModelPackage(String metaModelId, EPackage ePackage) {
		Set<EPackage> contents = metaModelIdToPackages.get(metaModelId);
		if (contents == null) {
			contents = new HashSet<EPackage>();
			metaModelIdToPackages.put(metaModelId, contents);
		}
		contents.add(ePackage);
		allMetaModelPackages.add(ePackage);
	}

	public QVTrTypedModelEnvironment createEnvironment(ModelDeclCS modelDeclCS) {
		String modelId = modelDeclCS.getModelId().getValue();
		QVTrTypedModelEnvironment environment = modelIdToTypedModelEnvironment.get(modelId);
		if (environment != null) {
			analyzerError("modelId '" + modelId + "' already defined", "modelDeclCS", modelDeclCS);
			return null;
		}			
		environment = new QVTrTypedModelEnvironment(this, modelDeclCS);
		TypedModel typedModel = environment.getTypedModel();
		transformation.getModelParameter().add(typedModel);
		modelIdToTypedModelEnvironment.put(modelId, environment);
		return environment;
	}

	public QVTrQueryEnvironment createEnvironment(QueryCS queryCS) {
		QVTrQueryEnvironment environment = new QVTrQueryEnvironment(this, queryCS);
//		Function query = environment.getQuery();
//		transformation.getEOperations().add(query);
		queryEnvMap.put(queryCS, environment);
		return environment;
	}

	public QVTrRelationEnvironment createEnvironment(RelationCS relationCS) {
		QVTrRelationEnvironment environment = new QVTrRelationEnvironment(this, relationCS);
		Relation relation = environment.getRelation();
		transformation.getRule().add(relation);
		relEnvMap.put(relationCS, environment);
		return environment;
	}

	public QVTrQueryEnvironment getEnvironment(QueryCS queryCS) {
		return queryEnvMap.get(queryCS);
	}

	public QVTrRelationEnvironment getEnvironment(RelationCS relationCS) {
		return relEnvMap.get(relationCS);
	}
	
	public QVTrTypedModelEnvironment getEnvironment(TypedModel typedModel) {
		return modelIdToTypedModelEnvironment.get(typedModel.getName());
	}

	@Override public String getModelName(EObject object) {
		for (String key : metaModelIdToPackages.keySet()) {
			Set<EPackage> ePackages = metaModelIdToPackages.get(key);
			if (ePackages.contains(object))
				return key;
		}
		return null;
	}	

	@Override public List<Function> getQueries(String queryName, List<OCLExpression> args) {
		return findMatchingQueries(transformation, queryName, args);
	}
	
	@Override public RelationalTransformation getRelationalTransformation() { return transformation; }

	@Override public Variable lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> params) {
		Relation relation = transformation.getRelation(name);
		if (relation != null)
			return (Variable) getSelfVariable();
		Function query = transformation.getFunction(name);
		if (query != null)
			return (Variable) getSelfVariable();
		return super.lookupImplicitSourceForOperation(name, params);
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		if (names == null)
			return null;
		int namesSize = names.size();
		if (namesSize > 1) {
			String metaModelId = names.get(0);
			Set<EPackage> contextPackages = metaModelIdToPackages.get(metaModelId);
			if ((contextPackages != null) && !contextPackages.isEmpty()) {
				EClassifier eClassifier = tryLookupClassifier(contextPackages, names.subList(1, namesSize));
				if (eClassifier != null)
					return eClassifier;
			}
		}
		if (namesSize > 0) {
			if ((allMetaModelPackages != null) && !allMetaModelPackages.isEmpty()) {
				EClassifier eClassifier = tryLookupClassifier(allMetaModelPackages, names);
				if (eClassifier != null)
					return eClassifier;
			}
		}
		return super.tryLookupClassifier(names);
	}

	@Override public EOperation tryLookupOperation(EClassifier owner, String name, List<? extends TypedElement<EClassifier>> args) throws LookupException {
		if (owner == transformation) {
			Function query = transformation.getFunction(name);
			if (query != null)
				return query;
		}
        UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml = getUMLReflection();
		owner = uml.getOCLType(owner);				// Workaround bugzilla 172782
		return super.tryLookupOperation(owner, name, args);
	}
}
