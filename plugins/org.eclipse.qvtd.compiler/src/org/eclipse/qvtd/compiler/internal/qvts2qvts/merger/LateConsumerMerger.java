/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

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
 * some node and surrounding predicates at its head must merge with all other regions that consume that
 * head node with non-conflicting predicates.
 *
 * Every predicated edge/node of a late merged region must be shared with or satisfied by the other region.
 */
public class LateConsumerMerger extends AbstractMerger
{
	public static class LateMergedMappingRegion extends NamedMappingRegionImpl
	{
		public LateMergedMappingRegion(@NonNull ScheduleManager scheduleManager, @NonNull String name) {
			scheduleManager.addMappingRegion(this);
			setName(name);
			setSymbolNameSuffix("_lc");
		}
	}

	protected static class LateRegionMerger extends RegionMerger
	{
		protected LateRegionMerger(@NonNull ScheduleManager scheduleManager, @NonNull MappingRegion primaryRegion) {
			super(scheduleManager, primaryRegion);
		}

		@Override
		protected @NonNull MappingRegion createMergedRegion(@NonNull String mergedName) {
			return new LateMergedMappingRegion(scheduleManager, mergedName);
		}

		public void install(@NonNull ContentsAnalysis<@NonNull MappingRegion> contentsAnalysis, @NonNull MappingRegion mergedRegion) {
			MappingRegion primaryRegion = getPrimaryRegion();
			ScheduledRegion invokingRegion = QVTscheduleUtil.getContainingScheduledRegion(primaryRegion);
			List<@NonNull Region> callableParents = Lists.newArrayList(primaryRegion.getCallableParents());
			for (@NonNull MappingRegion originalRegion : getOriginalRegions()) {
				contentsAnalysis.removeRegion(originalRegion);
				assert invokingRegion == originalRegion.getScheduledRegion();
				for (@NonNull Region callableParent : callableParents) {
					if (originalRegion == primaryRegion) {
						callableParent.replaceCallToChild(primaryRegion, mergedRegion);
					}
					else {
						callableParent.removeCallToChild(originalRegion);
					}
				}
				scheduleManager.setScheduledRegion(originalRegion, invokingRegion);
			}
			contentsAnalysis.addRegion(mergedRegion);
			scheduleManager.setScheduledRegion(mergedRegion, invokingRegion);
			for (@NonNull Node originalHeadNode : QVTscheduleUtil.getHeadNodes(primaryRegion)) {
				NodeConnection incomingConnection = originalHeadNode.getIncomingConnection();
				if (incomingConnection != null) {
					Node mergedHeadNode = getNodeMerger(originalHeadNode).getMergedNode();
					incomingConnection.addPassedTargetNode(mergedHeadNode);
					for (@NonNull Region originalRegion : getOriginalRegions()) {
						incomingConnection.removeTargetRegion(originalRegion);
					}
				}
			}
		}
	}

	private class LateStrategy extends Correlator.AbstractCorrelationStrategy
	{
		@Override
		public boolean navigableEdgesMatch(@Nullable EdgeMerger edgeMerger, @NonNull NavigableEdge extraEdge) { // assert same property, skip secondary properties
			if (extraEdge.isSecondary()) {				// Ignore opposites - checked by their forward edge
				return true;
			}
			Property property = extraEdge.getProperty();
			if (edgeMerger == null) {
				//				if (/*!extraEdge.isRequired() ||*/ !extraEdge.isUnconditional()) {
				//				if (/*!extraEdge.isRequired() ||*/ !(QVTscheduleUtil.getSourceNode(extraEdge).isUnconditional() && (QVTscheduleUtil.getTargetNode(extraEdge).getUtility() == Utility.STRONGLY_MATCHED))) {
				if (!extraEdge.isMatched()) {
					return true;
				}
				if (property.isIsMany() && (((CollectionType)property.getType()).getLower().intValue() == 0)) {
					return true;
				}
				if (extraEdge.isConstant()) {
					if (debugFailures) {
						FAILURE.println("Missing constant : " + extraEdge);
					}
					return false;
				}
				if (extraEdge.isLoaded()) {
					if (debugFailures) {
						FAILURE.println("Missing loaded : " + extraEdge);
					}
					return false;
				}
				if (extraEdge.isNew()) {
					return true;
				}
				if (extraEdge.isOld()) {
					if (!extraEdge.getEdgeTarget().isRequired()) {
						return true;					// If target is optional, it's absence cannot cause a failure
					}
					if (!property.isIsRequired()) {
						return true;					// If property is optional, it's absence cannot cause a failure
					}
					ClassDatum classDatum = QVTscheduleUtil.getClassDatum(extraEdge.getEdgeTarget());
					Iterable<@NonNull NavigableEdge> realizedEdges = getContentsAnalysis().getNewEdges(extraEdge, classDatum);
					if (realizedEdges != null) {
						int firstIndex = extraEdge.getOwningRegion().getFirstIndex();
						for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
							Region region = realizedEdge.getOwningRegion();
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
					FAILURE.println("Missing predicated match for : " + extraEdge);
				}
				return false;		// Missing edge must be unconditional somewhere
			}
			else {
				assert edgeMerger.getProperty() == property;
				if (/*!edgeMerger.isRequired() ||*/ !edgeMerger.isUnconditional()) {
					return true;
				}
				if (extraEdge.isConstant() || edgeMerger.isConstant()) {
					if (extraEdge.isConstant() != edgeMerger.isConstant()) {
						System.out.println("Inconsistent constant: " + extraEdge + ", " + edgeMerger);
					}
					return true;
				}
				if (extraEdge.isLoaded() || edgeMerger.isLoaded()) {
					if (extraEdge.isLoaded() != edgeMerger.isLoaded()) {
						System.out.println("Inconsistent loaded: " + extraEdge + ", " + edgeMerger);
					}
					return true;
				}
				if (extraEdge.isNew() || edgeMerger.isNew()) {
					if (extraEdge.isNew() == edgeMerger.isNew()) {		// == should only be one REALIZED
						System.out.println("Inconsistent new: " + extraEdge + ", " + edgeMerger);
					}
					return true;
				}
				if (extraEdge.isOld() || edgeMerger.isOld()) {
					if (extraEdge.isOld() != edgeMerger.isOld()) {
						System.out.println("Inconsistent old: " + extraEdge + ", " + edgeMerger);
					}
					return true;
				}
				if (debugFailures) {
					FAILURE.println("Inconsistent edges : " + extraEdge + ", " + edgeMerger);
				}
				return false; //super.navigableEdgesMatch(extraEdge, edgeMerger);
			}
		}

		@Override
		public boolean navigableNodesMatch(@Nullable NodeMerger nodeMerger, @NonNull Node extraNode) {
			if (!extraNode.isRequired() || !extraNode.isUnconditional()) {
				return true;
			}
			if (nodeMerger == null) {
				return true;			// Missing node must be created somewhere else (?? duplicates missing edge logic)
			}
			if (!nodeMerger.isRequired() || !nodeMerger.isUnconditional()) {
				return true;
			}
			if (extraNode.isConstant() || nodeMerger.isConstant()) {
				if (extraNode.isConstant() != nodeMerger.isConstant()) {
					System.out.println("Inconsistent constant: " + extraNode + ", " + nodeMerger);
				}
				return true;
			}
			if (extraNode.isLoaded() || nodeMerger.isLoaded()) {
				if (extraNode.isLoaded() != nodeMerger.isLoaded()) {
					System.out.println("Inconsistent loaded: " + extraNode + ", " + nodeMerger);
				}
				return true;
			}
			if (extraNode.isNew() || nodeMerger.isNew()) {
				if (extraNode.isNew() == nodeMerger.isNew()) {		// == should only be one REALIZED
					System.out.println("Inconsistent new: " + extraNode + ", " + nodeMerger);
				}
				return true;
			}
			if (extraNode.isOld() || nodeMerger.isOld()) {
				if (extraNode.isOld() != nodeMerger.isOld()) {
					System.out.println("Inconsistent old: " + extraNode + ", " + nodeMerger);
				}
				return true;
			}
			if (debugFailures) {
				FAILURE.println("Inconsistent nodes : " + extraNode + ", " + nodeMerger);
			}
			return false;//super.navigableNodesMatch(extraNode, primaryNode);
		}
	}

	/**
	 * Replace those inputRegions that may be merged by merged regions.
	 *
	 * inputRegions should be indexed to encourage consecutive indexes for regions sharing an input connection.
	 */
	public static @NonNull Map<@NonNull MappingRegion, @NonNull List<@NonNull MappingRegion>> merge(@NonNull ScheduleManager scheduleManager, @NonNull ScheduledRegion scheduledRegion) {
		LateConsumerMerger lateMerger = new LateConsumerMerger(scheduleManager, scheduledRegion);
		lateMerger.merge();
		lateMerger.prune();
		scheduleManager.writeDebugGraphs("8-late", true, true, false);
		return lateMerger.getMerges();
	}

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ScheduledRegion scheduledRegion;
	protected final @NonNull List<@NonNull Region> allRegions = new ArrayList<>();
	private /*@LazyNonNull*/ ContentsAnalysis<@NonNull MappingRegion> contentsAnalysis;
	private final @NonNull Map<@NonNull MappingRegion, @NonNull List<@NonNull MappingRegion>> mergedRegion2originalRegions = new HashMap<>();
	protected final @NonNull LateStrategy LateStrategy_INSTANCE = new LateStrategy();

	public LateConsumerMerger(@NonNull ScheduleManager scheduleManager, @NonNull ScheduledRegion scheduledRegion) {
		this.scheduleManager = scheduleManager;
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

	protected @NonNull ContentsAnalysis<@NonNull MappingRegion> getContentsAnalysis() {
		ContentsAnalysis<@NonNull MappingRegion> contentsAnalysis2 = contentsAnalysis;
		if (contentsAnalysis2 == null) {
			contentsAnalysis2 = contentsAnalysis = new ContentsAnalysis<@NonNull MappingRegion>(scheduleManager);
			for (@NonNull Region region : allRegions) {
				if (region instanceof MappingRegion) {			// Skip e.g LoadingRegion
					contentsAnalysis2.addRegion((MappingRegion) region);
				}
			}
		}
		return contentsAnalysis2;
	}

	public @NonNull Map<@NonNull MappingRegion, @NonNull List<@NonNull MappingRegion>> getMerges() {
		return mergedRegion2originalRegions;
	}

	/*	private @Nullable Iterable<@NonNull Region> getSharedConsumers(@NonNull Region primaryRegion) {
		Set<@NonNull Region> sharedRegions = null;
		List<@NonNull Node> headNodes = primaryRegion.getHeadNodes();
		for (@NonNull Node headNode : headNodes) {
			Iterable<@NonNull Node> originalNodes = getContentsAnalysis().getOldNodes(headNode.getClassDatumAnalysis());
			if (originalNodes != null) {
				for (@NonNull Node originalNode : originalNodes) {
					Region region = originalNode.getRegion();
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
					LateRegionMerger forwardRegionMerger = regionMerger != null ? regionMerger : new LateRegionMerger(scheduleManager, primaryRegion);
					Correlator forwardCorrelator = Correlator.correlate(forwardRegionMerger, secondaryRegion, LateStrategy_INSTANCE, null);
					if (forwardCorrelator != null) {
						boolean doMerge = false;
						if (!isSharedHead(primaryRegion, secondaryRegion)) {
							doMerge = false;
						}
						else {
							if (LATE.isActive()) {
								LATE.println("Correlating inverse");
							}
							LateRegionMerger reverseRegionMerger = new LateRegionMerger(scheduleManager, secondaryRegion);
							if (Correlator.correlate(reverseRegionMerger, primaryRegion, LateStrategy_INSTANCE, forwardCorrelator) != null) {
								doMerge = true;
							}
						}
						if (doMerge) {
							if (regionMerger == null) {
								//							residualInputRegions.remove(primaryRegion);
								regionMerger = forwardRegionMerger;
							}
							//						residualInputRegions.remove(secondaryRegion);
							regionMerger.addSecondaryRegion(secondaryRegion, forwardCorrelator);
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
				List<@NonNull MappingRegion> originalRegions = new ArrayList<>();
				originalRegions.addAll(regionMerger.getOriginalRegions());
				mergedRegion2originalRegions.put(mergedRegion, originalRegions);
				residualInputRegions.removeAll(originalRegions);
				for (@NonNull Region originalRegion : originalRegions) {
					for (int index : originalRegion.getIndexes()) {
						mergedRegion.addIndex(index);
					}
				}
				scheduleManager.writeDebugGraphs(mergedRegion, null);
			}
		}
	}

	private void prune() {
		for (@NonNull List<@NonNull MappingRegion> originalRegions : mergedRegion2originalRegions.values()) {
			for (@NonNull MappingRegion originalRegion : originalRegions) {
				//				originalRegion.getOwningScheduledRegion().getOwnedMappingRegions().remove(originalRegion);
			}
		}
	}

	/**
	 * Return the lists of child regions that have consecutive indexes.
	 */
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
