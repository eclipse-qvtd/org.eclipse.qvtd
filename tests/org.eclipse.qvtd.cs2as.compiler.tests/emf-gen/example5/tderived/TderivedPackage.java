/*******************************************************************************
 * Copyright (c) 2016, 2021 Willink Transformations and others.
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
package example5.tderived;

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
 * @see example5.tderived.TderivedFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore"
 * @generated
 */
public interface TderivedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "tderived";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example5/targetDerivedMM/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "tderived";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TderivedPackage eINSTANCE = example5.tderived.impl.TderivedPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link example5.tderived.A2 <em>A2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>A2</em>'.
	 * @see example5.tderived.A2
	 * @generated
	 */
	EClass getA2();

	/**
	 * Returns the meta object for the containment reference list '{@link example5.tderived.A2#getOwnsD <em>Owns D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owns D</em>'.
	 * @see example5.tderived.A2#getOwnsD()
	 * @see #getA2()
	 * @generated
	 */
	EReference getA2_OwnsD();

	/**
	 * Returns the meta object for class '{@link example5.tderived.B2 <em>B2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B2</em>'.
	 * @see example5.tderived.B2
	 * @generated
	 */
	EClass getB2();

	/**
	 * Returns the meta object for the attribute '{@link example5.tderived.B2#getAnotherName <em>Another Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Another Name</em>'.
	 * @see example5.tderived.B2#getAnotherName()
	 * @see #getB2()
	 * @generated
	 */
	EAttribute getB2_AnotherName();

	/**
	 * Returns the meta object for class '{@link example5.tderived.D <em>D</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>D</em>'.
	 * @see example5.tderived.D
	 * @generated
	 */
	EClass getD();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TderivedFactory getTderivedFactory();

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
		 * The meta object literal for the '{@link example5.tderived.impl.A2Impl <em>A2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.tderived.impl.A2Impl
		 * @see example5.tderived.impl.TderivedPackageImpl#getA2()
		 * @generated
		 */
		EClass A2 = eINSTANCE.getA2();

		/**
		 * The meta object literal for the '<em><b>Owns D</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference A2__OWNS_D = eINSTANCE.getA2_OwnsD();

		/**
		 * The meta object literal for the '{@link example5.tderived.impl.B2Impl <em>B2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.tderived.impl.B2Impl
		 * @see example5.tderived.impl.TderivedPackageImpl#getB2()
		 * @generated
		 */
		EClass B2 = eINSTANCE.getB2();

		/**
		 * The meta object literal for the '<em><b>Another Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute B2__ANOTHER_NAME = eINSTANCE.getB2_AnotherName();

		/**
		 * The meta object literal for the '{@link example5.tderived.impl.DImpl <em>D</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.tderived.impl.DImpl
		 * @see example5.tderived.impl.TderivedPackageImpl#getD()
		 * @generated
		 */
		EClass D = eINSTANCE.getD();

	}

} //TderivedPackage
