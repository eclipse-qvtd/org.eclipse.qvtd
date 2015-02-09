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
 * @see org.eclipse.qvtd.build.qvtschedule.QVTscheduleFactory
 * @model kind="package"
 * @generated
 */
public interface QVTschedulePackage extends EPackage {
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
	String eNS_URI = "http://www.eclipse.org/qvt/0.2/QVTschedule/";

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
	QVTschedulePackage eINSTANCE = org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.AbstractDatumImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getAbstractDatum()
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
	 * The feature id for the '<em><b>Sub</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__SUB = 1;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__DOMAIN = 2;

	/**
	 * The feature id for the '<em><b>Produced By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__PRODUCED_BY = 3;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__REQUIRED_BY = 4;

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
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getAbstractAction()
	 * @generated
	 */
	int ABSTRACT_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Productions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__PRODUCTIONS = 0;

	/**
	 * The feature id for the '<em><b>Requisites</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__REQUISITES = 1;

	/**
	 * The feature id for the '<em><b>Parameter Derivations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__PARAMETER_DERIVATIONS = 2;

	/**
	 * The feature id for the '<em><b>Order</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__ORDER = 3;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__PARENT = 4;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__CHILDREN = 5;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__PARAMETERS = 6;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__RESULTS = 7;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION__SCHEDULE = 8;

	/**
	 * The number of structural features of the '<em>Abstract Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_ACTION_FEATURE_COUNT = 9;

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
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getClassDatum()
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
	 * The feature id for the '<em><b>Sub</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SUB = ABSTRACT_DATUM__SUB;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__DOMAIN = ABSTRACT_DATUM__DOMAIN;

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
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__TYPE = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Datums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__PROPERTY_DATUMS = ABSTRACT_DATUM_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl <em>Data Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getDataParameter()
	 * @generated
	 */
	int DATA_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER__VARIABLE = 0;

	/**
	 * The feature id for the '<em><b>Secondary Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER__SECONDARY_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER__DATUM = 2;

	/**
	 * The number of structural features of the '<em>Data Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Data Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_PARAMETER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.InputActionImpl <em>Input Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.InputActionImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getInputAction()
	 * @generated
	 */
	int INPUT_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Productions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__PRODUCTIONS = ABSTRACT_ACTION__PRODUCTIONS;

	/**
	 * The feature id for the '<em><b>Requisites</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__REQUISITES = ABSTRACT_ACTION__REQUISITES;

	/**
	 * The feature id for the '<em><b>Parameter Derivations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__PARAMETER_DERIVATIONS = ABSTRACT_ACTION__PARAMETER_DERIVATIONS;

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
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__PARAMETERS = ABSTRACT_ACTION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_ACTION__RESULTS = ABSTRACT_ACTION__RESULTS;

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
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getMappingAction()
	 * @generated
	 */
	int MAPPING_ACTION = 5;

	/**
	 * The feature id for the '<em><b>Productions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__PRODUCTIONS = ABSTRACT_ACTION__PRODUCTIONS;

	/**
	 * The feature id for the '<em><b>Requisites</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__REQUISITES = ABSTRACT_ACTION__REQUISITES;

	/**
	 * The feature id for the '<em><b>Parameter Derivations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__PARAMETER_DERIVATIONS = ABSTRACT_ACTION__PARAMETER_DERIVATIONS;

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
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__PARAMETERS = ABSTRACT_ACTION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__RESULTS = ABSTRACT_ACTION__RESULTS;

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
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getOutputAction()
	 * @generated
	 */
	int OUTPUT_ACTION = 6;

	/**
	 * The feature id for the '<em><b>Productions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__PRODUCTIONS = ABSTRACT_ACTION__PRODUCTIONS;

	/**
	 * The feature id for the '<em><b>Requisites</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__REQUISITES = ABSTRACT_ACTION__REQUISITES;

	/**
	 * The feature id for the '<em><b>Parameter Derivations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__PARAMETER_DERIVATIONS = ABSTRACT_ACTION__PARAMETER_DERIVATIONS;

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
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__PARAMETERS = ABSTRACT_ACTION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_ACTION__RESULTS = ABSTRACT_ACTION__RESULTS;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.ParameterDerivationImpl <em>Parameter Derivation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.ParameterDerivationImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getParameterDerivation()
	 * @generated
	 */
	int PARAMETER_DERIVATION = 7;

	/**
	 * The feature id for the '<em><b>Target</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DERIVATION__TARGET = 0;

	/**
	 * The feature id for the '<em><b>Primary Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DERIVATION__PRIMARY_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Secondary Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DERIVATION__SECONDARY_PARAMETER = 2;

	/**
	 * The number of structural features of the '<em>Parameter Derivation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DERIVATION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Parameter Derivation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DERIVATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.PropertyDatumImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getPropertyDatum()
	 * @generated
	 */
	int PROPERTY_DATUM = 8;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__SUPER = ABSTRACT_DATUM__SUPER;

	/**
	 * The feature id for the '<em><b>Sub</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__SUB = ABSTRACT_DATUM__SUB;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__DOMAIN = ABSTRACT_DATUM__DOMAIN;

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
	 * The feature id for the '<em><b>Schedule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__SCHEDULE = ABSTRACT_DATUM__SCHEDULE;

	/**
	 * The feature id for the '<em><b>Data Parameter</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__DATA_PARAMETER = ABSTRACT_DATUM__DATA_PARAMETER;

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
	 * The number of structural features of the '<em>Property Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Property Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM_OPERATION_COUNT = ABSTRACT_DATUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl <em>Schedule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getSchedule()
	 * @generated
	 */
	int SCHEDULE = 9;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.SecondaryParameterImpl <em>Secondary Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.SecondaryParameterImpl
	 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getSecondaryParameter()
	 * @generated
	 */
	int SECONDARY_PARAMETER = 10;

	/**
	 * The feature id for the '<em><b>Is Loop</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_PARAMETER__IS_LOOP = 0;

	/**
	 * The feature id for the '<em><b>Data Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_PARAMETER__DATA_PARAMETER = 1;

	/**
	 * The feature id for the '<em><b>Derivation Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_PARAMETER__DERIVATION_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Derivation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_PARAMETER__DERIVATION = 3;

	/**
	 * The number of structural features of the '<em>Secondary Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_PARAMETER_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Secondary Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_PARAMETER_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSub <em>Sub</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getSub()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_Sub();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getProducedBy <em>Produced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Produced By</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getProducedBy()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_ProducedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required By</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractDatum#getRequiredBy()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_RequiredBy();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getProductions <em>Productions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Productions</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getProductions()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Productions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getRequisites <em>Requisites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requisites</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getRequisites()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Requisites();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParameterDerivations <em>Parameter Derivations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Derivations</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParameterDerivations()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_ParameterDerivations();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getParameters()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Parameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.qvtschedule.AbstractAction#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.AbstractAction#getResults()
	 * @see #getAbstractAction()
	 * @generated
	 */
	EReference getAbstractAction_Results();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.ClassDatum#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.ClassDatum#getType()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.build.qvtschedule.ClassDatum#getPropertyDatums <em>Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Datums</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.ClassDatum#getPropertyDatums()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_PropertyDatums();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.DataParameter#getSecondaryParameter <em>Secondary Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Secondary Parameter</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.DataParameter#getSecondaryParameter()
	 * @see #getDataParameter()
	 * @generated
	 */
	EReference getDataParameter_SecondaryParameter();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation <em>Parameter Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Derivation</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.ParameterDerivation
	 * @generated
	 */
	EClass getParameterDerivation();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getTarget()
	 * @see #getParameterDerivation()
	 * @generated
	 */
	EReference getParameterDerivation_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getPrimaryParameter <em>Primary Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Parameter</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getPrimaryParameter()
	 * @see #getParameterDerivation()
	 * @generated
	 */
	EReference getParameterDerivation_PrimaryParameter();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getSecondaryParameter <em>Secondary Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Secondary Parameter</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.ParameterDerivation#getSecondaryParameter()
	 * @see #getParameterDerivation()
	 * @generated
	 */
	EReference getParameterDerivation_SecondaryParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum <em>Property Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Datum</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.PropertyDatum
	 * @generated
	 */
	EClass getPropertyDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getProperty()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_Property();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getClassDatum()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_ClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.PropertyDatum#getOpposite()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_Opposite();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.build.qvtschedule.SecondaryParameter <em>Secondary Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Secondary Parameter</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.SecondaryParameter
	 * @generated
	 */
	EClass getSecondaryParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#isIsLoop <em>Is Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Loop</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#isIsLoop()
	 * @see #getSecondaryParameter()
	 * @generated
	 */
	EAttribute getSecondaryParameter_IsLoop();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#getDataParameter <em>Data Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Data Parameter</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#getDataParameter()
	 * @see #getSecondaryParameter()
	 * @generated
	 */
	EReference getSecondaryParameter_DataParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#getDerivationProperty <em>Derivation Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Derivation Property</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#getDerivationProperty()
	 * @see #getSecondaryParameter()
	 * @generated
	 */
	EReference getSecondaryParameter_DerivationProperty();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#getDerivation <em>Derivation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Derivation</em>'.
	 * @see org.eclipse.qvtd.build.qvtschedule.SecondaryParameter#getDerivation()
	 * @see #getSecondaryParameter()
	 * @generated
	 */
	EReference getSecondaryParameter_Derivation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTscheduleFactory getQVTscheduleFactory();

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
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getAbstractDatum()
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
		 * The meta object literal for the '<em><b>Sub</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__SUB = eINSTANCE.getAbstractDatum_Sub();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__DOMAIN = eINSTANCE.getAbstractDatum_Domain();

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
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getAbstractAction()
		 * @generated
		 */
		EClass ABSTRACT_ACTION = eINSTANCE.getAbstractAction();

		/**
		 * The meta object literal for the '<em><b>Productions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__PRODUCTIONS = eINSTANCE.getAbstractAction_Productions();

		/**
		 * The meta object literal for the '<em><b>Requisites</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__REQUISITES = eINSTANCE.getAbstractAction_Requisites();

		/**
		 * The meta object literal for the '<em><b>Parameter Derivations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__PARAMETER_DERIVATIONS = eINSTANCE.getAbstractAction_ParameterDerivations();

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
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__PARAMETERS = eINSTANCE.getAbstractAction_Parameters();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_ACTION__RESULTS = eINSTANCE.getAbstractAction_Results();

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
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getClassDatum()
		 * @generated
		 */
		EClass CLASS_DATUM = eINSTANCE.getClassDatum();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__TYPE = eINSTANCE.getClassDatum_Type();

		/**
		 * The meta object literal for the '<em><b>Property Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__PROPERTY_DATUMS = eINSTANCE.getClassDatum_PropertyDatums();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl <em>Data Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.DataParameterImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getDataParameter()
		 * @generated
		 */
		EClass DATA_PARAMETER = eINSTANCE.getDataParameter();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PARAMETER__VARIABLE = eINSTANCE.getDataParameter_Variable();

		/**
		 * The meta object literal for the '<em><b>Secondary Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PARAMETER__SECONDARY_PARAMETER = eINSTANCE.getDataParameter_SecondaryParameter();

		/**
		 * The meta object literal for the '<em><b>Datum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_PARAMETER__DATUM = eINSTANCE.getDataParameter_Datum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.InputActionImpl <em>Input Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.InputActionImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getInputAction()
		 * @generated
		 */
		EClass INPUT_ACTION = eINSTANCE.getInputAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.MappingActionImpl <em>Mapping Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.MappingActionImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getMappingAction()
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
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getOutputAction()
		 * @generated
		 */
		EClass OUTPUT_ACTION = eINSTANCE.getOutputAction();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.ParameterDerivationImpl <em>Parameter Derivation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.ParameterDerivationImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getParameterDerivation()
		 * @generated
		 */
		EClass PARAMETER_DERIVATION = eINSTANCE.getParameterDerivation();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DERIVATION__TARGET = eINSTANCE.getParameterDerivation_Target();

		/**
		 * The meta object literal for the '<em><b>Primary Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DERIVATION__PRIMARY_PARAMETER = eINSTANCE.getParameterDerivation_PrimaryParameter();

		/**
		 * The meta object literal for the '<em><b>Secondary Parameter</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_DERIVATION__SECONDARY_PARAMETER = eINSTANCE.getParameterDerivation_SecondaryParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.PropertyDatumImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getPropertyDatum()
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
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl <em>Schedule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.ScheduleImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getSchedule()
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

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.build.qvtschedule.impl.SecondaryParameterImpl <em>Secondary Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.SecondaryParameterImpl
		 * @see org.eclipse.qvtd.build.qvtschedule.impl.QVTschedulePackageImpl#getSecondaryParameter()
		 * @generated
		 */
		EClass SECONDARY_PARAMETER = eINSTANCE.getSecondaryParameter();

		/**
		 * The meta object literal for the '<em><b>Is Loop</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SECONDARY_PARAMETER__IS_LOOP = eINSTANCE.getSecondaryParameter_IsLoop();

		/**
		 * The meta object literal for the '<em><b>Data Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECONDARY_PARAMETER__DATA_PARAMETER = eINSTANCE.getSecondaryParameter_DataParameter();

		/**
		 * The meta object literal for the '<em><b>Derivation Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECONDARY_PARAMETER__DERIVATION_PROPERTY = eINSTANCE.getSecondaryParameter_DerivationProperty();

		/**
		 * The meta object literal for the '<em><b>Derivation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECONDARY_PARAMETER__DERIVATION = eINSTANCE.getSecondaryParameter_Derivation();

	}

} //QVTschedulePackage
