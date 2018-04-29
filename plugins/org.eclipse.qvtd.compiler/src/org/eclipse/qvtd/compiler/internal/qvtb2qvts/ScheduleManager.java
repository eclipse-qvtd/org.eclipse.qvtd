/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompletePackage;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseLibraryHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TraceHelper;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;

public interface ScheduleManager
{
	void addMappingRegion(@NonNull MappingRegion mappingRegion);
	void addProblem(@NonNull CompilerProblem problem);
	void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings);
	void addRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings);

	/**
	 * Define an additional/only Transformation to be scheduled by the subsequent anayses and syntheses.
	 */
	@NonNull TransformationAnalysis addTransformation(@NonNull Transformation asTransformation);
	void analyzeCompletePackage(@NonNull TypedModel typedModel, @NonNull CompletePackage completePackage);
	@NonNull OperationRegion analyzeOperation(@NonNull OperationCallExp operationCallExp);
	@NonNull ContentsAnalysis<@NonNull RuleRegion> analyzeOriginalContents();

	/**
	 * Perform the pre-analysis that relies solely on traversal of the QVTr source model.
	 */
	void analyzeSourceModel();

	/**
	 * Perform the late analysis of a synthesized trace Package.
	 */
	void analyzeTracePackage(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Package tracePackage);

	/**
	 * Perform the interdependent global analysis of each Rule within its Transformation.
	 */
	@NonNull Map<@NonNull ScheduledRegion, @NonNull Iterable<@NonNull RuleRegion>> analyzeTransformations();

	@Nullable Property basicGetSuccessProperty(@NonNull Node node);
	@NonNull ExpressionSynthesizer createExpressionSynthesizer(@NonNull RuleAnalysis ruleAnalysis);
	@NonNull RuleAnalysis createRuleAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Rule asRule);
	@NonNull RuleAnalysis2TraceGroup createRuleAnalysis2TraceGroup(@NonNull RuleAnalysis ruleAnalysis);
	@NonNull TransformationAnalysis2TracePackage createTransformationAnalysis2TracePackage(@NonNull TransformationAnalysis transformationAnalysis);
	@NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum);
	@NonNull ClassDatum getBooleanClassDatum();
	@NonNull Property getCastProperty(@NonNull Type type);
	@NonNull ClassDatum getClassDatum(@NonNull TypedElement asTypedElement);
	@NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class asType);
	@NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass);
	@NonNull Iterable<@NonNull ClassDatum> getClassDatums();
	@NonNull RootDomainUsageAnalysis getDomainUsageAnalysis();
	@NonNull DomainUsage getDomainUsage(@NonNull Element element);
	@NonNull ClassDatum getElementalClassDatum(@NonNull ClassDatum classDatum);
	@NonNull EnvironmentFactory getEnvironmentFactory();
	@NonNull NameGenerator getNameGenerator();
	@NonNull ClassDatum getOclVoidClassDatum();

	/**
	 * Return a determinstic alphabetical ordereding of the TransformationAnalysis instances.
	 */
	@NonNull Iterable<@NonNull TransformationAnalysis> getOrderedTransformationAnalyses();

	/**
	 * Return the analysis of the pre-partitioned regions consumptions and productions.
	 */
	@NonNull ContentsAnalysis<@NonNull RuleRegion> getOriginalContentsAnalysis();

	@NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum classDatum, @NonNull Property property);
	@NonNull PropertyDatum getPropertyDatum(@NonNull NavigableEdge edge);
	@NonNull QVTbaseLibraryHelper getQVTbaseLibraryHelper();
	@NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region);
	@NonNull ScheduleModel getScheduleModel();
	@NonNull StandardLibrary getStandardLibrary();
	@NonNull StandardLibraryHelper getStandardLibraryHelper();
	@NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty);
	@NonNull Iterable<@NonNull ClassDatum> getSuperClassDatums(@NonNull ClassDatum classDatum);
	@NonNull TraceHelper getTraceHelper();
	@NonNull TypedModel getTraceTypedModel();
	@NonNull Iterable<@NonNull TransformationAnalysis> getTransformationAnalyses();
	@NonNull TransformationAnalysis getTransformationAnalysis(@NonNull Transformation transformation);

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	boolean isDirty(@NonNull Property property);

	/**
	 * Return true if the elemental source type of thatEdge is compatible with the source type of thisEdge.
	 */
	boolean isElementallyConformantSource(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge);

	/**
	 * Return true if domain is an input domain.
	 */
	boolean isInput(@NonNull Domain domain);

	/**
	 * Return true if node is part of the middle (traced) domain.
	 */
	boolean isMiddle(@NonNull Node node);

	boolean isNoEarlyMerge();
	boolean isNoLateConsumerMerge();

	/**
	 * Return true if domain is an output domain.
	 */
	boolean isOutput(@NonNull Domain domain);

	/**
	 * Return true if multiple trace class prodicers should be discrimated to enabale manually designed trace classes to
	 * accommodate M:N usage patterns as simple M:1 usages. (This is not needed for QVTr.)
	 */
	boolean needsDiscrimination();

	void setScheduledRegion(@NonNull MappingRegion mappingRegion, @Nullable ScheduledRegion scheduledRegion);

	/**
	 * Eeturn true to use the new QVTr ActivatorRegion support, false to retain the older, one day obsolete support.
	 */
	boolean useActivators();
	void writeDebugGraphs(@NonNull Region region, @Nullable String context);
	void writeDebugGraphs(@NonNull String context, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph);
}