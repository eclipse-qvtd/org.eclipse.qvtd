/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CastEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CastInitializerCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionVisitor;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.ConstantTargetCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.MultipleEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.NavigableEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.NonNullInitializerCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.PredicateEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.PredicateNavigationEdgeCheckedCondition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A CheckedConditionWeightComparator supports prioritization lof condition check synthesis by sorting
 * condition according to their weight, which is the number of edges to be traversed in order to prepare
 * the inputs for the check.
 */
public class CheckedConditionWeightComparator implements CheckedConditionVisitor<@NonNull Integer>, Comparator<@NonNull CheckedCondition>
{
	protected final @NonNull BasicRegion2Mapping region2mapping;
	private final @NonNull Map<@NonNull CheckedCondition, @NonNull Integer> condition2weight = new HashMap<>();

	public CheckedConditionWeightComparator(@NonNull BasicRegion2Mapping region2mapping) {
		this.region2mapping = region2mapping;
	}

	protected void accumulateNode(@NonNull Set<@NonNull Node> requiredNodes, @NonNull Node node) {
		requiredNodes.addAll(region2mapping.getPrecedingNodes(node));
	}

	protected void accumulateNodes(@NonNull Set<@NonNull Node> requiredNodes, @NonNull Edge edge) {
		accumulateNode(requiredNodes, QVTscheduleUtil.getSourceNode(edge));
		accumulateNode(requiredNodes, QVTscheduleUtil.getTargetNode(edge));
	}

	@Override
	public int compare(@NonNull CheckedCondition o1, @NonNull CheckedCondition o2) {
		int w1 = getWeight(o1);
		int w2 = getWeight(o2);
		return w1 - w2;
	}

	private int getWeight(@NonNull CheckedCondition checkedCondition) {
		Integer weight = condition2weight.get(checkedCondition);
		if (weight == null) {
			weight = checkedCondition.accept(this);
			condition2weight.put(checkedCondition, weight);
		}
		return weight;
	}

	@Override
	public @NonNull Integer visitCastEdgeCheckedCondition(@NonNull CastEdgeCheckedCondition castEdgeCheckedCondition) {
		Set<@NonNull Node> requiredNodes = new HashSet<>();
		accumulateNodes(requiredNodes, castEdgeCheckedCondition.getCastEdge());
		return requiredNodes.size();
	}

	@Override
	public @NonNull Integer visitCastInitializerCheckedCondition(@NonNull CastInitializerCheckedCondition castInitializerCheckedCondition) {
		Set<@NonNull Node> requiredNodes = new HashSet<>();
		accumulateNode(requiredNodes, castInitializerCheckedCondition.getOperationNode());
		return requiredNodes.size();
	}

	@Override
	public @NonNull Integer visitConstantTargetCheckedCondition(@NonNull ConstantTargetCheckedCondition constantTargetCheckedCondition) {
		Set<@NonNull Node> requiredNodes = new HashSet<>();
		requiredNodes.addAll(region2mapping.getPrecedingNodes(QVTscheduleUtil.getSourceNode(constantTargetCheckedCondition.getPredicateEdge())));
		return requiredNodes.size();
	}

	@Override
	public @NonNull Integer visitMultipleEdgeCheckedCondition(@NonNull MultipleEdgeCheckedCondition multipleEdgeCheckedCondition) {
		Set<@NonNull Node> requiredNodes = new HashSet<>();
		for (@NonNull Edge edge : multipleEdgeCheckedCondition.getEdges()) {
			accumulateNodes(requiredNodes, edge);
		}
		return requiredNodes.size();
	}

	@Override
	public @NonNull Integer visitNavigableEdgeCheckedCondition(@NonNull NavigableEdgeCheckedCondition navigableEdgeCheckedCondition) {
		Set<@NonNull Node> requiredNodes = new HashSet<>();
		accumulateNodes(requiredNodes, navigableEdgeCheckedCondition.getNavigableEdge());
		return requiredNodes.size();
	}

	@Override
	public @NonNull Integer visitNonNullInitializerCheckedCondition(@NonNull NonNullInitializerCheckedCondition nonNullInitializerCheckedCondition) {
		Set<@NonNull Node> requiredNodes = new HashSet<>();
		accumulateNode(requiredNodes, nonNullInitializerCheckedCondition.getOperationNode());
		return requiredNodes.size();
	}

	@Override
	public @NonNull Integer visitPredicateEdgeCheckedCondition(@NonNull PredicateEdgeCheckedCondition predicateEdgeCheckedCondition) {
		Set<@NonNull Node> requiredNodes = new HashSet<>();
		accumulateNodes(requiredNodes, predicateEdgeCheckedCondition.getPredicateEdge());
		return requiredNodes.size();
	}

	@Override
	public @NonNull Integer visitPredicateNavigationEdgeCheckedCondition(@NonNull PredicateNavigationEdgeCheckedCondition predicateNavigationEdgeCheckedCondition) {
		Set<@NonNull Node> requiredNodes = new HashSet<>();
		accumulateNodes(requiredNodes, predicateNavigationEdgeCheckedCondition.getNavigationEdge());
		return requiredNodes.size();
	}
}