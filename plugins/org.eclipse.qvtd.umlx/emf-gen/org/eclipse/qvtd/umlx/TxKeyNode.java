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
import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tx Key Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.TxKeyNode#getOwnedTxPartNodes <em>Owned Tx Part Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxKeyNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxKeyNode#getReferredEClass <em>Referred EClass</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxKeyNode()
 * @generated
 */
public interface TxKeyNode extends TxNode {
	/**
	 * Returns the value of the '<em><b>Owned Tx Part Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxPartNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxPartNode#getOwningTxKeyNode <em>Owning Tx Key Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tx Part Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tx Part Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxKeyNode_OwnedTxPartNodes()
	 * @see org.eclipse.qvtd.umlx.TxPartNode#getOwningTxKeyNode
	 * @generated
	 */
	EList<TxPartNode> getOwnedTxPartNodes();

	/**
	 * Returns the value of the '<em><b>Owning Tx Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxKeyNodes <em>Owned Tx Key Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Tx Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Tx Diagram</em>' container reference.
	 * @see #setOwningTxDiagram(TxDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxKeyNode_OwningTxDiagram()
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxKeyNodes
	 * @generated
	 */
	TxDiagram getOwningTxDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxKeyNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Tx Diagram</em>' container reference.
	 * @see #getOwningTxDiagram()
	 * @generated
	 */
	void setOwningTxDiagram(TxDiagram value);

	/**
	 * Returns the value of the '<em><b>Referred EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred EClass</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred EClass</em>' reference.
	 * @see #setReferredEClass(EClass)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxKeyNode_ReferredEClass()
	 * @generated
	 */
	EClass getReferredEClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxKeyNode#getReferredEClass <em>Referred EClass</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred EClass</em>' reference.
	 * @see #getReferredEClass()
	 * @generated
	 */
	void setReferredEClass(EClass value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validatePartsAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

} // TxKeyNode
