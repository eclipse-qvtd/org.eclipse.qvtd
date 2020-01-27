/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

/**
 * TracedHeadAnalysis supports a multi-directional analysis performed before the trace nodes are synthesized.
 * It facilitates the determination of the unit-oppositeness of trace to model properties.
 */
public class TracedHeadAnalysis extends HeadAnalysis
{
	public static final @NonNull TracingOption TRACED_HEAD_NODE_GROUPS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtr2qvts/trace/headNodeGroups");
	public static final @NonNull TracingOption TRACED_HEAD_IMMEDIATE_SOURCES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtr2qvts/trace/headSources");

	/**
	 * Return the head(s) of each TypedModel, mapped to the closure of elements that are transitively and bidirectionally one to one navigable from them.
	 *
	 * This computation has no side effects.
	 */
	public static @NonNull List<@NonNull HeadNodeGroup> computeTraceHeadGroupNodes(@NonNull MappingRegion mappingRegion, @NonNull Set<@NonNull Node> excludedNodes) {
		//	String name = mappingRegion.getName();
		TracedHeadAnalysis mappingRegionAnalysis = new TracedHeadAnalysis(mappingRegion);
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources = mappingRegionAnalysis.computeTracedTargetFromSources(excludedNodes);
		if (TRACED_HEAD_IMMEDIATE_SOURCES.isActive()) {
			StringBuilder s = new StringBuilder();
			s.append(mappingRegion.getName());
			List<@NonNull Node> targets = new ArrayList<>(targetFromSources.keySet());
			Collections.sort(targets, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull Node target : targets) {
				s.append("\n  " + target.getName() + ":");
				List<@NonNull Node> sources = new ArrayList<>(targetFromSources.get(target));
				Collections.sort(sources, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull Node source : sources) {
					s.append(" " + source.getName());
				}
			}
			TRACED_HEAD_IMMEDIATE_SOURCES.println(s.toString());
		}
		//
		//	Ripple the local target-from-sources to compute the overall target-from-sources closure.
		//
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourcesClosure = CompilerUtil.computeClosure(targetFromSources);
		//
		//	Compute the inverse Set of all source nodes from which a particular target node can be reached by transitive to-one navigation.
		//
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> sourceToTargetsClosure = CompilerUtil.computeInverseClosure(targetFromSourcesClosure);
		//
		//	Locate the head node groups of each to-one navigable sub-region.
		//
		List<@NonNull HeadNodeGroup> headNodeGroups = mappingRegionAnalysis.computeHeadNodeGroups(targetFromSourcesClosure, sourceToTargetsClosure, null);
		Collections.sort(headNodeGroups, NameUtil.NAMEABLE_COMPARATOR);
		if (TRACED_HEAD_NODE_GROUPS.isActive()) {
			StringBuilder s = new StringBuilder();
			s.append(mappingRegion.getName());
			for (@NonNull HeadNodeGroup headNodeGroup : headNodeGroups) {
				s.append("\n\t");
				headNodeGroup.appendTo(s);
			}
			TRACED_HEAD_NODE_GROUPS.println(s.toString());
		}
		return headNodeGroups;
	}

	protected TracedHeadAnalysis(@NonNull MappingRegion mappingRegion) {
		super(mappingRegion);
	}

	private @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> computeTracedTargetFromSources(@NonNull Set<@NonNull Node> excludedNodes) {
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources = new HashMap<>();
		for (@NonNull Node targetNode : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (!excludedNodes.contains(targetNode) && !targetNode.isConditional() && !targetNode.isConstant()) {
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(targetNode);
				TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
				if (!typedModel.isIsTrace()) {		// when/where invocation nodes are not part of the multi-sided trace
					Set<@NonNull Node> sources = targetFromSources.get(targetNode);
					if (sources == null) {
						sources = Sets.newHashSet(targetNode);
						targetFromSources.put(targetNode, sources);
					}
					for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
						Node sourceNode = edge.getEdgeSource();
						if (!excludedNodes.contains(sourceNode) && !sourceNode.isConditional() && !sourceNode.isConstant()) {
							if (edge instanceof NavigationEdge) {
								if (!((NavigationEdge)edge).isPartial()) {
									sources.add(sourceNode);
								}
							}
							else if (edge instanceof CastEdge) {
								sources.add(sourceNode);
							}
							else if (edge instanceof KeyPartEdge) {
								sources.add(sourceNode);
							}
							else if (edge instanceof PredicateEdge) {
								if (!((PredicateEdge)edge).isPartial()) {
									sources.add(sourceNode);
								}
							}
						}
					}
				}
			}
		}
		return targetFromSources;
	}

	@Override
	protected @NonNull HeadNodeGroup createHeadNodeGroup(@NonNull List<@NonNull Node> headNodeGroup) {
		return new TracedHeadNodeGroup(headNodeGroup);
	}
}