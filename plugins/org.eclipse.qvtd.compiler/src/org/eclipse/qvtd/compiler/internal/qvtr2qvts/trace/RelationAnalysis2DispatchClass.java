/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
public class RelationAnalysis2DispatchClass extends AbstractRelationAnalysis2MiddleType
{
	private @NonNull Map<@NonNull Relation, @NonNull DispatchClass2TraceProperty> relation2dispatchClass2traceProperty = new HashMap<>();

	/**
	 * Name to corresponding future trace property
	 */
	private final @NonNull Map<@NonNull String, /*@NonNull*/ Element2MiddleProperty> name2element2traceProperty = new HashMap<>();

	public RelationAnalysis2DispatchClass(@NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup, @NonNull String middleClassName) {
		super(relationAnalysis2traceGroup, middleClassName);
		//		if (relation.isIsAbstract()) {
		//			middleClass.setIsAbstract(true);
		//		}
		//		if (relation.getOverridden() == null) {
		//			getResultProperty();
		//		}
		//		else {
		//			reservePropertyName(QVTrNameGenerator.INVOCATIONCLASS_RESULT_PROPERTY_NAME);
		//		}
	}

	/**
	 * Descend the override hierrachy to create a DispatchClass2TraceProperty for each non-abstract relation.
	 */
	protected void analyzeOverrides(@NonNull Relation overriddenRelation) {
		if (!overriddenRelation.isIsAbstract()) {
			RelationAnalysis dispatchedRelationAnalysis = relationAnalysis.getScheduleManager().getRuleAnalysis(overriddenRelation);
			RelationAnalysis2TraceClass dispatchedRelationAnalysis2TraceClass = dispatchedRelationAnalysis.getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceClass();
			String nameHint = relationAnalysis2traceGroup.getNameGenerator().createDispatchClassDispatchPropertyName(overriddenRelation);
			DispatchClass2TraceProperty dispatchClass2traceProperty = new DispatchClass2TraceProperty(this, nameHint, dispatchedRelationAnalysis2TraceClass);
			DispatchClass2TraceProperty oldDispatchClass2TraceProperty = relation2dispatchClass2traceProperty.put(overriddenRelation, dispatchClass2traceProperty);
			assert oldDispatchClass2TraceProperty == null;
		}
		for (@NonNull Relation overridingRelation : QVTrelationUtil.getOverrides(overriddenRelation)) {
			analyzeOverrides(overridingRelation);
		}
	}

	@Override
	public void analyzeTraceElements(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups) throws CompilerChainException {
		//
		//	Dispatch is the superclass.
		//
		org.eclipse.ocl.pivot.Class dispatchClass = transformationAnalysis2tracePackage.getDispatchClass();
		middleClass.getSuperClasses().add(dispatchClass);
		//
		// There is always a trace interface success
		//
		Property globalSuccessProperty = NameUtil.getNameable(QVTbaseUtil.getOwnedProperties(dispatchClass), QVTrelationNameGenerator.TRACE_GLOBAL_SUCCESS_PROPERTY_NAME);
		assert globalSuccessProperty != null;
		createRelation2GlobalSuccessProperty(globalSuccessProperty);
		//
		// If there is no invocation interface for a when invoked realtion there is an invocation class result
		// There is always an invocation interface result
		//
		//		if (getRuleAnalysis().hasIncomingWhenInvocationAnalyses()) {
		createRelation2ResultProperty(relationAnalysis2traceGroup.getNameGenerator().createDispatchClassResultPropertyName());
		//		}
		//
		//	One trace property per root variable.
		//
		analyzeRootTemplateVariables(headNodeGroups);
		//
		//	One trace dispatch property per non-abstract relation in the overrode hierarchy.
		//
		assert relation.getOverridden() == null;
		assert !relation.getOverrides().isEmpty();
		analyzeOverrides(relation);
	}

	/*	@Override
	public @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
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
		RuleAnalysis2TraceGroup overriddenRuleAnalysis2TraceGroup = transformationAnalysis2tracePackage.getRuleAnalysis2TraceGroup(overriddenRule);
		RuleAnalysis2MiddleType overriddenRelation2InvocationInterface = overriddenRuleAnalysis2TraceGroup.getRuleAnalysis2InvocationInterface();
		return overriddenRelation2InvocationInterface.basicGetVariableDeclaration2TraceProperty(overriddenVariable);
	} */

	@Override
	protected @NonNull String createTracePropertyName(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable) {
		return getTransformation2TracePackage().getNameGenerator().createDispatchClassPropertyName(typedModel, variable);
	}

	public @NonNull DispatchClass2TraceProperty getDispatchClass2TraceProperty(@NonNull Relation relation) {
		return ClassUtil.nonNullState(relation2dispatchClass2traceProperty.get(relation));
	}

	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		return QVTrelationNameGenerator.getUniqueName(name2element2traceProperty, name, element2traceProperty);
	}

	@Override
	public void synthesizeTraceModel() {
		super.synthesizeTraceModel();
		//
		//	Create a trace dispatch property for each prepared trace dispatch property.
		//
		for (@NonNull DispatchClass2TraceProperty dispatchClass2traceProperty : relation2dispatchClass2traceProperty.values()) {
			@SuppressWarnings("unused")
			@NonNull Property traceProperty = dispatchClass2traceProperty.synthesizeTraceModel();
		}
	}
}