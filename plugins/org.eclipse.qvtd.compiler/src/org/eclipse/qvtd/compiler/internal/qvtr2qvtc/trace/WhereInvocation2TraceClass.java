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
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * A WhereInvocation2TraceClass represents the mapping between an where-invoked QVTr Relation and a QVTr mapping trace class.
 */
class WhereInvocation2TraceClass extends AbstractInvocation2TraceClass
{
	protected WhereInvocation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation invokedRelation, @NonNull Relation invokingRelation, boolean isDerived) {
		super(relationalTransformation2tracePackage, invokedRelation, invokingRelation, isDerived, relationalTransformation2tracePackage.getNameGenerator().createWhereTraceClassName(invokingRelation, invokedRelation));
	}

	//		@Override
	//		public void installConsumesDependencies() throws CompilerChainException {
	//			Rule2TraceClass invokingRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(invokingRelation);
	//			addConsumedBy(invokingRelation2TraceClass);
	//		}
}