/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Concurrency;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;

public abstract class AbstractCompositePartitionAnalysis<P extends CompositePartition> extends AbstractPartitionAnalysis<P> implements CompositePartitionAnalysis
{
	protected final @NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> originalPartitionAnalysis2predecessors;
	protected final @NonNull Set<@NonNull PartitionAnalysis> partitionAnalyses;
	private @Nullable List<@NonNull Concurrency> partitionSchedule = null;

	protected AbstractCompositePartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull P controlPartition,
			@NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors) {
		super(partitionedTransformationAnalysis, controlPartition);
		this.originalPartitionAnalysis2predecessors = partitionAnalysis2predecessors;
		this.partitionAnalyses = new HashSet<>(partitionAnalysis2predecessors.keySet());
		List<MappingPartition> ownedMappingPartitions = controlPartition.getOwnedMappingPartitions();
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
			ownedMappingPartitions.add((MappingPartition) partitionAnalysis.getPartition());
		}
	}

	/**
	 * Append additional concurrencies to partitionSchedule.
	 *
	 * All non-composite partitionAnalyses are added to a first additional concurrency.
	 *
	 * For composite partitionAnalyses, their first concurrency is folded into the first additional concurrency. Further concurrencies contribute
	 * to further additional concurrencies similarly merged concurrencies.
	 */
	protected void appendConcurrency(@NonNull List<@NonNull Concurrency> partitionSchedule, @NonNull Iterable<@NonNull PartitionAnalysis> partitionAnalyses) {
		Concurrency nonCompositeConcurrency = null;
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {		// FIXME alphabetical for determinism
			if (!(partitionAnalysis instanceof CompositePartitionAnalysis)) {
				if (nonCompositeConcurrency == null) {
					nonCompositeConcurrency = new Concurrency();
				}
				nonCompositeConcurrency.add(partitionAnalysis);
			}
		}
		if (nonCompositeConcurrency != null) {
			partitionSchedule.add(nonCompositeConcurrency);
		}
		int compositeConcurrencyPass = partitionSchedule.size();
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {		// FIXME alphabetical for determinism
			if (partitionAnalysis instanceof CompositePartitionAnalysis) {
				Iterable<@NonNull Concurrency> nestedConcurrencies = ((CompositePartitionAnalysis)partitionAnalysis).getPartitionSchedule();
				overlayConcurrency(partitionSchedule, compositeConcurrencyPass, nestedConcurrencies);
			}
		}
	}

	protected abstract @NonNull List<@NonNull Concurrency> createPartitionSchedule();

	@Override
	public @NonNull Iterable<@NonNull PartitionAnalysis> getPartitionAnalyses() {
		return partitionAnalyses;
	}

	@Override
	public @NonNull List<@NonNull Concurrency> getPartitionSchedule() {
		List<@NonNull Concurrency> partitionSchedule2 = partitionSchedule;
		if (partitionSchedule2 == null) {
			partitionSchedule = partitionSchedule2 = createPartitionSchedule();
		}
		return partitionSchedule2;
	}

	public void merge(@NonNull Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> old2new) {
		/*		Set<@NonNull PartitionAnalysis> oldKeys = partitionAnalysis2predecessors.keySet();
		if (QVTbaseUtil.containsAny(oldKeys, old2new.keySet())) {
			Set<@NonNull PartitionAnalysis> keys = new HashSet<>(oldKeys);

			// TODO Auto-generated method stub
		} */
		List<MappingPartition> ownedMappingPartitions = partition.getOwnedMappingPartitions();
		for (@NonNull PartitionAnalysis oldPartitionAnalysis : new HashSet<>(old2new.keySet())) {
			boolean wasRemoved = partitionAnalyses.remove(oldPartitionAnalysis);
			assert wasRemoved;
			assert !ownedMappingPartitions.contains(oldPartitionAnalysis.getPartition());
			PartitionAnalysis newPartitionAnalysis = old2new.get(oldPartitionAnalysis);
			if (newPartitionAnalysis != null) {
				partitionAnalyses.add(newPartitionAnalysis);
				assert ownedMappingPartitions.contains(newPartitionAnalysis.getPartition());
			}
		}
	}

	/**
	 * Add additional concurrencies of non-composite partitionAnalyses to partitionSchedule.
	 *
	 * All non-composite partitionAnalyses are added to a first additional concurrency.
	 *
	 * For composite partitionAnalyses, their first concurrency is folded into the first additional concurrency. Further concurrencies contribute
	 * to further additional concurrencies similarly merged concurrencies.
	 */
	private void overlayConcurrency(@NonNull List<@NonNull Concurrency> partitionSchedule,
			int initialPass, @NonNull Iterable<@NonNull Concurrency> newConcurrencies) {
		int mergePass = initialPass;
		for (@NonNull Concurrency newConcurrency : newConcurrencies) {
			assert newConcurrency.size() > 0;
			if (partitionSchedule.size() <= mergePass) {
				partitionSchedule.add(new Concurrency());
			}
			assert mergePass < partitionSchedule.size();
			Concurrency concurrency = partitionSchedule.get(mergePass);
			if (newConcurrency.isCycleStart()) {
				concurrency.setCycleStart();
			}
			if (newConcurrency.isCycleEnd()) {
				concurrency.setCycleEnd();
			}
			for (@NonNull PartitionAnalysis partitionAnalysis : newConcurrency) {
				concurrency.add(partitionAnalysis);
			}
			mergePass++;
		}
	}
}