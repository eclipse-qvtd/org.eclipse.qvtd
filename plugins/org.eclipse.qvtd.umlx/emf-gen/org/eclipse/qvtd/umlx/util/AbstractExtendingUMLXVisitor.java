/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * This code is auto-generated
 * from: org.eclipse.qvtd.umlx/model/UMLX.genmodel
 *
 * Only the copyright statement is editable.
 *******************************************************************************/
package	org.eclipse.qvtd.umlx.util;

import org.eclipse.jdt.annotation.NonNull;

/**
 * An AbstractExtendingUMLXVisitor provides a default implementation for each
 * visitXxx method that delegates to the visitYyy method of the first
 * super class, (or transitively its first super class' first super class
 * until a non-interface super-class is found). In the absence of any
 * suitable first super class, the method delegates to visiting().
 */
public abstract class AbstractExtendingUMLXVisitor<R, C>
	extends AbstractUMLXVisitor<R, C>
	implements UMLXVisitor<R>
{
	/**
	 * Initializes me with an initial value for my result.
	 *
	 * @param context my initial result value
	 */
	protected AbstractExtendingUMLXVisitor(C context) {
		super(context);
	}

	@Override
	public R visitRelDiagram(org.eclipse.qvtd.umlx.@NonNull RelDiagram object) {
		return visitUMLXNamedElement(object);
	}

	@Override
	public R visitRelDomainNode(org.eclipse.qvtd.umlx.@NonNull RelDomainNode object) {
		return visitRelNode(object);
	}

	@Override
	public R visitRelEdge(org.eclipse.qvtd.umlx.@NonNull RelEdge object) {
		return visitUMLXElement(object);
	}

	@Override
	public R visitRelInvocationEdge(org.eclipse.qvtd.umlx.@NonNull RelInvocationEdge object) {
		return visitRelEdge(object);
	}

	@Override
	public R visitRelInvocationNode(org.eclipse.qvtd.umlx.@NonNull RelInvocationNode object) {
		return visitRelNode(object);
	}

	@Override
	public R visitRelNode(org.eclipse.qvtd.umlx.@NonNull RelNode object) {
		return visitUMLXElement(object);
	}

	@Override
	public R visitRelPatternEdge(org.eclipse.qvtd.umlx.@NonNull RelPatternEdge object) {
		return visitRelEdge(object);
	}

	@Override
	public R visitRelPatternNode(org.eclipse.qvtd.umlx.@NonNull RelPatternNode object) {
		return visitRelNode(object);
	}

	@Override
	public R visitTxDiagram(org.eclipse.qvtd.umlx.@NonNull TxDiagram object) {
		return visitUMLXNamedElement(object);
	}

	@Override
	public R visitTxImportNode(org.eclipse.qvtd.umlx.@NonNull TxImportNode object) {
		return visitTxNode(object);
	}

	@Override
	public R visitTxKeyNode(org.eclipse.qvtd.umlx.@NonNull TxKeyNode object) {
		return visitTxNode(object);
	}

	@Override
	public R visitTxNode(org.eclipse.qvtd.umlx.@NonNull TxNode object) {
		return visitUMLXElement(object);
	}

	@Override
	public R visitTxPackageNode(org.eclipse.qvtd.umlx.@NonNull TxPackageNode object) {
		return visitTxNode(object);
	}

	@Override
	public R visitTxParameterNode(org.eclipse.qvtd.umlx.@NonNull TxParameterNode object) {
		return visitTxNode(object);
	}

	@Override
	public R visitTxPartNode(org.eclipse.qvtd.umlx.@NonNull TxPartNode object) {
		return visitTxNode(object);
	}

	@Override
	public R visitTxQueryNode(org.eclipse.qvtd.umlx.@NonNull TxQueryNode object) {
		return visitTxNode(object);
	}

	@Override
	public R visitTxTypedModelNode(org.eclipse.qvtd.umlx.@NonNull TxTypedModelNode object) {
		return visitTxNode(object);
	}

	@Override
	public R visitUMLXElement(org.eclipse.qvtd.umlx.@NonNull UMLXElement object) {
		return visiting(object);
	}

	@Override
	public R visitUMLXModel(org.eclipse.qvtd.umlx.@NonNull UMLXModel object) {
		return visitUMLXElement(object);
	}

	@Override
	public R visitUMLXNamedElement(org.eclipse.qvtd.umlx.@NonNull UMLXNamedElement object) {
		return visitUMLXElement(object);
	}

	@Override
	public R visitUMLXTypedElement(org.eclipse.qvtd.umlx.@NonNull UMLXTypedElement object) {
		return visitUMLXNamedElement(object);
	}
}
