/*******************************************************************************
 * Copyright (c) 2014, 2016 Willink Transformations and others.
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
package test.middle.HSV2HSL.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import test.hsl.HSLTree.HSLTreePackage;
import test.hsl.HSLTree.impl.HSLTreePackageImpl;
import test.hsv.HSVTree.HSVTreePackage;

import test.hsv.HSVTree.impl.HSVTreePackageImpl;
import test.middle.HSV2HSL.HSV2HSLFactory;
import test.middle.HSV2HSL.HSV2HSLPackage;
import test.middle.HSV2HSL.HSVNode2HSLNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class HSV2HSLPackageImpl extends EPackageImpl implements HSV2HSLPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hsvNode2HSLNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rgbEDataType = null;

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
	 * @see test.middle.HSV2HSL.HSV2HSLPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private HSV2HSLPackageImpl() {
		super(eNS_URI, HSV2HSLFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link HSV2HSLPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static HSV2HSLPackage init() {
		if (isInited) return (HSV2HSLPackage)EPackage.Registry.INSTANCE.getEPackage(HSV2HSLPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		HSV2HSLPackageImpl theHSV2HSLPackage = (HSV2HSLPackageImpl)(ePackage instanceof HSV2HSLPackageImpl ? ePackage : new HSV2HSLPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		HSVTreePackageImpl theHSVTreePackage = (HSVTreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI) instanceof HSVTreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI) : HSVTreePackage.eINSTANCE);
		HSLTreePackageImpl theHSLTreePackage = (HSLTreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(HSLTreePackage.eNS_URI) instanceof HSLTreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(HSLTreePackage.eNS_URI) : HSLTreePackage.eINSTANCE);

		// Create package meta-data objects
		theHSV2HSLPackage.createPackageContents();
		theHSVTreePackage.createPackageContents();
		theHSLTreePackage.createPackageContents();

		// Initialize created meta-data
		theHSV2HSLPackage.initializePackageContents();
		theHSVTreePackage.initializePackageContents();
		theHSLTreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theHSV2HSLPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(HSV2HSLPackage.eNS_URI, theHSV2HSLPackage);
		return theHSV2HSLPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getHSVNode2HSLNode() {
		return hsvNode2HSLNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHSVNode2HSLNode_Parent() {
		return (EReference)hsvNode2HSLNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHSVNode2HSLNode_Children() {
		return (EReference)hsvNode2HSLNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHSVNode2HSLNode_Hsv() {
		return (EReference)hsvNode2HSLNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getHSVNode2HSLNode_Hsl() {
		return (EReference)hsvNode2HSLNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHSVNode2HSLNode_Rgb() {
		return (EAttribute)hsvNode2HSLNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getHSVNode2HSLNode_Name() {
		return (EAttribute)hsvNode2HSLNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getRGB() {
		return rgbEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HSV2HSLFactory getHSV2HSLFactory() {
		return (HSV2HSLFactory)getEFactoryInstance();
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
		hsvNode2HSLNodeEClass = createEClass(HSV_NODE2_HSL_NODE);
		createEReference(hsvNode2HSLNodeEClass, HSV_NODE2_HSL_NODE__PARENT);
		createEReference(hsvNode2HSLNodeEClass, HSV_NODE2_HSL_NODE__CHILDREN);
		createEReference(hsvNode2HSLNodeEClass, HSV_NODE2_HSL_NODE__HSV);
		createEReference(hsvNode2HSLNodeEClass, HSV_NODE2_HSL_NODE__HSL);
		createEAttribute(hsvNode2HSLNodeEClass, HSV_NODE2_HSL_NODE__RGB);
		createEAttribute(hsvNode2HSLNodeEClass, HSV_NODE2_HSL_NODE__NAME);

		// Create data types
		rgbEDataType = createEDataType(RGB);
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
		HSVTreePackage theHSVTreePackage = (HSVTreePackage)EPackage.Registry.INSTANCE.getEPackage(HSVTreePackage.eNS_URI);
		HSLTreePackage theHSLTreePackage = (HSLTreePackage)EPackage.Registry.INSTANCE.getEPackage(HSLTreePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(hsvNode2HSLNodeEClass, HSVNode2HSLNode.class, "HSVNode2HSLNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHSVNode2HSLNode_Parent(), this.getHSVNode2HSLNode(), this.getHSVNode2HSLNode_Children(), "parent", null, 0, 1, HSVNode2HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHSVNode2HSLNode_Children(), this.getHSVNode2HSLNode(), this.getHSVNode2HSLNode_Parent(), "children", null, 0, -1, HSVNode2HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHSVNode2HSLNode_Hsv(), theHSVTreePackage.getHSVNode(), null, "hsv", null, 1, 1, HSVNode2HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getHSVNode2HSLNode_Hsl(), theHSLTreePackage.getHSLNode(), null, "hsl", null, 1, 1, HSVNode2HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHSVNode2HSLNode_Rgb(), this.getRGB(), "rgb", null, 1, 1, HSVNode2HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getHSVNode2HSLNode_Name(), ecorePackage.getEString(), "name", null, 0, 1, HSVNode2HSLNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize data types
		initEDataType(rgbEDataType, String.class, "RGB", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //HSV2HSLPackageImpl
