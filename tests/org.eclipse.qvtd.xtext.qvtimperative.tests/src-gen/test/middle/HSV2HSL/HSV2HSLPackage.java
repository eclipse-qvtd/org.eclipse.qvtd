/*******************************************************************************
 * Copyright (c) 2014, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package test.middle.HSV2HSL;

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
 * @see test.middle.HSV2HSL.HSV2HSLFactory
 * @model kind="package"
 * @generated
 */
public interface HSV2HSLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HSV2HSL";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/examples/0.1/HSVtoHSL";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hsv2hsl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HSV2HSLPackage eINSTANCE = test.middle.HSV2HSL.impl.HSV2HSLPackageImpl.init();

	/**
	 * The meta object id for the '{@link test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl <em>HSV Node2 HSL Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl
	 * @see test.middle.HSV2HSL.impl.HSV2HSLPackageImpl#getHSVNode2HSLNode()
	 * @generated
	 */
	int HSV_NODE2_HSL_NODE = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HSL_NODE__PARENT = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HSL_NODE__CHILDREN = 1;

	/**
	 * The feature id for the '<em><b>Hsv</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HSL_NODE__HSV = 2;

	/**
	 * The feature id for the '<em><b>Hsl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HSL_NODE__HSL = 3;

	/**
	 * The feature id for the '<em><b>Rgb</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HSL_NODE__RGB = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HSL_NODE__NAME = 5;

	/**
	 * The number of structural features of the '<em>HSV Node2 HSL Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HSL_NODE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>HSV Node2 HSL Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HSV_NODE2_HSL_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '<em>RGB</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see test.middle.HSV2HSL.impl.HSV2HSLPackageImpl#getRGB()
	 * @generated
	 */
	int RGB = 1;


	/**
	 * Returns the meta object for class '{@link test.middle.HSV2HSL.HSVNode2HSLNode <em>HSV Node2 HSL Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HSV Node2 HSL Node</em>'.
	 * @see test.middle.HSV2HSL.HSVNode2HSLNode
	 * @generated
	 */
	EClass getHSVNode2HSLNode();

	/**
	 * Returns the meta object for the container reference '{@link test.middle.HSV2HSL.HSVNode2HSLNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see test.middle.HSV2HSL.HSVNode2HSLNode#getParent()
	 * @see #getHSVNode2HSLNode()
	 * @generated
	 */
	EReference getHSVNode2HSLNode_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link test.middle.HSV2HSL.HSVNode2HSLNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see test.middle.HSV2HSL.HSVNode2HSLNode#getChildren()
	 * @see #getHSVNode2HSLNode()
	 * @generated
	 */
	EReference getHSVNode2HSLNode_Children();

	/**
	 * Returns the meta object for the reference '{@link test.middle.HSV2HSL.HSVNode2HSLNode#getHsv <em>Hsv</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hsv</em>'.
	 * @see test.middle.HSV2HSL.HSVNode2HSLNode#getHsv()
	 * @see #getHSVNode2HSLNode()
	 * @generated
	 */
	EReference getHSVNode2HSLNode_Hsv();

	/**
	 * Returns the meta object for the reference '{@link test.middle.HSV2HSL.HSVNode2HSLNode#getHsl <em>Hsl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Hsl</em>'.
	 * @see test.middle.HSV2HSL.HSVNode2HSLNode#getHsl()
	 * @see #getHSVNode2HSLNode()
	 * @generated
	 */
	EReference getHSVNode2HSLNode_Hsl();

	/**
	 * Returns the meta object for the attribute '{@link test.middle.HSV2HSL.HSVNode2HSLNode#getRgb <em>Rgb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rgb</em>'.
	 * @see test.middle.HSV2HSL.HSVNode2HSLNode#getRgb()
	 * @see #getHSVNode2HSLNode()
	 * @generated
	 */
	EAttribute getHSVNode2HSLNode_Rgb();

	/**
	 * Returns the meta object for the attribute '{@link test.middle.HSV2HSL.HSVNode2HSLNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.middle.HSV2HSL.HSVNode2HSLNode#getName()
	 * @see #getHSVNode2HSLNode()
	 * @generated
	 */
	EAttribute getHSVNode2HSLNode_Name();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>RGB</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>RGB</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getRGB();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HSV2HSLFactory getHSV2HSLFactory();

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
		 * The meta object literal for the '{@link test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl <em>HSV Node2 HSL Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.middle.HSV2HSL.impl.HSVNode2HSLNodeImpl
		 * @see test.middle.HSV2HSL.impl.HSV2HSLPackageImpl#getHSVNode2HSLNode()
		 * @generated
		 */
		EClass HSV_NODE2_HSL_NODE = eINSTANCE.getHSVNode2HSLNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE2_HSL_NODE__PARENT = eINSTANCE.getHSVNode2HSLNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE2_HSL_NODE__CHILDREN = eINSTANCE.getHSVNode2HSLNode_Children();

		/**
		 * The meta object literal for the '<em><b>Hsv</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE2_HSL_NODE__HSV = eINSTANCE.getHSVNode2HSLNode_Hsv();

		/**
		 * The meta object literal for the '<em><b>Hsl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSV_NODE2_HSL_NODE__HSL = eINSTANCE.getHSVNode2HSLNode_Hsl();

		/**
		 * The meta object literal for the '<em><b>Rgb</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSV_NODE2_HSL_NODE__RGB = eINSTANCE.getHSVNode2HSLNode_Rgb();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSV_NODE2_HSL_NODE__NAME = eINSTANCE.getHSVNode2HSLNode_Name();

		/**
		 * The meta object literal for the '<em>RGB</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see test.middle.HSV2HSL.impl.HSV2HSLPackageImpl#getRGB()
		 * @generated
		 */
		EDataType RGB = eINSTANCE.getRGB();

	}

} //HSV2HSLPackage
