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
package org.eclipse.qvtd.pivot.qvtcore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.qvtd.pivot.qvtcore.QVTcoreFactory
 * @model kind="package"
 * @generated
 */
public interface QVTcorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNAME = "qvtcore";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2015/QVTcore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvtc";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.qvtd.qvtcore";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("null")@NonNull QVTcorePackage eINSTANCE = org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.Area <em>Area</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getArea()
	 * @generated
	 */
	int AREA = 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__GUARD_PATTERN = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA__BOTTOM_PATTERN = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Area</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AREA_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.AssignmentImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__BOTTOM_PATTERN = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VALUE = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__IS_DEFAULT = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CorePatternImpl <em>Core Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CorePatternImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCorePattern()
	 * @generated
	 */
	int CORE_PATTERN = 6;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__ANNOTATING_COMMENTS = QVTbasePackage.PATTERN__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__OWNED_ANNOTATIONS = QVTbasePackage.PATTERN__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__OWNED_COMMENTS = QVTbasePackage.PATTERN__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__OWNED_EXTENSIONS = QVTbasePackage.PATTERN__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__PREDICATE = QVTbasePackage.PATTERN__PREDICATE;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__BINDS_TO = QVTbasePackage.PATTERN__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN__VARIABLE = QVTbasePackage.PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Core Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN_FEATURE_COUNT = QVTbasePackage.PATTERN_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN___ALL_OWNED_ELEMENTS = QVTbasePackage.PATTERN___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN___GET_VALUE__TYPE_STRING = QVTbasePackage.PATTERN___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Area</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN___GET_AREA = QVTbasePackage.PATTERN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Core Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_PATTERN_OPERATION_COUNT = QVTbasePackage.PATTERN_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl <em>Bottom Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getBottomPattern()
	 * @generated
	 */
	int BOTTOM_PATTERN = 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__ANNOTATING_COMMENTS = CORE_PATTERN__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__OWNED_ANNOTATIONS = CORE_PATTERN__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__OWNED_COMMENTS = CORE_PATTERN__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__OWNED_EXTENSIONS = CORE_PATTERN__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__PREDICATE = CORE_PATTERN__PREDICATE;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__BINDS_TO = CORE_PATTERN__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__VARIABLE = CORE_PATTERN__VARIABLE;

	/**
	 * The feature id for the '<em><b>Area</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__AREA = CORE_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Assignment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__ASSIGNMENT = CORE_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enforcement Operation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__ENFORCEMENT_OPERATION = CORE_PATTERN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Realized Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN__REALIZED_VARIABLE = CORE_PATTERN_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Bottom Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_FEATURE_COUNT = CORE_PATTERN_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN___ALL_OWNED_ELEMENTS = CORE_PATTERN___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN___GET_VALUE__TYPE_STRING = CORE_PATTERN___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Area</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN___GET_AREA = CORE_PATTERN___GET_AREA;

	/**
	 * The operation id for the '<em>Validate Variables Are Bottom Variables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN___VALIDATE_VARIABLES_ARE_BOTTOM_VARIABLES__DIAGNOSTICCHAIN_MAP = CORE_PATTERN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Bottom Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_PATTERN_OPERATION_COUNT = CORE_PATTERN_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomVariableImpl <em>Bottom Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.BottomVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getBottomVariable()
	 * @generated
	 */
	int BOTTOM_VARIABLE = 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__ANNOTATING_COMMENTS = PivotPackage.VARIABLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__OWNED_ANNOTATIONS = PivotPackage.VARIABLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__OWNED_COMMENTS = PivotPackage.VARIABLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__OWNED_EXTENSIONS = PivotPackage.VARIABLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__NAME = PivotPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__IS_MANY = PivotPackage.VARIABLE__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__IS_REQUIRED = PivotPackage.VARIABLE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__TYPE = PivotPackage.VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__TYPE_VALUE = PivotPackage.VARIABLE__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__IS_IMPLICIT = PivotPackage.VARIABLE__IS_IMPLICIT;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__OWNED_INIT = PivotPackage.VARIABLE__OWNED_INIT;

	/**
	 * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE__REPRESENTED_PARAMETER = PivotPackage.VARIABLE__REPRESENTED_PARAMETER;

	/**
	 * The number of structural features of the '<em>Bottom Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE_FEATURE_COUNT = PivotPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE___ALL_OWNED_ELEMENTS = PivotPackage.VARIABLE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE___GET_VALUE__TYPE_STRING = PivotPackage.VARIABLE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION = PivotPackage.VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Validate Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Bottom Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOTTOM_VARIABLE_OPERATION_COUNT = PivotPackage.VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CoreDomainImpl <em>Core Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CoreDomainImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCoreDomain()
	 * @generated
	 */
	int CORE_DOMAIN = 4;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__ANNOTATING_COMMENTS = QVTbasePackage.DOMAIN__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__OWNED_ANNOTATIONS = QVTbasePackage.DOMAIN__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__OWNED_COMMENTS = QVTbasePackage.DOMAIN__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__OWNED_EXTENSIONS = QVTbasePackage.DOMAIN__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__NAME = QVTbasePackage.DOMAIN__NAME;

	/**
	 * The feature id for the '<em><b>Is Checkable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__IS_CHECKABLE = QVTbasePackage.DOMAIN__IS_CHECKABLE;

	/**
	 * The feature id for the '<em><b>Is Enforceable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__IS_ENFORCEABLE = QVTbasePackage.DOMAIN__IS_ENFORCEABLE;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__RULE = QVTbasePackage.DOMAIN__RULE;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__TYPED_MODEL = QVTbasePackage.DOMAIN__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__GUARD_PATTERN = QVTbasePackage.DOMAIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN__BOTTOM_PATTERN = QVTbasePackage.DOMAIN_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Core Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN_FEATURE_COUNT = QVTbasePackage.DOMAIN_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN___ALL_OWNED_ELEMENTS = QVTbasePackage.DOMAIN___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN___GET_VALUE__TYPE_STRING = QVTbasePackage.DOMAIN___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Referred Element</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN___GET_REFERRED_ELEMENT = QVTbasePackage.DOMAIN___GET_REFERRED_ELEMENT;

	/**
	 * The operation id for the '<em>Validate Name Is Typed Model Name</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN___VALIDATE_NAME_IS_TYPED_MODEL_NAME__DIAGNOSTICCHAIN_MAP = QVTbasePackage.DOMAIN___VALIDATE_NAME_IS_TYPED_MODEL_NAME__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Typed Model Is Transformation Model Parameter</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN___VALIDATE_TYPED_MODEL_IS_TRANSFORMATION_MODEL_PARAMETER__DIAGNOSTICCHAIN_MAP = QVTbasePackage.DOMAIN___VALIDATE_TYPED_MODEL_IS_TRANSFORMATION_MODEL_PARAMETER__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Core Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_DOMAIN_OPERATION_COUNT = QVTbasePackage.DOMAIN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl <em>Core Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCoreModel()
	 * @generated
	 */
	int CORE_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__ANNOTATING_COMMENTS = QVTbasePackage.BASE_MODEL__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_ANNOTATIONS = QVTbasePackage.BASE_MODEL__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_COMMENTS = QVTbasePackage.BASE_MODEL__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_EXTENSIONS = QVTbasePackage.BASE_MODEL__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__NAME = QVTbasePackage.BASE_MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_CONSTRAINTS = QVTbasePackage.BASE_MODEL__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__EXTERNAL_URI = QVTbasePackage.BASE_MODEL__EXTERNAL_URI;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_IMPORTS = QVTbasePackage.BASE_MODEL__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL__OWNED_PACKAGES = QVTbasePackage.BASE_MODEL__OWNED_PACKAGES;

	/**
	 * The number of structural features of the '<em>Core Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL_FEATURE_COUNT = QVTbasePackage.BASE_MODEL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL___ALL_OWNED_ELEMENTS = QVTbasePackage.BASE_MODEL___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL___GET_VALUE__TYPE_STRING = QVTbasePackage.BASE_MODEL___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Core Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CORE_MODEL_OPERATION_COUNT = QVTbasePackage.BASE_MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.EnforcementOperationImpl <em>Enforcement Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.EnforcementOperationImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getEnforcementOperation()
	 * @generated
	 */
	int ENFORCEMENT_OPERATION = 7;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Enforcement Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__ENFORCEMENT_MODE = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__BOTTOM_PATTERN = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Call Exp</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION__OPERATION_CALL_EXP = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Enforcement Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Enforcement Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENFORCEMENT_OPERATION_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.GuardPatternImpl <em>Guard Pattern</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.GuardPatternImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getGuardPattern()
	 * @generated
	 */
	int GUARD_PATTERN = 8;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__ANNOTATING_COMMENTS = CORE_PATTERN__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__OWNED_ANNOTATIONS = CORE_PATTERN__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__OWNED_COMMENTS = CORE_PATTERN__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__OWNED_EXTENSIONS = CORE_PATTERN__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__PREDICATE = CORE_PATTERN__PREDICATE;

	/**
	 * The feature id for the '<em><b>Binds To</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__BINDS_TO = CORE_PATTERN__BINDS_TO;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__VARIABLE = CORE_PATTERN__VARIABLE;

	/**
	 * The feature id for the '<em><b>Area</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN__AREA = CORE_PATTERN_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Guard Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_FEATURE_COUNT = CORE_PATTERN_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN___ALL_OWNED_ELEMENTS = CORE_PATTERN___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN___GET_VALUE__TYPE_STRING = CORE_PATTERN___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Area</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN___GET_AREA = CORE_PATTERN___GET_AREA;

	/**
	 * The operation id for the '<em>Validate Variables Are Guard Variables</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN___VALIDATE_VARIABLES_ARE_GUARD_VARIABLES__DIAGNOSTICCHAIN_MAP = CORE_PATTERN_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Guard Pattern</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_PATTERN_OPERATION_COUNT = CORE_PATTERN_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.GuardVariableImpl <em>Guard Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.GuardVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getGuardVariable()
	 * @generated
	 */
	int GUARD_VARIABLE = 9;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__ANNOTATING_COMMENTS = PivotPackage.VARIABLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__OWNED_ANNOTATIONS = PivotPackage.VARIABLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__OWNED_COMMENTS = PivotPackage.VARIABLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__OWNED_EXTENSIONS = PivotPackage.VARIABLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__NAME = PivotPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__IS_MANY = PivotPackage.VARIABLE__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__IS_REQUIRED = PivotPackage.VARIABLE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__TYPE = PivotPackage.VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__TYPE_VALUE = PivotPackage.VARIABLE__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__IS_IMPLICIT = PivotPackage.VARIABLE__IS_IMPLICIT;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__OWNED_INIT = PivotPackage.VARIABLE__OWNED_INIT;

	/**
	 * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE__REPRESENTED_PARAMETER = PivotPackage.VARIABLE__REPRESENTED_PARAMETER;

	/**
	 * The number of structural features of the '<em>Guard Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_FEATURE_COUNT = PivotPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE___ALL_OWNED_ELEMENTS = PivotPackage.VARIABLE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE___GET_VALUE__TYPE_STRING = PivotPackage.VARIABLE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION = PivotPackage.VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Validate Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Guard Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GUARD_VARIABLE_OPERATION_COUNT = PivotPackage.VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 10;

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
	 * The feature id for the '<em><b>Guard Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__GUARD_PATTERN = QVTbasePackage.RULE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__BOTTOM_PATTERN = QVTbasePackage.RULE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__CONTEXT = QVTbasePackage.RULE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Local</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__LOCAL = QVTbasePackage.RULE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Refinement</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__REFINEMENT = QVTbasePackage.RULE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SPECIFICATION = QVTbasePackage.RULE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = QVTbasePackage.RULE_FEATURE_COUNT + 6;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___ALL_OWNED_ELEMENTS = QVTbasePackage.RULE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___GET_VALUE__TYPE_STRING = QVTbasePackage.RULE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Domain Name Is Unique</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_DOMAIN_NAME_IS_UNIQUE__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE___VALIDATE_DOMAIN_NAME_IS_UNIQUE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Overrides Rule Is Extended Rule</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_OVERRIDES_RULE_IS_EXTENDED_RULE__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE___VALIDATE_OVERRIDES_RULE_IS_EXTENDED_RULE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Overrides Rule Overrides All Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_OVERRIDES_RULE_OVERRIDES_ALL_DOMAINS__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE___VALIDATE_OVERRIDES_RULE_OVERRIDES_ALL_DOMAINS__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Domains Are Core Domains</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_DOMAINS_ARE_CORE_DOMAINS__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Nested Name Is Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_NESTED_NAME_IS_NULL__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Root Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING___VALIDATE_ROOT_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = QVTbasePackage.RULE_OPERATION_COUNT + 2;

	/**
	 * The number of operations of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_OPERATION_COUNT = QVTbasePackage.RULE_OPERATION_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.NavigationAssignmentImpl <em>Navigation Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.NavigationAssignmentImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getNavigationAssignment()
	 * @generated
	 */
	int NAVIGATION_ASSIGNMENT = 11;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT__ANNOTATING_COMMENTS = ASSIGNMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT__OWNED_ANNOTATIONS = ASSIGNMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT__OWNED_COMMENTS = ASSIGNMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT__OWNED_EXTENSIONS = ASSIGNMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT__BOTTOM_PATTERN = ASSIGNMENT__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT__VALUE = ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT__IS_DEFAULT = ASSIGNMENT__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Slot Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT__SLOT_EXPRESSION = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Navigation Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT___ALL_OWNED_ELEMENTS = ASSIGNMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT___GET_VALUE__TYPE_STRING = ASSIGNMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Navigation Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_ASSIGNMENT_OPERATION_COUNT = ASSIGNMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.OppositePropertyAssignmentImpl <em>Opposite Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.OppositePropertyAssignmentImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getOppositePropertyAssignment()
	 * @generated
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT = 12;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT__ANNOTATING_COMMENTS = NAVIGATION_ASSIGNMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT__OWNED_ANNOTATIONS = NAVIGATION_ASSIGNMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT__OWNED_COMMENTS = NAVIGATION_ASSIGNMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT__OWNED_EXTENSIONS = NAVIGATION_ASSIGNMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT__BOTTOM_PATTERN = NAVIGATION_ASSIGNMENT__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT__VALUE = NAVIGATION_ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT__IS_DEFAULT = NAVIGATION_ASSIGNMENT__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Slot Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT__SLOT_EXPRESSION = NAVIGATION_ASSIGNMENT__SLOT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Target Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT__TARGET_PROPERTY = NAVIGATION_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Opposite Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT_FEATURE_COUNT = NAVIGATION_ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT___ALL_OWNED_ELEMENTS = NAVIGATION_ASSIGNMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT___GET_VALUE__TYPE_STRING = NAVIGATION_ASSIGNMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Referred Target Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Compatible Type For Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Opposite Property Is Implicit</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_OPPOSITE_PROPERTY_IS_IMPLICIT__DIAGNOSTICCHAIN_MAP = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Target Propety Is Slot Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Opposite Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPPOSITE_PROPERTY_ASSIGNMENT_OPERATION_COUNT = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.PropertyAssignmentImpl <em>Property Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.PropertyAssignmentImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getPropertyAssignment()
	 * @generated
	 */
	int PROPERTY_ASSIGNMENT = 13;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__ANNOTATING_COMMENTS = NAVIGATION_ASSIGNMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__OWNED_ANNOTATIONS = NAVIGATION_ASSIGNMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__OWNED_COMMENTS = NAVIGATION_ASSIGNMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__OWNED_EXTENSIONS = NAVIGATION_ASSIGNMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__BOTTOM_PATTERN = NAVIGATION_ASSIGNMENT__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__VALUE = NAVIGATION_ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__IS_DEFAULT = NAVIGATION_ASSIGNMENT__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Slot Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__SLOT_EXPRESSION = NAVIGATION_ASSIGNMENT__SLOT_EXPRESSION;

	/**
	 * The feature id for the '<em><b>Target Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT__TARGET_PROPERTY = NAVIGATION_ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT_FEATURE_COUNT = NAVIGATION_ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT___ALL_OWNED_ELEMENTS = NAVIGATION_ASSIGNMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT___GET_VALUE__TYPE_STRING = NAVIGATION_ASSIGNMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Get Referred Target Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 0;

	/**
	 * The operation id for the '<em>Validate Compatible Type For Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 1;

	/**
	 * The operation id for the '<em>Validate Property Is Not Implicit</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT___VALIDATE_PROPERTY_IS_NOT_IMPLICIT__DIAGNOSTICCHAIN_MAP = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 2;

	/**
	 * The operation id for the '<em>Validate Target Propety Is Slot Property</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 3;

	/**
	 * The number of operations of the '<em>Property Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_ASSIGNMENT_OPERATION_COUNT = NAVIGATION_ASSIGNMENT_OPERATION_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.RealizedVariableImpl <em>Realized Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.RealizedVariableImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getRealizedVariable()
	 * @generated
	 */
	int REALIZED_VARIABLE = 14;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__ANNOTATING_COMMENTS = PivotPackage.VARIABLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__OWNED_ANNOTATIONS = PivotPackage.VARIABLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__OWNED_COMMENTS = PivotPackage.VARIABLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__OWNED_EXTENSIONS = PivotPackage.VARIABLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__NAME = PivotPackage.VARIABLE__NAME;

	/**
	 * The feature id for the '<em><b>Is Many</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__IS_MANY = PivotPackage.VARIABLE__IS_MANY;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__IS_REQUIRED = PivotPackage.VARIABLE__IS_REQUIRED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__TYPE = PivotPackage.VARIABLE__TYPE;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__TYPE_VALUE = PivotPackage.VARIABLE__TYPE_VALUE;

	/**
	 * The feature id for the '<em><b>Is Implicit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__IS_IMPLICIT = PivotPackage.VARIABLE__IS_IMPLICIT;

	/**
	 * The feature id for the '<em><b>Owned Init</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__OWNED_INIT = PivotPackage.VARIABLE__OWNED_INIT;

	/**
	 * The feature id for the '<em><b>Represented Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE__REPRESENTED_PARAMETER = PivotPackage.VARIABLE__REPRESENTED_PARAMETER;

	/**
	 * The number of structural features of the '<em>Realized Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_FEATURE_COUNT = PivotPackage.VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE___ALL_OWNED_ELEMENTS = PivotPackage.VARIABLE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE___GET_VALUE__TYPE_STRING = PivotPackage.VARIABLE___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Compatible Body</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION = PivotPackage.VARIABLE___COMPATIBLE_BODY__VALUESPECIFICATION;

	/**
	 * The operation id for the '<em>Validate Name Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Invalid</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_INVALID__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Type Is Not Null</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_TYPE_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Compatible Initialiser Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE___VALIDATE_COMPATIBLE_INITIALISER_TYPE__DIAGNOSTICCHAIN_MAP;

	/**
	 * The operation id for the '<em>Validate Non Data Type For Type</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE___VALIDATE_NON_DATA_TYPE_FOR_TYPE__DIAGNOSTICCHAIN_MAP = PivotPackage.VARIABLE_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Realized Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REALIZED_VARIABLE_OPERATION_COUNT = PivotPackage.VARIABLE_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.VariableAssignmentImpl
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getVariableAssignment()
	 * @generated
	 */
	int VARIABLE_ASSIGNMENT = 15;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__ANNOTATING_COMMENTS = ASSIGNMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__OWNED_ANNOTATIONS = ASSIGNMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__OWNED_COMMENTS = ASSIGNMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__OWNED_EXTENSIONS = ASSIGNMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Bottom Pattern</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__BOTTOM_PATTERN = ASSIGNMENT__BOTTOM_PATTERN;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VALUE = ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Is Default</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__IS_DEFAULT = ASSIGNMENT__IS_DEFAULT;

	/**
	 * The feature id for the '<em><b>Target Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__TARGET_VARIABLE = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT___ALL_OWNED_ELEMENTS = ASSIGNMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT___GET_VALUE__TYPE_STRING = ASSIGNMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The operation id for the '<em>Validate Compatible Type For Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = ASSIGNMENT_OPERATION_COUNT + 0;

	/**
	 * The number of operations of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_OPERATION_COUNT = ASSIGNMENT_OPERATION_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementMode <em>Enforcement Mode</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementMode
	 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getEnforcementMode()
	 * @generated
	 */
	int ENFORCEMENT_MODE = 16;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.Area <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Area</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area
	 * @generated
	 */
	EClass getArea();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.Area#getGuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Guard Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area#getGuardPattern()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_GuardPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Area#getBottomPattern()
	 * @see #getArea()
	 * @generated
	 */
	EReference getArea_BottomPattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment#getBottomPattern()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_BottomPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtcore.Assignment#isIsDefault <em>Is Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Default</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Assignment#isIsDefault()
	 * @see #getAssignment()
	 * @generated
	 */
	EAttribute getAssignment_IsDefault();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern
	 * @generated
	 */
	EClass getBottomPattern();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Area</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getArea()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_Area();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getAssignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getAssignment()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_Assignment();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getEnforcementOperation <em>Enforcement Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Enforcement Operation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getEnforcementOperation()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_EnforcementOperation();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getRealizedVariable <em>Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Realized Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#getRealizedVariable()
	 * @see #getBottomPattern()
	 * @generated
	 */
	EReference getBottomPattern_RealizedVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.BottomPattern#validateVariablesAreBottomVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Variables Are Bottom Variables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Variables Are Bottom Variables</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomPattern#validateVariablesAreBottomVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getBottomPattern__ValidateVariablesAreBottomVariables__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.BottomVariable <em>Bottom Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bottom Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.BottomVariable
	 * @generated
	 */
	EClass getBottomVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.CoreDomain <em>Core Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Domain</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CoreDomain
	 * @generated
	 */
	EClass getCoreDomain();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.CoreModel <em>Core Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CoreModel
	 * @generated
	 */
	EClass getCoreModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.CorePattern <em>Core Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Core Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CorePattern
	 * @generated
	 */
	EClass getCorePattern();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.CorePattern#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CorePattern#getVariable()
	 * @see #getCorePattern()
	 * @generated
	 */
	EReference getCorePattern_Variable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.CorePattern#getArea() <em>Get Area</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Area</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.CorePattern#getArea()
	 * @generated
	 */
	EOperation getCorePattern__GetArea();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation <em>Enforcement Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enforcement Operation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation
	 * @generated
	 */
	EClass getEnforcementOperation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getEnforcementMode <em>Enforcement Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enforcement Mode</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getEnforcementMode()
	 * @see #getEnforcementOperation()
	 * @generated
	 */
	EAttribute getEnforcementOperation_EnforcementMode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern <em>Bottom Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Bottom Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getBottomPattern()
	 * @see #getEnforcementOperation()
	 * @generated
	 */
	EReference getEnforcementOperation_BottomPattern();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getOperationCallExp <em>Operation Call Exp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation Call Exp</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation#getOperationCallExp()
	 * @see #getEnforcementOperation()
	 * @generated
	 */
	EReference getEnforcementOperation_OperationCallExp();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.GuardPattern <em>Guard Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Pattern</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardPattern
	 * @generated
	 */
	EClass getGuardPattern();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.GuardPattern#getArea <em>Area</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Area</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardPattern#getArea()
	 * @see #getGuardPattern()
	 * @generated
	 */
	EReference getGuardPattern_Area();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.GuardPattern#validateVariablesAreGuardVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Variables Are Guard Variables</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Variables Are Guard Variables</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardPattern#validateVariablesAreGuardVariables(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getGuardPattern__ValidateVariablesAreGuardVariables__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.GuardVariable <em>Guard Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Guard Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.GuardVariable
	 * @generated
	 */
	EClass getGuardVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Context</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getContext()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Context();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Specification</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getSpecification()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Specification();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#validateDomainsAreCoreDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Domains Are Core Domains</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Domains Are Core Domains</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#validateDomainsAreCoreDomains(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateDomainsAreCoreDomains__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#validateNestedNameIsNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Nested Name Is Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Nested Name Is Null</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#validateNestedNameIsNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateNestedNameIsNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#validateRootNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Root Name Is Not Null</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Root Name Is Not Null</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#validateRootNameIsNotNull(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getMapping__ValidateRootNameIsNotNull__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment <em>Navigation Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment
	 * @generated
	 */
	EClass getNavigationAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment#getSlotExpression <em>Slot Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Slot Expression</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment#getSlotExpression()
	 * @see #getNavigationAssignment()
	 * @generated
	 */
	EReference getNavigationAssignment_SlotExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment <em>Opposite Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Opposite Property Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment
	 * @generated
	 */
	EClass getOppositePropertyAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getTargetProperty <em>Target Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getTargetProperty()
	 * @see #getOppositePropertyAssignment()
	 * @generated
	 */
	EReference getOppositePropertyAssignment_TargetProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getReferredTargetProperty() <em>Get Referred Target Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Referred Target Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#getReferredTargetProperty()
	 * @generated
	 */
	EOperation getOppositePropertyAssignment__GetReferredTargetProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOppositePropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateOppositePropertyIsImplicit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Opposite Property Is Implicit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Opposite Property Is Implicit</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateOppositePropertyIsImplicit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOppositePropertyAssignment__ValidateOppositePropertyIsImplicit__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateTargetPropetyIsSlotProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Propety Is Slot Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Propety Is Slot Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment#validateTargetPropetyIsSlotProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getOppositePropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment <em>Property Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment
	 * @generated
	 */
	EClass getPropertyAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getTargetProperty <em>Target Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getTargetProperty()
	 * @see #getPropertyAssignment()
	 * @generated
	 */
	EReference getPropertyAssignment_TargetProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getReferredTargetProperty() <em>Get Referred Target Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Referred Target Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#getReferredTargetProperty()
	 * @generated
	 */
	EOperation getPropertyAssignment__GetReferredTargetProperty();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validatePropertyIsNotImplicit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Property Is Not Implicit</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Property Is Not Implicit</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validatePropertyIsNotImplicit(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateTargetPropetyIsSlotProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Target Propety Is Slot Property</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Target Propety Is Slot Property</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment#validateTargetPropetyIsSlotProperty(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.RealizedVariable <em>Realized Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Realized Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.RealizedVariable
	 * @generated
	 */
	EClass getRealizedVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.RealizedVariable#validateNonDataTypeForType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Non Data Type For Type</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Non Data Type For Type</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.RealizedVariable#validateNonDataTypeForType(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRealizedVariable__ValidateNonDataTypeForType__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.VariableAssignment
	 * @generated
	 */
	EClass getVariableAssignment();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#getTargetVariable <em>Target Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#getTargetVariable()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EReference getVariableAssignment_TargetVariable();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Type For Value</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Type For Value</em>' operation.
	 * @see org.eclipse.qvtd.pivot.qvtcore.VariableAssignment#validateCompatibleTypeForValue(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVariableAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementMode <em>Enforcement Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enforcement Mode</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementMode
	 * @generated
	 */
	EEnum getEnforcementMode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal <em>Local</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getLocal()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Local();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement <em>Refinement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Refinement</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.Mapping#getRefinement()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Refinement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QVTcoreFactory getQVTcoreFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.Area <em>Area</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.Area
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getArea()
		 * @generated
		 */
		EClass AREA = eINSTANCE.getArea();

		/**
		 * The meta object literal for the '<em><b>Guard Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__GUARD_PATTERN = eINSTANCE.getArea_GuardPattern();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AREA__BOTTOM_PATTERN = eINSTANCE.getArea_BottomPattern();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.AssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__BOTTOM_PATTERN = eINSTANCE.getAssignment_BottomPattern();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Is Default</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT__IS_DEFAULT = eINSTANCE.getAssignment_IsDefault();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl <em>Bottom Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.BottomPatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getBottomPattern()
		 * @generated
		 */
		EClass BOTTOM_PATTERN = eINSTANCE.getBottomPattern();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__AREA = eINSTANCE.getBottomPattern_Area();

		/**
		 * The meta object literal for the '<em><b>Assignment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__ASSIGNMENT = eINSTANCE.getBottomPattern_Assignment();

		/**
		 * The meta object literal for the '<em><b>Enforcement Operation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__ENFORCEMENT_OPERATION = eINSTANCE.getBottomPattern_EnforcementOperation();

		/**
		 * The meta object literal for the '<em><b>Realized Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOTTOM_PATTERN__REALIZED_VARIABLE = eINSTANCE.getBottomPattern_RealizedVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Variables Are Bottom Variables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation BOTTOM_PATTERN___VALIDATE_VARIABLES_ARE_BOTTOM_VARIABLES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getBottomPattern__ValidateVariablesAreBottomVariables__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.BottomVariableImpl <em>Bottom Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.BottomVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getBottomVariable()
		 * @generated
		 */
		EClass BOTTOM_VARIABLE = eINSTANCE.getBottomVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CoreDomainImpl <em>Core Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CoreDomainImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCoreDomain()
		 * @generated
		 */
		EClass CORE_DOMAIN = eINSTANCE.getCoreDomain();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl <em>Core Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CoreModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCoreModel()
		 * @generated
		 */
		EClass CORE_MODEL = eINSTANCE.getCoreModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.CorePatternImpl <em>Core Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.CorePatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getCorePattern()
		 * @generated
		 */
		EClass CORE_PATTERN = eINSTANCE.getCorePattern();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CORE_PATTERN__VARIABLE = eINSTANCE.getCorePattern_Variable();

		/**
		 * The meta object literal for the '<em><b>Get Area</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation CORE_PATTERN___GET_AREA = eINSTANCE.getCorePattern__GetArea();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.EnforcementOperationImpl <em>Enforcement Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.EnforcementOperationImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getEnforcementOperation()
		 * @generated
		 */
		EClass ENFORCEMENT_OPERATION = eINSTANCE.getEnforcementOperation();

		/**
		 * The meta object literal for the '<em><b>Enforcement Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENFORCEMENT_OPERATION__ENFORCEMENT_MODE = eINSTANCE.getEnforcementOperation_EnforcementMode();

		/**
		 * The meta object literal for the '<em><b>Bottom Pattern</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCEMENT_OPERATION__BOTTOM_PATTERN = eINSTANCE.getEnforcementOperation_BottomPattern();

		/**
		 * The meta object literal for the '<em><b>Operation Call Exp</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENFORCEMENT_OPERATION__OPERATION_CALL_EXP = eINSTANCE.getEnforcementOperation_OperationCallExp();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.GuardPatternImpl <em>Guard Pattern</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.GuardPatternImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getGuardPattern()
		 * @generated
		 */
		EClass GUARD_PATTERN = eINSTANCE.getGuardPattern();

		/**
		 * The meta object literal for the '<em><b>Area</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GUARD_PATTERN__AREA = eINSTANCE.getGuardPattern_Area();

		/**
		 * The meta object literal for the '<em><b>Validate Variables Are Guard Variables</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation GUARD_PATTERN___VALIDATE_VARIABLES_ARE_GUARD_VARIABLES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getGuardPattern__ValidateVariablesAreGuardVariables__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.GuardVariableImpl <em>Guard Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.GuardVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getGuardVariable()
		 * @generated
		 */
		EClass GUARD_VARIABLE = eINSTANCE.getGuardVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.MappingImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__CONTEXT = eINSTANCE.getMapping_Context();

		/**
		 * The meta object literal for the '<em><b>Specification</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SPECIFICATION = eINSTANCE.getMapping_Specification();

		/**
		 * The meta object literal for the '<em><b>Validate Domains Are Core Domains</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_DOMAINS_ARE_CORE_DOMAINS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateDomainsAreCoreDomains__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Nested Name Is Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_NESTED_NAME_IS_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateNestedNameIsNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Root Name Is Not Null</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation MAPPING___VALIDATE_ROOT_NAME_IS_NOT_NULL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getMapping__ValidateRootNameIsNotNull__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.NavigationAssignmentImpl <em>Navigation Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.NavigationAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getNavigationAssignment()
		 * @generated
		 */
		EClass NAVIGATION_ASSIGNMENT = eINSTANCE.getNavigationAssignment();

		/**
		 * The meta object literal for the '<em><b>Slot Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_ASSIGNMENT__SLOT_EXPRESSION = eINSTANCE.getNavigationAssignment_SlotExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.OppositePropertyAssignmentImpl <em>Opposite Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.OppositePropertyAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getOppositePropertyAssignment()
		 * @generated
		 */
		EClass OPPOSITE_PROPERTY_ASSIGNMENT = eINSTANCE.getOppositePropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Target Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPPOSITE_PROPERTY_ASSIGNMENT__TARGET_PROPERTY = eINSTANCE.getOppositePropertyAssignment_TargetProperty();

		/**
		 * The meta object literal for the '<em><b>Get Referred Target Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY = eINSTANCE.getOppositePropertyAssignment__GetReferredTargetProperty();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOppositePropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Opposite Property Is Implicit</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_OPPOSITE_PROPERTY_IS_IMPLICIT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOppositePropertyAssignment__ValidateOppositePropertyIsImplicit__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Target Propety Is Slot Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation OPPOSITE_PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getOppositePropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.PropertyAssignmentImpl <em>Property Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.PropertyAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getPropertyAssignment()
		 * @generated
		 */
		EClass PROPERTY_ASSIGNMENT = eINSTANCE.getPropertyAssignment();

		/**
		 * The meta object literal for the '<em><b>Target Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_ASSIGNMENT__TARGET_PROPERTY = eINSTANCE.getPropertyAssignment_TargetProperty();

		/**
		 * The meta object literal for the '<em><b>Get Referred Target Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_ASSIGNMENT___GET_REFERRED_TARGET_PROPERTY = eINSTANCE.getPropertyAssignment__GetReferredTargetProperty();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Property Is Not Implicit</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_ASSIGNMENT___VALIDATE_PROPERTY_IS_NOT_IMPLICIT__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyAssignment__ValidatePropertyIsNotImplicit__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Target Propety Is Slot Property</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PROPERTY_ASSIGNMENT___VALIDATE_TARGET_PROPETY_IS_SLOT_PROPERTY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPropertyAssignment__ValidateTargetPropetyIsSlotProperty__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.RealizedVariableImpl <em>Realized Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.RealizedVariableImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getRealizedVariable()
		 * @generated
		 */
		EClass REALIZED_VARIABLE = eINSTANCE.getRealizedVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Non Data Type For Type</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REALIZED_VARIABLE___VALIDATE_NON_DATA_TYPE_FOR_TYPE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRealizedVariable__ValidateNonDataTypeForType__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.VariableAssignmentImpl
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getVariableAssignment()
		 * @generated
		 */
		EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Target Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ASSIGNMENT__TARGET_VARIABLE = eINSTANCE.getVariableAssignment_TargetVariable();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Type For Value</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VARIABLE_ASSIGNMENT___VALIDATE_COMPATIBLE_TYPE_FOR_VALUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVariableAssignment__ValidateCompatibleTypeForValue__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.EnforcementMode <em>Enforcement Mode</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.EnforcementMode
		 * @see org.eclipse.qvtd.pivot.qvtcore.impl.QVTcorePackageImpl#getEnforcementMode()
		 * @generated
		 */
		EEnum ENFORCEMENT_MODE = eINSTANCE.getEnforcementMode();

		/**
		 * The meta object literal for the '<em><b>Local</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__LOCAL = eINSTANCE.getMapping_Local();

		/**
		 * The meta object literal for the '<em><b>Refinement</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__REFINEMENT = eINSTANCE.getMapping_Refinement();

	}

} //QVTcorePackage
