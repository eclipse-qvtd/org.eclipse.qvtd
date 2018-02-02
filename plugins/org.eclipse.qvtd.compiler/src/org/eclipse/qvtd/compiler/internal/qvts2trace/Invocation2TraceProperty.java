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
package org.eclipse.qvtd.compiler.internal.qvts2trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;

/**
 * Invocation2TraceProperty defines the future trace property that identifies the invoked mapping for a non-top relation.
 */
public class Invocation2TraceProperty extends Element2MiddleProperty
{
	public Invocation2TraceProperty(@NonNull RuleAnalysis2MiddleType invokingRelation2middleType, @NonNull RuleAnalysis2MiddleType invokedRelation2middleType) {
		super(invokingRelation2middleType, invokedRelation2middleType.getName(), invokedRelation2middleType.getMiddleClass(), false);
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		Property traceProperty = createMiddleProperty(null, "invocation_" + nameHint, false);
		traceProperty.setIsComposite(true);
		return traceProperty;
	}
}