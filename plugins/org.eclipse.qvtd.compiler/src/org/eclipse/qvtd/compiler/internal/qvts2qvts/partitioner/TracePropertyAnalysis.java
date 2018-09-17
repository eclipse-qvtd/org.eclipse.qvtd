/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.PartialRegionAnalysis;
//import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * Each TracePropertyAnalysis identifies the usage of one middle trace property.
 */
public abstract class TracePropertyAnalysis<@NonNull RA extends PartialRegionAnalysis<@NonNull RA>> extends TraceElementAnalysis<@NonNull RA>
{
	protected final @NonNull TransformationAnalysis<@NonNull RA> regionsAnalysis;
	protected final@NonNull TraceClassAnalysis<@NonNull RA> traceClassAnalysis;
	protected final @NonNull PropertyDatum tracePropertyDatum;

	protected TracePropertyAnalysis(@NonNull TransformationAnalysis<@NonNull RA> regionsAnalysis, @NonNull TraceClassAnalysis<@NonNull RA> traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		this.regionsAnalysis = regionsAnalysis;
		this.traceClassAnalysis = traceClassAnalysis;
		this.tracePropertyDatum = tracePropertyDatum;
		//	assert tracePropertyDatum.getReferredTypedModel() == regionsAnalysis.getScheduleManager().getTraceTypedModel();
		//		ClassDatum traceClassDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
		assert regionsAnalysis.getTraceClassAnalysis(QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum)) == traceClassAnalysis;
	}

	@Override
	public String getName() {
		return tracePropertyDatum.getName();
	}

	public @NonNull Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> getSuperTracePropertyAnalyses() {
		List<@NonNull TracePropertyAnalysis<@NonNull RA>> tracePropertyAnalyses = new ArrayList<>();
		//		ClassDatum traceClassDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
		//		TraceClassAnalysis<@NonNull RA> traceClassAnalysis = regionsAnalysis.getTraceClassAnalysis(traceClassDatum);
		for (@NonNull TraceClassAnalysis<@NonNull RA> superTraceClassAnalysis : traceClassAnalysis.getSuperTraceClassAnalyses()) {
			ClassDatum superTraceClassDatum = superTraceClassAnalysis.getClassDatum();
			PropertyDatum propertyDatum = NameUtil.getNameable(superTraceClassDatum.getOwnedPropertyDatums(), getName());		// FIXME avoid 'name' usage - use tracePropertyDatum(.referredProperty)
			if (propertyDatum != null) {
				TracePropertyAnalysis<@NonNull RA> tracePropertyAnalysis = regionsAnalysis.basicGetTracePropertyAnalysis(propertyDatum);	// FIXME is missing acceptable
				if ((tracePropertyAnalysis != null) && !tracePropertyAnalyses.contains(tracePropertyAnalysis)) {
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
