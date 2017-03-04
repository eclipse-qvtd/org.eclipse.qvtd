/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A LetVariableAnalysis provides the degenerate analysis of a LetVariable.
 */
public class LetVariableAnalysis extends AbstractVariableAnalysis
{
	protected final @NonNull LetVariable rLetVariable;
	protected final @NonNull LetVariable cLetVariable;

	protected LetVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull LetVariable rLetVariable) {
		super(variablesAnalysis, rLetVariable);
		this.rLetVariable = rLetVariable;
		this.cLetVariable = variablesAnalysis.createLetVariable(name, QVTrelationUtil.getType(rLetVariable), rLetVariable.isIsRequired());
	}

	@Override
	public @Nullable CorePattern getCorePattern() {
		return variablesAnalysis.cMiddleBottomPattern;
	}

	@Override
	public @NonNull Variable getCoreVariable() {
		return cLetVariable;
	}

	@Override
	public @Nullable LetVariable getRelationVariable() {
		return rLetVariable;
	}
}