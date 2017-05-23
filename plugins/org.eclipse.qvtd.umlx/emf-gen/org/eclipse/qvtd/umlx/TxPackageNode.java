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

import org.eclipse.emf.common.util.EList;
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
 *   <li>{@link org.eclipse.qvtd.umlx.TxPackageNode#getImportAliases <em>Import Aliases</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxPackageNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.TxPackageNode#getReferredEPackage <em>Referred EPackage</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxPackageNode()
 * @generated
 */
public interface TxPackageNode extends TxNode {
	/**
	 * Returns the value of the '<em><b>Import Aliases</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Aliases</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Aliases</em>' attribute list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxPackageNode_ImportAliases()
	 * @generated
	 */
	EList<String> getImportAliases();

	/**
	 * Returns the value of the '<em><b>Owning Tx Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxPackageNodes <em>Owned Tx Package Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Tx Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Tx Diagram</em>' container reference.
	 * @see #setOwningTxDiagram(TxDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getTxPackageNode_OwningTxDiagram()
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxPackageNodes
	 * @generated
	 */
	TxDiagram getOwningTxDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.TxPackageNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Tx Diagram</em>' container reference.
	 * @see #getOwningTxDiagram()
	 * @generated
	 */
	void setOwningTxDiagram(TxDiagram value);

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

} // TxPackageNode
