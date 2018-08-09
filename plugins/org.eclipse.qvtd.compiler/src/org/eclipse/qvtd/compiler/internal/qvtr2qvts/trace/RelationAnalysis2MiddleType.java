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
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * A Relation2MiddleType supports the future invocation/trace class/interface for a Relation
 * realized by a QVTc Mapping
 */
public interface RelationAnalysis2MiddleType extends RuleAnalysis2MiddleType
{
	@Nullable Relation2ResultProperty basicGetRelation2ResultProperty();
	@Nullable Element2MiddleProperty basicGetRelation2GlobalSuccessProperty();
	@Nullable Element2MiddleProperty basicGetRelation2LocalSuccessProperty();
	@Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable);
	void createRootVariableDeclaration2TraceProperty(@NonNull TypedModel rTypedModel, @NonNull VariableDeclaration rVariable, boolean manyTraces);
	@Override
	@NonNull Relation getRule();
	@Override
	@NonNull RelationAnalysis2TraceGroup getRuleAnalysis2TraceGroup();
	@Override
	@NonNull RelationAnalysis getRuleAnalysis();
	@Override
	@NonNull RelationalTransformationAnalysis2TracePackage getTransformation2TracePackage();
}