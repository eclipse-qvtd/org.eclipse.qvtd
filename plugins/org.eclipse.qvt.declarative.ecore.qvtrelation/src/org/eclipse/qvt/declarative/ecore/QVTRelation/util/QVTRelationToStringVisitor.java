/*******************************************************************************
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.ecore.QVTRelation.util;

import java.util.Iterator;
import java.util.List;

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
import org.eclipse.ocl.expressions.PropertyCallExp;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTRelation.OppositePropertyCallExp;
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

	@Override
	protected String handlePropertyCallExp(
			PropertyCallExp<EClassifier, EStructuralFeature> pc,
			String sourceResult, List<String> qualifierResults) {
		if (!(pc instanceof OppositePropertyCallExp))
			return super.handlePropertyCallExp(pc, sourceResult, qualifierResults);
		EStructuralFeature property = pc.getReferredProperty();

        if (sourceResult == null) {
			// if we are the qualifier of an association class call, then
			//   we just return our name, because our source is null (implied)
			return getName(property);
		}
		
		StringBuffer result = new StringBuffer(
		   sourceResult + ".opposite(" + getName(property) + ")");//$NON-NLS-1$
		
		if (!qualifierResults.isEmpty()) {
			result.append('[');
			
			for (Iterator<String> iter = qualifierResults.iterator(); iter.hasNext();) {
				result.append(iter.next());
				
				if (iter.hasNext()) {
					result.append(", "); //$NON-NLS-1$
				}
			}
			
			result.append(']');
		}
		
		return result.toString();
	}

	public String visitOppositePropertyCallExp(OppositePropertyCallExp opc) {
        return super.visitPropertyCallExp(opc);
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
