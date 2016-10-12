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
package org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getList <em>List</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage#getElement()
 * @model
 * @generated
 */
public interface Element extends EObject {
	/**
	 * Returns the value of the '<em><b>List</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' container reference.
	 * @see #setList(DoublyLinkedList)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage#getElement_List()
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList#getOwnedElements
	 * @model opposite="ownedElements" required="true" transient="false"
	 * @generated
	 */
	DoublyLinkedList getList();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getList <em>List</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>List</em>' container reference.
	 * @see #getList()
	 * @generated
	 */
	void setList(DoublyLinkedList value);

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
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage#getElement_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(Element)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage#getElement_Source()
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getTarget
	 * @model opposite="target" required="true"
	 * @generated
	 */
	Element getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(Element value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(Element)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistPackage#getElement_Target()
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getSource
	 * @model opposite="source" required="true"
	 * @generated
	 */
	Element getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Element value);

} // Element
