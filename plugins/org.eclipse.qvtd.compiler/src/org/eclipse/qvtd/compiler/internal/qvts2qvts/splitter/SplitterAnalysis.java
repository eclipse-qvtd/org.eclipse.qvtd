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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

class SplitterAnalysis
{
	/**
	 * The region to be split.
	 */
	protected final @NonNull Region region;

	/**
	 * Map from each reachable node to all the simple groups with a head node from which it is reachable by to-one navigation.
	 */
	private final @NonNull Map<@NonNull Node, List<@NonNull SimpleGroup>> reachableNode2simpleGroups = new HashMap<>();

	//	private final @NonNull Map<@NonNull Node, @NonNull SimpleGroup> headNode2simpleGroup = new HashMap<>();

	public SplitterAnalysis(@NonNull Region region) {
		this.region = region;
	}

	/**
	 * Perform the basic reachability analyses. Returns the simple groups to be sequenced,
	 * or null if no multiple heads need splitting.
	 */
	protected @Nullable Iterable<@NonNull SimpleGroup> analyze() {
		//
		// Compute the head nodes of the region.
		//
		List<@NonNull Node> headNodes = new ArrayList<>();
		for (@NonNull Node headNode : RegionUtil.getHeadNodes(region)) {
			if (headNode.isMatched()) {			// Ignore extra heads
				headNodes.add(headNode);
			}
		}
		if (headNodes.size() <= 1) {
			return null;
		}
		//
		//	Create a simple group for each head node.
		//
		Set<@NonNull SimpleGroup> simpleGroups = new HashSet<>(headNodes.size());
		for (@NonNull Node headNode : headNodes) {
			SimpleGroup simpleGroup = new SimpleGroup(this, headNode);
			//			headNode2simpleGroup.put(headNode, simpleGroup);
			simpleGroups.add(simpleGroup);
		}
		//
		//	Create the map from each node to the simple groups from which it is reachable.
		//
		computeReachableNode2SimpleGroups(simpleGroups);
		return simpleGroups;
	}

	/**
	 * Compute the mapping from each node to the simple groups within which it is reachable from at least one head node.
	 */
	protected void computeReachableNode2SimpleGroups(@NonNull Iterable<@NonNull SimpleGroup> simpleGroups) {
		for (@NonNull SimpleGroup simpleGroup : simpleGroups) {
			for (@NonNull Node reachableNode : simpleGroup.getReachableNodes()) {
				List<@NonNull SimpleGroup> reachableGroups = reachableNode2simpleGroups.get(reachableNode);
				if (reachableGroups == null) {
					reachableGroups = new ArrayList<>();
					reachableNode2simpleGroups.put(reachableNode, reachableGroups);
				}
				assert !reachableGroups.contains(simpleGroup);
				reachableGroups.add(simpleGroup);
			}
		}
	}

	/**
	 * Return each simple group whose head can navigate to node using to-one navigations.
	 * May return null for a computation node.
	 */
	public @Nullable Iterable<@NonNull SimpleGroup> basicGetReachableSimpleGroups(@NonNull Node node) {
		return reachableNode2simpleGroups.get(node);
	}


	/**
	 * Return each simple group whose head can navigate to node using to-one navigations.
	 * Throws IllegalStateException for a computation node.
	 */
	public @NonNull Iterable<@NonNull SimpleGroup> getReachableSimpleGroups(@NonNull Node node) {
		return ClassUtil.nonNullState(reachableNode2simpleGroups.get(node));
	}

	public @NonNull Region getRegion() {
		return region;
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(region.getName());
	}
}
