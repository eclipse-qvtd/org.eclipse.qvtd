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
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * A NonTopWhenOnlyClassInvocationAnalysis identifies the invocation of a non-top Relation by a when clause in another.
 * The Relation has a non-DataType root varioable and is not invoked by a where clause anywhere else.
 */
public class NonTopWhenOnlyClassInvocationAnalysis extends AbstractWhenInvocationAnalysis
{
	public NonTopWhenOnlyClassInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
	}

	@Override
	protected @NonNull Node createInvocationNode(@NonNull String name, @NonNull ClassDatum classDatum, boolean isMatched) {
		return invokingRelationAnalysis.createRealizedNode(name, classDatum, isMatched);
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