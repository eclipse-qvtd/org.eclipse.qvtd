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
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTimperative";

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
	int IMPERATIVE_MODEL = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl <em>Mapping Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingStatement()
	 * @generated
	 */
	int MAPPING_STATEMENT = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionVariableImpl <em>Connection Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getConnectionVariable()
	 * @generated
	 */
	int CONNECTION_VARIABLE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeDomainImpl <em>Imperative Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeDomainImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeDomain()
	 * @generated
	 */
	int IMPERATIVE_DOMAIN = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl <em>Mapping Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingCall()
	 * @generated
	 */
	int MAPPING_CALL = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl <em>Mapping Call Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingCallBinding()
	 * @generated
	 */
	int MAPPING_CALL_BINDING = 15;

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
	int STATEMENT = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl <em>Add Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAddStatement()
	 * @generated
	 */
	int ADD_STATEMENT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.CheckStatementImpl <em>Check Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.CheckStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getCheckStatement()
	 * @generated
	 */
	int CHECK_STATEMENT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardVariableImpl <em>Guard Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.GuardVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getGuardVariable()
	 * @generated
	 */
	int GUARD_VARIABLE = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.IfStatementImpl <em>If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.IfStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getIfStatement()
	 * @generated
	 */
	int IF_STATEMENT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl <em>Imperative Typed Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeTypedModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeTypedModel()
	 * @generated
	 */
	int IMPERATIVE_TYPED_MODEL = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.InConnectionVariableImpl <em>In Connection Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.InConnectionVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getInConnectionVariable()
	 * @generated
	 */
	int IN_CONNECTION_VARIABLE = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.InitializeStatementImpl <em>Initialize Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.InitializeStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getInitializeStatement()
	 * @generated
	 */
	int INITIALIZE_STATEMENT = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.LoopVariableImpl <em>Loop Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.LoopVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getLoopVariable()
	 * @generated
	 */
	int LOOP_VARIABLE = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.VariableStatementImpl <em>Variable Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.VariableStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getVariableStatement()
	 * @generated
	 */
	int VARIABLE_STATEMENT = 22;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AccessStatementImpl <em>Access Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AccessStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAccessStatement()
	 * @generated
	 */
	int ACCESS_STATEMENT = 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__ANNOTATING_COMMENTS = VARIABLE_STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__OWNED_ANNOTATIONS = VARIABLE_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__OWNED_COMMENTS = VARIABLE_STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__OWNED_EXTENSIONS = VARIABLE_STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__NAME = VARIABLE_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__IS_MANY = VARIABLE_STATEMENT__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__IS_REQUIRED = VARIABLE_STATEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__TYPE = VARIABLE_STATEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__TYPE_VALUE = VARIABLE_STATEMENT__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Source Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__SOURCE_VARIABLE = VARIABLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__SOURCE_PROPERTY = VARIABLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT__IS_OPPOSITE = VARIABLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Access Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCESS_STATEMENT_FEATURE_COUNT = VARIABLE_STATEMENT_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__TARGET_VARIABLE = MAPPING_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__OWNED_INIT = MAPPING_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Enforced Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT__IS_ENFORCED_UNIQUE = MAPPING_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Add Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADD_STATEMENT_FEATURE_COUNT = MAPPING_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__ANNOTATING_COMMENTS = STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__OWNED_ANNOTATIONS = STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__OWNED_COMMENTS = STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__OWNED_EXTENSIONS = STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT__OWNED_CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.DeclareStatementImpl <em>Declare Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.DeclareStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getDeclareStatement()
	 * @generated
	 */
	int DECLARE_STATEMENT = 4;

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
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__OWNED_INIT = VARIABLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT__IS_CHECKED = VARIABLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Declare Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARE_STATEMENT_FEATURE_COUNT = VARIABLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__ANNOTATING_COMMENTS = PivotPackage.VARIABLE_DECLARATION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__OWNED_ANNOTATIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__OWNED_COMMENTS = PivotPackage.VARIABLE_DECLARATION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__OWNED_EXTENSIONS = PivotPackage.VARIABLE_DECLARATION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__NAME = PivotPackage.VARIABLE_DECLARATION__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__IS_MANY = PivotPackage.VARIABLE_DECLARATION__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__IS_REQUIRED = PivotPackage.VARIABLE_DECLARATION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__TYPE = PivotPackage.VARIABLE_DECLARATION__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__TYPE_VALUE = PivotPackage.VARIABLE_DECLARATION__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__REFERRED_TYPED_MODEL = PivotPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guard Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_FEATURE_COUNT = PivotPackage.VARIABLE_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__ANNOTATING_COMMENTS = STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__OWNED_ANNOTATIONS = STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__OWNED_COMMENTS = STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__OWNED_EXTENSIONS = STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__OWNED_CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Then Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__OWNED_THEN_STATEMENTS = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Else Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__OWNED_ELSE_STATEMENTS = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__ANNOTATING_COMMENTS = QVTbasePackage.DOMAIN__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__OWNED_ANNOTATIONS = QVTbasePackage.DOMAIN__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__OWNED_COMMENTS = QVTbasePackage.DOMAIN__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__OWNED_EXTENSIONS = QVTbasePackage.DOMAIN__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__NAME = QVTbasePackage.DOMAIN__NAME;

	/**
	 * The feature id for the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__IS_CHECKABLE = QVTbasePackage.DOMAIN__IS_CHECKABLE;

	/**
	 * The feature id for the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__IS_ENFORCEABLE = QVTbasePackage.DOMAIN__IS_ENFORCEABLE;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__RULE = QVTbasePackage.DOMAIN__RULE;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__TYPED_MODEL = QVTbasePackage.DOMAIN__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Checked Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__CHECKED_PROPERTIES = QVTbasePackage.DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN_FEATURE_COUNT = QVTbasePackage.DOMAIN_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE__ANNOTATING_COMMENTS = CONNECTION_VARIABLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE__OWNED_ANNOTATIONS = CONNECTION_VARIABLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE__OWNED_COMMENTS = CONNECTION_VARIABLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE__OWNED_EXTENSIONS = CONNECTION_VARIABLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE__NAME = CONNECTION_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE__IS_MANY = CONNECTION_VARIABLE__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE__IS_REQUIRED = CONNECTION_VARIABLE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE__TYPE = CONNECTION_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE__TYPE_VALUE = CONNECTION_VARIABLE__TYPE_VALUE;

	/**
	 * The number of structural features of the '<em>In Connection Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IN_CONNECTION_VARIABLE_FEATURE_COUNT = CONNECTION_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZE_STATEMENT__ANNOTATING_COMMENTS = STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZE_STATEMENT__OWNED_ANNOTATIONS = STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZE_STATEMENT__OWNED_COMMENTS = STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZE_STATEMENT__OWNED_EXTENSIONS = STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZE_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZE_STATEMENT__TARGET_VARIABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZE_STATEMENT__OWNED_INIT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Checked</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZE_STATEMENT__IS_CHECKED = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Initialize Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INITIALIZE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Owned Guard Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_GUARD_VARIABLES = QVTbasePackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inout Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__INOUT_VARIABLES = QVTbasePackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_STATEMENTS = QVTbasePackage.RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Checked Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CHECKED_PROPERTIES = QVTbasePackage.RULE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = QVTbasePackage.RULE_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__REFERRED_MAPPING = MAPPING_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_FEATURE_COUNT = MAPPING_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Bound Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING__BOUND_VARIABLE = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Polled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING__IS_POLLED = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping Call</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING__MAPPING_CALL = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING__VALUE = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Call Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL_BINDING_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Owned Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_ITERATORS = MAPPING_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Mapping Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_MAPPING_STATEMENTS = MAPPING_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_SOURCE = MAPPING_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_FEATURE_COUNT = MAPPING_STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl <em>New Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.NewStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getNewStatement()
	 * @generated
	 */
	int NEW_STATEMENT = 18;

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
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__REFERRED_TYPED_MODEL = VARIABLE_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT__OWNED_INIT = VARIABLE_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>New Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_STATEMENT_FEATURE_COUNT = VARIABLE_STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.OutConnectionVariableImpl <em>Out Connection Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.OutConnectionVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getOutConnectionVariable()
	 * @generated
	 */
	int OUT_CONNECTION_VARIABLE = 19;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__ANNOTATING_COMMENTS = CONNECTION_VARIABLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__OWNED_ANNOTATIONS = CONNECTION_VARIABLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__OWNED_COMMENTS = CONNECTION_VARIABLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__OWNED_EXTENSIONS = CONNECTION_VARIABLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__NAME = CONNECTION_VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__IS_MANY = CONNECTION_VARIABLE__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__IS_REQUIRED = CONNECTION_VARIABLE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__TYPE = CONNECTION_VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__TYPE_VALUE = CONNECTION_VARIABLE__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE__OWNED_INIT = CONNECTION_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Out Connection Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUT_CONNECTION_VARIABLE_FEATURE_COUNT = CONNECTION_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl <em>Set Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getSetStatement()
	 * @generated
	 */
	int SET_STATEMENT = 20;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__ANNOTATING_COMMENTS = STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__OWNED_ANNOTATIONS = STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__OWNED_COMMENTS = STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__OWNED_EXTENSIONS = STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__NAME = STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__TARGET_VARIABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__TARGET_PROPERTY = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__OWNED_INIT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__IS_OPPOSITE = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Emit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT__IS_EMIT = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Set Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 5;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement <em>Access Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Access Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AccessStatement
	 * @generated
	 */
	EClass getAccessStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#getSourceVariable <em>Source Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#getSourceVariable()
	 * @see #getAccessStatement()
	 * @generated
	 */
	EReference getAccessStatement_SourceVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#getSourceProperty <em>Source Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#getSourceProperty()
	 * @see #getAccessStatement()
	 * @generated
	 */
	EReference getAccessStatement_SourceProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#isIsOpposite <em>Is Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Opposite</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AccessStatement#isIsOpposite()
	 * @see #getAccessStatement()
	 * @generated
	 */
	EAttribute getAccessStatement_IsOpposite();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.AddStatement#getOwnedInit()
	 * @see #getAddStatement()
	 * @generated
	 */
	EReference getAddStatement_OwnedInit();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.CheckStatement <em>Check Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.CheckStatement
	 * @generated
	 */
	EClass getCheckStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.CheckStatement#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.CheckStatement#getOwnedCondition()
	 * @see #getCheckStatement()
	 * @generated
	 */
	EReference getCheckStatement_OwnedCondition();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#getOwnedInit()
	 * @see #getDeclareStatement()
	 * @generated
	 */
	EReference getDeclareStatement_OwnedInit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#isIsChecked <em>Is Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Checked</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement#isIsChecked()
	 * @see #getDeclareStatement()
	 * @generated
	 */
	EAttribute getDeclareStatement_IsChecked();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardVariable <em>Guard Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardVariable
	 * @generated
	 */
	EClass getGuardVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.GuardVariable#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.GuardVariable#getReferredTypedModel()
	 * @see #getGuardVariable()
	 * @generated
	 */
	EReference getGuardVariable_ReferredTypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.IfStatement
	 * @generated
	 */
	EClass getIfStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedCondition <em>Owned Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Condition</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedCondition()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_OwnedCondition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedThenStatements <em>Owned Then Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Then Statements</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedThenStatements()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_OwnedThenStatements();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedElseStatements <em>Owned Else Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Else Statements</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.IfStatement#getOwnedElseStatements()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_OwnedElseStatements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain <em>Imperative Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Domain</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain
	 * @generated
	 */
	EClass getImperativeDomain();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain#getCheckedProperties <em>Checked Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Checked Properties</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeDomain#getCheckedProperties()
	 * @see #getImperativeDomain()
	 * @generated
	 */
	EReference getImperativeDomain_CheckedProperties();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.InConnectionVariable <em>In Connection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>In Connection Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.InConnectionVariable
	 * @generated
	 */
	EClass getInConnectionVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement <em>Initialize Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Initialize Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement
	 * @generated
	 */
	EClass getInitializeStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement#getTargetVariable()
	 * @see #getInitializeStatement()
	 * @generated
	 */
	EReference getInitializeStatement_TargetVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement#getOwnedInit()
	 * @see #getInitializeStatement()
	 * @generated
	 */
	EReference getInitializeStatement_OwnedInit();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement#isIsChecked <em>Is Checked</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Checked</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.InitializeStatement#isIsChecked()
	 * @see #getInitializeStatement()
	 * @generated
	 */
	EAttribute getInitializeStatement_IsChecked();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedGuardVariables <em>Owned Guard Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Guard Variables</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getOwnedGuardVariables()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_OwnedGuardVariables();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getInoutVariables <em>Inout Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inout Variables</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getInoutVariables()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_InoutVariables();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getCheckedProperties <em>Checked Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Checked Properties</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getCheckedProperties()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_CheckedProperties();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding <em>Mapping Call Binding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Call Binding</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding
	 * @generated
	 */
	EClass getMappingCallBinding();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getMappingCall <em>Mapping Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Mapping Call</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getMappingCall()
	 * @see #getMappingCallBinding()
	 * @generated
	 */
	EReference getMappingCallBinding_MappingCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getBoundVariable <em>Bound Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bound Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getBoundVariable()
	 * @see #getMappingCallBinding()
	 * @generated
	 */
	EReference getMappingCallBinding_BoundVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#isIsPolled <em>Is Polled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Polled</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#isIsPolled()
	 * @see #getMappingCallBinding()
	 * @generated
	 */
	EAttribute getMappingCallBinding_IsPolled();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding#getValue()
	 * @see #getMappingCallBinding()
	 * @generated
	 */
	EReference getMappingCallBinding_Value();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedSource <em>Owned Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Source</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedSource()
	 * @see #getMappingLoop()
	 * @generated
	 */
	EReference getMappingLoop_OwnedSource();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.NewStatement#getOwnedInit()
	 * @see #getNewStatement()
	 * @generated
	 */
	EReference getNewStatement_OwnedInit();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable <em>Out Connection Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Out Connection Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable
	 * @generated
	 */
	EClass getOutConnectionVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.OutConnectionVariable#getOwnedInit()
	 * @see #getOutConnectionVariable()
	 * @generated
	 */
	EReference getOutConnectionVariable_OwnedInit();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getOwnedInit <em>Owned Init</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Init</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#getOwnedInit()
	 * @see #getSetStatement()
	 * @generated
	 */
	EReference getSetStatement_OwnedInit();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsEmit <em>Is Emit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Emit</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.SetStatement#isIsEmit()
	 * @see #getSetStatement()
	 * @generated
	 */
	EAttribute getSetStatement_IsEmit();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AccessStatementImpl <em>Access Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.AccessStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getAccessStatement()
		 * @generated
		 */
		EClass ACCESS_STATEMENT = eINSTANCE.getAccessStatement();

		/**
		 * The meta object literal for the '<em><b>Source Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_STATEMENT__SOURCE_VARIABLE = eINSTANCE.getAccessStatement_SourceVariable();

		/**
		 * The meta object literal for the '<em><b>Source Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACCESS_STATEMENT__SOURCE_PROPERTY = eINSTANCE.getAccessStatement_SourceProperty();

		/**
		 * The meta object literal for the '<em><b>Is Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCESS_STATEMENT__IS_OPPOSITE = eINSTANCE.getAccessStatement_IsOpposite();

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
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADD_STATEMENT__OWNED_INIT = eINSTANCE.getAddStatement_OwnedInit();

		/**
		 * The meta object literal for the '<em><b>Is Enforced Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADD_STATEMENT__IS_ENFORCED_UNIQUE = eINSTANCE.getAddStatement_IsEnforcedUnique();

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
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK_STATEMENT__OWNED_CONDITION = eINSTANCE.getCheckStatement_OwnedCondition();

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
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DECLARE_STATEMENT__OWNED_INIT = eINSTANCE.getDeclareStatement_OwnedInit();

		/**
		 * The meta object literal for the '<em><b>Is Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DECLARE_STATEMENT__IS_CHECKED = eINSTANCE.getDeclareStatement_IsChecked();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardVariableImpl <em>Guard Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.GuardVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getGuardVariable()
		 * @generated
		 */
		EClass GUARD_VARIABLE = eINSTANCE.getGuardVariable();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_VARIABLE__REFERRED_TYPED_MODEL = eINSTANCE.getGuardVariable_ReferredTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.IfStatementImpl <em>If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.IfStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getIfStatement()
		 * @generated
		 */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		/**
		 * The meta object literal for the '<em><b>Owned Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__OWNED_CONDITION = eINSTANCE.getIfStatement_OwnedCondition();

		/**
		 * The meta object literal for the '<em><b>Owned Then Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__OWNED_THEN_STATEMENTS = eINSTANCE.getIfStatement_OwnedThenStatements();

		/**
		 * The meta object literal for the '<em><b>Owned Else Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__OWNED_ELSE_STATEMENTS = eINSTANCE.getIfStatement_OwnedElseStatements();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeDomainImpl <em>Imperative Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeDomainImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeDomain()
		 * @generated
		 */
		EClass IMPERATIVE_DOMAIN = eINSTANCE.getImperativeDomain();

		/**
		 * The meta object literal for the '<em><b>Checked Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_DOMAIN__CHECKED_PROPERTIES = eINSTANCE.getImperativeDomain_CheckedProperties();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.InConnectionVariableImpl <em>In Connection Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.InConnectionVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getInConnectionVariable()
		 * @generated
		 */
		EClass IN_CONNECTION_VARIABLE = eINSTANCE.getInConnectionVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.InitializeStatementImpl <em>Initialize Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.InitializeStatementImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getInitializeStatement()
		 * @generated
		 */
		EClass INITIALIZE_STATEMENT = eINSTANCE.getInitializeStatement();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALIZE_STATEMENT__TARGET_VARIABLE = eINSTANCE.getInitializeStatement_TargetVariable();

		/**
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INITIALIZE_STATEMENT__OWNED_INIT = eINSTANCE.getInitializeStatement_OwnedInit();

		/**
		 * The meta object literal for the '<em><b>Is Checked</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INITIALIZE_STATEMENT__IS_CHECKED = eINSTANCE.getInitializeStatement_IsChecked();

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
		 * The meta object literal for the '<em><b>Owned Guard Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__OWNED_GUARD_VARIABLES = eINSTANCE.getMapping_OwnedGuardVariables();

		/**
		 * The meta object literal for the '<em><b>Inout Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__INOUT_VARIABLES = eINSTANCE.getMapping_InoutVariables();

		/**
		 * The meta object literal for the '<em><b>Owned Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__OWNED_STATEMENTS = eINSTANCE.getMapping_OwnedStatements();

		/**
		 * The meta object literal for the '<em><b>Checked Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__CHECKED_PROPERTIES = eINSTANCE.getMapping_CheckedProperties();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl <em>Mapping Call Binding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingCallBinding()
		 * @generated
		 */
		EClass MAPPING_CALL_BINDING = eINSTANCE.getMappingCallBinding();

		/**
		 * The meta object literal for the '<em><b>Mapping Call</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_BINDING__MAPPING_CALL = eINSTANCE.getMappingCallBinding_MappingCall();

		/**
		 * The meta object literal for the '<em><b>Bound Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_BINDING__BOUND_VARIABLE = eINSTANCE.getMappingCallBinding_BoundVariable();

		/**
		 * The meta object literal for the '<em><b>Is Polled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_CALL_BINDING__IS_POLLED = eINSTANCE.getMappingCallBinding_IsPolled();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_CALL_BINDING__VALUE = eINSTANCE.getMappingCallBinding_Value();

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
		 * The meta object literal for the '<em><b>Owned Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP__OWNED_SOURCE = eINSTANCE.getMappingLoop_OwnedSource();

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
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEW_STATEMENT__OWNED_INIT = eINSTANCE.getNewStatement_OwnedInit();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.OutConnectionVariableImpl <em>Out Connection Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.OutConnectionVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getOutConnectionVariable()
		 * @generated
		 */
		EClass OUT_CONNECTION_VARIABLE = eINSTANCE.getOutConnectionVariable();

		/**
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUT_CONNECTION_VARIABLE__OWNED_INIT = eINSTANCE.getOutConnectionVariable_OwnedInit();

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
		 * The meta object literal for the '<em><b>Owned Init</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SET_STATEMENT__OWNED_INIT = eINSTANCE.getSetStatement_OwnedInit();

		/**
		 * The meta object literal for the '<em><b>Is Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_STATEMENT__IS_OPPOSITE = eINSTANCE.getSetStatement_IsOpposite();

		/**
		 * The meta object literal for the '<em><b>Is Emit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SET_STATEMENT__IS_EMIT = eINSTANCE.getSetStatement_IsEmit();

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
