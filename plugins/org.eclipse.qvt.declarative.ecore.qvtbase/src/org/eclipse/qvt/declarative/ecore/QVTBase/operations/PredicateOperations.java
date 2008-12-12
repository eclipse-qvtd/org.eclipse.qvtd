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
 * $Id: PredicateOperations.java,v 1.1 2008/12/12 15:31:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;
import org.eclipse.qvt.declarative.ecore.QVTBase.Predicate;

public class PredicateOperations extends AbstractQVTBaseOperations
{
	public static PredicateOperations INSTANCE = new PredicateOperations();

	/**
	 * Validates the ConditionExpressionIsBoolean constraint of '<em>Predicate</em>'.
	 */
	public boolean checkConditionExpressionIsBoolean(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		OCLExpression expression = predicate.getConditionExpression();
		if (expression == null)
			return true;						// Structural validation generates a more relevant error
		EClassifier type = expression.getEType();
		if (type == null)
			return true;						// Structural validation generates a more relevant error
		if (type != getBooleanType()) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(predicate, context) };
			appendError(diagnostics, predicate, "_UI_ConditionExpressionIsBoolean", messageSubstitutions);
			return false;
		}
		return true;
	}

	/**
	 * Validates the VariablesAreBoundByPattern constraint of '<em>Predicate</em>'.
	 *
	public boolean checkVariablesAreBoundByPattern(Predicate predicate, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Pattern pattern = predicate.getPattern();
		if (pattern == null)
			return true;						// Structural validation generates a more relevant error
		OCLExpression expression = predicate.getConditionExpression();
		if (expression == null)
			return true;						// Structural validation generates a more relevant error
		boolean allOk = true;
		for (VariableExp variableExp : getAllVariableExps(expression)) {
			Variable referencedVariable = (Variable) variableExp.getReferredVariable();
			if ((referencedVariable != null) && !pattern.getBindsTo().contains(referencedVariable)) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(referencedVariable, context), getObjectLabel(pattern, context) };
				appendError(diagnostics, variableExp, "_UI_VariablesAreBoundByPattern",  messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	} */

	/**
	 * Validates the NoVariableIsAFunctionParameter constraint of '<em>Pattern</em>'.
	 */
	public boolean checkNoVariableIsAFunctionParameter(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (Variable variable : pattern.getBindsTo()) {
			if (variable instanceof FunctionParameter) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(variable, context) };
				appendError(diagnostics, pattern, "_UI_NoVariableIsAFunctionParameter", messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	}
}