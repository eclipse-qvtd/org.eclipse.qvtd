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
 * A representation of the model object '<em><b>interface Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link delphi.interfaceType#getHeritage <em>Heritage</em>}</li>
 *   <li>{@link delphi.interfaceType#getMethodList <em>Method List</em>}</li>
 *   <li>{@link delphi.interfaceType#getPropList <em>Prop List</em>}</li>
 * </ul>
 *
 * @see delphi.DelphiPackage#getinterfaceType()
 * @model
 * @generated
 */
public interface interfaceType extends restrictedType {
	/**
	 * Returns the value of the '<em><b>Heritage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Heritage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Heritage</em>' containment reference.
	 * @see #setHeritage(interfaceHeritage)
	 * @see delphi.DelphiPackage#getinterfaceType_Heritage()
	 * @model containment="true"
	 * @generated
	 */
	interfaceHeritage getHeritage();

	/**
	 * Sets the value of the '{@link delphi.interfaceType#getHeritage <em>Heritage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Heritage</em>' containment reference.
	 * @see #getHeritage()
	 * @generated
	 */
	void setHeritage(interfaceHeritage value);

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
	 * @see delphi.DelphiPackage#getinterfaceType_MethodList()
	 * @model containment="true"
	 * @generated
	 */
	classMethodList getMethodList();

	/**
	 * Sets the value of the '{@link delphi.interfaceType#getMethodList <em>Method List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method List</em>' containment reference.
	 * @see #getMethodList()
	 * @generated
	 */
	void setMethodList(classMethodList value);

	/**
	 * Returns the value of the '<em><b>Prop List</b></em>' containment reference list.
	 * The list contents are of type {@link delphi.classPropertyList}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prop List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prop List</em>' containment reference list.
	 * @see delphi.DelphiPackage#getinterfaceType_PropList()
	 * @model containment="true"
	 * @generated
	 */
	EList<classPropertyList> getPropList();

} // interfaceType
