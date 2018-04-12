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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A NonTopOverrideRelation2TraceClass represents the mapping between a non-top level QVTr Relation with overrides
 * and the invocation/trace class/interface for a QVTc Mapping.
 */
class NonTopOverrideRelation2TraceClass extends AbstractRelation2TraceClass
{
	protected final @NonNull Relation2TraceInterface relation2traceInterface;
	protected final @NonNull Relation2InvocationClass relation2invocationClass;

	protected NonTopOverrideRelation2TraceClass(@NonNull RelationAnalysis relationAnalysis) {
		super(relationAnalysis, relationAnalysis.getNameGenerator().createTraceClassName(relationAnalysis.getRelation()));
		assert QVTrelationUtil.hasOverrides(relation);
		assert !relation.isIsTopLevel();
		relation2traceInterface = new Relation2TraceInterface(this);
		relation2invocationClass = new Relation2InvocationClass(this);
		if (relation.getOverridden() == null) {
			relation2traceInterface.getSuccessProperty();
			//			relation2invocationClass.getResultProperty();
		}
		else {
			reservePropertyName(QVTrNameGenerator.TRACECLASS_STATUS_PROPERTY_NAME);
			//			reservePropertyName(QVTrNameGenerator.INVOCATIONCLASS_RESULT_PROPERTY_NAME);
		}
	}

	@Override
	protected @Nullable Property basicGetRelation2SuccessProperty() {
		Property property = super.basicGetRelation2SuccessProperty();
		if (property != null) {
			return property;
		}
		return relation2traceInterface.basicGetRelation2SuccessProperty();
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
	public org.eclipse.ocl.pivot.@NonNull Class getInvocationClass() {
		return relation2invocationClass.getMiddleClass();
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getInvocationInterface() {
		return relation2invocationClass.getInvocationInterface();
	}

	@Override
	public @NonNull Relation2MiddleType getRelation2InvocationClass() {
		return relation2invocationClass;
	}

	@Override
	public @NonNull Relation2MiddleType getRelation2InvocationInterface() {
		return relation2invocationClass.getRelation2InvocationInterface();
	}

	@Override
	public @NonNull Relation2MiddleType getRelation2TraceInterface() {
		return relation2traceInterface;
	}

	@Override
	public @NonNull Property getStatusInterfaceProperty() {
		Relation2TraceClass baseRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(QVTrelationUtil.getBaseRelation(relation));
		if (baseRelation2TraceClass == this) {
			return ClassUtil.nonNullState(relation2traceInterface.basicGetRelation2SuccessProperty());
		}
		else {
			return baseRelation2TraceClass.getStatusInterfaceProperty();
		}
	}

	@Override
	public @NonNull Property getStatusTraceProperty() {
		Relation2TraceClass baseRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(QVTrelationUtil.getBaseRelation(relation));
		if (baseRelation2TraceClass == this) {
			return ClassUtil.nonNullState(basicGetRelation2SuccessProperty());
		}
		else {
			return baseRelation2TraceClass.getStatusInterfaceProperty();
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
		Relation2TraceInterface relation2traceInterface2 = relation2traceInterface;
		middleClass.getSuperClasses().add(relation2traceInterface2.getMiddleClass());
		super.synthesize();
	}
}