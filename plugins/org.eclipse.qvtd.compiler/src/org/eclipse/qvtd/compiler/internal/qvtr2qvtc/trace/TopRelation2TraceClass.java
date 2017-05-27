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
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * A TopRelation2TraceClass represents the mapping between a top level QVTr Relation and the trace class for a QVTc Mapping.
 */
class TopRelation2TraceClass extends AbstractRelation2TraceClass
{
	protected TopRelation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
		super(relationalTransformation2tracePackage, relation);
	}

	@Override
	public @Nullable Class basicGetSignatureClass() {
		return null;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getSignatureClass() {
		throw new IllegalStateException("top relations have no signature class");
	}

	@Override
	public @NonNull Property getSignatureProperty(@NonNull VariableDeclaration rVariable) {
		throw new IllegalStateException("top relations have no signature class or properties");
	}
}