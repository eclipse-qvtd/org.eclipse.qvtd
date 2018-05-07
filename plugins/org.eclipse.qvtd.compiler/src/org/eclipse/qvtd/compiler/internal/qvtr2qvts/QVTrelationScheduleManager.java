/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.QVTrelationDomainUsageAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationalTransformationAnalysis2TracePackage;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

public class QVTrelationScheduleManager extends AbstractScheduleManager
{
	protected final @NonNull QVTuConfiguration qvtuConfiguration;

	protected QVTrelationScheduleManager(@NonNull EnvironmentFactory environmentFactory, @NonNull QVTuConfiguration qvtuConfiguration,
			CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(QVTscheduleFactory.eINSTANCE.createScheduleModel(), environmentFactory, schedulerOptions);
		this.qvtuConfiguration = qvtuConfiguration;
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis() {
		return new QVTrelationDomainUsageAnalysis(environmentFactory);
	}

	@Override
	public @NonNull ExpressionSynthesizer createExpressionSynthesizer(@NonNull RuleAnalysis ruleAnalysis) {
		return new QVTrelationExpressionSynthesizer((RelationAnalysis) ruleAnalysis);
	}

	@Override
	protected @NonNull NameGenerator createNameGenerator() {
		return new QVTrelationNameGenerator();
	}

	@Override
	public @NonNull RelationAnalysis createRuleAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Rule asRule) {
		RuleRegion ruleRegion = QVTscheduleFactory.eINSTANCE.createRuleRegion();
		//		if (!asRule.isIsAbstract()) {
		ruleRegion.setOwningScheduleModel(scheduleModel);
		//		}
		ruleRegion.setReferredRule(asRule);
		ruleRegion.setName(getNameGenerator().createMappingName((Relation) asRule, null, qvtuConfiguration));
		return new RelationAnalysis(transformationAnalysis, qvtuConfiguration, ruleRegion);
	}

	@Override
	public @NonNull RuleAnalysis2TraceGroup createRuleAnalysis2TraceGroup(@NonNull RuleAnalysis ruleAnalysis) {
		return new RelationAnalysis2TraceGroup((RelationAnalysis)ruleAnalysis);
	}

	@Override
	protected @NonNull TransformationAnalysis createTransformationAnalysis(@NonNull Transformation asTransformation) {
		ScheduledRegion scheduledRegion = QVTscheduleFactory.eINSTANCE.createScheduledRegion();
		getScheduleModel().getOwnedScheduledRegions().add(scheduledRegion);
		scheduledRegion.setReferredTransformation(asTransformation);
		scheduledRegion.setName(asTransformation.getName());
		return new RelationalTransformationAnalysis(this, (RelationalTransformation) asTransformation, scheduledRegion);
	}

	@Override
	public @NonNull TransformationAnalysis2TracePackage createTransformationAnalysis2TracePackage(@NonNull TransformationAnalysis transformationAnalysis) {
		return new RelationalTransformationAnalysis2TracePackage(this, transformationAnalysis);
	}

	@Override
	public @NonNull QVTrelationDomainUsageAnalysis getDomainUsageAnalysis() {
		return (QVTrelationDomainUsageAnalysis) super.getDomainUsageAnalysis();
	}

	@Override
	protected @NonNull URI getGraphsBaseURI() {
		return getScheduleModel().eResource().getURI().trimSegments(1).appendSegment("graphs").appendSegment("");
	}

	//	public @NonNull QVTuConfiguration getQVTuConfiguration() {
	//		return qvtuConfiguration;
	//	}

	@Override
	public @NonNull QVTrelationNameGenerator getNameGenerator() {
		return (QVTrelationNameGenerator) super.getNameGenerator();
	}

	@Override
	public @NonNull RelationAnalysis getRuleAnalysis(@NonNull Rule relation) {
		return (RelationAnalysis) super.getRuleAnalysis(relation);
	}

	@Override
	public @NonNull RelationalTransformationAnalysis getTransformationAnalysis(@NonNull Transformation transformation) {
		return (RelationalTransformationAnalysis) super.getTransformationAnalysis(transformation);
	}

	@Override
	public boolean isInput(@NonNull Domain domain) {
		return qvtuConfiguration.isInput(QVTrelationUtil.getTypedModel(domain));
	}

	@Override
	public boolean isOutput(@NonNull Domain domain) {
		return qvtuConfiguration.isOutput(QVTrelationUtil.getTypedModel(domain));
	}

	@Override
	public boolean needsDiscrimination() {
		return false;
	}

	@Override
	public boolean useActivators() {
		return true;
	}
}