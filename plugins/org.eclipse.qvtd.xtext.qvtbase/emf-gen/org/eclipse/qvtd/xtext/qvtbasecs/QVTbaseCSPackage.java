/**
 * Copyright (c) 2010, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs;

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
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSFactory
 * @model kind="package"
 * @generated
 */
public interface QVTbaseCSPackage extends EPackage
{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtbasecs";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/ocl/2016/QVTbaseCS";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtbcs";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTbaseCSPackage eINSTANCE = org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl <em>Abstract Transformation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getAbstractTransformationCS()
	 * @generated
	 */
	int ABSTRACT_TRANSFORMATION_CS = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.JavaClassCSImpl <em>Java Class CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.JavaClassCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getJavaClassCS()
	 * @generated
	 */
	int JAVA_CLASS_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.JavaImplementationCSImpl <em>Java Implementation CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.JavaImplementationCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getJavaImplementationCS()
	 * @generated
	 */
	int JAVA_IMPLEMENTATION_CS = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.QualifiedPackageCSImpl <em>Qualified Package CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QualifiedPackageCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getQualifiedPackageCS()
	 * @generated
	 */
	int QUALIFIED_PACKAGE_CS = 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS <em>Abstract Transformation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Transformation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS
	 * @generated
	 */
	EClass getAbstractTransformationCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS#getOwnedPathName()
	 * @see #getAbstractTransformationCS()
	 * @generated
	 */
	EReference getAbstractTransformationCS_OwnedPathName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtbasecs.JavaClassCS <em>Java Class CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Class CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.JavaClassCS
	 * @generated
	 */
	EClass getJavaClassCS();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS <em>Java Implementation CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Implementation CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS
	 * @generated
	 */
	EClass getJavaImplementationCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS#getImplementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Implementation</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.JavaImplementationCS#getImplementation()
	 * @see #getJavaImplementationCS()
	 * @generated
	 */
	EReference getJavaImplementationCS_Implementation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS <em>Qualified Package CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualified Package CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS
	 * @generated
	 */
	EClass getQualifiedPackageCS();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS#getOwnedPathName <em>Owned Path Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Path Name</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS#getOwnedPathName()
	 * @see #getQualifiedPackageCS()
	 * @generated
	 */
	EReference getQualifiedPackageCS_OwnedPathName();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTbaseCSFactory getQVTbaseCSFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals
	{
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl <em>Abstract Transformation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.AbstractTransformationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getAbstractTransformationCS()
		 * @generated
		 */
		EClass ABSTRACT_TRANSFORMATION_CS = eINSTANCE.getAbstractTransformationCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME = eINSTANCE.getAbstractTransformationCS_OwnedPathName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.JavaClassCSImpl <em>Java Class CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.JavaClassCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getJavaClassCS()
		 * @generated
		 */
		EClass JAVA_CLASS_CS = eINSTANCE.getJavaClassCS();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.JavaImplementationCSImpl <em>Java Implementation CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.JavaImplementationCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getJavaImplementationCS()
		 * @generated
		 */
		EClass JAVA_IMPLEMENTATION_CS = eINSTANCE.getJavaImplementationCS();

		/**
		 * The meta object literal for the '<em><b>Implementation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JAVA_IMPLEMENTATION_CS__IMPLEMENTATION = eINSTANCE.getJavaImplementationCS_Implementation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.QualifiedPackageCSImpl <em>Qualified Package CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QualifiedPackageCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getQualifiedPackageCS()
		 * @generated
		 */
		EClass QUALIFIED_PACKAGE_CS = eINSTANCE.getQualifiedPackageCS();

		/**
		 * The meta object literal for the '<em><b>Owned Path Name</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME = eINSTANCE.getQualifiedPackageCS_OwnedPathName();

	}

} //QVTbaseCSPackage
