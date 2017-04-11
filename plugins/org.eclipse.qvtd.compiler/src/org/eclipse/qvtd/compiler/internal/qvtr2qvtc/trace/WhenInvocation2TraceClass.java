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
 * A WhenInvocation2TraceClass represents the mapping between an when-invoked QVTr Relation and a QVTr mapping trace class.
 */
class WhenInvocation2TraceClass extends AbstractInvocation2TraceClass
{
	protected WhenInvocation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage,
			@NonNull Relation invokedRelation, @NonNull Relation invokingRelation) throws CompilerChainException {
		super(relationalTransformation2tracePackage, invokedRelation, invokingRelation);
		String name = "T" + invokingRelation.getName() + "_when_" + invokedRelation.getName();
		traceClass.setName(relationalTransformation2tracePackage.getUniqueTraceClassName(this, name));
		Rule2TraceClass.@NonNull Internal superRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(invokedRelation);
		traceClass.getSuperClasses().add(superRelation2TraceClass.getTraceClass());
		//		addAllProperties(superRelation2TraceClass);
	}

	//		@Override
	//		public void installConsumesDependencies() throws CompilerChainException {
	//			Rule2TraceClass invokedRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(relation);
	//			Rule2TraceClass invokingRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(invokingRelation);
	//			invokedRelation2TraceClass.addConsumer(this);
	//			invokingRelation2TraceClass.addConsumer(this);
	//		}
}