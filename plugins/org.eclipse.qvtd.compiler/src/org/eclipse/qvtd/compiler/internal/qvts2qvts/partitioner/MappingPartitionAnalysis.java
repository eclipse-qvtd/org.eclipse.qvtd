/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

public abstract class MappingPartitionAnalysis<@NonNull P extends MappingPartition> extends AbstractPartitionAnalysis<P>
{
	/**
	 * The trace nodes and their corresponding global success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 *
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2globalSuccessEdge = new HashMap<>(); */

	/**
	 * The trace nodes and their corresponding local success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 *
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2localSuccessEdge = new HashMap<>(); */

	/**
	 * The map from node to the trace edge by which the node may be located by lookup in a trace node once its trace edge is realized..
	 *
	private final @NonNull Map<@NonNull Node, @NonNull Edge> node2traceEdge = new HashMap<>(); */

	protected MappingPartitionAnalysis(@NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis, @NonNull P partition) {
		super(partitionedTransformationAnalysis, partition);
	}

	@Override
	public void analyzePartition() {
		@SuppressWarnings("unused") String name = getName();
		analyzeNodes();
		analyzeEdges();
	}

	@Override
	protected @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return partition.getPartialEdges();
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return partition.getPartialNodes();
	}

	public abstract @NonNull ReachabilityForest getReachabilityForest();

	/*	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return node2traceEdge.get(node);
	} */

	@Override
	protected boolean isConstant(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isConstant();
	}

	@Override
	protected boolean isConstant(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isConstant();
	}

	@Override
	protected boolean isLoaded(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isLoaded();
	}

	@Override
	protected boolean isLoaded(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isLoaded();
	}

	@Override
	protected boolean isNew(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isNew();
	}

	@Override
	protected boolean isNew(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isNew();
	}

	protected boolean isOld(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isOld();
	}

	protected boolean isOld(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isOld();
	}

	@Override
	protected boolean isPredicated(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isPredicated();
	}

	@Override
	protected boolean isPredicated(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isPredicated();
	}

	@Override
	protected boolean isRealized(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isRealized();
	}

	@Override
	protected boolean isRealized(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isRealized();
	}

	@Override
	protected boolean isSpeculated(@NonNull Edge edge) {
		Role role = partition.getRole(edge);
		assert role != null;
		return role.isSpeculated();
	}

	@Override
	protected boolean isSpeculated(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isSpeculated();
	}

	@Override
	protected boolean isSpeculation(@NonNull Node node) {
		Role role = partition.getRole(node);
		assert role != null;
		return role.isSpeculation();
	}
}
