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

import java.util.HashMap;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.AbstractPartialRegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * PartitionedTransformationAnalysis<PRA> provides the mandatory default mangement of ClassDatum and PropertyDatum usage by partitions for a PartitionsAnalysis.
 */
public class PartitionedTransformationAnalysis extends AbstractPartialRegionsAnalysis<@NonNull PartitionsAnalysis>
{
	protected final @NonNull TransformationPartitioner transformationPartitioner;

	/**
	 * The PartitionAnalysis for each Partition.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull AbstractPartitionAnalysis<? extends @NonNull Partition>> partition2partitionAnalysis = new HashMap<>();

	/**
	 * The FallibilityAnalysis for each Partition.
	 */
	private final @NonNull Map<@NonNull Partition, @NonNull AbstractFallibilityAnalysis> partition2fallibilityAnalysis = new HashMap<>();

	private @Nullable RootPartitionAnalysis rootPartitionAnalysis = null;

	public PartitionedTransformationAnalysis(@NonNull TransformationPartitioner transformationPartitioner) {
		super(transformationPartitioner.getScheduleManager());
		this.transformationPartitioner = transformationPartitioner;
	}

	public void addPartitionAnalysis(@NonNull AbstractPartitionAnalysis<? extends @NonNull Partition> partitionAnalysis) {
		partition2partitionAnalysis.put(partitionAnalysis.getPartition(), partitionAnalysis);
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

	public void analyzePartitions(@NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> partitionAnalyses) {
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitionAnalyses) {
			((AbstractPartitionAnalysis<?>)partitionAnalysis).analyzePartition();
		}
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitionAnalyses) {
			((AbstractPartitionAnalysis<?>)partitionAnalysis).analyzePartition2();
		}
	}

	@Override
	protected @NonNull PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> createClassAnalysis(@NonNull ClassDatum classDatum) {
		AbstractTransformationAnalysis transformationAnalysis = transformationPartitioner.getTransformationAnalysis();
		PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis = transformationAnalysis.getClassAnalysis(classDatum);	// This fails if ClassDatum instances are not created in a timely fashion
		return new TraceClassPartitionAnalysis(classAnalysis);
	}

	public @NonNull AbstractFallibilityAnalysis getFallibilityAnalysis(@NonNull Partition partition) {
		AbstractFallibilityAnalysis fallibilityAnalysis = partition2fallibilityAnalysis.get(partition);
		if (fallibilityAnalysis == null) {
			PartitionAnalysis partitionAnalysis = getPartitionAnalysis(partition);
			fallibilityAnalysis = new SelfCyclicFallibilityAnalysis((MappingPartitionAnalysis<?>) partitionAnalysis);
		}
		return fallibilityAnalysis;
	}

	@Override
	public String getName() {
		return transformationPartitioner.getName();
	}

	public @NonNull AbstractPartitionAnalysis<?> getPartitionAnalysis(@NonNull Partition partition) {
		return ClassUtil.nonNullState(partition2partitionAnalysis.get(partition));
	}

	public @NonNull RootPartitionAnalysis getRootPartitionAnalysis() {
		return ClassUtil.nonNullState(rootPartitionAnalysis);
	}

	public void setLoadingRegionAnalysis(@NonNull LoadingPartitionAnalysis loadingPartitionAnalysis) {
		for (@NonNull ClassDatum classDatum : classDatum2classAnalysis.keySet()) {
			TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
			if (scheduleManager.isInput(typedModel)) {
				PartialRegionClassAnalysis<@NonNull PartitionsAnalysis> classAnalysis = classDatum2classAnalysis.get(classDatum);
				assert classAnalysis != null;
				Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> producers = classAnalysis.getCompatibleProducers();
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
