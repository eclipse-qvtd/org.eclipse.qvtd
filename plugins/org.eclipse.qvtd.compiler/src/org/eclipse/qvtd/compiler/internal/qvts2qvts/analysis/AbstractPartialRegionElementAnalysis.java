/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class or property.
 */
public abstract class AbstractPartialRegionElementAnalysis<PRA extends PartialRegionsAnalysis<@NonNull PRA>> implements PartialRegionElementAnalysis<@NonNull PRA>
{
	/**
	 * The partitioners that consume (predicate) the trace class.
	 */
	protected final @NonNull List<@NonNull PartialRegionAnalysis<@NonNull PRA>> consumers = new ArrayList<>();

	/**
	 * The partitioners that produce (realize) the trace class.
	 */
	protected final @NonNull List<@NonNull PartialRegionAnalysis<@NonNull PRA>> producers = new ArrayList<>();

	@Override
	public void addConsumer(@NonNull PartialRegionAnalysis<@NonNull PRA> consumer) {
		if (!consumers.contains(consumer)) {		// multi-consumption is possible
			consumers.add(consumer);
		}
	}

	@Override
	public void addProducer(@NonNull PartialRegionAnalysis<@NonNull PRA> producer) {
		if (!producers.contains(producer)) {		// multi-production of e.g. OclAny is possible
			producers.add(producer);
		}
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getConsumers() {
		return consumers;
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getProducers() {
		return producers;
	}
}
