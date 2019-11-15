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
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.BasicScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.MappingAnalysis.QVTcoreExpressionSynthesizer;
import org.eclipse.qvtd.compiler.internal.usage.DirectedDomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.usage.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.usage.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;

public class QVTcoreScheduleManager extends BasicScheduleManager
{
	protected final @NonNull TypedModelsConfiguration typedModelsConfiguration;

	public QVTcoreScheduleManager(@NonNull EnvironmentFactory environmentFactory, @NonNull Transformation transformation, @NonNull TypedModelsConfiguration typedModelsConfiguration, @NonNull ProblemHandler problemHandler, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(QVTscheduleFactory.eINSTANCE.createScheduleModel(), environmentFactory, transformation, problemHandler, schedulerOptions);
		this.typedModelsConfiguration = typedModelsConfiguration;
	}

	@Override
	protected @NonNull DirectedDomainUsageAnalysis createDirectedDomainUsageAnalysis() {
		return new QVTcoreDomainUsageAnalysis.QVTcoreDirectedDomainUsageAnalysis((QVTcoreDomainUsageAnalysis)domainUsageAnalysis, typedModelsConfiguration);
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis() {
		return new QVTcoreDomainUsageAnalysis(environmentFactory, problemHandler, transformation);
	}

	@Override
	public @NonNull MappingAnalysis createRuleAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull Rule asRule) {
		RuleRegion ruleRegion = QVTscheduleFactory.eINSTANCE.createRuleRegion();
		ruleRegion.setOwningScheduleModel(scheduleModel);
		ruleRegion.setReferredRule(asRule);
		ruleRegion.setName(asRule.getName());
		return new MappingAnalysis(transformationAnalysis, ruleRegion);
	}

	@Override
	public @NonNull Rule2TraceGroup createRule2TraceGroup(@NonNull Transformation2TracePackage transformation2TracePackage, @NonNull Rule rule) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected @NonNull AbstractTransformationAnalysis createTransformationAnalysis(@NonNull Transformation asTransformation) {
		RootRegion rootRegion = QVTscheduleFactory.eINSTANCE.createRootRegion();
		getScheduleModel().getOwnedRootRegions().add(rootRegion);
		rootRegion.setReferredTransformation(asTransformation);
		rootRegion.setName(asTransformation.getName());
		return new CoreTransformationAnalysis(this, asTransformation, rootRegion);
	}

	@Override
	public @NonNull Transformation2TracePackage createTransformation2TracePackage(@NonNull Transformation transformation) {
		return new Transformation2TracePackage(this, transformation)
		{
			@Override
			public org.eclipse.ocl.pivot.@Nullable Class getTransformationTraceClass() {
				return null;
			}
		};
	}

	@Override
	public @NonNull ExpressionSynthesizer createUnconditionalExpressionSynthesizer(@NonNull RuleAnalysis ruleAnalysis) {
		return new QVTcoreExpressionSynthesizer(ruleAnalysis, null);
	}

	@Override
	public @NonNull ClassDatum getTransformationTraceClassDatum(@NonNull Transformation transformation) {
		TypedModel traceTypedModel = getDomainUsageAnalysis().getTraceTypedModel();
		return getClassDatum(traceTypedModel, transformation);
	}

	@Override
	public @NonNull TypedModelsConfiguration getTypedModelsConfiguration() {
		return typedModelsConfiguration;
	}

	@Override
	public boolean needsDiscrimination() {
		return true;
	}

	@Override
	public boolean useActivators() {
		return false;
	}
}