/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CycleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CycleRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CyclesAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.CyclesRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TraceClassRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TracePropertyRegionAnalysis;
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
public class TransformationAnalysis extends QVTbaseHelper implements Nameable
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
	 * The TraceClassAnalysis for each trace class.
	 */
	private final @NonNull Map<@NonNull ClassDatum, @NonNull TraceClassRegionAnalysis> classDatum2traceClassAnalysis = new HashMap<>();

	/**
	 * The TracePropertyAnalysis for each trace property.
	 */
	private final @NonNull Map<@NonNull PropertyDatum, @NonNull TracePropertyRegionAnalysis> propertyDatum2tracePropertyAnalysis = new HashMap<>();

	/**
	 * Realization of corollary properties is deferred until speculation involving their source trace node has completed
	 * successfully. The map identifies the regions in which a deferred realization is needed.
	 */
	private final @NonNull Map<@NonNull Property, @NonNull List<@NonNull Region>> corollaryProperty2regions = new HashMap<>();

	/**
	 * The analysis of cycles.
	 */
	private @Nullable CyclesAnalysis<@NonNull RegionAnalysis> cyclesAnalysis = null;

	public TransformationAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull Transformation transformation, @NonNull ScheduledRegion scheduledRegion) {
		super(scheduleManager.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
		this.transformation = transformation;
		this.scheduledRegion = scheduledRegion;
		for (@NonNull Rule asRule : QVTbaseUtil.getOwnedRules(transformation)) {
			RuleAnalysis ruleAnalysis = scheduleManager.createRuleAnalysis(this, asRule);
			rule2ruleAnalysis.put(asRule, ruleAnalysis);
		}
	}

	public @NonNull TraceClassRegionAnalysis addConsumer(@NonNull ClassDatum traceClassDatum, @NonNull RegionAnalysis consumer) {
		TraceClassRegionAnalysis middleAnalysis = classDatum2traceClassAnalysis.get(traceClassDatum);
		if (middleAnalysis == null) {
			middleAnalysis = new TraceClassRegionAnalysis(this, traceClassDatum);
			classDatum2traceClassAnalysis.put(traceClassDatum, middleAnalysis);
		}
		middleAnalysis.addConsumer(consumer);
		return middleAnalysis;
	}

	public @NonNull TracePropertyRegionAnalysis addConsumer(@NonNull PropertyDatum tracePropertyDatum, @NonNull RegionAnalysis consumer) {
		TracePropertyRegionAnalysis middleAnalysis = propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum);
		if (middleAnalysis == null) {
			middleAnalysis = new TracePropertyRegionAnalysis(this, tracePropertyDatum);
			propertyDatum2tracePropertyAnalysis.put(tracePropertyDatum, middleAnalysis);
		}
		middleAnalysis.addConsumer(consumer);
		return middleAnalysis;
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

	public @NonNull TraceClassRegionAnalysis addProducer(@NonNull ClassDatum traceClassDatum, @NonNull RegionAnalysis producer) {
		TraceClassRegionAnalysis middleAnalysis = classDatum2traceClassAnalysis.get(traceClassDatum);
		if (middleAnalysis == null) {
			middleAnalysis = new TraceClassRegionAnalysis(this, traceClassDatum);
			classDatum2traceClassAnalysis.put(traceClassDatum, middleAnalysis);
		}
		middleAnalysis.addProducer(producer);
		return middleAnalysis;
	}

	public @NonNull TracePropertyRegionAnalysis addProducer(@NonNull PropertyDatum tracePropertyDatum, @NonNull RegionAnalysis producer) {
		TracePropertyRegionAnalysis middleAnalysis = propertyDatum2tracePropertyAnalysis.get(tracePropertyDatum);
		if (middleAnalysis == null) {
			middleAnalysis = new TracePropertyRegionAnalysis(this, tracePropertyDatum);
			propertyDatum2tracePropertyAnalysis.put(tracePropertyDatum, middleAnalysis);
		}
		middleAnalysis.addProducer(producer);
		return middleAnalysis;
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

	protected @NonNull CyclesAnalysis<@NonNull RegionAnalysis> computeCyclesAnalysis() {
		CyclesAnalysis<@NonNull RegionAnalysis> cyclesAnalysis = new CyclesRegionAnalysis(this, region2regionAnalysis.values());
		cyclesAnalysis.analyze();
		return cyclesAnalysis;
	}

	private @NonNull CyclesAnalysis<@NonNull RegionAnalysis> computeCyclicTraceClasses() {
		//
		//	Each mapping partitioner that consumes no trace class, is an acyclic producer.
		//
		Set<@NonNull RegionAnalysis> acyclicProducers = new HashSet<>();
		for (@NonNull RegionAnalysis regionAnalysis : region2regionAnalysis.values()) {
			Iterable<@NonNull TraceClassAnalysis<@NonNull RegionAnalysis>> consumedTraceClassAnalyses = regionAnalysis.getConsumedTraceClassAnalyses();
			if (consumedTraceClassAnalyses == null) {
				acyclicProducers.add(regionAnalysis);
			}
		}
		/*		for (@NonNull TraceClassAnalysis middleAnalysis : class2middleAnalysis.values()) {
		CompleteClass traceClass = middleAnalysis.getTraceClass();
		for (@NonNull CompleteClass superCompleteClass : traceClass.getProperSuperCompleteClasses()) {
			for (@NonNull RegionAnalysis producer : middleAnalysis.getProducers()) {
				addProducer(superCompleteClass, producer);
			}
		}
	} */

		CyclesAnalysis<@NonNull RegionAnalysis> cyclesAnalysis = computeCyclesAnalysis();
		//
		//	Each TraceClassAnalysis produced only by acyclic partitioners identifies an acyclic trace class
		// ?? is this cdead ?? should it be for TracePropertyAnalysis too ??
		Set<@NonNull TraceClassRegionAnalysis> acylicAnalysis = new HashSet<>();
		for (@NonNull RegionAnalysis acyclicProducer : acyclicProducers) {
			for (@NonNull Node traceNode : acyclicProducer.getTraceNodes()) {
				ClassDatum traceClassDatum = QVTscheduleUtil.getClassDatum(traceNode);
				TraceClassRegionAnalysis middleAnalysis = classDatum2traceClassAnalysis.get(traceClassDatum);
				assert middleAnalysis != null;
				if (QVTbaseUtil.containsAll(acyclicProducers, middleAnalysis.getProducers())) {
					acylicAnalysis.add(middleAnalysis);
				}
			}
		}
		return cyclesAnalysis;
	}

	private void computeTraceClassInheritance() {
		for (@NonNull TraceClassRegionAnalysis subTraceClassRegionAnalysis : classDatum2traceClassAnalysis.values()) {
			ClassDatum traceClassDatum = subTraceClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superTraceClassDatum : QVTscheduleUtil.getSuperClassDatums(traceClassDatum)) {
				if (superTraceClassDatum != traceClassDatum) {
					TraceClassRegionAnalysis superTraceClassRegionAnalysis = classDatum2traceClassAnalysis.get(superTraceClassDatum);
					if (superTraceClassRegionAnalysis != null) {
						superTraceClassRegionAnalysis.addSubTraceClassAnalysis(subTraceClassRegionAnalysis);
						subTraceClassRegionAnalysis.addSuperTraceClassAnalysis(superTraceClassRegionAnalysis);
					}
				}
			}
		}
	}

	private void computeTraceClassDiscrimination() throws CompilerChainException {
		for (@NonNull TraceClassRegionAnalysis traceClassAnalysis : classDatum2traceClassAnalysis.values()) {
			traceClassAnalysis.discriminate();
		}
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

	public @Nullable CycleAnalysis<@NonNull RegionAnalysis> getCycleAnalysis(@NonNull ClassDatum traceClassDatum) {
		TraceClassRegionAnalysis traceClassAnalysis = classDatum2traceClassAnalysis.get(traceClassDatum);
		if (traceClassAnalysis == null) {
			return null;
		}
		return getCycleAnalysis(traceClassAnalysis);
	}

	public @Nullable CycleRegionAnalysis getCycleAnalysis(@NonNull RegionAnalysis regionAnalysis) {
		assert cyclesAnalysis != null;
		return cyclesAnalysis != null ? (CycleRegionAnalysis)cyclesAnalysis.getCycleAnalysis(regionAnalysis) : null;
	}

	public @Nullable CycleAnalysis<@NonNull RegionAnalysis> getCycleAnalysis(@NonNull TraceClassAnalysis<@NonNull RegionAnalysis> traceClassAnalysis) {
		assert cyclesAnalysis != null;
		return cyclesAnalysis != null ? cyclesAnalysis.getCycleAnalysis(traceClassAnalysis) : null;
	}

	@Override
	public String getName() {
		return transformation.getName();
	}

	public @NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region) {
		RegionAnalysis regionAnalysis = region2regionAnalysis.get(region);
		if (regionAnalysis == null) {
			regionAnalysis = new RegionAnalysis(this, region);
			region2regionAnalysis.put(region, regionAnalysis);
		}
		return regionAnalysis;
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

	public @NonNull TraceClassAnalysis<@NonNull RegionAnalysis> getTraceClassAnalysis(@NonNull ClassDatum traceClassDatum) {
		return ClassUtil.nonNullState(classDatum2traceClassAnalysis.get(traceClassDatum));
	}

	public @NonNull TracePropertyAnalysis<@NonNull RegionAnalysis> getTracePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
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

	public boolean isCyclic(@NonNull ClassDatum traceClassDatum) {
		TraceClassRegionAnalysis traceClassAnalysis = classDatum2traceClassAnalysis.get(traceClassDatum);
		if (traceClassAnalysis == null) {
			return false;
		}
		return traceClassAnalysis.isCyclic();
	}

	public void prePartition() throws CompilerChainException {
		if (scheduleManager.needsDiscrimination()) {
			computeTraceClassDiscrimination();
		}
		computeTraceClassInheritance();
		this.cyclesAnalysis = computeCyclicTraceClasses();
		//		this.fallibilityAnalysis = computeFallibilityAnalysis();

	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(transformation);
	}
}
