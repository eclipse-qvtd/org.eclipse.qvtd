/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Invocation2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceGroup;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

/**
 * An InvocationAnalysis identifies the invocation of one Relation from another.
 */
public class InvocationAnalysis
{


	protected final @NonNull RelationAnalysis invokingRelationAnalysis;
	protected final @NonNull RelationAnalysis invokedRelationAnalysis;
	protected final boolean isWhen;
	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode = new HashMap<>();

	public InvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RelationAnalysis invokedRelationAnalysis,
			@NonNull RelationCallExp relationCallExp, boolean isWhen) {
		this.invokingRelationAnalysis = invokingRelationAnalysis;
		this.invokedRelationAnalysis = invokedRelationAnalysis;
		this.isWhen = isWhen;
	}

	public void add(@NonNull VariableDeclaration rootVariable, @NonNull Node argumentNode) {
		Node oldNode = rootVariable2argumentNode.put(rootVariable, argumentNode);
		assert oldNode == null;
	}

	public @NonNull RelationAnalysis getInvokedRelationAnalysis() {
		return invokedRelationAnalysis;
	}

	public @NonNull RelationAnalysis getInvokingRelationAnalysis() {
		return invokingRelationAnalysis;
	}

	public boolean isWhen() {
		return isWhen;
	}

	public void synthesizeInvocationNodes(@NonNull Node invokingTraceNode) {
		QVTrelationScheduleManager scheduleManager = invokedRelationAnalysis.getScheduleManager();
		QVTrelationNameGenerator nameGenerator = scheduleManager.getNameGenerator();	// FIXME unique names
		Relation invokedRelation = invokedRelationAnalysis.getRule();
		String name = isWhen ? nameGenerator.createWhenInvocationPropertyName(invokedRelation)
			: nameGenerator.createWhereInvocationPropertyName(invokedRelation);
		TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
		Relation invokingRelation = invokingRelationAnalysis.getRule();
		RelationAnalysis2TraceGroup invokingRuleAnalysis2TraceGroup = invokingRelationAnalysis.getRuleAnalysis2TraceGroup();
		RelationAnalysis2TraceClass invokingRuleAnalysis2TraceClass = invokingRuleAnalysis2TraceGroup.getRuleAnalysis2TraceClass();
		RelationAnalysis2TraceGroup invokedRuleAnalysis2TraceGroup = invokedRelationAnalysis.getRuleAnalysis2TraceGroup();
		Node invokedNode;
		if (isWhen) {
			RelationAnalysis2TraceGroup invokedBaseRelationAnalysis2TraceGroup = invokedRuleAnalysis2TraceGroup.getBaseRelationAnalysis2TraceGroup();
			RelationAnalysis2MiddleType invokedRelationAnalysis2InvocationInterface = invokedBaseRelationAnalysis2TraceGroup.getRuleAnalysis2InvocationInterface();
			org.eclipse.ocl.pivot.Class invokedInvocationInterface = invokedRelationAnalysis2InvocationInterface.getMiddleClass();
			ClassDatum classDatum = scheduleManager.getClassDatum(traceTypedModel, invokedInvocationInterface);
			invokedNode = invokingRelationAnalysis.createPredicatedNode(name, classDatum, true);
			if (invokingRelation.isIsTopLevel()) {
				Invocation2TraceProperty invokingInvocation2TraceProperty = invokingRuleAnalysis2TraceClass.getInvocation2TraceProperty(this);
				invokingRelationAnalysis.createRealizedNavigationEdge(invokingTraceNode, invokingInvocation2TraceProperty.getTraceProperty(), invokedNode, false);
			}
			Element2MiddleProperty relation2SuccessProperty = invokedRelationAnalysis2InvocationInterface.basicGetRelation2SuccessProperty();
			if (relation2SuccessProperty != null) {
				Property statusProperty = relation2SuccessProperty.getTraceProperty();
				invokingRelationAnalysis.createPredicatedSuccess(invokedNode, statusProperty, true);
			}
		}
		else {
			org.eclipse.ocl.pivot.Class invokedInvocationClass = invokedRuleAnalysis2TraceGroup.getInvocationClass();
			ClassDatum classDatum = scheduleManager.getClassDatum(traceTypedModel, invokedInvocationClass);
			invokedNode = invokingRelationAnalysis.createRealizedNode(name, classDatum, true);
			Invocation2TraceProperty invokingInvocation2TraceProperty = invokingRuleAnalysis2TraceClass.getInvocation2TraceProperty(this);
			Property invocationProperty = invokingInvocation2TraceProperty.getTraceProperty();
			invokingRelationAnalysis.createRealizedNavigationEdge(invokingTraceNode, invocationProperty, invokedNode, null);
		}
		Relation baseInvokedRelation = QVTrelationUtil.getBaseRelation(invokedRelationAnalysis.getRule());
		RelationAnalysis baseInvokedRelationAnalysis = scheduleManager.getRuleAnalysis(baseInvokedRelation);
		RelationAnalysis2TraceGroup baseInvokedRelationAnalysis2TraceGroup = baseInvokedRelationAnalysis.getRuleAnalysis2TraceGroup();
		RelationAnalysis2MiddleType baseInvokedRuleAnalysis2MiddleType;
		if (QVTrelationUtil.hasOverrides(invokedRelation)) {
			baseInvokedRuleAnalysis2MiddleType = baseInvokedRelationAnalysis2TraceGroup.getRuleAnalysis2DispatchClass();
		}
		else if (invokedRelation.isIsTopLevel()) {
			baseInvokedRuleAnalysis2MiddleType = baseInvokedRelationAnalysis2TraceGroup.getRuleAnalysis2TraceInterface();
		}
		else {
			baseInvokedRuleAnalysis2MiddleType = baseInvokedRelationAnalysis2TraceGroup.getRuleAnalysis2InvocationInterface();
		}
		for (@NonNull VariableDeclaration rootVariable : rootVariable2argumentNode.keySet()) {
			Node argumentNode = rootVariable2argumentNode.get(rootVariable);
			assert argumentNode != null;
			VariableDeclaration overriddenRootVariable = QVTrelationUtil.getOverriddenVariable(baseInvokedRelation, rootVariable);
			Property invocationProperty = baseInvokedRuleAnalysis2MiddleType.getTraceProperty(overriddenRootVariable);
			//				if (isWhen) {

			//				}
			//				else {
			invokingRelationAnalysis.createNavigationEdge(invokedNode, invocationProperty, argumentNode, null);
			//				}
		}

	}

	@Override
	public @NonNull String toString() {
		return invokingRelationAnalysis.getRule().getName() + "==" + (isWhen ? "when" : "where") + "==>" + invokedRelationAnalysis.getRule().getName();
	}
}