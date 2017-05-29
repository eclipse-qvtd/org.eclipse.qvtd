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
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A IteratorVariableAnalysis provides the degenerate analysis of an IteratorVariable.
 */
public class IteratorVariable2Variable extends AbstractVariable2Variable
{
	protected final @NonNull IteratorVariable rIteratorVariable;
	protected final @NonNull IteratorVariable cIteratorVariable;

	protected IteratorVariable2Variable(@NonNull Variables2Variables variablesAnalysis, @NonNull IteratorVariable rIteratorVariable) {
		super(variablesAnalysis, rIteratorVariable);
		this.rIteratorVariable = rIteratorVariable;
		this.cIteratorVariable = variablesAnalysis.createIteratorVariable(name, QVTrelationUtil.getType(rIteratorVariable), rIteratorVariable.isIsRequired());
	}

	@Override
	public @Nullable CorePattern getCorePattern() {
		return variablesAnalysis.cMiddleBottomPattern;
	}

	@Override
	public @NonNull Variable getCoreVariable() {
		return cIteratorVariable;
	}

	@Override
	public @Nullable IteratorVariable getRelationVariable() {
		return rIteratorVariable;
	}
}