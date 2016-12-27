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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>designator Sub Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.designatorSubPart#getPart <em>Part</em>}</li>
 *   <li>{@link delphi.designatorSubPart#getExprList <em>Expr List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getdesignatorSubPart()
 * @model
 * @generated
 */
public interface designatorSubPart extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Part</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' containment reference.
	 * @see #setPart(designatorPart)
	 * @see delphi.DelphiPackage#getdesignatorSubPart_Part()
	 * @model containment="true"
	 * @generated
	 */
	designatorPart getPart();

	/**
	 * Sets the value of the '{@link delphi.designatorSubPart#getPart <em>Part</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Part</em>' containment reference.
	 * @see #getPart()
	 * @generated
	 */
	void setPart(designatorPart value);

	/**
	 * Returns the value of the '<em><b>Expr List</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.exprList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expr List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expr List</em>' containment reference list.
	 * @see delphi.DelphiPackage#getdesignatorSubPart_ExprList()
	 * @model containment="true"
	 * @generated
	 */
	EList<exprList> getExprList();

} // designatorSubPart
