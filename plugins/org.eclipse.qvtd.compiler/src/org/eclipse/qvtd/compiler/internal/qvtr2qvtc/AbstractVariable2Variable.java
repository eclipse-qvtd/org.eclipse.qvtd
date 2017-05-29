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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * An AbstractVariableAnalysis provides the abstract accumulation the usage of a core or relation variable.
 * Derived CoreVariableAnalysis/RelationVariableAnalysis/ThisVariableAnalysis provide real functionality.
 */
public abstract class AbstractVariable2Variable implements Variable2Variable
{
	protected final @NonNull Variables2Variables variablesAnalysis;
	protected final @NonNull String name;

	protected AbstractVariable2Variable(@NonNull Variables2Variables variablesAnalysis, @NonNull String name) {
		this.variablesAnalysis = variablesAnalysis;
		this.name = variablesAnalysis.getUniqueVariableName(name, this);
	}

	protected AbstractVariable2Variable(@NonNull Variables2Variables variablesAnalysis, @NonNull Variable rThisVariable) {
		this.variablesAnalysis = variablesAnalysis;
		this.name = ClassUtil.nonNullState(rThisVariable.getName());
		assert rThisVariable.eContainer() instanceof RelationalTransformation;
	}

	@Override
	public void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression, @Nullable Boolean isPartial) throws CompilerChainException {
		System.err.println("Unexpected " + getClass().getSimpleName() + ".addNavigationAssignment for " + this);
	}

	@Override
	public void check() {}

	@Override
	public boolean hasWhenDomain() {
		System.err.println("Unexpected " + getClass().getSimpleName() + ".hasWhenDomain for " + this);
		return false;
	}

	@Override
	public void setIsEnforcedBound(@Nullable TemplateExp rTemplateExp, @NonNull TypedModel rEnforcedTypedModel, @Nullable Key rKey) {
		System.err.println("Unexpected " + getClass().getSimpleName() + ".setIsEnforcedBound for " + this);
	}

	@Override
	public void setIsEnforcedReferred() {
		System.err.println("Unexpected " + getClass().getSimpleName() + ".setIsEnforcedReferred for " + this);
	}

	@Override
	public void setIsRoot() {
		throw new IllegalStateException("Unexpected " + getClass().getSimpleName() + ".setIsRoot for " + this);
	}

	@Override
	public void setOtherBound(@NonNull TypedModel rOtherTypedModel) {
		System.err.println("Unexpected " + getClass().getSimpleName() + ".setOtherBound for " + this);
	}

	@Override
	public void setOtherReferred(@NonNull TypedModel rOtherTypedModel) {
		System.err.println("Unexpected " + getClass().getSimpleName() + ".setOtherReferred for " + this);
	}

	@Override
	public void setPredicate(@NonNull TypedModel rPredicateTypedModel) {
		System.err.println("Unexpected " + getClass().getSimpleName() + ".setPredicate for " + this);
	}

	@Override
	public void setWhen(@NonNull TypedModel rWhenTypedModel) {
		System.err.println("Unexpected " + getClass().getSimpleName() + ".setWhen for " + this);
	}

	@Override
	public void setWhere(@NonNull TypedModel rWhereTypedModel) {
		System.err.println("Unexpected " + getClass().getSimpleName() + ".setWhere for " + this);
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}