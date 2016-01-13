/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Region2Depth provides facilities that use a temporary cache depth of the region passing binding tree.
 * A temporary cache is needed since merges invalidate depths.
 */
public class Region2Depth
{
/*	private final @NonNull Comparator<Region> depthComparator = new Comparator<Region>()			// Deepest first
	{
		@Override
		public int compare(Region o1, Region o2) {
			assert o1 != null;
			assert o2 != null;
			return getRegionDepth(o2) - getRegionDepth(o1);
		}
	}; */

	/**
	 * The lazily computed depth of each region; 0 at root, +1 for each region invocation.
	 */
	private @NonNull Map<Region, Integer> region2depth = new HashMap<Region, Integer>();

	/**
	 * The lazily computed parents (invokers) of each region.
	 */
	private @NonNull Map<Region, List<Region>> region2parents = new HashMap<Region, List<Region>>();

	/**
	 * The lazily computed children (invoked) of each region.
	 */
	private @NonNull Map<Region, List<Region>> region2children = new HashMap<Region, List<Region>>();

	/**
	 * The lazily computed parents closure (invokers) of each region.
	 */
	private @NonNull Map<Region, Set<Region>> region2ancestors = new HashMap<Region, Set<Region>>();

	/**
	 * The lazily computed depth of each edge; 0 within root, +1 for each composition/to-join/from-joint/binding.
	 * NB the edge depth may be up to three times the region depth.
	 */
//	private @NonNull Map<InterRegionEdge, Integer> edge2depth = new HashMap<InterRegionEdge, Integer>();

	/**
	 * Propagate the source and target of a used binding edge up to an ordering edge in their common region.
	 *
	public @NonNull Set<Edge> accumulateOrderingDependency(@NonNull Node sourceNode, @NonNull Node targetNode) {
		Set<Edge> orderingEdges = new HashSet<Edge>();
		Region targetRegion = targetNode.getRegion();
		Region sourceRegion = sourceNode.getRegion();
		Region commonRegion = getCommonRegion(sourceRegion, targetRegion);
		if (commonRegion != null) {
			Iterable<Node> sourceAncestors = commonRegion.getAncestorsOf(sourceNode);			// FIXME caches
			Iterable<Node> targetAncestors = commonRegion.getAncestorsOf(targetNode);
			for (@SuppressWarnings("null")@NonNull Node sourceAncestor : sourceAncestors) {
				for (/*@SuppressWarnings("null")@NonNull* / Node targetAncestor : targetAncestors) {
					assert targetAncestor != null;
					if (sourceAncestor != targetAncestor) {
						if (!targetAncestor.isRealized()) {
							Edge orderingEdge = null;
							for (Edge containerEdge : targetAncestor.getContainerEdges()) {
								if (containerEdge.getTarget() == sourceAncestor) {
									orderingEdge = containerEdge;
									break;
								}
							}
							if (orderingEdge == null) {
								orderingEdge = sourceAncestor.getComposedOrderingEdge(targetAncestor);
								if ((orderingEdge == null)) {
									orderingEdge = Edges.COMPOSED_ORDERING.createEdge(commonRegion, sourceAncestor, null, targetAncestor);
								}
								orderingEdges.add(orderingEdge);
							}
						}
					}
					else {
						int commonChildDepth = region2depths.getDepth(commonRegion)+1;
						Set<Node> allSourceAncestors = new HashSet<Node>();
						Set<Node> allTargetAncestors = new HashSet<Node>();
						sourceNode.getAllAncestors(allSourceAncestors);
						targetNode.getAllAncestors(allTargetAncestors);
						for (Node sourceSubAncestor : allSourceAncestors) {
							if (region2depths.getDepth(sourceSubAncestor.getRegion()) == commonChildDepth) {
								for (Node targetSubAncestor : allTargetAncestors) {
									if (region2depths.getDepth(targetSubAncestor.getRegion()) == commonChildDepth) {
										for (List<Node> sourceHeadGroup : sourceSubAncestor.getRegion().getHeadNodeGroups()) {
											for (Node sourceHead : sourceHeadGroup) {
												for (List<Node> targetHeadGroup : targetSubAncestor.getRegion().getHeadNodeGroups()) {
													for (@SuppressWarnings("null")@NonNull Node targetHead : targetHeadGroup) {
														if (targetHead != sourceHead) {
															Edge orderingEdge = sourceHead.getConsumedOrderingEdge(targetHead);
															if (orderingEdge == null) {
																orderingEdge = Edges.CONSUMED_ORDERING.createEdge(commonRegion, sourceHead, null, targetHead);
															}
															orderingEdges.add(orderingEdge);
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return orderingEdges;
	} */
	
	public void addRegion(@NonNull MergedRegion region) {
		region2children.clear();	// FIXME do intelligent update rather than recalculate
		region2depth.clear();
		region2parents.clear();
		Scheduler.REGION_DEPTH.println(getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this)) + " <reset> : " + region.getName());
	}

	public @NonNull Set<Region> getAncestorRegions(@NonNull Region childRegion) {
		Set<Region> ancestorRegions = region2ancestors.get(childRegion);
		if (ancestorRegions == null) {
			ancestorRegions = new HashSet<Region>();
			ancestorRegions.add(childRegion);
			for (@SuppressWarnings("null")@NonNull Region parentRegion : getParentRegions(childRegion)) {
				ancestorRegions.addAll(getAncestorRegions(parentRegion));
			}
			region2ancestors.put(childRegion, ancestorRegions);
		}
		return ancestorRegions;
	}

	/**
	 * Return the 1-based index of the childRegion within parentRegion.
	 * Returns -1 if childRegion is not a child of parentRegion.
	 * Returns 0 if childRegion is the parentRegion.
	 *
	public int getChildIndexOf(@NonNull Region parentRegion, @NonNull Region childRegion) {
		if (parentRegion == childRegion) {
			return 0;
		}
		Region thisRegion = parentRegion;
		Region thatRegion = childRegion;
		if (getRegionDepth(thisRegion) >= getRegionDepth(thatRegion)) {
			return -1;
		}
		Region thatChildRegion = childRegion;
		while (getRegionDepth(thatRegion) > getRegionDepth(thisRegion)) {
			thatChildRegion = thatRegion;
			thatRegion = getMinimumDepthParentRegion(thatRegion);
			if (thatRegion == null) {
				return -1;
			}
		}
		return 1 + getChildRegions(parentRegion).indexOf(thatChildRegion);
	} */

/*	public @NonNull List<Region> getChildRegions(@NonNull Region parentRegion) {
		List<Region> childRegions = region2children.get(parentRegion);
		if (childRegions == null) {
			childRegions = new ArrayList<Region>();
			for (InterRegionEdge childEdge1 : parentRegion.getChildPassedBindingEdges()) {
				Node childNode1 = childEdge1.getTarget();
				if (childNode1.isConnection()) {
					for (InterRegionEdge childEdge2 : childNode1.getOutgoingPassedBindingEdges()) {
						Node childNode2 = childEdge2.getTarget();
						Region childRegion = childNode2.getRegion();
						if (!childRegions.contains(childRegion)) {
							childRegions.add(childRegion);
						}
					}
				}
				else {
					Region childRegion = childNode1.getRegion();
					if (!childRegions.contains(childRegion)) {
						childRegions.add(childRegion);
					}
				}
			}
			Collections.sort(childRegions, new EarliestRegionComparator());
			region2children.put(parentRegion, childRegions);
		}
		return childRegions;
	} */
	
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
	 * Return the edge depth as determined by the InterRegionEdge call tree. 0 at root.
	 *
	public int getEdgeDepth(@NonNull InterRegionEdge edge) {
		Integer depth = edge2depth.get(edge);
		if (depth == null) {
			if (edge2depth.containsKey(edge)) {
				Scheduler.EDGE_DEPTH.println( + " <loop> : " + edge);
				return 0;
			}
			edge2depth.put(edge, null);
			depth = 0;
			Iterable<InterRegionEdge> parentEdges = getParentEdges(edge);
			for (@SuppressWarnings("null")@NonNull InterRegionEdge parentEdge : parentEdges) {
				int parentDepth = getEdgeDepth(parentEdge);
				if (parentDepth >= depth) {
					depth = parentDepth+1;
				}
			}
			edge2depth.put(edge, depth);
			Scheduler.EDGE_DEPTH.println( + " " + depth + " : " + edge);
		}
		return depth.intValue();
	} */
	
/*	public @Nullable Region getMaximumDepthParentRegion(@NonNull Region childRegion) {
		Region maximumDepthParentRegion = null;
		int maximumDepth = -1;
		int thisDepth = getRegionDepth(childRegion);
		for (@SuppressWarnings("null")@NonNull Region parentRegion : getParentRegions(childRegion)) {
			int parentDepth = getRegionDepth(parentRegion);
			if ((parentDepth <thisDepth) && ((maximumDepthParentRegion == null) || (parentDepth > maximumDepth))) {
				maximumDepthParentRegion = parentRegion;
				maximumDepth = parentDepth;
			}
		}
		return maximumDepthParentRegion;
	} */

	/**
	 * Return a/the parent region that is no deeper than any other parent region.
	 * Returns null at the root.
	 */
	public @Nullable Region getMinimumDepthParentRegion(@NonNull Region childRegion) {
		Region minimumDepthParentRegion = null;
		int minimumDepth = Integer.MAX_VALUE;
		for (@SuppressWarnings("null")@NonNull Region parentRegion : getParentRegions(childRegion)) {
			int parentDepth = getRegionDepth(parentRegion);
			if ((minimumDepthParentRegion == null) || (parentDepth < minimumDepth)) {
				minimumDepthParentRegion = parentRegion;
				minimumDepth = parentDepth;
			}
		}
		return minimumDepthParentRegion;
	}

	public @NonNull Iterable<Region> getParentRegions(@NonNull Region childRegion) {
		List<Region> parentRegions = region2parents.get(childRegion);
		if (parentRegions == null) {
			parentRegions = new ArrayList<Region>();
			for (Connection parentConnection : childRegion.getParentPassedConnections()) {
				for (Node source : parentConnection.getSources()) {
					Region parentRegion = source.getRegion();
					if (!parentRegions.contains(parentRegion)) {
						parentRegions.add(parentRegion);
					}
				}
			}
			region2parents.put(childRegion, parentRegions);
		}
		return parentRegions;
	}

	/**
	 * Return the region depth as determined by the PassedBinding call tree. 0 at root.
	 */
	public int getRegionDepth(@NonNull Region region) {
		Integer depth = region2depth.get(region);
		if (depth == null) {
			if (region2depth.containsKey(region)) {
				Scheduler.REGION_DEPTH.println(getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this)) + " <loop> : " + region.getName());
				return 0;
			}
			region2depth.put(region, null);
			depth = 0;
			Iterable<Region> parentRegions = getParentRegions(region);
			for (@SuppressWarnings("null")@NonNull Region callingRegion : parentRegions) {
				int callingDepth = getRegionDepth(callingRegion);
				if (callingDepth >= depth) {
					depth = callingDepth+1;
				}
			}
			region2depth.put(region, depth);
			Scheduler.REGION_DEPTH.println(getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(this)) + " " + depth + " : " + region.getName());
		}
		return depth.intValue();
	}
	
	/**
	 * Return the edges deterministically ordered and in so far as
	 * possible respecting ordering edges between the target nodes. 
	 */
	public @NonNull <E extends Edge> Iterable<E> getSortedEdges(@NonNull Iterable<E> edges) {
		Map<Node, E> node2edge = new HashMap<Node, E>();
//		Map<Node, Node> before2after = new HashMap<Node, Node>();
		List<Node> orderedNodes = new ArrayList<Node>();
/*		for (E edge : edges) {
			Node target = edge.getTarget();
			Edge oldEdge = node2edge.put(target, edge);
			assert oldEdge == null;
			for (Edge orderingEdge : target.getOrderingEdges()) {
				before2after.put(orderingEdge.getSource(), orderingEdge.getTarget());
			}
		}
		while (orderedNodes.size() < node2edge.size()) {
			Set<Node> residualNodes = new HashSet<Node>(node2edge.keySet());
			residualNodes.removeAll(orderedNodes);
			residualNodes.removeAll(before2after.values());
			if (residualNodes.size() == 1) {
				Node residualNode = residualNodes.iterator().next();
				orderedNodes.add(residualNode);
				before2after.remove(residualNode);
			}
			else if (residualNodes.size() > 0) {
				List<Node> sortedResidualNodes = new ArrayList<Node>(residualNodes);
				Collections.sort(sortedResidualNodes, NameUtil.NameableComparator.INSTANCE);
				orderedNodes.addAll(sortedResidualNodes);
				for (Node residualNode : residualNodes) {
					before2after.remove(residualNode);
				}
			}
			else {
				// FIXME Choose least impact
				List<Node> sortedResidualNodes = new ArrayList<Node>(before2after.keySet());
				Collections.sort(sortedResidualNodes, NameUtil.NameableComparator.INSTANCE);
				Node arbitraryNode = sortedResidualNodes.get(0);
				orderedNodes.add(arbitraryNode);
				before2after.remove(arbitraryNode);
				System.out.println("Ordering loop broken by arbitrary choice of " + arbitraryNode);
			}			
		} */
		List<E> orderedEdges = new ArrayList<E>();
		for (Node orderedNode : orderedNodes) {
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
		Map<Node, Node> before2after = new HashMap<Node, Node>();
		List<Node> allNodes = new ArrayList<Node>();
		List<Node> orderedNodes = new ArrayList<Node>();
		for (Node target : nodes) {
			allNodes.add(target);
			for (Edge orderingEdge : target.getOrderingEdges()) {
				before2after.put(orderingEdge.getSource(), orderingEdge.getTarget());
			}
		}
		while (orderedNodes.size() < allNodes.size()) {
			Set<Node> residualNodes = new HashSet<Node>(allNodes);
			residualNodes.removeAll(orderedNodes);
			residualNodes.removeAll(before2after.values());
			if (residualNodes.size() == 1) {
				Node residualNode = residualNodes.iterator().next();
				orderedNodes.add(residualNode);
				before2after.remove(residualNode);
			}
			else if (residualNodes.size() > 0) {
				List<Node> sortedResidualNodes = new ArrayList<Node>(residualNodes);
				Collections.sort(sortedResidualNodes, NodeComparator.INSTANCE);
				orderedNodes.addAll(sortedResidualNodes);
				for (Node residualNode : residualNodes) {
					before2after.remove(residualNode);
				}
			}
			else {
				// FIXME Choose least impact
				List<Node> sortedResidualNodes = new ArrayList<Node>(before2after.keySet());
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
	public String toString() {
		StringBuilder s = new StringBuilder();
		for (Map.Entry<Region,Integer> entry : region2depth.entrySet()) {
			if (s.length() > 0) {
				s.append("\n");
			}
			s.append(entry.getValue() + " : " + entry.getKey().getName());
		}
		return s.toString();
	}
}