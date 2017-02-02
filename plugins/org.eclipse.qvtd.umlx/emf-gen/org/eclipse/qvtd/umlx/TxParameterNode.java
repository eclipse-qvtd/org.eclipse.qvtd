/**
 * Copyright (c) 2016 Willink Transformations and others.
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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tx Parameter Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxParameterNode#getOwningTxQueryNode <em>Owning Tx Query Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxParameterNode()
 * @generated
 */
public interface TxParameterNode extends TxNode, UMLXTypedElement {
	/**
	 * Returns the value of the '<em><b>Owning Tx Query Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxQueryNode#getOwnedTxParameterNodes <em>Owned Tx Parameter Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Tx Query Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Tx Query Node</em>' container reference.
	 * @see #setOwningTxQueryNode(TxQueryNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxParameterNode_OwningTxQueryNode()
	 * @see org.eclipse.qvtd.umlx.TxQueryNode#getOwnedTxParameterNodes
	 * @generated
	 */
	TxQueryNode getOwningTxQueryNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxParameterNode#getOwningTxQueryNode <em>Owning Tx Query Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Tx Query Node</em>' container reference.
	 * @see #getOwningTxQueryNode()
	 * @generated
	 */
	void setOwningTxQueryNode(TxQueryNode value);

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

} // TxParameterNode
