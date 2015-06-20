/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package tree2talltree.talltree;

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
 * @see tree2talltree.talltree.TalltreeFactory
 * @model kind="package"
 * @generated
 */
public interface TalltreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "talltree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/examples/0.1/TallTree";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "talltree";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TalltreePackage eINSTANCE = tree2talltree.talltree.impl.TalltreePackageImpl.init();

	/**
	 * The meta object id for the '{@link tree2talltree.talltree.impl.TallNodeImpl <em>Tall Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tree2talltree.talltree.impl.TallNodeImpl
	 * @see tree2talltree.talltree.impl.TalltreePackageImpl#getTallNode()
	 * @generated
	 */
	int TALL_NODE = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TALL_NODE__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TALL_NODE__HEIGHT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TALL_NODE__NAME = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TALL_NODE__PARENT = 3;

	/**
	 * The number of structural features of the '<em>Tall Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TALL_NODE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Tall Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TALL_NODE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link tree2talltree.talltree.TallNode <em>Tall Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tall Node</em>'.
	 * @see tree2talltree.talltree.TallNode
	 * @generated
	 */
	EClass getTallNode();

	/**
	 * Returns the meta object for the containment reference list '{@link tree2talltree.talltree.TallNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see tree2talltree.talltree.TallNode#getChildren()
	 * @see #getTallNode()
	 * @generated
	 */
	EReference getTallNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link tree2talltree.talltree.TallNode#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see tree2talltree.talltree.TallNode#getHeight()
	 * @see #getTallNode()
	 * @generated
	 */
	EAttribute getTallNode_Height();

	/**
	 * Returns the meta object for the attribute '{@link tree2talltree.talltree.TallNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tree2talltree.talltree.TallNode#getName()
	 * @see #getTallNode()
	 * @generated
	 */
	EAttribute getTallNode_Name();

	/**
	 * Returns the meta object for the container reference '{@link tree2talltree.talltree.TallNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see tree2talltree.talltree.TallNode#getParent()
	 * @see #getTallNode()
	 * @generated
	 */
	EReference getTallNode_Parent();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TalltreeFactory getTalltreeFactory();

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
		 * The meta object literal for the '{@link tree2talltree.talltree.impl.TallNodeImpl <em>Tall Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tree2talltree.talltree.impl.TallNodeImpl
		 * @see tree2talltree.talltree.impl.TalltreePackageImpl#getTallNode()
		 * @generated
		 */
		EClass TALL_NODE = eINSTANCE.getTallNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TALL_NODE__CHILDREN = eINSTANCE.getTallNode_Children();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TALL_NODE__HEIGHT = eINSTANCE.getTallNode_Height();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TALL_NODE__NAME = eINSTANCE.getTallNode_Name();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TALL_NODE__PARENT = eINSTANCE.getTallNode_Parent();

	}

} //TalltreePackage
