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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;

/**
 * PartialRegionsAnalysis<PRA> manages the ClassDatum and PropertyDatum usage by partial regions for a PartialRegionsAnalysis.
 */
public interface PartialRegionsAnalysis<@NonNull PRA extends PartialRegionsAnalysis<@NonNull PRA>> extends Nameable
{
	@NonNull PartialRegionClassAnalysis<@NonNull PRA> addConsumer(@NonNull ClassDatum classDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> consumer);
	@NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> addConsumer(@NonNull PropertyDatum propertyDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> consumer);
	@NonNull PartialRegionClassAnalysis<@NonNull PRA> addProducer(@NonNull ClassDatum classDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> producer);
	@NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> addProducer(@NonNull PropertyDatum propertyDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> producer);
	@Nullable ActualPartialRegionPropertyAnalysis<@NonNull PRA> basicGetPropertyAnalysis(@NonNull PropertyDatum propertyDatum);
	@NonNull PartialRegionClassAnalysis<@NonNull PRA> getClassAnalysis(@NonNull ClassDatum classDatum);
	@NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> getPropertyAnalysis(@NonNull PropertyDatum propertyDatum);
	@NonNull ScheduleManager getScheduleManager();
}