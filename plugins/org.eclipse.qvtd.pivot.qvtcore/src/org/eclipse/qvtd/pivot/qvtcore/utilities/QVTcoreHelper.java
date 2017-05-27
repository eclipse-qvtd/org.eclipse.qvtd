/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.BottomVariable;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardVariable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;

/**
 * QVTcoreHelper provides helper routines to assist creation of QVTcore model elements.
 */
public class QVTcoreHelper extends QVTbaseHelper
{
	public QVTcoreHelper(@NonNull EnvironmentFactory environmentFactory) {
		super(environmentFactory);
	}

	public @NonNull BottomVariable createBottomVariable(@NonNull String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression asInitExpression) {
		BottomVariable asVariable = QVTcoreFactory.eINSTANCE.createBottomVariable();
		asVariable.setName(name);
		setType(asVariable, asType, isRequired);
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	public @NonNull GuardVariable createGuardVariable(@NonNull String name, @NonNull Type asType, boolean isRequired, @Nullable OCLExpression asInitExpression) {
		GuardVariable asVariable = QVTcoreFactory.eINSTANCE.createGuardVariable();
		asVariable.setName(name);
		setType(asVariable, asType, isRequired);
		asVariable.setOwnedInit(asInitExpression);
		return asVariable;
	}

	public @NonNull Mapping createMapping(@Nullable String name) {
		Mapping coreMapping = QVTcoreFactory.eINSTANCE.createMapping();
		coreMapping.setName(name);
		GuardPattern guardPattern = QVTcoreFactory.eINSTANCE.createGuardPattern();
		coreMapping.setGuardPattern(guardPattern);
		BottomPattern bottomPattern = QVTcoreFactory.eINSTANCE.createBottomPattern();
		coreMapping.setBottomPattern(bottomPattern);
		return coreMapping;
	}

	public @NonNull NavigationAssignment createNavigationAssignment(@NonNull OCLExpression asSlotExpression, @NonNull Property asProperty, @NonNull OCLExpression asValueExpression, boolean isPartial) {
		NavigationAssignment asNavigationAssignment;
		if (asProperty.isIsImplicit()) {
			OppositePropertyAssignment asPropertyAssignment = QVTcoreFactory.eINSTANCE.createOppositePropertyAssignment();
			asPropertyAssignment.setTargetProperty(asProperty.getOpposite());
			asNavigationAssignment = asPropertyAssignment;
		}
		else {
			PropertyAssignment asPropertyAssignment = QVTcoreFactory.eINSTANCE.createPropertyAssignment();
			asPropertyAssignment.setTargetProperty(asProperty);
			asNavigationAssignment = asPropertyAssignment;
		}
		asNavigationAssignment.setSlotExpression(asSlotExpression);
		asNavigationAssignment.setValue(asValueExpression);
		asNavigationAssignment.setIsDefault(false);
		asNavigationAssignment.setIsPartial(isPartial);
		return asNavigationAssignment;
	}

	public @NonNull RealizedVariable createRealizedVariable(@NonNull String name, @NonNull Type type) {
		RealizedVariable realizedVariable = QVTcoreFactory.eINSTANCE.createRealizedVariable();
		realizedVariable.setName(name);
		setType(realizedVariable, type, true);
		return realizedVariable;
	}

	public @NonNull VariableAssignment createVariableAssignment(@NonNull Variable asVariable, @NonNull OCLExpression asValueExpression) {
		VariableAssignment asVariableAssignment = QVTcoreFactory.eINSTANCE.createVariableAssignment();
		asVariableAssignment.setTargetVariable(asVariable);
		asVariableAssignment.setValue(asValueExpression);
		asVariableAssignment.setIsDefault(false);
		asVariableAssignment.setIsPartial(false);
		return asVariableAssignment;
	}
}