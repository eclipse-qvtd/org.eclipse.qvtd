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
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingLoop;
import org.eclipse.qvtd.pivot.qvtimperative.MappingSequence;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QVTimperativePackageImpl extends EPackageImpl implements QVTimperativePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectionAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeAreaEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeBottomPatternEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeDomainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imperativeModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingCallBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingSequenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variablePredicateEClass = null;

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
	 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QVTimperativePackageImpl() {
		super(eNS_URI, QVTimperativeFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QVTimperativePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QVTimperativePackage init() {
		if (isInited) return (QVTimperativePackage)EPackage.Registry.INSTANCE.getEPackage(QVTimperativePackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		QVTimperativePackageImpl theQVTimperativePackage = (QVTimperativePackageImpl)(ePackage instanceof QVTimperativePackageImpl ? ePackage : new QVTimperativePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTcoreBasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQVTimperativePackage.createPackageContents();

		// Initialize created meta-data
		theQVTimperativePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQVTimperativePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QVTimperativePackage.eNS_URI, theQVTimperativePackage);
		return theQVTimperativePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConnectionAssignment() {
		return connectionAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getConnectionAssignment_TargetVariable() {
		return (EReference)connectionAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImperativeArea() {
		return imperativeAreaEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImperativeArea_CheckedProperties() {
		return (EReference)imperativeAreaEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImperativeArea_EnforcedProperties() {
		return (EReference)imperativeAreaEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImperativeBottomPattern() {
		return imperativeBottomPatternEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImperativeBottomPattern_OrderedAssignment() {
		return (EReference)imperativeBottomPatternEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImperativeDomain() {
		return imperativeDomainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImperativeModel() {
		return imperativeModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapping() {
		return mappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_MappingStatement() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMapping_PolledClasses() {
		return (EReference)mappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingCall() {
		return mappingCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCall_ReferredMapping() {
		return (EReference)mappingCallEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCall_Binding() {
		return (EReference)mappingCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingCall_IsInfinite() {
		return (EAttribute)mappingCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingCallBinding() {
		return mappingCallBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallBinding_MappingCall() {
		return (EReference)mappingCallBindingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallBinding_BoundVariable() {
		return (EReference)mappingCallBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappingCallBinding_IsPolled() {
		return (EAttribute)mappingCallBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingCallBinding_Value() {
		return (EReference)mappingCallBindingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingLoop() {
		return mappingLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoop_OwnedBody() {
		return (EReference)mappingLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingLoop_OwnedIterators() {
		return (EReference)mappingLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingSequence() {
		return mappingSequenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappingSequence_MappingStatements() {
		return (EReference)mappingSequenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappingStatement() {
		return mappingStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariablePredicate() {
		return variablePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariablePredicate_TargetVariable() {
		return (EReference)variablePredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public QVTimperativeFactory getQVTimperativeFactory() {
		return (QVTimperativeFactory)getEFactoryInstance();
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
		connectionAssignmentEClass = createEClass(CONNECTION_ASSIGNMENT);
		createEReference(connectionAssignmentEClass, CONNECTION_ASSIGNMENT__TARGET_VARIABLE);

		imperativeAreaEClass = createEClass(IMPERATIVE_AREA);
		createEReference(imperativeAreaEClass, IMPERATIVE_AREA__CHECKED_PROPERTIES);
		createEReference(imperativeAreaEClass, IMPERATIVE_AREA__ENFORCED_PROPERTIES);

		imperativeBottomPatternEClass = createEClass(IMPERATIVE_BOTTOM_PATTERN);
		createEReference(imperativeBottomPatternEClass, IMPERATIVE_BOTTOM_PATTERN__ORDERED_ASSIGNMENT);

		imperativeDomainEClass = createEClass(IMPERATIVE_DOMAIN);

		imperativeModelEClass = createEClass(IMPERATIVE_MODEL);

		mappingEClass = createEClass(MAPPING);
		createEReference(mappingEClass, MAPPING__MAPPING_STATEMENT);
		createEReference(mappingEClass, MAPPING__POLLED_CLASSES);

		mappingCallEClass = createEClass(MAPPING_CALL);
		createEReference(mappingCallEClass, MAPPING_CALL__BINDING);
		createEAttribute(mappingCallEClass, MAPPING_CALL__IS_INFINITE);
		createEReference(mappingCallEClass, MAPPING_CALL__REFERRED_MAPPING);

		mappingCallBindingEClass = createEClass(MAPPING_CALL_BINDING);
		createEReference(mappingCallBindingEClass, MAPPING_CALL_BINDING__BOUND_VARIABLE);
		createEAttribute(mappingCallBindingEClass, MAPPING_CALL_BINDING__IS_POLLED);
		createEReference(mappingCallBindingEClass, MAPPING_CALL_BINDING__MAPPING_CALL);
		createEReference(mappingCallBindingEClass, MAPPING_CALL_BINDING__VALUE);

		mappingLoopEClass = createEClass(MAPPING_LOOP);
		createEReference(mappingLoopEClass, MAPPING_LOOP__OWNED_BODY);
		createEReference(mappingLoopEClass, MAPPING_LOOP__OWNED_ITERATORS);

		mappingSequenceEClass = createEClass(MAPPING_SEQUENCE);
		createEReference(mappingSequenceEClass, MAPPING_SEQUENCE__MAPPING_STATEMENTS);

		mappingStatementEClass = createEClass(MAPPING_STATEMENT);

		variablePredicateEClass = createEClass(VARIABLE_PREDICATE);
		createEReference(variablePredicateEClass, VARIABLE_PREDICATE__TARGET_VARIABLE);
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
		QVTcoreBasePackage theQVTcoreBasePackage = (QVTcoreBasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTcoreBasePackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		connectionAssignmentEClass.getESuperTypes().add(theQVTcoreBasePackage.getAssignment());
		imperativeAreaEClass.getESuperTypes().add(theQVTcoreBasePackage.getArea());
		imperativeBottomPatternEClass.getESuperTypes().add(theQVTcoreBasePackage.getBottomPattern());
		imperativeDomainEClass.getESuperTypes().add(theQVTcoreBasePackage.getCoreDomain());
		imperativeDomainEClass.getESuperTypes().add(this.getImperativeArea());
		imperativeModelEClass.getESuperTypes().add(theQVTbasePackage.getBaseModel());
		mappingEClass.getESuperTypes().add(theQVTcoreBasePackage.getAbstractMapping());
		mappingEClass.getESuperTypes().add(this.getImperativeArea());
		mappingCallEClass.getESuperTypes().add(this.getMappingStatement());
		mappingCallEClass.getESuperTypes().add(thePivotPackage.getReferringElement());
		mappingCallBindingEClass.getESuperTypes().add(thePivotPackage.getElement());
		mappingLoopEClass.getESuperTypes().add(thePivotPackage.getCallExp());
		mappingLoopEClass.getESuperTypes().add(this.getMappingStatement());
		mappingSequenceEClass.getESuperTypes().add(this.getMappingStatement());
		mappingStatementEClass.getESuperTypes().add(thePivotPackage.getOCLExpression());
		variablePredicateEClass.getESuperTypes().add(theQVTbasePackage.getPredicate());

		// Initialize classes and features; add operations and parameters
		initEClass(connectionAssignmentEClass, ConnectionAssignment.class, "ConnectionAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectionAssignment_TargetVariable(), thePivotPackage.getVariable(), null, "targetVariable", null, 1, 1, ConnectionAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imperativeAreaEClass, ImperativeArea.class, "ImperativeArea", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeArea_CheckedProperties(), thePivotPackage.getProperty(), null, "checkedProperties", null, 0, -1, ImperativeArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImperativeArea_EnforcedProperties(), thePivotPackage.getProperty(), null, "enforcedProperties", null, 0, -1, ImperativeArea.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(imperativeBottomPatternEClass, ImperativeBottomPattern.class, "ImperativeBottomPattern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImperativeBottomPattern_OrderedAssignment(), theQVTcoreBasePackage.getAssignment(), null, "orderedAssignment", null, 0, -1, ImperativeBottomPattern.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(imperativeDomainEClass, ImperativeDomain.class, "ImperativeDomain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imperativeModelEClass, ImperativeModel.class, "ImperativeModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingEClass, Mapping.class, "Mapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMapping_MappingStatement(), this.getMappingStatement(), null, "mappingStatement", null, 0, 1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMapping_PolledClasses(), thePivotPackage.getClass_(), null, "polledClasses", null, 0, -1, Mapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(mappingEClass, this.getMapping(), "getAllMappings", 0, -1, IS_UNIQUE, !IS_ORDERED);

		initEClass(mappingCallEClass, MappingCall.class, "MappingCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCall_Binding(), this.getMappingCallBinding(), this.getMappingCallBinding_MappingCall(), "binding", null, 0, -1, MappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingCall_IsInfinite(), thePivotPackage.getBoolean(), "isInfinite", "false", 0, 1, MappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCall_ReferredMapping(), this.getMapping(), null, "referredMapping", null, 1, 1, MappingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingCallBindingEClass, MappingCallBinding.class, "MappingCallBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingCallBinding_BoundVariable(), thePivotPackage.getVariable(), null, "boundVariable", null, 1, 1, MappingCallBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingCallBinding_IsPolled(), thePivotPackage.getBoolean(), "isPolled", "false", 0, 1, MappingCallBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallBinding_MappingCall(), this.getMappingCall(), this.getMappingCall_Binding(), "mappingCall", null, 0, 1, MappingCallBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingCallBinding_Value(), thePivotPackage.getOCLExpression(), null, "value", null, 1, 1, MappingCallBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingLoopEClass, MappingLoop.class, "MappingLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingLoop_OwnedBody(), thePivotPackage.getOCLExpression(), null, "ownedBody", null, 1, 1, MappingLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingLoop_OwnedIterators(), thePivotPackage.getVariable(), null, "ownedIterators", null, 0, -1, MappingLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingSequenceEClass, MappingSequence.class, "MappingSequence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingSequence_MappingStatements(), this.getMappingStatement(), null, "mappingStatements", null, 0, -1, MappingSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingStatementEClass, MappingStatement.class, "MappingStatement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(variablePredicateEClass, VariablePredicate.class, "VariablePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariablePredicate_TargetVariable(), thePivotPackage.getVariable(), null, "targetVariable", null, 1, 1, VariablePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "qvtb", "../../org.eclipse.qvtd.pivot.qvtbase/model/QVTbase.ecore#/",
			 "qvtcb", "../../org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.ecore#/"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";	
		addAnnotation
		  (getConnectionAssignment_TargetVariable(), 
		   source, 
		   new String[] {
			 "body", "assignment"
		   });	
		addAnnotation
		  (getVariablePredicate_TargetVariable(), 
		   source, 
		   new String[] {
			 "body", "predicate"
		   });
	}

} //QVTimperativePackageImpl
