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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
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

	protected final @NonNull Property oclContainerProperty;

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
		this.oclContainerProperty = scheduleManager.getStandardLibraryHelper().getOclContainerProperty();
	}

	public @NonNull TraceClassAnalysis<@NonNull RA> addConsumer(@NonNull ClassDatum classDatum, @NonNull RA consumer) {
		TraceClassAnalysis<@NonNull RA> traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addConsumer(consumer);
		return traceClassAnalysis;
	}

	public @NonNull TracePropertyAnalysis<@NonNull RA> addConsumer(@NonNull PropertyDatum tracePropertyDatum, @NonNull RA consumer) {
		TracePropertyAnalysis<@NonNull RA> tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addConsumer(consumer);
		return tracePropertyAnalysis;
	}

	public @NonNull TraceClassAnalysis<@NonNull RA> addProducer(@NonNull ClassDatum classDatum, @NonNull RA producer) {
		TraceClassAnalysis<@NonNull RA> traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addProducer(producer);
		return traceClassAnalysis;
	}

	public @NonNull TracePropertyAnalysis<@NonNull RA> addProducer(@NonNull PropertyDatum tracePropertyDatum, @NonNull RA producer) {
		TracePropertyAnalysis<@NonNull RA> tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addProducer(producer);
		return tracePropertyAnalysis;
	}

	protected @Nullable TraceClassAnalysis<@NonNull RA> basicGetTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		return classDatum2traceClassAnalysis.get(classDatum);
	}

	public @Nullable TracePropertyAnalysis<@NonNull RA> basicGetTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		assert QVTscheduleUtil.getReferredProperty(propertyDatum) != oclContainerProperty;
		return propertyDatum2tracePropertyAnalysis.get(propertyDatum);
	}

	protected void computeTraceClassDiscrimination() throws CompilerChainException {
		for (@NonNull TraceClassAnalysis<@NonNull RA> traceClassAnalysis : classDatum2traceClassAnalysis.values()) {
			traceClassAnalysis.discriminate();
		}
	}

	protected void computeTraceClassInheritance() {
		Set<@NonNull ClassDatum> missingClassDatums = new HashSet<>();
		for (@NonNull TraceClassAnalysis<@NonNull RA> subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					TraceClassAnalysis<@NonNull RA> superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					if (superTraceClassRegionAnalysis == null) {
						missingClassDatums.add(superClassDatum);
					}
				}
			}
		}
		for (@NonNull ClassDatum missingClassDatum : missingClassDatums) {
			lazyCreateTraceClassAnalysis(missingClassDatum);
		}
		for (@NonNull TraceClassAnalysis<@NonNull RA> subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					TraceClassAnalysis<@NonNull RA> superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					assert superTraceClassRegionAnalysis != null;
					superTraceClassRegionAnalysis.addSubTraceClassAnalysis(subTraceClassRegionAnalysis);
					subTraceClassRegionAnalysis.addSuperTraceClassAnalysis(superTraceClassRegionAnalysis);
				}
			}
		}
	}

	protected abstract @NonNull TraceClassAnalysis<@NonNull RA> createTraceClassAnalysis(@NonNull ClassDatum classDatum);

	protected abstract @NonNull TracePropertyAnalysis<@NonNull RA> createTracePropertyAnalysis(@NonNull TraceClassAnalysis<@NonNull RA> traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum);

	//	protected abstract @NonNull Iterable<@NonNull RA> getPartialRegionAnalyses();

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull TraceClassAnalysis<@NonNull RA> getTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum2traceClassAnalysis.get(classDatum));
	}

	public @NonNull TracePropertyAnalysis<@NonNull RA> getTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		assert QVTscheduleUtil.getReferredProperty(propertyDatum) != oclContainerProperty;
		return ClassUtil.nonNullState(propertyDatum2tracePropertyAnalysis.get(propertyDatum));
	}

	private @NonNull TraceClassAnalysis<@NonNull RA> lazyCreateTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		TraceClassAnalysis<@NonNull RA> traceClassAnalysis = classDatum2traceClassAnalysis.get(classDatum);
		if (traceClassAnalysis == null) {
			traceClassAnalysis = createTraceClassAnalysis(classDatum);
			classDatum2traceClassAnalysis.put(classDatum, traceClassAnalysis);
		}
		return traceClassAnalysis;
	}

	private @NonNull TracePropertyAnalysis<@NonNull RA> lazyCreateTracePropertyAnalysis(@NonNull PropertyDatum tracePropertyDatum) {
		TracePropertyAnalysis<@NonNull RA> tracePropertyAnalysis = propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum);
		if (tracePropertyAnalysis == null) {
			ClassDatum classDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
			TraceClassAnalysis<@NonNull RA> traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
			tracePropertyAnalysis = createTracePropertyAnalysis(traceClassAnalysis, tracePropertyDatum);
			propertyDatum2tracePropertyAnalysis.put(tracePropertyDatum, tracePropertyAnalysis);
		}
		return tracePropertyAnalysis;
	}
}
