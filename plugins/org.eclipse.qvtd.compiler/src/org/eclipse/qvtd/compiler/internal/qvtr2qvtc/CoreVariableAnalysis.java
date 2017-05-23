/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;

/**
 * A CoreVariableAnalysis accumulates the usage of a core variable that has no relation variable counterpart and eventually synthesises an appropriate core variable.
 */
public class CoreVariableAnalysis extends AbstractVariableAnalysis
{
	private @NonNull Variable cVariable;

	public CoreVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull String name, @NonNull Type type, @Nullable OCLExpression initValue) {
		super(variablesAnalysis, name);
		this.cVariable = variablesAnalysis.createGuardVariable(this.name, type, true, initValue);
	}

	public CoreVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull String name, @NonNull Type type) {
		super(variablesAnalysis, name);
		this.cVariable = variablesAnalysis.createRealizedVariable(this.name, type);
	}

	/**
	 * Add the NavigationAssignment "cVariable.cProperty := cExpression" to the cBottomPattern inverting the usage
	 * of a Collection element assignment to "cExpression.cOppositeProperty := cVariable".
	 * @throws CompilerChainException
	 */
	@Override
	public void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression, @Nullable Boolean isPartial) throws CompilerChainException {
		Variable cVariable2 = getCoreVariable();
		List<@NonNull Assignment> cMiddleBottomAssignments = QVTcoreUtil.Internal.getOwnedAssignmentsList(variablesAnalysis.getMiddleBottomPattern());
		if (isPartial == null) {
			isPartial = targetProperty.isIsMany() && !(cExpression.getType() instanceof CollectionType);
		}
		//		if (isPartial == isPartial2) {
		VariableExp cSlotVariableExp = variablesAnalysis.createVariableExp(cVariable2);
		NavigationAssignment cAssignment = variablesAnalysis.createNavigationAssignment(cSlotVariableExp, targetProperty, cExpression, isPartial);
		QVTr2QVTc.SYNTHESIS.println("  addPropertyAssignment " + cAssignment);
		variablesAnalysis.assertNewAssignment(cMiddleBottomAssignments, cAssignment);
		cMiddleBottomAssignments.add(cAssignment);
	}

	@Override
	public @NonNull CorePattern getCorePattern() {
		return cVariable instanceof RealizedVariable ? variablesAnalysis.getMiddleBottomPattern() : variablesAnalysis.getMiddleGuardPattern();
	}

	public @NonNull RealizedVariable getCoreRealizedVariable() {
		return (@NonNull RealizedVariable) cVariable;
	}

	@Override
	public @NonNull Variable getCoreVariable() {
		return cVariable;
	}

	@Override
	public @Nullable Variable getRelationVariable() {
		return null;
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(cVariable);
	}
}