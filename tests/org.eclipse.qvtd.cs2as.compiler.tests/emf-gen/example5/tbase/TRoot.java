/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example5.tbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TRoot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example5.tbase.TRoot#getOwnedA <em>Owned A</em>}</li>
 * </ul>
 *
 * @see example5.tbase.TbasePackage#getTRoot()
 * @model
 * @generated
 */
public interface TRoot extends Element {
	/**
	 * Returns the value of the '<em><b>Owned A</b></em>' containment reference list.
	 * The list contents are of type {@link example5.tbase.A}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned A</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned A</em>' containment reference list.
	 * @see example5.tbase.TbasePackage#getTRoot_OwnedA()
	 * @model containment="true"
	 * @generated
	 */
	EList<A> getOwnedA();

} // TRoot
