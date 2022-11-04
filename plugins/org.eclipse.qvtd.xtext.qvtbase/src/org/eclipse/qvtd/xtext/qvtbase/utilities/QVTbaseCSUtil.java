/*******************************************************************************
 * Copyright (c) 2022 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtbase.utilities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.LanguageExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.Pivotable;
import org.eclipse.ocl.xtext.base.utilities.ElementUtil;
import org.eclipse.ocl.xtext.basecs.ElementCS;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

public class QVTbaseCSUtil extends ElementUtil
{
	public static @Nullable Rule basicGetContainingRule(@NonNull ElementCS csElement) {
		for (EObject eObject = csElement; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof Pivotable) {
				Element asElement = ((Pivotable)eObject).getPivot();
				if (asElement != null) {
					Rule asRule = QVTbaseUtil.basicGetContainingRule(asElement);
					if (asRule != null) {
						return asRule;
					}
				}
			}
		}
		return null;
	}

	public static @NonNull VariableDeclaration getContextVariable(@NonNull ElementCS csElement) {
		VariableDeclaration contextVariable = null;		// Always ParameterVariable
		Rule asRule = QVTbaseCSUtil.basicGetContainingRule(csElement);
		if (asRule != null) {
			contextVariable = QVTbaseUtil.getContextVariable(asRule);
		}
		else {
			Operation asOperation = ElementUtil.basicGetContainingOperation(csElement);
			if (asOperation != null) {
				LanguageExpression asExpression = asOperation.getBodyExpression();
				if (asExpression instanceof ExpressionInOCL) {		// Always true
					contextVariable = ((ExpressionInOCL)asExpression).getOwnedContext();
				}
			}
		}
		assert contextVariable != null;			// XXX
		return contextVariable;
	}
}
