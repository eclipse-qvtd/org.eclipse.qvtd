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
package org.eclipse.qvtd.compiler.internal.qvts2trace;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
public class RuleAnalysis2InvocationClass extends AbstractRuleAnalysis2MiddleType
{
	protected final @NonNull AbstractRuleAnalysis2TraceClass relation2traceClass;
	protected final @NonNull RuleAnalysis2InvocationInterface relation2invocationInterface;

	protected RuleAnalysis2InvocationClass(@NonNull AbstractRuleAnalysis2TraceClass relation2traceClass) {
		super(relation2traceClass.getRuleAnalysis(), relation2traceClass.createInvocationClassName());
		this.relation2traceClass = relation2traceClass;
		relation2invocationInterface = new RuleAnalysis2InvocationInterface(relation2traceClass);
	}

	@Override
	public void analyze() throws CompilerChainException {}

	@Override
	protected @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = super.basicGetVariableDeclaration2TraceProperty(variable);
		if (variableDeclaration2TraceProperty != null) {
			return variableDeclaration2TraceProperty;
		}
		variableDeclaration2TraceProperty = relation2invocationInterface.basicGetVariableDeclaration2TraceProperty(variable);
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
		AbstractRuleAnalysis2MiddleType overriddenRelation2InvocationClass = (AbstractRuleAnalysis2MiddleType)transformationAnalysis2tracePackage.getRuleAnalysis2TraceClass(overriddenRule).getRelation2InvocationClass();
		return overriddenRelation2InvocationClass.basicGetVariableDeclaration2TraceProperty(overriddenVariable);
	}

	public org.eclipse.ocl.pivot.@NonNull Class getInvocationInterface() {
		return ClassUtil.nonNullState(relation2invocationInterface).getMiddleClass();
	}

	public @NonNull RuleAnalysis2MiddleType getRelation2InvocationInterface() {
		return relation2invocationInterface;
	}

	@Override
	public @NonNull AbstractRuleAnalysis2TraceClass getRuleAnalysis2TraceClass() {
		return relation2traceClass;
	}

	//	public @NonNull Property getResultProperty() {
	//		return relation2invocationInterface.getResultProperty();
	//	}

	@Override
	public void synthesize() {
		middleClass.getSuperClasses().add(relation2invocationInterface.getMiddleClass());
		super.synthesize();
	}
}