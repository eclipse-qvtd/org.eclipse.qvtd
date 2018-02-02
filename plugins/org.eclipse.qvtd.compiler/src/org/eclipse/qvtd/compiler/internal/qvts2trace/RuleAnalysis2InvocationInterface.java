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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
public class RuleAnalysis2InvocationInterface extends AbstractRuleAnalysis2MiddleType
{
	protected final @NonNull AbstractRuleAnalysis2TraceClass relation2traceClass;

	/**
	 * The Property that provides the result state of the traced mapping.
	 */
	private @Nullable Relation2ResultProperty relation2resultProperty = null;

	protected RuleAnalysis2InvocationInterface(@NonNull AbstractRuleAnalysis2TraceClass relation2traceClass) {
		super(relation2traceClass.getRuleAnalysis(), relation2traceClass.createInvocationInterfaceName());
		this.relation2traceClass = relation2traceClass;
		if (rule.isIsAbstract()) {
			middleClass.setIsAbstract(true);
		}
		if (rule.getOverridden() == null) {
			getResultProperty();
		}
		//		else {
		//			reservePropertyName(QVTrNameGenerator.INVOCATIONCLASS_RESULT_PROPERTY_NAME);
		//		}
	}

	@Override
	public void analyze() throws CompilerChainException {
		if (QVTbaseUtil.basicGetOverridden(rule) == null) {
			analyzeRootTemplateVariables(false);
		}
	}

	@Override
	protected @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
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
		AbstractRuleAnalysis2MiddleType overriddenRelation2InvocationInterface = (AbstractRuleAnalysis2MiddleType)transformationAnalysis2tracePackage.getRuleAnalysis2TraceClass(overriddenRule).getRule2InvocationInterface();
		return overriddenRelation2InvocationInterface.basicGetVariableDeclaration2TraceProperty(overriddenVariable);
	}

	@Override
	public @NonNull AbstractRuleAnalysis2TraceClass getRuleAnalysis2TraceClass() {
		return relation2traceClass;
	}

	public @NonNull Property getResultProperty() {
		Rule overriddenRule = QVTbaseUtil.basicGetOverridden(rule);
		if (overriddenRule != null) {
			RuleAnalysis2InvocationInterface overriddenRelation2InvocationClass = (RuleAnalysis2InvocationInterface)transformationAnalysis2tracePackage.getRuleAnalysis2TraceClass(overriddenRule).getRule2InvocationInterface();
			return overriddenRelation2InvocationClass.getResultProperty();
		}
		Relation2ResultProperty relation2resultProperty2 = relation2resultProperty;
		if (relation2resultProperty2 == null) {
			relation2resultProperty = relation2resultProperty2 = new Relation2ResultProperty(this, relation2traceClass.getTraceInterface());
			relation2resultProperty2.getTraceProperty();
			//			getRelation2TraceClass().createProperty(QVTrNameGenerator.TRACECLASS_INVOCATION_STATUS_PROPERTY_NAME, booleanType);
			//			statusProperty2.setIsRequired(false);
			//			middleClass.getOwnedProperties().add(statusProperty2);
		}
		return relation2resultProperty2.getTraceProperty();
	}

	@Override
	public void synthesize() {
		Rule overriddenRule = QVTbaseUtil.basicGetOverridden(rule);
		if (overriddenRule != null) {
			RuleAnalysis2TraceClass overriddenRelation2TraceClass = transformationAnalysis2tracePackage.getRuleAnalysis2TraceClass(overriddenRule);
			middleClass.getSuperClasses().add(overriddenRelation2TraceClass.getInvocationInterface());
		}
		super.synthesize();
	}
}