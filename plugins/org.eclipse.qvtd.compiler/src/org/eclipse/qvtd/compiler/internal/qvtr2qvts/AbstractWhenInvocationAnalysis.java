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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2MiddleType;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

/**
 * An AbstractWhenInvocationAnalysis identifies the invocation of one Relation from the when clause of another.
 */
public abstract class AbstractWhenInvocationAnalysis extends AbstractInvocationAnalysis
{
	public AbstractWhenInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		super(invokingRelationAnalysis, invokedRelationAnalysis);
	}

	@Override
	protected void createGlobalSuccessNodeAndEdge(@NonNull Node invokedNode) {
		RelationAnalysis2MiddleType invokedRelationAnalysis2InvocationInterface = getInvokedRelationAnalysis2InvocationInterface();
		Element2MiddleProperty relation2globalSuccessProperty = invokedRelationAnalysis2InvocationInterface.basicGetRelation2GlobalSuccessProperty(invokingRelationAnalysis.getTargetTypedModel());
		if (relation2globalSuccessProperty != null) {
			Property globalSuccessProperty = relation2globalSuccessProperty.getTraceProperty();
			invokingRelationAnalysis.createPredicatedSuccess(invokedNode, globalSuccessProperty, true);
		}
	}

	@Override
	protected @NonNull NavigableEdge createInputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		return invokingRelationAnalysis.createNavigationEdge(Role.PREDICATED, invokedNode, invocationProperty, argumentNode, false);
	}

	@Override
	protected @NonNull Node createInvocationNode(@NonNull Node invokingTraceNode) {
		QVTrelationNameGenerator nameGenerator = scheduleManager.getNameGenerator();	// FIXME unique names
		Relation invokedRelation = invokedRelationAnalysis.getRule();
		String name = nameGenerator.createWhenInvocationPropertyName(invokedRelation);
		ClassDatum classDatum = getInvokedClassDatum();
		boolean isMatched = isMatched();
		return createInvocationNode(name, classDatum, isMatched);
	}

	@Override
	protected @NonNull NavigableEdge createOutputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		return invokingRelationAnalysis.createNavigationEdge(Role.PREDICATED, invokedNode, invocationProperty, argumentNode, false);
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
	protected void createInvokingTraceEdge(@NonNull Node invokedNode, @NonNull Node invokingTraceNode) {
		Relation invokingRelation = invokingRelationAnalysis.getRule();
		if (invokingRelation.isIsTopLevel()) {
			super.createInvokingTraceEdge(invokedNode, invokingTraceNode);
		}
	}

	@Override
	public final boolean isWhen() {
		return true;
	}
}