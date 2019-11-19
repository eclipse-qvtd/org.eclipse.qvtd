/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.BasicScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.DatumCaches;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.QVTrelationDomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.usage.DirectedDomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.InitUtility;

/**
 * A QVTrelationMultipleScheduleManager supervises and proviides the shared functionality for a distinct
 * QVTrelationDirectedScheduleManager dor each scheduled direction.
 */
public class QVTrelationMultipleScheduleManager extends BasicScheduleManager implements QVTrelationScheduleManager
{
	private @NonNull Map<@NonNull RootRegion, @NonNull QVTrelationDirectedScheduleManager> rootRegion2directedScheduleManager = new HashMap<>();

	public QVTrelationMultipleScheduleManager(@NonNull EnvironmentFactory environmentFactory, @NonNull Transformation transformation, @NonNull ProblemHandler problemHandler,
			@NonNull ScheduleModel scheduleModel, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(scheduleModel, environmentFactory, transformation, problemHandler, schedulerOptions, new QVTrelationNameGenerator(), null, null);
	}

	/*	@Override
	public @Nullable Property basicGetGlobalSuccessProperty(@NonNull Node node) {
		if (!isMiddle(node)) {
			return null;
		}
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(node);
		for (@NonNull CompleteClass completeClass : QVTscheduleUtil.getCompleteClasses(classDatum)) {	// Middle model never has multiples
			Property property = completeClass.getProperty(getNameGenerator().createTraceGlobalSuccessPropertyName());
			if (property != null) {
				return property;
			}
		}
		return null;
	} */

	public @NonNull QVTrelationDirectedScheduleManager createDirectedScheduleManager(@NonNull TypedModelsConfiguration typedModelsConfiguration) {
		QVTrelationDirectedScheduleManager directedScheduleManager = new QVTrelationDirectedScheduleManager(this, transformation, typedModelsConfiguration, schedulerOptions);
		RootRegion rootRegion = directedScheduleManager.getRootRegion();
		QVTrelationDirectedScheduleManager oldDirectedScheduleManager = rootRegion2directedScheduleManager.put(rootRegion, directedScheduleManager);
		assert oldDirectedScheduleManager == null;
		return directedScheduleManager;
	}

	@Override
	protected @NonNull DirectedDomainUsageAnalysis createDirectedDomainUsageAnalysis() {
		throw new UnsupportedOperationException();
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis() {
		return new QVTrelationDomainUsageAnalysis(environmentFactory, problemHandler, transformation);
	}

	@Override
	public @NonNull ExpressionSynthesizer createRootExpressionSynthesizer(@NonNull RuleAnalysis ruleAnalysis) {
		return new QVTrelationExpressionSynthesizer((RelationAnalysis) ruleAnalysis, null, InitUtility.NON_NULL_MATCHED);
	}

	@Override
	public @NonNull Rule2TraceGroup createRule2TraceGroup(@NonNull Transformation2TracePackage transformation2TracePackage, @NonNull Rule rule) {
		return new Relation2TraceGroup(transformation2TracePackage, (Relation)rule);
	}

	@Override
	public @NonNull RelationAnalysis createRuleAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull Rule asRule) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected @NonNull AbstractTransformationAnalysis createTransformationAnalysis(@NonNull Transformation asTransformation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Transformation2TracePackage createTransformation2TracePackage(@NonNull Transformation transformation) {
		return new RelationalTransformation2TracePackage(this, (RelationalTransformation)transformation);
	}

	protected @NonNull DatumCaches getDatumCaches() {
		return datumCaches;
	}

	@Override
	public @NonNull QVTrelationDirectedScheduleManager getDirectedScheduleManager(@NonNull RootRegion rootRegion) {
		return ClassUtil.nonNullState(rootRegion2directedScheduleManager.get(rootRegion));
	}

	@Override
	public @NonNull QVTrelationDomainUsageAnalysis getDomainUsageAnalysis() {
		return (QVTrelationDomainUsageAnalysis) super.getDomainUsageAnalysis();
	}

	@Override
	public @NonNull QVTrelationNameGenerator getNameGenerator() {
		return (QVTrelationNameGenerator) super.getNameGenerator();
	}

	@Override
	public @NonNull RelationAnalysis getRuleAnalysis(@NonNull Rule relation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull AbstractTransformationAnalysis getTransformationAnalysis() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull ClassDatum getTransformationTraceClassDatum(@NonNull Transformation transformation) {
		RelationalTransformation2TracePackage transformation2TracePackage = getTransformation2TracePackage(transformation);
		org.eclipse.ocl.pivot.@NonNull Class transformationTraceClass = transformation2TracePackage.getTransformationTraceClass();
		TypedModel traceTypedModel = getDomainUsageAnalysis().getTraceTypedModel();
		return getClassDatum(traceTypedModel, transformationTraceClass);
	}

	@Override
	public @NonNull RelationalTransformation2TracePackage getTransformation2TracePackage(@NonNull Transformation transformation) {
		return (RelationalTransformation2TracePackage)super.getTransformation2TracePackage(transformation);
	}

	@Override
	public @NonNull TypedModelsConfiguration getTypedModelsConfiguration() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean needsDiscrimination() {
		return false;			// FIXME Bug 488647 discriminate cyclic QVTr output classes too
	}

	@Override
	public boolean useActivators() {
		return true;
	}
}