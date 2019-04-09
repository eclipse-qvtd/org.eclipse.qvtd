/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * The MappingPartitioner supervises the partitioning of a mapping region into a 'tree' of partitions that avoid
 * scheduling hazards. Each partition describes the future content of a micromapping. For non-degerate cases the 'tree'
 * comprises a sequence of Speculation, Speculating, Speculated partitions followed by zero or more concurrent Edge partitions.
 *
 * The Speculation partition establishes the basic pattern of inputs objects that justify creation of a speculated trace object.
 *
 * The Speculating partition interacts with other Speculations to establish that all predicates are satisfied.
 *
 * The Speculated partition creates the immediate corollaries of the successful speculation.
 *
 * The Edge partitions realize further edges once their targets are available.
 *
 * Each MappingPartitioner collaborates with an overall TransformationPartitioner for global analyses.
 */
public class MappingPartitioner implements Nameable
{
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The overall transformation partitioner providing global analysis results.
	 */
	//	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;

	/**
	 * The overall transformation analysis results.
	 */
	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;

	/**
	 * The region to be partitioned.
	 */
	protected final @NonNull RegionAnalysis regionAnalysis;

	/**
	 * The region to be partitioned.
	 */
	protected final @NonNull MappingRegion region;

	/**
	 * Dynamically growing list of constant edges that have been traversed by a partition.
	 */
	private final @NonNull Set<@NonNull Edge> alreadyConstantEdges = new HashSet<>();

	/**
	 * Dynamically growing list of loaded edges that have been traversed by a partition.
	 */
	private final @NonNull Set<@NonNull Edge> alreadyLoadedEdges = new HashSet<>();

	/**
	 * Dynamically growing list of edges that have been checked (predicated or speculated) by a partition.
	 */
	private final @NonNull Set<@NonNull Edge> alreadyCheckedEdges = new HashSet<>();

	/**
	 * Dynamically growing list of nodes that have been checked (predicated or speculated) by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyCheckedNodes = new HashSet<>();

	/**
	 * Dynamically growing map of edges that have been realized to the partition that realizes them.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull BasicPartition> alreadyRealizedEdges = new HashMap<>();

	/**
	 * Dynamically growing list of nodes that have been realized by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyRealizedNodes = new HashSet<>();

	private final @NonNull Map<@NonNull Edge, @NonNull List<@NonNull BasicPartition>> debugEdge2partitions = new HashMap<>();

	public MappingPartitioner(@NonNull TransformationPartitioner transformationPartitioner, @NonNull RegionAnalysis regionAnalysis) {
		this.scheduleManager = transformationPartitioner.getScheduleManager();
		//		this.partitionedTransformationAnalysis = transformationPartitioner.getPartitionedTransformationAnalysis();
		this.transformationAnalysis = transformationPartitioner.getTransformationAnalysis();
		this.regionAnalysis = regionAnalysis;
		this.region = (MappingRegion) regionAnalysis.getRegion();
		//
	}

	public boolean addCheckedNode(@NonNull Node node) {
		return alreadyCheckedNodes.add(node);
	}

	public void addEdge(@NonNull Edge edge, @NonNull Role newEdgeRole, @NonNull BasicPartition partition) {
		if (newEdgeRole == Role.CONSTANT) {
			alreadyConstantEdges.add(edge);
		}
		else if (newEdgeRole == Role.LOADED) {
			alreadyLoadedEdges.add(edge);
		}
		else if (newEdgeRole == Role.PREDICATED) {
			alreadyCheckedEdges.add(edge);
		}
		else if (newEdgeRole == Role.SPECULATED) {
			alreadyCheckedEdges.add(edge);
		}
		else if (newEdgeRole == Role.REALIZED) {
			alreadyRealizedEdges.put(edge, partition);
		}
		List<@NonNull BasicPartition> partitions = debugEdge2partitions.get(edge);
		if (partitions == null) {
			partitions = new ArrayList<>();
			debugEdge2partitions.put(edge, partitions);
		}
		assert !partitions.contains(partition);
		partitions.add(partition);
	}

	public void addProblem(@NonNull CompilerProblem problem) {
		scheduleManager.addProblem(problem);
	}

	public boolean addRealizedNode(@NonNull Node node) {
		return alreadyRealizedNodes.add(node);
	}

	public @Nullable Node basicGetDispatchNode() {
		return regionAnalysis.basicGetDispatchNode();
	}

	public @Nullable SuccessEdge basicGetGlobalSuccessEdge(@NonNull Node traceNode) {
		return regionAnalysis.basicGetGlobalSuccessEdge(traceNode);
	}

	public @Nullable Node basicGetGlobalSuccessNode(@NonNull Node traceNode) {
		return regionAnalysis.basicGetGlobalSuccessNode(traceNode);
	}

	public @Nullable SuccessEdge basicGetLocalSuccessEdge(@NonNull Node traceNode) {
		return regionAnalysis.basicGetLocalSuccessEdge(traceNode);
	}

	public @Nullable Node basicGetLocalSuccessNode(@NonNull Node traceNode) {
		return regionAnalysis.basicGetLocalSuccessNode(traceNode);
	}

	private void check(/*boolean isInfallible*/) {
		/*	Set<@NonNull Edge> infallibleEdges = null;
		Set<@NonNull Node> infallibleNodes = null;
		if (isInfallible) {
			infallibleEdges = new HashSet<>();
			infallibleNodes = new HashSet<>();
			for (@NonNull Edge edge : regionAnalysis.getFallibleEdges()) {
				infallibleEdges.add(edge);
				infallibleNodes.add(QVTscheduleUtil.getTargetNode(edge));
			}
		} */
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (((node.isSpeculated() && !node.isHead()) || node.isRealized()) && !hasRealizedNode(node)) {
				//	if ((infallibleNodes == null) || !infallibleNodes.contains(node)) {
				addProblem(CompilerUtil.createRegionError(region, "Should have realized " + node));
				//	}
			}
		}
		Set<@NonNull Edge> allPrimaryEdges = new HashSet<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (!edge.isSecondary()) {
				allPrimaryEdges.add(edge);
				if (edge.isRealized() && !hasRealizedEdge(edge) && !edge.isExpression()) {
					//	if ((infallibleEdges == null) || !infallibleEdges.contains(edge)) {
					addProblem(CompilerUtil.createRegionError(region, "Should have realized " + edge));
					//	}
				}
			}
		}
		//
		Set<@NonNull Node> deadNodes = computeDeadNodes(QVTscheduleUtil.getOwnedNodes(region));
		Set<@NonNull Edge> deadEdges = computeDeadEdges(deadNodes);
		allPrimaryEdges.removeAll(deadEdges);
		Set<@NonNull Edge> partitionedEdges = new HashSet<>(debugEdge2partitions.keySet());
		if (!partitionedEdges.equals(allPrimaryEdges)) {
			Set<@NonNull Edge> extraEdgesSet = Sets.newHashSet(partitionedEdges);
			CompilerUtil.removeAll(extraEdgesSet, allPrimaryEdges);
			for (@NonNull Edge edge : extraEdgesSet) {
				if (!edge.isSecondary()) {
					@SuppressWarnings("unused")
					List<@NonNull BasicPartition> extraPartitions = debugEdge2partitions.get(edge);
					addProblem(CompilerUtil.createRegionWarning(region, "Extra " + edge));
				}
			}
			Set<@NonNull Edge> missingEdgesSet = Sets.newHashSet(allPrimaryEdges);
			missingEdgesSet.removeAll(partitionedEdges);
			for (@NonNull Edge edge : missingEdgesSet) {
				if (!(edge instanceof NavigableEdge) || (transformationAnalysis.getCorollaryOf((NavigableEdge)edge) == null)) {// && !isDead(edge)) {
					addProblem(CompilerUtil.createRegionWarning(region, "Missing " + edge));
				}
			}
		}
	}

	private @NonNull Set<@NonNull Edge> computeDeadEdges(@NonNull Iterable<@NonNull Node> deadNodes) {
		Set<@NonNull Edge> deadEdges = new HashSet<>();
		for (@NonNull Node node : deadNodes) {
			Iterables.addAll(deadEdges, QVTscheduleUtil.getIncomingEdges(node));
			Iterables.addAll(deadEdges, QVTscheduleUtil.getOutgoingEdges(node));
		}
		return deadEdges;
	}

	private @NonNull Set<@NonNull Node> computeDeadNodes(@NonNull Iterable<@NonNull Node> nodes) {
		Set<@NonNull Node> deadNodes = new HashSet<>();
		Set<@NonNull Node> moreDeadNodes = null;
		for (@NonNull Node node : nodes) {
			if (!node.isHead() && isDead(node, null)) {
				if (moreDeadNodes == null) {
					moreDeadNodes = new HashSet<>();
				}
				moreDeadNodes.add(node);
			}
		}
		if (moreDeadNodes == null) {
			return deadNodes;
		}
		while (moreDeadNodes.size() > 0) {
			deadNodes.addAll(moreDeadNodes);
			List<@NonNull Node> moreDeadNodesList = new ArrayList<>(moreDeadNodes);
			moreDeadNodes = null;
			for (@NonNull Node deadNode : moreDeadNodesList) {
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(deadNode)) {
					Node sourceNode = edge.getEdgeSource();
					if (!sourceNode.isHead() && isDead(sourceNode, deadNodes)) {
						if (moreDeadNodes == null) {
							moreDeadNodes = new HashSet<>();
						}
						moreDeadNodes.add(sourceNode);
					}
				}
			}
			if (moreDeadNodes == null) {
				break;
			}
		}
		return deadNodes;
	}

	//	public @NonNull Iterable<@NonNull Edge> getAlreadyPredicatedEdges() {
	//		return alreadyPredicatedEdges;
	//	}

	public @NonNull Iterable<@NonNull Edge> getAlreadyRealizedEdges() {
		return alreadyRealizedEdges.keySet();
	}

	public @NonNull Iterable<@NonNull Node> getConstantInputNodes() {
		return regionAnalysis.getConstantInputNodes();
	}

	public @NonNull Iterable<@NonNull Node> getConstantOutputNodes() {
		return regionAnalysis.getConstantOutputNodes();
	}

	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> getConsumedClassAnalyses() {
		return regionAnalysis.getConsumedClassAnalyses();
	}

	public @Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> getConsumedPropertyAnalyses() {
		return regionAnalysis.getConsumedPropertyAnalyses();
	}

	public @NonNull Iterable<@NonNull Node> getExecutionNodes() {
		return Iterables.concat(getPredicatedExecutionNodes(), getRealizedExecutionNodes());
	}

	public @NonNull SuccessEdge getGlobalSuccessEdge(@NonNull Node traceNode) {
		return regionAnalysis.getGlobalSuccessEdge(traceNode);
	}

	public @NonNull Node getGlobalSuccessNode(@NonNull Node traceNode) {
		return regionAnalysis.getGlobalSuccessNode(traceNode);
	}

	public @NonNull SuccessEdge getLocalSuccessEdge(@NonNull Node traceNode) {
		return regionAnalysis.getLocalSuccessEdge(traceNode);
	}

	public @NonNull Node getLocalSuccessNode(@NonNull Node traceNode) {
		return regionAnalysis.getLocalSuccessNode(traceNode);
	}

	@Override
	public String getName() {
		return region.getName();
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getOldPrimaryNavigableEdges() {
		return regionAnalysis.getOldPrimaryNavigableEdges();
	}

	//	public @NonNull PartitionedTransformationAnalysis getPartitionedTransformationAnalysis() {
	//		return partitionedTransformationAnalysis;
	//	}

	public @NonNull Iterable<@NonNull Edge> getPredicatedEdges() {
		return regionAnalysis.getPredicatedEdges();
	}

	public @NonNull List<@NonNull Node> getPredicatedExecutionNodes() {
		List<@NonNull Node> predicatedExecutionNodes = new ArrayList<>();
		for (@NonNull Node node : getPredicatedMiddleNodes()) {
			if (QVTrNameGenerator.TRACECLASS_PROPERTY_NAME.equals(node.getName())) {
				assert node.isTrace();
				predicatedExecutionNodes.add(node);
			}
		}
		return predicatedExecutionNodes;
	}

	public @NonNull Iterable<@NonNull Node> getPredicatedMiddleNodes() {
		return regionAnalysis.getPredicatedMiddleNodes();
	}

	public @NonNull Iterable<@NonNull Node> getPredicatedOutputNodes() {
		return regionAnalysis.getPredicatedOutputNodes();
	}

	public @NonNull List<@NonNull Node> getPredicatedWhenNodes() {
		List<@NonNull Node> predicatedWhenNodes = new ArrayList<>();
		for (@NonNull Node node : getPredicatedMiddleNodes()) {
			if (node.getName().startsWith("when_")) {
				predicatedWhenNodes.add(node);
			}
		}
		return predicatedWhenNodes;
	}

	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> getProducedClassAnalyses() {
		return regionAnalysis.getProducedClassAnalyses();
	}

	public @Nullable Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis>> getProducedPropertyAnalyses() {
		return regionAnalysis.getProducedPropertyAnalyses();
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getRealizedEdges() {
		return regionAnalysis.getRealizedEdges();
	}

	public @NonNull List<@NonNull Node> getRealizedExecutionNodes() {
		List<@NonNull Node> realizedExecutionNodes = new ArrayList<>();
		for (@NonNull Node node : getRealizedMiddleNodes()) {
			if (QVTrNameGenerator.TRACECLASS_PROPERTY_NAME.equals(node.getName())) {
				realizedExecutionNodes.add(node);
			}
			//			else if (QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME.equals(node.getName())) {
			//				realizedExecutionNodes.add(node);
			//			}
		}
		return realizedExecutionNodes;
	}

	public @NonNull Iterable<@NonNull Node> getRealizedMiddleNodes() {
		return regionAnalysis.getRealizedMiddleNodes();
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getRealizedOutputEdges() {
		return regionAnalysis.getRealizedOutputEdges();
	}

	public @NonNull Iterable<@NonNull Node> getRealizedOutputNodes() {
		return regionAnalysis.getRealizedOutputNodes();
	}

	public @NonNull List<@NonNull Node> getRealizedWhereNodes() {
		List<@NonNull Node> realizedWhereNodes = new ArrayList<>();
		for (@NonNull Node node : getRealizedMiddleNodes()) {
			if (node.getName().startsWith("where_")) {
				realizedWhereNodes.add(node);
			}
		}
		return realizedWhereNodes;
	}

	public @Nullable BasicPartition getRealizingPartition(@NonNull Edge edge) {
		return alreadyRealizedEdges.get(edge);
	}

	public @NonNull MappingRegion getRegion() {
		return region;
	}

	public @NonNull RegionAnalysis getRegionAnalysis() {
		return regionAnalysis;
	}

	protected @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull Iterable<@NonNull SuccessEdge> getSuccessEdges() {
		return regionAnalysis.getSuccessEdges();
	}

	public @Nullable Iterable<@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis>> getSuperProducedClassAnalyses() {
		return regionAnalysis.getSuperProducedClassAnalyses();
	}

	public @NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> getClassAnalysis(@NonNull Node traceNode) {
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(traceNode);
		return transformationAnalysis.getClassAnalysis(classDatum);
	}

	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return regionAnalysis.getTraceEdge(node);
	}

	public @NonNull Node getTraceNode() {
		List<@NonNull Node> traceNodes = getTraceNodes();
		assert traceNodes.size() == 1;
		return ClassUtil.nonNullState(traceNodes.get(0));
	}

	public @NonNull List<@NonNull Node> getTraceNodes() {
		return regionAnalysis.getTraceNodes();
	}

	public boolean hasCheckedEdge(@NonNull Edge edge) {
		return alreadyCheckedEdges.contains(edge);
	}

	public boolean hasCheckedNode(@NonNull Node node) {
		return alreadyCheckedNodes.contains(node);
	}

	public boolean hasConstantEdge(@NonNull Edge edge) {
		return alreadyConstantEdges.contains(edge);
	}

	public boolean hasLoadedEdge(@NonNull Edge edge) {
		return alreadyLoadedEdges.contains(edge);
	}

	public boolean hasRealizedEdge(@NonNull Edge edge) {
		return alreadyRealizedEdges.containsKey(edge);
	}

	public boolean hasRealizedNode(@NonNull Node node) {
		return alreadyRealizedNodes.contains(node);
	}

	public @Nullable List<@NonNull Region> getCorollaryOf(@NonNull NavigableEdge edge) {
		return transformationAnalysis.getCorollaryOf(edge);
	}

	public boolean isCyclic(@NonNull Node traceNode) {
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(traceNode);
		return transformationAnalysis.isCyclic(classDatum);
	}

	private boolean isDead(@NonNull Node node, @Nullable Set<@NonNull Node> knownDeadNodes) {
		if (node.isHead()) {
			return false;
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if ((edge.isCast() || edge.isNavigation())) {
				if ((knownDeadNodes == null) || !knownDeadNodes.contains(edge.getEdgeSource())) {
					return false;
				}
			}
			else if (edge.isPredicate()) {
				if ((knownDeadNodes == null) || !knownDeadNodes.contains(edge.getEdgeSource())) {
					return false;
				}
			}
			//			else if (edge.isExpression() && edge.isPredicated()) {
			//				return false;
			//			}
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
			if (edge.isCast() || edge.isNavigation() || edge.isExpression()) {
				if ((knownDeadNodes == null) || !knownDeadNodes.contains(edge.getEdgeTarget())) {
					return false;
				}
			}
		}
		return true;
	}

	/*	private boolean isDead(@NonNull Edge edge) {
		if (!edge.isExpression()) {
			return false;
		}
		Node node = edge.getTarget();
		for (@NonNull Edge incomingEdge : node.getIncomingEdges()) {
			if ((incomingEdge != edge) && incomingEdge.isMatched()) {
				return false;
			}
		}
		for (@NonNull Edge outgoingEdge : node.getOutgoingEdges()) {
			if (!isDead(outgoingEdge)) {
				return false;
			}
		}
		return true;
	} */

	public @NonNull Iterable<@NonNull PartitionAnalysis> partition(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		if ((region instanceof DispatchRegion) || (region instanceof VerdictRegion)) {
			return Collections.singletonList(new NonPartitionFactory(this).createPartitionAnalysis(partitionedTransformationAnalysis));
		}
		boolean isCyclic = transformationAnalysis.isCyclic(regionAnalysis);
		//	boolean isInfallible = false;
		//	if (cycleAnalysis != null) {
		//		isInfallible = cycleAnalysis.isInfallible();
		//	}
		boolean hasPredication = false;
		boolean needsActivator = false;
		boolean useActivators = scheduleManager.useActivators();
		if (useActivators) {		// QVTr
			List<@NonNull Node> predicatedWhenNodes = getPredicatedWhenNodes();
			hasPredication = predicatedWhenNodes.size() > 0;
			List<@NonNull Node> realizedExecutionNodes = getRealizedExecutionNodes();
			if (realizedExecutionNodes.size() > 0)	{			// A 'single' realized "trace" node is a boring no-override top activation.
				needsActivator = true;
			}
			else {
				needsActivator = false;
			}
		}
		else {		// legacy QVTc
			Iterable<@NonNull Node> predicatedMiddleNodes = getPredicatedMiddleNodes();
			hasPredication = !Iterables.isEmpty(predicatedMiddleNodes);
		}
		boolean needsSpeculation = isCyclic && hasPredication; //(dispatchedTraceNodes2.isEmpty() ? !predicatedMiddleNodes.isEmpty() : !predicatedMiddleNodes.containsAll(dispatchedTraceNodes2));
		//
		//	Create the partitioned regions
		//
		List<@NonNull PartitionAnalysis> newPartitionAnalyses = new ArrayList<>();
		if (needsActivator) {
			//
			//	Create an activator to make a QVTr top relation behave as a non-top relation.
			//
			newPartitionAnalyses.add(new ActivatorPartitionFactory(this).createPartitionAnalysis(partitionedTransformationAnalysis));
		}
		if (!needsSpeculation) {
			//
			//	If speculation is not needed just add the functionality as a single region.
			//
			if (newPartitionAnalyses.isEmpty()) {		// i.e. a QVTr non top relation - re-use as is
				newPartitionAnalyses.add(new NonPartitionFactory(this).createPartitionAnalysis(partitionedTransformationAnalysis));
			}
			else {							// i.e. a QVTr top relation - create a residue to finish off the activator
				newPartitionAnalyses.add(new ResidualPartitionFactory(this).createPartitionAnalysis(partitionedTransformationAnalysis));
			}
		}
		else {								// cycles may need speculation and partitioning into isolated actions
			//			if (isInfallible) {
			//				regionAnalysis.getFallibilities()
			//			}
			if (useActivators) {
				regionAnalysis.createLocalSuccess();
			}
			BasicPartitionAnalysis localPredicatePartition = new LocalPredicatePartitionFactory(this, useActivators).createPartitionAnalysis(partitionedTransformationAnalysis);
			BasicPartitionAnalysis globalPredicatePartition = new GlobalPredicatePartitionFactory(this).createPartitionAnalysis(partitionedTransformationAnalysis);
			BasicPartitionAnalysis speculatedPartition = new SpeculatedPartitionFactory(this).createPartitionAnalysis(partitionedTransformationAnalysis);
			newPartitionAnalyses.add(localPredicatePartition);
			newPartitionAnalyses.add(globalPredicatePartition);
			newPartitionAnalyses.add(speculatedPartition);
			if (!useActivators) {
				globalPredicatePartition.addExplicitPredecessor(localPredicatePartition);
				speculatedPartition.addExplicitPredecessor(globalPredicatePartition);
			}
			//
			//	Create an AssignmentRegion for each still to-be-realized edge to an output which may well result
			//  in two realized edges.
			//
			for (@NonNull NavigableEdge outputEdge : getRealizedOutputEdges()) {
				if (!hasRealizedEdge(outputEdge)) {
					newPartitionAnalyses.add(new AssignmentPartitionFactory(this, outputEdge).createPartitionAnalysis(partitionedTransformationAnalysis));
				}
			}
			//
			//	Create an AssignmentRegion for each still to-be-realized edge.
			//
			for (@NonNull NavigableEdge edge : getRealizedEdges()) {
				if (!hasRealizedEdge(edge)) {
					newPartitionAnalyses.add(new AssignmentPartitionFactory(this, edge).createPartitionAnalysis(partitionedTransformationAnalysis));
				}
			}
		}
		//		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
		//			for (@NonNull PartitionAnalysis partitionAnalysis : newPartitionAnalyses) {
		//				scheduleManager.writeDebugGraphs(partitionAnalysis.getPartition(), null);
		//			}
		//		}
		if (newPartitionAnalyses.size() > 1) {		// FIXME shouldn't this work anyway when no partitioning was needed?
			check(/*isInfallible*/);
		}
		return newPartitionAnalyses;
	}

	@Override
	public String toString() {
		return region.getName();
	}
}
