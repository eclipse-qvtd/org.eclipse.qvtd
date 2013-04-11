/**
 * <copyright>
 *
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtimperativecst.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.examples.pivot.PivotPackage;
import org.eclipse.ocl.examples.xtext.base.baseCST.BaseCSTPackage;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.EssentialOCLCSTPackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTPackage;
import org.eclipse.qvtd.xtext.qvtimperativecst.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecst.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecst.QVTimperativeCSTFactory;
import org.eclipse.qvtd.xtext.qvtimperativecst.QVTimperativeCSTPackage;
import org.eclipse.qvtd.xtext.qvtimperativecst.TopLevelCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTimperativeCSTPackageImpl extends EPackageImpl implements QVTimperativeCSTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallBindingCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelCSEClass = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtimperativecst.QVTimperativeCSTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTimperativeCSTPackageImpl() {
		super(eNS_URI, QVTimperativeCSTFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTimperativeCSTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTimperativeCSTPackage init() {
		if (isInited) return (QVTimperativeCSTPackage)EPackage.Registry.INSTANCE.getEPackage(QVTimperativeCSTPackage.eNS_URI);

		// Obtain or create and register package
		QVTimperativeCSTPackageImpl theQVTimperativeCSTPackage = (QVTimperativeCSTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QVTimperativeCSTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QVTimperativeCSTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTcoreBaseCSTPackage.eINSTANCE.eClass();
		QVTimperativePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTimperativeCSTPackage.createPackageContents();

		// Initialize created meta-data
		theQVTimperativeCSTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTimperativeCSTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTimperativeCSTPackage.eNS_URI, theQVTimperativeCSTPackage);
		return theQVTimperativeCSTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCS() {
		return mappingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCS_MappingCalls() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCallBindingCS() {
		return mappingCallBindingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCallBindingCS_MappingCall() {
		return (EReference)mappingCallBindingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCallBindingCS_ReferredVariable() {
		return (EReference)mappingCallBindingCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCallBindingCS_Value() {
		return (EReference)mappingCallBindingCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingCallBindingCS_IsLoop() {
		return (EAttribute)mappingCallBindingCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingCallCS() {
		return mappingCallCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCallCS_ReferredMapping() {
		return (EReference)mappingCallCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingCallCS_Bindings() {
		return (EReference)mappingCallCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTopLevelCS() {
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Transformations() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Queries() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTopLevelCS_Mappings() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QVTimperativeCSTFactory getQVTimperativeCSTFactory() {
		return (QVTimperativeCSTFactory)getEFactoryInstance();
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
		mappingCSEClass = createEClass(MAPPING_CS);
		createEReference(mappingCSEClass, MAPPING_CS__MAPPING_CALLS);

		mappingCallBindingCSEClass = createEClass(MAPPING_CALL_BINDING_CS);
		createEReference(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__MAPPING_CALL);
		createEReference(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE);
		createEReference(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__VALUE);
		createEAttribute(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__IS_LOOP);

		mappingCallCSEClass = createEClass(MAPPING_CALL_CS);
		createEReference(mappingCallCSEClass, MAPPING_CALL_CS__REFERRED_MAPPING);
		createEReference(mappingCallCSEClass, MAPPING_CALL_CS__BINDINGS);

		topLevelCSEClass = createEClass(TOP_LEVEL_CS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__TRANSFORMATIONS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__QUERIES);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__MAPPINGS);
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
		QVTcoreBaseCSTPackage theQVTcoreBaseCSTPackage = (QVTcoreBaseCSTPackage)EPackage.Registry.INSTANCE.getEPackage(QVTcoreBaseCSTPackage.eNS_URI);
		EssentialOCLCSTPackage theEssentialOCLCSTPackage = (EssentialOCLCSTPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSTPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		BaseCSTPackage theBaseCSTPackage = (BaseCSTPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSTPackage.eNS_URI);
		QVTimperativePackage theQVTimperativePackage = (QVTimperativePackage)EPackage.Registry.INSTANCE.getEPackage(QVTimperativePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mappingCSEClass.getESuperTypes().add(theQVTcoreBaseCSTPackage.getAbstractMappingCS());
		mappingCallBindingCSEClass.getESuperTypes().add(theEssentialOCLCSTPackage.getExpCS());
		mappingCallCSEClass.getESuperTypes().add(theBaseCSTPackage.getModelElementCS());
		topLevelCSEClass.getESuperTypes().add(theBaseCSTPackage.getRootPackageCS());

		// Initialize classes and features; add operations and parameters
		initEClass(mappingCSEClass, MappingCS.class, "MappingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCS_MappingCalls(), this.getMappingCallCS(), null, "mappingCalls", null, 0, -1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallBindingCSEClass, MappingCallBindingCS.class, "MappingCallBindingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCallBindingCS_MappingCall(), this.getMappingCallCS(), this.getMappingCallCS_Bindings(), "mappingCall", null, 0, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallBindingCS_ReferredVariable(), thePivotPackage.getVariable(), null, "referredVariable", null, 1, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallBindingCS_Value(), theEssentialOCLCSTPackage.getExpCS(), null, "value", null, 1, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingCallBindingCS_IsLoop(), thePivotPackage.getBoolean(), "isLoop", "false", 0, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallCSEClass, MappingCallCS.class, "MappingCallCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCallCS_ReferredMapping(), theQVTimperativePackage.getMapping(), null, "referredMapping", null, 1, 1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallCS_Bindings(), this.getMappingCallBindingCS(), this.getMappingCallBindingCS_MappingCall(), "bindings", null, 0, -1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_Transformations(), theQVTcoreBaseCSTPackage.getTransformationCS(), null, "transformations", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_Queries(), theQVTcoreBaseCSTPackage.getQueryCS(), null, "queries", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_Mappings(), this.getMappingCS(), null, "mappings", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTimperativeCSTPackageImpl
