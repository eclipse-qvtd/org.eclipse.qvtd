/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.ocl.examples.pivot.PivotPackage;

import org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction;
import org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum;
import org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum;
import org.eclipse.qvtd.build.etl.qvtscheduling.DataTypeDatum;
import org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData;
import org.eclipse.qvtd.build.etl.qvtscheduling.InputAction;
import org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction;
import org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding;
import org.eclipse.qvtd.build.etl.qvtscheduling.OutputAction;
import org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingFactory;
import org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage;

import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QvtSchedulingPackageImpl extends EPackageImpl implements QvtSchedulingPackage {
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
	private EClass dataTypeDatumEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass distinctDataEClass = null;

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
	private EClass mappingBindingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass outputActionEClass = null;

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
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QvtSchedulingPackageImpl() {
		super(eNS_URI, QvtSchedulingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QvtSchedulingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QvtSchedulingPackage init() {
		if (isInited) return (QvtSchedulingPackage)EPackage.Registry.INSTANCE.getEPackage(QvtSchedulingPackage.eNS_URI);

		// Obtain or create and register package
		QvtSchedulingPackageImpl theQvtSchedulingPackage = (QvtSchedulingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QvtSchedulingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QvtSchedulingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		QVTcoreBasePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theQvtSchedulingPackage.createPackageContents();

		// Initialize created meta-data
		theQvtSchedulingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theQvtSchedulingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QvtSchedulingPackage.eNS_URI, theQvtSchedulingPackage);
		return theQvtSchedulingPackage;
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
	public EReference getAbstractDatum_Sources() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_PrimaryDistinctData() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_SecondaryDistinctData() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_Parent() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_Super() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_Type() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_Domain() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractDatum_Targets() {
		return (EReference)abstractDatumEClass.getEStructuralFeatures().get(7);
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
	public EReference getAbstractAction_Results() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_DistinctArguments() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAbstractAction_Count() {
		return (EAttribute)abstractActionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Parent() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Children() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAbstractAction_Arguments() {
		return (EReference)abstractActionEClass.getEStructuralFeatures().get(5);
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
	public EReference getClassDatum_RealizedVariables() {
		return (EReference)classDatumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getClassDatum_Variables() {
		return (EReference)classDatumEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataTypeDatum() {
		return dataTypeDatumEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDistinctData() {
		return distinctDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDistinctData_Targets() {
		return (EReference)distinctDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDistinctData_PrimaryArgument() {
		return (EReference)distinctDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDistinctData_SecondaryArgument() {
		return (EReference)distinctDataEClass.getEStructuralFeatures().get(2);
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
	public EReference getMappingAction_MappingBindings() {
		return (EReference)mappingActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMappingBinding() {
		return mappingBindingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingBinding_MappingAction() {
		return (EReference)mappingBindingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMappingBinding_Loop() {
		return (EAttribute)mappingBindingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMappingBinding_Datum() {
		return (EReference)mappingBindingEClass.getEStructuralFeatures().get(2);
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
	public QvtSchedulingFactory getQvtSchedulingFactory() {
		return (QvtSchedulingFactory)getEFactoryInstance();
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
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__SOURCES);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__PARENT);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__SUPER);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__TYPE);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__DOMAIN);
		createEReference(abstractDatumEClass, ABSTRACT_DATUM__TARGETS);

		abstractActionEClass = createEClass(ABSTRACT_ACTION);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__RESULTS);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__DISTINCT_ARGUMENTS);
		createEAttribute(abstractActionEClass, ABSTRACT_ACTION__COUNT);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__PARENT);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__CHILDREN);
		createEReference(abstractActionEClass, ABSTRACT_ACTION__ARGUMENTS);

		classDatumEClass = createEClass(CLASS_DATUM);
		createEReference(classDatumEClass, CLASS_DATUM__REALIZED_VARIABLES);
		createEReference(classDatumEClass, CLASS_DATUM__VARIABLES);

		dataTypeDatumEClass = createEClass(DATA_TYPE_DATUM);

		distinctDataEClass = createEClass(DISTINCT_DATA);
		createEReference(distinctDataEClass, DISTINCT_DATA__TARGETS);
		createEReference(distinctDataEClass, DISTINCT_DATA__PRIMARY_ARGUMENT);
		createEReference(distinctDataEClass, DISTINCT_DATA__SECONDARY_ARGUMENT);

		inputActionEClass = createEClass(INPUT_ACTION);

		mappingActionEClass = createEClass(MAPPING_ACTION);
		createEReference(mappingActionEClass, MAPPING_ACTION__MAPPING_BINDINGS);

		mappingBindingEClass = createEClass(MAPPING_BINDING);
		createEReference(mappingBindingEClass, MAPPING_BINDING__MAPPING_ACTION);
		createEAttribute(mappingBindingEClass, MAPPING_BINDING__LOOP);
		createEReference(mappingBindingEClass, MAPPING_BINDING__DATUM);

		outputActionEClass = createEClass(OUTPUT_ACTION);
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
		PivotPackage thePivotPackage = (PivotPackage)EPackage.Registry.INSTANCE.getEPackage(PivotPackage.eNS_URI);
		QVTcoreBasePackage theQVTcoreBasePackage = (QVTcoreBasePackage)EPackage.Registry.INSTANCE.getEPackage(QVTcoreBasePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		classDatumEClass.getESuperTypes().add(this.getAbstractDatum());
		dataTypeDatumEClass.getESuperTypes().add(this.getAbstractDatum());
		inputActionEClass.getESuperTypes().add(this.getAbstractAction());
		mappingActionEClass.getESuperTypes().add(this.getAbstractAction());
		outputActionEClass.getESuperTypes().add(this.getAbstractAction());

		// Initialize classes, features, and operations; add parameters
		initEClass(abstractDatumEClass, AbstractDatum.class, "AbstractDatum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractDatum_Sources(), this.getAbstractAction(), this.getAbstractAction_Results(), "sources", null, 0, -1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_PrimaryDistinctData(), this.getDistinctData(), this.getDistinctData_PrimaryArgument(), "primaryDistinctData", null, 0, 1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_SecondaryDistinctData(), this.getDistinctData(), this.getDistinctData_SecondaryArgument(), "secondaryDistinctData", null, 0, -1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_Parent(), this.getAbstractDatum(), null, "parent", null, 0, 1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_Super(), this.getAbstractDatum(), null, "super", null, 0, -1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_Type(), thePivotPackage.getType(), null, "type", null, 1, 1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_Domain(), theQVTcoreBasePackage.getCoreDomain(), null, "domain", null, 0, 1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractDatum_Targets(), this.getAbstractAction(), this.getAbstractAction_Arguments(), "targets", null, 0, -1, AbstractDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(abstractActionEClass, AbstractAction.class, "AbstractAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAbstractAction_Results(), this.getAbstractDatum(), this.getAbstractDatum_Sources(), "results", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_DistinctArguments(), this.getDistinctData(), this.getDistinctData_Targets(), "distinctArguments", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAbstractAction_Count(), ecorePackage.getEInt(), "count", null, 0, 1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_Parent(), this.getAbstractAction(), this.getAbstractAction_Children(), "parent", null, 0, 1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_Children(), this.getAbstractAction(), this.getAbstractAction_Parent(), "children", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAbstractAction_Arguments(), this.getAbstractDatum(), this.getAbstractDatum_Targets(), "arguments", null, 0, -1, AbstractAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(classDatumEClass, ClassDatum.class, "ClassDatum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassDatum_RealizedVariables(), theQVTcoreBasePackage.getRealizedVariable(), null, "realizedVariables", null, 0, -1, ClassDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassDatum_Variables(), thePivotPackage.getVariable(), null, "variables", null, 0, -1, ClassDatum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataTypeDatumEClass, DataTypeDatum.class, "DataTypeDatum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(distinctDataEClass, DistinctData.class, "DistinctData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDistinctData_Targets(), this.getAbstractAction(), this.getAbstractAction_DistinctArguments(), "targets", null, 0, -1, DistinctData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDistinctData_PrimaryArgument(), this.getAbstractDatum(), this.getAbstractDatum_PrimaryDistinctData(), "primaryArgument", null, 0, -1, DistinctData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDistinctData_SecondaryArgument(), this.getAbstractDatum(), this.getAbstractDatum_SecondaryDistinctData(), "secondaryArgument", null, 0, -1, DistinctData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(inputActionEClass, InputAction.class, "InputAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mappingActionEClass, MappingAction.class, "MappingAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingAction_MappingBindings(), this.getMappingBinding(), this.getMappingBinding_MappingAction(), "mappingBindings", null, 0, -1, MappingAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mappingBindingEClass, MappingBinding.class, "MappingBinding", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappingBinding_MappingAction(), this.getMappingAction(), this.getMappingAction_MappingBindings(), "mappingAction", null, 0, 1, MappingBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappingBinding_Loop(), ecorePackage.getEBoolean(), "loop", null, 0, 1, MappingBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappingBinding_Datum(), this.getDataTypeDatum(), null, "datum", null, 0, 1, MappingBinding.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(outputActionEClass, OutputAction.class, "OutputAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //QvtSchedulingPackageImpl
