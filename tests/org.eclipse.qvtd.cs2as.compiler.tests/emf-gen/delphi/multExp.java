/**
 * Copyright (c)  2016 Willink Transformations, Univesity of York and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      Adolfo Sanchez-Barbudo Herrera - initial API and implementation
 */
package delphi;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>mult Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.multExp#getLeft <em>Left</em>}</li>
 *   <li>{@link delphi.multExp#getMultOp <em>Mult Op</em>}</li>
 *   <li>{@link delphi.multExp#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getmultExp()
 * @model
 * @generated
 */
public interface multExp extends term {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(term)
	 * @see delphi.DelphiPackage#getmultExp_Left()
	 * @model containment="true"
	 * @generated
	 */
	term getLeft();

	/**
	 * Sets the value of the '{@link delphi.multExp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(term value);

	/**
	 * Returns the value of the '<em><b>Mult Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mult Op</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mult Op</em>' containment reference.
	 * @see #setMultOp(mulOp)
	 * @see delphi.DelphiPackage#getmultExp_MultOp()
	 * @model containment="true"
	 * @generated
	 */
	mulOp getMultOp();

	/**
	 * Sets the value of the '{@link delphi.multExp#getMultOp <em>Mult Op</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mult Op</em>' containment reference.
	 * @see #getMultOp()
	 * @generated
	 */
	void setMultOp(mulOp value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(factor)
	 * @see delphi.DelphiPackage#getmultExp_Right()
	 * @model containment="true"
	 * @generated
	 */
	factor getRight();

	/**
	 * Sets the value of the '{@link delphi.multExp#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(factor value);

} // multExp
