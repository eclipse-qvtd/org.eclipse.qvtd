/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import com.google.common.collect.Iterables;

/**
 * The TransformationPartitioner supervises a MappingPartitioner for each mapping region. It provides
 * the global analysis to support the local partitioning.
 */
public class TransformationPartitioner
{
	public static @NonNull Iterable<@NonNull MappingRegion> partition(@NonNull ProblemHandler problemHandler, @NonNull Iterable<@NonNull ? extends Region> activeRegions) {
		TransformationPartitioner globalContext = new TransformationPartitioner(problemHandler, activeRegions);
		return globalContext.partition();
	}

	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull Iterable<@NonNull ? extends Region> activeRegions;

	/**
	 * The partitioner for each region.
	 */
	private final @NonNull Map<@NonNull MappingRegion, @NonNull MappingPartitioner> region2mappingPartitioner = new HashMap<>();

	/**
	 * The partitioners in the original activeRegions order.
	 */
	private final @NonNull List<@NonNull MappingPartitioner> mappingPartitioners = new ArrayList<>();

	/**
	 * All speculated-trace to realized node properties that are automatically assignable once their speculation
	 * is validated.
	 */
	private final @NonNull Set<@NonNull Property> corrolaryProperties = new HashSet<>();

	public TransformationPartitioner(@NonNull ProblemHandler problemHandler, @NonNull Iterable<@NonNull ? extends Region> activeRegions) {
		this.problemHandler = problemHandler;
		this.activeRegions = activeRegions;
	}

	public void addCorrolary(@NonNull Property property) {
		corrolaryProperties.add(property);
	}

	public void addProblem(@NonNull CompilerProblem problem) {
		problemHandler.addProblem(problem);
	}

	private void gatherCorrolaries(@NonNull Set<@NonNull Property> corrolaryProperties, @NonNull MappingRegion region) {
		List<@NonNull Node> middleNodes = new ArrayList<>();
		for (@NonNull Node node : RegionUtil.getOwnedNodes(region)) {
			if (!node.isTrue() && node.isPattern() && node.isRealized() && RegionUtil.getClassDatumAnalysis(node).getDomainUsage().isMiddle()) {
				middleNodes.add(node);
			}
		}
		for (@NonNull Node node : middleNodes) {
			for (@NonNull NavigableEdge edge : node.getNavigationEdges()) {
				if (edge.isRealized() && edge.getEdgeTarget().isRealized()) {
					corrolaryProperties.add(RegionUtil.getProperty(edge));
				}
			}
		}
	}

	public boolean isCorrolary(@NonNull Edge edge) {
		if (!edge.isNavigation()) {
			return false;
		}
		return corrolaryProperties.contains(((NavigableEdge)edge).getProperty());
	}

	public @NonNull Iterable<@NonNull MappingRegion> partition() {
		Set<@NonNull Property> corrolaryProperties = new HashSet<>();
		for (@NonNull Region region : activeRegions) {
			if (region instanceof MappingRegion) {
				gatherCorrolaries(corrolaryProperties, (MappingRegion)region);
			}
		}
		for (@NonNull Region region : activeRegions) {
			if (region instanceof MappingRegion) {
				MappingRegion mappingRegion = (MappingRegion)region;
				MappingPartitioner mappingPartitioner = new MappingPartitioner(problemHandler, mappingRegion, corrolaryProperties);
				region2mappingPartitioner.put(mappingRegion, mappingPartitioner);
				mappingPartitioners.add(mappingPartitioner);
			}
		}
		List<@NonNull MappingRegion> partitionedRegions = new ArrayList<>();
		for (@NonNull MappingPartitioner mappingPartitioner : mappingPartitioners) {
			Iterables.addAll(partitionedRegions, mappingPartitioner.partition());
		}
		return partitionedRegions;
	}
}
