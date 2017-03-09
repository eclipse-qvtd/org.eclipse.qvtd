/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class.
 */
public class TraceClassAnalysis
{
	protected final @NonNull TransformationPartitioner transformationPartitioner;
	protected final @NonNull CompleteClass traceClass;

	/**
	 * The partitioners that consume (predicate) the trace class.
	 */
	private final @NonNull List<@NonNull MappingPartitioner> consumers = new ArrayList<>();

	/**
	 * The partitioners that produce (realize) the trace class.
	 */
	private final @NonNull List<@NonNull MappingPartitioner> producers = new ArrayList<>();

	public TraceClassAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull CompleteClass traceClass) {
		this.transformationPartitioner = transformationPartitioner;
		this.traceClass = traceClass;
	}

	public void addConsumer(@NonNull MappingPartitioner consumer) {
		if (!consumers.contains(consumer)) {		// multi-consumption is possible
			consumers.add(consumer);
		}
	}

	public void addProducer(@NonNull MappingPartitioner producer) {
		if (!producers.contains(producer)) {		// multi-production of e.g. OclAny is possible
			producers.add(producer);
		}
	}

	public @NonNull Iterable<@NonNull MappingPartitioner> getConsumers() {
		return consumers;
	}

	public @NonNull Iterable<@NonNull MappingPartitioner> getProducers() {
		return producers;
	}

	public @NonNull CompleteClass getTraceClass() {
		return traceClass;
	}
}
