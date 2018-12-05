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
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedTransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

public class RegionAnalysis extends AbstractRegionAnalysis
{
	protected final @NonNull Region region;
	private @Nullable Iterable<@NonNull PartitionAnalysis> partitionAnalyses = null;

	/**
	 * The edges to be realized iff speculation succeeds.
	 */
	private final @NonNull List<@NonNull NavigableEdge> corollaryEdges = new ArrayList<>();

	/**
	 * The nodes to be realized iff speculation succeeds.
	 */
	private final @NonNull List<@NonNull Node> corollaryNodes = new ArrayList<>();

	public RegionAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull Region region) {
		super(transformationAnalysis);
		this.region = region;
		// FIXME eliminate LoadingRegion, MicroMappingRegion	assert (region instanceof RuleRegion) || (region instanceof LoadingRegion);
		if (!region.isLoadingRegion()) {
			List<@NonNull Node> alreadyRealized = analyze();
			analyzeCorollaries(alreadyRealized);
		}
	}

	/**
	 * Identify what gets realized as a consequence of the mapping succeeding.
	 *<p>
	 * The corollaries are realized nodes and edges that are logically realized at the same time as the trace node.
	 * However since the trace node may be created speculatively to host matched and success statuses,
	 * corollary realization is deferred until the speculation has been successfully resolved.
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
					transformationAnalysis.addCorollary(edge);
				}
			}
		}
	}

	public @Nullable Iterable<@NonNull PartitionAnalysis> basicGetPartitionAnalyses() {
		return partitionAnalyses;
	}

	public void createLocalSuccess() {
		List<@NonNull Node> traceNodes = getTraceNodes();
		assert traceNodes.size() == 1;
		Node traceNode = ClassUtil.nonNullState(traceNodes.get(0));
		Rule referredRule = QVTscheduleUtil.getReferredRule((RuleRegion)region);
		RelationAnalysis relationAnalysis = (RelationAnalysis)transformationAnalysis.getRuleAnalysis(referredRule);
		RelationAnalysis2TraceGroup relationAnalysis2traceGroup = relationAnalysis.getRuleAnalysis2TraceGroup();
		//			relationAnalysis.synthesizeTraceLocalSuccessAssignment(relationAnalysis2traceGroup, getTraceNode());
		RelationAnalysis2TraceClass relationAnalysis2TraceClass = relationAnalysis2traceGroup.getRuleAnalysis2TraceClass();
		Element2MiddleProperty relation2localSuccessProperty = relationAnalysis2TraceClass.basicGetRelation2LocalSuccessProperty();
		Property localSuccessProperty = scheduleManager.basicGetLocalSuccessProperty(traceNode);
		if (relation2localSuccessProperty == null) {
			String localSuccessPropertyName = relationAnalysis2traceGroup.getNameGenerator().createTraceLocalSuccessPropertyName();
			relation2localSuccessProperty = relationAnalysis2TraceClass.createRelation2LocalSuccessProperty(localSuccessPropertyName);
			localSuccessProperty = relation2localSuccessProperty.getTraceProperty();
			SuccessEdge localSuccessEdge = relationAnalysis.createRealizedSuccess(traceNode, localSuccessProperty, null);
			QVTscheduleUtil.getTargetNode(localSuccessEdge).setUtility(Utility.STRONGLY_MATCHED);
			analyzeLocalSuccessEdge(traceNode);
		}
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getCorollaryEdges() {
		return corollaryEdges;
	}

	public @NonNull Iterable<@NonNull Node> getCorollaryNodes() {
		return corollaryNodes;
	}

	@Override
	public @Nullable Iterable<@NonNull RegionAnalysis> getExplicitPredecessors() {
		return null;
	}

	@Override
	public @NonNull String getName() {
		return String.valueOf(region);
	}

	@Override
	protected @NonNull Iterable<@NonNull Edge> getPartialEdges() {
		return QVTscheduleUtil.getOwnedEdges(region);
	}

	@Override
	protected @NonNull Iterable<@NonNull Node> getPartialNodes() {
		return QVTscheduleUtil.getOwnedNodes(region);
	}

	public @NonNull Iterable<@NonNull PartitionAnalysis> getPartitionAnalyses() {
		return ClassUtil.nonNullState(partitionAnalyses);
	}

	public @NonNull PartitionedTransformationAnalysis getPartitionedTransformationAnalysis() {
		return getPartitionAnalyses().iterator().next().getPartitionedTransformationAnalysis();
	}

	public @NonNull Region getRegion() {
		return region;
	}

	public @NonNull AbstractTransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}

	public void setPartitionAnalyses(@NonNull Iterable<@NonNull PartitionAnalysis> partitionAnalyses) {
		assert this.partitionAnalyses == null;
		this.partitionAnalyses = partitionAnalyses;
	}

	@Override
	public String toString() {
		return region.toString();
	}
}