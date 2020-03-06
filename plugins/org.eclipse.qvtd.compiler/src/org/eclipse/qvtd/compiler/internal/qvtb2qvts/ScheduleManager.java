/*******************************************************************************
 * Copyright (c) 2015, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

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
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ConnectionManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.TraceHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeLibraryHelper;

public interface ScheduleManager
{
	void addMappingRegion(@NonNull MappingRegion mappingRegion);
	void addProblem(@NonNull CompilerProblem problem);
	void analyzeCompletePackage(@NonNull TypedModel typedModel, @NonNull CompletePackage completePackage);
	@NonNull OperationRegion analyzeOperation(@NonNull OperationCallExp operationCallExp);
	@NonNull OriginalContentsAnalysis analyzeOriginalContents();

	/**
	 * Perform the pre-analysis that relies solely on traversal of the QVTr source model.
	 */
	void analyzeSourceModel(@NonNull ProblemHandler problemHandler);

	/**
	 * Perform the late analysis of a synthesized trace Package.
	 */
	void analyzeTracePackage(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Package tracePackage);

	/**
	 * Perform the interdependent global analysis of each Rule within its Transformation.
	 */
	@NonNull AbstractTransformationAnalysis analyzeTransformation();

	@Nullable ConnectionManager basicGetConnectionManager();
	//	@Nullable Property basicGetGlobalSuccessProperty(@NonNull Node node);
	//	@Nullable Property basicGetLocalSuccessProperty(@NonNull Node node);

	/**
	 * Return true if targetNode is one rather than all of the elements computed by the property navigation to targetNode.
	 *
	 * FIXME Many calls to this are lazy; cannot possibly be partial.
	 */
	boolean computeIsPartial(@NonNull Node targetNode, @NonNull Property property);
	@NonNull ConnectionManager createConnectionManager(@NonNull ProblemHandler problemHandler, @NonNull LoadingRegionAnalysis loadingRegionAnalysis);
	@NonNull ExpressionSynthesizer createRootExpressionSynthesizer(@NonNull RuleAnalysis ruleAnalysis);
	@NonNull RuleAnalysis createRuleAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull Rule asRule);
	@NonNull Rule2TraceGroup createRule2TraceGroup(@NonNull Transformation2TracePackage transformation2TracePackage, @NonNull Rule rule);
	@NonNull Transformation2TracePackage createTransformation2TracePackage(@NonNull Transformation transformation);
	@NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum);
	@NonNull Iterable<@NonNull RuleRegion> gatherRuleRegions();
	@NonNull PropertyDatum getBasePropertyDatum(@NonNull PropertyDatum propertyDatum);
	@NonNull ClassDatum getBooleanClassDatum();
	@NonNull ClassDatum getClassDatum(@NonNull TypedElement asTypedElement);
	@NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull Type asType);
	@NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass);
	@NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull Iterable<@NonNull CompleteClass> completeClasses);
	@NonNull Iterable<@NonNull ClassDatum> getClassDatums();
	@NonNull ConnectionManager getConnectionManager();
	@NonNull ScheduleManager getDirectedScheduleManager(@NonNull RootRegion rootRegion);
	@NonNull RootDomainUsageAnalysis getDomainUsageAnalysis();
	@NonNull DomainUsage getDomainUsage(@NonNull Element element);
	@NonNull ClassDatum getElementalClassDatum(@NonNull ClassDatum classDatum);
	@NonNull ClassDatum getElementalTargetClassDatum(@NonNull PropertyDatum propertyDatum);
	@NonNull EnvironmentFactory getEnvironmentFactory();
	@NonNull ScheduleManager getMultipleScheduleManager();
	@NonNull NameGenerator getNameGenerator();
	//	@NonNull Iterable<@NonNull PropertyDatum> getOclContainerPropertyDatums(@NonNull ClassDatum classDatum);
	@NonNull ClassDatum getOclVoidClassDatum();

	/**
	 * Lazily create the opposite of a propertyDatum.
	 *
	@NonNull PropertyDatum getOppositePropertyDatum(@NonNull PropertyDatum propertyDatum); */

	/**
	 * Return the analysis of the pre-partitioned regions consumptions and productions.
	 */
	@NonNull OriginalContentsAnalysis getOriginalContentsAnalysis();

	@NonNull ProblemHandler getProblemHandler();
	@NonNull PropertyDatum getPropertyDatum(@NonNull ClassDatum sourceClassDatum, @NonNull Property property, @Nullable ClassDatum targetClassDatum);

	/**
	 * Return the PropertyDatum for the navigationEdge, which must not be a containment.
	 */
	@NonNull PropertyDatum getPropertyDatum(@NonNull NavigationEdge navigationEdge);

	/**
	 * Return the PropertyDatum for the navigationEdge, if it is not be a containment,
	 * or the PropertyDatums for the navigationEdge, if it is a containment.
	 */
	@NonNull Iterable<@NonNull PropertyDatum> getPropertyDatums(@NonNull NavigationEdge navigationEdge);
	@NonNull QVTruntimeLibraryHelper getQVTruntimeLibraryHelper();
	@NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region);
	@NonNull RootPartitionAnalysis getRootPartitionAnalysis(@NonNull RootRegion rootRegion);
	@NonNull RootRegion getRootRegion();
	@NonNull ScheduleModel getScheduleModel();
	@NonNull StandardLibrary getStandardLibrary();
	@NonNull StandardLibraryHelper getStandardLibraryHelper();
	@NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty);
	@NonNull Iterable<@NonNull ClassDatum> getSuperClassDatums(@NonNull ClassDatum classDatum);
	@NonNull TypedModel getTargetTypedModel();
	@NonNull TraceHelper getTraceHelper();
	@NonNull TypedModel getTraceTypedModel();
	@NonNull AbstractTransformationAnalysis getTransformationAnalysis();
	@NonNull AbstractTransformationAnalysis getTransformationAnalysis(@NonNull RootRegion rootRegion);
	@NonNull ClassDatum getTransformationTraceClassDatum(@NonNull Transformation transformation);
	@NonNull Transformation2TracePackage getTransformation2TracePackage(@NonNull Transformation transformation);
	@NonNull TypedModelsConfiguration getTypedModelsConfiguration();

	/**
	 * Return true if a mapping may assign this property in an input model.
	 */
	boolean isDirty(@NonNull Property property);

	/**
	 * Return true if domainUsage's typed model is configured as an input (and possibly an input+output).
	 */
	boolean isInput(@NonNull DomainUsage domainUsage);

	/**
	 * Return true if typedModel is configured as an input (and possibly an input+output).
	 */
	boolean isInput(@NonNull TypedModel typedModel);

	/**
	 * Return true if element is part of an input domain of rule.
	 */
	boolean isInputInRule(@NonNull Rule rule, @NonNull Element element);

	/**
	 * Return true if node is part of the middle (traced) domain.
	 */
	boolean isMiddle(@NonNull Node node);

	boolean isNoEarlyMerge();
	boolean isNoLateConsumerMerge();

	/**
	 * Return true if domainUsage's typed model is configured as an output (and possibly an input+output).
	 */
	boolean isOutput(@NonNull DomainUsage domainUsage);

	/**
	 * Return true if typedModel is configured as a output ( and possibly an input+output);.
	 */
	boolean isOutput(@NonNull TypedModel typedModel);

	/**
	 * Return true if element is part of an output domain of rule.
	 */
	boolean isOutputInRule(@NonNull Rule rule, @NonNull Element element);

	/**
	 * Return true if multiple trace class prodicers should be discrimated to enabale manually designed trace classes to
	 * accommodate M:N usage patterns as simple M:1 usages. (This is not needed for QVTr.)
	 */
	boolean needsDiscrimination();

	void setRootRegion(@NonNull MappingRegion mappingRegion, @Nullable RootRegion rootRegion);

	void throwCompilerChainExceptionForErrors() throws CompilerChainException;
	/**
	 * Return true to use the new QVTr ActivatorRegion support, false to retain the older, one day obsolete support.
	 */
	boolean useActivators();
	void writeDebugGraphs(@NonNull Graphable graphable, @Nullable String context);
	//	void writeDebugGraphs(@NonNull String context, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph);
	void writeDebugGraphs(@NonNull String context, @NonNull RootRegion rootRegion, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph);
}