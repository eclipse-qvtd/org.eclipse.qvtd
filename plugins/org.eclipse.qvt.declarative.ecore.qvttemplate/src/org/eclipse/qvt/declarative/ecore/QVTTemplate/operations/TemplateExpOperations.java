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
 * $Id: TemplateExpOperations.java,v 1.2 2009/01/14 21:01:48 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.operations.DomainOperations;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.TemplateExp;


public class TemplateExpOperations extends AbstractQVTTemplateOperations
{
	public static TemplateExpOperations INSTANCE = new TemplateExpOperations();

	/**
	 * Validates the DomainExists constraint of '<em>Template Exp</em>'.
	 */
	public boolean checkDomainExists(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Domain domain = getDomain(templateExp);
		if (domain != null)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(templateExp, context) };
		appendError(diagnostics, templateExp, QVTTemplateMessages._UI_TemplateExp_DomainDoesNotExist, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the PatternExists constraint of '<em>Template Exp</em>'.
	 */
	public boolean checkPatternExists(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = getPattern(templateExp);
		if (pattern != null)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(templateExp, context) };
		appendError(diagnostics, templateExp, QVTTemplateMessages._UI_TemplateExp_PatternDoesNotExist, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the VariableIsBoundByPattern constraint of '<em>Template Exp</em>'.
	 */
	public boolean checkVariableIsBoundByPattern(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = getPattern(templateExp);
		if (pattern == null)
			return true;
		Variable variable = templateExp.getBindsTo();
		if (variable == null)
			return true;						// Structural validation generates a more relevant error
		if (pattern.getBindsTo().contains(variable))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(variable, context), getObjectLabel(pattern, context) };
		appendError(diagnostics, templateExp, QVTTemplateMessages._UI_TemplateExp_VariableIsNotBoundByPattern, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the VariableTypeIsDeclaredByDomain constraint of '<em>Template Exp</em>'.
	 */
	public boolean checkVariableTypeIsDeclaredByDomain(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Domain domain = getDomain(templateExp);
		if (domain == null)
			return true;
		Variable variable = templateExp.getBindsTo();
		if (variable == null)
			return true;						// Structural validation generates a more relevant error
		EClassifier type = getTransitiveElementType(variable.getEType());
		if (type == null)
			return true;						// Structural validation generates a more relevant error
		if (DomainOperations.INSTANCE.declaresType(domain, type))
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(type, context), getObjectLabel(variable, context), getObjectLabel(domain, context) };
		appendError(diagnostics, templateExp, QVTTemplateMessages._UI_TemplateExp_VariableTypeIsNotDeclaredByDomain, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the WhereIsBoolean constraint of '<em>Template Exp</em>'.
	 */
	public boolean checkWhereIsBoolean(TemplateExp templateExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		OCLExpression expression = templateExp.getWhere();
		if (expression == null)
			return true;
		EClassifier type = expression.getEType();
		if (type == null)
			return true;						// Structural validation generates a more relevant error
		if (type == getBooleanType())
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(expression, context) };
		appendError(diagnostics, templateExp, QVTTemplateMessages._UI_TemplateExp_WhereIsNotBoolean, messageSubstitutions);
		return false;
	}

	public Domain getDomain(TemplateExp templateExp) {
		return getAncestor(templateExp, Domain.class);
	}

	public Pattern getPattern(TemplateExp templateExp) {
		return getAncestor(templateExp, Pattern.class);
	}
}