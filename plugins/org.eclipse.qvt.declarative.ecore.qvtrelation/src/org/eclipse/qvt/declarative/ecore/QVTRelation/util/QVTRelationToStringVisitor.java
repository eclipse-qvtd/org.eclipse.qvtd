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
package org.eclipse.qvt.declarative.ecore.QVTRelation.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTRelation.Relation;
import org.eclipse.qvt.declarative.ecore.QVTRelation.RelationCallExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.util.QVTTemplateToStringVisitor;
import org.eclipse.qvt.declarative.ecore.utils.ClassUtils;

public class QVTRelationToStringVisitor extends QVTTemplateToStringVisitor implements QVTRelationVisitor<String>
{
	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * environment.
	 * 
	 * @param env an OCL environment
	 * 
	 * @return the corresponding instance
	 */
	public static QVTRelationToStringVisitor getInstance(
			Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {		
		return new QVTRelationToStringVisitor(env);
	}
	
	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * expression or other typed element.
	 * 
	 * @param element an OCL expression or other typed element such as a variable
	 * 
	 * @return the corresponding instance
	 */
	public static QVTRelationToStringVisitor getInstance(TypedElement<EClassifier> element) {
		Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env = ClassUtils.asClassUnchecked(Environment.Registry.INSTANCE.getEnvironmentFor(element));
		return new QVTRelationToStringVisitor(env);
	}
	public QVTRelationToStringVisitor(Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {
		super(env);
	}

	public String visitRelationCallExp(RelationCallExp relationCallExp) {
		if (relationCallExp == null)
			return "null 'RelationCallExp'";
        StringBuffer result = new StringBuffer();
        Relation referredRelation = relationCallExp.getReferredRelation();
		if (referredRelation != null)
			result.append(referredRelation.getName());
		result.append("(");
		EList<OCLExpression> arguments = relationCallExp.getArgument();
		boolean isFirst = true;
		for (OCLExpression argument : arguments) {
			if (isFirst)
				isFirst = false;
			else
				result.append(", ");
			result.append(argument.accept(this));
		}
		result.append(")");
		return result.toString();
	}
}
