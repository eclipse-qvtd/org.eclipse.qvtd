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
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;

/**
 * A ThisVariableAnalysis describes the 'this' variable in relation and core transformations.
 * It requires no pattern or synthesis in a core mapping.
 */
public class ThisVariableAnalysis extends AbstractVariableAnalysis
{
	private @NonNull Variable rThisVariable;
	private @NonNull Variable cThisVariable;

	public ThisVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull Variable rThisVariable, @NonNull Variable cThisVariable) {
		super(variablesAnalysis, rThisVariable);
		this.rThisVariable = rThisVariable;
		this.cThisVariable = cThisVariable;
	}

	@Override
	public @Nullable CorePattern getCorePattern() {
		return null;
	}

	@Override
	public @NonNull Variable getCoreVariable() {
		return cThisVariable;
	}

	@Override
	public @NonNull Variable getRelationVariable() {
		return rThisVariable;
	}

	@Override
	public void setWhen(@NonNull CoreDomain cWhenDomain) {}

	@Override
	public void setWhere(@NonNull CoreDomain cWhereDomain) {}
}