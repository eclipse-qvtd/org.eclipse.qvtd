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

import org.eclipse.jdt.annotation.NonNull;

/**
 * A derived PartitionFactory creates an appropriately derived Partition for a partial Region implementation.
 *
 * Currently there is a distinct PartitionFactory for each distinct Partition.
 *
 * It is intended to unify the derived Partitions so that variant functionality is limitred to the unmodeled PartitionFactory
 * requiring fewer Partition variants in the model.
 */
public interface PartitionFactory
{
	@NonNull PartitionAnalysis createPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis);
}