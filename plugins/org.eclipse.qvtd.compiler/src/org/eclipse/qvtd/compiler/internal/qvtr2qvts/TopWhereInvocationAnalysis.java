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
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * A TopWhereInvocationAnalysis identifies the invocation of a top Relation by a where clause in another.
 *
 * top-where is a menainfgless combination since top relations are invoked automatically. THe implementation
 * here eliminates the call.
 */
public class TopWhereInvocationAnalysis extends AbstractInvocationAnalysis
{
	public TopWhereInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
	}

	@Override
	protected @NonNull Node createInvocationNode(@NonNull Node invokingTraceNode) {
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
	public void synthesizeInvocationNodes(@NonNull Node invokingTraceNode) {}

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "== top-where ==>" + invokedRelationAnalysis.getRule().getName();
	}
}