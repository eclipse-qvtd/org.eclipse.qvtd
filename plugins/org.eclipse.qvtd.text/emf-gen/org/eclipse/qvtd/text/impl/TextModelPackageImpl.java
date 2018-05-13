/**
 * <copyright>
 * 
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.text.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvtd.text.StringNode;
import org.eclipse.qvtd.text.TextModelFactory;
import org.eclipse.qvtd.text.TextModelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TextModelPackageImpl extends EPackageImpl implements TextModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringNodeEClass = null;

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
	 * @see org.eclipse.qvtd.text.TextModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private TextModelPackageImpl() {
		super(eNS_URI, TextModelFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link TextModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static TextModelPackage init() {
		if (isInited) return (TextModelPackage)EPackage.Registry.INSTANCE.getEPackage(TextModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredTextModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		TextModelPackageImpl theTextModelPackage = registeredTextModelPackage instanceof TextModelPackageImpl ? (TextModelPackageImpl)registeredTextModelPackage : new TextModelPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theTextModelPackage.createPackageContents();

		// Initialize created meta-data
		theTextModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTextModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TextModelPackage.eNS_URI, theTextModelPackage);
		return theTextModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringNode() {
		return stringNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringNode_Children() {
		return (EReference)stringNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringNode_EndText() {
		return (EAttribute)stringNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringNode_Indent() {
		return (EAttribute)stringNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringNode_NonBreakingSpace() {
		return (EAttribute)stringNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStringNode_Parent() {
		return (EReference)stringNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringNode_Prefix() {
		return (EAttribute)stringNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringNode_Separator() {
		return (EAttribute)stringNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringNode_Suffix() {
		return (EAttribute)stringNodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringNode_Text() {
		return (EAttribute)stringNodeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TextModelFactory getTextModelFactory() {
		return (TextModelFactory)getEFactoryInstance();
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
		stringNodeEClass = createEClass(STRING_NODE);
		createEReference(stringNodeEClass, STRING_NODE__CHILDREN);
		createEAttribute(stringNodeEClass, STRING_NODE__END_TEXT);
		createEAttribute(stringNodeEClass, STRING_NODE__INDENT);
		createEAttribute(stringNodeEClass, STRING_NODE__NON_BREAKING_SPACE);
		createEReference(stringNodeEClass, STRING_NODE__PARENT);
		createEAttribute(stringNodeEClass, STRING_NODE__PREFIX);
		createEAttribute(stringNodeEClass, STRING_NODE__SEPARATOR);
		createEAttribute(stringNodeEClass, STRING_NODE__SUFFIX);
		createEAttribute(stringNodeEClass, STRING_NODE__TEXT);
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
		initEClass(stringNodeEClass, StringNode.class, "StringNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStringNode_Children(), this.getStringNode(), this.getStringNode_Parent(), "children", null, 0, -1, StringNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringNode_EndText(), ecorePackage.getEString(), "endText", "", 1, 1, StringNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringNode_Indent(), ecorePackage.getEString(), "indent", "", 1, 1, StringNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringNode_NonBreakingSpace(), ecorePackage.getEChar(), "nonBreakingSpace", null, 0, 1, StringNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getStringNode_Parent(), this.getStringNode(), this.getStringNode_Children(), "parent", null, 0, 1, StringNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStringNode_Prefix(), ecorePackage.getEString(), "prefix", "", 1, 1, StringNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringNode_Separator(), ecorePackage.getEString(), "separator", "", 1, 1, StringNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringNode_Suffix(), ecorePackage.getEString(), "suffix", "", 1, 1, StringNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStringNode_Text(), ecorePackage.getEString(), "text", "", 1, 1, StringNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/qvt/2018/PostProcess
		createPostProcessAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/qvt/2018/PostProcess</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPostProcessAnnotations() {
		String source = "http://www.eclipse.org/qvt/2018/PostProcess";
		addAnnotation
		  (this,
		   source,
		   new String[] {
			   "raw", "org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl",
			   "processed", "org.eclipse.qvtd.text.utilities.TextModelResourceFactoryImpl"
		   });
	}

} //TextModelPackageImpl
