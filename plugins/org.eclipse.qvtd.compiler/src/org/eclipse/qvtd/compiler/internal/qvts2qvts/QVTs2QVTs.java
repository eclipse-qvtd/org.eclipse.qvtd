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
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RootScheduledRegion2;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.merger.LateConsumerMerger;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.Partitioner;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseEnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * QVTs2QVTi supervises the serialization of a QVTs schedule as a QVTi transformation.
 */
public class QVTs2QVTs extends QVTimperativeHelper
{
	protected final @NonNull ProblemHandler problemHandler;
	protected final @NonNull String rootName;

	public QVTs2QVTs(@NonNull ProblemHandler problemHandler, @NonNull QVTbaseEnvironmentFactory environmentFactory, @NonNull String rootName) {
		super(environmentFactory);
		this.problemHandler = problemHandler;
		this.rootName = rootName;
	}

	private void createLocalSchedule(@NonNull ScheduledRegion scheduledRegion) {
		//
		//	Partition single region recursive connections into base cases recursive case connections with associated region recursions.
		//
		//		splitConnectionVariables();
		//
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduledRegion.writeDebugGraphs("5-cycled", true, true, false);
		}
	}

	private void createLocalSchedule2(@NonNull ScheduledRegion scheduledRegion, @NonNull List<@NonNull Region> orderedRegions) {
		//		region2order.computeRegionIndexes(getCallableRegions());
		//		Iterable<Region> sortedCallableRegions = regionOrdering;//AbstractRegion.EarliestRegionComparator.sort(getCallableRegions());
		//
		//	Index all predicated and realized edges by typed model and property.
		//
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges = new HashMap<>();
		Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges = new HashMap<>();
		for (@NonNull Region region : orderedRegions) {
			QVTscheduleConstants.POLLED_PROPERTIES.println("building indexes for " + region + " " + region.getIndexRangeText());
			region.buildPredicatedNavigationEdgesIndex(typedModel2property2predicatedEdges);
			region.buildRealizedNavigationEdgesIndex(typedModel2property2realizedEdges);
		}
		//
		//	Eliminate dependencies that are satisfied by the linear invocation indexes.
		//
		for (@NonNull Region region : orderedRegions) {
			//			int earliestPassedConnectionSourceIndex = region.getEarliestPassedConnectionSourceIndex();
			int earliestIndex = region.getIndexes().get(0);
			List<@NonNull DatumConnection<?>> redundantConnections = null;
			for (@NonNull DatumConnection<?> usedConnection : region.getIncomingConnections()) {
				if (!usedConnection.isPassed(region)) {
					boolean isRedundant = true;
					for (@NonNull Region sourceRegion : usedConnection.getSourceRegions()) {
						List<@NonNull Integer> indexes = sourceRegion.getIndexes();
						int lastIndex = indexes.get(indexes.size()-1);
						if (lastIndex >= earliestIndex) {
							isRedundant = false;
							break;
						}
					}
					if (isRedundant) {
						if (redundantConnections == null) {
							redundantConnections = new ArrayList<>();
						}
						redundantConnections.add(usedConnection);
					}
				}
			}
			if (redundantConnections != null) {
				for (@NonNull DatumConnection<?> redundantConnection : redundantConnections) {
					redundantConnection.removeTargetRegion(region);
				}
			}
		}
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduledRegion.writeDebugGraphs("7-pruned", true, true, false);
		}

		boolean noLateConsumerMerge = scheduledRegion.getSchedulerConstants().isNoLateConsumerMerge();
		if (!noLateConsumerMerge) {
			lateMerge(scheduledRegion, orderedRegions, typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		}

		for (@NonNull Region region : orderedRegions) {
			region.computeCheckedOrEnforcedEdges(typedModel2property2predicatedEdges, typedModel2property2realizedEdges);
		}
		/*	suspended - just an optimization - needs more hierarchical consideration
		//
		//	Redirect ordered consumers to depend on each other's heads thereby respecting the ordering and
		//	making earlier results available to later mappings.
		//
		if (region2orderingEdge2usedEdges != null) {
			for (@SuppressWarnings("null")@NonNull Region commonRegion : region2orderingEdge2usedEdges.keySet()) {
				@SuppressWarnings("null")@NonNull Map<Edge, Set<Edge>> orderingEdge2usedEdges = region2orderingEdge2usedEdges.get(commonRegion);
				convertConsumedOrdering(commonRegion, orderingEdge2usedEdges);
			}
		}
		writeDOTfile("-5-reconsume");
		writeGraphMLfile("-5-reconsume"); */
		/*	suspended - just an optimization - needs more hierarchical consideration
		//
		//	Merge again now that dependencies may be available.
		//
		Region2Depth region2depths = new Region2Depth();
		List<Region> sortedRegions = region2depths.getSortedRegions(getRegions());
		for (Region calledRegion : sortedRegions) {
			List<List<Node>> headNodeGroups = calledRegion.getHeadNodeGroups();
			if ((headNodeGroups.size() == 1) && !(calledRegion instanceof CompositionRegion)) {
				Region callingRegion = null;
				boolean isMergeable = true;
				for (Node headNode : headNodeGroups.get(0)) {
					for (Node callingNode : headNode.getPassedBindingSources()) {
						if (callingRegion == null) {
							callingRegion = callingNode.getRegion();
						}
						else if (callingRegion != callingNode.getRegion()) {
							isMergeable = false;
							break;
						}
					}
				}
				if ((callingRegion != null) && isMergeable && callingRegion.isLateMergeable(calledRegion, region2depths)) {
					Map<Node, Node> node2mergedNode = callingRegion.canMerge(calledRegion, region2depths, true);
					if (node2mergedNode != null) {
						MergedRegion mergedRegion;
						if (callingRegion instanceof MergedRegion) {
							mergedRegion = (MergedRegion)callingRegion;
						}
						else {
							getRegions().remove(calledRegion);
							mergedRegion = new MergedRegion((MergeableRegion)callingRegion);
							Region invokingRegion = callingRegion.getInvokingRegion();
							assert invokingRegion != null;
							List<Region> regions = invokingRegion.getRegions();
							int index = regions.indexOf(callingRegion);
							assert index >= 0;
							regions.set(index, mergedRegion);
//							mergedRegion.writeDOTfile("-6-merged");
//							mergedRegion.writeGraphMLfile("-6-merged");
						}
						mergedRegion.mergeRegion(calledRegion, node2mergedNode);
						getRegions().remove(calledRegion);
						mergedRegion.writeDOTfile("-6-merged");
						mergedRegion.writeGraphMLfile("-6-merged");
						mergedRegion.resolveRecursion();
						mergedRegion.writeDOTfile("-7-merged");
						mergedRegion.writeGraphMLfile("-7-merged");
						region2depths.addRegion(mergedRegion);
					}
				}
			}
		} */
		//
		//	Propagate early results down to later mappings that need them.
		//
		/*		for (Region calledRegion : sortedRegions) {
			calledRegion.refineBindings(this);
		} */
		/*		HashMap<Node, List<Node>> outerNode2outerNodes = new HashMap<>();
		Map<Region, Map<NavigationEdge, NavigationEdge>> region2innerEdge2outerEdge = new HashMap<>();
		propagateCommonNavigations(rootContainmentRegion, outerNode2outerNodes, region2innerEdge2outerEdge);
		for (@SuppressWarnings("null")@NonNull Map.Entry<Region, Map<NavigationEdge, NavigationEdge>> entry1 : region2innerEdge2outerEdge.entrySet()) {
			Region innerRegion = entry1.getKey();
			for (@SuppressWarnings("null")@NonNull NavigationEdge innerEdge : entry1.getValue().keySet()) {
				Node innerNode = innerEdge.getTarget();
				List<NavigationEdge> bestPath = null;
				for (@SuppressWarnings("null")@NonNull List<Node> headGroup : innerRegion.getHeadNodeGroups()) {
					for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
						bestPath = getBestPath(bestPath, getPath(headNode, innerNode, new HashSet<>()));
					}
				}
				assert bestPath != null;
				for (@SuppressWarnings("null")@NonNull Node node : innerRegion.getNodes()) {
					for (@SuppressWarnings("null")@NonNull Edge edge : node.getIncomingPassedBindingEdges()) {	// ??? joins
						assert edge.getTarget() == node;
						Region outerRegion = edge.getSource().getRegion();
						Map<Edge, Edge> innerEdge2outerEdge = createPath(edge.getSource(), bestPath);
						for (@SuppressWarnings("null")@NonNull Map.Entry<Edge, Edge> entry : innerEdge2outerEdge.entrySet()) {
							Edge outerEdge = entry.getValue();
							Edge innerEdge2 = entry.getKey();
							Edges.USED_BINDING.createEdge(outerRegion, outerEdge.getTarget(), innerEdge2.getName(), innerEdge2.getTarget());
						}
//						innerNode2outerNode.put(node, edge.getSource());
//						propagateSharedNodes(edge.getSource(), node, innerNode2outerNode);




//						propagatePassedEdges(edge.getSource(), node, innerNode2outerNode, innerNode2edge);
					}
				}
			} */
		/*			Map<Node, Edge> innerNode2edge = new HashMap<>();
			Map<Node, Node> innerNode2outerNode = new HashMap<>();
//			for (NavigationEdge innerEdge : entry1.getValue().keySet()) {
//				innerNode2edge.put(innerEdge.getSource(), innerEdge);
//			}
			for (Node node : innerRegion.getNodes()) {
				for (Edge edge : node.getIncomingPassedBindingEdges()) {	// ??? joins
					assert edge.getTarget() == node;

					Node outerNode = createPath(edge.getRegion(), bestEdge);

					innerNode2outerNode.put(node, edge.getSource());
					propagateSharedNodes(edge.getSource(), node, innerNode2outerNode);




					propagatePassedEdges(edge.getSource(), node, innerNode2outerNode, innerNode2edge);
				}
			}
			for (Map.Entry<NavigationEdge, NavigationEdge> entry2 : entry1.getValue().entrySet()) {
				NavigationEdge innerEdge = entry2.getKey();
				NavigationEdge outerEdge = entry2.getValue();
				propagateEdge(outerEdge.getSource(), innerEdge.getSource());
				propagateEdge(outerEdge.getTarget(), innerEdge.getTarget());
			} */
		//		}
		//		firstPassRegion.writeDOTfile();
		//		firstPassRegion.writeGraphMLfile();
		//
		//		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
		//			writeDebugGraphs("9-final", true, true, true);
		//		}
	}

	public @NonNull ScheduledRegion createRootRegion(@NonNull Iterable<@NonNull ? extends Region> allRegions) {
		ScheduledRegion rootRegion = null;
		for (@NonNull Region region : Lists.newArrayList(allRegions)) {
			if (region.getInvokingRegion() == null) {
				if (rootRegion == null) {
					rootRegion = new RootScheduledRegion2(rootName, region);
				}
				region.setInvokingRegion(rootRegion);
			}
		}
		assert rootRegion != null;
		return rootRegion;
	}

	protected void createSchedule(@NonNull ScheduledRegion rootScheduledRegion) {
		//
		//	Replace multi-region recursions by single nested region recursions.
		//
		List<@NonNull ScheduledRegion> allScheduledRegions = new ArrayList<>();
		allScheduledRegions.add(rootScheduledRegion);
		//		CyclesAnalyzer cyclesAnalyzer = new CyclesAnalyzer(rootScheduledRegion, rootScheduledRegion.getCallableRegions());
		//		List<@NonNull RegionCycle> regionCycles = cyclesAnalyzer.getOrderedCycles();
		//		if (regionCycles != null) {
		/*			for (@NonNull RegionCycle regionCycle : regionCycles) {
				Iterable<@NonNull Region> regions = regionCycle.getRegions();
				if (Iterables.size(regions) == 1) {
					regions.iterator().next().setIsCyclic();
				}
				else {
					CyclicScheduledRegion cyclicRegion = createCyclicRegion(regions);
					allScheduledRegions.add(cyclicRegion);
				}
			} */
		//		}
		//		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
		//			rootScheduledRegion.writeDebugGraphs("4-cycles", true, true, false);
		//		}
		//
		//	Create the schedule for each directed acyclic scheduled region.
		//
		/*		for (@NonNull Region region : rootScheduledRegion.getCallableRegions()) {
			Splitter splitter = new Splitter(region);
			Split split = splitter.split();
			if (split != null) {
				//				split.install();
			}
		} */
		//
		//	Create the schedule for each directed acyclic scheduled region.
		//
		for (@NonNull ScheduledRegion scheduledRegion : allScheduledRegions) {
			createLocalSchedule(scheduledRegion);
		}
		ScheduleIndexer scheduleIndexer = new ScheduleIndexer(rootScheduledRegion);
		scheduleIndexer.schedule(rootScheduledRegion);
		for (@NonNull ScheduledRegion scheduledRegion : allScheduledRegions) {
			createLocalSchedule2(scheduledRegion, scheduleIndexer.getOrdering());
		}
	}

	private void lateMerge(@NonNull ScheduledRegion scheduledRegion, @NonNull List<@NonNull Region> orderedRegions,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		Map<@NonNull Region, @NonNull List<@NonNull Region>> newRegion2oldRegions = LateConsumerMerger.merge(scheduledRegion);
		for (Map.Entry<@NonNull Region, @NonNull List<@NonNull Region>> entry : newRegion2oldRegions.entrySet()) {
			Region newRegion = entry.getKey();
			List<@NonNull Region> oldRegions = entry.getValue();
			assert oldRegions.size() >= 2;
			int orderedRegionIndex = orderedRegions.indexOf(oldRegions.get(0));
			for (@NonNull Region oldRegion : oldRegions) {
				orderedRegions.remove(oldRegion);
				oldRegion.setInvokingRegion(null);
			}
			orderedRegions.add(orderedRegionIndex, newRegion);
			QVTscheduleConstants.POLLED_PROPERTIES.println("building indexes for " + newRegion + " " + newRegion.getIndexRangeText());
			newRegion.buildPredicatedNavigationEdgesIndex(typedModel2property2predicatedEdges);
			newRegion.buildRealizedNavigationEdgesIndex(typedModel2property2realizedEdges);
		}
	}

	protected void splitRegions() {
	}

	public @NonNull ScheduledRegion transform(@NonNull MultiRegion multiRegion) throws CompilerChainException {
		Iterable<@NonNull ? extends Region> activeRegions = multiRegion.getActiveRegions();
		//		for (@NonNull Region region : activeRegions) {
		//			System.out.println("activeRegions " + region);
		//		}
		Iterable<@NonNull MappingRegion> partitionedRegions = Partitioner.partition(problemHandler, activeRegions);
		if (!Iterables.isEmpty(partitionedRegions)) {
			//			for (@NonNull Region region : partitionedRegions) {
			//				System.out.println("partitionedRegions " + region);
			//			}
			activeRegions = partitionedRegions;
		}
		ScheduledRegion rootRegion = createRootRegion(activeRegions);
		((RootScheduledRegion2)rootRegion).createSchedule();
		createSchedule(rootRegion);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			rootRegion.writeDebugGraphs("9-final", true, true, true);
		}
		return rootRegion;
	}
}
