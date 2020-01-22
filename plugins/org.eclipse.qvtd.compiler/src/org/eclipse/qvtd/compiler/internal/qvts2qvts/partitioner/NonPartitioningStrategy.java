/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;

/**
 * NonPartitioningStrategy does no partitionings.
 */
public class NonPartitioningStrategy extends AbstractPartitioningStrategy
{
	public NonPartitioningStrategy(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull MappingPartitioner mappingPartitioner) {
		super(partitionedTransformationAnalysis, mappingPartitioner);
		//		assert !scheduleManager.useActivators();
	}

	@Override
	public @NonNull Iterable<@NonNull PartitionAnalysis> partition() {
		createNonPartition();
		check();
		return newPartitionAnalyses;
	}

	protected void createNonPartition() {
		newPartitionAnalyses.add(new NonPartitionFactory(mappingPartitioner).createPartitionAnalysis(partitionedTransformationAnalysis));
	}

	@Override
	protected boolean useActivators() {
		return false;
	}
}