/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.AbstractPartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionPropertyAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

public abstract class AbstractRegionAnalysis extends AbstractPartialRegionAnalysis<@NonNull RegionsAnalysis>
{
	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;

	/**
	 * The trace nodes and their corresponding global success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2globalSuccessEdge = new HashMap<>();

	/**
	 * The trace nodes and their corresponding local success node.
	 *
	 * There should normally be exactly one trace node.
	 *
	 * There is no trace node for Adolfo's prematurely folded middle optimization and for manual partitionings
	 * such as attributeColumns in testQVTcCompiler_SimpleUML2RDBMS_CG.
	 *
	 * There could be multiple trace nodes after an early merge results. Work in progress.
	 */
	private final @NonNull Map<@NonNull Node, @Nullable SuccessEdge> traceNode2localSuccessEdge = new HashMap<>();

	/**
	 * The map from node to the trace edge by which the node may be located by lookup in a trace node once its trace edge is realized..
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Edge> node2traceEdge = new HashMap<>();

	protected AbstractRegionAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis) {
		super(transformationAnalysis);
		this.transformationAnalysis = transformationAnalysis;
	}

	protected @NonNull List<@NonNull Node> analyze() {
		analyzeNodes();
		for (@NonNull Node traceNode : analyzeTraceNodes()) {
			//	analyzeLocalSuccessEdge(traceNode);  -- no intial local success
			analyzeGlobalSuccessEdge(traceNode);
			analyzeTraceEdges(traceNode);
		}
		analyzeEdges();
		List<@NonNull Node> alreadyRealized = new ArrayList<>(getTraceNodes());
		Node dispatchNode = basicGetDispatchNode();
		if (dispatchNode != null) {
			alreadyRealized.add(dispatchNode);
		}
		return alreadyRealized;
	}

	private void analyzeGlobalSuccessEdge(@NonNull Node traceNode) {
		SuccessEdge globalSuccessEdge = null;
		Rule2TraceGroup rule2traceGroup = basicGetRule2TraceGroup();
		if (rule2traceGroup != null) {
			Element2MiddleProperty relation2globalSuccessProperty = rule2traceGroup.basicGetRelation2GlobalSuccessProperty();
			if (relation2globalSuccessProperty != null) {
				Property globalSuccessProperty = relation2globalSuccessProperty.getTraceProperty();
				NavigationEdge statusNavigationEdge = QVTscheduleUtil.basicGetOutgoingNavigationEdge(traceNode, globalSuccessProperty);
				if (statusNavigationEdge != null) {
					globalSuccessEdge = (SuccessEdge) statusNavigationEdge;
				}
				else {		// Never needed
					/*				if (!(region instanceof DispatchRegion) && !(region instanceof VerdictRegion)) {
						RegionHelper<@NonNull MappingRegion> regionHelper = new RegionHelper<>(scheduleManager, (MappingRegion)region);
						successEdge = regionHelper.createRealizedSuccess(traceNode, successProperty, null);		// FIXME This creates a premature success in a speculation
					} */
				}
			}
		}
		traceNode2globalSuccessEdge.put(traceNode, globalSuccessEdge);
	}

	protected void analyzeLocalSuccessEdge(@NonNull Node traceNode) {
		SuccessEdge localSuccessEdge = null;
		Rule2TraceGroup rule2traceGroup = basicGetRule2TraceGroup();
		if (rule2traceGroup != null) {
			Element2MiddleProperty relation2localSuccessProperty = rule2traceGroup.basicGetRelation2LocalSuccessProperty();
			if (relation2localSuccessProperty != null) {
				Property localSuccessProperty = relation2localSuccessProperty.getTraceProperty();
				NavigationEdge statusNavigationEdge = QVTscheduleUtil.basicGetOutgoingNavigationEdge(traceNode, localSuccessProperty);
				if (statusNavigationEdge != null) {
					localSuccessEdge = (SuccessEdge) statusNavigationEdge;
				}
				else {		// Never needed
					/*				if (!(region instanceof DispatchRegion) && !(region instanceof VerdictRegion)) {
						RegionHelper<@NonNull MappingRegion> regionHelper = new RegionHelper<>(scheduleManager, (MappingRegion)region);
						successEdge = regionHelper.createRealizedSuccess(traceNode, successProperty, null);		// FIXME This creates a premature success in a speculation
					} */
				}
			}
		}
		//	System.out.println(NameUtil.debugSimpleName(this) + "\"" + getName() + "\" : " +  NameUtil.debugSimpleName(traceNode) + " !=> " + NameUtil.debugSimpleName(localSuccessEdge));
		traceNode2localSuccessEdge.put(traceNode, localSuccessEdge);
	}

	private void analyzeTraceEdges(@NonNull Node traceNode) {
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(traceNode)) {
			assert !edge.isCast();
			if ((edge.isNavigation() && isRealized(edge))) {
				Node tracedNode = QVTscheduleUtil.getTargetNode(edge);
				node2traceEdge.put(tracedNode, edge);
			}
		}
	}

	private @NonNull Iterable<@NonNull Node> analyzeTraceNodes() {
		/*		if (realizedMiddleNodes.size() == 0) {
			return Collections.emptyList();
		}
		if (realizedMiddleNodes.size() == 1) {
			return Collections.singletonList(realizedMiddleNodes.get(0));
		}
		Iterable<@NonNull Node> headNodes = RuleHeadAnalysis.computeRealizedHeadNodes(region, realizedMiddleNodes);
		if (Iterables.size(headNodes) == 0) {
			return Collections.emptyList();
		}
		else {
			return Collections.singletonList(headNodes.iterator().next());
		} */
		return Iterables.concat(getPredicatedMiddleNodes(), getRealizedMiddleNodes());
	}

	public @Nullable SuccessEdge basicGetGlobalSuccessEdge(@NonNull Node traceNode) {
		return traceNode2globalSuccessEdge.get(traceNode);
	}

	public @Nullable Node basicGetGlobalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = traceNode2globalSuccessEdge.get(traceNode);
		return successEdge != null ? successEdge.getTargetNode() : null;
	}

	public @Nullable SuccessEdge basicGetLocalSuccessEdge(@NonNull Node traceNode) {
		//	System.out.println(NameUtil.debugSimpleName(this) + "\"" + getName() + "\" : " + NameUtil.debugSimpleName(traceNode));
		return traceNode2localSuccessEdge.get(traceNode);
	}

	public @Nullable Node basicGetLocalSuccessNode(@NonNull Node traceNode) {
		//	System.out.println(NameUtil.debugSimpleName(this) + "\"" + getName() + "\" : " + NameUtil.debugSimpleName(traceNode));
		SuccessEdge successEdge = traceNode2localSuccessEdge.get(traceNode);
		return successEdge != null ? successEdge.getTargetNode() : null;
	}

	public @Nullable Rule2TraceGroup basicGetRule2TraceGroup() {
		Rule referredRule = QVTscheduleUtil.getReferredRule((RuleRegion)getRegion());
		RuleAnalysis ruleAnalysis = transformationAnalysis.getRuleAnalysis(referredRule);
		return ruleAnalysis.basicGetRule2TraceGroup();
	}

	public @NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> getClassAnalysis(@NonNull ClassDatum classDatum) {
		return partialRegionsAnalysis.getClassAnalysis(classDatum);
	}

	public @NonNull SuccessEdge getGlobalSuccessEdge(@NonNull Node traceNode) {
		return ClassUtil.nonNullState(traceNode2globalSuccessEdge.get(traceNode));
	}

	public @NonNull Node getGlobalSuccessNode(@NonNull Node traceNode) {
		SuccessEdge successEdge = ClassUtil.nonNullState(traceNode2globalSuccessEdge.get(traceNode));
		return QVTscheduleUtil.getTargetNode(successEdge);
	}

	public @NonNull SuccessEdge getLocalSuccessEdge(@NonNull Node traceNode) {
		//	System.out.println(NameUtil.debugSimpleName(this) + "\"" + getName() + "\" : " + NameUtil.debugSimpleName(traceNode));
		return ClassUtil.nonNullState(traceNode2localSuccessEdge.get(traceNode));
	}

	public @NonNull Node getLocalSuccessNode(@NonNull Node traceNode) {
		//	System.out.println(NameUtil.debugSimpleName(this) + "\"" + getName() + "\" : " + NameUtil.debugSimpleName(traceNode));
		SuccessEdge successEdge = ClassUtil.nonNullState(traceNode2localSuccessEdge.get(traceNode));
		return QVTscheduleUtil.getTargetNode(successEdge);
	}

	public @NonNull PartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> getPropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		return partialRegionsAnalysis.getPropertyAnalysis(propertyDatum);
	}

	public @Nullable Role getRole(@NonNull Edge edge) {
		return  edge.getEdgeRole();
	}

	public @Nullable Role getRole(@NonNull Node node) {
		return  node.getNodeRole();
	}

	public @NonNull Rule2TraceGroup getRule2TraceGroup() {
		Rule referredRule = QVTscheduleUtil.getReferredRule((RuleRegion)getRegion());
		RuleAnalysis ruleAnalysis = transformationAnalysis.getRuleAnalysis(referredRule);
		return ruleAnalysis.getRule2TraceGroup();
	}

	@Override
	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @Nullable Edge getTraceEdge(@NonNull Node node) {
		return node2traceEdge.get(node);
	}

	@Override
	protected boolean isConstant(@NonNull Edge edge) {
		return edge.isConstant();
	}

	@Override
	protected boolean isLoaded(@NonNull Edge edge) {
		return edge.isLoaded();
	}

	@Override
	protected boolean isLoaded(@NonNull Node node) {
		return node.isLoaded();
	}

	@Override
	protected boolean isPredicated(@NonNull Edge edge) {
		return edge.isPredicated();
	}

	@Override
	protected boolean isPredicated(@NonNull Node node) {
		return node.isPredicated();
	}

	@Override
	protected boolean isRealized(@NonNull Edge edge) {
		return edge.isRealized();
	}

	@Override
	protected boolean isRealized(@NonNull Node node) {
		return node.isRealized();
	}

	@Override
	protected boolean isSpeculated(@NonNull Edge edge) {
		return edge.isSpeculated();
	}

	@Override
	protected boolean isSpeculated(@NonNull Node node) {
		return node.isSpeculated();
	}

	@Override
	protected boolean isSpeculation(@NonNull Node node) {
		return node.isSpeculation();
	}
}