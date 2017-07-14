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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Slist Head2list Head</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.SlistHead2listHead#getForwardList <em>Forward List</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.SlistHead2listHead#getReverseList <em>Reverse List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.PForward2ReversePackage#getSlistHead2listHead()
 * @model
 * @generated
 */
public interface SlistHead2listHead extends EObject {
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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.PForward2ReversePackage#getSlistHead2listHead_ForwardList()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SlistHead2listHead'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='forward'"
	 * @generated
	 */
	DoublyLinkedList getForwardList();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.SlistHead2listHead#getForwardList <em>Forward List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward List</em>' reference.
	 * @see #getForwardList()
	 * @generated
	 */
	void setForwardList(DoublyLinkedList value);

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
	 * @see org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.PForward2ReversePackage#getSlistHead2listHead_ReverseList()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SlistHead2listHead'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='reverse'"
	 * @generated
	 */
	DoublyLinkedList getReverseList();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelation.tests.forward2reverse.PForward2Reverse.SlistHead2listHead#getReverseList <em>Reverse List</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reverse List</em>' reference.
	 * @see #getReverseList()
	 * @generated
	 */
	void setReverseList(DoublyLinkedList value);

} // SlistHead2listHead
