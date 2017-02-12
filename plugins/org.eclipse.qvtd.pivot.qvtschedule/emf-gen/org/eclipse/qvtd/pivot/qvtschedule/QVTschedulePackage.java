/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory
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
	String eNS_URI = "http://www.eclipse.org/qvt/2017/QVTschedule";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "qvts";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QVTschedulePackage eINSTANCE = org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getAbstractDatum()
	 * @generated
	 */
	int ABSTRACT_DATUM = 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Produced By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__PRODUCED_BY = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Required By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__REQUIRED_BY = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__TYPED_MODEL = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl <em>Class Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getClassDatum()
	 * @generated
	 */
	int CLASS_DATUM = 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__ANNOTATING_COMMENTS = ABSTRACT_DATUM__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__OWNED_ANNOTATIONS = ABSTRACT_DATUM__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__OWNED_COMMENTS = ABSTRACT_DATUM__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__OWNED_EXTENSIONS = ABSTRACT_DATUM__OWNED_EXTENSIONS;

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
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__TYPED_MODEL = ABSTRACT_DATUM__TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Complete Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__COMPLETE_CLASS = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Property Datums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__PROPERTY_DATUMS = ABSTRACT_DATUM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Super</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SUPER = ABSTRACT_DATUM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM___ALL_OWNED_ELEMENTS = ABSTRACT_DATUM___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM___GET_VALUE__TYPE_STRING = ABSTRACT_DATUM___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_OPERATION_COUNT = ABSTRACT_DATUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionRoleImpl <em>Connection Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionRoleImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionRole()
	 * @generated
	 */
	int CONNECTION_ROLE = 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ROLE__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ROLE__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ROLE__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ROLE__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ROLE__NODE = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connection Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ROLE_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ROLE___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ROLE___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Connection Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_ROLE_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 7;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__PHASE = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__CONSTANT = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Loaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__LOADED = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>New</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__NEW = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Old</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__OLD = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Predicated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__PREDICATED = PivotPackage.ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Realized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__REALIZED = PivotPackage.ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Speculated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__SPECULATED = PivotPackage.ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Speculation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__SPECULATION = PivotPackage.ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 9;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeRoleImpl <em>Edge Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeRoleImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdgeRole()
	 * @generated
	 */
	int EDGE_ROLE = 3;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__ANNOTATING_COMMENTS = ROLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__OWNED_ANNOTATIONS = ROLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__OWNED_COMMENTS = ROLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__OWNED_EXTENSIONS = ROLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__PHASE = ROLE__PHASE;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__CONSTANT = ROLE__CONSTANT;

	/**
	 * The feature id for the '<em><b>Loaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__LOADED = ROLE__LOADED;

	/**
	 * The feature id for the '<em><b>New</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__NEW = ROLE__NEW;

	/**
	 * The feature id for the '<em><b>Old</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__OLD = ROLE__OLD;

	/**
	 * The feature id for the '<em><b>Predicated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__PREDICATED = ROLE__PREDICATED;

	/**
	 * The feature id for the '<em><b>Realized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__REALIZED = ROLE__REALIZED;

	/**
	 * The feature id for the '<em><b>Speculated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__SPECULATED = ROLE__SPECULATED;

	/**
	 * The feature id for the '<em><b>Speculation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE__SPECULATION = ROLE__SPECULATION;

	/**
	 * The number of structural features of the '<em>Edge Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE___ALL_OWNED_ELEMENTS = ROLE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE___GET_VALUE__TYPE_STRING = ROLE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Edge Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_ROLE_OPERATION_COUNT = ROLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingActionImpl <em>Mapping Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingActionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingAction()
	 * @generated
	 */
	int MAPPING_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__MAPPING = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Productions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__PRODUCTIONS = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Requisites</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__REQUISITES = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Mapping Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeRoleImpl <em>Node Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeRoleImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNodeRole()
	 * @generated
	 */
	int NODE_ROLE = 5;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__ANNOTATING_COMMENTS = ROLE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__OWNED_ANNOTATIONS = ROLE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__OWNED_COMMENTS = ROLE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__OWNED_EXTENSIONS = ROLE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Phase</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__PHASE = ROLE__PHASE;

	/**
	 * The feature id for the '<em><b>Constant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__CONSTANT = ROLE__CONSTANT;

	/**
	 * The feature id for the '<em><b>Loaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__LOADED = ROLE__LOADED;

	/**
	 * The feature id for the '<em><b>New</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__NEW = ROLE__NEW;

	/**
	 * The feature id for the '<em><b>Old</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__OLD = ROLE__OLD;

	/**
	 * The feature id for the '<em><b>Predicated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__PREDICATED = ROLE__PREDICATED;

	/**
	 * The feature id for the '<em><b>Realized</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__REALIZED = ROLE__REALIZED;

	/**
	 * The feature id for the '<em><b>Speculated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__SPECULATED = ROLE__SPECULATED;

	/**
	 * The feature id for the '<em><b>Speculation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE__SPECULATION = ROLE__SPECULATION;

	/**
	 * The number of structural features of the '<em>Node Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE_FEATURE_COUNT = ROLE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE___ALL_OWNED_ELEMENTS = ROLE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE___GET_VALUE__TYPE_STRING = ROLE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Node Role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_ROLE_OPERATION_COUNT = ROLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPropertyDatum()
	 * @generated
	 */
	int PROPERTY_DATUM = 6;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__ANNOTATING_COMMENTS = ABSTRACT_DATUM__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__OWNED_ANNOTATIONS = ABSTRACT_DATUM__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__OWNED_COMMENTS = ABSTRACT_DATUM__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__OWNED_EXTENSIONS = ABSTRACT_DATUM__OWNED_EXTENSIONS;

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
	 * The feature id for the '<em><b>Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__TYPED_MODEL = ABSTRACT_DATUM__TYPED_MODEL;

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
	 * The feature id for the '<em><b>Super</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__SUPER = ABSTRACT_DATUM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Property Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM___ALL_OWNED_ELEMENTS = ABSTRACT_DATUM___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM___GET_VALUE__TYPE_STRING = ABSTRACT_DATUM___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Property Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM_OPERATION_COUNT = ABSTRACT_DATUM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Phase <em>Phase</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Phase
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPhase()
	 * @generated
	 */
	int PHASE = 8;


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum <em>Abstract Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum
	 * @generated
	 */
	EClass getAbstractDatum();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getProducedBy <em>Produced By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Produced By</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getProducedBy()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_ProducedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getRequiredBy <em>Required By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required By</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getRequiredBy()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_RequiredBy();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getTypedModel <em>Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getTypedModel()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_TypedModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum
	 * @generated
	 */
	EClass getClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getCompleteClass <em>Complete Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Complete Class</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getCompleteClass()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_CompleteClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getPropertyDatums <em>Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Property Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getPropertyDatums()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_PropertyDatums();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getSuper()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_Super();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole <em>Connection Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
	 * @generated
	 */
	EClass getConnectionRole();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole#isNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole#isNode()
	 * @see #getConnectionRole()
	 * @generated
	 */
	EAttribute getConnectionRole_Node();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @generated
	 */
	EClass getRole();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#getPhase <em>Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Phase</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role#getPhase()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Phase();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isConstant <em>Constant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Constant</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role#isConstant()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Constant();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isLoaded <em>Loaded</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loaded</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role#isLoaded()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Loaded();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isNew <em>New</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>New</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role#isNew()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_New();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isOld <em>Old</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Old</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role#isOld()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Old();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isPredicated <em>Predicated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Predicated</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role#isPredicated()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Predicated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isRealized <em>Realized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Realized</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role#isRealized()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Realized();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isSpeculated <em>Speculated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speculated</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role#isSpeculated()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Speculated();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Role#isSpeculation <em>Speculation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speculation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role#isSpeculation()
	 * @see #getRole()
	 * @generated
	 */
	EAttribute getRole_Speculation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeRole <em>Edge Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EdgeRole
	 * @generated
	 */
	EClass getEdgeRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction <em>Mapping Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Action</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction
	 * @generated
	 */
	EClass getMappingAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getMapping()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_Mapping();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getProductions <em>Productions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Productions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getProductions()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_Productions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getRequisites <em>Requisites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requisites</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getRequisites()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_Requisites();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeRole <em>Node Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeRole
	 * @generated
	 */
	EClass getNodeRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum <em>Property Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Property Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum
	 * @generated
	 */
	EClass getPropertyDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getProperty()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_Property();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getClassDatum()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_ClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOpposite <em>Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOpposite()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_Opposite();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getSuper <em>Super</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getSuper()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_Super();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.pivot.qvtschedule.Phase <em>Phase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Phase</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Phase
	 * @generated
	 */
	EEnum getPhase();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl <em>Abstract Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.AbstractDatumImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getAbstractDatum()
		 * @generated
		 */
		EClass ABSTRACT_DATUM = eINSTANCE.getAbstractDatum();

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
		 * The meta object literal for the '<em><b>Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__TYPED_MODEL = eINSTANCE.getAbstractDatum_TypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl <em>Class Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getClassDatum()
		 * @generated
		 */
		EClass CLASS_DATUM = eINSTANCE.getClassDatum();

		/**
		 * The meta object literal for the '<em><b>Complete Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__COMPLETE_CLASS = eINSTANCE.getClassDatum_CompleteClass();

		/**
		 * The meta object literal for the '<em><b>Property Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__PROPERTY_DATUMS = eINSTANCE.getClassDatum_PropertyDatums();

		/**
		 * The meta object literal for the '<em><b>Super</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__SUPER = eINSTANCE.getClassDatum_Super();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionRoleImpl <em>Connection Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionRoleImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionRole()
		 * @generated
		 */
		EClass CONNECTION_ROLE = eINSTANCE.getConnectionRole();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONNECTION_ROLE__NODE = eINSTANCE.getConnectionRole_Node();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl <em>Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '<em><b>Phase</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__PHASE = eINSTANCE.getRole_Phase();

		/**
		 * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__CONSTANT = eINSTANCE.getRole_Constant();

		/**
		 * The meta object literal for the '<em><b>Loaded</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__LOADED = eINSTANCE.getRole_Loaded();

		/**
		 * The meta object literal for the '<em><b>New</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__NEW = eINSTANCE.getRole_New();

		/**
		 * The meta object literal for the '<em><b>Old</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__OLD = eINSTANCE.getRole_Old();

		/**
		 * The meta object literal for the '<em><b>Predicated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__PREDICATED = eINSTANCE.getRole_Predicated();

		/**
		 * The meta object literal for the '<em><b>Realized</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__REALIZED = eINSTANCE.getRole_Realized();

		/**
		 * The meta object literal for the '<em><b>Speculated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__SPECULATED = eINSTANCE.getRole_Speculated();

		/**
		 * The meta object literal for the '<em><b>Speculation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__SPECULATION = eINSTANCE.getRole_Speculation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeRoleImpl <em>Edge Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeRoleImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdgeRole()
		 * @generated
		 */
		EClass EDGE_ROLE = eINSTANCE.getEdgeRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingActionImpl <em>Mapping Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingActionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingAction()
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
		 * The meta object literal for the '<em><b>Productions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__PRODUCTIONS = eINSTANCE.getMappingAction_Productions();

		/**
		 * The meta object literal for the '<em><b>Requisites</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__REQUISITES = eINSTANCE.getMappingAction_Requisites();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeRoleImpl <em>Node Role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeRoleImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNodeRole()
		 * @generated
		 */
		EClass NODE_ROLE = eINSTANCE.getNodeRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPropertyDatum()
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
		 * The meta object literal for the '<em><b>Super</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__SUPER = eINSTANCE.getPropertyDatum_Super();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Phase <em>Phase</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.Phase
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPhase()
		 * @generated
		 */
		EEnum PHASE = eINSTANCE.getPhase();

	}

} //QVTschedulePackage
