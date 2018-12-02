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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;

/**
 * A Concurrency identifies the PartitionAnalysis instances that may be executed concurrently as
 * one pass in the overall parallel schedule formed from a list of concurrencies.
 */
public class Concurrency implements Iterable<@NonNull PartitionAnalysis>
{
	/**
	 * The concurrently executable partitionAnalyses defining the schedule pass.
	 */
	protected final @NonNull Set<@NonNull PartitionAnalysis> partitionAnalyses;

	/**
	 * The concurrencies that may resume after exdecjution of this concurrency.
	 */
	//	private @Nullable List<@NonNull Concurrency> startConcurrencies = null;
	private boolean isCycleStart = false;
	private boolean isCycleEnd = false;

	/**
	 * The sequentual pass number within the overall schedule.
	 */
	private @Nullable Integer passNumber = null;

	public Concurrency() {
		this.partitionAnalyses = new HashSet<>();
	}

	/**
	 * Add an additional partitionAnalysis to the set of concurrent partitionAnalyses.
	 */
	public boolean add(@NonNull PartitionAnalysis partitionAnalysis) {
		return partitionAnalyses.add(partitionAnalysis);
	}

	public void addPass(int cyclePass) {
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
			partitionAnalysis.getPartition().addPass(cyclePass);
		}
	}

	public @NonNull Iterable<@NonNull PartitionAnalysis> getPartitionAnalyses() {
		return partitionAnalyses;
	}

	public boolean isCycleEnd() {
		return isCycleEnd;
	}

	public boolean isCycleStart() {
		return isCycleStart;
	}

	@Override
	public @NonNull Iterator<@NonNull PartitionAnalysis> iterator() {
		return partitionAnalyses.iterator();
	}

	void setPass(int passNumber) {
		assert this.passNumber == null;
		this.passNumber = passNumber;
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
			partitionAnalysis.getPartition().setPass(passNumber);
		}
	}

	public int size() {
		return partitionAnalyses.size();
	}

	public void setCycleStart() {
		this.isCycleStart = true;
	}

	public void setCycleEnd() {
		this.isCycleEnd = true;
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		s.append(passNumber);
		if (isCycleStart) {
			s.append(", «start»");
		}
		if (isCycleEnd) {
			s.append(", «end»");
		}
		for (@NonNull PartitionAnalysis partitionAnalysis : partitionAnalyses) {
			s.append(", ");
			s.append(partitionAnalysis);
		}
		s.append("]");
		return s.toString();
	}
}