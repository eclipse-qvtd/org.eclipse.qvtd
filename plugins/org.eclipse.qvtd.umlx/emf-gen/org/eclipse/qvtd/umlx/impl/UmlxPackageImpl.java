/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvtd.umlx.Diagram;
import org.eclipse.qvtd.umlx.Edge;
import org.eclipse.qvtd.umlx.Element;
import org.eclipse.qvtd.umlx.Model;
import org.eclipse.qvtd.umlx.Node;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxEdge;
import org.eclipse.qvtd.umlx.TxNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxTransformationNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UmlxFactory;

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
 * @see org.eclipse.qvtd.umlx.UmlxFactory
 * @generated
 */
public class UmlxPackageImpl extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "umlx";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.eclipse.org/qvt/2016/UMLX";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "umlx";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final UmlxPackageImpl eINSTANCE = org.eclipse.qvtd.umlx.impl.UmlxPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.ElementImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getElement()
	 * @generated
	 */
	public static final int ELEMENT = 2;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ELEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.DiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.DiagramImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getDiagram()
	 * @generated
	 */
	public static final int DIAGRAM = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM__NAME = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM__OWNED_NODES = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int DIAGRAM_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.EdgeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getEdge()
	 * @generated
	 */
	public static final int EDGE = 1;

	/**
	 * The feature id for the '<em><b>Owning Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EDGE__OWNING_SOURCE = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EDGE__TARGET = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EDGE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int EDGE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.ModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.ModelImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getModel()
	 * @generated
	 */
	public static final int MODEL = 3;

	/**
	 * The feature id for the '<em><b>Owned Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODEL__OWNED_DIAGRAMS = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int MODEL_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.NodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getNode()
	 * @generated
	 */
	public static final int NODE = 4;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE__DIAGRAM = ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE__INCOMING_EDGES = ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE__OWNED_OUTGOING_EDGES = ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NODE_OPERATION_COUNT = ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl <em>Rel Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelDiagramImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelDiagram()
	 * @generated
	 */
	public static final int REL_DIAGRAM = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DIAGRAM__NAME = DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DIAGRAM__OWNED_NODES = DIAGRAM__OWNED_NODES;

	/**
	 * The number of structural features of the '<em>Rel Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DIAGRAM_FEATURE_COUNT = DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rel Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DIAGRAM_OPERATION_COUNT = DIAGRAM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl <em>Rel Domain Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelDomainNode()
	 * @generated
	 */
	public static final int REL_DOMAIN_NODE = 6;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DOMAIN_NODE__DIAGRAM = NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DOMAIN_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DOMAIN_NODE__OWNED_OUTGOING_EDGES = NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Referred Typed Model Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root Pattern Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DOMAIN_NODE__ROOT_PATTERN_NODES = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rel Domain Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DOMAIN_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Rel Domain Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_DOMAIN_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl <em>Rel Invocation Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelInvocationEdge()
	 * @generated
	 */
	public static final int REL_INVOCATION_EDGE = 7;

	/**
	 * The feature id for the '<em><b>Owning Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_EDGE__OWNING_SOURCE = EDGE__OWNING_SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_EDGE__TARGET = EDGE__TARGET;

	/**
	 * The number of structural features of the '<em>Rel Invocation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Rel Invocation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_EDGE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl <em>Rel Invocation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelInvocationNode()
	 * @generated
	 */
	public static final int REL_INVOCATION_NODE = 8;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_NODE__DIAGRAM = NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_NODE__OWNED_OUTGOING_EDGES = NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Is When</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_NODE__IS_WHEN = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rel Invocation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rel Invocation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_INVOCATION_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl <em>Rel Pattern Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelPatternEdge()
	 * @generated
	 */
	public static final int REL_PATTERN_EDGE = 9;

	/**
	 * The feature id for the '<em><b>Owning Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_EDGE__OWNING_SOURCE = EDGE__OWNING_SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_EDGE__TARGET = EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_EDGE__REFERRED_PROPERTY = EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rel Pattern Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Rel Pattern Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_EDGE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl <em>Rel Pattern Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelPatternNode()
	 * @generated
	 */
	public static final int REL_PATTERN_NODE = 10;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE__DIAGRAM = NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE__OWNED_OUTGOING_EDGES = NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE__NAME = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE__REFERRED_CLASS = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Rel Domain Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE__REL_DOMAIN_NODE = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rel Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Rel Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int REL_PATTERN_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl <em>Tx Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxDiagramImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxDiagram()
	 * @generated
	 */
	public static final int TX_DIAGRAM = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_DIAGRAM__NAME = DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_DIAGRAM__OWNED_NODES = DIAGRAM__OWNED_NODES;

	/**
	 * The feature id for the '<em><b>Owned Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_DIAGRAM__OWNED_DIAGRAMS = DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tx Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_DIAGRAM_FEATURE_COUNT = DIAGRAM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Tx Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_DIAGRAM_OPERATION_COUNT = DIAGRAM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxEdgeImpl <em>Tx Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxEdgeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxEdge()
	 * @generated
	 */
	public static final int TX_EDGE = 12;

	/**
	 * The feature id for the '<em><b>Owning Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_EDGE__OWNING_SOURCE = EDGE__OWNING_SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_EDGE__TARGET = EDGE__TARGET;

	/**
	 * The number of structural features of the '<em>Tx Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_EDGE_FEATURE_COUNT = EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tx Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_EDGE_OPERATION_COUNT = EDGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxNodeImpl <em>Tx Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxNode()
	 * @generated
	 */
	public static final int TX_NODE = 13;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_NODE__DIAGRAM = NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_NODE__INCOMING_EDGES = NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_NODE__OWNED_OUTGOING_EDGES = NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The number of structural features of the '<em>Tx Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tx Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_NODE_OPERATION_COUNT = NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl <em>Tx Package Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxPackageNode()
	 * @generated
	 */
	public static final int TX_PACKAGE_NODE = 14;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_PACKAGE_NODE__DIAGRAM = TX_NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_PACKAGE_NODE__INCOMING_EDGES = TX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_PACKAGE_NODE__OWNED_OUTGOING_EDGES = TX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Referred Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_PACKAGE_NODE__REFERRED_PACKAGE = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tx Package Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_PACKAGE_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Tx Package Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_PACKAGE_NODE_OPERATION_COUNT = TX_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxTransformationNodeImpl <em>Tx Transformation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxTransformationNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxTransformationNode()
	 * @generated
	 */
	public static final int TX_TRANSFORMATION_NODE = 15;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TRANSFORMATION_NODE__DIAGRAM = TX_NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TRANSFORMATION_NODE__INCOMING_EDGES = TX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TRANSFORMATION_NODE__OWNED_OUTGOING_EDGES = TX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TRANSFORMATION_NODE__NAME = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tx Typed Model Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tx Transformation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TRANSFORMATION_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Tx Transformation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TRANSFORMATION_NODE_OPERATION_COUNT = TX_NODE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl <em>Tx Typed Model Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxTypedModelNode()
	 * @generated
	 */
	public static final int TX_TYPED_MODEL_NODE = 16;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TYPED_MODEL_NODE__DIAGRAM = TX_NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TYPED_MODEL_NODE__INCOMING_EDGES = TX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TYPED_MODEL_NODE__OWNED_OUTGOING_EDGES = TX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TYPED_MODEL_NODE__NAME = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tx Package Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tx Typed Model Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TYPED_MODEL_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Tx Typed Model Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TX_TYPED_MODEL_NODE_OPERATION_COUNT = TX_NODE_OPERATION_COUNT + 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relDomainNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relInvocationEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relInvocationNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relPatternEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relPatternNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass txDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass txEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass txNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass txPackageNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass txTransformationNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass txTypedModelNodeEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UmlxPackageImpl() {
		super(eNS_URI, ((EFactory)UmlxFactory.INSTANCE));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UmlxPackageImpl#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UmlxPackageImpl init() {
		if (isInited) return (UmlxPackageImpl)EPackage.Registry.INSTANCE.getEPackage(UmlxPackageImpl.eNS_URI);

		// Obtain or create and register package
		UmlxPackageImpl theUmlxPackage = (UmlxPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UmlxPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UmlxPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUmlxPackage.createPackageContents();

		// Initialize created meta-data
		theUmlxPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUmlxPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UmlxPackageImpl.eNS_URI, theUmlxPackage);
		return theUmlxPackage;
	}


	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.Diagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.Diagram
	 * @generated
	 */
	public EClass getDiagram() {
		return diagramEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.Diagram#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.umlx.Diagram#getName()
	 * @see #getDiagram()
	 * @generated
	 */
	public EAttribute getDiagram_Name() {
		return (EAttribute)diagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.Diagram#getOwnedNodes <em>Owned Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.Diagram#getOwnedNodes()
	 * @see #getDiagram()
	 * @generated
	 */
	public EReference getDiagram_OwnedNodes() {
		return (EReference)diagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see org.eclipse.qvtd.umlx.Edge
	 * @generated
	 */
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.Edge#getOwningSource <em>Owning Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Source</em>'.
	 * @see org.eclipse.qvtd.umlx.Edge#getOwningSource()
	 * @see #getEdge()
	 * @generated
	 */
	public EReference getEdge_OwningSource() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.Edge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.umlx.Edge#getTarget()
	 * @see #getEdge()
	 * @generated
	 */
	public EReference getEdge_Target() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.qvtd.umlx.Element
	 * @generated
	 */
	public EClass getElement() {
		return elementEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.Model <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipse.qvtd.umlx.Model
	 * @generated
	 */
	public EClass getModel() {
		return modelEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.Model#getOwnedDiagrams <em>Owned Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Diagrams</em>'.
	 * @see org.eclipse.qvtd.umlx.Model#getOwnedDiagrams()
	 * @see #getModel()
	 * @generated
	 */
	public EReference getModel_OwnedDiagrams() {
		return (EReference)modelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.qvtd.umlx.Node
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.Node#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.Node#getDiagram()
	 * @see #getNode()
	 * @generated
	 */
	public EReference getNode_Diagram() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.Node#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Edges</em>'.
	 * @see org.eclipse.qvtd.umlx.Node#getIncomingEdges()
	 * @see #getNode()
	 * @generated
	 */
	public EReference getNode_IncomingEdges() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.Node#getOwnedOutgoingEdges <em>Owned Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Outgoing Edges</em>'.
	 * @see org.eclipse.qvtd.umlx.Node#getOwnedOutgoingEdges()
	 * @see #getNode()
	 * @generated
	 */
	public EReference getNode_OwnedOutgoingEdges() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelDiagram <em>Rel Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDiagram
	 * @generated
	 */
	public EClass getRelDiagram() {
		return relDiagramEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelDomainNode <em>Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Domain Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode
	 * @generated
	 */
	public EClass getRelDomainNode() {
		return relDomainNodeEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelDomainNode#getReferredTypedModelNode <em>Referred Typed Model Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getReferredTypedModelNode()
	 * @see #getRelDomainNode()
	 * @generated
	 */
	public EReference getRelDomainNode_ReferredTypedModelNode() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.RelDomainNode#getRootPatternNodes <em>Root Pattern Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Pattern Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getRootPatternNodes()
	 * @see #getRelDomainNode()
	 * @generated
	 */
	public EReference getRelDomainNode_RootPatternNodes() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelInvocationEdge <em>Rel Invocation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Invocation Edge</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationEdge
	 * @generated
	 */
	public EClass getRelInvocationEdge() {
		return relInvocationEdgeEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelInvocationNode <em>Rel Invocation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Invocation Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode
	 * @generated
	 */
	public EClass getRelInvocationNode() {
		return relInvocationNodeEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelInvocationNode#isIsWhen <em>Is When</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is When</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode#isIsWhen()
	 * @see #getRelInvocationNode()
	 * @generated
	 */
	public EAttribute getRelInvocationNode_IsWhen() {
		return (EAttribute)relInvocationNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelPatternEdge <em>Rel Pattern Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Pattern Edge</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge
	 * @generated
	 */
	public EClass getRelPatternEdge() {
		return relPatternEdgeEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getReferredProperty()
	 * @see #getRelPatternEdge()
	 * @generated
	 */
	public EReference getRelPatternEdge_ReferredProperty() {
		return (EReference)relPatternEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelPatternNode <em>Rel Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Pattern Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode
	 * @generated
	 */
	public EClass getRelPatternNode() {
		return relPatternNodeEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelPatternNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getName()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	public EAttribute getRelPatternNode_Name() {
		return (EAttribute)relPatternNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternNode#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getReferredClass()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	public EReference getRelPatternNode_ReferredClass() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternNode#getRelDomainNode <em>Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Domain Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getRelDomainNode()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	public EReference getRelPatternNode_RelDomainNode() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram
	 * @generated
	 */
	public EClass getTxDiagram() {
		return txDiagramEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedDiagrams <em>Owned Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Diagrams</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedDiagrams()
	 * @see #getTxDiagram()
	 * @generated
	 */
	public EReference getTxDiagram_OwnedDiagrams() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxEdge <em>Tx Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Edge</em>'.
	 * @see org.eclipse.qvtd.umlx.TxEdge
	 * @generated
	 */
	public EClass getTxEdge() {
		return txEdgeEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxNode <em>Tx Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxNode
	 * @generated
	 */
	public EClass getTxNode() {
		return txNodeEClass;
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxPackageNode <em>Tx Package Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Package Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPackageNode
	 * @generated
	 */
	public EClass getTxPackageNode() {
		return txPackageNodeEClass;
	}

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.TxPackageNode#getReferredPackage <em>Referred Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Package</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPackageNode#getReferredPackage()
	 * @see #getTxPackageNode()
	 * @generated
	 */
	public EReference getTxPackageNode_ReferredPackage() {
		return (EReference)txPackageNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxTransformationNode <em>Tx Transformation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Transformation Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTransformationNode
	 * @generated
	 */
	public EClass getTxTransformationNode() {
		return txTransformationNodeEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.TxTransformationNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTransformationNode#getName()
	 * @see #getTxTransformationNode()
	 * @generated
	 */
	public EAttribute getTxTransformationNode_Name() {
		return (EAttribute)txTransformationNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.TxTransformationNode#getTxTypedModelNodes <em>Tx Typed Model Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tx Typed Model Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTransformationNode#getTxTypedModelNodes()
	 * @see #getTxTransformationNode()
	 * @generated
	 */
	public EReference getTxTransformationNode_TxTypedModelNodes() {
		return (EReference)txTransformationNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxTypedModelNode <em>Tx Typed Model Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Typed Model Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode
	 * @generated
	 */
	public EClass getTxTypedModelNode() {
		return txTypedModelNodeEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getName()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	public EAttribute getTxTypedModelNode_Name() {
		return (EAttribute)txTypedModelNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getTxPackageNodes <em>Tx Package Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tx Package Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getTxPackageNodes()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	public EReference getTxTypedModelNode_TxPackageNodes() {
		return (EReference)txTypedModelNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public UmlxFactory getUmlxFactory() {
		return (UmlxFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		diagramEClass = createEClass(DIAGRAM);
		createEAttribute(diagramEClass, DIAGRAM__NAME);
		createEReference(diagramEClass, DIAGRAM__OWNED_NODES);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__OWNING_SOURCE);
		createEReference(edgeEClass, EDGE__TARGET);

		elementEClass = createEClass(ELEMENT);

		modelEClass = createEClass(MODEL);
		createEReference(modelEClass, MODEL__OWNED_DIAGRAMS);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__DIAGRAM);
		createEReference(nodeEClass, NODE__INCOMING_EDGES);
		createEReference(nodeEClass, NODE__OWNED_OUTGOING_EDGES);

		relDiagramEClass = createEClass(REL_DIAGRAM);

		relDomainNodeEClass = createEClass(REL_DOMAIN_NODE);
		createEReference(relDomainNodeEClass, REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE);
		createEReference(relDomainNodeEClass, REL_DOMAIN_NODE__ROOT_PATTERN_NODES);

		relInvocationEdgeEClass = createEClass(REL_INVOCATION_EDGE);

		relInvocationNodeEClass = createEClass(REL_INVOCATION_NODE);
		createEAttribute(relInvocationNodeEClass, REL_INVOCATION_NODE__IS_WHEN);

		relPatternEdgeEClass = createEClass(REL_PATTERN_EDGE);
		createEReference(relPatternEdgeEClass, REL_PATTERN_EDGE__REFERRED_PROPERTY);

		relPatternNodeEClass = createEClass(REL_PATTERN_NODE);
		createEAttribute(relPatternNodeEClass, REL_PATTERN_NODE__NAME);
		createEReference(relPatternNodeEClass, REL_PATTERN_NODE__REFERRED_CLASS);
		createEReference(relPatternNodeEClass, REL_PATTERN_NODE__REL_DOMAIN_NODE);

		txDiagramEClass = createEClass(TX_DIAGRAM);
		createEReference(txDiagramEClass, TX_DIAGRAM__OWNED_DIAGRAMS);

		txEdgeEClass = createEClass(TX_EDGE);

		txNodeEClass = createEClass(TX_NODE);

		txPackageNodeEClass = createEClass(TX_PACKAGE_NODE);
		createEReference(txPackageNodeEClass, TX_PACKAGE_NODE__REFERRED_PACKAGE);

		txTransformationNodeEClass = createEClass(TX_TRANSFORMATION_NODE);
		createEAttribute(txTransformationNodeEClass, TX_TRANSFORMATION_NODE__NAME);
		createEReference(txTransformationNodeEClass, TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES);

		txTypedModelNodeEClass = createEClass(TX_TYPED_MODEL_NODE);
		createEAttribute(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__NAME);
		createEReference(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		diagramEClass.getESuperTypes().add(this.getElement());
		edgeEClass.getESuperTypes().add(this.getElement());
		modelEClass.getESuperTypes().add(this.getElement());
		nodeEClass.getESuperTypes().add(this.getElement());
		relDiagramEClass.getESuperTypes().add(this.getDiagram());
		relDomainNodeEClass.getESuperTypes().add(this.getNode());
		relInvocationEdgeEClass.getESuperTypes().add(this.getEdge());
		relInvocationNodeEClass.getESuperTypes().add(this.getNode());
		relPatternEdgeEClass.getESuperTypes().add(this.getEdge());
		relPatternNodeEClass.getESuperTypes().add(this.getNode());
		txDiagramEClass.getESuperTypes().add(this.getDiagram());
		txEdgeEClass.getESuperTypes().add(this.getEdge());
		txNodeEClass.getESuperTypes().add(this.getNode());
		txPackageNodeEClass.getESuperTypes().add(this.getTxNode());
		txTransformationNodeEClass.getESuperTypes().add(this.getTxNode());
		txTypedModelNodeEClass.getESuperTypes().add(this.getTxNode());

		// Initialize classes, features, and operations; add parameters
		initEClass(diagramEClass, Diagram.class, "Diagram", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagram_Name(), ecorePackage.getEString(), "name", null, 1, 1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagram_OwnedNodes(), this.getNode(), this.getNode_Diagram(), "ownedNodes", null, 0, -1, Diagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeEClass, Edge.class, "Edge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_OwningSource(), this.getNode(), this.getNode_OwnedOutgoingEdges(), "owningSource", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_Target(), this.getNode(), this.getNode_IncomingEdges(), "target", null, 1, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(elementEClass, Element.class, "Element", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModel_OwnedDiagrams(), this.getTxDiagram(), null, "ownedDiagrams", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode_Diagram(), this.getDiagram(), this.getDiagram_OwnedNodes(), "diagram", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_IncomingEdges(), this.getEdge(), this.getEdge_Target(), "incomingEdges", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_OwnedOutgoingEdges(), this.getEdge(), this.getEdge_OwningSource(), "ownedOutgoingEdges", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relDiagramEClass, RelDiagram.class, "RelDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relDomainNodeEClass, RelDomainNode.class, "RelDomainNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelDomainNode_ReferredTypedModelNode(), this.getTxTypedModelNode(), null, "referredTypedModelNode", null, 1, 1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDomainNode_RootPatternNodes(), this.getRelPatternNode(), this.getRelPatternNode_RelDomainNode(), "rootPatternNodes", null, 1, -1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relInvocationEdgeEClass, RelInvocationEdge.class, "RelInvocationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relInvocationNodeEClass, RelInvocationNode.class, "RelInvocationNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelInvocationNode_IsWhen(), ecorePackage.getEBoolean(), "isWhen", "true", 1, 1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relPatternEdgeEClass, RelPatternEdge.class, "RelPatternEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelPatternEdge_ReferredProperty(), theEcorePackage.getEStructuralFeature(), null, "referredProperty", null, 0, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relPatternNodeEClass, RelPatternNode.class, "RelPatternNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelPatternNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternNode_ReferredClass(), theEcorePackage.getEClassifier(), null, "referredClass", null, 1, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternNode_RelDomainNode(), this.getRelDomainNode(), this.getRelDomainNode_RootPatternNodes(), "relDomainNode", null, 0, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txDiagramEClass, TxDiagram.class, "TxDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxDiagram_OwnedDiagrams(), this.getRelDiagram(), null, "ownedDiagrams", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txEdgeEClass, TxEdge.class, "TxEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(txNodeEClass, TxNode.class, "TxNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(txPackageNodeEClass, TxPackageNode.class, "TxPackageNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxPackageNode_ReferredPackage(), theEcorePackage.getEPackage(), null, "referredPackage", null, 1, 1, TxPackageNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txTransformationNodeEClass, TxTransformationNode.class, "TxTransformationNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTxTransformationNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, TxTransformationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTransformationNode_TxTypedModelNodes(), this.getTxTypedModelNode(), null, "txTypedModelNodes", null, 0, -1, TxTransformationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txTypedModelNodeEClass, TxTypedModelNode.class, "TxTypedModelNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTxTypedModelNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTypedModelNode_TxPackageNodes(), this.getTxPackageNode(), null, "txPackageNodes", null, 0, -1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

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
	public interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.DiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.DiagramImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getDiagram()
		 * @generated
		 */
		public static final EClass DIAGRAM = eINSTANCE.getDiagram();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute DIAGRAM__NAME = eINSTANCE.getDiagram_Name();

		/**
		 * The meta object literal for the '<em><b>Owned Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference DIAGRAM__OWNED_NODES = eINSTANCE.getDiagram_OwnedNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.EdgeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getEdge()
		 * @generated
		 */
		public static final EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Owning Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference EDGE__OWNING_SOURCE = eINSTANCE.getEdge_OwningSource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference EDGE__TARGET = eINSTANCE.getEdge_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.ElementImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getElement()
		 * @generated
		 */
		public static final EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.ModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.ModelImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getModel()
		 * @generated
		 */
		public static final EClass MODEL = eINSTANCE.getModel();

		/**
		 * The meta object literal for the '<em><b>Owned Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference MODEL__OWNED_DIAGRAMS = eINSTANCE.getModel_OwnedDiagrams();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.NodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getNode()
		 * @generated
		 */
		public static final EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference NODE__DIAGRAM = eINSTANCE.getNode_Diagram();

		/**
		 * The meta object literal for the '<em><b>Incoming Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference NODE__INCOMING_EDGES = eINSTANCE.getNode_IncomingEdges();

		/**
		 * The meta object literal for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference NODE__OWNED_OUTGOING_EDGES = eINSTANCE.getNode_OwnedOutgoingEdges();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl <em>Rel Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelDiagramImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelDiagram()
		 * @generated
		 */
		public static final EClass REL_DIAGRAM = eINSTANCE.getRelDiagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl <em>Rel Domain Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelDomainNode()
		 * @generated
		 */
		public static final EClass REL_DOMAIN_NODE = eINSTANCE.getRelDomainNode();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE = eINSTANCE.getRelDomainNode_ReferredTypedModelNode();

		/**
		 * The meta object literal for the '<em><b>Root Pattern Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference REL_DOMAIN_NODE__ROOT_PATTERN_NODES = eINSTANCE.getRelDomainNode_RootPatternNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl <em>Rel Invocation Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelInvocationEdge()
		 * @generated
		 */
		public static final EClass REL_INVOCATION_EDGE = eINSTANCE.getRelInvocationEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl <em>Rel Invocation Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelInvocationNode()
		 * @generated
		 */
		public static final EClass REL_INVOCATION_NODE = eINSTANCE.getRelInvocationNode();

		/**
		 * The meta object literal for the '<em><b>Is When</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute REL_INVOCATION_NODE__IS_WHEN = eINSTANCE.getRelInvocationNode_IsWhen();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl <em>Rel Pattern Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelPatternEdge()
		 * @generated
		 */
		public static final EClass REL_PATTERN_EDGE = eINSTANCE.getRelPatternEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference REL_PATTERN_EDGE__REFERRED_PROPERTY = eINSTANCE.getRelPatternEdge_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl <em>Rel Pattern Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getRelPatternNode()
		 * @generated
		 */
		public static final EClass REL_PATTERN_NODE = eINSTANCE.getRelPatternNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute REL_PATTERN_NODE__NAME = eINSTANCE.getRelPatternNode_Name();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference REL_PATTERN_NODE__REFERRED_CLASS = eINSTANCE.getRelPatternNode_ReferredClass();

		/**
		 * The meta object literal for the '<em><b>Rel Domain Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference REL_PATTERN_NODE__REL_DOMAIN_NODE = eINSTANCE.getRelPatternNode_RelDomainNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl <em>Tx Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxDiagramImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxDiagram()
		 * @generated
		 */
		public static final EClass TX_DIAGRAM = eINSTANCE.getTxDiagram();

		/**
		 * The meta object literal for the '<em><b>Owned Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TX_DIAGRAM__OWNED_DIAGRAMS = eINSTANCE.getTxDiagram_OwnedDiagrams();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxEdgeImpl <em>Tx Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxEdgeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxEdge()
		 * @generated
		 */
		public static final EClass TX_EDGE = eINSTANCE.getTxEdge();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxNodeImpl <em>Tx Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxNode()
		 * @generated
		 */
		public static final EClass TX_NODE = eINSTANCE.getTxNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl <em>Tx Package Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxPackageNode()
		 * @generated
		 */
		public static final EClass TX_PACKAGE_NODE = eINSTANCE.getTxPackageNode();

		/**
		 * The meta object literal for the '<em><b>Referred Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TX_PACKAGE_NODE__REFERRED_PACKAGE = eINSTANCE.getTxPackageNode_ReferredPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxTransformationNodeImpl <em>Tx Transformation Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxTransformationNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxTransformationNode()
		 * @generated
		 */
		public static final EClass TX_TRANSFORMATION_NODE = eINSTANCE.getTxTransformationNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TX_TRANSFORMATION_NODE__NAME = eINSTANCE.getTxTransformationNode_Name();

		/**
		 * The meta object literal for the '<em><b>Tx Typed Model Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES = eINSTANCE.getTxTransformationNode_TxTypedModelNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl <em>Tx Typed Model Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UmlxPackageImpl#getTxTypedModelNode()
		 * @generated
		 */
		public static final EClass TX_TYPED_MODEL_NODE = eINSTANCE.getTxTypedModelNode();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TX_TYPED_MODEL_NODE__NAME = eINSTANCE.getTxTypedModelNode_Name();

		/**
		 * The meta object literal for the '<em><b>Tx Package Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES = eINSTANCE.getTxTypedModelNode_TxPackageNodes();

	}

} //UmlxPackageImpl
