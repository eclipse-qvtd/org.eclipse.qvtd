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
 * $Id: PropertyAssignmentOperations.java,v 1.1 2008/12/31 17:42:54 ewillink Exp $
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
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.ecore.QVTCore.PropertyAssignment;

public class PropertyAssignmentOperations extends AbstractQVTCoreOperations
{
	public static PropertyAssignmentOperations INSTANCE = new PropertyAssignmentOperations();

	/**
	 * Validates the TypeIsConsistent constraint of '<em>Property Assignment</em>'.
	 */
	public boolean checkTypeIsConsistent(PropertyAssignment propertyAssignment, DiagnosticChain diagnostics, Map<Object, Object> context) {
		OCLExpression value = propertyAssignment.getValue();
		EStructuralFeature property = propertyAssignment.getTargetProperty();
		if ((value != null) && (property != null)) {
			Environment<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter,
				EObject, CallOperationAction, SendSignalAction, Constraint, EClass, EObject> env = getValidator().getOclEnvironment(context);
			UMLReflection<EPackage, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> umlReflection = env.getUMLReflection();
			EClassifier propertyType = property.getEType();
			EClassifier resolvedPropertyType = umlReflection.getOCLType(property);
			EClassifier resolvedValueType = umlReflection.getOCLType(value);
			if (!TypeUtil.compatibleTypeMatch(env, resolvedValueType, resolvedPropertyType)
			 && !TypeUtil.compatibleTypeMatch(env, resolvedValueType, propertyType)) {
				Object[] messageSubstitutions = new Object[] { getObjectLabel(resolvedValueType, context), getObjectLabel(resolvedPropertyType, context) };
				appendError(diagnostics, propertyAssignment, QVTCoreMessages._UI_PropertyAssignment_PropertyTypeIsNotConsistent, messageSubstitutions);
				return false;
			}
		}
		return true;
	}
}