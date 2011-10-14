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
 * $Id: VariableAssignmentOperations.java,v 1.1 2008/12/31 17:42:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.QVTCore.VariableAssignment;

public class VariableAssignmentOperations extends AbstractQVTCoreOperations
{
	public static VariableAssignmentOperations INSTANCE = new VariableAssignmentOperations();

	/**
	 * Validates the TypeIsConsistent constraint of '<em>Property Assignment</em>'.
	 */
	public boolean checkTypeIsConsistent(VariableAssignment variableAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		OCLExpression value = variableAssignment.getValue();
		Variable variable = variableAssignment.getTargetVariable();
		if ((value != null) && (variable != null)) {
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
				EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env = getValidator().getOclEnvironment(context);
			UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> umlReflection = env.getUMLReflection();
			EClassifier variableType = variable.getEType();
			EClassifier resolvedVariableType = umlReflection.getOCLType(variable);
			EClassifier resolvedValueType = umlReflection.getOCLType(value);
			if (!TypeUtil.compatibleTypeMatch(env, resolvedValueType, resolvedVariableType)
			 && !TypeUtil.compatibleTypeMatch(env, resolvedValueType, variableType)) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(resolvedValueType, context), getObjectLabel(resolvedVariableType, context) };
				appendError(diagnostics, variableAssignment, QVTCoreMessages._UI_VariableAssignment_VariableTypeIsNotInconsistent, messageSubstitutions);
				return false;
			}
		}
		return true;
	}
}