/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public class BasicConnection extends AbstractConnection
{
	private int earliestIndex = -1;
	private int latestIndex = -1;
	private Region commonRegion = null;
	private List<Region> intermediateRegions = null;

	public BasicConnection(@NonNull ScheduledRegion region, @NonNull Set<Node> sourceNodes, @NonNull String name) {
		super(region, sourceNodes, name);
	}
	
	@Override
	public @Nullable Region getCommonRegion() {
		return commonRegion;
	}

	@Override
	public int getEarliestIndex() {
		return earliestIndex;
	}

	@Override
	public @Nullable String getIndexText() {
		Integer earliestIndex2 = earliestIndex;
		if (earliestIndex2 < 0) {
			return null;
		}
		else if (latestIndex == earliestIndex2) {
			return earliestIndex2.toString();
		}
		else {
			return earliestIndex2 + " ... " + latestIndex + " ";
		}
	}

	@Override
	public @NonNull List<Region> getIntermediateRegions() {
		return intermediateRegions != null ? intermediateRegions : SchedulerConstants.EMPTY_REGION_LIST;
	}

	@Override
	public int getLatestIndex() {
		return latestIndex;
	}

	@Override
	public void setCommonRegion(@NonNull Region commonRegion, @NonNull List<Region> intermediateRegions) {
		assert this.commonRegion == null;
		assert this.intermediateRegions == null;
		this.commonRegion = commonRegion;
		this.intermediateRegions = intermediateRegions;
		commonRegion.addRootConnection(this);
		for (Region intermediateRegion : intermediateRegions) {
			intermediateRegion.addIntermediateConnection(this);
		}
	}

	@Override
	public void setIndexes(int earliestIndex, int latestIndex) {
		if (this.earliestIndex < 0) {
			assert this.latestIndex == -1;
		}
		else {
			assert this.earliestIndex == earliestIndex;
		}
		assert earliestIndex <= latestIndex;
		this.earliestIndex = earliestIndex;
		this.latestIndex = latestIndex;
	}
}