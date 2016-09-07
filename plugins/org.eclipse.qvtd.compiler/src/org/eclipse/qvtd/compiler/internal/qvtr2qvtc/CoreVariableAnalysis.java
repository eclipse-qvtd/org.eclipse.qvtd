/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;

/**
 * A CoreVariableAnalysis accumulates the usage of a core variable that has no relation variable counterpart and eventually synthesises an appropriate core variable.
 */
public class CoreVariableAnalysis extends AbstractVariableAnalysis
{
	private @NonNull Variable cVariable;

	public CoreVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull String name, @NonNull Type type, @Nullable OCLExpression initValue) {
		super(variablesAnalysis, name);
		this.cVariable = variablesAnalysis.createVariable(this.name, type, true, initValue);
	}

	public CoreVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull String name, @NonNull Type type) {
		super(variablesAnalysis, name);
		this.cVariable = variablesAnalysis.createRealizedVariable(this.name, type);
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
}