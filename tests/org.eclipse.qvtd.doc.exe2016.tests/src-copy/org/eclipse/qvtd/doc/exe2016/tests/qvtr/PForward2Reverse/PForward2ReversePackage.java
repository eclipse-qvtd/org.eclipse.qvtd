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
 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.PForward2ReverseFactory
 * @model kind="package"
 * @generated
 */
public interface PForward2ReversePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "PForward2Reverse";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd-example/org/eclipse/qvtd/xtext/qvtrelation2/tests/forward2reverse/Forward2Reverse";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "PForward2Reverse";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PForward2ReversePackage eINSTANCE = org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.PForward2ReversePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl <em>Telement2element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.PForward2ReversePackageImpl#getTelement2element()
	 * @generated
	 */
	int TELEMENT2ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Element Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMENT2ELEMENT__ELEMENT_NAME = 0;

	/**
	 * The feature id for the '<em><b>Forward Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMENT2ELEMENT__FORWARD_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Forward List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMENT2ELEMENT__FORWARD_LIST = 2;

	/**
	 * The feature id for the '<em><b>Forward Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMENT2ELEMENT__FORWARD_TARGET = 3;

	/**
	 * The feature id for the '<em><b>Reverse Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMENT2ELEMENT__REVERSE_ELEMENT = 4;

	/**
	 * The feature id for the '<em><b>Reverse List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMENT2ELEMENT__REVERSE_LIST = 5;

	/**
	 * The feature id for the '<em><b>Reverse Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMENT2ELEMENT__REVERSE_SOURCE = 6;

	/**
	 * The number of structural features of the '<em>Telement2element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMENT2ELEMENT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Telement2element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TELEMENT2ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Tlist2listImpl <em>Tlist2list</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Tlist2listImpl
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.PForward2ReversePackageImpl#getTlist2list()
	 * @generated
	 */
	int TLIST2LIST = 1;

	/**
	 * The feature id for the '<em><b>Forward List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST2LIST__FORWARD_LIST = 0;

	/**
	 * The feature id for the '<em><b>List Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST2LIST__LIST_NAME = 1;

	/**
	 * The feature id for the '<em><b>Reverse List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST2LIST__REVERSE_LIST = 2;

	/**
	 * The number of structural features of the '<em>Tlist2list</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST2LIST_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Tlist2list</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST2LIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.TlistHead2listHeadImpl <em>Tlist Head2list Head</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.TlistHead2listHeadImpl
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.PForward2ReversePackageImpl#getTlistHead2listHead()
	 * @generated
	 */
	int TLIST_HEAD2LIST_HEAD = 2;

	/**
	 * The feature id for the '<em><b>Forward Head</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST_HEAD2LIST_HEAD__FORWARD_HEAD = 0;

	/**
	 * The feature id for the '<em><b>Forward List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST_HEAD2LIST_HEAD__FORWARD_LIST = 1;

	/**
	 * The feature id for the '<em><b>Reverse Head</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST_HEAD2LIST_HEAD__REVERSE_HEAD = 2;

	/**
	 * The feature id for the '<em><b>Reverse List</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST_HEAD2LIST_HEAD__REVERSE_LIST = 3;

	/**
	 * The number of structural features of the '<em>Tlist Head2list Head</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST_HEAD2LIST_HEAD_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Tlist Head2list Head</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TLIST_HEAD2LIST_HEAD_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element <em>Telement2element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Telement2element</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element
	 * @generated
	 */
	EClass getTelement2element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getElementName <em>Element Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Name</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getElementName()
	 * @see #getTelement2element()
	 * @generated
	 */
	EAttribute getTelement2element_ElementName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getForwardElement <em>Forward Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Forward Element</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getForwardElement()
	 * @see #getTelement2element()
	 * @generated
	 */
	EReference getTelement2element_ForwardElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getForwardList <em>Forward List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Forward List</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getForwardList()
	 * @see #getTelement2element()
	 * @generated
	 */
	EReference getTelement2element_ForwardList();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getForwardTarget <em>Forward Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Forward Target</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getForwardTarget()
	 * @see #getTelement2element()
	 * @generated
	 */
	EReference getTelement2element_ForwardTarget();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getReverseElement <em>Reverse Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reverse Element</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getReverseElement()
	 * @see #getTelement2element()
	 * @generated
	 */
	EReference getTelement2element_ReverseElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getReverseList <em>Reverse List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reverse List</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getReverseList()
	 * @see #getTelement2element()
	 * @generated
	 */
	EReference getTelement2element_ReverseList();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getReverseSource <em>Reverse Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reverse Source</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Telement2element#getReverseSource()
	 * @see #getTelement2element()
	 * @generated
	 */
	EReference getTelement2element_ReverseSource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list <em>Tlist2list</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tlist2list</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list
	 * @generated
	 */
	EClass getTlist2list();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list#getForwardList <em>Forward List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Forward List</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list#getForwardList()
	 * @see #getTlist2list()
	 * @generated
	 */
	EReference getTlist2list_ForwardList();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list#getListName <em>List Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>List Name</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list#getListName()
	 * @see #getTlist2list()
	 * @generated
	 */
	EAttribute getTlist2list_ListName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list#getReverseList <em>Reverse List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reverse List</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.Tlist2list#getReverseList()
	 * @see #getTlist2list()
	 * @generated
	 */
	EReference getTlist2list_ReverseList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead <em>Tlist Head2list Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tlist Head2list Head</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead
	 * @generated
	 */
	EClass getTlistHead2listHead();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getForwardHead <em>Forward Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Forward Head</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getForwardHead()
	 * @see #getTlistHead2listHead()
	 * @generated
	 */
	EReference getTlistHead2listHead_ForwardHead();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getForwardList <em>Forward List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Forward List</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getForwardList()
	 * @see #getTlistHead2listHead()
	 * @generated
	 */
	EReference getTlistHead2listHead_ForwardList();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getReverseHead <em>Reverse Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reverse Head</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getReverseHead()
	 * @see #getTlistHead2listHead()
	 * @generated
	 */
	EReference getTlistHead2listHead_ReverseHead();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getReverseList <em>Reverse List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reverse List</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.TlistHead2listHead#getReverseList()
	 * @see #getTlistHead2listHead()
	 * @generated
	 */
	EReference getTlistHead2listHead_ReverseList();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PForward2ReverseFactory getPForward2ReverseFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl <em>Telement2element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Telement2elementImpl
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.PForward2ReversePackageImpl#getTelement2element()
		 * @generated
		 */
		EClass TELEMENT2ELEMENT = eINSTANCE.getTelement2element();

		/**
		 * The meta object literal for the '<em><b>Element Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TELEMENT2ELEMENT__ELEMENT_NAME = eINSTANCE.getTelement2element_ElementName();

		/**
		 * The meta object literal for the '<em><b>Forward Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TELEMENT2ELEMENT__FORWARD_ELEMENT = eINSTANCE.getTelement2element_ForwardElement();

		/**
		 * The meta object literal for the '<em><b>Forward List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TELEMENT2ELEMENT__FORWARD_LIST = eINSTANCE.getTelement2element_ForwardList();

		/**
		 * The meta object literal for the '<em><b>Forward Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TELEMENT2ELEMENT__FORWARD_TARGET = eINSTANCE.getTelement2element_ForwardTarget();

		/**
		 * The meta object literal for the '<em><b>Reverse Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TELEMENT2ELEMENT__REVERSE_ELEMENT = eINSTANCE.getTelement2element_ReverseElement();

		/**
		 * The meta object literal for the '<em><b>Reverse List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TELEMENT2ELEMENT__REVERSE_LIST = eINSTANCE.getTelement2element_ReverseList();

		/**
		 * The meta object literal for the '<em><b>Reverse Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TELEMENT2ELEMENT__REVERSE_SOURCE = eINSTANCE.getTelement2element_ReverseSource();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Tlist2listImpl <em>Tlist2list</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.Tlist2listImpl
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.PForward2ReversePackageImpl#getTlist2list()
		 * @generated
		 */
		EClass TLIST2LIST = eINSTANCE.getTlist2list();

		/**
		 * The meta object literal for the '<em><b>Forward List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLIST2LIST__FORWARD_LIST = eINSTANCE.getTlist2list_ForwardList();

		/**
		 * The meta object literal for the '<em><b>List Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TLIST2LIST__LIST_NAME = eINSTANCE.getTlist2list_ListName();

		/**
		 * The meta object literal for the '<em><b>Reverse List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLIST2LIST__REVERSE_LIST = eINSTANCE.getTlist2list_ReverseList();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.TlistHead2listHeadImpl <em>Tlist Head2list Head</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.TlistHead2listHeadImpl
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtr.PForward2Reverse.impl.PForward2ReversePackageImpl#getTlistHead2listHead()
		 * @generated
		 */
		EClass TLIST_HEAD2LIST_HEAD = eINSTANCE.getTlistHead2listHead();

		/**
		 * The meta object literal for the '<em><b>Forward Head</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLIST_HEAD2LIST_HEAD__FORWARD_HEAD = eINSTANCE.getTlistHead2listHead_ForwardHead();

		/**
		 * The meta object literal for the '<em><b>Forward List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLIST_HEAD2LIST_HEAD__FORWARD_LIST = eINSTANCE.getTlistHead2listHead_ForwardList();

		/**
		 * The meta object literal for the '<em><b>Reverse Head</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLIST_HEAD2LIST_HEAD__REVERSE_HEAD = eINSTANCE.getTlistHead2listHead_ReverseHead();

		/**
		 * The meta object literal for the '<em><b>Reverse List</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TLIST_HEAD2LIST_HEAD__REVERSE_LIST = eINSTANCE.getTlistHead2listHead_ReverseList();

	}

} //PForward2ReversePackage
