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
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

class NonPartition extends AbstractPartition
{
	protected NonPartition(@NonNull MappingPartitioner partitioner) {
		super(partitioner);
	}

	@Override
	public @NonNull MappingRegion createMicroMappingRegion() {
		return (MappingRegion)originalRegion;
	}

	@Override
	public @NonNull MappingRegion getMicroMappingRegion() {
		return (MappingRegion)originalRegion;
	}

	@Override
	public @NonNull String getName() {
		return PivotUtil.getName(originalRegion);
	}

	@Override
	protected @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return QVTscheduleUtil.getOwnedEdges(originalRegion);
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return QVTscheduleUtil.getOwnedNodes(originalRegion);
	}
}