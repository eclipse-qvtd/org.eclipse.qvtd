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

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.IteratorVariable;
import org.eclipse.ocl.pivot.LetVariable;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
class Relation2TraceInterface extends AbstractRelation2MiddleType
{
	protected final @NonNull AbstractRelation2TraceClass relation2traceClass;

	protected Relation2TraceInterface(@NonNull AbstractRelation2TraceClass relation2traceClass) {
		super(relation2traceClass.getRelationAnalysis(), relation2traceClass.createTraceInterfaceName());
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
		AbstractRelation2MiddleType overriddenRelation2TraceInterface = (AbstractRelation2MiddleType)relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation).getRelation2TraceInterface();
		return overriddenRelation2TraceInterface.basicGetVariableDeclaration2TraceProperty(overriddenVariable);
	}

	@Override
	public @NonNull AbstractRelation2TraceClass getRelation2TraceClass() {
		return relation2traceClass;
	}

	@Override
	public void synthesize() {
		Relation overriddenRelation = QVTrelationUtil.basicGetOverridden(relation);
		if (overriddenRelation != null) {
			Relation2TraceClass overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation);
			middleClass.getSuperClasses().add(overriddenRelation2TraceClass.getTraceInterface());
		}
		super.synthesize();
	}
}