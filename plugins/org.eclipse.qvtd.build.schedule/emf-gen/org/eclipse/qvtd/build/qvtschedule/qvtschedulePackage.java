/**
 */
package org.eclipse.qvtd.build.qvtschedule;

import org.eclipse.emf.ecore.EAttribute;
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
 * <!-- begin-model-doc -->
 * The Package for an Imperative QVT Schedule.
 * <!-- end-model-doc -->
 * @see org.eclipse.qvtd.build.qvtschedule.qvtscheduleFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/OCL/Import ecore='http://www.eclipse.org/emf/2002/Ecore' qvtcb='../../org.eclipse.qvtd.pivot.qvtcorebase/model/QVTcoreBase.ecore#/' qvti='../../org.eclipse.qvtd.pivot.qvtimperative/model/QVTimperative.ecore#/'"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore invocationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' settingDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot' validationDelegates='http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot'"
 * @generated
 */
public interface qvtschedulePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtschedule";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/0.1/QVTschedule/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtschedule";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	qvtschedulePackage eINSTANCE = org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getAbstractDatum()
	 * @generated
	 */
	int ABSTRACT_DATUM = 0;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__SUPER = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__DOMAIN = 2;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__SOURCES = 3;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__TARGETS = 4;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__SCHEDULE = 5;

	/**
	 * The feature id for the '<em><b>Data Parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__DATA_PARAMETER = 6;

	/**
	 * The number of structural features of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getAbstractAction()
	 * @generated
	 */
	int ABSTRACT_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__RESULTS = 0;

	/**
	 * The feature id for the '<em><b>Distinct Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__DISTINCT_ARGUMENTS = 1;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__ORDER = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__PARENT = 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__CHILDREN = 4;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__ARGUMENTS = 5;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__SCHEDULE = 6;

	/**
	 * The number of structural features of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.ClassDatumImpl <em>Class Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.ClassDatumImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getClassDatum()
	 * @generated
	 */
	int CLASS_DATUM = 2;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SUPER = ABSTRACT_DATUM__SUPER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__TYPE = ABSTRACT_DATUM__TYPE;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__DOMAIN = ABSTRACT_DATUM__DOMAIN;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SOURCES = ABSTRACT_DATUM__SOURCES;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__TARGETS = ABSTRACT_DATUM__TARGETS;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SCHEDULE = ABSTRACT_DATUM__SCHEDULE;

	/**
	 * The feature id for the '<em><b>Data Parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__DATA_PARAMETER = ABSTRACT_DATUM__DATA_PARAMETER;

	/**
	 * The number of structural features of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_OPERATION_COUNT = ABSTRACT_DATUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl <em>Data Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getDataParameter()
	 * @generated
	 */
	int DATA_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Is Loop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER__IS_LOOP = 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER__VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Primary Distinct Data</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER__PRIMARY_DISTINCT_DATA = 2;

	/**
	 * The feature id for the '<em><b>Secondary Distinct Data</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER__SECONDARY_DISTINCT_DATA = 3;

	/**
	 * The feature id for the '<em><b>Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER__DATUM = 4;

	/**
	 * The number of structural features of the '<em>Data Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Data Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.DistinctDataImpl <em>Distinct Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.DistinctDataImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getDistinctData()
	 * @generated
	 */
	int DISTINCT_DATA = 4;

	/**
	 * The feature id for the '<em><b>Target</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_DATA__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Primary Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_DATA__PRIMARY_ARGUMENTS = 1;

	/**
	 * The feature id for the '<em><b>Secondary Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_DATA__SECONDARY_ARGUMENTS = 2;

	/**
	 * The number of structural features of the '<em>Distinct Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_DATA_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Distinct Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.InputActionImpl <em>Input Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.InputActionImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getInputAction()
	 * @generated
	 */
	int INPUT_ACTION = 5;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__RESULTS = ABSTRACT_ACTION__RESULTS;

	/**
	 * The feature id for the '<em><b>Distinct Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__DISTINCT_ARGUMENTS = ABSTRACT_ACTION__DISTINCT_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__ORDER = ABSTRACT_ACTION__ORDER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__PARENT = ABSTRACT_ACTION__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__CHILDREN = ABSTRACT_ACTION__CHILDREN;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__ARGUMENTS = ABSTRACT_ACTION__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__SCHEDULE = ABSTRACT_ACTION__SCHEDULE;

	/**
	 * The number of structural features of the '<em>Input Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Input Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION_OPERATION_COUNT = ABSTRACT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.MappingActionImpl <em>Mapping Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.MappingActionImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getMappingAction()
	 * @generated
	 */
	int MAPPING_ACTION = 6;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__RESULTS = ABSTRACT_ACTION__RESULTS;

	/**
	 * The feature id for the '<em><b>Distinct Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__DISTINCT_ARGUMENTS = ABSTRACT_ACTION__DISTINCT_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__ORDER = ABSTRACT_ACTION__ORDER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__PARENT = ABSTRACT_ACTION__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__CHILDREN = ABSTRACT_ACTION__CHILDREN;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__ARGUMENTS = ABSTRACT_ACTION__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__SCHEDULE = ABSTRACT_ACTION__SCHEDULE;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__MAPPING = ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mapping Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION_OPERATION_COUNT = ABSTRACT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.OutputActionImpl <em>Output Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.OutputActionImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getOutputAction()
	 * @generated
	 */
	int OUTPUT_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__RESULTS = ABSTRACT_ACTION__RESULTS;

	/**
	 * The feature id for the '<em><b>Distinct Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__DISTINCT_ARGUMENTS = ABSTRACT_ACTION__DISTINCT_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__ORDER = ABSTRACT_ACTION__ORDER;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__PARENT = ABSTRACT_ACTION__PARENT;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__CHILDREN = ABSTRACT_ACTION__CHILDREN;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__ARGUMENTS = ABSTRACT_ACTION__ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__SCHEDULE = ABSTRACT_ACTION__SCHEDULE;

	/**
	 * The number of structural features of the '<em>Output Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION_FEATURE_COUNT = ABSTRACT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Output Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION_OPERATION_COUNT = ABSTRACT_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl <em>Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getSchedule()
	 * @generated
	 */
	int SCHEDULE = 8;

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum <em>Abstract Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Datum</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum
	 * @generated
	 */
	EClass getAbstractDatum();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSuper()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Super();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getType()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDomain()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Domain();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sources</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSources()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Sources();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getTargets()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Targets();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Schedule</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSchedule()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Schedule();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDataParameter <em>Data Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Data Parameter</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getDataParameter()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_DataParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Action</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction
	 * @generated
	 */
	EClass getAbstractAction();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Results</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getResults()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Results();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getDistinctArguments <em>Distinct Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Distinct Arguments</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getDistinctArguments()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_DistinctArguments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getOrder()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EAttribute getAbstractAction_Order();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParent()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getChildren()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Children();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getArguments()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Arguments();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Schedule</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getSchedule()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Schedule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.ClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.ClassDatum
	 * @generated
	 */
	EClass getClassDatum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter <em>Data Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Parameter</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter
	 * @generated
	 */
	EClass getDataParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#isIsLoop <em>Is Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Loop</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#isIsLoop()
	 * @see #getDataParameter()
	 * @generated
	 */
	EAttribute getDataParameter_IsLoop();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#getVariable()
	 * @see #getDataParameter()
	 * @generated
	 */
	EReference getDataParameter_Variable();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getPrimaryDistinctData <em>Primary Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Primary Distinct Data</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#getPrimaryDistinctData()
	 * @see #getDataParameter()
	 * @generated
	 */
	EReference getDataParameter_PrimaryDistinctData();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getSecondaryDistinctData <em>Secondary Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Secondary Distinct Data</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#getSecondaryDistinctData()
	 * @see #getDataParameter()
	 * @generated
	 */
	EReference getDataParameter_SecondaryDistinctData();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getDatum <em>Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Datum</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#getDatum()
	 * @see #getDataParameter()
	 * @generated
	 */
	EReference getDataParameter_Datum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.DistinctData <em>Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distinct Data</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DistinctData
	 * @generated
	 */
	EClass getDistinctData();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DistinctData#getTarget()
	 * @see #getDistinctData()
	 * @generated
	 */
	EReference getDistinctData_Target();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getPrimaryArguments <em>Primary Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Primary Arguments</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DistinctData#getPrimaryArguments()
	 * @see #getDistinctData()
	 * @generated
	 */
	EReference getDistinctData_PrimaryArguments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.qvtschedule.DistinctData#getSecondaryArguments <em>Secondary Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Secondary Arguments</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DistinctData#getSecondaryArguments()
	 * @see #getDistinctData()
	 * @generated
	 */
	EReference getDistinctData_SecondaryArguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.InputAction <em>Input Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Action</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.InputAction
	 * @generated
	 */
	EClass getInputAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.MappingAction <em>Mapping Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Action</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.MappingAction
	 * @generated
	 */
	EClass getMappingAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.MappingAction#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.MappingAction#getMapping()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_Mapping();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.OutputAction <em>Output Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Action</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.OutputAction
	 * @generated
	 */
	EClass getOutputAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.Schedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.Schedule
	 * @generated
	 */
	EClass getSchedule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.qvtschedule.Schedule#getDatums <em>Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Datums</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.Schedule#getDatums()
	 * @see #getSchedule()
	 * @generated
	 */
	EReference getSchedule_Datums();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.qvtschedule.Schedule#getActions <em>Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actions</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.Schedule#getActions()
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
	qvtscheduleFactory getqvtscheduleFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getAbstractDatum()
		 * @generated
		 */
		EClass ABSTRACT_DATUM = eINSTANCE.getAbstractDatum();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__SUPER = eINSTANCE.getAbstractDatum_Super();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__TYPE = eINSTANCE.getAbstractDatum_Type();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__DOMAIN = eINSTANCE.getAbstractDatum_Domain();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__SOURCES = eINSTANCE.getAbstractDatum_Sources();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__TARGETS = eINSTANCE.getAbstractDatum_Targets();

		/**
		 * The meta object literal for the '<em><b>Schedule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__SCHEDULE = eINSTANCE.getAbstractDatum_Schedule();

		/**
		 * The meta object literal for the '<em><b>Data Parameter</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__DATA_PARAMETER = eINSTANCE.getAbstractDatum_DataParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.AbstractActionImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getAbstractAction()
		 * @generated
		 */
		EClass ABSTRACT_ACTION = eINSTANCE.getAbstractAction();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__RESULTS = eINSTANCE.getAbstractAction_Results();

		/**
		 * The meta object literal for the '<em><b>Distinct Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__DISTINCT_ARGUMENTS = eINSTANCE.getAbstractAction_DistinctArguments();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_ACTION__ORDER = eINSTANCE.getAbstractAction_Order();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__PARENT = eINSTANCE.getAbstractAction_Parent();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__CHILDREN = eINSTANCE.getAbstractAction_Children();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__ARGUMENTS = eINSTANCE.getAbstractAction_Arguments();

		/**
		 * The meta object literal for the '<em><b>Schedule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__SCHEDULE = eINSTANCE.getAbstractAction_Schedule();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.ClassDatumImpl <em>Class Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.ClassDatumImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getClassDatum()
		 * @generated
		 */
		EClass CLASS_DATUM = eINSTANCE.getClassDatum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl <em>Data Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getDataParameter()
		 * @generated
		 */
		EClass DATA_PARAMETER = eINSTANCE.getDataParameter();

		/**
		 * The meta object literal for the '<em><b>Is Loop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_PARAMETER__IS_LOOP = eINSTANCE.getDataParameter_IsLoop();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PARAMETER__VARIABLE = eINSTANCE.getDataParameter_Variable();

		/**
		 * The meta object literal for the '<em><b>Primary Distinct Data</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PARAMETER__PRIMARY_DISTINCT_DATA = eINSTANCE.getDataParameter_PrimaryDistinctData();

		/**
		 * The meta object literal for the '<em><b>Secondary Distinct Data</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PARAMETER__SECONDARY_DISTINCT_DATA = eINSTANCE.getDataParameter_SecondaryDistinctData();

		/**
		 * The meta object literal for the '<em><b>Datum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PARAMETER__DATUM = eINSTANCE.getDataParameter_Datum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.DistinctDataImpl <em>Distinct Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.DistinctDataImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getDistinctData()
		 * @generated
		 */
		EClass DISTINCT_DATA = eINSTANCE.getDistinctData();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTINCT_DATA__TARGET = eINSTANCE.getDistinctData_Target();

		/**
		 * The meta object literal for the '<em><b>Primary Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTINCT_DATA__PRIMARY_ARGUMENTS = eINSTANCE.getDistinctData_PrimaryArguments();

		/**
		 * The meta object literal for the '<em><b>Secondary Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTINCT_DATA__SECONDARY_ARGUMENTS = eINSTANCE.getDistinctData_SecondaryArguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.InputActionImpl <em>Input Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.InputActionImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getInputAction()
		 * @generated
		 */
		EClass INPUT_ACTION = eINSTANCE.getInputAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.MappingActionImpl <em>Mapping Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.MappingActionImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getMappingAction()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.OutputActionImpl <em>Output Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.OutputActionImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getOutputAction()
		 * @generated
		 */
		EClass OUTPUT_ACTION = eINSTANCE.getOutputAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl <em>Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.qvtschedulePackageImpl#getSchedule()
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

} //qvtschedulePackage
