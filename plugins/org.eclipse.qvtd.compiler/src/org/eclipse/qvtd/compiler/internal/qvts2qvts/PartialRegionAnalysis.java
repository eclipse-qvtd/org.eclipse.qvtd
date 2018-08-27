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
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;

public interface PartialRegionAnalysis<@NonNull RA extends PartialRegionAnalysis<@NonNull RA>> extends Nameable
{
	@Nullable Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> getConsumedTraceClassAnalyses();
	@Nullable Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> getConsumedTracePropertyAnalyses();
	@Deprecated /** @deprecated This accommodates the lack of a success trace variable for manual trace classes */
	@Nullable Iterable<@NonNull RA> getPredecessors();
	@Nullable Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> getProducedTraceClassAnalyses();
	@Nullable Iterable<@NonNull TracePropertyAnalysis<@NonNull RA>> getProducedTracePropertyAnalyses();
	@Nullable Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> getSuperProducedTraceClassAnalyses();
	@NonNull TraceClassAnalysis<@NonNull RA> getTraceClassAnalysis(@NonNull ClassDatum traceClassDatum);
	@NonNull TracePropertyAnalysis<@NonNull RA> getTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum);
	@NonNull List<@NonNull Node> getTraceNodes();
}