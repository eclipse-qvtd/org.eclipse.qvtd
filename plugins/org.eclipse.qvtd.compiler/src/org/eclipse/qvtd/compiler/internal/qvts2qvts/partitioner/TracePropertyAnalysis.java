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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * Each TracePropertyAnalysis identifies the usage of one middle trace property.
 */
public class TracePropertyAnalysis extends TraceElementAnalysis
{
	protected final @NonNull PropertyDatum tracePropertyDatum;

	public TracePropertyAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		super(transformationAnalysis);
		this.tracePropertyDatum = tracePropertyDatum;
		assert tracePropertyDatum.getReferredTypedModel() == transformationAnalysis.getScheduleManager().getTraceTypedModel();
	}

	@Override
	public String getName() {
		return tracePropertyDatum.getName();
	}

	public @NonNull Iterable<@NonNull TracePropertyAnalysis> getSuperTracePropertyAnalyses() {
		List<@NonNull TracePropertyAnalysis> tracePropertyAnalyses = new ArrayList<>();
		ClassDatum traceClassDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
		TraceClassAnalysis traceClassAnalysis = transformationAnalysis.getTraceClassAnalysis(traceClassDatum);
		for (@NonNull TraceClassAnalysis superTraceClassAnalysis : traceClassAnalysis.getSuperTraceClassAnalyses()) {
			ClassDatum superTraceClassDatum = superTraceClassAnalysis.getClassDatum();
			PropertyDatum propertyDatum = NameUtil.getNameable(superTraceClassDatum.getOwnedPropertyDatums(), getName());
			if (propertyDatum != null) {
				TracePropertyAnalysis tracePropertyAnalysis = transformationAnalysis.getTracePropertyAnalysis(propertyDatum);
				if (!tracePropertyAnalyses.contains(tracePropertyAnalysis)) {
					tracePropertyAnalyses.add(tracePropertyAnalysis);
				}
			}
		}
		assert tracePropertyAnalyses.contains(this);
		return tracePropertyAnalyses;
	}

	public @NonNull Property getTraceProperty() {
		return QVTscheduleUtil.getReferredProperty(tracePropertyDatum);
	}

	@Override
	public String toString() {
		return tracePropertyDatum.toString();
	}
}
