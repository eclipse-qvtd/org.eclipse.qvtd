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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;

/**
 * An AbstractRelation2MiddleType represents the mapping between a QVTr Relation and the trace class for an invoked QVTc Mapping.
 * Derived classes adjust the behaviour for a directly invoked relation or a dispatch of a set of overrides.
 */
abstract class AbstractRuleAnalysis2MiddleType implements RuleAnalysis2MiddleType
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull RuleAnalysis ruleAnalysis;

	protected final @NonNull TransformationAnalysis2TracePackage transformationAnalysis2tracePackage;

	/**
	 * The relation to be mapped to a trace class and mapping.
	 */
	protected final @NonNull Rule rule;

	/**
	 * The Class that realizes the trace class.
	 */
	protected final org.eclipse.ocl.pivot.@NonNull Class middleClass;
	/**
	 * Lazily created null-free Bag of traceClass.
	 */
	private org.eclipse.ocl.pivot.@Nullable Class bagOfMiddleClass = null;

	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull VariableDeclaration2TraceProperty> variable2variableDeclaration2traceProperty = new HashMap<>();

	/**
	 * The Property that provides the success/failure/not-ready state of the traced mapping.
	 */
	private @Nullable Relation2StatusProperty relation2statusProperty = null;

	protected AbstractRuleAnalysis2MiddleType(@NonNull RuleAnalysis ruleAnalysis, @NonNull String middleClassName) {
		this.scheduleManager = ruleAnalysis.getScheduleManager();
		this.ruleAnalysis = ruleAnalysis;
		this.transformationAnalysis2tracePackage = ruleAnalysis.getTransformationAnalysis2TracePackage();
		this.rule = ruleAnalysis.getRule();
		this.middleClass = transformationAnalysis2tracePackage.createClass(this, middleClassName);
	}

	protected void analyzeRootTemplateVariables(boolean manyTraces) {
		/*		//
		//	Prepare a trace property for each root variable.
		//
		for (@NonNull Domain rDomain : QVTbaseUtil.getOwnedDomains(rule)) {
			TypedModel rTypedModel = rDomain.getTypedModel();
			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rDomain)) {
				TemplateExp rTemplateExp = QVTrelationUtil.getOwnedTemplateExpression(rDomainPattern);
				Variable bindsTo = QVTrelationUtil.getBindsTo(rTemplateExp);
				createRootVariableDeclaration2TraceProperty(rTypedModel, bindsTo, manyTraces);
			}
		}
		//		if (!relation.isIsTopLevel()) {
		//			getRelation2TraceProperty();
		//		} */
	}

	protected @Nullable Property basicGetRelation2StatusProperty() {
		return relation2statusProperty != null ? relation2statusProperty.getTraceProperty() : null;
	}

	@Override
	public @Nullable Property basicGetTraceProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = basicGetVariableDeclaration2TraceProperty(rVariable);
		if (variableDeclaration2traceProperty == null) {
			RuleAnalysis2MiddleType relation2TraceInterface = getRule2TraceInterface();
			if (relation2TraceInterface != this) {
				variableDeclaration2traceProperty = ((AbstractRuleAnalysis2MiddleType)relation2TraceInterface).basicGetVariableDeclaration2TraceProperty(rVariable);
			}
			if (variableDeclaration2traceProperty == null) {
				return null;
			}
		}
		return variableDeclaration2traceProperty.getTraceProperty();
	}

	protected @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		return variable2variableDeclaration2traceProperty.get(variable);
	}

	@Override
	public int compareTo(@NonNull RuleAnalysis2MiddleType that) {
		return ClassUtil.safeCompareTo(this.middleClass.getName(), that.getMiddleClass().getName());
	}

	@Override
	public void createRootVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull Variable rVariable, boolean manyTraces) {
		getVariableDeclaration2TraceProperty(rTypedModel, rVariable, !manyTraces /*&& !QVTrelationUtil.hasOverrides(relation)*/);
	}

	protected @NonNull VariableDeclaration2TraceProperty createVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean isNestedOneToOne) {
		return new VariableDeclaration2TraceProperty(this, rTypedModel, variable, isNestedOneToOne);
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getBagOfMiddleClass() {
		Class bagOfMiddleClass2 = bagOfMiddleClass;
		if (bagOfMiddleClass2 == null) {
			bagOfMiddleClass = bagOfMiddleClass2 = transformationAnalysis2tracePackage.getBagType(middleClass);
		}
		return bagOfMiddleClass2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getMiddleClass() {
		return middleClass;
	}

	@Override
	public @NonNull String getName() {
		return QVTrelationUtil.getName(rule);
	}

	@Override
	public @NonNull Rule getRule() {
		return rule;
	}

	public @NonNull RuleAnalysis2MiddleType getRule2TraceInterface() {
		return this;
	}

	@Override
	public @NonNull RuleAnalysis getRuleAnalysis() {
		return ruleAnalysis;
	}

	@Override
	public @NonNull TransformationAnalysis2TracePackage getRelationalTransformation2TracePackage() {
		return transformationAnalysis2tracePackage;
	}

	public @NonNull Relation2StatusProperty getStatusProperty() {
		Relation2StatusProperty statusProperty2 = relation2statusProperty;
		if (statusProperty2 == null) {
			relation2statusProperty = statusProperty2 = new Relation2StatusProperty(this);
			statusProperty2.getTraceProperty();
			//			getRelation2TraceClass().createProperty(QVTrNameGenerator.TRACECLASS_INVOCATION_STATUS_PROPERTY_NAME, booleanType);
			//			statusProperty2.setIsRequired(false);
			//			middleClass.getOwnedProperties().add(statusProperty2);
		}
		return statusProperty2;
	}

	@Override
	public @NonNull Property getTraceProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = getVariableDeclaration2TraceProperty(rVariable);
		return variableDeclaration2traceProperty.getTraceProperty();
	}

	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		return getRuleAnalysis2TraceClass().getUniquePropertyName(element2traceProperty, name);
	}

	public @NonNull Iterable<@NonNull VariableDeclaration2TraceProperty> getVariableDeclaration2TraceProperties() {
		return variable2variableDeclaration2traceProperty.values();
	}

	protected @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean isNestedOneToOne) {
		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = variable2variableDeclaration2traceProperty.get(variable);
		if (variableDeclaration2traceProperty != null) {
			variableDeclaration2traceProperty.refineProperty(rTypedModel, isNestedOneToOne);
		}
		else {
			variableDeclaration2traceProperty = createVariableDeclaration2TraceProperty(rTypedModel, variable, isNestedOneToOne);
			variable2variableDeclaration2traceProperty.put(variable, variableDeclaration2traceProperty);
		}
		return variableDeclaration2traceProperty;
	}

	@Override
	public @NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = basicGetVariableDeclaration2TraceProperty(variable);
		return ClassUtil.nonNullState(variableDeclaration2TraceProperty);
	}

	@Override
	public void synthesize() {
		//
		//	Create a trace property for each prepared trace property.
		//
		for (@NonNull VariableDeclaration2TraceProperty variableDeclaration2traceProperty : variable2variableDeclaration2traceProperty.values()) {
			@NonNull Property traceProperty = variableDeclaration2traceProperty.synthesize();
		}
		CompilerUtil.normalizeNameables(QVTrelationUtil.Internal.getOwnedPropertiesList(middleClass));
	}

	@Override
	public String toString() {
		return middleClass.getName();
	}
}