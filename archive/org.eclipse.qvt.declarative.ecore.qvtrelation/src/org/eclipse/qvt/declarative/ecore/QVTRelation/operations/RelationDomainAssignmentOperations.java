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
 * $Id: RelationDomainAssignmentOperations.java,v 1.2 2009/01/14 21:02:27 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment;

public class RelationDomainAssignmentOperations extends AbstractQVTRelationOperations
{
	public static RelationDomainAssignmentOperations INSTANCE = new RelationDomainAssignmentOperations();

	/**
	 * Validates the VariableDefinedByRelation constraint of '<em>Relation Domain Assignment</em>'.
	 */
	public boolean checkVariableDefinedByRelation(RelationDomainAssignment relationDomainAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Relation relation = getRelation(relationDomainAssignment);
		if (relation == null)
			return true;
		Variable variable = relationDomainAssignment.getVariable();
		if (variable == null)
			return true;					// Multiplicity failure
		if (RelationOperations.INSTANCE.definesVariable(relation, variable))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(variable, context), getObjectLabel(relation, context) };
		appendError(diagnostics, variable, QVTRelationMessages._UI_RelationDomainAssignment_VariableIsNotDefinedByRelation, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the VariableTypeMatchesValueType constraint of '<em>Relation Domain Assignment</em>'.
	 */
	public boolean checkVariableTypeMatchesValueType(RelationDomainAssignment relationDomainAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Variable variable = relationDomainAssignment.getVariable();
		if (variable == null)
			return true;					// Multiplicity failure
		EClassifier variableType = variable.getEType();
		if (variableType == null)
			return true;					// Multiplicity failure
		OCLExpression value = relationDomainAssignment.getValueExp();
		if (value == null)
			return true;					// Multiplicity failure
		EClassifier valueType = value.getEType();
		if (valueType == null)
			return true;					// Multiplicity failure
		if (assignableFrom(variableType, valueType))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(variableType, context), getObjectLabel(variable, context), getObjectLabel(valueType, context) };
		appendError(diagnostics, variable, QVTRelationMessages._UI_RelationDomainAssignment_VariableTypeMatchesValueType, messageSubstitutions);
		return false;
	}

	public Relation getRelation(RelationDomainAssignment relationDomainAssignment) {
		EObject container = relationDomainAssignment.eContainer();
		if (!(container instanceof RelationDomain))
			return null;		// 
		Rule rule = ((Domain) container).getRule();
		if (!(rule instanceof Relation))
			return null;		//
		return (Relation) rule;
	}

	public RelationDomain getRelationDomain(RelationDomainAssignment relationDomainAssignment) {
		EObject container = relationDomainAssignment.eContainer();
		if (!(container instanceof RelationDomain))
			return null;		// 
		return (RelationDomain) container;
	}
}