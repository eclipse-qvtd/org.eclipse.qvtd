/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtcorebase.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;

/**
 * QVTcoreBaseHelper provides helper routines to assist creation of QVTcoreBase model elements.
 */
public class QVTcoreBaseHelper extends QVTbaseHelper
{
	public QVTcoreBaseHelper(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	public @NonNull PropertyAssignment createPropertyAssignment(@NonNull OCLExpression asSlotExpression, @NonNull Property asProperty, @NonNull OCLExpression asValueExpression) {
		PropertyAssignment asPropertyAssignment = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
		asPropertyAssignment.setSlotExpression(asSlotExpression);
		asPropertyAssignment.setTargetProperty(asProperty);
		asPropertyAssignment.setValue(asValueExpression);
		return asPropertyAssignment;
	}

	public @NonNull VariableAssignment createVariableAssignment(@NonNull Variable asVariable, @NonNull OCLExpression asValueExpression) {
		VariableAssignment asVariableAssignment = QVTcoreBaseFactory.eINSTANCE.createVariableAssignment();
		asVariableAssignment.setTargetVariable(asVariable);
		asVariableAssignment.setValue(asValueExpression);
		return asVariableAssignment;
	}
}