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
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.NonPartition;

public class NonPartitionAnalysis extends MappingPartitionAnalysis<NonPartition>
{
	/**
	 * The mechanisms to reach required nodes.
	 */
	private final @NonNull ReachabilityForest reachabilityForest;

	public NonPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis,
			@NonNull NonPartition partition, @NonNull ReachabilityForest reachabilityForest) {
		super(partitionedTransformationAnalysis, partition);
		this.reachabilityForest = reachabilityForest;
		partitionedTransformationAnalysis.addPartitionAnalysis(this);
	}

	@Override
	public @NonNull ReachabilityForest getReachabilityForest() {
		return reachabilityForest;
	}
}