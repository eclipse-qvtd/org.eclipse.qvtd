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
 * A NonTopWhereInvocationAnalysis identifies the invocation of a non-top Relation by a where clause in another.
 */
public class NonTopWhereInvocationAnalysis extends AbstractInvocationAnalysis
{
	public NonTopWhereInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
	}

	@Override
	public boolean isTop() {
		return false;
	}

	@Override
	public boolean isWhen() {
		return false;
	}

	@Override
	protected @NonNull Node createInvocationNode(@NonNull Node invokingTraceNode) {
		QVTrelationNameGenerator nameGenerator = scheduleManager.getNameGenerator();	// FIXME unique names
		Relation invokedRelation = invokedRelationAnalysis.getRule();
		String name = nameGenerator.createWhereInvocationPropertyName(invokedRelation);
		ClassDatum classDatum = getInvokedClassDatum();
		return invokingRelationAnalysis.createRealizedNode(name, classDatum, true);
	}

	/*	@Override
	protected @NonNull ClassDatum getInvokedClassDatum() {
		TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
		RelationAnalysis2TraceGroup invokedRuleAnalysis2TraceGroup = invokedRelationAnalysis.getRuleAnalysis2TraceGroup();
		org.eclipse.ocl.pivot.Class invokedInvocationClass = invokedRuleAnalysis2TraceGroup.getInvocationClass();
		return scheduleManager.getClassDatum(traceTypedModel, invokedInvocationClass);
	} */

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "== non-top-where ==>" + invokedRelationAnalysis.getRule().getName();
	}
}