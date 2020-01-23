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
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
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
import org.eclipse.qvtd.pivot.qvtschedule.Utility;
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

	private final @Nullable RuleAnalysis ruleAnalysis;

	public RegionAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull Region region) {
		super(transformationAnalysis);
		this.region = region;
		this.ruleAnalysis = region instanceof RuleRegion ? transformationAnalysis.getRuleAnalysis(QVTscheduleUtil.getReferredRule((RuleRegion)region)) : null;
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
			for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(alreadyRealizedNode)) {
				if (edge.isRealized() && edge.isNavigation()) {
					NavigationEdge navigationEdge = (NavigationEdge)edge;
					Node targetNode = QVTscheduleUtil.getTargetNode(navigationEdge);
					if (targetNode.isRealized() && !targetNode.isSuccess()) {
						assert !corollaryEdges.contains(navigationEdge);
						corollaryEdges.add(navigationEdge);
						if (!alreadyRealizedNodes.contains(targetNode)) {
							alreadyRealizedNodes.add(targetNode);
							assert !corollaryNodes.contains(targetNode);
							if (!corollaryNodes.contains(targetNode)) {		// Overrides have a base and derived edge to the same rootVariable node
								corollaryNodes.add(targetNode);
							}
						}
						transformationAnalysis.addCorollary(navigationEdge);
					}
				}
			}
		}
	}

	public @Nullable Iterable<@NonNull PartitionAnalysis> basicGetPartitionAnalyses() {
		return partitionAnalyses;
	}

	public @NonNull SuccessEdge createLocalSuccess() {
		List<@NonNull Node> traceNodes = getTraceNodes();
		assert traceNodes.size() == 1;
		Node traceNode = ClassUtil.nonNullState(traceNodes.get(0));
		Rule referredRule = QVTscheduleUtil.getReferredRule((RuleRegion)region);
		RelationAnalysis relationAnalysis = (RelationAnalysis)transformationAnalysis.getRuleAnalysis(referredRule);
		Relation2TraceGroup relation2traceGroup = relationAnalysis.getRule2TraceGroup();
		Relation2TraceClass relation2TraceClass = relation2traceGroup.getRule2TraceClass();
		Element2MiddleProperty relation2localSuccessProperty = relation2TraceClass.getRelation2LocalSuccessProperty();
		Property localSuccessProperty = relation2localSuccessProperty.getTraceProperty();
		SuccessEdge localSuccessEdge = relationAnalysis.createRealizedSuccess(Utility.NON_NULL_MATCHED, traceNode, localSuccessProperty, null);
		analyzeLocalSuccessEdge(traceNode);
		return localSuccessEdge;
	}

	public @NonNull Iterable<@NonNull NavigableEdge> getCorollaryEdges() {
		return corollaryEdges;
	}

	public @NonNull Iterable<@NonNull Node> getCorollaryNodes() {
		return corollaryNodes;
	}

	@Override
	public @Nullable Iterable<@NonNull PartialRegionAnalysis<@NonNull RegionsAnalysis>> getExplicitPredecessors() {
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

	@Override
	public @NonNull Region getRegion() {
		return region;
	}

	public @NonNull RuleAnalysis getRuleAnalysis() {
		return ClassUtil.nonNullState(ruleAnalysis);
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