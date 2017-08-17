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
import org.eclipse.ocl.pivot.Property;

/**
 * Relation2TraceProperty defines the mapping from a non-top Relation to the trace property that
 * identifies its invocation arguments.
 */
class Relation2TraceProperty extends Element2MiddleProperty
{
	public Relation2TraceProperty(@NonNull Relation2TraceClass relation2traceClass,
			@NonNull String name, org.eclipse.ocl.pivot.@NonNull Class type, boolean isRequired) {
		super(relation2traceClass, name, type, isRequired);
	}

	@Override
	protected @NonNull Property createMiddleProperty() {
		return createMiddleProperty(null, true);
	}
}