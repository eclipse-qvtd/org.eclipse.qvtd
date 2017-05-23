/**
 * Copyright (c) 2010, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtbasecs.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.xtext.qvtbasecs.AbstractTransformationCS;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSFactory;
import org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage;
import org.eclipse.qvtd.xtext.qvtbasecs.QualifiedPackageCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTbaseCSPackageImpl extends EPackageImpl implements QVTbaseCSPackage
{
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractTransformationCSEClass = null;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass qualifiedPackageCSEClass = null;
	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvtd.xtext.qvtbasecs.QVTbaseCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTbaseCSPackageImpl()
	{
		super(eNS_URI, QVTbaseCSFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link QVTbaseCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTbaseCSPackage init()
	{
		if (isInited) return (QVTbaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTbaseCSPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTbaseCSPackageImpl theQVTbaseCSPackage = (QVTbaseCSPackageImpl)(ePackage instanceof QVTbaseCSPackageImpl ? ePackage : new QVTbaseCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BaseCSPackage.eINSTANCE.eClass();
		PivotPackage.eINSTANCE.eClass();
		QVTbasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTbaseCSPackage.createPackageContents();

		// Initialize created meta-data
		theQVTbaseCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTbaseCSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTbaseCSPackage.eNS_URI, theQVTbaseCSPackage);
		return theQVTbaseCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAbstractTransformationCS()
	{
		return abstractTransformationCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAbstractTransformationCS_OwnedPathName()
	{
		return (EReference)abstractTransformationCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getQualifiedPackageCS()
	{
		return qualifiedPackageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getQualifiedPackageCS_OwnedPathName()
	{
		return (EReference)qualifiedPackageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTbaseCSFactory getQVTbaseCSFactory()
	{
		return (QVTbaseCSFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents()
	{
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		abstractTransformationCSEClass = createEClass(ABSTRACT_TRANSFORMATION_CS);
		createEReference(abstractTransformationCSEClass, ABSTRACT_TRANSFORMATION_CS__OWNED_PATH_NAME);

		qualifiedPackageCSEClass = createEClass(QUALIFIED_PACKAGE_CS);
		createEReference(qualifiedPackageCSEClass, QUALIFIED_PACKAGE_CS__OWNED_PATH_NAME);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents()
	{
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractTransformationCSEClass.getESuperTypes().add(theBaseCSPackage.getClassCS());
		qualifiedPackageCSEClass.getESuperTypes().add(theBaseCSPackage.getPackageCS());

		// Initialize classes and features; add operations and parameters
		initEClass(abstractTransformationCSEClass, AbstractTransformationCS.class, "AbstractTransformationCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractTransformationCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, AbstractTransformationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(qualifiedPackageCSEClass, QualifiedPackageCS.class, "QualifiedPackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getQualifiedPackageCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, QualifiedPackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTbaseCSPackageImpl
