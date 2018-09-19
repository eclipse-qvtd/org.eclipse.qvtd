/*******************************************************************************
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class or property.
 */
public abstract class TraceElementRegionAnalysis implements Nameable
{
	/**
	 * The partitioners that consume (predicate) the trace class.
	 */
	protected final @NonNull List<@NonNull RegionAnalysis> consumers = new ArrayList<>();

	/**
	 * The partitioners that produce (realize) the trace class.
	 */
	protected final @NonNull List<@NonNull RegionAnalysis> producers = new ArrayList<>();

	public void addConsumer(@NonNull RegionAnalysis consumer) {
		if (!consumers.contains(consumer)) {		// multi-consumption is possible
			consumers.add(consumer);
		}
	}

	public void addProducer(@NonNull RegionAnalysis producer) {
		if (!producers.contains(producer)) {		// multi-production of e.g. OclAny is possible
			producers.add(producer);
		}
	}

	public @NonNull Iterable<@NonNull RegionAnalysis> getConsumers() {
		return consumers;
	}

	public @NonNull Iterable<@NonNull RegionAnalysis> getProducers() {
		return producers;
	}
}
