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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtcore.Area;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * An AbstractVariableAnalysis provides the abstract accumulation the usage of a core or relation variable.
 * Derived CoreVariableAnalysis/RelationVariableAnalysis/ThisVariableAnalysis provide real functionality.
 */
public abstract class AbstractVariableAnalysis implements VariableAnalysis
{
	protected final @NonNull VariablesAnalysis variablesAnalysis;
	protected final @NonNull String name;

	protected AbstractVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull String name) {
		this.variablesAnalysis = variablesAnalysis;
		this.name = variablesAnalysis.getUniqueVariableName(name, this);
	}

	protected AbstractVariableAnalysis(@NonNull VariablesAnalysis variablesAnalysis, @NonNull Variable rThisVariable) {
		this.variablesAnalysis = variablesAnalysis;
		this.name = ClassUtil.nonNullState(rThisVariable.getName());
		assert rThisVariable.eContainer() instanceof RelationalTransformation;
	}

	@Override
	public void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression, @Nullable Boolean isPartial) throws CompilerChainException {
		System.out.println("Unexpected " + getClass().getSimpleName() + ".addNavigationAssignment for " + this);
	}

	@Override
	public void check() {}

	@Override
	public boolean hasWhenDomain() {
		System.out.println("Unexpected " + getClass().getSimpleName() + ".hasWhenDomain for " + this);
		return false;
	}

	@Override
	public void setIsEnforcedBound(@Nullable TemplateExp rTemplateExp, @Nullable Key rKey) {
		System.out.println("Unexpected " + getClass().getSimpleName() + ".setIsEnforcedBound for " + this);
	}

	@Override
	public void setIsEnforcedReferred() {
		System.out.println("Unexpected " + getClass().getSimpleName() + ".setIsEnforcedReferred for " + this);
	}

	@Override
	public void setIsRoot() {
		throw new IllegalStateException("Unexpected " + getClass().getSimpleName() + ".setIsRoot for " + this);
	}

	@Override
	public void setOtherBound(@NonNull CoreDomain otherDomain) {
		System.out.println("Unexpected " + getClass().getSimpleName() + ".setOtherBound for " + this);
	}

	@Override
	public void setOtherReferred(@NonNull CoreDomain cOtherDomain) {
		System.out.println("Unexpected " + getClass().getSimpleName() + ".setOtherReferred for " + this);
	}

	@Override
	public void setPredicate(@NonNull Area cPredicateArea) {
		System.out.println("Unexpected " + getClass().getSimpleName() + ".setPredicate for " + this);
	}

	@Override
	public void setWhen(@NonNull CoreDomain cWhenDomain) {
		System.out.println("Unexpected " + getClass().getSimpleName() + ".setWhen for " + this);
	}

	@Override
	public void setWhere(@NonNull CoreDomain cWhereDomain) {
		System.out.println("Unexpected " + getClass().getSimpleName() + ".setWhere for " + this);
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}