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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;

/**
 * Relation2ResultProperty defines the future trace property that identifies the trace
 * class of a non-top override relation execution.
 */
class Relation2ResultProperty extends Element2MiddleProperty
{
	public Relation2ResultProperty(@NonNull Relation2MiddleType relation2middleType, org.eclipse.ocl.pivot.@NonNull Class traceClassType) {
		super(relation2middleType, QVTrNameGenerator.INVOCATIONCLASS_RESULT_PROPERTY_NAME, traceClassType, false);
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		Property traceProperty = createMiddleProperty(null, QVTrNameGenerator.INVOCATIONCLASS_RESULT_PROPERTY_NAME, false);
		traceProperty.setIsRequired(false);
		return traceProperty;
	}
}