/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.schedule.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.DataParameter;
import org.eclipse.qvtd.pivot.schedule.InputAction;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.OutputAction;
import org.eclipse.qvtd.pivot.schedule.ParameterDerivation;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.ScheduleFactory;
import org.eclipse.qvtd.pivot.schedule.SchedulePackage;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.ScheduleElement;
import org.eclipse.qvtd.pivot.schedule.SecondaryParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulePackageImpl extends EPackageImpl implements SchedulePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractDatumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classDatumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass inputActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappingActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterDerivationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyDatumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduleElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass secondaryParameterEClass = null;

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
	 * @see org.eclipse.qvtd.pivot.schedule.SchedulePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SchedulePackageImpl() {
		super(eNS_URI, ScheduleFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SchedulePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SchedulePackage init() {
		if (isInited) return (SchedulePackage)EPackage.Registry.INSTANCE.getEPackage(SchedulePackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		SchedulePackageImpl theSchedulePackage = (SchedulePackageImpl)(ePackage instanceof SchedulePackageImpl ? ePackage : new SchedulePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTimperativePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSchedulePackage.createPackageContents();

		// Initialize created meta-data
		theSchedulePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSchedulePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SchedulePackage.eNS_URI, theSchedulePackage);
		return theSchedulePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractDatum() {
		return abstractDatumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_Super() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_Sub() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_Domain() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_TypedModel() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_ProducedBy() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_RequiredBy() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_Schedule() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_DataParameter() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractAction() {
		return abstractActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Productions() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Requisites() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_ParameterDerivations() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractAction_Order() {
		return (EAttribute)abstractActionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Parent() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Children() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Parameters() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Results() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Schedule() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getClassDatum() {
		return classDatumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassDatum_Type() {
		return (EReference)classDatumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassDatum_PropertyDatums() {
		return (EReference)classDatumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataParameter() {
		return dataParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataParameter_Variable() {
		return (EReference)dataParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataParameter_SecondaryParameter() {
		return (EReference)dataParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataParameter_Datum() {
		return (EReference)dataParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInputAction() {
		return inputActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingAction() {
		return mappingActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingAction_Mapping() {
		return (EReference)mappingActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOutputAction() {
		return outputActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterDerivation() {
		return parameterDerivationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDerivation_Target() {
		return (EReference)parameterDerivationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDerivation_PrimaryParameter() {
		return (EReference)parameterDerivationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterDerivation_SecondaryParameter() {
		return (EReference)parameterDerivationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPropertyDatum() {
		return propertyDatumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyDatum_Property() {
		return (EReference)propertyDatumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyDatum_ClassDatum() {
		return (EReference)propertyDatumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPropertyDatum_Opposite() {
		return (EReference)propertyDatumEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedule() {
		return scheduleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedule_Datums() {
		return (EReference)scheduleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSchedule_Actions() {
		return (EReference)scheduleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScheduleElement() {
		return scheduleElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSecondaryParameter() {
		return secondaryParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSecondaryParameter_IsLoop() {
		return (EAttribute)secondaryParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecondaryParameter_DataParameter() {
		return (EReference)secondaryParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecondaryParameter_DerivationProperty() {
		return (EReference)secondaryParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSecondaryParameter_Derivation() {
		return (EReference)secondaryParameterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScheduleFactory getScheduleFactory() {
		return (ScheduleFactory)getEFactoryInstance();
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
		abstractDatumEClass = createEClass(ABSTRACT_DATUM);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__SUPER);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__SUB);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__DOMAIN);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__PRODUCED_BY);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__REQUIRED_BY);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__SCHEDULE);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__DATA_PARAMETER);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__TYPED_MODEL);

		abstractActionEClass = createEClass(ABSTRACT_ACTION);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__PRODUCTIONS);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__REQUISITES);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__PARAMETER_DERIVATIONS);
		createEAttribute(abstractActionEClass, ABSTRACT_ACTION__ORDER);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__PARENT);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__CHILDREN);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__PARAMETERS);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__RESULTS);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__SCHEDULE);

		classDatumEClass = createEClass(CLASS_DATUM);
		createEReference(classDatumEClass, CLASS_DATUM__TYPE);
		createEReference(classDatumEClass, CLASS_DATUM__PROPERTY_DATUMS);

		dataParameterEClass = createEClass(DATA_PARAMETER);
		createEReference(dataParameterEClass, DATA_PARAMETER__VARIABLE);
		createEReference(dataParameterEClass, DATA_PARAMETER__SECONDARY_PARAMETER);
		createEReference(dataParameterEClass, DATA_PARAMETER__DATUM);

		inputActionEClass = createEClass(INPUT_ACTION);

		mappingActionEClass = createEClass(MAPPING_ACTION);
		createEReference(mappingActionEClass, MAPPING_ACTION__MAPPING);

		outputActionEClass = createEClass(OUTPUT_ACTION);

		parameterDerivationEClass = createEClass(PARAMETER_DERIVATION);
		createEReference(parameterDerivationEClass, PARAMETER_DERIVATION__TARGET);
		createEReference(parameterDerivationEClass, PARAMETER_DERIVATION__PRIMARY_PARAMETER);
		createEReference(parameterDerivationEClass, PARAMETER_DERIVATION__SECONDARY_PARAMETER);

		propertyDatumEClass = createEClass(PROPERTY_DATUM);
		createEReference(propertyDatumEClass, PROPERTY_DATUM__PROPERTY);
		createEReference(propertyDatumEClass, PROPERTY_DATUM__CLASS_DATUM);
		createEReference(propertyDatumEClass, PROPERTY_DATUM__OPPOSITE);

		scheduleEClass = createEClass(SCHEDULE);
		createEReference(scheduleEClass, SCHEDULE__DATUMS);
		createEReference(scheduleEClass, SCHEDULE__ACTIONS);

		scheduleElementEClass = createEClass(SCHEDULE_ELEMENT);

		secondaryParameterEClass = createEClass(SECONDARY_PARAMETER);
		createEAttribute(secondaryParameterEClass, SECONDARY_PARAMETER__IS_LOOP);
		createEReference(secondaryParameterEClass, SECONDARY_PARAMETER__DATA_PARAMETER);
		createEReference(secondaryParameterEClass, SECONDARY_PARAMETER__DERIVATION_PROPERTY);
		createEReference(secondaryParameterEClass, SECONDARY_PARAMETER__DERIVATION);
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
		QVTbasePackage theQVTbasePackage = (QVTbasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTbasePackage.eNS_URI);
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		abstractDatumEClass.getESuperTypes().add(this.getScheduleElement());
		abstractActionEClass.getESuperTypes().add(this.getScheduleElement());
		classDatumEClass.getESuperTypes().add(this.getAbstractDatum());
		dataParameterEClass.getESuperTypes().add(this.getScheduleElement());
		inputActionEClass.getESuperTypes().add(this.getAbstractAction());
		mappingActionEClass.getESuperTypes().add(this.getAbstractAction());
		outputActionEClass.getESuperTypes().add(this.getAbstractAction());
		parameterDerivationEClass.getESuperTypes().add(this.getScheduleElement());
		propertyDatumEClass.getESuperTypes().add(this.getAbstractDatum());
		scheduleEClass.getESuperTypes().add(this.getScheduleElement());
		secondaryParameterEClass.getESuperTypes().add(this.getScheduleElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractDatumEClass, AbstractDatum.class, "AbstractDatum", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractDatum_Super(), this.getAbstractDatum(), this.getAbstractDatum_Sub(), "super", null, 0, -1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_Sub(), this.getAbstractDatum(), this.getAbstractDatum_Super(), "sub", null, 0, -1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_Domain(), theQVTcoreBasePackage.getCoreDomain(), null, "domain", null, 0, 1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_ProducedBy(), this.getAbstractAction(), this.getAbstractAction_Productions(), "producedBy", null, 0, -1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_RequiredBy(), this.getAbstractAction(), this.getAbstractAction_Requisites(), "requiredBy", null, 0, -1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_Schedule(), this.getSchedule(), this.getSchedule_Datums(), "schedule", null, 0, 1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_DataParameter(), this.getDataParameter(), this.getDataParameter_Datum(), "dataParameter", null, 0, -1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_TypedModel(), theQVTbasePackage.getTypedModel(), null, "typedModel", null, 0, 1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractActionEClass, AbstractAction.class, "AbstractAction", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractAction_Productions(), this.getAbstractDatum(), this.getAbstractDatum_ProducedBy(), "productions", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_Requisites(), this.getAbstractDatum(), this.getAbstractDatum_RequiredBy(), "requisites", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_ParameterDerivations(), this.getParameterDerivation(), this.getParameterDerivation_Target(), "parameterDerivations", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractAction_Order(), ecorePackage.getEInt(), "order", null, 0, 1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_Parent(), this.getAbstractAction(), this.getAbstractAction_Children(), "parent", null, 0, 1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_Children(), this.getAbstractAction(), this.getAbstractAction_Parent(), "children", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_Parameters(), this.getDataParameter(), null, "parameters", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_Results(), this.getDataParameter(), null, "results", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_Schedule(), this.getSchedule(), this.getSchedule_Actions(), "schedule", null, 0, 1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classDatumEClass, ClassDatum.class, "ClassDatum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassDatum_Type(), thePivotPackage.getClass_(), null, "type", null, 1, 1, ClassDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getClassDatum_PropertyDatums(), this.getPropertyDatum(), this.getPropertyDatum_ClassDatum(), "propertyDatums", null, 0, -1, ClassDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataParameterEClass, DataParameter.class, "DataParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataParameter_Variable(), thePivotPackage.getVariable(), null, "variable", null, 1, 1, DataParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataParameter_SecondaryParameter(), this.getSecondaryParameter(), this.getSecondaryParameter_DataParameter(), "secondaryParameter", null, 0, 1, DataParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataParameter_Datum(), this.getAbstractDatum(), this.getAbstractDatum_DataParameter(), "datum", null, 1, 1, DataParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputActionEClass, InputAction.class, "InputAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingActionEClass, MappingAction.class, "MappingAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingAction_Mapping(), theQVTcoreBasePackage.getAbstractMapping(), null, "mapping", null, 0, 1, MappingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputActionEClass, OutputAction.class, "OutputAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(parameterDerivationEClass, ParameterDerivation.class, "ParameterDerivation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterDerivation_Target(), this.getAbstractAction(), this.getAbstractAction_ParameterDerivations(), "target", null, 0, 1, ParameterDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterDerivation_PrimaryParameter(), this.getDataParameter(), null, "primaryParameter", null, 0, 1, ParameterDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterDerivation_SecondaryParameter(), this.getSecondaryParameter(), this.getSecondaryParameter_Derivation(), "secondaryParameter", null, 0, 1, ParameterDerivation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertyDatumEClass, PropertyDatum.class, "PropertyDatum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPropertyDatum_Property(), thePivotPackage.getProperty(), null, "property", null, 1, 1, PropertyDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyDatum_ClassDatum(), this.getClassDatum(), this.getClassDatum_PropertyDatums(), "classDatum", null, 1, 1, PropertyDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPropertyDatum_Opposite(), this.getPropertyDatum(), null, "opposite", null, 0, 1, PropertyDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scheduleEClass, Schedule.class, "Schedule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSchedule_Datums(), this.getAbstractDatum(), this.getAbstractDatum_Schedule(), "datums", null, 0, -1, Schedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSchedule_Actions(), this.getAbstractAction(), this.getAbstractAction_Schedule(), "actions", null, 0, -1, Schedule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(scheduleElementEClass, ScheduleElement.class, "ScheduleElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(secondaryParameterEClass, SecondaryParameter.class, "SecondaryParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSecondaryParameter_IsLoop(), ecorePackage.getEBoolean(), "isLoop", null, 0, 1, SecondaryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecondaryParameter_DataParameter(), this.getDataParameter(), this.getDataParameter_SecondaryParameter(), "dataParameter", null, 1, 1, SecondaryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecondaryParameter_DerivationProperty(), thePivotPackage.getProperty(), null, "derivationProperty", null, 0, 1, SecondaryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSecondaryParameter_Derivation(), this.getParameterDerivation(), this.getParameterDerivation_SecondaryParameter(), "derivation", null, 0, 1, SecondaryParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SchedulePackageImpl
