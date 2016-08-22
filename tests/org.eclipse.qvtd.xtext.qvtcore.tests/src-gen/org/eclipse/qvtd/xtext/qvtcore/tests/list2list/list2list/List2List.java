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
package org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvtd.xtext.qvtcore.tests.list2list.doublylinkedlist.DoublyLinkedList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List2 List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2List#getList1 <em>List1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2List#getList2 <em>List2</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2List#getElement2Element <em>Element2 Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2List#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2listPackage#getList2List()
 * @model
 * @generated
 */
public interface List2List extends EObject {
	/**
	 * Returns the value of the '<em><b>List1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List1</em>' reference.
	 * @see #setList1(DoublyLinkedList)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2listPackage#getList2List_List1()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle1' lower='1' upper='1'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='forward'"
	 * @generated
	 */
	DoublyLinkedList getList1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2List#getList1 <em>List1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List1</em>' reference.
	 * @see #getList1()
	 * @generated
	 */
	void setList1(DoublyLinkedList value);

	/**
	 * Returns the value of the '<em><b>List2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List2</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List2</em>' reference.
	 * @see #setList2(DoublyLinkedList)
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2listPackage#getList2List_List2()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='middle2' lower='1' upper='1'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='reverse'"
	 * @generated
	 */
	DoublyLinkedList getList2();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2List#getList2 <em>List2</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List2</em>' reference.
	 * @see #getList2()
	 * @generated
	 */
	void setList2(DoublyLinkedList value);

	/**
	 * Returns the value of the '<em><b>Element2 Element</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.Element2Element}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.Element2Element#getList2list <em>List2list</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element2 Element</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element2 Element</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2listPackage#getList2List_Element2Element()
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.Element2Element#getList2list
	 * @model opposite="list2list" containment="true"
	 * @generated
	 */
	EList<Element2Element> getElement2Element();

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
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2listPackage#getList2List_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.list2list.list2list.List2List#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // List2List
