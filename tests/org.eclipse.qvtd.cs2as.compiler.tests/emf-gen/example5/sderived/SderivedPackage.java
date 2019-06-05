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
package example5.sderived;

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
 * @see example5.sderived.SderivedFactory
 * @model kind="package"
 * @generated
 */
public interface SderivedPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sderived";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example5/sourceDerivedMM/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "sderived";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SderivedPackage eINSTANCE = example5.sderived.impl.SderivedPackageImpl.init();

	/**
	 * Returns the meta object for class '{@link example5.sderived.X2 <em>X2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>X2</em>'.
	 * @see example5.sderived.X2
	 * @generated
	 */
	EClass getX2();

	/**
	 * Returns the meta object for the containment reference list '{@link example5.sderived.X2#getOwnsW <em>Owns W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owns W</em>'.
	 * @see example5.sderived.X2#getOwnsW()
	 * @see #getX2()
	 * @generated
	 */
	EReference getX2_OwnsW();

	/**
	 * Returns the meta object for class '{@link example5.sderived.Y2 <em>Y2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Y2</em>'.
	 * @see example5.sderived.Y2
	 * @generated
	 */
	EClass getY2();

	/**
	 * Returns the meta object for the attribute '{@link example5.sderived.Y2#getName2 <em>Name2</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name2</em>'.
	 * @see example5.sderived.Y2#getName2()
	 * @see #getY2()
	 * @generated
	 */
	EAttribute getY2_Name2();

	/**
	 * Returns the meta object for class '{@link example5.sderived.W <em>W</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>W</em>'.
	 * @see example5.sderived.W
	 * @generated
	 */
	EClass getW();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SderivedFactory getSderivedFactory();

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
		 * The meta object literal for the '{@link example5.sderived.impl.X2Impl <em>X2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sderived.impl.X2Impl
		 * @see example5.sderived.impl.SderivedPackageImpl#getX2()
		 * @generated
		 */
		EClass X2 = eINSTANCE.getX2();

		/**
		 * The meta object literal for the '<em><b>Owns W</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference X2__OWNS_W = eINSTANCE.getX2_OwnsW();

		/**
		 * The meta object literal for the '{@link example5.sderived.impl.Y2Impl <em>Y2</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sderived.impl.Y2Impl
		 * @see example5.sderived.impl.SderivedPackageImpl#getY2()
		 * @generated
		 */
		EClass Y2 = eINSTANCE.getY2();

		/**
		 * The meta object literal for the '<em><b>Name2</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute Y2__NAME2 = eINSTANCE.getY2_Name2();

		/**
		 * The meta object literal for the '{@link example5.sderived.impl.WImpl <em>W</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example5.sderived.impl.WImpl
		 * @see example5.sderived.impl.SderivedPackageImpl#getW()
		 * @generated
		 */
		EClass W = eINSTANCE.getW();

	}

} //SderivedPackage
