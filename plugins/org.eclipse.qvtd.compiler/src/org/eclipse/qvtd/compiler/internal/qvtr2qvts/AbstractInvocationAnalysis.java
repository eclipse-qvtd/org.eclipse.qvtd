/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Invocation2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceGroup;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * An InvocationAnalysis identifies the invocation of one Relation from another.
 *
 * AbstractInvocationAnalysis provides as much common behaviour as possible. Variant behaviour appears in derived classes.
 */
public abstract class AbstractInvocationAnalysis implements InvocationAnalysis
{
	protected final @NonNull RelationAnalysis invokingRelationAnalysis;
	protected final @NonNull RelationAnalysis invokedRelationAnalysis;
	protected final @NonNull QVTrelationScheduleManager scheduleManager;
	protected final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode = new HashMap<>();

	public AbstractInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis) {
		this.invokingRelationAnalysis = invokingRelationAnalysis;
		this.invokedRelationAnalysis = invokedRelationAnalysis;
		this.scheduleManager = invokedRelationAnalysis.getScheduleManager();
	}

	@Override
	public void addBinding(@NonNull VariableDeclaration rootVariable, @NonNull Node argumentNode) {
		Node oldNode = rootVariable2argumentNode.put(rootVariable, argumentNode);
		assert oldNode == null;
	}

	protected void createGlobalSuccessNodeAndEdge(@NonNull Node invokedNode) {}

	protected @NonNull NavigableEdge createInputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		return invokingRelationAnalysis.createNavigationEdge(invokedNode, invocationProperty, argumentNode, null);
	}

	protected void createInvocationEdges(@NonNull Node invokedNode) {
		RelationAnalysis2MiddleType baseInvokedRuleAnalysis2MiddleType = getBaseInvokedRuleAnalysis2MiddleType();
		Relation baseInvokedRelation = getBaseInvokedRelation();
		for (@NonNull VariableDeclaration rootVariable : rootVariable2argumentNode.keySet()) {
			Node argumentNode = rootVariable2argumentNode.get(rootVariable);
			assert argumentNode != null;
			VariableDeclaration overriddenRootVariable = QVTrelationUtil.getOverriddenVariable(baseInvokedRelation, rootVariable);
			Property invocationProperty = baseInvokedRuleAnalysis2MiddleType.getTraceProperty(overriddenRootVariable);
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(invokedNode);
			DomainUsage domainUsage = scheduleManager.getDomainUsage(classDatum);
			if (domainUsage.isOutput()) {
				createOutputEdge(invokedNode, invocationProperty, argumentNode);
			}
			else {
				createInputEdge(invokedNode, invocationProperty, argumentNode);
			}
		}
	}

	protected abstract @NonNull Node createInvocationNode(@NonNull Node invokingTraceNode);

	protected void createInvokingTraceEdge(@NonNull Node invokedNode, @NonNull Node invokingTraceNode) {
		RelationAnalysis2TraceGroup invokingRuleAnalysis2TraceGroup = invokingRelationAnalysis.getRuleAnalysis2TraceGroup();
		RelationAnalysis2TraceClass invokingRuleAnalysis2TraceClass = invokingRuleAnalysis2TraceGroup.getRuleAnalysis2TraceClass();
		Invocation2TraceProperty invokingInvocation2TraceProperty = invokingRuleAnalysis2TraceClass.getInvocation2TraceProperty(this);
		Property invocationTraceProperty = invokingInvocation2TraceProperty.getTraceProperty();
		invokingRelationAnalysis.createRealizedNavigationEdge(invokingTraceNode, invocationTraceProperty, invokedNode, null);
	}

	protected @NonNull NavigableEdge createOutputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode) {
		return invokingRelationAnalysis.createNavigationEdge(invokedNode, invocationProperty, argumentNode, null);
	}

	protected @NonNull Relation getBaseInvokedRelation() {
		return QVTrelationUtil.getBaseRelation(invokedRelationAnalysis.getRule());
	}

	protected @NonNull RelationAnalysis2MiddleType getBaseInvokedRuleAnalysis2MiddleType() {
		Relation invokedRelation = invokedRelationAnalysis.getRule();
		Relation baseInvokedRelation = getBaseInvokedRelation();
		RelationAnalysis baseInvokedRelationAnalysis = scheduleManager.getRuleAnalysis(baseInvokedRelation);
		RelationAnalysis2TraceGroup baseInvokedRelationAnalysis2TraceGroup = baseInvokedRelationAnalysis.getRuleAnalysis2TraceGroup();
		RelationAnalysis2MiddleType baseInvokedRuleAnalysis2MiddleType;
		if (QVTrelationUtil.hasOverrides(invokedRelation)) {
			baseInvokedRuleAnalysis2MiddleType = baseInvokedRelationAnalysis2TraceGroup.getRuleAnalysis2DispatchClass();
		}
		else if (isTop()) {
			baseInvokedRuleAnalysis2MiddleType = baseInvokedRelationAnalysis2TraceGroup.getRuleAnalysis2TraceInterface();
		}
		else {
			baseInvokedRuleAnalysis2MiddleType = baseInvokedRelationAnalysis2TraceGroup.getRuleAnalysis2InvocationInterface();
		}
		return baseInvokedRuleAnalysis2MiddleType;
	}

	protected @NonNull ClassDatum getInvokedClassDatum() {
		TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
		RelationAnalysis2MiddleType invokedRelationAnalysis2InvocationInterface = getInvokedRelationAnalysis2InvocationInterface();
		org.eclipse.ocl.pivot.Class invokedInvocationInterface = invokedRelationAnalysis2InvocationInterface.getMiddleClass();
		return scheduleManager.getClassDatum(traceTypedModel, invokedInvocationInterface);
	}

	@Override
	public @NonNull RelationAnalysis getInvokedRelationAnalysis() {
		return invokedRelationAnalysis;
	}

	protected @NonNull RelationAnalysis2MiddleType getInvokedRelationAnalysis2InvocationInterface() {
		RelationAnalysis2TraceGroup invokedRuleAnalysis2TraceGroup = invokedRelationAnalysis.getRuleAnalysis2TraceGroup();
		RelationAnalysis2TraceGroup invokedBaseRelationAnalysis2TraceGroup = invokedRuleAnalysis2TraceGroup.getBaseRelationAnalysis2TraceGroup();
		RelationAnalysis2MiddleType invokedRelationAnalysis2InvocationInterface = invokedBaseRelationAnalysis2TraceGroup.getRuleAnalysis2InvocationInterface();
		return invokedRelationAnalysis2InvocationInterface;
	}

	@Override
	public @NonNull RelationAnalysis getInvokingRelationAnalysis() {
		return invokingRelationAnalysis;
	}

	/**
	 * Return true unless some argumentNode is not matched.
	 */
	protected boolean isMatched() {
		for (@NonNull VariableDeclaration rootVariable : rootVariable2argumentNode.keySet()) {
			Node argumentNode = rootVariable2argumentNode.get(rootVariable);
			assert argumentNode != null;
			if (!argumentNode.isMatched()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void synthesizeInvocationNodes(@NonNull Node invokingTraceNode) {
		//
		//	Create the invokedNode that causes the invocation.
		//
		Node invokedNode = createInvocationNode(invokingTraceNode);
		//
		//	Integrate the invokedNode with the invokingTraceNode.
		//
		createInvokingTraceEdge(invokedNode, invokingTraceNode);
		//
		//	Create a global success status if appropriate.
		//
		createGlobalSuccessNodeAndEdge(invokedNode);
		//
		//	Join the invokedNode to the argument nodes that bind it.
		//
		createInvocationEdges(invokedNode);
	}
}