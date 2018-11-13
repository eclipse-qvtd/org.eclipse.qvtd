/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;

import com.google.common.collect.Sets;

/**
 * A Concurrency identifies the PartitionAnalysis instances that may be executed concurrently as
 * one pass in the overall parallel schedule formed from a list of concurrencies.
 */
public class Concurrency implements Iterable<@NonNull PartitionAnalysis>
{
	protected final @NonNull Set<@NonNull PartitionAnalysis> partitionAnalyses;

	public Concurrency() {
		this.partitionAnalyses = new HashSet<>();
	}

	public Concurrency(@NonNull Concurrency oldConcurrency) {
		this.partitionAnalyses = new HashSet<>(oldConcurrency.partitionAnalyses);
	}

	public Concurrency(@NonNull Iterable<@NonNull PartitionAnalysis> partitionAnalyses) {
		this.partitionAnalyses = Sets.newHashSet(partitionAnalyses);
	}

	public boolean add(@NonNull PartitionAnalysis partitionAnalysis) {
		return partitionAnalyses.add(partitionAnalysis);
	}

	public boolean addAll(@NonNull Concurrency concurrency) {
		return partitionAnalyses.addAll(concurrency.partitionAnalyses);
	}

	//	public @NonNull Iterable<@NonNull PartitionAnalysis> getPartitionAnalyses() {
	//		return partitionAnalyses;
	//	}

	@Override
	public @NonNull Iterator<@NonNull PartitionAnalysis> iterator() {
		return partitionAnalyses.iterator();
	}

	public boolean remove(@NonNull PartitionAnalysis partitionAnalysis) {
		return partitionAnalyses.add(partitionAnalysis);
	}

	public int size() {
		return partitionAnalyses.size();
	}
}
