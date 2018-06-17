/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
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
package example5.sbase;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SRoot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example5.sbase.SRoot#getOwnedX <em>Owned X</em>}</li>
 * </ul>
 *
 * @see example5.sbase.SbasePackage#getSRoot()
 * @model
 * @generated
 */
public interface SRoot extends SElement {
	/**
	 * Returns the value of the '<em><b>Owned X</b></em>' containment reference list.
	 * The list contents are of type {@link example5.sbase.X}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned X</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned X</em>' containment reference list.
	 * @see example5.sbase.SbasePackage#getSRoot_OwnedX()
	 * @model containment="true"
	 * @generated
	 */
	EList<X> getOwnedX();

} // SRoot
