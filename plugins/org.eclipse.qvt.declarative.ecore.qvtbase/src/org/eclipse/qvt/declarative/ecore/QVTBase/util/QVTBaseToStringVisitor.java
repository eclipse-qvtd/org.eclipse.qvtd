/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.ecore.QVTBase.util;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.util.ToStringVisitor;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.FunctionParameter;
import org.eclipse.qvt.declarative.ecore.utils.ClassUtils;

public class QVTBaseToStringVisitor extends ToStringVisitor<EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> implements QVTBaseVisitor<String>
{	
	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * environment.
	 * 
	 * @param env an OCL environment
	 * 
	 * @return the corresponding instance
	 */
	public static QVTBaseToStringVisitor getInstance(
			Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {		
		return new QVTBaseToStringVisitor(env);
	}
	
	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * expression or other typed element.
	 * 
	 * @param element an OCL expression or other typed element such as a variable
	 * 
	 * @return the corresponding instance
	 */
	public static QVTBaseToStringVisitor getInstance(TypedElement<EClassifier> element) {
		Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env = ClassUtils.asClassUnchecked(Environment.Registry.INSTANCE.getEnvironmentFor(element));
		return new QVTBaseToStringVisitor(env);
	}

	public QVTBaseToStringVisitor(Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {
		super(env);
	}

	public String visitFunctionParameter(FunctionParameter functionParameter) {
		return visitVariable(functionParameter);
	}
}
