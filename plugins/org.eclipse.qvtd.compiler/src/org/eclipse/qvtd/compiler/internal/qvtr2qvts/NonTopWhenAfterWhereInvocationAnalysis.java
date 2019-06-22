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
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * A NonTopWhenAfterWhereInvocationAnalysis identifies the invocation of a non-top Relation by a when clause in another.
 * The Relation exploits the results of a previous invocation by a where clause somewhere else.
 */
public class NonTopWhenAfterWhereInvocationAnalysis extends AbstractWhenInvocationAnalysis
{
	public NonTopWhenAfterWhereInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
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
	public boolean needsInvocationTraceProperty() {
		Relation invokingRelation = invokingRelationAnalysis.getRule();
		return invokingRelation.isIsTopLevel();
	}

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "==when-after-where==non-top==>" + invokedRelationAnalysis.getRule().getName();
	}
}