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

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.InitUtility;

/**
 * A NonTopWhenOnlyInvocationAnalysis identifies the invocation of a non-top Relation by a when clause in another.
 * The Relation is is not invoked by a where clause anywhere else.
 */
public class NonTopWhenOnlyInvocationAnalysis extends AbstractWhenInvocationAnalysis
{
	public NonTopWhenOnlyInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis,
			@NonNull InitUtility initUtility, @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode) {
		super(invokingRelationAnalysis, invokedRelationAnalysis, initUtility, rootVariable2argumentNode);
	}

	@Override
	protected @NonNull NavigableEdge createInputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		return invokingRelationAnalysis.createNavigationEdge(Role.REALIZED, initUtility, invokedNode, invocationProperty, argumentNode, false);
	}

	@Override
	protected @NonNull Node createInvocationNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		return invokingRelationAnalysis.createRealizedNode(initUtility, name, classDatum);
	}

	@Override
	public boolean isTop() {
		return false;
	}

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "==when-only==non-top==>" + invokedRelationAnalysis.getRule().getName();
	}
}