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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * Element2TraceProperty defines the requirements on a future trace property.
 * Derived classes support different kinds of Element.
 */
abstract class Element2TraceProperty implements Nameable
{
	/**
	 * The future trace class.
	 */
	protected final @NonNull Relation2TraceClass relation2traceClass;

	/**
	 * The unique name for the trace property.
	 */
	protected final @NonNull String name;

	/**
	 * The type the trace property.
	 */
	protected final org.eclipse.ocl.pivot.@NonNull Class type;

	/**
	 * The isRequired the trace property.
	 */
	protected final boolean isRequired;

	/**
	 * The lazily created trace property.
	 */
	private @Nullable Property traceProperty;

	protected Element2TraceProperty(@NonNull Relation2TraceClass relation2traceClass, @NonNull String name, org.eclipse.ocl.pivot.@NonNull Class type, boolean isRequired) {
		this.relation2traceClass = relation2traceClass;
		this.name = relation2traceClass.getUniqueTracePropertyName(this, name);
		this.type = type;
		this.isRequired = isRequired;
	}

	protected abstract @NonNull Property createTraceProperty();

	@Override
	public @NonNull String getName() {
		return name;
	}

	public @NonNull Property getTraceProperty() {
		Property traceProperty2 = traceProperty;
		if (traceProperty2 == null) {
			traceProperty = traceProperty2 = createTraceProperty();
		}
		return traceProperty2;
	}

	@Override
	public String toString() {
		return name + ":" + type + (isRequired? "[1]" : "[?]");
	}
}