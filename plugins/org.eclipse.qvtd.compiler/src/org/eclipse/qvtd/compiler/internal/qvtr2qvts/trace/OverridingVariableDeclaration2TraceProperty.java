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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * An OverridingVariableDeclaration2TraceProperty accumulates the requirements on the trace property for a root pattern variable of an overriding relation.
 */
public class OverridingVariableDeclaration2TraceProperty extends VariableDeclaration2TraceProperty
{
	/**
	 * The variable whose value is persisted by the trace property.
	 */
	protected final @NonNull OverrideableVariableDeclaration2TraceProperty overrideableVariableDeclaration2TraceProperty;

	public OverridingVariableDeclaration2TraceProperty(@NonNull VariableDeclaration overridingVariable, @NonNull OverrideableVariableDeclaration2TraceProperty overrideableVariableDeclaration2TraceProperty) {
		super(overrideableVariableDeclaration2TraceProperty, overridingVariable);
		this.overrideableVariableDeclaration2TraceProperty = overrideableVariableDeclaration2TraceProperty;
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull VariableDeclaration getOverrideableVariable() {
		return overrideableVariableDeclaration2TraceProperty.getOverrideableVariable();
	}

	@Override
	public @NonNull VariableDeclaration getOverridingVariable() {
		return variable;
	}

	@Override
	public @NonNull Property getTraceProperty() {
		return overrideableVariableDeclaration2TraceProperty.getTraceProperty();
	}

	@Override
	public @NonNull TypedModel getTypedModel() {
		return overrideableVariableDeclaration2TraceProperty.getTypedModel();
	}

	@Override
	public String toString() {
		return overrideableVariableDeclaration2TraceProperty.toString();
	}
}