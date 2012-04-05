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
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.ecore.EcoreFactory;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTCore.Mapping;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.parser.AbstractQVTAnalyzer;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.DirectionCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.MappingCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.TransformationCS;
import org.eclipse.qvt.declarative.parser.utils.StringUtils;

public class QVTcTransformationEnvironment extends QVTcEnvironment<IQVTcNodeEnvironment, QVTcTopLevelEnvironment, Transformation, TransformationCS>
{
	private Map<MappingCS, QVTcRootMappingEnvironment> mappingCSEnvironments = new HashMap<MappingCS, QVTcRootMappingEnvironment>(); 
	private Map<String, QVTcRootMappingEnvironment> mappingEnvironments = new HashMap<String, QVTcRootMappingEnvironment>(); 
	private Map<QueryCS, QVTcQueryEnvironment> queryCSEnvironments = new HashMap<QueryCS, QVTcQueryEnvironment>(); 
	private final Map<String,List<EPackage>> metaModelContents = new HashMap<String,List<EPackage>>();
	private List<EPackage> allContents = null;

	public QVTcTransformationEnvironment(QVTcTopLevelEnvironment env, TransformationCS transformationCS) {
		super(env, QVTBaseFactory.eINSTANCE.createTransformation(), transformationCS);
		PathNameCS transformationPathName = transformationCS.getPathName();
		List<String> names = AbstractQVTAnalyzer.createSequenceOfNames(transformationPathName, null);
		String name = names.get(names.size()-1);
		ast.setName(name);
		transformationPathName.setAst(ast);
		Variable variable = EcoreFactory.eINSTANCE.createVariable();	
		rootEnvironment.getASTNodeToCSTNodeMap().put(variable, transformationCS);
//		env.initASTMapping(variable, transformationCS.getPathName());
//		env.initASTMapping(ast, transformationCS.getPathName());
		variable.setName(SELF_VARIABLE_NAME);
		variable.setType(ast);
		setSelfVariable(variable);
//		IdentifierCS identifierCS = transformationCS.getExtends();
//		if (identifierCS != null) {
//			Transformation extendedTransformation = env.lookUpImportedTransformation(identifierCS.getValue());
//			transformation.setExtends(extendedTransformation);
//		}
	}

	public void addMetaModelPackage(String metaModelId, EPackage ePackage) {
		List<EPackage> contents = metaModelContents.get(metaModelId);
		if (contents == null) {
			contents = new ArrayList<EPackage>();
			metaModelContents.put(metaModelId, contents);
		}
		if (!contents.contains(ePackage))
			contents.add(ePackage);
		if (allContents == null)
			allContents = new ArrayList<EPackage>();
		if (!allContents.contains(ePackage))
			allContents.add(ePackage);
	}

	public QVTcRootMappingEnvironment createEnvironment(MappingCS mappingCS) {
		QVTcRootMappingEnvironment environment = new QVTcRootMappingEnvironment(this, mappingCS);
		Mapping mapping = environment.getMapping();
		ast.getRule().add(mapping);
		mappingCSEnvironments.put(mappingCS, environment);
		QVTcRootMappingEnvironment oldEnvironment = mappingEnvironments.put(mappingCS.getName(), environment);
		if (oldEnvironment != null)
			analyzerError("Duplicate mapping", "MappingCS", mappingCS);
		return environment;
	}

	public QVTcQueryEnvironment createEnvironment(QueryCS queryCS) {
		QVTcQueryEnvironment environment = new QVTcQueryEnvironment(this, queryCS);
		queryCSEnvironments.put(queryCS, environment);
		return environment;
	}

	public TypedModel createTypedModel(DirectionCS directionCS) {
		IdentifierCS identifierCS = directionCS.getIdentifier();
		String identifier = identifierCS.getValue();
		Transformation transformation = getTransformation();
		TypedModel typedModel = EcoreUtils.getNamedElement(transformation.getModelParameter(), identifier);
		if (typedModel != null)
			analyzerError("direction already defined", "directionCS", directionCS);
		else {
			typedModel = QVTBaseFactory.eINSTANCE.createTypedModel();
			initASTMapping(typedModel, directionCS);
			setNameFromIdentifier(typedModel, identifierCS);
			transformation.getModelParameter().add(typedModel);
		}
		return typedModel;
	}

	public QVTcRootMappingEnvironment getEnvironment(String name) {
		return mappingEnvironments.get(name);
	}

	public QVTcRootMappingEnvironment getEnvironment(MappingCS mappingCS) {
		return mappingCSEnvironments.get(mappingCS);
	}

	public QVTcQueryEnvironment getEnvironment(QueryCS queryCS) {
		return queryCSEnvironments.get(queryCS);
	}

	public Collection<MappingCS> getMappings() {
		return mappingCSEnvironments.keySet();
	}

	@Override public String getModelName(EObject object) {
		for (String key : metaModelContents.keySet()) {
			List<EPackage> ePackages = metaModelContents.get(key);
			if (ePackages.contains(object))
				return key;
		}
		return null;
	}	

	public Collection<QueryCS> getQueries() {
		return queryCSEnvironments.keySet();
	}

	@Override public Transformation getTransformation() { return ast; }

	public TypedModel getTypedModel(IdentifierCS identifierCS) {
		String identifier = identifierCS.getValue();
		Transformation transformation = getTransformation();
		return EcoreUtils.getNamedElement(transformation.getModelParameter(), identifier);
	}

/*	@Override public Variable lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> params) {
		Mapping mapping = null; //FIXME transformation.getMapping(name);
		if (mapping != null)
			return getSelfVariable();
		Function query = transformation.getFunction(name);
		if (query != null)
			return getSelfVariable();
		return super.lookupImplicitSourceForOperation(name, params);
	} */

/*	@Override public EOperation lookupOperation(EClassifier owner, String name, List<? extends TypedElement<EClassifier>> args) {
		if (owner == transformation) {
			Function query = transformation.getFunction(name);
			if (query != null)
				return query;
		}
        UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml = getUMLReflection();
		owner = uml.getOCLType(owner);				// Workaround bugzilla 172782
		return super.lookupOperation(owner, name, args);
	} */

	@Override
	public Variable lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> params) {
//		Mapping mapping = ast.getMapping(name);
//		if (relation != null)
//			return (Variable) getSelfVariable();
		Function query = ast.getFunction(name);
		if (query != null)
			return (Variable) getSelfVariable();
		return super.lookupImplicitSourceForOperation(name, params);
	}
	
	public List<EPackage> resolvePackages(PathNameCS packageNameCS) {
		List<String> names = AbstractQVTAnalyzer.createSequenceOfNames(packageNameCS, null);
		String packageName = StringUtils.splice(names, "::");
		List<EPackage> ePackages = metaModelContents.get(packageName);
		if (ePackages == null) {
			ePackages = new ArrayList<EPackage>();
			metaModelContents.put(packageName, ePackages);
			URI uri = getFileEnvironment().getResolver().getURI(packageName);		// FIXME Fix-up error with reference to stub
			if (uri == null) {
				String message = "Unknown package '" + formatString(packageName) + "'";
				analyzerError(message, "ImportCS", packageNameCS);
			}
			else {
				try {
					Resource resource = getFileEnvironment().getResolver().getResource(uri, true);
					if (resource == null) {
						String message = "Failed to load package '" + formatString(packageName) + "'";
						analyzerError(message, "ImportCS", packageNameCS);
					}
					else {
						List<EObject> contents = resource.getContents();
						if (contents != null) {
							for (EObject eObject : contents) {
								if (eObject instanceof EPackage)
									ePackages.add((EPackage) eObject);
//FIXME WIP restore this								else if (eObject instanceof org.eclipse.qvt.declarative.emof.EMOF.Package){
//									String message = "EMOF adapter not installed for '" + formatName(eObject) + "'";
//									analyzerError(message, "ImportCS", packageNameCS);
//								}
								else {
									String message = "Non-EPackage '" + formatName(eObject) + "' ignored";
									analyzerError(message, "ImportCS", packageNameCS);
								}
							}
						}
					}
					ePackages = metaModelContents.get(packageName);
				} catch (Exception e) {
					String message = "Failed to load package '" + formatString(packageName) + "' : " + e.getMessage();
					analyzerError(message, "ImportCS", packageNameCS);
				}
			}
		}
		return ePackages;
	}

	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		if (names == null)
			return null;
		int namesSize = names.size();
		if (namesSize > 1) {
			String metaModelName = names.get(0);
			List<EPackage> contextPackages = metaModelContents.get(metaModelName);
			if ((contextPackages != null) && !contextPackages.isEmpty()) {
				EClassifier eClassifier = tryLookupClassifier(contextPackages, names.subList(1, namesSize));
				if (eClassifier != null)
					return eClassifier;
			}
		}
		if (namesSize > 0) {
			if ((allContents != null) && !allContents.isEmpty()) {
				EClassifier eClassifier = tryLookupClassifier(allContents, names);
				if (eClassifier != null)
					return eClassifier;
			}
		}
		return super.tryLookupClassifier(names);
	}

	@Override
	public Mapping tryLookupMapping(String name) throws LookupException {
		Rule firstFind = null;
		List<Rule> allFinds = null;
		for (Rule rule : ast.getRule()) {
			if (name.equals(rule.getName())) {
				if (allFinds != null)
					allFinds.add(rule);					
				else if (firstFind != null) {
					allFinds = new ArrayList<Rule>();
					allFinds.add(firstFind);
					allFinds.add(rule);
					firstFind = null;
				}
				else
					firstFind = rule;
			}				
		}
		if (allFinds != null)
			throw new LookupException("Ambiguous Mapping", allFinds);
		if (firstFind == null)
			return null;
		if (firstFind instanceof Mapping)
			return (Mapping) firstFind;
		throw new LookupException("Non-Mapping", Collections.singletonList(firstFind));
	}
}
