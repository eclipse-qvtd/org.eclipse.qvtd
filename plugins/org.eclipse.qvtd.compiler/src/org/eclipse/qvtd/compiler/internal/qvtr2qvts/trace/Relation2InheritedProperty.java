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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;

/**
 * Relation2SuccessProperty defines the future trace property that identifies the invocation
 * success of a relation execution.
 */
public class Relation2InheritedProperty extends Element2MiddleProperty
{
	private final @NonNull Property property;

	public Relation2InheritedProperty(@NonNull RelationAnalysis2MiddleType relationAnalysis2middleType, @NonNull Property property) {
		super(relationAnalysis2middleType, QVTbaseUtil.getName(property), relationAnalysis2middleType.getTransformation2TracePackage().getBooleanType(), false);
		this.property = property;
		ScheduleManager scheduleManager = relationAnalysis2middleType.getRuleAnalysis().getScheduleManager();
		ClassDatum classDatum = scheduleManager.getClassDatum(scheduleManager.getTraceTypedModel(), QVTbaseUtil.getOwningClass(property));
		scheduleManager.getPropertyDatum(classDatum, property);		// FIXME why is this remedial installatioin needed?
	}

	@Override
	protected @NonNull Property createTraceProperty() {
		return property;
	}
}