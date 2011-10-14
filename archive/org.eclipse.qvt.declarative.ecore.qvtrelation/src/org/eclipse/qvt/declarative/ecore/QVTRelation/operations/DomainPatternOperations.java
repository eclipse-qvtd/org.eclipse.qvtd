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
 * $Id: DomainPatternOperations.java,v 1.2 2009/01/14 21:02:27 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTRelation.DomainPattern;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;



public class DomainPatternOperations extends AbstractQVTRelationOperations
{
	public static DomainPatternOperations INSTANCE = new DomainPatternOperations();

	/**
	 * Validates the EveryVariableIsDefinedByRelation constraint of '<em>Domain Pattern</em>'.	 * @generated NOT
	 */
	public boolean checkEveryVariableIsDefinedByRelation(DomainPattern domainPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Relation relation = getRelation(domainPattern);
		if (relation == null)
			return true;
		boolean allOk = true;
		for (Variable variable : domainPattern.getBindsTo()) {
			if (!RelationOperations.INSTANCE.definesVariable(relation, variable)) {
				allOk = false;
				Object[] messageSubstitutions = new Object[] { getObjectLabel(variable, context), getObjectLabel(relation, context) };
				appendError(diagnostics, variable, QVTRelationMessages._UI_DomainPattern_VariableIsNotDefinedByRelation, messageSubstitutions);
			}				
		}
		return allOk;
	}

	/**
	 * Validates the RootTemplateExpressionIsBoundToRootVariable constraint of '<em>Domain Pattern</em>'.
	 */
	public boolean checkRootTemplateExpressionIsBoundToRootVariable(DomainPattern domainPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		RelationDomain relationDomain = getRelationDomain(domainPattern);
		if (relationDomain == null)
			return true;
		DomainPattern pattern = relationDomain.getPattern();
		if (pattern == null)
			return true;					// Multiplicity failure
		TemplateExp templateExp = pattern.getTemplateExpression();
		if (templateExp == null)
			return true;
		Variable variable = templateExp.getBindsTo();
		if (variable == null)
			return true;					// Multiplicity failure
		Variable rootVariable = relationDomain.getRootVariable();
		if (rootVariable == null)
			return true;					// Multiplicity failure
		if (rootVariable == variable)
			return true;					// Relation checks its domains
		Object[] messageSubstitutions = new Object[] { getObjectLabel(rootVariable, context), getObjectLabel(variable, context) };
		appendError(diagnostics, relationDomain, QVTRelationMessages._UI_DomainPattern_RootTemplateExpressionIsNotBoundToRootVariable, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the RootTemplateExpressionTypeIsRootVariableType constraint of '<em>Domain Pattern</em>'.
	 */
	public boolean checkRootTemplateExpressionTypeIsRootVariableType(DomainPattern domainPattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		RelationDomain relationDomain = getRelationDomain(domainPattern);
		if (relationDomain == null)
			return true;
		DomainPattern pattern = relationDomain.getPattern();
		if (pattern == null)
			return true;					// Multiplicity failure
		TemplateExp templateExp = pattern.getTemplateExpression();
		if (templateExp == null)
			return true;
		Variable rootVariable = relationDomain.getRootVariable();
		if (rootVariable == null)
			return true;					// Multiplicity failure
		if (rootVariable.getEType() == templateExp.getEType())
			return true;					// Relation checks its domains
		Object[] messageSubstitutions = new Object[] { getObjectLabel(rootVariable.getEType(), context), getObjectLabel(rootVariable, context), getObjectLabel(templateExp.getEType(), context) };
		appendError(diagnostics, relationDomain, QVTRelationMessages._UI_DomainPattern_RootTemplateExpressionTypeIsNotRootVariableType, messageSubstitutions);
		return false;
	}

	public Relation getRelation(DomainPattern domainPattern) {
		EObject container = domainPattern.eContainer();
		if (!(container instanceof RelationDomain))
			return null;		// 
		Rule rule = ((Domain) container).getRule();
		if (!(rule instanceof Relation))
			return null;		//
		return (Relation) rule;
	}

	public RelationDomain getRelationDomain(DomainPattern domainPattern) {
		EObject container = domainPattern.eContainer();
		if (!(container instanceof RelationDomain))
			return null;		// 
		return (RelationDomain) container;
	}
}