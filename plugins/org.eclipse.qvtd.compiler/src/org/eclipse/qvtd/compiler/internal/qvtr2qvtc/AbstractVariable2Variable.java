/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

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

	protected AbstractVariable2Variable(@NonNull Variables2Variables variablesAnalysis, @NonNull VariableDeclaration rVariable) {
		this.variablesAnalysis = variablesAnalysis;
		this.name = QVTrelationUtil.getName(rVariable);
	}

	@Override
	public void addNavigationAssignment(@NonNull Property targetProperty, @NonNull OCLExpression cExpression, @Nullable Boolean isPartial) throws CompilerChainException {
		QVTruntimeUtil.errPrintln("Unexpected " + getClass().getSimpleName() + ".addNavigationAssignment for " + this);
	}

	@Override
	public void check() {}

	@Override
	public boolean hasWhenDomain() {
		QVTruntimeUtil.errPrintln("Unexpected " + getClass().getSimpleName() + ".hasWhenDomain for " + this);
		return false;
	}

	@Override
	public boolean isRealized() {
		return false;
	}

	@Override
	public void setIsEnforcedBound(@Nullable TemplateExp rTemplateExp, @NonNull TypedModel rEnforcedTypedModel, @Nullable Key rKey) {
		QVTruntimeUtil.errPrintln("Unexpected " + getClass().getSimpleName() + ".setIsEnforcedBound for " + this);
	}

	@Override
	public void setIsEnforcedReferred() {
		QVTruntimeUtil.errPrintln("Unexpected " + getClass().getSimpleName() + ".setIsEnforcedReferred for " + this);
	}

	@Override
	public void setIsRoot() {
		throw new IllegalStateException("Unexpected " + getClass().getSimpleName() + ".setIsRoot for " + this);
	}

	@Override
	public void setOtherBound(@NonNull TypedModel rOtherTypedModel) {
		QVTruntimeUtil.errPrintln("Unexpected " + getClass().getSimpleName() + ".setOtherBound for " + this);
	}

	@Override
	public void setOtherReferred(@NonNull TypedModel rOtherTypedModel) {
		QVTruntimeUtil.errPrintln("Unexpected " + getClass().getSimpleName() + ".setOtherReferred for " + this);
	}

	@Override
	public void setPredicate(@NonNull TypedModel rPredicateTypedModel) {
		QVTruntimeUtil.errPrintln("Unexpected " + getClass().getSimpleName() + ".setPredicate for " + this);
	}

	@Override
	public void setWhen(@NonNull TypedModel rWhenTypedModel) {
		QVTruntimeUtil.errPrintln("Unexpected " + getClass().getSimpleName() + ".setWhen for " + this);
	}

	@Override
	public void setWhere(@NonNull TypedModel rWhereTypedModel) {
		QVTruntimeUtil.errPrintln("Unexpected " + getClass().getSimpleName() + ".setWhere for " + this);
	}

	@Override
	public @NonNull String toString() {
		return name;
	}
}