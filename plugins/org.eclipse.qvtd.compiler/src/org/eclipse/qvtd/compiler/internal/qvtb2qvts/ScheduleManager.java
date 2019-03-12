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
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ConnectionManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
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
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;

public interface ScheduleManager
{
	void addMappingRegion(@NonNull MappingRegion mappingRegion);
	void addPartitionError(@NonNull Partition partition, @NonNull String messageTemplate, Object... bindings);
	void addPartitionWarning(@NonNull Partition partition, @NonNull String messageTemplate, Object... bindings);
	void addProblem(@NonNull CompilerProblem problem);
	void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings);
	void addRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings);

	/**
	 * Define an additional/only Transformation to be scheduled by the subsequent anayses and syntheses.
	 */
	@NonNull AbstractTransformationAnalysis addTransformation(@NonNull Transformation asTransformation);
	void analyzeCompletePackage(@NonNull TypedModel typedModel, @NonNull CompletePackage completePackage);
	@NonNull OperationRegion analyzeOperation(@NonNull OperationCallExp operationCallExp);
	@NonNull OriginalContentsAnalysis analyzeOriginalContents();

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
	@NonNull Map<@NonNull RootRegion, @NonNull Iterable<@NonNull RuleRegion>> analyzeTransformations();

	@Nullable ConnectionManager basicGetConnectionManager();
	@Nullable Property basicGetGlobalSuccessProperty(@NonNull Node node);
	@Nullable Property basicGetLocalSuccessProperty(@NonNull Node node);
	@NonNull ConnectionManager createConnectionManager(@NonNull ProblemHandler problemHandler, @NonNull LoadingRegionAnalysis loadingRegionAnalysis);
	@NonNull ExpressionSynthesizer createExpressionSynthesizer(@NonNull RuleAnalysis ruleAnalysis);
	@NonNull RuleAnalysis createRuleAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull Rule asRule);
	@NonNull RuleAnalysis2TraceGroup createRuleAnalysis2TraceGroup(@NonNull RuleAnalysis ruleAnalysis);
	@NonNull TransformationAnalysis2TracePackage createTransformationAnalysis2TracePackage(@NonNull AbstractTransformationAnalysis transformationAnalysis);
	@NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum);
	@NonNull ClassDatum getBooleanClassDatum();
	@NonNull Property getCastProperty(@NonNull Type type);
	@NonNull ClassDatum getClassDatum(@NonNull TypedElement asTypedElement);
	@NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class asType);
	@NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass);
	@NonNull Iterable<@NonNull ClassDatum> getClassDatums();
	@NonNull ConnectionManager getConnectionManager();
	@NonNull RootDomainUsageAnalysis getDomainUsageAnalysis();
	@NonNull DomainUsage getDomainUsage(@NonNull Element element);
	@NonNull ClassDatum getElementalClassDatum(@NonNull ClassDatum classDatum);
	@NonNull EnvironmentFactory getEnvironmentFactory();
	@NonNull NameGenerator getNameGenerator();
	@NonNull Iterable<@NonNull PropertyDatum> getOclContainerPropertyDatums(@NonNull ClassDatum classDatum);
	@NonNull ClassDatum getOclVoidClassDatum();

	/**
	 * Return a determinstic alphabetical ordereding of the TransformationAnalysis instances.
	 */
	@NonNull Iterable<@NonNull AbstractTransformationAnalysis> getOrderedTransformationAnalyses();

	/**
	 * Return the analysis of the pre-partitioned regions consumptions and productions.
	 */
	@NonNull OriginalContentsAnalysis getOriginalContentsAnalysis();

	@NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum classDatum, @NonNull Property property);
	@NonNull PropertyDatum getPropertyDatum(@NonNull NavigableEdge edge);
	@NonNull QVTbaseLibraryHelper getQVTbaseLibraryHelper();
	@NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region);
	@NonNull RootPartitionAnalysis getRootPartitionAnalysis(@NonNull RootRegion rootRegion);
	@NonNull ScheduleModel getScheduleModel();
	@NonNull StandardLibrary getStandardLibrary();
	@NonNull StandardLibraryHelper getStandardLibraryHelper();
	@NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty);
	@NonNull Iterable<@NonNull ClassDatum> getSuperClassDatums(@NonNull ClassDatum classDatum);
	@NonNull TraceHelper getTraceHelper();
	@NonNull TypedModel getTraceTypedModel();
	@NonNull Iterable<@NonNull AbstractTransformationAnalysis> getTransformationAnalyses();
	@NonNull AbstractTransformationAnalysis getTransformationAnalysis(@NonNull RootRegion rootRegion);
	@NonNull AbstractTransformationAnalysis getTransformationAnalysis(@NonNull Transformation transformation);

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

	boolean isInput(@NonNull TypedModel typedModel);
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

	void setRootRegion(@NonNull MappingRegion mappingRegion, @Nullable RootRegion rootRegion);

	/**
	 * Eeturn true to use the new QVTr ActivatorRegion support, false to retain the older, one day obsolete support.
	 */
	boolean useActivators();
	void writeDebugGraphs(@NonNull Graphable graphable, @Nullable String context);
	void writeDebugGraphs(@NonNull String context, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph);

	//	void wipAddPartition(@NonNull Partition partition, @NonNull Region partitionedRegion);
	//	@NonNull Partition wipGetPartition(@NonNull Region partitionedRegion);
	//	@NonNull Region wipGetRegion(@NonNull Partition partition);
}