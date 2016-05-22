/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example4.kiamacs;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Top CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example4.kiamacs.TopCS#getNode <em>Node</em>}</li>
 * </ul>
 *
 * @see example4.kiamacs.KiamacsPackage#getTopCS()
 * @model
 * @generated
 */
public interface TopCS extends BaseCS {
	/**
	 * Returns the value of the '<em><b>Node</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' containment reference.
	 * @see #setNode(NodeCS)
	 * @see example4.kiamacs.KiamacsPackage#getTopCS_Node()
	 * @model containment="true" required="true"
	 * @generated
	 */
	NodeCS getNode();

	/**
	 * Sets the value of the '{@link example4.kiamacs.TopCS#getNode <em>Node</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' containment reference.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(NodeCS value);

} // TopCS
