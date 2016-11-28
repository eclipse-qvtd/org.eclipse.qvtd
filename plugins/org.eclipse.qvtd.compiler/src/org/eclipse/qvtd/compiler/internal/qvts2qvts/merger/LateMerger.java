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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.NodeConnection;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RootScheduledRegion;

import com.google.common.collect.Iterables;

/**
 * LateMerger replaces one list of MappingRegions by another in which each set of regions that can be merged
 * exploiting knowledge of the schedule is replaced by an equivalent merged region.
 */
public class LateMerger extends AbstractMerger
{
	/**
	 * Replace those inputRegions that may be merged by merged regions.
	 *
	 * inputRegions should be indexed to encourage consecutive indexes for regions sharing an input connection.
	 */
	public static void merge(@NonNull RootScheduledRegion rootRegion) {
		LateMerger lateMerger = new LateMerger(rootRegion);
		lateMerger.merge();
	}

	protected final @NonNull RootScheduledRegion rootRegion;

	public LateMerger(@NonNull RootScheduledRegion rootRegion) {
		this.rootRegion = rootRegion;
	}

	private void merge() {
		mergeHierarchy(rootRegion);
		return;
	}

	private void mergeHierarchy(@NonNull Region parentRegion) {
		for (@NonNull Region childRegion : parentRegion.getCallableChildren()) {
			mergeHierarchy(childRegion);
			mergeRegion(childRegion);
		}
		return;
	}

	private void mergeRegion(@NonNull Region parentRegion) {
		for (@NonNull NodeConnection nodeConnection : parentRegion.getRootConnections()) {
			Iterable<@NonNull List<@NonNull Region>> consecutiveRegionRuns = selectConsecutiveRegionRuns(nodeConnection);
			for (@NonNull List<@NonNull Region> consecutiveRegionRun : consecutiveRegionRuns) {
				StringBuilder s = new StringBuilder();
				s.append(Iterables.size(consecutiveRegionRun));
				for (@NonNull Region consecutiveRegion : consecutiveRegionRun) {
					s.append(" " + consecutiveRegion);
				}
				System.out.println(s.toString());
				mergeRegions(consecutiveRegionRun);
			}
		}
		return;
	}

	protected void mergeRegions(@NonNull List<@NonNull Region> consecutiveRegionRun) {
		// TODO Auto-generated method stub

	}

	protected @NonNull Iterable<@NonNull List<@NonNull Region>> selectConsecutiveRegionRuns(@NonNull NodeConnection nodeConnection) {
		Map<@NonNull Integer, @NonNull Region> index2region = new HashMap<>();
		for (@NonNull Region targetRegion : nodeConnection.getTargetRegions()) {
			List<@NonNull Integer> indexes = targetRegion.getIndexes();
			index2region.put(indexes.get(indexes.size()-1), targetRegion);
		}
		List<@NonNull Integer> orderedIndexes = new ArrayList<>(index2region.keySet());
		Collections.sort(orderedIndexes);
		List<@NonNull List<@NonNull Region>> consecutiveRegionRuns = new ArrayList<>();
		{
			List<@NonNull Region> consecutiveRegionRun = null;
			for (@NonNull Integer index : orderedIndexes) {
				Region childRegion = index2region.get(index);
				assert childRegion != null;
				if ((consecutiveRegionRun == null) || (consecutiveRegionRun.get(consecutiveRegionRun.size()-1).getLastIndex()+1 != index)) {
					consecutiveRegionRun = new ArrayList<>();
					consecutiveRegionRuns.add(consecutiveRegionRun);
				}
				consecutiveRegionRun.add(childRegion);
			}
		}
		for (int i = consecutiveRegionRuns.size(); --i >= 0; ) {		// Down count to allow removal
			List<@NonNull Region> consecutiveRegionRun = consecutiveRegionRuns.get(i);
			if (consecutiveRegionRun.size() <= 1) {
				consecutiveRegionRuns.remove(i);
			}
		}
		return consecutiveRegionRuns;
	}
}
