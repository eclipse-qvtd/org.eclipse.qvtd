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
package tree2talltree.tree2talltree.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import tree2talltree.talltree.TalltreePackage;

import tree2talltree.talltree.impl.TalltreePackageImpl;

import tree2talltree.tree.TreePackage;

import tree2talltree.tree.impl.TreePackageImpl;

import tree2talltree.tree2talltree.Node2TallNode;
import tree2talltree.tree2talltree.Tree2talltreeFactory;
import tree2talltree.tree2talltree.Tree2talltreePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Tree2talltreePackageImpl extends EPackageImpl implements Tree2talltreePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass node2TallNodeEClass = null;

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
	 * @see tree2talltree.tree2talltree.Tree2talltreePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Tree2talltreePackageImpl() {
		super(eNS_URI, Tree2talltreeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link Tree2talltreePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Tree2talltreePackage init() {
		if (isInited) return (Tree2talltreePackage)EPackage.Registry.INSTANCE.getEPackage(Tree2talltreePackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		Tree2talltreePackageImpl theTree2talltreePackage = (Tree2talltreePackageImpl)(ePackage instanceof Tree2talltreePackageImpl ? ePackage : new Tree2talltreePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		TreePackageImpl theTreePackage = (TreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TreePackage.eNS_URI) instanceof TreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TreePackage.eNS_URI) : TreePackage.eINSTANCE);
		TalltreePackageImpl theTalltreePackage = (TalltreePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(TalltreePackage.eNS_URI) instanceof TalltreePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(TalltreePackage.eNS_URI) : TalltreePackage.eINSTANCE);

		// Create package meta-data objects
		theTree2talltreePackage.createPackageContents();
		theTreePackage.createPackageContents();
		theTalltreePackage.createPackageContents();

		// Initialize created meta-data
		theTree2talltreePackage.initializePackageContents();
		theTreePackage.initializePackageContents();
		theTalltreePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTree2talltreePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Tree2talltreePackage.eNS_URI, theTree2talltreePackage);
		return theTree2talltreePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode2TallNode() {
		return node2TallNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode2TallNode_Children() {
		return (EReference)node2TallNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode2TallNode_Name() {
		return (EAttribute)node2TallNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode2TallNode_Parent() {
		return (EReference)node2TallNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode2TallNode_Node() {
		return (EReference)node2TallNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode2TallNode_TallNode() {
		return (EReference)node2TallNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tree2talltreeFactory getTree2talltreeFactory() {
		return (Tree2talltreeFactory)getEFactoryInstance();
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
		node2TallNodeEClass = createEClass(NODE2_TALL_NODE);
		createEReference(node2TallNodeEClass, NODE2_TALL_NODE__CHILDREN);
		createEAttribute(node2TallNodeEClass, NODE2_TALL_NODE__NAME);
		createEReference(node2TallNodeEClass, NODE2_TALL_NODE__PARENT);
		createEReference(node2TallNodeEClass, NODE2_TALL_NODE__NODE);
		createEReference(node2TallNodeEClass, NODE2_TALL_NODE__TALL_NODE);
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
		TreePackage theTreePackage = (TreePackage)EPackage.Registry.INSTANCE.getEPackage(TreePackage.eNS_URI);
		TalltreePackage theTalltreePackage = (TalltreePackage)EPackage.Registry.INSTANCE.getEPackage(TalltreePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(node2TallNodeEClass, Node2TallNode.class, "Node2TallNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode2TallNode_Children(), this.getNode2TallNode(), this.getNode2TallNode_Parent(), "children", null, 0, -1, Node2TallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getNode2TallNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, Node2TallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode2TallNode_Parent(), this.getNode2TallNode(), this.getNode2TallNode_Children(), "parent", null, 0, 1, Node2TallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode2TallNode_Node(), theTreePackage.getNode(), null, "node", null, 1, 1, Node2TallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode2TallNode_TallNode(), theTalltreePackage.getTallNode(), null, "tallNode", null, 1, 1, Node2TallNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Tree2talltreePackageImpl
