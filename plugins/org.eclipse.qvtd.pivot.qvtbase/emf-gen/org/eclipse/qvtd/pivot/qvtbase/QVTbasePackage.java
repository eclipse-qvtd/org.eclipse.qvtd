/*******************************************************************************
 * Copyright (c) 2011, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtbase;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.ocl.pivot.PivotPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtbase.QVTbaseFactory
 * @model kind="package"
 * @generated
 */
public interface QVTbasePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "qvtbase";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTbase";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvtb";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.qvtd.qvtbase";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTbasePackage eINSTANCE = org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.BaseModelImpl <em>Base Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.BaseModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getBaseModel()
	 * @generated
	 */
	int BASE_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL__ANNOTATING_COMMENTS = PivotPackage.MODEL__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL__OWNED_ANNOTATIONS = PivotPackage.MODEL__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL__OWNED_COMMENTS = PivotPackage.MODEL__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL__OWNED_EXTENSIONS = PivotPackage.MODEL__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL__NAME = PivotPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL__OWNED_CONSTRAINTS = PivotPackage.MODEL__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL__EXTERNAL_URI = PivotPackage.MODEL__EXTERNAL_URI;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL__OWNED_IMPORTS = PivotPackage.MODEL__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL__OWNED_PACKAGES = PivotPackage.MODEL__OWNED_PACKAGES;

	/**
	 * The number of structural features of the '<em>Base Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL_FEATURE_COUNT = PivotPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL___ALL_OWNED_ELEMENTS = PivotPackage.MODEL___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL___GET_VALUE__TYPE_STRING = PivotPackage.MODEL___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Base Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASE_MODEL_OPERATION_COUNT = PivotPackage.MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl <em>Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getDomain()
	 * @generated
	 */
	int DOMAIN = 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__ANNOTATING_COMMENTS = PivotPackage.NAMED_ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__OWNED_ANNOTATIONS = PivotPackage.NAMED_ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__OWNED_COMMENTS = PivotPackage.NAMED_ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__OWNED_EXTENSIONS = PivotPackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__NAME = PivotPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__IS_CHECKABLE = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__IS_ENFORCEABLE = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__RULE = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN__TYPED_MODEL = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_FEATURE_COUNT = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___ALL_OWNED_ELEMENTS = PivotPackage.NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___GET_VALUE__TYPE_STRING = PivotPackage.NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___GET_REFERRED_ELEMENT = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Name Is Typed Model Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___VALIDATE_NAME_IS_TYPED_MODEL_NAME__DIAGNOSTICCHAIN_MAP = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Typed Model Is Transformation Model Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN___VALIDATE_TYPED_MODEL_IS_TRANSFORMATION_MODEL_PARAMETER__DIAGNOSTICCHAIN_MAP = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_OPERATION_COUNT = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.FunctionImpl
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__ANNOTATING_COMMENTS = PivotPackage.OPERATION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_ANNOTATIONS = PivotPackage.OPERATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_COMMENTS = PivotPackage.OPERATION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_EXTENSIONS = PivotPackage.OPERATION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = PivotPackage.OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IS_MANY = PivotPackage.OPERATION__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IS_REQUIRED = PivotPackage.OPERATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__TYPE = PivotPackage.OPERATION__TYPE;

	/**
	 * The feature id for the '<em><b>Implementation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IMPLEMENTATION = PivotPackage.OPERATION__IMPLEMENTATION;

	/**
	 * The feature id for the '<em><b>Implementation Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IMPLEMENTATION_CLASS = PivotPackage.OPERATION__IMPLEMENTATION_CLASS;

	/**
	 * The feature id for the '<em><b>Is Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IS_STATIC = PivotPackage.OPERATION__IS_STATIC;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_CONSTRAINTS = PivotPackage.OPERATION__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owned Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_BINDINGS = PivotPackage.OPERATION__OWNED_BINDINGS;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_SIGNATURE = PivotPackage.OPERATION__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__UNSPECIALIZED_ELEMENT = PivotPackage.OPERATION__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Body Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__BODY_EXPRESSION = PivotPackage.OPERATION__BODY_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Is Invalidating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IS_INVALIDATING = PivotPackage.OPERATION__IS_INVALIDATING;

	/**
	 * The feature id for the '<em><b>Is Transient</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IS_TRANSIENT = PivotPackage.OPERATION__IS_TRANSIENT;

	/**
	 * The feature id for the '<em><b>Is Typeof</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IS_TYPEOF = PivotPackage.OPERATION__IS_TYPEOF;

	/**
	 * The feature id for the '<em><b>Is Validating</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__IS_VALIDATING = PivotPackage.OPERATION__IS_VALIDATING;

	/**
	 * The feature id for the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_PARAMETERS = PivotPackage.OPERATION__OWNED_PARAMETERS;

	/**
	 * The feature id for the '<em><b>Owned Postconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_POSTCONDITIONS = PivotPackage.OPERATION__OWNED_POSTCONDITIONS;

	/**
	 * The feature id for the '<em><b>Owned Preconditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNED_PRECONDITIONS = PivotPackage.OPERATION__OWNED_PRECONDITIONS;

	/**
	 * The feature id for the '<em><b>Owning Class</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__OWNING_CLASS = PivotPackage.OPERATION__OWNING_CLASS;

	/**
	 * The feature id for the '<em><b>Precedence</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PRECEDENCE = PivotPackage.OPERATION__PRECEDENCE;

	/**
	 * The feature id for the '<em><b>Raised Exceptions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RAISED_EXCEPTIONS = PivotPackage.OPERATION__RAISED_EXCEPTIONS;

	/**
	 * The feature id for the '<em><b>Redefined Operations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__REDEFINED_OPERATIONS = PivotPackage.OPERATION__REDEFINED_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Query Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__QUERY_EXPRESSION = PivotPackage.OPERATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = PivotPackage.OPERATION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___ALL_OWNED_ELEMENTS = PivotPackage.OPERATION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___GET_VALUE__TYPE_STRING = PivotPackage.OPERATION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___COMPATIBLE_BODY__VALUESPECIFICATION = PivotPackage.OPERATION___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Validate Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Compatible Return</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___VALIDATE_COMPATIBLE_RETURN__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION___VALIDATE_COMPATIBLE_RETURN__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Loadable Implementation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___VALIDATE_LOADABLE_IMPLEMENTATION__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION___VALIDATE_LOADABLE_IMPLEMENTATION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Unique Postcondition Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___VALIDATE_UNIQUE_POSTCONDITION_NAME__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION___VALIDATE_UNIQUE_POSTCONDITION_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Unique Precondition Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___VALIDATE_UNIQUE_PRECONDITION_NAME__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION___VALIDATE_UNIQUE_PRECONDITION_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Parameters Are Function Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___VALIDATE_PARAMETERS_ARE_FUNCTION_PARAMETER__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Return Type Is Query Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION___VALIDATE_RETURN_TYPE_IS_QUERY_TYPE__DIAGNOSTICCHAIN_MAP = PivotPackage.OPERATION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OPERATION_COUNT = PivotPackage.OPERATION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.FunctionParameterImpl <em>Function Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.FunctionParameterImpl
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getFunctionParameter()
	 * @generated
	 */
	int FUNCTION_PARAMETER = 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__ANNOTATING_COMMENTS = PivotPackage.PARAMETER__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__OWNED_ANNOTATIONS = PivotPackage.PARAMETER__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__OWNED_COMMENTS = PivotPackage.PARAMETER__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__OWNED_EXTENSIONS = PivotPackage.PARAMETER__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__NAME = PivotPackage.PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__IS_MANY = PivotPackage.PARAMETER__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__IS_REQUIRED = PivotPackage.PARAMETER__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__TYPE = PivotPackage.PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__TYPE_VALUE = PivotPackage.PARAMETER__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Is Typeof</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__IS_TYPEOF = PivotPackage.PARAMETER__IS_TYPEOF;

	/**
	 * The feature id for the '<em><b>Owning Operation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER__OWNING_OPERATION = PivotPackage.PARAMETER__OWNING_OPERATION;

	/**
	 * The number of structural features of the '<em>Function Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER_FEATURE_COUNT = PivotPackage.PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER___ALL_OWNED_ELEMENTS = PivotPackage.PARAMETER___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER___GET_VALUE__TYPE_STRING = PivotPackage.PARAMETER___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER___COMPATIBLE_BODY__VALUESPECIFICATION = PivotPackage.PARAMETER___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Validate Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.PARAMETER___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = PivotPackage.PARAMETER___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.PARAMETER___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Function Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_PARAMETER_OPERATION_COUNT = PivotPackage.PARAMETER_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.PatternImpl <em>Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.PatternImpl
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getPattern()
	 * @generated
	 */
	int PATTERN = 4;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__PREDICATE = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN__BINDS_TO = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.PredicateImpl <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.PredicateImpl
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getPredicate()
	 * @generated
	 */
	int PREDICATE = 5;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__CONDITION_EXPRESSION = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE__PATTERN = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Condition Is Boolean</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE___VALIDATE_CONDITION_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getRule()
	 * @generated
	 */
	int RULE = 6;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__ANNOTATING_COMMENTS = PivotPackage.NAMED_ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OWNED_ANNOTATIONS = PivotPackage.NAMED_ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OWNED_COMMENTS = PivotPackage.NAMED_ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OWNED_EXTENSIONS = PivotPackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__NAME = PivotPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__DOMAIN = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__IS_ABSTRACT = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OVERRIDDEN = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__OVERRIDES = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE__TRANSFORMATION = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_FEATURE_COUNT = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___ALL_OWNED_ELEMENTS = PivotPackage.NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___GET_VALUE__TYPE_STRING = PivotPackage.NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Domain Name Is Unique</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___VALIDATE_DOMAIN_NAME_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate No Overrides Cycle</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___VALIDATE_NO_OVERRIDES_CYCLE__DIAGNOSTICCHAIN_MAP = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Overriding Rule Overrides All Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE___VALIDATE_OVERRIDING_RULE_OVERRIDES_ALL_DOMAINS__DIAGNOSTICCHAIN_MAP = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_OPERATION_COUNT = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl <em>Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getTransformation()
	 * @generated
	 */
	int TRANSFORMATION = 7;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__ANNOTATING_COMMENTS = PivotPackage.CLASS__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_ANNOTATIONS = PivotPackage.CLASS__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_COMMENTS = PivotPackage.CLASS__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_EXTENSIONS = PivotPackage.CLASS__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__NAME = PivotPackage.CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_CONSTRAINTS = PivotPackage.CLASS__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owned Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_BINDINGS = PivotPackage.CLASS__OWNED_BINDINGS;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_SIGNATURE = PivotPackage.CLASS__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__UNSPECIALIZED_ELEMENT = PivotPackage.CLASS__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Extenders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__EXTENDERS = PivotPackage.CLASS__EXTENDERS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__INSTANCE_CLASS_NAME = PivotPackage.CLASS__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__IS_ABSTRACT = PivotPackage.CLASS__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__IS_ACTIVE = PivotPackage.CLASS__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__IS_INTERFACE = PivotPackage.CLASS__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Owned Behaviors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_BEHAVIORS = PivotPackage.CLASS__OWNED_BEHAVIORS;

	/**
	 * The feature id for the '<em><b>Owned Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_INVARIANTS = PivotPackage.CLASS__OWNED_INVARIANTS;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_OPERATIONS = PivotPackage.CLASS__OWNED_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Owned Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_PROPERTIES = PivotPackage.CLASS__OWNED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNING_PACKAGE = PivotPackage.CLASS__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__SUPER_CLASSES = PivotPackage.CLASS__SUPER_CLASSES;

	/**
	 * The feature id for the '<em><b>Owned Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_TAG = PivotPackage.CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Model Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__MODEL_PARAMETER = PivotPackage.CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__RULE = PivotPackage.CLASS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__EXTENDS = PivotPackage.CLASS_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION__OWNED_CONTEXT = PivotPackage.CLASS_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_FEATURE_COUNT = PivotPackage.CLASS_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___ALL_OWNED_ELEMENTS = PivotPackage.CLASS___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___GET_VALUE__TYPE_STRING = PivotPackage.CLASS___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Flattened Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___FLATTENED_TYPE = PivotPackage.CLASS___FLATTENED_TYPE;

	/**
	 * The operation id for the '<em>Is Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___IS_CLASS = PivotPackage.CLASS___IS_CLASS;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___IS_TEMPLATE_PARAMETER = PivotPackage.CLASS___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___SPECIALIZE_IN__CALLEXP_TYPE = PivotPackage.CLASS___SPECIALIZE_IN__CALLEXP_TYPE;

	/**
	 * The operation id for the '<em>Validate Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.CLASS___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = PivotPackage.CLASS___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Function</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___GET_FUNCTION__STRING = PivotPackage.CLASS_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Get Model Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___GET_MODEL_PARAMETER__STRING = PivotPackage.CLASS_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Context Type Is Transformation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___VALIDATE_CONTEXT_TYPE_IS_TRANSFORMATION__DIAGNOSTICCHAIN_MAP = PivotPackage.CLASS_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Extended Typed Model Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___VALIDATE_EXTENDED_TYPED_MODEL_IS_EXTENDED__DIAGNOSTICCHAIN_MAP = PivotPackage.CLASS_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Model Parameter Is Unique</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___VALIDATE_MODEL_PARAMETER_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = PivotPackage.CLASS_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate No Extends Cycle</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION___VALIDATE_NO_EXTENDS_CYCLE__DIAGNOSTICCHAIN_MAP = PivotPackage.CLASS_OPERATION_COUNT + 5;

	/**
	 * The number of operations of the '<em>Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSFORMATION_OPERATION_COUNT = PivotPackage.CLASS_OPERATION_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl <em>Typed Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getTypedModel()
	 * @generated
	 */
	int TYPED_MODEL = 8;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__ANNOTATING_COMMENTS = PivotPackage.NAMED_ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__OWNED_ANNOTATIONS = PivotPackage.NAMED_ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__OWNED_COMMENTS = PivotPackage.NAMED_ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__OWNED_EXTENSIONS = PivotPackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__NAME = PivotPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__TRANSFORMATION = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Used Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__USED_PACKAGE = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__DEPENDS_ON = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL__OWNED_CONTEXT = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL_FEATURE_COUNT = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;


	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL___ALL_OWNED_ELEMENTS = PivotPackage.NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL___GET_VALUE__TYPE_STRING = PivotPackage.NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPED_MODEL_OPERATION_COUNT = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.BaseModel <em>Base Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Base Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.BaseModel
	 * @generated
	 */
	EClass getBaseModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.Domain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Domain
	 * @generated
	 */
	EClass getDomain();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsCheckable <em>Is Checkable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Checkable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Domain#isIsCheckable()
	 * @see #getDomain()
	 * @generated
	 */
	EAttribute getDomain_IsCheckable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#isIsEnforceable <em>Is Enforceable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enforceable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Domain#isIsEnforceable()
	 * @see #getDomain()
	 * @generated
	 */
	EAttribute getDomain_IsEnforceable();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Rule</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Domain#getRule()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_Rule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Domain#getTypedModel()
	 * @see #getDomain()
	 * @generated
	 */
	EReference getDomain_TypedModel();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#validateNameIsTypedModelName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Typed Model Name</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Typed Model Name</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Domain#validateNameIsTypedModelName(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDomain__ValidateNameIsTypedModelName__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Domain#validateTypedModelIsTransformationModelParameter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Typed Model Is Transformation Model Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Typed Model Is Transformation Model Parameter</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Domain#validateTypedModelIsTransformationModelParameter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getDomain__ValidateTypedModelIsTransformationModelParameter__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtbase.Function#getQueryExpression <em>Query Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Query Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Function#getQueryExpression()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_QueryExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Function#validateParametersAreFunctionParameter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Parameters Are Function Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Parameters Are Function Parameter</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Function#validateParametersAreFunctionParameter(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getFunction__ValidateParametersAreFunctionParameter__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Function#validateReturnTypeIsQueryType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Return Type Is Query Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Return Type Is Query Type</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Function#validateReturnTypeIsQueryType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getFunction__ValidateReturnTypeIsQueryType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.FunctionParameter <em>Function Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.FunctionParameter
	 * @generated
	 */
	EClass getFunctionParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.Pattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Pattern
	 * @generated
	 */
	EClass getPattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtbase.Pattern#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predicate</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Pattern#getPredicate()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_Predicate();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtbase.Pattern#getBindsTo <em>Binds To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Binds To</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Pattern#getBindsTo()
	 * @see #getPattern()
	 * @generated
	 */
	EReference getPattern_BindsTo();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Predicate
	 * @generated
	 */
	EClass getPredicate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtbase.Predicate#getConditionExpression <em>Condition Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Predicate#getConditionExpression()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_ConditionExpression();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtbase.Predicate#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Predicate#getPattern()
	 * @see #getPredicate()
	 * @generated
	 */
	EReference getPredicate_Pattern();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Predicate#validateConditionIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Condition Is Boolean</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Condition Is Boolean</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Predicate#validateConditionIsBoolean(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPredicate__ValidateConditionIsBoolean__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule
	 * @generated
	 */
	EClass getRule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Domain</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#getDomain()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Domain();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#isIsAbstract()
	 * @see #getRule()
	 * @generated
	 */
	EAttribute getRule_IsAbstract();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getOverrides <em>Overrides</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Overrides</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#getOverrides()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Overrides();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#getTransformation()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Transformation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#getOverridden <em>Overridden</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Overridden</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#getOverridden()
	 * @see #getRule()
	 * @generated
	 */
	EReference getRule_Overridden();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#validateDomainNameIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Domain Name Is Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Domain Name Is Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#validateDomainNameIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRule__ValidateDomainNameIsUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#validateNoOverridesCycle(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Overrides Cycle</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Overrides Cycle</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#validateNoOverridesCycle(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRule__ValidateNoOverridesCycle__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Rule#validateOverridingRuleOverridesAllDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Overriding Rule Overrides All Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Overriding Rule Overrides All Domains</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Rule#validateOverridingRuleOverridesAllDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRule__ValidateOverridingRuleOverridesAllDomains__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation
	 * @generated
	 */
	EClass getTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedTag <em>Owned Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tag</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedTag()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_OwnedTag();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getModelParameter <em>Model Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Model Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getModelParameter()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_ModelParameter();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rule</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getRule()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Rule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Extends</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getExtends()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_Extends();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedContext <em>Owned Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Context</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getOwnedContext()
	 * @see #getTransformation()
	 * @generated
	 */
	EReference getTransformation_OwnedContext();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getFunction(java.lang.String) <em>Get Function</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Function</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getFunction(java.lang.String)
	 * @generated
	 */
	EOperation getTransformation__GetFunction__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#getModelParameter(java.lang.String) <em>Get Model Parameter</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Model Parameter</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#getModelParameter(java.lang.String)
	 * @generated
	 */
	EOperation getTransformation__GetModelParameter__String();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#validateContextTypeIsTransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Context Type Is Transformation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Context Type Is Transformation</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#validateContextTypeIsTransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTransformation__ValidateContextTypeIsTransformation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#validateExtendedTypedModelIsExtended(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Extended Typed Model Is Extended</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Extended Typed Model Is Extended</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#validateExtendedTypedModelIsExtended(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTransformation__ValidateExtendedTypedModelIsExtended__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#validateModelParameterIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Model Parameter Is Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Model Parameter Is Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#validateModelParameterIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTransformation__ValidateModelParameterIsUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtbase.Transformation#validateNoExtendsCycle(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Extends Cycle</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Extends Cycle</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtbase.Transformation#validateNoExtendsCycle(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTransformation__ValidateNoExtendsCycle__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.TypedModel
	 * @generated
	 */
	EClass getTypedModel();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.TypedModel#getTransformation()
	 * @see #getTypedModel()
	 * @generated
	 */
	EReference getTypedModel_Transformation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getUsedPackage <em>Used Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used Package</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.TypedModel#getUsedPackage()
	 * @see #getTypedModel()
	 * @generated
	 */
	EReference getTypedModel_UsedPackage();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getDependsOn <em>Depends On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends On</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.TypedModel#getDependsOn()
	 * @see #getTypedModel()
	 * @generated
	 */
	EReference getTypedModel_DependsOn();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtbase.TypedModel#getOwnedContext <em>Owned Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Context</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.TypedModel#getOwnedContext()
	 * @see #getTypedModel()
	 * @generated
	 */
	EReference getTypedModel_OwnedContext();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTbaseFactory getQVTbaseFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.BaseModelImpl <em>Base Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.BaseModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getBaseModel()
		 * @generated
		 */
		EClass BASE_MODEL = eINSTANCE.getBaseModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl <em>Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.DomainImpl
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getDomain()
		 * @generated
		 */
		EClass DOMAIN = eINSTANCE.getDomain();

		/**
		 * The meta object literal for the '<em><b>Is Checkable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN__IS_CHECKABLE = eINSTANCE.getDomain_IsCheckable();

		/**
		 * The meta object literal for the '<em><b>Is Enforceable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOMAIN__IS_ENFORCEABLE = eINSTANCE.getDomain_IsEnforceable();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN__RULE = eINSTANCE.getDomain_Rule();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN__TYPED_MODEL = eINSTANCE.getDomain_TypedModel();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Typed Model Name</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___VALIDATE_NAME_IS_TYPED_MODEL_NAME__DIAGNOSTICCHAIN_MAP = eINSTANCE.getDomain__ValidateNameIsTypedModelName__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Typed Model Is Transformation Model Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation DOMAIN___VALIDATE_TYPED_MODEL_IS_TRANSFORMATION_MODEL_PARAMETER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getDomain__ValidateTypedModelIsTransformationModelParameter__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.FunctionImpl
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Query Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__QUERY_EXPRESSION = eINSTANCE.getFunction_QueryExpression();

		/**
		 * The meta object literal for the '<em><b>Validate Parameters Are Function Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___VALIDATE_PARAMETERS_ARE_FUNCTION_PARAMETER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getFunction__ValidateParametersAreFunctionParameter__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Return Type Is Query Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation FUNCTION___VALIDATE_RETURN_TYPE_IS_QUERY_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getFunction__ValidateReturnTypeIsQueryType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.FunctionParameterImpl <em>Function Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.FunctionParameterImpl
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getFunctionParameter()
		 * @generated
		 */
		EClass FUNCTION_PARAMETER = eINSTANCE.getFunctionParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.PatternImpl <em>Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.PatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getPattern()
		 * @generated
		 */
		EClass PATTERN = eINSTANCE.getPattern();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__PREDICATE = eINSTANCE.getPattern_Predicate();

		/**
		 * The meta object literal for the '<em><b>Binds To</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN__BINDS_TO = eINSTANCE.getPattern_BindsTo();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.PredicateImpl <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.PredicateImpl
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getPredicate()
		 * @generated
		 */
		EClass PREDICATE = eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '<em><b>Condition Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__CONDITION_EXPRESSION = eINSTANCE.getPredicate_ConditionExpression();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PREDICATE__PATTERN = eINSTANCE.getPredicate_Pattern();

		/**
		 * The meta object literal for the '<em><b>Validate Condition Is Boolean</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PREDICATE___VALIDATE_CONDITION_IS_BOOLEAN__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPredicate__ValidateConditionIsBoolean__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getRule()
		 * @generated
		 */
		EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__DOMAIN = eINSTANCE.getRule_Domain();

		/**
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RULE__IS_ABSTRACT = eINSTANCE.getRule_IsAbstract();

		/**
		 * The meta object literal for the '<em><b>Overrides</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__OVERRIDES = eINSTANCE.getRule_Overrides();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__TRANSFORMATION = eINSTANCE.getRule_Transformation();

		/**
		 * The meta object literal for the '<em><b>Overridden</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE__OVERRIDDEN = eINSTANCE.getRule_Overridden();

		/**
		 * The meta object literal for the '<em><b>Validate Domain Name Is Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RULE___VALIDATE_DOMAIN_NAME_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRule__ValidateDomainNameIsUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate No Overrides Cycle</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RULE___VALIDATE_NO_OVERRIDES_CYCLE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRule__ValidateNoOverridesCycle__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Overriding Rule Overrides All Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RULE___VALIDATE_OVERRIDING_RULE_OVERRIDES_ALL_DOMAINS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRule__ValidateOverridingRuleOverridesAllDomains__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl <em>Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.TransformationImpl
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getTransformation()
		 * @generated
		 */
		EClass TRANSFORMATION = eINSTANCE.getTransformation();

		/**
		 * The meta object literal for the '<em><b>Owned Tag</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__OWNED_TAG = eINSTANCE.getTransformation_OwnedTag();

		/**
		 * The meta object literal for the '<em><b>Model Parameter</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__MODEL_PARAMETER = eINSTANCE.getTransformation_ModelParameter();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__RULE = eINSTANCE.getTransformation_Rule();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__EXTENDS = eINSTANCE.getTransformation_Extends();

		/**
		 * The meta object literal for the '<em><b>Owned Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSFORMATION__OWNED_CONTEXT = eINSTANCE.getTransformation_OwnedContext();

		/**
		 * The meta object literal for the '<em><b>Get Function</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORMATION___GET_FUNCTION__STRING = eINSTANCE.getTransformation__GetFunction__String();

		/**
		 * The meta object literal for the '<em><b>Get Model Parameter</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORMATION___GET_MODEL_PARAMETER__STRING = eINSTANCE.getTransformation__GetModelParameter__String();

		/**
		 * The meta object literal for the '<em><b>Validate Context Type Is Transformation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORMATION___VALIDATE_CONTEXT_TYPE_IS_TRANSFORMATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTransformation__ValidateContextTypeIsTransformation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Extended Typed Model Is Extended</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORMATION___VALIDATE_EXTENDED_TYPED_MODEL_IS_EXTENDED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTransformation__ValidateExtendedTypedModelIsExtended__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Model Parameter Is Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORMATION___VALIDATE_MODEL_PARAMETER_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTransformation__ValidateModelParameterIsUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate No Extends Cycle</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TRANSFORMATION___VALIDATE_NO_EXTENDS_CYCLE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTransformation__ValidateNoExtendsCycle__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl <em>Typed Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.TypedModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtbase.impl.QVTbasePackageImpl#getTypedModel()
		 * @generated
		 */
		EClass TYPED_MODEL = eINSTANCE.getTypedModel();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_MODEL__TRANSFORMATION = eINSTANCE.getTypedModel_Transformation();

		/**
		 * The meta object literal for the '<em><b>Used Package</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_MODEL__USED_PACKAGE = eINSTANCE.getTypedModel_UsedPackage();

		/**
		 * The meta object literal for the '<em><b>Depends On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_MODEL__DEPENDS_ON = eINSTANCE.getTypedModel_DependsOn();

		/**
		 * The meta object literal for the '<em><b>Owned Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPED_MODEL__OWNED_CONTEXT = eINSTANCE.getTypedModel_OwnedContext();

	}

} //QVTbasePackage
