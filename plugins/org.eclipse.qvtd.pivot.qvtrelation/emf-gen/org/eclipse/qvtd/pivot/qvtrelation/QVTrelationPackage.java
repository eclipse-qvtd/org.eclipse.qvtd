/*******************************************************************************
 * Copyright (c) 2011, 2015 Willink Transformations and others.
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
	 * The feature id for the '<em><b>Template Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN__TEMPLATE_EXPRESSION = QVTbasePackage.PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Domain Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_PATTERN_FEATURE_COUNT = QVTbasePackage.PATTERN_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__PART = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__TRANSFORMATION = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Opposite Part</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY__OPPOSITE_PART = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Key</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__IS_DEFAULT = QVTbasePackage.RULE__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
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
	 * The feature id for the '<em><b>Overridden</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__OVERRIDDEN = QVTbasePackage.RULE__OVERRIDDEN;

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
	 * The feature id for the '<em><b>Value Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT__VALUE_EXP = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT__VARIABLE = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Relation Domain Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_DOMAIN_ASSIGNMENT_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationModelImpl <em>Relation Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationModel()
	 * @generated
	 */
	int RELATION_MODEL = 6;

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
	 * The number of structural features of the '<em>Relation Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_MODEL_FEATURE_COUNT = QVTbasePackage.BASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl <em>Relation Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationImplementationImpl
	 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationImplementation()
	 * @generated
	 */
	int RELATION_IMPLEMENTATION = 7;

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.DomainPattern <em>Domain Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.DomainPattern
	 * @generated
	 */
	EClass getDomainPattern();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment <em>Relation Domain Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Domain Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment
	 * @generated
	 */
	EClass getRelationDomainAssignment();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl <em>Relation Domain Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.RelationDomainAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtrelation.impl.QVTrelationPackageImpl#getRelationDomainAssignment()
		 * @generated
		 */
		EClass RELATION_DOMAIN_ASSIGNMENT = eINSTANCE.getRelationDomainAssignment();

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

	}

} //QVTrelationPackage
