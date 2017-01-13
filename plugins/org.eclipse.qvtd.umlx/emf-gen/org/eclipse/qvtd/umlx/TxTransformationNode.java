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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tx Transformation Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTransformationNode#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTransformationNode#getTxTypedModelNodes <em>Tx Typed Model Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTransformationNode#getTxKeyNodes <em>Tx Key Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTransformationNode()
 * @generated
 */
public interface TxTransformationNode extends TxNode {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTransformationNode_Name()
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxTransformationNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Tx Typed Model Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxTypedModelNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getTxTransformationNode <em>Tx Transformation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Typed Model Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Typed Model Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTransformationNode_TxTypedModelNodes()
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getTxTransformationNode
	 * @generated
	 */
	EList<TxTypedModelNode> getTxTypedModelNodes();

	/**
	 * Returns the value of the '<em><b>Tx Key Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxKeyNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxKeyNode#getTxTransformationNode <em>Tx Transformation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Key Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Key Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTransformationNode_TxKeyNodes()
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#getTxTransformationNode
	 * @generated
	 */
	EList<TxKeyNode> getTxKeyNodes();

} // TxTransformationNode
