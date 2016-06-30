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
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NavigationEdge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A HeadSplitter splits multi-headed regions whose heads are dependent into a cascade of looping regions, one per head around
 * a singly-headed core region. The split is performed recusively by introducing a Boundary between a Group of ssource head nodes
 * and target head nodes. The result is an ordered list of boundaries.
 */
public class HeadSplitter
{
	public static final @NonNull TracingOption ANALYSIS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/split/analysis");
	public static final @NonNull TracingOption OVERLAP = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/split/overlap");
	public static final @NonNull TracingOption RESULT = new TracingOption(CompilerConstants.PLUGIN_ID, "qvtp2qvts/split/result");

	public static boolean containsNone(@NonNull Iterable<@NonNull Node> firstNodes, @NonNull Iterable<@NonNull Node> secondNodes) {
		for (@NonNull Node firstNode : firstNodes) {
			for (@NonNull Node secondNode : secondNodes) {
				if (firstNode == secondNode) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * A Boundary describes an edge between the reachable nodes of two head groups.
	 */
	public static class Boundary implements Nameable
	{
		protected final @NonNull Group sourceGroup;
		protected final @NonNull Edge edge;
		protected final @NonNull Group targetGroup;
		protected final @NonNull String name;

		public Boundary(@NonNull Group sourceGroup, @NonNull Edge edge, @NonNull Group targetGroup) {
			this.sourceGroup = sourceGroup;
			this.edge = edge;
			this.targetGroup = targetGroup;
			this.name = sourceGroup.getName() + "==>" + edge.getName() + "==>" + targetGroup.getName();
		}

		public @NonNull Edge getEdge() {
			return edge;
		}

		@Override
		public @NonNull String getName() {
			return name;
		}

		public @NonNull Group getSourceGroup() {
			return sourceGroup;
		}

		public @NonNull Group getTargetGroup() {
			return targetGroup;
		}

		public boolean isReverseNavigable() {
			if (!(edge instanceof NavigationEdge)) {
				return false;
			}
			Property forwardProperty = ((NavigationEdge)edge).getProperty();
			Property reverseProperty = forwardProperty.getOpposite();
			if (reverseProperty == null) {
				return false;
			}
			return !reverseProperty.isIsImplicit();
		}

		@Override
		public @NonNull String toString() {
			return name;
		}
	}

	/**
	 * BestBoundaryComparator supports comparison of boundaries so that more easily realizeable cross-boundary iterations are sorted first.
	 */
	public static final class BestBoundaryComparator implements Comparator<@NonNull Boundary>
	{
		public static final @NonNull BestBoundaryComparator INSTANCE = new BestBoundaryComparator();

		@Override
		public int compare(@NonNull Boundary o1, @NonNull Boundary o2) {
			// boolean: true better than false
			boolean b1 = o1.isReverseNavigable();
			boolean b2 = o2.isReverseNavigable();
			if (b1 != b2) {
				return b1 ? -1 : 1;
			}
			Edge e1 = o1.getEdge();
			Edge e2 = o2.getEdge();
			b1 = e1.isConstant();
			b2 = e2.isConstant();
			if (b1 != b2) {
				return b1 ? -1 : 1;
			}
			b1 = e1.isLoaded();
			b2 = e2.isLoaded();
			if (b1 != b2) {
				return b1 ? -1 : 1;
			}
			b1 = e1.isPredicated();
			b2 = e2.isPredicated();
			if (b1 != b2) {
				return b1 ? -1 : 1;
			}
			return ClassUtil.safeCompareTo(o1.getName(), o2.getName());
		}
	}

	/**
	 * A head Group describes one or more head nodes whose reachable nodes are treated as a single sub-region for the purposes of
	 * establishing a Boundary between two or more Groups by a SplitAttempt.
	 */
	public static class Group implements Nameable
	{
		/**
		 * The head nodes grouped into a composite sub-region.
		 */
		protected final @NonNull Iterable<@NonNull Node> headNodes;

		/**
		 * The name of the group.
		 */
		protected final @NonNull String name;

		/**
		 * All the nodes reachable from one of the head nodes by to-one navigation.
		 */
		private final @NonNull Set<@NonNull Node> reachableNodes = new HashSet<>();

		public Group(@NonNull Iterable<@NonNull Node> headNodes) {
			this.headNodes = headNodes;
			for (@NonNull Node headNode : headNodes) {
				computeReachableNodes(headNode);
			}
			StringBuilder s = new StringBuilder();
			List<@NonNull Node> sortedHeadNodes = Lists.newArrayList(headNodes);
			Collections.sort(sortedHeadNodes, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull Node headNode : sortedHeadNodes) {
				if (s.length() <= 0) {
					s.append("\"");
				}
				else {
					s.append("+");
				}
				s.append(headNode.getName());
			}
			s.append("\"");
			this.name = s.toString();
		}

		private void computeReachableNodes(@NonNull Node sourceNode) {
			if (reachableNodes.add(sourceNode)) {
				for (@NonNull NavigationEdge edge : sourceNode.getNavigationEdges()) {
					assert edge.getSource() == sourceNode;
					if (!edge.isRealized() && edge.isNavigable()) {
						Node targetNode = edge.getTarget();
						computeReachableNodes(targetNode);
					}
				}
			}
		}

		public @NonNull Iterable<@NonNull Node> getHeadNodes() {
			return headNodes;
		}

		@Override
		public @NonNull String getName() {
			return name;
		}

		public @NonNull Iterable<@NonNull Node> getReachableNodes() {
			return reachableNodes;
		}

		@Override
		public @NonNull String toString() {
			return name;
		}
	}

	/**
	 * A SplitAttempt supervises the identification and merge of two overlapping sub-regions to form a smaller problem for the next SplitAttempt.
	 */
	protected static class SplitAttempt
	{
		/**
		 * An Overlap supports analysis of the intersection of nodes reachable from two or more head groups.
		 * The intersection may be empty when a computation rather than a navigation crosses the boundary
		 * between reachable node sub-regions.
		 */
		protected class Overlap
		{
			/**
			 * The nodes in the overlap.
			 */
			protected final @NonNull Set<@NonNull Node> overlapNodes;

			/**
			 * The heads groups for which all the overlapNodes are reachable.
			 */
			protected final @NonNull Set<@NonNull Group> headGroups = new HashSet<>();

			/**
			 * The per-target head edges that provide a path via the overlap from another head to the head.
			 */
			private final @NonNull Map<@NonNull Group, @NonNull Map<@NonNull Group, @NonNull List<@NonNull Boundary>>> sourceGroup2targetGroup2boundaries = new HashMap<>();

			public Overlap(@NonNull Set<@NonNull Node> overlapNodes) {
				this.overlapNodes = overlapNodes;
			}

			public void add(@NonNull Group headGroup) {
				boolean wasAdded = headGroups.add(headGroup);
				assert wasAdded;
			}

			private void addBoundary(@NonNull Group sourceGroup, @NonNull Edge edge, @NonNull Group targetGroup) {
				Boundary boundary = new Boundary(sourceGroup, edge, targetGroup);
				Map<@NonNull Group, @NonNull List<@NonNull Boundary>> targetGroup2boundaries = sourceGroup2targetGroup2boundaries.get(sourceGroup);
				if (targetGroup2boundaries == null) {
					targetGroup2boundaries = new HashMap<>();
					sourceGroup2targetGroup2boundaries.put(sourceGroup, targetGroup2boundaries);
				}
				List<@NonNull Boundary> boundaries = targetGroup2boundaries.get(targetGroup);
				if (boundaries == null) {
					boundaries = new ArrayList<>();
					targetGroup2boundaries.put(targetGroup, boundaries);
				}
				boolean wasAdded = boundaries.add(boundary);
				assert wasAdded;
			}

			public void analyze() {
				if (headGroups.size() > 1) {
					for (@NonNull Group headGroup : headGroups) {
						analyze(headGroup);
					}
				}
			}

			private void analyze(@NonNull Group thisHeadGroup) {
				Set<@NonNull Node> theseNonOverlapNodes = Sets.newHashSet(thisHeadGroup.getReachableNodes());
				theseNonOverlapNodes.removeAll(overlapNodes);
				for (@NonNull Node thisNonOverlapNode : theseNonOverlapNodes) {
					for (@NonNull NavigationEdge edge : thisNonOverlapNode.getNavigationEdges()) {
						assert edge.getSource() == thisNonOverlapNode;
						if (!edge.isRealized() && edge.isNavigable()) {
							Property property = edge.getProperty();
							Property opposite = property.getOpposite();
							if ((opposite != null) && opposite.isIsMany()) {
								Node targetNode = edge.getTarget();
								if (!theseNonOverlapNodes.contains(targetNode)) {
									List<@NonNull Group> targetGroups = reachable2groups.get(targetNode);
									assert targetGroups != null;
									for (@NonNull Group targetGroup : targetGroups) {
										if ((targetGroup != thisHeadGroup) && headGroups.contains(targetGroup)) {
											addBoundary(thisHeadGroup, edge, targetGroup);
										}
									}
								}
							}
						}
					}
					for (@NonNull Edge edge : thisNonOverlapNode.getIncomingEdges()) {
						assert edge.getTarget() == thisNonOverlapNode;
						if (!edge.isRealized() && edge.isComputation()) {
							for (@NonNull Group sourceGroup : getSourceGroups(edge)) {
								if ((sourceGroup != thisHeadGroup) && headGroups.contains(sourceGroup)) {
									addBoundary(sourceGroup, edge, thisHeadGroup);
								}
							}
						}
					}
				}
			}

			public void debug(@NonNull StringBuilder s) {
				s.append("\n    overlap: ");
				s.append(toString());
				for (@NonNull Node node : overlapNodes) {
					s.append("\n        shared " + node);
				}
				for (@NonNull Group sourceGroup : sourceGroup2targetGroup2boundaries.keySet()) {
					Map<@NonNull Group, List<@NonNull Boundary>> targetGroup2boundaries = sourceGroup2targetGroup2boundaries.get(sourceGroup);
					assert targetGroup2boundaries != null;
					for (@NonNull Group targetGroup : targetGroup2boundaries.keySet()) {
						s.append("\n      from " + sourceGroup.getName() + " to " + targetGroup.getName());
						List<@NonNull Boundary> boundaries = targetGroup2boundaries.get(targetGroup);
						assert boundaries != null;
						for (@NonNull Boundary boundary : boundaries) {
							s.append("\n        edge: " + boundary.getEdge());
						}
					}
				}
			}

			public @NonNull Set<@NonNull Boundary> getRemoveableBoundaries() {
				//
				//	Compute the head nodes that can be derived by navigation from other heads.
				//	Compute the deriveable head nodes that do not depend on other deriveable heads.
				//
				List<@NonNull Boundary> removableHeadBoundaries = new ArrayList<>();
				for (@NonNull Map<@NonNull Group, @NonNull List<@NonNull Boundary>> targetGroup2boundaries : sourceGroup2targetGroup2boundaries.values()) {
					for (@NonNull List<@NonNull Boundary> boundaries : targetGroup2boundaries.values()) {
						removableHeadBoundaries.addAll(boundaries);
					}
				}
				Collections.sort(removableHeadBoundaries, BestBoundaryComparator.INSTANCE);
				// FIXME can we remove multiple boundaries if suitably orthogonal ?
				return removableHeadBoundaries.size() > 0 ? Collections.singleton(removableHeadBoundaries.get(0)) :  Collections.emptySet();
			}

			@Override
			public @NonNull String toString() {
				StringBuilder s = new StringBuilder();
				List<@NonNull Group> sortedGroups = new ArrayList<>(headGroups);
				Collections.sort(sortedGroups, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull Group group : sortedGroups) {
					if (s.length() > 0) {
						s.append(",");
					}
					s.append(group.getName());
				}
				return s.toString();
			}
		}

		/**
		 * The region to be split.
		 */
		protected final @NonNull Region region;

		/**
		 * The sub-regions to be coalesced.
		 */
		protected final @NonNull Iterable<@NonNull Group> groups;

		/**
		 * Map from each reachable node to all the head nodes from which it is reachable by to-one navigation.
		 */
		private final @NonNull Map<@NonNull Node, List<@NonNull Group>> reachable2groups = new HashMap<>();

		private final @NonNull Map<@NonNull Set<@NonNull Node>, @NonNull Overlap> overlapNodes2overlap = new HashMap<>();

		public SplitAttempt(@NonNull Region region, @NonNull Iterable<@NonNull Group> groups) {
			this.region = region;
			this.groups = groups;
			for (@NonNull Group group : groups) {
				for (@NonNull Node reachableNode : group.getReachableNodes()) {
					List<@NonNull Group> reachableGroups = reachable2groups.get(reachableNode);
					if (reachableGroups == null) {
						reachableGroups = new ArrayList<>();
						reachable2groups.put(reachableNode, reachableGroups);
					}
					assert !reachableGroups.contains(group);
					reachableGroups.add(group);
				}
			}
		}

		private void computeSourceNodes(@NonNull Edge computationEdge, @NonNull Set<@NonNull Node> sourceNodes) {
			Node sourceNode = computationEdge.getSource();
			if (sourceNodes.add(sourceNode)) {
				for (@NonNull Edge edge : sourceNode.getIncomingEdges()) {
					assert edge.getTarget() == sourceNode;
					if (!edge.isRealized() && edge.isComputation()) {
						computeSourceNodes(edge, sourceNodes);
					}
				}
			}
		}

		private void createOverlap(@NonNull Group thisGroup) {
			//
			//	Compute the nodes that are reachable from all other groups.
			//
			Set<@NonNull Node> allThoseNodes = new HashSet<>();
			for (@NonNull Group thatGroup : groups) {
				if (thatGroup != thisGroup) {
					Iterables.addAll(allThoseNodes, thatGroup.getReachableNodes());
				}
			}
			//
			//	Compute the overlap nodes that are reachable from this head node and another head node.
			//
			Iterable<@NonNull Node> theseNodes = thisGroup.getReachableNodes();
			Set<@NonNull Node> overlapNodes = Sets.newHashSet(theseNodes);
			overlapNodes.retainAll(allThoseNodes);
			//
			//	Create or extend the overlap for the overlap nodes.
			//
			Overlap overlap = overlapNodes2overlap.get(overlapNodes);
			if (overlap == null) {
				overlap = new Overlap(overlapNodes);
				overlapNodes2overlap.put(overlapNodes, overlap);
			}
			overlap.add(thisGroup);
		}

		private @NonNull Iterable<@NonNull Group> getSourceGroups(@NonNull Edge edge) {
			Set<@NonNull Group> sourceGroups = new HashSet<>();
			Set<@NonNull Node> sourceNodes = new HashSet<>();
			computeSourceNodes(edge, sourceNodes);
			for (@NonNull Node sourceNode : sourceNodes) {
				List<@NonNull Group> reachableSourceGroups = reachable2groups.get(sourceNode);
				if (reachableSourceGroups != null) {
					sourceGroups.addAll(reachableSourceGroups);
				}
			}
			return sourceGroups;
		}

		/* private void pruneOverlaps() {
			//
			//	Hypothesis: larger overlaps are sums of smaller overlaps, so smaller are the interesting ones.
			//
			List<@NonNull Set<@NonNull Node>> intersections = new ArrayList<>(overlapNodes2overlap.keySet());
			int iMax = intersections.size();
			for (int i1 = 0; i1 < iMax; i1++) {
				Set<@NonNull Node> intersection1 = intersections.get(i1);
				Overlap overlap1 = overlapNodes2overlap.get(intersection1);
				assert overlap1 != null;
				for (int i2 = 0; i2 < iMax; i2++) {
					if (i1 != i2) {
						Set<@NonNull Node> intersection2 = intersections.get(i2);
						if (/*(intersection2.size() > 0) &&* / intersection1.containsAll(intersection2)) {
							overlapNodes2overlap.remove(intersection1);
							Overlap overlap2 = overlapNodes2overlap.get(intersection2);
							assert overlap2 != null;
							for (@NonNull Node headNode : overlap1.headNodes) {
								overlap2.add(headNode);
							}
						}
					}
				}
			}
		} */

		private @NonNull Set<@NonNull Boundary> removeOverlap() {
			Set<@NonNull Boundary> removeableBoundaries = new HashSet<>();
			for (@NonNull Overlap overlap : overlapNodes2overlap.values()) {
				//				for (Map.Entry<@NonNull Node, @NonNull List<@NonNull Edge>> entry : overlap.getRemoveableHeads().entrySet()) {
				for (@NonNull Boundary boundary : overlap.getRemoveableBoundaries()) {
					removeableBoundaries.add(boundary);
				}
			}
			if (OVERLAP.isActive()) {
				StringBuilder s = new StringBuilder();
				for (@NonNull Boundary boundary : removeableBoundaries) {
					s.append("\n    resolveable: " + boundary);
				}
				OVERLAP.println(region + s.toString());
			}
			return removeableBoundaries;
		}

		public @NonNull Set<@NonNull Boundary> split() {
			//
			//	Create the overlap (intersection) between each head node's reachable region
			//	and the other head node's reachable regions.
			//
			for (@NonNull Group group : groups) {
				createOverlap(group);
			}
			//		pruneOverlaps();
			//
			//	Analyze each overlap to identify the boundaries that bridge the overlap.
			//
			for (@NonNull Overlap overlap : overlapNodes2overlap.values()) {
				overlap.analyze();
			}
			//
			//	Print out the analysis
			//
			if (ANALYSIS.isActive()) {
				StringBuilder s = new StringBuilder();
				for (@NonNull Overlap overlap : overlapNodes2overlap.values()) {
					overlap.debug(s);
				}
				ANALYSIS.println(region + s.toString());
			}
			return removeOverlap();
		}

	}

	/**
	 * The region to be split.
	 */
	protected final @NonNull Region region;

	/**
	 * The root groups, one per head node.
	 */
	//	protected final @NonNull List<@NonNull Group> rootGroups = new ArrayList<>();

	public HeadSplitter(@NonNull Region region) {
		this.region = region;
	}

	/**
	 * Return an ordered list of boundaries at which the region can be successively split by performing an iteration from the boundary source
	 * using the boundary edge over the boundary target. Returns null if no split possible or needed.
	 */
	public @Nullable List<@NonNull Boundary> split() {
		List<@NonNull Node> headNodes = region.getHeadNodes();
		if (headNodes.size() <= 1) {
			return null;
		}
		List<@NonNull Group> groups = new ArrayList<>(headNodes.size());
		for (@NonNull Node headNode : headNodes) {
			groups.add(new Group(Collections.singletonList(headNode)));
		}
		List<@NonNull Boundary> allRemoveableBoundaries = new ArrayList<>();
		while (groups.size() > 1) {
			SplitAttempt splitAttempt = new SplitAttempt(region, groups);
			Set<@NonNull Boundary> removeableBoundaries = splitAttempt.split();
			if (removeableBoundaries.size() <= 0) {
				break;
			}
			for (@NonNull Boundary boundary : removeableBoundaries) {
				allRemoveableBoundaries.add(0, boundary);
				Group sourceGroup = boundary.getSourceGroup();
				Group targetGroup = boundary.getTargetGroup();
				boolean wasRemoved = groups.remove(sourceGroup) && groups.remove(targetGroup);
				assert wasRemoved;
				List<@NonNull Node> mergedHeadNodes = Lists.newArrayList(sourceGroup.getHeadNodes());
				Iterables.addAll(mergedHeadNodes, targetGroup.getHeadNodes());
				groups.add(new Group(mergedHeadNodes));
			}
		}
		if (RESULT.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull Boundary boundary : allRemoveableBoundaries) {
				s.append("\n    split: " + boundary);
			}
			RESULT.println(region + s.toString());
		}
		return allRemoveableBoundaries;
	}

	@Override
	public @NonNull String toString() {
		return region.getName();
	}
}
