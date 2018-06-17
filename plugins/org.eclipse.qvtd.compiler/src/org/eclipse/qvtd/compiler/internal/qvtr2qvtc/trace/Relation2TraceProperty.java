/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;

/**
 * Relation2TraceProperty defines the future trace property that identifies the trace class passed in to
 * a non-top relation.
 */
class Relation2TraceProperty extends Element2MiddleProperty
{
	public Relation2TraceProperty(@NonNull Relation2MiddleType relation2middleType) {
		super(relation2middleType, QVTrNameGenerator.TRACECLASS_PROPERTY_NAME, relation2middleType.getMiddleClass(), false);
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		Property traceProperty = createMiddleProperty(null, QVTrNameGenerator.TRACECLASS_PROPERTY_NAME, false);
		return traceProperty;
	}
}