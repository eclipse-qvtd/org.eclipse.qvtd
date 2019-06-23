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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.UtilityAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.DispatchClass2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2DispatchClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceGroup;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion;

/**
 * A RelationVerdictAnalysis assists in the synthesis of the base region that assigns the false success once all overrides have failed.
 */
public class RelationVerdictAnalysis extends RegionHelper<@NonNull RuleRegion>
{
	protected final @NonNull RelationAnalysis relationAnalysis;
	protected final @NonNull Relation relation;

	public RelationVerdictAnalysis(@NonNull RelationAnalysis relationAnalysis, @NonNull VerdictRegion verdictRegion) {
		super(relationAnalysis.getScheduleManager(), verdictRegion);
		this.relationAnalysis = relationAnalysis;
		this.relation = relationAnalysis.getRule();
	}

	public void gatherRuleRegions(@NonNull List<@NonNull RuleRegion> ruleRegions) {
		ruleRegions.add(getRegion());
	}

	protected void synthesizeDispatchHierarchy(@NonNull Node traceNode, @NonNull RelationAnalysis2DispatchClass relationAnalysis2dispatchClass, @NonNull Relation relation) {
		if (!relation.isIsAbstract()) {						// Cannot test abstract -must test all its overrides
			//
			//	Create a predicated node for the overriding relation's trace
			//
			QVTrelationScheduleManager scheduleManager =(QVTrelationScheduleManager)getScheduleManager();
			RelationAnalysis2TraceClass relationAnalysis2TraceClass = scheduleManager.getRuleAnalysis(relation).getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceClass();
			RelationAnalysis2MiddleType relationAnalysis2TraceInterface = relationAnalysis.getBaseRelationAnalysis().getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceInterface();
			TypedModel traceTypedModel = relationAnalysis.getTraceTypedModel();
			ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(traceTypedModel, relationAnalysis2TraceClass.getMiddleClass());
			Node dispatchedNode = createPredicatedNode(getName(relation), dispatchedClassDatum, true);
			//
			//	Reached by the appropriate dispatch navigation.
			//
			DispatchClass2TraceProperty dispatchClass2traceProperty = relationAnalysis2dispatchClass.getDispatchClass2TraceProperty(relation);
			createNavigationEdge(traceNode, dispatchClass2traceProperty.getTraceProperty(), dispatchedNode, false);
			//
			//	Require the overriding relation to have failed.
			//
			Property successProperty = relationAnalysis2TraceInterface.getGlobalSuccessProperty(getScheduleManager().getTargetTypedModel());
			createPredicatedSuccess(dispatchedNode, successProperty, false);
		}
		for (@NonNull Relation overridingRelation : QVTrelationUtil.getOverrides(relation)) {
			synthesizeDispatchHierarchy(traceNode, relationAnalysis2dispatchClass, overridingRelation);
		}
	}

	/**
	 * Create a realized trace node, a predicatec guard node per input root variable and a
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
		//	Create the trace node assignments to pattern nodes
		//
		synthesizeDispatchHierarchy(traceNode, relationAnalysis2dispatchClass, relation);
		//
		UtilityAnalysis.assignUtilities(scheduleManager, region);
	}

	/**
	 *	Create the trace node
	 */
	protected @NonNull Node synthesizeTraceNode(@NonNull RelationAnalysis2DispatchClass relationAnalysis2dispatchClass) {
		QVTrelationScheduleManager scheduleManager =(QVTrelationScheduleManager)getScheduleManager();
		TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
		ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(traceTypedModel, relationAnalysis2dispatchClass.getMiddleClass());
		Node traceNode = createPredicatedNode(getName(relation), dispatchedClassDatum, true);
		region.getHeadNodes().add(traceNode);
		traceNode.setHead();

		Property successProperty = relationAnalysis2dispatchClass.getDispatchSuccessProperty();
		createRealizedSuccess(traceNode, successProperty, false);

		return traceNode;
	}
}