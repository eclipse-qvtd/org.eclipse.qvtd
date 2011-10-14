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
 * $Id: RelationOperations.java,v 1.3 2009/03/05 22:04:41 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.TypedModel;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationImplementation;
import org.eclipse.qvt.declarative.ecore.operations.EPackageOperations;

public class RelationOperations extends AbstractQVTRelationOperations
{
	public static RelationOperations INSTANCE = new RelationOperations();

	/**
	 * Validates the EveryDomainIsARelationDomain constraint of '<em>Relation</em>'.
	 */
    public boolean checkEveryDomainIsARelationDomain(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (Domain domain : relation.getDomain()) {
			if (!(domain instanceof RelationDomain)) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(domain, context) };
				appendError(diagnostics, domain, QVTRelationMessages._UI_Relation_DomainIsNotARelationDomain, messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	}

	/**
	 * Validates the AtLeastTwoDomains constraint of '<em>Relation</em>'.
	 */
    public boolean checkAtLeastTwoDomains(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (relation.getDomain().size() < 2) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(relation, context) };
			appendError(diagnostics, relation, QVTRelationMessages._UI_Relation_LessThanTwoDomains, messageSubstitutions);
			return false;
		}
		return true;
	}

	/**
	 * Validates the DomainTypedModelsMatchModelParameters constraint of '<em>Rule</em>'.
	 */
	public boolean checkDomainTypedModelsMatchModelParameters(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		List<Domain> domains = rule.getDomain();
		List<TypedModel> modelParameters = rule.getTransformation().getModelParameter();
		int domainCount = domains.size();
		int modelParameterCount = modelParameters.size();
		if (domainCount < modelParameterCount) {
			Object[] messageSubstitutions = new Object[] { domainCount, getObjectLabel(rule, context), modelParameterCount };
			appendError(diagnostics, rule, QVTRelationMessages._UI_Relation_DomainTypedModelsDoNotMatchModelParameters, messageSubstitutions);
			return false;
		}
		boolean allOk = true;
		for (int i = 0; i < domainCount; i++)
		{
			Domain domain = domains.get(i);
			TypedModel typedModel = domain.getTypedModel();
			if (i < modelParameterCount) {
				TypedModel modelParameter = modelParameters.get(i);
				if (typedModel == null)
					continue;			// Multiplicity error
				if (typedModel != modelParameter) {
					if (!modelParameters.contains(typedModel))
						continue;		// Domain consistency error
					Object[] messageSubstitutions = new Object[] { getObjectLabel(domain, context), getObjectLabel(modelParameter, context) };
					appendError(diagnostics, rule, QVTRelationMessages._UI_Relation_DomainTypedModelIsNotModelParameter, messageSubstitutions);
					allOk = false;
				}
			} else if (typedModel != null) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(domain, context) };
				appendError(diagnostics, rule, QVTRelationMessages._UI_Relation_DomainWithoutModelParameterMustBePrimitive, messageSubstitutions);
				allOk = false;
				
			}
		}
		return allOk;
	}

	/**
	 * Validates the NonTopLevelIsNotInvokedWarning constraint of '<em>Relation</em>'.
	 */
    public boolean checkNonTopLevelIsNotInvokedWarning(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		return true;
	}

	/**
	 * Validates the RelationImplsAreUniqueWarning constraint of '<em>Relation</em>'.
	 */
    public boolean checkRelationImplsAreUniqueWarning(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		UniquenessChecker<EOperation, RelationImplementation> checker = new UniquenessChecker<EOperation, RelationImplementation>()
		{
			@Override
			protected EOperation getKey(RelationImplementation value) {
				return value.getImpl();
			}

			@Override
			protected int getSeverity() {
				return Diagnostic.WARNING;
			}
		};
		return checker.check(relation.getOperationalImpl(), QVTRelationMessages._UI_Relation_ImplIsNotUnique, relation, diagnostics, context);
	}

	protected boolean checkTypesAreDeclaredByRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context, Pattern pattern, String errorMessage) {
		if (pattern == null)
    		return true;
    	boolean allOk = true;
    	for (OCLExpression expression : getPatternExpressions(pattern)) {
	    	for (VariableExp variableReference : getAllVariableReferences(expression)) {
	    		Variable variable = (Variable) variableReference.getReferredVariable();
	    		EClassifier type = getTransitiveElementType(variable.getEType());
				if (!declaresType(relation, type)) {
	 				Object[] messageSubstitutions = new Object[] { getObjectLabel(type, context), getObjectLabel(variable, context), getObjectLabel(relation, context) };
					appendError(diagnostics, variableReference, errorMessage, messageSubstitutions);
					allOk = false;
	    		}
	    	}
	    	for (Variable variable : getAllVariables(expression)) {
	    		EClassifier type = getTransitiveElementType(variable.getEType());
				if (!declaresType(relation, type)) {
	 				Object[] messageSubstitutions = new Object[] { getObjectLabel(type, context), getObjectLabel(variable, context), getObjectLabel(relation, context) };
					appendError(diagnostics, variable, errorMessage, messageSubstitutions);
					allOk = false;
	    		}
	    	}
    	}
    	return allOk;
	}

	protected boolean checkVariablesAreDefinedByRelation(Relation relation,
			DiagnosticChain diagnostics, Map<Object, Object> context, Pattern pattern, String errorMessage) {
		if (pattern == null)
    		return true;
    	boolean allOk = true;
    	for (OCLExpression expression : getPatternExpressions(pattern)) {
	    	for (VariableExp variableReference : getAllVariableReferences(expression)) {
	    		Variable variable = (Variable) variableReference.getReferredVariable();
	    		if (!definesVariable(relation, variable) && !locallyDefined(variableReference)) {
	 				Object[] messageSubstitutions = new Object[] { getObjectLabel(variable, context), getObjectLabel(relation, context) };
					appendError(diagnostics, variableReference, errorMessage, messageSubstitutions);
					allOk = false;
	    		}
	    	}
    	}
    	return allOk;
	}

	/**
	 * Validates the VariablesAreUnique constraint of '<em>Relation</em>'.
	 */
	public boolean checkVariablesAreUnique(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		return checkUniqueNames(relation, relation.getVariable(), QVTRelationMessages._UI_Relation_VariableNameIsNotUnique, diagnostics, context);
	}

	/**
	 * Validates the WhenTypesAreDeclaredByRelation constraint of '<em>Relation</em>'.
	 */
    public boolean checkWhenTypesAreDeclaredByRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = relation.getWhen();
		String errorMessage = QVTRelationMessages._UI_Relation_WhenTypeIsNotDeclaredByRelation;
    	return checkTypesAreDeclaredByRelation(relation, diagnostics, context, pattern, errorMessage);
	}

	/**
	 * Validates the WhenVariablesAreDefinedByRelation constraint of '<em>Relation</em>'.
	 */
    public boolean checkWhenVariablesAreDefinedByRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = relation.getWhen();
		String errorMessage = QVTRelationMessages._UI_Relation_WhenVariableIsNotDefinedByRelation;
    	return checkVariablesAreDefinedByRelation(relation, diagnostics, context, pattern, errorMessage);
	}

	/**
	 * Validates the WhereTypesAreDeclaredByRelation constraint of '<em>Relation</em>'.
	 */
    public boolean checkWhereTypesAreDeclaredByRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		String errorMessage = QVTRelationMessages._UI_Relation_WhereTypeIsNotDeclaredByRelation;
		Pattern pattern = relation.getWhere();
    	return checkTypesAreDeclaredByRelation(relation, diagnostics, context, pattern, errorMessage);
	}

	/**
	 * Validates the WhereVariablesAreDefinedByRelation constraint of '<em>Relation</em>'.
	 */
    public boolean checkWhereVariablesAreDefinedByRelation(Relation relation, DiagnosticChain diagnostics, Map<Object, Object> context) {
		String errorMessage = QVTRelationMessages._UI_Relation_WhereVariableIsNotDefinedByRelation;
		Pattern pattern = relation.getWhere();
    	return checkVariablesAreDefinedByRelation(relation, diagnostics, context, pattern, errorMessage);
	}

	public boolean declaresType(Relation relation, EClassifier type) {
		return isPredefinedType(type) || getDeclaredPackages(relation).contains(type.getEPackage());
	}

	public boolean definesVariable(Relation relation, Variable variable) {
		return relation.getVariable().contains(variable);
	}

	public Set<Variable> getAllLocalVariables1(Collection<OCLExpression> expressions) {
		Set<Variable> variables = new HashSet<Variable>();
    	for (OCLExpression expression : expressions) {
    		for (TreeIterator<EObject> i = expression.eAllContents(); i.hasNext(); ) {
    			EObject eObject = i.next();
    			if (eObject instanceof Variable)
					variables.add((Variable) eObject);
    		}
    	}
		return variables;
	}

	public Set<EPackage> getDeclaredPackages(Relation relation) {
		Set<EPackage> declaredPackages = new HashSet<EPackage>();
		for (Domain domain : relation.getDomain()) {
			TypedModel typedModel = domain.getTypedModel();
			if (typedModel != null) {
				for (EPackage usedPackage : typedModel.getUsedPackage()) {
					Set<EPackage> allUsedPackages = EPackageOperations.INSTANCE.getAllEPackages(usedPackage);
					declaredPackages.addAll(allUsedPackages);
				}
			}
		}
		return declaredPackages;
	}

	public Collection<OCLExpression> getPatternExpressions(Pattern pattern) {
    	List<OCLExpression> expressions = new ArrayList<OCLExpression>();
    	for (Predicate predicate : pattern.getPredicate()) {
    		OCLExpression conditionExpression = predicate.getConditionExpression();
    		if (conditionExpression != null)
    			expressions.add(conditionExpression);
    	}
    	return expressions;
	}
}