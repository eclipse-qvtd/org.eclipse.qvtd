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
 * A representation of the model object '<em><b>Tx Typed Model Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getTxTransformationNode <em>Tx Transformation Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getTxPackageNodes <em>Tx Package Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isCheck <em>Check</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isEnforce <em>Enforce</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode()
 * @generated
 */
public interface TxTypedModelNode extends TxNode {
	/**
	 * Returns the value of the '<em><b>Tx Transformation Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxTransformationNode#getTxTypedModelNodes <em>Tx Typed Model Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Transformation Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Transformation Node</em>' container reference.
	 * @see #setTxTransformationNode(TxTransformationNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_TxTransformationNode()
	 * @see org.eclipse.qvtd.umlx.TxTransformationNode#getTxTypedModelNodes
	 * @generated
	 */
	TxTransformationNode getTxTransformationNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getTxTransformationNode <em>Tx Transformation Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tx Transformation Node</em>' container reference.
	 * @see #getTxTransformationNode()
	 * @generated
	 */
	void setTxTransformationNode(TxTransformationNode value);

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
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_Name()
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Tx Package Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxPackageNode}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Package Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Package Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_TxPackageNodes()
	 * @generated
	 */
	EList<TxPackageNode> getTxPackageNodes();

	/**
	 * Returns the value of the '<em><b>Check</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check</em>' attribute.
	 * @see #setCheck(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_Check()
	 * @generated
	 */
	boolean isCheck();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isCheck <em>Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check</em>' attribute.
	 * @see #isCheck()
	 * @generated
	 */
	void setCheck(boolean value);

	/**
	 * Returns the value of the '<em><b>Enforce</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enforce</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enforce</em>' attribute.
	 * @see #setEnforce(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxTypedModelNode_Enforce()
	 * @generated
	 */
	boolean isEnforce();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isEnforce <em>Enforce</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enforce</em>' attribute.
	 * @see #isEnforce()
	 * @generated
	 */
	void setEnforce(boolean value);

} // TxTypedModelNode
