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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.MappingAnalysis.QVTcoreExpressionSynthesizer;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtcore.analysis.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

public class QVTcoreScheduleManager extends AbstractScheduleManager
{
	public QVTcoreScheduleManager(@NonNull EnvironmentFactory environmentFactory, @NonNull ProblemHandler problemHandler, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(QVTscheduleFactory.eINSTANCE.createScheduleModel(), environmentFactory, problemHandler, schedulerOptions);
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis() {
		return new QVTcoreDomainUsageAnalysis(environmentFactory);
	}

	@Override
	public @NonNull ExpressionSynthesizer createExpressionSynthesizer(@NonNull RuleAnalysis ruleAnalysis) {
		return new QVTcoreExpressionSynthesizer(ruleAnalysis);
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
	public @NonNull RuleAnalysis2TraceGroup createRuleAnalysis2TraceGroup(@NonNull RuleAnalysis ruleAnalysis) {
		throw new UnsupportedOperationException();
	}

	@Override
	protected @NonNull AbstractTransformationAnalysis createTransformationAnalysis(@NonNull Transformation asTransformation) {
		ScheduledRegion scheduledRegion = QVTscheduleFactory.eINSTANCE.createScheduledRegion();
		getScheduleModel().getOwnedScheduledRegions().add(scheduledRegion);
		scheduledRegion.setReferredTransformation(asTransformation);
		scheduledRegion.setName(asTransformation.getName());
		return new CoreTransformationAnalysis(this, asTransformation, scheduledRegion);
	}

	@Override
	public @NonNull TransformationAnalysis2TracePackage createTransformationAnalysis2TracePackage(@NonNull AbstractTransformationAnalysis transformationAnalysis) {
		return new TransformationAnalysis2TracePackage(this, transformationAnalysis) {};
	}

	@Override
	public boolean isInput(@NonNull Domain domain) {
		return domain.isIsCheckable();
	}

	@Override
	public boolean isInput(@NonNull TypedModel typedModel) {
		return getDomainUsage(typedModel).isInput();
	}

	@Override
	public boolean isOutput(@NonNull Domain domain) {
		return domain.isIsEnforceable();
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