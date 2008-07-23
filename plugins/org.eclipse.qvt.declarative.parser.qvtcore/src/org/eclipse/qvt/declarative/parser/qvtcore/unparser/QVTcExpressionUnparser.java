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
package org.eclipse.qvt.declarative.parser.qvtcore.unparser;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.utilities.UMLReflection;
import org.eclipse.qvt.declarative.parser.unparser.OCLExpressionUnparser;

public abstract class QVTcExpressionUnparser extends OCLExpressionUnparser
{
	
	public QVTcExpressionUnparser(Resource resource, UMLReflection<?, EClassifier, EOperation, EStructuralFeature, EEnumLiteral, EParameter, EObject, CallOperationAction, SendSignalAction, Constraint> uml) {
		super(resource, uml);
	}

//	@Override protected ExpressionsSwitch<Object> createExpressionSwitch() {
//		return new QVTrExpressionUnparserSwitch();
//	}

//	protected EqvtCoreSwitch<Object> createCoreSwitch() {
//		return new QVTcCoreUnparserSwitch();
//	}

//	protected EqvtTemplateSwitch<Object> createTemplateSwitch() {
//		return new QVTrTemplateUnparserSwitch();
//	}

/*	protected Object doRelationSwitch(OCLExpression<?> oclExpression) {
		if (oclExpression != null)
			return relationSwitch.doSwitch(oclExpression);
		else
			append("_null_relation_");		
		return this;
	}

	protected Object doTemplateSwitch(OCLExpression<?> oclExpression) {
		if (oclExpression != null)
			return templateSwitch.doSwitch(oclExpression);
		else
			append("_null_template_");		
		return this;
	} */

	@Override protected void initialize() {
		super.initialize();
//		if (relationSwitch == null)
//			relationSwitch = createRelationSwitch();
//		if (templateSwitch == null)
//			templateSwitch = createTemplateSwitch();
	}
}
