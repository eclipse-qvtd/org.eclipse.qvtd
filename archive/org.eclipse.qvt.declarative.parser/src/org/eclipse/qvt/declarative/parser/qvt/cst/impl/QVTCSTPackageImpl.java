/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: QVTCSTPackageImpl.java,v 1.3 2008/11/28 17:23:01 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvt.cst.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.cst.CSTPackage;
import org.eclipse.qvt.declarative.parser.environment.IHasName;
import org.eclipse.qvt.declarative.parser.qvt.cst.ErrorNode;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTFactory;
import org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTCSTPackageImpl extends EPackageImpl implements QVTCSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass errorNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifiedCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identifierCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iHasNameEClass = null;

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
	 * @see org.eclipse.qvt.declarative.parser.qvt.cst.QVTCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTCSTPackageImpl() {
		super(eNS_URI, QVTCSTFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTCSTPackage init() {
		if (isInited) return (QVTCSTPackage)EPackage.Registry.INSTANCE.getEPackage(QVTCSTPackage.eNS_URI);

		// Obtain or create and register package
		QVTCSTPackageImpl theQVTCSTPackage = (QVTCSTPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof QVTCSTPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new QVTCSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CSTPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTCSTPackage.createPackageContents();

		// Initialize created meta-data
		theQVTCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTCSTPackage.freeze();

		return theQVTCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getErrorNode() {
		return errorNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getErrorNode_Message() {
		return (EAttribute)errorNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifiedCS() {
		return identifiedCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifiedCS_Identifier() {
		return (EReference)identifiedCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifiedCS_AstNode() {
		return (EReference)identifiedCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentifierCS() {
		return identifierCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentifierCS_Value() {
		return (EAttribute)identifierCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIdentifierCS_AstNode() {
		return (EReference)identifierCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIHasName() {
		return iHasNameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTCSTFactory getQVTCSTFactory() {
		return (QVTCSTFactory)getEFactoryInstance();
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
		errorNodeEClass = createEClass(ERROR_NODE);
		createEAttribute(errorNodeEClass, ERROR_NODE__MESSAGE);

		identifiedCSEClass = createEClass(IDENTIFIED_CS);
		createEReference(identifiedCSEClass, IDENTIFIED_CS__IDENTIFIER);
		createEReference(identifiedCSEClass, IDENTIFIED_CS__AST_NODE);

		identifierCSEClass = createEClass(IDENTIFIER_CS);
		createEAttribute(identifierCSEClass, IDENTIFIER_CS__VALUE);
		createEReference(identifierCSEClass, IDENTIFIER_CS__AST_NODE);

		iHasNameEClass = createEClass(IHAS_NAME);
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
		CSTPackage theCSTPackage = (CSTPackage)EPackage.Registry.INSTANCE.getEPackage(CSTPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		identifiedCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		identifiedCSEClass.getESuperTypes().add(this.getIHasName());
		identifierCSEClass.getESuperTypes().add(theCSTPackage.getCSTNode());
		identifierCSEClass.getESuperTypes().add(this.getIHasName());

		// Initialize classes and features; add operations and parameters
		initEClass(errorNodeEClass, ErrorNode.class, "ErrorNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getErrorNode_Message(), ecorePackage.getEString(), "message", null, 1, 1, ErrorNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(identifiedCSEClass, IdentifiedCS.class, "IdentifiedCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIdentifiedCS_Identifier(), this.getIdentifierCS(), null, "identifier", null, 0, 1, IdentifiedCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdentifiedCS_AstNode(), ecorePackage.getEObject(), null, "astNode", null, 0, 1, IdentifiedCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(identifierCSEClass, IdentifierCS.class, "IdentifierCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentifierCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, IdentifierCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIdentifierCS_AstNode(), ecorePackage.getEObject(), null, "astNode", null, 0, 1, IdentifierCS.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(iHasNameEClass, IHasName.class, "IHasName", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //EqvtCSTPackageImpl
