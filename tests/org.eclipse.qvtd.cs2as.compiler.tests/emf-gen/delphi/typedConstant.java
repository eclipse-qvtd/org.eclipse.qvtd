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
 * A representation of the model object '<em><b>typed Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.typedConstant#getConst <em>Const</em>}</li>
 *   <li>{@link delphi.typedConstant#getArray <em>Array</em>}</li>
 *   <li>{@link delphi.typedConstant#getRecord <em>Record</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#gettypedConstant()
 * @model
 * @generated
 */
public interface typedConstant extends CSTrace {
	/**
	 * Returns the value of the '<em><b>Const</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const</em>' containment reference.
	 * @see #setConst(constExpr)
	 * @see delphi.DelphiPackage#gettypedConstant_Const()
	 * @model containment="true"
	 * @generated
	 */
	constExpr getConst();

	/**
	 * Sets the value of the '{@link delphi.typedConstant#getConst <em>Const</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const</em>' containment reference.
	 * @see #getConst()
	 * @generated
	 */
	void setConst(constExpr value);

	/**
	 * Returns the value of the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array</em>' containment reference.
	 * @see #setArray(arrayConstant)
	 * @see delphi.DelphiPackage#gettypedConstant_Array()
	 * @model containment="true"
	 * @generated
	 */
	arrayConstant getArray();

	/**
	 * Sets the value of the '{@link delphi.typedConstant#getArray <em>Array</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Array</em>' containment reference.
	 * @see #getArray()
	 * @generated
	 */
	void setArray(arrayConstant value);

	/**
	 * Returns the value of the '<em><b>Record</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Record</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Record</em>' containment reference.
	 * @see #setRecord(recordConstant)
	 * @see delphi.DelphiPackage#gettypedConstant_Record()
	 * @model containment="true"
	 * @generated
	 */
	recordConstant getRecord();

	/**
	 * Sets the value of the '{@link delphi.typedConstant#getRecord <em>Record</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record</em>' containment reference.
	 * @see #getRecord()
	 * @generated
	 */
	void setRecord(recordConstant value);

} // typedConstant
