/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A CompoundGroup comprises two or more Groups that share one or more to-N navigation relationships enabling
 * a free choice as to which group is scheduled first.
 */
class CompoundGroup extends AbstractGroup
{
	/**
	 * The alphabetically ordered mutually navigable simple groups.
	 */
	protected final @NonNull List<@NonNull SimpleGroup> internalSimpleGroups;

	/**
	 * The alphabetically ordered head nodes grouped into a composite sub-region.
	 */
	protected final @NonNull List<@NonNull Node> headNodes;

	/**
	 * The per-target head edges that provide a path via the overlap from another head to the head.
	 */
	private final @NonNull Map<@NonNull SimpleGroup, @NonNull Map<@NonNull SimpleGroup, @NonNull List<@NonNull Boundary>>> sourceGroup2targetGroup2boundaries = new HashMap<>();

	/**
	 * The schedule in which boundaries are exploited.
	 */
	private final @NonNull List<@NonNull Boundary> orderedBoundaries = new ArrayList<>();

	public CompoundGroup(@NonNull SplitterAnalysis splitter, @NonNull Iterable<@NonNull SimpleGroup> simpleGroups) {
		super(splitter, SplitterUtil.computeHeadNodes(simpleGroups));
		this.internalSimpleGroups = Lists.newArrayList(simpleGroups);
		this.headNodes = SplitterUtil.computeHeadNodes(simpleGroups);
		assert internalSimpleGroups.size() > 1;
		Collections.sort(this.internalSimpleGroups, NameUtil.NAMEABLE_COMPARATOR);		// Improve determinacy
	}

	private void addBoundary(@NonNull SimpleGroup sourceGroup, @NonNull Edge edge, @NonNull  SimpleGroup targetGroup) {
		Boundary boundary = new Boundary(sourceGroup, edge, targetGroup);
		Map<@NonNull  SimpleGroup, @NonNull List<@NonNull Boundary>> targetGroup2boundaries = sourceGroup2targetGroup2boundaries.get(sourceGroup);
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

	@Override
	public void buildSplit(@NonNull Split split, @Nullable SimpleGroup sourceSimpleGroup, @Nullable Edge edge) {
		SimpleGroup entryGroup = getEntryGroup();
		split.addStage(sourceSimpleGroup, edge, entryGroup);
		for (@NonNull Boundary boundary : orderedBoundaries) {
			split.addStage(boundary.getSourceGroup(), boundary.getEdge(), boundary.getTargetGroup());
		}
		buildSplit(split, entryGroup);
	}

	/**
	 * Create a Boundary for each edge whose source end is also in externalSimpleGroups and whose target end is only in internalSimpleGroups.
	 */
	protected @NonNull Iterable<@NonNull SimpleGroup> computeExternalBoundaries(@NonNull Iterable<@NonNull SimpleGroup> externalSimpleGroups) {
		Set<@NonNull Node> externalReachableNodes = SplitterUtil.computeNavigableNodes(SplitterUtil.computeHeadNodes(externalSimpleGroups));
		Set<@NonNull Node> externalComputableNodes = SplitterUtil.computeComputableTargetNodes(externalReachableNodes);
		List<@NonNull SimpleGroup> externalInternalSimpleGroups = new ArrayList<>();
		for (@NonNull SimpleGroup internalSimpleGroup : internalSimpleGroups) {
			Iterable<@NonNull Node> internalReachableNodes = internalSimpleGroup.getReachableNodes();
			Set<@NonNull Node> overlapNodes = Sets.newHashSet(internalReachableNodes);
			overlapNodes.retainAll(externalComputableNodes);
			if (!overlapNodes.isEmpty()) {
				externalInternalSimpleGroups.add(internalSimpleGroup);
				//				Set<@NonNull Node> internalNonOverlapNodes = Sets.newHashSet(internalReachableNodes);
				//				internalNonOverlapNodes.removeAll(overlapNodes);
				//				createBoundaries(internalSimpleGroup, internalNonOverlapNodes);
			}
		}
		return externalInternalSimpleGroups;
	}

	/**
	 * Create a Boundary for each edge whose ends are in distinct internalSimpleGroups.
	 */
	protected void computeInternalBoundaries() {
		int iMax = internalSimpleGroups.size();
		for (int iThis = 0; iThis < iMax; iThis++) {
			SimpleGroup thisGroup = internalSimpleGroups.get(iThis);
			Set<@NonNull Node> theseReachableNodes = Sets.newHashSet(thisGroup.getReachableNodes());
			for (int iThat = iThis+1; iThat < iMax; iThat++) {
				SimpleGroup thatGroup = internalSimpleGroups.get(iThat);
				Iterable<@NonNull Node> thoseReachableNodes = thatGroup.getReachableNodes();
				Set<@NonNull Node> overlapNodes = Sets.newHashSet(thoseReachableNodes);
				overlapNodes.retainAll(theseReachableNodes);
				if (!overlapNodes.isEmpty()) {
					Set<@NonNull Node> theseNonOverlapNodes = Sets.newHashSet(theseReachableNodes);
					Set<@NonNull Node> thoseNonOverlapNodes = Sets.newHashSet(thoseReachableNodes);
					theseNonOverlapNodes.removeAll(overlapNodes);
					thoseNonOverlapNodes.removeAll(overlapNodes);
					createBoundaries(thisGroup, thoseNonOverlapNodes);
					createBoundaries(thatGroup, theseNonOverlapNodes);
				}
			}
		}
	}

	@Override
	public void computeMutualOrdering(@NonNull Iterable<@NonNull SimpleGroup> externalSimpleGroups) {
		//
		//	Determine the boundaries between the navigable simple groups.
		//
		//		List<@NonNull SimpleGroup> schedulableSimpleGroups = Lists.newArrayList(externalSimpleGroups);
		//		schedulableSimpleGroups.addAll(internalSimpleGroups);
		computeInternalBoundaries();
		//
		//	Grow the scheduled simple groups one boundary at a time.
		//
		List<@NonNull SimpleGroup> scheduledSimpleGroups = new ArrayList<>(); // Lists.newArrayList(externalSimpleGroups);
		if (!Iterables.isEmpty(externalSimpleGroups)) {
			for (@NonNull SimpleGroup externalInternalSimpleGroup : computeExternalBoundaries(externalSimpleGroups)) {
				scheduledSimpleGroups.add(externalInternalSimpleGroup);
			}
		}
		Collections.sort(scheduledSimpleGroups, NameUtil.NAMEABLE_COMPARATOR);		// Improve determinacy
		List<@NonNull SimpleGroup> unscheduledSimpleGroups = Lists.newArrayList(internalSimpleGroups);
		unscheduledSimpleGroups.removeAll(scheduledSimpleGroups);
		while (unscheduledSimpleGroups.size() > 0) {
			//
			//	Identify all boundaries applicable to the currently scheduledSimpleGroups.
			//
			Set<@NonNull Boundary> activeBoundaries = selectActiveBoundariesHeuristic(scheduledSimpleGroups, unscheduledSimpleGroups);
			//
			//	Identify the best boundary applicable to the currently scheduledSimpleGroups.
			//
			Boundary bestBoundary = selectBestBoundaryHeuristic(activeBoundaries, scheduledSimpleGroups);
			//
			//	Schedule the best boundary.
			//
			SimpleGroup sourceGroup = bestBoundary.getSourceGroup();
			SimpleGroup targetGroup = bestBoundary.getTargetGroup();
			assert scheduledSimpleGroups.isEmpty() || scheduledSimpleGroups.contains(sourceGroup);
			assert scheduledSimpleGroups.isEmpty() || !unscheduledSimpleGroups.contains(sourceGroup);
			assert !scheduledSimpleGroups.contains(targetGroup);
			assert unscheduledSimpleGroups.contains(targetGroup);
			assert !orderedBoundaries.contains(bestBoundary);
			orderedBoundaries.add(bestBoundary);
			if (unscheduledSimpleGroups.remove(sourceGroup)) {
				scheduledSimpleGroups.add(sourceGroup);
			}
			unscheduledSimpleGroups.remove(targetGroup);
			scheduledSimpleGroups.add(targetGroup);
		}
	}

	/**
	 * Create a Boundary for each edge from one of the non-overlapping nodes in sourceGroup to another group.
	 */
	protected void createBoundaries(@NonNull SimpleGroup sourceGroup, @NonNull Iterable<@NonNull Node> nonOverlapNodes) {
		for (@NonNull Node nonOverlapNode : nonOverlapNodes) {
			for (@NonNull NavigableEdge edge : nonOverlapNode.getNavigationEdges()) {
				assert edge.getEdgeSource() == nonOverlapNode;
				if (!edge.isRealized() && edge.isMatched()) {
					Property property = edge.getProperty();
					Property opposite = property.getOpposite();
					if ((opposite != null) && opposite.isIsMany()) {
						Node targetNode = edge.getEdgeTarget();
						if (!Iterables.contains(nonOverlapNodes, targetNode)) {
							Iterable<@NonNull SimpleGroup> targetGroups = splitter.getReachableSimpleGroups(targetNode);
							assert targetGroups != null;
							for (@NonNull SimpleGroup targetGroup : targetGroups) {
								if ((targetGroup != sourceGroup) && internalSimpleGroups.contains(targetGroup)) {
									addBoundary(sourceGroup, edge, targetGroup);
								}
							}
						}
					}
				}
			}
		}
	}

	/*	public void debug(@NonNull StringBuilder s) {
		s.append("\n    overlap: ");
		s.append(toString());
		for (@NonNull Node node : overlapNodes) {
			s.append("\n        shared " + node);
		}
		for (@NonNull Group sourceGroup : sourceGroup2targetGroup2boundaries.keySet()) {
			Map<@NonNull  SimpleGroup, List<@NonNull Boundary>> targetGroup2boundaries = sourceGroup2targetGroup2boundaries.get(sourceGroup);
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
	} */

	public @NonNull SimpleGroup getEntryGroup() {
		assert !orderedBoundaries.isEmpty();
		return orderedBoundaries.get(0).getSourceGroup();
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getHeadNodes() {
		return headNodes;
	}

	@Override
	public @NonNull Iterable<@NonNull SimpleGroup> getInternalSimpleGroups() {
		return internalSimpleGroups;
	}

	/**
	 * Return the boundaries appropriate one or more of unscheduledSimpleGroups once scheduledSimpleGroups are already scheduled.
	 */
	private @NonNull Set<@NonNull Boundary> selectActiveBoundariesHeuristic(@NonNull Iterable<@NonNull SimpleGroup> scheduledSimpleGroups,
			@NonNull Iterable<@NonNull SimpleGroup> unscheduledSimpleGroups) {
		assert !sourceGroup2targetGroup2boundaries.isEmpty();
		Set<@NonNull Boundary> activeBoundaries = new HashSet<@NonNull Boundary>();
		//
		//	First choice: boundaries from scheduledSimpleGroups to unscheduledSimpleGroups.
		//
		for (@NonNull SimpleGroup scheduledSimpleGroup : scheduledSimpleGroups) {
			Map<@NonNull SimpleGroup, @NonNull List<@NonNull Boundary>> targetGroup2boundaries = sourceGroup2targetGroup2boundaries.get(scheduledSimpleGroup);
			if (targetGroup2boundaries != null) {
				for (@NonNull SimpleGroup targetGroup : targetGroup2boundaries.keySet()) {
					if (Iterables.contains(unscheduledSimpleGroups, targetGroup)) {
						List<@NonNull Boundary> boundaries = targetGroup2boundaries.get(targetGroup);
						assert boundaries != null;
						activeBoundaries.addAll(boundaries);
					}
				}
			}
		}
		//
		//	Second choice: unscheduledSimpleGroups whose head is LOADED.
		//
		if (activeBoundaries.isEmpty()) {
			for (@NonNull SimpleGroup sourceGroup : sourceGroup2targetGroup2boundaries.keySet()) {
				Node headNode = sourceGroup.getHeadNode();
				if (headNode.isLoaded()) {
					Map<@NonNull SimpleGroup, @NonNull List<@NonNull Boundary>> targetGroup2boundaries = sourceGroup2targetGroup2boundaries.get(sourceGroup);
					assert targetGroup2boundaries != null;
					for (@NonNull List<@NonNull Boundary> boundaries : targetGroup2boundaries.values()) {
						activeBoundaries.addAll(boundaries);
					}
				}
			}
		}
		//
		//	Last choice: the alphabetically first boundary.
		//
		if (activeBoundaries.isEmpty()) {
			Set<@NonNull Boundary> allBoundariesSet = new HashSet<>();
			for (@NonNull Map<@NonNull SimpleGroup, @NonNull List<@NonNull Boundary>> targetGroup2boundaries : sourceGroup2targetGroup2boundaries.values()) {
				for (@NonNull List<@NonNull Boundary> boundaries : targetGroup2boundaries.values()) {
					allBoundariesSet.addAll(boundaries);
				}
			}
			List<@NonNull Boundary> allBoundariesList = new ArrayList<>(allBoundariesSet);
			Collections.sort(allBoundariesList, NameUtil.NAMEABLE_COMPARATOR);		// Improve determinacy
			activeBoundaries.add(allBoundariesList.get(0));
		}
		return activeBoundaries;
	}

	/**
	 * Return the boundaries appropriate one or more of unscheduledSimpleGroups once scheduledSimpleGroups are already scheduled.
	 */
	private @NonNull Boundary selectBestBoundaryHeuristic(@NonNull Set<@NonNull Boundary> activeBoundaries, @NonNull Iterable<@NonNull SimpleGroup> scheduledSimpleGroups/*,
			@NonNull Iterable<@NonNull SimpleGroup> unscheduledSimpleGroups*/) {
		assert !activeBoundaries.isEmpty();
		List<@NonNull Boundary> goodBoundaries = new ArrayList<@NonNull Boundary>();
		//
		//	First choice: LOADED edges
		//
		for (@NonNull Boundary boundary : activeBoundaries) {
			Edge edge = boundary.getEdge();
			if (edge.isConstant() || edge.isLoaded()) {
				goodBoundaries.add(boundary);
			}
		}
		//
		//	Second choice: boundaries to simple groups with greatest connectivity / minimum transitive distance.
		//
		if (goodBoundaries.isEmpty()) {
			//	TODO use BestBoundaryComparator
		}
		//
		//	Last choice: alphabetically first boundary
		//
		if (goodBoundaries.isEmpty()) {
			goodBoundaries.addAll(activeBoundaries);
		}
		Collections.sort(goodBoundaries, NameUtil.NAMEABLE_COMPARATOR);		// Improve determinacy
		return goodBoundaries.get(0);
	}

	@Override
	public void toString(@NonNull StringBuilder s, int depth) {
		CompilerUtil.indent(s, depth);
		s.append("compound-group: ");
		s.append(name);
		if (orderedBoundaries.isEmpty()) {
			List<@NonNull SimpleGroup> sortedSimpleGroups = Lists.newArrayList(internalSimpleGroups);
			Collections.sort(sortedSimpleGroups, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull SimpleGroup simpleGroup : sortedSimpleGroups) {
				s.append("\n");
				simpleGroup.toString(s, depth+1);
			}
		}
		else {
			for (@NonNull Boundary boundary : orderedBoundaries) {
				s.append("\n");
				CompilerUtil.indent(s, depth+1);
				s.append("boundary: ");
				s.append(boundary.getName());
				s.append("\n");
				CompilerUtil.indent(s, depth+2);
				s.append(boundary.getEdge().getEdgeTarget());
			}
		}
		super.toString(s, depth);
	}
}