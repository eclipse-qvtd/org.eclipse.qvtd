/*******************************************************************************
 * Copyright (c) 2011, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtrelation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.eclipse.qvtd.pivot.qvtrelation.QVTrelationFactory
 * @model kind="package"
 * @generated
 */
public interface QVTrelationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvtrelation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTrelation";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvtr";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.qvtd.qvtrelation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")@NonNull QVTrelationPackage eINSTANCE = org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.DomainPatternImpl <em>Domain Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.DomainPatternImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getDomainPattern()
	 * @generated
	 */
	int DOMAIN_PATTERN = 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN__ANNOTATING_COMMENTS = QVTbasePackage.PATTERN__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN__OWNED_ANNOTATIONS = QVTbasePackage.PATTERN__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN__OWNED_COMMENTS = QVTbasePackage.PATTERN__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN__OWNED_EXTENSIONS = QVTbasePackage.PATTERN__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN__PREDICATE = QVTbasePackage.PATTERN__PREDICATE;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN__BINDS_TO = QVTbasePackage.PATTERN__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Relation Domain</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN__RELATION_DOMAIN = QVTbasePackage.PATTERN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN__TEMPLATE_EXPRESSION = QVTbasePackage.PATTERN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Domain Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_FEATURE_COUNT = QVTbasePackage.PATTERN_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN___ALL_OWNED_ELEMENTS = QVTbasePackage.PATTERN___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN___GET_VALUE__TYPE_STRING = QVTbasePackage.PATTERN___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Domain Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_OPERATION_COUNT = QVTbasePackage.PATTERN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl <em>Key</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getKey()
	 * @generated
	 */
	int KEY = 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__IDENTIFIES = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opposite Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__OPPOSITE_PART = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__PART = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__TRANSFORMATION = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Identifies Is Not Abstract</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___VALIDATE_IDENTIFIES_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Identifies Is AUsed Package Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___VALIDATE_IDENTIFIES_IS_AUSED_PACKAGE_CLASS__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate No Super Keys</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___VALIDATE_NO_SUPER_KEYS__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Identifies Is Unique</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___VALIDATE_IDENTIFIES_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 3;

	/**
	 * The operation id for the '<em>Validate Opposite Parts Have Opposites</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___VALIDATE_OPPOSITE_PARTS_HAVE_OPPOSITES__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 4;

	/**
	 * The operation id for the '<em>Validate Opposite Parts Are Opposite Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___VALIDATE_OPPOSITE_PARTS_ARE_OPPOSITE_PARTS__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 5;

	/**
	 * The operation id for the '<em>Validate Parts Are Parts</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___VALIDATE_PARTS_ARE_PARTS__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 6;

	/**
	 * The operation id for the '<em>Validate Parts Are Unique</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY___VALIDATE_PARTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 7;

	/**
	 * The number of operations of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__ANNOTATING_COMMENTS = QVTbasePackage.RULE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OWNED_ANNOTATIONS = QVTbasePackage.RULE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OWNED_COMMENTS = QVTbasePackage.RULE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OWNED_EXTENSIONS = QVTbasePackage.RULE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__NAME = QVTbasePackage.RULE__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__DOMAIN = QVTbasePackage.RULE__DOMAIN;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__IS_ABSTRACT = QVTbasePackage.RULE__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OVERRIDDEN = QVTbasePackage.RULE__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OVERRIDES = QVTbasePackage.RULE__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TRANSFORMATION = QVTbasePackage.RULE__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Is Top Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__IS_TOP_LEVEL = QVTbasePackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operational Impl</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OPERATIONAL_IMPL = QVTbasePackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__VARIABLE = QVTbasePackage.RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>When</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__WHEN = QVTbasePackage.RULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Where</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__WHERE = QVTbasePackage.RULE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = QVTbasePackage.RULE_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___ALL_OWNED_ELEMENTS = QVTbasePackage.RULE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___GET_VALUE__TYPE_STRING = QVTbasePackage.RULE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Domain Name Is Unique</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___VALIDATE_DOMAIN_NAME_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE___VALIDATE_DOMAIN_NAME_IS_UNIQUE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Overrides Cycle</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___VALIDATE_NO_OVERRIDES_CYCLE__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE___VALIDATE_NO_OVERRIDES_CYCLE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Overriding Rule Overrides All Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___VALIDATE_OVERRIDING_RULE_OVERRIDES_ALL_DOMAINS__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE___VALIDATE_OVERRIDING_RULE_OVERRIDES_ALL_DOMAINS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Domains Are Relation Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___VALIDATE_DOMAINS_ARE_RELATION_DOMAINS__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Top Relation Overridden By Top Relation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___VALIDATE_TOP_RELATION_OVERRIDDEN_BY_TOP_RELATION__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Transformation Is Relational Transformation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION___VALIDATE_TRANSFORMATION_IS_RELATIONAL_TRANSFORMATION__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_OPERATION_COUNT = QVTbasePackage.RULE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl <em>Relation Call Exp</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationCallExp()
	 * @generated
	 */
	int RELATION_CALL_EXP = 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__ANNOTATING_COMMENTS = PivotPackage.OCL_EXPRESSION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__OWNED_ANNOTATIONS = PivotPackage.OCL_EXPRESSION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__OWNED_COMMENTS = PivotPackage.OCL_EXPRESSION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__OWNED_EXTENSIONS = PivotPackage.OCL_EXPRESSION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__NAME = PivotPackage.OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__IS_MANY = PivotPackage.OCL_EXPRESSION__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__IS_REQUIRED = PivotPackage.OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__TYPE = PivotPackage.OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__TYPE_VALUE = PivotPackage.OCL_EXPRESSION__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Argument</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__ARGUMENT = PivotPackage.OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP__REFERRED_RELATION = PivotPackage.OCL_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Relation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP_FEATURE_COUNT = PivotPackage.OCL_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP___ALL_OWNED_ELEMENTS = PivotPackage.OCL_EXPRESSION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP___GET_VALUE__TYPE_STRING = PivotPackage.OCL_EXPRESSION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP___COMPATIBLE_BODY__VALUESPECIFICATION = PivotPackage.OCL_EXPRESSION___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Is Non Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP___IS_NON_NULL = PivotPackage.OCL_EXPRESSION___IS_NON_NULL;

	/**
	 * The operation id for the '<em>Is Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP___IS_NULL = PivotPackage.OCL_EXPRESSION___IS_NULL;

	/**
	 * The operation id for the '<em>Validate Type Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.OCL_EXPRESSION___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Matching Argument Count</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP___VALIDATE_MATCHING_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP = PivotPackage.OCL_EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Where Invocation Is ANon Top Relation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP___VALIDATE_WHERE_INVOCATION_IS_ANON_TOP_RELATION__DIAGNOSTICCHAIN_MAP = PivotPackage.OCL_EXPRESSION_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Relation Call Exp</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CALL_EXP_OPERATION_COUNT = PivotPackage.OCL_EXPRESSION_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl <em>Relation Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationDomain()
	 * @generated
	 */
	int RELATION_DOMAIN = 4;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__ANNOTATING_COMMENTS = QVTbasePackage.DOMAIN__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__OWNED_ANNOTATIONS = QVTbasePackage.DOMAIN__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__OWNED_COMMENTS = QVTbasePackage.DOMAIN__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__OWNED_EXTENSIONS = QVTbasePackage.DOMAIN__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__NAME = QVTbasePackage.DOMAIN__NAME;

	/**
	 * The feature id for the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__IS_CHECKABLE = QVTbasePackage.DOMAIN__IS_CHECKABLE;

	/**
	 * The feature id for the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__IS_ENFORCEABLE = QVTbasePackage.DOMAIN__IS_ENFORCEABLE;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__RULE = QVTbasePackage.DOMAIN__RULE;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__TYPED_MODEL = QVTbasePackage.DOMAIN__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Default Assignment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__DEFAULT_ASSIGNMENT = QVTbasePackage.DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__PATTERN = QVTbasePackage.DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Root Variable</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN__ROOT_VARIABLE = QVTbasePackage.DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relation Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_FEATURE_COUNT = QVTbasePackage.DOMAIN_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN___ALL_OWNED_ELEMENTS = QVTbasePackage.DOMAIN___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN___GET_VALUE__TYPE_STRING = QVTbasePackage.DOMAIN___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN___GET_REFERRED_ELEMENT = QVTbasePackage.DOMAIN___GET_REFERRED_ELEMENT;

	/**
	 * The operation id for the '<em>Validate Name Is Typed Model Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN___VALIDATE_NAME_IS_TYPED_MODEL_NAME__DIAGNOSTICCHAIN_MAP = QVTbasePackage.DOMAIN___VALIDATE_NAME_IS_TYPED_MODEL_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Typed Model Is Transformation Model Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN___VALIDATE_TYPED_MODEL_IS_TRANSFORMATION_MODEL_PARAMETER__DIAGNOSTICCHAIN_MAP = QVTbasePackage.DOMAIN___VALIDATE_TYPED_MODEL_IS_TRANSFORMATION_MODEL_PARAMETER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Relation Domain Assignments Are Unique</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN___VALIDATE_RELATION_DOMAIN_ASSIGNMENTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = QVTbasePackage.DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Relation Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_OPERATION_COUNT = QVTbasePackage.DOMAIN_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl <em>Relation Domain Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationDomainAssignment()
	 * @generated
	 */
	int RELATION_DOMAIN_ASSIGNMENT = 5;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT__OWNER = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT__VARIABLE = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relation Domain Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Compatible Type For Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Relation Domain Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationModelImpl <em>Relation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationModel()
	 * @generated
	 */
	int RELATION_MODEL = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl <em>Relation Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationImplementation()
	 * @generated
	 */
	int RELATION_IMPLEMENTATION = 6;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Impl</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION__IMPL = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>In Direction Of</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION__IN_DIRECTION_OF = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION__RELATION = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relation Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Relation Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_IMPLEMENTATION_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__ANNOTATING_COMMENTS = QVTbasePackage.BASE_MODEL__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__OWNED_ANNOTATIONS = QVTbasePackage.BASE_MODEL__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__OWNED_COMMENTS = QVTbasePackage.BASE_MODEL__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__OWNED_EXTENSIONS = QVTbasePackage.BASE_MODEL__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__NAME = QVTbasePackage.BASE_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__OWNED_CONSTRAINTS = QVTbasePackage.BASE_MODEL__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__EXTERNAL_URI = QVTbasePackage.BASE_MODEL__EXTERNAL_URI;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__OWNED_IMPORTS = QVTbasePackage.BASE_MODEL__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__OWNED_PACKAGES = QVTbasePackage.BASE_MODEL__OWNED_PACKAGES;

	/**
	 * The feature id for the '<em><b>Xmiid Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL__XMIID_VERSION = QVTbasePackage.BASE_MODEL__XMIID_VERSION;

	/**
	 * The number of structural features of the '<em>Relation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL_FEATURE_COUNT = QVTbasePackage.BASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL___ALL_OWNED_ELEMENTS = QVTbasePackage.BASE_MODEL___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL___GET_VALUE__TYPE_STRING = QVTbasePackage.BASE_MODEL___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Relation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL_OPERATION_COUNT = QVTbasePackage.BASE_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationalTransformationImpl <em>Relational Transformation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationalTransformationImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationalTransformation()
	 * @generated
	 */
	int RELATIONAL_TRANSFORMATION = 8;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__ANNOTATING_COMMENTS = QVTbasePackage.TRANSFORMATION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_ANNOTATIONS = QVTbasePackage.TRANSFORMATION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_COMMENTS = QVTbasePackage.TRANSFORMATION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_EXTENSIONS = QVTbasePackage.TRANSFORMATION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__NAME = QVTbasePackage.TRANSFORMATION__NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_CONSTRAINTS = QVTbasePackage.TRANSFORMATION__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Owned Bindings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_BINDINGS = QVTbasePackage.TRANSFORMATION__OWNED_BINDINGS;

	/**
	 * The feature id for the '<em><b>Owned Signature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_SIGNATURE = QVTbasePackage.TRANSFORMATION__OWNED_SIGNATURE;

	/**
	 * The feature id for the '<em><b>Unspecialized Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__UNSPECIALIZED_ELEMENT = QVTbasePackage.TRANSFORMATION__UNSPECIALIZED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Extenders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__EXTENDERS = QVTbasePackage.TRANSFORMATION__EXTENDERS;

	/**
	 * The feature id for the '<em><b>Instance Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__INSTANCE_CLASS_NAME = QVTbasePackage.TRANSFORMATION__INSTANCE_CLASS_NAME;

	/**
	 * The feature id for the '<em><b>Is Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__IS_ABSTRACT = QVTbasePackage.TRANSFORMATION__IS_ABSTRACT;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__IS_ACTIVE = QVTbasePackage.TRANSFORMATION__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Is Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__IS_INTERFACE = QVTbasePackage.TRANSFORMATION__IS_INTERFACE;

	/**
	 * The feature id for the '<em><b>Owned Behaviors</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_BEHAVIORS = QVTbasePackage.TRANSFORMATION__OWNED_BEHAVIORS;

	/**
	 * The feature id for the '<em><b>Owned Invariants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_INVARIANTS = QVTbasePackage.TRANSFORMATION__OWNED_INVARIANTS;

	/**
	 * The feature id for the '<em><b>Owned Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_OPERATIONS = QVTbasePackage.TRANSFORMATION__OWNED_OPERATIONS;

	/**
	 * The feature id for the '<em><b>Owned Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_PROPERTIES = QVTbasePackage.TRANSFORMATION__OWNED_PROPERTIES;

	/**
	 * The feature id for the '<em><b>Owning Package</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNING_PACKAGE = QVTbasePackage.TRANSFORMATION__OWNING_PACKAGE;

	/**
	 * The feature id for the '<em><b>Super Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__SUPER_CLASSES = QVTbasePackage.TRANSFORMATION__SUPER_CLASSES;

	/**
	 * The feature id for the '<em><b>Owned Tag</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_TAG = QVTbasePackage.TRANSFORMATION__OWNED_TAG;

	/**
	 * The feature id for the '<em><b>Model Parameter</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__MODEL_PARAMETER = QVTbasePackage.TRANSFORMATION__MODEL_PARAMETER;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__RULE = QVTbasePackage.TRANSFORMATION__RULE;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__EXTENDS = QVTbasePackage.TRANSFORMATION__EXTENDS;

	/**
	 * The feature id for the '<em><b>Owned Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_CONTEXT = QVTbasePackage.TRANSFORMATION__OWNED_CONTEXT;

	/**
	 * The feature id for the '<em><b>Owned Key</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION__OWNED_KEY = QVTbasePackage.TRANSFORMATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Relational Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION_FEATURE_COUNT = QVTbasePackage.TRANSFORMATION_FEATURE_COUNT + 1;


	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___ALL_OWNED_ELEMENTS = QVTbasePackage.TRANSFORMATION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___GET_VALUE__TYPE_STRING = QVTbasePackage.TRANSFORMATION___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Flattened Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___FLATTENED_TYPE = QVTbasePackage.TRANSFORMATION___FLATTENED_TYPE;

	/**
	 * The operation id for the '<em>Is Class</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___IS_CLASS = QVTbasePackage.TRANSFORMATION___IS_CLASS;

	/**
	 * The operation id for the '<em>Is Template Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___IS_TEMPLATE_PARAMETER = QVTbasePackage.TRANSFORMATION___IS_TEMPLATE_PARAMETER;

	/**
	 * The operation id for the '<em>Specialize In</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___SPECIALIZE_IN__CALLEXP_TYPE = QVTbasePackage.TRANSFORMATION___SPECIALIZE_IN__CALLEXP_TYPE;

	/**
	 * The operation id for the '<em>Validate Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = QVTbasePackage.TRANSFORMATION___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Unique Invariant Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP = QVTbasePackage.TRANSFORMATION___VALIDATE_UNIQUE_INVARIANT_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Get Function</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___GET_FUNCTION__STRING = QVTbasePackage.TRANSFORMATION___GET_FUNCTION__STRING;

	/**
	 * The operation id for the '<em>Get Model Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___GET_MODEL_PARAMETER__STRING = QVTbasePackage.TRANSFORMATION___GET_MODEL_PARAMETER__STRING;

	/**
	 * The operation id for the '<em>Validate Context Type Is Transformation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___VALIDATE_CONTEXT_TYPE_IS_TRANSFORMATION__DIAGNOSTICCHAIN_MAP = QVTbasePackage.TRANSFORMATION___VALIDATE_CONTEXT_TYPE_IS_TRANSFORMATION__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Extended Typed Model Is Extended</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___VALIDATE_EXTENDED_TYPED_MODEL_IS_EXTENDED__DIAGNOSTICCHAIN_MAP = QVTbasePackage.TRANSFORMATION___VALIDATE_EXTENDED_TYPED_MODEL_IS_EXTENDED__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Model Parameter Is Unique</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___VALIDATE_MODEL_PARAMETER_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = QVTbasePackage.TRANSFORMATION___VALIDATE_MODEL_PARAMETER_IS_UNIQUE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate No Extends Cycle</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___VALIDATE_NO_EXTENDS_CYCLE__DIAGNOSTICCHAIN_MAP = QVTbasePackage.TRANSFORMATION___VALIDATE_NO_EXTENDS_CYCLE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Rules Are Relations</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION___VALIDATE_RULES_ARE_RELATIONS__DIAGNOSTICCHAIN_MAP = QVTbasePackage.TRANSFORMATION_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Relational Transformation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_TRANSFORMATION_OPERATION_COUNT = QVTbasePackage.TRANSFORMATION_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.SharedVariableImpl <em>Shared Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.SharedVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getSharedVariable()
	 * @generated
	 */
	int SHARED_VARIABLE = 9;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__ANNOTATING_COMMENTS = PivotPackage.VARIABLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__OWNED_ANNOTATIONS = PivotPackage.VARIABLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__OWNED_COMMENTS = PivotPackage.VARIABLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__OWNED_EXTENSIONS = PivotPackage.VARIABLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__NAME = PivotPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__IS_MANY = PivotPackage.VARIABLE__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__IS_REQUIRED = PivotPackage.VARIABLE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__TYPE = PivotPackage.VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__TYPE_VALUE = PivotPackage.VARIABLE__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__IS_IMPLICIT = PivotPackage.VARIABLE__IS_IMPLICIT;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__OWNED_INIT = PivotPackage.VARIABLE__OWNED_INIT;

	/**
	 * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__REPRESENTED_PARAMETER = PivotPackage.VARIABLE__REPRESENTED_PARAMETER;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE__TYPED_MODEL = PivotPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shared Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE_FEATURE_COUNT = PivotPackage.VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE___ALL_OWNED_ELEMENTS = PivotPackage.VARIABLE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE___GET_VALUE__TYPE_STRING = PivotPackage.VARIABLE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION = PivotPackage.VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Validate Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Compatible Type For Initializer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE___VALIDATE_COMPATIBLE_TYPE_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Compatible Nullity For Initializer</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE___VALIDATE_COMPATIBLE_NULLITY_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The number of operations of the '<em>Shared Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_VARIABLE_OPERATION_COUNT = PivotPackage.VARIABLE_OPERATION_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.TemplateVariableImpl <em>Template Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.TemplateVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getTemplateVariable()
	 * @generated
	 */
	int TEMPLATE_VARIABLE = 10;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__ANNOTATING_COMMENTS = PivotPackage.VARIABLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__OWNED_ANNOTATIONS = PivotPackage.VARIABLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__OWNED_COMMENTS = PivotPackage.VARIABLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__OWNED_EXTENSIONS = PivotPackage.VARIABLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__NAME = PivotPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__IS_MANY = PivotPackage.VARIABLE__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__IS_REQUIRED = PivotPackage.VARIABLE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__TYPE = PivotPackage.VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__TYPE_VALUE = PivotPackage.VARIABLE__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__IS_IMPLICIT = PivotPackage.VARIABLE__IS_IMPLICIT;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__OWNED_INIT = PivotPackage.VARIABLE__OWNED_INIT;

	/**
	 * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE__REPRESENTED_PARAMETER = PivotPackage.VARIABLE__REPRESENTED_PARAMETER;

	/**
	 * The number of structural features of the '<em>Template Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_FEATURE_COUNT = PivotPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE___ALL_OWNED_ELEMENTS = PivotPackage.VARIABLE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE___GET_VALUE__TYPE_STRING = PivotPackage.VARIABLE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION = PivotPackage.VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Validate Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Template Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_VARIABLE_OPERATION_COUNT = PivotPackage.VARIABLE_OPERATION_COUNT + 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern <em>Domain Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.DomainPattern
	 * @generated
	 */
	EClass getDomainPattern();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getRelationDomain <em>Relation Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Relation Domain</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getRelationDomain()
	 * @see #getDomainPattern()
	 * @generated
	 */
	EReference getDomainPattern_RelationDomain();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getTemplateExpression <em>Template Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Template Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.DomainPattern#getTemplateExpression()
	 * @see #getDomainPattern()
	 * @generated
	 */
	EReference getDomainPattern_TemplateExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.Key <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key
	 * @generated
	 */
	EClass getKey();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getIdentifies <em>Identifies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifies</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getIdentifies()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_Identifies();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getPart <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getPart()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_Part();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getTransformation()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_Transformation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsNotAbstract(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Identifies Is Not Abstract</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Identifies Is Not Abstract</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsNotAbstract(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsAUsedPackageClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Identifies Is AUsed Package Class</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Identifies Is AUsed Package Class</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsAUsedPackageClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateIdentifiesIsAUsedPackageClass__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateNoSuperKeys(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate No Super Keys</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate No Super Keys</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateNoSuperKeys(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateNoSuperKeys__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Identifies Is Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Identifies Is Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateIdentifiesIsUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateIdentifiesIsUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateOppositePartsHaveOpposites(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Opposite Parts Have Opposites</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Opposite Parts Have Opposites</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateOppositePartsHaveOpposites(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateOppositePartsHaveOpposites__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validateOppositePartsAreOppositeParts(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Opposite Parts Are Opposite Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Opposite Parts Are Opposite Parts</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validateOppositePartsAreOppositeParts(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidateOppositePartsAreOppositeParts__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validatePartsAreParts(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Parts Are Parts</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Parts Are Parts</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validatePartsAreParts(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidatePartsAreParts__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#validatePartsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Parts Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Parts Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#validatePartsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getKey__ValidatePartsAreUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.Key#getOppositePart <em>Opposite Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Opposite Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Key#getOppositePart()
	 * @see #getKey()
	 * @generated
	 */
	EReference getKey_OppositePart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#isIsTopLevel <em>Is Top Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Top Level</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#isIsTopLevel()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_IsTopLevel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getOperationalImpl <em>Operational Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operational Impl</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#getOperationalImpl()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_OperationalImpl();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#getVariable()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhen <em>When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>When</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhen()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_When();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhere <em>Where</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Where</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#getWhere()
	 * @see #getRelation()
	 * @generated
	 */
	EReference getRelation_Where();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#validateDomainsAreRelationDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Domains Are Relation Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Domains Are Relation Domains</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#validateDomainsAreRelationDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelation__ValidateDomainsAreRelationDomains__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#validateTopRelationOverriddenByTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Top Relation Overridden By Top Relation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Top Relation Overridden By Top Relation</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#validateTopRelationOverriddenByTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelation__ValidateTopRelationOverriddenByTopRelation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.Relation#validateTransformationIsRelationalTransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Transformation Is Relational Transformation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Transformation Is Relational Transformation</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.Relation#validateTransformationIsRelationalTransformation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelation__ValidateTransformationIsRelationalTransformation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp <em>Relation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Call Exp</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp
	 * @generated
	 */
	EClass getRelationCallExp();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getArgument <em>Argument</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Argument</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getArgument()
	 * @see #getRelationCallExp()
	 * @generated
	 */
	EReference getRelationCallExp_Argument();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Relation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#getReferredRelation()
	 * @see #getRelationCallExp()
	 * @generated
	 */
	EReference getRelationCallExp_ReferredRelation();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateMatchingArgumentCount(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Matching Argument Count</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Matching Argument Count</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateMatchingArgumentCount(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationCallExp__ValidateMatchingArgumentCount__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateWhereInvocationIsANonTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Where Invocation Is ANon Top Relation</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Where Invocation Is ANon Top Relation</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp#validateWhereInvocationIsANonTopRelation(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationCallExp__ValidateWhereInvocationIsANonTopRelation__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain <em>Relation Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Domain</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain
	 * @generated
	 */
	EClass getRelationDomain();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getDefaultAssignment <em>Default Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Default Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getDefaultAssignment()
	 * @see #getRelationDomain()
	 * @generated
	 */
	EReference getRelationDomain_DefaultAssignment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getPattern <em>Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getPattern()
	 * @see #getRelationDomain()
	 * @generated
	 */
	EReference getRelationDomain_Pattern();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getRootVariable <em>Root Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#getRootVariable()
	 * @see #getRelationDomain()
	 * @generated
	 */
	EReference getRelationDomain_RootVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#validateRelationDomainAssignmentsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Relation Domain Assignments Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Relation Domain Assignments Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomain#validateRelationDomainAssignmentsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationDomain__ValidateRelationDomainAssignmentsAreUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment <em>Relation Domain Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Domain Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment
	 * @generated
	 */
	EClass getRelationDomainAssignment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owner</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getOwner()
	 * @see #getRelationDomainAssignment()
	 * @generated
	 */
	EReference getRelationDomainAssignment_Owner();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getValueExp <em>Value Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Exp</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getValueExp()
	 * @see #getRelationDomainAssignment()
	 * @generated
	 */
	EReference getRelationDomainAssignment_ValueExp();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#getVariable()
	 * @see #getRelationDomainAssignment()
	 * @generated
	 */
	EReference getRelationDomainAssignment_Variable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationDomainAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationModel <em>Relation Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationModel
	 * @generated
	 */
	EClass getRelationModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation <em>Relation Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Implementation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation
	 * @generated
	 */
	EClass getRelationImplementation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getImpl <em>Impl</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Impl</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getImpl()
	 * @see #getRelationImplementation()
	 * @generated
	 */
	EReference getRelationImplementation_Impl();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getInDirectionOf <em>In Direction Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>In Direction Of</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getInDirectionOf()
	 * @see #getRelationImplementation()
	 * @generated
	 */
	EReference getRelationImplementation_InDirectionOf();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Relation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationImplementation#getRelation()
	 * @see #getRelationImplementation()
	 * @generated
	 */
	EReference getRelationImplementation_Relation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation <em>Relational Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation
	 * @generated
	 */
	EClass getRelationalTransformation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#getOwnedKey <em>Owned Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Key</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#getOwnedKey()
	 * @see #getRelationalTransformation()
	 * @generated
	 */
	EReference getRelationalTransformation_OwnedKey();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#validateRulesAreRelations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Rules Are Relations</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Rules Are Relations</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation#validateRulesAreRelations(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelationalTransformation__ValidateRulesAreRelations__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable <em>Shared Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.SharedVariable
	 * @generated
	 */
	EClass getSharedVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#getTypedModel()
	 * @see #getSharedVariable()
	 * @generated
	 */
	EReference getSharedVariable_TypedModel();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Initializer</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#validateCompatibleTypeForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSharedVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#validateCompatibleNullityForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Nullity For Initializer</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Nullity For Initializer</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.SharedVariable#validateCompatibleNullityForInitializer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getSharedVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable <em>Template Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable
	 * @generated
	 */
	EClass getTemplateVariable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTrelationFactory getQVTrelationFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.DomainPatternImpl <em>Domain Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.DomainPatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getDomainPattern()
		 * @generated
		 */
		EClass DOMAIN_PATTERN = eINSTANCE.getDomainPattern();

		/**
		 * The meta object literal for the '<em><b>Relation Domain</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_PATTERN__RELATION_DOMAIN = eINSTANCE.getDomainPattern_RelationDomain();

		/**
		 * The meta object literal for the '<em><b>Template Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOMAIN_PATTERN__TEMPLATE_EXPRESSION = eINSTANCE.getDomainPattern_TemplateExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl <em>Key</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.KeyImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getKey()
		 * @generated
		 */
		EClass KEY = eINSTANCE.getKey();

		/**
		 * The meta object literal for the '<em><b>Identifies</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__IDENTIFIES = eINSTANCE.getKey_Identifies();

		/**
		 * The meta object literal for the '<em><b>Part</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__PART = eINSTANCE.getKey_Part();

		/**
		 * The meta object literal for the '<em><b>Transformation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__TRANSFORMATION = eINSTANCE.getKey_Transformation();

		/**
		 * The meta object literal for the '<em><b>Validate Identifies Is Not Abstract</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_IDENTIFIES_IS_NOT_ABSTRACT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateIdentifiesIsNotAbstract__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Identifies Is AUsed Package Class</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_IDENTIFIES_IS_AUSED_PACKAGE_CLASS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateIdentifiesIsAUsedPackageClass__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate No Super Keys</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_NO_SUPER_KEYS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateNoSuperKeys__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Identifies Is Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_IDENTIFIES_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateIdentifiesIsUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Opposite Parts Have Opposites</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_OPPOSITE_PARTS_HAVE_OPPOSITES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateOppositePartsHaveOpposites__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Opposite Parts Are Opposite Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_OPPOSITE_PARTS_ARE_OPPOSITE_PARTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidateOppositePartsAreOppositeParts__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Parts Are Parts</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_PARTS_ARE_PARTS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidatePartsAreParts__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Parts Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation KEY___VALIDATE_PARTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getKey__ValidatePartsAreUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Opposite Part</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY__OPPOSITE_PART = eINSTANCE.getKey_OppositePart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Is Top Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__IS_TOP_LEVEL = eINSTANCE.getRelation_IsTopLevel();

		/**
		 * The meta object literal for the '<em><b>Operational Impl</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__OPERATIONAL_IMPL = eINSTANCE.getRelation_OperationalImpl();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__VARIABLE = eINSTANCE.getRelation_Variable();

		/**
		 * The meta object literal for the '<em><b>When</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__WHEN = eINSTANCE.getRelation_When();

		/**
		 * The meta object literal for the '<em><b>Where</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION__WHERE = eINSTANCE.getRelation_Where();

		/**
		 * The meta object literal for the '<em><b>Validate Domains Are Relation Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___VALIDATE_DOMAINS_ARE_RELATION_DOMAINS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelation__ValidateDomainsAreRelationDomains__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Top Relation Overridden By Top Relation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___VALIDATE_TOP_RELATION_OVERRIDDEN_BY_TOP_RELATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelation__ValidateTopRelationOverriddenByTopRelation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Transformation Is Relational Transformation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION___VALIDATE_TRANSFORMATION_IS_RELATIONAL_TRANSFORMATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelation__ValidateTransformationIsRelationalTransformation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl <em>Relation Call Exp</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationCallExpImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationCallExp()
		 * @generated
		 */
		EClass RELATION_CALL_EXP = eINSTANCE.getRelationCallExp();

		/**
		 * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CALL_EXP__ARGUMENT = eINSTANCE.getRelationCallExp_Argument();

		/**
		 * The meta object literal for the '<em><b>Referred Relation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_CALL_EXP__REFERRED_RELATION = eINSTANCE.getRelationCallExp_ReferredRelation();

		/**
		 * The meta object literal for the '<em><b>Validate Matching Argument Count</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_CALL_EXP___VALIDATE_MATCHING_ARGUMENT_COUNT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationCallExp__ValidateMatchingArgumentCount__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Where Invocation Is ANon Top Relation</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_CALL_EXP___VALIDATE_WHERE_INVOCATION_IS_ANON_TOP_RELATION__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationCallExp__ValidateWhereInvocationIsANonTopRelation__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl <em>Relation Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationDomain()
		 * @generated
		 */
		EClass RELATION_DOMAIN = eINSTANCE.getRelationDomain();

		/**
		 * The meta object literal for the '<em><b>Default Assignment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN__DEFAULT_ASSIGNMENT = eINSTANCE.getRelationDomain_DefaultAssignment();

		/**
		 * The meta object literal for the '<em><b>Pattern</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN__PATTERN = eINSTANCE.getRelationDomain_Pattern();

		/**
		 * The meta object literal for the '<em><b>Root Variable</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN__ROOT_VARIABLE = eINSTANCE.getRelationDomain_RootVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Relation Domain Assignments Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_DOMAIN___VALIDATE_RELATION_DOMAIN_ASSIGNMENTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationDomain__ValidateRelationDomainAssignmentsAreUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl <em>Relation Domain Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationDomainAssignment()
		 * @generated
		 */
		EClass RELATION_DOMAIN_ASSIGNMENT = eINSTANCE.getRelationDomainAssignment();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN_ASSIGNMENT__OWNER = eINSTANCE.getRelationDomainAssignment_Owner();

		/**
		 * The meta object literal for the '<em><b>Value Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP = eINSTANCE.getRelationDomainAssignment_ValueExp();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_DOMAIN_ASSIGNMENT__VARIABLE = eINSTANCE.getRelationDomainAssignment_Variable();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATION_DOMAIN_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationDomainAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationModelImpl <em>Relation Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationModel()
		 * @generated
		 */
		EClass RELATION_MODEL = eINSTANCE.getRelationModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl <em>Relation Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationImplementation()
		 * @generated
		 */
		EClass RELATION_IMPLEMENTATION = eINSTANCE.getRelationImplementation();

		/**
		 * The meta object literal for the '<em><b>Impl</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_IMPLEMENTATION__IMPL = eINSTANCE.getRelationImplementation_Impl();

		/**
		 * The meta object literal for the '<em><b>In Direction Of</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_IMPLEMENTATION__IN_DIRECTION_OF = eINSTANCE.getRelationImplementation_InDirectionOf();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATION_IMPLEMENTATION__RELATION = eINSTANCE.getRelationImplementation_Relation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationalTransformationImpl <em>Relational Transformation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationalTransformationImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationalTransformation()
		 * @generated
		 */
		EClass RELATIONAL_TRANSFORMATION = eINSTANCE.getRelationalTransformation();

		/**
		 * The meta object literal for the '<em><b>Owned Key</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_TRANSFORMATION__OWNED_KEY = eINSTANCE.getRelationalTransformation_OwnedKey();

		/**
		 * The meta object literal for the '<em><b>Validate Rules Are Relations</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation RELATIONAL_TRANSFORMATION___VALIDATE_RULES_ARE_RELATIONS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelationalTransformation__ValidateRulesAreRelations__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.SharedVariableImpl <em>Shared Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.SharedVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getSharedVariable()
		 * @generated
		 */
		EClass SHARED_VARIABLE = eINSTANCE.getSharedVariable();

		/**
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHARED_VARIABLE__TYPED_MODEL = eINSTANCE.getSharedVariable_TypedModel();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHARED_VARIABLE___VALIDATE_COMPATIBLE_TYPE_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSharedVariable__ValidateCompatibleTypeForInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Nullity For Initializer</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation SHARED_VARIABLE___VALIDATE_COMPATIBLE_NULLITY_FOR_INITIALIZER__DIAGNOSTICCHAIN_MAP = eINSTANCE.getSharedVariable__ValidateCompatibleNullityForInitializer__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.TemplateVariableImpl <em>Template Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.TemplateVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getTemplateVariable()
		 * @generated
		 */
		EClass TEMPLATE_VARIABLE = eINSTANCE.getTemplateVariable();

	}

} //QVTrelationPackage
