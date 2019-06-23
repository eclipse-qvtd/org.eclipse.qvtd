/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.UtilityAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.DispatchClass2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2DispatchClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.VariableDeclaration2TraceProperty;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.Node.Utility;

/**
 * A RelationDispatchAnalysis assists in the synthesis of the dispatch for an override hierarchy.
 */
public class RelationDispatchAnalysis extends RegionHelper<@NonNull RuleRegion>
{
	protected final @NonNull RelationAnalysis relationAnalysis;
	protected final @NonNull Relation relation;

	public RelationDispatchAnalysis(@NonNull RelationAnalysis relationAnalysis, @NonNull DispatchRegion dispatchRegion) {
		super(relationAnalysis.getScheduleManager(), dispatchRegion);
		this.relationAnalysis = relationAnalysis;
		this.relation = relationAnalysis.getRule();
	}

	public void gatherRuleRegions(@NonNull List<@NonNull RuleRegion> ruleRegions) {
		ruleRegions.add(region);
	}

	protected void synthesizeDispatchHierarchy(@NonNull Node traceNode, @NonNull RelationAnalysis2DispatchClass relationAnalysis2dispatchClass, @NonNull Relation relation) {
		if (!relation.isIsAbstract()) {
			QVTrelationScheduleManager scheduleManager =(QVTrelationScheduleManager)getScheduleManager();
			RelationAnalysis2TraceClass relationAnalysis2TraceClass = scheduleManager.getRuleAnalysis(relation).getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceClass();
			TypedModel traceTypedModel = relationAnalysis.getTraceTypedModel();
			ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(traceTypedModel, relationAnalysis2TraceClass.getMiddleClass());
			Node dispatchedNode = createRealizedNode(getName(relation), dispatchedClassDatum, true);
			DispatchClass2TraceProperty dispatchClass2traceProperty = relationAnalysis2dispatchClass.getDispatchClass2TraceProperty(relation);
			createRealizedNavigationEdge(traceNode, dispatchClass2traceProperty.getTraceProperty(), dispatchedNode, false);
		}
		for (@NonNull Relation overridingRelation : QVTrelationUtil.getOverrides(relation)) {
			synthesizeDispatchHierarchy(traceNode, relationAnalysis2dispatchClass, overridingRelation);
		}
	}

	/**
	 * Create a realized trace node, a predicated guard node per input root variable and a
	 * predicated property edge between them.
	 */
	public void synthesizeElements() {
		RelationAnalysis2TraceGroup ruleAnalysis2TraceGroup = relationAnalysis.getRuleAnalysis2TraceGroup();
		RelationAnalysis2DispatchClass relationAnalysis2dispatchClass = ruleAnalysis2TraceGroup.getRuleAnalysis2DispatchClass();
		//
		//	Create the trace node
		//
		Node traceNode = synthesizeTraceNode(relationAnalysis2dispatchClass);
		//
		//	Create the trace node assignments to guard nodes
		//
		synthesizeTraceEdges(traceNode);
		//
		//	Create the trace node assignments to pattern nodes
		//
		synthesizeDispatchHierarchy(traceNode, relationAnalysis2dispatchClass, relation);
		//
		//
		//
		//			Iterable<@NonNull Node> headNodes = RuleHeadAnalysis.computeRuleHeadNodes(scheduleManager, region, null);
		//			List<@NonNull Node> headNodesList = QVTscheduleUtil.Internal.getHeadNodesList(region);
		//			headNodesList.clear();
		//			Iterables.addAll(headNodesList, headNodes);
		UtilityAnalysis.assignUtilities(scheduleManager, region);
	}

	/**
	 *	Create the trace node assignments to pattern nodes
	 */
	protected void synthesizeTraceEdges(@NonNull Node traceNode) {
		//			assert region.getHeadNodes().isEmpty();
		boolean isTopLevel = relation.isIsTopLevel();
		RelationAnalysis2TraceGroup ruleAnalysis2TraceGroup = relationAnalysis.getRuleAnalysis2TraceGroup();
		RelationAnalysis2DispatchClass ruleAnalysis2dispatchClass = ruleAnalysis2TraceGroup.getRuleAnalysis2DispatchClass();
		for (@NonNull RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			if (scheduleManager.isInput(relationDomain)) {
				for (@NonNull VariableDeclaration variable : QVTrelationUtil.getRootVariables(relationDomain)) {
					VariableDeclaration2TraceProperty variableDeclaration2traceClassProperty = ruleAnalysis2dispatchClass.getVariableDeclaration2TraceProperty(variable);
					//						VariableDeclaration2TraceProperty variableDeclaration2traceInterfaceProperty = ruleAnalysis2traceInterface.getVariableDeclaration2TraceProperty(variable);
					Property traceClassProperty = variableDeclaration2traceClassProperty.getTraceProperty();
					//						Property traceInterfaceProperty = variableDeclaration2traceInterfaceProperty.getTraceProperty();
					Node targetNode = createOldNode(variable);
					boolean isPartial = scheduleManager.computeIsPartial(targetNode, traceClassProperty);
					createNavigationEdge(traceNode, traceClassProperty, targetNode, isPartial);
					if (isTopLevel) {
						region.getHeadNodes().add(targetNode);
						targetNode.setHead();
					}
				}
			}
		}




		/*			Relation relation = getRule();
		RelationAnalysis relationAnalysis = RelationAnalysis.this.getScheduleManager().getRuleAnalysis(relation);
		RelationAnalysis2TraceGroup relationAnalysis2TraceGroup = relationAnalysis.getRuleAnalysis2TraceGroup();
		RelationAnalysis2MiddleType relationAnalysis2TraceClass = relationAnalysis2TraceGroup.getRuleAnalysis2TraceClass();
		Property successProperty = relationAnalysis2TraceClass.getSuccessProperty();
		Node falseNode = createBooleanValueNode(true, false);
		createNavigationEdge(traceNode, successProperty, falseNode, false); */
	}

	/**
	 *	Create the trace node
	 */
	protected @NonNull Node synthesizeTraceNode(@NonNull RelationAnalysis2DispatchClass relationAnalysis2dispatchClass) {
		TypedModel traceTypedModel = relationAnalysis.getTraceTypedModel();
		ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(traceTypedModel, relationAnalysis2dispatchClass.getMiddleClass());
		if (relation.isIsTopLevel()) {
			VariableNode realizedDispatchNode = createRealizedNode(QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME, dispatchedClassDatum, true);
			realizedDispatchNode.setUtility(Utility.TRACE);
			return realizedDispatchNode;
		}
		else {
			Node predicatedDispatchNode = createPredicatedNode(QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME, dispatchedClassDatum, true);
			predicatedDispatchNode.setUtility(Utility.TRACE);
			region.getHeadNodes().add(predicatedDispatchNode);
			predicatedDispatchNode.setHead();
			return predicatedDispatchNode;
		}
	}
}