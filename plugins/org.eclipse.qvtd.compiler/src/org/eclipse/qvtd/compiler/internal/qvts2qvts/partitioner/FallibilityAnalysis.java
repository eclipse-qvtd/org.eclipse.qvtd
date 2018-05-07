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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CastEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionVisitor;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.ConstantTargetCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.MultipleEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.NavigableEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.PredicateEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.PredicateNavigationEdgeCheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
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
	protected class Visitor implements CheckedConditionVisitor<Object>
	{
		protected final @NonNull MappingPartitioner mappingPartitioner;

		/**
		 * Map from the fallible producing RegionAnalysis to the single CheckCondition or Set<@NonNull CheckCondition> that
		 * depends on the producing RegionAnalysis.
		 */
		protected final @NonNull Map<@NonNull CheckedCondition, @NonNull Object> check2regionOrRegions = new HashMap<>();

		public Visitor(@NonNull MappingPartitioner mappingPartitioner) {
			this.mappingPartitioner = mappingPartitioner;
		}

		private void addFallibility(@NonNull CheckedCondition checkedCondition, @NonNull RegionAnalysis producingRegionAnalysis) {
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
			MappingRegion region = mappingPartitioner.getRegion();
			Iterable<@NonNull Node> headNodes = QVTscheduleUtil.getHeadNodes(region);
			Iterable<@NonNull Node> constantInputNodes = mappingPartitioner.getConstantInputNodes();
			Iterable<@NonNull Node> rootNodes = Iterables.concat(headNodes, constantInputNodes);
			Iterable<@NonNull NavigableEdge> navigableEdges = mappingPartitioner.getOldPrimaryNavigableEdges();
			ReachabilityForest checkedReachabilityForest = new ReachabilityForest(rootNodes, navigableEdges);
			CheckedConditionAnalysis analysis = new CheckedConditionAnalysis(scheduleManager, checkedReachabilityForest, region)
			{
				@Override
				protected @Nullable Set<@NonNull Property> computeCheckedProperties() {
					return null;
				}
			};
			Set<@NonNull CheckedCondition> checkedConditions = analysis.computeCheckedConditions();
			System.out.println(region + ": " + checkedConditions);
			for (@NonNull CheckedCondition checkedCondition : checkedConditions) {
				checkedCondition.accept(this);
			}
			return check2regionOrRegions;
		}

		@Override
		public Object visitCastEdgeCheckedCondition(@NonNull CastEdgeCheckedCondition castEdgeCheckedCondition) {
			addFallibility(castEdgeCheckedCondition, failSometimes);
			return null;
		}

		@Override
		public Object visitConstantTargetCheckedCondition(@NonNull ConstantTargetCheckedCondition constantTargetCheckedCondition) {
			addFallibility(constantTargetCheckedCondition, failSometimes);
			return null;
		}

		@Override
		public Object visitMultipleEdgeCheckedCondition(@NonNull MultipleEdgeCheckedCondition multipleEdgeCheckedCondition) {
			addFallibility(multipleEdgeCheckedCondition, failSometimes);
			return null;
		}

		@Override
		public Object visitNavigableEdgeCheckedCondition(@NonNull NavigableEdgeCheckedCondition navigableEdgeCheckedCondition) {
			addFallibility(navigableEdgeCheckedCondition, failSometimes);
			return null;
		}

		@Override
		public Object visitPredicateEdgeCheckedCondition(@NonNull PredicateEdgeCheckedCondition predicateEdgeCheckedCondition) {
			addFallibility(predicateEdgeCheckedCondition, failSometimes);
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
						RegionAnalysis producingRegionAnalysis = scheduleManager.getRegionAnalysis(producingRegion);
						addFallibility(predicateNavigationEdgeCheckedCondition, producingRegionAnalysis);
						//						}
						//						else {
						//							allSuccessesResolved = false;
						//						}
					}
				}
			}
			if (!allSuccessesResolved) {
				addFallibility(predicateNavigationEdgeCheckedCondition, failSometimes);
			}
			return null;
		}
	}

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull ContentsAnalysis<@NonNull RuleRegion> originalContentsAnalysis;
	protected final @NonNull TransformationPartitioner transformationPartitioner;
	//	protected final @NonNull RegionAnalysis failAlways;
	protected final @NonNull RegionAnalysis failSometimes;
	private @NonNull Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> consumer2producers = new HashMap<>();

	public FallibilityAnalysis(@NonNull TransformationPartitioner transformationPartitioner) {
		this.scheduleManager = transformationPartitioner.getScheduleManager();
		this.originalContentsAnalysis = scheduleManager.getOriginalContentsAnalysis();
		this.transformationPartitioner = transformationPartitioner;
		//		this.failAlways = createPseudoRegionAnalysis("«failAlways»");
		this.failSometimes = createPseudoRegionAnalysis("«failSometimes»");
		//		consumer2producers.put(failAlways, Sets.newHashSet(failAlways));
		consumer2producers.put(failSometimes, Sets.newHashSet(failSometimes));
	}

	public void accumulate(@NonNull MappingPartitioner mappingPartitioner) {
		Visitor visitor = new Visitor(mappingPartitioner);
		Map<@NonNull CheckedCondition, @NonNull Object> check2regionOrRegions = visitor.analyze();
		Set<@NonNull RegionAnalysis> regionAnalyses = new HashSet<>();
		Set<@NonNull Edge> edges = new HashSet<>();
		for (@NonNull CheckedCondition checkedCondition : check2regionOrRegions.keySet()) {
			for (@NonNull Edge edge : checkedCondition.getEdges()) {
				edges.add(edge);
			}
			Object regionOrRegions = check2regionOrRegions.get(checkedCondition);
			assert regionOrRegions != null;
			if (regionOrRegions instanceof RegionAnalysis) {
				regionAnalyses.add((RegionAnalysis) regionOrRegions);
			}
			else {
				@SuppressWarnings("unchecked")
				Iterable<@NonNull RegionAnalysis> regions = (Iterable<@NonNull RegionAnalysis>) regionOrRegions;
				for (@NonNull RegionAnalysis regionAnalysis : regions) {
					regionAnalyses.add(regionAnalysis);
				}
			}
		}
		RegionAnalysis regionAnalysis = mappingPartitioner.getRegionAnalysis();
		regionAnalysis.setFallibleEdges(edges);
		Set<@NonNull RegionAnalysis> old = consumer2producers.put(regionAnalysis, regionAnalyses);
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
		return new RegionAnalysis(scheduleManager, dummyRegion);
	}

	public void install() {
		Map<@NonNull RegionAnalysis, @NonNull Set<@NonNull RegionAnalysis>> consumer2producersClosure = CompilerUtil.computeClosure(consumer2producers);
		for (@NonNull RegionAnalysis consumingRegionAnalysis : consumer2producersClosure.keySet()) {
			Set<@NonNull RegionAnalysis> fallibilities = consumer2producersClosure.get(consumingRegionAnalysis);
			assert fallibilities != null;
			consumingRegionAnalysis.setFallibilities(fallibilities);
		}
	}
}