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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public abstract class AbstractPartialRegionsAnalysis<@NonNull PRA extends PartialRegionsAnalysis<PRA>> extends QVTbaseHelper implements PartialRegionsAnalysis<PRA>
{
	/**
	 * The supervising ScheduleManager.
	 */
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The TraceClassAnalysis for each trace class.
	 */
	protected final @NonNull Map<@NonNull ClassDatum, @NonNull PartialRegionClassAnalysis<@NonNull PRA>> classDatum2traceClassAnalysis = new HashMap<>();

	/**
	 * The TracePropertyAnalysis for each trace property.
	 */
	protected final @NonNull Map<@NonNull PropertyDatum, @NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> propertyDatum2tracePropertyAnalysis = new HashMap<>();

	protected AbstractPartialRegionsAnalysis(@NonNull ScheduleManager scheduleManager) {
		super(scheduleManager.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
	}

	@Override
	public @NonNull PartialRegionClassAnalysis<@NonNull PRA> addConsumer(@NonNull ClassDatum classDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> consumer) {
		PartialRegionClassAnalysis<@NonNull PRA> traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addConsumer(consumer);
		return traceClassAnalysis;
	}

	@Override
	public @NonNull PartialRegionPropertyAnalysis<@NonNull PRA> addConsumer(@NonNull PropertyDatum tracePropertyDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> consumer) {
		PartialRegionPropertyAnalysis<@NonNull PRA> tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addConsumer(consumer);
		return tracePropertyAnalysis;
	}

	@Override
	public @NonNull PartialRegionClassAnalysis<@NonNull PRA> addProducer(@NonNull ClassDatum classDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> producer) {
		PartialRegionClassAnalysis<@NonNull PRA> traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addProducer(producer);
		return traceClassAnalysis;
	}

	@Override
	public @NonNull PartialRegionPropertyAnalysis<@NonNull PRA> addProducer(@NonNull PropertyDatum tracePropertyDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> producer) {
		if (this instanceof AbstractTransformationAnalysis) {		// FIXME irregular for ATL2QVTr --- why??
			PartialRegionPropertyAnalysis<@NonNull PRA> tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
			tracePropertyAnalysis.addProducer(producer);
			return tracePropertyAnalysis;
		}
		for (@NonNull PropertyDatum superPropertyDatum : QVTscheduleUtil.getSuperPropertyDatums(tracePropertyDatum)) {
			PartialRegionPropertyAnalysis<@NonNull PRA> superTracePropertyAnalysis = lazyCreateTracePropertyAnalysis(superPropertyDatum);
			superTracePropertyAnalysis.addProducer(producer);
		}
		return getTracePropertyAnalysis(tracePropertyDatum);
	}

	public @Nullable PartialRegionClassAnalysis<@NonNull PRA> basicGetTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		return classDatum2traceClassAnalysis.get(classDatum);
	}

	@Override
	public @Nullable PartialRegionPropertyAnalysis<@NonNull PRA> basicGetTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		return propertyDatum2tracePropertyAnalysis.get(propertyDatum);
	}

	protected void computeTraceClassDiscrimination() throws CompilerChainException {
		for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> traceClassAnalysis : classDatum2traceClassAnalysis.values()) {
			traceClassAnalysis.discriminate();
		}
	}

	public void computeTraceClassInheritance() {
		Set<@NonNull ClassDatum> missingClassDatums = new HashSet<>();
		for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					PartialRegionClassAnalysis<@NonNull PRA> superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					if (superTraceClassRegionAnalysis == null) {
						missingClassDatums.add(superClassDatum);
					}
				}
			}
		}
		for (@NonNull ClassDatum missingClassDatum : missingClassDatums) {
			lazyCreateTraceClassAnalysis(missingClassDatum);
		}
		for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					PartialRegionClassAnalysis<@NonNull PRA> superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					assert superTraceClassRegionAnalysis != null;
					superTraceClassRegionAnalysis.addSubTraceClassAnalysis(subTraceClassRegionAnalysis);
					subTraceClassRegionAnalysis.addSuperTraceClassAnalysis(superTraceClassRegionAnalysis);
				}
			}
		}
	}

	protected abstract @NonNull PartialRegionClassAnalysis<@NonNull PRA> createTraceClassAnalysis(@NonNull ClassDatum traceClassDatum);

	//	protected abstract @NonNull PartialRegionPropertyAnalysis<@NonNull PRA> createTracePropertyAnalysis(@NonNull PartialRegionClassAnalysis<@NonNull PRA> traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum);

	protected @NonNull PartialRegionPropertyAnalysis<@NonNull PRA> createTracePropertyAnalysis(@NonNull PartialRegionClassAnalysis<@NonNull PRA> traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		return new AbstractPartialRegionPropertyAnalysis<@NonNull PRA>(this, traceClassAnalysis, tracePropertyDatum) {};
	}

	@Override
	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	@Override
	public @NonNull PartialRegionClassAnalysis<@NonNull PRA> getTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum2traceClassAnalysis.get(classDatum));
	}

	@Override
	public @NonNull PartialRegionPropertyAnalysis<@NonNull PRA> getTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		return ClassUtil.nonNullState(propertyDatum2tracePropertyAnalysis.get(propertyDatum));
	}

	private @NonNull PartialRegionClassAnalysis<@NonNull PRA> lazyCreateTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		PartialRegionClassAnalysis<@NonNull PRA> traceClassAnalysis = classDatum2traceClassAnalysis.get(classDatum);
		if (traceClassAnalysis == null) {
			traceClassAnalysis = createTraceClassAnalysis(classDatum);
			classDatum2traceClassAnalysis.put(classDatum, traceClassAnalysis);
		}
		return traceClassAnalysis;
	}

	private @NonNull PartialRegionPropertyAnalysis<@NonNull PRA> lazyCreateTracePropertyAnalysis(@NonNull PropertyDatum tracePropertyDatum) {
		PartialRegionPropertyAnalysis<@NonNull PRA> tracePropertyAnalysis = propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum);
		if (tracePropertyAnalysis == null) {
			ClassDatum classDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
			PartialRegionClassAnalysis<@NonNull PRA> traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
			tracePropertyAnalysis = createTracePropertyAnalysis(traceClassAnalysis, tracePropertyDatum);
			propertyDatum2tracePropertyAnalysis.put(tracePropertyDatum, tracePropertyAnalysis);
		}
		return tracePropertyAnalysis;
	}
}