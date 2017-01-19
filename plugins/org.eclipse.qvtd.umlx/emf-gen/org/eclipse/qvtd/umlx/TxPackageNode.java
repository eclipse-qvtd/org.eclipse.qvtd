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

import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tx Package Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxPackageNode#getReferredEPackage <em>Referred EPackage</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxPackageNode#getOwningTxTypedModelNode <em>Owning Tx Typed Model Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxPackageNode()
 * @generated
 */
public interface TxPackageNode extends TxNode {
	/**
	 * Returns the value of the '<em><b>Referred EPackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred EPackage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred EPackage</em>' reference.
	 * @see #setReferredEPackage(EPackage)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxPackageNode_ReferredEPackage()
	 * @generated
	 */
	EPackage getReferredEPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxPackageNode#getReferredEPackage <em>Referred EPackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred EPackage</em>' reference.
	 * @see #getReferredEPackage()
	 * @generated
	 */
	void setReferredEPackage(EPackage value);

	/**
	 * Returns the value of the '<em><b>Owning Tx Typed Model Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getOwnedTxPackageNodes <em>Owned Tx Package Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Tx Typed Model Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Tx Typed Model Node</em>' container reference.
	 * @see #setOwningTxTypedModelNode(TxTypedModelNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxPackageNode_OwningTxTypedModelNode()
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getOwnedTxPackageNodes
	 * @generated
	 */
	TxTypedModelNode getOwningTxTypedModelNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxPackageNode#getOwningTxTypedModelNode <em>Owning Tx Typed Model Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Tx Typed Model Node</em>' container reference.
	 * @see #getOwningTxTypedModelNode()
	 * @generated
	 */
	void setOwningTxTypedModelNode(TxTypedModelNode value);

} // TxPackageNode
