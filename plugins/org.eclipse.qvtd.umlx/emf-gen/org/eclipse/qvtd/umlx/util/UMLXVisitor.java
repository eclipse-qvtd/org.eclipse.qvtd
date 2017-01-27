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
import org.eclipse.jdt.annotation.Nullable;

/**
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface UMLXVisitor<R>
{
	/**
	 * Returns an object which is an instance of the given class
	 * associated with this object. Returns <code>null</code> if
	 * no such object can be found.
	 *
	 * @param adapter the adapter class to look up
	 * @return an object of the given class,
	 *    or <code>null</code> if this object does not
	 *    have an adapter for the given class
	 */
	@Nullable <A> A getAdapter(@NonNull Class<A> adapter);

	/**
	 * Return the result of visiting a visitable for which no more specific pivot type method
	 * is available.
	 */
	R visiting(org.eclipse.qvtd.umlx.@NonNull UMLXElement visitable);

	R visitRelDiagram(org.eclipse.qvtd.umlx.@NonNull RelDiagram object);
	R visitRelDomainNode(org.eclipse.qvtd.umlx.@NonNull RelDomainNode object);
	R visitRelEdge(org.eclipse.qvtd.umlx.@NonNull RelEdge object);
	R visitRelInvocationEdge(org.eclipse.qvtd.umlx.@NonNull RelInvocationEdge object);
	R visitRelInvocationNode(org.eclipse.qvtd.umlx.@NonNull RelInvocationNode object);
	R visitRelNode(org.eclipse.qvtd.umlx.@NonNull RelNode object);
	R visitRelPatternClassNode(org.eclipse.qvtd.umlx.@NonNull RelPatternClassNode object);
	R visitRelPatternEdge(org.eclipse.qvtd.umlx.@NonNull RelPatternEdge object);
	R visitRelPatternExpressionNode(org.eclipse.qvtd.umlx.@NonNull RelPatternExpressionNode object);
	R visitRelPatternNode(org.eclipse.qvtd.umlx.@NonNull RelPatternNode object);
	R visitTxDiagram(org.eclipse.qvtd.umlx.@NonNull TxDiagram object);
	R visitTxImportNode(org.eclipse.qvtd.umlx.@NonNull TxImportNode object);
	R visitTxKeyNode(org.eclipse.qvtd.umlx.@NonNull TxKeyNode object);
	R visitTxNode(org.eclipse.qvtd.umlx.@NonNull TxNode object);
	R visitTxPackageNode(org.eclipse.qvtd.umlx.@NonNull TxPackageNode object);
	R visitTxParameterNode(org.eclipse.qvtd.umlx.@NonNull TxParameterNode object);
	R visitTxPartNode(org.eclipse.qvtd.umlx.@NonNull TxPartNode object);
	R visitTxQueryNode(org.eclipse.qvtd.umlx.@NonNull TxQueryNode object);
	R visitTxTypedModelNode(org.eclipse.qvtd.umlx.@NonNull TxTypedModelNode object);
	R visitUMLXElement(org.eclipse.qvtd.umlx.@NonNull UMLXElement object);
	R visitUMLXModel(org.eclipse.qvtd.umlx.@NonNull UMLXModel object);
	R visitUMLXNamedElement(org.eclipse.qvtd.umlx.@NonNull UMLXNamedElement object);
	R visitUMLXTypedElement(org.eclipse.qvtd.umlx.@NonNull UMLXTypedElement object);
}
