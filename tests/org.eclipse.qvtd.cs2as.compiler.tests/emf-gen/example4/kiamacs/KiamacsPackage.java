/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
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
package example4.kiamacs;

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
 * @see example4.kiamacs.KiamacsFactory
 * @model kind="package"
 * @generated
 */
public interface KiamacsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "kiamacs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example4/simplerkiamacs/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "kiamacs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	KiamacsPackage eINSTANCE = example4.kiamacs.impl.KiamacsPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link example4.kiamacs.TopCS <em>Top CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Top CS</em>'.
	 * @see example4.kiamacs.TopCS
	 * @generated
	 */
	EClass getTopCS();

	/**
	 * Returns the meta object for the containment reference '{@link example4.kiamacs.TopCS#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Node</em>'.
	 * @see example4.kiamacs.TopCS#getNode()
	 * @see #getTopCS()
	 * @generated
	 */
	EReference getTopCS_Node();

	/**
	 * Returns the meta object for class '{@link example4.kiamacs.NodeCS <em>Node CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node CS</em>'.
	 * @see example4.kiamacs.NodeCS
	 * @generated
	 */
	EClass getNodeCS();

	/**
	 * Returns the meta object for class '{@link example4.kiamacs.CompositeCS <em>Composite CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite CS</em>'.
	 * @see example4.kiamacs.CompositeCS
	 * @generated
	 */
	EClass getCompositeCS();

	/**
	 * Returns the meta object for the containment reference '{@link example4.kiamacs.CompositeCS#getChild <em>Child</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Child</em>'.
	 * @see example4.kiamacs.CompositeCS#getChild()
	 * @see #getCompositeCS()
	 * @generated
	 */
	EReference getCompositeCS_Child();

	/**
	 * Returns the meta object for class '{@link example4.kiamacs.LeafCS <em>Leaf CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leaf CS</em>'.
	 * @see example4.kiamacs.LeafCS
	 * @generated
	 */
	EClass getLeafCS();

	/**
	 * Returns the meta object for class '{@link example4.kiamacs.BaseCS <em>Base CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base CS</em>'.
	 * @see example4.kiamacs.BaseCS
	 * @generated
	 */
	EClass getBaseCS();

	/**
	 * Returns the meta object for the reference '{@link example4.kiamacs.BaseCS#getAst <em>Ast</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ast</em>'.
	 * @see example4.kiamacs.BaseCS#getAst()
	 * @see #getBaseCS()
	 * @generated
	 */
	EReference getBaseCS_Ast();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	KiamacsFactory getKiamacsFactory();

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
		 * The meta object literal for the '{@link example4.kiamacs.impl.TopCSImpl <em>Top CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.TopCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getTopCS()
		 * @generated
		 */
		EClass TOP_CS = eINSTANCE.getTopCS();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOP_CS__NODE = eINSTANCE.getTopCS_Node();

		/**
		 * The meta object literal for the '{@link example4.kiamacs.impl.NodeCSImpl <em>Node CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.NodeCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getNodeCS()
		 * @generated
		 */
		EClass NODE_CS = eINSTANCE.getNodeCS();

		/**
		 * The meta object literal for the '{@link example4.kiamacs.impl.CompositeCSImpl <em>Composite CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.CompositeCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getCompositeCS()
		 * @generated
		 */
		EClass COMPOSITE_CS = eINSTANCE.getCompositeCS();

		/**
		 * The meta object literal for the '<em><b>Child</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_CS__CHILD = eINSTANCE.getCompositeCS_Child();

		/**
		 * The meta object literal for the '{@link example4.kiamacs.impl.LeafCSImpl <em>Leaf CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.LeafCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getLeafCS()
		 * @generated
		 */
		EClass LEAF_CS = eINSTANCE.getLeafCS();

		/**
		 * The meta object literal for the '{@link example4.kiamacs.impl.BaseCSImpl <em>Base CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example4.kiamacs.impl.BaseCSImpl
		 * @see example4.kiamacs.impl.KiamacsPackageImpl#getBaseCS()
		 * @generated
		 */
		EClass BASE_CS = eINSTANCE.getBaseCS();

		/**
		 * The meta object literal for the '<em><b>Ast</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASE_CS__AST = eINSTANCE.getBaseCS_Ast();

	}

} //KiamacsPackage
