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
 * A representation of the model object '<em><b>class Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.classProperty#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link delphi.classProperty#getPropList <em>Prop List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getclassProperty()
 * @model
 * @generated
 */
public interface classProperty extends CSTrace {
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
	 * @see delphi.DelphiPackage#getclassProperty_Visibility()
	 * @model
	 * @generated
	 */
	String getVisibility();

	/**
	 * Sets the value of the '{@link delphi.classProperty#getVisibility <em>Visibility</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Visibility</em>' attribute.
	 * @see #getVisibility()
	 * @generated
	 */
	void setVisibility(String value);

	/**
	 * Returns the value of the '<em><b>Prop List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prop List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prop List</em>' containment reference.
	 * @see #setPropList(propertyList)
	 * @see delphi.DelphiPackage#getclassProperty_PropList()
	 * @model containment="true"
	 * @generated
	 */
	propertyList getPropList();

	/**
	 * Sets the value of the '{@link delphi.classProperty#getPropList <em>Prop List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prop List</em>' containment reference.
	 * @see #getPropList()
	 * @generated
	 */
	void setPropList(propertyList value);

} // classProperty
