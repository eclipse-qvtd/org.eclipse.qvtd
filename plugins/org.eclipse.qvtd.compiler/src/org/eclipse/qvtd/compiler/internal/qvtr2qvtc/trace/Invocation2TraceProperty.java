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
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * Invocation2TraceProperty defines the requirements on the trace property for an invocation signature.
 */
class Invocation2TraceProperty extends Element2MiddleProperty
{
	/**
	 * The invocation whose use is persisted by the signature property.
	 */
	//		final @NonNull RelationCallExp invocation;

	public Invocation2TraceProperty(@NonNull Relation2TraceClass relation2traceClass, @NonNull String name, @NonNull Relation invokedRelation) {
		super(relation2traceClass, name, relation2traceClass.getRelationalTransformation2TracePackage().getSignatureClass(invokedRelation), true);
	}

	/**
	 * Create the middle Property.
	 */
	@Override
	protected @NonNull Property createMiddleProperty() {
		return createMiddleProperty(null, true);
	}
}