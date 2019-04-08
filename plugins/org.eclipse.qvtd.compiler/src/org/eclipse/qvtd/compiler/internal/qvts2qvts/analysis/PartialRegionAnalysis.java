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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

public interface PartialRegionAnalysis<@NonNull PRA extends PartialRegionAnalysis<@NonNull PRA>> extends Nameable // implements CompilerUtil.PartialRegion<@NonNull RegionAnalysis, @NonNull PartialRegionClassAnalysis<@NonNull RegionAnalysis>, @NonNull PartialRegionPropertyAnalysis<@NonNull RegionAnalysis>>
{
	@Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull PRA>> getConsumedTraceClassAnalyses();
	@Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> getConsumedTracePropertyAnalyses();
	@Nullable Iterable<@NonNull PRA> getExplicitPredecessors();
	@NonNull Iterable<@NonNull Node> getTraceNodes();
}