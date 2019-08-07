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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.BasicScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.QVTrelationDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;

/**
 * A QVTrelationDirectedScheduleManager supervises one of the distinct scheduled directions
 * supervised by a QVTrelationMultipleScheduleManager.
 */
public class QVTrelationDirectedScheduleManager extends BasicScheduleManager implements QVTrelationScheduleManager
{
	protected final @NonNull QVTrelationMultipleScheduleManager multipleScheduleManager;
	protected final @NonNull QVTuConfiguration qvtuConfiguration;

	public QVTrelationDirectedScheduleManager(@NonNull QVTrelationMultipleScheduleManager multipleScheduleManager, @NonNull Transformation transformation,
			@NonNull QVTuConfiguration qvtuConfiguration, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(multipleScheduleManager.getScheduleModel(), multipleScheduleManager.getEnvironmentFactory(), transformation,
			multipleScheduleManager.getProblemHandler(), schedulerOptions,
			multipleScheduleManager.getNameGenerator(), multipleScheduleManager.getDatumCaches(), multipleScheduleManager.getDomainUsageAnalysis());
		this.multipleScheduleManager = multipleScheduleManager;
		this.qvtuConfiguration = qvtuConfiguration;
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

	@Override
	public @Nullable Property basicGetLocalSuccessProperty(@NonNull Node node) {
		if (!isMiddle(node)) {
			return null;
		}
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(node);
		for (@NonNull CompleteClass completeClass : QVTscheduleUtil.getCompleteClasses(classDatum)) {	// Middle model never has multiples
			Property property = completeClass.getProperty(getNameGenerator().createTraceLocalSuccessPropertyName(getTargetTypedModel()));
			if (property != null) {
				return property;
			}
		}
		return null;
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull ExpressionSynthesizer createExpressionSynthesizer(@NonNull RuleAnalysis ruleAnalysis) {
		return multipleScheduleManager.createExpressionSynthesizer(ruleAnalysis);
	}

	@Override
	public @NonNull RelationAnalysis createRuleAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull Rule asRule) {
		RuleRegion ruleRegion = QVTscheduleFactory.eINSTANCE.createRuleRegion();
		//		if (!asRule.isIsAbstract()) {
		ruleRegion.setOwningScheduleModel(scheduleModel);
		//		}
		ruleRegion.setReferredRule(asRule);
		ruleRegion.setName(getNameGenerator().createMappingName((Relation) asRule, null, qvtuConfiguration));
		return new RelationAnalysis(transformationAnalysis, qvtuConfiguration, ruleRegion);
	}

	@Override
	public @NonNull Rule2TraceGroup createRule2TraceGroup(@NonNull Transformation2TracePackage transformation2TracePackage, @NonNull Rule rule) {
		//		return multipleScheduleManager.createRule2TraceGroup(transformation2TracePackage, rule);
		throw new UnsupportedOperationException();
	}

	@Override
	protected @NonNull AbstractTransformationAnalysis createTransformationAnalysis(@NonNull Transformation asTransformation) {
		RootRegion rootRegion = QVTscheduleFactory.eINSTANCE.createRootRegion();
		getScheduleModel().getOwnedRootRegions().add(rootRegion);
		rootRegion.setReferredTransformation(asTransformation);
		rootRegion.setName(getDirectedName(asTransformation));
		return new RelationalTransformationAnalysis(this, (RelationalTransformation) asTransformation, rootRegion);
	}

	@Override
	public @NonNull Transformation2TracePackage createTransformation2TracePackage(@NonNull Transformation transformation) {
		throw new UnsupportedOperationException();
	}

	public @NonNull String getDirectedName(@NonNull Transformation asTransformation) {
		StringBuilder s = new StringBuilder();
		s.append(QVTbaseUtil.getName(asTransformation));
		s.append("_");
		s.append(PivotUtil.getName(qvtuConfiguration.getTargetTypedModel()));
		return s.toString();
	}

	@Override
	public @NonNull QVTrelationDomainUsageAnalysis getDomainUsageAnalysis() {
		return multipleScheduleManager.getDomainUsageAnalysis();
	}

	@Override
	public @NonNull ScheduleManager getMultipleScheduleManager() {
		return multipleScheduleManager;
	}

	@Override
	public @NonNull QVTrelationNameGenerator getNameGenerator() {
		return multipleScheduleManager.getNameGenerator();
	}

	@Override
	protected @NonNull QVTuConfiguration getQVTuConfiguration() {
		return qvtuConfiguration;
	}

	@Override
	public @NonNull RelationAnalysis getRuleAnalysis(@NonNull Rule relation) {
		return (RelationAnalysis) super.getRuleAnalysis(relation);
	}

	@Override
	public @NonNull TypedModel getTargetTypedModel() {
		return qvtuConfiguration.getTargetTypedModel();
	}

	@Override
	public @NonNull RelationalTransformationAnalysis getTransformationAnalysis(@NonNull Transformation transformation) {
		return (RelationalTransformationAnalysis) super.getTransformationAnalysis(transformation);
	}

	@Override
	public @NonNull Transformation2TracePackage getTransformation2TracePackage(@NonNull Transformation transformation) {
		return multipleScheduleManager.getTransformation2TracePackage(transformation);
	}

	@Override
	public boolean isInput(@NonNull Domain domain) {
		TypedModel typedModel = domain.getTypedModel();
		return (typedModel != null) && qvtuConfiguration.isInput(typedModel);
	}

	@Override
	public boolean isInput(@NonNull TypedModel typedModel) {
		return qvtuConfiguration.isInput(typedModel);
	}

	@Override
	public boolean isOutput(@NonNull Domain domain) {
		TypedModel typedModel = domain.getTypedModel();
		return (typedModel != null) && qvtuConfiguration.isOutput(typedModel);
	}

	@Override
	public boolean isOutput(@NonNull TypedModel typedModel) {
		return qvtuConfiguration.isOutput(typedModel);
	}

	@Override
	public boolean needsDiscrimination() {
		return multipleScheduleManager.needsDiscrimination();
	}

	@Override
	public boolean useActivators() {
		return multipleScheduleManager.useActivators();
	}
}