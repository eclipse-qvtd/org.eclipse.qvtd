/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Doubly Linked List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.DoublyLinkedList#getHeadElement <em>Head Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.DoublyLinkedList#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.DoublyLinkedList#getOwnedElements <em>Owned Elements</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage#getDoublyLinkedList()
 * @model
 * @generated
 */
public interface DoublyLinkedList extends EObject {
	/**
	 * Returns the value of the '<em><b>Head Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Head Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Head Element</em>' reference.
	 * @see #setHeadElement(Element)
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage#getDoublyLinkedList_HeadElement()
	 * @model
	 * @generated
	 */
	Element getHeadElement();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.DoublyLinkedList#getHeadElement <em>Head Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Head Element</em>' reference.
	 * @see #getHeadElement()
	 * @generated
	 */
	void setHeadElement(Element value);

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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage#getDoublyLinkedList_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.DoublyLinkedList#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Owned Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.Element}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.Element#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Elements</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.doublylinkedlistPackage#getDoublyLinkedList_OwnedElements()
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.doublylinkedlist.Element#getList
	 * @model opposite="list" containment="true" ordered="false"
	 * @generated
	 */
	EList<Element> getOwnedElements();

} // DoublyLinkedList
