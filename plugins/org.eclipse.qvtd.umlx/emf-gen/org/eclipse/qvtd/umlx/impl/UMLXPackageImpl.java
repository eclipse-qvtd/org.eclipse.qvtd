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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.qvtd.umlx.RelConstraintNode;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTransformationNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXDiagram;
import org.eclipse.qvtd.umlx.UMLXEdge;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXFactory;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXNode;
import org.eclipse.qvtd.umlx.UMLXPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UMLXPackageImpl extends EPackageImpl implements UMLXPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relConstraintNodeEClass = null;

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
	private EClass relNodeEClass = null;

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
	private EClass txKeyNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass txPartNodeEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlxDiagramEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlxEdgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlxElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlxModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass umlxNodeEClass = null;

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
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UMLXPackageImpl() {
		super(eNS_URI, UMLXFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link UMLXPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UMLXPackage init() {
		if (isInited) return (UMLXPackage)EPackage.Registry.INSTANCE.getEPackage(UMLXPackage.eNS_URI);

		// Obtain or create and register package
		Object ePackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UMLXPackageImpl theUMLXPackage = (UMLXPackageImpl)(ePackage instanceof UMLXPackageImpl ? ePackage : new UMLXPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theUMLXPackage.createPackageContents();

		// Initialize created meta-data
		theUMLXPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUMLXPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UMLXPackage.eNS_URI, theUMLXPackage);
		return theUMLXPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelConstraintNode() {
		return relConstraintNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelConstraintNode_Expression() {
		return (EAttribute)relConstraintNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelDiagram() {
		return relDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelDiagram_IsTop() {
		return (EAttribute)relDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelDomainNode() {
		return relDomainNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDomainNode_ReferredTypedModelNode() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDomainNode_RootPatternNodes() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelInvocationEdge() {
		return relInvocationEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelInvocationNode() {
		return relInvocationNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelInvocationNode_IsThen() {
		return (EAttribute)relInvocationNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelInvocationNode_ReferredRelationNode() {
		return (EReference)relInvocationNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelNode() {
		return relNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelPatternEdge() {
		return relPatternEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternEdge_ReferredProperty() {
		return (EReference)relPatternEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelPatternEdge_IsOpposite() {
		return (EAttribute)relPatternEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelPatternNode() {
		return relPatternNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelPatternNode_Name() {
		return (EAttribute)relPatternNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternNode_ReferredClass() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternNode_RelDomainNode() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxDiagram() {
		return txDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxDiagram_OwnedDiagrams() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxKeyNode() {
		return txKeyNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxKeyNode_TxTransformationNode() {
		return (EReference)txKeyNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxKeyNode_ReferredClass() {
		return (EReference)txKeyNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxKeyNode_TxPartNodes() {
		return (EReference)txKeyNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxPartNode() {
		return txPartNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxPartNode_TxKeyNode() {
		return (EReference)txPartNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxPartNode_IsOpposite() {
		return (EAttribute)txPartNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxPartNode_ReferredProperty() {
		return (EReference)txPartNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxNode() {
		return txNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxPackageNode() {
		return txPackageNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxPackageNode_ReferredPackage() {
		return (EReference)txPackageNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxTransformationNode() {
		return txTransformationNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxTransformationNode_Name() {
		return (EAttribute)txTransformationNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxTransformationNode_TxTypedModelNodes() {
		return (EReference)txTransformationNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxTransformationNode_TxKeyNodes() {
		return (EReference)txTransformationNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxTypedModelNode() {
		return txTypedModelNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxTypedModelNode_TxTransformationNode() {
		return (EReference)txTypedModelNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxTypedModelNode_Name() {
		return (EAttribute)txTypedModelNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxTypedModelNode_TxPackageNodes() {
		return (EReference)txTypedModelNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxTypedModelNode_Check() {
		return (EAttribute)txTypedModelNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxTypedModelNode_Enforce() {
		return (EAttribute)txTypedModelNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUMLXDiagram() {
		return umlxDiagramEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUMLXDiagram_Name() {
		return (EAttribute)umlxDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUMLXDiagram_OwnedNodes() {
		return (EReference)umlxDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUMLXEdge() {
		return umlxEdgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUMLXEdge_OwningSource() {
		return (EReference)umlxEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUMLXEdge_Target() {
		return (EReference)umlxEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUMLXElement() {
		return umlxElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUMLXModel() {
		return umlxModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUMLXModel_OwnedDiagrams() {
		return (EReference)umlxModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUMLXNode() {
		return umlxNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUMLXNode_Diagram() {
		return (EReference)umlxNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUMLXNode_IncomingEdges() {
		return (EReference)umlxNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUMLXNode_OwnedOutgoingEdges() {
		return (EReference)umlxNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UMLXFactory getUMLXFactory() {
		return (UMLXFactory)getEFactoryInstance();
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
		relConstraintNodeEClass = createEClass(REL_CONSTRAINT_NODE);
		createEAttribute(relConstraintNodeEClass, REL_CONSTRAINT_NODE__EXPRESSION);

		relDiagramEClass = createEClass(REL_DIAGRAM);
		createEAttribute(relDiagramEClass, REL_DIAGRAM__IS_TOP);

		relDomainNodeEClass = createEClass(REL_DOMAIN_NODE);
		createEReference(relDomainNodeEClass, REL_DOMAIN_NODE__REFERRED_TYPED_MODEL_NODE);
		createEReference(relDomainNodeEClass, REL_DOMAIN_NODE__ROOT_PATTERN_NODES);

		relInvocationEdgeEClass = createEClass(REL_INVOCATION_EDGE);

		relInvocationNodeEClass = createEClass(REL_INVOCATION_NODE);
		createEAttribute(relInvocationNodeEClass, REL_INVOCATION_NODE__IS_THEN);
		createEReference(relInvocationNodeEClass, REL_INVOCATION_NODE__REFERRED_RELATION_NODE);

		relNodeEClass = createEClass(REL_NODE);

		relPatternEdgeEClass = createEClass(REL_PATTERN_EDGE);
		createEReference(relPatternEdgeEClass, REL_PATTERN_EDGE__REFERRED_PROPERTY);
		createEAttribute(relPatternEdgeEClass, REL_PATTERN_EDGE__IS_OPPOSITE);

		relPatternNodeEClass = createEClass(REL_PATTERN_NODE);
		createEAttribute(relPatternNodeEClass, REL_PATTERN_NODE__NAME);
		createEReference(relPatternNodeEClass, REL_PATTERN_NODE__REFERRED_CLASS);
		createEReference(relPatternNodeEClass, REL_PATTERN_NODE__REL_DOMAIN_NODE);

		txDiagramEClass = createEClass(TX_DIAGRAM);
		createEReference(txDiagramEClass, TX_DIAGRAM__OWNED_DIAGRAMS);

		txKeyNodeEClass = createEClass(TX_KEY_NODE);
		createEReference(txKeyNodeEClass, TX_KEY_NODE__TX_TRANSFORMATION_NODE);
		createEReference(txKeyNodeEClass, TX_KEY_NODE__REFERRED_CLASS);
		createEReference(txKeyNodeEClass, TX_KEY_NODE__TX_PART_NODES);

		txPartNodeEClass = createEClass(TX_PART_NODE);
		createEReference(txPartNodeEClass, TX_PART_NODE__TX_KEY_NODE);
		createEAttribute(txPartNodeEClass, TX_PART_NODE__IS_OPPOSITE);
		createEReference(txPartNodeEClass, TX_PART_NODE__REFERRED_PROPERTY);

		txNodeEClass = createEClass(TX_NODE);

		txPackageNodeEClass = createEClass(TX_PACKAGE_NODE);
		createEReference(txPackageNodeEClass, TX_PACKAGE_NODE__REFERRED_PACKAGE);

		txTransformationNodeEClass = createEClass(TX_TRANSFORMATION_NODE);
		createEAttribute(txTransformationNodeEClass, TX_TRANSFORMATION_NODE__NAME);
		createEReference(txTransformationNodeEClass, TX_TRANSFORMATION_NODE__TX_TYPED_MODEL_NODES);
		createEReference(txTransformationNodeEClass, TX_TRANSFORMATION_NODE__TX_KEY_NODES);

		txTypedModelNodeEClass = createEClass(TX_TYPED_MODEL_NODE);
		createEReference(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__TX_TRANSFORMATION_NODE);
		createEAttribute(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__NAME);
		createEReference(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__TX_PACKAGE_NODES);
		createEAttribute(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__CHECK);
		createEAttribute(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__ENFORCE);

		umlxDiagramEClass = createEClass(UMLX_DIAGRAM);
		createEAttribute(umlxDiagramEClass, UMLX_DIAGRAM__NAME);
		createEReference(umlxDiagramEClass, UMLX_DIAGRAM__OWNED_NODES);

		umlxEdgeEClass = createEClass(UMLX_EDGE);
		createEReference(umlxEdgeEClass, UMLX_EDGE__OWNING_SOURCE);
		createEReference(umlxEdgeEClass, UMLX_EDGE__TARGET);

		umlxElementEClass = createEClass(UMLX_ELEMENT);

		umlxModelEClass = createEClass(UMLX_MODEL);
		createEReference(umlxModelEClass, UMLX_MODEL__OWNED_DIAGRAMS);

		umlxNodeEClass = createEClass(UMLX_NODE);
		createEReference(umlxNodeEClass, UMLX_NODE__DIAGRAM);
		createEReference(umlxNodeEClass, UMLX_NODE__INCOMING_EDGES);
		createEReference(umlxNodeEClass, UMLX_NODE__OWNED_OUTGOING_EDGES);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		relConstraintNodeEClass.getESuperTypes().add(this.getRelNode());
		relDiagramEClass.getESuperTypes().add(this.getUMLXDiagram());
		relDomainNodeEClass.getESuperTypes().add(this.getRelNode());
		relInvocationEdgeEClass.getESuperTypes().add(this.getUMLXEdge());
		relInvocationNodeEClass.getESuperTypes().add(this.getRelNode());
		relNodeEClass.getESuperTypes().add(this.getUMLXNode());
		relPatternEdgeEClass.getESuperTypes().add(this.getUMLXEdge());
		relPatternNodeEClass.getESuperTypes().add(this.getRelNode());
		txDiagramEClass.getESuperTypes().add(this.getUMLXDiagram());
		txKeyNodeEClass.getESuperTypes().add(this.getTxNode());
		txPartNodeEClass.getESuperTypes().add(this.getTxNode());
		txNodeEClass.getESuperTypes().add(this.getUMLXNode());
		txPackageNodeEClass.getESuperTypes().add(this.getTxNode());
		txTransformationNodeEClass.getESuperTypes().add(this.getTxNode());
		txTypedModelNodeEClass.getESuperTypes().add(this.getTxNode());
		umlxDiagramEClass.getESuperTypes().add(this.getUMLXElement());
		umlxEdgeEClass.getESuperTypes().add(this.getUMLXElement());
		umlxModelEClass.getESuperTypes().add(this.getUMLXElement());
		umlxNodeEClass.getESuperTypes().add(this.getUMLXElement());

		// Initialize classes and features; add operations and parameters
		initEClass(relConstraintNodeEClass, RelConstraintNode.class, "RelConstraintNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelConstraintNode_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, RelConstraintNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relDiagramEClass, RelDiagram.class, "RelDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelDiagram_IsTop(), ecorePackage.getEBoolean(), "isTop", "false", 1, 1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relDomainNodeEClass, RelDomainNode.class, "RelDomainNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelDomainNode_ReferredTypedModelNode(), this.getTxTypedModelNode(), null, "referredTypedModelNode", null, 1, 1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDomainNode_RootPatternNodes(), this.getRelPatternNode(), this.getRelPatternNode_RelDomainNode(), "rootPatternNodes", null, 1, -1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relInvocationEdgeEClass, RelInvocationEdge.class, "RelInvocationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relInvocationNodeEClass, RelInvocationNode.class, "RelInvocationNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelInvocationNode_IsThen(), ecorePackage.getEBoolean(), "isThen", "true", 1, 1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationNode_ReferredRelationNode(), this.getRelDiagram(), null, "referredRelationNode", null, 1, 1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relNodeEClass, RelNode.class, "RelNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relPatternEdgeEClass, RelPatternEdge.class, "RelPatternEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelPatternEdge_ReferredProperty(), ecorePackage.getEStructuralFeature(), null, "referredProperty", null, 1, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelPatternEdge_IsOpposite(), ecorePackage.getEBoolean(), "isOpposite", "true", 1, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relPatternNodeEClass, RelPatternNode.class, "RelPatternNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelPatternNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternNode_ReferredClass(), ecorePackage.getEClassifier(), null, "referredClass", null, 1, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternNode_RelDomainNode(), this.getRelDomainNode(), this.getRelDomainNode_RootPatternNodes(), "relDomainNode", null, 0, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txDiagramEClass, TxDiagram.class, "TxDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxDiagram_OwnedDiagrams(), this.getRelDiagram(), null, "ownedDiagrams", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txKeyNodeEClass, TxKeyNode.class, "TxKeyNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxKeyNode_TxTransformationNode(), this.getTxTransformationNode(), this.getTxTransformationNode_TxKeyNodes(), "txTransformationNode", null, 1, 1, TxKeyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxKeyNode_ReferredClass(), ecorePackage.getEClassifier(), null, "referredClass", null, 1, 1, TxKeyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxKeyNode_TxPartNodes(), this.getTxPartNode(), this.getTxPartNode_TxKeyNode(), "txPartNodes", null, 1, -1, TxKeyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txPartNodeEClass, TxPartNode.class, "TxPartNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxPartNode_TxKeyNode(), this.getTxKeyNode(), this.getTxKeyNode_TxPartNodes(), "txKeyNode", null, 1, 1, TxPartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxPartNode_IsOpposite(), ecorePackage.getEBoolean(), "isOpposite", "false", 1, 1, TxPartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxPartNode_ReferredProperty(), ecorePackage.getEStructuralFeature(), null, "referredProperty", null, 1, 1, TxPartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txNodeEClass, TxNode.class, "TxNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(txPackageNodeEClass, TxPackageNode.class, "TxPackageNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxPackageNode_ReferredPackage(), ecorePackage.getEPackage(), null, "referredPackage", null, 1, 1, TxPackageNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txTransformationNodeEClass, TxTransformationNode.class, "TxTransformationNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTxTransformationNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, TxTransformationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTransformationNode_TxTypedModelNodes(), this.getTxTypedModelNode(), this.getTxTypedModelNode_TxTransformationNode(), "txTypedModelNodes", null, 0, -1, TxTransformationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTransformationNode_TxKeyNodes(), this.getTxKeyNode(), this.getTxKeyNode_TxTransformationNode(), "txKeyNodes", null, 0, -1, TxTransformationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txTypedModelNodeEClass, TxTypedModelNode.class, "TxTypedModelNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxTypedModelNode_TxTransformationNode(), this.getTxTransformationNode(), this.getTxTransformationNode_TxTypedModelNodes(), "txTransformationNode", null, 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxTypedModelNode_Name(), ecorePackage.getEString(), "name", null, 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTypedModelNode_TxPackageNodes(), this.getTxPackageNode(), null, "txPackageNodes", null, 0, -1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxTypedModelNode_Check(), ecorePackage.getEBoolean(), "check", "false", 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxTypedModelNode_Enforce(), ecorePackage.getEBoolean(), "enforce", "false", 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxDiagramEClass, UMLXDiagram.class, "UMLXDiagram", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUMLXDiagram_Name(), ecorePackage.getEString(), "name", null, 1, 1, UMLXDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUMLXDiagram_OwnedNodes(), this.getUMLXNode(), this.getUMLXNode_Diagram(), "ownedNodes", null, 0, -1, UMLXDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxEdgeEClass, UMLXEdge.class, "UMLXEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUMLXEdge_OwningSource(), this.getUMLXNode(), this.getUMLXNode_OwnedOutgoingEdges(), "owningSource", null, 1, 1, UMLXEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUMLXEdge_Target(), this.getUMLXNode(), this.getUMLXNode_IncomingEdges(), "target", null, 1, 1, UMLXEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxElementEClass, UMLXElement.class, "UMLXElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(umlxModelEClass, UMLXModel.class, "UMLXModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUMLXModel_OwnedDiagrams(), this.getTxDiagram(), null, "ownedDiagrams", null, 0, -1, UMLXModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxNodeEClass, UMLXNode.class, "UMLXNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUMLXNode_Diagram(), this.getUMLXDiagram(), this.getUMLXDiagram_OwnedNodes(), "diagram", null, 0, 1, UMLXNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUMLXNode_IncomingEdges(), this.getUMLXEdge(), this.getUMLXEdge_Target(), "incomingEdges", null, 0, -1, UMLXNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUMLXNode_OwnedOutgoingEdges(), this.getUMLXEdge(), this.getUMLXEdge_OwningSource(), "ownedOutgoingEdges", null, 0, -1, UMLXNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UMLXPackageImpl
