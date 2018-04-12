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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * An AbstractRelation2MiddleType represents the mapping between a QVTr Relation and the trace class for an invoked QVTc Mapping.
 * Derived classes adjust the behaviour for a directly invoked relation or a dispatch of a set of overrides.
 */
abstract class AbstractRelation2MiddleType implements Relation2MiddleType
{
	protected final @NonNull RelationAnalysis relationAnalysis;

	protected final @NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage;

	/**
	 * The relation to be mapped to a trace class and mapping.
	 */
	protected final @NonNull Relation relation;

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
	private @Nullable Relation2SuccessProperty relation2successProperty = null;

	protected AbstractRelation2MiddleType(@NonNull RelationAnalysis relationAnalysis, @NonNull String middleClassName) {
		this.relationAnalysis = relationAnalysis;
		this.relationalTransformation2tracePackage = relationAnalysis.getRelationalTransformation2TracePackage();
		this.relation = relationAnalysis.getRelation();
		this.middleClass = relationalTransformation2tracePackage.createClass(this, middleClassName);
	}

	protected void analyzeRootTemplateVariables(boolean manyTraces) {
		//
		//	Prepare a trace property for each root variable.
		//
		for (@NonNull RelationDomain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			TypedModel rTypedModel = rDomain.getTypedModel();
			for (@NonNull DomainPattern rDomainPattern : QVTrelationUtil.getOwnedPatterns(rDomain)) {
				TemplateExp rTemplateExp = QVTrelationUtil.getOwnedTemplateExpression(rDomainPattern);
				Variable bindsTo = QVTrelationUtil.getBindsTo(rTemplateExp);
				createRootVariableDeclaration2TraceProperty(rTypedModel, bindsTo, manyTraces);
			}
		}
		//		if (!relation.isIsTopLevel()) {
		//			getRelation2TraceProperty();
		//		}
	}

	protected @Nullable Property basicGetRelation2SuccessProperty() {
		return relation2successProperty != null ? relation2successProperty.getTraceProperty() : null;
	}

	@Override
	public @Nullable Property basicGetTraceProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = basicGetVariableDeclaration2TraceProperty(rVariable);
		if (variableDeclaration2traceProperty == null) {
			Relation2MiddleType relation2TraceInterface = getRelation2TraceInterface();
			if (relation2TraceInterface != this) {
				variableDeclaration2traceProperty = ((AbstractRelation2MiddleType)relation2TraceInterface).basicGetVariableDeclaration2TraceProperty(rVariable);
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
	public int compareTo(@NonNull Relation2MiddleType that) {
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
			bagOfMiddleClass = bagOfMiddleClass2 = relationalTransformation2tracePackage.getBagType(middleClass);
		}
		return bagOfMiddleClass2;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getMiddleClass() {
		return middleClass;
	}

	@Override
	public @NonNull String getName() {
		return QVTrelationUtil.getName(relation);
	}

	@Override
	public @NonNull Relation getRelation() {
		return relation;
	}

	public @NonNull Relation2MiddleType getRelation2TraceInterface() {
		return this;
	}

	@Override
	public @NonNull RelationAnalysis getRelationAnalysis() {
		return relationAnalysis;
	}

	@Override
	public @NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage() {
		return relationalTransformation2tracePackage;
	}

	public @NonNull Relation2SuccessProperty getSuccessProperty() {
		Relation2SuccessProperty successProperty2 = relation2successProperty;
		if (successProperty2 == null) {
			relation2successProperty = successProperty2 = new Relation2SuccessProperty(this);
			successProperty2.getTraceProperty();
			//			getRelation2TraceClass().createProperty(QVTrNameGenerator.TRACECLASS_INVOCATION_STATUS_PROPERTY_NAME, booleanType);
			//			successProperty2.setIsRequired(false);
			//			middleClass.getOwnedProperties().add(successProperty2);
		}
		return successProperty2;
	}

	@Override
	public @NonNull Property getTraceProperty(@NonNull VariableDeclaration rVariable) {
		VariableDeclaration2TraceProperty variableDeclaration2traceProperty = getVariableDeclaration2TraceProperty(rVariable);
		return variableDeclaration2traceProperty.getTraceProperty();
	}

	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		return getRelation2TraceClass().getUniquePropertyName(element2traceProperty, name);
	}

	//	public @NonNull Iterable<@NonNull VariableDeclaration2TraceProperty> getVariableDeclaration2TraceProperties() {
	//		return variable2variableDeclaration2traceProperty.values();
	//	}

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
			variableDeclaration2traceProperty.synthesize();
		}
		CompilerUtil.normalizeNameables(QVTrelationUtil.Internal.getOwnedPropertiesList(middleClass));
	}

	@Override
	public String toString() {
		return middleClass.getName();
	}
}