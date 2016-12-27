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
 * A representation of the model object '<em><b>object Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.objectType#getHeritage <em>Heritage</em>}</li>
 *   <li>{@link delphi.objectType#getFieldList <em>Field List</em>}</li>
 *   <li>{@link delphi.objectType#getMethodList <em>Method List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getobjectType()
 * @model
 * @generated
 */
public interface objectType extends restrictedType {
	/**
	 * Returns the value of the '<em><b>Heritage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heritage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heritage</em>' containment reference.
	 * @see #setHeritage(objHeritage)
	 * @see delphi.DelphiPackage#getobjectType_Heritage()
	 * @model containment="true"
	 * @generated
	 */
	objHeritage getHeritage();

	/**
	 * Sets the value of the '{@link delphi.objectType#getHeritage <em>Heritage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heritage</em>' containment reference.
	 * @see #getHeritage()
	 * @generated
	 */
	void setHeritage(objHeritage value);

	/**
	 * Returns the value of the '<em><b>Field List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field List</em>' containment reference.
	 * @see #setFieldList(objFieldList)
	 * @see delphi.DelphiPackage#getobjectType_FieldList()
	 * @model containment="true"
	 * @generated
	 */
	objFieldList getFieldList();

	/**
	 * Sets the value of the '{@link delphi.objectType#getFieldList <em>Field List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field List</em>' containment reference.
	 * @see #getFieldList()
	 * @generated
	 */
	void setFieldList(objFieldList value);

	/**
	 * Returns the value of the '<em><b>Method List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method List</em>' containment reference.
	 * @see #setMethodList(methodList)
	 * @see delphi.DelphiPackage#getobjectType_MethodList()
	 * @model containment="true"
	 * @generated
	 */
	methodList getMethodList();

	/**
	 * Sets the value of the '{@link delphi.objectType#getMethodList <em>Method List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method List</em>' containment reference.
	 * @see #getMethodList()
	 * @generated
	 */
	void setMethodList(methodList value);

} // objectType
