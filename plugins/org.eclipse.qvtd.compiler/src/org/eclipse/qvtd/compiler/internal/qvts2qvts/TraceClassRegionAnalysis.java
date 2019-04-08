/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.AbstractPartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class.
 */
public class TraceClassRegionAnalysis extends AbstractPartialRegionClassAnalysis<@NonNull RegionAnalysis>
{
	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;

	private @Nullable Boolean isCyclic = null;

	public TraceClassRegionAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull ClassDatum traceClassDatum) {
		super(transformationAnalysis.getScheduleManager(), traceClassDatum);
		this.transformationAnalysis = transformationAnalysis;
	}

	/**
	 * Return true if this TraceClassAnalyis participates in a production/consumption cycle of either the trace class or its trace properties.
	 */
	@Override
	public boolean isCyclic() {
		Boolean isCyclic2 = isCyclic;
		if (isCyclic2 == null) {
			for (@NonNull PartialRegionClassAnalysis<@NonNull RegionAnalysis> subTraceClassAnalysis : getSubTraceClassAnalyses()) {
				if (transformationAnalysis.isCyclic(subTraceClassAnalysis)) {
					isCyclic2 = isCyclic = true;
					return isCyclic2;
				}
			}
			isCyclic2 = isCyclic = false;
		}
		return isCyclic2;
	}
}
