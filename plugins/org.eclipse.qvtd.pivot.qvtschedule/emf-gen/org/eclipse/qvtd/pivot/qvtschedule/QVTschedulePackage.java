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
import org.eclipse.jdt.annotation.NonNull;
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
	@NonNull String eNAME = "qvtschedule";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_URI = "http://www.eclipse.org/qvt/2017/QVTschedule";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eNS_PREFIX = "qvts";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@NonNull String eCONTENT_TYPE = "org.eclipse.qvtd.qvtschedule";

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
	 * The feature id for the '<em><b>Produced By Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__PRODUCED_BY_ACTIONS = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__REFERRED_TYPED_MODEL = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Required By Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__REQUIRED_BY_ACTIONS = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

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
	int CLASS_DATUM = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionEnd()
	 * @generated
	 */
	int CONNECTION_END = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl <em>Datum Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDatumConnection()
	 * @generated
	 */
	int DATUM_CONNECTION = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl <em>Edge Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdgeConnection()
	 * @generated
	 */
	int EDGE_CONNECTION = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Role <em>Role</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 42;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingActionImpl <em>Mapping Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingActionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingAction()
	 * @generated
	 */
	int MAPPING_ACTION = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl <em>Navigable Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigableEdge()
	 * @generated
	 */
	int NAVIGABLE_EDGE = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNode()
	 * @generated
	 */
	int NODE = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl <em>Node Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNodeConnection()
	 * @generated
	 */
	int NODE_CONNECTION = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl <em>Operation Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationRegion()
	 * @generated
	 */
	int OPERATION_REGION = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPropertyDatum()
	 * @generated
	 */
	int PROPERTY_DATUM = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl <em>Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingRegion()
	 * @generated
	 */
	int MAPPING_REGION = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl <em>Navigation Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigationEdge()
	 * @generated
	 */
	int NAVIGATION_EDGE = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl <em>Cast Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCastEdge()
	 * @generated
	 */
	int CAST_EDGE = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDependencyNode()
	 * @generated
	 */
	int DEPENDENCY_NODE = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl <em>Error Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getErrorNode()
	 * @generated
	 */
	int ERROR_NODE = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl <em>Expression Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getExpressionEdge()
	 * @generated
	 */
	int EXPRESSION_EDGE = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl <em>Input Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getInputNode()
	 * @generated
	 */
	int INPUT_NODE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl <em>Iterated Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratedEdge()
	 * @generated
	 */
	int ITERATED_EDGE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl <em>Variable Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getVariableNode()
	 * @generated
	 */
	int VARIABLE_NODE = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl <em>Iterator Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratorNode()
	 * @generated
	 */
	int ITERATOR_NODE = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl <em>Composed Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getComposedNode()
	 * @generated
	 */
	int COMPOSED_NODE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl <em>Micro Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMicroMappingRegion()
	 * @generated
	 */
	int MICRO_MAPPING_REGION = 19;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__SYMBOL_NAME = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_EDGES = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_NODES = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNING_SCHEDULED_REGION = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__ANNOTATING_COMMENTS = REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNED_ANNOTATIONS = REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNED_COMMENTS = REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNED_EXTENSIONS = REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__SYMBOL_NAME = REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNED_EDGES = REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNED_NODES = REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNING_SCHEDULED_REGION = REGION__OWNING_SCHEDULED_REGION;

	/**
	 * The number of structural features of the '<em>Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION___ALL_OWNED_ELEMENTS = REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION___GET_VALUE__TYPE_STRING = REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION_OPERATION_COUNT = REGION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl <em>Basic Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getBasicMappingRegion()
	 * @generated
	 */
	int BASIC_MAPPING_REGION = 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__ANNOTATING_COMMENTS = MAPPING_REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__OWNED_ANNOTATIONS = MAPPING_REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__OWNED_COMMENTS = MAPPING_REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__OWNED_EXTENSIONS = MAPPING_REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__SYMBOL_NAME = MAPPING_REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__OWNED_EDGES = MAPPING_REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__OWNED_NODES = MAPPING_REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__OWNING_SCHEDULED_REGION = MAPPING_REGION__OWNING_SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__NAME = MAPPING_REGION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__REFERRED_MAPPING = MAPPING_REGION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Basic Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION_FEATURE_COUNT = MAPPING_REGION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION___ALL_OWNED_ELEMENTS = MAPPING_REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION___GET_VALUE__TYPE_STRING = MAPPING_REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Basic Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION_OPERATION_COUNT = MAPPING_REGION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__EDGE_ROLE = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NAME = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__OWNING_REGION = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE_NODE = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET_NODE = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__ANNOTATING_COMMENTS = EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__OWNED_ANNOTATIONS = EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__OWNED_COMMENTS = EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__OWNED_EXTENSIONS = EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__EDGE_ROLE = EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__NAME = EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__OWNING_REGION = EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__SOURCE_NODE = EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__TARGET_NODE = EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__INCOMING_CONNECTION = EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Opposite Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__OPPOSITE_EDGE = EDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__OUTGOING_CONNECTIONS = EDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Secondary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__SECONDARY = EDGE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Navigable Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE___ALL_OWNED_ELEMENTS = EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE___GET_VALUE__TYPE_STRING = EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Navigable Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__ANNOTATING_COMMENTS = NAVIGABLE_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__OWNED_ANNOTATIONS = NAVIGABLE_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__OWNED_COMMENTS = NAVIGABLE_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__OWNED_EXTENSIONS = NAVIGABLE_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__EDGE_ROLE = NAVIGABLE_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__NAME = NAVIGABLE_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__OWNING_REGION = NAVIGABLE_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__SOURCE_NODE = NAVIGABLE_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__TARGET_NODE = NAVIGABLE_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__INCOMING_CONNECTION = NAVIGABLE_EDGE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Opposite Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__OPPOSITE_EDGE = NAVIGABLE_EDGE__OPPOSITE_EDGE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__OUTGOING_CONNECTIONS = NAVIGABLE_EDGE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Secondary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__SECONDARY = NAVIGABLE_EDGE__SECONDARY;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__PROPERTY = NAVIGABLE_EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__REFERRED_CLASS = NAVIGABLE_EDGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Cast Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE_FEATURE_COUNT = NAVIGABLE_EDGE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE___ALL_OWNED_ELEMENTS = NAVIGABLE_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE___GET_VALUE__TYPE_STRING = NAVIGABLE_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Cast Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE_OPERATION_COUNT = NAVIGABLE_EDGE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Produced By Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__PRODUCED_BY_ACTIONS = ABSTRACT_DATUM__PRODUCED_BY_ACTIONS;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__REFERRED_TYPED_MODEL = ABSTRACT_DATUM__REFERRED_TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Required By Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__REQUIRED_BY_ACTIONS = ABSTRACT_DATUM__REQUIRED_BY_ACTIONS;

	/**
	 * The feature id for the '<em><b>Complete Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__COMPLETE_CLASS = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Property Datums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__OWNING_PROPERTY_DATUMS = ABSTRACT_DATUM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__OWNING_SCHEDULE_MODEL = ABSTRACT_DATUM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__REFERRED_CLASS = ABSTRACT_DATUM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Super Class Datums</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__SUPER_CLASS_DATUMS = ABSTRACT_DATUM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Class Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 5;

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
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CLASS_DATUM = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_CONNECTION = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_EDGES = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NODE_ROLE = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_CONNECTIONS = PivotPackage.ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_EDGES = PivotPackage.ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OWNING_REGION = PivotPackage.ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The number of structural features of the '<em>Composed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Composed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__SYMBOL_NAME = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION__OWNING_SCHEDULED_REGION = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Connection End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Connection End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_END_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION__ANNOTATING_COMMENTS = CONNECTION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION__OWNED_ANNOTATIONS = CONNECTION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION__OWNED_COMMENTS = CONNECTION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION__OWNED_EXTENSIONS = CONNECTION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION__SYMBOL_NAME = CONNECTION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION__OWNING_SCHEDULED_REGION = CONNECTION__OWNING_SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Connection Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION__CONNECTION_ROLE = CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION__NAME = CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Source Ends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION__SOURCE_ENDS = CONNECTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Datum Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION___ALL_OWNED_ELEMENTS = CONNECTION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION___GET_VALUE__TYPE_STRING = CONNECTION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Datum Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION_OPERATION_COUNT = CONNECTION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The number of structural features of the '<em>Dependency Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Dependency Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__ANNOTATING_COMMENTS = DATUM_CONNECTION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__OWNED_ANNOTATIONS = DATUM_CONNECTION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__OWNED_COMMENTS = DATUM_CONNECTION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__OWNED_EXTENSIONS = DATUM_CONNECTION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__SYMBOL_NAME = DATUM_CONNECTION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__OWNING_SCHEDULED_REGION = DATUM_CONNECTION__OWNING_SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Connection Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__CONNECTION_ROLE = DATUM_CONNECTION__CONNECTION_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__NAME = DATUM_CONNECTION__NAME;

	/**
	 * The feature id for the '<em><b>Source Ends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__SOURCE_ENDS = DATUM_CONNECTION__SOURCE_ENDS;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION__REFERRED_PROPERTY = DATUM_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Edge Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION_FEATURE_COUNT = DATUM_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION___ALL_OWNED_ELEMENTS = DATUM_CONNECTION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION___GET_VALUE__TYPE_STRING = DATUM_CONNECTION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Edge Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION_OPERATION_COUNT = DATUM_CONNECTION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The number of structural features of the '<em>Error Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Error Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__ANNOTATING_COMMENTS = EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__OWNED_ANNOTATIONS = EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__OWNED_COMMENTS = EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__OWNED_EXTENSIONS = EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__EDGE_ROLE = EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__NAME = EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__OWNING_REGION = EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__SOURCE_NODE = EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__TARGET_NODE = EDGE__TARGET_NODE;

	/**
	 * The number of structural features of the '<em>Expression Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE___ALL_OWNED_ELEMENTS = EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE___GET_VALUE__TYPE_STRING = EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Expression Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The number of structural features of the '<em>Input Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Input Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__ANNOTATING_COMMENTS = EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__OWNED_ANNOTATIONS = EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__OWNED_COMMENTS = EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__OWNED_EXTENSIONS = EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__EDGE_ROLE = EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__NAME = EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__OWNING_REGION = EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__SOURCE_NODE = EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__TARGET_NODE = EDGE__TARGET_NODE;

	/**
	 * The number of structural features of the '<em>Iterated Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE___ALL_OWNED_ELEMENTS = EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE___GET_VALUE__TYPE_STRING = EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Iterated Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__REFERRED_VARIABLE = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__ANNOTATING_COMMENTS = VARIABLE_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__OWNED_ANNOTATIONS = VARIABLE_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__OWNED_COMMENTS = VARIABLE_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__OWNED_EXTENSIONS = VARIABLE_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__CLASS_DATUM = VARIABLE_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__INCOMING_CONNECTION = VARIABLE_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__INCOMING_EDGES = VARIABLE_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__NAME = VARIABLE_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__NODE_ROLE = VARIABLE_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__OUTGOING_CONNECTIONS = VARIABLE_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__OUTGOING_EDGES = VARIABLE_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__OWNING_REGION = VARIABLE_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__REFERRED_VARIABLE = VARIABLE_NODE__REFERRED_VARIABLE;

	/**
	 * The number of structural features of the '<em>Iterator Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE_FEATURE_COUNT = VARIABLE_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE___ALL_OWNED_ELEMENTS = VARIABLE_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE___GET_VALUE__TYPE_STRING = VARIABLE_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Iterator Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE_OPERATION_COUNT = VARIABLE_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl <em>Loading Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getLoadingRegion()
	 * @generated
	 */
	int LOADING_REGION = 16;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__ANNOTATING_COMMENTS = REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNED_ANNOTATIONS = REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNED_COMMENTS = REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNED_EXTENSIONS = REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__SYMBOL_NAME = REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNED_EDGES = REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNED_NODES = REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNING_SCHEDULED_REGION = REGION__OWNING_SCHEDULED_REGION;

	/**
	 * The number of structural features of the '<em>Loading Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION___ALL_OWNED_ELEMENTS = REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION___GET_VALUE__TYPE_STRING = REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Loading Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION_OPERATION_COUNT = REGION_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__OWNING_SCHEDULE_MODEL = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Produced Datums</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__PRODUCED_DATUMS = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__REFERRED_MAPPING = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Required Datums</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION__REQUIRED_DATUMS = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mapping Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_ACTION_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__ANNOTATING_COMMENTS = MAPPING_REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNED_ANNOTATIONS = MAPPING_REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNED_COMMENTS = MAPPING_REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNED_EXTENSIONS = MAPPING_REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__SYMBOL_NAME = MAPPING_REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNED_EDGES = MAPPING_REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNED_NODES = MAPPING_REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNING_SCHEDULED_REGION = MAPPING_REGION__OWNING_SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Mapping Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__MAPPING_REGION = MAPPING_REGION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__NAME_PREFIX = MAPPING_REGION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Symbol Name Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__SYMBOL_NAME_SUFFIX = MAPPING_REGION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Micro Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION_FEATURE_COUNT = MAPPING_REGION_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION___ALL_OWNED_ELEMENTS = MAPPING_REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION___GET_VALUE__TYPE_STRING = MAPPING_REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Micro Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION_OPERATION_COUNT = MAPPING_REGION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl <em>Named Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNamedMappingRegion()
	 * @generated
	 */
	int NAMED_MAPPING_REGION = 20;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__ANNOTATING_COMMENTS = MAPPING_REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNED_ANNOTATIONS = MAPPING_REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNED_COMMENTS = MAPPING_REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNED_EXTENSIONS = MAPPING_REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__SYMBOL_NAME = MAPPING_REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNED_EDGES = MAPPING_REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNED_NODES = MAPPING_REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNING_SCHEDULED_REGION = MAPPING_REGION__OWNING_SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__NAME = MAPPING_REGION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Symbol Name Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__SYMBOL_NAME_SUFFIX = MAPPING_REGION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Named Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION_FEATURE_COUNT = MAPPING_REGION_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION___ALL_OWNED_ELEMENTS = MAPPING_REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION___GET_VALUE__TYPE_STRING = MAPPING_REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Named Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION_OPERATION_COUNT = MAPPING_REGION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__ANNOTATING_COMMENTS = NAVIGABLE_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__OWNED_ANNOTATIONS = NAVIGABLE_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__OWNED_COMMENTS = NAVIGABLE_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__OWNED_EXTENSIONS = NAVIGABLE_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__EDGE_ROLE = NAVIGABLE_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__NAME = NAVIGABLE_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__OWNING_REGION = NAVIGABLE_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__SOURCE_NODE = NAVIGABLE_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__TARGET_NODE = NAVIGABLE_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__INCOMING_CONNECTION = NAVIGABLE_EDGE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Opposite Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__OPPOSITE_EDGE = NAVIGABLE_EDGE__OPPOSITE_EDGE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__OUTGOING_CONNECTIONS = NAVIGABLE_EDGE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Secondary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__SECONDARY = NAVIGABLE_EDGE__SECONDARY;

	/**
	 * The feature id for the '<em><b>Partial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__PARTIAL = NAVIGABLE_EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__REFERRED_PROPERTY = NAVIGABLE_EDGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Navigation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE_FEATURE_COUNT = NAVIGABLE_EDGE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE___ALL_OWNED_ELEMENTS = NAVIGABLE_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE___GET_VALUE__TYPE_STRING = NAVIGABLE_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Navigation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE_OPERATION_COUNT = NAVIGABLE_EDGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__ANNOTATING_COMMENTS = DATUM_CONNECTION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__OWNED_ANNOTATIONS = DATUM_CONNECTION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__OWNED_COMMENTS = DATUM_CONNECTION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__OWNED_EXTENSIONS = DATUM_CONNECTION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__SYMBOL_NAME = DATUM_CONNECTION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__OWNING_SCHEDULED_REGION = DATUM_CONNECTION__OWNING_SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Connection Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__CONNECTION_ROLE = DATUM_CONNECTION__CONNECTION_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__NAME = DATUM_CONNECTION__NAME;

	/**
	 * The feature id for the '<em><b>Source Ends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__SOURCE_ENDS = DATUM_CONNECTION__SOURCE_ENDS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION__CLASS_DATUM = DATUM_CONNECTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Node Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION_FEATURE_COUNT = DATUM_CONNECTION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION___ALL_OWNED_ELEMENTS = DATUM_CONNECTION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION___GET_VALUE__TYPE_STRING = DATUM_CONNECTION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Node Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION_OPERATION_COUNT = DATUM_CONNECTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NullNodeImpl <em>Null Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NullNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNullNode()
	 * @generated
	 */
	int NULL_NODE = 25;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__MATCHED = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Null Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Null Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationNodeImpl <em>Operation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationNode()
	 * @generated
	 */
	int OPERATION_NODE = 26;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__MATCHED = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__ANNOTATING_COMMENTS = REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNED_ANNOTATIONS = REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNED_COMMENTS = REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNED_EXTENSIONS = REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__SYMBOL_NAME = REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNED_EDGES = REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNED_NODES = REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNING_SCHEDULED_REGION = REGION__OWNING_SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Dependency Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__DEPENDENCY_NODES = REGION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Head Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__HEAD_NODES = REGION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__NAME = REGION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__REFERRED_OPERATION = REGION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Result Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__RESULT_NODE = REGION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Operation Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION___ALL_OWNED_ELEMENTS = REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION___GET_VALUE__TYPE_STRING = REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Operation Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION_OPERATION_COUNT = REGION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PatternTypedNodeImpl <em>Pattern Typed Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PatternTypedNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPatternTypedNode()
	 * @generated
	 */
	int PATTERN_TYPED_NODE = 28;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__MATCHED = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Typed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Pattern Typed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl <em>Pattern Variable Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPatternVariableNode()
	 * @generated
	 */
	int PATTERN_VARIABLE_NODE = 29;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__ANNOTATING_COMMENTS = VARIABLE_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__OWNED_ANNOTATIONS = VARIABLE_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__OWNED_COMMENTS = VARIABLE_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__OWNED_EXTENSIONS = VARIABLE_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__CLASS_DATUM = VARIABLE_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__INCOMING_CONNECTION = VARIABLE_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__INCOMING_EDGES = VARIABLE_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__NAME = VARIABLE_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__NODE_ROLE = VARIABLE_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__OUTGOING_CONNECTIONS = VARIABLE_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__OUTGOING_EDGES = VARIABLE_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__OWNING_REGION = VARIABLE_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__REFERRED_VARIABLE = VARIABLE_NODE__REFERRED_VARIABLE;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__MATCHED = VARIABLE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Pattern Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE_FEATURE_COUNT = VARIABLE_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE___ALL_OWNED_ELEMENTS = VARIABLE_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE___GET_VALUE__TYPE_STRING = VARIABLE_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Pattern Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE_OPERATION_COUNT = VARIABLE_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PredicateEdgeImpl <em>Predicate Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PredicateEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPredicateEdge()
	 * @generated
	 */
	int PREDICATE_EDGE = 30;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__ANNOTATING_COMMENTS = EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__OWNED_ANNOTATIONS = EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__OWNED_COMMENTS = EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__OWNED_EXTENSIONS = EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__EDGE_ROLE = EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__NAME = EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__OWNING_REGION = EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__SOURCE_NODE = EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__TARGET_NODE = EDGE__TARGET_NODE;

	/**
	 * The number of structural features of the '<em>Predicate Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE___ALL_OWNED_ELEMENTS = EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE___GET_VALUE__TYPE_STRING = EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Predicate Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Produced By Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__PRODUCED_BY_ACTIONS = ABSTRACT_DATUM__PRODUCED_BY_ACTIONS;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__REFERRED_TYPED_MODEL = ABSTRACT_DATUM__REFERRED_TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Required By Actions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__REQUIRED_BY_ACTIONS = ABSTRACT_DATUM__REQUIRED_BY_ACTIONS;

	/**
	 * The feature id for the '<em><b>Opposite</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__OPPOSITE = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Class Datum</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__OWNING_CLASS_DATUM = ABSTRACT_DATUM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__REFERRED_PROPERTY = ABSTRACT_DATUM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Super Property Datums</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__SUPER_PROPERTY_DATUMS = ABSTRACT_DATUM_FEATURE_COUNT + 3;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl <em>Recursion Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRecursionEdge()
	 * @generated
	 */
	int RECURSION_EDGE = 32;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__ANNOTATING_COMMENTS = EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__OWNED_ANNOTATIONS = EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__OWNED_COMMENTS = EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__OWNED_EXTENSIONS = EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__EDGE_ROLE = EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__NAME = EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__OWNING_REGION = EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__SOURCE_NODE = EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__TARGET_NODE = EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Primary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__PRIMARY = EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Recursion Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE___ALL_OWNED_ELEMENTS = EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE___GET_VALUE__TYPE_STRING = EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Recursion Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl <em>Schedule Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getScheduleModel()
	 * @generated
	 */
	int SCHEDULE_MODEL = 34;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__ANNOTATING_COMMENTS = PivotPackage.MODEL__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_ANNOTATIONS = PivotPackage.MODEL__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_COMMENTS = PivotPackage.MODEL__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_EXTENSIONS = PivotPackage.MODEL__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__NAME = PivotPackage.MODEL__NAME;

	/**
	 * The feature id for the '<em><b>Owned Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_CONSTRAINTS = PivotPackage.MODEL__OWNED_CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>External URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__EXTERNAL_URI = PivotPackage.MODEL__EXTERNAL_URI;

	/**
	 * The feature id for the '<em><b>Owned Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_IMPORTS = PivotPackage.MODEL__OWNED_IMPORTS;

	/**
	 * The feature id for the '<em><b>Owned Packages</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_PACKAGES = PivotPackage.MODEL__OWNED_PACKAGES;

	/**
	 * The feature id for the '<em><b>Loading Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__LOADING_REGION = PivotPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Class Datums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_CLASS_DATUMS = PivotPackage.MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Mapping Actions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_MAPPING_ACTIONS = PivotPackage.MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Other Mapping Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_OTHER_MAPPING_REGIONS = PivotPackage.MODEL_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owned Scheduled Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_SCHEDULED_REGION = PivotPackage.MODEL_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Schedule Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL_FEATURE_COUNT = PivotPackage.MODEL_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL___ALL_OWNED_ELEMENTS = PivotPackage.MODEL___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL___GET_VALUE__TYPE_STRING = PivotPackage.MODEL___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Schedule Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL_OPERATION_COUNT = PivotPackage.MODEL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduledRegionImpl <em>Scheduled Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduledRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getScheduledRegion()
	 * @generated
	 */
	int SCHEDULED_REGION = 35;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__ANNOTATING_COMMENTS = REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_ANNOTATIONS = REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_COMMENTS = REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_EXTENSIONS = REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__SYMBOL_NAME = REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_EDGES = REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_NODES = REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNING_SCHEDULED_REGION = REGION__OWNING_SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__NAME = REGION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_CONNECTIONS = REGION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_REGIONS = REGION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNING_SCHEDULE_MODEL = REGION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Scheduled Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION___ALL_OWNED_ELEMENTS = REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION___GET_VALUE__TYPE_STRING = REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Scheduled Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION_OPERATION_COUNT = REGION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable <em>Symbolable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSymbolable()
	 * @generated
	 */
	int SYMBOLABLE = 36;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLABLE__SYMBOL_NAME = 0;

	/**
	 * The number of structural features of the '<em>Symbolable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLABLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Symbolable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYMBOLABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TrueNodeImpl <em>True Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TrueNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTrueNode()
	 * @generated
	 */
	int TRUE_NODE = 37;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The number of structural features of the '<em>True Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>True Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.UnknownNodeImpl <em>Unknown Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.UnknownNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getUnknownNode()
	 * @generated
	 */
	int UNKNOWN_NODE = 38;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The number of structural features of the '<em>Unknown Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Unknown Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage <em>Domain Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDomainUsage()
	 * @generated
	 */
	int DOMAIN_USAGE = 40;

	/**
	 * The number of structural features of the '<em>Domain Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_USAGE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Domain Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOMAIN_USAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole <em>Connection Role</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionRole()
	 * @generated
	 */
	int CONNECTION_ROLE = 41;

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getProducedByActions <em>Produced By Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Produced By Actions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getProducedByActions()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_ProducedByActions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getReferredTypedModel <em>Referred Typed Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getReferredTypedModel()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_ReferredTypedModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getRequiredByActions <em>Required By Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required By Actions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum#getRequiredByActions()
	 * @see #getAbstractDatum()
	 * @generated
	 */
	EReference getAbstractDatum_RequiredByActions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion <em>Basic Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion
	 * @generated
	 */
	EClass getBasicMappingRegion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion#getName()
	 * @see #getBasicMappingRegion()
	 * @generated
	 */
	EAttribute getBasicMappingRegion_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion#getReferredMapping <em>Referred Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion#getReferredMapping()
	 * @see #getBasicMappingRegion()
	 * @generated
	 */
	EReference getBasicMappingRegion_ReferredMapping();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge <em>Cast Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cast Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CastEdge
	 * @generated
	 */
	EClass getCastEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getProperty()
	 * @see #getCastEdge()
	 * @generated
	 */
	EReference getCastEdge_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CastEdge#getReferredClass()
	 * @see #getCastEdge()
	 * @generated
	 */
	EReference getCastEdge_ReferredClass();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningPropertyDatums <em>Owning Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owning Property Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningPropertyDatums()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_OwningPropertyDatums();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwningScheduleModel()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_OwningScheduleModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getReferredClass()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_ReferredClass();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getSuperClassDatums <em>Super Class Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Class Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getSuperClassDatums()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_SuperClassDatums();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ComposedNode <em>Composed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composed Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ComposedNode
	 * @generated
	 */
	EClass getComposedNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection <em>Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection
	 * @generated
	 */
	EClass getConnection();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningScheduledRegion <em>Owning Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Scheduled Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Connection#getOwningScheduledRegion()
	 * @see #getConnection()
	 * @generated
	 */
	EReference getConnection_OwningScheduledRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection End</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
	 * @generated
	 */
	EClass getConnectionEnd();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection <em>Datum Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Datum Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DatumConnection
	 * @generated
	 */
	EClass getDatumConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getConnectionRole <em>Connection Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Connection Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getConnectionRole()
	 * @see #getDatumConnection()
	 * @generated
	 */
	EAttribute getDatumConnection_ConnectionRole();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getName()
	 * @see #getDatumConnection()
	 * @generated
	 */
	EAttribute getDatumConnection_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getSourceEnds <em>Source Ends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Ends</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DatumConnection#getSourceEnds()
	 * @see #getDatumConnection()
	 * @generated
	 */
	EReference getDatumConnection_SourceEnds();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.DependencyNode <em>Dependency Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DependencyNode
	 * @generated
	 */
	EClass getDependencyNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getEdgeRole <em>Edge Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Edge Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getEdgeRole()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_EdgeRole();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getName()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Name();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getOwningRegion()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_OwningRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getSourceNode <em>Source Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getSourceNode()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_SourceNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getTargetNode <em>Target Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getTargetNode()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_TargetNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection <em>Edge Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection
	 * @generated
	 */
	EClass getEdgeConnection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection#getReferredProperty()
	 * @see #getEdgeConnection()
	 * @generated
	 */
	EReference getEdgeConnection_ReferredProperty();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.pivot.qvtschedule.Role <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @generated
	 */
	EEnum getRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel <em>Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel
	 * @generated
	 */
	EClass getScheduleModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getLoadingRegion <em>Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loading Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getLoadingRegion()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_LoadingRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedClassDatums <em>Owned Class Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Class Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedClassDatums()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedClassDatums();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedMappingActions <em>Owned Mapping Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Actions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedMappingActions()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedMappingActions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedOtherMappingRegions <em>Owned Other Mapping Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Other Mapping Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedOtherMappingRegions()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedOtherMappingRegions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedScheduledRegion <em>Owned Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Scheduled Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedScheduledRegion()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedScheduledRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion <em>Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduled Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion
	 * @generated
	 */
	EClass getScheduledRegion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getName()
	 * @see #getScheduledRegion()
	 * @generated
	 */
	EAttribute getScheduledRegion_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedConnections <em>Owned Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Connections</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedConnections()
	 * @see #getScheduledRegion()
	 * @generated
	 */
	EReference getScheduledRegion_OwnedConnections();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedRegions <em>Owned Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedRegions()
	 * @see #getScheduledRegion()
	 * @generated
	 */
	EReference getScheduledRegion_OwnedRegions();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwningScheduleModel()
	 * @see #getScheduledRegion()
	 * @generated
	 */
	EReference getScheduledRegion_OwningScheduleModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable <em>Symbolable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Symbolable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable
	 * @generated
	 */
	EClass getSymbolable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable#getSymbolName <em>Symbol Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable#getSymbolName()
	 * @see #getSymbolable()
	 * @generated
	 */
	EAttribute getSymbolable_SymbolName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.TrueNode <em>True Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TrueNode
	 * @generated
	 */
	EClass getTrueNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.UnknownNode <em>Unknown Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unknown Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.UnknownNode
	 * @generated
	 */
	EClass getUnknownNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.VariableNode <em>Variable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VariableNode
	 * @generated
	 */
	EClass getVariableNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.VariableNode#getReferredVariable <em>Referred Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Variable</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VariableNode#getReferredVariable()
	 * @see #getVariableNode()
	 * @generated
	 */
	EReference getVariableNode_ReferredVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage <em>Domain Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Domain Usage</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage
	 * @model instanceClass="org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage"
	 * @generated
	 */
	EClass getDomainUsage();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole <em>Connection Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Connection Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
	 * @generated
	 */
	EEnum getConnectionRole();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ErrorNode <em>Error Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Error Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ErrorNode
	 * @generated
	 */
	EClass getErrorNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge <em>Expression Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge
	 * @generated
	 */
	EClass getExpressionEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.InputNode <em>Input Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.InputNode
	 * @generated
	 */
	EClass getInputNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge <em>Iterated Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterated Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IteratedEdge
	 * @generated
	 */
	EClass getIteratedEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.IteratorNode <em>Iterator Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iterator Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IteratorNode
	 * @generated
	 */
	EClass getIteratorNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion <em>Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loading Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion
	 * @generated
	 */
	EClass getLoadingRegion();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getReferredMapping <em>Referred Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Mapping</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getReferredMapping()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_ReferredMapping();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getRequiredDatums <em>Required Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Required Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getRequiredDatums()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_RequiredDatums();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getOwningScheduleModel()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_OwningScheduleModel();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getProducedDatums <em>Produced Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Produced Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingAction#getProducedDatums()
	 * @see #getMappingAction()
	 * @generated
	 */
	EReference getMappingAction_ProducedDatums();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion <em>Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion
	 * @generated
	 */
	EClass getMappingRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion <em>Micro Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Micro Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion
	 * @generated
	 */
	EClass getMicroMappingRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getMappingRegion <em>Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getMappingRegion()
	 * @see #getMicroMappingRegion()
	 * @generated
	 */
	EReference getMicroMappingRegion_MappingRegion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getNamePrefix <em>Name Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Prefix</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getNamePrefix()
	 * @see #getMicroMappingRegion()
	 * @generated
	 */
	EAttribute getMicroMappingRegion_NamePrefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getSymbolNameSuffix <em>Symbol Name Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol Name Suffix</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion#getSymbolNameSuffix()
	 * @see #getMicroMappingRegion()
	 * @generated
	 */
	EAttribute getMicroMappingRegion_SymbolNameSuffix();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion <em>Named Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion
	 * @generated
	 */
	EClass getNamedMappingRegion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion#getName()
	 * @see #getNamedMappingRegion()
	 * @generated
	 */
	EAttribute getNamedMappingRegion_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion#getSymbolNameSuffix <em>Symbol Name Suffix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Symbol Name Suffix</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NamedMappingRegion#getSymbolNameSuffix()
	 * @see #getNamedMappingRegion()
	 * @generated
	 */
	EAttribute getNamedMappingRegion_SymbolNameSuffix();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge <em>Navigable Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigable Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge
	 * @generated
	 */
	EClass getNavigableEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getIncomingConnection <em>Incoming Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getIncomingConnection()
	 * @see #getNavigableEdge()
	 * @generated
	 */
	EReference getNavigableEdge_IncomingConnection();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Connections</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getOutgoingConnections()
	 * @see #getNavigableEdge()
	 * @generated
	 */
	EReference getNavigableEdge_OutgoingConnections();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#isSecondary <em>Secondary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Secondary</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#isSecondary()
	 * @see #getNavigableEdge()
	 * @generated
	 */
	EAttribute getNavigableEdge_Secondary();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getOppositeEdge <em>Opposite Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Opposite Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge#getOppositeEdge()
	 * @see #getNavigableEdge()
	 * @generated
	 */
	EReference getNavigableEdge_OppositeEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge <em>Navigation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge
	 * @generated
	 */
	EClass getNavigationEdge();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isPartial <em>Partial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Partial</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#isPartial()
	 * @see #getNavigationEdge()
	 * @generated
	 */
	EAttribute getNavigationEdge_Partial();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge#getReferredProperty()
	 * @see #getNavigationEdge()
	 * @generated
	 */
	EReference getNavigationEdge_ReferredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getClassDatum()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_ClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingConnection <em>Incoming Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Incoming Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingConnection()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_IncomingConnection();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getNodeRole <em>Node Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getNodeRole()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_NodeRole();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingConnections <em>Outgoing Connections</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Connections</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingConnections()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutgoingConnections();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getIncomingEdges()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_IncomingEdges();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getName()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingEdges <em>Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getOutgoingEdges()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OutgoingEdges();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getOwningRegion()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_OwningRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection <em>Node Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeConnection
	 * @generated
	 */
	EClass getNodeConnection();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getClassDatum <em>Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NodeConnection#getClassDatum()
	 * @see #getNodeConnection()
	 * @generated
	 */
	EReference getNodeConnection_ClassDatum();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NullNode <em>Null Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NullNode
	 * @generated
	 */
	EClass getNullNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.NullNode#isMatched <em>Matched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matched</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NullNode#isMatched()
	 * @see #getNullNode()
	 * @generated
	 */
	EAttribute getNullNode_Matched();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationNode <em>Operation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationNode
	 * @generated
	 */
	EClass getOperationNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationNode#isMatched <em>Matched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matched</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationNode#isMatched()
	 * @see #getOperationNode()
	 * @generated
	 */
	EAttribute getOperationNode_Matched();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion <em>Operation Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion
	 * @generated
	 */
	EClass getOperationRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getDependencyNodes <em>Dependency Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dependency Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getDependencyNodes()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_DependencyNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getHeadNodes <em>Head Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Head Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getHeadNodes()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_HeadNodes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getName()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EAttribute getOperationRegion_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getReferredOperation()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_ReferredOperation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getResultNode <em>Result Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Result Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getResultNode()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_ResultNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode <em>Pattern Typed Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Typed Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode
	 * @generated
	 */
	EClass getPatternTypedNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode#isMatched <em>Matched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matched</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode#isMatched()
	 * @see #getPatternTypedNode()
	 * @generated
	 */
	EAttribute getPatternTypedNode_Matched();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode <em>Pattern Variable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Variable Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode
	 * @generated
	 */
	EClass getPatternVariableNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode#isMatched <em>Matched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matched</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode#isMatched()
	 * @see #getPatternVariableNode()
	 * @generated
	 */
	EAttribute getPatternVariableNode_Matched();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge <em>Predicate Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge
	 * @generated
	 */
	EClass getPredicateEdge();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOwningClassDatum <em>Owning Class Datum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Class Datum</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getOwningClassDatum()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_OwningClassDatum();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getReferredProperty()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_ReferredProperty();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getSuperPropertyDatums <em>Super Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Super Property Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#getSuperPropertyDatums()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EReference getPropertyDatum_SuperPropertyDatums();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge <em>Recursion Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recursion Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge
	 * @generated
	 */
	EClass getRecursionEdge();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge#isPrimary <em>Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge#isPrimary()
	 * @see #getRecursionEdge()
	 * @generated
	 */
	EAttribute getRecursionEdge_Primary();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Region <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region
	 * @generated
	 */
	EClass getRegion();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwningScheduledRegion <em>Owning Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Scheduled Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwningScheduledRegion()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwningScheduledRegion();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedEdges <em>Owned Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedEdges()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwnedEdges();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedNodes <em>Owned Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedNodes()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwnedNodes();

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
		 * The meta object literal for the '<em><b>Produced By Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__PRODUCED_BY_ACTIONS = eINSTANCE.getAbstractDatum_ProducedByActions();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__REFERRED_TYPED_MODEL = eINSTANCE.getAbstractDatum_ReferredTypedModel();

		/**
		 * The meta object literal for the '<em><b>Required By Actions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__REQUIRED_BY_ACTIONS = eINSTANCE.getAbstractDatum_RequiredByActions();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl <em>Basic Mapping Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getBasicMappingRegion()
		 * @generated
		 */
		EClass BASIC_MAPPING_REGION = eINSTANCE.getBasicMappingRegion();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BASIC_MAPPING_REGION__NAME = eINSTANCE.getBasicMappingRegion_Name();

		/**
		 * The meta object literal for the '<em><b>Referred Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BASIC_MAPPING_REGION__REFERRED_MAPPING = eINSTANCE.getBasicMappingRegion_ReferredMapping();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl <em>Cast Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCastEdge()
		 * @generated
		 */
		EClass CAST_EDGE = eINSTANCE.getCastEdge();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAST_EDGE__PROPERTY = eINSTANCE.getCastEdge_Property();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAST_EDGE__REFERRED_CLASS = eINSTANCE.getCastEdge_ReferredClass();

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
		 * The meta object literal for the '<em><b>Owning Property Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__OWNING_PROPERTY_DATUMS = eINSTANCE.getClassDatum_OwningPropertyDatums();

		/**
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__OWNING_SCHEDULE_MODEL = eINSTANCE.getClassDatum_OwningScheduleModel();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__REFERRED_CLASS = eINSTANCE.getClassDatum_ReferredClass();

		/**
		 * The meta object literal for the '<em><b>Super Class Datums</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__SUPER_CLASS_DATUMS = eINSTANCE.getClassDatum_SuperClassDatums();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl <em>Composed Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getComposedNode()
		 * @generated
		 */
		EClass COMPOSED_NODE = eINSTANCE.getComposedNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl <em>Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnection()
		 * @generated
		 */
		EClass CONNECTION = eINSTANCE.getConnection();

		/**
		 * The meta object literal for the '<em><b>Owning Scheduled Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTION__OWNING_SCHEDULED_REGION = eINSTANCE.getConnection_OwningScheduledRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionEnd()
		 * @generated
		 */
		EClass CONNECTION_END = eINSTANCE.getConnectionEnd();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl <em>Datum Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDatumConnection()
		 * @generated
		 */
		EClass DATUM_CONNECTION = eINSTANCE.getDatumConnection();

		/**
		 * The meta object literal for the '<em><b>Connection Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATUM_CONNECTION__CONNECTION_ROLE = eINSTANCE.getDatumConnection_ConnectionRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATUM_CONNECTION__NAME = eINSTANCE.getDatumConnection_Name();

		/**
		 * The meta object literal for the '<em><b>Source Ends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATUM_CONNECTION__SOURCE_ENDS = eINSTANCE.getDatumConnection_SourceEnds();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDependencyNode()
		 * @generated
		 */
		EClass DEPENDENCY_NODE = eINSTANCE.getDependencyNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Edge Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__EDGE_ROLE = eINSTANCE.getEdge_EdgeRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__NAME = eINSTANCE.getEdge_Name();

		/**
		 * The meta object literal for the '<em><b>Owning Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__OWNING_REGION = eINSTANCE.getEdge_OwningRegion();

		/**
		 * The meta object literal for the '<em><b>Source Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__SOURCE_NODE = eINSTANCE.getEdge_SourceNode();

		/**
		 * The meta object literal for the '<em><b>Target Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__TARGET_NODE = eINSTANCE.getEdge_TargetNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl <em>Edge Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdgeConnection()
		 * @generated
		 */
		EClass EDGE_CONNECTION = eINSTANCE.getEdgeConnection();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE_CONNECTION__REFERRED_PROPERTY = eINSTANCE.getEdgeConnection_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Role <em>Role</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRole()
		 * @generated
		 */
		EEnum ROLE = eINSTANCE.getRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl <em>Schedule Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getScheduleModel()
		 * @generated
		 */
		EClass SCHEDULE_MODEL = eINSTANCE.getScheduleModel();

		/**
		 * The meta object literal for the '<em><b>Loading Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__LOADING_REGION = eINSTANCE.getScheduleModel_LoadingRegion();

		/**
		 * The meta object literal for the '<em><b>Owned Class Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_CLASS_DATUMS = eINSTANCE.getScheduleModel_OwnedClassDatums();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Actions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_MAPPING_ACTIONS = eINSTANCE.getScheduleModel_OwnedMappingActions();

		/**
		 * The meta object literal for the '<em><b>Owned Other Mapping Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_OTHER_MAPPING_REGIONS = eINSTANCE.getScheduleModel_OwnedOtherMappingRegions();

		/**
		 * The meta object literal for the '<em><b>Owned Scheduled Region</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_SCHEDULED_REGION = eINSTANCE.getScheduleModel_OwnedScheduledRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduledRegionImpl <em>Scheduled Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduledRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getScheduledRegion()
		 * @generated
		 */
		EClass SCHEDULED_REGION = eINSTANCE.getScheduledRegion();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULED_REGION__NAME = eINSTANCE.getScheduledRegion_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_REGION__OWNED_CONNECTIONS = eINSTANCE.getScheduledRegion_OwnedConnections();

		/**
		 * The meta object literal for the '<em><b>Owned Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_REGION__OWNED_REGIONS = eINSTANCE.getScheduledRegion_OwnedRegions();

		/**
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_REGION__OWNING_SCHEDULE_MODEL = eINSTANCE.getScheduledRegion_OwningScheduleModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable <em>Symbolable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSymbolable()
		 * @generated
		 */
		EClass SYMBOLABLE = eINSTANCE.getSymbolable();

		/**
		 * The meta object literal for the '<em><b>Symbol Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYMBOLABLE__SYMBOL_NAME = eINSTANCE.getSymbolable_SymbolName();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TrueNodeImpl <em>True Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TrueNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTrueNode()
		 * @generated
		 */
		EClass TRUE_NODE = eINSTANCE.getTrueNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.UnknownNodeImpl <em>Unknown Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.UnknownNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getUnknownNode()
		 * @generated
		 */
		EClass UNKNOWN_NODE = eINSTANCE.getUnknownNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl <em>Variable Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getVariableNode()
		 * @generated
		 */
		EClass VARIABLE_NODE = eINSTANCE.getVariableNode();

		/**
		 * The meta object literal for the '<em><b>Referred Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_NODE__REFERRED_VARIABLE = eINSTANCE.getVariableNode_ReferredVariable();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage <em>Domain Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDomainUsage()
		 * @generated
		 */
		EClass DOMAIN_USAGE = eINSTANCE.getDomainUsage();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole <em>Connection Role</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionRole()
		 * @generated
		 */
		EEnum CONNECTION_ROLE = eINSTANCE.getConnectionRole();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl <em>Error Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getErrorNode()
		 * @generated
		 */
		EClass ERROR_NODE = eINSTANCE.getErrorNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl <em>Expression Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getExpressionEdge()
		 * @generated
		 */
		EClass EXPRESSION_EDGE = eINSTANCE.getExpressionEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl <em>Input Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getInputNode()
		 * @generated
		 */
		EClass INPUT_NODE = eINSTANCE.getInputNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl <em>Iterated Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratedEdge()
		 * @generated
		 */
		EClass ITERATED_EDGE = eINSTANCE.getIteratedEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl <em>Iterator Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratorNode()
		 * @generated
		 */
		EClass ITERATOR_NODE = eINSTANCE.getIteratorNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl <em>Loading Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getLoadingRegion()
		 * @generated
		 */
		EClass LOADING_REGION = eINSTANCE.getLoadingRegion();

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
		 * The meta object literal for the '<em><b>Referred Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__REFERRED_MAPPING = eINSTANCE.getMappingAction_ReferredMapping();

		/**
		 * The meta object literal for the '<em><b>Required Datums</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__REQUIRED_DATUMS = eINSTANCE.getMappingAction_RequiredDatums();

		/**
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__OWNING_SCHEDULE_MODEL = eINSTANCE.getMappingAction_OwningScheduleModel();

		/**
		 * The meta object literal for the '<em><b>Produced Datums</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_ACTION__PRODUCED_DATUMS = eINSTANCE.getMappingAction_ProducedDatums();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl <em>Mapping Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingRegion()
		 * @generated
		 */
		EClass MAPPING_REGION = eINSTANCE.getMappingRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl <em>Micro Mapping Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMicroMappingRegion()
		 * @generated
		 */
		EClass MICRO_MAPPING_REGION = eINSTANCE.getMicroMappingRegion();

		/**
		 * The meta object literal for the '<em><b>Mapping Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MICRO_MAPPING_REGION__MAPPING_REGION = eINSTANCE.getMicroMappingRegion_MappingRegion();

		/**
		 * The meta object literal for the '<em><b>Name Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICRO_MAPPING_REGION__NAME_PREFIX = eINSTANCE.getMicroMappingRegion_NamePrefix();

		/**
		 * The meta object literal for the '<em><b>Symbol Name Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MICRO_MAPPING_REGION__SYMBOL_NAME_SUFFIX = eINSTANCE.getMicroMappingRegion_SymbolNameSuffix();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl <em>Named Mapping Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNamedMappingRegion()
		 * @generated
		 */
		EClass NAMED_MAPPING_REGION = eINSTANCE.getNamedMappingRegion();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_MAPPING_REGION__NAME = eINSTANCE.getNamedMappingRegion_Name();

		/**
		 * The meta object literal for the '<em><b>Symbol Name Suffix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_MAPPING_REGION__SYMBOL_NAME_SUFFIX = eINSTANCE.getNamedMappingRegion_SymbolNameSuffix();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl <em>Navigable Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigableEdge()
		 * @generated
		 */
		EClass NAVIGABLE_EDGE = eINSTANCE.getNavigableEdge();

		/**
		 * The meta object literal for the '<em><b>Incoming Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGABLE_EDGE__INCOMING_CONNECTION = eINSTANCE.getNavigableEdge_IncomingConnection();

		/**
		 * The meta object literal for the '<em><b>Outgoing Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGABLE_EDGE__OUTGOING_CONNECTIONS = eINSTANCE.getNavigableEdge_OutgoingConnections();

		/**
		 * The meta object literal for the '<em><b>Secondary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGABLE_EDGE__SECONDARY = eINSTANCE.getNavigableEdge_Secondary();

		/**
		 * The meta object literal for the '<em><b>Opposite Edge</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGABLE_EDGE__OPPOSITE_EDGE = eINSTANCE.getNavigableEdge_OppositeEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl <em>Navigation Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigationEdge()
		 * @generated
		 */
		EClass NAVIGATION_EDGE = eINSTANCE.getNavigationEdge();

		/**
		 * The meta object literal for the '<em><b>Partial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAVIGATION_EDGE__PARTIAL = eINSTANCE.getNavigationEdge_Partial();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NAVIGATION_EDGE__REFERRED_PROPERTY = eINSTANCE.getNavigationEdge_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Class Datum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CLASS_DATUM = eINSTANCE.getNode_ClassDatum();

		/**
		 * The meta object literal for the '<em><b>Incoming Connection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING_CONNECTION = eINSTANCE.getNode_IncomingConnection();

		/**
		 * The meta object literal for the '<em><b>Node Role</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NODE_ROLE = eINSTANCE.getNode_NodeRole();

		/**
		 * The meta object literal for the '<em><b>Outgoing Connections</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING_CONNECTIONS = eINSTANCE.getNode_OutgoingConnections();

		/**
		 * The meta object literal for the '<em><b>Incoming Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__INCOMING_EDGES = eINSTANCE.getNode_IncomingEdges();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__NAME = eINSTANCE.getNode_Name();

		/**
		 * The meta object literal for the '<em><b>Outgoing Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OUTGOING_EDGES = eINSTANCE.getNode_OutgoingEdges();

		/**
		 * The meta object literal for the '<em><b>Owning Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__OWNING_REGION = eINSTANCE.getNode_OwningRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl <em>Node Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNodeConnection()
		 * @generated
		 */
		EClass NODE_CONNECTION = eINSTANCE.getNodeConnection();

		/**
		 * The meta object literal for the '<em><b>Class Datum</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_CONNECTION__CLASS_DATUM = eINSTANCE.getNodeConnection_ClassDatum();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NullNodeImpl <em>Null Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NullNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNullNode()
		 * @generated
		 */
		EClass NULL_NODE = eINSTANCE.getNullNode();

		/**
		 * The meta object literal for the '<em><b>Matched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NULL_NODE__MATCHED = eINSTANCE.getNullNode_Matched();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationNodeImpl <em>Operation Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationNode()
		 * @generated
		 */
		EClass OPERATION_NODE = eINSTANCE.getOperationNode();

		/**
		 * The meta object literal for the '<em><b>Matched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_NODE__MATCHED = eINSTANCE.getOperationNode_Matched();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl <em>Operation Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationRegion()
		 * @generated
		 */
		EClass OPERATION_REGION = eINSTANCE.getOperationRegion();

		/**
		 * The meta object literal for the '<em><b>Dependency Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__DEPENDENCY_NODES = eINSTANCE.getOperationRegion_DependencyNodes();

		/**
		 * The meta object literal for the '<em><b>Head Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__HEAD_NODES = eINSTANCE.getOperationRegion_HeadNodes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_REGION__NAME = eINSTANCE.getOperationRegion_Name();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__REFERRED_OPERATION = eINSTANCE.getOperationRegion_ReferredOperation();

		/**
		 * The meta object literal for the '<em><b>Result Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__RESULT_NODE = eINSTANCE.getOperationRegion_ResultNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PatternTypedNodeImpl <em>Pattern Typed Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PatternTypedNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPatternTypedNode()
		 * @generated
		 */
		EClass PATTERN_TYPED_NODE = eINSTANCE.getPatternTypedNode();

		/**
		 * The meta object literal for the '<em><b>Matched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_TYPED_NODE__MATCHED = eINSTANCE.getPatternTypedNode_Matched();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl <em>Pattern Variable Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPatternVariableNode()
		 * @generated
		 */
		EClass PATTERN_VARIABLE_NODE = eINSTANCE.getPatternVariableNode();

		/**
		 * The meta object literal for the '<em><b>Matched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PATTERN_VARIABLE_NODE__MATCHED = eINSTANCE.getPatternVariableNode_Matched();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PredicateEdgeImpl <em>Predicate Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PredicateEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPredicateEdge()
		 * @generated
		 */
		EClass PREDICATE_EDGE = eINSTANCE.getPredicateEdge();

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
		 * The meta object literal for the '<em><b>Opposite</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__OPPOSITE = eINSTANCE.getPropertyDatum_Opposite();

		/**
		 * The meta object literal for the '<em><b>Owning Class Datum</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__OWNING_CLASS_DATUM = eINSTANCE.getPropertyDatum_OwningClassDatum();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__REFERRED_PROPERTY = eINSTANCE.getPropertyDatum_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Super Property Datums</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROPERTY_DATUM__SUPER_PROPERTY_DATUMS = eINSTANCE.getPropertyDatum_SuperPropertyDatums();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl <em>Recursion Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRecursionEdge()
		 * @generated
		 */
		EClass RECURSION_EDGE = eINSTANCE.getRecursionEdge();

		/**
		 * The meta object literal for the '<em><b>Primary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RECURSION_EDGE__PRIMARY = eINSTANCE.getRecursionEdge_Primary();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl <em>Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRegion()
		 * @generated
		 */
		EClass REGION = eINSTANCE.getRegion();

		/**
		 * The meta object literal for the '<em><b>Owning Scheduled Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNING_SCHEDULED_REGION = eINSTANCE.getRegion_OwningScheduledRegion();

		/**
		 * The meta object literal for the '<em><b>Owned Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_EDGES = eINSTANCE.getRegion_OwnedEdges();

		/**
		 * The meta object literal for the '<em><b>Owned Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_NODES = eINSTANCE.getRegion_OwnedNodes();

	}

} //QVTschedulePackage
