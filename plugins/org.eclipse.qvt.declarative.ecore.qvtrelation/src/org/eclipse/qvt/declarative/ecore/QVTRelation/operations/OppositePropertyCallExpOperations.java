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
 * $Id: OppositePropertyCallExpOperations.java,v 1.3 2008/12/31 17:43:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.util.OCLUtil;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.qvt.declarative.ecore.QVTRelation.OppositePropertyCallExp;

public class OppositePropertyCallExpOperations extends AbstractQVTRelationOperations
{
	public static OppositePropertyCallExpOperations INSTANCE = new OppositePropertyCallExpOperations();

	/**
	 * Validates the PropertyIsReference constraint of '<em>Opposite Property Call Exp</em>'.
	 */
	public boolean checkPropertyIsReference(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EStructuralFeature property = oppositePropertyCallExp.getReferredProperty();
		if (property == null)
			return true;		// Multiplicity failure
		if (property instanceof EReference)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(property, context) };
		appendError(diagnostics, oppositePropertyCallExp, QVTRelationMessages._UI_OppositePropertyCallExp_PropertyIsNotAReference, messageSubstitutions);
		return false;
	}

	/**
	 * Validates the PropertyIsUnidirectional constraint of '<em>Opposite Property Call Exp</em>'.
	 */
	public boolean checkPropertyIsUnidirectional(OppositePropertyCallExp oppositePropertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
		EStructuralFeature property = oppositePropertyCallExp.getReferredProperty();
		if (!(property instanceof EReference))
			return true;
		EReference eOpposite = ((EReference)property).getEOpposite();
		if (eOpposite == null)
			return true;
		Object[] messageSubstitutions = new Object[] { getObjectLabel(property, context) };
		appendError(diagnostics, oppositePropertyCallExp, QVTRelationMessages._UI_OppositePropertyCallExp_PropertyIsNotUnidirectional, messageSubstitutions);
		return false;
	}

    /**
     * Check that the OppositePropertyCallExp has an appropriate type.
     */
    public boolean checkPropertyType(OppositePropertyCallExp propertyCallExp, DiagnosticChain diagnostics, Map<Object, Object> context) {
    	boolean allOk = true;
    	Environment<?, EClassifier, ?, EStructuralFeature, ?, ?, ?, ?, ?, ?, ?, ?> env = OCLUtil
				.getValidationEnvironment(propertyCallExp, context);		
		if (env != null) {
			OCLExpression<EClassifier> source = propertyCallExp.getSource();
			EStructuralFeature property = propertyCallExp.getReferredProperty();
			if ((property != null) && (source != null)) {
				EClassifier type = propertyCallExp.getType();			
				EClassifier refType = TypeUtil.resolveSetType(env, property.getEContainingClass());			
				if (!TypeUtil.exactTypeMatch(env, refType, type)) {
					allOk = false;
					Object[] messageSubstitutions = new Object[] { getObjectLabel(propertyCallExp, context), getObjectLabel(refType, context) };
					appendError(diagnostics, propertyCallExp, QVTRelationMessages._UI_OppositePropertyCallExp_TypeIsNotSetOfPropertyTarget, messageSubstitutions);
				}
			}
		}
        return allOk;
    }

} // PropertyCallExpOperations