/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class or property.
 */
public abstract class AbstractPartialRegionPropertyAnalysis<@NonNull PRA extends PartialRegionsAnalysis<@NonNull PRA>> extends AbstractPartialRegionElementAnalysis<@NonNull PRA> implements PartialRegionPropertyAnalysis<@NonNull PRA>
{
	protected final @NonNull PartialRegionsAnalysis<@NonNull PRA> partialRegionsAnalysis;
	protected final @NonNull PartialRegionClassAnalysis<PRA> traceClassAnalysis;
	protected final @NonNull PropertyDatum tracePropertyDatum;

	protected AbstractPartialRegionPropertyAnalysis(@NonNull PartialRegionsAnalysis<@NonNull PRA> partialRegionsAnalysis, @NonNull PartialRegionClassAnalysis<PRA> traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		this.partialRegionsAnalysis = partialRegionsAnalysis;
		this.traceClassAnalysis = traceClassAnalysis;
		this.tracePropertyDatum = tracePropertyDatum;
		//	assert tracePropertyDatum.getReferredTypedModel() == partialRegionsAnalysis.getScheduleManager().getTraceTypedModel();
		//		ClassDatum traceClassDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
		assert partialRegionsAnalysis.getTraceClassAnalysis(QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum)) == traceClassAnalysis;
	}

	@Override
	public String getName() {
		return tracePropertyDatum.getName();
	}

	@Override
	public @NonNull PropertyDatum getPropertyDatum() {
		return tracePropertyDatum;
	}

	public @NonNull Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> getSuperTracePropertyAnalyses() {
		List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> tracePropertyAnalyses = new ArrayList<>();
		//		ClassDatum traceClassDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
		//		TraceClassAnalysis<@NonNull RA> traceClassAnalysis = regionsAnalysis.getTraceClassAnalysis(traceClassDatum);
		for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> superTraceClassAnalysis : traceClassAnalysis.getSuperTraceClassAnalyses()) {
			ClassDatum superTraceClassDatum = superTraceClassAnalysis.getClassDatum();
			PropertyDatum propertyDatum = NameUtil.getNameable(superTraceClassDatum.getOwnedPropertyDatums(), getName());		// FIXME avoid 'name' usage - use tracePropertyDatum(.referredProperty)
			if (propertyDatum != null) {
				PartialRegionPropertyAnalysis<@NonNull PRA> tracePropertyAnalysis = partialRegionsAnalysis.basicGetTracePropertyAnalysis(propertyDatum);	// FIXME is missing acceptable
				if ((tracePropertyAnalysis != null) && !tracePropertyAnalyses.contains(tracePropertyAnalysis)) {
					tracePropertyAnalyses.add(tracePropertyAnalysis);
				}
			}
		}
		assert tracePropertyAnalyses.contains(this);
		return tracePropertyAnalyses;
	}

	public @NonNull PartialRegionClassAnalysis<PRA> getTraceClassAnalysis() {
		return traceClassAnalysis;
	}

	public @NonNull Property getTraceProperty() {
		return QVTscheduleUtil.getReferredProperty(tracePropertyDatum);
	}

	@Override
	public String toString() {
		return tracePropertyDatum.toString();
	}
}
