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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2MiddleType;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * An OverrideableVariableDeclaration2TraceProperty accumulates the requirements on the trace property for a pattern variable.
 * If the pattern variable is a root variable, it may be overridden in an overriding relation.
 */
public class OverrideableVariableDeclaration2TraceProperty extends VariableDeclaration2TraceProperty
{
	/**
	 * The typed model within which the variable's reference is located.
	 */
	private final @Nullable TypedModel typedModel;

	/**
	 * True if there is known to be at most one instance of the trace class for each value of the trace variable.
	 * False if there might be more than one.
	 */
	private final boolean unitOpposite;

	public OverrideableVariableDeclaration2TraceProperty(@NonNull RuleAnalysis2MiddleType relation2middleType, @NonNull String nameHint, @Nullable TypedModel typedModel, @NonNull VariableDeclaration variable, boolean unitOpposite) {
		super(relation2middleType, nameHint, variable);
		this.typedModel = typedModel;
		this.unitOpposite = unitOpposite;
	}

	/**
	 * Create the name Property for a traceClass with a type. If unitOpposite is not set there may be many trace class instances referencing the same object through
	 * the trace property and so the implicit opposite must be a Bag.
	 */
	@Override
	protected @NonNull Property createTraceProperty() {
		return createMiddleProperty(typedModel, nameHint, unitOpposite);
	}

	@Override
	public @NonNull VariableDeclaration getOverrideableVariable() {
		return variable;
	}

	@Override
	public @NonNull VariableDeclaration getOverridingVariable() {
		return variable;
	}

	@Override
	public @Nullable TypedModel getTypedModel() {
		return typedModel;
	}

	@Override
	public String toString() {
		return String.valueOf(typedModel) + "!" + super.toString() + " " + (unitOpposite ? "SINGLE" : "MULTIPLE");
	}
}