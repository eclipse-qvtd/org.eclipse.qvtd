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
package org.eclipse.qvtd.pivot.schedule;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.schedule.ScheduleFactory
 * @model kind="package"
 * @generated
 */
public interface SchedulePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "schedule";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2015/Schedule";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulePackage eINSTANCE = org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl
	 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getAbstractDatum()
	 * @generated
	 */
	int ABSTRACT_DATUM = 0;

	/**
	 * The feature id for the '<em><b>Produced By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__PRODUCED_BY = 0;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__REQUIRED_BY = 1;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__TYPED_MODEL = 2;

	/**
	 * The number of structural features of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.schedule.impl.ClassDatumImpl <em>Class Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.schedule.impl.ClassDatumImpl
	 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getClassDatum()
	 * @generated
	 */
	int CLASS_DATUM = 1;

	/**
	 * The feature id for the '<em><b>Produced By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__PRODUCED_BY = ABSTRACT_DATUM__PRODUCED_BY;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__REQUIRED_BY = ABSTRACT_DATUM__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__TYPED_MODEL = ABSTRACT_DATUM__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Complete Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__COMPLETE_CLASS = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Datums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__PROPERTY_DATUMS = ABSTRACT_DATUM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SCHEDULE = ABSTRACT_DATUM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SUPER = ABSTRACT_DATUM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_OPERATION_COUNT = ABSTRACT_DATUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.schedule.impl.MappingActionImpl <em>Mapping Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.schedule.impl.MappingActionImpl
	 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getMappingAction()
	 * @generated
	 */
	int MAPPING_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__MAPPING = 0;

	/**
	 * The feature id for the '<em><b>Productions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__PRODUCTIONS = 1;

	/**
	 * The feature id for the '<em><b>Requisites</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__REQUISITES = 2;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__SCHEDULE = 3;

	/**
	 * The number of structural features of the '<em>Mapping Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Mapping Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.schedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.schedule.impl.PropertyDatumImpl
	 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getPropertyDatum()
	 * @generated
	 */
	int PROPERTY_DATUM = 3;

	/**
	 * The feature id for the '<em><b>Produced By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__PRODUCED_BY = ABSTRACT_DATUM__PRODUCED_BY;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__REQUIRED_BY = ABSTRACT_DATUM__REQUIRED_BY;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__TYPED_MODEL = ABSTRACT_DATUM__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__PROPERTY = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__CLASS_DATUM = ABSTRACT_DATUM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__OPPOSITE = ABSTRACT_DATUM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__SUPER = ABSTRACT_DATUM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Property Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Property Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM_OPERATION_COUNT = ABSTRACT_DATUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.schedule.impl.ScheduleImpl <em>Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.schedule.impl.ScheduleImpl
	 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getSchedule()
	 * @generated
	 */
	int SCHEDULE = 4;

	/**
	 * The feature id for the '<em><b>Datums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE__DATUMS = 0;

	/**
	 * The feature id for the '<em><b>Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE__ACTIONS = 1;

	/**
	 * The number of structural features of the '<em>Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Schedule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum <em>Abstract Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum
	 * @generated
	 */
	EClass getAbstractDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum#getTypedModel()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_TypedModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getProducedBy <em>Produced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Produced By</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum#getProducedBy()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_ProducedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.schedule.AbstractDatum#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required By</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.AbstractDatum#getRequiredBy()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_RequiredBy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.schedule.ClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.ClassDatum
	 * @generated
	 */
	EClass getClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.schedule.ClassDatum#getCompleteClass <em>Complete Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Complete Class</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.ClassDatum#getCompleteClass()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_CompleteClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.schedule.ClassDatum#getPropertyDatums <em>Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.ClassDatum#getPropertyDatums()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_PropertyDatums();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.schedule.ClassDatum#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Schedule</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.ClassDatum#getSchedule()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_Schedule();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.schedule.ClassDatum#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.ClassDatum#getSuper()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_Super();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.schedule.MappingAction <em>Mapping Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Action</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.MappingAction
	 * @generated
	 */
	EClass getMappingAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.MappingAction#getMapping()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_Mapping();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getProductions <em>Productions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Productions</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.MappingAction#getProductions()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_Productions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getRequisites <em>Requisites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requisites</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.MappingAction#getRequisites()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_Requisites();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.schedule.MappingAction#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Schedule</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.MappingAction#getSchedule()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_Schedule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.schedule.PropertyDatum <em>Property Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.PropertyDatum
	 * @generated
	 */
	EClass getPropertyDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.schedule.PropertyDatum#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.PropertyDatum#getProperty()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_Property();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.schedule.PropertyDatum#getClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.PropertyDatum#getClassDatum()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_ClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.schedule.PropertyDatum#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.PropertyDatum#getOpposite()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_Opposite();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.schedule.PropertyDatum#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.PropertyDatum#getSuper()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_Super();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.schedule.Schedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.Schedule
	 * @generated
	 */
	EClass getSchedule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.schedule.Schedule#getDatums <em>Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.Schedule#getDatums()
	 * @see #getSchedule()
	 * @generated
	 */
	EReference getSchedule_Datums();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.schedule.Schedule#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.eclipse.qvtd.pivot.schedule.Schedule#getActions()
	 * @see #getSchedule()
	 * @generated
	 */
	EReference getSchedule_Actions();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ScheduleFactory getScheduleFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.schedule.impl.AbstractDatumImpl
		 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getAbstractDatum()
		 * @generated
		 */
		EClass ABSTRACT_DATUM = eINSTANCE.getAbstractDatum();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__TYPED_MODEL = eINSTANCE.getAbstractDatum_TypedModel();

		/**
		 * The meta object literal for the '<em><b>Produced By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__PRODUCED_BY = eINSTANCE.getAbstractDatum_ProducedBy();

		/**
		 * The meta object literal for the '<em><b>Required By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__REQUIRED_BY = eINSTANCE.getAbstractDatum_RequiredBy();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.schedule.impl.ClassDatumImpl <em>Class Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.schedule.impl.ClassDatumImpl
		 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getClassDatum()
		 * @generated
		 */
		EClass CLASS_DATUM = eINSTANCE.getClassDatum();

		/**
		 * The meta object literal for the '<em><b>Complete Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__COMPLETE_CLASS = eINSTANCE.getClassDatum_CompleteClass();

		/**
		 * The meta object literal for the '<em><b>Property Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__PROPERTY_DATUMS = eINSTANCE.getClassDatum_PropertyDatums();

		/**
		 * The meta object literal for the '<em><b>Schedule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__SCHEDULE = eINSTANCE.getClassDatum_Schedule();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__SUPER = eINSTANCE.getClassDatum_Super();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.schedule.impl.MappingActionImpl <em>Mapping Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.schedule.impl.MappingActionImpl
		 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getMappingAction()
		 * @generated
		 */
		EClass MAPPING_ACTION = eINSTANCE.getMappingAction();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__MAPPING = eINSTANCE.getMappingAction_Mapping();

		/**
		 * The meta object literal for the '<em><b>Productions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__PRODUCTIONS = eINSTANCE.getMappingAction_Productions();

		/**
		 * The meta object literal for the '<em><b>Requisites</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__REQUISITES = eINSTANCE.getMappingAction_Requisites();

		/**
		 * The meta object literal for the '<em><b>Schedule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__SCHEDULE = eINSTANCE.getMappingAction_Schedule();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.schedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.schedule.impl.PropertyDatumImpl
		 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getPropertyDatum()
		 * @generated
		 */
		EClass PROPERTY_DATUM = eINSTANCE.getPropertyDatum();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__PROPERTY = eINSTANCE.getPropertyDatum_Property();

		/**
		 * The meta object literal for the '<em><b>Class Datum</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__CLASS_DATUM = eINSTANCE.getPropertyDatum_ClassDatum();

		/**
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__OPPOSITE = eINSTANCE.getPropertyDatum_Opposite();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__SUPER = eINSTANCE.getPropertyDatum_Super();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.schedule.impl.ScheduleImpl <em>Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.schedule.impl.ScheduleImpl
		 * @see org.eclipse.qvtd.pivot.schedule.impl.SchedulePackageImpl#getSchedule()
		 * @generated
		 */
		EClass SCHEDULE = eINSTANCE.getSchedule();

		/**
		 * The meta object literal for the '<em><b>Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE__DATUMS = eINSTANCE.getSchedule_Datums();

		/**
		 * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE__ACTIONS = eINSTANCE.getSchedule_Actions();

	}

} //SchedulePackage
