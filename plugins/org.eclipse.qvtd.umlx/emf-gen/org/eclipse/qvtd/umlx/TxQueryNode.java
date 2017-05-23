/**
 * Copyright (c) 2016, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tx Query Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxQueryNode#getInitExpressionLines <em>Init Expression Lines</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxQueryNode#getOwnedTxParameterNodes <em>Owned Tx Parameter Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxQueryNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxQueryNode()
 * @generated
 */
public interface TxQueryNode extends TxNode, UMLXTypedElement {
	/**
	 * Returns the value of the '<em><b>Init Expression Lines</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression Lines</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expression Lines</em>' attribute list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxQueryNode_InitExpressionLines()
	 * @generated
	 */
	EList<String> getInitExpressionLines();

	/**
	 * Returns the value of the '<em><b>Owned Tx Parameter Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxParameterNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxParameterNode#getOwningTxQueryNode <em>Owning Tx Query Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tx Parameter Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tx Parameter Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxQueryNode_OwnedTxParameterNodes()
	 * @see org.eclipse.qvtd.umlx.TxParameterNode#getOwningTxQueryNode
	 * @generated
	 */
	EList<TxParameterNode> getOwnedTxParameterNodes();

	/**
	 * Returns the value of the '<em><b>Owning Tx Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxQueryNodes <em>Owned Tx Query Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Tx Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Tx Diagram</em>' container reference.
	 * @see #setOwningTxDiagram(TxDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxQueryNode_OwningTxDiagram()
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxQueryNodes
	 * @generated
	 */
	TxDiagram getOwningTxDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxQueryNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Tx Diagram</em>' container reference.
	 * @see #getOwningTxDiagram()
	 * @generated
	 */
	void setOwningTxDiagram(TxDiagram value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateNameIsRequired(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateTypeIsRequired(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateParametersAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

} // TxQueryNode
