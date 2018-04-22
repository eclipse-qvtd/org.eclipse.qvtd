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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
public class Relation2InvocationInterface extends AbstractRelation2MiddleType
{
	protected final @NonNull AbstractRelation2TraceClass relation2traceClass;

	/**
	 * The Property that provides the result state of the traced mapping.
	 */
	private @Nullable Relation2ResultProperty relation2resultProperty = null;

	protected Relation2InvocationInterface(@NonNull AbstractRelation2TraceClass relation2traceClass) {
		super(relation2traceClass.getRelationAnalysis(), relation2traceClass.createInvocationInterfaceName());
		this.relation2traceClass = relation2traceClass;
		if (relation.isIsAbstract()) {
			middleClass.setIsAbstract(true);
		}
		if (relation.getOverridden() == null) {
			getResultProperty();
		}
		//		else {
		//			reservePropertyName(QVTrNameGenerator.INVOCATIONCLASS_RESULT_PROPERTY_NAME);
		//		}
	}

	@Override
	public void analyze() throws CompilerChainException {
		if (QVTrelationUtil.basicGetOverridden(relation) == null) {
			analyzeRootTemplateVariables(false);
		}
	}

	@Override
	protected @Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable) {
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
		AbstractRelation2MiddleType overriddenRelation2InvocationInterface = (AbstractRelation2MiddleType)relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation).getRelation2InvocationInterface();
		return overriddenRelation2InvocationInterface.basicGetVariableDeclaration2TraceProperty(overriddenVariable);
	}

	@Override
	public @NonNull AbstractRelation2TraceClass getRelation2TraceClass() {
		return relation2traceClass;
	}

	public @NonNull Property getResultProperty() {
		Relation overriddenRelation = QVTrelationUtil.basicGetOverridden(relation);
		if (overriddenRelation != null) {
			Relation2InvocationInterface overriddenRelation2InvocationClass = (Relation2InvocationInterface)relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation).getRelation2InvocationInterface();
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
		Relation overriddenRelation = QVTrelationUtil.basicGetOverridden(relation);
		if (overriddenRelation != null) {
			Relation2TraceClass overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation);
			middleClass.getSuperClasses().add(overriddenRelation2TraceClass.getInvocationInterface());
		}
		super.synthesize();
	}
}