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
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.CompositePartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;

public abstract class AbstractCompositePartitionAnalysis<P extends CompositePartition> extends AbstractPartitionAnalysis<P> implements CompositePartitionAnalysis
{
	protected final @NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors;
	private @Nullable List<@NonNull Set<@NonNull PartitionAnalysis>> partitionSchedule = null;

	protected AbstractCompositePartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull P controlPartition,
			@NonNull Map<@NonNull PartitionAnalysis, @NonNull Set<@NonNull PartitionAnalysis>> partitionAnalysis2predecessors) {
		super(partitionedTransformationAnalysis, controlPartition);
		this.partitionAnalysis2predecessors = partitionAnalysis2predecessors;
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalysis2predecessors.keySet()) {
			controlPartition.getOwnedMappingPartitions().add((MappingPartition) partitionAnalysis.getPartition());
		}
	}

	protected abstract @NonNull List<@NonNull Set<@NonNull PartitionAnalysis>> createPartitionSchedule();

	@Override
	public @NonNull Iterable<@NonNull PartitionAnalysis> getPartitionAnalyses() {
		return partitionAnalysis2predecessors.keySet();
	}

	@Override
	public @NonNull List<@NonNull Set<@NonNull PartitionAnalysis>> getPartitionSchedule() {
		List<@NonNull Set<@NonNull PartitionAnalysis>> partitionSchedule2 = partitionSchedule;
		if (partitionSchedule2 == null) {
			partitionSchedule = partitionSchedule2 = createPartitionSchedule();
		}
		return partitionSchedule2;
	}

	public void merge(@NonNull Map<@NonNull PartitionAnalysis, @Nullable PartitionAnalysis> old2new) {
		Set<@NonNull PartitionAnalysis> oldKeys = partitionAnalysis2predecessors.keySet();
		if (QVTbaseUtil.containsAny(oldKeys, old2new.keySet())) {
			Set<@NonNull PartitionAnalysis> keys = new HashSet<>(oldKeys);

			// TODO Auto-generated method stub
		}

	}
}