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
package example4.kiamacs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Composite CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example4.kiamacs.CompositeCS#getChild <em>Child</em>}</li>
 * </ul>
 *
 * @see example4.kiamacs.KiamacsPackage#getCompositeCS()
 * @model
 * @generated
 */
public interface CompositeCS extends NodeCS {
	/**
	 * Returns the value of the '<em><b>Child</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child</em>' containment reference.
	 * @see #setChild(NodeCS)
	 * @see example4.kiamacs.KiamacsPackage#getCompositeCS_Child()
	 * @model containment="true"
	 * @generated
	 */
	NodeCS getChild();

	/**
	 * Sets the value of the '{@link example4.kiamacs.CompositeCS#getChild <em>Child</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Child</em>' containment reference.
	 * @see #getChild()
	 * @generated
	 */
	void setChild(NodeCS value);

} // CompositeCS
