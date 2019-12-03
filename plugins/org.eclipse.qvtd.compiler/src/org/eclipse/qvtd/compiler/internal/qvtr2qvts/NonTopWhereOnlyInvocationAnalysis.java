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
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;

/**
 * A NonTopWhereOnlyInvocationAnalysis identifies the invocation of a non-top Relation by a where clause in another.
 * The Relation is subsequently invoked by a when clause somewhere else.
 */
public class NonTopWhereOnlyInvocationAnalysis extends AbstractInvocationAnalysis
{
	public NonTopWhereOnlyInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis,
			@NonNull Utility utility, @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode) {
		super(invokingRelationAnalysis, invokedRelationAnalysis, utility, rootVariable2argumentNode);
	}

	@Override
	protected @NonNull NavigableEdge createInputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		return invokingRelationAnalysis.createNavigationEdge(Role.REALIZED, utility, invokedNode, invocationProperty, argumentNode, false);
	}

	@Override
	protected @NonNull Node createInvocationNode() {
		QVTrelationNameGenerator nameGenerator = scheduleManager.getNameGenerator();	// FIXME unique names
		Relation invokedRelation = invokedRelationAnalysis.getRule();
		String name = nameGenerator.createWhereInvocationPropertyName(invokedRelation);
		ClassDatum classDatum = getInvokedClassDatum();
		return invokingRelationAnalysis.createRealizedNode(utility, name, classDatum);
	}

	@Override
	protected @NonNull NavigableEdge createOutputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		return invokingRelationAnalysis.createNavigationEdge(Role.REALIZED, utility, invokedNode, invocationProperty, argumentNode, false);
	}

	/*	@Override
	protected @NonNull ClassDatum getInvokedClassDatum() {
		TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
		relation2traceGroup invokedRule2TraceGroup = invokedRelationAnalysis.getRule2TraceGroup();
		org.eclipse.ocl.pivot.Class invokedInvocationClass = invokedRule2TraceGroup.getInvocationClass();
		return scheduleManager.getClassDatum(traceTypedModel, invokedInvocationClass);
	} */

	@Override
	public boolean isTop() {
		return false;
	}

	@Override
	public boolean isWhen() {
		return false;
	}

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "==where-only==non-top==>" + invokedRelationAnalysis.getRule().getName();
	}
}