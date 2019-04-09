/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
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
	private final @NonNull Map<@NonNull ClassDatum, @NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis>> classDatum2traceClassAnalysis = new HashMap<>();

	/**
	 * The TracePropertyAnalysis for each trace property.
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis>> propertyDatum2tracePropertyAnalysis = new HashMap<>();

	/**
	 * The PartitionAnalysis for each Partition.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull AbstractPartitionAnalysis<?>> partition2partitionAnalysis = new HashMap<>();

	/**
	 * The FallibilityAnalysis for each Partition.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull AbstractFallibilityAnalysis> partition2fallibilityAnalysis = new HashMap<>();

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
		if (!predicatedEdges.contains(predicatedEdge)) {		// Same edge can come from multiple partitions
			predicatedEdges.add(predicatedEdge);
		}
		QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " predicated for " + property);
	}

	public @NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> addConsumer(@NonNull ClassDatum classDatum, @NonNull PartitionAnalysis consumer) {
		PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addConsumer(consumer);
		return traceClassAnalysis;
	}

	public @NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> addConsumer(@NonNull PropertyDatum tracePropertyDatum, @NonNull PartitionAnalysis consumer) {
		PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addConsumer(consumer);
		return tracePropertyAnalysis;
	}

	public void addPartitionAnalysis(@NonNull AbstractPartitionAnalysis<?> partitionAnalysis) {
		partition2partitionAnalysis.put(partitionAnalysis.getPartition(), partitionAnalysis);
	}

	public @NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> addProducer(@NonNull ClassDatum classDatum, @NonNull PartitionAnalysis producer) {
		PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addProducer(producer);
		return traceClassAnalysis;
	}

	public @NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> addProducer(@NonNull PropertyDatum tracePropertyDatum, @NonNull PartitionAnalysis producer) {
		for (@NonNull PropertyDatum superPropertyDatum : QVTscheduleUtil.getSuperPropertyDatums(tracePropertyDatum)) {
			PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> superTracePropertyAnalysis = lazyCreateTracePropertyAnalysis(superPropertyDatum);
			superTracePropertyAnalysis.addProducer(producer);
		}
		return getTracePropertyAnalysis(tracePropertyDatum);
		//		TracePropertyPartitionAnalysis tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		//		tracePropertyAnalysis.addProducer(producer);
		//		return tracePropertyAnalysis;
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
		assert !realizedEdges.contains(realizedEdge);		// Can only be realized in one partition.
		realizedEdges.add(realizedEdge);
		QVTscheduleConstants.POLLED_PROPERTIES.println("  " + typedModel + " realized for " + property);
	}

	public void analyzeFallibilities(@NonNull RootPartitionAnalysis rootPartitionAnalysis) {
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> nestedPartitionAnalysis : rootPartitionAnalysis.getPartitionAnalyses()) {
			if (nestedPartitionAnalysis instanceof CyclicPartitionAnalysis) {
				analyzeFallibilities((CyclicPartitionAnalysis)nestedPartitionAnalysis);
			}
			else if (nestedPartitionAnalysis instanceof LoadingPartitionAnalysis) {
				;
			}
			else if (nestedPartitionAnalysis instanceof MappingPartitionAnalysis<?>) {
				;
			}
			else {
				throw new UnsupportedOperationException();
			}
		}
	}

	protected @NonNull AbstractFallibilityAnalysis analyzeFallibilities(@NonNull CyclicPartitionAnalysis partitionAnalysis) {
		Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> partitionAnalyses = partitionAnalysis.getPartitionAnalyses();
		if (Iterables.size(partitionAnalyses) == 1) {
			PartialRegionAnalysis<@NonNull PartitionsAnalysis> nestedPartitionAnalysis = partitionAnalyses.iterator().next();
			if (nestedPartitionAnalysis instanceof CyclicPartitionAnalysis) {
				return analyzeFallibilities((CyclicPartitionAnalysis)nestedPartitionAnalysis);
			}
			else {
				assert nestedPartitionAnalysis instanceof MappingPartitionAnalysis<?>;
				return getFallibilityAnalysis(nestedPartitionAnalysis.getPartition());
			}
		}
		CyclicFallibilityAnalysis cyclicFallibilityAnalysis = new CyclicFallibilityAnalysis(partitionAnalysis);
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> nestedPartitionAnalysis : partitionAnalyses) {
			if (nestedPartitionAnalysis instanceof CyclicPartitionAnalysis) {
				AbstractFallibilityAnalysis nestedFallibilityAnalysis = analyzeFallibilities((CyclicPartitionAnalysis)nestedPartitionAnalysis);
				cyclicFallibilityAnalysis.analyze(nestedFallibilityAnalysis);
			}
			else {
				assert nestedPartitionAnalysis instanceof MappingPartitionAnalysis<?>;
				Partition nestedPartition = nestedPartitionAnalysis.getPartition();
				FallibilityAnalysis fallibilityAnalysis = partition2fallibilityAnalysis.get(nestedPartition);
				assert fallibilityAnalysis == null;
				cyclicFallibilityAnalysis.analyze((PartitionAnalysis) nestedPartitionAnalysis);
				FallibilityAnalysis oldFallibilityAnalysis = partition2fallibilityAnalysis.put(nestedPartition, cyclicFallibilityAnalysis);
				assert oldFallibilityAnalysis == null;
			}
		}
		cyclicFallibilityAnalysis.analyze();
		return cyclicFallibilityAnalysis;
	}

	public void analyzePartitionEdges(@NonNull Iterable<@NonNull Concurrency> partitionSchedule) {
		typedModel2property2predicatedEdges = new HashMap<>();
		typedModel2property2realizedEdges = new HashMap<>();
		for (@NonNull Concurrency concurrency : partitionSchedule) {
			for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : concurrency) {
				Partition partition = partitionAnalysis.getPartition();
				QVTscheduleConstants.POLLED_PROPERTIES.println("building indexes for " + partition + " " + partition.getPassRangeText());
				((PartitionAnalysis)partitionAnalysis).analyzePartitionEdges();
			}
		}
	}

	public void analyzePartitions(@NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> partitionAnalyses) {
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitionAnalyses) {
			((AbstractPartitionAnalysis<?>)partitionAnalysis).analyzePartition();
		}
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitionAnalyses) {
			((AbstractPartitionAnalysis<?>)partitionAnalysis).analyzePartition2();
		}
	}

	public void computeCheckedOrEnforcedEdges(@NonNull List<@NonNull Concurrency> mergedPartitionSchedule) {
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges2 = typedModel2property2realizedEdges;
		assert typedModel2property2realizedEdges2 != null;
		for (@NonNull Concurrency concurrency : mergedPartitionSchedule) {
			for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : concurrency) {
				((PartitionAnalysis)partitionAnalysis).computeCheckedOrEnforcedEdges();
			}
		}
	}

	protected void computeTraceClassDiscrimination() throws CompilerChainException {
		for (@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> traceClassAnalysis : classDatum2traceClassAnalysis.values()) {
			traceClassAnalysis.discriminate();
		}
	}

	public void computeTraceClassInheritance() {
		Set<@NonNull ClassDatum> missingClassDatums = new HashSet<>();
		for (@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					if (superTraceClassRegionAnalysis == null) {
						missingClassDatums.add(superClassDatum);
					}
				}
			}
		}
		for (@NonNull ClassDatum missingClassDatum : missingClassDatums) {
			lazyCreateTraceClassAnalysis(missingClassDatum);
		}
		for (@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					assert superTraceClassRegionAnalysis != null;
					superTraceClassRegionAnalysis.addSubTraceClassAnalysis(subTraceClassRegionAnalysis);
					subTraceClassRegionAnalysis.addSuperTraceClassAnalysis(superTraceClassRegionAnalysis);
				}
			}
		}
	}

	protected @NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> createTraceClassAnalysis(@NonNull ClassDatum traceClassDatum) {
		return new TraceClassPartitionAnalysis(transformationPartitioner.getTransformationAnalysis().getTraceClassAnalysis(traceClassDatum));
	}

	protected @NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> createTracePropertyAnalysis(@NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		return new TracePropertyPartitionAnalysis(transformationPartitioner, traceClassAnalysis, tracePropertyDatum);
	}

	public @NonNull AbstractFallibilityAnalysis getFallibilityAnalysis(@NonNull Partition partition) {
		AbstractFallibilityAnalysis fallibilityAnalysis = partition2fallibilityAnalysis.get(partition);
		if (fallibilityAnalysis == null) {
			PartitionAnalysis partitionAnalysis = getPartitionAnalysis(partition);
			fallibilityAnalysis = new SelfCyclicFallibilityAnalysis((MappingPartitionAnalysis<?>) partitionAnalysis);
		}
		return fallibilityAnalysis;
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

	private @NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> getTracePropertyAnalysis(@NonNull PropertyDatum tracePropertyDatum) {
		return ClassUtil.nonNullState(propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum));
	}

	private @NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> lazyCreateTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> traceClassAnalysis = classDatum2traceClassAnalysis.get(classDatum);
		if (traceClassAnalysis == null) {
			traceClassAnalysis = createTraceClassAnalysis(classDatum);
			classDatum2traceClassAnalysis.put(classDatum, traceClassAnalysis);
		}
		return traceClassAnalysis;
	}

	private @NonNull PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> lazyCreateTracePropertyAnalysis(@NonNull PropertyDatum tracePropertyDatum) {
		PartialRegionPropertyAnalysis<@NonNull PartitionsAnalysis> tracePropertyAnalysis = propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum);
		if (tracePropertyAnalysis == null) {
			ClassDatum classDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
			PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
			tracePropertyAnalysis = createTracePropertyAnalysis(traceClassAnalysis, tracePropertyDatum);
			propertyDatum2tracePropertyAnalysis.put(tracePropertyDatum, tracePropertyAnalysis);
		}
		return tracePropertyAnalysis;
	}

	public void setLoadingRegionAnalysis(@NonNull LoadingPartitionAnalysis loadingPartitionAnalysis) {
		for (@NonNull ClassDatum classDatum : classDatum2traceClassAnalysis.keySet()) {
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			if (scheduleManager.isInput(typedModel)) {
				PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> classAnalysis = classDatum2traceClassAnalysis.get(classDatum);
				assert classAnalysis != null;
				Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> producers = classAnalysis.getProducers();
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
