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
 * $Id: RelationCallExpOperations.java,v 1.2 2009/01/14 21:02:27 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.TransformationOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;

public class RelationCallExpOperations extends AbstractQVTRelationOperations
{
	public static RelationCallExpOperations INSTANCE = new RelationCallExpOperations();

	/**
	 * Validates the EveryWhenReferredRelationArgumentTypeMatches constraint of '<em>Relation Call Exp</em>'.
	 */
	public boolean checkEveryWhenReferredRelationArgumentTypeMatches(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = getPattern(relationCallExp);
		if (pattern == null)
			return true;					// PatternExists failure
		Relation relation = getRelation(relationCallExp);
		if (relation == null)
			return true;					// RelationExists failure
		if (pattern != relation.getWhen())
			return true;
		Relation referredRelation = relationCallExp.getReferredRelation();
		if (referredRelation == null)
			return true;					// Multiplicity failure
		List<Domain> referredDomains = referredRelation.getDomain();
		int referredArgumentCount = referredDomains.size();
		int argumentCount = relationCallExp.getArgument().size();
		if (argumentCount != referredArgumentCount)
			return true;	// ReferredRelationArgumentNumberMatches
//		List<TypedModel> typedModels = referredRelation.getTransformation().getModelParameter();
//		if (typedModels.size() <  referredArgumentCount)
//			return true;	// DomainNumberMatches
//		Map<TypedModel, RelationDomain> typedModel2Domain = new HashMap<TypedModel, RelationDomain>();
//		for (Domain domain : referredDomains)
//			typedModel2Domain.put(domain.getTypedModel(), (RelationDomain) domain);
    	boolean allOk = true;
    	for (int i = 0; i < argumentCount; i++) {
    		OCLExpression argument = relationCallExp.getArgument().get(i);
    		EClassifier argumentType = argument.getEType();
//    		TypedModel typedModel = typedModels.get(i);
//    		RelationDomain domain = typedModel2Domain.get(typedModel);
    		RelationDomain domain = (RelationDomain) referredDomains.get(i);
    		EClassifier domainType = domain.getRootVariable().getEType();
    		if (!assignableFrom(domainType, argumentType)) {
//    		if (argumentType != domainType) {
 				Object[] messageSubstitutions = new Object[] { getObjectLabel(argumentType, context), getObjectLabel(domainType, context), getObjectLabel(domain, context) };
				appendError(diagnostics, argument, QVTRelationMessages._UI_RelationCallExp_WhenReferredRelationArgumentTypeDoesNotMatch, messageSubstitutions);
				allOk = false;
	    	}
    	}
    	return allOk;
	}

	/**
	 * Validates the veryWhereReferredRelationArgumentTypeIsMatchableWarning constraint of '<em>Relation Call Exp</em>'.
	 */
	public boolean checkEveryWhereReferredRelationArgumentTypeIsMatchableWarning(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = getPattern(relationCallExp);
		if (pattern == null)
			return true;					// PatternExists failure
		Relation relation = getRelation(relationCallExp);
		if (relation == null)
			return true;					// RelationExists failure
		if (pattern != relation.getWhere())
			return true;
		Relation referredRelation = relationCallExp.getReferredRelation();
		List<Domain> referredDomains = referredRelation.getDomain();
		int referredArgumentCount = referredDomains.size();
		int argumentCount = relationCallExp.getArgument().size();
		if (argumentCount != referredArgumentCount)
			return true;	// ReferredRelationArgumentNumberMatches
//		List<TypedModel> typedModels = referredRelation.getTransformation().getModelParameter();
//		if (typedModels.size() <  referredArgumentCount)
//			return true;	// DomainNumberMatches
//		Map<TypedModel, RelationDomain> typedModel2Domain = new HashMap<TypedModel, RelationDomain>();
//		for (Domain domain : referredDomains)
//			typedModel2Domain.put(domain.getTypedModel(), (RelationDomain) domain);
    	boolean allOk = true;
    	for (int i = 0; i < argumentCount; i++) {
    		OCLExpression argument = relationCallExp.getArgument().get(i);
    		EClassifier argumentType = argument.getEType();
//    		TypedModel typedModel = typedModels.get(i);
//    		RelationDomain domain = typedModel2Domain.get(typedModel);
    		RelationDomain domain = (RelationDomain) referredDomains.get(i);
    		EClassifier domainType = domain.getRootVariable().getEType();
    		if (!assignableFrom(argumentType, domainType) && !assignableFrom(domainType, argumentType)) {
 				Object[] messageSubstitutions = new Object[] { getObjectLabel(argumentType, context), getObjectLabel(domainType, context), getObjectLabel(domain, context) };
				appendWarning(diagnostics, argument, QVTRelationMessages._UI_RelationCallExp_WhereReferredRelationArgumentTypeIsNotMatchableWarning, messageSubstitutions);
				allOk = false;
	    	}
    	}
    	return allOk;
	}

	/**
	 * Validates the InvokedFromWhenOrWhereClause constraint of '<em>Relation Call Exp</em>'.
	 */
	public boolean checkInvokedFromWhenOrWhereClause(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = getPattern(relationCallExp);
		if (pattern == null)
			return true;					// PatternExists failure
		Relation relation = getRelation(relationCallExp);
		if (relation == null)
			return true;					// RelationExists failure
		if ((pattern == relation.getWhen()) || (pattern == relation.getWhere()))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(relationCallExp, context) };
		appendError(diagnostics, relationCallExp, QVTRelationMessages._UI_RelationCallExp_NotInvokedFromWhenOrWhereClause, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the PatternExists constraint of '<em>Relation Call Exp</em>'.
	 */
	public boolean checkPatternExists(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = getPattern(relationCallExp);
		if (pattern != null)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(relationCallExp, context) };
		appendError(diagnostics, relationCallExp, QVTRelationMessages._UI_RelationCallExp_PatternDoesNotExist, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the ReferredRelationArgumentNumberMatches constraint of '<em>Relation Call Exp</em>'.
	 */
	public boolean checkReferredRelationArgumentNumberMatches(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		int argumentCount = relationCallExp.getArgument().size();
		Relation referredRelation = relationCallExp.getReferredRelation();
		if (referredRelation == null)
			return true;		// Multiplicity failure
		int referredArgumentCount = referredRelation.getDomain().size();
		if (argumentCount == referredArgumentCount)
			return true;
		Object[] messageSubstitutions = new Object[] { argumentCount, referredArgumentCount, getObjectLabel(relationCallExp, context) };
		appendError(diagnostics, relationCallExp, QVTRelationMessages._UI_RelationCallExp_ReferredRelationArgumentNumberDoesNotMatch, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the ReferredRelationDeclaredByTransformation constraint of '<em>Relation Call Exp</em>'.
	 */
	public boolean checkReferredRelationDeclaredByTransformation(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Relation relation = getRelation(relationCallExp);
		if (relation == null)
			return true;					// RelationExists failure
		Transformation transformation = relation.getTransformation();
		Relation referredRelation = relationCallExp.getReferredRelation();
		if (referredRelation == null)
			return true;					// Multiplicity failure
		if (TransformationOperations.INSTANCE.declaresRule(transformation, referredRelation))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(referredRelation, context), getObjectLabel(transformation, context) };
		appendError(diagnostics, relationCallExp, QVTRelationMessages._UI_RelationCallExp_ReferredRelationIsNotDeclaredByTransformation, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the RelationExists constraint of '<em>Relation Call Exp</em>'.
	 */
	public boolean checkRelationExists(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = getPattern(relationCallExp);
		if (pattern == null)
			return true;		// PatternExists failure
		Relation relation = getRelation(relationCallExp);
		if (relation != null)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(relationCallExp, context) };
		appendError(diagnostics, relationCallExp, QVTRelationMessages._UI_RelationCallExp_RelationDoesNotExist, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the TypeIsBoolean constraint of '<em>Relation Call Exp</em>'.
	 */
	public boolean checkTypeIsBoolean(RelationCallExp relationCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EClassifier type = relationCallExp.getEType();
		if (type == null)
			return true;						// Structural validation generates a more relevant error
		if (type != getBooleanType()) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(relationCallExp, context) };
			appendError(diagnostics, relationCallExp, QVTRelationMessages._UI_RelationCallExp_TypeIsNotBoolean, messageSubstitutions);
			return false;
		}
		return true;
	}

	public Pattern getPattern(EObject eObject) {
		EObject parent = eObject.eContainer();
		if (parent instanceof Pattern)
			return (Pattern) parent;
		if (parent instanceof Predicate)
			return getPattern(parent);
		if (parent instanceof OCLExpression)
			return getPattern(parent);
		if (parent instanceof PropertyTemplateItem)
			return getPattern(parent);
		return null;
	}

	public Relation getRelation(EObject eObject) {
		EObject parent = eObject.eContainer();
		if (parent instanceof Relation)
			return (Relation) parent;
		if (parent instanceof Domain)
			return getRelation(parent);
		if (parent instanceof Pattern)
			return getRelation(parent);
		if (parent instanceof Predicate)
			return getRelation(parent);
		if (parent instanceof OCLExpression)
			return getRelation(parent);
		if (parent instanceof PropertyTemplateItem)
			return getRelation(parent);
		return null;
	}
}