/**
 * Copyright (c) 2010, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.TargetElementCSImpl <em>Target Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.TargetElementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getTargetElementCS()
	 * @generated
	 */
	int TARGET_ELEMENT_CS = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.CompoundTargetElementCSImpl <em>Compound Target Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.CompoundTargetElementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getCompoundTargetElementCS()
	 * @generated
	 */
	int COMPOUND_TARGET_ELEMENT_CS = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.DummyQVTbaseConstraintClassImpl <em>Dummy QV Tbase Constraint Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.DummyQVTbaseConstraintClassImpl
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getDummyQVTbaseConstraintClass()
	 * @generated
	 */
	int DUMMY_QV_TBASE_CONSTRAINT_CLASS = 2;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.SimpleTargetElementCSImpl <em>Simple Target Element CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.SimpleTargetElementCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getSimpleTargetElementCS()
	 * @generated
	 */
	int SIMPLE_TARGET_ELEMENT_CS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.TargetCSImpl <em>Target CS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.TargetCSImpl
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getTargetCS()
	 * @generated
	 */
	int TARGET_CS = 5;

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS#getOwnedTargets <em>Owned Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Targets</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS#getOwnedTargets()
	 * @see #getAbstractTransformationCS()
	 * @generated
	 */
	EReference getAbstractTransformationCS_OwnedTargets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtbasecs.CompoundTargetElementCS <em>Compound Target Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound Target Element CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.CompoundTargetElementCS
	 * @generated
	 */
	EClass getCompoundTargetElementCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtbasecs.CompoundTargetElementCS#getOwnedTargetElements <em>Owned Target Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Target Elements</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.CompoundTargetElementCS#getOwnedTargetElements()
	 * @see #getCompoundTargetElementCS()
	 * @generated
	 */
	EReference getCompoundTargetElementCS_OwnedTargetElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtbasecs.DummyQVTbaseConstraintClass <em>Dummy QV Tbase Constraint Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dummy QV Tbase Constraint Class</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.DummyQVTbaseConstraintClass
	 * @generated
	 */
	EClass getDummyQVTbaseConstraintClass();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS <em>Simple Target Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Target Element CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS
	 * @generated
	 */
	EClass getSimpleTargetElementCS();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getTypedModel()
	 * @see #getSimpleTargetElementCS()
	 * @generated
	 */
	EReference getSimpleTargetElementCS_TypedModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getIterates <em>Iterates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Iterates</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getIterates()
	 * @see #getSimpleTargetElementCS()
	 * @generated
	 */
	EReference getSimpleTargetElementCS_Iterates();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Input</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getInput()
	 * @see #getSimpleTargetElementCS()
	 * @generated
	 */
	EAttribute getSimpleTargetElementCS_Input();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getOutput <em>Output</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Output</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getOutput()
	 * @see #getSimpleTargetElementCS()
	 * @generated
	 */
	EAttribute getSimpleTargetElementCS_Output();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getVia <em>Via</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Via</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.SimpleTargetElementCS#getVia()
	 * @see #getSimpleTargetElementCS()
	 * @generated
	 */
	EAttribute getSimpleTargetElementCS_Via();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtbasecs.TargetCS <em>Target CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.TargetCS
	 * @generated
	 */
	EClass getTargetCS();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.xtext.qvtbasecs.TargetCS#getOwnedTargetElements <em>Owned Target Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Target Elements</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.TargetCS#getOwnedTargetElements()
	 * @see #getTargetCS()
	 * @generated
	 */
	EReference getTargetCS_OwnedTargetElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.xtext.qvtbasecs.TargetElementCS <em>Target Element CS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Element CS</em>'.
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.TargetElementCS
	 * @generated
	 */
	EClass getTargetElementCS();

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
		 * The meta object literal for the '<em><b>Owned Targets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_TRANSFORMATION_CS__OWNED_TARGETS = eINSTANCE.getAbstractTransformationCS_OwnedTargets();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.CompoundTargetElementCSImpl <em>Compound Target Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.CompoundTargetElementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getCompoundTargetElementCS()
		 * @generated
		 */
		EClass COMPOUND_TARGET_ELEMENT_CS = eINSTANCE.getCompoundTargetElementCS();

		/**
		 * The meta object literal for the '<em><b>Owned Target Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND_TARGET_ELEMENT_CS__OWNED_TARGET_ELEMENTS = eINSTANCE.getCompoundTargetElementCS_OwnedTargetElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.DummyQVTbaseConstraintClassImpl <em>Dummy QV Tbase Constraint Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.DummyQVTbaseConstraintClassImpl
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getDummyQVTbaseConstraintClass()
		 * @generated
		 */
		EClass DUMMY_QV_TBASE_CONSTRAINT_CLASS = eINSTANCE.getDummyQVTbaseConstraintClass();

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

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.SimpleTargetElementCSImpl <em>Simple Target Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.SimpleTargetElementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getSimpleTargetElementCS()
		 * @generated
		 */
		EClass SIMPLE_TARGET_ELEMENT_CS = eINSTANCE.getSimpleTargetElementCS();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_TARGET_ELEMENT_CS__TYPED_MODEL = eINSTANCE.getSimpleTargetElementCS_TypedModel();

		/**
		 * The meta object literal for the '<em><b>Iterates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_TARGET_ELEMENT_CS__ITERATES = eINSTANCE.getSimpleTargetElementCS_Iterates();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TARGET_ELEMENT_CS__INPUT = eINSTANCE.getSimpleTargetElementCS_Input();

		/**
		 * The meta object literal for the '<em><b>Output</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TARGET_ELEMENT_CS__OUTPUT = eINSTANCE.getSimpleTargetElementCS_Output();

		/**
		 * The meta object literal for the '<em><b>Via</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_TARGET_ELEMENT_CS__VIA = eINSTANCE.getSimpleTargetElementCS_Via();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.TargetCSImpl <em>Target CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.TargetCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getTargetCS()
		 * @generated
		 */
		EClass TARGET_CS = eINSTANCE.getTargetCS();

		/**
		 * The meta object literal for the '<em><b>Owned Target Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_CS__OWNED_TARGET_ELEMENTS = eINSTANCE.getTargetCS_OwnedTargetElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.xtext.qvtbasecs.impl.TargetElementCSImpl <em>Target Element CS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.TargetElementCSImpl
		 * @see org.eclipse.qvtd.xtext.qvtbasecs.impl.QVTbaseCSPackageImpl#getTargetElementCS()
		 * @generated
		 */
		EClass TARGET_ELEMENT_CS = eINSTANCE.getTargetElementCS();

	}

} //QVTbaseCSPackage
