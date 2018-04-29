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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.QVTm2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
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
	//	protected final @NonNull TransformationPartitioner transformationPartitioner;

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
	 * The realized edges from the (realized) trace node to a realized (corollary) ouput node that identify what is
	 * guaranteed to be created only speculation succeeds.
	 */
	private final @NonNull List<@NonNull NavigableEdge> corollaryEdges = new ArrayList<>();

	/**
	 * The realized output nodes guaranteed to be created only speculation succeeds;
	 * the targets of corollaryEdges.
	 */
	private final @NonNull List<@NonNull Node> corollaryNodes = new ArrayList<>();

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
	private final @NonNull Map<@NonNull Edge, @NonNull AbstractPartition> alreadyRealizedEdges = new HashMap<>();

	/**
	 * Dynamically growing list of nodes that have been realized by a partition.
	 */
	private final @NonNull Set<@NonNull Node> alreadyRealizedNodes = new HashSet<>();

	private final @NonNull Map<@NonNull Edge, @NonNull List<@NonNull AbstractPartition>> debugEdge2partitions = new HashMap<>();

	public MappingPartitioner(@NonNull TransformationPartitioner transformationPartitioner, @NonNull RegionAnalysis regionAnalysis) {
		this.scheduleManager = transformationPartitioner.getScheduleManager();
		//		this.transformationPartitioner = transformationPartitioner;
		this.transformationAnalysis = transformationPartitioner.getTransformationAnalysis();
		this.regionAnalysis = regionAnalysis;
		this.region = (MappingRegion) regionAnalysis.getRegion();
		//
		List<@NonNull Node> alreadyRealized = new ArrayList<>(getTraceNodes());
		Node dispatchNode = basicGetDispatchNode();
		if (dispatchNode != null) {
			alreadyRealized.add(dispatchNode);
		}
		analyzeCorollaries(alreadyRealized);
	}

	public void addEdge(@NonNull Edge edge, @NonNull Role newEdgeRole, @NonNull AbstractPartition partition) {
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
		List<@NonNull AbstractPartition> partitions = debugEdge2partitions.get(edge);
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

	/**
	 * Identify what gets realized as a consequence of the mapping succeeding.
	 */
	private void analyzeCorollaries(@NonNull List<@NonNull Node> alreadyRealizedNodes) {
		for (int i = 0; i < alreadyRealizedNodes.size(); i++) {
			Node alreadyRealizedNode = alreadyRealizedNodes.get(i);
			for (@NonNull NavigationEdge edge : alreadyRealizedNode.getRealizedNavigationEdges()) {
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (targetNode.isRealized() && !targetNode.isSuccess()) {
					assert !corollaryEdges.contains(edge);
					corollaryEdges.add(edge);
					if (!alreadyRealizedNodes.contains(targetNode)) {
						alreadyRealizedNodes.add(targetNode);
						assert !corollaryNodes.contains(targetNode);
						if (!corollaryNodes.contains(targetNode)) {		// Overrides have a base and derived edge to the same rootVariable node
							corollaryNodes.add(targetNode);
						}
					}
					transformationAnalysis.addCorollary(QVTscheduleUtil.getProperty(edge), region);
				}
			}
		}
	}

	public @Nullable Node basicGetDispatchNode() {
		return regionAnalysis.basicGetDispatchNode();
	}

	private void check(boolean isInfallible) {
		Set<@NonNull Edge> infallibleEdges = null;
		Set<@NonNull Node> infallibleNodes = null;
		if (isInfallible) {
			infallibleEdges = new HashSet<>();
			infallibleNodes = new HashSet<>();
			for (@NonNull Edge edge : regionAnalysis.getFallibleEdges()) {
				infallibleEdges.add(edge);
				infallibleNodes.add(QVTscheduleUtil.getTargetNode(edge));
			}
		}
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (((node.isSpeculated() && !node.isHead()) || node.isRealized()) && !hasRealizedNode(node)) {
				if ((infallibleNodes == null) || !infallibleNodes.contains(node)) {
					addProblem(CompilerUtil.createRegionError(region, "Should have realized " + node));
				}
			}
		}
		Set<@NonNull Edge> allPrimaryEdges = new HashSet<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (!edge.isSecondary()) {
				allPrimaryEdges.add(edge);
				if (edge.isRealized() && !hasRealizedEdge(edge)) {
					if ((infallibleEdges == null) || !infallibleEdges.contains(edge)) {
						addProblem(CompilerUtil.createRegionError(region, "Should have realized " + edge));
					}
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
				addProblem(CompilerUtil.createRegionWarning(region, "Extra " + edge));
			}
			Set<@NonNull Edge> missingEdgesSet = Sets.newHashSet(allPrimaryEdges);
			missingEdgesSet.removeAll(partitionedEdges);
			for (@NonNull Edge edge : missingEdgesSet) {
				if (transformationAnalysis.getCorollaryOf(edge) == null) {// && !isDead(edge)) {
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

	private @NonNull MicroMappingRegion createActivatorRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		ActivatorPartition speculatingPartition = new ActivatorPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculatingPartition.createMicroMappingRegion("«activator»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatingPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createAssignmentRegion(@NonNull ReachabilityForest reachabilityForest, @NonNull Edge outputEdge, int partitionNumber) {
		String namePrefix = "«edge" + partitionNumber + "»";
		String symbolSuffix = "_p" + partitionNumber;
		AssignmentPartition assignmentPartition = new AssignmentPartition(this, reachabilityForest, outputEdge);
		MicroMappingRegion microMappingRegion = assignmentPartition.createMicroMappingRegion(namePrefix, symbolSuffix);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		assignmentPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createNewSpeculatedRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		NewSpeculatedPartition speculatedPartition = new NewSpeculatedPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculatedPartition.createMicroMappingRegion("«speculated»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createNewSpeculatingRegion(int partitionNumber, boolean isInfallible) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		NewSpeculatingPartition speculatingPartition = new NewSpeculatingPartition(this, reachabilityForest, isInfallible);
		MicroMappingRegion microMappingRegion = speculatingPartition.createMicroMappingRegion("«speculating»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatingPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createNewSpeculationRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getSpeculationReachabilityRootNodes(), getAvailableNavigableEdges());
		NewSpeculationPartition speculationPartition = new NewSpeculationPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculationPartition.createMicroMappingRegion("«speculation»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculationPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createRealizedRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		RealizedPartition realizedPartition = new RealizedPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = realizedPartition.createMicroMappingRegion("«realized»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		realizedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createResidualRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		ResidualPartition realizedPartition = new ResidualPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = realizedPartition.createMicroMappingRegion("«residue»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		realizedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculatedRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		SpeculatedPartition speculatedPartition = new SpeculatedPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculatedPartition.createMicroMappingRegion("«speculated»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatedPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculatingRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		SpeculatingPartition speculatingPartition = new SpeculatingPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculatingPartition.createMicroMappingRegion("«speculating»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		speculatingPartition.check(microMappingRegion);
		return microMappingRegion;
	}

	private @NonNull MicroMappingRegion createSpeculationRegion(int partitionNumber) {
		ReachabilityForest reachabilityForest = new ReachabilityForest(getSpeculationReachabilityRootNodes(), getAvailableNavigableEdges());
		SpeculationPartition speculationPartition = new SpeculationPartition(this, reachabilityForest);
		MicroMappingRegion microMappingRegion = speculationPartition.createMicroMappingRegion("«speculation»", "_p" + partitionNumber);
		if (QVTm2QVTs.DEBUG_GRAPHS.isActive()) {
			scheduleManager.writeDebugGraphs(microMappingRegion, null);
		}
		//			>>>>>>> 4473ebf residue
		speculationPartition.check(microMappingRegion);
		return microMappingRegion;
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

	public @Nullable Iterable<@NonNull TraceClassAnalysis> getConsumedTraceClassAnalyses() {
		return regionAnalysis.getConsumedTraceClassAnalyses();
	}

	public @Nullable Iterable<@NonNull TracePropertyAnalysis> getConsumedTracePropertyAnalyses() {
		return regionAnalysis.getConsumedTracePropertyAnalyses();
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getCorollaryEdges() {
		return corollaryEdges;
	}

	public @NonNull Iterable<@NonNull Node> getCorollaryNodes() {
		return corollaryNodes;
	}

	public @NonNull Iterable<@NonNull Node> getExecutionNodes() {
		return Iterables.concat(getPredicatedExecutionNodes(), getRealizedExecutionNodes());
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

	public @Nullable Iterable<@NonNull TraceClassAnalysis> getProducedTraceClassAnalyses() {
		return regionAnalysis.getProducedTraceClassAnalyses();
	}

	public @Nullable Iterable<@NonNull TracePropertyAnalysis> getProducedTracePropertyAnalyses() {
		return regionAnalysis.getProducedTracePropertyAnalyses();
	}

	private @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Iterable<@NonNull Node> traceNodes = getTraceNodes();
		Iterable<@NonNull Node> constantInputNodes = getConstantInputNodes();
		return Iterables.concat(traceNodes, constantInputNodes);
	}

	public @NonNull Iterable<@NonNull Edge> getRealizedEdges() {
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

	public @NonNull Iterable<@NonNull Edge> getRealizedOutputEdges() {
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

	public @Nullable AbstractPartition getRealizingPartition(@NonNull Edge edge) {
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

	public @Nullable SuccessEdge getSuccessEdge(@NonNull Node traceNode) {
		return regionAnalysis.getSuccessEdge(traceNode);
	}

	public @NonNull Iterable<@NonNull SuccessEdge> getSuccessEdges() {
		return regionAnalysis.getSuccessEdges();
	}

	public @Nullable Node getSuccessNode(@NonNull Node traceNode) {
		return regionAnalysis.getSuccessNode(traceNode);
	}

	public @Nullable Iterable<@NonNull TraceClassAnalysis> getSuperProducedTraceClassAnalyses() {
		return regionAnalysis.getSuperProducedTraceClassAnalyses();
	}

	public @NonNull TraceClassAnalysis getTraceClassAnalysis(@NonNull Node traceNode) {
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

	//	public @NonNull TransformationPartitioner getTransformationPartitioner() {
	//		return transformationPartitioner;
	//	}

	/*	private boolean hasNoComputationInputs(@NonNull Node node) {
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isComputation()) {
				return false;
			}
		}
		return true;
	} */


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

	public @Nullable List<@NonNull MappingRegion> getCorollaryOf(@NonNull Edge edge) {
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

	public @NonNull Iterable<@NonNull MappingRegion> partition() {
		boolean useActivators = scheduleManager.useActivators();
		if (useActivators) {
			return partition4qvtr();		// New algorithms with Dispatch/VerdictRegions to support overriding
		}
		else {
			return partition4qvtc();		// Old algorithms pending debugging and exploitation of new algorithms
		}
	}

	public @NonNull Iterable<@NonNull MappingRegion> partition4qvtc() {
		boolean isCyclic = transformationAnalysis.getCycleAnalysis(regionAnalysis) != null;
		List<@NonNull MappingRegion> newRegions = new ArrayList<>();
		if (!isCyclic) {	// Cycle analysis found no cycles
			newRegions.add(region);
		}
		else {
			if (!Iterables.isEmpty(getPredicatedMiddleNodes())) {
				newRegions.add(createSpeculationRegion(newRegions.size()));
				newRegions.add(createSpeculatingRegion(newRegions.size()));
				newRegions.add(createSpeculatedRegion(newRegions.size()));
			}
			else {
				newRegions.add(createRealizedRegion(newRegions.size()));
			}
			ReachabilityForest assignmentReachabilityForest	= new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
			//
			//	Create an AssignmentRegion for each to-be-realized edge to an output, which may also realize most trace edges too.
			//
			for (@NonNull Edge outputEdge : getRealizedOutputEdges()) {
				if (!hasRealizedEdge(outputEdge)) {
					newRegions.add(createAssignmentRegion(assignmentReachabilityForest, outputEdge, newRegions.size()));
				}
			}
			//
			//	Create an AssignmentRegion for each still to-be-realized edge to an output.
			//
			for (@NonNull Edge edge : getRealizedEdges()) {
				if (!hasRealizedEdge(edge)) {
					newRegions.add(createAssignmentRegion(assignmentReachabilityForest, edge, newRegions.size()));
				}
			}
		}
		if (newRegions.size() > 1) {		// FIXME shouldn't this work anyway when no partitioning was needed?
			check(false);
		}
		return newRegions;
	}

	public @NonNull Iterable<@NonNull MappingRegion> partition4qvtr() {
		if ((region instanceof DispatchRegion) || (region instanceof VerdictRegion)) {
			return Collections.singletonList(region);
		}
		String name = region.getName();
		if ("mapNavigationOrAttributeCallExp_Helper_qvtr".equals(name)) {
			getClass();
		}
		CycleAnalysis cycleAnalysis = transformationAnalysis.getCycleAnalysis(regionAnalysis);
		boolean isCyclic = cycleAnalysis != null;
		boolean isInfallible = false;
		if (cycleAnalysis != null) {
			isInfallible = cycleAnalysis.isInfallible();
		}
		List<@NonNull Node> predicatedWhenNodes = getPredicatedWhenNodes();
		List<@NonNull Node> realizedExecutionNodes = getRealizedExecutionNodes();
		boolean needsActivator = false;
		if (realizedExecutionNodes.size() > 0)	{			// A 'single' realized "trace" node is a boring no-override top activation.
			needsActivator = true;
		}
		else {
			needsActivator = false;
		}
		boolean needsSpeculation = isCyclic && (predicatedWhenNodes.size() > 0); //(dispatchedTraceNodes2.isEmpty() ? !predicatedMiddleNodes.isEmpty() : !predicatedMiddleNodes.containsAll(dispatchedTraceNodes2));
		//
		//	Create the partitioned regions
		//
		List<@NonNull MappingRegion> newRegions = new ArrayList<>();
		if (needsActivator) {
			//
			//	Create an activator to make a QVTr top relation behave as a non-top relation.
			//
			newRegions.add(createActivatorRegion(newRegions.size()));
		}
		if (!needsSpeculation) {
			//
			//	If speculation is not needed just add the functionality as a single region.
			//
			if (newRegions.isEmpty()) {		// i.e. a QVTr non top relation - re-use as is
				newRegions.add(region);
			}
			else {							// i.e. a QVTr top relation - create a residue to finish off the activator
				newRegions.add(createResidualRegion(newRegions.size()));
			}
		}
		else {								// cycles may need speculation and partitioning into isolated actions
			//			if (isInfallible) {
			//				regionAnalysis.getFallibilities()
			//			}
			newRegions.add(createNewSpeculationRegion(newRegions.size()));
			newRegions.add(createNewSpeculatingRegion(newRegions.size(), isInfallible));
			newRegions.add(createNewSpeculatedRegion(newRegions.size()));
			ReachabilityForest assignmentReachabilityForest	= new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
			//
			//	Create an AssignmentRegion for each to-be-realized edge to an output, which may also realize most trace edges too.
			//
			for (@NonNull Edge outputEdge : getRealizedOutputEdges()) {
				if (!hasRealizedEdge(outputEdge)) {
					newRegions.add(createAssignmentRegion(assignmentReachabilityForest, outputEdge, newRegions.size()));
				}
			}
			//
			//	Create an AssignmentRegion for each still to-be-realized edge to an output.
			//
			for (@NonNull Edge edge : getRealizedEdges()) {
				if (!hasRealizedEdge(edge)) {
					newRegions.add(createAssignmentRegion(assignmentReachabilityForest, edge, newRegions.size()));
				}
			}
		}
		if (newRegions.size() > 1) {		// FIXME shouldn't this work anyway when no partitioning was needed?
			check(isInfallible);
		}
		return newRegions;
	}

	@Override
	public String toString() {
		return region.getName();
	}
}
