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
 * A representation of the model object '<em><b>D</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link example1.target.D#getToC <em>To C</em>}</li>
 *   <li>{@link example1.target.D#getToB <em>To B</em>}</li>
 *   <li>{@link example1.target.D#getToA <em>To A</em>}</li>
 *   <li>{@link example1.target.D#getRefsB <em>Refs B</em>}</li>
 *   <li>{@link example1.target.D#getRefsC <em>Refs C</em>}</li>
 * </ul>
 *
 * @see example1.target.TargetPackage#getD()
 * @model
 * @generated
 */
public interface D extends NamedElement {
	/**
	 * Returns the value of the '<em><b>To C</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link example1.target.C#getOwnsD <em>Owns D</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To C</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To C</em>' container reference.
	 * @see #setToC(C)
	 * @see example1.target.TargetPackage#getD_ToC()
	 * @see example1.target.C#getOwnsD
	 * @model opposite="ownsD" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example1/targetMM/1.0!D!toC'"
	 * @generated
	 */
	C getToC();

	/**
	 * Sets the value of the '{@link example1.target.D#getToC <em>To C</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To C</em>' container reference.
	 * @see #getToC()
	 * @generated
	 */
	void setToC(C value);

	/**
	 * Returns the value of the '<em><b>To B</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link example1.target.B#getOwnsD <em>Owns D</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To B</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To B</em>' container reference.
	 * @see #setToB(B)
	 * @see example1.target.TargetPackage#getD_ToB()
	 * @see example1.target.B#getOwnsD
	 * @model opposite="ownsD" transient="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example1/targetMM/1.0!D!toB'"
	 * @generated
	 */
	B getToB();

	/**
	 * Sets the value of the '{@link example1.target.D#getToB <em>To B</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To B</em>' container reference.
	 * @see #getToB()
	 * @generated
	 */
	void setToB(B value);

	/**
	 * Returns the value of the '<em><b>To A</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To A</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To A</em>' reference.
	 * @see #setToA(A)
	 * @see example1.target.TargetPackage#getD_ToA()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example1/targetMM/1.0!D!toA'"
	 * @generated
	 */
	A getToA();

	/**
	 * Sets the value of the '{@link example1.target.D#getToA <em>To A</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To A</em>' reference.
	 * @see #getToA()
	 * @generated
	 */
	void setToA(A value);

	/**
	 * Returns the value of the '<em><b>Refs B</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refs B</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refs B</em>' reference.
	 * @see #setRefsB(B)
	 * @see example1.target.TargetPackage#getD_RefsB()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example1/targetMM/1.0!D!refsB'"
	 * @generated
	 */
	B getRefsB();

	/**
	 * Sets the value of the '{@link example1.target.D#getRefsB <em>Refs B</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refs B</em>' reference.
	 * @see #getRefsB()
	 * @generated
	 */
	void setRefsB(B value);

	/**
	 * Returns the value of the '<em><b>Refs C</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refs C</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refs C</em>' reference.
	 * @see #setRefsC(C)
	 * @see example1.target.TargetPackage#getD_RefsC()
	 * @model annotation="http://www.eclipse.org/emf/2002/GenModel get='throw new UnsupportedOperationException();  // FIXME Unimplemented http://cs2as/tests/example1/targetMM/1.0!D!refsC'"
	 * @generated
	 */
	C getRefsC();

	/**
	 * Sets the value of the '{@link example1.target.D#getRefsC <em>Refs C</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Refs C</em>' reference.
	 * @see #getRefsC()
	 * @generated
	 */
	void setRefsC(C value);

} // D
