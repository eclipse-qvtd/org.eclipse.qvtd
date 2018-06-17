/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;

public interface ScheduleManager
{
	void addMappingRegion(@NonNull MappingRegion mappingRegion);
	void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings);
	void addRegionWarning(@NonNull Region region, @NonNull String messageTemplate, Object... bindings);
	@NonNull TransformationAnalysis addTransformation(@NonNull Transformation asTransformation);
	@NonNull OperationRegion analyzeOperation(@NonNull OperationCallExp operationCallExp);
	void analyzeTransformations();
	@Nullable Property basicGetStatusProperty(@NonNull Node node);
	@NonNull ExpressionAnalyzer createExpressionAnalyzer(@NonNull RuleAnalysis ruleAnalysis);
	@NonNull RuleAnalysis createRuleAnalysis(@NonNull Rule asRule);
	@NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum);
	@NonNull Property getCastProperty(@NonNull Type type);
	@NonNull ClassDatum getClassDatum(@NonNull TypedElement asTypedElement);
	@NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, org.eclipse.ocl.pivot.@NonNull Class asType);
	@NonNull ClassDatum getClassDatum(@NonNull TypedModel typedModel, @NonNull CompleteClass completeClass);
	@NonNull Iterable<@NonNull ClassDatum> getClassDatums();
	@NonNull RootDomainUsageAnalysis getDomainUsageAnalysis();
	@NonNull DomainUsage getDomainUsage(@NonNull Element element);
	@NonNull ClassDatum getElementalClassDatum(@NonNull ClassDatum classDatum);
	@NonNull EnvironmentFactory getEnvironmentFactory();
	@NonNull ClassDatum getOclVoidClassDatum();
	@NonNull RegionAnalysis getRegionAnalysis(@NonNull Region region);
	@NonNull ScheduleModel getScheduleModel();
	@NonNull StandardLibrary getStandardLibrary();
	@NonNull StandardLibraryHelper getStandardLibraryHelper();
	@NonNull PropertyDatum getSuccessPropertyDatum(@NonNull Property successProperty);
	@NonNull Iterable<@NonNull ClassDatum> getSuperClassDatums(@NonNull ClassDatum classDatum);
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
	 * Return true if node is part of the middle (traced) domain.
	 */
	boolean isMiddle(@NonNull Node node);

	boolean isNoEarlyMerge();
	boolean isNoLateConsumerMerge();
	void setScheduledRegion(@NonNull MappingRegion mappingRegion, @Nullable ScheduledRegion scheduledRegion);
	void writeDebugGraphs(@NonNull Region region, @Nullable String context);
	void writeDebugGraphs(@NonNull String context, boolean doNodesGraph, boolean doRegionGraph, boolean doCallGraph);
}