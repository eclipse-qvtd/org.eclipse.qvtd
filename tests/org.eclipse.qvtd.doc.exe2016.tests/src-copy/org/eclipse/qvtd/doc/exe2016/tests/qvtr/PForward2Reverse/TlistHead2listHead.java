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
package org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.DoublyLinkedList;
import org.eclipse.qvtd.doc.exe2016.tests.qvtr.doublylinkedlist.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tlist Head2list Head</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getForwardHead <em>Forward Head</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getForwardList <em>Forward List</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getReverseHead <em>Reverse Head</em>}</li>
 *   <li>{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getReverseList <em>Reverse List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReversePackage#getTlistHead2listHead()
 * @model
 * @generated
 */
public interface TlistHead2listHead extends EObject {
	/**
	 * Returns the value of the '<em><b>Forward Head</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward Head</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward Head</em>' reference.
	 * @see #setForwardHead(Element)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReversePackage#getTlistHead2listHead_ForwardHead()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='forward'"
	 * @generated
	 */
	Element getForwardHead();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getForwardHead <em>Forward Head</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward Head</em>' reference.
	 * @see #getForwardHead()
	 * @generated
	 */
	void setForwardHead(Element value);

	/**
	 * Returns the value of the '<em><b>Forward List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward List</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward List</em>' reference.
	 * @see #setForwardList(DoublyLinkedList)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReversePackage#getTlistHead2listHead_ForwardList()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='forward'"
	 * @generated
	 */
	DoublyLinkedList getForwardList();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getForwardList <em>Forward List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward List</em>' reference.
	 * @see #getForwardList()
	 * @generated
	 */
	void setForwardList(DoublyLinkedList value);

	/**
	 * Returns the value of the '<em><b>Reverse Head</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverse Head</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverse Head</em>' reference.
	 * @see #setReverseHead(Element)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReversePackage#getTlistHead2listHead_ReverseHead()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='reverse'"
	 * @generated
	 */
	Element getReverseHead();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getReverseHead <em>Reverse Head</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reverse Head</em>' reference.
	 * @see #getReverseHead()
	 * @generated
	 */
	void setReverseHead(Element value);

	/**
	 * Returns the value of the '<em><b>Reverse List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reverse List</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reverse List</em>' reference.
	 * @see #setReverseList(DoublyLinkedList)
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReversePackage#getTlistHead2listHead_ReverseList()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='reverse'"
	 * @generated
	 */
	DoublyLinkedList getReverseList();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getReverseList <em>Reverse List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reverse List</em>' reference.
	 * @see #getReverseList()
	 * @generated
	 */
	void setReverseList(DoublyLinkedList value);

} // TlistHead2listHead
