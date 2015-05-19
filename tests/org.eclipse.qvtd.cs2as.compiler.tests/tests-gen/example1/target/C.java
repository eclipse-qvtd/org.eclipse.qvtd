/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
package example1.target;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>C</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example1.target.C#getToA2 <em>To A2</em>}</li>
 *   <li>{@link example1.target.C#getOwnsD <em>Owns D</em>}</li>
 * </ul>
 *
 * @see example1.target.TargetPackage#getC()
 * @model
 * @generated
 */
public interface C extends Namespace {
	/**
	 * Returns the value of the '<em><b>To A2</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link example1.target.A2#getOwnsC <em>Owns C</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To A2</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To A2</em>' container reference.
	 * @see #setToA2(A2)
	 * @see example1.target.TargetPackage#getC_ToA2()
	 * @see example1.target.A2#getOwnsC
	 * @model opposite="ownsC" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example1/targetMM/1.0!C!toA2'"
	 * @generated
	 */
	A2 getToA2();

	/**
	 * Sets the value of the '{@link example1.target.C#getToA2 <em>To A2</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To A2</em>' container reference.
	 * @see #getToA2()
	 * @generated
	 */
	void setToA2(A2 value);

	/**
	 * Returns the value of the '<em><b>Owns D</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link example1.target.D#getToC <em>To C</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owns D</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owns D</em>' containment reference.
	 * @see #setOwnsD(D)
	 * @see example1.target.TargetPackage#getC_OwnsD()
	 * @see example1.target.D#getToC
	 * @model opposite="toC" containment="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example1/targetMM/1.0!C!ownsD'"
	 * @generated
	 */
	D getOwnsD();

	/**
	 * Sets the value of the '{@link example1.target.C#getOwnsD <em>Owns D</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owns D</em>' containment reference.
	 * @see #getOwnsD()
	 * @generated
	 */
	void setOwnsD(D value);

} // C
