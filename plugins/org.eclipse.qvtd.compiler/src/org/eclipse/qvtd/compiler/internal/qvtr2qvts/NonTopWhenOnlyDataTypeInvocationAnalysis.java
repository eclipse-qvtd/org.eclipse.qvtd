/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

/**
 * A NonTopWhenOnlyDataTypeInvocationAnalysis identifies the invocation of a non-top Relation by a when clause in another.
 * The Relation has only DataTyped root variables and is not invoked by a where clause anywhere else.
 */
public class NonTopWhenOnlyDataTypeInvocationAnalysis extends AbstractWhenInvocationAnalysis
{
	public NonTopWhenOnlyDataTypeInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
	}

	@Override
	protected @NonNull NavigableEdge createInputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		if (invokedRelationAnalysis.isSharedAggregator()) {
			invokedRelationAnalysis.createSharedEdge(Role.PREDICATED, argumentNode, invocationProperty, invokedNode);
		}
		return super.createInputEdge(invokedNode, invocationProperty, argumentNode);
	}

	@Override
	protected @NonNull Node createInvocationNode(@NonNull String name, @NonNull ClassDatum classDatum, boolean isMatched) {
		return invokingRelationAnalysis.createPredicatedNode(name, classDatum, isMatched);
	}

	@Override
	public boolean isTop() {
		return false;
	}

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "==when-only==non-top==data==>" + invokedRelationAnalysis.getRule().getName();
	}
}