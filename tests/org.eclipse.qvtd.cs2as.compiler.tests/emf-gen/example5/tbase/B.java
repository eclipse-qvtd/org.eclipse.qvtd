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
package example5.tbase;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>B</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example5.tbase.B#getOwnsC <em>Owns C</em>}</li>
 * </ul>
 *
 * @see example5.tbase.TbasePackage#getB()
 * @model
 * @generated
 */
public interface B extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Owns C</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns C</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns C</em>' containment reference.
	 * @see #setOwnsC(C)
	 * @see example5.tbase.TbasePackage#getB_OwnsC()
	 * @model containment="true"
	 * @generated
	 */
	C getOwnsC();

	/**
	 * Sets the value of the '{@link example5.tbase.B#getOwnsC <em>Owns C</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owns C</em>' containment reference.
	 * @see #getOwnsC()
	 * @generated
	 */
	void setOwnsC(C value);

} // B
