/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
package example2.classescstraces;

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
 * @see example2.classescstraces.ClassescstracesFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import classes='Classes.ecore#/' classescs='ClassesCS.ecore#/'"
 * @generated
 */
public interface ClassescstracesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "classescstraces";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://cs2as/tests/example2/classescs2as/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "classescstraces";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ClassescstracesPackage eINSTANCE = example2.classescstraces.impl.ClassescstracesPackageImpl.init();

	/**
	 * The meta object id for the '{@link example2.classescstraces.impl.PackageCS2PackageImpl <em>Package CS2 Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example2.classescstraces.impl.PackageCS2PackageImpl
	 * @see example2.classescstraces.impl.ClassescstracesPackageImpl#getPackageCS2Package()
	 * @generated
	 */
	int PACKAGE_CS2_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Package CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS2_PACKAGE__PACKAGE_CS = 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS2_PACKAGE__PACKAGE = 1;

	/**
	 * The number of structural features of the '<em>Package CS2 Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS2_PACKAGE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Package CS2 Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_CS2_PACKAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link example2.classescstraces.impl.ClassCS2ClassImpl <em>Class CS2 Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example2.classescstraces.impl.ClassCS2ClassImpl
	 * @see example2.classescstraces.impl.ClassescstracesPackageImpl#getClassCS2Class()
	 * @generated
	 */
	int CLASS_CS2_CLASS = 1;

	/**
	 * The feature id for the '<em><b>Class CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS2_CLASS__CLASS_CS = 0;

	/**
	 * The feature id for the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS2_CLASS__CLASS = 1;

	/**
	 * The number of structural features of the '<em>Class CS2 Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS2_CLASS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Class CS2 Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_CS2_CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link example2.classescstraces.impl.RootCS2RootImpl <em>Root CS2 Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see example2.classescstraces.impl.RootCS2RootImpl
	 * @see example2.classescstraces.impl.ClassescstracesPackageImpl#getRootCS2Root()
	 * @generated
	 */
	int ROOT_CS2_ROOT = 2;

	/**
	 * The feature id for the '<em><b>Root CS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS2_ROOT__ROOT_CS = 0;

	/**
	 * The feature id for the '<em><b>Root</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS2_ROOT__ROOT = 1;

	/**
	 * The number of structural features of the '<em>Root CS2 Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS2_ROOT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Root CS2 Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_CS2_ROOT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link example2.classescstraces.PackageCS2Package <em>Package CS2 Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package CS2 Package</em>'.
	 * @see example2.classescstraces.PackageCS2Package
	 * @generated
	 */
	EClass getPackageCS2Package();

	/**
	 * Returns the meta object for the reference '{@link example2.classescstraces.PackageCS2Package#getPackageCS <em>Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package CS</em>'.
	 * @see example2.classescstraces.PackageCS2Package#getPackageCS()
	 * @see #getPackageCS2Package()
	 * @generated
	 */
	EReference getPackageCS2Package_PackageCS();

	/**
	 * Returns the meta object for the reference '{@link example2.classescstraces.PackageCS2Package#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Package</em>'.
	 * @see example2.classescstraces.PackageCS2Package#getPackage()
	 * @see #getPackageCS2Package()
	 * @generated
	 */
	EReference getPackageCS2Package_Package();

	/**
	 * Returns the meta object for class '{@link example2.classescstraces.ClassCS2Class <em>Class CS2 Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class CS2 Class</em>'.
	 * @see example2.classescstraces.ClassCS2Class
	 * @generated
	 */
	EClass getClassCS2Class();

	/**
	 * Returns the meta object for the reference '{@link example2.classescstraces.ClassCS2Class#getClassCS <em>Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class CS</em>'.
	 * @see example2.classescstraces.ClassCS2Class#getClassCS()
	 * @see #getClassCS2Class()
	 * @generated
	 */
	EReference getClassCS2Class_ClassCS();

	/**
	 * Returns the meta object for the reference '{@link example2.classescstraces.ClassCS2Class#getClass_ <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class</em>'.
	 * @see example2.classescstraces.ClassCS2Class#getClass_()
	 * @see #getClassCS2Class()
	 * @generated
	 */
	EReference getClassCS2Class_Class();

	/**
	 * Returns the meta object for class '{@link example2.classescstraces.RootCS2Root <em>Root CS2 Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root CS2 Root</em>'.
	 * @see example2.classescstraces.RootCS2Root
	 * @generated
	 */
	EClass getRootCS2Root();

	/**
	 * Returns the meta object for the reference '{@link example2.classescstraces.RootCS2Root#getRootCS <em>Root CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root CS</em>'.
	 * @see example2.classescstraces.RootCS2Root#getRootCS()
	 * @see #getRootCS2Root()
	 * @generated
	 */
	EReference getRootCS2Root_RootCS();

	/**
	 * Returns the meta object for the reference '{@link example2.classescstraces.RootCS2Root#getRoot <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Root</em>'.
	 * @see example2.classescstraces.RootCS2Root#getRoot()
	 * @see #getRootCS2Root()
	 * @generated
	 */
	EReference getRootCS2Root_Root();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ClassescstracesFactory getClassescstracesFactory();

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
		 * The meta object literal for the '{@link example2.classescstraces.impl.PackageCS2PackageImpl <em>Package CS2 Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example2.classescstraces.impl.PackageCS2PackageImpl
		 * @see example2.classescstraces.impl.ClassescstracesPackageImpl#getPackageCS2Package()
		 * @generated
		 */
		EClass PACKAGE_CS2_PACKAGE = eINSTANCE.getPackageCS2Package();

		/**
		 * The meta object literal for the '<em><b>Package CS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS2_PACKAGE__PACKAGE_CS = eINSTANCE.getPackageCS2Package_PackageCS();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE_CS2_PACKAGE__PACKAGE = eINSTANCE.getPackageCS2Package_Package();

		/**
		 * The meta object literal for the '{@link example2.classescstraces.impl.ClassCS2ClassImpl <em>Class CS2 Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example2.classescstraces.impl.ClassCS2ClassImpl
		 * @see example2.classescstraces.impl.ClassescstracesPackageImpl#getClassCS2Class()
		 * @generated
		 */
		EClass CLASS_CS2_CLASS = eINSTANCE.getClassCS2Class();

		/**
		 * The meta object literal for the '<em><b>Class CS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS2_CLASS__CLASS_CS = eINSTANCE.getClassCS2Class_ClassCS();

		/**
		 * The meta object literal for the '<em><b>Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_CS2_CLASS__CLASS = eINSTANCE.getClassCS2Class_Class();

		/**
		 * The meta object literal for the '{@link example2.classescstraces.impl.RootCS2RootImpl <em>Root CS2 Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see example2.classescstraces.impl.RootCS2RootImpl
		 * @see example2.classescstraces.impl.ClassescstracesPackageImpl#getRootCS2Root()
		 * @generated
		 */
		EClass ROOT_CS2_ROOT = eINSTANCE.getRootCS2Root();

		/**
		 * The meta object literal for the '<em><b>Root CS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS2_ROOT__ROOT_CS = eINSTANCE.getRootCS2Root_RootCS();

		/**
		 * The meta object literal for the '<em><b>Root</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT_CS2_ROOT__ROOT = eINSTANCE.getRootCS2Root_Root();

	}

} //ClassescstracesPackage
