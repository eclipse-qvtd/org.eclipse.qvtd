/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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
package classescs.impl;

import classes.ClassesPackage;

import classes.impl.ClassesPackageImpl;

import classescs.ClassCS;
import classescs.ClassescsFactory;
import classescs.ClassescsPackage;
import classescs.ElementCS;
import classescs.NamedElementCS;
import classescs.PackageCS;
import classescs.PathElementCS;
import classescs.PathNameCS;
import classescs.RootCS;

import classescstraces.ClassescstracesPackage;

import classescstraces.impl.ClassescstracesPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ClassescsPackageImpl extends EPackageImpl implements ClassescsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass packageCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathNameCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pathElementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rootCSEClass = null;

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
	 * @see classescs.ClassescsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ClassescsPackageImpl() {
		super(eNS_URI, ClassescsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ClassescsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ClassescsPackage init() {
		if (isInited) return (ClassescsPackage)EPackage.Registry.INSTANCE.getEPackage(ClassescsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredClassescsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ClassescsPackageImpl theClassescsPackage = registeredClassescsPackage instanceof ClassescsPackageImpl ? (ClassescsPackageImpl)registeredClassescsPackage : new ClassescsPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ClassescstracesPackage.eNS_URI);
		ClassescstracesPackageImpl theClassescstracesPackage = (ClassescstracesPackageImpl)(registeredPackage instanceof ClassescstracesPackageImpl ? registeredPackage : ClassescstracesPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);
		ClassesPackageImpl theClassesPackage = (ClassesPackageImpl)(registeredPackage instanceof ClassesPackageImpl ? registeredPackage : ClassesPackage.eINSTANCE);

		// Create package meta-data objects
		theClassescsPackage.createPackageContents();
		theClassescstracesPackage.createPackageContents();
		theClassesPackage.createPackageContents();

		// Initialize created meta-data
		theClassescsPackage.initializePackageContents();
		theClassescstracesPackage.initializePackageContents();
		theClassesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theClassescsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ClassescsPackage.eNS_URI, theClassescsPackage);
		return theClassescsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getElementCS() {
		return elementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getElementCS_Ast() {
		return (EReference)elementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedElementCS() {
		return namedElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNamedElementCS_Name() {
		return (EAttribute)namedElementCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPackageCS() {
		return packageCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPackageCS_OwnedClasses() {
		return (EReference)packageCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassCS() {
		return classCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassCS_Extends() {
		return (EReference)classCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPathNameCS() {
		return pathNameCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPathNameCS_Path() {
		return (EReference)pathNameCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPathElementCS() {
		return pathElementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRootCS() {
		return rootCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRootCS_OwnedPackages() {
		return (EReference)rootCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassescsFactory getClassescsFactory() {
		return (ClassescsFactory)getEFactoryInstance();
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
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		elementCSEClass = createEClass(0);
		createEReference(elementCSEClass, 0);

		namedElementCSEClass = createEClass(1);
		createEAttribute(namedElementCSEClass, 1);

		packageCSEClass = createEClass(2);
		createEReference(packageCSEClass, 2);

		classCSEClass = createEClass(3);
		createEReference(classCSEClass, 2);

		pathNameCSEClass = createEClass(4);
		createEReference(pathNameCSEClass, 1);

		pathElementCSEClass = createEClass(5);

		rootCSEClass = createEClass(6);
		createEReference(rootCSEClass, 1);
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
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ClassesPackage theClassesPackage = (ClassesPackage)EPackage.Registry.INSTANCE.getEPackage(ClassesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		namedElementCSEClass.getESuperTypes().add(this.getElementCS());
		packageCSEClass.getESuperTypes().add(this.getNamedElementCS());
		classCSEClass.getESuperTypes().add(this.getNamedElementCS());
		pathNameCSEClass.getESuperTypes().add(this.getElementCS());
		pathElementCSEClass.getESuperTypes().add(this.getNamedElementCS());
		rootCSEClass.getESuperTypes().add(this.getElementCS());

		// Initialize classes, features, and operations; add parameters
		initEClass(elementCSEClass, ElementCS.class, "ElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getElementCS_Ast(), theClassesPackage.getElement(), null, "ast", null, 0, 1, ElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedElementCSEClass, NamedElementCS.class, "NamedElementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamedElementCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(packageCSEClass, PackageCS.class, "PackageCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPackageCS_OwnedClasses(), this.getClassCS(), null, "ownedClasses", null, 0, -1, PackageCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classCSEClass, ClassCS.class, "ClassCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassCS_Extends(), this.getPathNameCS(), null, "extends", null, 0, 1, ClassCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathNameCSEClass, PathNameCS.class, "PathNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPathNameCS_Path(), this.getPathElementCS(), null, "path", null, 1, -1, PathNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pathElementCSEClass, PathElementCS.class, "PathElementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rootCSEClass, RootCS.class, "RootCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRootCS_OwnedPackages(), this.getPackageCS(), null, "ownedPackages", null, 0, -1, RootCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ClassescsPackageImpl
