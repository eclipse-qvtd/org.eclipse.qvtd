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
 * $Id: FunctionOperations.java,v 1.2 2008/12/31 17:42:29 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTBase.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.ocl.ecore.OCLExpression;
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
				appendError(diagnostics, parameter, QVTBaseMessages._UI_Function_ParameterIsNotAFunctionParameter, messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	}
	
	/**
	 * Validates the IsSideEffectFree constraint of '<em>Function</em>'.
	 */
	public boolean checkIsSideEffectFree(Function function, DiagnosticChain diagnostics, Map<Object, Object> context) {
		boolean allOk = true;
		for (TreeIterator<EObject> i = function.eAllContents(); i.hasNext(); ) {
			EObject eObject = i.next();
			String reason = mayHaveSideEffect(eObject);
			if (reason != null) {
				Object[] messageSubstitutions = new Object[] { reason, getObjectLabel(function, context) };
				appendWarning(diagnostics, function, QVTBaseMessages._UI_Function_MayHaveASideEffect, messageSubstitutions);
				allOk = false;
			}
		}
		return allOk;
	}

	protected String mayHaveSideEffect(EObject eObject) {
		if (!(eObject instanceof OCLExpression))
			return null;
		EClass eClass = eObject.eClass();
		EPackage ePackage = eClass.getEPackage();
		if ((ePackage == org.eclipse.ocl.expressions.ExpressionsPackage.eINSTANCE)
		 || (ePackage == org.eclipse.ocl.ecore.EcorePackage.eINSTANCE))
			return null;
		return eClass.getName();
	}
}