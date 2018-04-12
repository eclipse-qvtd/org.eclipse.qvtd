/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
public class RelationAnalysis2InvocationClass extends AbstractRelationAnalysis2MiddleType
{
	public RelationAnalysis2InvocationClass(@NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup, @NonNull String middleClassName) {
		super(relationAnalysis2traceGroup, middleClassName);
	}

	@Override
	public void analyzeTraceElements(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups) throws CompilerChainException {
		//
		// If there is an invocation interface, then it is a superclass
		//
		RelationAnalysis2TraceGroup baseRelationAnalysis2TraceGroup = relationAnalysis2traceGroup.getBaseRelationAnalysis2TraceGroup();
		RelationAnalysis2DispatchClass baseRelationAnalysis2invocationInterface = baseRelationAnalysis2TraceGroup.basicGetRuleAnalysis2InvocationInterface();
		if (baseRelationAnalysis2invocationInterface != null) {
			middleClass.getSuperClasses().add(baseRelationAnalysis2invocationInterface.getMiddleClass());
		}
		//		else {
		//FIXME			middleClass.getSuperClasses().add(getTransformation2TracePackage().getAbstractTraceClass());
		//		}
		// No success property.
		//
		// If there is no invocation interface for a when invoked realtion there is an invocation class result
		//
		if ((baseRelationAnalysis2invocationInterface == null) && getRuleAnalysis().hasIncomingWhenInvocationAnalyses()) {
			createRelation2ResultProperty(relationAnalysis2traceGroup.getNameGenerator().createDispatchClassResultPropertyName());
		}
		//
		//	If there is no invocation interface, one trace property per root variable.
		//
		if (baseRelationAnalysis2invocationInterface == null) {
			analyzeRootTemplateVariables(headNodeGroups);
		}
	}

	@Override
	public @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = super.basicGetVariableDeclaration2TraceProperty(variable);
		if (variableDeclaration2TraceProperty != null) {
			return variableDeclaration2TraceProperty;
		}
		//		RelationAnalysis2MiddleType superRuleAnalysis2MiddleType = getSuperRuleAnalysis2MiddleType();
		//		if (superRuleAnalysis2MiddleType != null) {
		//			return superRuleAnalysis2MiddleType.basicGetVariableDeclaration2TraceProperty(variable);
		//		}
		return null;
	}

	/*	@Override
	public @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = super.basicGetVariableDeclaration2TraceProperty(variable);
		if (variableDeclaration2TraceProperty != null) {
			return variableDeclaration2TraceProperty;
		}
		variableDeclaration2TraceProperty = relationAnalysis2traceGroup.getRuleAnalysis2InvocationInterface().basicGetVariableDeclaration2TraceProperty(variable);
		if (variableDeclaration2TraceProperty != null) {
			return variableDeclaration2TraceProperty;
		}
		Rule overriddenRule = QVTbaseUtil.basicGetOverridden(rule);
		if (overriddenRule == null) {
			return null;
		}
		Domain rootVariableDomain = scheduleManager.getRootVariableDomain(variable);
		List<@NonNull VariableDeclaration> rootVariables = scheduleManager.getRootVariables(rootVariableDomain);
		int rootVariableIndex = rootVariables.indexOf(variable);
		if (rootVariableIndex < 0) {
			return null;
		}
		Domain overriddenDomain = QVTbaseUtil.getDomain(overriddenRule, QVTbaseUtil.getTypedModel(rootVariableDomain));
		List<@NonNull VariableDeclaration> overriddenRootVariables = scheduleManager.getRootVariables(overriddenDomain);
		if (rootVariableIndex >= overriddenRootVariables.size()) {
			return null;
		}
		VariableDeclaration overriddenVariable = overriddenRootVariables.get(rootVariableIndex);
		RuleAnalysis2TraceGroup overriddenRuleAnalysis2TraceClasses = transformationAnalysis2tracePackage.getRuleAnalysis2TraceGroup(overriddenRule);
		RuleAnalysis2MiddleType overriddenRuleAnalysis2InvocationClass = overriddenRuleAnalysis2TraceClasses.getRuleAnalysis2InvocationClass();
		return overriddenRuleAnalysis2InvocationClass.basicGetVariableDeclaration2TraceProperty(overriddenVariable);
	} */

	@Override
	protected @NonNull String createTracePropertyName(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable) {
		return getTransformation2TracePackage().getNameGenerator().createInvocationClassPropertyName(typedModel, variable);
	}

	/*	@Override
	public @Nullable RelationAnalysis2MiddleType getSuperRuleAnalysis2MiddleType() {
		throw new UnsupportedOperationException();
		/*		RelationAnalysis2InvocationInterface ruleAnalysis2InvocationInterface = relationAnalysis2traceGroup.basicGetRuleAnalysis2InvocationInterface();
		if (ruleAnalysis2InvocationInterface != null) {
			return ruleAnalysis2InvocationInterface;
		}
		else {
			Rule overriddenRule = getRule().getOverridden();
			if (overriddenRule != null) {
				return transformationAnalysis2tracePackage.getRuleAnalysis2TraceGroup(overriddenRule).getRuleAnalysis2InvocationClass();
			}
			else {
				return null;
			}
		} * /
	} */

	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		throw new IllegalStateException();
	}

	/*	@Override
	public void synthesize() {
		middleClass.getSuperClasses().add(relationAnalysis2traceGroup.getRuleAnalysis2InvocationInterface().getMiddleClass());
		super.synthesize();
	} */
}