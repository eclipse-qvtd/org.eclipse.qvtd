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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.AbstractRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.MultiRegion;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.QVTp2QVTs;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Region;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

/**
 * A Split captures the result of the analysis that enables a multi-headed region to be split.
 */
public class Split
{
	public static class BodySplitterVisitor extends SplitterVisitor
	{
		public BodySplitterVisitor(@NonNull MultiRegion multiRegion, @NonNull Stage stage, int stageNumber) {
			super(multiRegion, stage, stageNumber);
		}
	}

	public static class HeadSplitterVisitor extends SplitterVisitor
	{
		public HeadSplitterVisitor(@NonNull MultiRegion multiRegion, @NonNull Stage stage, int stageNumber) {
			super(multiRegion, stage, stageNumber);
		}
	}

	public static class LoopSplitterVisitor extends SplitterVisitor
	{
		public LoopSplitterVisitor(@NonNull MultiRegion multiRegion, @NonNull Stage stage, int stageNumber) {
			super(multiRegion, stage, stageNumber);
		}
	}


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

	public void install(@NonNull MultiRegion multiRegion) {
		Region oldRegion = splitter.getRegion();
		//		Iterable<@NonNull Node> newHeadNodes = stages.get(0).getHeadNodes();
		//		Iterable<@NonNull Node> oldHeadNodes = Lists.newArrayList(region.getHeadNodes());
		//		for (@NonNull Node headNode : oldHeadNodes) {
		//			if (!Iterables.contains(newHeadNodes, headNode)) {
		//				oldRegion.resetHead(headNode);
		//			}
		//		}
		int stageNumber = 0;
		Iterator<@NonNull Stage> stageIterator = stages.iterator();;
		//
		//	HeadStage
		//
		Stage nextStage = stageIterator.hasNext() ? stageIterator.next() : null;
		assert nextStage instanceof HeadStage;
		SplitterVisitor visitor = new HeadSplitterVisitor(multiRegion, nextStage, ++stageNumber);
		AbstractRegion stageRegion = visitor.create(AbstractRegion.class, oldRegion);
		multiRegion.addActiveRegion(stageRegion);
		nextStage = stageIterator.hasNext() ? stageIterator.next() : null;
		//
		//	non-hazardous LoopStages fold into HeadStage
		//
		while ((nextStage instanceof LoopStage) && !((LoopStage)nextStage).getEdge().isPredicated()) {
			visitor.extend(stageRegion, nextStage, oldRegion);
			nextStage = stageIterator.hasNext() ? stageIterator.next() : null;
		}
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			stageRegion.writeDebugGraphs("4-stage");
		}
		//
		//	LoopStage
		//
		while (nextStage instanceof HeadedStage) {
			visitor = new LoopSplitterVisitor(multiRegion, nextStage, ++stageNumber);
			stageRegion = visitor.create(AbstractRegion.class, oldRegion);
			multiRegion.addActiveRegion(stageRegion);
			nextStage = stageIterator.hasNext() ? stageIterator.next() : null;
			//
			//	non-hazardous LoopStages fold into HeadStage
			//
			while ((nextStage instanceof LoopStage) && !((LoopStage)nextStage).getEdge().isPredicated()) {
				visitor.extend(stageRegion, nextStage, oldRegion);
				nextStage = stageIterator.hasNext() ? stageIterator.next() : null;
			}
			if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
				stageRegion.writeDebugGraphs("4-stage");
			}
		}
		//
		//	LoopStage
		//
		assert nextStage instanceof BodyStage;
		visitor = new BodySplitterVisitor(multiRegion, nextStage, ++stageNumber);
		stageRegion = visitor.create(AbstractRegion.class, oldRegion);
		multiRegion.addActiveRegion(stageRegion);
		if (QVTp2QVTs.DEBUG_GRAPHS.isActive()) {
			stageRegion.writeDebugGraphs("4-stage");
		}
		assert !stageIterator.hasNext();
		multiRegion.removeActiveRegion(oldRegion);
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