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
 * Invocation2TraceProperty defines the future trace property that identifies an invoked mapping, which may be a non-top where invocation, or a top when invocation.
 */
public class Invocation2TraceProperty extends Element2MiddleProperty
{
	public Invocation2TraceProperty(@NonNull RelationAnalysis2MiddleType invokingRelation2middleType, @NonNull String nameHint, org.eclipse.ocl.pivot.@NonNull Class type, boolean isRequired) {
		super(invokingRelation2middleType, nameHint, type, isRequired);
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		Property traceProperty = createMiddleProperty(null, nameHint, false);
		//		traceProperty.setIsComposite(true);
		return traceProperty;
	}
}