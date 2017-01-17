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
import org.eclipse.qvtd.umlx.RelNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
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

	public static @NonNull RelDiagram getDiagram(@NonNull RelNode relNode) {
		return ClassUtil.nonNullState(relNode.getDiagram());
	}

	public static @NonNull Iterable<@NonNull RelPatternEdge> getIncomingEdges(@NonNull RelPatternNode relNode) {
		return Iterables.filter(ClassUtil.nullFree(relNode.getIncomingEdges()), RelPatternEdge.class);
	}

	public static @NonNull String getName(@NonNull UMLXNamedElement umlxElement) {
		return ClassUtil.nonNullState(umlxElement.getName());
	}

	public static @NonNull Iterable<@NonNull RelPatternEdge> getOutgoingEdges(@NonNull RelPatternNode relNode) {
		return Iterables.filter(ClassUtil.nullFree(relNode.getOwnedOutgoingEdges()), RelPatternEdge.class);
	}

	public static @NonNull Iterable<@NonNull RelDiagram> getOwnedDiagrams(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getOwnedDiagrams());
	}

	public static @NonNull Iterable<@NonNull TxDiagram> getOwnedDiagrams(@NonNull UMLXModel umlxModel) {
		return ClassUtil.nullFree(umlxModel.getOwnedDiagrams());
	}

	//	public static @NonNull Iterable<@NonNull RelPatternEdge> getOwnedEdges(@NonNull RelDiagram relDiagram) {
	//		return ClassUtil.nullFree(relDiagram.getOwnedEdges());
	//	}

	public static @NonNull Iterable<@NonNull RelNode> getOwnedNodes(@NonNull RelDiagram relDiagram) {
		return ClassUtil.nullFree(relDiagram.getOwnedNodes());
	}

	public static @NonNull EClass getReferredClass(@NonNull TxKeyNode txKeyNode) {
		return ClassUtil.nonNullState(txKeyNode.getReferredClass());
	}

	public static @NonNull EClassifier getReferredClassifier(@NonNull RelPatternNode relPatternNode) {
		return ClassUtil.nonNullState(relPatternNode.getReferredClass());
	}

	public static @NonNull EPackage getReferredPackage(@NonNull TxPackageNode txPackageNode) {
		return ClassUtil.nonNullState(txPackageNode.getReferredPackage());
	}

	public static @NonNull EStructuralFeature getReferredProperty(@NonNull RelPatternEdge relPatternEdge) {
		return ClassUtil.nonNullState(relPatternEdge.getReferredProperty());
	}

	public static @NonNull EStructuralFeature getReferredProperty(@NonNull TxPartNode txPartNode) {
		return ClassUtil.nonNullState(txPartNode.getReferredProperty());
	}

	public static @NonNull RelDiagram getReferredRelDiagram(@NonNull RelInvocationNode relInvocationNode) {
		return ClassUtil.nonNullState(relInvocationNode.getReferredRelDiagram());
	}

	public static @NonNull RelPatternNode getReferredRelPatternNode(@NonNull RelInvocationEdge relInvocationEdge) {
		return ClassUtil.nonNullState(relInvocationEdge.getReferredRelPatternNode());
	}

	public static @NonNull TxTypedModelNode getReferredTypedModelNode(@NonNull RelDomainNode relDomainNode) {
		return ClassUtil.nonNullState(relDomainNode.getReferredTypedModelNode());
	}

	public static @NonNull Iterable<@NonNull RelPatternNode> getRootPatternNodes(@NonNull RelDomainNode relDomainNode) {
		return ClassUtil.nullFree(relDomainNode.getRootPatternNodes());
	}

	public static @NonNull RelPatternNode getSource(@NonNull RelPatternEdge relPatternEdge) {
		return (RelPatternNode) ClassUtil.nonNullState(relPatternEdge.getOwningSource());
	}

	public static @NonNull RelPatternNode getTarget(@NonNull RelInvocationEdge relInvocationEdge) {
		return (RelPatternNode) ClassUtil.nonNullState(relInvocationEdge.getTarget());
	}

	public static @NonNull RelPatternNode getTarget(@NonNull RelPatternEdge relPatternEdge) {
		return (RelPatternNode) ClassUtil.nonNullState(relPatternEdge.getTarget());
	}

	public static @NonNull Iterable<? extends @NonNull TxImportNode> getTxImportNodes(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getTxImportNodes());
	}

	public static @NonNull Iterable<@NonNull TxKeyNode> getTxKeyNodes(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getTxKeyNodes());
	}

	public static @NonNull Iterable<@NonNull TxPackageNode> getTxPackageNodes(@NonNull TxTypedModelNode txTypedModelNode) {
		return ClassUtil.nullFree(txTypedModelNode.getTxPackageNodes());
	}

	public static @NonNull Iterable<@NonNull TxPartNode> getTxPartNodes(@NonNull TxKeyNode txKeyNode) {
		return ClassUtil.nullFree(txKeyNode.getTxPartNodes());
	}

	public static @NonNull Iterable<@NonNull TxTypedModelNode> getTxTypedModelNodes(@NonNull TxDiagram txDiagram) {
		return ClassUtil.nullFree(txDiagram.getTxTypedModelNodes());
	}
}