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
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedRelDiagrams <em>Owned Rel Diagrams</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxImportNodes <em>Owned Tx Import Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxKeyNodes <em>Owned Tx Key Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxTypedModelNodes <em>Owned Tx Typed Model Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxDiagram#getPackage <em>Package</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram()
 * @generated
 */
public interface TxDiagram extends UMLXNamedElement {
	/**
	 * Returns the value of the '<em><b>Owned Rel Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.RelDiagram}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelDiagram#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Rel Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Rel Diagrams</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram_OwnedRelDiagrams()
	 * @see org.eclipse.qvtd.umlx.RelDiagram#getOwningTxDiagram
	 * @generated
	 */
	EList<RelDiagram> getOwnedRelDiagrams();

	/**
	 * Returns the value of the '<em><b>Owned Tx Import Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxImportNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxImportNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tx Import Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tx Import Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram_OwnedTxImportNodes()
	 * @see org.eclipse.qvtd.umlx.TxImportNode#getOwningTxDiagram
	 * @generated
	 */
	EList<TxImportNode> getOwnedTxImportNodes();

	/**
	 * Returns the value of the '<em><b>Owned Tx Key Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxKeyNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxKeyNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tx Key Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tx Key Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram_OwnedTxKeyNodes()
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#getOwningTxDiagram
	 * @generated
	 */
	EList<TxKeyNode> getOwnedTxKeyNodes();

	/**
	 * Returns the value of the '<em><b>Owned Tx Typed Model Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxTypedModelNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tx Typed Model Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tx Typed Model Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxDiagram_OwnedTxTypedModelNodes()
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getOwningTxDiagram
	 * @generated
	 */
	EList<TxTypedModelNode> getOwnedTxTypedModelNodes();

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean RelDiagramNamesAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean TxTypedModelNodeNamesAreUnique(DiagnosticChain diagnostics, Map<Object, Object> context);

} // TxDiagram
