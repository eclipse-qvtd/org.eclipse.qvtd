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
package org.eclipse.qvt.declarative.ecore.QVTTemplate.util;

import java.util.List;

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
import org.eclipse.ocl.ecore.Variable;
import org.eclipse.ocl.utilities.TypedElement;
import org.eclipse.qvt.declarative.ecore.QVTBase.util.QVTBaseToStringVisitor;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.utils.ClassUtils;

public class QVTTemplateToStringVisitor extends QVTBaseToStringVisitor implements QVTTemplateVisitor<String>
{	
	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * environment.
	 * 
	 * @param env an OCL environment
	 * 
	 * @return the corresponding instance
	 */
	public static QVTTemplateToStringVisitor getInstance(
			Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {		
		return new QVTTemplateToStringVisitor(env);
	}
	
	/**
	 * Obtains an instance of the <tt>toString()</tt> visitor for the specified
	 * expression or other typed element.
	 * 
	 * @param element an OCL expression or other typed element such as a variable
	 * 
	 * @return the corresponding instance
	 */
	public static QVTTemplateToStringVisitor getInstance(TypedElement<EClassifier> element) {
		Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env = ClassUtils.asClassUnchecked(Environment.Registry.INSTANCE.getEnvironmentFor(element));
		return new QVTTemplateToStringVisitor(env);
	}

	public QVTTemplateToStringVisitor(Environment<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint, ?, ?> env) {
		super(env);
	}

	public String visitCollectionTemplateExp(CollectionTemplateExp collectionTemplateExp) {
		if (collectionTemplateExp == null)
			return "null 'CollectionTemplateExp'";
        StringBuffer result = new StringBuffer();
		Variable variable = collectionTemplateExp.getBindsTo();
		if (variable != null)
			result.append(variable.accept(this));
		else {							// Perhaps a ObjectTemplateExp as a literal
			result.append(collectionTemplateExp.getName());
			result.append(" : ");
			EClassifier type = collectionTemplateExp.getType();
			if (type != null)
				result.append(type.getName());
		}
		List<OCLExpression> parts = collectionTemplateExp.getMember();
		result.append(" {");
		if (parts.size() > 0) {
			boolean isFirst = true;
			for (OCLExpression part : parts) {
				if (isFirst)
					isFirst = false;
				else
					result.append(", ");
				result.append(part.accept(this));
			}
			result.append(" ++ ");
			Variable rest = collectionTemplateExp.getRest();
			if (rest != null)
				result.append(rest.accept(this));
		}
		result.append("}");
		return result.toString();
	}

	public String visitObjectTemplateExp(ObjectTemplateExp objectTemplateExp) {
		if (objectTemplateExp == null)
			return "null 'ObjectTemplateExp'";
        StringBuffer result = new StringBuffer();
		Variable variable = objectTemplateExp.getBindsTo();
		if (variable != null)
			result.append(variable.accept(this));
		else {							// Perhaps a ObjectTemplateExp as a literal
			result.append(objectTemplateExp.getName());
			result.append(" : ");
			EClassifier type = objectTemplateExp.getType();
			if (type != null)
				result.append(type.getName());
		}
		List<PropertyTemplateItem> parts = objectTemplateExp.getPart();
		if (parts.size() > 0) {
			result.append(" {");
			boolean first = true;
			for (PropertyTemplateItem part : parts) {
				if (!first)
					result.append(",");
				result.append(visitPropertyTemplateItem(part));
				first = false;
			}
			result.append("}");
		}
		else
			result.append(" {}");
		return result.toString();
	}
	
    public String visitPropertyTemplateItem(PropertyTemplateItem propertyTemplateItem) {
        StringBuffer result = new StringBuffer();
		EStructuralFeature property = propertyTemplateItem.getReferredProperty();
		if (property != null)
			result.append(property.getName());
		result.append(" = ");
		OCLExpression value = propertyTemplateItem.getValue();
		if (value != null)
			result.append(value.accept(this));
		return result.toString();
    }
}
