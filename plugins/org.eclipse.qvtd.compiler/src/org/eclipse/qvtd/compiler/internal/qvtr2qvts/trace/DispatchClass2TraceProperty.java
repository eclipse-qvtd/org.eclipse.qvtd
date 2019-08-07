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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * DispatchClass2TraceProperty accumulates the requirements on the dispatch property for an override hierarchy.
 */
public class DispatchClass2TraceProperty extends Element2MiddleProperty
{
	/**
	 * The relation whose trace is composed by the dispatch property.
	 */
	protected final @NonNull Relation2TraceClass relation2traceClass;

	protected DispatchClass2TraceProperty(@NonNull Rule2MiddleType relation2middleType, @NonNull String nameHint, @NonNull Relation2TraceClass relation2traceClass) {
		super(relation2middleType, nameHint, relation2traceClass.getMiddleClass(), false);
		this.relation2traceClass = relation2traceClass;
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		TypedModel traceTypedModel = relation2traceClass.getTraceTypedModel();
		Property dispatchProperty = createMiddleProperty(traceTypedModel, nameHint, true);
		dispatchProperty.setIsComposite(true);
		Property oppositeProperty = dispatchProperty.getOpposite();
		oppositeProperty.setName(QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME);
		oppositeProperty.setIsImplicit(false);
		oppositeProperty.setIsRequired(true);
		return dispatchProperty;
	}
}