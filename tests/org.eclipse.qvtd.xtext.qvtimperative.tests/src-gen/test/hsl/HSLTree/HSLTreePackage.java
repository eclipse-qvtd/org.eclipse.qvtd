/*******************************************************************************
 * Copyright (c) 2014, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package test.hsl.HSLTree;

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
 * @see test.hsl.HSLTree.HSLTreeFactory
 * @model kind="package"
 * @generated
 */
public interface HSLTreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "HSLTree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/examples/0.1/HSLTree";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "hsl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	HSLTreePackage eINSTANCE = test.hsl.HSLTree.impl.HSLTreePackageImpl.init();

	/**
	 * Returns the meta object for class '{@link test.hsl.HSLTree.HSLNode <em>HSL Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HSL Node</em>'.
	 * @see test.hsl.HSLTree.HSLNode
	 * @generated
	 */
	EClass getHSLNode();

	/**
	 * Returns the meta object for the container reference '{@link test.hsl.HSLTree.HSLNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see test.hsl.HSLTree.HSLNode#getParent()
	 * @see #getHSLNode()
	 * @generated
	 */
	EReference getHSLNode_Parent();

	/**
	 * Returns the meta object for the containment reference list '{@link test.hsl.HSLTree.HSLNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see test.hsl.HSLTree.HSLNode#getChildren()
	 * @see #getHSLNode()
	 * @generated
	 */
	EReference getHSLNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link test.hsl.HSLTree.HSLNode#getHsl <em>Hsl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hsl</em>'.
	 * @see test.hsl.HSLTree.HSLNode#getHsl()
	 * @see #getHSLNode()
	 * @generated
	 */
	EAttribute getHSLNode_Hsl();

	/**
	 * Returns the meta object for the attribute '{@link test.hsl.HSLTree.HSLNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see test.hsl.HSLTree.HSLNode#getName()
	 * @see #getHSLNode()
	 * @generated
	 */
	EAttribute getHSLNode_Name();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>HSL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>HSL</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getHSL();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	HSLTreeFactory getHSLTreeFactory();

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
		 * The meta object literal for the '{@link test.hsl.HSLTree.impl.HSLNodeImpl <em>HSL Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see test.hsl.HSLTree.impl.HSLNodeImpl
		 * @see test.hsl.HSLTree.impl.HSLTreePackageImpl#getHSLNode()
		 * @generated
		 */
		EClass HSL_NODE = eINSTANCE.getHSLNode();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSL_NODE__PARENT = eINSTANCE.getHSLNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HSL_NODE__CHILDREN = eINSTANCE.getHSLNode_Children();

		/**
		 * The meta object literal for the '<em><b>Hsl</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSL_NODE__HSL = eINSTANCE.getHSLNode_Hsl();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HSL_NODE__NAME = eINSTANCE.getHSLNode_Name();

		/**
		 * The meta object literal for the '<em>HSL</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see test.hsl.HSLTree.impl.HSLTreePackageImpl#getHSL()
		 * @generated
		 */
		EDataType HSL = eINSTANCE.getHSL();

	}

} //HSLTreePackage
