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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;

/**
 * Relation2SuccessProperty defines the future trace property that identifies the invocation
 * success of a relation execution.
 */
public class Relation2SuccessProperty extends Element2MiddleProperty
{
	public Relation2SuccessProperty(@NonNull RelationAnalysis2MiddleType relationAnalysis2middleType, @NonNull String nameHint) {
		super(relationAnalysis2middleType, nameHint, relationAnalysis2middleType.getTransformation2TracePackage().getBooleanType(), false);
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		Property traceProperty = createMiddleProperty(null, nameHint, false);
		traceProperty.setIsRequired(false);
		return traceProperty;
	}
}