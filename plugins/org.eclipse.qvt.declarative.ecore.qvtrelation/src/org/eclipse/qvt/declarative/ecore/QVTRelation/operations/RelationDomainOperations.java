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
 * $Id: RelationDomainOperations.java,v 1.2 2009/01/14 21:02:27 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.ecore.VariableExp;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.DomainOperations;
import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;

public class RelationDomainOperations extends DomainOperations
{
	public static RelationDomainOperations INSTANCE = new RelationDomainOperations();

	/**
	 * Validates the PrimitiveDomainIsUnnamed constraint of '<em>Relation Domain</em>'.
	 */
	public boolean checkPrimitiveDomainIsUnnamed(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (relationDomain.getPattern() != null)
			return true;
		if (relationDomain.getName() == null)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(relationDomain, context) };
		appendError(diagnostics, relationDomain, QVTRelationMessages._UI_RelationDomain_PrimitiveDomainMustBeUnnamed, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the RootVariableIsDefinedByRelation constraint of '<em>Relation Domain</em>'.
	 */
	public boolean checkRootVariableIsDefinedByRelation(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Variable rootVariable = relationDomain.getRootVariable();
		if (rootVariable == null)
			return true;					// Multiplicity failure
		Rule rule = relationDomain.getRule();
		if (!(rule instanceof Relation))
			return true;					// Relation checks its domains
		if (RelationOperations.INSTANCE.definesVariable((Relation) rule, rootVariable))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(rootVariable, context), getObjectLabel(rule, context) };
		appendError(diagnostics, relationDomain, QVTRelationMessages._UI_RelationDomain_RootVariableIsNotDefinedByRelation, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the RootVariableTypeIsDeclaredByDomainTypedModel constraint of '<em>Relation Domain</em>'.
	 */
	public boolean checkRootVariableTypeIsDeclaredByDomainTypedModel(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Variable rootVariable = relationDomain.getRootVariable();
		if (rootVariable == null)
			return true;					// Multiplicity failure
		EClassifier type = getTransitiveElementType(rootVariable.getEType());
		if (type == null)
			return true;					// Multiplicity failure
		if (declaresType(relationDomain, type))
			return true;					// Relation checks its domains
		Object[] messageSubstitutions = new Object[] { getObjectLabel(type, context), getObjectLabel(rootVariable, context), getObjectLabel(relationDomain, context) };
		appendError(diagnostics, relationDomain, QVTRelationMessages._UI_RelationDomain_RootVariableTypeIsNotDeclaredByDomainTypedModel, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the EveryEnforceableVariableIsMatchedOrAssigned constraint of '<em>Relation Domain</em>'.
	 */
	public boolean checkEveryEnforceableVariableIsMatchedOrAssigned(RelationDomain relationDomain, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!relationDomain.isIsEnforceable())
			return true;
		Set<Variable> sharedVariables = new HashSet<Variable>();
		Set<Variable> passedVariables = new HashSet<Variable>();
		Set<Variable> collectedVariables = new HashSet<Variable>();
		Set<Variable> defaultedVariables = new HashSet<Variable>();
		Map<Variable,Set<EStructuralFeature>> matchedVariableFeatures = new HashMap<Variable,Set<EStructuralFeature>>();
		for (Domain domain : relationDomain.getRule().getDomain())
			if ((domain != relationDomain) && (domain instanceof RelationDomain)) {
				DomainPattern pattern = ((RelationDomain) domain).getPattern();
				if (pattern != null)
					sharedVariables.addAll(pattern.getBindsTo());
			}
		for (TreeIterator<EObject> i = relationDomain.eAllContents(); i.hasNext(); ) {
			EObject eObject = i.next();
			if (eObject instanceof RelationCallExp) {
				for (OCLExpression argument : ((RelationCallExp)eObject).getArgument()) {
					if (argument instanceof VariableExp)
						passedVariables.add((Variable) ((VariableExp)argument).getReferredVariable());
				}
			}
			else if (eObject instanceof ObjectTemplateExp) {
				ObjectTemplateExp templateExp = (ObjectTemplateExp)eObject;
				Variable templateVariable = templateExp.getBindsTo();
				Set<EStructuralFeature> matchedFeatures = matchedVariableFeatures.get(templateVariable);
				if (matchedFeatures == null) {
					matchedFeatures = new HashSet<EStructuralFeature>();
					matchedVariableFeatures.put(templateVariable, matchedFeatures);				
				}				
				for (PropertyTemplateItem part : templateExp.getPart())
					matchedFeatures.add(part.getReferredProperty());
			}
			else if (eObject instanceof CollectionTemplateExp) {
				CollectionTemplateExp templateExp = (CollectionTemplateExp)eObject;
				collectedVariables.add(templateExp.getBindsTo());
			}
			else if (eObject instanceof RelationDomainAssignment) {
				RelationDomainAssignment assignment = (RelationDomainAssignment)eObject;
				defaultedVariables.add(assignment.getVariable());
			}
		}
		boolean allOk = true;
/*		for (Variable boundVariable : relationDomain.getPattern().getBindsTo()) {
			if (!sharedVariables.contains(boundVariable)
			 && !passedVariables.contains(boundVariable)
			 && !collectedVariables.contains(boundVariable)
			 && !defaultedVariables.contains(boundVariable)) {
				Set<EStructuralFeature> matchedFeatures = matchedVariableFeatures.get(boundVariable);
				if (matchedFeatures == null) {
					allOk = false;
					Object[] messageSubstitutions = new Object[] { boundVariable.getName(), getObjectLabel(relationDomain, context) };
					appendWarning(diagnostics, boundVariable, QVTRelationMessages._UI_RelationDomain_BoundVariableIsNotDefinedByEnforceableDomain, messageSubstitutions);
				}
				else {
					for (EStructuralFeature feature : boundVariable.getEType().eClass().getEAllStructuralFeatures()) {
						if (!matchedFeatures.contains(feature) && feature.isRequired()) {
							allOk = false;
							Object[] messageSubstitutions = new Object[] { boundVariable.getName(), feature.getName(), getObjectLabel(relationDomain, context) };
							appendWarning(diagnostics, boundVariable, QVTRelationMessages._UI_RelationDomain_BoundVariableFeatureIsNotDefinedByEnforceableDomain, messageSubstitutions);
						}
					}
				}
			}
		} */
		return allOk;
	}
}