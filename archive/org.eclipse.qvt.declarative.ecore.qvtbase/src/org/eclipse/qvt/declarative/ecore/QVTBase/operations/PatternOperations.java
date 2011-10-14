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
 * $Id: PatternOperations.java,v 1.2 2008/12/31 17:42:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Pattern;

public class PatternOperations extends AbstractQVTBaseOperations
{
	public static PatternOperations INSTANCE = new PatternOperations();

	/**
	 * Validates the NoVariableIsAFunctionParameter constraint of '<em>Pattern</em>'.
	 */
	public boolean checkNoVariableIsAFunctionParameter(Pattern pattern, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (Variable variable : pattern.getBindsTo()) {
			if (variable instanceof FunctionParameter) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(variable, context) };
				appendError(diagnostics, pattern, QVTBaseMessages._UI_Pattern_VariableIsNotAFunctionParameter, messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	}
}