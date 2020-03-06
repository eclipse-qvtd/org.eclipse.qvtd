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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.ConstantTargetCheckedCondition;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;

/**
 * A SelfCyclicFallibilityAnalysis provides the FallibilityAnalysis for a single partition cycle.
 */
public class SelfCyclicFallibilityAnalysis extends AbstractFallibilityAnalysis
{
	protected class SelfCyclicCheckedConditionVisitor extends AbstractCheckedConditionVisitor
	{
		@Override
		public @NonNull Boolean visitConstantTargetCheckedCondition(@NonNull ConstantTargetCheckedCondition constantTargetCheckedCondition) {
			NavigableEdge predicateEdge = constantTargetCheckedCondition.getNavigationEdge();
			if (!(predicateEdge instanceof SuccessEdge)) {
				return false;
			}
			if (checkedSuccessHeadEdges.contains(predicateEdge)) {
				return true;
			}
			if (realizedSuccessHeadEdges.contains(predicateEdge)) {
				return true;
			}
			if (predicatedSuccessNonHeadEdges.contains(predicateEdge)) {
				return true;
			}
			if (speculatedSuccessNonHeadEdges.contains(predicateEdge)) {
				return true;
			}
			return false;
		}
	}

	public SelfCyclicFallibilityAnalysis(@NonNull MappingPartitionAnalysis<?> partitionAnalysis) {
		super(partitionAnalysis);
	}

	@Override
	public boolean isInfallible() {
		analyzeSuccessEdges(partition);
		SelfCyclicCheckedConditionVisitor visitor = new SelfCyclicCheckedConditionVisitor();
		CheckedConditionAnalysis checkedConditionAnalysis = new CheckedConditionAnalysis((MappingPartitionAnalysis<?>) partitionAnalysis, scheduleManager);
		//	Set<@NonNull Property> allCheckedProperties = checkedConditionAnalysis.getAllCheckedProperties();
		Set<@NonNull CheckedCondition> checkedConditions = checkedConditionAnalysis.computeCheckedConditions();
		boolean isInfallible = true;
		for (@NonNull CheckedCondition checkedCondition : checkedConditions) {
			if (!checkedCondition.accept(visitor)) {
				isInfallible = false;
				break;
			}
		}
		return isInfallible;
	}

	@Override
	public boolean isTerminating() {
		return true;
	}
}