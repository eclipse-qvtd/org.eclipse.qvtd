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
 * A AbstractRelation2TraceClass represents the mapping between a QVTr Relation and the abstract trace class for an invoked QVTc Mapping.
 */
abstract class AbstractRelation2TraceClass extends AbstractRule2TraceClass
{
	protected AbstractRelation2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
		super(relationalTransformation2tracePackage, relation);
		String name = "T" + relation.getName();
		traceClass.setName(relationalTransformation2tracePackage.getUniqueTraceClassName(this, name));
	}

	/*		@Override
	public void installConsumesDependencies() throws CompilerChainException {
		Iterable<@NonNull RelationCallExp> rWhenInvocations = relationalTransformation2tracePackage.qvtr2qvtc.getWhenInvocationsOf(relation);
		if (rWhenInvocations != null) {
			for (@NonNull RelationCallExp rWhenInvocation : rWhenInvocations) {
				//					Rule2TraceClass invocation2TraceClass = relationalTransformation2tracePackage.getInvocation2TraceClass(rWhenInvocation);
				Relation rInvokingRelation = QVTrelationUtil.getContainingRelation(rWhenInvocation);
				Rule2TraceClass invokingRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(rInvokingRelation);
				invokingRelation2TraceClass.addConsumer(this);		// invoker consumers the invoked result
				//					addConsumer(invokingRelation2TraceClass);
			}
		}
		Iterable<@NonNull RelationCallExp> rWhereInvocations = relationalTransformation2tracePackage.qvtr2qvtc.getWhereInvocationsOf(relation);
		if (rWhereInvocations != null) {
			for (@NonNull RelationCallExp rWhereInvocation : rWhereInvocations) {
				//					Rule2TraceClass invocation2TraceClass = relationalTransformation2tracePackage.getInvocation2TraceClass(rWhenInvocation);
				Relation rInvokingRelation = QVTrelationUtil.getContainingRelation(rWhereInvocation);
				Rule2TraceClass invokingRelation2TraceClass = relationalTransformation2tracePackage.getRule2TraceClass(rInvokingRelation);
				addConsumer(invokingRelation2TraceClass);
			}
		}
	} */
}