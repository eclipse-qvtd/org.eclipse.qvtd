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
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.InitUtility;

/**
 * A TopWhenInvocationAnalysis identifies the invocation of a top Relation by a when clause in another.
 */
public class TopWhenInvocationAnalysis extends AbstractWhenInvocationAnalysis
{
	/**
	 * Return true unless a non-match is permitted and used for null input to null output. (See Bug 499432)
	 */
	//	@Override
	private static @NonNull InitUtility resolveInitUtility(@NonNull InitUtility initUtility, @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode) {
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
			return initUtility;				//  a match is required
		}
		if (!anyOmitted) {				// If nothing omitted
			return initUtility;				//  a match is required
		}
		return initUtility.isConditional() ? InitUtility.NULLABLE_CONDITIONAL: InitUtility.NULLABLE_MATCHED;					// Match can be omitted
	}

	public TopWhenInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis,
			@NonNull InitUtility initUtility, @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode) {
		super(invokingRelationAnalysis, invokedRelationAnalysis, resolveInitUtility(initUtility, rootVariable2argumentNode), rootVariable2argumentNode);
	}

	@Override
	protected @NonNull Node createInvocationNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		return invokingRelationAnalysis.createPredicatedNode(initUtility, name, classDatum);
	}

	@Override
	public boolean needsInvocationTraceProperty() {
		Relation invokingRelation = invokingRelationAnalysis.getRule();
		return invokingRelation.isIsTopLevel();
	}
}