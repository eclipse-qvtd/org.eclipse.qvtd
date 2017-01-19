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
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternExpressionNode;
import org.eclipse.qvtd.umlx.RelPatternClassNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXNamedElement;

import com.google.common.collect.Iterables;

public class UMLXUtil
{
	public static @NonNull Iterable<@NonNull String> getComments(@NonNull UMLXElement umlxElement) {
		return ClassUtil.nullFree(umlxElement.getComments());
	}

	public static @NonNull String getExpression(@NonNull RelPatternExpressionNode relPatternExpressionNode) {
		return ClassUtil.nonNullState(relPatternExpressionNode.getExpression());
	}

	//	public static @NonNull RelDiagram getDiagram(@NonNull RelPatternNode relNode) {
	//		return ClassUtil.nonNullState(relNode.getDiagram());
	//	}

	public static @NonNull Iterable<@NonNull RelPatternEdge> getIncoming(@NonNull RelPatternNode relNode) {
		return Iterables.filter(ClassUtil.nullFree(relNode.getIncoming()), RelPatternEdge.class);
	}

	public static @NonNull RelPatternNode getInvokingRelPatternNode(@NonNull RelInvocationEdge relInvocationEdge) {
		return ClassUtil.nonNullState(relInvocationEdge.getInvokingRelPatternNode());
	}

	public static @NonNull String getName(@NonNull UMLXNamedElement umlxElement) {
		return ClassUtil.nonNullState(umlxElement.getName());
	}

	public static @NonNull Iterable<@NonNull RelPatternEdge> getOutgoing(@NonNull RelPatternClassNode relNode) {
		return Iterables.filter(ClassUtil.nullFree(relNode.getOutgoing()), RelPatternEdge.class);
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

	public static @NonNull Iterable<@NonNull TxPartNode> getOwnedTxPartNodes(@NonNull TxKeyNode txKeyNode) {
		return ClassUtil.nullFree(txKeyNode.getOwnedTxPartNodes());
	}

	public static @NonNull Iterable<@NonNull TxTypedModelNode> getOwnedTxTypedModelNodes(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getOwnedTxTypedModelNodes());
	}

	public static @NonNull RelDiagram getOwningRelDiagram(@NonNull RelInvocationNode relInvocationNode) {
		return ClassUtil.nonNullState(relInvocationNode.getOwningRelDiagram());
	}

	public static @NonNull EClass getReferredEClass(@NonNull TxKeyNode txKeyNode) {
		return ClassUtil.nonNullState(txKeyNode.getReferredEClass());
	}

	public static @NonNull EClassifier getReferredEClassifier(@NonNull RelPatternClassNode relPatternNode) {
		return ClassUtil.nonNullState(relPatternNode.getReferredEClassifier());
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

	public static @NonNull RelPatternClassNode getReferredRelPatternNode(@NonNull RelInvocationEdge relInvocationEdge) {
		return ClassUtil.nonNullState(relInvocationEdge.getReferredRelPatternNode());
	}

	public static @NonNull TxTypedModelNode getReferredTxTypedModelNode(@NonNull RelDomainNode relDomainNode) {
		return ClassUtil.nonNullState(relDomainNode.getReferredTxTypedModelNode());
	}

	public static @NonNull RelPatternClassNode getSource(@NonNull RelPatternEdge relPatternEdge) {
		return ClassUtil.nonNullState(relPatternEdge.getSource());
	}

	public static @NonNull RelPatternNode getTarget(@NonNull RelPatternEdge relPatternEdge) {
		return ClassUtil.nonNullState(relPatternEdge.getTarget());
	}
}