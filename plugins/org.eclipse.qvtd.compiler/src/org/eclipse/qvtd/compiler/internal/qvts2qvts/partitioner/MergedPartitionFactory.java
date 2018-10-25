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

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.utilities.PivotUtilInternal;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MergedPartition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import com.google.common.collect.Iterables;

/**
 * The Merged Partition aggregates the nodes and edges of multipl,e partitions as a single merged partition.
 */
public class MergedPartitionFactory extends AbstractPartitionFactory<@NonNull Region>
{
	protected final @NonNull Iterable<@NonNull BasicPartitionAnalysis> subPartitionAnalyses;

	public MergedPartitionFactory(@NonNull RegionAnalysis regionAnalysis, @NonNull Iterable<@NonNull BasicPartitionAnalysis> subPartitionAnalyses) {
		super(regionAnalysis.getScheduleManager(), regionAnalysis.getRegion());
		this.subPartitionAnalyses = subPartitionAnalyses;
	}

	protected void addNode(@NonNull BasicPartition partition, @NonNull Node node, @NonNull Role newNodeRole) {
		assert node.getOwningRegion() == region;
		Role displacedNodeRole = partition.putNodeRole(node, newNodeRole);
		assert displacedNodeRole == null;
	}

	protected @NonNull String computeName() {
		StringBuilder s = new StringBuilder();
		s.append(region.getName() + "«");
		boolean isFirst = true;
		for (@NonNull BasicPartitionAnalysis subPartitionAnalysis : subPartitionAnalyses) {
			if (!isFirst) {
				s.append(",");
			}
			String name = subPartitionAnalysis.getName();
			int iStart = name.indexOf('«');
			int iFinish = name.indexOf('»');
			if ((0 <= iStart) && (iStart < iFinish)) {
				s.append(name.subSequence(iStart+1, iFinish));
			}
			else {
				s.append(name);
			}
			isFirst = false;
		}
		s.append("»");
		return s.toString();
	}

	@Override
	public @NonNull BasicPartitionAnalysis createPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis) {
		Iterable<@NonNull Node> headNodes = subPartitionAnalyses.iterator().next().getTraceNodes();
		MergedPartition mergedPartition = createMergedPartition(computeName(), headNodes);
		for (@NonNull BasicPartitionAnalysis subPartitionAnalysis : subPartitionAnalyses) {
			BasicPartition subPartition = subPartitionAnalysis.getPartition();
			PivotUtilInternal.resetContainer(subPartition);
			mergedPartition.getOwnedMergedPartitions().add(subPartition);
			mergedPartition.getExplicitPredecessors().addAll(subPartition.getExplicitPredecessors());
			mergedPartition.getExplicitSuccessors().addAll(subPartition.getExplicitSuccessors());
		}
		mergedPartition.initTypedModelAnalysis();
		return createPartitionAnalysis(partitionedTransformationAnalysis, mergedPartition);
	}

	protected @NonNull BasicPartitionAnalysis createPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull MergedPartition mergedPartition) {
		ReachabilityForest reachabilityForest = createReachabilityForest();
		int partitionNumber = region.getNextPartitionNumber();
		String namePrefix = "«merge" + partitionNumber + "»";
		String symbolSuffix = "_p" + partitionNumber;
		BasicPartitionAnalysis basicPartitionAnalysis = new BasicPartitionAnalysis(partitionedTransformationAnalysis, mergedPartition, reachabilityForest, namePrefix, symbolSuffix);
		initializePartition(basicPartitionAnalysis);
		basicPartitionAnalysis.analyzePartition();
		basicPartitionAnalysis.analyzePartition2();
		return basicPartitionAnalysis;
	}

	@Override
	protected @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges() {
		Set<@NonNull NavigableEdge> oldEdges = new HashSet<>();  //
		Set<@NonNull NavigableEdge> realizedEdges = new HashSet<>();  //
		for (@NonNull BasicPartitionAnalysis subPartitionAnalysis : subPartitionAnalyses) {
			BasicPartition partition = subPartitionAnalysis.getPartition();
			for (@NonNull Edge edge : partition.getPartialEdges()) {
				if (edge.isNavigation()) {
					if (subPartitionAnalysis.isRealized(edge)) {
						realizedEdges.add((NavigableEdge) edge);
					}
					else if (subPartitionAnalysis.isOld(edge)) {
						oldEdges.add((NavigableEdge) edge);
					}
				}
			}
		}
		oldEdges.removeAll(realizedEdges);		// FIXME ?? conditional / computation
		return oldEdges;
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		Set<@NonNull Node> rootNodes = new HashSet<>();
		for (@NonNull BasicPartitionAnalysis subPartitionAnalysis : subPartitionAnalyses) {
			ReachabilityForest reachabilityForest = subPartitionAnalysis.getReachabilityForest();
			for (@NonNull Node node : reachabilityForest.getNodes()) {
				if (reachabilityForest.getCost(node) == 0) {
					rootNodes.add(node);
				}
			}
		}
		return rootNodes;
	}

	protected void initializePartition(@NonNull BasicPartitionAnalysis partitionAnalysis) {
		BasicPartition partition = partitionAnalysis.getPartition();
		//	this.traceNode = mappingPartitioner.getTraceNode();
		String regionName = region.getName();
		if ("mapNavigationOrAttributeCallExp_Property_qvtr".equals(regionName)) {
			getClass();
		}
		//
		//	Add all the nodes merging the roles.
		//
		Set<@NonNull Node> mergedNodes = new HashSet<>();
		Set<@NonNull Edge> mergedEdges = new HashSet<>();
		for (@NonNull BasicPartitionAnalysis subPartitionAnalysis : subPartitionAnalyses) {
			BasicPartition subPartition = subPartitionAnalysis.getPartition();
			Iterables.addAll(mergedNodes, subPartition.getPartialNodes());
			Iterables.addAll(mergedEdges, subPartition.getPartialEdges());
		}
		//
		//	Add all the nodes merging the roles.
		//
		for (@NonNull Node mergedNode : mergedNodes) {
			mergeNode(partition, mergedNode);
		}
		//
		//	Add all the edges merging the roles.
		//
		for (@NonNull Edge edge : mergedEdges) {
			mergeEdge(partition, edge);
		}
	}

	/**
	 * Merge the edge merging the roles.
	 */
	protected void mergeEdge(@NonNull BasicPartition partition, @NonNull Edge edge) {
		boolean isConstant = false;
		boolean isLoaded = false;
		boolean isPredicated = false;
		boolean isRealized = false;
		boolean isSpeculated = false;
		for (@NonNull BasicPartitionAnalysis subPartitionAnalysis : subPartitionAnalyses) {
			Role role = subPartitionAnalysis.getPartition().getRole(edge);
			if (role != null) {
				switch (role) {
					case CONSTANT: isConstant = true; break;
					case LOADED: isLoaded = true; break;
					case PREDICATED: isPredicated = true; break;
					case REALIZED: isRealized = true; break;
					case SPECULATED: isSpeculated = true; break;
					default: throw new UnsupportedOperationException();
				}
			}
		}
		if (isConstant) {
			addEdge(partition, edge, Role.CONSTANT);
		}
		else if (isLoaded) {
			addEdge(partition, edge, Role.LOADED);
		}
		else if (isRealized) {
			addEdge(partition, edge, Role.REALIZED);
		}
		else if (isSpeculated) {
			addEdge(partition, edge, Role.SPECULATED);
		}
		else if (isPredicated) {
			addEdge(partition, edge, Role.PREDICATED);
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Merge the node merging the roles.
	 */
	protected void mergeNode(@NonNull BasicPartition partition, @NonNull Node node) {
		boolean isConstant = false;
		boolean isConstantSuccessFalse = false;
		boolean isConstantSuccessTrue = false;
		boolean isLoaded = false;
		boolean isPredicated = false;
		boolean isRealized = false;
		boolean isSpeculated = false;
		for (@NonNull BasicPartitionAnalysis subPartitionAnalysis : subPartitionAnalyses) {
			Role role = subPartitionAnalysis.getPartition().getRole(node);
			if (role != null) {
				switch (role) {
					case CONSTANT: isConstant = true; break;
					case CONSTANT_SUCCESS_FALSE: isConstantSuccessFalse = true; break;
					case CONSTANT_SUCCESS_TRUE: isConstantSuccessTrue = true; break;
					case LOADED: isLoaded = true; break;
					case PREDICATED: isPredicated = true; break;
					case REALIZED: isRealized = true; break;
					case SPECULATED: isSpeculated = true; break;
					default: throw new UnsupportedOperationException();
				}
			}
		}
		if (isConstant) {
			addNode(partition, node, Role.CONSTANT);
		}
		else if (isConstantSuccessFalse) {
			addNode(partition, node, Role.CONSTANT_SUCCESS_FALSE);
		}
		else if (isConstantSuccessTrue) {
			addNode(partition, node, Role.CONSTANT_SUCCESS_TRUE);
		}
		else if (isLoaded) {
			addNode(partition, node, Role.LOADED);
		}
		else if (isRealized) {
			addNode(partition, node, Role.REALIZED);
		}
		else if (isSpeculated) {
			addNode(partition, node, Role.SPECULATED);
		}
		else if (isPredicated) {
			addNode(partition, node, Role.PREDICATED);
		}
		else {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	protected @Nullable Role resolveEdgeRole(@NonNull Role sourceNodeRole, @NonNull Edge edge, @NonNull Role targetNodeRole) {
		throw new UnsupportedOperationException();		// Never called since resolveEdges() not called.
	}

	@Override
	public @NonNull String toString() {
		return super.toString() + " " + subPartitionAnalyses;
	}
}
