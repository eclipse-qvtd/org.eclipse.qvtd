/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * Each TracePropertyAnalysis identifies the usage of one middle trace property.
 */
public class TracePropertyAnalysis extends TraceElementAnalysis
{
	protected final @NonNull PropertyDatum tracePropertyDatum;

	public TracePropertyAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull PropertyDatum tracePropertyDatum) {
		super(transformationPartitioner);
		this.tracePropertyDatum = tracePropertyDatum;
		assert tracePropertyDatum.getReferredTypedModel() == transformationPartitioner.getScheduleManager().getTraceTypedModel();
	}

	@Override
	public String getName() {
		return tracePropertyDatum.getName();
	}

	public @NonNull Property getTraceProperty() {
		return QVTscheduleUtil.getReferredProperty(tracePropertyDatum);
	}

	@Override
	public String toString() {
		return tracePropertyDatum.toString();
	}
}
