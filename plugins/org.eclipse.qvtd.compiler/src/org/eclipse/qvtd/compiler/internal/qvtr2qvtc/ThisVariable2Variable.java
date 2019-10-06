/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * A ThisVariableAnalysis describes the 'this' variable in relation and core transformations.
 * It requires no pattern or synthesis in a core mapping.
 */
public class ThisVariable2Variable extends AbstractVariable2Variable
{
	private @NonNull VariableDeclaration rThisVariable;
	private @NonNull VariableDeclaration cThisVariable;

	public ThisVariable2Variable(@NonNull Variables2Variables variablesAnalysis, @NonNull VariableDeclaration rThisVariable, @NonNull VariableDeclaration cThisVariable) {
		super(variablesAnalysis, rThisVariable);
		assert rThisVariable.eContainer() instanceof RelationalTransformation;
		this.rThisVariable = rThisVariable;
		this.cThisVariable = cThisVariable;
	}

	@Override
	public @Nullable CorePattern getCorePattern() {
		return null;
	}

	@Override
	public @NonNull VariableDeclaration getCoreVariable() {
		return cThisVariable;
	}

	@Override
	public @NonNull VariableDeclaration getRelationVariable() {
		return rThisVariable;
	}

	@Override
	public void setIsEnforcedReferred() {
		// this may be used in any domain;
	}

	@Override
	public void setOtherReferred(@NonNull TypedModel rOtherTypedModel) {}

	@Override
	public void setWhen(@NonNull TypedModel rWhenTypedModel) {}

	@Override
	public void setWhere(@NonNull TypedModel rWhereTypedModel) {}
}