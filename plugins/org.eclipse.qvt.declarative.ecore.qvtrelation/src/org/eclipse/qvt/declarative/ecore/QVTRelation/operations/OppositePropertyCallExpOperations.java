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
 * $Id: OppositePropertyCallExpOperations.java,v 1.1 2008/09/09 20:59:19 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation.operations;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClassifier;
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
					if (diagnostics != null) {
						diagnostics.add
							(createDiagnostic
								(Diagnostic.ERROR,
								 DIAGNOSTIC_SOURCE,
								 0,
								 "_UI_OppositePropertyCallTypeMustBeSetOfPropertyTarget_diagnostic",
								 new Object[] { getObjectLabel(propertyCallExp, context), getObjectLabel(refType, context) },
								 new Object[] { propertyCallExp },
								 context));
					}
				}
			}
		}
        return allOk;
    }

} // PropertyCallExpOperations