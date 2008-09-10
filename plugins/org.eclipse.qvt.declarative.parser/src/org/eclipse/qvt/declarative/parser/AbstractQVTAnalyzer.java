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

import java.util.Collection;
import java.util.List;

import lpg.lpgjavaruntime.Monitor;

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
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.cst.CollectionTypeCS;
import org.eclipse.ocl.cst.IterateExpCS;
import org.eclipse.ocl.cst.IteratorExpCS;
import org.eclipse.ocl.cst.LetExpCS;
import org.eclipse.ocl.cst.OperationCallExpCS;
import org.eclipse.ocl.cst.PathNameCS;
import org.eclipse.ocl.cst.PrimitiveTypeCS;
import org.eclipse.ocl.cst.SimpleNameCS;
import org.eclipse.ocl.cst.TupleTypeCS;
import org.eclipse.ocl.cst.TypeCS;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.expressions.InvalidLiteralExp;
import org.eclipse.ocl.expressions.IterateExp;
import org.eclipse.ocl.expressions.IteratorExp;
import org.eclipse.ocl.expressions.LetExp;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.OperationCallExp;
import org.eclipse.ocl.lpg.AbstractParser;
import org.eclipse.ocl.parser.AbstractOCLAnalyzer;
import org.eclipse.ocl.parser.AbstractOCLParser;
import org.eclipse.ocl.util.OCLStandardLibraryUtil;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.modelregistry.environment.ModelResolver;
import org.eclipse.qvt.declarative.parser.environment.IFileAnalyzer;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvt.environment.IQVTEnvironment;
import org.eclipse.qvt.declarative.parser.qvt.environment.MoreEcoreForeignMethods;
import org.eclipse.qvt.declarative.parser.utils.OCLUtils;

public abstract class AbstractQVTAnalyzer<E extends IQVTEnvironment> extends AbstractOCLAnalyzer<
	EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
	EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> implements IFileAnalyzer
{	
	private ModelResolver resolver = null;
	private Monitor monitor;
		
	public AbstractQVTAnalyzer(AbstractOCLParser parser, Monitor monitor) {
		super(parser);
		this.monitor = monitor;
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
	
	protected abstract E createdNestedEnvironment(CSTNode cstNode,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env);
	
    @Override
	protected OperationCallExp<EClassifier, EOperation> genOperationCallExp(Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env, OperationCallExpCS operationCallExpCS, String rule, String operName, OCLExpression<EClassifier> source, EClassifier ownerType, List<OCLExpression<EClassifier>> args) {
    	OperationCallExp<EClassifier, EOperation> opCall = super.genOperationCallExp(env, operationCallExpCS, rule, operName, source, ownerType, args);
    	// FIXME Workaround for Bugzilla 213886
    	if ((source != null) && (source.getType() == getStandardLibrary().getString()) && "+".equals(operName))
    		opCall.setOperationCode(OCLStandardLibraryUtil.getOperationCode("concat"));
    	return opCall;
	}

	public Monitor getMonitor() { return monitor; }
    public ModelResolver getResolver() { return resolver; }

	@Override
	protected EClassifier getTypeType(CSTNode cstNode, Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env, EClassifier type) {
		if (type instanceof Transformation)
			return type;
		return super.getTypeType(cstNode, env, type);
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
		return super.iterateExpCS(iterateExpCS, createdNestedEnvironment(iterateExpCS, env));
	}

	/**
	 * Overridden to provided a nested scope for nested variables.
	 */
	@Override
	protected IteratorExp<EClassifier, EParameter> iteratorExpCS(IteratorExpCS iteratorExpCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env) {
		return super.iteratorExpCS(iteratorExpCS, createdNestedEnvironment(iteratorExpCS, env));
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
			List<?> matches = e.getAmbiguousMatches();
			return matches.isEmpty() ? env.getUnresolvedClassifier() : (EClassifier) matches.get(0);
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
			return matches.isEmpty() ? env.getUnresolvedOperation() : (EOperation) matches.get(0);
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
			return matches.isEmpty() ? env.getUnresolvedProperty() : (EStructuralFeature) matches.get(0);
		}
	}

	public abstract Collection<? extends EObject> parseCSTtoAST(CSTNode cstNode, URI sourceURI);
    
	public Collection<? extends EObject> parseToAST(URI sourceURI) {
		CSTNode cstNode = parseToCST();
        if (cstNode == null)
 			return null;
		if (isCancelled())
			return null;
		return parseCSTtoAST(cstNode, sourceURI);
	}

	public CSTNode parseToCST() {
		AbstractParser parser = getParser();
		if (isCancelled())
			return null;
		parser.getLexer().lexToTokens(parser);
		if (isCancelled())
			return null;
		return parser.parseTokensToCST();
	}

	protected EClass resolveClass(E env, String rule, TypeCS typeCS) {		
		E typeEnv = env; //createTypeEnvironment(env, typeCS);
		EClassifier referredClassifier = typeCS(typeCS, typeEnv);
		if (referredClassifier instanceof EClass) {
			if (referredClassifier != env.getUnresolvedClassifier())
				return (EClass) referredClassifier;
		}
		else if (referredClassifier == null)
			ERROR(typeCS, rule, "Missing class");
		else {
			if ((referredClassifier != env.getOCLStandardLibrary().getOclVoid())
			 && (referredClassifier != env.getUnresolvedClassifier()))
				ERROR(typeCS, rule, "Non Class type '" + formatType(referredClassifier) + "'");
		}
		return env.getUnresolvedClass();
	}

	protected EClassifier resolveClassifier(E env, String rule, TypeCS typeCS) {
		E typeEnv = env; //createTypeEnvironment(env, typeCS);
		EClassifier referredClassifier = typeCS(typeCS, typeEnv);
		if (referredClassifier != null) {
			if (!(referredClassifier instanceof CollectionType))
				return referredClassifier;
			if (((CollectionType)referredClassifier).getElementType() == null) {
				ERROR(typeCS, "typeCS", "Undefined element type");
				((CollectionType)referredClassifier).setElementType(env.getUnresolvedClassifier());
			}
			return referredClassifier;
		}
		else {
			StringBuffer s = new StringBuffer();
			s.append("Undefined ");
			if (typeCS instanceof PrimitiveTypeCS) {
				s.append("primitive type '" + ((PrimitiveTypeCS)typeCS).getValue() + "'");
			} else if (typeCS instanceof PathNameCS) {
				s.append("type '");
				boolean isFirst = true;
				for (String name : ((PathNameCS)typeCS).getSequenceOfNames()) {
					if (!isFirst)
						s.append("::");
					s.append(name);
					isFirst = false;
				}
				s.append("'");
			} else if (typeCS instanceof CollectionTypeCS) {
				s.append("collection type '" + ((CollectionTypeCS)typeCS).getCollectionTypeIdentifier() + "'");
			} else if (typeCS instanceof TupleTypeCS) {
				s.append("tuple type");
			}
			ERROR(typeCS, rule, s.toString());
		}
		return env.getUnresolvedClassifier();
	}

	protected EDataType resolveDataType(E env, String rule, TypeCS typeCS) {		
		E typeEnv = env; //createTypeEnvironment(env, typeCS);
		EClassifier referredClassifier = typeCS(typeCS, typeEnv);
		if (referredClassifier instanceof EDataType)
			return (EDataType) referredClassifier;
		else if (referredClassifier != null) {
			if (referredClassifier != env.getUnresolvedClassifier())
				ERROR(typeCS, rule, "Non Primitive type '" + formatType(referredClassifier) + "'");
		}
		else
			ERROR(typeCS, rule, "Missing primitive type");
		return env.getUnresolvedDataType();
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
				referredProperty = env.getUnresolvedReference();
		}
		return referredProperty;
	}
	
	protected EStructuralFeature resolveUnresolvedProperty(E env, EClass parentType, String rule, IdentifiedCS propertyIdCS) {
		if (parentType == null)
			return null;
		String propertyName = identifierCS(propertyIdCS.getIdentifier());
		if (!OCLUtils.isUnresolved(parentType))
			ERROR(propertyIdCS, rule, "No '" + formatString(propertyName) + "' property in '" + formatName(parentType) + "'");
		return env.getUnresolvedProperty();
	}

    public void setResolver(ModelResolver resolver) {
		this.resolver = resolver;
	}

	@Override		// FIXME Workaround Bug 226083
	protected OCLExpression<EClassifier> simpleNameCS(SimpleNameCS simpleNameCS,
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env,
			OCLExpression<EClassifier> source) {
		if (source instanceof InvalidLiteralExp)
			return source;
		@SuppressWarnings("unchecked")
		E cstEnv = (E)env;
		CSTNode savedNode = cstEnv.setCSTNode(simpleNameCS);
		try {
			return super.simpleNameCS(simpleNameCS, env, source);
		} catch (Exception e) {		// Workaround bug 241421
			ERROR(simpleNameCS, "simpleNameCS", e.getMessage());
			InvalidLiteralExp<EClassifier> invalidLiteralExp = createDummyInvalidLiteralExp();	// FIXME simplify when Bug 242153 fix visible
			initASTMapping(env, invalidLiteralExp, simpleNameCS);
			return invalidLiteralExp;
		} finally {
			cstEnv.setCSTNode(savedNode);
		}
	}
}
