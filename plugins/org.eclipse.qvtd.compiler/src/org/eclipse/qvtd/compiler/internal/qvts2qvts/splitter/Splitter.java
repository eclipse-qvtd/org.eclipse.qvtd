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
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * A Splitter splits multi-headed regions whose heads are dependent into a cascade of looping regions, one per head around
 * a singly-headed core region. The split is performed recusively by introducing a Boundary between a Group of ssource head nodes
 * and target head nodes. The result is an ordered list of boundaries.
 *
 * Splitting is performed at two levels.
 *
 * The upper Computable level builds a tree of mutual groups with predecessor/successor relationships determined by the unidirectional
 * computational relationships between the mutual groups.
 *
 * The lower Navigable level of mutual groups with bidirectional navigation relationships between simple groups is sequenced
 * to respect the simple groups used by the Computable level.
 */
public class Splitter extends SplitterAnalysis
{
	//	public static final @NonNull TracingOption ANALYSIS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/split/analysis");
	public static final @NonNull TracingOption GROUPS = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/split/groups");
	public static final @NonNull TracingOption RESULT = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/split/result");
	public static final @NonNull TracingOption STAGES = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/split/stages");

	/**
	 * Map from each simple group to the mutually navigable group that contains it.
	 */
	private final @NonNull Map<@NonNull SimpleGroup, @NonNull AbstractGroup> simpleGroup2mutualGroup = new HashMap<>();

	public Splitter(@NonNull Region region) {
		super(region);
	}

	/**
	 * Established the computable predecessor/successor relationships between navigable groups.
	 */
	protected void computeComputableGroup(@NonNull Iterable<@NonNull AbstractGroup> mutualGroups) {
		for (@NonNull AbstractGroup mutualGroup : mutualGroups) {
			computeComputablePredecessors(mutualGroup);
		}
	}

	/**
	 * Create a forest to sequence the computable groups and return the roots.
	 */
	protected @NonNull Iterable<@NonNull AbstractGroup> computeComputableGroupSchedule() {
		List<@NonNull AbstractGroup> rootMutuals = new ArrayList<>();
		List<@NonNull AbstractGroup> scheduledNavigables = new ArrayList<>(simpleGroup2mutualGroup.size());
		List<@NonNull AbstractGroup> unscheduledNavigables = new ArrayList<>(new HashSet<>(simpleGroup2mutualGroup.values()));
		Collections.sort(unscheduledNavigables, NameUtil.NAMEABLE_COMPARATOR);	// Improve determinacy
		while (unscheduledNavigables.size() > 0) {
			int oldSize = unscheduledNavigables.size();
			for (@NonNull AbstractGroup unscheduledNavigable : unscheduledNavigables) {
				Iterable<@NonNull AbstractGroup> predecessors = unscheduledNavigable.getPredecessors();
				Set<@NonNull AbstractGroup> unscheduledPredecessors = Sets.newHashSet(predecessors);
				for (@NonNull AbstractGroup scheduledNavigable : scheduledNavigables) {
					unscheduledPredecessors.remove(scheduledNavigable);
				}
				if (unscheduledPredecessors.isEmpty()) {
					boolean hasPredecessor = false;
					for (int lastIndex = scheduledNavigables.size()-1; lastIndex >= 0; lastIndex--) {
						AbstractGroup lastScheduledNavigable = scheduledNavigables.get(lastIndex);
						if (Iterables.contains(predecessors, lastScheduledNavigable)) {
							lastScheduledNavigable.addSuccessor(unscheduledNavigable);
							hasPredecessor = true;
							break;
						}
					}
					if (!hasPredecessor) {
						rootMutuals.add(unscheduledNavigable);
					}
					scheduledNavigables.add(unscheduledNavigable);
				}
			}
			unscheduledNavigables.removeAll(scheduledNavigables);
			int newSize = unscheduledNavigables.size();
			if (oldSize == newSize) {
				throw new IllegalStateException("Cyclic dependency in " + region);
			}
		}
		return rootMutuals;
	}

	/**
	 * Establishing predecessor/suucessor relationships between the ComputableGroup of each MutualGroup
	 * according to computation edges traversing the inter-navigable group divide.
	 */
	protected void computeComputablePredecessors(@NonNull AbstractGroup mutualGroup) {
		Iterable<@NonNull SimpleGroup> targetGroups = mutualGroup.getInternalSimpleGroups();
		AbstractGroup targetMutualGroup = simpleGroup2mutualGroup.get(targetGroups.iterator().next());
		assert targetMutualGroup != null;
		Iterable<@NonNull Node> reachableNodes = mutualGroup.getReachableNodes();
		for (@NonNull Node node : reachableNodes) {		// FIXME ?? can only be heads
			for (@NonNull Edge edge : node.getIncomingEdges()) {
				assert edge.getTarget() == node;
				if (!edge.isRealized() && edge.isComputation()) {
					Node sourceNode = edge.getSource();
					Iterable<@NonNull SimpleGroup> sourceGroups = basicGetReachableSimpleGroups(sourceNode);
					if (sourceGroups == null) {
						sourceGroups = computeComputableSourceGroups(new HashSet<@NonNull SimpleGroup>(), sourceNode);
					}
					assert sourceGroups != null;
					List<@NonNull AbstractGroup> sourceComputableGroups = new ArrayList<>();
					for (@NonNull SimpleGroup sourceGroup : sourceGroups) {
						if (!Iterables.contains(targetGroups, sourceGroup)) {
							AbstractGroup sourceMutualGroup = simpleGroup2mutualGroup.get(sourceGroup);
							assert sourceMutualGroup != null;
							sourceComputableGroups.add(sourceMutualGroup);
						}
					}
					targetMutualGroup.addPredecessor(edge, sourceComputableGroups);
				}
			}
		}
	}

	protected Iterable<@NonNull SimpleGroup> computeComputableSourceGroups(@NonNull Set<@NonNull SimpleGroup> groups, @NonNull Node targetNode) {
		for (@NonNull Edge edge : targetNode.getIncomingEdges()) {
			if (edge.isComputation()) {
				Node sourceNode = edge.getSource();
				Iterable<@NonNull SimpleGroup> sourceGroups = basicGetReachableSimpleGroups(sourceNode);
				if (sourceGroups != null) {
					Iterables.addAll(groups, sourceGroups);
					computeComputableSourceGroups(groups, sourceNode);
				}
			}
		}
		return groups;
	}

	protected @NonNull Iterable<@NonNull AbstractGroup> computeSimpleGroup2mutualGroup(@NonNull Iterable<@NonNull SimpleGroup> simpleGroups) {
		for (@NonNull SimpleGroup simpleGroup : simpleGroups) {
			if (!simpleGroup2mutualGroup.containsKey(simpleGroup)) {
				growMutualGroup(simpleGroups, simpleGroup);
			}
		}
		return Sets.newHashSet(simpleGroup2mutualGroup.values());
	}

	/**
	 * Traverse the rootGroups and create a Split to sequence the head-nodes of each partial
	 * region and the edges that traverse them.
	 */
	protected Split computeSplit(@NonNull Iterable<@NonNull AbstractGroup> rootGroups) {
		Split split = new Split(this);
		for (@NonNull AbstractGroup rootGroup : rootGroups) {
			rootGroup.buildSplit(split, null, null);
		}
		split.addBodyStage();
		return split;
	}

	/**
	 * Grow a navigable group seeded by thisGroup to include all simple groups that are mutually to-1 or to-N navigable from this group.
	 */
	protected @NonNull AbstractGroup growMutualGroup(@NonNull Iterable<@NonNull SimpleGroup> simpleGroups, @NonNull SimpleGroup thisGroup) {
		//
		//	Initialize the set of these groups and their reachable nodes from thisGroup.
		//
		Set<@NonNull SimpleGroup> theseGroups = new HashSet<>();
		theseGroups.add(thisGroup);
		Set<@NonNull Node> theseNodes = new HashSet<>();
		for (@NonNull Group group : theseGroups) {
			Iterables.addAll(theseNodes, group.getReachableNodes());
		}
		//
		//	Initialize the set of those groups.
		//
		Set<@NonNull SimpleGroup> thoseGroups = new HashSet<>();
		Iterables.addAll(thoseGroups, simpleGroups);
		thoseGroups.removeAll(theseGroups);
		while (true) {
			//
			//	Compute the set of reachable nodes from thoseGroups.
			//
			Set<@NonNull Node> thoseNodes = new HashSet<>();
			for (@NonNull Group group : thoseGroups) {
				Iterables.addAll(thoseNodes, group.getReachableNodes());
			}
			//
			//	Compute the overlap nodes that are reachable from one or more of these head node and one or more of those head nodes.
			//
			Set<@NonNull Node> overlapNodes = Sets.newHashSet(theseNodes);
			overlapNodes.retainAll(thoseNodes);
			if (overlapNodes.isEmpty()) {
				AbstractGroup navigableGroup;
				if (theseGroups.size() == 1) {
					navigableGroup = theseGroups.iterator().next();
				}
				else {
					navigableGroup = new CompoundGroup(this, theseGroups);
				}
				for (@NonNull SimpleGroup simpleGroup : theseGroups) {
					AbstractGroup oldMutualGroup = simpleGroup2mutualGroup.put(simpleGroup, navigableGroup);
					assert oldMutualGroup == null;
				}
				return navigableGroup;
			}
			//
			//	Compute the additional groups contributing to the overlap..
			//
			Set<@NonNull SimpleGroup> newOverlapGroups = new HashSet<>();
			for (@NonNull Node node : overlapNodes) {
				Iterable<@NonNull SimpleGroup> overlapGroups = getReachableSimpleGroups(node);
				assert overlapGroups != null;
				for (@NonNull SimpleGroup overlapGroup : overlapGroups) {
					newOverlapGroups.add(overlapGroup);
				}
			}
			newOverlapGroups.removeAll(theseGroups);
			//
			//	Move the new groups of the overlap to theseGroups for the next iteration.
			//
			for (@NonNull SimpleGroup group : newOverlapGroups) {
				theseGroups.add(group);
				thoseGroups.remove(group);
				Iterables.addAll(theseNodes, group.getReachableNodes());
			}
		}
	}

	/**
	 * Return an ordered list of boundaries at which the region can be successively split by performing an iteration from the boundary source
	 * using the boundary edge over the boundary target. Returns null if no split possible or needed.
	 */
	public @Nullable Split split() {
		//
		// Perform the basic reachability analyses.
		//
		Iterable<@NonNull SimpleGroup> simpleGroups = analyze();
		if (simpleGroups == null) {
			return null;
		}
		//
		//	Create and grow the mutually navigable groups.
		//
		Iterable<@NonNull AbstractGroup> mutualGroups = computeSimpleGroup2mutualGroup(simpleGroups);
		//
		//	Create a computable group for each navigable group and their mandatory precedences.
		//
		computeComputableGroup(mutualGroups);
		//
		//	Create the list of roots of computable group trees.
		//
		Iterable<@NonNull AbstractGroup> rootGroups = computeComputableGroupSchedule();
		//
		//	Sequence each mutual group to exploit its calling context.
		//
		for (@NonNull AbstractGroup rootGroup : rootGroups) {
			rootGroup.computeNavigableGroupSchedule(Collections.emptyList());
		}
		//
		if (GROUPS.isActive()) {
			StringBuilder s = new StringBuilder();
			for (@NonNull AbstractGroup rootGroup : rootGroups) {
				if (Iterables.isEmpty(rootGroup.getPredecessors())) {
					s.append("\n");
					rootGroup.toString(s, 0);
				}
			}
			GROUPS.println(region + s.toString());
		}
		//
		//	Build a Split to summarize the analysis result.
		//
		Split split = computeSplit(rootGroups);
		//
		if (RESULT.isActive()) {
			RESULT.println(region + split.toString());
		}
		split.check();
		return split;
	}
}
