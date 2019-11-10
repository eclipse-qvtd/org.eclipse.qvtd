/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2MiddleType;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;

/**
 * An AbstractWhenInvocationAnalysis identifies the invocation of one Relation from the when clause of another.
 */
public abstract class AbstractWhenInvocationAnalysis extends AbstractInvocationAnalysis
{
	private @Nullable SuccessEdge globalSuccessEdge = null;

	public AbstractWhenInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
	}

	@Override
	protected @NonNull NavigableEdge createInputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		return invokingRelationAnalysis.createNavigationEdge(Role.PREDICATED, invokedNode, invocationProperty, argumentNode, false);
	}

	@Override
	protected @NonNull Node createInvocationNode() {
		QVTrelationNameGenerator nameGenerator = scheduleManager.getNameGenerator();	// FIXME unique names
		Relation invokedRelation = invokedRelationAnalysis.getRule();
		String name = nameGenerator.createWhenInvocationPropertyName(invokedRelation);
		ClassDatum classDatum = getInvokedClassDatum();
		boolean isMatched = isMatched();
		return createInvocationNode(name, classDatum, isMatched);
	}

	@Override
	protected void createInvokingTraceEdge(@NonNull Node invokedNode, @NonNull Node invokingTraceNode) {
		if (needsInvocationTraceProperty()) {
			super.createInvokingTraceEdge(invokedNode, invokingTraceNode);
		}
	}

	@Override
	protected @NonNull NavigableEdge createOutputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		return invokingRelationAnalysis.createNavigationEdge(Role.PREDICATED, invokedNode, invocationProperty, argumentNode, false);
	}

	@Override
	public @Nullable SuccessEdge getGlobalSuccessEdge() {
		SuccessEdge globalSuccessEdge2 = globalSuccessEdge;
		if (globalSuccessEdge2 == null) {
			Node invokingNode = getInvokingNode();
			Relation2MiddleType invokedRelation2InvocationInterface = getInvokedRelation2InvocationInterface();
			Element2MiddleProperty relation2globalSuccessProperty = invokedRelation2InvocationInterface.getRelation2GlobalSuccessProperty();
			//	if (relation2globalSuccessProperty != null) {
			Property globalSuccessProperty = relation2globalSuccessProperty.getTraceProperty();
			globalSuccessEdge = globalSuccessEdge2 = invokingRelationAnalysis.createPredicatedSuccess(invokingNode, globalSuccessProperty, true);
			//	}
		}
		return globalSuccessEdge2;
	}

	@Override
	public boolean isTop() {
		return true;
	}

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "==when==top==>" + invokedRelationAnalysis.getRule().getName();
	}

	protected abstract @NonNull Node createInvocationNode(@NonNull String name, @NonNull ClassDatum classDatum, boolean isMatched);

	@Override
	public final boolean isWhen() {
		return true;
	}
}