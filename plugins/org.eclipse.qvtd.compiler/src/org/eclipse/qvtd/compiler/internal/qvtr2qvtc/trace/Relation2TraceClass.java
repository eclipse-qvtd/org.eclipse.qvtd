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

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;

/**
 * A Relation2TraceClass represents the mapping between a Relation and a TraceClass/Mapping
 */
public interface Relation2TraceClass extends Relation2MiddleClass
{
	void addConsumedBy(@NonNull Relation2TraceClass consumedByRelation2TraceClass);
	void addConsumedInternal(@NonNull Relation2TraceClass consumedRelation2TraceClass);
	void analyzeInheritance();
	@Nullable Iterable<@NonNull Relation2TraceClass> getConsumedByRelation2TraceClasses();
	@Nullable Iterable<@NonNull Relation2TraceClass> getConsumedRelation2TraceClasses();
	@Nullable Iterable<@NonNull Relation2TraceClass> getCyclicRelation2TraceClasses();
	@NonNull Property getTraceProperty(@NonNull RelationCallExp rInvocation);
	@NonNull Set<@NonNull Relation2TraceClass> getTransitivelyConsumedByRelation2TraceClasses();
	@NonNull Set<@NonNull Relation2TraceClass> getTransitivelyConsumedByRelation2TraceClasses(@NonNull Set<@NonNull Relation2TraceClass> accumulator);
	@NonNull Set<@NonNull Relation2TraceClass> getTransitivelyConsumedRelation2TraceClasses();
	@NonNull Set<@NonNull Relation2TraceClass> getTransitivelyConsumedRelation2TraceClasses(@NonNull Set<@NonNull Relation2TraceClass> accumulator);
	@NonNull Iterable<@NonNull RelationCallExp> getWhenInvocations();
	@NonNull Iterable<@NonNull RelationCallExp> getWhereInvocations();
	void installConsumesDependencies() throws CompilerChainException;
}