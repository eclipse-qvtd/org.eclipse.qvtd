/**
 */
package org.eclipse.qvtd.doc.miniocl;

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
 * @see org.eclipse.qvtd.doc.miniocl.MiniOCLFactory
 * @model kind="package"
 * @generated
 */
public interface MiniOCLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "miniocl";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvtd/doc/MiniOCL/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "mocl";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MiniOCLPackage eINSTANCE = org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.util.Visitable <em>Visitable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.util.Visitable
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getVisitable()
	 * @generated
	 */
	int VISITABLE = 16;

	/**
	 * The number of structural features of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Visitable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VISITABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.ElementImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = VISITABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_OPERATION_COUNT = VISITABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.NamedElementImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.NamespaceImpl <em>Namespace</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.NamespaceImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getNamespace()
	 * @generated
	 */
	int NAMESPACE = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.TypedElementImpl <em>Typed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.TypedElementImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getTypedElement()
	 * @generated
	 */
	int TYPED_ELEMENT = 17;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT__TYPE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Typed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.OCLExpressionImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOCLExpression()
	 * @generated
	 */
	int OCL_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION__TYPE = TYPED_ELEMENT__TYPE;

	/**
	 * The number of structural features of the '<em>OCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_FEATURE_COUNT = TYPED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>OCL Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OCL_EXPRESSION_OPERATION_COUNT = TYPED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.CallExpImpl <em>Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.CallExpImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getCallExp()
	 * @generated
	 */
	int CALL_EXP = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP__OWNED_SOURCE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALL_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.RootImpl <em>Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.RootImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getRoot()
	 * @generated
	 */
	int ROOT = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PackageImpl <em>Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.PackageImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getPackage()
	 * @generated
	 */
	int PACKAGE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ClassImpl <em>Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.ClassImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getClass_()
	 * @generated
	 */
	int CLASS = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Super Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__SUPER_CLASS = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_OPERATIONS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_PROPERTIES = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS__OWNED_INVARIANTS = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.FeatureImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Namespace</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMESPACE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.PropertyImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OperationImpl <em>Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.OperationImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOperation()
	 * @generated
	 */
	int OPERATION = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.VariableImpl <em>Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.VariableImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getVariable()
	 * @generated
	 */
	int VARIABLE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ParameterImpl <em>Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.ParameterImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getParameter()
	 * @generated
	 */
	int PARAMETER = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.PropertyCallExpImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getPropertyCallExp()
	 * @generated
	 */
	int PROPERTY_CALL_EXP = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.OperationCallExpImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOperationCallExp()
	 * @generated
	 */
	int OPERATION_CALL_EXP = 7;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNED_SOURCE = CALL_EXP__OWNED_SOURCE;

	/**
	 * The feature id for the '<em><b>Owned Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__OWNED_ARGUMENTS = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP__REFERRED_OPERATION = CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Operation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_EXP_OPERATION_COUNT = CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__TYPE = FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_PARAMETERS = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNING_CLASS = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION__OWNED_BODY_EXPRESSION = FEATURE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_OPERATION_COUNT = FEATURE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Classes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_CLASSES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE__OWNED_PACKAGES = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PACKAGE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE__TYPE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__NAME = VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER__TYPE = VARIABLE__TYPE;

	/**
	 * The number of structural features of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_FEATURE_COUNT = VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_OPERATION_COUNT = VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__NAME = FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__TYPE = FEATURE__TYPE;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__OWNING_CLASS = FEATURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = FEATURE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_OPERATION_COUNT = FEATURE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__TYPE = CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__OWNED_SOURCE = CALL_EXP__OWNED_SOURCE;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP__REFERRED_PROPERTY = CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP_FEATURE_COUNT = CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Property Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_CALL_EXP_OPERATION_COUNT = CALL_EXP_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT__OWNED_PACKAGES = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.VariableExpImpl <em>Variable Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.VariableExpImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getVariableExp()
	 * @generated
	 */
	int VARIABLE_EXP = 15;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__TYPE = OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP__REFERRED_VARIABLE = OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_FEATURE_COUNT = OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_EXP_OPERATION_COUNT = OCL_EXPRESSION_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getExpressionInOCL()
	 * @generated
	 */
	int EXPRESSION_IN_OCL = 18;

	/**
	 * The feature id for the '<em><b>Owned Self Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNED_SELF_VAR = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL__OWNED_BODY = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Expression In OCL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Expression In OCL</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_IN_OCL_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.doc.miniocl.impl.ConstraintImpl
	 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__OWNED_SPECIFICATION = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_OPERATION_COUNT = NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.doc.miniocl.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Namespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Namespace</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Namespace
	 * @generated
	 */
	EClass getNamespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.TypedElement
	 * @generated
	 */
	EClass getTypedElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.TypedElement#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.TypedElement#getType()
	 * @see #getTypedElement()
	 * @generated
	 */
	EReference getTypedElement_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL <em>Expression In OCL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression In OCL</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.ExpressionInOCL
	 * @generated
	 */
	EClass getExpressionInOCL();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedSelfVar <em>Owned Self Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Self Var</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedSelfVar()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_OwnedSelfVar();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.ExpressionInOCL#getOwnedBody()
	 * @see #getExpressionInOCL()
	 * @generated
	 */
	EReference getExpressionInOCL_OwnedBody();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.Constraint#getOwnedSpecification <em>Owned Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owned Specification</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Constraint#getOwnedSpecification()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_OwnedSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.OCLExpression <em>OCL Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>OCL Expression</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OCLExpression
	 * @generated
	 */
	EClass getOCLExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.CallExp <em>Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Call Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CallExp
	 * @generated
	 */
	EClass getCallExp();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.CallExp#getOwnedSource <em>Owned Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Source</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.CallExp#getOwnedSource()
	 * @see #getCallExp()
	 * @generated
	 */
	EReference getCallExp_OwnedSource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Root
	 * @generated
	 */
	EClass getRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Root#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Root#getOwnedPackages()
	 * @see #getRoot()
	 * @generated
	 */
	EReference getRoot_OwnedPackages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Package <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Package</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Package
	 * @generated
	 */
	EClass getPackage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Package#getOwnedClasses <em>Owned Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Classes</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Package#getOwnedClasses()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedClasses();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Package#getOwnedPackages <em>Owned Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Packages</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Package#getOwnedPackages()
	 * @see #getPackage()
	 * @generated
	 */
	EReference getPackage_OwnedPackages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Class <em>Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Class
	 * @generated
	 */
	EClass getClass_();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.Class#getSuperClass <em>Super Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Class</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Class#getSuperClass()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_SuperClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Class#getOwnedOperations <em>Owned Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operations</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Class#getOwnedOperations()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedOperations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Class#getOwnedProperties <em>Owned Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Properties</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Class#getOwnedProperties()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedProperties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Class#getOwnedInvariants <em>Owned Invariants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Invariants</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Class#getOwnedInvariants()
	 * @see #getClass_()
	 * @generated
	 */
	EReference getClass_OwnedInvariants();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.Property#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owning Class</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Property#getOwningClass()
	 * @see #getProperty()
	 * @generated
	 */
	EReference getProperty_OwningClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Operation
	 * @generated
	 */
	EClass getOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Operation#getOwnedParameters()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedParameters();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwningClass <em>Owning Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Operation#getOwningClass()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwningClass();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.doc.miniocl.Operation#getOwnedBodyExpression <em>Owned Body Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body Expression</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Operation#getOwnedBodyExpression()
	 * @see #getOperation()
	 * @generated
	 */
	EReference getOperation_OwnedBodyExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Parameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Parameter
	 * @generated
	 */
	EClass getParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.PropertyCallExp <em>Property Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Call Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.PropertyCallExp
	 * @generated
	 */
	EClass getPropertyCallExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.PropertyCallExp#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.PropertyCallExp#getReferredProperty()
	 * @see #getPropertyCallExp()
	 * @generated
	 */
	EReference getPropertyCallExp_ReferredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.OperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OperationCallExp
	 * @generated
	 */
	EClass getOperationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.doc.miniocl.OperationCallExp#getOwnedArguments <em>Owned Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Arguments</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OperationCallExp#getOwnedArguments()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_OwnedArguments();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.OperationCallExp#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.OperationCallExp#getReferredOperation()
	 * @see #getOperationCallExp()
	 * @generated
	 */
	EReference getOperationCallExp_ReferredOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.Variable
	 * @generated
	 */
	EClass getVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.VariableExp <em>Variable Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Exp</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.VariableExp
	 * @generated
	 */
	EClass getVariableExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.doc.miniocl.VariableExp#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.VariableExp#getReferredVariable()
	 * @see #getVariableExp()
	 * @generated
	 */
	EReference getVariableExp_ReferredVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.doc.miniocl.util.Visitable <em>Visitable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Visitable</em>'.
	 * @see org.eclipse.qvtd.doc.miniocl.util.Visitable
	 * @model instanceClass="org.eclipse.qvtd.doc.miniocl.util.Visitable"
	 * @generated
	 */
	EClass getVisitable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MiniOCLFactory getMiniOCLFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ElementImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.FeatureImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.NamedElementImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.NamespaceImpl <em>Namespace</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.NamespaceImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getNamespace()
		 * @generated
		 */
		EClass NAMESPACE = eINSTANCE.getNamespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.TypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.TypedElementImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getTypedElement()
		 * @generated
		 */
		EClass TYPED_ELEMENT = eINSTANCE.getTypedElement();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_ELEMENT__TYPE = eINSTANCE.getTypedElement_Type();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl <em>Expression In OCL</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ExpressionInOCLImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getExpressionInOCL()
		 * @generated
		 */
		EClass EXPRESSION_IN_OCL = eINSTANCE.getExpressionInOCL();

		/**
		 * The meta object literal for the '<em><b>Owned Self Var</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__OWNED_SELF_VAR = eINSTANCE.getExpressionInOCL_OwnedSelfVar();

		/**
		 * The meta object literal for the '<em><b>Owned Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_IN_OCL__OWNED_BODY = eINSTANCE.getExpressionInOCL_OwnedBody();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ConstraintImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Owned Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__OWNED_SPECIFICATION = eINSTANCE.getConstraint_OwnedSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OCLExpressionImpl <em>OCL Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.OCLExpressionImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOCLExpression()
		 * @generated
		 */
		EClass OCL_EXPRESSION = eINSTANCE.getOCLExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.CallExpImpl <em>Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.CallExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getCallExp()
		 * @generated
		 */
		EClass CALL_EXP = eINSTANCE.getCallExp();

		/**
		 * The meta object literal for the '<em><b>Owned Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CALL_EXP__OWNED_SOURCE = eINSTANCE.getCallExp_OwnedSource();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.RootImpl <em>Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.RootImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getRoot()
		 * @generated
		 */
		EClass ROOT = eINSTANCE.getRoot();

		/**
		 * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROOT__OWNED_PACKAGES = eINSTANCE.getRoot_OwnedPackages();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PackageImpl <em>Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.PackageImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getPackage()
		 * @generated
		 */
		EClass PACKAGE = eINSTANCE.getPackage();

		/**
		 * The meta object literal for the '<em><b>Owned Classes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_CLASSES = eINSTANCE.getPackage_OwnedClasses();

		/**
		 * The meta object literal for the '<em><b>Owned Packages</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PACKAGE__OWNED_PACKAGES = eINSTANCE.getPackage_OwnedPackages();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ClassImpl <em>Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ClassImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getClass_()
		 * @generated
		 */
		EClass CLASS = eINSTANCE.getClass_();

		/**
		 * The meta object literal for the '<em><b>Super Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__SUPER_CLASS = eINSTANCE.getClass_SuperClass();

		/**
		 * The meta object literal for the '<em><b>Owned Operations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_OPERATIONS = eINSTANCE.getClass_OwnedOperations();

		/**
		 * The meta object literal for the '<em><b>Owned Properties</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_PROPERTIES = eINSTANCE.getClass_OwnedProperties();

		/**
		 * The meta object literal for the '<em><b>Owned Invariants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS__OWNED_INVARIANTS = eINSTANCE.getClass_OwnedInvariants();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.PropertyImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY__OWNING_CLASS = eINSTANCE.getProperty_OwningClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OperationImpl <em>Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.OperationImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOperation()
		 * @generated
		 */
		EClass OPERATION = eINSTANCE.getOperation();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNED_PARAMETERS = eINSTANCE.getOperation_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owning Class</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNING_CLASS = eINSTANCE.getOperation_OwningClass();

		/**
		 * The meta object literal for the '<em><b>Owned Body Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION__OWNED_BODY_EXPRESSION = eINSTANCE.getOperation_OwnedBodyExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.ParameterImpl <em>Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.ParameterImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getParameter()
		 * @generated
		 */
		EClass PARAMETER = eINSTANCE.getParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.PropertyCallExpImpl <em>Property Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.PropertyCallExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getPropertyCallExp()
		 * @generated
		 */
		EClass PROPERTY_CALL_EXP = eINSTANCE.getPropertyCallExp();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_CALL_EXP__REFERRED_PROPERTY = eINSTANCE.getPropertyCallExp_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.OperationCallExpImpl <em>Operation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.OperationCallExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getOperationCallExp()
		 * @generated
		 */
		EClass OPERATION_CALL_EXP = eINSTANCE.getOperationCallExp();

		/**
		 * The meta object literal for the '<em><b>Owned Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__OWNED_ARGUMENTS = eINSTANCE.getOperationCallExp_OwnedArguments();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_EXP__REFERRED_OPERATION = eINSTANCE.getOperationCallExp_ReferredOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.VariableImpl <em>Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.VariableImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getVariable()
		 * @generated
		 */
		EClass VARIABLE = eINSTANCE.getVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.impl.VariableExpImpl <em>Variable Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.impl.VariableExpImpl
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getVariableExp()
		 * @generated
		 */
		EClass VARIABLE_EXP = eINSTANCE.getVariableExp();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_EXP__REFERRED_VARIABLE = eINSTANCE.getVariableExp_ReferredVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.doc.miniocl.util.Visitable <em>Visitable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.doc.miniocl.util.Visitable
		 * @see org.eclipse.qvtd.doc.miniocl.impl.MiniOCLPackageImpl#getVisitable()
		 * @generated
		 */
		EClass VISITABLE = eINSTANCE.getVisitable();

	}

} //MiniOCLPackage
