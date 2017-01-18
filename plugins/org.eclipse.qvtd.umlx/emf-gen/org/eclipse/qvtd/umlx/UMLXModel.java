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
 * A representation of the model object '<em><b>Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXModel#getOwnedTxDiagrams <em>Owned Tx Diagrams</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXModel()
 * @generated
 */
public interface UMLXModel extends UMLXElement {
	/**
	 * Returns the value of the '<em><b>Owned Tx Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxDiagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Tx Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Tx Diagrams</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXModel_OwnedTxDiagrams()
	 * @generated
	 */
	EList<TxDiagram> getOwnedTxDiagrams();

} // Model
