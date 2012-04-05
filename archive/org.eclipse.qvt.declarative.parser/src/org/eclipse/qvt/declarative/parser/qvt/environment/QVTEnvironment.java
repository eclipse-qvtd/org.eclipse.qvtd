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
package org.eclipse.qvt.declarative.parser.qvt.environment;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.xmi.impl.EMOFExtendedMetaData;
import org.eclipse.ocl.LookupException;
import org.eclipse.ocl.cst.CSTNode;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.OperationCallExp;
import org.eclipse.ocl.ecore.TupleType;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.internal.EcoreForeignMethods;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.parser.environment.CSTChildEnvironment;
import org.eclipse.qvt.declarative.parser.plugin.QVTParserPlugin;
import org.eclipse.qvt.declarative.parser.utils.OCLUtils;

/**
 * QVTEnvironment revises the EcoreEnvironment behaviour to support operation in an
 * a deep environment hierarchy, in which lookups are presumed to be resolved
 * by an parent environment and the results may be ambiguous. 
 * <p>
 * Look-ups are performed by default using the parent implementation. A failed
 * parent look-up is then delegated to the derived OCL look-up.
 * <p>
 * This provides a default semantics that may often be useful. It is expected
 * that derived environments will re-implement whenever another semantics is needed.
 * <br>
 * @param <E> The derived IQVTEnvironment from which all environments derive
 * @param <P> The derived E of the parent environment
 */
@SuppressWarnings("restriction")		// FIXME awaiting Bugzilla 182994
public abstract class QVTEnvironment<E extends IQVTNodeEnvironment, P extends IQVTNodeEnvironment, AST extends Notifier, CST extends CSTNode> extends CSTChildEnvironment<E,P,AST,CST> implements IQVTEnvironment
{
	protected QVTEnvironment(P parent, AST astNode, CST cstNode) {
		super(parent, astNode, cstNode);
	}
	
	@Override protected void addedVariable(String name, org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> variable, boolean isExplicit) {
		if (variable == null)
			return;
		if (!(variable instanceof Variable))
			QVTParserPlugin.logError("non-derived Variable in " + getClass().getName() + ".addedVariable", null);
	}

	public List<Function> findMatchingQueries(Transformation transformation, String queryName, List<OCLExpression> args) {
		List<Function> queries = new ArrayList<Function>();
		int iMax = args.size();
		for (EOperation eOperation : transformation.getEAllOperations()) {
			if (!(eOperation instanceof Function))
				continue;
			if (!queryName.equals(eOperation.getName()))
				continue;
			List<EParameter> params = eOperation.getEParameters();
			if (params.size() != iMax)
				continue;
			int i = 0;
			for ( ; i < iMax; i++) {
				OCLExpression arg = args.get(i);
				EParameter param = params.get(i);
				EClassifier paramType = param.getEType();
				if (!isAssignableTo(paramType, arg)) 
					break; 
			}
			if (i < iMax)
				continue;
			queries.add((Function) eOperation); 
		}
		return queries;
	}

	public Function findMatchingQuery(Transformation transformation, String name, List<FunctionParameter> parameters) {
		Function match = null;
		int iMax = parameters.size();
		for (EOperation candidateOperation : transformation.getEOperations()) {
			if (!(candidateOperation instanceof Function))
				continue;
			if (!name.equals(candidateOperation.getName()))
				continue;
			List<EParameter> params = candidateOperation.getEParameters();
			if (params.size() != iMax)
				continue;
			int i = 0;
			for ( ; i < iMax; i++) {
				EParameter candidateParameter = candidateOperation.getEParameters().get(i);
				EParameter queryParameter = parameters.get(i);
				EClassifier candidateType = candidateParameter.getEType();
				EClassifier queryType = queryParameter.getEType();
				if (candidateType != queryType) 
					break; 
			}
			if (i < iMax)
				continue;
			if (match != null)
				QVTParserPlugin.logError("Duplicate match for query '" + formatName(match) + "'", null);
			match = (Function) candidateOperation;
		}
		return match;
	}

	public String getModelName(EObject object) {
		return getParentEnvironment().getModelName(object);
	}	
	
	/**
	 * Add any classifiers that can be located in ePackage corresponding to
	 * names to resolutions.
	 * <p>
	 * 
	 * 
	 * @param resolutions Set to receive any result values
	 * @param currentPackage package within which to resolve names
	 * @param names list of package-names and classifier-name to find
	 * @param hasScope true for match within ePackage, false for nested packages too
	 */
	protected boolean getPackagedClassifiers(List<EClassifier> resolutions, EPackage currentPackage, List<String> names, boolean hasScope) {
		int namesSize = names.size();
		if (namesSize <= 0)
			return false;									// Need at least classifierName
		else if (namesSize == 1) {							// Just a classifier-name
			String classifierName = names.get(0);
			EClassifier eClassifier = getPackagedClassifier(currentPackage, classifierName);
			if (eClassifier != null) {
				if (!resolutions.contains(eClassifier))
					resolutions.add(eClassifier);
				return true;								// Found explicit classifierName
			}
			if (hasScope)									// Got scope so cannot try nested packages
				return false;
		}
		else {												// Package-qualified classifier-name
			String packageName = names.get(0);
			for (EPackage searchPackage = currentPackage; searchPackage != null; searchPackage = searchPackage.getESuperPackage()) {
				EPackage ePackage = EcoreForeignMethods.getESubpackage(searchPackage, packageName);
				if (ePackage != null) {
					if (getPackagedClassifiers(resolutions, ePackage, names.subList(1, namesSize), true))
						return true;						// Found first packageName
				}
				if (hasScope)								// Got scope so cannot try surrounding packages
					return false;
				if (EcoreForeignMethods.isNamed(packageName, currentPackage)) {
					if (getPackagedClassifiers(resolutions, currentPackage, names.subList(1, namesSize), true))
						return true;						// Found first packageName					
				}					
			}
		}
		boolean found = false;
		for (EPackage ePackage : currentPackage.getESubpackages())
			if (getPackagedClassifiers(resolutions, ePackage, names, false))
				found = true;
		return found;
	}

	protected String getOppositeName(EReference reference) {
		EReference eOpposite = reference.getEOpposite();
		if (eOpposite != null)
			return eOpposite.getName();
		EAnnotation annotation = reference.getEAnnotation(EMOFExtendedMetaData.EMOF_PROPERTY_OPPOSITE_ROLE_NAME_ANNOTATION_SOURCE);
		if (annotation != null)
			return annotation.getDetails().get(EMOFExtendedMetaData.EMOF_COMMENT_BODY);
		return initialLower(reference.getEContainingClass());
	}

	protected EClassifier getPackagedClassifier(EPackage currentPackage, String classifierName) {
		if ((currentPackage instanceof EClassifier) && classifierName.equals(currentPackage.getName()))
			return (EClassifier) currentPackage;		// Use of Transformation which is EPackage and EClass
		else
			return EcoreForeignMethods.getEClassifier(currentPackage, classifierName);
	}

	public Transformation getTransformation() {
		return getParentEnvironment().getTransformation();
	}

	public boolean isAssignableTo(EClassifier featureType, OCLExpression oclExpression) {
		if (featureType == null)
			return false;
		if (!isResolved(featureType))
			return false;
		EClassifier expressionType = getUMLReflection().getOCLType(oclExpression.getType());
		if (expressionType == null)
			return false;
		if (!isResolved(expressionType))
			return false;
		if (featureType == expressionType)
			return true;
		else if (featureType instanceof EEnum) {
			String enumLiteralText = oclExpression.toString();
			if (enumLiteralText.length() >= 2)
				enumLiteralText = enumLiteralText.substring(1, enumLiteralText.length()-1);
			EEnumLiteral enumLiteral = ((EEnum)featureType).getEEnumLiteral(enumLiteralText);
			if (enumLiteral != null)
				return true;
		}
		else if (featureType instanceof CollectionType) {
			CollectionKind featureKind = ((CollectionType) featureType).getKind();
			EClassifier featureElementType = ((CollectionType) featureType).getElementType();
			CollectionKind expressionKind = null;
			EClassifier expressionElementType = expressionType;
			if (expressionType instanceof CollectionType) {
				expressionKind = ((CollectionType) expressionType).getKind();
				expressionElementType = ((CollectionType) expressionType).getElementType();
			}
			if (expressionElementType == null)
				return false;
			if (!isResolved(expressionElementType))
				return false;
			if (!(expressionElementType instanceof EClass))
				;
			else if (!((EClass) featureElementType).isSuperTypeOf((EClass) expressionElementType))
				;
//			else if ((expressionKind != null) && QVTrUtils.isOrdered(featureKind) && !QVTrUtils.isOrdered(expressionKind))
//				;
			else if ((expressionKind != null) && OCLUtils.isUnique(featureKind) && !OCLUtils.isUnique(expressionKind))
				;
			else
				return true;
		}
		else if (featureType instanceof EDataType) {
			;
		}
		else if (featureType instanceof TupleType) {
			;
		}
		else if (featureType instanceof EClass) {
			if (!(expressionType instanceof EClass))
				;
			else if (!((EClass) featureType).isSuperTypeOf((EClass) expressionType))
				;
			else
				return true;
		}
		else
			;
		return false;
	}

	public Transformation lookupImportedTransformation(String name) {
		return getParentEnvironment().lookupImportedTransformation(name);
	}

	@Override
	public Variable lookupImplicitSourceForOperation(String name, List<? extends TypedElement<EClassifier>> params) {
		return getParentEnvironment().lookupImplicitSourceForOperation(name, params);
	}

	@Override
	public Variable lookupImplicitSourceForProperty(String name) {
		return getParentEnvironment().lookupImplicitSourceForProperty(name);
	}
	
	@Override protected void removedVariable(String name, org.eclipse.ocl.expressions.Variable<EClassifier, EParameter> variable, boolean isExplicit) {
	}

	/**
	 * QVT classifier lookups must occur with respect to multiple context packages.
	 * The inherited behaviour must therefore be re-implemented by derived classes.
	 */
	@Override public EClassifier tryLookupClassifier(List<String> names) throws LookupException {
		return getParentEnvironment().tryLookupClassifier(names);
	}
	
	public EClassifier tryLookupClassifier(Collection<EPackage> contextPackages, List<String> names) throws LookupException {
		if (contextPackages.isEmpty())
			return null;
		List<EClassifier> resolutions = new ArrayList<EClassifier>(2);
		for (EPackage contextPackage : contextPackages)
			getPackagedClassifiers(resolutions, contextPackage, names, false);
		if (resolutions.size() <= 0)
			return null;
		if (resolutions.size() == 1)
			return resolutions.get(0);
		throw new LookupException("Ambiguous name '" + formatPath(names) + "'", resolutions);
	}
	
	public Transformation tryLookupTransformation(List<String> pathName) throws LookupException {
		return getParentEnvironment().tryLookupTransformation(pathName);
	}

	public EReference tryLookupOppositeProperty(EClass eClass, String propertyName) throws LookupException {
		return getParentEnvironment().tryLookupOppositeProperty(eClass, propertyName);
	}

	public Variable tryLookupVariable(String name) throws LookupException {
		return getParentEnvironment().tryLookupVariable(name);
	}

	@Override
	public void validatorError(String problemMessage, String problemContext, Object problemObject) {
		// FIXME Workaround for ???
		if ((problemObject instanceof OperationCallExp) && (((OperationCallExp)problemObject).getReferredOperation() instanceof Function) && problemMessage.startsWith("Null source in operation call "))
			return;
		super.validatorError(problemMessage, problemContext, problemObject);
	}
}
