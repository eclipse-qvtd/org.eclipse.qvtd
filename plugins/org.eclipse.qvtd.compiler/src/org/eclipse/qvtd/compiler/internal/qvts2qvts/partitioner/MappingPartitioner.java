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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
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
import com.google.common.collect.Lists;
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
	protected final @NonNull RegionsAnalysis<@NonNull Partition> regionsPartitionAnalysis;

	/**
	 * The overall transformation analysis results.
	 */
	protected final @NonNull TransformationAnalysis transformationAnalysis;

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
	 * Dynamically growing list of edges that have been predicated by a partition.
	 */
	private final @NonNull Set<@NonNull Edge> alreadyPredicatedEdges = new HashSet<>();

	/**
	 * Dynamically growing list of nodes that have been predicated by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyPredicatedNodes = new HashSet<>();

	/**
	 * Dynamically growing map of edges that have been realized to the partition that realizes them.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull AbstractPartialPartition> alreadyRealizedEdges = new HashMap<>();

	/**
	 * Dynamically growing list of nodes that have been realized by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyRealizedNodes = new HashSet<>();

	private final @NonNull Map<@NonNull Edge, @NonNull List<@NonNull AbstractPartialPartition>> debugEdge2partitions = new HashMap<>();

	public MappingPartitioner(@NonNull TransformationPartitioner transformationPartitioner, @NonNull RegionAnalysis regionAnalysis) {
		this.scheduleManager = transformationPartitioner.getScheduleManager();
		this.regionsPartitionAnalysis = transformationPartitioner;
		this.transformationAnalysis = transformationPartitioner.getTransformationAnalysis();
		this.regionAnalysis = regionAnalysis;
		this.region = (MappingRegion) regionAnalysis.getRegion();
		//
	}

	public void addEdge(@NonNull Edge edge, @NonNull Role newEdgeRole, @NonNull AbstractPartialPartition partition) {
		if (newEdgeRole == Role.CONSTANT) {
			alreadyConstantEdges.add(edge);
		}
		else if (newEdgeRole == Role.LOADED) {
			alreadyLoadedEdges.add(edge);
		}
		else if (newEdgeRole == Role.PREDICATED) {
			alreadyPredicatedEdges.add(edge);
		}
		else if (newEdgeRole == Role.SPECULATED) {
			alreadyPredicatedEdges.add(edge);
		}
		else if (newEdgeRole == Role.REALIZED) {
			alreadyRealizedEdges.put(edge, partition);
		}
		List<@NonNull AbstractPartialPartition> partitions = debugEdge2partitions.get(edge);
		if (partitions == null) {
			partitions = new ArrayList<>();
			debugEdge2partitions.put(edge, partitions);
		}
		assert !partitions.contains(partition);
		partitions.add(partition);
	}

	public boolean addPredicatedNode(@NonNull Node node) {
		return alreadyPredicatedNodes.add(node);
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
					List<@NonNull AbstractPartialPartition> extraPartitions = debugEdge2partitions.get(edge);
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

	private @NonNull ActivatorPartition createActivatorPartition() {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		return new ActivatorPartition(this, reachabilityForest);
	}

	private @NonNull AssignmentPartition createAssignmentPartition(@NonNull ReachabilityForest reachabilityForest, @NonNull Edge outputEdge) {
		return new AssignmentPartition(this, reachabilityForest, outputEdge);
	}

	private @NonNull NonPartition createNonPartition() {
		return new NonPartition(this);
	}

	private @NonNull ResidualPartition createResidualPartition() {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		return new ResidualPartition(this, reachabilityForest);
	}

	private @NonNull SpeculatedPartition createSpeculatedPartition() {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		return new SpeculatedPartition(this, reachabilityForest);
	}

	private @NonNull SpeculatingPartition createSpeculatingPartition(/*boolean isInfallible*/) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		return new SpeculatingPartition(this, reachabilityForest/*, isInfallible*/);
	}

	private @NonNull SpeculationPartition createSpeculationPartition() {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getSpeculationReachabilityRootNodes(), getAvailableNavigableEdges());
		return new SpeculationPartition(this, reachabilityForest);
	}

	//	public @NonNull Iterable<@NonNull Edge> getAlreadyPredicatedEdges() {
	//		return alreadyPredicatedEdges;
	//	}

	public @NonNull Iterable<@NonNull Edge> getAlreadyRealizedEdges() {
		return alreadyRealizedEdges.keySet();
	}

	/**
	 * Return the navigable edges that may be used by to locate nodes by this partition.
	 * The default implementation returns all old primary navigable edges
	 * and all already realized navigable edges
	 */
	private @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges() {
		List<@NonNull NavigableEdge> navigableEdges = Lists.newArrayList(getOldPrimaryNavigableEdges());
		for (@NonNull Edge edge : getAlreadyRealizedEdges()) {
			if (edge instanceof NavigableEdge) {
				navigableEdges.add((NavigableEdge) edge);
			}
		}
		return navigableEdges;
	}

	public @NonNull Iterable<@NonNull Node> getConstantInputNodes() {
		return regionAnalysis.getConstantInputNodes();
	}

	public @NonNull Iterable<@NonNull Node> getConstantOutputNodes() {
		return regionAnalysis.getConstantOutputNodes();
	}

	public @Nullable Iterable<@NonNull TraceClassAnalysis<@NonNull RegionAnalysis>> getConsumedTraceClassAnalyses() {
		return regionAnalysis.getConsumedTraceClassAnalyses();
	}

	public @Nullable Iterable<@NonNull TracePropertyAnalysis<@NonNull RegionAnalysis>> getConsumedTracePropertyAnalyses() {
		return regionAnalysis.getConsumedTracePropertyAnalyses();
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

	public @Nullable Iterable<@NonNull TraceClassAnalysis<@NonNull RegionAnalysis>> getProducedTraceClassAnalyses() {
		return regionAnalysis.getProducedTraceClassAnalyses();
	}

	public @Nullable Iterable<@NonNull TracePropertyAnalysis<@NonNull RegionAnalysis>> getProducedTracePropertyAnalyses() {
		return regionAnalysis.getProducedTracePropertyAnalyses();
	}

	private @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Iterable<@NonNull Node> traceNodes = getTraceNodes();
		Iterable<@NonNull Node> constantInputNodes = getConstantInputNodes();
		return Iterables.concat(traceNodes, constantInputNodes);
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

	public @Nullable AbstractPartialPartition getRealizingPartition(@NonNull Edge edge) {
		return alreadyRealizedEdges.get(edge);
	}

	public @NonNull MappingRegion getRegion() {
		return region;
	}

	public @NonNull RegionAnalysis getRegionAnalysis() {
		return regionAnalysis;
	}

	public @NonNull RegionsAnalysis<@NonNull Partition> getRegionsPartitionAnalysis() {
		return regionsPartitionAnalysis;
	}

	protected @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	private @NonNull Iterable<@NonNull Node> getSpeculationReachabilityRootNodes() {
		List<@NonNull Node> rootNodes = new ArrayList<>();
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(region)) {
			if (!headNode.isDependency()) {
				rootNodes.add(headNode);
			}
		}
		for (@NonNull Node constantInputNode : getConstantInputNodes()) {
			rootNodes.add(constantInputNode);
		}
		return rootNodes;
	}

	public @NonNull Iterable<@NonNull SuccessEdge> getSuccessEdges() {
		return regionAnalysis.getSuccessEdges();
	}

	public @Nullable Iterable<@NonNull TraceClassAnalysis<@NonNull RegionAnalysis>> getSuperProducedTraceClassAnalyses() {
		return regionAnalysis.getSuperProducedTraceClassAnalyses();
	}

	public @NonNull TraceClassAnalysis<@NonNull RegionAnalysis> getTraceClassAnalysis(@NonNull Node traceNode) {
		ClassDatum traceClassDatum = QVTscheduleUtil.getClassDatum(traceNode);
		return transformationAnalysis.getTraceClassAnalysis(traceClassDatum);
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

	public boolean hasConstantEdge(@NonNull Edge edge) {
		return alreadyConstantEdges.contains(edge);
	}

	public boolean hasLoadedEdge(@NonNull Edge edge) {
		return alreadyLoadedEdges.contains(edge);
	}

	public boolean hasPredicatedEdge(@NonNull Edge edge) {
		return alreadyPredicatedEdges.contains(edge);
	}

	public boolean hasPredicatedNode(@NonNull Node node) {
		return alreadyPredicatedNodes.contains(node);
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
		ClassDatum traceClassDatum = QVTscheduleUtil.getClassDatum(traceNode);
		return transformationAnalysis.isCyclic(traceClassDatum);
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

	public @NonNull Iterable<@NonNull Partition> partition() {
		if ((region instanceof DispatchRegion) || (region instanceof VerdictRegion)) {
			return Collections.singletonList(createNonPartition());
		}
		String name = region.getName();
		if ("associationToForeignKey".equals(name)) {
			getClass();
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
		List<@NonNull Partition> newPartitions = new ArrayList<>();
		if (needsActivator) {
			//
			//	Create an activator to make a QVTr top relation behave as a non-top relation.
			//
			newPartitions.add(createActivatorPartition());
		}
		if (!needsSpeculation) {
			//
			//	If speculation is not needed just add the functionality as a single region.
			//
			if (newPartitions.isEmpty()) {		// i.e. a QVTr non top relation - re-use as is
				newPartitions.add(createNonPartition());
			}
			else {							// i.e. a QVTr top relation - create a residue to finish off the activator
				newPartitions.add(createResidualPartition());
			}
		}
		else {								// cycles may need speculation and partitioning into isolated actions
			//			if (isInfallible) {
			//				regionAnalysis.getFallibilities()
			//			}
			if (useActivators) {
				regionAnalysis.createLocalSuccess();
			}
			SpeculationPartition speculationPartition = createSpeculationPartition();
			SpeculatingPartition speculatingPartition = createSpeculatingPartition();
			SpeculatedPartition speculatedPartition = createSpeculatedPartition();
			newPartitions.add(speculationPartition);
			newPartitions.add(speculatingPartition);
			newPartitions.add(speculatedPartition);
			if (!useActivators) {
				speculatingPartition.addExplicitPredecessor(speculationPartition);
				speculatedPartition.addExplicitPredecessor(speculatingPartition);
			}
			ReachabilityForest assignmentReachabilityForest	= new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
			//
			//	Create an AssignmentRegion for each to-be-realized edge to an output, which may also realize most trace edges too.
			//
			for (@NonNull NavigableEdge outputEdge : getRealizedOutputEdges()) {
				if (!hasRealizedEdge(outputEdge)) {
					newPartitions.add(createAssignmentPartition(assignmentReachabilityForest, outputEdge));
				}
			}
			//
			//	Create an AssignmentRegion for each still to-be-realized edge to an output.
			//
			for (@NonNull NavigableEdge edge : getRealizedEdges()) {
				if (!hasRealizedEdge(edge)) {
					newPartitions.add(createAssignmentPartition(assignmentReachabilityForest, edge));
				}
			}
		}
		if (newPartitions.size() > 1) {		// FIXME shouldn't this work anyway when no partitioning was needed?
			check(/*isInfallible*/);
		}
		return newPartitions;
	}

	@Override
	public String toString() {
		return region.getName();
	}
}
