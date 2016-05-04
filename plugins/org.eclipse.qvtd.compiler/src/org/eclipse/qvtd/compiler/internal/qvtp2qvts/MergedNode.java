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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.TypedElement;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * MergedNode provides the merge of multiple non-merged nodes as part of a MergedRegion.
 */
public class MergedNode extends AbstractNode
{
	private static final class NodeToTypedElementsFunction implements Function<@NonNull Node, @NonNull Iterable<@NonNull TypedElement>>
	{
		public static final @NonNull NodeToTypedElementsFunction INSTANCE = new NodeToTypedElementsFunction();

		@Override
		public @NonNull Iterable<@NonNull TypedElement> apply(@NonNull Node node) {
			return node.getTypedElements();
		}
	}

	protected final @NonNull List<@NonNull SimpleNode> simpleNodes = new ArrayList<@NonNull SimpleNode>();
//	private @Nullable MergedNode recursionNode = null;

	public MergedNode(@NonNull MergedMappingRegion mergedRegion, @NonNull Node node) {
		super(node.getNodeRole(), mergedRegion, node.getName(), node.getClassDatumAnalysis());
	}

	public void addNode(@NonNull SimpleNode node) {
		CompleteClass completeClass1 = getCompleteClass();
		SimpleNode simpleNode = node;
		CompleteClass completeClass2 = simpleNode.getCompleteClass();
		assert completeClass1 == completeClass2;
		assert !simpleNodes.contains(simpleNode);
		simpleNodes.add(simpleNode);
		mergeRole(simpleNode.getNodeRole());
	}

	public @NonNull Iterable<SimpleNode> getNodes() {
		return simpleNodes;
	}

//	public @Nullable MergedNode getRecursionNode() {
//		return recursionNode;
//	}

	@Override
	public @NonNull Iterable<@NonNull SimpleNode> getSimpleNodes() {
		return simpleNodes;
	}

	@Override
	public @NonNull Iterable<@NonNull TypedElement> getTypedElements() {
		@NonNull Iterable<@NonNull Iterable<@NonNull TypedElement>> transform = Iterables.transform(simpleNodes, NodeToTypedElementsFunction.INSTANCE);
		@NonNull Iterable<@NonNull TypedElement> concat = Iterables.concat(transform);
		return concat;
	}

	public void setRecursion(@NonNull MergedNode recursionNode) {
//		this.recursionNode  = recursionNode;
	}

//	@Override
//	public String toString() {
//		return introductoryNode != null ? introductoryNode.toString() : super.toString();
//	}
}