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
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.DispatchClass2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2DispatchClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2TraceGroup;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;
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

	protected void synthesizeDispatchHierarchy(@NonNull Node traceNode, @NonNull Relation2DispatchClass relation2dispatchClass, @NonNull Relation relation) {
		if (!relation.isIsAbstract()) {						// Cannot test abstract -must test all its overrides
			//
			//	Create a predicated node for the overriding relation's trace
			//
			QVTrelationScheduleManager scheduleManager =(QVTrelationScheduleManager)getScheduleManager();
			Relation2TraceClass relation2TraceClass = scheduleManager.getRuleAnalysis(relation).getRule2TraceGroup().getRule2TraceClass();
			Relation2MiddleType relation2TraceInterface = relationAnalysis.getRule2TraceGroup().getBaseRelation2TraceGroup().getRule2TraceInterface();
			TypedModel traceTypedModel = relationAnalysis.getTraceTypedModel();
			ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(traceTypedModel, relation2TraceClass.getMiddleClass());
			Node dispatchedNode = createPredicatedNode(Utility.NON_NULL_MATCHED, getName(relation), dispatchedClassDatum);
			//
			//	Reached by the appropriate dispatch navigation.
			//
			DispatchClass2TraceProperty dispatchClass2traceProperty = relation2dispatchClass.getDispatchClass2TraceProperty(relation);
			createNavigationEdge(Utility.NON_NULL_MATCHED, traceNode, dispatchClass2traceProperty.getTraceProperty(), dispatchedNode, false);
			//
			//	Require the overriding relation to have failed.
			//
			Property successProperty = relation2TraceInterface.getGlobalSuccessProperty();
			createPredicatedSuccess(Utility.NON_NULL_MATCHED, dispatchedNode, successProperty, false);
		}
		for (@NonNull Relation overridingRelation : QVTrelationUtil.getOverrides(relation)) {
			synthesizeDispatchHierarchy(traceNode, relation2dispatchClass, overridingRelation);
		}
	}

	/**
	 * Create a realized trace node, a predicated guard node per input root variable and a
	 * predicated property edge between them.
	 */
	public void synthesizeElements() {
		Relation2TraceGroup rule2traceGroup = relationAnalysis.getRule2TraceGroup();
		Relation2DispatchClass relation2dispatchClass = rule2traceGroup.getRule2DispatchClass();
		//
		//	Create the trace node
		//
		Node traceNode = synthesizeTraceNode(relation2dispatchClass);
		//
		//	Create the trace node assignments to pattern nodes
		//
		synthesizeDispatchHierarchy(traceNode, relation2dispatchClass, relation);
	}

	/**
	 *	Create the trace node
	 */
	protected @NonNull Node synthesizeTraceNode(@NonNull Relation2DispatchClass relation2dispatchClass) {
		QVTrelationScheduleManager scheduleManager =(QVTrelationScheduleManager)getScheduleManager();
		TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
		ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(traceTypedModel, relation2dispatchClass.getMiddleClass());
		Node traceNode = createPredicatedNode(Utility.NON_NULL_MATCHED, getName(relation), dispatchedClassDatum);
		region.getHeadNodes().add(traceNode);
		traceNode.setHead();

		Property successProperty = relation2dispatchClass.getDispatchSuccessProperty();
		createRealizedSuccess(Utility.NON_NULL_MATCHED, traceNode, successProperty, false);

		return traceNode;
	}
}