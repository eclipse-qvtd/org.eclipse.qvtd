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

import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;

/**
 * A Rule2TraceClass represents the mapping between a Relation or RelationCallExp and a TraceClass/Mapping
 */
interface Rule2TraceClass extends Comparable<@NonNull Rule2TraceClass>
{
	org.eclipse.ocl.pivot.@NonNull Class getTraceClass();

	interface Internal extends Rule2TraceClass
	{
		void addConsumedBy(Rule2TraceClass.@NonNull Internal consumedByRule2traceClass);
		void addConsumedInternal(Rule2TraceClass.@NonNull Internal consumedRule2traceClass);
		@Nullable Iterable<Rule2TraceClass.@NonNull Internal> getConsumedByRule2traceClasses();
		@Nullable Iterable<Rule2TraceClass.@NonNull Internal> getConsumedRule2traceClasses();
		@Nullable Iterable<Rule2TraceClass.@NonNull Internal> getCyclicRule2traceClasses();
		@NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedByRule2traceClasses();
		@NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedByRule2traceClasses(@NonNull Set<Rule2TraceClass.@NonNull Internal> accumulator);
		@NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedRule2traceClasses();
		@NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedRule2traceClasses(@NonNull Set<Rule2TraceClass.@NonNull Internal> accumulator);
		@NonNull Iterable<@NonNull RelationCallExp> getWhenInvocations();
		@NonNull Iterable<@NonNull RelationCallExp> getWhereInvocations();
		void installConsumesDependencies() throws CompilerChainException;
		@NonNull Map<@NonNull String, @NonNull Property> getName2Property();
		void transform() throws CompilerChainException;
	}
}