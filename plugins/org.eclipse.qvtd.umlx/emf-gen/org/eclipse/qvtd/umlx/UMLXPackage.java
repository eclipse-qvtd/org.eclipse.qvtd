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
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl <em>Rel Pattern Class Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternClassNode()
	 * @generated
	 */
	int REL_PATTERN_CLASS_NODE = 6;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelDiagramImpl <em>Rel Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelDiagramImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelDiagram()
	 * @generated
	 */
	int REL_DIAGRAM = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl <em>Rel Domain Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelDomainNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelDomainNode()
	 * @generated
	 */
	int REL_DOMAIN_NODE = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelEdgeImpl <em>Rel Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelEdgeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelEdge()
	 * @generated
	 */
	int REL_EDGE = 2;

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
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl <em>Rel Invocation Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelInvocationNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelInvocationNode()
	 * @generated
	 */
	int REL_INVOCATION_NODE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl <em>Rel Pattern Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelPatternEdgeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternEdge()
	 * @generated
	 */
	int REL_PATTERN_EDGE = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxDiagramImpl <em>Tx Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxDiagramImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxDiagram()
	 * @generated
	 */
	int TX_DIAGRAM = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxNodeImpl <em>Tx Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxNode()
	 * @generated
	 */
	int TX_NODE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxImportNodeImpl <em>Tx Import Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxImportNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxImportNode()
	 * @generated
	 */
	int TX_IMPORT_NODE = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl <em>Tx Key Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxKeyNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxKeyNode()
	 * @generated
	 */
	int TX_KEY_NODE = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxPartNodeImpl <em>Tx Part Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxPartNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxPartNode()
	 * @generated
	 */
	int TX_PART_NODE = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl <em>Tx Package Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxPackageNode()
	 * @generated
	 */
	int TX_PACKAGE_NODE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl <em>Tx Typed Model Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.TxTypedModelNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxTypedModelNode()
	 * @generated
	 */
	int TX_TYPED_MODEL_NODE = 16;

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
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__COMMENTS = UMLX_NAMED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__NAME = UMLX_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Is Top</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__IS_TOP = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Rel Domain Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__OWNED_REL_DOMAIN_NODES = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Rel Invocation Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__OWNED_REL_INVOCATION_NODES = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Tx Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM__OWNING_TX_DIAGRAM = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rel Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DIAGRAM_FEATURE_COUNT = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4;

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
	int REL_NODE__COMMENTS = UMLX_ELEMENT__COMMENTS;

	/**
	 * The number of structural features of the '<em>Rel Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_NODE_FEATURE_COUNT = UMLX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__COMMENTS = REL_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Rel Pattern Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES = REL_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Rel Pattern Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES = REL_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owning Rel Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__OWNING_REL_DIAGRAM = REL_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Referred Tx Typed Model Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE = REL_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rel Domain Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_DOMAIN_NODE_FEATURE_COUNT = REL_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_EDGE__COMMENTS = UMLX_ELEMENT__COMMENTS;

	/**
	 * The number of structural features of the '<em>Rel Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_EDGE_FEATURE_COUNT = UMLX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE__COMMENTS = REL_EDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Referred Rel Pattern Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE = REL_EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Rel Invocation Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE__OWNING_REL_INVOCATION_NODE = REL_EDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Invoking Rel Pattern Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE__INVOKING_REL_PATTERN_NODE = REL_EDGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Rel Invocation Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_EDGE_FEATURE_COUNT = REL_EDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__COMMENTS = REL_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Is Then</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__IS_THEN = REL_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Rel Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__OWNING_REL_DIAGRAM = REL_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Rel Invocation Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES = REL_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Referred Rel Diagram</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM = REL_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rel Invocation Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_INVOCATION_NODE_FEATURE_COUNT = REL_NODE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl <em>Rel Pattern Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelPatternNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternNode()
	 * @generated
	 */
	int REL_PATTERN_NODE = 9;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__COMMENTS = REL_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__INCOMING = REL_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__IS_ROOT = REL_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__OUTGOING = REL_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owning Rel Domain Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE__OWNING_REL_DOMAIN_NODE = REL_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rel Pattern Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_NODE_FEATURE_COUNT = REL_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE__COMMENTS = REL_PATTERN_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE__INCOMING = REL_PATTERN_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE__IS_ROOT = REL_PATTERN_NODE__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE__OUTGOING = REL_PATTERN_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Owning Rel Domain Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE__OWNING_REL_DOMAIN_NODE = REL_PATTERN_NODE__OWNING_REL_DOMAIN_NODE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE__NAME = REL_PATTERN_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE__IS_REQUIRED = REL_PATTERN_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE__REFERRED_CLASS = REL_PATTERN_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Rel Domain Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE__REL_DOMAIN_NODE = REL_PATTERN_NODE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Rel Pattern Class Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_CLASS_NODE_FEATURE_COUNT = REL_PATTERN_NODE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__COMMENTS = REL_EDGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Is Opposite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__IS_OPPOSITE = REL_EDGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Rel Domain Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE = REL_EDGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__REFERRED_PROPERTY = REL_EDGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__SOURCE = REL_EDGE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE__TARGET = REL_EDGE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Rel Pattern Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EDGE_FEATURE_COUNT = REL_EDGE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternExpressionNodeImpl <em>Rel Pattern Expression Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.qvtd.umlx.impl.RelPatternExpressionNodeImpl
	 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternExpressionNode()
	 * @generated
	 */
	int REL_PATTERN_EXPRESSION_NODE = 8;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EXPRESSION_NODE__COMMENTS = REL_PATTERN_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Incoming</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EXPRESSION_NODE__INCOMING = REL_PATTERN_NODE__INCOMING;

	/**
	 * The feature id for the '<em><b>Is Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EXPRESSION_NODE__IS_ROOT = REL_PATTERN_NODE__IS_ROOT;

	/**
	 * The feature id for the '<em><b>Outgoing</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EXPRESSION_NODE__OUTGOING = REL_PATTERN_NODE__OUTGOING;

	/**
	 * The feature id for the '<em><b>Owning Rel Domain Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EXPRESSION_NODE__OWNING_REL_DOMAIN_NODE = REL_PATTERN_NODE__OWNING_REL_DOMAIN_NODE;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EXPRESSION_NODE__EXPRESSION = REL_PATTERN_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Rel Pattern Expression Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REL_PATTERN_EXPRESSION_NODE_FEATURE_COUNT = REL_PATTERN_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__COMMENTS = UMLX_NAMED_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__NAME = UMLX_NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Owned Rel Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__OWNED_REL_DIAGRAMS = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owned Tx Import Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__OWNED_TX_IMPORT_NODES = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owned Tx Key Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__OWNED_TX_KEY_NODES = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Owned Tx Typed Model Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Package</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM__PACKAGE = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Tx Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_DIAGRAM_FEATURE_COUNT = UMLX_NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_NODE__COMMENTS = UMLX_ELEMENT__COMMENTS;

	/**
	 * The number of structural features of the '<em>Tx Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_NODE_FEATURE_COUNT = UMLX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__COMMENTS = TX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__NAME = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Tx Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__OWNING_TX_DIAGRAM = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Uri</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE__URI = TX_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tx Import Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_IMPORT_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__COMMENTS = TX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Tx Part Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__OWNED_TX_PART_NODES = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Tx Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__OWNING_TX_DIAGRAM = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE__REFERRED_CLASS = TX_NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Tx Key Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_KEY_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PACKAGE_NODE__COMMENTS = TX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Referred Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PACKAGE_NODE__REFERRED_PACKAGE = TX_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owning Tx Typed Model Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE = TX_NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Tx Package Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PACKAGE_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PART_NODE__COMMENTS = TX_NODE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Owning Tx Key Node</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_PART_NODE__OWNING_TX_KEY_NODE = TX_NODE_FEATURE_COUNT + 0;

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
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__COMMENTS = TX_NODE__COMMENTS;

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
	 * The feature id for the '<em><b>Owned Tx Package Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES = TX_NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Owning Tx Diagram</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM = TX_NODE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Tx Typed Model Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TX_TYPED_MODEL_NODE_FEATURE_COUNT = TX_NODE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_MODEL__COMMENTS = UMLX_ELEMENT__COMMENTS;

	/**
	 * The feature id for the '<em><b>Owned Tx Diagrams</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_MODEL__OWNED_TX_DIAGRAMS = UMLX_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UMLX_MODEL_FEATURE_COUNT = UMLX_ELEMENT_FEATURE_COUNT + 1;

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.RelDiagram#getOwnedRelDomainNodes <em>Owned Rel Domain Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Rel Domain Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDiagram#getOwnedRelDomainNodes()
	 * @see #getRelDiagram()
	 * @generated
	 */
	EReference getRelDiagram_OwnedRelDomainNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.RelDiagram#getOwnedRelInvocationNodes <em>Owned Rel Invocation Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Rel Invocation Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDiagram#getOwnedRelInvocationNodes()
	 * @see #getRelDiagram()
	 * @generated
	 */
	EReference getRelDiagram_OwnedRelInvocationNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.RelDiagram#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDiagram#getOwningTxDiagram()
	 * @see #getRelDiagram()
	 * @generated
	 */
	EReference getRelDiagram_OwningTxDiagram();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternEdges <em>Owned Rel Pattern Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Rel Pattern Edges</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternEdges()
	 * @see #getRelDomainNode()
	 * @generated
	 */
	EReference getRelDomainNode_OwnedRelPatternEdges();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternNodes <em>Owned Rel Pattern Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Rel Pattern Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternNodes()
	 * @see #getRelDomainNode()
	 * @generated
	 */
	EReference getRelDomainNode_OwnedRelPatternNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.RelDomainNode#getOwningRelDiagram <em>Owning Rel Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Rel Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getOwningRelDiagram()
	 * @see #getRelDomainNode()
	 * @generated
	 */
	EReference getRelDomainNode_OwningRelDiagram();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelDomainNode#getReferredTxTypedModelNode <em>Referred Tx Typed Model Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Tx Typed Model Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getReferredTxTypedModelNode()
	 * @see #getRelDomainNode()
	 * @generated
	 */
	EReference getRelDomainNode_ReferredTxTypedModelNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelEdge <em>Rel Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Edge</em>'.
	 * @see org.eclipse.qvtd.umlx.RelEdge
	 * @generated
	 */
	EClass getRelEdge();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getOwningRelInvocationNode <em>Owning Rel Invocation Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Rel Invocation Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationEdge#getOwningRelInvocationNode()
	 * @see #getRelInvocationEdge()
	 * @generated
	 */
	EReference getRelInvocationEdge_OwningRelInvocationNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getInvokingRelPatternNode <em>Invoking Rel Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Invoking Rel Pattern Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationEdge#getInvokingRelPatternNode()
	 * @see #getRelInvocationEdge()
	 * @generated
	 */
	EReference getRelInvocationEdge_InvokingRelPatternNode();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.RelInvocationNode#getOwningRelDiagram <em>Owning Rel Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Rel Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode#getOwningRelDiagram()
	 * @see #getRelInvocationNode()
	 * @generated
	 */
	EReference getRelInvocationNode_OwningRelDiagram();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.RelInvocationNode#getOwnedRelInvocationEdges <em>Owned Rel Invocation Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Rel Invocation Edges</em>'.
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode#getOwnedRelInvocationEdges()
	 * @see #getRelInvocationNode()
	 * @generated
	 */
	EReference getRelInvocationNode_OwnedRelInvocationEdges();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getSource()
	 * @see #getRelPatternEdge()
	 * @generated
	 */
	EReference getRelPatternEdge_Source();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Rel Domain Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getOwningRelDomainNode()
	 * @see #getRelPatternEdge()
	 * @generated
	 */
	EReference getRelPatternEdge_OwningRelDomainNode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getTarget()
	 * @see #getRelPatternEdge()
	 * @generated
	 */
	EReference getRelPatternEdge_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelPatternExpressionNode <em>Rel Pattern Expression Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Pattern Expression Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternExpressionNode
	 * @generated
	 */
	EClass getRelPatternExpressionNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelPatternExpressionNode#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternExpressionNode#getExpression()
	 * @see #getRelPatternExpressionNode()
	 * @generated
	 */
	EAttribute getRelPatternExpressionNode_Expression();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.RelPatternNode#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Incoming</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getIncoming()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EReference getRelPatternNode_Incoming();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelPatternNode#isIsRoot <em>Is Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Root</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#isIsRoot()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EAttribute getRelPatternNode_IsRoot();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.RelPatternNode#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Outgoing</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getOutgoing()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EReference getRelPatternNode_Outgoing();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.RelPatternNode#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Rel Domain Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getOwningRelDomainNode()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EReference getRelPatternNode_OwningRelDomainNode();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedRelDiagrams <em>Owned Rel Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Rel Diagrams</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedRelDiagrams()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_OwnedRelDiagrams();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxImportNodes <em>Owned Tx Import Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tx Import Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxImportNodes()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_OwnedTxImportNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxKeyNodes <em>Owned Tx Key Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tx Key Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxKeyNodes()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_OwnedTxKeyNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxTypedModelNodes <em>Owned Tx Typed Model Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tx Typed Model Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxTypedModelNodes()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_OwnedTxTypedModelNodes();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxImportNode <em>Tx Import Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Import Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxImportNode
	 * @generated
	 */
	EClass getTxImportNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxImportNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxImportNode#getOwningTxDiagram()
	 * @see #getTxImportNode()
	 * @generated
	 */
	EReference getTxImportNode_OwningTxDiagram();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxKeyNode <em>Tx Key Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Key Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode
	 * @generated
	 */
	EClass getTxKeyNode();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxKeyNode#getOwnedTxPartNodes <em>Owned Tx Part Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tx Part Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#getOwnedTxPartNodes()
	 * @see #getTxKeyNode()
	 * @generated
	 */
	EReference getTxKeyNode_OwnedTxPartNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxKeyNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#getOwningTxDiagram()
	 * @see #getTxKeyNode()
	 * @generated
	 */
	EReference getTxKeyNode_OwningTxDiagram();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxPartNode <em>Tx Part Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Part Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPartNode
	 * @generated
	 */
	EClass getTxPartNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxPartNode#getOwningTxKeyNode <em>Owning Tx Key Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Tx Key Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPartNode#getOwningTxKeyNode()
	 * @see #getTxPartNode()
	 * @generated
	 */
	EReference getTxPartNode_OwningTxKeyNode();

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
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxPackageNode#getOwningTxTypedModelNode <em>Owning Tx Typed Model Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Tx Typed Model Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPackageNode#getOwningTxTypedModelNode()
	 * @see #getTxPackageNode()
	 * @generated
	 */
	EReference getTxPackageNode_OwningTxTypedModelNode();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getOwnedTxPackageNodes <em>Owned Tx Package Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tx Package Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getOwnedTxPackageNodes()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	EReference getTxTypedModelNode_OwnedTxPackageNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getOwningTxDiagram()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	EReference getTxTypedModelNode_OwningTxDiagram();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.UMLXModel#getOwnedTxDiagrams <em>Owned Tx Diagrams</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tx Diagrams</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXModel#getOwnedTxDiagrams()
	 * @see #getUMLXModel()
	 * @generated
	 */
	EReference getUMLXModel_OwnedTxDiagrams();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.RelPatternClassNode <em>Rel Pattern Class Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rel Pattern Class Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternClassNode
	 * @generated
	 */
	EClass getRelPatternClassNode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelPatternClassNode#isIsRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternClassNode#isIsRequired()
	 * @see #getRelPatternClassNode()
	 * @generated
	 */
	EAttribute getRelPatternClassNode_IsRequired();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternClassNode#getReferredClass <em>Referred Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred Class</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternClassNode#getReferredClass()
	 * @see #getRelPatternClassNode()
	 * @generated
	 */
	EReference getRelPatternClassNode_ReferredClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternClassNode#getRelDomainNode <em>Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Rel Domain Node</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternClassNode#getRelDomainNode()
	 * @see #getRelPatternClassNode()
	 * @generated
	 */
	EReference getRelPatternClassNode_RelDomainNode();

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
		 * The meta object literal for the '<em><b>Owned Rel Domain Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DIAGRAM__OWNED_REL_DOMAIN_NODES = eINSTANCE.getRelDiagram_OwnedRelDomainNodes();

		/**
		 * The meta object literal for the '<em><b>Owned Rel Invocation Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DIAGRAM__OWNED_REL_INVOCATION_NODES = eINSTANCE.getRelDiagram_OwnedRelInvocationNodes();

		/**
		 * The meta object literal for the '<em><b>Owning Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DIAGRAM__OWNING_TX_DIAGRAM = eINSTANCE.getRelDiagram_OwningTxDiagram();

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
		 * The meta object literal for the '<em><b>Owned Rel Pattern Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES = eINSTANCE.getRelDomainNode_OwnedRelPatternEdges();

		/**
		 * The meta object literal for the '<em><b>Owned Rel Pattern Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES = eINSTANCE.getRelDomainNode_OwnedRelPatternNodes();

		/**
		 * The meta object literal for the '<em><b>Owning Rel Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DOMAIN_NODE__OWNING_REL_DIAGRAM = eINSTANCE.getRelDomainNode_OwningRelDiagram();

		/**
		 * The meta object literal for the '<em><b>Referred Tx Typed Model Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE = eINSTANCE.getRelDomainNode_ReferredTxTypedModelNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelEdgeImpl <em>Rel Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelEdgeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelEdge()
		 * @generated
		 */
		EClass REL_EDGE = eINSTANCE.getRelEdge();

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
		 * The meta object literal for the '<em><b>Owning Rel Invocation Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_INVOCATION_EDGE__OWNING_REL_INVOCATION_NODE = eINSTANCE.getRelInvocationEdge_OwningRelInvocationNode();

		/**
		 * The meta object literal for the '<em><b>Invoking Rel Pattern Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_INVOCATION_EDGE__INVOKING_REL_PATTERN_NODE = eINSTANCE.getRelInvocationEdge_InvokingRelPatternNode();

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
		 * The meta object literal for the '<em><b>Owning Rel Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_INVOCATION_NODE__OWNING_REL_DIAGRAM = eINSTANCE.getRelInvocationNode_OwningRelDiagram();

		/**
		 * The meta object literal for the '<em><b>Owned Rel Invocation Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES = eINSTANCE.getRelInvocationNode_OwnedRelInvocationEdges();

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
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_EDGE__SOURCE = eINSTANCE.getRelPatternEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Is Opposite</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_PATTERN_EDGE__IS_OPPOSITE = eINSTANCE.getRelPatternEdge_IsOpposite();

		/**
		 * The meta object literal for the '<em><b>Owning Rel Domain Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE = eINSTANCE.getRelPatternEdge_OwningRelDomainNode();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_EDGE__TARGET = eINSTANCE.getRelPatternEdge_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternExpressionNodeImpl <em>Rel Pattern Expression Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelPatternExpressionNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternExpressionNode()
		 * @generated
		 */
		EClass REL_PATTERN_EXPRESSION_NODE = eINSTANCE.getRelPatternExpressionNode();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_PATTERN_EXPRESSION_NODE__EXPRESSION = eINSTANCE.getRelPatternExpressionNode_Expression();

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
		 * The meta object literal for the '<em><b>Incoming</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_NODE__INCOMING = eINSTANCE.getRelPatternNode_Incoming();

		/**
		 * The meta object literal for the '<em><b>Is Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_PATTERN_NODE__IS_ROOT = eINSTANCE.getRelPatternNode_IsRoot();

		/**
		 * The meta object literal for the '<em><b>Outgoing</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_NODE__OUTGOING = eINSTANCE.getRelPatternNode_Outgoing();

		/**
		 * The meta object literal for the '<em><b>Owning Rel Domain Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_NODE__OWNING_REL_DOMAIN_NODE = eINSTANCE.getRelPatternNode_OwningRelDomainNode();

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
		 * The meta object literal for the '<em><b>Owned Rel Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__OWNED_REL_DIAGRAMS = eINSTANCE.getTxDiagram_OwnedRelDiagrams();

		/**
		 * The meta object literal for the '<em><b>Owned Tx Import Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__OWNED_TX_IMPORT_NODES = eINSTANCE.getTxDiagram_OwnedTxImportNodes();

		/**
		 * The meta object literal for the '<em><b>Owned Tx Key Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__OWNED_TX_KEY_NODES = eINSTANCE.getTxDiagram_OwnedTxKeyNodes();

		/**
		 * The meta object literal for the '<em><b>Owned Tx Typed Model Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES = eINSTANCE.getTxDiagram_OwnedTxTypedModelNodes();

		/**
		 * The meta object literal for the '<em><b>Package</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_DIAGRAM__PACKAGE = eINSTANCE.getTxDiagram_Package();

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
		 * The meta object literal for the '<em><b>Owning Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_IMPORT_NODE__OWNING_TX_DIAGRAM = eINSTANCE.getTxImportNode_OwningTxDiagram();

		/**
		 * The meta object literal for the '<em><b>Uri</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_IMPORT_NODE__URI = eINSTANCE.getTxImportNode_Uri();

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
		 * The meta object literal for the '<em><b>Owned Tx Part Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_KEY_NODE__OWNED_TX_PART_NODES = eINSTANCE.getTxKeyNode_OwnedTxPartNodes();

		/**
		 * The meta object literal for the '<em><b>Owning Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_KEY_NODE__OWNING_TX_DIAGRAM = eINSTANCE.getTxKeyNode_OwningTxDiagram();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_KEY_NODE__REFERRED_CLASS = eINSTANCE.getTxKeyNode_ReferredClass();

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
		 * The meta object literal for the '<em><b>Owning Tx Key Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_PART_NODE__OWNING_TX_KEY_NODE = eINSTANCE.getTxPartNode_OwningTxKeyNode();

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
		 * The meta object literal for the '<em><b>Owning Tx Typed Model Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE = eINSTANCE.getTxPackageNode_OwningTxTypedModelNode();

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
		 * The meta object literal for the '<em><b>Owned Tx Package Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES = eINSTANCE.getTxTypedModelNode_OwnedTxPackageNodes();

		/**
		 * The meta object literal for the '<em><b>Owning Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM = eINSTANCE.getTxTypedModelNode_OwningTxDiagram();

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
		 * The meta object literal for the '<em><b>Owned Tx Diagrams</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UMLX_MODEL__OWNED_TX_DIAGRAMS = eINSTANCE.getUMLXModel_OwnedTxDiagrams();

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

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl <em>Rel Pattern Class Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.RelPatternClassNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getRelPatternClassNode()
		 * @generated
		 */
		EClass REL_PATTERN_CLASS_NODE = eINSTANCE.getRelPatternClassNode();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_PATTERN_CLASS_NODE__IS_REQUIRED = eINSTANCE.getRelPatternClassNode_IsRequired();

		/**
		 * The meta object literal for the '<em><b>Referred Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_CLASS_NODE__REFERRED_CLASS = eINSTANCE.getRelPatternClassNode_ReferredClass();

		/**
		 * The meta object literal for the '<em><b>Rel Domain Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_CLASS_NODE__REL_DOMAIN_NODE = eINSTANCE.getRelPatternClassNode_RelDomainNode();

	}

} //UMLXPackage
