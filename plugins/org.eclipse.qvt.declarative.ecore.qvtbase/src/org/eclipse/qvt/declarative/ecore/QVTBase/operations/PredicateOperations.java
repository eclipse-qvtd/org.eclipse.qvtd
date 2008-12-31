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
 * $Id: PredicateOperations.java,v 1.2 2008/12/31 17:42:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.ocl.ecore.OCLExpression;
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
			appendError(diagnostics, predicate, QVTBaseMessages._UI_Predicate_ConditionExpressionIsNotBoolean, messageSubstitutions);
			return false;
		}
		return true;
	}
}