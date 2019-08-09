/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.TraceClassRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.AbstractPartialRegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.ActualPartialRegionPropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CyclicRegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TransformationPartitioner;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * AbstractTransformationAnalysis provides the mandatory default management of ClassDatum and PropertyDatum usage by regions for a RegionsAnalysis.
 */
public abstract class AbstractTransformationAnalysis extends AbstractPartialRegionsAnalysis<@NonNull RegionsAnalysis>
{

	/**
	 * The analyzed Transformation.
	 */
	protected final @NonNull Transformation transformation;

	/**
	 * The RootRegion that implements the transformation.
	 */
	protected final @NonNull RootRegion rootRegion;

	protected final @NonNull Property oclContainerProperty;

	/**
	 * The analysis of cycles.
	 */
	private @Nullable CyclicRegionsAnalysis cyclesRegionAnalysis = null;

	/**
	 * The mapping from analyzed Transformation to its corresponding trace Package.
	 */
	private @Nullable Transformation2TracePackage transformation2tracePackage = null;

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

	private @Nullable RootPartitionAnalysis rootPartitionAnalysis = null;

	protected AbstractTransformationAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull Transformation transformation, @NonNull RootRegion rootRegion) {
		super(scheduleManager);
		this.transformation = transformation;
		this.rootRegion = rootRegion;
		this.oclContainerProperty = scheduleManager.getStandardLibraryHelper().getOclContainerProperty();
		for (@NonNull Rule asRule : QVTbaseUtil.getOwnedRules(transformation)) {
			RuleAnalysis ruleAnalysis = scheduleManager.createRuleAnalysis(this, asRule);
			rule2ruleAnalysis.put(asRule, ruleAnalysis);
		}
	}

	/**
	 * Register edge for delayed realization after speculation of the trace node of edge's region has completed successfully.
	 */
	public void addCorollary(@NonNull NavigationEdge edge) {
		assert edge.isRealized();
		//	Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
		Node targetNode = QVTscheduleUtil.getTargetNode(edge);
		//	assert sourceNode.isRealized();		-- may be a loaded input of a realized where invocation
		assert targetNode.isRealized();
		//	assert sourceNode.isTrace() || targetNode.isTrace();	-- may be part of an extensive realized pattern
		Region region = QVTscheduleUtil.getOwningRegion(edge);
		Property property = QVTscheduleUtil.getReferredProperty(edge);
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

	public @Nullable RegionAnalysis basicGetRegionAnalysis(@NonNull Region region) {
		return region2regionAnalysis.get(region);
	}

	public @Nullable RootPartitionAnalysis basicGetRootPartitionAnalysis() {
		return rootPartitionAnalysis;
	}

	@Override
	public @Nullable ActualPartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> basicGetPropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		assert QVTscheduleUtil.getReferredProperty(propertyDatum) != oclContainerProperty;
		return super.basicGetPropertyAnalysis(propertyDatum);
	}

	protected void computeCyclicRegionsAnalysis(@NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		this.cyclesRegionAnalysis = new CyclicRegionsAnalysis(regionAnalyses);
	}

	@Override
	protected @NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> createClassAnalysis(@NonNull ClassDatum classDatum) {
		return new TraceClassRegionAnalysis(this, classDatum);
	}

	public @NonNull Iterable<@NonNull RuleRegion> gatherRuleRegions() {
		List<@NonNull RuleRegion> ruleRegions = new ArrayList<>();
		gatherRuleRegions(ruleRegions);
		Collections.sort(ruleRegions, NameUtil.NAMEABLE_COMPARATOR);		// For predictability
		return ruleRegions;
	}

	public void gatherRuleRegions(@NonNull List<@NonNull RuleRegion> ruleRegions) {
		for (@NonNull RuleAnalysis ruleAnalysis : rule2ruleAnalysis.values()) {
			ruleAnalysis.gatherRuleRegions(ruleRegions);
		}
	}

	public @Nullable List<@NonNull Region> getCorollaryOf(@NonNull NavigationEdge edge) {
		return corollaryProperty2regions.get(QVTscheduleUtil.getReferredProperty(edge));
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

	public @NonNull RootPartitionAnalysis getRootPartitionAnalysis() {
		return ClassUtil.nonNullState(rootPartitionAnalysis);
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

	public @NonNull RootRegion getRootRegion() {
		return rootRegion;
	}

	@Override
	public @NonNull ActualPartialRegionPropertyAnalysis<@NonNull RegionsAnalysis> getPropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		assert QVTscheduleUtil.getReferredProperty(propertyDatum) != oclContainerProperty;
		return super.getPropertyAnalysis(propertyDatum);
	}

	public @NonNull Transformation getTransformation() {
		return transformation;
	}

	public @NonNull Transformation2TracePackage getTransformation2TracePackage() {
		Transformation2TracePackage transformation2tracePackage2 = transformation2tracePackage;
		if (transformation2tracePackage2 == null) {
			transformation2tracePackage = transformation2tracePackage2 = scheduleManager.getTransformation2TracePackage(transformation);
		}
		return transformation2tracePackage2;
	}

	/**
	 * Return true if node is a corollary of some mapping.
	 */
	public boolean isCorollary(@NonNull Node node) {
		if (node.isPredicated()) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isPredicated() && (edge instanceof NavigationEdge)) {
					NavigationEdge navigationEdge =(NavigationEdge)edge;
					if (!navigationEdge.isSecondary()) {
						List<@NonNull Region> corollaryOf = getCorollaryOf(navigationEdge);
						if (corollaryOf != null) {
							return true;
						}
					}
				}
			}
		}
		else if (node.isRealized()) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isRealized() && (edge instanceof NavigationEdge)) {
					NavigationEdge navigationEdge =(NavigationEdge)edge;
					if (!navigationEdge.isSecondary()) {
						List<@NonNull Region> corollaryOf = getCorollaryOf(navigationEdge);
						if (corollaryOf != null) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean isCyclic(@NonNull PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis) {
		assert cyclesRegionAnalysis != null;
		return cyclesRegionAnalysis.isCyclic(classAnalysis);
	}

	public boolean isCyclic(@NonNull RegionAnalysis regionAnalysis) {
		assert cyclesRegionAnalysis != null;
		return cyclesRegionAnalysis.isCyclic(regionAnalysis);
	}

	public boolean isCyclic(@NonNull ClassDatum classDatum) {
		PartialRegionClassAnalysis<@NonNull RegionsAnalysis> classAnalysis = basicGetClassAnalysis(classDatum);
		if (classAnalysis == null) {
			return false;
		}
		return classAnalysis.isCyclic();
	}

	public @NonNull PartitionedTransformationAnalysis partition(@NonNull ProblemHandler problemHandler, @NonNull Iterable<? extends @NonNull Region> activeRegions) throws CompilerChainException {
		assert this.rootPartitionAnalysis == null;
		PartitionedTransformationAnalysis partitionedTransformationAnalysis = TransformationPartitioner.partition(this, problemHandler, activeRegions);
		this.rootPartitionAnalysis = partitionedTransformationAnalysis.getRootPartitionAnalysis();
		return partitionedTransformationAnalysis;
	}

	public void prePartition() throws CompilerChainException {
		if (scheduleManager.needsDiscrimination()) {
			computeTraceClassDiscrimination();
		}
		computeTraceClassInheritance();
		computeCyclicRegionsAnalysis(region2regionAnalysis.values());
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(transformation);
	}
}
