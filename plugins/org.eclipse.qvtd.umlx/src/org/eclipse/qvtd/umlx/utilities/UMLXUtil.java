/*******************************************************************************
 * Copyright (c) 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.utilities;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxParameterNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxQueryNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
import org.eclipse.qvtd.umlx.UMLXTypedElement;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public class UMLXUtil
{
	public static class Internal extends UMLXUtil
	{
		public static @NonNull List<@NonNull RelPatternEdge> getIncomingList(@NonNull RelPatternNode relNode) {
			return ClassUtil.nullFree(relNode.getIncoming());
		}

		public static @NonNull List<@NonNull RelPatternNode> getOwnedRelPatternNodesList(@NonNull RelDomainNode relDomainNode) {
			return ClassUtil.nullFree(relDomainNode.getOwnedRelPatternNodes());
		}
	}

	public static final class IsRootPredicate implements Predicate<@NonNull RelPatternNode>
	{
		public static final @NonNull IsRootPredicate INSTANCE = new IsRootPredicate();

		@Override
		public boolean apply(@NonNull RelPatternNode input) {
			return input.isIsRoot();
		}
	}

	public static final class RelDomainNodeComparator implements Comparator<@NonNull RelDomainNode>
	{
		public static final @NonNull RelDomainNodeComparator INSTANCE = new RelDomainNodeComparator();

		@Override
		public int compare(@NonNull RelDomainNode o1, @NonNull RelDomainNode o2) {
			TxTypedModelNode t1 = o1.getReferredTxTypedModelNode();
			TxTypedModelNode t2 = o2.getReferredTxTypedModelNode();
			String n1 = t1 != null ? t1.getName() : "";
			String n2 = t2 != null ? t2.getName() : "";
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static final class RelPatternNodeComparator implements Comparator<@NonNull RelPatternNode>
	{
		public static final @NonNull RelPatternNodeComparator INSTANCE = new RelPatternNodeComparator();

		@Override
		public int compare(@NonNull RelPatternNode o1, @NonNull RelPatternNode o2) {
			assertClassNode(o1);
			assertClassNode(o2);
			String n1 = o1.getName();
			String n2 = o2.getName();
			return ClassUtil.safeCompareTo(n1, n2);
		}
	}

	public static void assertClassNode(@NonNull RelPatternNode relPatternNode) {
		assert !relPatternNode.isExpression();
		assert relPatternNode.getName() != null;
		assert relPatternNode.getReferredEClassifier() != null;
	}

	public static void assertExpressionNode(@NonNull RelPatternNode relPatternNode) {
		assert relPatternNode.isExpression();
		assert !relPatternNode.getInitExpressionLines().isEmpty();
		assert relPatternNode.getName() == null;
		assert relPatternNode.getOutgoing().isEmpty();
		assert relPatternNode.getReferredEClassifier() == null;
		assert !relPatternNode.isIsRoot();
	}

	public static @NonNull Iterable<@NonNull String> getComments(@NonNull UMLXElement umlxElement) {
		return ClassUtil.nullFree(umlxElement.getComments());
	}

	public static @NonNull Iterable<@NonNull TxTypedModelNode> getDependsOns(@NonNull TxTypedModelNode txTypedModelNode) {
		return ClassUtil.nullFree(txTypedModelNode.getDependsOns());
	}

	public static @NonNull Iterable<@NonNull RelPatternEdge> getIncoming(@NonNull RelPatternNode relNode) {
		return ClassUtil.nullFree(relNode.getIncoming());
	}

	public static @NonNull List<@NonNull String> getInitExpressionLines(@NonNull RelPatternNode relPatternNode) {
		return ClassUtil.nullFree(relPatternNode.getInitExpressionLines());
	}

	public static @NonNull RelPatternNode getInvokingRelPatternNode(@NonNull RelInvocationEdge relInvocationEdge) {
		return ClassUtil.nonNullState(relInvocationEdge.getInvokingRelPatternNode());
	}

	public static @NonNull String getName(@NonNull UMLXNamedElement umlxElement) {
		return ClassUtil.nonNullState(umlxElement.getName());
	}

	public static @NonNull Iterable<@NonNull RelPatternEdge> getOutgoing(@NonNull RelPatternNode relNode) {
		return ClassUtil.nullFree(relNode.getOutgoing());
	}

	public static @NonNull Iterable<@NonNull RelDiagram> getOwnedRelDiagrams(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getOwnedRelDiagrams());
	}

	public static @NonNull Iterable<@NonNull RelDomainNode> getOwnedRelDomainNodes(@NonNull RelDiagram relDiagram) {
		return ClassUtil.nullFree(relDiagram.getOwnedRelDomainNodes());
	}

	public static @NonNull Iterable<@NonNull RelInvocationEdge> getOwnedRelInvocationEdges(@NonNull RelInvocationNode relInvocationNode) {
		return ClassUtil.nullFree(relInvocationNode.getOwnedRelInvocationEdges());
	}

	public static @NonNull Iterable<@NonNull RelInvocationNode> getOwnedRelInvocationNodes(@NonNull RelDiagram relDiagram) {
		return ClassUtil.nullFree(relDiagram.getOwnedRelInvocationNodes());
	}

	public static @NonNull Iterable<@NonNull RelPatternEdge> getOwnedRelPatternEdges(@NonNull RelDomainNode relDomainNode) {
		return ClassUtil.nullFree(relDomainNode.getOwnedRelPatternEdges());
	}

	public static @NonNull Iterable<@NonNull RelPatternNode> getOwnedRelPatternNodes(@NonNull RelDomainNode relDomainNode) {
		return ClassUtil.nullFree(relDomainNode.getOwnedRelPatternNodes());
	}

	public static @NonNull Iterable<@NonNull TxDiagram> getOwnedTxDiagrams(@NonNull UMLXModel umlxModel) {
		return ClassUtil.nullFree(umlxModel.getOwnedTxDiagrams());
	}

	public static @NonNull Iterable<? extends @NonNull TxImportNode> getOwnedTxImportNodes(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getOwnedTxImportNodes());
	}

	public static @NonNull Iterable<@NonNull TxKeyNode> getOwnedTxKeyNodes(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getOwnedTxKeyNodes());
	}

	public static @NonNull Iterable<@NonNull TxPackageNode> getOwnedTxPackageNodes(@NonNull TxTypedModelNode txTypedModelNode) {
		return ClassUtil.nullFree(txTypedModelNode.getOwnedTxPackageNodes());
	}

	public static @NonNull Iterable<@NonNull TxParameterNode> getOwnedTxParameterNodes(@NonNull TxQueryNode txTypedModelNode) {
		return ClassUtil.nullFree(txTypedModelNode.getOwnedTxParameterNodes());
	}

	public static @NonNull Iterable<@NonNull TxPartNode> getOwnedTxPartNodes(@NonNull TxKeyNode txKeyNode) {
		return ClassUtil.nullFree(txKeyNode.getOwnedTxPartNodes());
	}

	public static @NonNull Iterable<@NonNull TxQueryNode> getOwnedTxQueryNodes(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getOwnedTxQueryNodes());
	}

	public static @NonNull Iterable<@NonNull TxTypedModelNode> getOwnedTxTypedModelNodes(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getOwnedTxTypedModelNodes());
	}

	public static @NonNull RelDiagram getOwningRelDiagram(@NonNull RelInvocationNode relInvocationNode) {
		return ClassUtil.nonNullState(relInvocationNode.getOwningRelDiagram());
	}

	public static @NonNull RelDomainNode getOwningRelDomainNode(@NonNull RelPatternNode relPatternNode) {
		return ClassUtil.nonNullState(relPatternNode.getOwningRelDomainNode());
	}

	public static @NonNull EClass getReferredEClass(@NonNull TxKeyNode txKeyNode) {
		return ClassUtil.nonNullState(txKeyNode.getReferredEClass());
	}

	public static @NonNull EClassifier getReferredEClassifier(@NonNull UMLXTypedElement umlxTypedElement) {
		return ClassUtil.nonNullState(umlxTypedElement.getReferredEClassifier());
	}

	public static @NonNull EPackage getReferredEPackage(@NonNull TxPackageNode txPackageNode) {
		return ClassUtil.nonNullState(txPackageNode.getReferredEPackage());
	}

	public static @NonNull EStructuralFeature getReferredEStructuralFeature(@NonNull RelPatternEdge relPatternEdge) {
		return ClassUtil.nonNullState(relPatternEdge.getReferredEStructuralFeature());
	}

	public static @NonNull EStructuralFeature getReferredEStructuralFeature(@NonNull TxPartNode txPartNode) {
		return ClassUtil.nonNullState(txPartNode.getReferredEStructuralFeature());
	}

	public static @NonNull RelDiagram getReferredRelDiagram(@NonNull RelInvocationNode relInvocationNode) {
		return ClassUtil.nonNullState(relInvocationNode.getReferredRelDiagram());
	}

	public static @NonNull RelPatternNode getReferredRelPatternNode(@NonNull RelInvocationEdge relInvocationEdge) {
		return ClassUtil.nonNullState(relInvocationEdge.getReferredRelPatternNode());
	}

	public static @NonNull TxTypedModelNode getReferredTxTypedModelNode(@NonNull RelDomainNode relDomainNode) {
		return ClassUtil.nonNullState(relDomainNode.getReferredTxTypedModelNode());
	}

	private static @NonNull Iterable<@NonNull RelPatternNode> getRootPatternClassNodes(@NonNull RelDomainNode relDomainNode) {
		Iterable<@NonNull RelPatternNode> nullFree = ClassUtil.nullFree(relDomainNode.getOwnedRelPatternNodes());
		return Iterables.filter(nullFree, IsRootPredicate.INSTANCE);
	}

	public static @NonNull RelPatternNode getSource(@NonNull RelPatternEdge relPatternEdge) {
		return ClassUtil.nonNullState(relPatternEdge.getSource());
	}

	public static @NonNull RelPatternNode getTarget(@NonNull RelPatternEdge relPatternEdge) {
		return ClassUtil.nonNullState(relPatternEdge.getTarget());
	}

	public static @NonNull List<@NonNull RelInvocationEdge> getSortedInvocationEdges(@NonNull RelInvocationNode relInvocationNode) {
		final Map<@NonNull RelPatternNode, @NonNull Integer> node2index = new HashMap<>();
		List<@NonNull RelDomainNode> sortedRelDomainNodes = Lists.newArrayList(UMLXUtil.getOwnedRelDomainNodes(UMLXUtil.getReferredRelDiagram(relInvocationNode)));
		Collections.sort(sortedRelDomainNodes, RelDomainNodeComparator.INSTANCE);
		for (@NonNull RelDomainNode relDomainNode : sortedRelDomainNodes) {
			List<@NonNull RelPatternNode> sortedRootNodes = Lists.newArrayList(getRootPatternClassNodes(relDomainNode));
			Collections.sort(sortedRootNodes, RelPatternNodeComparator.INSTANCE);
			for (@NonNull RelPatternNode relPatternClassNode : sortedRootNodes) {
				node2index.put(relPatternClassNode, node2index.size());
			}
		}
		List<@NonNull RelInvocationEdge> sortedEdges = Lists.newArrayList(getOwnedRelInvocationEdges(relInvocationNode));
		Collections.sort(sortedEdges, new Comparator<@NonNull RelInvocationEdge>()
		{
			@Override
			public int compare(@NonNull RelInvocationEdge o1, @NonNull RelInvocationEdge o2) {
				Integer i1 = node2index.get(o1.getReferredRelPatternNode());
				Integer i2 = node2index.get(o2.getReferredRelPatternNode());
				assert (i1 != null) && (i2 != null);
				return i1 - i2;
			}
		});
		return sortedEdges;
	}
}