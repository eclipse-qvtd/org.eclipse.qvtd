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
package org.eclipse.qvtd.compiler.internal.qvts2qvti.splitter;

import java.util.LinkedHashMap;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Edge;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.Node;

/**
 * A Split captures the result of the analysis that enables a multi-headed region to be split.
 */
public class Split
{
	/**
	 * The head nodes of each region in navigation order and the edge that enables each head to be
	 * reached from earlier heads. The first head has a null edge.
	 */
	protected final @NonNull LinkedHashMap<@NonNull Node, @Nullable Edge> headNode2edge = new LinkedHashMap<>();

	public void addSimpleGroup(@NonNull SimpleGroup simpleGroup, @Nullable Edge edge) {
		Node headNode = simpleGroup.getHeadNode();
		assert !headNode2edge.containsKey(headNode);
		headNode2edge.put(headNode, edge);
	}

	public void toString(@NonNull StringBuilder s, int depth) {
		SplitterUtil.indent(s, depth);
		for (@NonNull Node node : headNode2edge.keySet()) {
			Edge edge = headNode2edge.get(node);
			if (edge != null) {
				s.append("\n");
				SplitterUtil.indent(s, depth+1);
				s.append(edge.isComputation() ? "forward-edge : " : "reverse-edge : ");
				s.append(edge.getName());
				s.append(" : ");
				s.append(edge);
			}
			s.append("\n");
			SplitterUtil.indent(s, depth+1);
			s.append("head-node : ");
			s.append(node.getName());
			s.append(" : ");
			s.append(node);
		}
	}
}