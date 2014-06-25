/**
 */
package org.eclipse.qvtd.build.etl.qvtscheduling;

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
 * @see org.eclipse.qvtd.build.etl.qvtscheduling.QvtSchedulingFactory
 * @model kind="package"
 * @generated
 */
public interface QvtSchedulingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtscheduling";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/0.1/QVTscheduling/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtscheduling";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QvtSchedulingPackage eINSTANCE = org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getAbstractDatum()
	 * @generated
	 */
	int ABSTRACT_DATUM = 0;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__SOURCES = 0;

	/**
	 * The feature id for the '<em><b>Primary Distinct Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA = 1;

	/**
	 * The feature id for the '<em><b>Secondary Distinct Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA = 2;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__PARENT = 3;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__SUPER = 4;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__TYPE = 5;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__DOMAIN = 6;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__TARGETS = 7;

	/**
	 * The number of structural features of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getAbstractAction()
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
	 * The feature id for the '<em><b>Distinct Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__DISTINCT_ARGUMENTS = 1;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__COUNT = 2;

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
	 * The number of structural features of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.ClassDatumImpl <em>Class Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.ClassDatumImpl
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getClassDatum()
	 * @generated
	 */
	int CLASS_DATUM = 2;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SOURCES = ABSTRACT_DATUM__SOURCES;

	/**
	 * The feature id for the '<em><b>Primary Distinct Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__PRIMARY_DISTINCT_DATA = ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA;

	/**
	 * The feature id for the '<em><b>Secondary Distinct Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SECONDARY_DISTINCT_DATA = ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__PARENT = ABSTRACT_DATUM__PARENT;

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
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__TARGETS = ABSTRACT_DATUM__TARGETS;

	/**
	 * The feature id for the '<em><b>Realized Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__REALIZED_VARIABLES = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__VARIABLES = ABSTRACT_DATUM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_OPERATION_COUNT = ABSTRACT_DATUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.DataTypeDatumImpl <em>Data Type Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.DataTypeDatumImpl
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getDataTypeDatum()
	 * @generated
	 */
	int DATA_TYPE_DATUM = 3;

	/**
	 * The feature id for the '<em><b>Sources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM__SOURCES = ABSTRACT_DATUM__SOURCES;

	/**
	 * The feature id for the '<em><b>Primary Distinct Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM__PRIMARY_DISTINCT_DATA = ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA;

	/**
	 * The feature id for the '<em><b>Secondary Distinct Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM__SECONDARY_DISTINCT_DATA = ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM__PARENT = ABSTRACT_DATUM__PARENT;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM__SUPER = ABSTRACT_DATUM__SUPER;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM__TYPE = ABSTRACT_DATUM__TYPE;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM__DOMAIN = ABSTRACT_DATUM__DOMAIN;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM__TARGETS = ABSTRACT_DATUM__TARGETS;

	/**
	 * The number of structural features of the '<em>Data Type Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Data Type Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DATUM_OPERATION_COUNT = ABSTRACT_DATUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.DistinctDataImpl <em>Distinct Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.DistinctDataImpl
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getDistinctData()
	 * @generated
	 */
	int DISTINCT_DATA = 4;

	/**
	 * The feature id for the '<em><b>Targets</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_DATA__TARGETS = 0;

	/**
	 * The feature id for the '<em><b>Primary Argument</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_DATA__PRIMARY_ARGUMENT = 1;

	/**
	 * The feature id for the '<em><b>Secondary Argument</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISTINCT_DATA__SECONDARY_ARGUMENT = 2;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.InputActionImpl <em>Input Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.InputActionImpl
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getInputAction()
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
	 * The feature id for the '<em><b>Distinct Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__DISTINCT_ARGUMENTS = ABSTRACT_ACTION__DISTINCT_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__COUNT = ABSTRACT_ACTION__COUNT;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingActionImpl <em>Mapping Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingActionImpl
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getMappingAction()
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
	 * The feature id for the '<em><b>Distinct Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__DISTINCT_ARGUMENTS = ABSTRACT_ACTION__DISTINCT_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__COUNT = ABSTRACT_ACTION__COUNT;

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
	 * The feature id for the '<em><b>Mapping Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__MAPPING_BINDINGS = ABSTRACT_ACTION_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingBindingImpl <em>Mapping Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingBindingImpl
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getMappingBinding()
	 * @generated
	 */
	int MAPPING_BINDING = 7;

	/**
	 * The feature id for the '<em><b>Mapping Action</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BINDING__MAPPING_ACTION = 0;

	/**
	 * The feature id for the '<em><b>Loop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BINDING__LOOP = 1;

	/**
	 * The feature id for the '<em><b>Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BINDING__DATUM = 2;

	/**
	 * The number of structural features of the '<em>Mapping Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BINDING_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Mapping Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_BINDING_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.OutputActionImpl <em>Output Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.OutputActionImpl
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getOutputAction()
	 * @generated
	 */
	int OUTPUT_ACTION = 8;

	/**
	 * The feature id for the '<em><b>Results</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__RESULTS = ABSTRACT_ACTION__RESULTS;

	/**
	 * The feature id for the '<em><b>Distinct Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__DISTINCT_ARGUMENTS = ABSTRACT_ACTION__DISTINCT_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__COUNT = ABSTRACT_ACTION__COUNT;

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum <em>Abstract Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Datum</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum
	 * @generated
	 */
	EClass getAbstractDatum();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSources <em>Sources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sources</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSources()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Sources();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getPrimaryDistinctData <em>Primary Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Distinct Data</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getPrimaryDistinctData()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_PrimaryDistinctData();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSecondaryDistinctData <em>Secondary Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Secondary Distinct Data</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSecondaryDistinctData()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_SecondaryDistinctData();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getParent()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getSuper()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Super();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getType()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Domain</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getDomain()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Domain();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractDatum#getTargets()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Targets();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Action</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction
	 * @generated
	 */
	EClass getAbstractAction();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Results</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getResults()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Results();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getDistinctArguments <em>Distinct Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Distinct Arguments</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getDistinctArguments()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_DistinctArguments();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getCount <em>Count</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Count</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getCount()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EAttribute getAbstractAction_Count();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parent</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getParent()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Parent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getChildren()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Children();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.AbstractAction#getArguments()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum
	 * @generated
	 */
	EClass getClassDatum();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum#getRealizedVariables <em>Realized Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized Variables</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum#getRealizedVariables()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_RealizedVariables();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variables</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.ClassDatum#getVariables()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_Variables();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DataTypeDatum <em>Data Type Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Datum</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DataTypeDatum
	 * @generated
	 */
	EClass getDataTypeDatum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData <em>Distinct Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Distinct Data</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData
	 * @generated
	 */
	EClass getDistinctData();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getTargets <em>Targets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Targets</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getTargets()
	 * @see #getDistinctData()
	 * @generated
	 */
	EReference getDistinctData_Targets();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getPrimaryArgument <em>Primary Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Primary Argument</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getPrimaryArgument()
	 * @see #getDistinctData()
	 * @generated
	 */
	EReference getDistinctData_PrimaryArgument();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getSecondaryArgument <em>Secondary Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Secondary Argument</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.DistinctData#getSecondaryArgument()
	 * @see #getDistinctData()
	 * @generated
	 */
	EReference getDistinctData_SecondaryArgument();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.InputAction <em>Input Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Action</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.InputAction
	 * @generated
	 */
	EClass getInputAction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction <em>Mapping Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Action</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction
	 * @generated
	 */
	EClass getMappingAction();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction#getMappingBindings <em>Mapping Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Bindings</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingAction#getMappingBindings()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_MappingBindings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding <em>Mapping Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Binding</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding
	 * @generated
	 */
	EClass getMappingBinding();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getMappingAction <em>Mapping Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Action</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getMappingAction()
	 * @see #getMappingBinding()
	 * @generated
	 */
	EReference getMappingBinding_MappingAction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#isLoop <em>Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loop</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#isLoop()
	 * @see #getMappingBinding()
	 * @generated
	 */
	EAttribute getMappingBinding_Loop();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getDatum <em>Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Datum</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.MappingBinding#getDatum()
	 * @see #getMappingBinding()
	 * @generated
	 */
	EReference getMappingBinding_Datum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.etl.qvtscheduling.OutputAction <em>Output Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Action</em>'.
	 * @see org.eclipse.qvtd.build.etl.qvtscheduling.OutputAction
	 * @generated
	 */
	EClass getOutputAction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QvtSchedulingFactory getQvtSchedulingFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractDatumImpl
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getAbstractDatum()
		 * @generated
		 */
		EClass ABSTRACT_DATUM = eINSTANCE.getAbstractDatum();

		/**
		 * The meta object literal for the '<em><b>Sources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__SOURCES = eINSTANCE.getAbstractDatum_Sources();

		/**
		 * The meta object literal for the '<em><b>Primary Distinct Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__PRIMARY_DISTINCT_DATA = eINSTANCE.getAbstractDatum_PrimaryDistinctData();

		/**
		 * The meta object literal for the '<em><b>Secondary Distinct Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__SECONDARY_DISTINCT_DATA = eINSTANCE.getAbstractDatum_SecondaryDistinctData();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__PARENT = eINSTANCE.getAbstractDatum_Parent();

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
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__TARGETS = eINSTANCE.getAbstractDatum_Targets();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl <em>Abstract Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.AbstractActionImpl
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getAbstractAction()
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
		 * The meta object literal for the '<em><b>Distinct Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__DISTINCT_ARGUMENTS = eINSTANCE.getAbstractAction_DistinctArguments();

		/**
		 * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ABSTRACT_ACTION__COUNT = eINSTANCE.getAbstractAction_Count();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.ClassDatumImpl <em>Class Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.ClassDatumImpl
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getClassDatum()
		 * @generated
		 */
		EClass CLASS_DATUM = eINSTANCE.getClassDatum();

		/**
		 * The meta object literal for the '<em><b>Realized Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__REALIZED_VARIABLES = eINSTANCE.getClassDatum_RealizedVariables();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__VARIABLES = eINSTANCE.getClassDatum_Variables();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.DataTypeDatumImpl <em>Data Type Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.DataTypeDatumImpl
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getDataTypeDatum()
		 * @generated
		 */
		EClass DATA_TYPE_DATUM = eINSTANCE.getDataTypeDatum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.DistinctDataImpl <em>Distinct Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.DistinctDataImpl
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getDistinctData()
		 * @generated
		 */
		EClass DISTINCT_DATA = eINSTANCE.getDistinctData();

		/**
		 * The meta object literal for the '<em><b>Targets</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTINCT_DATA__TARGETS = eINSTANCE.getDistinctData_Targets();

		/**
		 * The meta object literal for the '<em><b>Primary Argument</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTINCT_DATA__PRIMARY_ARGUMENT = eINSTANCE.getDistinctData_PrimaryArgument();

		/**
		 * The meta object literal for the '<em><b>Secondary Argument</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISTINCT_DATA__SECONDARY_ARGUMENT = eINSTANCE.getDistinctData_SecondaryArgument();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.InputActionImpl <em>Input Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.InputActionImpl
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getInputAction()
		 * @generated
		 */
		EClass INPUT_ACTION = eINSTANCE.getInputAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingActionImpl <em>Mapping Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingActionImpl
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getMappingAction()
		 * @generated
		 */
		EClass MAPPING_ACTION = eINSTANCE.getMappingAction();

		/**
		 * The meta object literal for the '<em><b>Mapping Bindings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__MAPPING_BINDINGS = eINSTANCE.getMappingAction_MappingBindings();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingBindingImpl <em>Mapping Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.MappingBindingImpl
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getMappingBinding()
		 * @generated
		 */
		EClass MAPPING_BINDING = eINSTANCE.getMappingBinding();

		/**
		 * The meta object literal for the '<em><b>Mapping Action</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_BINDING__MAPPING_ACTION = eINSTANCE.getMappingBinding_MappingAction();

		/**
		 * The meta object literal for the '<em><b>Loop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_BINDING__LOOP = eINSTANCE.getMappingBinding_Loop();

		/**
		 * The meta object literal for the '<em><b>Datum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_BINDING__DATUM = eINSTANCE.getMappingBinding_Datum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.etl.qvtscheduling.impl.OutputActionImpl <em>Output Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.OutputActionImpl
		 * @see org.eclipse.qvtd.build.etl.qvtscheduling.impl.QvtSchedulingPackageImpl#getOutputAction()
		 * @generated
		 */
		EClass OUTPUT_ACTION = eINSTANCE.getOutputAction();

	}

} //QvtSchedulingPackage
