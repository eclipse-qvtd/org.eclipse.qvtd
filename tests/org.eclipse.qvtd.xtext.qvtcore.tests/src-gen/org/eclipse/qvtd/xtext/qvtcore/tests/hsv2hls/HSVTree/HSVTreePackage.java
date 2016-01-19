/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVTreeFactory
 * @model kind="package"
 * @generated
 */
public interface HSVTreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HSVTree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd/xtext/qvtcore/tests/HSV2HLS/1.0/HSVTree";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hsv";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HSVTreePackage eINSTANCE = org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.impl.HSVTreePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.impl.HSVNodeImpl <em>HSV Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.impl.HSVNodeImpl
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.impl.HSVTreePackageImpl#getHSVNode()
	 * @generated
	 */
	int HSV_NODE = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE__CHILDREN = 1;

	/**
	 * The feature id for the '<em><b>Hsv</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE__HSV = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE__NAME = 3;

	/**
	 * The number of structural features of the '<em>HSV Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>HSV Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>HSV</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.impl.HSVTreePackageImpl#getHSV()
	 * @generated
	 */
	int HSV = 1;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode <em>HSV Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HSV Node</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode
	 * @generated
	 */
	EClass getHSVNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode#getParent()
	 * @see #getHSVNode()
	 * @generated
	 */
	EReference getHSVNode_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode#getChildren()
	 * @see #getHSVNode()
	 * @generated
	 */
	EReference getHSVNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode#getHsv <em>Hsv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hsv</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode#getHsv()
	 * @see #getHSVNode()
	 * @generated
	 */
	EAttribute getHSVNode_Hsv();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.HSVNode#getName()
	 * @see #getHSVNode()
	 * @generated
	 */
	EAttribute getHSVNode_Name();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>HSV</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>HSV</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getHSV();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HSVTreeFactory getHSVTreeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.impl.HSVNodeImpl <em>HSV Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.impl.HSVNodeImpl
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.impl.HSVTreePackageImpl#getHSVNode()
		 * @generated
		 */
		EClass HSV_NODE = eINSTANCE.getHSVNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE__PARENT = eINSTANCE.getHSVNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE__CHILDREN = eINSTANCE.getHSVNode_Children();

		/**
		 * The meta object literal for the '<em><b>Hsv</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSV_NODE__HSV = eINSTANCE.getHSVNode_Hsv();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSV_NODE__NAME = eINSTANCE.getHSVNode_Name();

		/**
		 * The meta object literal for the '<em>HSV</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hls.HSVTree.impl.HSVTreePackageImpl#getHSV()
		 * @generated
		 */
		EDataType HSV = eINSTANCE.getHSV();

	}

} //HSVTreePackage
