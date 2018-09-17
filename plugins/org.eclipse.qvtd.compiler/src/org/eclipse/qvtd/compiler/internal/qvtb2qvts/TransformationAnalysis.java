/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;

/**
 * A TransformationAnalysis accumulates the results of analyzing a RelationalTransformation and its contents.
 */
public interface TransformationAnalysis<@NonNull RA extends PartialRegionAnalysis<@NonNull RA>> extends  Nameable
{
	@NonNull ScheduleManager getScheduleManager();

	@NonNull TraceClassAnalysis<@NonNull RA> addConsumer(@NonNull ClassDatum classDatum, @NonNull RA ra);

	@NonNull TracePropertyAnalysis<@NonNull RA> addConsumer(@NonNull PropertyDatum propertyDatum, @NonNull RA ra);

	@NonNull TracePropertyAnalysis<@NonNull RA> addProducer(@NonNull PropertyDatum propertyDatum, @NonNull RA ra);

	@NonNull TraceClassAnalysis<@NonNull RA> addProducer(@NonNull ClassDatum classDatum, @NonNull RA ra);

	@NonNull TraceClassAnalysis<@NonNull RA> getTraceClassAnalysis(@NonNull ClassDatum traceClassDatum);

	@NonNull TracePropertyAnalysis<@NonNull RA> getTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum);

	@Nullable TracePropertyAnalysis<@NonNull RA> basicGetTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum);

	void computeTraceClassInheritance();
}
