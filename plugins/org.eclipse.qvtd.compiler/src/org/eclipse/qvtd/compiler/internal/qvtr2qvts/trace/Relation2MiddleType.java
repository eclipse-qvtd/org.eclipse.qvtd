/*******************************************************************************
 * Copyright (c) 2017, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2MiddleType;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * A Relation2MiddleType supports the future invocation/trace class/interface for a Relation
 * realized by a QVTc Mapping
 */
public interface Relation2MiddleType extends Rule2MiddleType
{
	@Nullable Relation2SuccessProperty basicGetRelation2DispatchSuccessProperty();
	@Nullable Relation2SuccessProperty basicGetRelation2GlobalSuccessProperty();
	@Nullable Relation2SuccessProperty basicGetRelation2LocalSuccessProperty();
	@Nullable Relation2ResultProperty basicGetRelation2ResultProperty();
	@Nullable VariableDeclaration2TraceProperty basicGetVariableDeclaration2TraceProperty(@NonNull VariableDeclaration variable);
	@NonNull Relation2SuccessProperty getRelation2GlobalSuccessProperty();
	@NonNull Relation2SuccessProperty getRelation2LocalSuccessProperty();
	void getRootVariableDeclaration2TraceProperty(@Nullable TypedModel rTypedModel, @NonNull VariableDeclaration rVariable, boolean manyTraces);
	@Override
	@NonNull Relation getRule();
	@Override
	@NonNull Relation2TraceGroup getRule2TraceGroup();
	@Override
	@NonNull RelationalTransformation2TracePackage getTransformation2TracePackage();
}