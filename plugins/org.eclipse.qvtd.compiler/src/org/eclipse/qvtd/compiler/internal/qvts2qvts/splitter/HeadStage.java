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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Node;

import com.google.common.collect.Iterables;

/**
 * The HeadStage specifies the first part of a multi-headed region split. It has a headNode to represent its primary content.
 */
class HeadStage extends HeadedStage
{
	public HeadStage(@NonNull SplitterAnalysis splitter, @NonNull SimpleGroup targetSimpleGroup) {
		super(splitter, null, null, targetSimpleGroup);
	}

	@Override
	protected boolean isLive(@NonNull Node node, @NonNull Set<@NonNull Node> deadNodes) {
		Iterable<@NonNull SimpleGroup> reachableSimpleGroups = splitter.basicGetReachableSimpleGroups(node);
		if ((reachableSimpleGroups != null) && (Iterables.size(reachableSimpleGroups) > 1)) {
			return true;		// Group intersections must be live.
		}
		return super.isLive(node, deadNodes);
	}
}