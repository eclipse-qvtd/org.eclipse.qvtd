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
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A TopOverrideRelation2TraceClass represents the mapping between a top level QVTr Relation with overrides
 * and the trace class/interface for a QVTc Mapping.
 */
class TopOverrideRelation2TraceClass extends AbstractRelation2TraceClass
{
	protected final @NonNull Relation2TraceInterface relation2traceInterface;

	private @Nullable Relation2TraceClass baseRelation2TraceClass;

	protected TopOverrideRelation2TraceClass(@NonNull RelationAnalysis relationAnalysis) {
		super(relationAnalysis, relationAnalysis.getNameGenerator().createTraceClassName(relationAnalysis.getRelation()));
		assert QVTrelationUtil.hasOverrides(relation);
		assert relation.isIsTopLevel();
		relation2traceInterface = new Relation2TraceInterface(this);
		if (relation.getOverridden() == null) {
			relation2traceInterface.getSuccessProperty();
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
	public void createRootVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull Variable rVariable, boolean manyTraces) {
		Relation2TraceClass baseRelation2TraceClass2 = getBaseRelation2TraceClass();
		if (baseRelation2TraceClass2 == this) {
			Relation2MiddleType baseRelation2TraceInterface = baseRelation2TraceClass2.getRelation2TraceInterface();
			baseRelation2TraceInterface.createRootVariableDeclaration2TraceProperty(rTypedModel, rVariable, manyTraces);
		}
	}


	protected @NonNull Relation2TraceClass getBaseRelation2TraceClass() {
		Relation2TraceClass baseRelation2TraceClass2 = baseRelation2TraceClass;
		if (baseRelation2TraceClass2 == null) {
			if (relation.getOverridden() == null) {
				baseRelation2TraceClass2 = this;
			}
			else {
				baseRelation2TraceClass2 = relationalTransformation2tracePackage.getRelation2TraceClass(QVTrelationUtil.getBaseRelation(relation));
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
	public @NonNull Relation2MiddleType getRelation2InvocationClass() {
		return this;
	}

	@Override
	public @NonNull Relation2MiddleType getRelation2InvocationInterface() {
		return this;
	}

	@Override
	public @NonNull Relation2MiddleType getRelation2TraceInterface() {
		return relation2traceInterface;
	}

	@Override
	public @NonNull Property getStatusInterfaceProperty() {
		Relation2TraceClass baseRelation2TraceClass2 = getBaseRelation2TraceClass();
		if (baseRelation2TraceClass2 == this) {
			return ClassUtil.nonNullState(relation2traceInterface.basicGetRelation2SuccessProperty());
		}
		else {
			return baseRelation2TraceClass2.getStatusInterfaceProperty();
		}
	}

	@Override
	public @NonNull Property getStatusTraceProperty() {
		Relation2TraceClass baseRelation2TraceClass2 = getBaseRelation2TraceClass();
		if (baseRelation2TraceClass2 == this) {
			return ClassUtil.nonNullState(basicGetRelation2SuccessProperty());
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