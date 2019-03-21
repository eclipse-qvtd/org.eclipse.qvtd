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

/**
 * A TopWhenInvocationAnalysis identifies the invocation of a top Relation by a when clause in another.
 */
public class TopWhenInvocationAnalysis extends AbstractWhenInvocationAnalysis
{
	public TopWhenInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
	}

	@Override
	public boolean isTop() {
		return true;
	}

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "== top-when ==>" + invokedRelationAnalysis.getRule().getName();
	}
}