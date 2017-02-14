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
	int CLASS_DATUM = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl <em>Class Datum Analysis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getClassDatumAnalysis()
	 * @generated
	 */
	int CLASS_DATUM_ANALYSIS = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionEnd()
	 * @generated
	 */
	int CONNECTION_END = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionRoleImpl <em>Connection Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionRoleImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionRole()
	 * @generated
	 */
	int CONNECTION_ROLE = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl <em>Datum Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDatumConnection()
	 * @generated
	 */
	int DATUM_CONNECTION = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl <em>Edge Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdgeConnection()
	 * @generated
	 */
	int EDGE_CONNECTION = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl <em>Role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RoleImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingActionImpl <em>Mapping Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingActionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingAction()
	 * @generated
	 */
	int MAPPING_ACTION = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl <em>Navigable Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigableEdge()
	 * @generated
	 */
	int NAVIGABLE_EDGE = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNode()
	 * @generated
	 */
	int NODE = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl <em>Node Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNodeConnection()
	 * @generated
	 */
	int NODE_CONNECTION = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl <em>Operation Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationRegion()
	 * @generated
	 */
	int OPERATION_REGION = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPropertyDatum()
	 * @generated
	 */
	int PROPERTY_DATUM = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl <em>Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingRegion()
	 * @generated
	 */
	int MAPPING_REGION = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MultiRegionImpl <em>Multi Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MultiRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMultiRegion()
	 * @generated
	 */
	int MULTI_REGION = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl <em>Navigation Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigationEdge()
	 * @generated
	 */
	int NAVIGATION_EDGE = 24;

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
	int DEPENDENCY_NODE = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl <em>Error Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getErrorNode()
	 * @generated
	 */
	int ERROR_NODE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl <em>Expression Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getExpressionEdge()
	 * @generated
	 */
	int EXPRESSION_EDGE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl <em>Input Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getInputNode()
	 * @generated
	 */
	int INPUT_NODE = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl <em>Iterated Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratedEdge()
	 * @generated
	 */
	int ITERATED_EDGE = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl <em>Variable Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getVariableNode()
	 * @generated
	 */
	int VARIABLE_NODE = 43;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl <em>Iterator Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratorNode()
	 * @generated
	 */
	int ITERATOR_NODE = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl <em>Composed Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getComposedNode()
	 * @generated
	 */
	int COMPOSED_NODE = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl <em>Micro Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMicroMappingRegion()
	 * @generated
	 */
	int MICRO_MAPPING_REGION = 20;

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
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__EDGES = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__NODES = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

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
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__EDGES = REGION__EDGES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__NODES = REGION__NODES;

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
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__EDGES = MAPPING_REGION__EDGES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION__NODES = MAPPING_REGION__NODES;

	/**
	 * The number of structural features of the '<em>Basic Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASIC_MAPPING_REGION_FEATURE_COUNT = MAPPING_REGION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Edge Role</b></em>' reference.
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
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__REGION = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

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
	 * The feature id for the '<em><b>Edge Role</b></em>' reference.
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
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__REGION = EDGE__REGION;

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
	 * The number of structural features of the '<em>Navigable Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Edge Role</b></em>' reference.
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
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__REGION = NAVIGABLE_EDGE__REGION;

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
	 * The number of structural features of the '<em>Cast Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE_FEATURE_COUNT = NAVIGABLE_EDGE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_ANALYSIS__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_ANALYSIS__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_ANALYSIS__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_ANALYSIS__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The number of structural features of the '<em>Class Datum Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_ANALYSIS_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_ANALYSIS___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_ANALYSIS___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Class Datum Analysis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM_ANALYSIS_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_EDGES = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NODE_ROLE = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_EDGES = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__REGION = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 5;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__REGION = NODE__REGION;

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
	 * The number of structural features of the '<em>Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTION_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

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
	 * The number of structural features of the '<em>Datum Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATUM_CONNECTION_FEATURE_COUNT = CONNECTION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__REGION = NODE__REGION;

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
	 * The number of structural features of the '<em>Edge Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_CONNECTION_FEATURE_COUNT = DATUM_CONNECTION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__REGION = NODE__REGION;

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
	 * The feature id for the '<em><b>Edge Role</b></em>' reference.
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
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__REGION = EDGE__REGION;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__REGION = NODE__REGION;

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
	 * The feature id for the '<em><b>Edge Role</b></em>' reference.
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
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__REGION = EDGE__REGION;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__REGION = NODE__REGION;

	/**
	 * The number of structural features of the '<em>Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__NODE_ROLE = VARIABLE_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__OUTGOING_EDGES = VARIABLE_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__REGION = VARIABLE_NODE__REGION;

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
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__EDGES = MAPPING_REGION__EDGES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__NODES = MAPPING_REGION__NODES;

	/**
	 * The number of structural features of the '<em>Micro Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION_FEATURE_COUNT = MAPPING_REGION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REGION__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REGION__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REGION__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REGION__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The number of structural features of the '<em>Multi Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REGION_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REGION___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REGION___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Multi Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTI_REGION_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl <em>Named Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNamedMappingRegion()
	 * @generated
	 */
	int NAMED_MAPPING_REGION = 22;

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
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__EDGES = MAPPING_REGION__EDGES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__NODES = MAPPING_REGION__NODES;

	/**
	 * The number of structural features of the '<em>Named Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION_FEATURE_COUNT = MAPPING_REGION_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Edge Role</b></em>' reference.
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
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__REGION = NAVIGABLE_EDGE__REGION;

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
	 * The number of structural features of the '<em>Navigation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE_FEATURE_COUNT = NAVIGABLE_EDGE_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Node Connection</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_CONNECTION_FEATURE_COUNT = DATUM_CONNECTION_FEATURE_COUNT + 0;

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
	int NULL_NODE = 27;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE__REGION = NODE__REGION;

	/**
	 * The number of structural features of the '<em>Null Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

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
	int OPERATION_NODE = 28;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__REGION = NODE__REGION;

	/**
	 * The number of structural features of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__EDGES = REGION__EDGES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__NODES = REGION__NODES;

	/**
	 * The number of structural features of the '<em>Operation Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 0;

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
	int PATTERN_TYPED_NODE = 30;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__REGION = NODE__REGION;

	/**
	 * The number of structural features of the '<em>Pattern Typed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

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
	int PATTERN_VARIABLE_NODE = 31;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__NODE_ROLE = VARIABLE_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__OUTGOING_EDGES = VARIABLE_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__REGION = VARIABLE_NODE__REGION;

	/**
	 * The number of structural features of the '<em>Pattern Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE_FEATURE_COUNT = VARIABLE_NODE_FEATURE_COUNT + 0;

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
	int PREDICATE_EDGE = 32;

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
	 * The feature id for the '<em><b>Edge Role</b></em>' reference.
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
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__REGION = EDGE__REGION;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl <em>Recursion Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRecursionEdge()
	 * @generated
	 */
	int RECURSION_EDGE = 34;

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
	 * The feature id for the '<em><b>Edge Role</b></em>' reference.
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
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__REGION = EDGE__REGION;

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
	 * The number of structural features of the '<em>Recursion Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootCompositionRegionImpl <em>Root Composition Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RootCompositionRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRootCompositionRegion()
	 * @generated
	 */
	int ROOT_COMPOSITION_REGION = 37;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION__ANNOTATING_COMMENTS = REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION__OWNED_ANNOTATIONS = REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION__OWNED_COMMENTS = REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION__OWNED_EXTENSIONS = REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION__SYMBOL_NAME = REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION__EDGES = REGION__EDGES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION__NODES = REGION__NODES;

	/**
	 * The number of structural features of the '<em>Root Composition Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION___ALL_OWNED_ELEMENTS = REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION___GET_VALUE__TYPE_STRING = REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Root Composition Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROOT_COMPOSITION_REGION_OPERATION_COUNT = REGION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduledRegionImpl <em>Scheduled Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduledRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getScheduledRegion()
	 * @generated
	 */
	int SCHEDULED_REGION = 38;

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
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__EDGES = REGION__EDGES;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__NODES = REGION__NODES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__NAME = REGION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Scheduled Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.SchedulerConstantsImpl <em>Scheduler Constants</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.SchedulerConstantsImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSchedulerConstants()
	 * @generated
	 */
	int SCHEDULER_CONSTANTS = 39;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONSTANTS__ANNOTATING_COMMENTS = PivotPackage.ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONSTANTS__OWNED_ANNOTATIONS = PivotPackage.ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONSTANTS__OWNED_COMMENTS = PivotPackage.ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONSTANTS__OWNED_EXTENSIONS = PivotPackage.ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The number of structural features of the '<em>Scheduler Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONSTANTS_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONSTANTS___ALL_OWNED_ELEMENTS = PivotPackage.ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONSTANTS___GET_VALUE__TYPE_STRING = PivotPackage.ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Scheduler Constants</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_CONSTANTS_OPERATION_COUNT = PivotPackage.ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable <em>Symbolable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSymbolable()
	 * @generated
	 */
	int SYMBOLABLE = 40;

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
	int TRUE_NODE = 41;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRUE_NODE__REGION = NODE__REGION;

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
	int UNKNOWN_NODE = 42;

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
	 * The feature id for the '<em><b>Node Role</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__REGION = NODE__REGION;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge <em>Graph Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getGraphEdge()
	 * @generated
	 */
	int GRAPH_EDGE = 44;

	/**
	 * The number of structural features of the '<em>Graph Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Graph Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_EDGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode <em>Graph Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getGraphNode()
	 * @generated
	 */
	int GRAPH_NODE = 45;

	/**
	 * The number of structural features of the '<em>Graph Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Graph Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPH_NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable <em>To DO Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getToDOTable()
	 * @generated
	 */
	int TO_DO_TABLE = 46;

	/**
	 * The number of structural features of the '<em>To DO Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_DO_TABLE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>To DO Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TO_DO_TABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Phase <em>Phase</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Phase
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPhase()
	 * @generated
	 */
	int PHASE = 47;


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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion <em>Basic Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Basic Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion
	 * @generated
	 */
	EClass getBasicMappingRegion();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis <em>Class Datum Analysis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Datum Analysis</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatumAnalysis
	 * @generated
	 */
	EClass getClassDatumAnalysis();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connection End</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
	 * @generated
	 */
	EClass getConnectionEnd();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.DatumConnection <em>Datum Connection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Datum Connection</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DatumConnection
	 * @generated
	 */
	EClass getDatumConnection();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getEdgeRole <em>Edge Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edge Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getEdgeRole()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_EdgeRole();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getRegion()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Region();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.RootCompositionRegion <em>Root Composition Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Root Composition Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RootCompositionRegion
	 * @generated
	 */
	EClass getRootCompositionRegion();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.SchedulerConstants <em>Scheduler Constants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduler Constants</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.SchedulerConstants
	 * @generated
	 */
	EClass getSchedulerConstants();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge <em>Graph Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge
	 * @model instanceClass="org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge"
	 * @generated
	 */
	EClass getGraphEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode <em>Graph Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graph Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode
	 * @model instanceClass="org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode"
	 * @generated
	 */
	EClass getGraphNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable <em>To DO Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>To DO Table</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable
	 * @model instanceClass="org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable"
	 * @generated
	 */
	EClass getToDOTable();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MultiRegion <em>Multi Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multi Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MultiRegion
	 * @generated
	 */
	EClass getMultiRegion();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge <em>Navigable Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigable Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge
	 * @generated
	 */
	EClass getNavigableEdge();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getNodeRole <em>Node Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node Role</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getNodeRole()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_NodeRole();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getRegion()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Region();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NullNode <em>Null Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NullNode
	 * @generated
	 */
	EClass getNullNode();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion <em>Operation Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion
	 * @generated
	 */
	EClass getOperationRegion();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode <em>Pattern Variable Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Variable Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode
	 * @generated
	 */
	EClass getPatternVariableNode();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge <em>Recursion Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recursion Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RecursionEdge
	 * @generated
	 */
	EClass getRecursionEdge();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getEdges()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Edges();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getNodes()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_Nodes();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl <em>Basic Mapping Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getBasicMappingRegion()
		 * @generated
		 */
		EClass BASIC_MAPPING_REGION = eINSTANCE.getBasicMappingRegion();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl <em>Class Datum Analysis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumAnalysisImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getClassDatumAnalysis()
		 * @generated
		 */
		EClass CLASS_DATUM_ANALYSIS = eINSTANCE.getClassDatumAnalysis();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionEnd()
		 * @generated
		 */
		EClass CONNECTION_END = eINSTANCE.getConnectionEnd();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl <em>Datum Connection</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDatumConnection()
		 * @generated
		 */
		EClass DATUM_CONNECTION = eINSTANCE.getDatumConnection();

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
		 * The meta object literal for the '<em><b>Edge Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__EDGE_ROLE = eINSTANCE.getEdge_EdgeRole();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__NAME = eINSTANCE.getEdge_Name();

		/**
		 * The meta object literal for the '<em><b>Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__REGION = eINSTANCE.getEdge_Region();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RootCompositionRegionImpl <em>Root Composition Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RootCompositionRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRootCompositionRegion()
		 * @generated
		 */
		EClass ROOT_COMPOSITION_REGION = eINSTANCE.getRootCompositionRegion();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.SchedulerConstantsImpl <em>Scheduler Constants</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.SchedulerConstantsImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSchedulerConstants()
		 * @generated
		 */
		EClass SCHEDULER_CONSTANTS = eINSTANCE.getSchedulerConstants();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge <em>Graph Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getGraphEdge()
		 * @generated
		 */
		EClass GRAPH_EDGE = eINSTANCE.getGraphEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode <em>Graph Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getGraphNode()
		 * @generated
		 */
		EClass GRAPH_NODE = eINSTANCE.getGraphNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable <em>To DO Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT.ToDOTable
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getToDOTable()
		 * @generated
		 */
		EClass TO_DO_TABLE = eINSTANCE.getToDOTable();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MultiRegionImpl <em>Multi Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MultiRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMultiRegion()
		 * @generated
		 */
		EClass MULTI_REGION = eINSTANCE.getMultiRegion();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl <em>Navigable Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigableEdge()
		 * @generated
		 */
		EClass NAVIGABLE_EDGE = eINSTANCE.getNavigableEdge();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Node Role</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__NODE_ROLE = eINSTANCE.getNode_NodeRole();

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
		 * The meta object literal for the '<em><b>Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__REGION = eINSTANCE.getNode_Region();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NullNodeImpl <em>Null Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NullNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNullNode()
		 * @generated
		 */
		EClass NULL_NODE = eINSTANCE.getNullNode();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl <em>Operation Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationRegion()
		 * @generated
		 */
		EClass OPERATION_REGION = eINSTANCE.getOperationRegion();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl <em>Pattern Variable Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPatternVariableNode()
		 * @generated
		 */
		EClass PATTERN_VARIABLE_NODE = eINSTANCE.getPatternVariableNode();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl <em>Recursion Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRecursionEdge()
		 * @generated
		 */
		EClass RECURSION_EDGE = eINSTANCE.getRecursionEdge();

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
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__EDGES = eINSTANCE.getRegion_Edges();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__NODES = eINSTANCE.getRegion_Nodes();

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
