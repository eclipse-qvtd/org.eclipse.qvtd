/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.ocl.xtext.basecs.BaseCSPackage;
import org.eclipse.ocl.xtext.essentialoclcs.EssentialOCLCSPackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativeDomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.ImperativePredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingLoopCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingStatementCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSFactory;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.TopLevelCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTimperativeCSPackageImpl extends EPackageImpl implements QVTimperativeCSPackage {
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
	private EClass mappingLoopCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingSequenceCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingStatementCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass topLevelCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeDomainCSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativePredicateOrAssignmentCSEClass = null;

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
	 * @see org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTimperativeCSPackageImpl() {
		super(eNS_URI, QVTimperativeCSFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTimperativeCSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTimperativeCSPackage init() {
		if (isInited) return (QVTimperativeCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTimperativeCSPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTimperativeCSPackageImpl theQVTimperativeCSPackage = (QVTimperativeCSPackageImpl)(ePackage instanceof QVTimperativeCSPackageImpl ? ePackage : new QVTimperativeCSPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTcoreBaseCSPackage.eINSTANCE.eClass();
		QVTimperativePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTimperativeCSPackage.createPackageContents();

		// Initialize created meta-data
		theQVTimperativeCSPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTimperativeCSPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTimperativeCSPackage.eNS_URI, theQVTimperativeCSPackage);
		return theQVTimperativeCSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingCS() {
		return mappingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCS_OwnedMappingSequence() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCS_OwnedUsesPathNames() {
		return (EReference)mappingCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingCallBindingCS() {
		return mappingCallBindingCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingCallBindingCS_IsPolled() {
		return (EAttribute)mappingCallBindingCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallBindingCS_OwningMappingCall() {
		return (EReference)mappingCallBindingCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallBindingCS_ReferredVariable() {
		return (EReference)mappingCallBindingCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallBindingCS_OwnedValue() {
		return (EReference)mappingCallBindingCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingCallCS() {
		return mappingCallCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingCallCS_IsInfinite() {
		return (EAttribute)mappingCallCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallCS_ReferredMapping() {
		return (EReference)mappingCallCSEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallCS_OwnedBindings() {
		return (EReference)mappingCallCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallCS_OwnedPathName() {
		return (EReference)mappingCallCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingLoopCS() {
		return mappingLoopCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoopCS_OwnedIterator() {
		return (EReference)mappingLoopCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoopCS_OwnedInExpression() {
		return (EReference)mappingLoopCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoopCS_OwnedMappingSequence() {
		return (EReference)mappingLoopCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingSequenceCS() {
		return mappingSequenceCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingSequenceCS_OwnedMappingStatements() {
		return (EReference)mappingSequenceCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingStatementCS() {
		return mappingStatementCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTopLevelCS() {
		return topLevelCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopLevelCS_OwnedTransformations() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopLevelCS_OwnedQueries() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTopLevelCS_OwnedMappings() {
		return (EReference)topLevelCSEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImperativeDomainCS() {
		return imperativeDomainCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImperativeDomainCS_CheckedProperties() {
		return (EReference)imperativeDomainCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImperativeDomainCS_EnforcedProperties() {
		return (EReference)imperativeDomainCSEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImperativePredicateOrAssignmentCS() {
		return imperativePredicateOrAssignmentCSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImperativePredicateOrAssignmentCS_IsAccumulate() {
		return (EAttribute)imperativePredicateOrAssignmentCSEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTimperativeCSFactory getQVTimperativeCSFactory() {
		return (QVTimperativeCSFactory)getEFactoryInstance();
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
		imperativeDomainCSEClass = createEClass(IMPERATIVE_DOMAIN_CS);
		createEReference(imperativeDomainCSEClass, IMPERATIVE_DOMAIN_CS__CHECKED_PROPERTIES);
		createEReference(imperativeDomainCSEClass, IMPERATIVE_DOMAIN_CS__ENFORCED_PROPERTIES);

		imperativePredicateOrAssignmentCSEClass = createEClass(IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS);
		createEAttribute(imperativePredicateOrAssignmentCSEClass, IMPERATIVE_PREDICATE_OR_ASSIGNMENT_CS__IS_ACCUMULATE);

		mappingCSEClass = createEClass(MAPPING_CS);
		createEReference(mappingCSEClass, MAPPING_CS__OWNED_MAPPING_SEQUENCE);
		createEReference(mappingCSEClass, MAPPING_CS__OWNED_USES_PATH_NAMES);

		mappingCallBindingCSEClass = createEClass(MAPPING_CALL_BINDING_CS);
		createEAttribute(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__IS_POLLED);
		createEReference(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__OWNED_VALUE);
		createEReference(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL);
		createEReference(mappingCallBindingCSEClass, MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE);

		mappingCallCSEClass = createEClass(MAPPING_CALL_CS);
		createEAttribute(mappingCallCSEClass, MAPPING_CALL_CS__IS_INFINITE);
		createEReference(mappingCallCSEClass, MAPPING_CALL_CS__OWNED_BINDINGS);
		createEReference(mappingCallCSEClass, MAPPING_CALL_CS__OWNED_PATH_NAME);
		createEReference(mappingCallCSEClass, MAPPING_CALL_CS__REFERRED_MAPPING);

		mappingLoopCSEClass = createEClass(MAPPING_LOOP_CS);
		createEReference(mappingLoopCSEClass, MAPPING_LOOP_CS__OWNED_ITERATOR);
		createEReference(mappingLoopCSEClass, MAPPING_LOOP_CS__OWNED_IN_EXPRESSION);
		createEReference(mappingLoopCSEClass, MAPPING_LOOP_CS__OWNED_MAPPING_SEQUENCE);

		mappingSequenceCSEClass = createEClass(MAPPING_SEQUENCE_CS);
		createEReference(mappingSequenceCSEClass, MAPPING_SEQUENCE_CS__OWNED_MAPPING_STATEMENTS);

		mappingStatementCSEClass = createEClass(MAPPING_STATEMENT_CS);

		topLevelCSEClass = createEClass(TOP_LEVEL_CS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__OWNED_TRANSFORMATIONS);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__OWNED_QUERIES);
		createEReference(topLevelCSEClass, TOP_LEVEL_CS__OWNED_MAPPINGS);
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
		QVTcoreBaseCSPackage theQVTcoreBaseCSPackage = (QVTcoreBaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(QVTcoreBaseCSPackage.eNS_URI);
		BaseCSPackage theBaseCSPackage = (BaseCSPackage)EPackage.Registry.INSTANCE.getEPackage(BaseCSPackage.eNS_URI);
		EssentialOCLCSPackage theEssentialOCLCSPackage = (EssentialOCLCSPackage)EPackage.Registry.INSTANCE.getEPackage(EssentialOCLCSPackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTimperativePackage theQVTimperativePackage = (QVTimperativePackage)EPackage.Registry.INSTANCE.getEPackage(QVTimperativePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		imperativeDomainCSEClass.getESuperTypes().add(theQVTcoreBaseCSPackage.getDomainCS());
		imperativePredicateOrAssignmentCSEClass.getESuperTypes().add(theQVTcoreBaseCSPackage.getPredicateOrAssignmentCS());
		mappingCSEClass.getESuperTypes().add(theQVTcoreBaseCSPackage.getAbstractMappingCS());
		mappingCallBindingCSEClass.getESuperTypes().add(theEssentialOCLCSPackage.getExpCS());
		mappingCallCSEClass.getESuperTypes().add(this.getMappingStatementCS());
		mappingLoopCSEClass.getESuperTypes().add(this.getMappingStatementCS());
		mappingSequenceCSEClass.getESuperTypes().add(this.getMappingStatementCS());
		mappingStatementCSEClass.getESuperTypes().add(theBaseCSPackage.getModelElementCS());
		topLevelCSEClass.getESuperTypes().add(theBaseCSPackage.getRootPackageCS());

		// Initialize classes and features; add operations and parameters
		initEClass(imperativeDomainCSEClass, ImperativeDomainCS.class, "ImperativeDomainCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeDomainCS_CheckedProperties(), theBaseCSPackage.getPathNameCS(), null, "checkedProperties", null, 0, -1, ImperativeDomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImperativeDomainCS_EnforcedProperties(), theBaseCSPackage.getPathNameCS(), null, "enforcedProperties", null, 0, -1, ImperativeDomainCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(imperativePredicateOrAssignmentCSEClass, ImperativePredicateOrAssignmentCS.class, "ImperativePredicateOrAssignmentCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImperativePredicateOrAssignmentCS_IsAccumulate(), ecorePackage.getEBoolean(), "isAccumulate", "false", 0, 1, ImperativePredicateOrAssignmentCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCSEClass, MappingCS.class, "MappingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCS_OwnedMappingSequence(), this.getMappingSequenceCS(), null, "ownedMappingSequence", null, 0, 1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCS_OwnedUsesPathNames(), theBaseCSPackage.getPathNameCS(), null, "ownedUsesPathNames", null, 0, -1, MappingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallBindingCSEClass, MappingCallBindingCS.class, "MappingCallBindingCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingCallBindingCS_IsPolled(), ecorePackage.getEBoolean(), "isPolled", "false", 0, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallBindingCS_OwnedValue(), theEssentialOCLCSPackage.getExpCS(), null, "ownedValue", null, 1, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallBindingCS_OwningMappingCall(), this.getMappingCallCS(), this.getMappingCallCS_OwnedBindings(), "owningMappingCall", null, 0, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallBindingCS_ReferredVariable(), thePivotPackage.getVariable(), null, "referredVariable", null, 1, 1, MappingCallBindingCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallCSEClass, MappingCallCS.class, "MappingCallCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMappingCallCS_IsInfinite(), ecorePackage.getEBoolean(), "isInfinite", "false", 0, 1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallCS_OwnedBindings(), this.getMappingCallBindingCS(), this.getMappingCallBindingCS_OwningMappingCall(), "ownedBindings", null, 0, -1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMappingCallCS_OwnedPathName(), theBaseCSPackage.getPathNameCS(), null, "ownedPathName", null, 0, 1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallCS_ReferredMapping(), theQVTimperativePackage.getMapping(), null, "referredMapping", null, 0, 1, MappingCallCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(mappingLoopCSEClass, MappingLoopCS.class, "MappingLoopCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingLoopCS_OwnedIterator(), theEssentialOCLCSPackage.getVariableCS(), null, "ownedIterator", null, 1, 1, MappingLoopCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingLoopCS_OwnedInExpression(), theEssentialOCLCSPackage.getExpCS(), null, "ownedInExpression", null, 1, 1, MappingLoopCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingLoopCS_OwnedMappingSequence(), this.getMappingSequenceCS(), null, "ownedMappingSequence", null, 1, 1, MappingLoopCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingSequenceCSEClass, MappingSequenceCS.class, "MappingSequenceCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingSequenceCS_OwnedMappingStatements(), this.getMappingStatementCS(), null, "ownedMappingStatements", null, 1, -1, MappingSequenceCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingStatementCSEClass, MappingStatementCS.class, "MappingStatementCS", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(topLevelCSEClass, TopLevelCS.class, "TopLevelCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTopLevelCS_OwnedTransformations(), theQVTcoreBaseCSPackage.getTransformationCS(), null, "ownedTransformations", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_OwnedQueries(), theQVTcoreBaseCSPackage.getQueryCS(), null, "ownedQueries", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTopLevelCS_OwnedMappings(), this.getMappingCS(), null, "ownedMappings", null, 0, -1, TopLevelCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //QVTimperativeCSTPackageImpl
