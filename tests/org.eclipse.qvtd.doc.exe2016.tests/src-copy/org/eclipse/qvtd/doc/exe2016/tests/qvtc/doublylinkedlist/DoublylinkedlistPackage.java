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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublylinkedlistFactory
 * @model kind="package"
 * @generated
 */
public interface DoublylinkedlistPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "doublylinkedlist";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/DoublyLinkList";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "doublylinkedlist";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DoublylinkedlistPackage eINSTANCE = org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublylinkedlistPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.ElementImpl
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublylinkedlistPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>List</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__LIST = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__SOURCE = 2;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__TARGET = 3;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublyLinkedListImpl <em>Doubly Linked List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublyLinkedListImpl
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublylinkedlistPackageImpl#getDoublyLinkedList()
	 * @generated
	 */
	int DOUBLY_LINKED_LIST = 1;

	/**
	 * The feature id for the '<em><b>Head Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLY_LINKED_LIST__HEAD_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLY_LINKED_LIST__NAME = 1;

	/**
	 * The feature id for the '<em><b>Owned Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLY_LINKED_LIST__OWNED_ELEMENTS = 2;

	/**
	 * The number of structural features of the '<em>Doubly Linked List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLY_LINKED_LIST_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Doubly Linked List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLY_LINKED_LIST_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getList <em>List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>List</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getList()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_List();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getName()
	 * @see #getElement()
	 * @generated
	 */
	EAttribute getElement_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getSource()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.Element#getTarget()
	 * @see #getElement()
	 * @generated
	 */
	EReference getElement_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList <em>Doubly Linked List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Doubly Linked List</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList
	 * @generated
	 */
	EClass getDoublyLinkedList();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList#getHeadElement <em>Head Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Head Element</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList#getHeadElement()
	 * @see #getDoublyLinkedList()
	 * @generated
	 */
	EReference getDoublyLinkedList_HeadElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList#getName()
	 * @see #getDoublyLinkedList()
	 * @generated
	 */
	EAttribute getDoublyLinkedList_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList#getOwnedElements <em>Owned Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Elements</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.DoublyLinkedList#getOwnedElements()
	 * @see #getDoublyLinkedList()
	 * @generated
	 */
	EReference getDoublyLinkedList_OwnedElements();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DoublylinkedlistFactory getDoublylinkedlistFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.ElementImpl
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublylinkedlistPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '<em><b>List</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__LIST = eINSTANCE.getElement_List();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT__NAME = eINSTANCE.getElement_Name();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__SOURCE = eINSTANCE.getElement_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT__TARGET = eINSTANCE.getElement_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublyLinkedListImpl <em>Doubly Linked List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublyLinkedListImpl
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.doublylinkedlist.impl.DoublylinkedlistPackageImpl#getDoublyLinkedList()
		 * @generated
		 */
		EClass DOUBLY_LINKED_LIST = eINSTANCE.getDoublyLinkedList();

		/**
		 * The meta object literal for the '<em><b>Head Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOUBLY_LINKED_LIST__HEAD_ELEMENT = eINSTANCE.getDoublyLinkedList_HeadElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLY_LINKED_LIST__NAME = eINSTANCE.getDoublyLinkedList_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOUBLY_LINKED_LIST__OWNED_ELEMENTS = eINSTANCE.getDoublyLinkedList_OwnedElements();

	}

} //DoublylinkedlistPackage
