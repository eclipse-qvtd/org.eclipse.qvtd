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
package example3.kiamacs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plus CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example3.kiamacs.PlusCS#getLeft <em>Left</em>}</li>
 *   <li>{@link example3.kiamacs.PlusCS#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see example3.kiamacs.KiamacsPackage#getPlusCS()
 * @model
 * @generated
 */
public interface PlusCS extends NodeCS {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(NodeCS)
	 * @see example3.kiamacs.KiamacsPackage#getPlusCS_Left()
	 * @model containment="true"
	 * @generated
	 */
	NodeCS getLeft();

	/**
	 * Sets the value of the '{@link example3.kiamacs.PlusCS#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(NodeCS value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(NodeCS)
	 * @see example3.kiamacs.KiamacsPackage#getPlusCS_Right()
	 * @model containment="true"
	 * @generated
	 */
	NodeCS getRight();

	/**
	 * Sets the value of the '{@link example3.kiamacs.PlusCS#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(NodeCS value);

} // PlusCS
