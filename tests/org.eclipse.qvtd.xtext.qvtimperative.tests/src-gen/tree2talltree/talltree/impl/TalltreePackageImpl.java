/**
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package tree2talltree.talltree.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tree2talltree.talltree.TallNode;
import tree2talltree.talltree.TalltreeFactory;
import tree2talltree.talltree.TalltreePackage;

import tree2talltree.tree.TreePackage;

import tree2talltree.tree.impl.TreePackageImpl;

import tree2talltree.tree2talltree.Tree2talltreePackage;

import tree2talltree.tree2talltree.impl.Tree2talltreePackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TalltreePackageImpl extends EPackageImpl implements TalltreePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tallNodeEClass = null;

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
	 * @see tree2talltree.talltree.TalltreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TalltreePackageImpl() {
		super(eNS_URI, TalltreeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TalltreePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TalltreePackage init() {
		if (isInited) return (TalltreePackage)EPackage.Registry.INSTANCE.getEPackage(TalltreePackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TalltreePackageImpl theTalltreePackage = (TalltreePackageImpl)(ePackage instanceof TalltreePackageImpl ? ePackage : new TalltreePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		Tree2talltreePackageImpl theTree2talltreePackage = (Tree2talltreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(Tree2talltreePackage.eNS_URI) instanceof Tree2talltreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(Tree2talltreePackage.eNS_URI) : Tree2talltreePackage.eINSTANCE);
		TreePackageImpl theTreePackage = (TreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TreePackage.eNS_URI) instanceof TreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TreePackage.eNS_URI) : TreePackage.eINSTANCE);

		// Create package meta-data objects
		theTalltreePackage.createPackageContents();
		theTree2talltreePackage.createPackageContents();
		theTreePackage.createPackageContents();

		// Initialize created meta-data
		theTalltreePackage.initializePackageContents();
		theTree2talltreePackage.initializePackageContents();
		theTreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTalltreePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TalltreePackage.eNS_URI, theTalltreePackage);
		return theTalltreePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTallNode() {
		return tallNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTallNode_Children() {
		return (EReference)tallNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTallNode_Height() {
		return (EAttribute)tallNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTallNode_Name() {
		return (EAttribute)tallNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTallNode_Parent() {
		return (EReference)tallNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TalltreeFactory getTalltreeFactory() {
		return (TalltreeFactory)getEFactoryInstance();
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
		tallNodeEClass = createEClass(TALL_NODE);
		createEReference(tallNodeEClass, TALL_NODE__CHILDREN);
		createEAttribute(tallNodeEClass, TALL_NODE__HEIGHT);
		createEAttribute(tallNodeEClass, TALL_NODE__NAME);
		createEReference(tallNodeEClass, TALL_NODE__PARENT);
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
		initEClass(tallNodeEClass, TallNode.class, "TallNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTallNode_Children(), this.getTallNode(), this.getTallNode_Parent(), "children", null, 0, -1, TallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTallNode_Height(), ecorePackage.getEInt(), "height", null, 1, 1, TallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTallNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, TallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTallNode_Parent(), this.getTallNode(), this.getTallNode_Children(), "parent", null, 0, 1, TallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //TalltreePackageImpl
