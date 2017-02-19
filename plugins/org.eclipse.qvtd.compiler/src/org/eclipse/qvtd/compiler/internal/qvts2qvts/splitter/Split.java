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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.splitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A Split captures the result of the analysis that enables a multi-headed region to be split.
 */
public class Split
{
	/**
	 * The Splitter supervising the region splitting.
	 */
	protected final @NonNull SplitterAnalysis splitter;

	/**
	 * The Stages that specify a multi-headed region split.
	 */
	private final @NonNull List<@NonNull Stage> stages = new ArrayList<>();

	/**
	 * Mapping from each head node to the Stage that specifies it.
	 */
	private final @NonNull Map<@NonNull SimpleGroup, @NonNull HeadedStage> simpleGroup2stage = new HashMap<>();

	public Split(@NonNull SplitterAnalysis splitter) {
		this.splitter = splitter;
	}

	public void addBodyStage() {
		Stage bodyStage = new BodyStage(splitter, stages);
		stages.add(bodyStage);
	}

	public @NonNull Stage addStage(@Nullable SimpleGroup sourceSimpleGroup, @Nullable Edge edge, @NonNull SimpleGroup targetSimpleGroup) {
		assert !simpleGroup2stage.containsKey(targetSimpleGroup);
		HeadedStage sourceStage;
		HeadedStage targetStage;
		if (edge == null) {
			assert sourceSimpleGroup == null;
			sourceStage = null;
			targetStage = new HeadStage(splitter, targetSimpleGroup);
		}
		else {
			assert sourceSimpleGroup != null;
			sourceStage = /*sourceSimpleGroup != null ?*/ simpleGroup2stage.get(sourceSimpleGroup);// : null;
			targetStage = new LoopStage(splitter, sourceStage, edge, targetSimpleGroup);
		}
		stages.add(targetStage);
		simpleGroup2stage.put(targetSimpleGroup, targetStage);
		if (sourceStage != null) {
			sourceStage.addSuccessor(targetStage);
		}
		return targetStage;
	}

	public void check() {
		for (@NonNull Stage stage : stages) {
			stage.debug();
			stage.check();
		}
	}

	public void debug() {
		for (@NonNull Stage stage : stages) {
			stage.debug();
		}
	}

	public void install() {
		Region region = splitter.getRegion();
		Iterable<@NonNull Node> newHeadNodes = stages.get(0).getHeadNodes();
		Iterable<@NonNull Node> oldHeadNodes = Lists.newArrayList(region.getHeadNodes());
		for (@NonNull Node headNode : oldHeadNodes) {
			if (!Iterables.contains(newHeadNodes, headNode)) {
				region.resetHead(headNode);
			}
		}
	}

	@Override
	public @NonNull String toString() {
		StringBuilder s = new StringBuilder();
		toString(s, 0);
		return s.toString();
	}

	public void toString(@NonNull StringBuilder s, int depth) {
		CompilerUtil.indent(s, depth);
		for (@NonNull Stage stage : stages) {
			s.append("\n");
			stage.toString(s, depth+1);
		}
	}
}