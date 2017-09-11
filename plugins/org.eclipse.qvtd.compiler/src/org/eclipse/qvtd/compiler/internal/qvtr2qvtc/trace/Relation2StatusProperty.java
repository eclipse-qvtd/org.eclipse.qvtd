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
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;

/**
 * Relation2StatusProperty defines the future trace property that identifies the invocation
 * status of a relation execution.
 */
class Relation2StatusProperty extends Element2MiddleProperty
{
	public Relation2StatusProperty(@NonNull Relation2MiddleType relation2middleType) {
		super(relation2middleType, QVTrNameGenerator.TRACECLASS_STATUS_PROPERTY_NAME, relation2middleType.getRelationalTransformation2TracePackage().getBooleanType(), false);
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		Property traceProperty = createMiddleProperty(null, QVTrNameGenerator.TRACECLASS_STATUS_PROPERTY_NAME, false);
		traceProperty.setIsRequired(false);
		return traceProperty;
	}
}