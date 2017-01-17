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
 * A representation of the model object '<em><b>Tx Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedDiagrams <em>Owned Diagrams</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getPackage <em>Package</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getTxImportNodes <em>Tx Import Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getTxKeyNodes <em>Tx Key Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getTxTypedModelNodes <em>Tx Typed Model Nodes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram()
 * @generated
 */
public interface TxDiagram extends UMLXDiagram {
	/**
	 * Returns the value of the '<em><b>Owned Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.RelDiagram}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelDiagram#getTxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Diagrams</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram_OwnedDiagrams()
	 * @see org.eclipse.qvtd.umlx.RelDiagram#getTxDiagram
	 * @generated
	 */
	EList<RelDiagram> getOwnedDiagrams();

	/**
	 * Returns the value of the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' attribute.
	 * @see #setPackage(String)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram_Package()
	 * @generated
	 */
	String getPackage();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxDiagram#getPackage <em>Package</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' attribute.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(String value);

	/**
	 * Returns the value of the '<em><b>Tx Import Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxImportNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxImportNode#getTxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Import Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Import Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram_TxImportNodes()
	 * @see org.eclipse.qvtd.umlx.TxImportNode#getTxDiagram
	 * @generated
	 */
	EList<TxImportNode> getTxImportNodes();

	/**
	 * Returns the value of the '<em><b>Tx Key Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxKeyNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxKeyNode#getTxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Key Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Key Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram_TxKeyNodes()
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#getTxDiagram
	 * @generated
	 */
	EList<TxKeyNode> getTxKeyNodes();

	/**
	 * Returns the value of the '<em><b>Tx Typed Model Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxTypedModelNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getTxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Typed Model Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Typed Model Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram_TxTypedModelNodes()
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getTxDiagram
	 * @generated
	 */
	EList<TxTypedModelNode> getTxTypedModelNodes();

} // TxDiagram
