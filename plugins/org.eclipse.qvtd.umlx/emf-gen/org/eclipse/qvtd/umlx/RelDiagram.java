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
 * A representation of the model object '<em><b>Rel Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDiagram#isIsTop <em>Is Top</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDiagram#getOwnedNodes <em>Owned Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDiagram#getTxDiagram <em>Tx Diagram</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDiagram()
 * @generated
 */
public interface RelDiagram extends UMLXDiagram {

	/**
	 * Returns the value of the '<em><b>Is Top</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Top</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Top</em>' attribute.
	 * @see #setIsTop(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDiagram_IsTop()
	 * @generated
	 */
	boolean isIsTop();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelDiagram#isIsTop <em>Is Top</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Top</em>' attribute.
	 * @see #isIsTop()
	 * @generated
	 */
	void setIsTop(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.RelNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelNode#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDiagram_OwnedNodes()
	 * @see org.eclipse.qvtd.umlx.RelNode#getDiagram
	 * @generated
	 */
	EList<RelNode> getOwnedNodes();

	/**
	 * Returns the value of the '<em><b>Tx Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedDiagrams <em>Owned Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tx Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tx Diagram</em>' container reference.
	 * @see #setTxDiagram(TxDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDiagram_TxDiagram()
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedDiagrams
	 * @generated
	 */
	TxDiagram getTxDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelDiagram#getTxDiagram <em>Tx Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tx Diagram</em>' container reference.
	 * @see #getTxDiagram()
	 * @generated
	 */
	void setTxDiagram(TxDiagram value);
} // RelDiagram
