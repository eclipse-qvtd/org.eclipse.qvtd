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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.TraceClassRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.TracePropertyRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CyclicRegionsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TransformationPartitioner;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A TransformationAnalysis accumulates the tesults of analyzing a RelationalTransformation and its contents.
 */
public abstract class AbstractTransformationAnalysis extends QVTbaseHelper implements Nameable
{
	/**
	 * The supervising ScheduleManager.
	 */
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The analyzed Transformation.
	 */
	protected final @NonNull Transformation transformation;

	/**
	 * The ScheduledRegion that implements the transformation.
	 */
	protected final @NonNull ScheduledRegion scheduledRegion;

	protected final @NonNull Property oclContainerProperty;

	/**
	 * The TraceClassAnalysis for each trace class.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull TraceClassRegionAnalysis> classDatum2traceClassAnalysis = new HashMap<>();

	/**
	 * The TracePropertyAnalysis for each trace property.
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull TracePropertyRegionAnalysis> propertyDatum2tracePropertyAnalysis = new HashMap<>();

	/**
	 * The analysis of cycles.
	 */
	private @Nullable CyclicRegionsAnalysis cyclesRegionAnalysis = null;

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

	private @Nullable RootPartitionAnalysis rootPartitionAnalysis = null;

	protected AbstractTransformationAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull Transformation transformation, @NonNull ScheduledRegion scheduledRegion) {
		super(scheduleManager.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
		this.transformation = transformation;
		this.scheduledRegion = scheduledRegion;
		this.oclContainerProperty = scheduleManager.getStandardLibraryHelper().getOclContainerProperty();
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

	public @NonNull TraceClassRegionAnalysis addConsumer(@NonNull ClassDatum classDatum, @NonNull RegionAnalysis consumer) {
		TraceClassRegionAnalysis traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addConsumer(consumer);
		return traceClassAnalysis;
	}

	public @NonNull TracePropertyRegionAnalysis addConsumer(@NonNull PropertyDatum tracePropertyDatum, @NonNull RegionAnalysis consumer) {
		TracePropertyRegionAnalysis tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addConsumer(consumer);
		return tracePropertyAnalysis;
	}

	public @NonNull TraceClassRegionAnalysis addProducer(@NonNull ClassDatum classDatum, @NonNull RegionAnalysis producer) {
		TraceClassRegionAnalysis traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
		traceClassAnalysis.addProducer(producer);
		return traceClassAnalysis;
	}

	public @NonNull TracePropertyRegionAnalysis addProducer(@NonNull PropertyDatum tracePropertyDatum, @NonNull RegionAnalysis producer) {
		TracePropertyRegionAnalysis tracePropertyAnalysis = lazyCreateTracePropertyAnalysis(tracePropertyDatum);
		tracePropertyAnalysis.addProducer(producer);
		return tracePropertyAnalysis;
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

	public @Nullable TraceClassRegionAnalysis basicGetTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		return classDatum2traceClassAnalysis.get(classDatum);
	}

	public @Nullable RootPartitionAnalysis basicGetRootPartitionAnalysis() {
		return rootPartitionAnalysis;
	}

	public @Nullable TracePropertyRegionAnalysis basicGetTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		assert QVTscheduleUtil.getReferredProperty(propertyDatum) != oclContainerProperty;
		return propertyDatum2tracePropertyAnalysis.get(propertyDatum);
	}

	protected void computeCyclicRegionsAnalysis(@NonNull Iterable<@NonNull RegionAnalysis> regionAnalyses) {
		this.cyclesRegionAnalysis = new CyclicRegionsAnalysis(regionAnalyses);
	}

	protected void computeTraceClassDiscrimination() throws CompilerChainException {
		for (@NonNull TraceClassRegionAnalysis traceClassAnalysis : classDatum2traceClassAnalysis.values()) {
			traceClassAnalysis.discriminate();
		}
	}

	public void computeTraceClassInheritance() {
		Set<@NonNull ClassDatum> missingClassDatums = new HashSet<>();
		for (@NonNull TraceClassRegionAnalysis subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					TraceClassRegionAnalysis superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					if (superTraceClassRegionAnalysis == null) {
						missingClassDatums.add(superClassDatum);
					}
				}
			}
		}
		for (@NonNull ClassDatum missingClassDatum : missingClassDatums) {
			lazyCreateTraceClassAnalysis(missingClassDatum);
		}
		for (@NonNull TraceClassRegionAnalysis subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum classDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					TraceClassRegionAnalysis superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superClassDatum);
					assert superTraceClassRegionAnalysis != null;
					superTraceClassRegionAnalysis.addSubTraceClassAnalysis(subTraceClassRegionAnalysis);
					subTraceClassRegionAnalysis.addSuperTraceClassAnalysis(superTraceClassRegionAnalysis);
				}
			}
		}
	}

	protected @NonNull TraceClassRegionAnalysis createTraceClassAnalysis(@NonNull ClassDatum traceClassDatum) {
		return new TraceClassRegionAnalysis(this, traceClassDatum);
	}

	protected @NonNull TracePropertyRegionAnalysis createTracePropertyAnalysis(@NonNull TraceClassRegionAnalysis traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		return new TracePropertyRegionAnalysis(this, traceClassAnalysis, tracePropertyDatum);
	}

	public @Nullable RegionAnalysis basicGetRegionAnalysis(@NonNull Region region) {
		return region2regionAnalysis.get(region);
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

	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	public @NonNull ScheduledRegion getScheduledRegion() {
		return scheduledRegion;
	}

	public @NonNull TraceClassRegionAnalysis getTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum2traceClassAnalysis.get(classDatum));
	}

	public @NonNull TracePropertyRegionAnalysis getTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		assert QVTscheduleUtil.getReferredProperty(propertyDatum) != oclContainerProperty;
		return ClassUtil.nonNullState(propertyDatum2tracePropertyAnalysis.get(propertyDatum));
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

	public boolean isCyclic(@NonNull TraceClassRegionAnalysis traceClassAnalysis) {
		assert cyclesRegionAnalysis != null;
		return cyclesRegionAnalysis.isCyclic(traceClassAnalysis);
	}

	public boolean isCyclic(@NonNull RegionAnalysis regionAnalysis) {
		assert cyclesRegionAnalysis != null;
		return cyclesRegionAnalysis.isCyclic(regionAnalysis);
	}

	public boolean isCyclic(@NonNull ClassDatum traceClassDatum) {
		TraceClassRegionAnalysis traceClassAnalysis = basicGetTraceClassAnalysis(traceClassDatum);
		if (traceClassAnalysis == null) {
			return false;
		}
		return traceClassAnalysis.isCyclic();
	}

	private @NonNull TraceClassRegionAnalysis lazyCreateTraceClassAnalysis(@NonNull ClassDatum classDatum) {
		TraceClassRegionAnalysis traceClassAnalysis = classDatum2traceClassAnalysis.get(classDatum);
		if (traceClassAnalysis == null) {
			traceClassAnalysis = createTraceClassAnalysis(classDatum);
			classDatum2traceClassAnalysis.put(classDatum, traceClassAnalysis);
		}
		return traceClassAnalysis;
	}

	private @NonNull TracePropertyRegionAnalysis lazyCreateTracePropertyAnalysis(@NonNull PropertyDatum tracePropertyDatum) {
		TracePropertyRegionAnalysis tracePropertyAnalysis = propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum);
		if (tracePropertyAnalysis == null) {
			ClassDatum classDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
			TraceClassRegionAnalysis traceClassAnalysis = lazyCreateTraceClassAnalysis(classDatum);
			tracePropertyAnalysis = createTracePropertyAnalysis(traceClassAnalysis, tracePropertyDatum);
			propertyDatum2tracePropertyAnalysis.put(tracePropertyDatum, tracePropertyAnalysis);
		}
		return tracePropertyAnalysis;
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
