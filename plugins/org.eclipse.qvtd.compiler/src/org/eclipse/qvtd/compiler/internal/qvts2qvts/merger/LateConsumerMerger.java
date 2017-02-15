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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * LateConsumerMerger replaces one list of MappingRegions by another in which each set of regions that
 * share a consumption and can be merged exploiting knowledge of the schedule is replaced by an
 * equivalent merged region.
 *
 * Preconditions:
 *
 * Late consumer merge must occur at all possible merge sites, or none. That is, a merged region that consumes
 * some node and surrounding predicates at ts head must merge with all other regions that consume that
 * head node with non-conflicting predicates.
 *
 * Every predicated edge/node of a late merged region must be shared with or satisfied by the other region.
 */
public class LateConsumerMerger extends AbstractMerger
{
	public static class LateMergedMappingRegion extends NamedMappingRegionImpl
	{
		public LateMergedMappingRegion(@NonNull ScheduleModel scheduleModel, @NonNull String name) {
			setFixmeScheduleModel(scheduleModel);
			setName(name);
		}

		@Override
		protected @NonNull String getSymbolNameSuffix() {
			return "_lc";
		}
	}

	protected static class LateRegionMerger extends RegionMerger
	{
		protected LateRegionMerger(@NonNull MappingRegion primaryRegion) {
			super(primaryRegion);
		}

		@Override
		protected @NonNull MappingRegion createNewRegion(@NonNull String newName) {
			return new LateMergedMappingRegion(RegionUtil.getScheduleModel(primaryRegion), newName);
		}

		public void install(@NonNull ContentsAnalysis contentsAnalysis, @NonNull MappingRegion mergedRegion) {
			ScheduledRegion invokingRegion = RegionUtil.getInvokingRegion(primaryRegion);
			List<@NonNull Region> callableParents = Lists.newArrayList(primaryRegion.getCallableParents());
			contentsAnalysis.removeRegion(primaryRegion);
			for (@NonNull Region callableParent : callableParents) {
				callableParent.replaceCallToChild(primaryRegion, mergedRegion);
			}
			primaryRegion.setInvokingRegion(invokingRegion);
			for (@NonNull Region secondaryRegion : secondaryRegions) {
				contentsAnalysis.removeRegion(secondaryRegion);
				assert invokingRegion == secondaryRegion.getInvokingRegion();
				for (@NonNull Region callableParent : callableParents) {
					callableParent.removeCallToChild(secondaryRegion);
				}
				secondaryRegion.setInvokingRegion(invokingRegion);
			}
			contentsAnalysis.addRegion(mergedRegion);
			mergedRegion.setInvokingRegion(invokingRegion);
			for (@NonNull Node oldHeadNode : RegionUtil.getHeadNodes(primaryRegion)) {
				NodeConnection incomingConnection = oldHeadNode.getIncomingConnection();
				if (incomingConnection != null) {
					Node newHeadNode = getNodeMerger(oldHeadNode).getNewNode();
					incomingConnection.addPassedTargetNode(newHeadNode);
					incomingConnection.removeTargetRegion(primaryRegion);
					for (@NonNull Region secondaryRegion : secondaryRegions) {
						incomingConnection.removeTargetRegion(secondaryRegion);
					}
				}
			}
		}
	}

	private class LateStrategy extends Correlator.AbstractCorrelationStrategy
	{
		@Override
		public boolean navigableEdgesMatch(@NonNull NavigableEdge secondaryEdge, @Nullable NavigableEdge primaryEdge) { // assert same property, skip secondary properties
			if (secondaryEdge.isSecondary()) {				// Ignore opposites - checked by theit forward edge
				return true;
			}
			Property property = secondaryEdge.getProperty();
			if (primaryEdge == null) {
				if (/*!secondaryEdge.isRequired() ||*/ !secondaryEdge.isUnconditional()) {
					return true;
				}
				if (secondaryEdge.isConstant()) {
					return true;
				}
				if (secondaryEdge.isLoaded()) {
					return true;
				}
				if (secondaryEdge.isNew()) {
					return true;
				}
				if (secondaryEdge.isOld()) {
					if (!secondaryEdge.getEdgeTarget().isRequired()) {
						return true;					// If target is optional, it's absence cannot cause a failure
					}
					if (!property.isIsRequired()) {
						return true;					// If property is optional, it's absence cannot cause a failure
					}
					ClassDatumAnalysis classDatumAnalysis = RegionUtil.getClassDatumAnalysis(secondaryEdge.getEdgeTarget());
					Iterable<@NonNull NavigableEdge> realizedEdges = getContentsAnalysis().getNewEdges(secondaryEdge, classDatumAnalysis);
					if (realizedEdges != null) {
						int firstIndex = secondaryEdge.getRegion().getFirstIndex();
						for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
							Region region = realizedEdge.getRegion();
							int lastIndex = region.getLastIndex();
							if (lastIndex >= firstIndex) {
								if (debugFailures) {
									FAILURE.println("Not ready : " + realizedEdge);
								}
								return false;		// Missing edge must be unconditional somewhere
							}
						}
						return true;					// All realizations are earlier
					}
					//					if (property.isIsRequired()) {
					//						return true;					// Property is required therefore it must be assigned elsewhere (and earlier)
					//					}
					// FIXME If there is a mandatory assignment to the optional property => true
					toString();
				}
				if (debugFailures) {
					FAILURE.println("Missing predicated match for : " + secondaryEdge);
				}
				return false;		// Missing edge must be unconditional somewhere
			}
			else {
				assert primaryEdge.getProperty() == property;
				if (/*!primaryEdge.isRequired() ||*/ !primaryEdge.isUnconditional()) {
					return true;
				}
				if (secondaryEdge.isConstant() || primaryEdge.isConstant()) {
					if (secondaryEdge.isConstant() != primaryEdge.isConstant()) {
						System.out.println("Inconsistent constant: " + secondaryEdge + ", " + primaryEdge);
					}
					return true;
				}
				if (secondaryEdge.isLoaded() || primaryEdge.isLoaded()) {
					if (secondaryEdge.isLoaded() != primaryEdge.isLoaded()) {
						System.out.println("Inconsistent loaded: " + secondaryEdge + ", " + primaryEdge);
					}
					return true;
				}
				if (secondaryEdge.isNew() || primaryEdge.isNew()) {
					if (secondaryEdge.isNew() == primaryEdge.isNew()) {		// == should only be one REALIZED
						System.out.println("Inconsistent new: " + secondaryEdge + ", " + primaryEdge);
					}
					return true;
				}
				if (secondaryEdge.isOld() || primaryEdge.isOld()) {
					if (secondaryEdge.isOld() != primaryEdge.isOld()) {
						System.out.println("Inconsistent old: " + secondaryEdge + ", " + primaryEdge);
					}
					return true;
				}
				if (debugFailures) {
					FAILURE.println("Inconsistent edges : " + secondaryEdge + ", " + primaryEdge);
				}
				return false; //super.navigableEdgesMatch(secondaryEdge, primaryEdge);
			}
		}

		@Override
		public boolean navigableNodesMatch(@NonNull Node secondaryNode, @Nullable Node primaryNode) {
			if (!secondaryNode.isRequired() || !secondaryNode.isUnconditional()) {
				return true;
			}
			if (primaryNode == null) {
				return true;			// Missing node must be created somewhere else (?? duplicates missing edge logic)
			}
			else {
				if (!primaryNode.isRequired() || !primaryNode.isUnconditional()) {
					return true;
				}
				if (secondaryNode.isConstant() || primaryNode.isConstant()) {
					if (secondaryNode.isConstant() != primaryNode.isConstant()) {
						System.out.println("Inconsistent constant: " + secondaryNode + ", " + primaryNode);
					}
					return true;
				}
				if (secondaryNode.isLoaded() || primaryNode.isLoaded()) {
					if (secondaryNode.isLoaded() != primaryNode.isLoaded()) {
						System.out.println("Inconsistent loaded: " + secondaryNode + ", " + primaryNode);
					}
					return true;
				}
				if (secondaryNode.isNew() || primaryNode.isNew()) {
					if (secondaryNode.isNew() == primaryNode.isNew()) {		// == should only be one REALIZED
						System.out.println("Inconsistent new: " + secondaryNode + ", " + primaryNode);
					}
					return true;
				}
				if (secondaryNode.isOld() || primaryNode.isOld()) {
					if (secondaryNode.isOld() != primaryNode.isOld()) {
						System.out.println("Inconsistent old: " + secondaryNode + ", " + primaryNode);
					}
					return true;
				}
				if (debugFailures) {
					FAILURE.println("Inconsistent nodes : " + secondaryNode + ", " + primaryNode);
				}
			}
			return false;//super.navigableNodesMatch(secondaryNode, primaryNode);
		}
	}

	/**
	 * Replace those inputRegions that may be merged by merged regions.
	 *
	 * inputRegions should be indexed to encourage consecutive indexes for regions sharing an input connection.
	 */
	public static @NonNull Map<@NonNull Region, @NonNull List<@NonNull Region>> merge(@NonNull ScheduledRegion scheduledRegion) {
		LateConsumerMerger lateMerger = new LateConsumerMerger(scheduledRegion);
		lateMerger.merge();
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduledRegion.writeDebugGraphs("8-late", true, true, false);
		}
		return lateMerger.getMerges();
	}

	protected final @NonNull ScheduledRegion scheduledRegion;
	protected final @NonNull List<@NonNull Region> allRegions = new ArrayList<>();
	private /*@LazyNonNull*/ ContentsAnalysis contentsAnalysis;
	private final @NonNull Map<@NonNull Region, @NonNull List<@NonNull Region>> newRegion2oldRegions = new HashMap<>();
	protected final @NonNull LateStrategy LateStrategy_INSTANCE = new LateStrategy();

	public LateConsumerMerger(@NonNull ScheduledRegion scheduledRegion) {
		this.scheduledRegion = scheduledRegion;
		gatherRegions(scheduledRegion);

	}

	private void gatherRegions(@NonNull Region parentRegion) {
		for (@NonNull Region childRegion : parentRegion.getCallableChildren()) {
			allRegions.add(childRegion);
			gatherRegions(childRegion);
		}
		return;
	}

	protected @NonNull ContentsAnalysis getContentsAnalysis() {
		ContentsAnalysis contentsAnalysis2 = contentsAnalysis;
		if (contentsAnalysis2 == null) {
			contentsAnalysis2 = contentsAnalysis = new ContentsAnalysis(RegionUtil.getScheduleModel(scheduledRegion));
			for (@NonNull Region region : allRegions) {
				contentsAnalysis2.addRegion(region);
			}
		}
		return contentsAnalysis2;
	}

	public @NonNull Map<@NonNull Region, @NonNull List<@NonNull Region>> getMerges() {
		return newRegion2oldRegions;
	}

	/*	private @Nullable Iterable<@NonNull Region> getSharedConsumers(@NonNull Region primaryRegion) {
		Set<@NonNull Region> sharedRegions = null;
		List<@NonNull Node> headNodes = primaryRegion.getHeadNodes();
		for (@NonNull Node headNode : headNodes) {
			Iterable<@NonNull Node> oldNodes = getContentsAnalysis().getOldNodes(headNode.getClassDatumAnalysis());
			if (oldNodes != null) {
				for (@NonNull Node oldNode : oldNodes) {
					Region region = oldNode.getRegion();
					if (region != primaryRegion) {
						if (sharedRegions == null) {
							sharedRegions = new HashSet<>();
						}
						sharedRegions.add(region);
					}
				}
			}
		}
		return sharedRegions;
	} */

	private void merge() {
		mergeHierarchy(scheduledRegion);
		return;
	}

	private void mergeHierarchy(@NonNull Region parentRegion) {
		for (@NonNull Region childRegion : parentRegion.getCallableChildren()) {
			mergeHierarchy(childRegion);
			mergeRegion(childRegion);
		}
		return;
	}

	private void mergeRegion(@NonNull Region parentRegion) {
		for (@NonNull NodeConnection nodeConnection : parentRegion.getRootConnections()) {
			//			System.out.println(nodeConnection + " " + nodeConnection.getIndexes());
			Iterable<@NonNull List<@NonNull MappingRegion>> consecutiveRegionRuns = selectConsecutiveRegionRuns(nodeConnection);
			for (@NonNull List<@NonNull MappingRegion> consecutiveRegionRun : consecutiveRegionRuns) {
				StringBuilder s = new StringBuilder();
				s.append(Iterables.size(consecutiveRegionRun));
				for (@NonNull Region consecutiveRegion : consecutiveRegionRun) {
					s.append(" " + consecutiveRegion);
				}
				//				System.out.println(s.toString());
				mergeRegions(consecutiveRegionRun);
			}
		}
		return;
	}

	protected void mergeRegions(@NonNull List<@NonNull MappingRegion> consecutiveRegionRun) {
		List<@NonNull MappingRegion> residualInputRegions = new ArrayList<>(consecutiveRegionRun);
		while (residualInputRegions.size() >= 2) {
			MappingRegion primaryRegion = residualInputRegions.remove(0);
			if (LATE.isActive()) {
				LATE.println("Correlating primary: " + primaryRegion + "@[" + primaryRegion.getIndexRangeText() + "]");
			}
			if (primaryRegion.getIntermediateConnections().size() > 0) {		// FIXME this should be allowed
				if (FAILURE.isActive()) {
					FAILURE.println("Intermediate connections not yet supported");
				}
				return;
			}
			/*			Iterable<@NonNull Region> sharedConsumers = getSharedConsumers(primaryRegion);
			if (sharedConsumers != null) {
				for (@NonNull Region sharedConsumer : sharedConsumers) {
					if (!residualInputRegions.contains(sharedConsumer)) {
						if (FAILURE.isActive()) {
							FAILURE.println("Unshareable shared region: " + sharedConsumer + "@[" + sharedConsumer.getIndexRangeText() + "]");
						}
						return;
					}
				}
			} */
			LateRegionMerger regionMerger = null;
			for (int i = 0; i < residualInputRegions.size(); i++) {
				MappingRegion secondaryRegion = residualInputRegions.get(i);
				if (LATE.isActive()) {
					LATE.println("Correlating secondary: " + secondaryRegion + "@[" + secondaryRegion.getIndexRangeText() + "]");
				}
				if (secondaryRegion.getIntermediateConnections().size() > 0) {		// FIXME this should be allowed
					if (FAILURE.isActive()) {
						FAILURE.println("Intermediate connections not yet supported");
					}
				}
				else {
					Correlator secondary2primary = Correlator.correlate(secondaryRegion, primaryRegion, LateStrategy_INSTANCE, null);
					if (secondary2primary != null) {
						boolean doMerge = false;
						if (!isSharedHead(primaryRegion, secondaryRegion)) {
							doMerge = true;
						}
						else {
							if (LATE.isActive()) {
								LATE.println("Correlating inverse");
							}
							if (Correlator.correlate(primaryRegion, secondaryRegion, LateStrategy_INSTANCE, secondary2primary.getNode2Node()) != null) {
								doMerge = true;
							}
						}
						if (doMerge) {
							if (regionMerger == null) {
								//							residualInputRegions.remove(primaryRegion);
								regionMerger = new LateRegionMerger(primaryRegion);
							}
							//						residualInputRegions.remove(secondaryRegion);
							regionMerger.addSecondaryRegion(secondaryRegion, secondary2primary.getNode2Node());
						}
					}
				}
			}
			if (regionMerger != null) {
				// ?? involves all shareableConsumers
				regionMerger.prune();
				MappingRegion mergedRegion = regionMerger.create();
				regionMerger.check(mergedRegion);
				regionMerger.install(getContentsAnalysis(), mergedRegion);
				List<@NonNull Region> oldRegions = new ArrayList<>();
				oldRegions.add(primaryRegion);
				oldRegions.addAll(regionMerger.getSecondaryRegions());
				newRegion2oldRegions.put(mergedRegion, oldRegions);
				residualInputRegions.removeAll(oldRegions);
				for (@NonNull Region oldRegion : oldRegions) {
					for (int index : oldRegion.getIndexes()) {
						mergedRegion.addIndex(index);
					}
				}
				mergedRegion.writeDebugGraphs(null);
			}
		}
	}

	protected @NonNull Iterable<@NonNull List<@NonNull MappingRegion>> selectConsecutiveRegionRuns(@NonNull NodeConnection nodeConnection) {
		Map<@NonNull Integer, @NonNull MappingRegion> index2region = new HashMap<>();
		for (@NonNull Region targetRegion : nodeConnection.getTargetRegions()) {
			if (targetRegion instanceof MappingRegion) {			// FIXME ?? always a MappingRegion
				List<@NonNull Integer> indexes = targetRegion.getIndexes();
				index2region.put(indexes.get(indexes.size()-1), (@NonNull MappingRegion) targetRegion);
			}
		}
		List<@NonNull Integer> orderedIndexes = new ArrayList<>(index2region.keySet());
		Collections.sort(orderedIndexes);
		List<@NonNull List<@NonNull MappingRegion>> consecutiveRegionRuns = new ArrayList<>();
		{
			List<@NonNull MappingRegion> consecutiveRegionRun = null;
			for (@NonNull Integer index : orderedIndexes) {
				MappingRegion childRegion = index2region.get(index);
				assert childRegion != null;
				if ((consecutiveRegionRun == null) || (consecutiveRegionRun.get(consecutiveRegionRun.size()-1).getLastIndex()+1 != index)) {
					consecutiveRegionRun = new ArrayList<>();
					consecutiveRegionRuns.add(consecutiveRegionRun);
				}
				consecutiveRegionRun.add(childRegion);
			}
		}
		for (int i = consecutiveRegionRuns.size(); --i >= 0; ) {		// Down count to allow removal
			List<@NonNull MappingRegion> consecutiveRegionRun = consecutiveRegionRuns.get(i);
			if (consecutiveRegionRun.size() <= 1) {
				consecutiveRegionRuns.remove(i);
			}
		}
		return consecutiveRegionRuns;
	}
}
