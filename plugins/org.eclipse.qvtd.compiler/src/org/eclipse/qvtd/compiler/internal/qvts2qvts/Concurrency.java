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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis.PartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionsAnalysis;

/**
 * A Concurrency identifies the PartitionAnalysis instances that may be executed concurrently as
 * one pass in the overall parallel schedule formed from a list of concurrencies.
 */
public class Concurrency implements Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>>
{
	/**
	 * The concurrently executable partitionAnalyses defining the schedule pass.
	 */
	protected final @NonNull List<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> partitionAnalyses;		// List rather than Set for deterministic iteration

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
		this.partitionAnalyses = new ArrayList<>();
	}

	/**
	 * Add an additional partitionAnalysis to the set of concurrent partitionAnalyses.
	 */
	public boolean add(@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis) {
		assert !partitionAnalyses.contains(partitionAnalysis);
		//	if (partitionAnalyses.contains(partitionAnalysis)) {
		//		return false;
		//	}
		return partitionAnalyses.add(partitionAnalysis);
	}

	public void addPass(int cyclePass) {
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitionAnalyses) {
			partitionAnalysis.getPartition().addPass(cyclePass);
		}
	}

	public @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> getPartitionAnalyses() {
		return partitionAnalyses;
	}

	public boolean isCycleEnd() {
		return isCycleEnd;
	}

	public boolean isCycleStart() {
		return isCycleStart;
	}

	@Override
	public @NonNull Iterator<@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis>> iterator() {
		return partitionAnalyses.iterator();
	}

	void setPass(int passNumber) {
		assert this.passNumber == null;
		this.passNumber = passNumber;
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitionAnalyses) {
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
		toString(s);
		s.append("]");
		return s.toString();
	}

	public void toString(@NonNull StringBuilder s) {
		if (isCycleStart) {
			s.append(", «start»");
		}
		for (@NonNull PartialRegionAnalysis<@NonNull PartitionsAnalysis> partitionAnalysis : partitionAnalyses) {
			s.append(", ");
			s.append(partitionAnalysis);
		}
		if (isCycleEnd) {
			s.append(", «end»");
		}
	}
}
