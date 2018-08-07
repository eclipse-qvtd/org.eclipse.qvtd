/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CycleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CyclesAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A TransformationAnalysis accumulates the results of analyzing a RelationalTransformation and its contents.
 */
public abstract class RegionsAnalysis<@NonNull RA extends PartialRegionAnalysis<@NonNull RA>> extends QVTbaseHelper implements Nameable
{
	/**
	 * The supervising ScheduleManager.
	 */
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The TraceClassAnalysis for each trace class.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull TraceClassAnalysis<@NonNull RA>> classDatum2traceClassAnalysis = new HashMap<>();

	/**
	 * The TracePropertyAnalysis for each trace property.
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull TracePropertyAnalysis<@NonNull RA>> propertyDatum2tracePropertyAnalysis = new HashMap<>();

	protected RegionsAnalysis(@NonNull ScheduleManager scheduleManager) {
		super(scheduleManager.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
	}

	public @NonNull TraceClassAnalysis<@NonNull RA> addConsumer(@NonNull ClassDatum traceClassDatum, @NonNull RA consumer) {
		TraceClassAnalysis<@NonNull RA> middleAnalysis = classDatum2traceClassAnalysis.get(traceClassDatum);
		if (middleAnalysis == null) {
			middleAnalysis = createTraceClassAnalysis(traceClassDatum);
			classDatum2traceClassAnalysis.put(traceClassDatum, middleAnalysis);
		}
		middleAnalysis.addConsumer(consumer);
		return middleAnalysis;
	}

	public @NonNull TracePropertyAnalysis<@NonNull RA> addConsumer(@NonNull PropertyDatum tracePropertyDatum, @NonNull RA consumer) {
		TracePropertyAnalysis<@NonNull RA> middleAnalysis = propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum);
		if (middleAnalysis == null) {
			middleAnalysis = createTracePropertyAnalysis(tracePropertyDatum);
			propertyDatum2tracePropertyAnalysis.put(tracePropertyDatum, middleAnalysis);
		}
		middleAnalysis.addConsumer(consumer);
		return middleAnalysis;
	}

	public @NonNull TraceClassAnalysis<@NonNull RA> addProducer(@NonNull ClassDatum traceClassDatum, @NonNull RA producer) {
		TraceClassAnalysis<@NonNull RA> middleAnalysis = classDatum2traceClassAnalysis.get(traceClassDatum);
		if (middleAnalysis == null) {
			middleAnalysis = createTraceClassAnalysis(traceClassDatum);
			classDatum2traceClassAnalysis.put(traceClassDatum, middleAnalysis);
		}
		middleAnalysis.addProducer(producer);
		return middleAnalysis;
	}

	public @NonNull TracePropertyAnalysis<@NonNull RA> addProducer(@NonNull PropertyDatum tracePropertyDatum, @NonNull RA producer) {
		TracePropertyAnalysis<@NonNull RA> middleAnalysis = propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum);
		if (middleAnalysis == null) {
			middleAnalysis = createTracePropertyAnalysis(tracePropertyDatum);
			propertyDatum2tracePropertyAnalysis.put(tracePropertyDatum, middleAnalysis);
		}
		middleAnalysis.addProducer(producer);
		return middleAnalysis;
	}

	protected @Nullable TraceClassRegionAnalysis basicGetTraceClassRegionAnalysis(@NonNull ClassDatum traceClassDatum) {
		return (TraceClassRegionAnalysis)classDatum2traceClassAnalysis.get(traceClassDatum);
	}

	protected @NonNull CyclesAnalysis<@NonNull RA> computeCyclicTraceClasses() {
		//
		//	Each mapping partitioner that consumes no trace class, is an acyclic producer.
		//
		Set<@NonNull RA> acyclicProducers = new HashSet<>();
		for (@NonNull RA regionAnalysis : getPartialRegionAnalyses()) {
			Iterable<@NonNull TraceClassAnalysis<@NonNull RA>> consumedTraceClassAnalyses = regionAnalysis.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses == null) {
				acyclicProducers.add(regionAnalysis);
			}
		}
		/*		for (@NonNull TraceClassAnalysis middleAnalysis : class2middleAnalysis.values()) {
		CompleteClass traceClass = middleAnalysis.getTraceClass();
		for (@NonNull CompleteClass superCompleteClass : traceClass.getProperSuperCompleteClasses()) {
			for (@NonNull RegionAnalysis producer : middleAnalysis.getProducers()) {
				addProducer(superCompleteClass, producer);
			}
		}
	} */

		CyclesAnalysis<@NonNull RA> cyclesAnalysis = createCyclesAnalysis();
		cyclesAnalysis.analyze();
		//
		//	Each TraceClassAnalysis produced only by acyclic partitioners identifies an acyclic trace class
		// ?? is this cdead ?? should it be for TracePropertyAnalysis too ??
		Set<@NonNull TraceClassAnalysis<@NonNull RA>> acylicAnalysis = new HashSet<>();
		for (@NonNull RA acyclicProducer : acyclicProducers) {
			for (@NonNull Node traceNode : acyclicProducer.getTraceNodes()) {
				ClassDatum traceClassDatum = QVTscheduleUtil.getClassDatum(traceNode);
				TraceClassAnalysis<@NonNull RA> middleAnalysis = classDatum2traceClassAnalysis.get(traceClassDatum);
				assert middleAnalysis != null;
				if (QVTbaseUtil.containsAll(acyclicProducers, middleAnalysis.getProducers())) {
					acylicAnalysis.add(middleAnalysis);
				}
			}
		}
		return cyclesAnalysis;
	}

	protected void computeTraceClassDiscrimination() throws CompilerChainException {
		for (@NonNull TraceClassAnalysis<@NonNull RA> traceClassAnalysis : classDatum2traceClassAnalysis.values()) {
			traceClassAnalysis.discriminate();
		}
	}

	protected void computeTraceClassInheritance() {
		for (@NonNull TraceClassAnalysis<@NonNull RA> subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum traceClassDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superTraceClassDatum : QVTscheduleUtil.getSuperClassDatums(traceClassDatum)) {
				if (superTraceClassDatum != traceClassDatum) {
					TraceClassAnalysis<@NonNull RA> superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superTraceClassDatum);
					if (superTraceClassRegionAnalysis != null) {
						superTraceClassRegionAnalysis.addSubTraceClassAnalysis(subTraceClassRegionAnalysis);
						subTraceClassRegionAnalysis.addSuperTraceClassAnalysis(superTraceClassRegionAnalysis);
					}
				}
			}
		}
	}

	protected abstract @NonNull CyclesAnalysis<@NonNull RA> createCyclesAnalysis();

	protected abstract @NonNull TraceClassAnalysis<@NonNull RA> createTraceClassAnalysis(@NonNull ClassDatum traceClassDatum);

	protected abstract @NonNull TracePropertyAnalysis<@NonNull RA> createTracePropertyAnalysis(@NonNull PropertyDatum tracePropertyDatum);

	public @Nullable CycleAnalysis<@NonNull RA> getCycleAnalysis(@NonNull ClassDatum traceClassDatum) {
		TraceClassAnalysis<@NonNull RA> traceClassAnalysis = classDatum2traceClassAnalysis.get(traceClassDatum);
		if (traceClassAnalysis == null) {
			return null;
		}
		return getCycleAnalysis(traceClassAnalysis);
	}

	public abstract @Nullable CycleAnalysis<@NonNull RA> getCycleAnalysis(@NonNull TraceClassAnalysis<@NonNull RA> traceClassAnalysis);

	protected abstract @NonNull Iterable<@NonNull RA> getPartialRegionAnalyses();

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull TraceClassAnalysis<@NonNull RA> getTraceClassAnalysis(@NonNull ClassDatum traceClassDatum) {
		return ClassUtil.nonNullState(classDatum2traceClassAnalysis.get(traceClassDatum));
	}

	public @NonNull TracePropertyAnalysis<@NonNull RA> getTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		return ClassUtil.nonNullState(propertyDatum2tracePropertyAnalysis.get(propertyDatum));
	}
}
