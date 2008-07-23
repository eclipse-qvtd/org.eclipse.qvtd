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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionLiteralPartCS;
import org.eclipse.ocl.cst.DotOrArrowEnum;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
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
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.QVTBaseFactory;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationFactory;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Key;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplateFactory;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;
import org.eclipse.qvt.declarative.ecore.utils.EcoreUtils;
import org.eclipse.qvt.declarative.modelregistry.util.ClassUtils;
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
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.IQVTrEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrDomainEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrNestedEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrQueryEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrRelationEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrTopLevelEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrTransformationEnvironment;
import org.eclipse.qvt.declarative.parser.qvtrelation.environment.QVTrTypedModelEnvironment;
import org.eclipse.qvt.declarative.parser.ui.preferences.QVTPreferences;

public abstract class AbstractQVTrAnalyzer extends AbstractQVTAnalyzer<IQVTrEnvironment>
{
	static org.eclipse.emf.ecore.EcoreFactory emfEcoreFactory = org.eclipse.emf.ecore.EcoreFactory.eINSTANCE;
	static org.eclipse.ocl.ecore.EcoreFactory oclEcoreFactory = org.eclipse.ocl.ecore.EcoreFactory.eINSTANCE;

	public AbstractQVTrAnalyzer(QVTrParser parser) {
		super(parser, parser.getOCLEnvironment().getMonitor());
	}
	
	@Override
	protected IQVTrEnvironment createdNestedEnvironment(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		return new QVTrNestedEnvironment((IQVTrEnvironment)env, cstNode);
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
		functionParameter.setName(identifierCS(inputParamDeclarationCS.getIdentifier()));
		functionParameter.setEType(resolveClassifier(env, "inputParamDeclarationCS", inputParamDeclarationCS.getType()));
		env.addParameter(functionParameter);
	}

	protected void declareMetaModelIdCS(QVTrTypedModelEnvironment env, IdentifierCS metaModelIdCS) {
		TypedModel typedModel = env.getTypedModel();
		String metaModelId = identifierCS(metaModelIdCS);
		URI uri = getResolver().getURI(metaModelId);		// FIXME Fix-up error with reference to stub
		if (uri == null)
			ERROR(metaModelIdCS, "metaModelIdCS", "Unknown meta-model '" + formatString(metaModelId) + "'");
		else {
			try {
				Resource resource = getResolver().getResource(uri, true);
				if (resource == null)
					ERROR(metaModelIdCS, "metaModelIdCS", "Failed to load meta-model '" + formatString(metaModelId) + "'");
				else {
					EList<EObject> contents = resource.getContents();
					if (contents != null) {
						for (EObject eObject : contents) {
							if (eObject instanceof EPackage) {
								typedModel.getUsedPackage().add((EPackage) eObject);
								env.addMetaModelPackage(metaModelId, (EPackage) eObject);
							}
							else
								ERROR(metaModelIdCS, "metaModelIdCS", "Non-package '" + formatName(eObject) + "' ignored");
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
		IdentifiedCS propertyIdCS = propertyTemplateCS.getPropertyId();
		EStructuralFeature property = resolveProperty(env, parentType, "propertyTemplateCS", propertyIdCS);
		propertyTemplateCS.setReferredProperty(property);
		EClassifier propertyType = property != null ? uml.getOCLType(property) : null;
		propertyType = TypeUtil.resolveType(env, propertyType);
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
		for (AbstractDomainCS domainCS : relationCS.getDomain()) {
			if (domainCS instanceof PrimitiveTypeDomainCS)
				declarePrimitiveTypeDomainCS(relationEnv, (PrimitiveTypeDomainCS) domainCS);
			else
				declareDomainCS(relationEnv, (DomainCS) domainCS);
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
			@SuppressWarnings("null") RelationDomain domain = (RelationDomain) invokedDomains.get(i);
			@SuppressWarnings("null") OCLExpressionCS argument = invokingArguments.get(i);
			if (argument instanceof VariableExpCS)
				env.createVariableDeclaration((VariableExpCS) argument, domain.getRootVariable().getType(), domain, true);
		}
	}

	protected void declareTemplateCS(QVTrDomainEnvironment env, TemplateCS templateCS, EClassifier referredClassifier) {
		if (referredClassifier == null) {
			TypeCS typeCS = templateCS.getType();
			referredClassifier = resolveClassifier(env, "templateCS", typeCS);
			env.createVariableDeclaration(templateCS.getIdentifier(), referredClassifier);
		}
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

	protected CollectionTemplateExp defineCollectionTemplateCS(IQVTrEnvironment env, CollectionTemplateCS collectionTemplateCS) {
		Variable variable = null;
		try {
			variable = env.tryLookupVariable(identifierCS(collectionTemplateCS.getIdentifier()));
		} catch (LookupException e) {
			ERROR(collectionTemplateCS.getIdentifier(), "CollectionTemplateCS", env.formatLookupException(e));
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
				headVariableExp.setType(elementType);
//				headVariableExp.setName(headVariable.getName());
				collectionTemplateExp.getMember().add(headVariableExp);
			}
		}
		IdentifierCS tailIdentifier = collectionTemplateCS.getRestIdentifier();
		if (tailIdentifier != null) {
			Variable tailVariable = env.createVariableDeclaration(tailIdentifier, referredClassifier);
			collectionTemplateExp.setRest(tailVariable);
		}
		collectionTemplateExp.setName(identifierCS(collectionTemplateCS.getIdentifier()));
		collectionTemplateExp.setBindsTo(variable);
		CollectionType referredCollectionType = ClassUtils.asClass(referredClassifier, CollectionType.class);
		collectionTemplateExp.setType(referredClassifier);
		collectionTemplateExp.setReferredCollectionType(referredCollectionType);			
		return collectionTemplateExp;
	}
	
	protected void defineDomainCS(QVTrRelationEnvironment env, RelationDomain relationDomain, DomainCS domainCS) {
		QVTrDomainEnvironment domainEnv = env.getEnvironment(domainCS);
		DomainPattern domainPattern = QVTRelationFactory.eINSTANCE.createDomainPattern();
		env.initASTMapping(domainPattern, domainCS);
		relationDomain.setPattern(domainPattern);
		domainPattern.setTemplateExpression(defineTemplateCS(domainEnv, domainCS.getTemplate()));
		List<DefaultValueCS> defaultValueCSs = domainCS.getDefaultValue();
		if (defaultValueCSs != null)
			for (DefaultValueCS defaultValueCS : defaultValueCSs) {
				IdentifierCS identifierCS = defaultValueCS.getIdentifier();
				String identifier = identifierCS(identifierCS);
				Variable variable = env.getVariable(identifier);
				if (variable == null) {
					ERROR(identifierCS, "identifierCS", "Undefined variable '" + formatString(identifier) + "'");
				}
				else {
					EClassifier variableType = variable.getType();
					OCLExpression initExpression = oclExpressionCS(defaultValueCS.getInitialiser(), domainEnv);
					EClassifier initialiserType = initExpression != null ? initExpression.getType() : null;
					if ((initExpression instanceof CollectionLiteralExp) && (variableType instanceof CollectionType)) {
						CollectionLiteralExp collectionLiteral = (CollectionLiteralExp) initExpression;
						CollectionType collectionElementType = (CollectionType)variableType;
						EList<?> parts = collectionLiteral.getPart();
						if ((parts == null) || (parts.size() <= 0)) {							
							initialiserType = getCollectionType(env, collectionLiteral.getKind(), collectionElementType.getElementType());
//							collectionLiteral.setType(resolvedType); -- empty collection is OclVoid -- OCL 8.3.7
						}
					}
					RelationDomainAssignment defaultInitializer = QVTRelationFactory.eINSTANCE.createRelationDomainAssignment();
					env.initASTMapping(defaultInitializer, defaultValueCS);
					defaultInitializer.setVariable(variable);
					defaultInitializer.setValueExp(initExpression);
					relationDomain.getDefaultAssignment().add(defaultInitializer);
					if (!assignableToFrom(variableType, initialiserType))
						ERROR(defaultValueCS, "defaultValueCS", "Incompatible initialiser type '" + formatType(initialiserType) + "' for variable type '" + formatType(variableType) + "'");
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
		env.initASTMapping(relationImplementation, implementedByCS);
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

	protected List<TransformationCS> defineImportClauseCS(QVTrTopLevelEnvironment env, UnitCS unitCS, URI sourceURI) {
		StringBuffer fileName = new StringBuffer();
		for (IdentifierCS id : unitCS.getIdentifier()) {
			fileName.append(id.getValue());
			fileName.append(".");				// FIXME need some kind of search path for . separators
		}
		File currentFile = new File(sourceURI.toFileString());
		String fileNameString = null;
		File file = null;
		for (String textExtension : QVTPreferences.getRelationTextExtensions()) {
			fileNameString = fileName.toString() + textExtension;
			file = new File(currentFile.getParent(), fileNameString);
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
			QVTrLexer lexer = new QVTrLexer(env);
			QVTrParser parser = new QVTrParser(lexer);
			lexer.setFileName(file.toString());
			lexer.initialize(fileReader); 
			lexer.lexToTokens(parser);
			CSTNode cstNode = parser.parseTokensToCST();
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
		EClass identifiedClass = resolveClass(env, "keyDeclCS", keyDeclCS.getClassId());
		if (identifiedClass != null) {
			key.setIdentifies(identifiedClass);
			for (IdentifiedCS  propertyIdCS : keyDeclCS.getPropertyId()) {
				EStructuralFeature part = resolveProperty(env, identifiedClass, "keyDeclCS", propertyIdCS);
				if (part != null)
					key.getPart().add(part);
			}
		}
		return key;
	}

	protected TemplateExp defineObjectTemplateCS(IQVTrEnvironment env, ObjectTemplateCS templateCS) {
		Variable variable = null;
		try {
			variable = env.tryLookupVariable(identifierCS(templateCS.getIdentifier()));
		} catch (LookupException e) {
			ERROR(templateCS.getIdentifier(), "ObjectTemplateCS", env.formatLookupException(e));
		}
		ObjectTemplateExp objectTemplate = QVTTemplateFactory.eINSTANCE.createObjectTemplateExp();
		env.initASTMapping(objectTemplate, templateCS);
		objectTemplate.setName(identifierCS(templateCS.getIdentifier()));
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
		EClass referredClass = ClassUtils.asClass(referredClassifier, EClass.class);
		objectTemplate.setType(referredClassifier);
		objectTemplate.setReferredClass(referredClass);
		for (PropertyTemplateCS propertyTemplateCS : templateCS.getPropertyTemplate()) {
			PropertyTemplateItem item = definePropertyTemplateCS(env, referredClass, propertyTemplateCS);
			if (item != null)
				objectTemplate.getPart().add(item);
		}
		return objectTemplate;
	}

	protected void definePredicateCS(IQVTrEnvironment env, Pattern pattern, List<OCLExpressionCS> oclExpressionCSlist) {
		// FIXME bindsTo
		for (OCLExpressionCS oclExpressionCS : oclExpressionCSlist) {
			Predicate predicate = QVTBaseFactory.eINSTANCE.createPredicate();
			env.initASTMapping(predicate, oclExpressionCS);
			pattern.getPredicate().add(predicate);			
			predicate.setConditionExpression(definePredicateOCLExpressionCS(env, oclExpressionCS));
		}
	}
	
	protected OCLExpression definePredicateOCLExpressionCS(IQVTrEnvironment env, OCLExpressionCS oclExpressionCS) {
		Relation relation = isRelationCallExpCS(env, oclExpressionCS);
		if (relation == null)
			return oclExpressionCS(oclExpressionCS, env);
		RelationCallExp relationCallExp = QVTRelationFactory.eINSTANCE.createRelationCallExp();
		env.initASTMapping(relationCallExp, oclExpressionCS);
		relationCallExp.setReferredRelation(relation);
		relationCallExp.setType(getBoolean());
		for (OCLExpressionCS argumentCS : ((OperationCallExpCS) oclExpressionCS).getArguments()) {
			OCLExpression argument = oclExpressionCS(argumentCS, env);
			if (argument != null)
				relationCallExp.getArgument().add(argument);
		}
		return relationCallExp;
	}

	protected PropertyTemplateItem definePropertyTemplateCS(IQVTrEnvironment env, EClass referredClass, PropertyTemplateCS propertyTemplateCS) {
		PropertyTemplateItem propertyTemplateItem = QVTTemplateFactory.eINSTANCE.createPropertyTemplateItem();
		env.initASTMapping(propertyTemplateItem, propertyTemplateCS);
		IdentifiedCS propertyIdCS = propertyTemplateCS.getPropertyId();
		EStructuralFeature eStructuralFeature = propertyTemplateCS.getReferredProperty();
		if (eStructuralFeature == null) {					// Not yet resolved if in a literal context
			IdentifierCS identifierCS = propertyIdCS.getIdentifier();
			String propertyName = identifierCS(identifierCS);
			eStructuralFeature = referredClass != null ? referredClass.getEStructuralFeature(propertyName) : null;
			if (eStructuralFeature == null)
				ERROR(identifierCS, "propertyTemplate", "No '" + formatType(referredClass) + "." + formatString(propertyName) + "' property");
		}
		OCLExpression oclExpression = oclExpressionCS(propertyTemplateCS.getOclExpression(), env);
		propertyTemplateItem.setReferredProperty(eStructuralFeature);
		propertyTemplateItem.setValue(oclExpression);
		if ((eStructuralFeature != null) && (oclExpression != null)) {
			EClassifier featureType = uml.getOCLType(eStructuralFeature);
			featureType = TypeUtil.resolveType(env, featureType);
			env.checkFeatureCompatibility(propertyTemplateCS.getPropertyId(), featureType, oclExpression);
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
		for (VarDeclarationCS varDeclarationCS : relationCS.getVarDeclaration())
			defineVarDeclarationCS(env, varDeclarationCS);
		int i = 0;
		for (AbstractDomainCS abstractDomainCS : relationCS.getDomain()) {
			if (isCancelled())
				return relation;
			if (abstractDomainCS instanceof DomainCS) {
				DomainCS domainCS = (DomainCS) abstractDomainCS;
				QVTrDomainEnvironment domainEnv = env.getEnvironment(domainCS);
				TemplateCS templateCS = domainCS.getTemplate();
				Variable rootVariable = env.getVariable(templateCS.getIdentifier().getValue());
				EClassifier rootClassifier = rootVariable != null ? rootVariable.getType() : null;
				declareTemplateCS(domainEnv, templateCS, rootClassifier);
			}
		}
		List<OCLExpressionCS> whenCSs = relationCS.getWhen();
		List<OCLExpressionCS> whereCSs = relationCS.getWhere();
		if ((whenCSs != null) && (whenCSs.size() > 0))
			for (OCLExpressionCS whenCS : whenCSs)
				declarePredicateCS(env, whenCS);
		if ((whereCSs != null) && (whereCSs.size() > 0))
			for (OCLExpressionCS whereCS : whereCSs)
				declarePredicateCS(env, whereCS);
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
		i = 0;
		for (AbstractDomainCS domainCS : relationCS.getDomain()) {
			if (isCancelled())
				return relation;
			RelationDomain domain = (RelationDomain) relation.getDomain().get(i++);
			if (domainCS instanceof DomainCS)
				defineDomainCS(env, domain, (DomainCS) domainCS);
		}
		if ((whenCSs != null) && (whenCSs.size() > 0)) {
			Pattern pattern = QVTBaseFactory.eINSTANCE.createPattern();
			env.initASTMapping(pattern, relationCS);
			definePredicateCS(env, pattern, whenCSs);
			relation.setWhen(pattern);
		}
		if ((whereCSs != null) && (whereCSs.size() > 0)) {
			Pattern pattern = QVTBaseFactory.eINSTANCE.createPattern();
			env.initASTMapping(pattern, relationCS);
			definePredicateCS(env, pattern, whereCSs);
			relation.setWhere(pattern);
		}
		return relation;
	}

	protected RelationCallExp defineRelationCallExpCS(IQVTrEnvironment env, Relation relation, OperationCallExpCS operationCallExpCS) {
		RelationCallExp relationCallExp = QVTRelationFactory.eINSTANCE.createRelationCallExp();
		env.initASTMapping(relationCallExp, operationCallExpCS);
		relationCallExp.setReferredRelation(relation);
		relationCallExp.setType(getBoolean());
		for (OCLExpressionCS argumentCS : operationCallExpCS.getArguments()) {
			OCLExpression argument = oclExpressionCS(argumentCS, env);
			if (argument != null)
				relationCallExp.getArgument().add(argument);
		}
		return relationCallExp;
	}

	protected TemplateExp defineTemplateCS(IQVTrEnvironment env, TemplateCS templateCS) {
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

	protected void defineTopLevelCS(QVTrTopLevelEnvironment topLevelEnvironment, TopLevelCS topLevelCS, URI sourceURI) {
		for (UnitCS unitCS : topLevelCS.getImportClause()) {
			if (isCancelled()) 
				return;
			List<TransformationCS> transformationCSs = defineImportClauseCS(topLevelEnvironment, unitCS, sourceURI);
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
			List<String> pathName = queryCS.getPathName().getSequenceOfNames();
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

	protected OCLExpression isQueryCallExpCS(IQVTrEnvironment env, OCLExpressionCS oclExpressionCS) {
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
		return queryCall;		
	}

	protected Relation isRelationCallExpCS(IQVTrEnvironment env, OCLExpressionCS oclExpressionCS) {
		if (!(oclExpressionCS instanceof OperationCallExpCS))
			return null;
		OperationCallExpCS operationCallExpCS = (OperationCallExpCS)oclExpressionCS;
		if (operationCallExpCS.getAccessor() == DotOrArrowEnum.ARROW_LITERAL)
			return null;
		String name = operationCallExpCS.getSimpleNameCS().getValue();
		OCLExpressionCS source = operationCallExpCS.getSource();
		EList<String> pathName = null;
		if (source instanceof PathNameCS)
			pathName = ((PathNameCS) source).getSequenceOfNames();
		Relation relation = env.getRelation(pathName, name);
		if ((pathName != null) && (relation == null))			// Null pathName could be a query
			ERROR(oclExpressionCS, "RelationCallExpCS", "Unable to resolve relation '" + formatPath(pathName, name) + "'");
		return relation;		
	}

	@Override protected OCLExpression oclExpressionCS(OCLExpressionCS oclExpressionCS, Environment<
			EPackage, EClassifier, EOperation, EStructuralFeature,
			EEnumLiteral, EParameter,
			EObject, CallOperationAction, SendSignalAction, Constraint,
			EClass, EObject> env) {
//		IQVTrEnvironment exprEnv = new QVTrExpressionEnvironment((IQVTrEnvironment)env, oclExpressionCS);
		IQVTrEnvironment exprEnv = (IQVTrEnvironment)env;
		OCLExpression oclExpression = null;
		try {
			if (oclExpressionCS instanceof TemplateCS)
				return defineTemplateCS((IQVTrEnvironment)env, (TemplateCS) oclExpressionCS);
			Relation relation = isRelationCallExpCS(exprEnv, oclExpressionCS);
			if (relation != null)
				return defineRelationCallExpCS(exprEnv, relation, (OperationCallExpCS)oclExpressionCS);
			oclExpression = (OCLExpression) super.oclExpressionCS(oclExpressionCS, exprEnv);
			if (oclExpression != null)
				return oclExpression;
		} catch (Exception e) {
			ERROR(oclExpressionCS, "oclExpressionCS", "Failed to parse expression : " + e.getClass().getName() + " - " + e.getMessage());
			e.printStackTrace();
			oclExpression = ((IQVTrEnvironment)env).createInvalidLiteralExp(oclExpressionCS);
		}
		return oclExpression;		// FIXME always return invalidLiteral
	}

	@Override protected org.eclipse.ocl.expressions.OCLExpression<EClassifier> operationCallExpCS(
			OperationCallExpCS operationCallExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		OCLExpression queryCall = isQueryCallExpCS((IQVTrEnvironment) env, operationCallExpCS);
		if (queryCall != null)
			return queryCall;
		return super.operationCallExpCS(operationCallExpCS, env);
	}
}
