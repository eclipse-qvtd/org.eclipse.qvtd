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
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
class RuleAnalysis2TraceInterface extends AbstractRuleAnalysis2MiddleType
{
	protected final @NonNull AbstractRuleAnalysis2TraceClass relation2traceClass;

	protected RuleAnalysis2TraceInterface(@NonNull AbstractRuleAnalysis2TraceClass relation2traceClass) {
		super(relation2traceClass.getRuleAnalysis(), relation2traceClass.createTraceInterfaceName());
		this.relation2traceClass = relation2traceClass;
		//		if (relation.isIsAbstract()) {
		middleClass.setIsAbstract(true);
		//		}
	}

	@Override
	public void analyze() throws CompilerChainException {}

	@Override
	protected @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		if (variable instanceof IteratorVariable) {
			return null;
		}
		if (variable instanceof LetVariable) {
			return null;
		}
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = super.basicGetVariableDeclaration2TraceProperty(variable);
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
		Domain overriddenRelationDomain = QVTbaseUtil.getDomain(overriddenRule, QVTbaseUtil.getTypedModel(rootVariableDomain));
		List<@NonNull VariableDeclaration> overriddenRootVariables = scheduleManager.getRootVariables(overriddenRelationDomain);
		if (rootVariableIndex >= overriddenRootVariables.size()) {
			return null;
		}
		VariableDeclaration overriddenVariable = overriddenRootVariables.get(rootVariableIndex);
		AbstractRuleAnalysis2MiddleType overriddenRelation2TraceInterface = (AbstractRuleAnalysis2MiddleType)transformationAnalysis2tracePackage.getRuleAnalysis2TraceClass(overriddenRule).getRelation2TraceInterface();
		return overriddenRelation2TraceInterface.basicGetVariableDeclaration2TraceProperty(overriddenVariable);
	}

	@Override
	public @NonNull AbstractRuleAnalysis2TraceClass getRuleAnalysis2TraceClass() {
		return relation2traceClass;
	}

	@Override
	public void synthesize() {
		Rule overriddenRule = QVTbaseUtil.basicGetOverridden(rule);
		if (overriddenRule != null) {
			RuleAnalysis2TraceClass overriddenRelation2TraceClass = transformationAnalysis2tracePackage.getRuleAnalysis2TraceClass(overriddenRule);
			middleClass.getSuperClasses().add(overriddenRelation2TraceClass.getTraceInterface());
		}
		super.synthesize();
	}
}