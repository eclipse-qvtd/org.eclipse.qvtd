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

import java.util.Collections;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;

/**
 * A SimpleGroup encompasses a head node and its reachable nodes.
 */
class SimpleGroup extends AbstractGroup
{
	/**
	 * The head node of the simple group.
	 */
	protected final @NonNull Node headNode;

	public SimpleGroup(@NonNull SplitterAnalysis splitter, @NonNull Node headNode) {
		super(splitter, Collections.singletonList(headNode));
		this.headNode = headNode;
	}

	@Override
	public void computeMutualOrdering(@NonNull Iterable<@NonNull SimpleGroup> externalSimpleGroups) {}

	@Override
	protected void buildSplit(@NonNull Split split, @Nullable SimpleGroup sourceSimpleGroup, @Nullable Edge edge) {
		split.addStage(sourceSimpleGroup, edge, this);
		buildSplit(split, this);
	}

	public @NonNull Node getHeadNode() {
		return headNode;
	}

	@Override
	public @NonNull Iterable<@NonNull Node> getHeadNodes() {
		return Collections.singletonList(headNode);
	}

	@Override
	public @NonNull Iterable<@NonNull SimpleGroup> getInternalSimpleGroups() {
		return Collections.singletonList(this);
	}

	@Override
	public void toString(@NonNull StringBuilder s, int depth) {
		CompilerUtil.indent(s, depth);
		s.append("simple-group: ");
		s.append(name);
		super.toString(s, depth);
	}
}