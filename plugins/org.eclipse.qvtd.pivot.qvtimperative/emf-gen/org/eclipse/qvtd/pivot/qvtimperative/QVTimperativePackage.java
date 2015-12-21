/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtcorebase.QVTcoreBasePackage;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionAssignmentImpl <em>Connection Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionAssignmentImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getConnectionAssignment()
	 * @generated
	 */
	int CONNECTION_ASSIGNMENT = 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ASSIGNMENT__ANNOTATING_COMMENTS = QVTcoreBasePackage.ASSIGNMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ASSIGNMENT__OWNED_ANNOTATIONS = QVTcoreBasePackage.ASSIGNMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ASSIGNMENT__OWNED_COMMENTS = QVTcoreBasePackage.ASSIGNMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ASSIGNMENT__OWNED_EXTENSIONS = QVTcoreBasePackage.ASSIGNMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ASSIGNMENT__BOTTOM_PATTERN = QVTcoreBasePackage.ASSIGNMENT__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ASSIGNMENT__VALUE = QVTcoreBasePackage.ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ASSIGNMENT__IS_DEFAULT = QVTcoreBasePackage.ASSIGNMENT__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ASSIGNMENT__TARGET_VARIABLE = QVTcoreBasePackage.ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connection Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ASSIGNMENT_FEATURE_COUNT = QVTcoreBasePackage.ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea <em>Imperative Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeArea()
	 * @generated
	 */
	int IMPERATIVE_AREA = 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_AREA__ANNOTATING_COMMENTS = QVTcoreBasePackage.AREA__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_AREA__OWNED_ANNOTATIONS = QVTcoreBasePackage.AREA__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_AREA__OWNED_COMMENTS = QVTcoreBasePackage.AREA__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_AREA__OWNED_EXTENSIONS = QVTcoreBasePackage.AREA__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_AREA__GUARD_PATTERN = QVTcoreBasePackage.AREA__GUARD_PATTERN;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_AREA__BOTTOM_PATTERN = QVTcoreBasePackage.AREA__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Checked Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_AREA__CHECKED_PROPERTIES = QVTcoreBasePackage.AREA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enforced Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_AREA__ENFORCED_PROPERTIES = QVTcoreBasePackage.AREA_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Imperative Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_AREA_FEATURE_COUNT = QVTcoreBasePackage.AREA_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeBottomPatternImpl <em>Imperative Bottom Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeBottomPatternImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeBottomPattern()
	 * @generated
	 */
	int IMPERATIVE_BOTTOM_PATTERN = 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__ANNOTATING_COMMENTS = QVTcoreBasePackage.BOTTOM_PATTERN__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__OWNED_ANNOTATIONS = QVTcoreBasePackage.BOTTOM_PATTERN__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__OWNED_COMMENTS = QVTcoreBasePackage.BOTTOM_PATTERN__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__OWNED_EXTENSIONS = QVTcoreBasePackage.BOTTOM_PATTERN__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__PREDICATE = QVTcoreBasePackage.BOTTOM_PATTERN__PREDICATE;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__BINDS_TO = QVTcoreBasePackage.BOTTOM_PATTERN__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__VARIABLE = QVTcoreBasePackage.BOTTOM_PATTERN__VARIABLE;

	/**
	 * The feature id for the '<em><b>Area</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__AREA = QVTcoreBasePackage.BOTTOM_PATTERN__AREA;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__ASSIGNMENT = QVTcoreBasePackage.BOTTOM_PATTERN__ASSIGNMENT;

	/**
	 * The feature id for the '<em><b>Enforcement Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__ENFORCEMENT_OPERATION = QVTcoreBasePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION;

	/**
	 * The feature id for the '<em><b>Realized Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__REALIZED_VARIABLE = QVTcoreBasePackage.BOTTOM_PATTERN__REALIZED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Ordered Assignment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN__ORDERED_ASSIGNMENT = QVTcoreBasePackage.BOTTOM_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Imperative Bottom Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_BOTTOM_PATTERN_FEATURE_COUNT = QVTcoreBasePackage.BOTTOM_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeDomainImpl <em>Imperative Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeDomainImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeDomain()
	 * @generated
	 */
	int IMPERATIVE_DOMAIN = 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__ANNOTATING_COMMENTS = QVTcoreBasePackage.CORE_DOMAIN__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__OWNED_ANNOTATIONS = QVTcoreBasePackage.CORE_DOMAIN__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__OWNED_COMMENTS = QVTcoreBasePackage.CORE_DOMAIN__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__OWNED_EXTENSIONS = QVTcoreBasePackage.CORE_DOMAIN__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__NAME = QVTcoreBasePackage.CORE_DOMAIN__NAME;

	/**
	 * The feature id for the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__IS_CHECKABLE = QVTcoreBasePackage.CORE_DOMAIN__IS_CHECKABLE;

	/**
	 * The feature id for the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__IS_ENFORCEABLE = QVTcoreBasePackage.CORE_DOMAIN__IS_ENFORCEABLE;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__RULE = QVTcoreBasePackage.CORE_DOMAIN__RULE;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__TYPED_MODEL = QVTcoreBasePackage.CORE_DOMAIN__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__GUARD_PATTERN = QVTcoreBasePackage.CORE_DOMAIN__GUARD_PATTERN;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__BOTTOM_PATTERN = QVTcoreBasePackage.CORE_DOMAIN__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Checked Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__CHECKED_PROPERTIES = QVTcoreBasePackage.CORE_DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enforced Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN__ENFORCED_PROPERTIES = QVTcoreBasePackage.CORE_DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Imperative Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPERATIVE_DOMAIN_FEATURE_COUNT = QVTcoreBasePackage.CORE_DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl <em>Imperative Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeModel()
	 * @generated
	 */
	int IMPERATIVE_MODEL = 4;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 5;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ANNOTATING_COMMENTS = QVTcoreBasePackage.ABSTRACT_MAPPING__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_ANNOTATIONS = QVTcoreBasePackage.ABSTRACT_MAPPING__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_COMMENTS = QVTcoreBasePackage.ABSTRACT_MAPPING__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OWNED_EXTENSIONS = QVTcoreBasePackage.ABSTRACT_MAPPING__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__NAME = QVTcoreBasePackage.ABSTRACT_MAPPING__NAME;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__DOMAIN = QVTcoreBasePackage.ABSTRACT_MAPPING__DOMAIN;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__IS_DEFAULT = QVTcoreBasePackage.ABSTRACT_MAPPING__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Overrides</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OVERRIDES = QVTcoreBasePackage.ABSTRACT_MAPPING__OVERRIDES;

	/**
	 * The feature id for the '<em><b>Transformation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TRANSFORMATION = QVTcoreBasePackage.ABSTRACT_MAPPING__TRANSFORMATION;

	/**
	 * The feature id for the '<em><b>Overridden</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__OVERRIDDEN = QVTcoreBasePackage.ABSTRACT_MAPPING__OVERRIDDEN;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__GUARD_PATTERN = QVTcoreBasePackage.ABSTRACT_MAPPING__GUARD_PATTERN;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__BOTTOM_PATTERN = QVTcoreBasePackage.ABSTRACT_MAPPING__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Checked Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CHECKED_PROPERTIES = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enforced Properties</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__ENFORCED_PROPERTIES = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__MAPPING_STATEMENT = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Polled Classes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__POLLED_CLASSES = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = QVTcoreBasePackage.ABSTRACT_MAPPING_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl <em>Mapping Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingStatementImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingStatement()
	 * @generated
	 */
	int MAPPING_STATEMENT = 10;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__ANNOTATING_COMMENTS = PivotPackage.OCL_EXPRESSION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__OWNED_ANNOTATIONS = PivotPackage.OCL_EXPRESSION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__OWNED_COMMENTS = PivotPackage.OCL_EXPRESSION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__OWNED_EXTENSIONS = PivotPackage.OCL_EXPRESSION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__NAME = PivotPackage.OCL_EXPRESSION__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__IS_MANY = PivotPackage.OCL_EXPRESSION__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__IS_REQUIRED = PivotPackage.OCL_EXPRESSION__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__TYPE = PivotPackage.OCL_EXPRESSION__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT__TYPE_VALUE = PivotPackage.OCL_EXPRESSION__TYPE_VALUE;

	/**
	 * The number of structural features of the '<em>Mapping Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_STATEMENT_FEATURE_COUNT = PivotPackage.OCL_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl <em>Mapping Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingCall()
	 * @generated
	 */
	int MAPPING_CALL = 6;

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
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__IS_MANY = MAPPING_STATEMENT__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__IS_REQUIRED = MAPPING_STATEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__TYPE = MAPPING_STATEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_CALL__TYPE_VALUE = MAPPING_STATEMENT__TYPE_VALUE;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl <em>Mapping Call Binding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingCallBinding()
	 * @generated
	 */
	int MAPPING_CALL_BINDING = 7;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl <em>Mapping Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingLoopImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingLoop()
	 * @generated
	 */
	int MAPPING_LOOP = 8;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__ANNOTATING_COMMENTS = PivotPackage.CALL_EXP__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_ANNOTATIONS = PivotPackage.CALL_EXP__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_COMMENTS = PivotPackage.CALL_EXP__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_EXTENSIONS = PivotPackage.CALL_EXP__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__NAME = PivotPackage.CALL_EXP__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__IS_MANY = PivotPackage.CALL_EXP__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__IS_REQUIRED = PivotPackage.CALL_EXP__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__TYPE = PivotPackage.CALL_EXP__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__TYPE_VALUE = PivotPackage.CALL_EXP__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__IS_IMPLICIT = PivotPackage.CALL_EXP__IS_IMPLICIT;

	/**
	 * The feature id for the '<em><b>Is Safe</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__IS_SAFE = PivotPackage.CALL_EXP__IS_SAFE;

	/**
	 * The feature id for the '<em><b>Owned Source</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_SOURCE = PivotPackage.CALL_EXP__OWNED_SOURCE;

	/**
	 * The feature id for the '<em><b>Owned Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_BODY = PivotPackage.CALL_EXP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Iterators</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP__OWNED_ITERATORS = PivotPackage.CALL_EXP_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Mapping Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_LOOP_FEATURE_COUNT = PivotPackage.CALL_EXP_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingSequenceImpl <em>Mapping Sequence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingSequenceImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingSequence()
	 * @generated
	 */
	int MAPPING_SEQUENCE = 9;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__ANNOTATING_COMMENTS = MAPPING_STATEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__OWNED_ANNOTATIONS = MAPPING_STATEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__OWNED_COMMENTS = MAPPING_STATEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__OWNED_EXTENSIONS = MAPPING_STATEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__NAME = MAPPING_STATEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__IS_MANY = MAPPING_STATEMENT__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__IS_REQUIRED = MAPPING_STATEMENT__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__TYPE = MAPPING_STATEMENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__TYPE_VALUE = MAPPING_STATEMENT__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Mapping Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE__MAPPING_STATEMENTS = MAPPING_STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Sequence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_SEQUENCE_FEATURE_COUNT = MAPPING_STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.VariablePredicateImpl <em>Variable Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.VariablePredicateImpl
	 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getVariablePredicate()
	 * @generated
	 */
	int VARIABLE_PREDICATE = 11;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PREDICATE__ANNOTATING_COMMENTS = QVTbasePackage.PREDICATE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PREDICATE__OWNED_ANNOTATIONS = QVTbasePackage.PREDICATE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PREDICATE__OWNED_COMMENTS = QVTbasePackage.PREDICATE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PREDICATE__OWNED_EXTENSIONS = QVTbasePackage.PREDICATE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Condition Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PREDICATE__CONDITION_EXPRESSION = QVTbasePackage.PREDICATE__CONDITION_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PREDICATE__PATTERN = QVTbasePackage.PREDICATE__PATTERN;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PREDICATE__TARGET_VARIABLE = QVTbasePackage.PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_PREDICATE_FEATURE_COUNT = QVTbasePackage.PREDICATE_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment <em>Connection Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment
	 * @generated
	 */
	EClass getConnectionAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment#getTargetVariable()
	 * @see #getConnectionAssignment()
	 * @generated
	 */
	EReference getConnectionAssignment_TargetVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea <em>Imperative Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Area</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea
	 * @generated
	 */
	EClass getImperativeArea();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea#getCheckedProperties <em>Checked Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Checked Properties</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea#getCheckedProperties()
	 * @see #getImperativeArea()
	 * @generated
	 */
	EReference getImperativeArea_CheckedProperties();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea#getEnforcedProperties <em>Enforced Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Enforced Properties</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea#getEnforcedProperties()
	 * @see #getImperativeArea()
	 * @generated
	 */
	EReference getImperativeArea_EnforcedProperties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern <em>Imperative Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern
	 * @generated
	 */
	EClass getImperativeBottomPattern();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern#getOrderedAssignment <em>Ordered Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Ordered Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeBottomPattern#getOrderedAssignment()
	 * @see #getImperativeBottomPattern()
	 * @generated
	 */
	EReference getImperativeBottomPattern_OrderedAssignment();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel <em>Imperative Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Imperative Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeModel
	 * @generated
	 */
	EClass getImperativeModel();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getMappingStatement <em>Mapping Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Mapping Statement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getMappingStatement()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_MappingStatement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.Mapping#getPolledClasses <em>Polled Classes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Polled Classes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.Mapping#getPolledClasses()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_PolledClasses();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedBody <em>Owned Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Body</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingLoop#getOwnedBody()
	 * @see #getMappingLoop()
	 * @generated
	 */
	EReference getMappingLoop_OwnedBody();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingSequence <em>Mapping Sequence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Sequence</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingSequence
	 * @generated
	 */
	EClass getMappingSequence();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtimperative.MappingSequence#getMappingStatements <em>Mapping Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping Statements</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.MappingSequence#getMappingStatements()
	 * @see #getMappingSequence()
	 * @generated
	 */
	EReference getMappingSequence_MappingStatements();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate <em>Variable Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Predicate</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate
	 * @generated
	 */
	EClass getVariablePredicate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtimperative.VariablePredicate#getTargetVariable()
	 * @see #getVariablePredicate()
	 * @generated
	 */
	EReference getVariablePredicate_TargetVariable();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionAssignmentImpl <em>Connection Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getConnectionAssignment()
		 * @generated
		 */
		EClass CONNECTION_ASSIGNMENT = eINSTANCE.getConnectionAssignment();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION_ASSIGNMENT__TARGET_VARIABLE = eINSTANCE.getConnectionAssignment_TargetVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea <em>Imperative Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.ImperativeArea
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeArea()
		 * @generated
		 */
		EClass IMPERATIVE_AREA = eINSTANCE.getImperativeArea();

		/**
		 * The meta object literal for the '<em><b>Checked Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_AREA__CHECKED_PROPERTIES = eINSTANCE.getImperativeArea_CheckedProperties();

		/**
		 * The meta object literal for the '<em><b>Enforced Properties</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_AREA__ENFORCED_PROPERTIES = eINSTANCE.getImperativeArea_EnforcedProperties();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeBottomPatternImpl <em>Imperative Bottom Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeBottomPatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeBottomPattern()
		 * @generated
		 */
		EClass IMPERATIVE_BOTTOM_PATTERN = eINSTANCE.getImperativeBottomPattern();

		/**
		 * The meta object literal for the '<em><b>Ordered Assignment</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPERATIVE_BOTTOM_PATTERN__ORDERED_ASSIGNMENT = eINSTANCE.getImperativeBottomPattern_OrderedAssignment();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl <em>Imperative Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.ImperativeModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getImperativeModel()
		 * @generated
		 */
		EClass IMPERATIVE_MODEL = eINSTANCE.getImperativeModel();

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
		 * The meta object literal for the '<em><b>Mapping Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__MAPPING_STATEMENT = eINSTANCE.getMapping_MappingStatement();

		/**
		 * The meta object literal for the '<em><b>Polled Classes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__POLLED_CLASSES = eINSTANCE.getMapping_PolledClasses();

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
		 * The meta object literal for the '<em><b>Owned Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP__OWNED_BODY = eINSTANCE.getMappingLoop_OwnedBody();

		/**
		 * The meta object literal for the '<em><b>Owned Iterators</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_LOOP__OWNED_ITERATORS = eINSTANCE.getMappingLoop_OwnedIterators();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingSequenceImpl <em>Mapping Sequence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.MappingSequenceImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getMappingSequence()
		 * @generated
		 */
		EClass MAPPING_SEQUENCE = eINSTANCE.getMappingSequence();

		/**
		 * The meta object literal for the '<em><b>Mapping Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_SEQUENCE__MAPPING_STATEMENTS = eINSTANCE.getMappingSequence_MappingStatements();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtimperative.impl.VariablePredicateImpl <em>Variable Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.VariablePredicateImpl
		 * @see org.eclipse.qvtd.pivot.qvtimperative.impl.QVTimperativePackageImpl#getVariablePredicate()
		 * @generated
		 */
		EClass VARIABLE_PREDICATE = eINSTANCE.getVariablePredicate();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_PREDICATE__TARGET_VARIABLE = eINSTANCE.getVariablePredicate_TargetVariable();

	}

} //QVTimperativePackage
