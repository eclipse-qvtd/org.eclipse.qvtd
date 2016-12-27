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
 * A representation of the model object '<em><b>add Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.addExp#getLeft <em>Left</em>}</li>
 *   <li>{@link delphi.addExp#getAddOp <em>Add Op</em>}</li>
 *   <li>{@link delphi.addExp#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getaddExp()
 * @model
 * @generated
 */
public interface addExp extends simpleExpression {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(simpleExpression)
	 * @see delphi.DelphiPackage#getaddExp_Left()
	 * @model containment="true"
	 * @generated
	 */
	simpleExpression getLeft();

	/**
	 * Sets the value of the '{@link delphi.addExp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(simpleExpression value);

	/**
	 * Returns the value of the '<em><b>Add Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Add Op</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Add Op</em>' containment reference.
	 * @see #setAddOp(addOp)
	 * @see delphi.DelphiPackage#getaddExp_AddOp()
	 * @model containment="true"
	 * @generated
	 */
	addOp getAddOp();

	/**
	 * Sets the value of the '{@link delphi.addExp#getAddOp <em>Add Op</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Add Op</em>' containment reference.
	 * @see #getAddOp()
	 * @generated
	 */
	void setAddOp(addOp value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(term)
	 * @see delphi.DelphiPackage#getaddExp_Right()
	 * @model containment="true"
	 * @generated
	 */
	term getRight();

	/**
	 * Sets the value of the '{@link delphi.addExp#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(term value);

} // addExp
