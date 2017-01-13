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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tx Key Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxKeyNode#getTxTransformationNode <em>Tx Transformation Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxKeyNode#getReferredClass <em>Referred Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxKeyNode#getTxPartNodes <em>Tx Part Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxKeyNode()
 * @generated
 */
public interface TxKeyNode extends TxNode {
	/**
	 * Returns the value of the '<em><b>Tx Transformation Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxTransformationNode#getTxKeyNodes <em>Tx Key Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Transformation Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Transformation Node</em>' container reference.
	 * @see #setTxTransformationNode(TxTransformationNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxKeyNode_TxTransformationNode()
	 * @see org.eclipse.qvtd.umlx.TxTransformationNode#getTxKeyNodes
	 * @generated
	 */
	TxTransformationNode getTxTransformationNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxKeyNode#getTxTransformationNode <em>Tx Transformation Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tx Transformation Node</em>' container reference.
	 * @see #getTxTransformationNode()
	 * @generated
	 */
	void setTxTransformationNode(TxTransformationNode value);

	/**
	 * Returns the value of the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Class</em>' reference.
	 * @see #setReferredClass(EClassifier)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxKeyNode_ReferredClass()
	 * @generated
	 */
	EClassifier getReferredClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxKeyNode#getReferredClass <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Class</em>' reference.
	 * @see #getReferredClass()
	 * @generated
	 */
	void setReferredClass(EClassifier value);

	/**
	 * Returns the value of the '<em><b>Tx Part Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxPartNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxPartNode#getTxKeyNode <em>Tx Key Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Part Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Part Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxKeyNode_TxPartNodes()
	 * @see org.eclipse.qvtd.umlx.TxPartNode#getTxKeyNode
	 * @generated
	 */
	EList<TxPartNode> getTxPartNodes();

} // TxKeyNode
