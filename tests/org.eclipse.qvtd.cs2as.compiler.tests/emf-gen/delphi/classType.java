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
 * A representation of the model object '<em><b>class Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.classType#getHeritage <em>Heritage</em>}</li>
 *   <li>{@link delphi.classType#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link delphi.classType#getFieldList <em>Field List</em>}</li>
 *   <li>{@link delphi.classType#getMethodList <em>Method List</em>}</li>
 *   <li>{@link delphi.classType#getPropList <em>Prop List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getclassType()
 * @model
 * @generated
 */
public interface classType extends restrictedType {
	/**
	 * Returns the value of the '<em><b>Heritage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heritage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heritage</em>' containment reference.
	 * @see #setHeritage(classHeritage)
	 * @see delphi.DelphiPackage#getclassType_Heritage()
	 * @model containment="true"
	 * @generated
	 */
	classHeritage getHeritage();

	/**
	 * Sets the value of the '{@link delphi.classType#getHeritage <em>Heritage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heritage</em>' containment reference.
	 * @see #getHeritage()
	 * @generated
	 */
	void setHeritage(classHeritage value);

	/**
	 * Returns the value of the '<em><b>Visibility</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Visibility</em>' attribute.
	 * @see #setVisibility(String)
	 * @see delphi.DelphiPackage#getclassType_Visibility()
	 * @model
	 * @generated
	 */
	String getVisibility();

	/**
	 * Sets the value of the '{@link delphi.classType#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(String value);

	/**
	 * Returns the value of the '<em><b>Field List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Field List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field List</em>' containment reference.
	 * @see #setFieldList(classFieldList)
	 * @see delphi.DelphiPackage#getclassType_FieldList()
	 * @model containment="true"
	 * @generated
	 */
	classFieldList getFieldList();

	/**
	 * Sets the value of the '{@link delphi.classType#getFieldList <em>Field List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field List</em>' containment reference.
	 * @see #getFieldList()
	 * @generated
	 */
	void setFieldList(classFieldList value);

	/**
	 * Returns the value of the '<em><b>Method List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method List</em>' containment reference.
	 * @see #setMethodList(classMethodList)
	 * @see delphi.DelphiPackage#getclassType_MethodList()
	 * @model containment="true"
	 * @generated
	 */
	classMethodList getMethodList();

	/**
	 * Sets the value of the '{@link delphi.classType#getMethodList <em>Method List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method List</em>' containment reference.
	 * @see #getMethodList()
	 * @generated
	 */
	void setMethodList(classMethodList value);

	/**
	 * Returns the value of the '<em><b>Prop List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prop List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prop List</em>' containment reference.
	 * @see #setPropList(classPropertyList)
	 * @see delphi.DelphiPackage#getclassType_PropList()
	 * @model containment="true"
	 * @generated
	 */
	classPropertyList getPropList();

	/**
	 * Sets the value of the '{@link delphi.classType#getPropList <em>Prop List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prop List</em>' containment reference.
	 * @see #getPropList()
	 * @generated
	 */
	void setPropList(classPropertyList value);

} // classType
