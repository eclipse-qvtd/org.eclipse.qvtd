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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class or property.
 */
public interface PartialRegionClassAnalysis<PRA extends PartialRegionsAnalysis> extends PartialRegionElementAnalysis<@NonNull PRA>
{
	void addSubTraceClassAnalysis(@NonNull PartialRegionClassAnalysis<@NonNull PRA> traceClassAnalysis);
	void addSuperTraceClassAnalysis(@NonNull PartialRegionClassAnalysis<@NonNull PRA> traceClassAnalysis);
	void discriminate() throws CompilerChainException;
	@NonNull ClassDatum getClassDatum();
	@Nullable Iterable<@NonNull Property> getDiscriminatingProperties();
	@NonNull ScheduleManager getScheduleManager();
	@NonNull Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getSubTraceClassAnalyses();
	@NonNull Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getSuperTraceClassAnalyses();
	boolean isCyclic();
}
