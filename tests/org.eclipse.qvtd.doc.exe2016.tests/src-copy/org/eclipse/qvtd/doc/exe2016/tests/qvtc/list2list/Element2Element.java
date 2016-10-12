/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element2 Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getElement1 <em>Element1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getElement2 <em>Element2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getList2list <em>List2list</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage#getElement2Element()
 * @model
 * @generated
 */
public interface Element2Element extends EObject {
	/**
	 * Returns the value of the '<em><b>Element1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element1</em>' reference.
	 * @see #setElement1(Element)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage#getElement2Element_Element1()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle1' lower='1' upper='1'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='forward'"
	 * @generated
	 */
	Element getElement1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getElement1 <em>Element1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element1</em>' reference.
	 * @see #getElement1()
	 * @generated
	 */
	void setElement1(Element value);

	/**
	 * Returns the value of the '<em><b>Element2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element2</em>' reference.
	 * @see #setElement2(Element)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage#getElement2Element_Element2()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle2' lower='1' upper='1'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='reverse'"
	 * @generated
	 */
	Element getElement2();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getElement2 <em>Element2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element2</em>' reference.
	 * @see #getElement2()
	 * @generated
	 */
	void setElement2(Element value);

	/**
	 * Returns the value of the '<em><b>List2list</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getElement2Element <em>Element2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List2list</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List2list</em>' container reference.
	 * @see #setList2list(List2List)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage#getElement2Element_List2list()
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getElement2Element
	 * @model opposite="element2Element" required="true" transient="false"
	 * @generated
	 */
	List2List getList2list();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getList2list <em>List2list</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List2list</em>' container reference.
	 * @see #getList2list()
	 * @generated
	 */
	void setList2list(List2List value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listPackage#getElement2Element_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // Element2Element
