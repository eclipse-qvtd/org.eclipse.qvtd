/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.umlx.utilities;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.LabelUtil;
import org.eclipse.qvtd.umlx.RelPatternExpressionNode;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternClassNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
import org.eclipse.qvtd.umlx.util.AbstractExtendingUMLXVisitor;

public class UMLXToStringVisitor extends AbstractExtendingUMLXVisitor<@Nullable Object, @NonNull StringBuilder>
{
	public static @NonNull String toString(@NonNull UMLXElement umlxElement) {
		UMLXToStringVisitor umlxToStringVisitor = new UMLXToStringVisitor();
		umlxElement.accept(umlxToStringVisitor);
		return umlxToStringVisitor.toString();
	}

	protected UMLXToStringVisitor() {
		super(new StringBuilder());
	}

	private void append(@Nullable String string) {
		context.append(string != null ? string : "null");
	}

	@Override
	public @NonNull String toString() {
		return context.toString();
	}

	@Override
	public @Nullable Object visitRelDomainNode(@NonNull RelDomainNode relDomainNode) {
		TxTypedModelNode txTypedModelNode = relDomainNode.getReferredTxTypedModelNode();
		append(txTypedModelNode != null ? txTypedModelNode.getName() : null);
		return null;
	}

	@Override
	public @Nullable Object visitRelInvocationEdge(@NonNull RelInvocationEdge relInvocationEdge) {
		RelPatternClassNode relPatternNode = relInvocationEdge.getReferredRelPatternNode();
		if (relPatternNode != null) {
			return relPatternNode.accept(this);
		}
		append(null);
		return null;
	}

	@Override
	public @Nullable Object visitRelInvocationNode(@NonNull RelInvocationNode relInvocationNode) {
		RelDiagram relDiagram = relInvocationNode.getReferredRelDiagram();
		append(relDiagram != null ? relDiagram.getName() : null);
		return null;
	}

	@Override
	public @Nullable Object visitRelPatternClassNode(@NonNull RelPatternClassNode relPatternClassNode) {
		EClassifier eClassifier = relPatternClassNode.getReferredEClassifier();
		append(LabelUtil.getLabel(eClassifier));
		return null;
	}

	@Override
	public @Nullable Object visitRelPatternEdge(@NonNull RelPatternEdge relPatternEdge) {
		EStructuralFeature eStructuralFeature = relPatternEdge.getReferredEStructuralFeature();
		append(LabelUtil.getLabel(eStructuralFeature));
		return null;
	}

	@Override
	public @Nullable Object visitRelPatternExpressionNode(@NonNull RelPatternExpressionNode relPatternExpressionNode) {
		String expression = relPatternExpressionNode.getExpression();
		append(expression);
		return null;
	}

	@Override
	public @Nullable Object visitTxKeyNode(@NonNull TxKeyNode txKeyNode) {
		EClassifier eClassifier = txKeyNode.getReferredEClass();
		append(LabelUtil.getLabel(eClassifier));
		return null;
	}

	@Override
	public @Nullable Object visitTxPackageNode(@NonNull TxPackageNode txPackageNode) {
		EPackage ePackage = txPackageNode.getReferredEPackage();
		append(LabelUtil.getLabel(ePackage));
		return null;
	}

	@Override
	public @Nullable Object visitTxPartNode(@NonNull TxPartNode txPartNode) {
		EStructuralFeature eStructuralFeature = txPartNode.getReferredEStructuralFeature();
		if (txPartNode.isIsOpposite()) {
			append("~");
		}
		append(LabelUtil.getLabel(eStructuralFeature));
		return null;
	}

	@Override
	public @Nullable Object visitUMLXModel(@NonNull UMLXModel umlxModel) {
		return "UMLXModel";
	}

	@Override
	public @Nullable Object visitUMLXNamedElement(@NonNull UMLXNamedElement umlxNamedElement) {
		String name = umlxNamedElement.getName();
		append(name);
		return null;
	}

	@Override
	public @Nullable Object visiting(@NonNull UMLXElement umlxElement) {
		append("Unsupported " + getClass().getSimpleName() + " for " + umlxElement.eClass().getName());
		return null;
	}
}
