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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RuleAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * A Relation2MiddleType supports the future invocation/trace class/interface for a Relation
 * realized by a QVTc Mapping
 */
public interface RuleAnalysis2MiddleType extends Nameable, Comparable<@NonNull RuleAnalysis2MiddleType>
{
	void analyze() throws CompilerChainException;
	@Nullable Property basicGetTraceProperty(@NonNull VariableDeclaration rVariable);
	void createRootVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull Variable rVariable, boolean manyTraces);
	org.eclipse.ocl.pivot.@NonNull Class getBagOfMiddleClass();
	org.eclipse.ocl.pivot.@NonNull Class getMiddleClass();
	@NonNull Rule getRule();
	@NonNull AbstractRuleAnalysis2TraceClass getRuleAnalysis2TraceClass();
	@NonNull RuleAnalysis getRuleAnalysis();
	@NonNull TransformationAnalysis2TracePackage getRelationalTransformation2TracePackage();
	@NonNull Property getTraceProperty(@NonNull VariableDeclaration rVariable);
	@NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty variableDeclaration2middleProperty, @NonNull String name);
	@NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@NonNull VariableDeclaration rVariable);
	void synthesize();
}