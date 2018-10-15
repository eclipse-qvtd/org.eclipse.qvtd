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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public abstract class AbstractPartitionFactory implements PartitionFactory
{
	protected @NonNull MappingPartitioner mappingPartitioner;

	protected AbstractPartitionFactory(@NonNull MappingPartitioner mappingPartitioner) {
		this.mappingPartitioner = mappingPartitioner;
	}

	protected @NonNull String computeName(@NonNull String suffix){
		return QVTscheduleUtil.getName(mappingPartitioner.getRegionAnalysis().getRegion()) + "«" + suffix + "»";
	}

	/**
	 * Return the navigable edges that may be used by to locate nodes by this partition.
	 * The default implementation returns all old primary navigable edges
	 * and all already realized navigable edges
	 */
	protected @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges() {
		List<@NonNull NavigableEdge> navigableEdges = Lists.newArrayList(mappingPartitioner.getOldPrimaryNavigableEdges());
		for (@NonNull Edge edge : mappingPartitioner.getAlreadyRealizedEdges()) {
			if (edge instanceof NavigableEdge) {
				navigableEdges.add((NavigableEdge) edge);
			}
		}
		return navigableEdges;
	}

	protected @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Iterable<@NonNull Node> traceNodes = mappingPartitioner.getTraceNodes();
		Iterable<@NonNull Node> constantInputNodes = mappingPartitioner.getConstantInputNodes();
		return Iterables.concat(traceNodes, constantInputNodes);
	}

	@Override
	public @NonNull String toString() {
		return getClass().getSimpleName() + " for " + mappingPartitioner;
	}
}