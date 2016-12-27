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
 * A representation of the model object '<em><b>rec Variant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.recVariant#getConstExp <em>Const Exp</em>}</li>
 *   <li>{@link delphi.recVariant#getFieldList <em>Field List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getrecVariant()
 * @model
 * @generated
 */
public interface recVariant extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Const Exp</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.constExpr}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const Exp</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const Exp</em>' containment reference list.
	 * @see delphi.DelphiPackage#getrecVariant_ConstExp()
	 * @model containment="true"
	 * @generated
	 */
	EList<constExpr> getConstExp();

	/**
	 * Returns the value of the '<em><b>Field List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field List</em>' containment reference.
	 * @see #setFieldList(fieldList)
	 * @see delphi.DelphiPackage#getrecVariant_FieldList()
	 * @model containment="true"
	 * @generated
	 */
	fieldList getFieldList();

	/**
	 * Sets the value of the '{@link delphi.recVariant#getFieldList <em>Field List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field List</em>' containment reference.
	 * @see #getFieldList()
	 * @generated
	 */
	void setFieldList(fieldList value);

} // recVariant
