/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CastEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CastInitializerCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionVisitor;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.ConstantTargetCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.MultipleEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.NavigableEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.NonNullInitializerCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.PredicateEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.PredicateNavigationEdgeCheckedCondition;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * The FallibilityAnalysis identifies why individual Mappings may fail allowing cycles of Mappings whose
 * cycle members succeed conditionally to succeed unconditionally.
 *
 * The regions/mappings are first accumulate()'d, then the closure of the accumulated results are install()'d
 * within each RegionAnalysis.
 */
public abstract class AbstractFallibilityAnalysis implements FallibilityAnalysis
{
	protected static abstract class AbstractCheckedConditionVisitor implements CheckedConditionVisitor<@NonNull Boolean>
	{
		@Override
		public @NonNull Boolean visitCastEdgeCheckedCondition(@NonNull CastEdgeCheckedCondition castEdgeCheckedCondition) {
			return false;
		}

		@Override
		public @NonNull Boolean visitCastInitializerCheckedCondition(@NonNull CastInitializerCheckedCondition castInitializerCheckedCondition) {
			return false;
		}

		@Override
		public @NonNull Boolean visitConstantTargetCheckedCondition(@NonNull ConstantTargetCheckedCondition constantTargetCheckedCondition) {
			return false;
		}

		@Override
		public @NonNull Boolean visitMultipleEdgeCheckedCondition(@NonNull MultipleEdgeCheckedCondition multipleEdgeCheckedCondition) {
			return false;
		}

		@Override
		public @NonNull Boolean visitNavigableEdgeCheckedCondition(@NonNull NavigableEdgeCheckedCondition navigableEdgeCheckedCondition) {
			return false;
		}

		@Override
		public @NonNull Boolean visitNonNullInitializerCheckedCondition(@NonNull NonNullInitializerCheckedCondition nonNullInitializerCheckedCondition) {
			return false;
		}

		@Override
		public @NonNull Boolean visitPredicateEdgeCheckedCondition(@NonNull PredicateEdgeCheckedCondition predicateEdgeCheckedCondition) {
			return false;
		}

		@Override
		public @NonNull Boolean visitPredicateNavigationEdgeCheckedCondition(@NonNull PredicateNavigationEdgeCheckedCondition predicateNavigationEdgeCheckedCondition) {
			return false;
		}
	}

	protected final @NonNull PartitionAnalysis partitionAnalysis;
	protected final @NonNull Partition partition;
	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull Set<@NonNull SuccessEdge> checkedSuccessHeadEdges = new HashSet<>();
	protected final @NonNull Set<@NonNull SuccessEdge> realizedSuccessHeadEdges = new HashSet<>();
	protected final @NonNull Set<@NonNull SuccessEdge> predicatedSuccessNonHeadEdges = new HashSet<>();
	protected final @NonNull Set<@NonNull SuccessEdge> speculatedSuccessNonHeadEdges = new HashSet<>();

	public AbstractFallibilityAnalysis(@NonNull PartitionAnalysis partitionAnalysis) {
		this.partitionAnalysis = partitionAnalysis;
		this.partition = partitionAnalysis.getPartition();
		this.partitionedTransformationAnalysis = partitionAnalysis.getPartitionedTransformationAnalysis();
		this.scheduleManager = partitionedTransformationAnalysis.getScheduleManager();
	}

	public void analyze(@NonNull AbstractFallibilityAnalysis nestedFallibilityAnalysis) {
		checkedSuccessHeadEdges.addAll(nestedFallibilityAnalysis.checkedSuccessHeadEdges);
		realizedSuccessHeadEdges.addAll(nestedFallibilityAnalysis.realizedSuccessHeadEdges);
	}

	protected void analyzeSuccessEdges(@NonNull Partition partition) {
		analyzeSuccessHeadEdges(partition);
		Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(partition);
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (edge instanceof SuccessEdge) {
				Role edgeRole = partition.getRole(edge);
				assert edgeRole != null;
				SuccessEdge successEdge = (SuccessEdge)edge;
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (!Iterables.contains(headNodes, sourceNode)) {
					if (edgeRole.isChecked()) {
						if (targetNode instanceof BooleanLiteralNode) {
							boolean targetValue = ((BooleanLiteralNode)targetNode).isBooleanValue();
							if (targetValue) {
								if (edgeRole.isPredicated()) {
									predicatedSuccessNonHeadEdges.add(successEdge);
								}
								else {
									speculatedSuccessNonHeadEdges.add(successEdge);
								}
							}
						}
					}
				}
			}
		}
	}

	private void analyzeSuccessHeadEdges(@NonNull Partition partition) {
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(partition)) {
			for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(headNode)) {
				if (edge instanceof SuccessEdge) {
					Role edgeRole = partition.getRole(edge);
					if (edgeRole != null) {
						SuccessEdge successEdge = (SuccessEdge)edge;
						Node targetNode = QVTscheduleUtil.getTargetNode(edge);
						if (edgeRole.isChecked()) {
							if (targetNode instanceof SuccessNode) {
								checkedSuccessHeadEdges.add(successEdge);
							}
							/*	else if (targetNode instanceof BooleanLiteralNode) {
							boolean targetValue = ((BooleanLiteralNode)targetNode).isBooleanValue();
							if (targetValue) {
								checkedSuccessHeadEdges2.add(successEdge);
							}
						} */
						}
						else if (edgeRole.isRealized()) {
							if (targetNode instanceof SuccessNode) {
								realizedSuccessHeadEdges.add(successEdge);
							}
						}
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return partition.toString();
	}
}