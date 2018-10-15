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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.LegacyContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CastEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CastInitializerCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionVisitor;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.ConstantTargetCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.MultipleEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.NavigableEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.NonNullInitializerCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.PredicateEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.PredicateNavigationEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Sets;

/**
 * The FallibilityAnalysis identifies why individual Mappings may fail allowing cycles of Mappings whose
 * cycle members succeed conditionally to succeed unconditionally.
 *
 * The regions/mappings are first accumulate()'d, then the closure of the accumulated results are install()'d
 * within each RegionAnalysis.
 */
public class FallibilityAnalysis
{
	public static final @NonNull TracingOption GLOBAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/fallibility/global");
	public static final @NonNull TracingOption LOCAL = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/fallibility/local");

	protected class Visitor implements CheckedConditionVisitor<Object>
	{
		protected final @NonNull Partition partition;
		protected final @NonNull RegionAnalysis regionAnalysis;

		/**
		 * Map from the fallible producing RegionAnalysis to the single CheckCondition or Set<@NonNull CheckCondition> that
		 * depends on the producing RegionAnalysis.
		 */
		protected final @NonNull Map<@NonNull CheckedCondition, @NonNull Object> check2regionOrRegions = new HashMap<>();

		public Visitor(@NonNull Partition partition, @NonNull RegionAnalysis regionAnalysis) {
			this.partition = partition;
			this.regionAnalysis = regionAnalysis;
		}

		private void addFallibility(@NonNull CheckedCondition checkedCondition, @NonNull RegionAnalysis producingRegionAnalysis) {
			if (LOCAL.isActive()) {
				LOCAL.println(partition + " may fail because " + checkedCondition + " produced by " + producingRegionAnalysis);
			}
			Object regionOrRegions = check2regionOrRegions.get(checkedCondition);
			if (regionOrRegions == null) {
				check2regionOrRegions.put(checkedCondition, producingRegionAnalysis);
			}
			else if (regionOrRegions instanceof RegionAnalysis) {
				if (regionOrRegions != producingRegionAnalysis) {
					Set<@NonNull RegionAnalysis> regions = new HashSet<>();
					check2regionOrRegions.put(checkedCondition, regions);
					regions.add((RegionAnalysis) regionOrRegions);
					regions.add(producingRegionAnalysis);
				}
			}
			else {
				@SuppressWarnings("unchecked")
				Set<@NonNull RegionAnalysis> regions = (Set<@NonNull RegionAnalysis>) regionOrRegions;
				regions.add(producingRegionAnalysis);
			}
		}

		public @NonNull Map<@NonNull CheckedCondition, @NonNull Object> analyze() {
			List<@NonNull Node> rootNodes = new ArrayList<>();
			for (@NonNull Node node : partition.getPartialNodes()) {
				Role nodeRole = partition.getRole(node);
				if (nodeRole != null) {
					if (partition.isHead(node) || nodeRole.isConstant()) {
						rootNodes.add(node);
					}
				}
			}
			List<@NonNull NavigableEdge> navigableEdges = new ArrayList<>();
			for (@NonNull Edge edge : partition.getPartialEdges()) {
				if (edge.isNavigation()) {
					Role edgeRole = partition.getRole(edge);
					if ((edgeRole != null) && edgeRole.isOld()) {
						navigableEdges.add((NavigableEdge) edge);
					}
				}
			}
			CheckedConditionAnalysis analysis = new CheckedConditionAnalysis(partition, scheduleManager)
			{
				@Override
				protected @Nullable Set<@NonNull Property> computeCheckedProperties() {
					return null;
				}
			};
			Set<@NonNull CheckedCondition> checkedConditions = analysis.computeCheckedConditions();
			//			System.out.println(region + ": " + checkedConditions);
			for (@NonNull CheckedCondition checkedCondition : checkedConditions) {
				checkedCondition.accept(this);
			}
			return check2regionOrRegions;
		}

		@Override
		public Object visitCastEdgeCheckedCondition(@NonNull CastEdgeCheckedCondition castEdgeCheckedCondition) {
			NavigableEdge castEdge = castEdgeCheckedCondition.getCastEdge();
			Node sourceNode = QVTscheduleUtil.getSourceNode(castEdge);
			if (!sourceNode.isDispatch()) {		// A dispatch pattern type error is a non-invocation not a failure
				addFallibility(castEdgeCheckedCondition, getFailSometimes());
			}
			return null;
		}

		@Override
		public Object visitCastInitializerCheckedCondition(@NonNull CastInitializerCheckedCondition castInitializerCheckedCondition) {
			addFallibility(castInitializerCheckedCondition, getFailSometimes());
			return null;
		}

		@Override
		public Object visitConstantTargetCheckedCondition(@NonNull ConstantTargetCheckedCondition constantTargetCheckedCondition) {
			addFallibility(constantTargetCheckedCondition, getFailSometimes());
			return null;
		}

		@Override
		public Object visitMultipleEdgeCheckedCondition(@NonNull MultipleEdgeCheckedCondition multipleEdgeCheckedCondition) {
			addFallibility(multipleEdgeCheckedCondition, getFailSometimes());
			return null;
		}

		@Override
		public Object visitNavigableEdgeCheckedCondition(@NonNull NavigableEdgeCheckedCondition navigableEdgeCheckedCondition) {
			addFallibility(navigableEdgeCheckedCondition, getFailSometimes());
			return null;
		}

		@Override
		public Object visitNonNullInitializerCheckedCondition(@NonNull NonNullInitializerCheckedCondition nonNullInitializerCheckedCondition) {
			addFallibility(nonNullInitializerCheckedCondition, getFailSometimes());
			return null;
		}

		@Override
		public Object visitPredicateEdgeCheckedCondition(@NonNull PredicateEdgeCheckedCondition predicateEdgeCheckedCondition) {
			addFallibility(predicateEdgeCheckedCondition, getFailSometimes());
			return null;
		}

		@Override
		public Object visitPredicateNavigationEdgeCheckedCondition(@NonNull PredicateNavigationEdgeCheckedCondition predicateNavigationEdgeCheckedCondition) {
			boolean allSuccessesResolved = true;
			NavigationEdge navigationEdge = predicateNavigationEdgeCheckedCondition.getNavigationEdge();
			if (!navigationEdge.isSuccess()) {
				allSuccessesResolved = false;
			}
			else {
				Node sourceNode = QVTscheduleUtil.getSourceNode(navigationEdge);
				Node targetNode = QVTscheduleUtil.getTargetNode(navigationEdge);
				if (!(targetNode instanceof BooleanLiteralNode) || ! ((BooleanLiteralNode)targetNode).isBooleanValue()) {
					allSuccessesResolved = false;
				}
				else {
					ClassDatum classDatum = QVTscheduleUtil.getClassDatum(sourceNode);
					Iterable<@NonNull RuleRegion> contentsGetProducingRegions = originalContentsAnalysis.getProducingRegions(classDatum);
					for (@NonNull RuleRegion producingRegion : contentsGetProducingRegions) {
						//						if (producingRegion instanceof MappingRegion) {
						RegionAnalysis producingRegionAnalysis = transformationAnalysis.getRegionAnalysis(producingRegion);
						addFallibility(predicateNavigationEdgeCheckedCondition, producingRegionAnalysis);
						//						}
						//						else {
						//							allSuccessesResolved = false;
						//						}
					}
				}
			}
			if (!allSuccessesResolved) {
				addFallibility(predicateNavigationEdgeCheckedCondition, getFailSometimes());
			}
			return null;
		}
	}

	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull LegacyContentsAnalysis originalContentsAnalysis;
	private @Nullable RegionAnalysis failSometimes = null;

	private @NonNull Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> consumer2producers = new HashMap<>();

	public FallibilityAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis) {
		this.transformationAnalysis = transformationAnalysis;
		this.scheduleManager = transformationAnalysis.getScheduleManager();
		this.originalContentsAnalysis = scheduleManager.getOriginalContentsAnalysis();
	}

	public void accumulate(@NonNull Partition consumingPartition, @NonNull RegionAnalysis consumingRegionAnalysis) {
		String name = consumingRegionAnalysis.getName();
		if ("mTmapIfExp_success_t1atlCondition_t1atlElse_t1atlTh".equals(name)) {
			getClass();
		}
		Visitor visitor = new Visitor(consumingPartition, consumingRegionAnalysis);
		Map<@NonNull CheckedCondition, @NonNull Object> check2regionOrRegions = visitor.analyze();
		Set<@NonNull RegionAnalysis> producingRegionAnalyses = new HashSet<>();
		Set<@NonNull Edge> checkedEdges = new HashSet<>();
		Set<@NonNull Node> checkedNodes = new HashSet<>();
		for (@NonNull CheckedCondition checkedCondition : check2regionOrRegions.keySet()) {
			Iterable<@NonNull Edge> conditionEdges = checkedCondition.getEdges();
			if (conditionEdges != null) {
				for (@NonNull Edge conditionEdge : conditionEdges) {
					checkedEdges.add(conditionEdge);
				}
			}
			Node conditionNode = checkedCondition.getNode();
			if (conditionNode != null) {
				checkedNodes.add(conditionNode);
			}
			Object regionOrRegions = check2regionOrRegions.get(checkedCondition);
			assert regionOrRegions != null;
			if (regionOrRegions instanceof RegionAnalysis) {
				producingRegionAnalyses.add((RegionAnalysis) regionOrRegions);
			}
			else {
				@SuppressWarnings("unchecked")
				Iterable<@NonNull RegionAnalysis> producingRegions = (Iterable<@NonNull RegionAnalysis>) regionOrRegions;
				for (@NonNull RegionAnalysis producingRegionAnalysis : producingRegions) {
					producingRegionAnalyses.add(producingRegionAnalysis);
				}
			}
		}
		//		consumingRegionAnalysis.setFallibleEdges(checkedEdges);
		// FIXME		consumingRegionAnalysis.setFallibleNodes(checkedNodes);
		Set<@NonNull RegionAnalysis> old = consumer2producers.put(consumingRegionAnalysis, producingRegionAnalyses);
		assert old == null;
		/*			Set<@NonNull MappingPartitioner> requiredMappingPartitioners = new HashSet<>();
			for (@NonNull ClassDatum classDatum : visitor.getTypeDependentConditions().values()) {
				assert classDatum.getReferredTypedModel() == scheduleManager.getTraceTypedModel();
				TraceClassAnalysis traceClassAnalysis = getTraceClassAnalysis(QVTscheduleUtil.getCompleteClass(classDatum));
				requiredMappingPartitioners.add(traceClassAnalysis);
			}
			Iterable<@NonNull Node> traceNodes = mappingPartitioner.getTraceNodes();
			boolean isSinglyTraced = Iterables.size(traceNodes) == 1;
			for (@NonNull Node traceNode : traceNodes) {
				TraceClassAnalysis traceClassAnalysis = mappingPartitioner.getTraceClassAnalysis(traceNode);
				Map<@NonNull TraceClassAnalysis, @NonNull Set<@NonNull TraceClassAnalysis>> traceClassAnalysis2traceClassAnalyses2 = traceClassAnalysis2traceClassAnalyses;
				Set<@NonNull TraceClassAnalysis> old = traceClassAnalysis2traceClassAnalyses2.put(traceClassAnalysis, requiredTraceClassAnalyses);
				assert old == null;
			}
		} */
	}

	private @NonNull RegionAnalysis createPseudoRegionAnalysis(@NonNull String name) {
		RegionImpl dummyRegion = new RegionImpl()
		{
			@Override
			public List<Node> getHeadNodes() {
				return Collections.emptyList();
			}
		};
		dummyRegion.setName(name);;
		return new RegionAnalysis(transformationAnalysis, dummyRegion);
	}

	public @NonNull RegionAnalysis getFailSometimes() {
		RegionAnalysis failSometimes2 = failSometimes;
		if (failSometimes2 == null) {
			failSometimes = failSometimes2 = createPseudoRegionAnalysis("«failSometimes»");
			consumer2producers.put(failSometimes2, Sets.newHashSet(failSometimes2));
		}
		return failSometimes2;
	}

	public void install() {
		if (LOCAL.isActive()) {
			List<@NonNull RegionAnalysis> consumers = new ArrayList<>(consumer2producers.keySet());
			Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull RegionAnalysis consumingRegionAnalysis : consumers) {
				StringBuilder s = new StringBuilder();
				s.append(consumingRegionAnalysis + " <=");
				Set<@NonNull RegionAnalysis> producers = consumer2producers.get(consumingRegionAnalysis);
				assert producers != null;
				List<@NonNull RegionAnalysis> sortedProducers = new ArrayList<>(producers);
				Collections.sort(sortedProducers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RegionAnalysis producingRegionAnalysis : sortedProducers) {
					s.append(" " + producingRegionAnalysis);
				}
				LOCAL.println(s.toString());
			}
		}
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		for (@NonNull RegionAnalysis consumingRegionAnalysis : consumer2producersClosure.keySet()) {
			Set<@NonNull RegionAnalysis> fallibilities = consumer2producersClosure.get(consumingRegionAnalysis);
			assert fallibilities != null;
			//			consumingRegionAnalysis.setFallibilities(fallibilities);
		}
		if (GLOBAL.isActive()) {
			List<@NonNull RegionAnalysis> consumers = new ArrayList<>(consumer2producersClosure.keySet());
			Collections.sort(consumers, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull RegionAnalysis consumingRegionAnalysis : consumers) {
				StringBuilder s = new StringBuilder();
				s.append(consumingRegionAnalysis + " <=");
				Set<@NonNull RegionAnalysis> producers = consumer2producersClosure.get(consumingRegionAnalysis);
				assert producers != null;
				List<@NonNull RegionAnalysis> sortedProducers = new ArrayList<>(producers);
				Collections.sort(sortedProducers, NameUtil.NAMEABLE_COMPARATOR);
				for (@NonNull RegionAnalysis producingRegionAnalysis : sortedProducers) {
					s.append(" " + producingRegionAnalysis);
				}
				GLOBAL.println(s.toString());
			}
		}
	}
}