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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * A TransformationAnalysis accumulates the results of analyzing a RelationalTransformation and its contents.
 */
public class PartitionedTransformationAnalysis extends QVTbaseHelper implements Nameable
{
	protected final @NonNull TransformationPartitioner transformationPartitioner;
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The TraceClassAnalysis for each trace class.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull TraceClassPartitionAnalysis> classDatum2traceClassAnalysis = new HashMap<>();

	/**
	 * The TracePropertyAnalysis for each trace property.
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull TracePropertyPartitionAnalysis> propertyDatum2tracePropertyAnalysis = new HashMap<>();

	public PartitionedTransformationAnalysis(@NonNull TransformationPartitioner transformationPartitioner) {
		super(transformationPartitioner.getScheduleManager().getEnvironmentFactory());
		this.transformationPartitioner = transformationPartitioner;
		this.scheduleManager = transformationPartitioner.getScheduleManager();
	}

	public @NonNull TraceClassPartitionAnalysis addConsumer(@NonNull ClassDatum classDatum, @NonNull Partition consumer) {
		TraceClassPartitionAnalysis traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addConsumer(consumer);
		return traceClassAnalysis;
	}

	public @NonNull TracePropertyPartitionAnalysis addConsumer(@NonNull PropertyDatum tracePropertyDatum, @NonNull Partition consumer) {
		TracePropertyPartitionAnalysis tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addConsumer(consumer);
		return tracePropertyAnalysis;
	}

	public @NonNull TraceClassPartitionAnalysis addProducer(@NonNull ClassDatum classDatum, @NonNull Partition producer) {
		TraceClassPartitionAnalysis traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addProducer(producer);
		return traceClassAnalysis;
	}

	public @NonNull TracePropertyPartitionAnalysis addProducer(@NonNull PropertyDatum tracePropertyDatum, @NonNull Partition producer) {
		TracePropertyPartitionAnalysis tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addProducer(producer);
		return tracePropertyAnalysis;
	}

	protected void computeTraceClassDiscrimination() throws CompilerChainException {
		for (@NonNull TraceClassPartitionAnalysis traceClassAnalysis : classDatum2traceClassAnalysis.values()) {
			traceClassAnalysis.discriminate();
		}
	}

	public void computeTraceClassInheritance() {
		Set<@NonNull ClassDatum> missingClassDatums = new HashSet<>();
		for (@NonNull TraceClassPartitionAnalysis subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					TraceClassPartitionAnalysis superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					if (superTraceClassRegionAnalysis == null) {
						missingClassDatums.add(superClassDatum);
					}
				}
			}
		}
		for (@NonNull ClassDatum missingClassDatum : missingClassDatums) {
			lazyCreateTraceClassAnalysis(missingClassDatum);
		}
		for (@NonNull TraceClassPartitionAnalysis subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					TraceClassPartitionAnalysis superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					assert superTraceClassRegionAnalysis != null;
					superTraceClassRegionAnalysis.addSubTraceClassAnalysis(subTraceClassRegionAnalysis);
					subTraceClassRegionAnalysis.addSuperTraceClassAnalysis(superTraceClassRegionAnalysis);
				}
			}
		}
	}

	protected @NonNull TraceClassPartitionAnalysis createTraceClassAnalysis(@NonNull ClassDatum traceClassDatum) {
		return new TraceClassPartitionAnalysis(transformationPartitioner.getTransformationAnalysis().getTraceClassAnalysis(traceClassDatum));
	}

	protected @NonNull TracePropertyPartitionAnalysis createTracePropertyAnalysis(@NonNull TraceClassPartitionAnalysis traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		return new TracePropertyPartitionAnalysis(transformationPartitioner, traceClassAnalysis, tracePropertyDatum);
	}

	//	protected abstract @NonNull Iterable<@NonNull Partition> getPartialRegionAnalyses();

	@Override
	public String getName() {
		return transformationPartitioner.getName();
	}

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	private @NonNull TraceClassPartitionAnalysis lazyCreateTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		TraceClassPartitionAnalysis traceClassAnalysis = classDatum2traceClassAnalysis.get(classDatum);
		if (traceClassAnalysis == null) {
			traceClassAnalysis = createTraceClassAnalysis(classDatum);
			classDatum2traceClassAnalysis.put(classDatum, traceClassAnalysis);
		}
		return traceClassAnalysis;
	}

	private @NonNull TracePropertyPartitionAnalysis lazyCreateTracePropertyAnalysis(@NonNull PropertyDatum tracePropertyDatum) {
		TracePropertyPartitionAnalysis tracePropertyAnalysis = propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum);
		if (tracePropertyAnalysis == null) {
			ClassDatum classDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
			TraceClassPartitionAnalysis traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
			tracePropertyAnalysis = createTracePropertyAnalysis(traceClassAnalysis, tracePropertyDatum);
			propertyDatum2tracePropertyAnalysis.put(tracePropertyDatum, tracePropertyAnalysis);
		}
		return tracePropertyAnalysis;
	}

	public void setLoadingRegionAnalysis(@NonNull LoadingPartition loadingPartition) {
		for (@NonNull ClassDatum classDatum : classDatum2traceClassAnalysis.keySet()) {
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			if (scheduleManager.isInput(typedModel)) {
				TraceClassPartitionAnalysis classAnalysis = classDatum2traceClassAnalysis.get(classDatum);
				assert classAnalysis != null;
				Iterable<@NonNull Partition> producers = classAnalysis.getProducers();
				if (Iterables.isEmpty(producers)) {
					classAnalysis.addProducer(loadingPartition);
				}
			}
		}
	}
}
