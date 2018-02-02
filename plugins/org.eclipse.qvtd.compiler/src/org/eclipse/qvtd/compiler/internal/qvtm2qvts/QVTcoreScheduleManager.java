/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.CompilerOptions;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.MappingAnalysis.QVTcoreExpressionAnalyzer;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtcore.analysis.QVTcoreDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;

public class QVTcoreScheduleManager extends AbstractScheduleManager
{
	public QVTcoreScheduleManager(@NonNull EnvironmentFactory environmentFactory, CompilerOptions.@Nullable StepOptions schedulerOptions) {
		super(QVTscheduleFactory.eINSTANCE.createScheduleModel(), environmentFactory, schedulerOptions);
	}

	@Override
	public void analyzeTransformation(@NonNull TransformationAnalysis transformationAnalysis) {
		TypedModel primitiveTypeModel = domainUsageAnalysis.getPrimitiveTypeModel();
		transformationAnalysis.getTransformation().getModelParameter().add(primitiveTypeModel);
		super.analyzeTransformation(transformationAnalysis);
	}

	@Override
	protected @NonNull DatumCaches createDatumCaches() {
		return new QVTcoreDatumCaches(this);
	}

	@Override
	protected @NonNull RootDomainUsageAnalysis createDomainUsageAnalysis() {
		return new QVTcoreDomainUsageAnalysis(environmentFactory);
	}

	@Override
	public @NonNull ExpressionAnalyzer createExpressionAnalyzer(@NonNull RuleAnalysis ruleAnalysis) {
		return new QVTcoreExpressionAnalyzer(ruleAnalysis);
	}

	@Override
	public @NonNull MappingAnalysis createRuleAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull Rule asRule) {
		RuleRegion ruleRegion = QVTscheduleFactory.eINSTANCE.createRuleRegion();
		ruleRegion.setOwningScheduleModel(scheduleModel);
		ruleRegion.setReferredRule(asRule);
		ruleRegion.setName(asRule.getName());
		return new MappingAnalysis(transformationAnalysis, ruleRegion);
	}

	@Override
	public @NonNull Rule getReferredRule(@NonNull OCLExpression invocation) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Domain getRootVariableDomain(@NonNull VariableDeclaration variable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull List<@NonNull VariableDeclaration> getRootVariables(@NonNull Domain domain) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isInput(@NonNull Domain domain) {
		return domain.isIsCheckable();
	}

	@Override
	public boolean isOutput(@NonNull Domain domain) {
		return domain.isIsEnforceable();
	}

	@Override
	public boolean isTopLevel(@NonNull Rule rule) {
		throw new UnsupportedOperationException();
	}
}