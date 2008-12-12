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
 * $Id: RuleOperations.java,v 1.1 2008/12/12 15:31:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.qvt.declarative.ecore.QVTBase.Rule;
import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;

public class RuleOperations extends AbstractQVTBaseOperations
{
	public static RuleOperations INSTANCE = new RuleOperations();

	/**
	 * Validates the OverridesIsCompatible constraint of '<em>Rule</em>'.
	 */
	public boolean checkOverridesIsCompatible(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(rule, context) };
			appendError(diagnostics, rule, "_UI_OverridesIsCompatible", messageSubstitutions);
			return false;
		}
		return true;
	}

	/**
	 * Validates the OverridesDefinedByTransformation constraint of '<em>Rule</em>'.
	 */
	public boolean checkOverridesDefinedByTransformation(Rule rule, DiagnosticChain diagnostics, Map<Object, Object> context) {
		Transformation transformation = rule.getTransformation();
		Rule overrides = rule.getOverrides();
		if ((overrides != null) && !TransformationOperations.INSTANCE.declaresRule(transformation, overrides)) {
			Object[] messageSubstitutions = new Object[] { getObjectLabel(rule, context), getObjectLabel(transformation, context) };
			appendError(diagnostics, rule, "_UI_OverridesDefinedByTransformation", messageSubstitutions);
			return false;
		}
		return true;
	}
}