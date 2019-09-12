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
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * A TopWhenInvocationAnalysis identifies the invocation of a top Relation by a when clause in another.
 */
public class TopWhenInvocationAnalysis extends AbstractWhenInvocationAnalysis
{
	public TopWhenInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
	}

	@Override
	protected @NonNull Node createInvocationNode(@NonNull String name, @NonNull ClassDatum classDatum, boolean isMatched) {
		return invokingRelationAnalysis.createPredicatedNode(name, classDatum, isMatched);
	}


	/**
	 * Return true unless a non-match is permitted for null input to null output. (See Bug 499432)
	 */
	@Override
	protected boolean isMatched() {
		boolean anyRequired = false;
		boolean anyOmitted = false;
		for (@NonNull VariableDeclaration rootVariable : rootVariable2argumentNode.keySet()) {
			if (rootVariable.isIsRequired()) {
				anyRequired = true;
			}
			Node argumentNode = rootVariable2argumentNode.get(rootVariable);
			assert argumentNode != null;
			if (!argumentNode.isRequired()) {
				anyOmitted = true;
			}
		}
		if (anyRequired) {				// If any root cannot be null
			return true;				//  a match is required
		}
		if (!anyOmitted) {				// If nothing omitted
			return true;				//  a match is required
		}
		return false;					// Match can be omitted
	}

	@Override
	public boolean needsInvocationTraceProperty() {
		Relation invokingRelation = invokingRelationAnalysis.getRule();
		return invokingRelation.isIsTopLevel();
	}
}