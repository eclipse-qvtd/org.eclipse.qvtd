/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLTreePackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.impl.HSLTreePackageImpl;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HSL.HSV2HSLPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HSL.impl.HSV2HSLPackageImpl;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVNode;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreeFactory;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HSVTreePackageImpl extends EPackageImpl implements HSVTreePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hsvNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType hsvEDataType = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HSVTreePackageImpl() {
		super(eNS_URI, HSVTreeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HSVTreePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HSVTreePackage init() {
		if (isInited) return (HSVTreePackage)EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI);

		// Obtain or create and register package
		Object registeredHSVTreePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		HSVTreePackageImpl theHSVTreePackage = registeredHSVTreePackage instanceof HSVTreePackageImpl ? (HSVTreePackageImpl)registeredHSVTreePackage : new HSVTreePackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(HSV2HSLPackage.eNS_URI);
		HSV2HSLPackageImpl theHSV2HSLPackage = (HSV2HSLPackageImpl)(registeredPackage instanceof HSV2HSLPackageImpl ? registeredPackage : HSV2HSLPackage.eINSTANCE);
		registeredPackage = EPackage.Registry.INSTANCE.getEPackage(HSLTreePackage.eNS_URI);
		HSLTreePackageImpl theHSLTreePackage = (HSLTreePackageImpl)(registeredPackage instanceof HSLTreePackageImpl ? registeredPackage : HSLTreePackage.eINSTANCE);

		// Create package meta-data objects
		theHSVTreePackage.createPackageContents();
		theHSV2HSLPackage.createPackageContents();
		theHSLTreePackage.createPackageContents();

		// Initialize created meta-data
		theHSVTreePackage.initializePackageContents();
		theHSV2HSLPackage.initializePackageContents();
		theHSLTreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHSVTreePackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HSVTreePackage.eNS_URI, theHSVTreePackage);
		return theHSVTreePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHSVNode() {
		return hsvNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHSVNode_Parent() {
		return (EReference)hsvNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHSVNode_Children() {
		return (EReference)hsvNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHSVNode_Hsv() {
		return (EAttribute)hsvNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHSVNode_Name() {
		return (EAttribute)hsvNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getHSV() {
		return hsvEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HSVTreeFactory getHSVTreeFactory() {
		return (HSVTreeFactory)getEFactoryInstance();
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
		hsvNodeEClass = createEClass(0);
		createEReference(hsvNodeEClass, 0);
		createEReference(hsvNodeEClass, 1);
		createEAttribute(hsvNodeEClass, 2);
		createEAttribute(hsvNodeEClass, 3);

		// Create data types
		hsvEDataType = createEDataType(1);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(hsvNodeEClass, HSVNode.class, "HSVNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHSVNode_Parent(), this.getHSVNode(), this.getHSVNode_Children(), "parent", null, 0, 1, HSVNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHSVNode_Children(), this.getHSVNode(), this.getHSVNode_Parent(), "children", null, 0, -1, HSVNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHSVNode_Hsv(), this.getHSV(), "hsv", "", 1, 1, HSVNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHSVNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, HSVNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(hsvEDataType, String.class, "HSV", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //HSVTreePackageImpl
