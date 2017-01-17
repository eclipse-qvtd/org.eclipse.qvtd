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
package org.eclipse.qvtd.umlx;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.qvtd.umlx.UMLXFactory
 * @generated
 */
public interface UMLXPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "umlx";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/qvt/2016/UMLX";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "umlx";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UMLXPackage eINSTANCE = org.eclipse.qvtd.umlx.impl.UMLXPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.UMLXElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.UMLXElementImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXElement()
	 * @generated
	 */
	int UMLX_ELEMENT = 17;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_ELEMENT__COMMENTS = 0;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.UMLXNodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.UMLXNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXNode()
	 * @generated
	 */
	int UMLX_NODE = 20;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_NODE__COMMENTS = UMLX_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_NODE__INCOMING_EDGES = UMLX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_NODE__OWNED_OUTGOING_EDGES = UMLX_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_NODE_FEATURE_COUNT = UMLX_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelNodeImpl <em>Rel Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelNode()
	 * @generated
	 */
	int REL_NODE = 5;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_NODE__COMMENTS = UMLX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_NODE__INCOMING_EDGES = UMLX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_NODE__OWNED_OUTGOING_EDGES = UMLX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_NODE__DIAGRAM = UMLX_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rel Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_NODE_FEATURE_COUNT = UMLX_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelConstraintNodeImpl <em>Rel Constraint Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelConstraintNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelConstraintNode()
	 * @generated
	 */
	int REL_CONSTRAINT_NODE = 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_CONSTRAINT_NODE__COMMENTS = REL_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_CONSTRAINT_NODE__INCOMING_EDGES = REL_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_CONSTRAINT_NODE__OWNED_OUTGOING_EDGES = REL_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_CONSTRAINT_NODE__DIAGRAM = REL_NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_CONSTRAINT_NODE__EXPRESSION = REL_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rel Constraint Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_CONSTRAINT_NODE_FEATURE_COUNT = REL_NODE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.UMLXNamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.UMLXNamedElementImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXNamedElement()
	 * @generated
	 */
	int UMLX_NAMED_ELEMENT = 19;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_NAMED_ELEMENT__COMMENTS = UMLX_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_NAMED_ELEMENT__NAME = UMLX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_NAMED_ELEMENT_FEATURE_COUNT = UMLX_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.UMLXDiagramImpl <em>Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.UMLXDiagramImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXDiagram()
	 * @generated
	 */
	int UMLX_DIAGRAM = 15;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_DIAGRAM__COMMENTS = UMLX_NAMED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_DIAGRAM__NAME = UMLX_NAMED_ELEMENT__NAME;

	/**
	 * The number of structural features of the '<em>Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_DIAGRAM_FEATURE_COUNT = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl <em>Rel Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelDiagramImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelDiagram()
	 * @generated
	 */
	int REL_DIAGRAM = 1;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__COMMENTS = UMLX_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__NAME = UMLX_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Is Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__IS_TOP = UMLX_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__OWNED_NODES = UMLX_DIAGRAM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tx Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__TX_DIAGRAM = UMLX_DIAGRAM_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rel Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM_FEATURE_COUNT = UMLX_DIAGRAM_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl <em>Rel Domain Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelDomainNode()
	 * @generated
	 */
	int REL_DOMAIN_NODE = 2;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__COMMENTS = REL_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__INCOMING_EDGES = REL_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__OWNED_OUTGOING_EDGES = REL_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__DIAGRAM = REL_NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Referred Typed Model Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE = REL_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Root Pattern Nodes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__ROOT_PATTERN_NODES = REL_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rel Domain Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE_FEATURE_COUNT = REL_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.UMLXEdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.UMLXEdgeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXEdge()
	 * @generated
	 */
	int UMLX_EDGE = 16;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_EDGE__COMMENTS = UMLX_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Owning Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_EDGE__OWNING_SOURCE = UMLX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_EDGE__TARGET = UMLX_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_EDGE_FEATURE_COUNT = UMLX_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl <em>Rel Invocation Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelInvocationEdge()
	 * @generated
	 */
	int REL_INVOCATION_EDGE = 3;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE__COMMENTS = UMLX_EDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Owning Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE__OWNING_SOURCE = UMLX_EDGE__OWNING_SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE__TARGET = UMLX_EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Referred Rel Pattern Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE = UMLX_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rel Invocation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE_FEATURE_COUNT = UMLX_EDGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl <em>Rel Invocation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelInvocationNode()
	 * @generated
	 */
	int REL_INVOCATION_NODE = 4;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__COMMENTS = REL_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__INCOMING_EDGES = REL_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__OWNED_OUTGOING_EDGES = REL_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__DIAGRAM = REL_NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Is Then</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__IS_THEN = REL_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Referred Rel Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM = REL_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rel Invocation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE_FEATURE_COUNT = REL_NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl <em>Rel Pattern Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternEdge()
	 * @generated
	 */
	int REL_PATTERN_EDGE = 6;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__COMMENTS = UMLX_EDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Owning Source</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__OWNING_SOURCE = UMLX_EDGE__OWNING_SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__TARGET = UMLX_EDGE__TARGET;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__REFERRED_PROPERTY = UMLX_EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__IS_OPPOSITE = UMLX_EDGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Rel Pattern Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE_FEATURE_COUNT = UMLX_EDGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl <em>Rel Pattern Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternNode()
	 * @generated
	 */
	int REL_PATTERN_NODE = 7;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__COMMENTS = REL_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__INCOMING_EDGES = REL_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__OWNED_OUTGOING_EDGES = REL_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__DIAGRAM = REL_NODE__DIAGRAM;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__NAME = REL_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__IS_REQUIRED = REL_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__REFERRED_CLASS = REL_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rel Domain Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__REL_DOMAIN_NODE = REL_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rel Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE_FEATURE_COUNT = REL_NODE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl <em>Tx Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxDiagramImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxDiagram()
	 * @generated
	 */
	int TX_DIAGRAM = 8;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__COMMENTS = UMLX_DIAGRAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__NAME = UMLX_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Owned Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__OWNED_DIAGRAMS = UMLX_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__PACKAGE = UMLX_DIAGRAM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tx Import Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__TX_IMPORT_NODES = UMLX_DIAGRAM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tx Key Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__TX_KEY_NODES = UMLX_DIAGRAM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Tx Typed Model Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__TX_TYPED_MODEL_NODES = UMLX_DIAGRAM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Tx Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM_FEATURE_COUNT = UMLX_DIAGRAM_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxNodeImpl <em>Tx Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxNode()
	 * @generated
	 */
	int TX_NODE = 11;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_NODE__COMMENTS = UMLX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_NODE__INCOMING_EDGES = UMLX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_NODE__OWNED_OUTGOING_EDGES = UMLX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The number of structural features of the '<em>Tx Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_NODE_FEATURE_COUNT = UMLX_NODE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxImportNodeImpl <em>Tx Import Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxImportNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxImportNode()
	 * @generated
	 */
	int TX_IMPORT_NODE = 9;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__COMMENTS = TX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__INCOMING_EDGES = TX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__OWNED_OUTGOING_EDGES = TX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__NAME = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__URI = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tx Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__TX_DIAGRAM = TX_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tx Import Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl <em>Tx Key Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxKeyNode()
	 * @generated
	 */
	int TX_KEY_NODE = 10;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__COMMENTS = TX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__INCOMING_EDGES = TX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__OWNED_OUTGOING_EDGES = TX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__REFERRED_CLASS = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tx Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__TX_DIAGRAM = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tx Part Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__TX_PART_NODES = TX_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tx Key Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxPartNodeImpl <em>Tx Part Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxPartNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxPartNode()
	 * @generated
	 */
	int TX_PART_NODE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl <em>Tx Package Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxPackageNode()
	 * @generated
	 */
	int TX_PACKAGE_NODE = 12;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PACKAGE_NODE__COMMENTS = TX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PACKAGE_NODE__INCOMING_EDGES = TX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PACKAGE_NODE__OWNED_OUTGOING_EDGES = TX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Referred Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PACKAGE_NODE__REFERRED_PACKAGE = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tx Package Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PACKAGE_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PART_NODE__COMMENTS = TX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PART_NODE__INCOMING_EDGES = TX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PART_NODE__OWNED_OUTGOING_EDGES = TX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Tx Key Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PART_NODE__TX_KEY_NODE = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PART_NODE__IS_OPPOSITE = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PART_NODE__REFERRED_PROPERTY = TX_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tx Part Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PART_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl <em>Tx Typed Model Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxTypedModelNode()
	 * @generated
	 */
	int TX_TYPED_MODEL_NODE = 14;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__COMMENTS = TX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Edges</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__INCOMING_EDGES = TX_NODE__INCOMING_EDGES;

	/**
	 * The feature id for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__OWNED_OUTGOING_EDGES = TX_NODE__OWNED_OUTGOING_EDGES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__NAME = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Check</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__CHECK = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Enforce</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__ENFORCE = TX_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Tx Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__TX_DIAGRAM = TX_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Tx Package Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES = TX_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Tx Typed Model Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.UMLXModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.UMLXModelImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXModel()
	 * @generated
	 */
	int UMLX_MODEL = 18;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_MODEL__COMMENTS = UMLX_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_MODEL__OWNED_DIAGRAMS = UMLX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_MODEL_FEATURE_COUNT = UMLX_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelConstraintNode <em>Rel Constraint Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Constraint Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelConstraintNode
	 * @generated
	 */
	EClass getRelConstraintNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelConstraintNode#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.eclipse.qvtd.umlx.RelConstraintNode#getExpression()
	 * @see #getRelConstraintNode()
	 * @generated
	 */
	EAttribute getRelConstraintNode_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelDiagram <em>Rel Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDiagram
	 * @generated
	 */
	EClass getRelDiagram();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelDiagram#isIsTop <em>Is Top</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Top</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDiagram#isIsTop()
	 * @see #getRelDiagram()
	 * @generated
	 */
	EAttribute getRelDiagram_IsTop();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.RelDiagram#getOwnedNodes <em>Owned Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDiagram#getOwnedNodes()
	 * @see #getRelDiagram()
	 * @generated
	 */
	EReference getRelDiagram_OwnedNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.RelDiagram#getTxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDiagram#getTxDiagram()
	 * @see #getRelDiagram()
	 * @generated
	 */
	EReference getRelDiagram_TxDiagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelDomainNode <em>Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Domain Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode
	 * @generated
	 */
	EClass getRelDomainNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelDomainNode#getReferredTypedModelNode <em>Referred Typed Model Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Typed Model Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getReferredTypedModelNode()
	 * @see #getRelDomainNode()
	 * @generated
	 */
	EReference getRelDomainNode_ReferredTypedModelNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.RelDomainNode#getRootPatternNodes <em>Root Pattern Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Root Pattern Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getRootPatternNodes()
	 * @see #getRelDomainNode()
	 * @generated
	 */
	EReference getRelDomainNode_RootPatternNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelInvocationEdge <em>Rel Invocation Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Invocation Edge</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationEdge
	 * @generated
	 */
	EClass getRelInvocationEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getReferredRelPatternNode <em>Referred Rel Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Rel Pattern Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationEdge#getReferredRelPatternNode()
	 * @see #getRelInvocationEdge()
	 * @generated
	 */
	EReference getRelInvocationEdge_ReferredRelPatternNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelInvocationNode <em>Rel Invocation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Invocation Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode
	 * @generated
	 */
	EClass getRelInvocationNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelInvocationNode#isIsThen <em>Is Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Then</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode#isIsThen()
	 * @see #getRelInvocationNode()
	 * @generated
	 */
	EAttribute getRelInvocationNode_IsThen();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelInvocationNode#getReferredRelDiagram <em>Referred Rel Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Rel Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode#getReferredRelDiagram()
	 * @see #getRelInvocationNode()
	 * @generated
	 */
	EReference getRelInvocationNode_ReferredRelDiagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelNode <em>Rel Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelNode
	 * @generated
	 */
	EClass getRelNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.RelNode#getDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.RelNode#getDiagram()
	 * @see #getRelNode()
	 * @generated
	 */
	EReference getRelNode_Diagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelPatternEdge <em>Rel Pattern Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Pattern Edge</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge
	 * @generated
	 */
	EClass getRelPatternEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getReferredProperty()
	 * @see #getRelPatternEdge()
	 * @generated
	 */
	EReference getRelPatternEdge_ReferredProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelPatternEdge#isIsOpposite <em>Is Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Opposite</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#isIsOpposite()
	 * @see #getRelPatternEdge()
	 * @generated
	 */
	EAttribute getRelPatternEdge_IsOpposite();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelPatternNode <em>Rel Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Pattern Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode
	 * @generated
	 */
	EClass getRelPatternNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelPatternNode#isIsRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#isIsRequired()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EAttribute getRelPatternNode_IsRequired();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternNode#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getReferredClass()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EReference getRelPatternNode_ReferredClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternNode#getRelDomainNode <em>Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Domain Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getRelDomainNode()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EReference getRelPatternNode_RelDomainNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram
	 * @generated
	 */
	EClass getTxDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedDiagrams <em>Owned Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Diagrams</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedDiagrams()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_OwnedDiagrams();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.TxDiagram#getPackage <em>Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getPackage()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EAttribute getTxDiagram_Package();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getTxImportNodes <em>Tx Import Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tx Import Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getTxImportNodes()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_TxImportNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getTxKeyNodes <em>Tx Key Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tx Key Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getTxKeyNodes()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_TxKeyNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getTxTypedModelNodes <em>Tx Typed Model Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tx Typed Model Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getTxTypedModelNodes()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_TxTypedModelNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxImportNode <em>Tx Import Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Import Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxImportNode
	 * @generated
	 */
	EClass getTxImportNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.TxImportNode#getUri <em>Uri</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Uri</em>'.
	 * @see org.eclipse.qvtd.umlx.TxImportNode#getUri()
	 * @see #getTxImportNode()
	 * @generated
	 */
	EAttribute getTxImportNode_Uri();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxImportNode#getTxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxImportNode#getTxDiagram()
	 * @see #getTxImportNode()
	 * @generated
	 */
	EReference getTxImportNode_TxDiagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxKeyNode <em>Tx Key Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Key Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode
	 * @generated
	 */
	EClass getTxKeyNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.TxKeyNode#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#getReferredClass()
	 * @see #getTxKeyNode()
	 * @generated
	 */
	EReference getTxKeyNode_ReferredClass();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxKeyNode#getTxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#getTxDiagram()
	 * @see #getTxKeyNode()
	 * @generated
	 */
	EReference getTxKeyNode_TxDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxKeyNode#getTxPartNodes <em>Tx Part Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tx Part Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#getTxPartNodes()
	 * @see #getTxKeyNode()
	 * @generated
	 */
	EReference getTxKeyNode_TxPartNodes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxPartNode <em>Tx Part Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Part Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPartNode
	 * @generated
	 */
	EClass getTxPartNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxPartNode#getTxKeyNode <em>Tx Key Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tx Key Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPartNode#getTxKeyNode()
	 * @see #getTxPartNode()
	 * @generated
	 */
	EReference getTxPartNode_TxKeyNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.TxPartNode#isIsOpposite <em>Is Opposite</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Opposite</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPartNode#isIsOpposite()
	 * @see #getTxPartNode()
	 * @generated
	 */
	EAttribute getTxPartNode_IsOpposite();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.TxPartNode#getReferredProperty <em>Referred Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Property</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPartNode#getReferredProperty()
	 * @see #getTxPartNode()
	 * @generated
	 */
	EReference getTxPartNode_ReferredProperty();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxNode <em>Tx Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxNode
	 * @generated
	 */
	EClass getTxNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxPackageNode <em>Tx Package Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Package Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPackageNode
	 * @generated
	 */
	EClass getTxPackageNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.TxPackageNode#getReferredPackage <em>Referred Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Package</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPackageNode#getReferredPackage()
	 * @see #getTxPackageNode()
	 * @generated
	 */
	EReference getTxPackageNode_ReferredPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxTypedModelNode <em>Tx Typed Model Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Typed Model Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode
	 * @generated
	 */
	EClass getTxTypedModelNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getTxPackageNodes <em>Tx Package Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tx Package Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getTxPackageNodes()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	EReference getTxTypedModelNode_TxPackageNodes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isCheck <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Check</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#isCheck()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	EAttribute getTxTypedModelNode_Check();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#isEnforce <em>Enforce</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enforce</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#isEnforce()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	EAttribute getTxTypedModelNode_Enforce();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getTxDiagram <em>Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getTxDiagram()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	EReference getTxTypedModelNode_TxDiagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.UMLXDiagram <em>Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXDiagram
	 * @generated
	 */
	EClass getUMLXDiagram();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.UMLXEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXEdge
	 * @generated
	 */
	EClass getUMLXEdge();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.UMLXEdge#getOwningSource <em>Owning Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Source</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXEdge#getOwningSource()
	 * @see #getUMLXEdge()
	 * @generated
	 */
	EReference getUMLXEdge_OwningSource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.UMLXEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXEdge#getTarget()
	 * @see #getUMLXEdge()
	 * @generated
	 */
	EReference getUMLXEdge_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.UMLXElement <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXElement
	 * @generated
	 */
	EClass getUMLXElement();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvtd.umlx.UMLXElement#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Comments</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXElement#getComments()
	 * @see #getUMLXElement()
	 * @generated
	 */
	EAttribute getUMLXElement_Comments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.UMLXModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXModel
	 * @generated
	 */
	EClass getUMLXModel();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.UMLXModel#getOwnedDiagrams <em>Owned Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Diagrams</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXModel#getOwnedDiagrams()
	 * @see #getUMLXModel()
	 * @generated
	 */
	EReference getUMLXModel_OwnedDiagrams();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.UMLXNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXNode
	 * @generated
	 */
	EClass getUMLXNode();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.UMLXNode#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming Edges</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXNode#getIncomingEdges()
	 * @see #getUMLXNode()
	 * @generated
	 */
	EReference getUMLXNode_IncomingEdges();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.UMLXNode#getOwnedOutgoingEdges <em>Owned Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Outgoing Edges</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXNode#getOwnedOutgoingEdges()
	 * @see #getUMLXNode()
	 * @generated
	 */
	EReference getUMLXNode_OwnedOutgoingEdges();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.UMLXNamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXNamedElement
	 * @generated
	 */
	EClass getUMLXNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.UMLXNamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXNamedElement#getName()
	 * @see #getUMLXNamedElement()
	 * @generated
	 */
	EAttribute getUMLXNamedElement_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UMLXFactory getUMLXFactory();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelConstraintNodeImpl <em>Rel Constraint Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelConstraintNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelConstraintNode()
		 * @generated
		 */
		EClass REL_CONSTRAINT_NODE = eINSTANCE.getRelConstraintNode();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_CONSTRAINT_NODE__EXPRESSION = eINSTANCE.getRelConstraintNode_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl <em>Rel Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelDiagramImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelDiagram()
		 * @generated
		 */
		EClass REL_DIAGRAM = eINSTANCE.getRelDiagram();

		/**
		 * The meta object literal for the '<em><b>Is Top</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_DIAGRAM__IS_TOP = eINSTANCE.getRelDiagram_IsTop();

		/**
		 * The meta object literal for the '<em><b>Owned Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DIAGRAM__OWNED_NODES = eINSTANCE.getRelDiagram_OwnedNodes();

		/**
		 * The meta object literal for the '<em><b>Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DIAGRAM__TX_DIAGRAM = eINSTANCE.getRelDiagram_TxDiagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl <em>Rel Domain Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelDomainNode()
		 * @generated
		 */
		EClass REL_DOMAIN_NODE = eINSTANCE.getRelDomainNode();

		/**
		 * The meta object literal for the '<em><b>Referred Typed Model Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE = eINSTANCE.getRelDomainNode_ReferredTypedModelNode();

		/**
		 * The meta object literal for the '<em><b>Root Pattern Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DOMAIN_NODE__ROOT_PATTERN_NODES = eINSTANCE.getRelDomainNode_RootPatternNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl <em>Rel Invocation Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelInvocationEdgeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelInvocationEdge()
		 * @generated
		 */
		EClass REL_INVOCATION_EDGE = eINSTANCE.getRelInvocationEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Rel Pattern Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE = eINSTANCE.getRelInvocationEdge_ReferredRelPatternNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl <em>Rel Invocation Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelInvocationNode()
		 * @generated
		 */
		EClass REL_INVOCATION_NODE = eINSTANCE.getRelInvocationNode();

		/**
		 * The meta object literal for the '<em><b>Is Then</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_INVOCATION_NODE__IS_THEN = eINSTANCE.getRelInvocationNode_IsThen();

		/**
		 * The meta object literal for the '<em><b>Referred Rel Diagram</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM = eINSTANCE.getRelInvocationNode_ReferredRelDiagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelNodeImpl <em>Rel Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelNode()
		 * @generated
		 */
		EClass REL_NODE = eINSTANCE.getRelNode();

		/**
		 * The meta object literal for the '<em><b>Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_NODE__DIAGRAM = eINSTANCE.getRelNode_Diagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl <em>Rel Pattern Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternEdge()
		 * @generated
		 */
		EClass REL_PATTERN_EDGE = eINSTANCE.getRelPatternEdge();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_EDGE__REFERRED_PROPERTY = eINSTANCE.getRelPatternEdge_ReferredProperty();

		/**
		 * The meta object literal for the '<em><b>Is Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_PATTERN_EDGE__IS_OPPOSITE = eINSTANCE.getRelPatternEdge_IsOpposite();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl <em>Rel Pattern Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternNode()
		 * @generated
		 */
		EClass REL_PATTERN_NODE = eINSTANCE.getRelPatternNode();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_PATTERN_NODE__IS_REQUIRED = eINSTANCE.getRelPatternNode_IsRequired();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_NODE__REFERRED_CLASS = eINSTANCE.getRelPatternNode_ReferredClass();

		/**
		 * The meta object literal for the '<em><b>Rel Domain Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_NODE__REL_DOMAIN_NODE = eINSTANCE.getRelPatternNode_RelDomainNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl <em>Tx Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxDiagramImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxDiagram()
		 * @generated
		 */
		EClass TX_DIAGRAM = eINSTANCE.getTxDiagram();

		/**
		 * The meta object literal for the '<em><b>Owned Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__OWNED_DIAGRAMS = eINSTANCE.getTxDiagram_OwnedDiagrams();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_DIAGRAM__PACKAGE = eINSTANCE.getTxDiagram_Package();

		/**
		 * The meta object literal for the '<em><b>Tx Import Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__TX_IMPORT_NODES = eINSTANCE.getTxDiagram_TxImportNodes();

		/**
		 * The meta object literal for the '<em><b>Tx Key Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__TX_KEY_NODES = eINSTANCE.getTxDiagram_TxKeyNodes();

		/**
		 * The meta object literal for the '<em><b>Tx Typed Model Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__TX_TYPED_MODEL_NODES = eINSTANCE.getTxDiagram_TxTypedModelNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxImportNodeImpl <em>Tx Import Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxImportNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxImportNode()
		 * @generated
		 */
		EClass TX_IMPORT_NODE = eINSTANCE.getTxImportNode();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_IMPORT_NODE__URI = eINSTANCE.getTxImportNode_Uri();

		/**
		 * The meta object literal for the '<em><b>Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_IMPORT_NODE__TX_DIAGRAM = eINSTANCE.getTxImportNode_TxDiagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl <em>Tx Key Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxKeyNode()
		 * @generated
		 */
		EClass TX_KEY_NODE = eINSTANCE.getTxKeyNode();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_KEY_NODE__REFERRED_CLASS = eINSTANCE.getTxKeyNode_ReferredClass();

		/**
		 * The meta object literal for the '<em><b>Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_KEY_NODE__TX_DIAGRAM = eINSTANCE.getTxKeyNode_TxDiagram();

		/**
		 * The meta object literal for the '<em><b>Tx Part Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_KEY_NODE__TX_PART_NODES = eINSTANCE.getTxKeyNode_TxPartNodes();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxPartNodeImpl <em>Tx Part Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxPartNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxPartNode()
		 * @generated
		 */
		EClass TX_PART_NODE = eINSTANCE.getTxPartNode();

		/**
		 * The meta object literal for the '<em><b>Tx Key Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_PART_NODE__TX_KEY_NODE = eINSTANCE.getTxPartNode_TxKeyNode();

		/**
		 * The meta object literal for the '<em><b>Is Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_PART_NODE__IS_OPPOSITE = eINSTANCE.getTxPartNode_IsOpposite();

		/**
		 * The meta object literal for the '<em><b>Referred Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_PART_NODE__REFERRED_PROPERTY = eINSTANCE.getTxPartNode_ReferredProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxNodeImpl <em>Tx Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxNode()
		 * @generated
		 */
		EClass TX_NODE = eINSTANCE.getTxNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl <em>Tx Package Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxPackageNode()
		 * @generated
		 */
		EClass TX_PACKAGE_NODE = eINSTANCE.getTxPackageNode();

		/**
		 * The meta object literal for the '<em><b>Referred Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_PACKAGE_NODE__REFERRED_PACKAGE = eINSTANCE.getTxPackageNode_ReferredPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl <em>Tx Typed Model Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxTypedModelNode()
		 * @generated
		 */
		EClass TX_TYPED_MODEL_NODE = eINSTANCE.getTxTypedModelNode();

		/**
		 * The meta object literal for the '<em><b>Tx Package Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES = eINSTANCE.getTxTypedModelNode_TxPackageNodes();

		/**
		 * The meta object literal for the '<em><b>Check</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_TYPED_MODEL_NODE__CHECK = eINSTANCE.getTxTypedModelNode_Check();

		/**
		 * The meta object literal for the '<em><b>Enforce</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_TYPED_MODEL_NODE__ENFORCE = eINSTANCE.getTxTypedModelNode_Enforce();

		/**
		 * The meta object literal for the '<em><b>Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_TYPED_MODEL_NODE__TX_DIAGRAM = eINSTANCE.getTxTypedModelNode_TxDiagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.UMLXDiagramImpl <em>Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.UMLXDiagramImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXDiagram()
		 * @generated
		 */
		EClass UMLX_DIAGRAM = eINSTANCE.getUMLXDiagram();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.UMLXEdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.UMLXEdgeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXEdge()
		 * @generated
		 */
		EClass UMLX_EDGE = eINSTANCE.getUMLXEdge();

		/**
		 * The meta object literal for the '<em><b>Owning Source</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UMLX_EDGE__OWNING_SOURCE = eINSTANCE.getUMLXEdge_OwningSource();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UMLX_EDGE__TARGET = eINSTANCE.getUMLXEdge_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.UMLXElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.UMLXElementImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXElement()
		 * @generated
		 */
		EClass UMLX_ELEMENT = eINSTANCE.getUMLXElement();

		/**
		 * The meta object literal for the '<em><b>Comments</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UMLX_ELEMENT__COMMENTS = eINSTANCE.getUMLXElement_Comments();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.UMLXModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.UMLXModelImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXModel()
		 * @generated
		 */
		EClass UMLX_MODEL = eINSTANCE.getUMLXModel();

		/**
		 * The meta object literal for the '<em><b>Owned Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UMLX_MODEL__OWNED_DIAGRAMS = eINSTANCE.getUMLXModel_OwnedDiagrams();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.UMLXNodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.UMLXNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXNode()
		 * @generated
		 */
		EClass UMLX_NODE = eINSTANCE.getUMLXNode();

		/**
		 * The meta object literal for the '<em><b>Incoming Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UMLX_NODE__INCOMING_EDGES = eINSTANCE.getUMLXNode_IncomingEdges();

		/**
		 * The meta object literal for the '<em><b>Owned Outgoing Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UMLX_NODE__OWNED_OUTGOING_EDGES = eINSTANCE.getUMLXNode_OwnedOutgoingEdges();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.UMLXNamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.UMLXNamedElementImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXNamedElement()
		 * @generated
		 */
		EClass UMLX_NAMED_ELEMENT = eINSTANCE.getUMLXNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UMLX_NAMED_ELEMENT__NAME = eINSTANCE.getUMLXNamedElement_Name();

	}

} //UMLXPackage
