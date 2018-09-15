/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CyclicRegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TransformationPartitioner;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A TransformationAnalysis accumulates the tesults of analyzing a RelationalTransformation and its contents.
 */
public class TransformationAnalysis extends RegionsAnalysis<@NonNull RegionAnalysis>
{
	/**
	 * The analyzed Transformation.
	 */
	protected final @NonNull Transformation transformation;

	/**
	 * The ScheduledRegion that implements the transformation.
	 */
	protected final @NonNull ScheduledRegion scheduledRegion;

	/**
	 * The mapping from analyzed Transformation to its corresponding trace Package.
	 */
	private @Nullable TransformationAnalysis2TracePackage transformationAnalysis2tracePackage = null;

	/**
	 * Map from each rule to its analysis.
	 */
	private final @NonNull Map<@NonNull Rule, @NonNull RuleAnalysis> rule2ruleAnalysis = new HashMap<>();

	private @NonNull Map<@NonNull Region, @NonNull RegionAnalysis> region2regionAnalysis = new HashMap<>();

	/**
	 * Realization of corollary properties is deferred until speculation involving their source trace node has completed
	 * successfully. The map identifies the regions in which a deferred realization is needed.
	 */
	private final @NonNull Map<@NonNull Property, @NonNull List<@NonNull Region>> corollaryProperty2regions = new HashMap<>();

	/**
	 * The analysis of cycles.
	 */
	private @Nullable CyclicRegionsAnalysis cyclesRegionAnalysis = null;

	private @Nullable RootPartition rootPartition = null;

	public TransformationAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull Transformation transformation, @NonNull ScheduledRegion scheduledRegion) {
		super(scheduleManager);
		this.transformation = transformation;
		this.scheduledRegion = scheduledRegion;
		for (@NonNull Rule asRule : QVTbaseUtil.getOwnedRules(transformation)) {
			RuleAnalysis ruleAnalysis = scheduleManager.createRuleAnalysis(this, asRule);
			rule2ruleAnalysis.put(asRule, ruleAnalysis);
		}
	}

	/**
	 * Register edge for delayed realization after speculation of the trace node of edge's region has completed successfully.
	 */
	public void addCorollary(@NonNull NavigableEdge edge) {
		assert edge.isRealized();
		//	Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
		Node targetNode = QVTscheduleUtil.getTargetNode(edge);
		//	assert sourceNode.isRealized();		-- may be a loaded input of a realized where invocation
		assert targetNode.isRealized();
		//	assert sourceNode.isTrace() || targetNode.isTrace();	-- may be part of an extensive realized pattern
		Region region = QVTscheduleUtil.getOwningRegion(edge);
		Property property = QVTscheduleUtil.getProperty(edge);
		List<@NonNull Region> regions = corollaryProperty2regions.get(property);
		if (regions == null) {
			regions = new ArrayList<>();
			corollaryProperty2regions.put(property, regions);
		}
		if (!regions.contains(region)) {
			regions.add(region);
		}
	}

	/**
	 * Perform the independent local analysis of each Rule.
	 */
	public void analyzeMappingRegions() {
		for (@NonNull Rule asRule : QVTbaseUtil.getOwnedRules(transformation)) {
			RuleAnalysis ruleAnalysis = getRuleAnalysis(asRule);
			ruleAnalysis.analyzeMappingRegion();
		}
		CompleteModel completeModel = environmentFactory.getCompleteModel();
		for (@NonNull TypedModel typedModel : QVTbaseUtil.getModelParameters(transformation)) {
			for (org.eclipse.ocl.pivot.@NonNull Package asPackage : QVTbaseUtil.getUsedPackages(typedModel)) {
				CompletePackage completePackage = completeModel.getCompletePackage(asPackage);
				scheduleManager.analyzeCompletePackage(typedModel, completePackage);
			}
		}
	}

	/**
	 * Determine the TypedModel usage of each model element.
	 */
	public void analyzeSourceModel() {
		for (@NonNull RuleAnalysis ruleAnalysis : rule2ruleAnalysis.values()) {
			ruleAnalysis.analyzeSourceModel();
		}
	}

	@Override
	protected @NonNull TraceClassRegionAnalysis createTraceClassAnalysis(@NonNull ClassDatum traceClassDatum) {
		return new TraceClassRegionAnalysis(this, traceClassDatum);
	}

	@Override
	protected @NonNull TracePropertyRegionAnalysis createTracePropertyAnalysis(@NonNull TraceClassAnalysis<@NonNull RegionAnalysis> traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		return new TracePropertyRegionAnalysis(this, traceClassAnalysis, tracePropertyDatum);
	}

	public @NonNull Iterable<@NonNull RuleRegion> gatherRuleRegions() {
		List<@NonNull RuleRegion> ruleRegions = new ArrayList<>();
		for (@NonNull RuleAnalysis ruleAnalysis : rule2ruleAnalysis.values()) {
			ruleAnalysis.gatherRuleRegions(ruleRegions);
		}
		Collections.sort(ruleRegions, NameUtil.NAMEABLE_COMPARATOR);		// For predictability
		return ruleRegions;
	}

	public @Nullable List<@NonNull Region> getCorollaryOf(@NonNull NavigableEdge edge) {
		return corollaryProperty2regions.get(edge.getProperty());
	}

	/*	public @Nullable Iterable<@NonNull RegionAnalysis> getCyclicRegionAnalyses(@NonNull RegionAnalysis regionAnalysis) {
		assert cyclesRegionAnalysis != null;
		CycleRegionAnalysis cycleAnalysis = cyclesRegionAnalysis.getCycleAnalysis(regionAnalysis);
		return cycleAnalysis != null ? cycleAnalysis.getRegionAnalyses() : null;
	} */

	@Override
	public String getName() {
		return transformation.getName();
	}

	//	@Override
	//	protected @NonNull Iterable<@NonNull RegionAnalysis> getPartialRegionAnalyses() {
	//		return region2regionAnalysis.values();
	//	}

	public @NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region) {
		RegionAnalysis regionAnalysis = region2regionAnalysis.get(region);
		if (regionAnalysis == null) {
			regionAnalysis = new RegionAnalysis(this, region);
			region2regionAnalysis.put(region, regionAnalysis);
		}
		return regionAnalysis;
	}

	public @NonNull RootPartition getRootPartition() {
		return ClassUtil.nonNullState(rootPartition);
	}

	//	public @NonNull Iterable<@NonNull RuleAnalysis> getRuleAnalyses() {
	//		return rule2ruleAnalysis.values();
	//	}

	public @NonNull RuleAnalysis getRuleAnalysis(@NonNull Rule rule) {
		return ClassUtil.nonNullState(rule2ruleAnalysis.get(rule));
		/*		RuleAnalysis ruleAnalysis = rule2ruleAnalysis.get(rule);
		if (ruleAnalysis != null) {
			return ruleAnalysis;
		}
		TransformationAnalysis transformationAnalysis = scheduleManager.getTransformationAnalysis(QVTbaseUtil.getContainingTransformation(rule));
		if (transformationAnalysis != this) {
			return transformationAnalysis.getRuleAnalysis(rule);
		}
		throw new IllegalStateException("No RuleAnalysis for '" + rule + "'"); */
	}

	public @NonNull ScheduledRegion getScheduledRegion() {
		return scheduledRegion;
	}

	public @NonNull Transformation getTransformation() {
		return transformation;
	}

	public @NonNull TransformationAnalysis2TracePackage getTransformationAnalysis2TracePackage() {
		TransformationAnalysis2TracePackage transformationAnalysis2tracePackage2 = transformationAnalysis2tracePackage;
		if (transformationAnalysis2tracePackage2 == null) {
			transformationAnalysis2tracePackage = transformationAnalysis2tracePackage2 = scheduleManager.createTransformationAnalysis2TracePackage(this);
		}
		return transformationAnalysis2tracePackage2;
	}

	/**
	 * Return true if node is a corollary of some mapping.
	 */
	public boolean isCorollary(@NonNull Node node) {
		if (node.isPredicated()) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isPredicated() && !edge.isSecondary() && (edge instanceof NavigableEdge)) {
					List<@NonNull Region> corollaryOf = getCorollaryOf((NavigableEdge)edge);
					if (corollaryOf != null) {
						return true;
					}
				}
			}
		}
		else if (node.isRealized()) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isRealized() && !edge.isSecondary() && (edge instanceof NavigableEdge)) {
					List<@NonNull Region> corollaryOf = getCorollaryOf((NavigableEdge)edge);
					if (corollaryOf != null) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean isCyclic(@NonNull TraceClassAnalysis<@NonNull RegionAnalysis> traceClassAnalysis) {
		assert cyclesRegionAnalysis != null;
		return cyclesRegionAnalysis.isCyclic(traceClassAnalysis);
	}

	public boolean isCyclic(@NonNull RegionAnalysis regionAnalysis) {
		assert cyclesRegionAnalysis != null;
		return cyclesRegionAnalysis.isCyclic(regionAnalysis);
	}

	public boolean isCyclic(@NonNull ClassDatum traceClassDatum) {
		TraceClassAnalysis<@NonNull RegionAnalysis> traceClassAnalysis = basicGetTraceClassAnalysis(traceClassDatum);
		if (traceClassAnalysis == null) {
			return false;
		}
		return ((TraceClassRegionAnalysis)traceClassAnalysis).isCyclic();
	}

	public @NonNull RootPartition partition(@NonNull ProblemHandler problemHandler, @NonNull Iterable<? extends @NonNull MappingRegion> activeRegions) throws CompilerChainException {
		assert this.rootPartition == null;
		this.rootPartition  = TransformationPartitioner.partition(this, problemHandler, activeRegions);
		return rootPartition;
	}

	public void prePartition() throws CompilerChainException {
		if (scheduleManager.needsDiscrimination()) {
			computeTraceClassDiscrimination();
		}
		computeTraceClassInheritance();
		this.cyclesRegionAnalysis = new CyclicRegionsAnalysis(region2regionAnalysis.values());
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(transformation);
	}
}
