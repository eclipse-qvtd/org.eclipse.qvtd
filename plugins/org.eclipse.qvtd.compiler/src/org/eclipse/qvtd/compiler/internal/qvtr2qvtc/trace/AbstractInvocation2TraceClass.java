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
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * A AbstractInvocation2TraceClass represents the mapping between an invoked QVTr Relation and a QVTr mapping trace class.
 */
abstract class AbstractInvocation2TraceClass extends AbstractRule2TraceClass
{
	protected final @NonNull Relation invokingRelation;

	protected AbstractInvocation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage,
			@NonNull Relation invokedRelation, @NonNull Relation invokingRelation) throws CompilerChainException {
		super(relationalTransformation2tracePackage, invokedRelation);
		this.invokingRelation = invokingRelation;
	}
}