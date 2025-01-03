/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
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
package example4.kiamaas;

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
 * @see example4.kiamaas.KiamaasFactory
 * @model kind="package"
 * @generated
 */
public interface KiamaasPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kiamaas";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example4/simplerkiamaas/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kiamaas";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KiamaasPackage eINSTANCE = example4.kiamaas.impl.KiamaasPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link example4.kiamaas.Top <em>Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top</em>'.
	 * @see example4.kiamaas.Top
	 * @generated
	 */
	EClass getTop();

	/**
	 * Returns the meta object for the containment reference '{@link example4.kiamaas.Top#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see example4.kiamaas.Top#getNode()
	 * @see #getTop()
	 * @generated
	 */
	EReference getTop_Node();

	/**
	 * Returns the meta object for class '{@link example4.kiamaas.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see example4.kiamaas.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link example4.kiamaas.Node#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see example4.kiamaas.Node#getHeight()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Height();

	/**
	 * Returns the meta object for the attribute '{@link example4.kiamaas.Node#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see example4.kiamaas.Node#getDepth()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Depth();

	/**
	 * Returns the meta object for class '{@link example4.kiamaas.Composite <em>Composite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite</em>'.
	 * @see example4.kiamaas.Composite
	 * @generated
	 */
	EClass getComposite();

	/**
	 * Returns the meta object for the containment reference '{@link example4.kiamaas.Composite#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Child</em>'.
	 * @see example4.kiamaas.Composite#getChild()
	 * @see #getComposite()
	 * @generated
	 */
	EReference getComposite_Child();

	/**
	 * Returns the meta object for class '{@link example4.kiamaas.Leaf <em>Leaf</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf</em>'.
	 * @see example4.kiamaas.Leaf
	 * @generated
	 */
	EClass getLeaf();

	/**
	 * Returns the meta object for class '{@link example4.kiamaas.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see example4.kiamaas.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KiamaasFactory getKiamaasFactory();

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
		 * The meta object literal for the '{@link example4.kiamaas.impl.TopImpl <em>Top</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamaas.impl.TopImpl
		 * @see example4.kiamaas.impl.KiamaasPackageImpl#getTop()
		 * @generated
		 */
		EClass TOP = eINSTANCE.getTop();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP__NODE = eINSTANCE.getTop_Node();

		/**
		 * The meta object literal for the '{@link example4.kiamaas.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamaas.impl.NodeImpl
		 * @see example4.kiamaas.impl.KiamaasPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__HEIGHT = eINSTANCE.getNode_Height();

		/**
		 * The meta object literal for the '<em><b>Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__DEPTH = eINSTANCE.getNode_Depth();

		/**
		 * The meta object literal for the '{@link example4.kiamaas.impl.CompositeImpl <em>Composite</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamaas.impl.CompositeImpl
		 * @see example4.kiamaas.impl.KiamaasPackageImpl#getComposite()
		 * @generated
		 */
		EClass COMPOSITE = eINSTANCE.getComposite();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE__CHILD = eINSTANCE.getComposite_Child();

		/**
		 * The meta object literal for the '{@link example4.kiamaas.impl.LeafImpl <em>Leaf</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamaas.impl.LeafImpl
		 * @see example4.kiamaas.impl.KiamaasPackageImpl#getLeaf()
		 * @generated
		 */
		EClass LEAF = eINSTANCE.getLeaf();

		/**
		 * The meta object literal for the '{@link example4.kiamaas.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamaas.impl.ElementImpl
		 * @see example4.kiamaas.impl.KiamaasPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

	}

} //KiamaasPackage
