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
 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2listFactory
 * @model kind="package"
 * @generated
 */
public interface List2listPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "list2list";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd/xtext/qvtcore/tests/forward2reverse/1.0/List2List";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "list2list";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	List2listPackage eINSTANCE = org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2listPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2ListImpl <em>List2 List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2ListImpl
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2listPackageImpl#getList2List()
	 * @generated
	 */
	int LIST2_LIST = 0;

	/**
	 * The feature id for the '<em><b>List1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST2_LIST__LIST1 = 0;

	/**
	 * The feature id for the '<em><b>List2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST2_LIST__LIST2 = 1;

	/**
	 * The feature id for the '<em><b>Element2 Element</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST2_LIST__ELEMENT2_ELEMENT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST2_LIST__NAME = 3;

	/**
	 * The number of structural features of the '<em>List2 List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST2_LIST_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>List2 List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIST2_LIST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.Element2ElementImpl <em>Element2 Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.Element2ElementImpl
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2listPackageImpl#getElement2Element()
	 * @generated
	 */
	int ELEMENT2_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Element1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT2_ELEMENT__ELEMENT1 = 0;

	/**
	 * The feature id for the '<em><b>Element2</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT2_ELEMENT__ELEMENT2 = 1;

	/**
	 * The feature id for the '<em><b>List2list</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT2_ELEMENT__LIST2LIST = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT2_ELEMENT__NAME = 3;

	/**
	 * The number of structural features of the '<em>Element2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT2_ELEMENT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Element2 Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT2_ELEMENT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List <em>List2 List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>List2 List</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List
	 * @generated
	 */
	EClass getList2List();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getList1 <em>List1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>List1</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getList1()
	 * @see #getList2List()
	 * @generated
	 */
	EReference getList2List_List1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getList2 <em>List2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>List2</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getList2()
	 * @see #getList2List()
	 * @generated
	 */
	EReference getList2List_List2();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getElement2Element <em>Element2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Element2 Element</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getElement2Element()
	 * @see #getList2List()
	 * @generated
	 */
	EReference getList2List_Element2Element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.List2List#getName()
	 * @see #getList2List()
	 * @generated
	 */
	EAttribute getList2List_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element <em>Element2 Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element2 Element</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element
	 * @generated
	 */
	EClass getElement2Element();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getElement1 <em>Element1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element1</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getElement1()
	 * @see #getElement2Element()
	 * @generated
	 */
	EReference getElement2Element_Element1();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getElement2 <em>Element2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Element2</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getElement2()
	 * @see #getElement2Element()
	 * @generated
	 */
	EReference getElement2Element_Element2();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getList2list <em>List2list</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>List2list</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getList2list()
	 * @see #getElement2Element()
	 * @generated
	 */
	EReference getElement2Element_List2list();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.Element2Element#getName()
	 * @see #getElement2Element()
	 * @generated
	 */
	EAttribute getElement2Element_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	List2listFactory getList2listFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2ListImpl <em>List2 List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2ListImpl
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2listPackageImpl#getList2List()
		 * @generated
		 */
		EClass LIST2_LIST = eINSTANCE.getList2List();

		/**
		 * The meta object literal for the '<em><b>List1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST2_LIST__LIST1 = eINSTANCE.getList2List_List1();

		/**
		 * The meta object literal for the '<em><b>List2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST2_LIST__LIST2 = eINSTANCE.getList2List_List2();

		/**
		 * The meta object literal for the '<em><b>Element2 Element</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LIST2_LIST__ELEMENT2_ELEMENT = eINSTANCE.getList2List_Element2Element();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIST2_LIST__NAME = eINSTANCE.getList2List_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.Element2ElementImpl <em>Element2 Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.Element2ElementImpl
		 * @see org.eclipse.qvtd.doc.exe2016.tests.qvtc.list2list.impl.List2listPackageImpl#getElement2Element()
		 * @generated
		 */
		EClass ELEMENT2_ELEMENT = eINSTANCE.getElement2Element();

		/**
		 * The meta object literal for the '<em><b>Element1</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT2_ELEMENT__ELEMENT1 = eINSTANCE.getElement2Element_Element1();

		/**
		 * The meta object literal for the '<em><b>Element2</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT2_ELEMENT__ELEMENT2 = eINSTANCE.getElement2Element_Element2();

		/**
		 * The meta object literal for the '<em><b>List2list</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT2_ELEMENT__LIST2LIST = eINSTANCE.getElement2Element_List2list();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT2_ELEMENT__NAME = eINSTANCE.getElement2Element_Name();

	}

} //List2listPackage
