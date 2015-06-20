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
package tree2talltree.tree2talltree;

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
 * @see tree2talltree.tree2talltree.Tree2talltreeFactory
 * @model kind="package"
 * @generated
 */
public interface Tree2talltreePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tree2talltree";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/examples/0.1/List2List";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "l2l";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Tree2talltreePackage eINSTANCE = tree2talltree.tree2talltree.impl.Tree2talltreePackageImpl.init();

	/**
	 * The meta object id for the '{@link tree2talltree.tree2talltree.impl.Node2TallNodeImpl <em>Node2 Tall Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see tree2talltree.tree2talltree.impl.Node2TallNodeImpl
	 * @see tree2talltree.tree2talltree.impl.Tree2talltreePackageImpl#getNode2TallNode()
	 * @generated
	 */
	int NODE2_TALL_NODE = 0;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE2_TALL_NODE__CHILDREN = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE2_TALL_NODE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE2_TALL_NODE__PARENT = 2;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE2_TALL_NODE__NODE = 3;

	/**
	 * The feature id for the '<em><b>Tall Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE2_TALL_NODE__TALL_NODE = 4;

	/**
	 * The number of structural features of the '<em>Node2 Tall Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE2_TALL_NODE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Node2 Tall Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE2_TALL_NODE_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link tree2talltree.tree2talltree.Node2TallNode <em>Node2 Tall Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node2 Tall Node</em>'.
	 * @see tree2talltree.tree2talltree.Node2TallNode
	 * @generated
	 */
	EClass getNode2TallNode();

	/**
	 * Returns the meta object for the containment reference list '{@link tree2talltree.tree2talltree.Node2TallNode#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see tree2talltree.tree2talltree.Node2TallNode#getChildren()
	 * @see #getNode2TallNode()
	 * @generated
	 */
	EReference getNode2TallNode_Children();

	/**
	 * Returns the meta object for the attribute '{@link tree2talltree.tree2talltree.Node2TallNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see tree2talltree.tree2talltree.Node2TallNode#getName()
	 * @see #getNode2TallNode()
	 * @generated
	 */
	EAttribute getNode2TallNode_Name();

	/**
	 * Returns the meta object for the container reference '{@link tree2talltree.tree2talltree.Node2TallNode#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see tree2talltree.tree2talltree.Node2TallNode#getParent()
	 * @see #getNode2TallNode()
	 * @generated
	 */
	EReference getNode2TallNode_Parent();

	/**
	 * Returns the meta object for the reference '{@link tree2talltree.tree2talltree.Node2TallNode#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see tree2talltree.tree2talltree.Node2TallNode#getNode()
	 * @see #getNode2TallNode()
	 * @generated
	 */
	EReference getNode2TallNode_Node();

	/**
	 * Returns the meta object for the reference '{@link tree2talltree.tree2talltree.Node2TallNode#getTallNode <em>Tall Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Tall Node</em>'.
	 * @see tree2talltree.tree2talltree.Node2TallNode#getTallNode()
	 * @see #getNode2TallNode()
	 * @generated
	 */
	EReference getNode2TallNode_TallNode();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	Tree2talltreeFactory getTree2talltreeFactory();

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
		 * The meta object literal for the '{@link tree2talltree.tree2talltree.impl.Node2TallNodeImpl <em>Node2 Tall Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see tree2talltree.tree2talltree.impl.Node2TallNodeImpl
		 * @see tree2talltree.tree2talltree.impl.Tree2talltreePackageImpl#getNode2TallNode()
		 * @generated
		 */
		EClass NODE2_TALL_NODE = eINSTANCE.getNode2TallNode();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE2_TALL_NODE__CHILDREN = eINSTANCE.getNode2TallNode_Children();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE2_TALL_NODE__NAME = eINSTANCE.getNode2TallNode_Name();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE2_TALL_NODE__PARENT = eINSTANCE.getNode2TallNode_Parent();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE2_TALL_NODE__NODE = eINSTANCE.getNode2TallNode_Node();

		/**
		 * The meta object literal for the '<em><b>Tall Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE2_TALL_NODE__TALL_NODE = eINSTANCE.getNode2TallNode_TallNode();

	}

} //Tree2talltreePackage
