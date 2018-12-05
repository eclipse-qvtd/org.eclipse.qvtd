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
package org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace;

import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.VariableDeclaration2TraceProperty;
import org.eclipse.qvtd.pivot.qvtbase.Rule;

/**
 * A Relation2MiddleType supports the future invocation/trace class/interface for a Relation
 * realized by a QVTc Mapping
 */
public interface RuleAnalysis2MiddleType extends Nameable, Comparable<@NonNull RuleAnalysis2MiddleType>
{
	void analyzeTraceElements(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups) throws CompilerChainException;
	@Nullable Property basicGetTraceProperty(@NonNull VariableDeclaration rVariable);
	//	@Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable);
	//	void createRootVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration rVariable, boolean manyTraces);
	org.eclipse.ocl.pivot.@NonNull Class getBagOfMiddleClass();
	@NonNull Property getGlobalSuccessProperty();
	org.eclipse.ocl.pivot.@NonNull Class getMiddleClass();

	@Override
	@NonNull String getName();

	@NonNull Property getResultProperty();
	@NonNull Rule getRule();
	@NonNull RuleAnalysis2TraceGroup getRuleAnalysis2TraceGroup();
	@NonNull RuleAnalysis getRuleAnalysis();
	@NonNull TransformationAnalysis2TracePackage getTransformation2TracePackage();
	@NonNull Property getTraceProperty(@NonNull VariableDeclaration rVariable);
	@NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty variableDeclaration2middleProperty, @NonNull String name);
	@NonNull VariableDeclaration2TraceProperty getVariableDeclaration2TraceProperty(@NonNull VariableDeclaration rVariable);
	void synthesizeTraceModel();
}