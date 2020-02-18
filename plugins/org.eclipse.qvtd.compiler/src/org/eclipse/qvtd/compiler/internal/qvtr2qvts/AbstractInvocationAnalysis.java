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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Invocation2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2TraceGroup;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;

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
	protected final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode;
	protected final @NonNull Utility utility;
	private @Nullable Node invokingNode = null;
	private final @NonNull Map<@NonNull Node, @NonNull Boolean> argumentNode2isOutput = new HashMap<>();

	public AbstractInvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis, @NonNull Utility utility,
			@NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode) {
		this.invokingRelationAnalysis = invokingRelationAnalysis;
		this.invokedRelationAnalysis = invokedRelationAnalysis;
		this.scheduleManager = invokedRelationAnalysis.getScheduleManager();
		this.rootVariable2argumentNode = rootVariable2argumentNode;
		this.utility = utility;
	}

	/**
	 * Create the invocation edge for an input domain of the invoked relation.
	 */
	protected abstract @NonNull NavigableEdge createInputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode);

	protected void createInvocationEdges(@NonNull Node invokedNode) {
		Relation2MiddleType baseInvokedRule2MiddleType = getBaseInvokedRule2MiddleType();
		Relation baseInvokedRelation = getBaseInvokedRelation();
		for (@NonNull VariableDeclaration rootVariable : rootVariable2argumentNode.keySet()) {
			Node argumentNode = rootVariable2argumentNode.get(rootVariable);
			assert argumentNode != null;
			VariableDeclaration overriddenRootVariable = QVTrelationUtil.getOverriddenVariable(baseInvokedRelation, rootVariable);
			Property invocationProperty = baseInvokedRule2MiddleType.getTraceProperty(overriddenRootVariable);
			boolean isOutput = scheduleManager.isOutputInRule(baseInvokedRelation, overriddenRootVariable);
			if (isOutput) {
				createOutputEdge(invokedNode, invocationProperty, argumentNode);
			}
			else {
				createInputEdge(invokedNode, invocationProperty, argumentNode);
			}
			argumentNode2isOutput.put(argumentNode, isOutput);
		}
	}

	/**
	 * Create the invocation trace node for the invoked relation.
	 */
	protected abstract @NonNull Node createInvocationNode();

	protected void createInvokingTraceEdge(@NonNull Node invokedNode, @NonNull Node invokingTraceNode) {
		Relation2TraceGroup invokingRule2TraceGroup = invokingRelationAnalysis.getRule2TraceGroup();
		Relation2TraceClass invokingRule2TraceClass = invokingRule2TraceGroup.getRule2TraceClass();
		Invocation2TraceProperty invokingInvocation2TraceProperty = invokingRule2TraceClass.getInvocation2TraceProperty(this);
		Property invocationTraceProperty = invokingInvocation2TraceProperty.getTraceProperty();
		boolean isPartial = scheduleManager.computeIsPartial(invokedNode, invocationTraceProperty);
		invokingRelationAnalysis.createRealizedNavigationEdge(utility, invokingTraceNode, invocationTraceProperty, invokedNode, isPartial);
	}

	/**
	 * Create the invocation edge for an output domain of the invoked relation.
	 */
	protected abstract @NonNull NavigableEdge createOutputEdge(@NonNull Node invokedNode, @NonNull Property invocationProperty, @NonNull Node argumentNode);

	@Override
	public @NonNull Iterable<@NonNull Node> getArgumentNodes() {
		return rootVariable2argumentNode.values();
	}

	protected @NonNull Relation getBaseInvokedRelation() {
		return QVTrelationUtil.getBaseRelation(invokedRelationAnalysis.getRule());
	}

	protected @NonNull Relation2MiddleType getBaseInvokedRule2MiddleType() {
		Relation invokedRelation = invokedRelationAnalysis.getRule();
		Relation baseInvokedRelation = getBaseInvokedRelation();
		RelationAnalysis baseInvokedRelationAnalysis = scheduleManager.getRuleAnalysis(baseInvokedRelation);
		Relation2TraceGroup baseInvokedrelation2traceGroup = baseInvokedRelationAnalysis.getRule2TraceGroup();
		Relation2MiddleType baseInvokedRule2MiddleType;
		if (QVTrelationUtil.hasOverrides(invokedRelation)) {
			baseInvokedRule2MiddleType = baseInvokedrelation2traceGroup.getRule2DispatchClass();
		}
		else if (isTop()) {
			baseInvokedRule2MiddleType = baseInvokedrelation2traceGroup.getRule2TraceInterface();
		}
		else {
			baseInvokedRule2MiddleType = baseInvokedrelation2traceGroup.getRule2InvocationInterface();
		}
		return baseInvokedRule2MiddleType;
	}

	protected @NonNull ClassDatum getInvokedClassDatum() {
		TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
		Relation2MiddleType invokedRelation2InvocationInterface = getInvokedRelation2InvocationInterface();
		org.eclipse.ocl.pivot.Class invokedInvocationInterface = invokedRelation2InvocationInterface.getMiddleClass();
		return scheduleManager.getClassDatum(traceTypedModel, invokedInvocationInterface);
	}

	@Override
	public @NonNull RelationAnalysis getInvokedRelationAnalysis() {
		return invokedRelationAnalysis;
	}

	protected @NonNull Relation2MiddleType getInvokedRelation2InvocationInterface() {
		Relation2TraceGroup invokedBaserelation2traceGroup = invokedRelationAnalysis.getRule2TraceGroup().getBaseRelation2TraceGroup();
		Relation2MiddleType invokedRelation2InvocationInterface = invokedBaserelation2traceGroup.getRule2InvocationInterface();
		return invokedRelation2InvocationInterface;
	}

	@Override
	public @NonNull Node getInvokingNode() {
		Node invokingNode2 = this.invokingNode;
		if (invokingNode2 == null) {
			this.invokingNode = invokingNode2 = createInvocationNode();
		}
		return invokingNode2;
	}

	@Override
	public @NonNull RelationAnalysis getInvokingRelationAnalysis() {
		return invokingRelationAnalysis;
	}

	@Override
	public @Nullable SuccessEdge getGlobalSuccessEdge(@Nullable Boolean successStatus) {
		return null;
	}

	@Override
	public final boolean isOptional() {
		return utility.isNullable() || utility.isConditional();
	}

	@Override
	public @Nullable Boolean isOutput(@NonNull Node node) {
		return argumentNode2isOutput.get(node);
	}

	@Override
	public boolean isRealized() {
		assert invokingNode != null;
		return invokingNode.isRealized();
	}

	//	@Override
	//	public boolean isRequired() {
	//		return false;
	//	}

	@Override
	public boolean needsInvocationTraceProperty() {
		return true;
	}

	@Override
	public void setStrict(boolean isStrict) {
		assert invokingNode != null;
		invokingNode.setStrict(isStrict);
	}

	@Override
	public @NonNull Node synthesizeInvocationNodes(@NonNull Node invokingTraceNode) {
		Node invokingNode = getInvokingNode();
		//
		//	Integrate the invokedNode with the invokingTraceNode.
		//
		createInvokingTraceEdge(invokingNode, invokingTraceNode);
		//
		//	Create a global success status if appropriate.
		//
		getGlobalSuccessEdge(Boolean.TRUE);
		//
		//	Join the invokedNode to the argument nodes that bind it.
		//
		createInvocationEdges(invokingNode);
		return invokingNode;
	}
}