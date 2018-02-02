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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;

/**
 * A TopOverrideRelation2TraceClass represents the mapping between a top level QVTr Relation with overrides
 * and the trace class/interface for a QVTc Mapping.
 */
class TopOverrideRuleAnalysis2TraceClass extends AbstractRuleAnalysis2TraceClass
{
	protected final @NonNull RuleAnalysis2TraceInterface relation2traceInterface;

	private @Nullable RuleAnalysis2TraceClass baseRelation2TraceClass;

	protected TopOverrideRuleAnalysis2TraceClass(@NonNull RuleAnalysis ruleAnalysis) {
		super(ruleAnalysis, ruleAnalysis.getNameGenerator().createTraceClassName(ruleAnalysis.getRule()));
		assert QVTbaseUtil.hasOverrides(rule);
		assert scheduleManager.isTopLevel(rule);
		relation2traceInterface = new RuleAnalysis2TraceInterface(this);
		if (rule.getOverridden() == null) {
			relation2traceInterface.getStatusProperty();
		}
		else {
			reservePropertyName(QVTrNameGenerator.TRACECLASS_STATUS_PROPERTY_NAME);
		}
	}

	@Override
	public void analyze() throws CompilerChainException {
		/*		Relation2TraceClass baseRelation2TraceClass2 = getBaseRelation2TraceClass();
		if (baseRelation2TraceClass2 != this) {
			Relation2MiddleType baseRelation2TraceInterface = baseRelation2TraceClass2.getRelation2TraceInterface();
			for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
				Property traceProperty = baseRelation2TraceInterface.getTraceProperty(rootVariable);
			}
		} */
		super.analyze();
	}

	@Override
	protected @Nullable Property basicGetRelation2StatusProperty() {
		Property property = super.basicGetRelation2StatusProperty();
		if (property != null) {
			return property;
		}
		return relation2traceInterface.basicGetRelation2StatusProperty();
	}

	@Override
	protected @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = super.basicGetVariableDeclaration2TraceProperty(variable);
		if (variableDeclaration2TraceProperty != null) {
			return variableDeclaration2TraceProperty;
		}
		return relation2traceInterface.basicGetVariableDeclaration2TraceProperty(variable);
	}

	@Override
	public void createRootVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull Variable rVariable, boolean manyTraces) {
		RuleAnalysis2TraceClass baseRelation2TraceClass2 = getBaseRelation2TraceClass();
		if (baseRelation2TraceClass2 == this) {
			RuleAnalysis2MiddleType baseRelation2TraceInterface = baseRelation2TraceClass2.getRelation2TraceInterface();
			baseRelation2TraceInterface.createRootVariableDeclaration2TraceProperty(rTypedModel, rVariable, manyTraces);
		}
	}


	protected @NonNull RuleAnalysis2TraceClass getBaseRelation2TraceClass() {
		RuleAnalysis2TraceClass baseRelation2TraceClass2 = baseRelation2TraceClass;
		if (baseRelation2TraceClass2 == null) {
			if (rule.getOverridden() == null) {
				baseRelation2TraceClass2 = this;
			}
			else {
				baseRelation2TraceClass2 = transformationAnalysis2tracePackage.getRuleAnalysis2TraceClass(QVTbaseUtil.getBaseRule(rule));
			}
			this.baseRelation2TraceClass = baseRelation2TraceClass2;

		}
		return baseRelation2TraceClass2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getInvocationClass() {
		return middleClass;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getInvocationInterface() {
		return relation2traceInterface.getMiddleClass();
	}

	@Override
	public @NonNull RuleAnalysis2MiddleType getRelation2InvocationClass() {
		return this;
	}

	@Override
	public @NonNull RuleAnalysis2MiddleType getRule2InvocationInterface() {
		return this;
	}

	@Override
	public @NonNull RuleAnalysis2MiddleType getRelation2TraceInterface() {
		return relation2traceInterface;
	}

	@Override
	public @NonNull Property getStatusInterfaceProperty() {
		RuleAnalysis2TraceClass baseRelation2TraceClass2 = getBaseRelation2TraceClass();
		if (baseRelation2TraceClass2 == this) {
			return ClassUtil.nonNullState(relation2traceInterface.basicGetRelation2StatusProperty());
		}
		else {
			return baseRelation2TraceClass2.getStatusInterfaceProperty();
		}
	}

	@Override
	public @NonNull Property getStatusTraceProperty() {
		RuleAnalysis2TraceClass baseRelation2TraceClass2 = getBaseRelation2TraceClass();
		if (baseRelation2TraceClass2 == this) {
			return ClassUtil.nonNullState(basicGetRelation2StatusProperty());
		}
		else {
			return baseRelation2TraceClass2.getStatusInterfaceProperty();
		}
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass() {
		return middleClass;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getTraceInterface() {
		return relation2traceInterface.getMiddleClass();
	}

	@Override
	public void synthesize() {
		middleClass.getSuperClasses().add(relation2traceInterface.getMiddleClass());
		super.synthesize();
	}
}