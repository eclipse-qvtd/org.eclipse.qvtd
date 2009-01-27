/**
 * <copyright>
 * 
 * Copyright (c) 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: CollectionTemplateExpOperations.java,v 1.4 2009/01/27 21:17:48 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.operations;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.DomainOperations;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;

public class CollectionTemplateExpOperations extends TemplateExpOperations
{
	public static CollectionTemplateExpOperations INSTANCE = new CollectionTemplateExpOperations();

	/**
	 * Validates the EveryEnforceableItemIsEnforced constraint of '<em>Collection Template Exp</em>'.
	 *
	public boolean checkEveryEnforceableItemIsEnforced(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EObject container = collectionTemplateExp.eContainer();
		if (!(container instanceof PropertyTemplateItem))
			return true;
		Domain domain = getDomain(collectionTemplateExp);
		if (domain == null)
			return true;		// DomainExists failure
		if (!domain.isIsEnforceable())
			return true;
		EStructuralFeature feature = ((PropertyTemplateItem)container).getReferredProperty();
		if (feature == null)
			return true;		// Multiplicity failure
		if (feature.getLowerBound() <= collectionTemplateExp.getMember().size())
			return true;
		if (feature.getDefaultValue() != null)
			return true;
		Object[] messageSubstitutions = new Object[] {getObjectLabel(container, context), feature.getLowerBound() };
		appendWarning(diagnostics, collectionTemplateExp, QVTTemplateMessages._UI_CollectionTemplateExp_EnforceableMemberIsNotEnforced, messageSubstitutions);
		return false;
	} */

	/**
	 * Validates the EveryMemberExpressionVariableIsBoundByPattern constraint of '<em>Collection Template Exp</em>'.
	 */
	public boolean checkEveryMemberExpressionVariableIsBoundByPattern(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = getPattern(collectionTemplateExp);
		if (pattern == null)
			return true;		// PatternExists error
		List<Variable> bindsTo = pattern.getBindsTo();
		boolean allOk = true;
		for (OCLExpression member : collectionTemplateExp.getMember()) {
			for (TreeIterator<EObject> i = member.eAllContents(); i.hasNext(); ) {
				EObject eObject = i.next();
				if (eObject instanceof VariableExp) {
					VariableExp variableReference = (VariableExp) eObject;
					Variable variable = (Variable) variableReference.getReferredVariable();
					if (variable == null)
						continue;
					if (isSpecialVariable(variable))
						continue;
					if (locallyDefined(variableReference))
						continue;
					if (!bindsTo.contains(variable)) {
						Object[] messageSubstitutions = new Object[] { getObjectLabel(variable, context), getObjectLabel(pattern, context) };
						appendError(diagnostics, variableReference, QVTTemplateMessages._UI_CollectionTemplateExp_MemberExpressionVariableIsNotBoundByPattern, messageSubstitutions);
						allOk = false;
					}
				}
			}
		}
		return allOk;
	}

	/**
	 * Validates the EveryMemberTypeMatchesElementType constraint of '<em>Collection Template Exp</em>'.
	 */
	public boolean checkEveryMemberTypeMatchesElementType(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		CollectionType collectionType = collectionTemplateExp.getReferredCollectionType();
		if (collectionType == null)
			return true;		// Multiplicity error
		EClassifier elementType = collectionType.getElementType();
		if (elementType == null)
			return true;		// Multiplicity error
		boolean allOk = true;
		for (OCLExpression member : collectionTemplateExp.getMember()) {
			if (isSpecialVariableReference(member))
				continue;
			EClassifier memberType = member.getType();
			if ((memberType != null) && !assignableFrom(elementType, memberType)) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(elementType, context), getObjectLabel(memberType, context) };
				appendError(diagnostics, collectionTemplateExp, QVTTemplateMessages._UI_CollectionTemplateExp_MemberTypeDoesNotMatchElementType, messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	}

	/**
	 * Validates the MemberCountSatifiesLowerBound constraint of '<em>Collection Template Exp</em>'.
	 */
	public boolean checkMemberCountSatifiesLowerBound(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EObject container = collectionTemplateExp.eContainer();
		if (!(container instanceof PropertyTemplateItem))
			return true;
		int memberCount = collectionTemplateExp.getMember().size();
		if ((memberCount == 0) && (collectionTemplateExp.getRest() == null))
			return true;
		EStructuralFeature feature = ((PropertyTemplateItem)container).getReferredProperty();
		if (feature == null)
			return true;		// Multiplicity error
		int lowerBound = feature.getLowerBound();
		if (memberCount >= lowerBound)
			return true;
		Object[] messageSubstitutions = new Object[] { memberCount, lowerBound, getObjectLabel(feature, context) };
		appendError(diagnostics, collectionTemplateExp, QVTTemplateMessages._UI_CollectionTemplateExp_MemberCountDoesNotSatisfyLowerBound, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the ReferredCollectionElementTypeIsDeclaredByDomain constraint of '<em>Collection Template Exp</em>'.
	 */
	public boolean checkReferredCollectionElementTypeIsDeclaredByDomain(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Domain domain = getDomain(collectionTemplateExp);
		if (domain == null)
			return true;		// DomainExists error
		CollectionType collectionType = collectionTemplateExp.getReferredCollectionType();
		if (collectionType == null)
			return true;		// Multiplicity error
		EClassifier transitiveElementType = getTransitiveElementType(collectionType);
		if (transitiveElementType == null)
			return true;		// Multiplicity error
		if (DomainOperations.INSTANCE.declaresType(domain, transitiveElementType))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(transitiveElementType, context), getObjectLabel(domain, context) };
		appendError(diagnostics, collectionTemplateExp, QVTTemplateMessages._UI_CollectionTemplateExp_TypeIsNotDeclaredByDomain, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the RestTypeMatchesCollectionType constraint of '<em>Collection Template Exp</em>'.
	 */
	public boolean checkRestTypeMatchesCollectionType(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Variable rest = collectionTemplateExp.getRest();
		if (rest == null)
			return true;
		if (isSpecialVariable(rest))
			return true;
		EClassifier restType = rest.getType();
		if (restType == null)
			return true;		// Multiplicity error
		CollectionType collectionType = collectionTemplateExp.getReferredCollectionType();
		if (collectionType == null)
			return true;		// Multiplicity error
		if (assignableFrom(collectionType, restType))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(collectionType, context), getObjectLabel(restType, context) };
		appendError(diagnostics, collectionTemplateExp, QVTTemplateMessages._UI_CollectionTemplateExp_RestTypeDoesNotMatchCollectionType, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the RestVariableIsBoundByPattern constraint of '<em>Collection Template Exp</em>'.
	 */
	public boolean checkRestVariableIsBoundByPattern(CollectionTemplateExp collectionTemplateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Variable rest = collectionTemplateExp.getRest();
		if (rest == null)
			return true;
		if (isSpecialVariable(rest))
			return true;
		Pattern pattern = getPattern(collectionTemplateExp);
		if (pattern == null)
			return true;		// PatternExists error
		if (pattern.getBindsTo().contains(rest))
			return true;
		Object[] messageSubstitutions = new Object[] { rest.getName(), getObjectLabel(pattern, context) };
		appendError(diagnostics, collectionTemplateExp, QVTTemplateMessages._UI_CollectionTemplateExp_RestVariableIsNotBoundByPattern, messageSubstitutions);
		return false;
	}
}