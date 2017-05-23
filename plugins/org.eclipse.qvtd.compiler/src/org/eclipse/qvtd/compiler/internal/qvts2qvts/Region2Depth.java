/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

/**
 * Region2Depth provides facilities that use a temporary cache depth of the region passing binding tree.
 * A temporary cache is needed since merges invalidate depths.
 */
public class Region2Depth
{
	/**
	 * The lazily computed depth of each region; 0 at root, +1 for each region invocation.
	 */
	private @NonNull Map<@NonNull Region, @Nullable Integer> region2depth = new HashMap<>();

	/**
	 * The lazily computed parents (invokers) of each region.
	 */
	private @NonNull Map<@NonNull Region, @NonNull List<@NonNull Region>> region2parents = new HashMap<>();

	/**
	 * The lazily computed children (invoked) of each region.
	 */
	private @NonNull Map<@NonNull Region, @NonNull List<@NonNull Region>> region2children = new HashMap<>();

	/**
	 * The lazily computed parents closure (invokers) of each region all of whose depth is less than that of the region.
	 * I.e. for regions in a cycle the ancestors depends on and is consistent with the choice of the shallowest node
	 * in the cycle.
	 */
	private @NonNull Map<@NonNull Region, @NonNull Set<@NonNull Region>> region2properAncestors = new HashMap<>();

	public void addRegion(@NonNull Region region) {
		region2children.clear();	// FIXME do intelligent update rather than recalculate
		region2depth.clear();
		region2parents.clear();
		QVTm2QVTs.REGION_DEPTH.println(getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this)) + " <reset> : " + region.getName());
	}

	/**
	 * Return the deepest region in the region call tree that is common to firstRegion and secondRegion.
	 */
	public @Nullable Region getCommonRegion(@NonNull Region firstRegion, @NonNull Region secondRegion) {
		Region thisRegion = firstRegion;
		Region thatRegion = secondRegion;
		while (thisRegion != thatRegion) {
			int thisDepth = getRegionDepth(thisRegion);
			int thatDepth = getRegionDepth(thatRegion);
			if (thisDepth > thatDepth) {
				thisRegion = getMinimumDepthParentRegion(thisRegion);
				if (thisRegion == null) {
					return null;
				}
			}
			else if (thatDepth > thisDepth) {
				thatRegion = getMinimumDepthParentRegion(thatRegion);
				if (thatRegion == null) {
					return null;
				}
			}
			else {
				thisRegion = getMinimumDepthParentRegion(thisRegion);
				thatRegion = getMinimumDepthParentRegion(thatRegion);
				if ((thisRegion == null) || (thatRegion == null)) {
					return null;
				}
			}
		}
		return thisRegion;
	}

	/**
	 * Return a/the parent region that is no deeper than any other parent region.
	 * Returns null at the root.
	 */
	public @Nullable Region getMinimumDepthParentRegion(@NonNull Region childRegion) {
		Region minimumDepthParentRegion = null;
		int minimumDepth = Integer.MAX_VALUE;
		for (@NonNull Region parentRegion : getParentRegions(childRegion)) {
			int parentDepth = getRegionDepth(parentRegion);
			if ((minimumDepthParentRegion == null) || (parentDepth < minimumDepth)) {
				minimumDepthParentRegion = parentRegion;
				minimumDepth = parentDepth;
			}
		}
		return minimumDepthParentRegion;
	}

	public @NonNull Iterable<@NonNull Region> getParentRegions(@NonNull Region childRegion) {
		ScheduledRegion childInvokingRegion = childRegion.getOwningScheduledRegion();
		int childInvokingRegionDepth = childInvokingRegion != null ? getRegionDepth(childInvokingRegion) : 0;
		List<@NonNull Region> parentRegions = region2parents.get(childRegion);
		if (parentRegions == null) {
			parentRegions = new ArrayList<>();
			for (@NonNull DatumConnection<?> parentConnection : childRegion.getIncomingPassedConnections()) {
				for (@NonNull Node source : parentConnection.getSourceNodes()) {
					Region sourceRegion = RegionUtil.getOwningRegion(source);
					ScheduledRegion sourceInvokingRegion = sourceRegion.getOwningScheduledRegion();
					int sourceInvokingRegionDepth = sourceInvokingRegion != null ? getRegionDepth(sourceInvokingRegion) : 0;
					Region parentRegion = sourceInvokingRegionDepth < childInvokingRegionDepth ? childInvokingRegion : sourceRegion;
					//					if ((scheduledRegion == null)
					//					 || (parentRegion == scheduledRegion)
					//					 || (parentRegion.getInvokingRegion() == scheduledRegion)) {
					if ((parentRegion != null) && !parentRegions.contains(parentRegion)) {
						parentRegions.add(parentRegion);
					}
					//					}
				}
			}
			if (parentRegions.isEmpty() && (childInvokingRegion != null)) {
				parentRegions.add(childInvokingRegion);
			}
			region2parents.put(childRegion, parentRegions);
		}
		return parentRegions;
	}

	protected @NonNull Set<@NonNull Region> getProperAncestorRegions(@NonNull Region childRegion) {
		Set<@NonNull Region> properAncestorRegions = region2properAncestors.get(childRegion);
		if (properAncestorRegions == null) {
			properAncestorRegions = new HashSet<>();
			int childDepth = getRegionDepth(childRegion);
			for (@NonNull Region parentRegion : getParentRegions(childRegion)) {
				int parentDepth = getRegionDepth(parentRegion);
				if (parentDepth < childDepth) {
					properAncestorRegions.add(parentRegion);
					properAncestorRegions.addAll(getProperAncestorRegions(parentRegion));
				}
			}
			region2properAncestors.put(childRegion, properAncestorRegions);
		}
		return properAncestorRegions;
	}

	/**
	 * Return the region depth as determined by the PassedBinding call tree. 0 at root.
	 */
	public int getRegionDepth(@NonNull Region region) {
		Integer depth = region2depth.get(region);
		if (depth == null) {
			if (region2depth.containsKey(region)) {
				QVTm2QVTs.REGION_DEPTH.println(getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this)) + " <loop> : " + region.getName());
				return 0;
			}
			region2depth.put(region, null);
			depth = 0;
			Iterable<@NonNull Region> parentRegions = getParentRegions(region);
			for (@NonNull Region callingRegion : parentRegions) {
				int callingDepth = getRegionDepth(callingRegion);
				if (callingDepth >= depth) {
					depth = callingDepth+1;
				}
			}
			region2depth.put(region, depth);
			QVTm2QVTs.REGION_DEPTH.println(getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this)) + " " + depth + " : " + region.getName());
		}
		return depth.intValue();
	}

	/**
	 * Return the edges deterministically ordered and in so far as
	 * possible respecting ordering edges between the target nodes.
	 */
	public @NonNull <@NonNull E extends Edge> Iterable<@NonNull E> getSortedEdges(@NonNull Iterable<@NonNull E> edges) {
		Map<@NonNull Node, @NonNull E> node2edge = new HashMap<>();
		//		Map<Node, Node> before2after = new HashMap<>();
		List<@NonNull Node> orderedNodes = new ArrayList<>();
		/*		for (E edge : edges) {
			Node target = edge.getTarget();
			Edge oldEdge = node2edge.put(target, edge);
			assert oldEdge == null;
			for (Edge orderingEdge : target.getOrderingEdges()) {
				before2after.put(orderingEdge.getSource(), orderingEdge.getTarget());
			}
		}
		while (orderedNodes.size() < node2edge.size()) {
			Set<Node> residualNodes = new HashSet<>(node2edge.keySet());
			residualNodes.removeAll(orderedNodes);
			residualNodes.removeAll(before2after.values());
			if (residualNodes.size() == 1) {
				Node residualNode = residualNodes.iterator().next();
				orderedNodes.add(residualNode);
				before2after.remove(residualNode);
			}
			else if (residualNodes.size() > 0) {
				List<Node> sortedResidualNodes = new ArrayList<>(residualNodes);
				Collections.sort(sortedResidualNodes, NameUtil.NameableComparator.INSTANCE);
				orderedNodes.addAll(sortedResidualNodes);
				for (Node residualNode : residualNodes) {
					before2after.remove(residualNode);
				}
			}
			else {
				// FIXME Choose least impact
				List<Node> sortedResidualNodes = new ArrayList<>(before2after.keySet());
				Collections.sort(sortedResidualNodes, NameUtil.NameableComparator.INSTANCE);
				Node arbitraryNode = sortedResidualNodes.get(0);
				orderedNodes.add(arbitraryNode);
				before2after.remove(arbitraryNode);
				System.out.println("Ordering loop broken by arbitrary choice of " + arbitraryNode);
			}
		} */
		List<@NonNull E> orderedEdges = new ArrayList<>();
		for (@NonNull Node orderedNode : orderedNodes) {
			@Nullable E edge = node2edge.get(orderedNode);
			assert edge != null;
			orderedEdges.add(edge);
		}
		assert orderedEdges.size() == node2edge.size();
		return orderedEdges;
	}

	/*
	 * Return true if secondRegion executes after firstNode is computed, if to-one navigable, or all node's if not to-one navigable.
	 *
	public boolean isAfter(@NonNull Node firstNode, @NonNull Region secondRegion) {
		Region firstRegion = firstNode.getRegion();
		Region commonRegion = getCommonRegion(firstRegion, secondRegion);
		if (commonRegion == null) {
			commonRegion = getCommonRegion(firstRegion, secondRegion);		// FIXME debugging
		}
		assert commonRegion != null;
		if (firstRegion == commonRegion) {
			return true;
		}
		int firstIndex = getChildIndexOf(commonRegion, firstRegion);
		if (firstIndex < 0) {
			firstIndex = getChildIndexOf(commonRegion, firstRegion);		// FIXME debugging
		}
		assert firstIndex >= 0;
		int secondIndex = getChildIndexOf(commonRegion, secondRegion);
		if (secondIndex < 0) {
			secondIndex = getChildIndexOf(commonRegion, secondRegion);		// FIXME debugging
		}
		assert secondIndex >= 0;
		return secondIndex >= firstIndex;		// =0 is same region so 'after' is same time.
	} */

	/*
	 * Return true if secondRegion executes after firstRegion is executed, if to-one navigable, or all region's if not to-ione navigable.
	 *
	public boolean isAfter(@NonNull Region firstRegion, @NonNull Region secondRegion) {
		Region commonRegion = getCommonRegion(firstRegion, secondRegion);
		assert commonRegion != null;
		int firstIndex = getChildIndexOf(commonRegion, firstRegion);
		assert firstIndex >= 0;
		int secondIndex = getChildIndexOf(commonRegion, secondRegion);
		assert secondIndex >= 0;
		return secondIndex >= firstIndex;		// =0 is same region so 'after' is same time.
	} */

	/**
	 * Return the nodes deterministically ordered and in so far as
	 * possible respecting ordering edges between the nodes.
	 *
	public @NonNull Iterable<Node> getSortedTargets(@NonNull Iterable<Node> nodes) {
		Map<Node, Node> before2after = new HashMap<>();
		List<Node> allNodes = new ArrayList<>();
		List<Node> orderedNodes = new ArrayList<>();
		for (Node target : nodes) {
			allNodes.add(target);
			for (Edge orderingEdge : target.getOrderingEdges()) {
				before2after.put(orderingEdge.getSource(), orderingEdge.getTarget());
			}
		}
		while (orderedNodes.size() < allNodes.size()) {
			Set<Node> residualNodes = new HashSet<>(allNodes);
			residualNodes.removeAll(orderedNodes);
			residualNodes.removeAll(before2after.values());
			if (residualNodes.size() == 1) {
				Node residualNode = residualNodes.iterator().next();
				orderedNodes.add(residualNode);
				before2after.remove(residualNode);
			}
			else if (residualNodes.size() > 0) {
				List<Node> sortedResidualNodes = new ArrayList<>(residualNodes);
				Collections.sort(sortedResidualNodes, NodeComparator.INSTANCE);
				orderedNodes.addAll(sortedResidualNodes);
				for (Node residualNode : residualNodes) {
					before2after.remove(residualNode);
				}
			}
			else {
				// FIXME Choose least impact
				List<Node> sortedResidualNodes = new ArrayList<>(before2after.keySet());
				Collections.sort(sortedResidualNodes, NodeComparator.INSTANCE);
				Node arbitraryNode = sortedResidualNodes.get(0);
				orderedNodes.add(arbitraryNode);
				before2after.remove(arbitraryNode);
				System.out.println("Ordering loop broken by arbitrary choice of " + arbitraryNode);
			}
		}
		return orderedNodes;
	} */


	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		for (Map.@NonNull Entry<@NonNull Region, @Nullable Integer> entry : region2depth.entrySet()) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(entry.getValue() + " : " + entry.getKey().getName());
		}
		return s.toString();
	}
}