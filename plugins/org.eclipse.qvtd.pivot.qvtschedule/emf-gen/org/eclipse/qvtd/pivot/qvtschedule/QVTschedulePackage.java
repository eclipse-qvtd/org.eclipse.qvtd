/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
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
	int ABSTRACT_DATUM__ANNOTATING_COMMENTS = PivotPackage.NAMED_ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__OWNED_ANNOTATIONS = PivotPackage.NAMED_ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__OWNED_COMMENTS = PivotPackage.NAMED_ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__OWNED_EXTENSIONS = PivotPackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__NAME = PivotPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM__REFERRED_TYPED_MODEL = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_FEATURE_COUNT = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM___ALL_OWNED_ELEMENTS = PivotPackage.NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM___GET_VALUE__TYPE_STRING = PivotPackage.NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Abstract Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_DATUM_OPERATION_COUNT = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl <em>Class Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getClassDatum()
	 * @generated
	 */
	int CLASS_DATUM = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl <em>Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnection()
	 * @generated
	 */
	int CONNECTION = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd <em>Connection End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionEnd()
	 * @generated
	 */
	int CONNECTION_END = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl <em>Datum Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DatumConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDatumConnection()
	 * @generated
	 */
	int DATUM_CONNECTION = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl <em>Edge Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EdgeConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEdgeConnection()
	 * @generated
	 */
	int EDGE_CONNECTION = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Role <em>Role</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Role
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRole()
	 * @generated
	 */
	int ROLE = 70;

	/**
	 * The meta object id for the '<em>Number</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Number
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNumber()
	 * @generated
	 */
	int NUMBER = 71;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl <em>Navigable Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigableEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigableEdge()
	 * @generated
	 */
	int NAVIGABLE_EDGE = 37;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNode()
	 * @generated
	 */
	int NODE = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl <em>Node Connection</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNodeConnection()
	 * @generated
	 */
	int NODE_CONNECTION = 40;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl <em>Operation Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationRegion()
	 * @generated
	 */
	int OPERATION_REGION = 45;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl <em>Property Datum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPropertyDatum()
	 * @generated
	 */
	int PROPERTY_DATUM = 51;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl <em>Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRegion()
	 * @generated
	 */
	int REGION = 53;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl <em>Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingRegion()
	 * @generated
	 */
	int MAPPING_REGION = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl <em>Navigation Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NavigationEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNavigationEdge()
	 * @generated
	 */
	int NAVIGATION_EDGE = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl <em>Cast Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCastEdge()
	 * @generated
	 */
	int CAST_EDGE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDependencyNode()
	 * @generated
	 */
	int DEPENDENCY_NODE = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl <em>Error Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ErrorNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getErrorNode()
	 * @generated
	 */
	int ERROR_NODE = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl <em>Expression Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ExpressionEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getExpressionEdge()
	 * @generated
	 */
	int EXPRESSION_EDGE = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl <em>Input Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.InputNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getInputNode()
	 * @generated
	 */
	int INPUT_NODE = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl <em>Iterated Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratedEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratedEdge()
	 * @generated
	 */
	int ITERATED_EDGE = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl <em>Variable Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.VariableNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getVariableNode()
	 * @generated
	 */
	int VARIABLE_NODE = 67;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl <em>Iterator Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IteratorNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIteratorNode()
	 * @generated
	 */
	int ITERATOR_NODE = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl <em>Composed Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ComposedNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getComposedNode()
	 * @generated
	 */
	int COMPOSED_NODE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl <em>Micro Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMicroMappingRegion()
	 * @generated
	 */
	int MICRO_MAPPING_REGION = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl <em>Loading Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.LoadingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getLoadingRegion()
	 * @generated
	 */
	int LOADING_REGION = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl <em>Named Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NamedMappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNamedMappingRegion()
	 * @generated
	 */
	int NAMED_MAPPING_REGION = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationNodeImpl <em>Operation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationNode()
	 * @generated
	 */
	int OPERATION_NODE = 44;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PatternTypedNodeImpl <em>Pattern Typed Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PatternTypedNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPatternTypedNode()
	 * @generated
	 */
	int PATTERN_TYPED_NODE = 48;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl <em>Pattern Variable Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PatternVariableNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPatternVariableNode()
	 * @generated
	 */
	int PATTERN_VARIABLE_NODE = 49;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PredicateEdgeImpl <em>Predicate Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.PredicateEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getPredicateEdge()
	 * @generated
	 */
	int PREDICATE_EDGE = 50;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl <em>Recursion Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RecursionEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRecursionEdge()
	 * @generated
	 */
	int RECURSION_EDGE = 52;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl <em>Rule Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRuleRegion()
	 * @generated
	 */
	int RULE_REGION = 54;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl <em>Schedule Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getScheduleModel()
	 * @generated
	 */
	int SCHEDULE_MODEL = 55;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduledRegionImpl <em>Scheduled Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduledRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getScheduledRegion()
	 * @generated
	 */
	int SCHEDULED_REGION = 56;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.Symbolable <em>Symbolable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Symbolable
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSymbolable()
	 * @generated
	 */
	int SYMBOLABLE = 62;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.UnknownNodeImpl <em>Unknown Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.UnknownNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getUnknownNode()
	 * @generated
	 */
	int UNKNOWN_NODE = 66;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.KeyedValueNodeImpl <em>Keyed Value Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.KeyedValueNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getKeyedValueNode()
	 * @generated
	 */
	int KEYED_VALUE_NODE = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DispatchRegionImpl <em>Dispatch Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DispatchRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDispatchRegion()
	 * @generated
	 */
	int DISPATCH_REGION = 16;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__CLUSTER = PivotPackage.ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__EDGE_ROLE = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__NAME = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__OWNING_REGION = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__SOURCE_NODE = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TARGET_NODE = PivotPackage.ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 6;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_EDGE__CLUSTER = EDGE__CLUSTER;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ArgumentEdgeImpl <em>Argument Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ArgumentEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getArgumentEdge()
	 * @generated
	 */
	int ARGUMENT_EDGE = 1;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__ANNOTATING_COMMENTS = EXPRESSION_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__OWNED_ANNOTATIONS = EXPRESSION_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__OWNED_COMMENTS = EXPRESSION_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__OWNED_EXTENSIONS = EXPRESSION_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__CLUSTER = EXPRESSION_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__EDGE_ROLE = EXPRESSION_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__NAME = EXPRESSION_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__OWNING_REGION = EXPRESSION_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__SOURCE_NODE = EXPRESSION_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE__TARGET_NODE = EXPRESSION_EDGE__TARGET_NODE;

	/**
	 * The number of structural features of the '<em>Argument Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE_FEATURE_COUNT = EXPRESSION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE___ALL_OWNED_ELEMENTS = EXPRESSION_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE___GET_VALUE__TYPE_STRING = EXPRESSION_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Argument Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARGUMENT_EDGE_OPERATION_COUNT = EXPRESSION_EDGE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__CLUSTER = PivotPackage.ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_CONNECTION = PivotPackage.ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__INCOMING_EDGES = PivotPackage.ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = PivotPackage.ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NODE_ROLE = PivotPackage.ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_CONNECTIONS = PivotPackage.ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OUTGOING_EDGES = PivotPackage.ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__OWNING_REGION = PivotPackage.ELEMENT_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = PivotPackage.ELEMENT_FEATURE_COUNT + 9;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingNodeImpl <em>Mapping Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingNode()
	 * @generated
	 */
	int MAPPING_NODE = 33;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__ANNOTATING_COMMENTS = NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__OWNED_ANNOTATIONS = NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__OWNED_COMMENTS = NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__OWNED_EXTENSIONS = NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__CLASS_DATUM = NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__CLUSTER = NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__INCOMING_CONNECTION = NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__NODE_ROLE = NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__OUTGOING_CONNECTIONS = NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__OUTGOING_EDGES = NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__OWNING_REGION = NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE__MATCHED = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mapping Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE___ALL_OWNED_ELEMENTS = NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE___GET_VALUE__TYPE_STRING = NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Mapping Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__ANNOTATING_COMMENTS = MAPPING_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OWNED_ANNOTATIONS = MAPPING_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OWNED_COMMENTS = MAPPING_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OWNED_EXTENSIONS = MAPPING_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__CLASS_DATUM = MAPPING_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__CLUSTER = MAPPING_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__INCOMING_CONNECTION = MAPPING_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__INCOMING_EDGES = MAPPING_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__NAME = MAPPING_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__NODE_ROLE = MAPPING_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OUTGOING_CONNECTIONS = MAPPING_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OUTGOING_EDGES = MAPPING_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__OWNING_REGION = MAPPING_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE__MATCHED = MAPPING_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE___ALL_OWNED_ELEMENTS = MAPPING_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE___GET_VALUE__TYPE_STRING = MAPPING_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Operation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_NODE_OPERATION_COUNT = MAPPING_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BooleanLiteralNodeImpl <em>Boolean Literal Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.BooleanLiteralNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getBooleanLiteralNode()
	 * @generated
	 */
	int BOOLEAN_LITERAL_NODE = 2;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The feature id for the '<em><b>Boolean Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE__BOOLEAN_VALUE = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Boolean Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Boolean Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOLEAN_LITERAL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGABLE_EDGE__CLUSTER = EDGE__CLUSTER;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAST_EDGE__CLUSTER = NAVIGABLE_EDGE__CLUSTER;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__NAME = ABSTRACT_DATUM__NAME;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__REFERRED_TYPED_MODEL = ABSTRACT_DATUM__REFERRED_TYPED_MODEL;

	/**
	 * The feature id for the '<em><b>Complete Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__COMPLETE_CLASS = ABSTRACT_DATUM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Property Datums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_DATUM__OWNED_PROPERTY_DATUMS = ABSTRACT_DATUM_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl <em>Cluster</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCluster()
	 * @generated
	 */
	int CLUSTER = 5;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__ANNOTATING_COMMENTS = PivotPackage.NAMED_ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__OWNED_ANNOTATIONS = PivotPackage.NAMED_ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__OWNED_COMMENTS = PivotPackage.NAMED_ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__OWNED_EXTENSIONS = PivotPackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__NAME = PivotPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__SYMBOL_NAME = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__OWNING_REGION = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Member Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__MEMBER_NODES = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Member Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__MEMBER_EDGES = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Preceding Clusters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__PRECEDING_CLUSTERS = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Succeeding Clusters</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__SUCCEEDING_CLUSTERS = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Depth</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER__DEPTH = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Cluster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_FEATURE_COUNT = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 7;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER___ALL_OWNED_ELEMENTS = PivotPackage.NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER___GET_VALUE__TYPE_STRING = PivotPackage.NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Cluster</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLUSTER_OPERATION_COUNT = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionLiteralNodeImpl <em>Collection Literal Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionLiteralNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionLiteralNode()
	 * @generated
	 */
	int COLLECTION_LITERAL_NODE = 6;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Collection Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Collection Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_LITERAL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionPartEdgeImpl <em>Collection Part Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionPartEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionPartEdge()
	 * @generated
	 */
	int COLLECTION_PART_EDGE = 7;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__ANNOTATING_COMMENTS = ARGUMENT_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__OWNED_ANNOTATIONS = ARGUMENT_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__OWNED_COMMENTS = ARGUMENT_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__OWNED_EXTENSIONS = ARGUMENT_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__CLUSTER = ARGUMENT_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__EDGE_ROLE = ARGUMENT_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__NAME = ARGUMENT_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__OWNING_REGION = ARGUMENT_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__SOURCE_NODE = ARGUMENT_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__TARGET_NODE = ARGUMENT_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Referred Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE__REFERRED_PART = ARGUMENT_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE_FEATURE_COUNT = ARGUMENT_EDGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE___ALL_OWNED_ELEMENTS = ARGUMENT_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE___GET_VALUE__TYPE_STRING = ARGUMENT_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Collection Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PART_EDGE_OPERATION_COUNT = ARGUMENT_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionRangeNodeImpl <em>Collection Range Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionRangeNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionRangeNode()
	 * @generated
	 */
	int COLLECTION_RANGE_NODE = 8;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Collection Range Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Collection Range Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_RANGE_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSED_NODE__CLUSTER = NODE__CLUSTER;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyEdgeImpl <em>Dependency Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDependencyEdge()
	 * @generated
	 */
	int DEPENDENCY_EDGE = 14;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__ANNOTATING_COMMENTS = PivotPackage.NAMED_ELEMENT__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_ANNOTATIONS = PivotPackage.NAMED_ELEMENT__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_COMMENTS = PivotPackage.NAMED_ELEMENT__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_EXTENSIONS = PivotPackage.NAMED_ELEMENT__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__NAME = PivotPackage.NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__SYMBOL_NAME = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_NODES = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_EDGES = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION__OWNED_CLUSTERS = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_FEATURE_COUNT = PivotPackage.NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___ALL_OWNED_ELEMENTS = PivotPackage.NAMED_ELEMENT___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION___GET_VALUE__TYPE_STRING = PivotPackage.NAMED_ELEMENT___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REGION_OPERATION_COUNT = PivotPackage.NAMED_ELEMENT_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__NAME = REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__SYMBOL_NAME = REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNED_NODES = REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNED_EDGES = REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNED_CLUSTERS = REGION__OWNED_CLUSTERS;

	/**
	 * The feature id for the '<em><b>Head Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__HEAD_NODES = REGION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__OWNING_SCHEDULE_MODEL = REGION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scheduled Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION__SCHEDULED_REGION = REGION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 3;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicMappingRegionImpl <em>Cyclic Mapping Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicMappingRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCyclicMappingRegion()
	 * @generated
	 */
	int CYCLIC_MAPPING_REGION = 12;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__ANNOTATING_COMMENTS = MAPPING_REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__OWNED_ANNOTATIONS = MAPPING_REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__OWNED_COMMENTS = MAPPING_REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__OWNED_EXTENSIONS = MAPPING_REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__NAME = MAPPING_REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__SYMBOL_NAME = MAPPING_REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__OWNED_NODES = MAPPING_REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__OWNED_EDGES = MAPPING_REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__OWNED_CLUSTERS = MAPPING_REGION__OWNED_CLUSTERS;

	/**
	 * The feature id for the '<em><b>Head Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__HEAD_NODES = MAPPING_REGION__HEAD_NODES;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__OWNING_SCHEDULE_MODEL = MAPPING_REGION__OWNING_SCHEDULE_MODEL;

	/**
	 * The feature id for the '<em><b>Scheduled Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__SCHEDULED_REGION = MAPPING_REGION__SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Element Regions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION__ELEMENT_REGIONS = MAPPING_REGION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Cyclic Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION_FEATURE_COUNT = MAPPING_REGION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION___ALL_OWNED_ELEMENTS = MAPPING_REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION___GET_VALUE__TYPE_STRING = MAPPING_REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Cyclic Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCLIC_MAPPING_REGION_OPERATION_COUNT = MAPPING_REGION_OPERATION_COUNT + 0;

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
	int DEPENDENCY_EDGE__ANNOTATING_COMMENTS = EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__OWNED_ANNOTATIONS = EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__OWNED_COMMENTS = EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__OWNED_EXTENSIONS = EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__CLUSTER = EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__EDGE_ROLE = EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__NAME = EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__OWNING_REGION = EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__SOURCE_NODE = EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE__TARGET_NODE = EDGE__TARGET_NODE;

	/**
	 * The number of structural features of the '<em>Dependency Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE___ALL_OWNED_ELEMENTS = EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE___GET_VALUE__TYPE_STRING = EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Dependency Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_EDGE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_NODE__CLUSTER = NODE__CLUSTER;

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
	int RULE_REGION__ANNOTATING_COMMENTS = MAPPING_REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__OWNED_ANNOTATIONS = MAPPING_REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__OWNED_COMMENTS = MAPPING_REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__OWNED_EXTENSIONS = MAPPING_REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__NAME = MAPPING_REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__SYMBOL_NAME = MAPPING_REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__OWNED_NODES = MAPPING_REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__OWNED_EDGES = MAPPING_REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__OWNED_CLUSTERS = MAPPING_REGION__OWNED_CLUSTERS;

	/**
	 * The feature id for the '<em><b>Head Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__HEAD_NODES = MAPPING_REGION__HEAD_NODES;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__OWNING_SCHEDULE_MODEL = MAPPING_REGION__OWNING_SCHEDULE_MODEL;

	/**
	 * The feature id for the '<em><b>Scheduled Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__SCHEDULED_REGION = MAPPING_REGION__SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Referred Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION__REFERRED_RULE = MAPPING_REGION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rule Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION_FEATURE_COUNT = MAPPING_REGION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION___ALL_OWNED_ELEMENTS = MAPPING_REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION___GET_VALUE__TYPE_STRING = MAPPING_REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Rule Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_REGION_OPERATION_COUNT = MAPPING_REGION_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__ANNOTATING_COMMENTS = RULE_REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__OWNED_ANNOTATIONS = RULE_REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__OWNED_COMMENTS = RULE_REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__OWNED_EXTENSIONS = RULE_REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__NAME = RULE_REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__SYMBOL_NAME = RULE_REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__OWNED_NODES = RULE_REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__OWNED_EDGES = RULE_REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__OWNED_CLUSTERS = RULE_REGION__OWNED_CLUSTERS;

	/**
	 * The feature id for the '<em><b>Head Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__HEAD_NODES = RULE_REGION__HEAD_NODES;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__OWNING_SCHEDULE_MODEL = RULE_REGION__OWNING_SCHEDULE_MODEL;

	/**
	 * The feature id for the '<em><b>Scheduled Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__SCHEDULED_REGION = RULE_REGION__SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Referred Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__REFERRED_RULE = RULE_REGION__REFERRED_RULE;

	/**
	 * The feature id for the '<em><b>Referred Rule Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION__REFERRED_RULE_REGION = RULE_REGION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dispatch Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION_FEATURE_COUNT = RULE_REGION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION___ALL_OWNED_ELEMENTS = RULE_REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION___GET_VALUE__TYPE_STRING = RULE_REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Dispatch Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISPATCH_REGION_OPERATION_COUNT = RULE_REGION_OPERATION_COUNT + 0;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EnumLiteralNodeImpl <em>Enum Literal Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EnumLiteralNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEnumLiteralNode()
	 * @generated
	 */
	int ENUM_LITERAL_NODE = 19;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The feature id for the '<em><b>Enum Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE__ENUM_VALUE = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enum Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Enum Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUM_LITERAL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__ANNOTATING_COMMENTS = MAPPING_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OWNED_ANNOTATIONS = MAPPING_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OWNED_COMMENTS = MAPPING_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OWNED_EXTENSIONS = MAPPING_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__CLASS_DATUM = MAPPING_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__CLUSTER = MAPPING_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__INCOMING_CONNECTION = MAPPING_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__INCOMING_EDGES = MAPPING_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__NAME = MAPPING_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__NODE_ROLE = MAPPING_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OUTGOING_CONNECTIONS = MAPPING_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OUTGOING_EDGES = MAPPING_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__OWNING_REGION = MAPPING_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE__MATCHED = MAPPING_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Error Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE___ALL_OWNED_ELEMENTS = MAPPING_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE___GET_VALUE__TYPE_STRING = MAPPING_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Error Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ERROR_NODE_OPERATION_COUNT = MAPPING_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IfNodeImpl <em>If Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IfNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIfNode()
	 * @generated
	 */
	int IF_NODE = 22;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>If Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>If Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IncludesEdgeImpl <em>Includes Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IncludesEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIncludesEdge()
	 * @generated
	 */
	int INCLUDES_EDGE = 23;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__ANNOTATING_COMMENTS = EXPRESSION_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__OWNED_ANNOTATIONS = EXPRESSION_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__OWNED_COMMENTS = EXPRESSION_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__OWNED_EXTENSIONS = EXPRESSION_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__CLUSTER = EXPRESSION_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__EDGE_ROLE = EXPRESSION_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__NAME = EXPRESSION_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__OWNING_REGION = EXPRESSION_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__SOURCE_NODE = EXPRESSION_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE__TARGET_NODE = EXPRESSION_EDGE__TARGET_NODE;

	/**
	 * The number of structural features of the '<em>Includes Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE_FEATURE_COUNT = EXPRESSION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE___ALL_OWNED_ELEMENTS = EXPRESSION_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE___GET_VALUE__TYPE_STRING = EXPRESSION_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Includes Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCLUDES_EDGE_OPERATION_COUNT = EXPRESSION_EDGE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_NODE__CLUSTER = NODE__CLUSTER;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATED_EDGE__CLUSTER = EDGE__CLUSTER;

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
	int VARIABLE_NODE__ANNOTATING_COMMENTS = MAPPING_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OWNED_ANNOTATIONS = MAPPING_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OWNED_COMMENTS = MAPPING_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OWNED_EXTENSIONS = MAPPING_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__CLASS_DATUM = MAPPING_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__CLUSTER = MAPPING_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__INCOMING_CONNECTION = MAPPING_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__INCOMING_EDGES = MAPPING_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__NAME = MAPPING_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__NODE_ROLE = MAPPING_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OUTGOING_CONNECTIONS = MAPPING_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OUTGOING_EDGES = MAPPING_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__OWNING_REGION = MAPPING_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__MATCHED = MAPPING_NODE__MATCHED;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE__REFERRED_VARIABLE = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE___ALL_OWNED_ELEMENTS = MAPPING_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE___GET_VALUE__TYPE_STRING = MAPPING_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Variable Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NODE_OPERATION_COUNT = MAPPING_NODE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__CLUSTER = VARIABLE_NODE__CLUSTER;

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
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATOR_NODE__MATCHED = VARIABLE_NODE__MATCHED;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.KeyPartEdgeImpl <em>Key Part Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.KeyPartEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getKeyPartEdge()
	 * @generated
	 */
	int KEY_PART_EDGE = 27;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__ANNOTATING_COMMENTS = ARGUMENT_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__OWNED_ANNOTATIONS = ARGUMENT_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__OWNED_COMMENTS = ARGUMENT_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__OWNED_EXTENSIONS = ARGUMENT_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__CLUSTER = ARGUMENT_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__EDGE_ROLE = ARGUMENT_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__NAME = ARGUMENT_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__OWNING_REGION = ARGUMENT_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__SOURCE_NODE = ARGUMENT_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__TARGET_NODE = ARGUMENT_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Referred Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE__REFERRED_PART = ARGUMENT_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Key Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE_FEATURE_COUNT = ARGUMENT_EDGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE___ALL_OWNED_ELEMENTS = ARGUMENT_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE___GET_VALUE__TYPE_STRING = ARGUMENT_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Key Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEY_PART_EDGE_OPERATION_COUNT = ARGUMENT_EDGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The feature id for the '<em><b>Class Datum Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE__CLASS_DATUM_VALUE = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Keyed Value Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Keyed Value Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int KEYED_VALUE_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__NAME = REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__SYMBOL_NAME = REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNED_NODES = REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNED_EDGES = REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNED_CLUSTERS = REGION__OWNED_CLUSTERS;

	/**
	 * The feature id for the '<em><b>Owning Scheduled Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION__OWNING_SCHEDULED_REGION = REGION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Loading Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOADING_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 1;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MapLiteralNodeImpl <em>Map Literal Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MapLiteralNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMapLiteralNode()
	 * @generated
	 */
	int MAP_LITERAL_NODE = 30;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Map Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Map Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_LITERAL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartEdgeImpl <em>Map Part Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMapPartEdge()
	 * @generated
	 */
	int MAP_PART_EDGE = 31;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__ANNOTATING_COMMENTS = ARGUMENT_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__OWNED_ANNOTATIONS = ARGUMENT_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__OWNED_COMMENTS = ARGUMENT_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__OWNED_EXTENSIONS = ARGUMENT_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__CLUSTER = ARGUMENT_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__EDGE_ROLE = ARGUMENT_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__NAME = ARGUMENT_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__OWNING_REGION = ARGUMENT_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__SOURCE_NODE = ARGUMENT_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__TARGET_NODE = ARGUMENT_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Referred Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE__REFERRED_PART = ARGUMENT_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Map Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE_FEATURE_COUNT = ARGUMENT_EDGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE___ALL_OWNED_ELEMENTS = ARGUMENT_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE___GET_VALUE__TYPE_STRING = ARGUMENT_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Map Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_EDGE_OPERATION_COUNT = ARGUMENT_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartNodeImpl <em>Map Part Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMapPartNode()
	 * @generated
	 */
	int MAP_PART_NODE = 32;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Map Part Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Map Part Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_PART_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__NAME = MAPPING_REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__SYMBOL_NAME = MAPPING_REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNED_NODES = MAPPING_REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNED_EDGES = MAPPING_REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNED_CLUSTERS = MAPPING_REGION__OWNED_CLUSTERS;

	/**
	 * The feature id for the '<em><b>Head Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__HEAD_NODES = MAPPING_REGION__HEAD_NODES;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__OWNING_SCHEDULE_MODEL = MAPPING_REGION__OWNING_SCHEDULE_MODEL;

	/**
	 * The feature id for the '<em><b>Scheduled Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MICRO_MAPPING_REGION__SCHEDULED_REGION = MAPPING_REGION__SCHEDULED_REGION;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__NAME = MAPPING_REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__SYMBOL_NAME = MAPPING_REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNED_NODES = MAPPING_REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNED_EDGES = MAPPING_REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNED_CLUSTERS = MAPPING_REGION__OWNED_CLUSTERS;

	/**
	 * The feature id for the '<em><b>Head Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__HEAD_NODES = MAPPING_REGION__HEAD_NODES;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__OWNING_SCHEDULE_MODEL = MAPPING_REGION__OWNING_SCHEDULE_MODEL;

	/**
	 * The feature id for the '<em><b>Scheduled Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__SCHEDULED_REGION = MAPPING_REGION__SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Symbol Name Suffix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION__SYMBOL_NAME_SUFFIX = MAPPING_REGION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Mapping Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_MAPPING_REGION_FEATURE_COUNT = MAPPING_REGION_FEATURE_COUNT + 1;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_EDGE__CLUSTER = NAVIGABLE_EDGE__CLUSTER;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NullLiteralNodeImpl <em>Null Literal Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NullLiteralNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNullLiteralNode()
	 * @generated
	 */
	int NULL_LITERAL_NODE = 41;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Null Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Null Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NULL_LITERAL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NumericLiteralNodeImpl <em>Numeric Literal Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NumericLiteralNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNumericLiteralNode()
	 * @generated
	 */
	int NUMERIC_LITERAL_NODE = 42;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The feature id for the '<em><b>Numeric Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE__NUMERIC_VALUE = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Numeric Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Numeric Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_LITERAL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationCallNodeImpl <em>Operation Call Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationCallNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationCallNode()
	 * @generated
	 */
	int OPERATION_CALL_NODE = 43;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE__REFERRED_OPERATION = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Call Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Operation Call Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_CALL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__NAME = REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__SYMBOL_NAME = REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNED_NODES = REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNED_EDGES = REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNED_CLUSTERS = REGION__OWNED_CLUSTERS;

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
	 * The feature id for the '<em><b>Referred Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__REFERRED_OPERATION = REGION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Result Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__RESULT_NODE = REGION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_REGION__OWNING_SCHEDULE_MODEL = REGION_FEATURE_COUNT + 4;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationParameterEdgeImpl <em>Operation Parameter Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationParameterEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationParameterEdge()
	 * @generated
	 */
	int OPERATION_PARAMETER_EDGE = 46;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__ANNOTATING_COMMENTS = ARGUMENT_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__OWNED_ANNOTATIONS = ARGUMENT_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__OWNED_COMMENTS = ARGUMENT_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__OWNED_EXTENSIONS = ARGUMENT_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__CLUSTER = ARGUMENT_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__EDGE_ROLE = ARGUMENT_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__NAME = ARGUMENT_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__OWNING_REGION = ARGUMENT_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__SOURCE_NODE = ARGUMENT_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__TARGET_NODE = ARGUMENT_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Referred Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__REFERRED_PARAMETER = ARGUMENT_EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE__PARAMETER_INDEX = ARGUMENT_EDGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Operation Parameter Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE_FEATURE_COUNT = ARGUMENT_EDGE_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE___ALL_OWNED_ELEMENTS = ARGUMENT_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE___GET_VALUE__TYPE_STRING = ARGUMENT_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Operation Parameter Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_PARAMETER_EDGE_OPERATION_COUNT = ARGUMENT_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationSelfEdgeImpl <em>Operation Self Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationSelfEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationSelfEdge()
	 * @generated
	 */
	int OPERATION_SELF_EDGE = 47;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__ANNOTATING_COMMENTS = ARGUMENT_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__OWNED_ANNOTATIONS = ARGUMENT_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__OWNED_COMMENTS = ARGUMENT_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__OWNED_EXTENSIONS = ARGUMENT_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__CLUSTER = ARGUMENT_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__EDGE_ROLE = ARGUMENT_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__NAME = ARGUMENT_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__OWNING_REGION = ARGUMENT_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__SOURCE_NODE = ARGUMENT_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__TARGET_NODE = ARGUMENT_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Referred Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE__REFERRED_TYPE = ARGUMENT_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Operation Self Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE_FEATURE_COUNT = ARGUMENT_EDGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE___ALL_OWNED_ELEMENTS = ARGUMENT_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE___GET_VALUE__TYPE_STRING = ARGUMENT_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Operation Self Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_SELF_EDGE_OPERATION_COUNT = ARGUMENT_EDGE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__ANNOTATING_COMMENTS = MAPPING_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OWNED_ANNOTATIONS = MAPPING_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OWNED_COMMENTS = MAPPING_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OWNED_EXTENSIONS = MAPPING_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__CLASS_DATUM = MAPPING_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__CLUSTER = MAPPING_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__INCOMING_CONNECTION = MAPPING_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__INCOMING_EDGES = MAPPING_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__NAME = MAPPING_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__NODE_ROLE = MAPPING_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OUTGOING_CONNECTIONS = MAPPING_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OUTGOING_EDGES = MAPPING_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__OWNING_REGION = MAPPING_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE__MATCHED = MAPPING_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Pattern Typed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE___ALL_OWNED_ELEMENTS = MAPPING_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE___GET_VALUE__TYPE_STRING = MAPPING_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Pattern Typed Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_TYPED_NODE_OPERATION_COUNT = MAPPING_NODE_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__CLUSTER = VARIABLE_NODE__CLUSTER;

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
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__MATCHED = VARIABLE_NODE__MATCHED;

	/**
	 * The feature id for the '<em><b>Referred Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_VARIABLE_NODE__REFERRED_VARIABLE = VARIABLE_NODE__REFERRED_VARIABLE;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PREDICATE_EDGE__CLUSTER = EDGE__CLUSTER;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__NAME = ABSTRACT_DATUM__NAME;

	/**
	 * The feature id for the '<em><b>Referred Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__REFERRED_TYPED_MODEL = ABSTRACT_DATUM__REFERRED_TYPED_MODEL;

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
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM__KEY = ABSTRACT_DATUM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Property Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_DATUM_FEATURE_COUNT = ABSTRACT_DATUM_FEATURE_COUNT + 5;

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
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECURSION_EDGE__CLUSTER = EDGE__CLUSTER;

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
	 * The feature id for the '<em><b>Xmiid Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__XMIID_VERSION = PivotPackage.MODEL__XMIID_VERSION;

	/**
	 * The feature id for the '<em><b>Owned Class Datums</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_CLASS_DATUMS = PivotPackage.MODEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Mapping Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_MAPPING_REGIONS = PivotPackage.MODEL_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Operation Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_OPERATION_REGIONS = PivotPackage.MODEL_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Scheduled Regions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS = PivotPackage.MODEL_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Schedule Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULE_MODEL_FEATURE_COUNT = PivotPackage.MODEL_FEATURE_COUNT + 4;

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__NAME = REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__SYMBOL_NAME = REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_NODES = REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_EDGES = REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_CLUSTERS = REGION__OWNED_CLUSTERS;

	/**
	 * The feature id for the '<em><b>Owned Connections</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_CONNECTIONS = REGION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Loading Region</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNED_LOADING_REGION = REGION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Mapping Regions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__MAPPING_REGIONS = REGION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__OWNING_SCHEDULE_MODEL = REGION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Referred Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION__REFERRED_TRANSFORMATION = REGION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Scheduled Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULED_REGION_FEATURE_COUNT = REGION_FEATURE_COUNT + 5;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowNodeImpl <em>Shadow Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getShadowNode()
	 * @generated
	 */
	int SHADOW_NODE = 57;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Shadow Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Shadow Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowPartEdgeImpl <em>Shadow Part Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowPartEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getShadowPartEdge()
	 * @generated
	 */
	int SHADOW_PART_EDGE = 58;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__ANNOTATING_COMMENTS = ARGUMENT_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__OWNED_ANNOTATIONS = ARGUMENT_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__OWNED_COMMENTS = ARGUMENT_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__OWNED_EXTENSIONS = ARGUMENT_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__CLUSTER = ARGUMENT_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__EDGE_ROLE = ARGUMENT_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__NAME = ARGUMENT_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__OWNING_REGION = ARGUMENT_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__SOURCE_NODE = ARGUMENT_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__TARGET_NODE = ARGUMENT_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Referred Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE__REFERRED_PART = ARGUMENT_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Shadow Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE_FEATURE_COUNT = ARGUMENT_EDGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE___ALL_OWNED_ELEMENTS = ARGUMENT_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE___GET_VALUE__TYPE_STRING = ARGUMENT_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Shadow Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHADOW_PART_EDGE_OPERATION_COUNT = ARGUMENT_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.StringLiteralNodeImpl <em>String Literal Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.StringLiteralNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getStringLiteralNode()
	 * @generated
	 */
	int STRING_LITERAL_NODE = 59;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The feature id for the '<em><b>String Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE__STRING_VALUE = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>String Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_LITERAL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessEdgeImpl <em>Success Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSuccessEdge()
	 * @generated
	 */
	int SUCCESS_EDGE = 60;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__ANNOTATING_COMMENTS = NAVIGATION_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__OWNED_ANNOTATIONS = NAVIGATION_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__OWNED_COMMENTS = NAVIGATION_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__OWNED_EXTENSIONS = NAVIGATION_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__CLUSTER = NAVIGATION_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__EDGE_ROLE = NAVIGATION_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__NAME = NAVIGATION_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__OWNING_REGION = NAVIGATION_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__SOURCE_NODE = NAVIGATION_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__TARGET_NODE = NAVIGATION_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__INCOMING_CONNECTION = NAVIGATION_EDGE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Opposite Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__OPPOSITE_EDGE = NAVIGATION_EDGE__OPPOSITE_EDGE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__OUTGOING_CONNECTIONS = NAVIGATION_EDGE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Secondary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__SECONDARY = NAVIGATION_EDGE__SECONDARY;

	/**
	 * The feature id for the '<em><b>Partial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__PARTIAL = NAVIGATION_EDGE__PARTIAL;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE__REFERRED_PROPERTY = NAVIGATION_EDGE__REFERRED_PROPERTY;

	/**
	 * The number of structural features of the '<em>Success Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE_FEATURE_COUNT = NAVIGATION_EDGE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE___ALL_OWNED_ELEMENTS = NAVIGATION_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE___GET_VALUE__TYPE_STRING = NAVIGATION_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Success Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_EDGE_OPERATION_COUNT = NAVIGATION_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessNodeImpl <em>Success Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSuccessNode()
	 * @generated
	 */
	int SUCCESS_NODE = 61;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__ANNOTATING_COMMENTS = MAPPING_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__OWNED_ANNOTATIONS = MAPPING_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__OWNED_COMMENTS = MAPPING_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__OWNED_EXTENSIONS = MAPPING_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__CLASS_DATUM = MAPPING_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__CLUSTER = MAPPING_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__INCOMING_CONNECTION = MAPPING_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__INCOMING_EDGES = MAPPING_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__NAME = MAPPING_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__NODE_ROLE = MAPPING_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__OUTGOING_CONNECTIONS = MAPPING_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__OUTGOING_EDGES = MAPPING_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__OWNING_REGION = MAPPING_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE__MATCHED = MAPPING_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Success Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE___ALL_OWNED_ELEMENTS = MAPPING_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE___GET_VALUE__TYPE_STRING = MAPPING_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Success Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESS_NODE_OPERATION_COUNT = MAPPING_NODE_OPERATION_COUNT + 0;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TupleLiteralNodeImpl <em>Tuple Literal Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TupleLiteralNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTupleLiteralNode()
	 * @generated
	 */
	int TUPLE_LITERAL_NODE = 63;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Tuple Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Tuple Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_LITERAL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TuplePartEdgeImpl <em>Tuple Part Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TuplePartEdgeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTuplePartEdge()
	 * @generated
	 */
	int TUPLE_PART_EDGE = 64;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__ANNOTATING_COMMENTS = ARGUMENT_EDGE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__OWNED_ANNOTATIONS = ARGUMENT_EDGE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__OWNED_COMMENTS = ARGUMENT_EDGE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__OWNED_EXTENSIONS = ARGUMENT_EDGE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__CLUSTER = ARGUMENT_EDGE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Edge Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__EDGE_ROLE = ARGUMENT_EDGE__EDGE_ROLE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__NAME = ARGUMENT_EDGE__NAME;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__OWNING_REGION = ARGUMENT_EDGE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Source Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__SOURCE_NODE = ARGUMENT_EDGE__SOURCE_NODE;

	/**
	 * The feature id for the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__TARGET_NODE = ARGUMENT_EDGE__TARGET_NODE;

	/**
	 * The feature id for the '<em><b>Referred Part</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE__REFERRED_PART = ARGUMENT_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tuple Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE_FEATURE_COUNT = ARGUMENT_EDGE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE___ALL_OWNED_ELEMENTS = ARGUMENT_EDGE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE___GET_VALUE__TYPE_STRING = ARGUMENT_EDGE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Tuple Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TUPLE_PART_EDGE_OPERATION_COUNT = ARGUMENT_EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TypeLiteralNodeImpl <em>Type Literal Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TypeLiteralNodeImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTypeLiteralNode()
	 * @generated
	 */
	int TYPE_LITERAL_NODE = 65;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__ANNOTATING_COMMENTS = OPERATION_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__OWNED_ANNOTATIONS = OPERATION_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__OWNED_COMMENTS = OPERATION_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__OWNED_EXTENSIONS = OPERATION_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__CLASS_DATUM = OPERATION_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__CLUSTER = OPERATION_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__INCOMING_CONNECTION = OPERATION_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__INCOMING_EDGES = OPERATION_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__NAME = OPERATION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__NODE_ROLE = OPERATION_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__OUTGOING_CONNECTIONS = OPERATION_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__OUTGOING_EDGES = OPERATION_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__OWNING_REGION = OPERATION_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__MATCHED = OPERATION_NODE__MATCHED;

	/**
	 * The feature id for the '<em><b>Type Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE__TYPE_VALUE = OPERATION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE_FEATURE_COUNT = OPERATION_NODE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE___ALL_OWNED_ELEMENTS = OPERATION_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE___GET_VALUE__TYPE_STRING = OPERATION_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Type Literal Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_LITERAL_NODE_OPERATION_COUNT = OPERATION_NODE_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__ANNOTATING_COMMENTS = MAPPING_NODE__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OWNED_ANNOTATIONS = MAPPING_NODE__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OWNED_COMMENTS = MAPPING_NODE__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OWNED_EXTENSIONS = MAPPING_NODE__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Class Datum</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__CLASS_DATUM = MAPPING_NODE__CLASS_DATUM;

	/**
	 * The feature id for the '<em><b>Cluster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__CLUSTER = MAPPING_NODE__CLUSTER;

	/**
	 * The feature id for the '<em><b>Incoming Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__INCOMING_CONNECTION = MAPPING_NODE__INCOMING_CONNECTION;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__INCOMING_EDGES = MAPPING_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__NAME = MAPPING_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Node Role</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__NODE_ROLE = MAPPING_NODE__NODE_ROLE;

	/**
	 * The feature id for the '<em><b>Outgoing Connections</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OUTGOING_CONNECTIONS = MAPPING_NODE__OUTGOING_CONNECTIONS;

	/**
	 * The feature id for the '<em><b>Outgoing Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OUTGOING_EDGES = MAPPING_NODE__OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Owning Region</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__OWNING_REGION = MAPPING_NODE__OWNING_REGION;

	/**
	 * The feature id for the '<em><b>Matched</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE__MATCHED = MAPPING_NODE__MATCHED;

	/**
	 * The number of structural features of the '<em>Unknown Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE_FEATURE_COUNT = MAPPING_NODE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE___ALL_OWNED_ELEMENTS = MAPPING_NODE___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE___GET_VALUE__TYPE_STRING = MAPPING_NODE___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Unknown Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNKNOWN_NODE_OPERATION_COUNT = MAPPING_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VerdictRegionImpl <em>Verdict Region</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.VerdictRegionImpl
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getVerdictRegion()
	 * @generated
	 */
	int VERDICT_REGION = 68;

	/**
	 * The feature id for the '<em><b>Annotating Comments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__ANNOTATING_COMMENTS = RULE_REGION__ANNOTATING_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Annotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__OWNED_ANNOTATIONS = RULE_REGION__OWNED_ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Owned Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__OWNED_COMMENTS = RULE_REGION__OWNED_COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__OWNED_EXTENSIONS = RULE_REGION__OWNED_EXTENSIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__NAME = RULE_REGION__NAME;

	/**
	 * The feature id for the '<em><b>Symbol Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__SYMBOL_NAME = RULE_REGION__SYMBOL_NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__OWNED_NODES = RULE_REGION__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__OWNED_EDGES = RULE_REGION__OWNED_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Clusters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__OWNED_CLUSTERS = RULE_REGION__OWNED_CLUSTERS;

	/**
	 * The feature id for the '<em><b>Head Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__HEAD_NODES = RULE_REGION__HEAD_NODES;

	/**
	 * The feature id for the '<em><b>Owning Schedule Model</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__OWNING_SCHEDULE_MODEL = RULE_REGION__OWNING_SCHEDULE_MODEL;

	/**
	 * The feature id for the '<em><b>Scheduled Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__SCHEDULED_REGION = RULE_REGION__SCHEDULED_REGION;

	/**
	 * The feature id for the '<em><b>Referred Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__REFERRED_RULE = RULE_REGION__REFERRED_RULE;

	/**
	 * The feature id for the '<em><b>Referred Rule Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION__REFERRED_RULE_REGION = RULE_REGION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Verdict Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION_FEATURE_COUNT = RULE_REGION_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>All Owned Elements</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION___ALL_OWNED_ELEMENTS = RULE_REGION___ALL_OWNED_ELEMENTS;

	/**
	 * The operation id for the '<em>Get Value</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION___GET_VALUE__TYPE_STRING = RULE_REGION___GET_VALUE__TYPE_STRING;

	/**
	 * The number of operations of the '<em>Verdict Region</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERDICT_REGION_OPERATION_COUNT = RULE_REGION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole <em>Connection Role</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole
	 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getConnectionRole()
	 * @generated
	 */
	int CONNECTION_ROLE = 69;

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ArgumentEdge <em>Argument Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Argument Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ArgumentEdge
	 * @generated
	 */
	EClass getArgumentEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode <em>Boolean Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Boolean Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode
	 * @generated
	 */
	EClass getBooleanLiteralNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode#isBooleanValue <em>Boolean Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Boolean Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode#isBooleanValue()
	 * @see #getBooleanLiteralNode()
	 * @generated
	 */
	EAttribute getBooleanLiteralNode_BooleanValue();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwnedPropertyDatums <em>Owned Property Datums</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Property Datums</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ClassDatum#getOwnedPropertyDatums()
	 * @see #getClassDatum()
	 * @generated
	 */
	EReference getClassDatum_OwnedPropertyDatums();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cluster</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster
	 * @generated
	 */
	EClass getCluster();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getOwningRegion <em>Owning Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getOwningRegion()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_OwningRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberNodes <em>Member Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Member Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberNodes()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_MemberNodes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberEdges <em>Member Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Member Edges</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getMemberEdges()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_MemberEdges();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getPrecedingClusters <em>Preceding Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Preceding Clusters</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getPrecedingClusters()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_PrecedingClusters();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getSucceedingClusters <em>Succeeding Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Succeeding Clusters</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getSucceedingClusters()
	 * @see #getCluster()
	 * @generated
	 */
	EReference getCluster_SucceedingClusters();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.Cluster#getDepth <em>Depth</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Depth</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Cluster#getDepth()
	 * @see #getCluster()
	 * @generated
	 */
	EAttribute getCluster_Depth();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode <em>Collection Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode
	 * @generated
	 */
	EClass getCollectionLiteralNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge <em>Collection Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge
	 * @generated
	 */
	EClass getCollectionPartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge#getReferredPart()
	 * @see #getCollectionPartEdge()
	 * @generated
	 */
	EReference getCollectionPartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode <em>Collection Range Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Range Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode
	 * @generated
	 */
	EClass getCollectionRangeNode();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion <em>Cyclic Mapping Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cyclic Mapping Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion
	 * @generated
	 */
	EClass getCyclicMappingRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion#getElementRegions <em>Element Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Element Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.CyclicMappingRegion#getElementRegions()
	 * @see #getCyclicMappingRegion()
	 * @generated
	 */
	EReference getCyclicMappingRegion_ElementRegions();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge <em>Dependency Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DependencyEdge
	 * @generated
	 */
	EClass getDependencyEdge();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion <em>Dispatch Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dispatch Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion
	 * @generated
	 */
	EClass getDispatchRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion#getReferredRuleRegion <em>Referred Rule Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Rule Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion#getReferredRuleRegion()
	 * @see #getDispatchRegion()
	 * @generated
	 */
	EReference getDispatchRegion_ReferredRuleRegion();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Edge#getCluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cluster</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Edge#getCluster()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Cluster();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode <em>Enum Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enum Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode
	 * @generated
	 */
	EClass getEnumLiteralNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode#getEnumValue <em>Enum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Enum Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode#getEnumValue()
	 * @see #getEnumLiteralNode()
	 * @generated
	 */
	EReference getEnumLiteralNode_EnumValue();

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
	 * Returns the meta object for data type '{@link java.lang.Number <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * A primitive type representing the mathematical concept of real or integer.
     * <!-- end-model-doc -->
	 * @return the meta object for data type '<em>Number</em>'.
	 * @see java.lang.Number
	 * @model instanceClass="java.lang.Number"
	 * @generated
	 */
	EDataType getNumber();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedOperationRegions <em>Owned Operation Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Operation Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedOperationRegions()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedOperationRegions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedScheduledRegions <em>Owned Scheduled Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Scheduled Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedScheduledRegions()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedScheduledRegions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedMappingRegions <em>Owned Mapping Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Mapping Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel#getOwnedMappingRegions()
	 * @see #getScheduleModel()
	 * @generated
	 */
	EReference getScheduleModel_OwnedMappingRegions();

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
	 * Returns the meta object for the containment reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedLoadingRegion <em>Owned Loading Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owned Loading Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getOwnedLoadingRegion()
	 * @see #getScheduledRegion()
	 * @generated
	 */
	EReference getScheduledRegion_OwnedLoadingRegion();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getMappingRegions <em>Mapping Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mapping Regions</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getMappingRegions()
	 * @see #getScheduledRegion()
	 * @generated
	 */
	EReference getScheduledRegion_MappingRegions();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getReferredTransformation <em>Referred Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Transformation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion#getReferredTransformation()
	 * @see #getScheduledRegion()
	 * @generated
	 */
	EReference getScheduledRegion_ReferredTransformation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ShadowNode <em>Shadow Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shadow Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ShadowNode
	 * @generated
	 */
	EClass getShadowNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge <em>Shadow Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shadow Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge
	 * @generated
	 */
	EClass getShadowPartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge#getReferredPart()
	 * @see #getShadowPartEdge()
	 * @generated
	 */
	EReference getShadowPartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode <em>String Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode
	 * @generated
	 */
	EClass getStringLiteralNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode#getStringValue <em>String Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>String Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode#getStringValue()
	 * @see #getStringLiteralNode()
	 * @generated
	 */
	EAttribute getStringLiteralNode_StringValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge <em>Success Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Success Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge
	 * @generated
	 */
	EClass getSuccessEdge();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.SuccessNode <em>Success Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Success Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.SuccessNode
	 * @generated
	 */
	EClass getSuccessNode();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode <em>Tuple Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode
	 * @generated
	 */
	EClass getTupleLiteralNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge <em>Tuple Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tuple Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge
	 * @generated
	 */
	EClass getTuplePartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge#getReferredPart()
	 * @see #getTuplePartEdge()
	 * @generated
	 */
	EReference getTuplePartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode <em>Type Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode
	 * @generated
	 */
	EClass getTypeLiteralNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode#getTypeValue <em>Type Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode#getTypeValue()
	 * @see #getTypeLiteralNode()
	 * @generated
	 */
	EReference getTypeLiteralNode_TypeValue();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion <em>Verdict Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Verdict Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion
	 * @generated
	 */
	EClass getVerdictRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion#getReferredRuleRegion <em>Referred Rule Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Rule Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion#getReferredRuleRegion()
	 * @see #getVerdictRegion()
	 * @generated
	 */
	EReference getVerdictRegion_ReferredRuleRegion();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.IfNode <em>If Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IfNode
	 * @generated
	 */
	EClass getIfNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.IncludesEdge <em>Includes Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Includes Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.IncludesEdge
	 * @generated
	 */
	EClass getIncludesEdge();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge <em>Key Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Key Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge
	 * @generated
	 */
	EClass getKeyPartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge#getReferredPart()
	 * @see #getKeyPartEdge()
	 * @generated
	 */
	EReference getKeyPartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode <em>Keyed Value Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Keyed Value Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode
	 * @generated
	 */
	EClass getKeyedValueNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode#getClassDatumValue <em>Class Datum Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Class Datum Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode#getClassDatumValue()
	 * @see #getKeyedValueNode()
	 * @generated
	 */
	EReference getKeyedValueNode_ClassDatumValue();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningScheduledRegion <em>Owning Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Scheduled Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion#getOwningScheduledRegion()
	 * @see #getLoadingRegion()
	 * @generated
	 */
	EReference getLoadingRegion_OwningScheduledRegion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode <em>Map Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode
	 * @generated
	 */
	EClass getMapLiteralNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge <em>Map Part Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Part Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge
	 * @generated
	 */
	EClass getMapPartEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge#getReferredPart <em>Referred Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Part</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapPartEdge#getReferredPart()
	 * @see #getMapPartEdge()
	 * @generated
	 */
	EReference getMapPartEdge_ReferredPart();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MapPartNode <em>Map Part Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Map Part Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MapPartNode
	 * @generated
	 */
	EClass getMapPartNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingNode <em>Mapping Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingNode
	 * @generated
	 */
	EClass getMappingNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingNode#isMatched <em>Matched</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Matched</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingNode#isMatched()
	 * @see #getMappingNode()
	 * @generated
	 */
	EAttribute getMappingNode_Matched();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getHeadNodes <em>Head Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Head Nodes</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getHeadNodes()
	 * @see #getMappingRegion()
	 * @generated
	 */
	EReference getMappingRegion_HeadNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getOwningScheduleModel()
	 * @see #getMappingRegion()
	 * @generated
	 */
	EReference getMappingRegion_OwningScheduleModel();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getScheduledRegion <em>Scheduled Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scheduled Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.MappingRegion#getScheduledRegion()
	 * @see #getMappingRegion()
	 * @generated
	 */
	EReference getMappingRegion_ScheduledRegion();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.Node#getCluster <em>Cluster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Cluster</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Node#getCluster()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Cluster();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode <em>Null Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Null Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode
	 * @generated
	 */
	EClass getNullLiteralNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode <em>Numeric Literal Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Literal Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode
	 * @generated
	 */
	EClass getNumericLiteralNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode#getNumericValue <em>Numeric Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Numeric Value</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode#getNumericValue()
	 * @see #getNumericLiteralNode()
	 * @generated
	 */
	EAttribute getNumericLiteralNode_NumericValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode <em>Operation Call Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Call Node</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode
	 * @generated
	 */
	EClass getOperationCallNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode#getReferredOperation <em>Referred Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Operation</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode#getReferredOperation()
	 * @see #getOperationCallNode()
	 * @generated
	 */
	EReference getOperationCallNode_ReferredOperation();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getOwningScheduleModel <em>Owning Schedule Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Schedule Model</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationRegion#getOwningScheduleModel()
	 * @see #getOperationRegion()
	 * @generated
	 */
	EReference getOperationRegion_OwningScheduleModel();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge <em>Operation Parameter Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Parameter Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge
	 * @generated
	 */
	EClass getOperationParameterEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getReferredParameter <em>Referred Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Parameter</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getReferredParameter()
	 * @see #getOperationParameterEdge()
	 * @generated
	 */
	EReference getOperationParameterEdge_ReferredParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getParameterIndex <em>Parameter Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Index</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge#getParameterIndex()
	 * @see #getOperationParameterEdge()
	 * @generated
	 */
	EAttribute getOperationParameterEdge_ParameterIndex();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge <em>Operation Self Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operation Self Edge</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge
	 * @generated
	 */
	EClass getOperationSelfEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge#getReferredType <em>Referred Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Type</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge#getReferredType()
	 * @see #getOperationSelfEdge()
	 * @generated
	 */
	EReference getOperationSelfEdge_ReferredType();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#isKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum#isKey()
	 * @see #getPropertyDatum()
	 * @generated
	 */
	EAttribute getPropertyDatum_Key();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion <em>Rule Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Region</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RuleRegion
	 * @generated
	 */
	EClass getRuleRegion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getReferredRule <em>Referred Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Rule</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.RuleRegion#getReferredRule()
	 * @see #getRuleRegion()
	 * @generated
	 */
	EReference getRuleRegion_ReferredRule();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedClusters <em>Owned Clusters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Clusters</em>'.
	 * @see org.eclipse.qvtd.pivot.qvtschedule.Region#getOwnedClusters()
	 * @see #getRegion()
	 * @generated
	 */
	EReference getRegion_OwnedClusters();

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
		 * The meta object literal for the '<em><b>Referred Typed Model</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ABSTRACT_DATUM__REFERRED_TYPED_MODEL = eINSTANCE.getAbstractDatum_ReferredTypedModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ArgumentEdgeImpl <em>Argument Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ArgumentEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getArgumentEdge()
		 * @generated
		 */
		EClass ARGUMENT_EDGE = eINSTANCE.getArgumentEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BooleanLiteralNodeImpl <em>Boolean Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.BooleanLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getBooleanLiteralNode()
		 * @generated
		 */
		EClass BOOLEAN_LITERAL_NODE = eINSTANCE.getBooleanLiteralNode();

		/**
		 * The meta object literal for the '<em><b>Boolean Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOLEAN_LITERAL_NODE__BOOLEAN_VALUE = eINSTANCE.getBooleanLiteralNode_BooleanValue();

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
		 * The meta object literal for the '<em><b>Owned Property Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_DATUM__OWNED_PROPERTY_DATUMS = eINSTANCE.getClassDatum_OwnedPropertyDatums();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl <em>Cluster</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ClusterImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCluster()
		 * @generated
		 */
		EClass CLUSTER = eINSTANCE.getCluster();

		/**
		 * The meta object literal for the '<em><b>Owning Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__OWNING_REGION = eINSTANCE.getCluster_OwningRegion();

		/**
		 * The meta object literal for the '<em><b>Member Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__MEMBER_NODES = eINSTANCE.getCluster_MemberNodes();

		/**
		 * The meta object literal for the '<em><b>Member Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__MEMBER_EDGES = eINSTANCE.getCluster_MemberEdges();

		/**
		 * The meta object literal for the '<em><b>Preceding Clusters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__PRECEDING_CLUSTERS = eINSTANCE.getCluster_PrecedingClusters();

		/**
		 * The meta object literal for the '<em><b>Succeeding Clusters</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLUSTER__SUCCEEDING_CLUSTERS = eINSTANCE.getCluster_SucceedingClusters();

		/**
		 * The meta object literal for the '<em><b>Depth</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLUSTER__DEPTH = eINSTANCE.getCluster_Depth();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionLiteralNodeImpl <em>Collection Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionLiteralNode()
		 * @generated
		 */
		EClass COLLECTION_LITERAL_NODE = eINSTANCE.getCollectionLiteralNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionPartEdgeImpl <em>Collection Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionPartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionPartEdge()
		 * @generated
		 */
		EClass COLLECTION_PART_EDGE = eINSTANCE.getCollectionPartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PART_EDGE__REFERRED_PART = eINSTANCE.getCollectionPartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionRangeNodeImpl <em>Collection Range Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CollectionRangeNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCollectionRangeNode()
		 * @generated
		 */
		EClass COLLECTION_RANGE_NODE = eINSTANCE.getCollectionRangeNode();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicMappingRegionImpl <em>Cyclic Mapping Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.CyclicMappingRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getCyclicMappingRegion()
		 * @generated
		 */
		EClass CYCLIC_MAPPING_REGION = eINSTANCE.getCyclicMappingRegion();

		/**
		 * The meta object literal for the '<em><b>Element Regions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CYCLIC_MAPPING_REGION__ELEMENT_REGIONS = eINSTANCE.getCyclicMappingRegion_ElementRegions();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyEdgeImpl <em>Dependency Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DependencyEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDependencyEdge()
		 * @generated
		 */
		EClass DEPENDENCY_EDGE = eINSTANCE.getDependencyEdge();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.DispatchRegionImpl <em>Dispatch Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.DispatchRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getDispatchRegion()
		 * @generated
		 */
		EClass DISPATCH_REGION = eINSTANCE.getDispatchRegion();

		/**
		 * The meta object literal for the '<em><b>Referred Rule Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISPATCH_REGION__REFERRED_RULE_REGION = eINSTANCE.getDispatchRegion_ReferredRuleRegion();

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
		 * The meta object literal for the '<em><b>Cluster</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__CLUSTER = eINSTANCE.getEdge_Cluster();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.EnumLiteralNodeImpl <em>Enum Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.EnumLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getEnumLiteralNode()
		 * @generated
		 */
		EClass ENUM_LITERAL_NODE = eINSTANCE.getEnumLiteralNode();

		/**
		 * The meta object literal for the '<em><b>Enum Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUM_LITERAL_NODE__ENUM_VALUE = eINSTANCE.getEnumLiteralNode_EnumValue();

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
		 * The meta object literal for the '<em>Number</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Number
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNumber()
		 * @generated
		 */
		EDataType NUMBER = eINSTANCE.getNumber();

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
		 * The meta object literal for the '<em><b>Owned Class Datums</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_CLASS_DATUMS = eINSTANCE.getScheduleModel_OwnedClassDatums();

		/**
		 * The meta object literal for the '<em><b>Owned Operation Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_OPERATION_REGIONS = eINSTANCE.getScheduleModel_OwnedOperationRegions();

		/**
		 * The meta object literal for the '<em><b>Owned Scheduled Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS = eINSTANCE.getScheduleModel_OwnedScheduledRegions();

		/**
		 * The meta object literal for the '<em><b>Owned Mapping Regions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULE_MODEL__OWNED_MAPPING_REGIONS = eINSTANCE.getScheduleModel_OwnedMappingRegions();

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
		 * The meta object literal for the '<em><b>Owned Connections</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_REGION__OWNED_CONNECTIONS = eINSTANCE.getScheduledRegion_OwnedConnections();

		/**
		 * The meta object literal for the '<em><b>Owned Loading Region</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_REGION__OWNED_LOADING_REGION = eINSTANCE.getScheduledRegion_OwnedLoadingRegion();

		/**
		 * The meta object literal for the '<em><b>Mapping Regions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_REGION__MAPPING_REGIONS = eINSTANCE.getScheduledRegion_MappingRegions();

		/**
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_REGION__OWNING_SCHEDULE_MODEL = eINSTANCE.getScheduledRegion_OwningScheduleModel();

		/**
		 * The meta object literal for the '<em><b>Referred Transformation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULED_REGION__REFERRED_TRANSFORMATION = eINSTANCE.getScheduledRegion_ReferredTransformation();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowNodeImpl <em>Shadow Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getShadowNode()
		 * @generated
		 */
		EClass SHADOW_NODE = eINSTANCE.getShadowNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowPartEdgeImpl <em>Shadow Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowPartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getShadowPartEdge()
		 * @generated
		 */
		EClass SHADOW_PART_EDGE = eINSTANCE.getShadowPartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHADOW_PART_EDGE__REFERRED_PART = eINSTANCE.getShadowPartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.StringLiteralNodeImpl <em>String Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.StringLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getStringLiteralNode()
		 * @generated
		 */
		EClass STRING_LITERAL_NODE = eINSTANCE.getStringLiteralNode();

		/**
		 * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_LITERAL_NODE__STRING_VALUE = eINSTANCE.getStringLiteralNode_StringValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessEdgeImpl <em>Success Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSuccessEdge()
		 * @generated
		 */
		EClass SUCCESS_EDGE = eINSTANCE.getSuccessEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessNodeImpl <em>Success Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.SuccessNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getSuccessNode()
		 * @generated
		 */
		EClass SUCCESS_NODE = eINSTANCE.getSuccessNode();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TupleLiteralNodeImpl <em>Tuple Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TupleLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTupleLiteralNode()
		 * @generated
		 */
		EClass TUPLE_LITERAL_NODE = eINSTANCE.getTupleLiteralNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TuplePartEdgeImpl <em>Tuple Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TuplePartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTuplePartEdge()
		 * @generated
		 */
		EClass TUPLE_PART_EDGE = eINSTANCE.getTuplePartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TUPLE_PART_EDGE__REFERRED_PART = eINSTANCE.getTuplePartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TypeLiteralNodeImpl <em>Type Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.TypeLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getTypeLiteralNode()
		 * @generated
		 */
		EClass TYPE_LITERAL_NODE = eINSTANCE.getTypeLiteralNode();

		/**
		 * The meta object literal for the '<em><b>Type Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_LITERAL_NODE__TYPE_VALUE = eINSTANCE.getTypeLiteralNode_TypeValue();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.VerdictRegionImpl <em>Verdict Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.VerdictRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getVerdictRegion()
		 * @generated
		 */
		EClass VERDICT_REGION = eINSTANCE.getVerdictRegion();

		/**
		 * The meta object literal for the '<em><b>Referred Rule Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERDICT_REGION__REFERRED_RULE_REGION = eINSTANCE.getVerdictRegion_ReferredRuleRegion();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IfNodeImpl <em>If Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IfNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIfNode()
		 * @generated
		 */
		EClass IF_NODE = eINSTANCE.getIfNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.IncludesEdgeImpl <em>Includes Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.IncludesEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getIncludesEdge()
		 * @generated
		 */
		EClass INCLUDES_EDGE = eINSTANCE.getIncludesEdge();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.KeyPartEdgeImpl <em>Key Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.KeyPartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getKeyPartEdge()
		 * @generated
		 */
		EClass KEY_PART_EDGE = eINSTANCE.getKeyPartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEY_PART_EDGE__REFERRED_PART = eINSTANCE.getKeyPartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.KeyedValueNodeImpl <em>Keyed Value Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.KeyedValueNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getKeyedValueNode()
		 * @generated
		 */
		EClass KEYED_VALUE_NODE = eINSTANCE.getKeyedValueNode();

		/**
		 * The meta object literal for the '<em><b>Class Datum Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference KEYED_VALUE_NODE__CLASS_DATUM_VALUE = eINSTANCE.getKeyedValueNode_ClassDatumValue();

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
		 * The meta object literal for the '<em><b>Owning Scheduled Region</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOADING_REGION__OWNING_SCHEDULED_REGION = eINSTANCE.getLoadingRegion_OwningScheduledRegion();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MapLiteralNodeImpl <em>Map Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MapLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMapLiteralNode()
		 * @generated
		 */
		EClass MAP_LITERAL_NODE = eINSTANCE.getMapLiteralNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartEdgeImpl <em>Map Part Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMapPartEdge()
		 * @generated
		 */
		EClass MAP_PART_EDGE = eINSTANCE.getMapPartEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Part</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAP_PART_EDGE__REFERRED_PART = eINSTANCE.getMapPartEdge_ReferredPart();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartNodeImpl <em>Map Part Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MapPartNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMapPartNode()
		 * @generated
		 */
		EClass MAP_PART_NODE = eINSTANCE.getMapPartNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MappingNodeImpl <em>Mapping Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.MappingNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getMappingNode()
		 * @generated
		 */
		EClass MAPPING_NODE = eINSTANCE.getMappingNode();

		/**
		 * The meta object literal for the '<em><b>Matched</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPING_NODE__MATCHED = eINSTANCE.getMappingNode_Matched();

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
		 * The meta object literal for the '<em><b>Head Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REGION__HEAD_NODES = eINSTANCE.getMappingRegion_HeadNodes();

		/**
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REGION__OWNING_SCHEDULE_MODEL = eINSTANCE.getMappingRegion_OwningScheduleModel();

		/**
		 * The meta object literal for the '<em><b>Scheduled Region</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING_REGION__SCHEDULED_REGION = eINSTANCE.getMappingRegion_ScheduledRegion();

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
		 * The meta object literal for the '<em><b>Cluster</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__CLUSTER = eINSTANCE.getNode_Cluster();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NullLiteralNodeImpl <em>Null Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NullLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNullLiteralNode()
		 * @generated
		 */
		EClass NULL_LITERAL_NODE = eINSTANCE.getNullLiteralNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.NumericLiteralNodeImpl <em>Numeric Literal Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.NumericLiteralNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getNumericLiteralNode()
		 * @generated
		 */
		EClass NUMERIC_LITERAL_NODE = eINSTANCE.getNumericLiteralNode();

		/**
		 * The meta object literal for the '<em><b>Numeric Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_LITERAL_NODE__NUMERIC_VALUE = eINSTANCE.getNumericLiteralNode_NumericValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationCallNodeImpl <em>Operation Call Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationCallNodeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationCallNode()
		 * @generated
		 */
		EClass OPERATION_CALL_NODE = eINSTANCE.getOperationCallNode();

		/**
		 * The meta object literal for the '<em><b>Referred Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_CALL_NODE__REFERRED_OPERATION = eINSTANCE.getOperationCallNode_ReferredOperation();

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
		 * The meta object literal for the '<em><b>Owning Schedule Model</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_REGION__OWNING_SCHEDULE_MODEL = eINSTANCE.getOperationRegion_OwningScheduleModel();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationParameterEdgeImpl <em>Operation Parameter Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationParameterEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationParameterEdge()
		 * @generated
		 */
		EClass OPERATION_PARAMETER_EDGE = eINSTANCE.getOperationParameterEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_PARAMETER_EDGE__REFERRED_PARAMETER = eINSTANCE.getOperationParameterEdge_ReferredParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute OPERATION_PARAMETER_EDGE__PARAMETER_INDEX = eINSTANCE.getOperationParameterEdge_ParameterIndex();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.OperationSelfEdgeImpl <em>Operation Self Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.OperationSelfEdgeImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getOperationSelfEdge()
		 * @generated
		 */
		EClass OPERATION_SELF_EDGE = eINSTANCE.getOperationSelfEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATION_SELF_EDGE__REFERRED_TYPE = eINSTANCE.getOperationSelfEdge_ReferredType();

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
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY_DATUM__KEY = eINSTANCE.getPropertyDatum_Key();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl <em>Rule Region</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl
		 * @see org.eclipse.qvtd.pivot.qvtschedule.impl.QVTschedulePackageImpl#getRuleRegion()
		 * @generated
		 */
		EClass RULE_REGION = eINSTANCE.getRuleRegion();

		/**
		 * The meta object literal for the '<em><b>Referred Rule</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_REGION__REFERRED_RULE = eINSTANCE.getRuleRegion_ReferredRule();

		/**
		 * The meta object literal for the '<em><b>Owned Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_EDGES = eINSTANCE.getRegion_OwnedEdges();

		/**
		 * The meta object literal for the '<em><b>Owned Clusters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_CLUSTERS = eINSTANCE.getRegion_OwnedClusters();

		/**
		 * The meta object literal for the '<em><b>Owned Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REGION__OWNED_NODES = eINSTANCE.getRegion_OwnedNodes();

	}

} //QVTschedulePackage
