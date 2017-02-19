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
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

/**
 * A RegionCycle identifies a Set or Regions that encompass a cyclic dependency.
 *
 * Distinct RegionCycle objects identifying the same set of regions are equal.
 */
public final class RegionCycle
{
	private static final class CycleComparator implements Comparator<@NonNull RegionCycle>
	{
		@Override
		public int compare(@NonNull RegionCycle o1, @NonNull RegionCycle o2) {
			return o1.regions.size() - o2.regions.size();
		}
	}

	public static final @NonNull CycleComparator COMPARATOR = new CycleComparator();

	private final @NonNull Set<@NonNull Region> regions;
	private @Nullable String name;

	public RegionCycle(@NonNull Set<@NonNull Region> regions) {
		this.regions = regions;
		assert regions.size() > 0;		// FIXME > 1 ??
	}

	/**
	 * Return a new Cycle comprising the residue after removing thatCycle fron this cycle.
	 */
	public @NonNull RegionCycle createResidualCycle(@NonNull RegionCycle thatCycle) {
		HashSet<@NonNull Region> regions = new HashSet<@NonNull Region>(this.regions);
		regions.removeAll(thatCycle.regions);
		return new RegionCycle(regions);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RegionCycle)) {
			return false;
		}
		return regions.equals(((RegionCycle)obj).regions);
	}

	/**
	 * The regions that comprise the cycle.
	 */
	public @NonNull Iterable<@NonNull Region> getRegions() {
		return regions;
	}

	@Override
	public int hashCode() {
		return regions.hashCode();
	}

	@Override
	public @NonNull String toString() {
		String name2 = name;
		if (name2 == null) {
			List<@NonNull String> names = new ArrayList<@NonNull String>();
			Collections.sort(names);
			for (@NonNull Region region : regions) {
				names.add(region.getName());
			}
			Collections.sort(names);
			StringBuilder s = null;
			for (@NonNull String name : names) {
				if (s == null) {
					s = new StringBuilder();
				}
				else {
					s.append(", ");
				}
				s.append(name);
			}
			assert s != null;
			name2 = this.name = "[" + s.toString() + "]";
		}
		return name2;
	}
}