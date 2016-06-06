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
 *   <li>{@link org.eclipse.qvtd.umlx.Model#getOwnedDiagrams <em>Owned Diagrams</em>}</li>
 * </ul>
 *
 * @generated
 */
public interface Model extends Element {
	/**
	 * Returns the value of the '<em><b>Owned Diagrams</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.TxDiagram}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Diagrams</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Diagrams</em>' containment reference list.
	 * @generated
	 */
	EList<TxDiagram> getOwnedDiagrams();

} // Model
