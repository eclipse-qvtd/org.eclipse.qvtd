/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;

public interface ScheduledRegion extends Region
{	
	void addEdgeConnection(@NonNull EdgeConnection edgeConnection);
	void addNodeConnection(@NonNull NodeConnection nodeConnection);
	@NonNull CyclicScheduledRegion createCyclicScheduledRegion(@NonNull Iterable<@NonNull Region> cycle);
	void createLocalSchedule();
	void createLocalSchedule2(@NonNull List<@NonNull Region> orderedRegions);
	@NonNull NodeConnection getAttributeConnection(@NonNull Iterable<@NonNull Node> sourceNodes, @NonNull CompleteClass owningClass, @NonNull Property property, @NonNull ClassDatumAnalysis classDatumAnalysis);
	@NonNull Iterable<@NonNull Region> getCallableRegions();
	@NonNull Collection<@NonNull Connection> getConnections();
	@NonNull EdgeConnection getEdgeConnection(@NonNull Iterable<@NonNull NavigableEdge> sourceEdges, @NonNull Property property);
	@NonNull Iterable<@NonNull EdgeConnection> getEdgeConnections();
	@NonNull NodeConnection getNodeConnection(@NonNull Iterable<@NonNull Node> sourceNodes, @NonNull ClassDatumAnalysis classDatumAnalysis);
	@NonNull Iterable<@NonNull NodeConnection> getNodeConnections();
	@Nullable Region getNormalizedRegion(@NonNull Region region);
	@NonNull List<@NonNull Region> getRegions();
	@NonNull RootScheduledRegion getRootScheduledRegion();
	void removeConnection(@NonNull Connection connection);
	void replaceSources(@NonNull NodeConnection connection, @NonNull Set<@NonNull Node> obsoleteSourceNodes, @NonNull Node newSourceNode);
	void writeDebugGraphs(@NonNull String context, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph);
}