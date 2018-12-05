/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2MiddleType;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * VariableDeclaration2MiddleProperty accumulates the requirements on the trace property for a pattern variable.
 */
public abstract class VariableDeclaration2TraceProperty extends Element2MiddleProperty
{
	/**
	 * The variable whose value is persisted by the trace property.
	 */
	protected final @NonNull VariableDeclaration variable;

	protected VariableDeclaration2TraceProperty(@NonNull RuleAnalysis2MiddleType relation2middleType, @NonNull String nameHint, @NonNull VariableDeclaration variable) {
		super(relation2middleType, nameHint, QVTrelationUtil.getClass(variable), variable.isIsRequired());
		this.variable = variable;
	}

	protected VariableDeclaration2TraceProperty(@NonNull OverrideableVariableDeclaration2TraceProperty overrideableVariableDeclaration2TraceProperty, @NonNull VariableDeclaration variable) {
		super(overrideableVariableDeclaration2TraceProperty.relation2middleType, overrideableVariableDeclaration2TraceProperty.nameHint, overrideableVariableDeclaration2TraceProperty.type, overrideableVariableDeclaration2TraceProperty.isRequired);
		this.variable = variable;
	}

	public abstract @NonNull VariableDeclaration getOverrideableVariable();

	public abstract @NonNull VariableDeclaration getOverridingVariable();

	public abstract @NonNull TypedModel getTypedModel();

	//	public abstract void refineProperty(@Nullable TypedModel rTypedModel, boolean isNestedOneToOne);
}