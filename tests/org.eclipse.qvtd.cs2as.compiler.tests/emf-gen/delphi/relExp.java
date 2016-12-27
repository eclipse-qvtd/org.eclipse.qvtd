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
 * A representation of the model object '<em><b>rel Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.relExp#getLeft <em>Left</em>}</li>
 *   <li>{@link delphi.relExp#getRelOp <em>Rel Op</em>}</li>
 *   <li>{@link delphi.relExp#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getrelExp()
 * @model
 * @generated
 */
public interface relExp extends expression {
	/**
	 * Returns the value of the '<em><b>Left</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left</em>' containment reference.
	 * @see #setLeft(expression)
	 * @see delphi.DelphiPackage#getrelExp_Left()
	 * @model containment="true"
	 * @generated
	 */
	expression getLeft();

	/**
	 * Sets the value of the '{@link delphi.relExp#getLeft <em>Left</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Left</em>' containment reference.
	 * @see #getLeft()
	 * @generated
	 */
	void setLeft(expression value);

	/**
	 * Returns the value of the '<em><b>Rel Op</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rel Op</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rel Op</em>' containment reference.
	 * @see #setRelOp(relOp)
	 * @see delphi.DelphiPackage#getrelExp_RelOp()
	 * @model containment="true"
	 * @generated
	 */
	relOp getRelOp();

	/**
	 * Sets the value of the '{@link delphi.relExp#getRelOp <em>Rel Op</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel Op</em>' containment reference.
	 * @see #getRelOp()
	 * @generated
	 */
	void setRelOp(relOp value);

	/**
	 * Returns the value of the '<em><b>Right</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right</em>' containment reference.
	 * @see #setRight(simpleExpression)
	 * @see delphi.DelphiPackage#getrelExp_Right()
	 * @model containment="true"
	 * @generated
	 */
	simpleExpression getRight();

	/**
	 * Sets the value of the '{@link delphi.relExp#getRight <em>Right</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Right</em>' containment reference.
	 * @see #getRight()
	 * @generated
	 */
	void setRight(simpleExpression value);

} // relExp
