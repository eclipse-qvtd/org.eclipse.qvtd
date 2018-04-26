/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class or property.
 */
public abstract class TraceElementAnalysis implements Nameable
{
	protected final @NonNull TransformationPartitioner transformationPartitioner;

	/**
	 * The partitioners that consume (predicate) the trace class.
	 */
	protected final @NonNull List<@NonNull MappingPartitioner> consumers = new ArrayList<>();

	/**
	 * The partitioners that produce (realize) the trace class.
	 */
	protected final @NonNull List<@NonNull MappingPartitioner> producers = new ArrayList<>();

	public TraceElementAnalysis(@NonNull TransformationPartitioner transformationPartitioner) {
		this.transformationPartitioner = transformationPartitioner;
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
}
