/*******************************************************************************
 * Copyright (c) 2017, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
public class Relation2InvocationClass extends AbstractRelation2MiddleType
{
	public Relation2InvocationClass(@NonNull Relation2TraceGroup relation2traceGroup, @NonNull String middleClassName) {
		super(relation2traceGroup, middleClassName);
	}

	@Override
	public void analyzeTraceElements(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups, @NonNull RuleAnalysis ruleAnalysis) throws CompilerChainException {
		//
		// If there is an invocation interface, then it is a superclass
		//
		Relation2TraceGroup baseRelation2traceGroup = ((RelationAnalysis)ruleAnalysis).getRule2TraceGroup().getBaseRelation2TraceGroup();
		Relation2DispatchClass baseRelation2invocationInterface = baseRelation2traceGroup.basicGetRule2InvocationInterface();
		if (baseRelation2invocationInterface != null) {
			middleClass.getSuperClasses().add(baseRelation2invocationInterface.getMiddleClass());
		}
		//		else {
		//FIXME			middleClass.getSuperClasses().add(getTransformation2TracePackage().getAbstractTraceClass());
		//		}
		// No success property.
		//
		// If there is no invocation interface for a when invoked realtion there is an invocation class result
		//
		if ((baseRelation2invocationInterface == null) && ((RelationAnalysis)ruleAnalysis).hasIncomingWhenInvocationAnalyses()) {
			createRelation2ResultProperty(relation2traceGroup.getNameGenerator().createDispatchClassResultPropertyName());
		}
		//
		//	If there is no invocation interface, one trace property per root variable.
		//
		if (baseRelation2invocationInterface == null) {
			analyzeRootTemplateVariables(headNodeGroups);
		}
	}

	@Override
	public @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = super.basicGetVariableDeclaration2TraceProperty(variable);
		if (variableDeclaration2TraceProperty != null) {
			return variableDeclaration2TraceProperty;
		}
		//		Relation2MiddleType superRule2MiddleType = getSuperRule2MiddleType();
		//		if (superRule2MiddleType != null) {
		//			return superRule2MiddleType.basicGetVariableDeclaration2TraceProperty(variable);
		//		}
		return null;
	}

	/*	@Override
	public @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = super.basicGetVariableDeclaration2TraceProperty(variable);
		if (variableDeclaration2TraceProperty != null) {
			return variableDeclaration2TraceProperty;
		}
		variableDeclaration2TraceProperty = relation2traceGroup.getRule2InvocationInterface().basicGetVariableDeclaration2TraceProperty(variable);
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
		Rule2TraceGroup overriddenRule2TraceClasses = transformationAnalysis2tracePackage.getRule2TraceGroup(overriddenRule);
		Rule2MiddleType overriddenRule2InvocationClass = overriddenRule2TraceClasses.getRule2InvocationClass();
		return overriddenRule2InvocationClass.basicGetVariableDeclaration2TraceProperty(overriddenVariable);
	} */

	@Override
	protected @NonNull String createTracePropertyName(@Nullable TypedModel typedModel, @NonNull VariableDeclaration variable) {
		return getTransformation2TracePackage().getNameGenerator().createInvocationClassPropertyName(typedModel, variable);
	}

	/*	@Override
	public @Nullable Relation2MiddleType getSuperRule2MiddleType() {
		throw new UnsupportedOperationException();
		/*		Relation2InvocationInterface rule2InvocationInterface = relation2traceGroup.basicGetRule2InvocationInterface();
		if (rule2InvocationInterface != null) {
			return rule2InvocationInterface;
		}
		else {
			Rule overriddenRule = getRule().getOverridden();
			if (overriddenRule != null) {
				return transformationAnalysis2tracePackage.getRule2TraceGroup(overriddenRule).getRule2InvocationClass();
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
		middleClass.getSuperClasses().add(relation2traceGroup.getRule2InvocationInterface().getMiddleClass());
		super.synthesize();
	} */
}