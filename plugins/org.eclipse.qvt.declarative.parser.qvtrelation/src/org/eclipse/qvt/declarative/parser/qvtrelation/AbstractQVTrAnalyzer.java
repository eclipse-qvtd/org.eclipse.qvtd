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
package org.eclipse.qvt.declarative.parser.qvtrelation;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import lpg.runtime.Monitor;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionLiteralExp;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.ocl.examples.modelregistry.environment.AbstractModelResolver;
import org.eclipse.ocl.examples.modelregistry.environment.FileHandle;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplateFactory;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;
import org.eclipse.qvt.declarative.ecore.utils.ClassUtils;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.parser.AbstractQVTAnalyzer;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.AbstractDomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DefaultValueCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.DomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.KeyDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ModelDeclCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ParamDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PrimitiveTypeDomainCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QueryCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.RelationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateVariableCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TopLevelCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TransformationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.UnitCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.VarDeclarationCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhenCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.WhereCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.IQVTrNodeEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrDomainEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrNestedEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrQueryEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrRelationEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrTransformationEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrTypedModelEnvironment;
import org.eclipse.qvt.declarative.parser.ui.preferences.QVTPreferences;

public abstract class AbstractQVTrAnalyzer extends AbstractQVTAnalyzer<IQVTrNodeEnvironment>
{
	static org.eclipse.emf.ecore.EcoreFactory emfEcoreFactory = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE;
	static org.eclipse.ocl.ecore.EcoreFactory oclEcoreFactory = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE;
	
	public AbstractQVTrAnalyzer(QVTrParser parser, Monitor monitor) {
		super(parser, monitor);
	}
	
	@Override
	protected IQVTrNodeEnvironment createdNestedEnvironment(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		return new QVTrNestedEnvironment((IQVTrNodeEnvironment)env, cstNode);
	}
	
	protected void declareCollectionTemplateCS(QVTrDomainEnvironment env, EClassifier type, CollectionTemplateCS collectionTemplateCS) {
		IdentifierCS tailIdentifier = collectionTemplateCS.getRestIdentifier();
		if (tailIdentifier != null)
			env.createVariableDeclaration(tailIdentifier, type);
		for (IdentifiedCS headIdentifier :  collectionTemplateCS.getMemberIdentifier()) {
			if (headIdentifier instanceof TemplateCS)
				declareTemplateCS(env, (TemplateCS)headIdentifier, null);
		}
	}

	protected void declareDomainCS(QVTrRelationEnvironment env, DomainCS domainCS) {
		QVTrDomainEnvironment domainEnv = env.createEnvironment(domainCS);
		RelationDomain domain = domainEnv.getDomain();
		domain.setIsCheckable(domainCS.isCheckonly());
		domain.setIsEnforceable(domainCS.isEnforce());
		TemplateVariableCS templateVariable = domainCS.getTemplate();
		EClassifier rootVariableType = resolveClassifier(domainEnv, "domainCS", templateVariable.getType());
		Variable variable = env.createVariableDeclaration(templateVariable.getIdentifier(), rootVariableType);
		domain.setRootVariable(variable);
	}
	
	protected void declareInputParamDeclarationCS(QVTrQueryEnvironment env, ParamDeclarationCS inputParamDeclarationCS) {
		FunctionParameter functionParameter = QVTBaseFactory.eINSTANCE.createFunctionParameter();
		env.initASTMapping(functionParameter, inputParamDeclarationCS);
		env.setNameFromIdentifier(functionParameter, inputParamDeclarationCS.getIdentifier(), functionParameter);
		functionParameter.setEType(resolveClassifier(env, "inputParamDeclarationCS", inputParamDeclarationCS.getType()));
		env.addParameter(functionParameter);
	}

	protected void declareMetaModelIdCS(QVTrTypedModelEnvironment env, IdentifierCS metaModelIdCS) {
		TypedModel typedModel = env.getTypedModel();
		String metaModelId = identifierCS(metaModelIdCS);
		AbstractModelResolver resolver = env.getResolver();
		URI uri = resolver.getURI(metaModelId);		// FIXME Fix-up error with reference to stub
		if (uri == null)
			ERROR(metaModelIdCS, "metaModelIdCS", "Unknown meta-model '" + formatString(metaModelId) + "'");
		else {
			try {
				ResourceSet resourceSet = resolver.getResourceSet();
				if (uri.hasFragment()) {
					EObject eObject = resourceSet.getEObject(uri, true);
					if (eObject instanceof EPackage) {
						typedModel.getUsedPackage().add((EPackage) eObject);
						env.addMetaModelPackage(metaModelId, (EPackage) eObject);
						metaModelIdCS.setAst(eObject);
					}
					else if (eObject != null)
						ERROR(metaModelIdCS, "metaModelIdCS", "Non-EPackage found at '" + formatString(uri.toString()) + "'");
					else
						ERROR(metaModelIdCS, "metaModelIdCS", "No EPackage found at '" + formatString(uri.toString()) + "'");
				}
				else {			// FIXME Bug 251873 Remove this once Model Registry consistently hands out fragment URIs
					Resource resource = resourceSet.getResource(uri, true);
					if (resource == null)
						ERROR(metaModelIdCS, "metaModelIdCS", "Failed to load meta-model '" + formatString(metaModelId) + "'");
					else {
						EList<EObject> contents = resource.getContents();
						if (contents != null) {
							for (EObject eObject : contents) {
								if (eObject instanceof EPackage) {
									typedModel.getUsedPackage().add((EPackage) eObject);
									env.addMetaModelPackage(metaModelId, (EPackage) eObject);
									if (metaModelIdCS.getAst() == null)			// FIXME Redundant test once Bug 251873 fixed
										metaModelIdCS.setAst(eObject);
								}
								else
									ERROR(metaModelIdCS, "metaModelIdCS", "Non-EPackage '" + formatName(eObject) + "' ignored");
							}
						}
					}
				}
				
			} catch (Exception e) {
				ERROR(metaModelIdCS, "metaModelIdCS", "Failed to load meta-model '" + formatString(metaModelId) + "' : " + e.getMessage());
			}
		}
	}

	protected void declareModelDeclCS(QVTrTransformationEnvironment env, ModelDeclCS modelDeclCS) {
		QVTrTypedModelEnvironment typedModelEnv = env.createEnvironment(modelDeclCS);
		if (typedModelEnv == null)
			return;
		for (IdentifierCS metaModelIdCS : modelDeclCS.getMetaModelId())
			if (!isCancelled())
				declareMetaModelIdCS(typedModelEnv, metaModelIdCS);
	}

	protected void declareOCLExpressionCS(QVTrDomainEnvironment env, EClassifier propertyType,
			OCLExpressionCS oclExpressionCS) {
		if (oclExpressionCS instanceof TemplateCS)
			declareTemplateCS(env, (TemplateCS) oclExpressionCS, null);
		else if (oclExpressionCS instanceof VariableExpCS) {
			env.createVariableDeclaration((VariableExpCS)oclExpressionCS, propertyType);
		}
		else if (oclExpressionCS instanceof CollectionLiteralExpCS) {
			for (CollectionLiteralPartCS collectionLiteralPartCS : ((CollectionLiteralExpCS)oclExpressionCS).getCollectionLiteralParts())
				declareOCLExpressionCS(env, propertyType, collectionLiteralPartCS.getExpressionCS());
		}
//		else	expressions are self sufficient
//			System.out.println("Unsupported createVariableForPropertyTemplateCS for " + oclExpressionCS.getClass().getName());
	}

	protected void declarePredicateCS(QVTrRelationEnvironment env, OCLExpressionCS oclExpressionCS) {
		if (oclExpressionCS == null)
			return;
		Relation relation = isRelationCallExpCS(env, oclExpressionCS);
		if (relation != null)
			declareRelationCallExpCS(env, relation, (OperationCallExpCS)oclExpressionCS);
		else if (oclExpressionCS instanceof OperationCallExpCS) {
			declarePredicateCS(env, ((OperationCallExpCS)oclExpressionCS).getSource());
			List<OCLExpressionCS> arguments = ((OperationCallExpCS)oclExpressionCS).getArguments();
			if (arguments != null)
				for (OCLExpressionCS argument : arguments)
					declarePredicateCS(env, argument);			
		}
	}

	protected void declarePrimitiveTypeDomainCS(QVTrRelationEnvironment env, PrimitiveTypeDomainCS primitiveTypeDomainCS) {
		QVTrDomainEnvironment domainEnv = env.createEnvironment(primitiveTypeDomainCS);
		RelationDomain domain = domainEnv.getDomain();
		domain.setIsCheckable(false);
		domain.setIsEnforceable(false);
		EDataType rootVariableType = resolveDataType(env, "domainCS", primitiveTypeDomainCS.getType());
		Variable variable = env.createVariableDeclaration(primitiveTypeDomainCS.getIdentifier(), rootVariableType);
		domain.setRootVariable(variable);
	}

	protected void declarePropertyTemplateCS(QVTrDomainEnvironment env, EClass parentType, PropertyTemplateCS propertyTemplateCS) {
		EClassifier propertyType = resolveProperty(env, parentType, propertyTemplateCS);
		OCLExpressionCS oclExpressionCS = propertyTemplateCS.getOclExpression();
		declareOCLExpressionCS(env, propertyType, oclExpressionCS);
	}

	protected void declareQueryCS(QVTrTransformationEnvironment env, QueryCS queryCS) {
		QVTrQueryEnvironment queryEnv = env.createEnvironment(queryCS);
		EClassifier returnType = resolveClassifier(env, "queryCS", queryCS.getType());
		for (ParamDeclarationCS inputParamDeclarationCS : queryCS.getInputParamDeclaration())
			declareInputParamDeclarationCS(queryEnv, inputParamDeclarationCS);
		@SuppressWarnings("unused") Function function = queryEnv.resolveQuery(returnType);
	}

	protected void declareRelationCS(QVTrTransformationEnvironment env, RelationCS relationCS) {
		QVTrRelationEnvironment relationEnv = env.createEnvironment(relationCS);
		boolean explicitCheckonly = false;
		boolean explicitEnforce = false;
		for (AbstractDomainCS abstractDomainCS : relationCS.getDomain()) {
			if (abstractDomainCS instanceof PrimitiveTypeDomainCS) {
				declarePrimitiveTypeDomainCS(relationEnv, (PrimitiveTypeDomainCS) abstractDomainCS);
			}
			else {
				DomainCS domainCS = (DomainCS) abstractDomainCS;
				declareDomainCS(relationEnv, domainCS);
				if (domainCS.isCheckonly())
					explicitCheckonly = true;
				if (domainCS.isEnforce())
					explicitEnforce = true;
			}
		}
		for (Domain domain : relationEnv.getASTNode().getDomain()) {
			boolean isPrimitive = domain.getTypedModel() == null;
			boolean isCheckonly = domain.isIsCheckable();
			boolean isEnforced = domain.isIsEnforceable();
			if (isPrimitive || (!explicitCheckonly && !isEnforced))
				domain.setIsCheckable(true);
			if (isPrimitive || (!explicitEnforce && !isCheckonly))
				domain.setIsEnforceable(true);
		}
	}

	protected void declareRelationCallExpCS(QVTrRelationEnvironment env, Relation relation, OperationCallExpCS relationCallExpCS) {
		EList<Domain> invokedDomains = relation.getDomain();
		EList<OCLExpressionCS> invokingArguments = relationCallExpCS.getArguments();
		int invokedCount = invokedDomains != null ? invokedDomains.size() : 0;
		int invokingCount = invokingArguments != null ? invokingArguments.size() : 0;
		if (invokedCount != invokingCount) {
			ERROR(relationCallExpCS, "relationCallExpCS", "Expected " + invokedCount + " arguments");
			return;
		}
		for (int i = 0; i < invokedCount; i++) {
//			@SuppressWarnings("null")
			RelationDomain domain = (RelationDomain) invokedDomains.get(i);
//			@SuppressWarnings("null")
			OCLExpressionCS argument = invokingArguments.get(i);
			if (argument instanceof VariableExpCS)
				env.createVariableDeclaration((VariableExpCS) argument, domain.getRootVariable().getType(), domain, true);
		}
	}

	protected void declareTemplateCS(QVTrDomainEnvironment env, TemplateCS templateCS, Variable rootVariable) {
		EClassifier referredClassifier;
		if (rootVariable == null) {
			TypeCS typeCS = templateCS.getType();
			referredClassifier = resolveClassifier(env, "templateCS", typeCS);
			env.createVariableDeclaration(templateCS.getIdentifier(), referredClassifier);
		}
		else
			referredClassifier = rootVariable.getType();
		if (templateCS instanceof ObjectTemplateCS) {
			if ((referredClassifier == null) || (referredClassifier instanceof EClass))
				for (PropertyTemplateCS propertyTemplateCS : ((ObjectTemplateCS) templateCS).getPropertyTemplate())
					declarePropertyTemplateCS(env, (EClass)referredClassifier, propertyTemplateCS);
			else
				ERROR(templateCS.getType(), "declareTemplateCS", "Non-class '" + formatType(referredClassifier) + "'");
		}
		else if (templateCS instanceof CollectionTemplateCS)
			declareCollectionTemplateCS(env, referredClassifier, (CollectionTemplateCS) templateCS);
		else
			ERROR(templateCS, "declareTemplateCS", "Unsupported " + formatClass(templateCS));
	}

	protected void declareTransformationCS(QVTrTopLevelEnvironment topLevelEnvironment, TransformationCS transformationCS) {
		QVTrTransformationEnvironment env = topLevelEnvironment.createEnvironment(transformationCS);
		for (ModelDeclCS modelDeclCS : transformationCS.getModelDecl())
			if (!isCancelled())
				declareModelDeclCS(env, modelDeclCS);
		for (QueryCS queryCS : transformationCS.getQuery())
			if (!isCancelled())
				declareQueryCS(env, queryCS);
		for (RelationCS relationCS : transformationCS.getRelation())
			if (!isCancelled())
				declareRelationCS(env, relationCS);
	}

	protected CollectionTemplateExp defineCollectionTemplateCS(IQVTrNodeEnvironment env, CollectionTemplateCS collectionTemplateCS) {
		IdentifierCS identifier = collectionTemplateCS.getIdentifier();
		Variable variable = null;
		try {
			variable = env.tryLookupVariable(identifierCS(identifier));
		} catch (LookupException e) {
			ERROR(identifier, "CollectionTemplateCS", env.formatLookupException(e));
		}
		CollectionTemplateExp collectionTemplateExp = QVTTemplateFactory.eINSTANCE.createCollectionTemplateExp();
		env.initASTMapping(collectionTemplateExp, collectionTemplateCS);
		EClassifier referredClassifier;
		if (variable != null)
			referredClassifier = variable.getType();
		else
			referredClassifier = typeCS(collectionTemplateCS.getType(), env);
		if (referredClassifier == null)
			referredClassifier = getOCLEnvironment().getOCLStandardLibrary().getOclVoid();
		EClassifier elementType = null;
		if (referredClassifier instanceof CollectionType)
			elementType = ((CollectionType) referredClassifier).getElementType();
		if (elementType == null)
			elementType = getOCLEnvironment().getOCLStandardLibrary().getOclVoid();
		for (IdentifiedCS headIdentifier :  collectionTemplateCS.getMemberIdentifier()) {
			if (headIdentifier instanceof TemplateCS) {
				OCLExpression headExpr = defineTemplateCS(env, (TemplateCS) headIdentifier);
//				headExpr.setType(type);
				collectionTemplateExp.getMember().add(headExpr);
			}
			else {
				Variable headVariable = env.createVariableDeclaration(headIdentifier.getIdentifier(), elementType);
				VariableExp headVariableExp = oclEcoreFactory.createVariableExp();
				env.initASTMapping(headVariableExp, headIdentifier);
				headVariableExp.setReferredVariable(headVariable);
				headVariableExp.setType(headVariable.getType());	// May differ from elementTypoe for _
//				headVariableExp.setName(headVariable.getName());
				collectionTemplateExp.getMember().add(headVariableExp);
			}
		}
		IdentifierCS tailIdentifier = collectionTemplateCS.getRestIdentifier();
		if (tailIdentifier != null) {
			Variable tailVariable = (Variable) tailIdentifier.getAst();
			collectionTemplateExp.setRest(tailVariable);
		}
		collectionTemplateExp.setName(identifierCS(identifier));
		collectionTemplateExp.setBindsTo(variable);
		CollectionType referredCollectionType = ClassUtils.asClassOrNull(referredClassifier, CollectionType.class);
		collectionTemplateExp.setType(referredClassifier);
		collectionTemplateExp.setReferredCollectionType(referredCollectionType);			
		return collectionTemplateExp;
	}
	
	protected void defineDomainCS(QVTrRelationEnvironment env, DomainCS domainCS) {
		QVTrDomainEnvironment domainEnv = env.getEnvironment(domainCS);
		RelationDomain relationDomain = domainEnv.getASTNode();
		TemplateExp templateExpression = defineTemplateCS(domainEnv, domainCS.getTemplate());
		domainEnv.installPattern(templateExpression);
		List<DefaultValueCS> defaultValueCSs = domainCS.getDefaultValue();
		if (defaultValueCSs != null) {
			for (DefaultValueCS defaultValueCS : defaultValueCSs) {
				IdentifierCS identifierCS = defaultValueCS.getIdentifier();
				String identifier = identifierCS(identifierCS);
				Variable variable = env.getVariable(identifier);
				if (variable == null) {
					ERROR(identifierCS, "identifierCS", "Undefined variable '" + formatString(identifier) + "'");
				}
				else {
					OCLExpression initExpression = oclExpressionCS(defaultValueCS.getInitialiser(), domainEnv);
					RelationDomainAssignment defaultInitializer = QVTRelationFactory.eINSTANCE.createRelationDomainAssignment();
					env.initASTMapping(defaultInitializer, defaultValueCS);
					identifierCS.setAst(defaultInitializer);
					defaultInitializer.setVariable(variable);
					defaultInitializer.setValueExp(initExpression);
					relationDomain.getDefaultAssignment().add(defaultInitializer);
					// FIXME Move the following to validation
					EClassifier variableType = variable.getType();
					EClassifier initialiserType = initExpression != null ? initExpression.getType() : null;
					if ((initExpression instanceof CollectionLiteralExp) && (variableType instanceof CollectionType)) {
						CollectionLiteralExp collectionLiteral = (CollectionLiteralExp) initExpression;
						CollectionType collectionElementType = (CollectionType)variableType;
						EList<?> parts = collectionLiteral.getPart();
						if ((parts == null) || (parts.size() <= 0)) {							
							initialiserType = getCollectionType(identifierCS, env, collectionLiteral.getKind(), collectionElementType.getElementType());
//							collectionLiteral.setType(resolvedType); -- empty collection is OclVoid -- OCL 8.3.7
						}
					}
					if (!assignableToFrom(variableType, initialiserType))
						ERROR(defaultValueCS, "defaultValueCS", "Incompatible initialiser type '" + formatType(initialiserType) + "' for variable type '" + formatType(variableType) + "'");
				}
			}
		}
		OperationCallExpCS implementedByCS = domainCS.getImplementedBy();
		if (implementedByCS != null) {
			RelationImplementation relationImplementation = defineImplementedByCS(env, relationDomain.getTypedModel(), implementedByCS);
			if (relationImplementation != null)
				env.getRelation().getOperationalImpl().add(relationImplementation);
		}
	}

	protected RelationImplementation defineImplementedByCS(QVTrRelationEnvironment env, TypedModel typedModel, OperationCallExpCS implementedByCS) {
		RelationImplementation relationImplementation = QVTRelationFactory.eINSTANCE.createRelationImplementation();
		env.initASTMapping(relationImplementation, implementedByCS, null);
		relationImplementation.setInDirectionOf(typedModel);
		org.eclipse.ocl.expressions.OCLExpression<EClassifier> exp = operationCallExpCS(implementedByCS, env);
		if (exp instanceof OperationCallExp) {
			OperationCallExp opCall = (OperationCallExp)exp;
			relationImplementation.setImpl(opCall.getReferredOperation());
			//FIXME arguments
		}
		// FIXME error
		return relationImplementation;
	}

	protected List<TransformationCS> defineImportClauseCS(QVTrTopLevelEnvironment env, UnitCS unitCS) {
		String sourceFolder = getSourceFolder(env);
		StringBuffer fileName = new StringBuffer();
		for (IdentifierCS id : unitCS.getIdentifier()) {
			fileName.append(id.getValue());
			fileName.append(".");				// FIXME need some kind of search path for . separators
		}
		String fileNameString = null;
		File file = null;
		for (String textExtension : QVTPreferences.getRelationTextExtensions()) {
			fileNameString = fileName.toString() + textExtension;
			file = new File(sourceFolder, fileNameString);
			if (file.exists())
				break;
			file = null;
		}
		if (file == null) {
			ERROR(unitCS, "importClauseCS", "Failed to locate any file for '" + formatString(fileName.toString()) + "'");
			return null;
		}
		try {
			Reader fileReader = new FileReader(file);
			QVTrLexer lexer = new QVTrLexer(env.getFileEnvironment());
			lexer.reset(fileReader, file.toString());
			QVTrParser parser = new QVTrParser(lexer);
			lexer.lexer(parser.getIPrsStream());
			CSTNode cstNode = parser.parser();
			if (cstNode == null)
				return null;
			List<TransformationCS> importedTransformationCS = ((TopLevelCS) cstNode).getTransformation();
			return importedTransformationCS;			// FIXME nested imports
		} catch (IOException e) {
			ERROR(unitCS, "importClauseCS", "Failed to import '" + formatString(fileNameString) + "' : " + e.getMessage());
			return null;
		}
	}

	protected Key defineKeyDeclCS(QVTrTransformationEnvironment env, KeyDeclCS keyDeclCS) {
		Key key = QVTRelationFactory.eINSTANCE.createKey();
		env.initASTMapping(key, keyDeclCS);
		PathNameCS classId = keyDeclCS.getClassId();
		EClass identifiedClass = resolveClass(env, "keyDeclCS", classId);
		key.setIdentifies(identifiedClass);
		for (IdentifiedCS  propertyIdCS : keyDeclCS.getPropertyId()) {
			propertyIdCS.setAst(key);
			EStructuralFeature resolvedProperty = resolveForwardProperty(env, identifiedClass, "keyDeclCS", propertyIdCS);
			if (resolvedProperty != null) {
				key.getPart().add(resolvedProperty);;
			}
			else if ((resolvedProperty = resolveReverseProperty(env, identifiedClass, "keyDeclCS", propertyIdCS)) != null) {
				key.getOppositePart().add((EReference) resolvedProperty);
			}
			else {
				resolvedProperty = resolveUnresolvedProperty(env, identifiedClass, "keyDeclCS", propertyIdCS);
				key.getPart().add(resolvedProperty);;
			}
			propertyIdCS.getIdentifier().setAst(resolvedProperty);
		}
		return key;
	}

	protected TemplateExp defineObjectTemplateCS(IQVTrNodeEnvironment env, ObjectTemplateCS templateCS) {
		IdentifierCS identifier = templateCS.getIdentifier();
		Variable variable = null;
		try {
			variable = env.tryLookupVariable(identifierCS(identifier));		// FIXME use identifier.getAst();
		} catch (LookupException e) {
			ERROR(identifier, "ObjectTemplateCS", env.formatLookupException(e));
		}
		ObjectTemplateExp objectTemplate = QVTTemplateFactory.eINSTANCE.createObjectTemplateExp();
		env.initASTMapping(objectTemplate, templateCS);
		env.setNameFromIdentifier(objectTemplate, identifier, null);
		EClassifier referredClassifier;
		if (variable != null) {
			referredClassifier = variable.getType();
			objectTemplate.setBindsTo(variable);
		}
		else {
			referredClassifier = typeCS(templateCS.getType(), env);
		}
		if (referredClassifier == null)
			referredClassifier = getOCLEnvironment().getOCLStandardLibrary().getOclVoid();
		EClass referredClass = ClassUtils.asClassOrNull(referredClassifier, EClass.class);
		objectTemplate.setType(referredClassifier);
		objectTemplate.setReferredClass(referredClass);
		for (PropertyTemplateCS propertyTemplateCS : templateCS.getPropertyTemplate()) {
			PropertyTemplateItem item = definePropertyTemplateCS(env, referredClass, propertyTemplateCS);
			if (item != null)
				objectTemplate.getPart().add(item);
		}
		return objectTemplate;
	}

	protected void definePredicateCS(IQVTrNodeEnvironment env, Pattern pattern, List<OCLExpressionCS> oclExpressionCSlist) {
		List<Variable> bindsTo = pattern.getBindsTo();
		for (OCLExpressionCS oclExpressionCS : oclExpressionCSlist) {
			Predicate predicate = QVTBaseFactory.eINSTANCE.createPredicate();
			env.initASTMapping(predicate, oclExpressionCS, null);
			pattern.getPredicate().add(predicate);			
			OCLExpression conditionExpression = definePredicateOCLExpressionCS(env, oclExpressionCS);
			predicate.setConditionExpression(conditionExpression);
			for(TreeIterator<EObject> i = conditionExpression.eAllContents(); i.hasNext(); ) {
				EObject content = i.next();
				if (content instanceof VariableExp) {
					Variable variable = (Variable) ((VariableExp)content).getReferredVariable();
					if (!isLocallyDefined(variable) && !bindsTo.contains(variable))
						bindsTo.add(variable);
				}
			}
		}
	}

	protected OCLExpression definePredicateOCLExpressionCS(IQVTrNodeEnvironment env, OCLExpressionCS oclExpressionCS) {
		Relation relation = isRelationCallExpCS(env, oclExpressionCS);
		if (relation == null)
			return oclExpressionCS(oclExpressionCS, env);
		RelationCallExp relationCallExp = QVTRelationFactory.eINSTANCE.createRelationCallExp();
		env.initASTMapping(relationCallExp, oclExpressionCS);
		((OperationCallExpCS) oclExpressionCS).getSimpleNameCS().setAst(relationCallExp);
		relationCallExp.setReferredRelation(relation);
		relationCallExp.setType(getBoolean());
		for (OCLExpressionCS argumentCS : ((OperationCallExpCS) oclExpressionCS).getArguments()) {
			OCLExpression argument = oclExpressionCS(argumentCS, env);
			if (argument != null)
				relationCallExp.getArgument().add(argument);
		}
		return relationCallExp;
	}

	protected PropertyTemplateItem definePropertyTemplateCS(IQVTrNodeEnvironment env, EClass referredClass, PropertyTemplateCS propertyTemplateCS) {
		PropertyTemplateItem propertyTemplateItem = QVTTemplateFactory.eINSTANCE.createPropertyTemplateItem();
		env.initASTMapping(propertyTemplateItem, propertyTemplateCS);
		
		EStructuralFeature eStructuralFeature = propertyTemplateCS.getReferredProperty();
		IdentifiedCS propertyIdCS = propertyTemplateCS.getPropertyId();
		propertyIdCS.setAst(propertyTemplateItem);
		propertyIdCS.getIdentifier().setAst(eStructuralFeature);
/*		IdentifiedCS propertyIdCS = propertyTemplateCS.getPropertyId();
		if (resolvedProperty == null) {					// Not yet resolved if in a literal context
			IdentifierCS identifierCS = propertyIdCS.getIdentifier();
			String propertyName = identifierCS(identifierCS);
			eStructuralFeature = referredClass != null ? referredClass.getEStructuralFeature(propertyName) : null;
			if (eStructuralFeature == null)
				ERROR(identifierCS, "propertyTemplate", "No '" + formatType(referredClass) + "." + formatString(propertyName) + "' property");
		} */
		OCLExpression oclExpression = oclExpressionCS(propertyTemplateCS.getOclExpression(), env);
		propertyTemplateItem.setReferredProperty(eStructuralFeature);
		boolean isOpposite = propertyTemplateCS.isOpposite();
		propertyTemplateItem.setIsOpposite(isOpposite);
		propertyTemplateItem.setValue(oclExpression);
		if ((eStructuralFeature != null) && (oclExpression != null)) {
			EClassifier featureType = uml.getOCLType(isOpposite ? eStructuralFeature.getEContainingClass() : eStructuralFeature);
			featureType = TypeUtil.resolveType(env, featureType);
			env.checkFeatureCompatibility(propertyIdCS, featureType, oclExpression);
		}
		return propertyTemplateItem;
	}

	protected Function defineQueryCS(QVTrQueryEnvironment env, QueryCS queryCS) {
		Function query = env.getQuery();
		if (query.getQueryExpression() == null)		// Error generated from resolveQuery in declareQueryCS
			query.setQueryExpression(oclExpressionCS(queryCS.getOclExpression(), env));
		return query;
	}
	
	protected Relation defineRelationCS(QVTrRelationEnvironment env, RelationCS relationCS) {
		Relation relation = env.getRelation();
		relation.setIsTopLevel(relationCS.isTop());
		for (VarDeclarationCS varDeclarationCS : relationCS.getVarDeclaration()) {
			defineVarDeclarationCS(env, varDeclarationCS);
			varDeclarationCS.setAst(relation);			// ?? Perhaps first variable would be better
		}
		for (AbstractDomainCS abstractDomainCS : relationCS.getDomain()) {
			if (isCancelled())
				return relation;
			if (abstractDomainCS instanceof DomainCS) {
				DomainCS domainCS = (DomainCS) abstractDomainCS;
				QVTrDomainEnvironment domainEnv = env.getEnvironment(domainCS);
				TemplateCS templateCS = domainCS.getTemplate();
				Variable rootVariable = env.getVariable(templateCS.getIdentifier().getValue());
				declareTemplateCS(domainEnv, templateCS, rootVariable);
			}
		}
		WhenCS whenCS = relationCS.getWhen();
		WhereCS whereCS = relationCS.getWhere();
		if ((whenCS != null) && (whenCS.getExpr().size() > 0))
			for (OCLExpressionCS exprCS : whenCS.getExpr())
				declarePredicateCS(env, exprCS);
		if ((whereCS != null) && (whereCS.getExpr().size() > 0))
			for (OCLExpressionCS exprCS : whereCS.getExpr())
				declarePredicateCS(env, exprCS);
		env.createReferencedVariables(this);
		IdentifierCS overridesCS = relationCS.getOverrides();
		if (overridesCS != null) {
			String overridesId = identifierCS(overridesCS);
			Relation overrides = env.getRelation(null, overridesId);
			if (overrides != null)
				relation.setOverrides(overrides);
			else
				ERROR(overridesCS, "relationCS", "Failed to locate overriden '" + overridesId + "'");
		}
		for (AbstractDomainCS domainCS : relationCS.getDomain()) {
			if (isCancelled())
				return relation;
			if (domainCS instanceof DomainCS)
				defineDomainCS(env, (DomainCS) domainCS);
		}
		if ((whenCS != null) && (whenCS.getExpr().size() > 0)) {
			Pattern pattern = QVTBaseFactory.eINSTANCE.createPattern();
			env.initASTMapping(pattern, whenCS);
			definePredicateCS(env, pattern, whenCS.getExpr());
			relation.setWhen(pattern);
		}
		if ((whereCS != null) && (whereCS.getExpr().size() > 0)) {
			Pattern pattern = QVTBaseFactory.eINSTANCE.createPattern();
			env.initASTMapping(pattern, whereCS);
			definePredicateCS(env, pattern, whereCS.getExpr());
			relation.setWhere(pattern);
		}
		return relation;
	}

	protected RelationCallExp defineRelationCallExpCS(IQVTrNodeEnvironment env, Relation relation, OperationCallExpCS operationCallExpCS) {
		RelationCallExp relationCallExp = QVTRelationFactory.eINSTANCE.createRelationCallExp();
		env.initASTMapping(relationCallExp, operationCallExpCS);
		operationCallExpCS.getSimpleNameCS().setAst(relationCallExp);
		relationCallExp.setReferredRelation(relation);
		relationCallExp.setType(getBoolean());
		for (OCLExpressionCS argumentCS : operationCallExpCS.getArguments()) {
			OCLExpression argument = oclExpressionCS(argumentCS, env);
			if (argument != null)
				relationCallExp.getArgument().add(argument);
		}
		return relationCallExp;
	}

	protected TemplateExp defineTemplateCS(IQVTrNodeEnvironment env, TemplateCS templateCS) {
		TemplateExp templateExp = null;
		if (templateCS instanceof ObjectTemplateCS)
			templateExp = defineObjectTemplateCS(env, (ObjectTemplateCS) templateCS);
		else if (templateCS instanceof CollectionTemplateCS)
			templateExp = defineCollectionTemplateCS(env, (CollectionTemplateCS) templateCS);
		else
			ERROR(templateCS, "templateCS", "Unsupported " + formatClass(templateCS));
		OCLExpressionCS guardCS = templateCS.getGuardExpression();
		if ((templateExp != null) && (guardCS != null))
			templateExp.setWhere(definePredicateOCLExpressionCS(env, guardCS));
		return templateExp;
	}

	protected void defineTopLevelCS(QVTrTopLevelEnvironment topLevelEnvironment) {
		TopLevelCS topLevelCS = topLevelEnvironment.getCSTNode();
		for (UnitCS unitCS : topLevelCS.getImportClause()) {
			if (isCancelled()) 
				return;
			List<TransformationCS> transformationCSs = defineImportClauseCS(topLevelEnvironment, unitCS);
			if (transformationCSs != null)
				topLevelCS.getTransformation().addAll(transformationCSs);
		}
		for (TransformationCS transformationCS : topLevelCS.getTransformation()) {
			if (!isCancelled())
				declareTransformationCS(topLevelEnvironment, transformationCS);
		}
		for (TransformationCS transformationCS : topLevelCS.getTransformation()) {
			if (!isCancelled())
				defineTransformationCS(topLevelEnvironment, transformationCS);
		}
	}

	protected void defineTransformationCS(QVTrTopLevelEnvironment topLevelEnvironment, TransformationCS transformationCS) {
		QVTrTransformationEnvironment env = topLevelEnvironment.getEnvironment(transformationCS);
		RelationalTransformation transformation = env.getRelationalTransformation();
		for (KeyDeclCS keyDeclCS : transformationCS.getKeyDecl())
			transformation.getOwnedKey().add(defineKeyDeclCS(env, keyDeclCS));
		for (QueryCS queryCS : transformationCS.getQuery()) {
			if (isCancelled())
				return;
			List<String> pathName = AbstractQVTAnalyzer.createSequenceOfNames(queryCS.getPathName(), null);
			if (pathName != null) {
				int pathSize = pathName.size();
				if (pathSize > 0) {
					RelationalTransformation scope = transformation;
					if (pathSize > 1)
						scope = topLevelEnvironment.getRelationalTransformation(pathName.subList(0, pathSize-1));
					Function query = EcoreUtils.getNamedElement(scope.getEOperations(), pathName.get(pathSize-1), Function.class);
					if (query != null) {
						QVTrQueryEnvironment queryEnv = env.getEnvironment(queryCS);
						defineQueryCS(queryEnv, queryCS);
					}
				}
			}
		}
		for (RelationCS relationCS : transformationCS.getRelation()) {
			if (isCancelled())
				return;
			QVTrRelationEnvironment relationEnv = env.getEnvironment(relationCS);
			defineRelationCS(relationEnv, relationCS);
		}
		return;
	}

	protected void defineVarDeclarationCS(QVTrRelationEnvironment env, VarDeclarationCS varDeclarationCS) {
		TypeCS typeCS = varDeclarationCS.getType();
		EClassifier type = resolveClassifier(env, "varDeclarationCS", typeCS);
		for (IdentifierCS varDeclarationId : varDeclarationCS.getVarDeclarationId()) {
			env.createVariableDeclaration(varDeclarationId, type);
//			if (type instanceof PrimitiveType)
//				ERROR(typeCS, "VarDeclarationCS", "#Using OCL type '" + formatType(type) + "'");
//			else if ((type instanceof CollectionType) && (((CollectionType)type).getElementType() instanceof PrimitiveType))
//				ERROR(typeCS, "VarDeclarationCS", "#Using OCL type '" + formatType(type) + "'");
		}
	}
	
	protected String getSourceFolder(IQVTrNodeEnvironment env) {
		FileHandle file = env.getResolver().getHandle();
		URI uri = file != null ? file.getURI() : null;
		File currentFile = uri != null ? new File(uri.toFileString()) : null;
		return currentFile != null ? currentFile.getParent() : null;
	}

	protected OCLExpression isQueryCallExpCS(IQVTrNodeEnvironment env, OCLExpressionCS oclExpressionCS) {
		if (!(oclExpressionCS instanceof OperationCallExpCS))
			return null;
		OperationCallExpCS operationCallExpCS = (OperationCallExpCS)oclExpressionCS;
		if (operationCallExpCS.getAccessor() != DotOrArrowEnum.NONE_LITERAL)
			return null;
		String name = operationCallExpCS.getSimpleNameCS().getValue();
		if (name == null)
			return null;
		OCLExpressionCS source = operationCallExpCS.getSource();
		if (source != null)
			return null;
		List<OCLExpression> args = new ArrayList<OCLExpression>();
		for (OCLExpressionCS arg : operationCallExpCS.getArguments()) {
			OCLExpression argExpr = oclExpressionCS(arg, env);
			if (argExpr == null)
				return env.createInvalidLiteralExp(oclExpressionCS);
			args.add(argExpr);
		}
		List<Function> queries = env.getQueries(name, args);
		if ((queries == null) || (queries.size() == 0)) {
			ERROR(oclExpressionCS, "QueryCallExpCS", "Unable to resolve query '" + formatString(name) + "' with matching signature");
			return env.createInvalidLiteralExp(oclExpressionCS);
		}
		if (queries.size() > 1) {
			ERROR(oclExpressionCS, "QueryCallExpCS", "Unable to resolve query '" + formatString(name) + "' unambiguously");
			return env.createInvalidLiteralExp(oclExpressionCS);
		}
		Function query = queries.get(0);
		OperationCallExp queryCall = oclEcoreFactory.createOperationCallExp();
		env.initASTMapping(queryCall, oclExpressionCS);
		queryCall.setName(name);
		queryCall.setEType(query.getEType());
		queryCall.setReferredOperation(query);
		queryCall.getArgument().addAll(args);
		operationCallExpCS.getSimpleNameCS().setAst(query);
		return queryCall;		
	}

	protected Relation isRelationCallExpCS(IQVTrNodeEnvironment env, OCLExpressionCS oclExpressionCS) {
		if (!(oclExpressionCS instanceof OperationCallExpCS))
			return null;
		OperationCallExpCS operationCallExpCS = (OperationCallExpCS)oclExpressionCS;
		if (operationCallExpCS.getAccessor() == DotOrArrowEnum.ARROW_LITERAL)
			return null;
		String name = operationCallExpCS.getSimpleNameCS().getValue();
		OCLExpressionCS source = operationCallExpCS.getSource();
		EList<String> pathName = null;
		if (source instanceof PathNameCS)
			pathName = AbstractQVTAnalyzer.createSequenceOfNames((PathNameCS) source, null);
		Relation relation = env.getRelation(pathName, name);
		if ((pathName != null) && (relation == null))			// Null pathName could be a query
			ERROR(oclExpressionCS, "RelationCallExpCS", "Unable to resolve relation '" + formatPath(pathName, name) + "'");
		return relation;		
	}

	// Overridden to add support for relation calls.
	@Override
	protected OCLExpression oclExpressionCS(OCLExpressionCS oclExpressionCS, Environment<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter,
			EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env) {
//		IQVTrEnvironment exprEnv = new QVTrExpressionEnvironment((IQVTrEnvironment)env, oclExpressionCS);
		IQVTrNodeEnvironment exprEnv = (IQVTrNodeEnvironment)env;
		OCLExpression oclExpression = null;
		try {
			if (oclExpressionCS instanceof TemplateCS)
				return defineTemplateCS((IQVTrNodeEnvironment)env, (TemplateCS) oclExpressionCS);
			Relation relation = isRelationCallExpCS(exprEnv, oclExpressionCS);
			if (relation != null)
				return defineRelationCallExpCS(exprEnv, relation, (OperationCallExpCS)oclExpressionCS);
			oclExpression = (OCLExpression) super.oclExpressionCS(oclExpressionCS, exprEnv);
			if (oclExpression != null)
				return oclExpression;
		} catch (Exception e) {
			ERROR(oclExpressionCS, "oclExpressionCS", "Failed to parse expression : " + e.getClass().getName() + " - " + e.getMessage());
			e.printStackTrace();
			oclExpression = ((IQVTrNodeEnvironment)env).createInvalidLiteralExp(oclExpressionCS);
		}
		return oclExpression;		// FIXME always return invalidLiteral
	}

	// Overridden to add support for query calls.
	@Override
	protected org.eclipse.ocl.expressions.OCLExpression<EClassifier> operationCallExpCS(
			OperationCallExpCS operationCallExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		OCLExpression queryCall = isQueryCallExpCS((IQVTrNodeEnvironment) env, operationCallExpCS);
		if (queryCall != null)
			return queryCall;
		return super.operationCallExpCS(operationCallExpCS, env);
	}

	protected EClassifier resolveProperty(QVTrDomainEnvironment env, EClass parentType, PropertyTemplateCS propertyTemplateCS) {
		IdentifiedCS propertyIdCS = propertyTemplateCS.getPropertyId();
		EClassifier propertyType = null;
		EStructuralFeature resolvedProperty = resolveForwardProperty(env, parentType, "propertyTemplateCS", propertyIdCS);
		if (resolvedProperty != null) {
			propertyTemplateCS.setReferredProperty(resolvedProperty);
			propertyType = uml.getOCLType(resolvedProperty);
		}
		else if ((resolvedProperty = resolveReverseProperty(env, parentType, "propertyTemplateCS", propertyIdCS)) != null) {
			propertyTemplateCS.setReferredProperty(resolvedProperty);
			propertyTemplateCS.setOpposite(true);
			propertyType = uml.getOCLType(resolvedProperty.getEContainingClass());
		}
		else {
			resolvedProperty = resolveUnresolvedProperty(env, parentType, "propertyTemplateCS", propertyIdCS);
			propertyTemplateCS.setReferredProperty(resolvedProperty);
			propertyType = uml.getOCLType(resolvedProperty);
		}
		propertyType = TypeUtil.resolveType(env, propertyType);
		if (propertyType instanceof CollectionType)
			initASTMapping(env, propertyType, propertyTemplateCS, null);
		return propertyType;
	}

	// Overridden to add support for opposite property names.
	@Override
	protected PropertyCallExp<EClassifier, EStructuralFeature> simplePropertyName(
			SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			org.eclipse.ocl.expressions.OCLExpression<EClassifier> source,
			EClassifier sourceElementType, String simpleName) {
		PropertyCallExp<EClassifier, EStructuralFeature> propertyCall = super.simplePropertyName(simpleNameCS, env, source, sourceElementType, simpleName);
		if (propertyCall != null)
			return propertyCall;
		if (!(sourceElementType instanceof EClass))
			return null;
		EStructuralFeature property;
		try {
			property = ((IQVTrNodeEnvironment)env).tryLookupOppositeProperty((EClass)sourceElementType, simpleName);
		} catch (LookupException e) {
			ERROR(simpleNameCS, "SimpleNameCS", ((IQVTrNodeEnvironment) env).formatLookupException(e));
			List<?> matches = e.getAmbiguousMatches();
			if (matches.isEmpty())
				return null;
			property = (EStructuralFeature) matches.get(0);
		}
		if (property == null)
			return null;
		TRACE("variableExpCS", "Property: " + simpleName);//$NON-NLS-2$//$NON-NLS-1$
		propertyCall = QVTRelationFactory.eINSTANCE.createOppositePropertyCallExp();
		initASTMapping(env, propertyCall, simpleNameCS);
		propertyCall.setReferredProperty(property);
		EClassifier resolvedSetType = TypeUtil.resolveSetType(env, property.getEContainingClass());
		if (resolvedSetType != null)
			((IQVTrNodeEnvironment)env).getASTNodeToCSTNodeMap().put(resolvedSetType, simpleNameCS);
		propertyCall.setType(resolvedSetType);
		if (source != null) {
			propertyCall.setSource(source);
		} else {
			org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> var = env.lookupImplicitSourceForProperty(simpleName);
			org.eclipse.ocl.expressions.VariableExp<EClassifier, EParameter> result = createVariableExp(env, simpleNameCS, var);
			propertyCall.setSource(result);
		}
		initPropertyPositions(propertyCall, simpleNameCS);
		return propertyCall;
	}
}
