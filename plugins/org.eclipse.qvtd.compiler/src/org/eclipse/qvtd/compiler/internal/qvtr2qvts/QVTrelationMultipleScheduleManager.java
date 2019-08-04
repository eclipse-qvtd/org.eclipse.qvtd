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
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.BasicScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.DatumCaches;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.QVTrelationDomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationalTransformationAnalysis2TracePackage;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

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

	public void addDirectedRootRegions(@NonNull QVTrelationDirectedScheduleManager directedScheduleManager, @NonNull Iterable<@NonNull RootRegion> rootRegions) {
		for (@NonNull RootRegion rootRegion : rootRegions) {
			QVTrelationDirectedScheduleManager oldDirectedScheduleManager = rootRegion2directedScheduleManager.put(rootRegion, directedScheduleManager);
			assert oldDirectedScheduleManager == null;
		}
	}

	@Override
	public @Nullable Property basicGetGlobalSuccessProperty(@NonNull Node node) {
		if (!isMiddle(node)) {
			return null;
		}
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(node);
		for (@NonNull CompleteClass completeClass : QVTscheduleUtil.getCompleteClasses(classDatum)) {	// Middle model never has multiples
			Property property = completeClass.getProperty(getNameGenerator().createTraceGlobalSuccessPropertyName(getTargetTypedModel()));
			if (property != null) {
				return property;
			}
		}
		return null;
	}

	public @NonNull QVTrelationDirectedScheduleManager createDirectedScheduleManager(@NonNull QVTuConfiguration qvtuConfiguration) {
		return new QVTrelationDirectedScheduleManager(this, transformation, qvtuConfiguration, schedulerOptions);
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis() {
		return new QVTrelationDomainUsageAnalysis(environmentFactory, transformation);
	}

	@Override
	public @NonNull ExpressionSynthesizer createExpressionSynthesizer(@NonNull RuleAnalysis ruleAnalysis) {
		return new QVTrelationExpressionSynthesizer((RelationAnalysis) ruleAnalysis);
	}

	@Override
	public @NonNull RuleAnalysis2TraceGroup createRuleAnalysis2TraceGroup(@NonNull RuleAnalysis ruleAnalysis) {
		return new RelationAnalysis2TraceGroup((RelationAnalysis)ruleAnalysis);
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
	public @NonNull TransformationAnalysis2TracePackage createTransformationAnalysis2TracePackage(@NonNull AbstractTransformationAnalysis transformationAnalysis) {
		return new RelationalTransformationAnalysis2TracePackage(this, transformationAnalysis);
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
	public @NonNull Iterable<@NonNull AbstractTransformationAnalysis> getOrderedTransformationAnalyses() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull RelationAnalysis getRuleAnalysis(@NonNull Rule relation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull RelationalTransformationAnalysis getTransformationAnalysis(@NonNull Transformation transformation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isInput(@NonNull Domain domain) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isInput(@NonNull TypedModel typedModel) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isOutput(@NonNull Domain domain) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isOutput(@NonNull TypedModel typedModel) {
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