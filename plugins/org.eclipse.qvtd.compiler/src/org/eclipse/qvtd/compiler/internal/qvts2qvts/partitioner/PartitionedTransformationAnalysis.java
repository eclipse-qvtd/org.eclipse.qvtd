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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Concurrency;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
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

	/**
	 * The TracePropertyAnalysis for each trace property.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull AbstractPartitionAnalysis<?>> partition2partitionAnalysis = new HashMap<>();

	private @Nullable RootPartitionAnalysis rootPartitionAnalysis = null;
	private @Nullable Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges = null;
	private @Nullable Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges = null;

	public PartitionedTransformationAnalysis(@NonNull TransformationPartitioner transformationPartitioner) {
		super(transformationPartitioner.getScheduleManager().getEnvironmentFactory());
		this.transformationPartitioner = transformationPartitioner;
		this.scheduleManager = transformationPartitioner.getScheduleManager();
	}

	public void addCheckedEdge(@NonNull TypedModel typedModel, @NonNull NavigationEdge predicatedEdge) {
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges2 = typedModel2property2predicatedEdges;
		assert typedModel2property2predicatedEdges2 != null;
		Property property = QVTscheduleUtil.getProperty(predicatedEdge);
		Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2predicatedEdges = typedModel2property2predicatedEdges2.get(typedModel);
		if (property2predicatedEdges == null) {
			property2predicatedEdges = new HashMap<>();
			typedModel2property2predicatedEdges2.put(typedModel, property2predicatedEdges);
		}
		List<@NonNull NavigableEdge> predicatedEdges = property2predicatedEdges.get(property);
		if (predicatedEdges == null) {
			predicatedEdges = new ArrayList<>();
			property2predicatedEdges.put(property, predicatedEdges);
		}
		predicatedEdges.add(predicatedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " predicated for " + property);
	}

	public @NonNull TraceClassPartitionAnalysis addConsumer(@NonNull ClassDatum classDatum, @NonNull PartitionAnalysis consumer) {
		TraceClassPartitionAnalysis traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addConsumer(consumer);
		return traceClassAnalysis;
	}

	public @NonNull TracePropertyPartitionAnalysis addConsumer(@NonNull PropertyDatum tracePropertyDatum, @NonNull PartitionAnalysis consumer) {
		TracePropertyPartitionAnalysis tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addConsumer(consumer);
		return tracePropertyAnalysis;
	}

	public void addPartitionAnalysis(@NonNull AbstractPartitionAnalysis<?> partitionAnalysis) {
		partition2partitionAnalysis.put(partitionAnalysis.getPartition(), partitionAnalysis);
	}

	public @NonNull TraceClassPartitionAnalysis addProducer(@NonNull ClassDatum classDatum, @NonNull PartitionAnalysis producer) {
		TraceClassPartitionAnalysis traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addProducer(producer);
		return traceClassAnalysis;
	}

	public @NonNull TracePropertyPartitionAnalysis addProducer(@NonNull PropertyDatum tracePropertyDatum, @NonNull PartitionAnalysis producer) {
		TracePropertyPartitionAnalysis tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addProducer(producer);
		return tracePropertyAnalysis;
	}

	public void addRealizedEdge(@NonNull TypedModel typedModel, @NonNull NavigationEdge realizedEdge) {
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges2 = typedModel2property2realizedEdges;
		assert typedModel2property2realizedEdges2 != null;
		Property property = QVTscheduleUtil.getProperty(realizedEdge);
		Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = typedModel2property2realizedEdges2.get(typedModel);
		if (property2realizedEdges == null) {
			property2realizedEdges = new HashMap<>();
			typedModel2property2realizedEdges2.put(typedModel, property2realizedEdges);
		}
		List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(property);
		if (realizedEdges == null) {
			realizedEdges = new ArrayList<>();
			property2realizedEdges.put(property, realizedEdges);
		}
		realizedEdges.add(realizedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " realized for " + property);
	}

	public void analyzePartitionEdges(@NonNull Iterable<@NonNull Concurrency> partitionSchedule) {
		typedModel2property2predicatedEdges = new HashMap<>();
		typedModel2property2realizedEdges = new HashMap<>();
		for (@NonNull Concurrency concurrency : partitionSchedule) {
			for (@NonNull PartitionAnalysis partitionAnalysis : concurrency) {
				Partition partition = partitionAnalysis.getPartition();
				QVTscheduleConstants.POLLED_PROPERTIES.println("building indexes for " + partition + " " + partition.getPassRangeText());
				partitionAnalysis.analyzePartitionEdges();
			}
		}
	}

	public void analyzePartitions(@NonNull Iterable<@NonNull PartitionAnalysis> partitionAnalyses) {
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
			((AbstractPartitionAnalysis<?>)partitionAnalysis).analyzePartition();
		}
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
			((AbstractPartitionAnalysis<?>)partitionAnalysis).analyzePartition2();
		}
	}

	public void computeCheckedOrEnforcedEdges(@NonNull List<@NonNull Concurrency> mergedPartitionSchedule) {
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges2 = typedModel2property2realizedEdges;
		assert typedModel2property2realizedEdges2 != null;
		for (@NonNull Concurrency concurrency : mergedPartitionSchedule) {
			for (@NonNull PartitionAnalysis partitionAnalysis : concurrency) {
				partitionAnalysis.computeCheckedOrEnforcedEdges();
			}
		}
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

	public @NonNull AbstractPartitionAnalysis<?> getPartitionAnalysis(@NonNull Partition partition) {
		return ClassUtil.nonNullState(partition2partitionAnalysis.get(partition));
	}

	public @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> getProperty2RealizedEdges(@NonNull TypedModel typedModel) {
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges2 = typedModel2property2realizedEdges;
		assert typedModel2property2realizedEdges2 != null;
		return ClassUtil.nonNullState(typedModel2property2realizedEdges2.get(typedModel));
	}

	public @NonNull RootPartitionAnalysis getRootPartitionAnalysis() {
		return ClassUtil.nonNullState(rootPartitionAnalysis);
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

	public void setLoadingRegionAnalysis(@NonNull LoadingPartitionAnalysis loadingPartitionAnalysis) {
		for (@NonNull ClassDatum classDatum : classDatum2traceClassAnalysis.keySet()) {
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			if (scheduleManager.isInput(typedModel)) {
				TraceClassPartitionAnalysis classAnalysis = classDatum2traceClassAnalysis.get(classDatum);
				assert classAnalysis != null;
				Iterable<@NonNull PartitionAnalysis> producers = classAnalysis.getProducers();
				if (Iterables.isEmpty(producers)) {
					classAnalysis.addProducer(loadingPartitionAnalysis);
				}
			}
		}
		partition2partitionAnalysis.put(loadingPartitionAnalysis.getPartition(), loadingPartitionAnalysis);
	}

	public void setRootPartitionAnalysis(@NonNull RootPartitionAnalysis rootPartitionAnalysis) {
		this.rootPartitionAnalysis = rootPartitionAnalysis;
		partition2partitionAnalysis.put(rootPartitionAnalysis.getPartition(), rootPartitionAnalysis);
	}
}
