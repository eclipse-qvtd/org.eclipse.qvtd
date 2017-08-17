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
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;

/**
 * A NonTopRelation2TraceClass represents the mapping between a non-top level QVTr Relation and the abstract trace class for an invoked QVTc Mapping.
 */
class NonTopRelation2TraceClass extends AbstractRelation2TraceClass
{
	protected final @NonNull Relation2SignatureClass relation2signatureClass;
	protected final @NonNull Relation2TraceProperty relation2traceProperty;

	protected NonTopRelation2TraceClass(@NonNull Relation2SignatureClass relation2signatureClass) {
		super(relation2signatureClass.getRelationAnalysis(), relation2signatureClass.getNameGenerator().createTraceClassName(relation2signatureClass.getRelation()));
		this.relation2signatureClass = relation2signatureClass;
		//			traceClass.setIsAbstract(true);
		Relation baseRelation = QVTrelationUtil.getBaseRelation(relation);
		Relation2SignatureClass baseRelation2SignatureClass = relationalTransformation2tracePackage.getRelation2SignatureClass(baseRelation);
		String inName = nameGenerator.createInPropertyName(baseRelation);
		org.eclipse.ocl.pivot.Class signatureClass = baseRelation2SignatureClass.getMiddleClass();
		this.relation2traceProperty = new Relation2TraceProperty(this, inName, signatureClass, true);
	}

	@Override
	public void analyzeProperties() throws CompilerChainException {
		//		super.analyzeProperties();
		boolean manyTraces = analyzeTraceMultiplicity();
		analyzeSharedVariables();
		//		analyzeRootTemplateVariables(manyTraces); -- root variables are nested in the invocation Relation2TraceProperty
		analyzeNonRootTemplateVariables(manyTraces);
		analyzePredicateVariables();
	}

	//	protected void createRelation2TraceProperty() {
	//		String inName = nameGenerator.createInPropertyName(relation);
	//		Relation2TraceProperty relation2MiddleProperty = new Relation2TraceProperty(this, inName, relation2signatureClass.getMiddleClass(), true);
	//		nameGenerator.getUniqueName(name2element2middleProperty, inName, element2middleProperty);
	//	}

	@Override
	protected @NonNull VariableDeclaration2MiddleProperty createVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration variable, boolean isNestedOneToOne) {
		return new VariableDeclaration2MiddleProperty(this, rTypedModel, variable, isNestedOneToOne);
	}

	@Override
	public @NonNull Element2MiddleProperty getRelation2TraceProperty() {
		return relation2traceProperty;
	}
}