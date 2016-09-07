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
package org.eclipse.qvtd.pivot.qvtcore.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBaseFactory;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcorebase.VariableAssignment;

/**
 * QVTcoreHelper provides helper routines to assist creation of QVTcore model elements.
 */
public class QVTcoreHelper extends QVTbaseHelper
{
	public QVTcoreHelper(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	public @NonNull Mapping createMapping(@Nullable String name) {
		Mapping coreMapping = QVTcoreFactory.eINSTANCE.createMapping();
		coreMapping.setName(name);
		GuardPattern guardPattern = QVTcoreBaseFactory.eINSTANCE.createGuardPattern();
		coreMapping.setGuardPattern(guardPattern);
		BottomPattern bottomPattern = QVTcoreBaseFactory.eINSTANCE.createBottomPattern();
		coreMapping.setBottomPattern(bottomPattern);
		return coreMapping;
	}

	public @NonNull NavigationAssignment createNavigationAssignment(@NonNull OCLExpression asSlotExpression, @NonNull Property asProperty, @NonNull OCLExpression asValueExpression) {
		NavigationAssignment asNavigationAssignment;
		if (asProperty.isIsImplicit()) {
			OppositePropertyAssignment asPropertyAssignment = QVTcoreBaseFactory.eINSTANCE.createOppositePropertyAssignment();
			asPropertyAssignment.setTargetProperty(asProperty.getOpposite());
			asNavigationAssignment = asPropertyAssignment;
		}
		else {
			PropertyAssignment asPropertyAssignment = QVTcoreBaseFactory.eINSTANCE.createPropertyAssignment();
			asPropertyAssignment.setTargetProperty(asProperty);
			asNavigationAssignment = asPropertyAssignment;
		}
		asNavigationAssignment.setSlotExpression(asSlotExpression);
		asNavigationAssignment.setValue(asValueExpression);
		return asNavigationAssignment;
	}

	public @NonNull RealizedVariable createRealizedVariable(@NonNull String name, @NonNull Type type) {
		RealizedVariable realizedVariable = QVTcoreBaseFactory.eINSTANCE.createRealizedVariable();
		realizedVariable.setName(name);
		realizedVariable.setType(type);
		realizedVariable.setIsRequired(true);;
		return realizedVariable;
	}

	public @NonNull VariableAssignment createVariableAssignment(@NonNull Variable asVariable, @NonNull OCLExpression asValueExpression) {
		VariableAssignment asVariableAssignment = QVTcoreBaseFactory.eINSTANCE.createVariableAssignment();
		asVariableAssignment.setTargetVariable(asVariable);
		asVariableAssignment.setValue(asValueExpression);
		return asVariableAssignment;
	}
}