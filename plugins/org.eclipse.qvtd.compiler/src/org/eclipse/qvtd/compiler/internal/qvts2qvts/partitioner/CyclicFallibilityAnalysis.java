/*******************************************************************************
 * Copyright (c) 2018, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.ConstantTargetCheckedCondition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;

public class CyclicFallibilityAnalysis extends AbstractFallibilityAnalysis
{
	protected class CyclicCheckedConditionVisitor extends AbstractCheckedConditionVisitor
	{
		@Override
		public @NonNull Boolean visitConstantTargetCheckedCondition(@NonNull ConstantTargetCheckedCondition constantTargetCheckedCondition) {
			NavigableEdge predicateEdge = constantTargetCheckedCondition.getNavigationEdge();
			if (!(predicateEdge instanceof SuccessEdge)) {
				return false;
			}
			/*	Set<@NonNull SuccessEdge> checkedSuccessHeadEdges2 = checkedSuccessHeadEdges;
			assert checkedSuccessHeadEdges2 != null;
			if (checkedSuccessHeadEdges2.contains(predicateEdge)) {
				return true;
			}
			Set<@NonNull SuccessEdge> realizedSuccessHeadEdges2 = realizedSuccessHeadEdges;
			assert realizedSuccessHeadEdges2 != null;
			if (realizedSuccessHeadEdges2.contains(predicateEdge)) {
				return true;
			}
			Set<@NonNull SuccessEdge> predicatedSuccessEdges2 = predicatedSuccessEdges;
			assert predicatedSuccessEdges2 != null;
			if (predicatedSuccessEdges2.contains(predicateEdge)) {
				return true;
			}
			Set<@NonNull SuccessEdge> speculatedSuccessEdges2 = speculatedSuccessEdges;
			assert speculatedSuccessEdges2 != null;
			if (speculatedSuccessEdges2.contains(predicateEdge)) {
				return true;
			}
			/*	Node targetNode = QVTscheduleUtil.getTargetNode(predicateEdge);
			if (targetNode instanceof SuccessNode) {

			}
			else if (targetNode instanceof BooleanLiteralNode) {
				boolean targetValue = ((BooleanLiteralNode)targetNode).isBooleanValue();
				if (!targetValue) {
					return false;
				}
			}
			else {
				return false;
			}
			@SuppressWarnings("unused") Role targetRole = partition.getRole(targetNode);
			//	if (targetRole != Role.CONSTANT_SUCCESS_TRUE) {
			//		return false;
			//	}
			Node sourceNode = QVTscheduleUtil.getSourceNode(predicateEdge);
			if (partition.isHead(sourceNode)) {
				Role edgeRole = partition.getRole(predicateEdge);
				assert edgeRole != null;
				if (edgeRole.isChecked()) {
					return true;
				}
				if (!edgeRole.isRealized()) {
					return false;
				}
				assert (realizedSuccessHeadEdges2 != null) && realizedSuccessHeadEdges2.contains(predicateEdge);
				return true;
			}
			for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(partition)) {
				for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(headNode)) {
					if (edge.isSuccess()) {
						NavigableEdge headEdge = (NavigableEdge) edge;
						if (headEdge.getProperty() == predicateEdge.getProperty()) {
							Node successNode = QVTscheduleUtil.getTargetNode(headEdge);
							if (successNode instanceof SuccessNode) {
								assert ((predicatedSuccessEdges != null) && predicatedSuccessEdges.contains(predicateEdge)) || ((speculatedSuccessEdges != null) && speculatedSuccessEdges.contains(predicateEdge));
								return true;
							}
						}
					}
				}
			} */
			return false;
		}
	}

	private boolean isInfallible = false;
	private boolean isTerminating = false;

	public CyclicFallibilityAnalysis(@NonNull CyclicPartitionAnalysis cyclicPartitionAnalysis) {
		super(cyclicPartitionAnalysis);
	}

	public void analyze() {
		//	throw new UnsupportedOperationException();
		Set<@NonNull SuccessEdge> unsatisfiedSuccessNonHeadEdges = new HashSet<>(speculatedSuccessNonHeadEdges);
		unsatisfiedSuccessNonHeadEdges.removeAll(realizedSuccessHeadEdges);
		isInfallible = true;
		isTerminating = true;
	}

	public void analyze(@NonNull PartitionAnalysis nestedPartitionAnalysis) {
		analyzeSuccessEdges(nestedPartitionAnalysis.getPartition());
	}

	@Override
	public boolean isInfallible() {
		return isInfallible;
	}

	@Override
	public boolean isTerminating() {
		return isTerminating;
	}
}