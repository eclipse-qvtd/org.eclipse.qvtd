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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tx Import Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxImportNode#getUri <em>Uri</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxImportNode#getTxDiagram <em>Tx Diagram</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxImportNode()
 * @generated
 */
public interface TxImportNode extends TxNode, UMLXNamedElement {
	/**
	 * Returns the value of the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uri</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uri</em>' attribute.
	 * @see #setUri(String)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxImportNode_Uri()
	 * @generated
	 */
	String getUri();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxImportNode#getUri <em>Uri</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uri</em>' attribute.
	 * @see #getUri()
	 * @generated
	 */
	void setUri(String value);

	/**
	 * Returns the value of the '<em><b>Tx Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxDiagram#getTxImportNodes <em>Tx Import Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Diagram</em>' container reference.
	 * @see #setTxDiagram(TxDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxImportNode_TxDiagram()
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getTxImportNodes
	 * @generated
	 */
	TxDiagram getTxDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxImportNode#getTxDiagram <em>Tx Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tx Diagram</em>' container reference.
	 * @see #getTxDiagram()
	 * @generated
	 */
	void setTxDiagram(TxDiagram value);

} // TxImportNode
