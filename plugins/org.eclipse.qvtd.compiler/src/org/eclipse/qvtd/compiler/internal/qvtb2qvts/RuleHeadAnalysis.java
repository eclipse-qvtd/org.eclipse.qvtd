/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

/**
 * RuleHeadAnalysis is a helper class to compute the head nodes of a region.
 */
public class RuleHeadAnalysis extends HeadAnalysis
{
	/**
	 * Return the minimal head(s) of a partitioned MappingRegion from which all old nodes in the region may be reached by to-one navigation.
	 *
	 * The head/not-head nodes are installed by invoking Node.setHead(true/false) as appropriate.
	 *
	 * FIXME is this an unduely complicated way of computing the traceNode ??
	 */
	public static @NonNull Iterable<@NonNull Node> computeRealizedHeadNodes(@NonNull MappingRegion mappingRegion, @NonNull List<@NonNull Node> realizedMiddleNodes) {
		RuleHeadAnalysis mappingRegionAnalysis = new RuleHeadAnalysis(mappingRegion);
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure = mappingRegionAnalysis.computeNewTargetFromSources(realizedMiddleNodes);
		Iterable<@NonNull Node> headNodes = mappingRegionAnalysis.computeHeadNodes(targetFromSourceClosure, null);
		return headNodes;
	}

	/**
	 * Return the minimal head(s) of a MappingRegion from which all old nodes in the region may be reached by to-one navigation.
	 *
	 * This uni-directional analysis is performed after the trace nodes are synthesized and so can exploit to-one traces to
	 * locate output nodes wrt input nodes.
	 *
	 * The head/not-head nodes are installed by invoking Node.setHead(true/false) as appropriate.
	 */
	public static @NonNull Iterable<@NonNull Node> computeRuleHeadNodes(@NonNull ScheduleManager scheduleManager, @NonNull MappingRegion mappingRegion, @Nullable List<@NonNull Node> preferredHeadNodes) {
		RuleHeadAnalysis mappingRegionAnalysis = new RuleHeadAnalysis(mappingRegion);
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources =  mappingRegionAnalysis.computeOldTargetFromSources();
		Iterable<@NonNull Node> headNodes =  mappingRegionAnalysis.computeHeadNodes(targetFromSources, preferredHeadNodes);
		mappingRegionAnalysis.checkHeadNodeConsistency(headNodes);
		return headNodes;
	}

	protected RuleHeadAnalysis(@NonNull MappingRegion mappingRegion) {
		super(mappingRegion);
	}

	private void addExtraHeads(@NonNull List<@NonNull Node> headNodes) {
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			//			assert !node.isDependency();
			if (node.isDependency()) {
				node.setHead();
				assert !headNodes.contains(node);
				headNodes.add(node);
			}
		}
	}

	private void checkHeadNodeConsistency(@NonNull Iterable<@NonNull Node> headNodes) {
		Set<@NonNull Node> debugHeadNodes = new HashSet<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (node.isDependency() || node.isHead()) {
				debugHeadNodes.add(node);
			}
		}
		assert debugHeadNodes.equals(Sets.newHashSet(headNodes));
	}

	private @NonNull Iterable<@NonNull Node> computeHeadNodes(@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources, @Nullable List<@NonNull Node> preferredHeadNodes) {
		//
		//	Ripple the local target-from-sources to compute the overall target-from-sources closure.
		//
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourcesClosure = CompilerUtil.computeClosure(targetFromSources);
		//
		//	Compute the inverse Set of all source nodes from which a particular target node can be reached by transitive to-one navigation.
		//
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> sourceToTargetsClosure = CompilerUtil.computeInverseClosure(targetFromSourcesClosure);
		List<@NonNull HeadNodeGroup> headNodeGroups = computeHeadNodeGroups(targetFromSourcesClosure, sourceToTargetsClosure, preferredHeadNodes);
		List<@NonNull Node> headNodes = selectHeadNodes(headNodeGroups, preferredHeadNodes);
		//
		//	Add the pseudo-heads for true and dependency nodes.
		//
		addExtraHeads(headNodes);
		//
		//	Set/reset the head flag on each node.
		//
		setHeadNodes(targetFromSourcesClosure.keySet(), headNodes);
		return headNodes;
	}

	//
	//	Compute the Set of all source nodes from which each target can be reached by transitive to-one new navigation.
	//
	private @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> computeNewTargetFromSources(@NonNull Iterable<@NonNull Node> realizedMiddleNodes) {
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources = new HashMap<>();
		for (@NonNull Node sourceNode : realizedMiddleNodes) {
			Set<@NonNull Node> sources1 = targetFromSources.get(sourceNode);
			if (sources1 == null) {
				sources1 = Sets.newHashSet(sourceNode);
				targetFromSources.put(sourceNode, sources1);
			}
			for (@NonNull NavigationEdge navigationEdge : sourceNode.getRealizedNavigationEdges()) {
				Node targetNode = navigationEdge.getEdgeTarget();
				Set<@NonNull Node> sources2 = targetFromSources.get(targetNode);
				if (sources2 == null) {
					sources2 = Sets.newHashSet(targetNode);
					targetFromSources.put(targetNode, sources2);
				}
				sources2.add(sourceNode);
			}
		}
		return targetFromSources;
	}

	//
	//	Compute the Set of all source nodes from which each target can be reached by a direct to-one old navigation.
	//
	private @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> computeOldTargetFromSources() {
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSources = new HashMap<>();
		for (@NonNull Node sourceNode : QVTscheduleUtil.getOwnedNodes(mappingRegion)) {
			if (sourceNode.isPattern() && sourceNode.isMatched() && sourceNode.isClass() && !sourceNode.isConstant() && !sourceNode.isOperation()) {	// Excludes, null, attributes, constants, operations
				if (sourceNode.isLoaded() || sourceNode.isChecked()) {
					Set<@NonNull Node> sources1 = targetFromSources.get(sourceNode);
					if (sources1 == null) {
						sources1 = Sets.newHashSet(sourceNode);
						targetFromSources.put(sourceNode, sources1);
					}
					for (@NonNull NavigableEdge navigationEdge : sourceNode.getNavigableEdges()) {
						if (!navigationEdge.isRealized()) {
							Property source2targetProperty = QVTscheduleUtil.getProperty(navigationEdge);
							if (!source2targetProperty.isIsMany() /*&& source2targetProperty.isIsRequired()*/) {
								Node targetNode = navigationEdge.getEdgeTarget();
								if (targetNode.isMatched() /*&& targetNode.isClass()*/ && !targetNode.isConstant()) {
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
		}
		return targetFromSources;
	}

	private void setHeadNodes(@NonNull Set<@NonNull Node> reachableNodes, @NonNull List<@NonNull Node> headNodes) {
		for (@NonNull Node node : reachableNodes) {
			if (headNodes.contains(node)) {
				node.setHead();
			}
			else {
				node.resetHead();
			}
		}
	}
}