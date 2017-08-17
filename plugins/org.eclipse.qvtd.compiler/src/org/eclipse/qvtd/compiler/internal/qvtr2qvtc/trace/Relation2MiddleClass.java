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
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.QVTrNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvtc.analysis.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * A Relation2MiddleClass represents the mapping between a Relation and a SignatureClass/TraceClass/Mapping
 */
interface Relation2MiddleClass extends Comparable<@NonNull Relation2MiddleClass>
{
	void analyzeProperties() throws CompilerChainException;
	@Nullable Property basicGetMiddleProperty(@NonNull VariableDeclaration rVariable);
	org.eclipse.ocl.pivot.@NonNull Class getBagOfMiddleClass();
	org.eclipse.ocl.pivot.@NonNull Class getMiddleClass();
	@NonNull Property getMiddleProperty(@NonNull VariableDeclaration rVariable);
	@NonNull QVTrNameGenerator getNameGenerator();
	@NonNull Relation getRelation();
	@NonNull Element2MiddleProperty getRelation2TraceProperty();
	@NonNull RelationAnalysis getRelationAnalysis();
	@NonNull RelationalTransformation2TracePackage getRelationalTransformation2TracePackage();
	@NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty variableDeclaration2middleProperty, @NonNull String name);
	@NonNull VariableDeclaration2MiddleProperty getVariableDeclaration2MiddleProperty(@NonNull VariableDeclaration rVariable);
	org.eclipse.ocl.pivot.@NonNull Class synthesize();
}