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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.checks;

import org.eclipse.jdt.annotation.NonNull;

/**
 * CheckedConditionVisitor supports visiting a CheckedCondition.
 *
 * (In due course this should be merged with the QVTscheduleVisitor.)
 */
public interface CheckedConditionVisitor<R>
{
	R visitCastEdgeCheckedCondition(@NonNull CastEdgeCheckedCondition castEdgeCheckedCondition);
	R visitCastInitializerCheckedCondition(@NonNull CastInitializerCheckedCondition castInitializerCheckedCondition);
	R visitConstantTargetCheckedCondition(@NonNull ConstantTargetCheckedCondition constantTargetCheckedCondition);
	R visitMultipleEdgeCheckedCondition(@NonNull MultipleEdgeCheckedCondition multipleEdgeCheckedCondition);
	R visitNavigableEdgeCheckedCondition(@NonNull NavigableEdgeCheckedCondition navigableEdgeCheckedCondition);
	R visitNonNullInitializerCheckedCondition(@NonNull NonNullInitializerCheckedCondition nonNullInitializerCheckedCondition);
	R visitPredicateEdgeCheckedCondition(@NonNull PredicateEdgeCheckedCondition predicateEdgeCheckedCondition);
	R visitSpeculationCheckedCondition(@NonNull SpeculationCheckedCondition speculationCheckedCondition);
}