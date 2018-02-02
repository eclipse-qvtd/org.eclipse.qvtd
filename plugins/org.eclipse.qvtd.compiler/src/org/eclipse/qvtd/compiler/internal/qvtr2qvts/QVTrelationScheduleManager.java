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

import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.AbstractScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.DatumCaches;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ExpressionAnalyzer;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.QVTrelationDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;

public class QVTrelationScheduleManager extends AbstractScheduleManager
{
	protected final @NonNull QVTuConfiguration qvtuConfiguration;

	protected QVTrelationScheduleManager(@NonNull EnvironmentFactory environmentFactory, @NonNull QVTuConfiguration qvtuConfiguration,
			CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(QVTscheduleFactory.eINSTANCE.createScheduleModel(), environmentFactory, schedulerOptions);
		this.qvtuConfiguration = qvtuConfiguration;
	}

	@Override
	public void analyzeTransformation(@NonNull TransformationAnalysis transformationAnalysis) {
		TypedModel primitiveTypeModel = domainUsageAnalysis.getPrimitiveTypeModel();
		transformationAnalysis.getTransformation().getModelParameter().add(primitiveTypeModel);
		super.analyzeTransformation(transformationAnalysis);
	}

	@Override
	protected @NonNull DatumCaches createDatumCaches() {
		return new QVTrelationDatumCaches(this);
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis() {
		return new QVTrelationDomainUsageAnalysis(environmentFactory);
	}

	@Override
	public @NonNull ExpressionAnalyzer createExpressionAnalyzer(@NonNull RuleAnalysis ruleAnalysis) {
		return new QVTrelationExpressionAnalyzer((RelationAnalysis) ruleAnalysis);
	}

	@Override
	public @NonNull RelationAnalysis createRuleAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Rule asRule) {
		RuleRegion ruleRegion = QVTscheduleFactory.eINSTANCE.createRuleRegion();
		ruleRegion.setOwningScheduleModel(scheduleModel);
		ruleRegion.setReferredRule(asRule);
		ruleRegion.setName(nameGenerator.createMappingName((Relation) asRule, qvtuConfiguration));
		return new RelationAnalysis(transformationAnalysis, qvtuConfiguration, ruleRegion);
	}

	@Override
	public @NonNull QVTrelationDomainUsageAnalysis getDomainUsageAnalysis() {
		return (QVTrelationDomainUsageAnalysis) super.getDomainUsageAnalysis();
	}

	@Override
	protected @NonNull URI getGraphsBaseURI() {
		return getScheduleModel().eResource().getURI().trimSegments(1).appendSegment("graphs").appendSegment("");
	}

	@Override
	public @NonNull Rule getReferredRule(@NonNull OCLExpression invocation) {
		return QVTrelationUtil.getReferredRelation((RelationCallExp) invocation);
	}

	@Override
	public @NonNull Domain getRootVariableDomain(@NonNull VariableDeclaration variable) {
		return QVTrelationUtil.getRootVariableDomain(variable);
	}

	@Override
	public @NonNull List<@NonNull VariableDeclaration> getRootVariables(@NonNull Domain domain) {
		return new ArrayList<>(QVTrelationUtil.getRootVariables((RelationDomain)domain));		// FIXME avoid new list
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
	public boolean isTopLevel(@NonNull Rule rule) {
		return ((Relation)rule).isIsTopLevel();
	}
}