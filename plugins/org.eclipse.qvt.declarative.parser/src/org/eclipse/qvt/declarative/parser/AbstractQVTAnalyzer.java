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
package org.eclipse.qvt.declarative.parser;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lpg.lpgjavaruntime.Monitor;

import org.eclipse.emf.common.util.EList;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CollectionLiteralExpCS;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.EnumLiteralExpCS;
import org.eclipse.ocl.cst.FeatureCallExpCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.cst.VariableCS;
import org.eclipse.ocl.cst.VariableExpCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.CollectionLiteralExp;
import org.eclipse.ocl.expressions.FeatureCallExp;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;
import org.eclipse.ocl.parser.AbstractOCLParser;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.parser.environment.ICSTEnvironment;
import org.eclipse.qvt.declarative.parser.environment.ICSTNodeEnvironment;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvt.environment.IQVTNodeEnvironment;
import org.eclipse.qvt.declarative.parser.qvt.environment.MoreEcoreForeignMethods;
import org.eclipse.qvt.declarative.parser.utils.CSTUtils;

public abstract class AbstractQVTAnalyzer<E extends IQVTNodeEnvironment> extends AbstractOCLAnalyzer<
	EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
	EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject>
{	
	private Monitor monitor;
		
	public AbstractQVTAnalyzer(AbstractOCLParser parser, Monitor monitor) {
		super(parser);
		this.monitor = monitor;
	}
	
	public void ERROR(ICSTEnvironment env, CSTNode cstNode, String rule, String problemMessage) {
		CSTUtils.setASTErrorNode(cstNode, problemMessage);
		ERROR(cstNode, rule, problemMessage);
	}
	
	public void WARNING(ICSTEnvironment env, CSTNode cstNode, String rule, String problemMessage) {
		CSTUtils.setASTErrorNode(cstNode, problemMessage);
		WARNING(cstNode, rule, problemMessage);
	}
	
	public void WARNING(Object problemObject, String rule, String problemMessage) {
		getEnvironment().analyzerWarning(problemMessage, rule, problemObject);
	}

	protected boolean assignableElementToFrom(EClassifier variableType, EClassifier initialiserType) {
		if (variableType == null)
			return false;
		if (initialiserType == null)
			return false;
		if (variableType == initialiserType)
			return true;
		if ((initialiserType instanceof EClass) && (variableType instanceof EClass)
		 && ((EClass)variableType).isSuperTypeOf((EClass)initialiserType))
			return true;
		return false;
	}
	
	protected boolean assignableToFrom(EClassifier variableType, EClassifier initialiserType) {
		if (variableType == null)
			return false;
		if (initialiserType == null)
			return false;
		if (variableType == initialiserType)
			return true;
		CollectionKind variableKind = null;
		EClassifier variableElementType = variableType;
		if (variableType instanceof CollectionType) {
			variableKind = ((CollectionType)variableType).getKind();
			variableElementType = ((CollectionType)variableType).getElementType();
		}
		CollectionKind initialiserKind = null;
		EClassifier initialiserElementType = initialiserType;
		if (initialiserType instanceof CollectionType) {
			initialiserKind = ((CollectionType)initialiserType).getKind();
			initialiserElementType = ((CollectionType)initialiserType).getElementType();
		}
		if (!assignableElementToFrom(variableElementType, initialiserElementType))
			return false;
		if (initialiserKind == null)	// Scalar to set or scalar to scalar
			return true;
		if (variableKind == null)		// Set to scalar
			return false;
//		if (QVTrUtils.isUnique(variableKind) && !QVTrUtils.isUnique(initialiserKind))
//			return false;
		return true;					// Set to set ?? TODO read the specs
	}

	protected void checkAndSetAst(ICSTEnvironment env, CSTNode cstNode, EObject astNode) {
		if (astNode != null) {
			if (env.getASTMapping(astNode) == null) {
//				System.out.println("Missing AST mapping for " + env.getFormatter().formatQualifiedName(astNode) + " corrected");
				env.getASTNodeToCSTNodeMap().put(astNode, cstNode);
			}
			if (cstNode.getAst() == null) {
//				System.out.println("Missing CST mapping for " + EcoreUtils.formatQualifiedName(cstNode) + " corrected");
				cstNode.setAst(astNode);
			}
		}
	}	
	
	@Override
	protected CollectionLiteralExp<EClassifier> collectionLiteralExpCS(CollectionLiteralExpCS collectionLiteralExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		CollectionLiteralExp<EClassifier> expr = super.collectionLiteralExpCS(collectionLiteralExpCS, env);
		EClassifier type = expr != null ? expr.getType() : null;
		if ((type != null) && (((ICSTEnvironment)env).getASTMapping(type) == null))
			((ICSTEnvironment)env).initASTMapping(type, collectionLiteralExpCS);
		return expr;
	}

	@Override
	protected IteratorExp<EClassifier, EParameter> createImplicitCollect(OCLExpression<EClassifier> source, FeatureCallExp<EClassifier> propertyCall,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			CSTNode cstNode) {
		IteratorExp<EClassifier, EParameter> expr = super.createImplicitCollect(source, propertyCall, env, cstNode);
		EClassifier type = expr != null ? expr.getType() : null;
		if ((type != null) && (((ICSTEnvironment)env).getASTMapping(type) == null))
			((ICSTEnvironment)env).initASTMapping(type, cstNode);
		return expr;
	}

	protected abstract E createdNestedEnvironment(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env);
	
    @Override
	protected OCLExpression<EClassifier> enumLiteralExpCS(EnumLiteralExpCS enumLiteralExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		OCLExpression<EClassifier> enumLiteralExp = super.enumLiteralExpCS(enumLiteralExpCS, env);
		checkAndSetAst((ICSTEnvironment) env, enumLiteralExpCS.getPathNameCS(), enumLiteralExp);
		checkAndSetAst((ICSTEnvironment) env, enumLiteralExpCS.getSimpleNameCS(), enumLiteralExp);
		return enumLiteralExp;
	}

	@Override
	protected OperationCallExp<EClassifier, EOperation> genOperationCallExp(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env, OperationCallExpCS operationCallExpCS, String rule, String operName, OCLExpression<EClassifier> source, EClassifier ownerType, List<OCLExpression<EClassifier>> args) {
    	OperationCallExp<EClassifier, EOperation> opCall = super.genOperationCallExp(env, operationCallExpCS, rule, operName, source, ownerType, args);
    	// FIXME Workaround for Bugzilla 213886
    	if ((source != null) && (source.getType() == getStandardLibrary().getString()) && "+".equals(operName))
    		opCall.setOperationCode(OCLStandardLibraryUtil.getOperationCode("concat"));
    	return opCall;
	}

	@Override
	protected EClassifier getBagType(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EClassifier elementType) {
		EClassifier typeType = super.getBagType(cstNode, env, elementType);
		if ((typeType != null) && (((ICSTEnvironment)env).getASTMapping(typeType) == null))
			((ICSTEnvironment)env).initASTMapping(typeType, cstNode);
		return typeType;
	}

	public Monitor getMonitor() { return monitor; }

	@Override
	protected EClassifier getOrderedSetType(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EClassifier elementType) {
		EClassifier orderedSetType = super.getOrderedSetType(cstNode, env, elementType);
		if ((orderedSetType != null) && (((ICSTEnvironment)env).getASTMapping(orderedSetType) == null))
			((ICSTEnvironment)env).initASTMapping(orderedSetType, cstNode);
		return orderedSetType;
	}

	@Override
	protected EClassifier getSequenceType(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EClassifier elementType) {
		EClassifier sequenceType = super.getSequenceType(cstNode, env, elementType);
		if ((sequenceType != null) && (((ICSTEnvironment)env).getASTMapping(sequenceType) == null))
			((ICSTEnvironment)env).initASTMapping(sequenceType, cstNode);
		return sequenceType;
	}

	@Override
	protected EClassifier getSetType(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EClassifier elementType) {
		EClassifier setType = super.getSetType(cstNode, env, elementType);
		if ((setType != null) && (((ICSTEnvironment)env).getASTMapping(setType) == null))
			((ICSTEnvironment)env).initASTMapping(setType, cstNode);
		return setType;
	}

	@Override
	protected EClassifier getTupleType(
			CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EList<? extends TypedElement<EClassifier>> parts) {
		// TODO Auto-generated method stub
		return super.getTupleType(cstNode, env, parts);
	}

	@Override
	protected EClassifier getTypeType(CSTNode cstNode, Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env, EClassifier type) {
		if (type instanceof Transformation)
			return type;
		EClassifier typeType = super.getTypeType(cstNode, env, type);
		if ((typeType != null) && (((ICSTEnvironment)env).getASTMapping(typeType) == null))
			((ICSTEnvironment)env).initASTMapping(typeType, cstNode);
		return typeType;
	}

	protected String identifierCS(IdentifierCS identifierCS) {
		return identifierCS != null ? identifierCS.getValue() : null;
	}

	protected boolean isCancelled() {
		return monitor != null ? monitor.isCancelled() : false;
	}

	/**
	 * Overridden to provided a nested scope for nested variables.
	 */
	@Override
	protected IterateExp<EClassifier, EParameter> iterateExpCS(IterateExpCS iterateExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		IterateExp<EClassifier, EParameter> iterateExp = super.iterateExpCS(iterateExpCS, createdNestedEnvironment(iterateExpCS, env));
		checkAndSetAst((ICSTEnvironment) env, iterateExpCS.getSimpleNameCS(), iterateExp);
		return iterateExp;
	}

	/**
	 * Overridden to provided a nested scope for nested variables.
	 */
	@Override
	protected IteratorExp<EClassifier, EParameter> iteratorExpCS(IteratorExpCS iteratorExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		IteratorExp<EClassifier, EParameter> iteratorExp = super.iteratorExpCS(iteratorExpCS, createdNestedEnvironment(iteratorExpCS, env));
		checkAndSetAst((ICSTEnvironment) env, iteratorExpCS.getSimpleNameCS(), iteratorExp);
		return iteratorExp;
	}

	/**
	 * Overridden to provided a nested scope for nested variables.
	 */
	@Override
	protected LetExp<EClassifier, EParameter> letExpCS(LetExpCS letExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		return super.letExpCS(letExpCS, createdNestedEnvironment(letExpCS, env));
	}

	@SuppressWarnings("unchecked") @Override @Deprecated
	protected EClassifier lookupClassifier(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			List<String> className) {
		return lookupClassifier(cstNode, (E)env, className);
	}

	protected EClassifier lookupClassifier(CSTNode cstNode, E env, List<String> className) {
		try {
			return env.tryLookupClassifier(className);
		} catch (LookupException e) {
			ERROR(cstNode, "lookupClassifier", env.formatLookupException(e));
			@SuppressWarnings("unchecked")
			List<EClassifier> matches = (List<EClassifier>) e.getAmbiguousMatches();
			Collections.sort(matches, new Comparator<EClassifier>()	// Establish a deterministic order for predictable unit tests
			{
				public int compare(EClassifier o1, EClassifier o2) {
					String n1 = String.valueOf(EcoreUtil.getURI(o1));
					String n2 = String.valueOf(EcoreUtil.getURI(o2));
					return n1.compareTo(n2);
				}
			});
			return matches.isEmpty() ? env.getUnresolvedEnvironment().getUnresolvedEClass(className) : matches.get(0);
		}
	}
	
	@SuppressWarnings("unchecked") @Override @Deprecated
	protected EOperation lookupOperation(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EClassifier owner, String name, List<? extends TypedElement<EClassifier>> args) {
		return lookupOperation(cstNode,(E)env, owner, name, args);
	}
	
	protected EOperation lookupOperation(CSTNode cstNode, E env, EClassifier owner, String name,
			List<? extends TypedElement<EClassifier>> args) {
		try {
			return env.tryLookupOperation(owner, name, args);
		} catch (LookupException e) {
			ERROR(cstNode, "lookupOperation", env.formatLookupException(e));
			List<?> matches = e.getAmbiguousMatches();
			return matches.isEmpty() ? env.getUnresolvedEnvironment().getUnresolvedEOperation(owner, name) : (EOperation) matches.get(0);
		}
	}

	@SuppressWarnings("unchecked") @Override @Deprecated
	protected EStructuralFeature lookupProperty(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			EClassifier owner, String name) {
		return lookupProperty(cstNode, (E)env, owner, name);
	}

	protected EStructuralFeature lookupProperty(CSTNode cstNode, E env, EClassifier owner, String name) {
		try {
			return env.tryLookupProperty(owner, name);
		} catch (LookupException e) {
			ERROR(cstNode, "lookupProperty", env.formatLookupException(e));
			List<?> matches = e.getAmbiguousMatches();
			return matches.isEmpty() ? env.getUnresolvedEnvironment().getUnresolvedEReference(owner, name) : (EStructuralFeature) matches.get(0);
		}
	}

	protected EClass resolveClass(E env, String rule, TypeCS typeCS) {		
		E typeEnv = env; //createTypeEnvironment(env, typeCS);
		EClassifier referredClassifier = typeCS(typeCS, typeEnv);
		if (referredClassifier instanceof EClass) {
			if (env.isResolved(referredClassifier))
				return (EClass) referredClassifier;
		}
		else if (referredClassifier == null)
			ERROR(typeCS, rule, "Missing class");
		else {
			if ((referredClassifier != env.getOCLStandardLibrary().getOclVoid())
			 && (env.isResolved(referredClassifier)))
				ERROR(typeCS, rule, "Non Class type '" + formatType(referredClassifier) + "'");
		}
		return env.getUnresolvedEnvironment().getUnresolvedEClass((EClassifier)null);	// FIXME better name
	}

	protected EClassifier resolveClassifier(E env, String rule, TypeCS typeCS) {
		E typeEnv = env; //createTypeEnvironment(env, typeCS);
		EClassifier referredClassifier = typeCS(typeCS, typeEnv);
		if (referredClassifier != null) {
//			typeCS.setAst(referredClassifier);
			if (!(referredClassifier instanceof CollectionType))
				return referredClassifier;
			if (((CollectionType)referredClassifier).getElementType() == null) {
				ERROR(typeCS, "typeCS", "Undefined element type");
				((CollectionType)referredClassifier).setElementType(env.getUnresolvedEnvironment().getUnresolvedEClass(referredClassifier));
			}
			return referredClassifier;
		}
		StringBuffer s = new StringBuffer();
		if (typeCS instanceof PrimitiveTypeCS) {
			String name = ((PrimitiveTypeCS)typeCS).getValue();
			s.append("Undefined primitive type '" + name + "'");
			ERROR(typeCS, rule, s.toString());
			return env.getUnresolvedEnvironment().getUnresolvedEDataType(null, name);
		} else if (typeCS instanceof PathNameCS) {
			s.append("Undefined type '");
			boolean isFirst = true;
			EList<String> names = ((PathNameCS)typeCS).getSequenceOfNames();
			for (String name : names) {
				if (!isFirst)
					s.append("::");
				s.append(name);
				isFirst = false;
			}
			s.append("'");
			ERROR(typeCS, rule, s.toString());
			return env.getUnresolvedEnvironment().getUnresolvedEClass(names);
		} else if (typeCS instanceof CollectionTypeCS) {
			s.append("Undefined collection type '" + ((CollectionTypeCS)typeCS).getCollectionTypeIdentifier() + "'");
			ERROR(typeCS, rule, s.toString());
			return env.getUnresolvedEnvironment().getUnresolvedEClass((EClassifier)null);	// FIXME better name
		} else if (typeCS instanceof TupleTypeCS) {
			s.append("Undefined tuple type");
			ERROR(typeCS, rule, s.toString());
			return env.getUnresolvedEnvironment().getUnresolvedEClass((EClassifier)null);	// FIXME better name
		} else {
			s.append("Undefined ");
			ERROR(typeCS, rule, s.toString());
			return env.getUnresolvedEnvironment().getUnresolvedEClass((EClassifier)null);
		}
	}

	protected EDataType resolveDataType(E env, String rule, TypeCS typeCS) {		
		E typeEnv = env; //createTypeEnvironment(env, typeCS);
		EClassifier referredClassifier = typeCS(typeCS, typeEnv);
		if (referredClassifier instanceof EDataType)
			return (EDataType) referredClassifier;
		if (referredClassifier != null) {
			if (env.isResolved(referredClassifier))
				ERROR(typeCS, rule, "Non Primitive type '" + formatType(referredClassifier) + "'");
			return env.getUnresolvedEnvironment().getUnresolvedEDataType(referredClassifier.getEPackage(), referredClassifier.getName());
		}
		ERROR(typeCS, rule, "Missing primitive type");
		return env.getUnresolvedEnvironment().getUnresolvedEDataType(null, null);
	}
	
	protected EStructuralFeature resolveForwardProperty(E env, EClass parentType, String rule, IdentifiedCS propertyIdCS) {
		if (parentType == null)
			return null;
		String propertyName = identifierCS(propertyIdCS.getIdentifier());
		return MoreEcoreForeignMethods.getEStructuralFeature(parentType, propertyName);
	}
	
	protected EReference resolveReverseProperty(E env, EClass parentType, String rule, IdentifiedCS propertyIdCS) {
		if (parentType == null)
			return null;
		EReference referredProperty;
		String propertyName = identifierCS(propertyIdCS.getIdentifier());
		try {
			referredProperty = env.tryLookupOppositeProperty(parentType, propertyName);
	        if ((referredProperty == null) && isEscaped(propertyName)) {
	            // try the unescaped name
	        	referredProperty = env.tryLookupOppositeProperty(parentType, unescape(propertyName));
	        }
		} catch (LookupException e) {
			env.analyzerError(env.formatLookupException(e), "lookup", propertyIdCS);
			List<?> ambiguousMatches = e.getAmbiguousMatches();
			if (ambiguousMatches.size() > 0)
				referredProperty = (EReference) ambiguousMatches.get(0);
			else
				referredProperty = env.getUnresolvedEnvironment().getUnresolvedEReference(parentType, propertyName);
		}
		return referredProperty;
	}
	
	protected EStructuralFeature resolveUnresolvedProperty(E env, EClass parentType, String rule, IdentifiedCS propertyIdCS) {
		if (parentType == null)
			return null;
		String propertyName = identifierCS(propertyIdCS.getIdentifier());
		if (env.isResolved(parentType))
			ERROR(propertyIdCS, rule, "No '" + formatString(propertyName) + "' property in '" + formatName(parentType) + "'");
		return env.getUnresolvedEnvironment().getUnresolvedEReference(parentType, propertyName);
	}

	@Override
	protected OCLExpression<EClassifier> modelPropertyCallExpCS(FeatureCallExpCS modelPropertyCallExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		OCLExpression<EClassifier> featureCallExp = super.modelPropertyCallExpCS(modelPropertyCallExpCS, env);
		checkAndSetAst((ICSTEnvironment) env, modelPropertyCallExpCS, featureCallExp);
		return featureCallExp;
	}

	@Override
	protected OCLExpression<EClassifier> operationCallExpCS(OperationCallExpCS operationCallExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		OCLExpression<EClassifier> expr = super.operationCallExpCS(operationCallExpCS, env);
		if (expr instanceof OperationCallExp) {
			@SuppressWarnings("unchecked")
			OperationCallExp<EClassifier, EStructuralFeature> operationCallExp = (OperationCallExp<EClassifier, EStructuralFeature>)expr;
			checkAndSetAst((ICSTEnvironment) env, operationCallExpCS.getSimpleNameCS(), operationCallExp.getReferredOperation());
		} else
			checkAndSetAst((ICSTEnvironment) env, operationCallExpCS.getSimpleNameCS(), expr);
		return expr;
	}

	@Override		// FIXME Workaround Bug 226083
	protected OCLExpression<EClassifier> simpleNameCS(SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			OCLExpression<EClassifier> source) {
		if (source instanceof InvalidLiteralExp)
			return source;
		ICSTNodeEnvironment nestedEnv =  ((ICSTNodeEnvironment)env).createNestedEnvironment(simpleNameCS);
		try {
			OCLExpression<EClassifier> expr = super.simpleNameCS(simpleNameCS, nestedEnv, source);			
			checkAndSetAst((ICSTEnvironment) env, simpleNameCS, expr);
			return expr;
		} catch (Exception e) {		// Workaround bug 241421
			ERROR(simpleNameCS, "simpleNameCS", e.getMessage());
			return createDummyInvalidLiteralExp(env, simpleNameCS);
		}
	}

	@Override
	protected PropertyCallExp<EClassifier, EStructuralFeature> simplePropertyName(SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			OCLExpression<EClassifier> source, EClassifier owner,String simpleName) {
		PropertyCallExp<EClassifier, EStructuralFeature> propertyCallExp = super.simplePropertyName(simpleNameCS, env, source, owner, simpleName);
		if (propertyCallExp != null) {
			simpleNameCS.setAst(null);		// Fixup bad OCL init
			checkAndSetAst((ICSTEnvironment) env, simpleNameCS, propertyCallExp.getReferredProperty());
		}
		return propertyCallExp;
	}

	@Override
	protected EClassifier typeCS(TypeCS typeCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		EClassifier type = super.typeCS(typeCS, env);
		checkAndSetAst((ICSTEnvironment) env, typeCS, type);
		return type;
	}

	@Override
	protected Variable<EClassifier, EParameter> variableDeclarationCS(VariableCS variableDeclarationCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			boolean addToEnvironment) {
		Variable<EClassifier, EParameter> variable = super.variableDeclarationCS(variableDeclarationCS, env, addToEnvironment);
//		variableDeclarationCS.setAst(variable);
		return variable;
	}

	@Override
	protected OCLExpression<EClassifier> variableExpCS(VariableExpCS variableExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		OCLExpression<EClassifier> variableExp = super.variableExpCS(variableExpCS, env);
		checkAndSetAst((ICSTEnvironment) env, variableExpCS, variableExp);
		return variableExp;
	}
}
