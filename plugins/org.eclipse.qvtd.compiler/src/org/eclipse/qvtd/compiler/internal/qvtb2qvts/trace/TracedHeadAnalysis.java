/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

/**
 * TracedHeadAnalysis supports a multi-directional analysis performed before the trace nodes are synthesized.
 * It facilitates the determination of the unit-oppositeness of trace to model properties.
 */
public class TracedHeadAnalysis extends HeadAnalysis
{
	/**
	 * Return the head(s) of each TypedModel, mapped to the closure of elements that are transitively and bidirectionally one to one navigable from them.
	 *
	 * This computation has no side effects.
	 */
	public static @NonNull List<@NonNull HeadNodeGroup> computeTraceHeadGroupNodes(@NonNull ScheduleManager scheduleManager, @NonNull MappingRegion mappingRegion) {
		TracedHeadAnalysis mappingRegionAnalysis = new TracedHeadAnalysis(mappingRegion);
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources = mappingRegionAnalysis.computeTracedTargetFromSources();
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
		return mappingRegionAnalysis.computeHeadNodeGroups(targetFromSourcesClosure, sourceToTargetsClosure, null);
	}

	protected TracedHeadAnalysis(@NonNull MappingRegion mappingRegion) {
		super(mappingRegion);
	}

	private @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> computeTracedTargetFromSources() {
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources = new HashMap<>();
		for (@NonNull Node sourceNode : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (sourceNode.isPattern() /*&& sourceNode.isUnconditional()*/) {
				Set<@NonNull Node> sources1 = targetFromSources.get(sourceNode);
				if (sources1 == null) {
					sources1 = Sets.newHashSet(sourceNode);
					targetFromSources.put(sourceNode, sources1);
				}
				for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(sourceNode)) {
					if (edge instanceof NavigationEdge) {
						NavigationEdge navigationEdge = (NavigationEdge) edge;
						Property source2targetProperty = QVTscheduleUtil.getReferredProperty(navigationEdge);
						//					boolean isRequired = source2targetProperty.isIsRequired();
						boolean isMany = source2targetProperty.isIsMany();
						Node targetNode = navigationEdge.getEdgeTarget();
						if (!isMany || targetNode.isDataType()) {
							if (targetNode.isMatched() /*&& targetNode.isClass()*/ && !targetNode.isNullLiteral() && !targetNode.isConstant()) {
								Set<@NonNull Node> sources2 = targetFromSources.get(targetNode);
								if (sources2 == null) {
									sources2 = Sets.newHashSet(targetNode);
									targetFromSources.put(targetNode, sources2);
								}
								sources2.add(sourceNode);
							}
						}
					}
				}
			}
		}
		return targetFromSources;
	}
}