/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLNode;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLTreeFactory;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLTreePackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HSL.HSV2HSLPackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSV2HSL.impl.HSV2HSLPackageImpl;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.HSVTreePackage;
import org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSVTree.impl.HSVTreePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HSLTreePackageImpl extends EPackageImpl implements HSLTreePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hslNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType hslEDataType = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtcore.tests.hsv2hsl.HSLTree.HSLTreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HSLTreePackageImpl() {
		super(eNS_URI, HSLTreeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HSLTreePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HSLTreePackage init() {
		if (isInited) return (HSLTreePackage)EPackage.Registry.INSTANCE.getEPackage(HSLTreePackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		HSLTreePackageImpl theHSLTreePackage = (HSLTreePackageImpl)(ePackage instanceof HSLTreePackageImpl ? ePackage : new HSLTreePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		HSV2HSLPackageImpl theHSV2HSLPackage = (HSV2HSLPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HSV2HSLPackage.eNS_URI) instanceof HSV2HSLPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HSV2HSLPackage.eNS_URI) : HSV2HSLPackage.eINSTANCE);
		HSVTreePackageImpl theHSVTreePackage = (HSVTreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI) instanceof HSVTreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI) : HSVTreePackage.eINSTANCE);

		// Create package meta-data objects
		theHSLTreePackage.createPackageContents();
		theHSV2HSLPackage.createPackageContents();
		theHSVTreePackage.createPackageContents();

		// Initialize created meta-data
		theHSLTreePackage.initializePackageContents();
		theHSV2HSLPackage.initializePackageContents();
		theHSVTreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHSLTreePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HSLTreePackage.eNS_URI, theHSLTreePackage);
		return theHSLTreePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHSLNode() {
		return hslNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHSLNode_Parent() {
		return (EReference)hslNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHSLNode_Children() {
		return (EReference)hslNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHSLNode_Hsl() {
		return (EAttribute)hslNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHSLNode_Name() {
		return (EAttribute)hslNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getHSL() {
		return hslEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HSLTreeFactory getHSLTreeFactory() {
		return (HSLTreeFactory)getEFactoryInstance();
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
		hslNodeEClass = createEClass(HSL_NODE);
		createEReference(hslNodeEClass, HSL_NODE__PARENT);
		createEReference(hslNodeEClass, HSL_NODE__CHILDREN);
		createEAttribute(hslNodeEClass, HSL_NODE__HSL);
		createEAttribute(hslNodeEClass, HSL_NODE__NAME);

		// Create data types
		hslEDataType = createEDataType(HSL);
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
		initEClass(hslNodeEClass, HSLNode.class, "HSLNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHSLNode_Parent(), this.getHSLNode(), this.getHSLNode_Children(), "parent", null, 0, 1, HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHSLNode_Children(), this.getHSLNode(), this.getHSLNode_Parent(), "children", null, 0, -1, HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHSLNode_Hsl(), this.getHSL(), "hsl", "1", 1, 1, HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHSLNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(hslEDataType, String.class, "HSL", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //HLSTreePackageImpl
