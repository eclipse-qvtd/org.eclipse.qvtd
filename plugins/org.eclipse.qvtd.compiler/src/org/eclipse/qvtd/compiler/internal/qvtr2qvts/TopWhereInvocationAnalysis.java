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
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;

/**
 * A TopWhereInvocationAnalysis identifies the invocation of a top Relation by a where clause in another.
 *
 * top-where is a menainfgless combination since top relations are invoked automatically. THe implementation
 * here eliminates the call.
 */
public class TopWhereInvocationAnalysis extends AbstractInvocationAnalysis
{
	public TopWhereInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis,
			@NonNull Utility utility, @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode) {
		super(invokingRelationAnalysis, invokedRelationAnalysis, utility, rootVariable2argumentNode);
	}

	@Override
	protected @NonNull NavigableEdge createInputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		throw new UnsupportedOperationException();	// Cannot happen synthesizeInvocationNodes is empty.
	}

	@Override
	protected @NonNull Node createInvocationNode() {
		throw new UnsupportedOperationException();	// Cannot happen synthesizeInvocationNodes is empty.
	}

	@Override
	protected @NonNull NavigableEdge createOutputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		throw new UnsupportedOperationException();	// Cannot happen synthesizeInvocationNodes is empty.
	}

	@Override
	public boolean isTop() {
		return true;
	}

	@Override
	public boolean isWhen() {
		return false;
	}

	@Override
	public @NonNull Node synthesizeInvocationNodes(@NonNull Node invokingTraceNode) {
		throw new IllegalStateException();
	}

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "==where==top==>" + invokedRelationAnalysis.getRule().getName();
	}
}