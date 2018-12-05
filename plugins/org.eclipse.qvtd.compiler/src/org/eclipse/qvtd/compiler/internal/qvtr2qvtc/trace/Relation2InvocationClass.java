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
package org.eclipse.qvtd.compiler.internal.qvtr2qvtc.trace;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
public class Relation2InvocationClass extends AbstractRelation2MiddleType
{
	protected final @NonNull AbstractRelation2TraceClass relation2traceClass;
	protected final @NonNull Relation2InvocationInterface relation2invocationInterface;

	protected Relation2InvocationClass(@NonNull AbstractRelation2TraceClass relation2traceClass) {
		super(relation2traceClass.getRelationAnalysis(), relation2traceClass.createInvocationClassName());
		this.relation2traceClass = relation2traceClass;
		relation2invocationInterface = new Relation2InvocationInterface(relation2traceClass);
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
		Relation overriddenRelation = QVTrelationUtil.basicGetOverridden(relation);
		if (overriddenRelation == null) {
			return null;
		}
		RelationDomain rootVariableDomain = QVTrelationUtil.getRootVariableDomain(variable);
		List<@NonNull Variable> rootVariables = QVTrelationUtil.getRootVariables(rootVariableDomain);
		int rootVariableIndex = rootVariables.indexOf(variable);
		if (rootVariableIndex < 0) {
			return null;
		}
		RelationDomain overriddenRelationDomain = QVTrelationUtil.getRelationDomain(overriddenRelation, QVTrelationUtil.getTypedModel(rootVariableDomain));
		List<@NonNull Variable> overriddenRootVariables = QVTrelationUtil.getRootVariables(overriddenRelationDomain);
		if (rootVariableIndex >= overriddenRootVariables.size()) {
			return null;
		}
		VariableDeclaration overriddenVariable = overriddenRootVariables.get(rootVariableIndex);
		AbstractRelation2MiddleType overriddenRelation2InvocationClass = (AbstractRelation2MiddleType)relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation).getRelation2InvocationClass();
		return overriddenRelation2InvocationClass.basicGetVariableDeclaration2TraceProperty(overriddenVariable);
	}

	public org.eclipse.ocl.pivot.@NonNull Class getInvocationInterface() {
		return ClassUtil.nonNullState(relation2invocationInterface).getMiddleClass();
	}

	public @NonNull Relation2MiddleType getRelation2InvocationInterface() {
		return relation2invocationInterface;
	}

	@Override
	public @NonNull AbstractRelation2TraceClass getRelation2TraceClass() {
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