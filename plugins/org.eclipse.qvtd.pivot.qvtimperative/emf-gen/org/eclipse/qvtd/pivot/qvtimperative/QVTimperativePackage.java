/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.PivotPackage;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;

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
 * <!-- begin-model-doc -->
 * The Package for an Imperative QVT transformation.
 * 
 * An Imperative QVT trabsformation is expected to be created by an autogenerator that observes the following run-time restrictions:
 * 
 * A mapping that my be re-invoked must have MappingCall.isInfinite set for every possible invocation.
 * 
 * A mapping that reads object slots before they are guaranteed to have been assigned must declare the slots property in a corresponding ImperativeArea.checkedProperties entry.
 * 
 * A mapping that assigns an object slot that any mapping may access before assignment is guaranteed must declare declare the slots property in a corresponding ImperativeArea.enforcedProperties entry.
 * 
 * All reads by Functions/Queries must be guaranteed to succeed; i.e. the invoking mapping must check readiness before calling the query.
 * 
 * All writes to multi-valued properties must be guaranteed to occur before any read of the property.
 * <!-- end-model-doc -->
 * @see org.eclipse.qvtd.pivot.qvtimperative.QVTimperativeFactory
 * @generated
 */
public interface QVTimperativePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvtimperative";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2016/QVTimperative";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvti";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.qvtd.qvtimperative";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTimperativePackage eINSTANCE = org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl <em>Imperative Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeModel()
	 * @generated
	 */
	int IMPERATIVE_MODEL = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl <em>Mapping Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingStatement()
	 * @generated
	 */
	int MAPPING_STATEMENT = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionVariableImpl <em>Connection Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getConnectionVariable()
	 * @generated
	 */
	int CONNECTION_VARIABLE = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl <em>Mapping Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingCall()
	 * @generated
	 */
	int MAPPING_CALL = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl <em>Mapping Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingLoop()
	 * @generated
	 */
	int MAPPING_LOOP = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.StatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl <em>Add Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAddStatement()
	 * @generated
	 */
	int ADD_STATEMENT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.CheckStatementImpl <em>Check Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.CheckStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getCheckStatement()
	 * @generated
	 */
	int CHECK_STATEMENT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl <em>Imperative Typed Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeTypedModel()
	 * @generated
	 */
	int IMPERATIVE_TYPED_MODEL = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.LoopVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getLoopVariable()
	 * @generated
	 */
	int LOOP_VARIABLE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.VariableStatementImpl <em>Variable Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.VariableStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getVariableStatement()
	 * @generated
	 */
	int VARIABLE_STATEMENT = 26;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__ANNOTATING_COMMENTS = PivotPackage.NAMED_ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__OWNED_ANNOTATIONS = PivotPackage.NAMED_ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__OWNED_COMMENTS = PivotPackage.NAMED_ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__OWNED_EXTENSIONS = PivotPackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT__NAME = PivotPackage.NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__ANNOTATING_COMMENTS = STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__OWNED_ANNOTATIONS = STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__OWNED_COMMENTS = STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__OWNED_EXTENSIONS = STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Mapping Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__ANNOTATING_COMMENTS = MAPPING_STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__OWNED_ANNOTATIONS = MAPPING_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__OWNED_COMMENTS = MAPPING_STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__OWNED_EXTENSIONS = MAPPING_STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__NAME = MAPPING_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Observed Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__OBSERVED_PROPERTIES = MAPPING_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__TARGET_VARIABLE = MAPPING_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Enforced Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__IS_ENFORCED_UNIQUE = MAPPING_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__OWNED_EXPRESSION = MAPPING_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Add Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_FEATURE_COUNT = MAPPING_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterImpl <em>Append Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAppendParameter()
	 * @generated
	 */
	int APPEND_PARAMETER = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ObservableStatementImpl <em>Observable Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ObservableStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getObservableStatement()
	 * @generated
	 */
	int OBSERVABLE_STATEMENT = 21;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE__ANNOTATING_COMMENTS = PivotPackage.VARIABLE_DECLARATION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE__OWNED_ANNOTATIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE__OWNED_COMMENTS = PivotPackage.VARIABLE_DECLARATION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE__OWNED_EXTENSIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE__NAME = PivotPackage.VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE__IS_MANY = PivotPackage.VARIABLE_DECLARATION__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE__IS_REQUIRED = PivotPackage.VARIABLE_DECLARATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE__TYPE = PivotPackage.VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE__TYPE_VALUE = PivotPackage.VARIABLE_DECLARATION__TYPE_VALUE;

	/**
	 * The number of structural features of the '<em>Connection Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_VARIABLE_FEATURE_COUNT = PivotPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER__ANNOTATING_COMMENTS = CONNECTION_VARIABLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER__OWNED_ANNOTATIONS = CONNECTION_VARIABLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER__OWNED_COMMENTS = CONNECTION_VARIABLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER__OWNED_EXTENSIONS = CONNECTION_VARIABLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER__NAME = CONNECTION_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER__IS_MANY = CONNECTION_VARIABLE__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER__IS_REQUIRED = CONNECTION_VARIABLE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER__TYPE = CONNECTION_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER__TYPE_VALUE = CONNECTION_VARIABLE__TYPE_VALUE;

	/**
	 * The number of structural features of the '<em>Append Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER_FEATURE_COUNT = CONNECTION_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl <em>Mapping Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingParameterBinding()
	 * @generated
	 */
	int MAPPING_PARAMETER_BINDING = 18;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER_BINDING__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER_BINDING__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER_BINDING__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER_BINDING__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Mapping Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER_BINDING__MAPPING_CALL = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bound Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER_BINDING__BOUND_VARIABLE = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER_BINDING_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.DeclareStatementImpl <em>Declare Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.DeclareStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getDeclareStatement()
	 * @generated
	 */
	int DECLARE_STATEMENT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterImpl <em>Mapping Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingParameter()
	 * @generated
	 */
	int MAPPING_PARAMETER = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterImpl <em>Guard Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getGuardParameter()
	 * @generated
	 */
	int GUARD_PARAMETER = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterBindingImpl <em>Guard Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterBindingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getGuardParameterBinding()
	 * @generated
	 */
	int GUARD_PARAMETER_BINDING = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterBindingImpl <em>Append Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterBindingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAppendParameterBinding()
	 * @generated
	 */
	int APPEND_PARAMETER_BINDING = 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER_BINDING__ANNOTATING_COMMENTS = MAPPING_PARAMETER_BINDING__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER_BINDING__OWNED_ANNOTATIONS = MAPPING_PARAMETER_BINDING__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER_BINDING__OWNED_COMMENTS = MAPPING_PARAMETER_BINDING__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER_BINDING__OWNED_EXTENSIONS = MAPPING_PARAMETER_BINDING__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Mapping Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER_BINDING__MAPPING_CALL = MAPPING_PARAMETER_BINDING__MAPPING_CALL;

	/**
	 * The feature id for the '<em><b>Bound Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER_BINDING__BOUND_VARIABLE = MAPPING_PARAMETER_BINDING__BOUND_VARIABLE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER_BINDING__VALUE = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Append Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int APPEND_PARAMETER_BINDING_FEATURE_COUNT = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl <em>Buffer Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getBufferStatement()
	 * @generated
	 */
	int BUFFER_STATEMENT = 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__ANNOTATING_COMMENTS = CONNECTION_VARIABLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__OWNED_ANNOTATIONS = CONNECTION_VARIABLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__OWNED_COMMENTS = CONNECTION_VARIABLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__OWNED_EXTENSIONS = CONNECTION_VARIABLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__NAME = CONNECTION_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__IS_MANY = CONNECTION_VARIABLE__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__IS_REQUIRED = CONNECTION_VARIABLE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__TYPE = CONNECTION_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__TYPE_VALUE = CONNECTION_VARIABLE__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Observed Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__OBSERVED_PROPERTIES = CONNECTION_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT__OWNED_EXPRESSION = CONNECTION_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Buffer Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUFFER_STATEMENT_FEATURE_COUNT = CONNECTION_VARIABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVABLE_STATEMENT__ANNOTATING_COMMENTS = STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVABLE_STATEMENT__OWNED_ANNOTATIONS = STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVABLE_STATEMENT__OWNED_COMMENTS = STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVABLE_STATEMENT__OWNED_EXTENSIONS = STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVABLE_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Observed Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Observable Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBSERVABLE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__ANNOTATING_COMMENTS = OBSERVABLE_STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__OWNED_ANNOTATIONS = OBSERVABLE_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__OWNED_COMMENTS = OBSERVABLE_STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__OWNED_EXTENSIONS = OBSERVABLE_STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__NAME = OBSERVABLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Observed Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__OBSERVED_PROPERTIES = OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__OWNED_EXPRESSION = OBSERVABLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT_FEATURE_COUNT = OBSERVABLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__ANNOTATING_COMMENTS = PivotPackage.VARIABLE_DECLARATION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__OWNED_ANNOTATIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__OWNED_COMMENTS = PivotPackage.VARIABLE_DECLARATION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__OWNED_EXTENSIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__NAME = PivotPackage.VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__IS_MANY = PivotPackage.VARIABLE_DECLARATION__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__IS_REQUIRED = PivotPackage.VARIABLE_DECLARATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__TYPE = PivotPackage.VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT__TYPE_VALUE = PivotPackage.VARIABLE_DECLARATION__TYPE_VALUE;

	/**
	 * The number of structural features of the '<em>Variable Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_STATEMENT_FEATURE_COUNT = PivotPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__ANNOTATING_COMMENTS = VARIABLE_STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__OWNED_ANNOTATIONS = VARIABLE_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__OWNED_COMMENTS = VARIABLE_STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__OWNED_EXTENSIONS = VARIABLE_STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__NAME = VARIABLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__IS_MANY = VARIABLE_STATEMENT__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__IS_REQUIRED = VARIABLE_STATEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__TYPE = VARIABLE_STATEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__TYPE_VALUE = VARIABLE_STATEMENT__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Observed Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__OBSERVED_PROPERTIES = VARIABLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__IS_CHECK = VARIABLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__OWNED_EXPRESSION = VARIABLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Declare Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT_FEATURE_COUNT = VARIABLE_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__ANNOTATING_COMMENTS = PivotPackage.VARIABLE_DECLARATION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__OWNED_ANNOTATIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__OWNED_COMMENTS = PivotPackage.VARIABLE_DECLARATION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__OWNED_EXTENSIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__NAME = PivotPackage.VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__IS_MANY = PivotPackage.VARIABLE_DECLARATION__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__IS_REQUIRED = PivotPackage.VARIABLE_DECLARATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__TYPE = PivotPackage.VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER__TYPE_VALUE = PivotPackage.VARIABLE_DECLARATION__TYPE_VALUE;

	/**
	 * The number of structural features of the '<em>Mapping Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_PARAMETER_FEATURE_COUNT = PivotPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__ANNOTATING_COMMENTS = MAPPING_PARAMETER__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__OWNED_ANNOTATIONS = MAPPING_PARAMETER__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__OWNED_COMMENTS = MAPPING_PARAMETER__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__OWNED_EXTENSIONS = MAPPING_PARAMETER__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__NAME = MAPPING_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__IS_MANY = MAPPING_PARAMETER__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__IS_REQUIRED = MAPPING_PARAMETER__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__TYPE = MAPPING_PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__TYPE_VALUE = MAPPING_PARAMETER__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER__REFERRED_TYPED_MODEL = MAPPING_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guard Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_FEATURE_COUNT = MAPPING_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_BINDING__ANNOTATING_COMMENTS = MAPPING_PARAMETER_BINDING__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_BINDING__OWNED_ANNOTATIONS = MAPPING_PARAMETER_BINDING__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_BINDING__OWNED_COMMENTS = MAPPING_PARAMETER_BINDING__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_BINDING__OWNED_EXTENSIONS = MAPPING_PARAMETER_BINDING__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Mapping Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_BINDING__MAPPING_CALL = MAPPING_PARAMETER_BINDING__MAPPING_CALL;

	/**
	 * The feature id for the '<em><b>Bound Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_BINDING__BOUND_VARIABLE = MAPPING_PARAMETER_BINDING__BOUND_VARIABLE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_BINDING__VALUE = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_BINDING__IS_CHECK = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Guard Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PARAMETER_BINDING_FEATURE_COUNT = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL__ANNOTATING_COMMENTS = QVTbasePackage.BASE_MODEL__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL__OWNED_ANNOTATIONS = QVTbasePackage.BASE_MODEL__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL__OWNED_COMMENTS = QVTbasePackage.BASE_MODEL__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL__OWNED_EXTENSIONS = QVTbasePackage.BASE_MODEL__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL__NAME = QVTbasePackage.BASE_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL__OWNED_CONSTRAINTS = QVTbasePackage.BASE_MODEL__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL__EXTERNAL_URI = QVTbasePackage.BASE_MODEL__EXTERNAL_URI;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL__OWNED_IMPORTS = QVTbasePackage.BASE_MODEL__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL__OWNED_PACKAGES = QVTbasePackage.BASE_MODEL__OWNED_PACKAGES;

	/**
	 * The number of structural features of the '<em>Imperative Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_MODEL_FEATURE_COUNT = QVTbasePackage.BASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTransformationImpl <em>Imperative Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTransformationImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeTransformation()
	 * @generated
	 */
	int IMPERATIVE_TRANSFORMATION = 10;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__ANNOTATING_COMMENTS = QVTbasePackage.TRANSFORMATION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_ANNOTATIONS = QVTbasePackage.TRANSFORMATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_COMMENTS = QVTbasePackage.TRANSFORMATION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_EXTENSIONS = QVTbasePackage.TRANSFORMATION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__NAME = QVTbasePackage.TRANSFORMATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_CONSTRAINTS = QVTbasePackage.TRANSFORMATION__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owned Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_BINDINGS = QVTbasePackage.TRANSFORMATION__OWNED_BINDINGS;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_SIGNATURE = QVTbasePackage.TRANSFORMATION__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__UNSPECIALIZED_ELEMENT = QVTbasePackage.TRANSFORMATION__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Extenders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__EXTENDERS = QVTbasePackage.TRANSFORMATION__EXTENDERS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__INSTANCE_CLASS_NAME = QVTbasePackage.TRANSFORMATION__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__IS_ABSTRACT = QVTbasePackage.TRANSFORMATION__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__IS_ACTIVE = QVTbasePackage.TRANSFORMATION__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__IS_INTERFACE = QVTbasePackage.TRANSFORMATION__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Owned Behaviors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_BEHAVIORS = QVTbasePackage.TRANSFORMATION__OWNED_BEHAVIORS;

	/**
	 * The feature id for the '<em><b>Owned Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_INVARIANTS = QVTbasePackage.TRANSFORMATION__OWNED_INVARIANTS;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_OPERATIONS = QVTbasePackage.TRANSFORMATION__OWNED_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Owned Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_PROPERTIES = QVTbasePackage.TRANSFORMATION__OWNED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNING_PACKAGE = QVTbasePackage.TRANSFORMATION__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__SUPER_CLASSES = QVTbasePackage.TRANSFORMATION__SUPER_CLASSES;

	/**
	 * The feature id for the '<em><b>Owned Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_TAG = QVTbasePackage.TRANSFORMATION__OWNED_TAG;

	/**
	 * The feature id for the '<em><b>Model Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__MODEL_PARAMETER = QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__RULE = QVTbasePackage.TRANSFORMATION__RULE;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__EXTENDS = QVTbasePackage.TRANSFORMATION__EXTENDS;

	/**
	 * The feature id for the '<em><b>Owned Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION__OWNED_CONTEXT = QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT;

	/**
	 * The number of structural features of the '<em>Imperative Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TRANSFORMATION_FEATURE_COUNT = QVTbasePackage.TRANSFORMATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__ANNOTATING_COMMENTS = QVTbasePackage.TYPED_MODEL__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__OWNED_ANNOTATIONS = QVTbasePackage.TYPED_MODEL__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__OWNED_COMMENTS = QVTbasePackage.TYPED_MODEL__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__OWNED_EXTENSIONS = QVTbasePackage.TYPED_MODEL__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__NAME = QVTbasePackage.TYPED_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__TRANSFORMATION = QVTbasePackage.TYPED_MODEL__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Used Package</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__USED_PACKAGE = QVTbasePackage.TYPED_MODEL__USED_PACKAGE;

	/**
	 * The feature id for the '<em><b>Depends On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__DEPENDS_ON = QVTbasePackage.TYPED_MODEL__DEPENDS_ON;

	/**
	 * The feature id for the '<em><b>Owned Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__OWNED_CONTEXT = QVTbasePackage.TYPED_MODEL__OWNED_CONTEXT;

	/**
	 * The feature id for the '<em><b>Is Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__IS_CHECKED = QVTbasePackage.TYPED_MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Enforced</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL__IS_ENFORCED = QVTbasePackage.TYPED_MODEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Imperative Typed Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_TYPED_MODEL_FEATURE_COUNT = QVTbasePackage.TYPED_MODEL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.LoopParameterBindingImpl <em>Loop Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.LoopParameterBindingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getLoopParameterBinding()
	 * @generated
	 */
	int LOOP_PARAMETER_BINDING = 12;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PARAMETER_BINDING__ANNOTATING_COMMENTS = MAPPING_PARAMETER_BINDING__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PARAMETER_BINDING__OWNED_ANNOTATIONS = MAPPING_PARAMETER_BINDING__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PARAMETER_BINDING__OWNED_COMMENTS = MAPPING_PARAMETER_BINDING__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PARAMETER_BINDING__OWNED_EXTENSIONS = MAPPING_PARAMETER_BINDING__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Mapping Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PARAMETER_BINDING__MAPPING_CALL = MAPPING_PARAMETER_BINDING__MAPPING_CALL;

	/**
	 * The feature id for the '<em><b>Bound Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PARAMETER_BINDING__BOUND_VARIABLE = MAPPING_PARAMETER_BINDING__BOUND_VARIABLE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PARAMETER_BINDING__VALUE = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PARAMETER_BINDING__IS_CHECK = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_PARAMETER_BINDING_FEATURE_COUNT = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__ANNOTATING_COMMENTS = PivotPackage.VARIABLE_DECLARATION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__OWNED_ANNOTATIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__OWNED_COMMENTS = PivotPackage.VARIABLE_DECLARATION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__OWNED_EXTENSIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__NAME = PivotPackage.VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__IS_MANY = PivotPackage.VARIABLE_DECLARATION__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__IS_REQUIRED = PivotPackage.VARIABLE_DECLARATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__TYPE = PivotPackage.VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__TYPE_VALUE = PivotPackage.VARIABLE_DECLARATION__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Owning Mapping Loop</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE__OWNING_MAPPING_LOOP = PivotPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loop Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_VARIABLE_FEATURE_COUNT = PivotPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ANNOTATING_COMMENTS = QVTbasePackage.RULE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_ANNOTATIONS = QVTbasePackage.RULE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_COMMENTS = QVTbasePackage.RULE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_EXTENSIONS = QVTbasePackage.RULE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = QVTbasePackage.RULE__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__DOMAIN = QVTbasePackage.RULE__DOMAIN;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__IS_DEFAULT = QVTbasePackage.RULE__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OVERRIDES = QVTbasePackage.RULE__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TRANSFORMATION = QVTbasePackage.RULE__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OVERRIDDEN = QVTbasePackage.RULE__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>Owned Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_PARAMETERS = QVTbasePackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_STATEMENTS = QVTbasePackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = QVTbasePackage.RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__ANNOTATING_COMMENTS = MAPPING_STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__OWNED_ANNOTATIONS = MAPPING_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__OWNED_COMMENTS = MAPPING_STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__OWNED_EXTENSIONS = MAPPING_STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__NAME = MAPPING_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Binding</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__BINDING = MAPPING_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Infinite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__IS_INFINITE = MAPPING_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Install</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__IS_INSTALL = MAPPING_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Invoke</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__IS_INVOKE = MAPPING_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__REFERRED_MAPPING = MAPPING_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Mapping Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_FEATURE_COUNT = MAPPING_STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__ANNOTATING_COMMENTS = MAPPING_STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_ANNOTATIONS = MAPPING_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_COMMENTS = MAPPING_STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_EXTENSIONS = MAPPING_STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__NAME = MAPPING_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Observed Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OBSERVED_PROPERTIES = MAPPING_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_ITERATORS = MAPPING_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Mapping Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_MAPPING_STATEMENTS = MAPPING_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_EXPRESSION = MAPPING_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_FEATURE_COUNT = MAPPING_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl <em>New Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getNewStatement()
	 * @generated
	 */
	int NEW_STATEMENT = 20;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__ANNOTATING_COMMENTS = VARIABLE_STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__OWNED_ANNOTATIONS = VARIABLE_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__OWNED_COMMENTS = VARIABLE_STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__OWNED_EXTENSIONS = VARIABLE_STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__NAME = VARIABLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__IS_MANY = VARIABLE_STATEMENT__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__IS_REQUIRED = VARIABLE_STATEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__TYPE = VARIABLE_STATEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__TYPE_VALUE = VARIABLE_STATEMENT__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Observed Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__OBSERVED_PROPERTIES = VARIABLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__REFERRED_TYPED_MODEL = VARIABLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__OWNED_EXPRESSION = VARIABLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>New Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_FEATURE_COUNT = VARIABLE_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl <em>Set Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSetStatement()
	 * @generated
	 */
	int SET_STATEMENT = 22;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__ANNOTATING_COMMENTS = OBSERVABLE_STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__OWNED_ANNOTATIONS = OBSERVABLE_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__OWNED_COMMENTS = OBSERVABLE_STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__OWNED_EXTENSIONS = OBSERVABLE_STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__NAME = OBSERVABLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Observed Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__OBSERVED_PROPERTIES = OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__TARGET_VARIABLE = OBSERVABLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__TARGET_PROPERTY = OBSERVABLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__IS_OPPOSITE = OBSERVABLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Notify</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__IS_NOTIFY = OBSERVABLE_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__OWNED_EXPRESSION = OBSERVABLE_STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Set Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_FEATURE_COUNT = OBSERVABLE_STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterImpl <em>Simple Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSimpleParameter()
	 * @generated
	 */
	int SIMPLE_PARAMETER = 23;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__ANNOTATING_COMMENTS = MAPPING_PARAMETER__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__OWNED_ANNOTATIONS = MAPPING_PARAMETER__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__OWNED_COMMENTS = MAPPING_PARAMETER__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__OWNED_EXTENSIONS = MAPPING_PARAMETER__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__NAME = MAPPING_PARAMETER__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__IS_MANY = MAPPING_PARAMETER__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__IS_REQUIRED = MAPPING_PARAMETER__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__TYPE = MAPPING_PARAMETER__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__TYPE_VALUE = MAPPING_PARAMETER__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER__REFERRED_TYPED_MODEL = MAPPING_PARAMETER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_FEATURE_COUNT = MAPPING_PARAMETER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterBindingImpl <em>Simple Parameter Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterBindingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSimpleParameterBinding()
	 * @generated
	 */
	int SIMPLE_PARAMETER_BINDING = 24;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_BINDING__ANNOTATING_COMMENTS = MAPPING_PARAMETER_BINDING__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_BINDING__OWNED_ANNOTATIONS = MAPPING_PARAMETER_BINDING__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_BINDING__OWNED_COMMENTS = MAPPING_PARAMETER_BINDING__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_BINDING__OWNED_EXTENSIONS = MAPPING_PARAMETER_BINDING__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Mapping Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_BINDING__MAPPING_CALL = MAPPING_PARAMETER_BINDING__MAPPING_CALL;

	/**
	 * The feature id for the '<em><b>Bound Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_BINDING__BOUND_VARIABLE = MAPPING_PARAMETER_BINDING__BOUND_VARIABLE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_BINDING__VALUE = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_BINDING__IS_CHECK = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple Parameter Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_PARAMETER_BINDING_FEATURE_COUNT = MAPPING_PARAMETER_BINDING_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement <em>Add Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Add Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement
	 * @generated
	 */
	EClass getAddStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getTargetVariable()
	 * @see #getAddStatement()
	 * @generated
	 */
	EReference getAddStatement_TargetVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#isIsEnforcedUnique <em>Is Enforced Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enforced Unique</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement#isIsEnforcedUnique()
	 * @see #getAddStatement()
	 * @generated
	 */
	EAttribute getAddStatement_IsEnforcedUnique();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getOwnedExpression()
	 * @see #getAddStatement()
	 * @generated
	 */
	EReference getAddStatement_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.AppendParameter <em>Append Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Append Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AppendParameter
	 * @generated
	 */
	EClass getAppendParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding <em>Append Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Append Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding
	 * @generated
	 */
	EClass getAppendParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AppendParameterBinding#getValue()
	 * @see #getAppendParameterBinding()
	 * @generated
	 */
	EReference getAppendParameterBinding_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement <em>Buffer Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Buffer Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.BufferStatement
	 * @generated
	 */
	EClass getBufferStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.BufferStatement#getOwnedExpression()
	 * @see #getBufferStatement()
	 * @generated
	 */
	EReference getBufferStatement_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.CheckStatement <em>Check Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.CheckStatement
	 * @generated
	 */
	EClass getCheckStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.CheckStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.CheckStatement#getOwnedExpression()
	 * @see #getCheckStatement()
	 * @generated
	 */
	EReference getCheckStatement_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable <em>Connection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable
	 * @generated
	 */
	EClass getConnectionVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement <em>Declare Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Declare Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement
	 * @generated
	 */
	EClass getDeclareStatement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#isIsCheck()
	 * @see #getDeclareStatement()
	 * @generated
	 */
	EAttribute getDeclareStatement_IsCheck();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#getOwnedExpression()
	 * @see #getDeclareStatement()
	 * @generated
	 */
	EReference getDeclareStatement_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameter <em>Guard Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameter
	 * @generated
	 */
	EClass getGuardParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameter#getReferredTypedModel()
	 * @see #getGuardParameter()
	 * @generated
	 */
	EReference getGuardParameter_ReferredTypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding <em>Guard Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding
	 * @generated
	 */
	EClass getGuardParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding#getValue()
	 * @see #getGuardParameterBinding()
	 * @generated
	 */
	EReference getGuardParameterBinding_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardParameterBinding#isIsCheck()
	 * @see #getGuardParameterBinding()
	 * @generated
	 */
	EAttribute getGuardParameterBinding_IsCheck();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel <em>Imperative Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel
	 * @generated
	 */
	EClass getImperativeModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation <em>Imperative Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTransformation
	 * @generated
	 */
	EClass getImperativeTransformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel <em>Imperative Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel
	 * @generated
	 */
	EClass getImperativeTypedModel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsChecked <em>Is Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Checked</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsChecked()
	 * @see #getImperativeTypedModel()
	 * @generated
	 */
	EAttribute getImperativeTypedModel_IsChecked();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsEnforced <em>Is Enforced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enforced</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel#isIsEnforced()
	 * @see #getImperativeTypedModel()
	 * @generated
	 */
	EAttribute getImperativeTypedModel_IsEnforced();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding <em>Loop Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding
	 * @generated
	 */
	EClass getLoopParameterBinding();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#getValue()
	 * @see #getLoopParameterBinding()
	 * @generated
	 */
	EReference getLoopParameterBinding_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopParameterBinding#isIsCheck()
	 * @see #getLoopParameterBinding()
	 * @generated
	 */
	EAttribute getLoopParameterBinding_IsCheck();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopVariable <em>Loop Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopVariable
	 * @generated
	 */
	EClass getLoopVariable();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.LoopVariable#getOwningMappingLoop <em>Owning Mapping Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Mapping Loop</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.LoopVariable#getOwningMappingLoop()
	 * @see #getLoopVariable()
	 * @generated
	 */
	EReference getLoopVariable_OwningMappingLoop();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedParameters <em>Owned Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Parameters</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedParameters()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_OwnedParameters();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedStatements <em>Owned Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Statements</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedStatements()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_OwnedStatements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall <em>Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall
	 * @generated
	 */
	EClass getMappingCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredMapping <em>Referred Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getReferredMapping()
	 * @see #getMappingCall()
	 * @generated
	 */
	EReference getMappingCall_ReferredMapping();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getBinding <em>Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#getBinding()
	 * @see #getMappingCall()
	 * @generated
	 */
	EReference getMappingCall_Binding();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInfinite <em>Is Infinite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Infinite</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInfinite()
	 * @see #getMappingCall()
	 * @generated
	 */
	EAttribute getMappingCall_IsInfinite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInstall <em>Is Install</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Install</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInstall()
	 * @see #getMappingCall()
	 * @generated
	 */
	EAttribute getMappingCall_IsInstall();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInvoke <em>Is Invoke</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Invoke</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCall#isIsInvoke()
	 * @see #getMappingCall()
	 * @generated
	 */
	EAttribute getMappingCall_IsInvoke();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop <em>Mapping Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Loop</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop
	 * @generated
	 */
	EClass getMappingLoop();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedIterators <em>Owned Iterators</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Iterators</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedIterators()
	 * @see #getMappingLoop()
	 * @generated
	 */
	EReference getMappingLoop_OwnedIterators();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedMappingStatements <em>Owned Mapping Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Statements</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedMappingStatements()
	 * @see #getMappingLoop()
	 * @generated
	 */
	EReference getMappingLoop_OwnedMappingStatements();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedExpression()
	 * @see #getMappingLoop()
	 * @generated
	 */
	EReference getMappingLoop_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameter <em>Mapping Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameter
	 * @generated
	 */
	EClass getMappingParameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding <em>Mapping Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding
	 * @generated
	 */
	EClass getMappingParameterBinding();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getMappingCall <em>Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Call</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getMappingCall()
	 * @see #getMappingParameterBinding()
	 * @generated
	 */
	EReference getMappingParameterBinding_MappingCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getBoundVariable <em>Bound Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bound Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding#getBoundVariable()
	 * @see #getMappingParameterBinding()
	 * @generated
	 */
	EReference getMappingParameterBinding_BoundVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingStatement <em>Mapping Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingStatement
	 * @generated
	 */
	EClass getMappingStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement <em>New Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement
	 * @generated
	 */
	EClass getNewStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getReferredTypedModel()
	 * @see #getNewStatement()
	 * @generated
	 */
	EReference getNewStatement_ReferredTypedModel();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedExpression()
	 * @see #getNewStatement()
	 * @generated
	 */
	EReference getNewStatement_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement <em>Observable Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Observable Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement
	 * @generated
	 */
	EClass getObservableStatement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement#getObservedProperties <em>Observed Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Observed Properties</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement#getObservedProperties()
	 * @see #getObservableStatement()
	 * @generated
	 */
	EReference getObservableStatement_ObservedProperties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement <em>Set Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement
	 * @generated
	 */
	EClass getSetStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetVariable()
	 * @see #getSetStatement()
	 * @generated
	 */
	EReference getSetStatement_TargetVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetProperty <em>Target Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getTargetProperty()
	 * @see #getSetStatement()
	 * @generated
	 */
	EReference getSetStatement_TargetProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsOpposite <em>Is Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Opposite</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsOpposite()
	 * @see #getSetStatement()
	 * @generated
	 */
	EAttribute getSetStatement_IsOpposite();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsNotify <em>Is Notify</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Notify</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsNotify()
	 * @see #getSetStatement()
	 * @generated
	 */
	EAttribute getSetStatement_IsNotify();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getOwnedExpression <em>Owned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getOwnedExpression()
	 * @see #getSetStatement()
	 * @generated
	 */
	EReference getSetStatement_OwnedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter <em>Simple Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter
	 * @generated
	 */
	EClass getSimpleParameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter#getReferredTypedModel()
	 * @see #getSimpleParameter()
	 * @generated
	 */
	EReference getSimpleParameter_ReferredTypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding <em>Simple Parameter Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple Parameter Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding
	 * @generated
	 */
	EClass getSimpleParameterBinding();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#getValue()
	 * @see #getSimpleParameterBinding()
	 * @generated
	 */
	EReference getSimpleParameterBinding_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#isIsCheck <em>Is Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Check</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SimpleParameterBinding#isIsCheck()
	 * @see #getSimpleParameterBinding()
	 * @generated
	 */
	EAttribute getSimpleParameterBinding_IsCheck();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.VariableStatement <em>Variable Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.VariableStatement
	 * @generated
	 */
	EClass getVariableStatement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTimperativeFactory getQVTimperativeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl <em>Add Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAddStatement()
		 * @generated
		 */
		EClass ADD_STATEMENT = eINSTANCE.getAddStatement();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_STATEMENT__TARGET_VARIABLE = eINSTANCE.getAddStatement_TargetVariable();

		/**
		 * The meta object literal for the '<em><b>Is Enforced Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_STATEMENT__IS_ENFORCED_UNIQUE = eINSTANCE.getAddStatement_IsEnforcedUnique();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getAddStatement_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterImpl <em>Append Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAppendParameter()
		 * @generated
		 */
		EClass APPEND_PARAMETER = eINSTANCE.getAppendParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterBindingImpl <em>Append Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AppendParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAppendParameterBinding()
		 * @generated
		 */
		EClass APPEND_PARAMETER_BINDING = eINSTANCE.getAppendParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference APPEND_PARAMETER_BINDING__VALUE = eINSTANCE.getAppendParameterBinding_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl <em>Buffer Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.BufferStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getBufferStatement()
		 * @generated
		 */
		EClass BUFFER_STATEMENT = eINSTANCE.getBufferStatement();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUFFER_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getBufferStatement_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.CheckStatementImpl <em>Check Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.CheckStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getCheckStatement()
		 * @generated
		 */
		EClass CHECK_STATEMENT = eINSTANCE.getCheckStatement();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getCheckStatement_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionVariableImpl <em>Connection Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getConnectionVariable()
		 * @generated
		 */
		EClass CONNECTION_VARIABLE = eINSTANCE.getConnectionVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.DeclareStatementImpl <em>Declare Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.DeclareStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getDeclareStatement()
		 * @generated
		 */
		EClass DECLARE_STATEMENT = eINSTANCE.getDeclareStatement();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARE_STATEMENT__IS_CHECK = eINSTANCE.getDeclareStatement_IsCheck();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARE_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getDeclareStatement_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterImpl <em>Guard Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getGuardParameter()
		 * @generated
		 */
		EClass GUARD_PARAMETER = eINSTANCE.getGuardParameter();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_PARAMETER__REFERRED_TYPED_MODEL = eINSTANCE.getGuardParameter_ReferredTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterBindingImpl <em>Guard Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getGuardParameterBinding()
		 * @generated
		 */
		EClass GUARD_PARAMETER_BINDING = eINSTANCE.getGuardParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_PARAMETER_BINDING__VALUE = eINSTANCE.getGuardParameterBinding_Value();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GUARD_PARAMETER_BINDING__IS_CHECK = eINSTANCE.getGuardParameterBinding_IsCheck();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl <em>Imperative Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeModel()
		 * @generated
		 */
		EClass IMPERATIVE_MODEL = eINSTANCE.getImperativeModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTransformationImpl <em>Imperative Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTransformationImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeTransformation()
		 * @generated
		 */
		EClass IMPERATIVE_TRANSFORMATION = eINSTANCE.getImperativeTransformation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl <em>Imperative Typed Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeTypedModel()
		 * @generated
		 */
		EClass IMPERATIVE_TYPED_MODEL = eINSTANCE.getImperativeTypedModel();

		/**
		 * The meta object literal for the '<em><b>Is Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPERATIVE_TYPED_MODEL__IS_CHECKED = eINSTANCE.getImperativeTypedModel_IsChecked();

		/**
		 * The meta object literal for the '<em><b>Is Enforced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPERATIVE_TYPED_MODEL__IS_ENFORCED = eINSTANCE.getImperativeTypedModel_IsEnforced();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.LoopParameterBindingImpl <em>Loop Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.LoopParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getLoopParameterBinding()
		 * @generated
		 */
		EClass LOOP_PARAMETER_BINDING = eINSTANCE.getLoopParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_PARAMETER_BINDING__VALUE = eINSTANCE.getLoopParameterBinding_Value();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOOP_PARAMETER_BINDING__IS_CHECK = eINSTANCE.getLoopParameterBinding_IsCheck();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.LoopVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getLoopVariable()
		 * @generated
		 */
		EClass LOOP_VARIABLE = eINSTANCE.getLoopVariable();

		/**
		 * The meta object literal for the '<em><b>Owning Mapping Loop</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_VARIABLE__OWNING_MAPPING_LOOP = eINSTANCE.getLoopVariable_OwningMappingLoop();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Owned Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__OWNED_PARAMETERS = eINSTANCE.getMapping_OwnedParameters();

		/**
		 * The meta object literal for the '<em><b>Owned Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__OWNED_STATEMENTS = eINSTANCE.getMapping_OwnedStatements();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl <em>Mapping Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingCall()
		 * @generated
		 */
		EClass MAPPING_CALL = eINSTANCE.getMappingCall();

		/**
		 * The meta object literal for the '<em><b>Referred Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL__REFERRED_MAPPING = eINSTANCE.getMappingCall_ReferredMapping();

		/**
		 * The meta object literal for the '<em><b>Binding</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL__BINDING = eINSTANCE.getMappingCall_Binding();

		/**
		 * The meta object literal for the '<em><b>Is Infinite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL__IS_INFINITE = eINSTANCE.getMappingCall_IsInfinite();

		/**
		 * The meta object literal for the '<em><b>Is Install</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL__IS_INSTALL = eINSTANCE.getMappingCall_IsInstall();

		/**
		 * The meta object literal for the '<em><b>Is Invoke</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL__IS_INVOKE = eINSTANCE.getMappingCall_IsInvoke();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl <em>Mapping Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingLoop()
		 * @generated
		 */
		EClass MAPPING_LOOP = eINSTANCE.getMappingLoop();

		/**
		 * The meta object literal for the '<em><b>Owned Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP__OWNED_ITERATORS = eINSTANCE.getMappingLoop_OwnedIterators();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP__OWNED_MAPPING_STATEMENTS = eINSTANCE.getMappingLoop_OwnedMappingStatements();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP__OWNED_EXPRESSION = eINSTANCE.getMappingLoop_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterImpl <em>Mapping Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingParameter()
		 * @generated
		 */
		EClass MAPPING_PARAMETER = eINSTANCE.getMappingParameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl <em>Mapping Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingParameterBinding()
		 * @generated
		 */
		EClass MAPPING_PARAMETER_BINDING = eINSTANCE.getMappingParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Mapping Call</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARAMETER_BINDING__MAPPING_CALL = eINSTANCE.getMappingParameterBinding_MappingCall();

		/**
		 * The meta object literal for the '<em><b>Bound Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_PARAMETER_BINDING__BOUND_VARIABLE = eINSTANCE.getMappingParameterBinding_BoundVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl <em>Mapping Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingStatement()
		 * @generated
		 */
		EClass MAPPING_STATEMENT = eINSTANCE.getMappingStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl <em>New Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getNewStatement()
		 * @generated
		 */
		EClass NEW_STATEMENT = eINSTANCE.getNewStatement();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_STATEMENT__REFERRED_TYPED_MODEL = eINSTANCE.getNewStatement_ReferredTypedModel();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getNewStatement_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ObservableStatementImpl <em>Observable Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ObservableStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getObservableStatement()
		 * @generated
		 */
		EClass OBSERVABLE_STATEMENT = eINSTANCE.getObservableStatement();

		/**
		 * The meta object literal for the '<em><b>Observed Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBSERVABLE_STATEMENT__OBSERVED_PROPERTIES = eINSTANCE.getObservableStatement_ObservedProperties();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl <em>Set Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSetStatement()
		 * @generated
		 */
		EClass SET_STATEMENT = eINSTANCE.getSetStatement();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT__TARGET_VARIABLE = eINSTANCE.getSetStatement_TargetVariable();

		/**
		 * The meta object literal for the '<em><b>Target Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT__TARGET_PROPERTY = eINSTANCE.getSetStatement_TargetProperty();

		/**
		 * The meta object literal for the '<em><b>Is Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_STATEMENT__IS_OPPOSITE = eINSTANCE.getSetStatement_IsOpposite();

		/**
		 * The meta object literal for the '<em><b>Is Notify</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_STATEMENT__IS_NOTIFY = eINSTANCE.getSetStatement_IsNotify();

		/**
		 * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT__OWNED_EXPRESSION = eINSTANCE.getSetStatement_OwnedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterImpl <em>Simple Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSimpleParameter()
		 * @generated
		 */
		EClass SIMPLE_PARAMETER = eINSTANCE.getSimpleParameter();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PARAMETER__REFERRED_TYPED_MODEL = eINSTANCE.getSimpleParameter_ReferredTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterBindingImpl <em>Simple Parameter Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SimpleParameterBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSimpleParameterBinding()
		 * @generated
		 */
		EClass SIMPLE_PARAMETER_BINDING = eINSTANCE.getSimpleParameterBinding();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE_PARAMETER_BINDING__VALUE = eINSTANCE.getSimpleParameterBinding_Value();

		/**
		 * The meta object literal for the '<em><b>Is Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIMPLE_PARAMETER_BINDING__IS_CHECK = eINSTANCE.getSimpleParameterBinding_IsCheck();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.StatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.VariableStatementImpl <em>Variable Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.VariableStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getVariableStatement()
		 * @generated
		 */
		EClass VARIABLE_STATEMENT = eINSTANCE.getVariableStatement();

	}

} //QVTimperativePackage
