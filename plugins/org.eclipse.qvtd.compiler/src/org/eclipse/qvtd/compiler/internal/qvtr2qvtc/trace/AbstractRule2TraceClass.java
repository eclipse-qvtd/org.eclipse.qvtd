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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.PivotFactory;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * An AbstractRule2TraceClass represents the mapping between a Relation or RelationCallExp and a TraceClass/Mapping
 */
abstract class AbstractRule2TraceClass implements Rule2TraceClass.Internal
{
	protected final @NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage;

	/**
	 * The relation to be mapped to a trace class and mapping.
	 */
	protected final @NonNull Relation relation;

	/**
	 * The Class that realizes the middle model trace class.
	 */
	protected final org.eclipse.ocl.pivot.@NonNull Class traceClass = ClassUtil.nonNullState(PivotFactory.eINSTANCE.createClass());

	/**
	 * Each Rule2TraceClass which directly consumes this Rule2TraceClass.
	 */
	private final @NonNull List<Rule2TraceClass.@NonNull Internal> consumedByRule2traceClasses = new ArrayList<>();

	/**
	 * Each Rule2TraceClass which this Rule2TraceClass directly consumes.
	 */
	private final @NonNull List<Rule2TraceClass.@NonNull Internal> consumedRule2traceClasses = new ArrayList<>();

	/**
	 * Each Rule2TraceClass that transitively consumes this Rule2TraceClass.
	 */
	private @Nullable Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedByRule2traceClasses = null;

	/**
	 * Each Rule2TraceClass that is transitively consumed by this Rule2TraceClass.
	 */
	private @Nullable Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedRule2traceClasses = null;

	/**
	 * Each Rule2TraceClass that is both transitively consumed by and consumes this Rule2TraceClass.
	 */
	private @Nullable Set<Rule2TraceClass.@NonNull Internal> cyclicRule2traceClasses = null;

	public AbstractRule2TraceClass(@NonNull RelationalTransformation2TracePackage relationalTransformation2tracePackage, @NonNull Relation relation) {
		this.relationalTransformation2tracePackage = relationalTransformation2tracePackage;
		this.relation = relation;
	}

	@Override
	public void addConsumedBy(Rule2TraceClass.@NonNull Internal consumedByRule2traceClass) {
		if (!consumedByRule2traceClasses.contains(consumedByRule2traceClass)) {
			consumedByRule2traceClasses.add(consumedByRule2traceClass);
		}
		consumedByRule2traceClass.addConsumedInternal(this);
	}

	@Override
	public void addConsumedInternal(Rule2TraceClass.@NonNull Internal consumedRule2traceClass) {
		if (!consumedRule2traceClasses.contains(consumedRule2traceClass)) {
			consumedRule2traceClasses.add(consumedRule2traceClass);
		}
	}

	@Override
	public int compareTo(@NonNull Rule2TraceClass that) {
		return ClassUtil.safeCompareTo(this.traceClass.getName(), that.getTraceClass().getName());
	}

	@Override
	public @Nullable Iterable<Rule2TraceClass.@NonNull Internal> getConsumedByRule2traceClasses() {
		return consumedByRule2traceClasses;
	}

	@Override
	public @Nullable Iterable<Rule2TraceClass.@NonNull Internal> getConsumedRule2traceClasses() {
		return consumedRule2traceClasses;
	}

	@Override
	public @Nullable Iterable<Rule2TraceClass.@NonNull Internal> getCyclicRule2traceClasses() {
		return cyclicRule2traceClasses;
	}

	public @NonNull Relation getRelation() {
		return relation;
	}

	@Override
	public org.eclipse.ocl.pivot.@NonNull Class getTraceClass() {
		return traceClass;
	}

	@Override
	public @NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedByRule2traceClasses() {
		Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedByRule2traceClasses2 = transitivelyConsumedByRule2traceClasses;
		if (transitivelyConsumedByRule2traceClasses2 == null) {
			transitivelyConsumedByRule2traceClasses2 = getTransitivelyConsumedByRule2traceClasses(new HashSet<>());
		}
		return transitivelyConsumedByRule2traceClasses2;
	}
	@Override
	public @NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedByRule2traceClasses(@NonNull Set<Rule2TraceClass.@NonNull Internal> accumulator) {
		Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedByRule2traceClasses2 = this.transitivelyConsumedByRule2traceClasses;
		if (transitivelyConsumedByRule2traceClasses2 != null) {
			accumulator.addAll(transitivelyConsumedByRule2traceClasses2);
		}
		else {
			for (Rule2TraceClass.@NonNull Internal consumedByRule2traceClass : consumedByRule2traceClasses) {
				if (accumulator.add(consumedByRule2traceClass)) {
					consumedByRule2traceClass.getTransitivelyConsumedByRule2traceClasses(accumulator);
				}
			}
		}
		return accumulator;
	}

	@Override
	public @NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedRule2traceClasses() {
		Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedRule2traceClasses2 = transitivelyConsumedRule2traceClasses;
		if (transitivelyConsumedRule2traceClasses2 == null) {
			transitivelyConsumedRule2traceClasses2 = getTransitivelyConsumedRule2traceClasses(new HashSet<>());
		}
		return transitivelyConsumedRule2traceClasses2;
	}
	@Override
	public @NonNull Set<Rule2TraceClass.@NonNull Internal> getTransitivelyConsumedRule2traceClasses(@NonNull Set<Rule2TraceClass.@NonNull Internal> accumulator) {
		Set<Rule2TraceClass.@NonNull Internal> transitivelyConsumedRule2traceClasses2 = this.transitivelyConsumedRule2traceClasses;
		if (transitivelyConsumedRule2traceClasses2 != null) {
			accumulator.addAll(transitivelyConsumedRule2traceClasses2);
		}
		else {
			for (Rule2TraceClass.@NonNull Internal consumedRule2traceClass : consumedRule2traceClasses) {
				if (accumulator.add(consumedRule2traceClass)) {
					consumedRule2traceClass.getTransitivelyConsumedRule2traceClasses(accumulator);
				}
			}
		}
		return accumulator;
	}

	//		public void installConsumedByDependencies() {
	//			for (@NonNull Rule2TraceClass consumedRule2traceClass : getTransitivelyConsumedRule2traceClasses()) {
	//				ClassUtil.nonNullState(consumedRule2traceClass.transitivelyConsumedByRule2traceClasses).add(this);
	//			}
	//		}

	/*		public void installDependencyCycles() throws CompilerChainException {
		Set<@NonNull Rule2TraceClass> cyclicRule2traceClasses2 = cyclicRule2traceClasses = new HashSet<>(getTransitivelyConsumedByRule2traceClasses());
		cyclicRule2traceClasses2.retainAll(getTransitivelyConsumedRule2traceClasses());
		if (!cyclicRule2traceClasses2.isEmpty()) {
			traceClass.getSuperClasses().add(relationalTransformation2tracePackage.getSpeculatableClass());
		}
	} */

	@Override
	public String toString() {
		return traceClass.getName();
	}
}