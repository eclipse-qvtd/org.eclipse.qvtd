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
 * $Id: FunctionOperations.java,v 1.1 2008/12/12 15:31:45 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.qvt.declarative.ecore.QVTBase.Function;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;

public class FunctionOperations extends AbstractQVTBaseOperations
{
	public static FunctionOperations INSTANCE = new FunctionOperations();

	/**
	 * Validates the EveryFunctionParameterIsAFunctionParameter constraint of '<em>Function</em>'.
	 */
	public boolean checkEveryFunctionParameterIsAFunctionParameter(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (EParameter parameter : function.getEParameters()) {
			if (!(parameter instanceof FunctionParameter)) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(parameter, context) };
				appendError(diagnostics, parameter, "_UI_EveryFunctionParameterIsAFunctionParameter", messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	}
}