/*******************************************************************************
 * Copyright (c) 2017, 2020 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;

/**
 * Relation2SuccessProperty defines the future trace property that identifies the invocation
 * success of a relation execution.
 */
public class Relation2InheritedProperty extends Element2MiddleProperty
{
	private final @NonNull Property property;

	public Relation2InheritedProperty(@NonNull Relation2MiddleType relation2middleType, @NonNull Property property) {
		super(relation2middleType, QVTbaseUtil.getName(property), relation2middleType.getTransformation2TracePackage().getBooleanType(), false);
		this.property = property;
		ScheduleManager scheduleManager = relation2middleType.getScheduleManager();
		TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
		ClassDatum sourceClassDatum = scheduleManager.getClassDatum(traceTypedModel, QVTbaseUtil.getOwningClass(property));
		scheduleManager.getPropertyDatum(sourceClassDatum, property, null);		// FIXME why is this remedial installation needed?
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		return property;
	}
}