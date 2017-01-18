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
import org.eclipse.qvtd.umlx.RelPatternExpressionNode;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelEdge;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.RelNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternClassNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxImportNode;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXFactory;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
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
	private EClass relEdgeEClass = null;

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
	private EClass relPatternExpressionNodeEClass = null;

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
	private EClass txImportNodeEClass = null;

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
	private EClass txTypedModelNodeEClass = null;

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
	private EClass umlxNamedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass relPatternClassNodeEClass = null;

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
	public EReference getRelDiagram_OwnedRelDomainNodes() {
		return (EReference)relDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDiagram_OwnedRelInvocationNodes() {
		return (EReference)relDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDiagram_OwningTxDiagram() {
		return (EReference)relDiagramEClass.getEStructuralFeatures().get(3);
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
	public EReference getRelDomainNode_OwnedRelPatternEdges() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDomainNode_OwnedRelPatternNodes() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDomainNode_OwningRelDiagram() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDomainNode_ReferredTxTypedModelNode() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelEdge() {
		return relEdgeEClass;
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
	public EReference getRelInvocationEdge_ReferredRelPatternNode() {
		return (EReference)relInvocationEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelInvocationEdge_OwningRelInvocationNode() {
		return (EReference)relInvocationEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelInvocationEdge_InvokingRelPatternNode() {
		return (EReference)relInvocationEdgeEClass.getEStructuralFeatures().get(2);
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
	public EReference getRelInvocationNode_ReferredRelDiagram() {
		return (EReference)relInvocationNodeEClass.getEStructuralFeatures().get(3);
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
	public EReference getRelInvocationNode_OwningRelDiagram() {
		return (EReference)relInvocationNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelInvocationNode_OwnedRelInvocationEdges() {
		return (EReference)relInvocationNodeEClass.getEStructuralFeatures().get(2);
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
		return (EReference)relPatternEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternEdge_Source() {
		return (EReference)relPatternEdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelPatternEdge_IsOpposite() {
		return (EAttribute)relPatternEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternEdge_OwningRelDomainNode() {
		return (EReference)relPatternEdgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternEdge_Target() {
		return (EReference)relPatternEdgeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelPatternExpressionNode() {
		return relPatternExpressionNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelPatternExpressionNode_Expression() {
		return (EAttribute)relPatternExpressionNodeEClass.getEStructuralFeatures().get(0);
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
	public EReference getRelPatternNode_Incoming() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelPatternNode_IsRoot() {
		return (EAttribute)relPatternNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternNode_Outgoing() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternNode_OwningRelDomainNode() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(3);
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
	public EReference getTxDiagram_OwnedRelDiagrams() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxDiagram_OwnedTxImportNodes() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxDiagram_OwnedTxKeyNodes() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxDiagram_OwnedTxTypedModelNodes() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxDiagram_Package() {
		return (EAttribute)txDiagramEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxImportNode() {
		return txImportNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxImportNode_OwningTxDiagram() {
		return (EReference)txImportNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxImportNode_Uri() {
		return (EAttribute)txImportNodeEClass.getEStructuralFeatures().get(1);
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
	public EReference getTxKeyNode_OwnedTxPartNodes() {
		return (EReference)txKeyNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxKeyNode_OwningTxDiagram() {
		return (EReference)txKeyNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxKeyNode_ReferredClass() {
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
	public EReference getTxPartNode_OwningTxKeyNode() {
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
	public EReference getTxPackageNode_OwningTxTypedModelNode() {
		return (EReference)txPackageNodeEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getTxTypedModelNode_Check() {
		return (EAttribute)txTypedModelNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxTypedModelNode_Enforce() {
		return (EAttribute)txTypedModelNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxTypedModelNode_OwnedTxPackageNodes() {
		return (EReference)txTypedModelNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxTypedModelNode_OwningTxDiagram() {
		return (EReference)txTypedModelNodeEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getUMLXElement_Comments() {
		return (EAttribute)umlxElementEClass.getEStructuralFeatures().get(0);
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
	public EReference getUMLXModel_OwnedTxDiagrams() {
		return (EReference)umlxModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUMLXNamedElement() {
		return umlxNamedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUMLXNamedElement_Name() {
		return (EAttribute)umlxNamedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelPatternClassNode() {
		return relPatternClassNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelPatternClassNode_IsRequired() {
		return (EAttribute)relPatternClassNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternClassNode_ReferredClass() {
		return (EReference)relPatternClassNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternClassNode_RelDomainNode() {
		return (EReference)relPatternClassNodeEClass.getEStructuralFeatures().get(2);
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
		relDiagramEClass = createEClass(REL_DIAGRAM);
		createEAttribute(relDiagramEClass, REL_DIAGRAM__IS_TOP);
		createEReference(relDiagramEClass, REL_DIAGRAM__OWNED_REL_DOMAIN_NODES);
		createEReference(relDiagramEClass, REL_DIAGRAM__OWNED_REL_INVOCATION_NODES);
		createEReference(relDiagramEClass, REL_DIAGRAM__OWNING_TX_DIAGRAM);

		relDomainNodeEClass = createEClass(REL_DOMAIN_NODE);
		createEReference(relDomainNodeEClass, REL_DOMAIN_NODE__OWNED_REL_PATTERN_EDGES);
		createEReference(relDomainNodeEClass, REL_DOMAIN_NODE__OWNED_REL_PATTERN_NODES);
		createEReference(relDomainNodeEClass, REL_DOMAIN_NODE__OWNING_REL_DIAGRAM);
		createEReference(relDomainNodeEClass, REL_DOMAIN_NODE__REFERRED_TX_TYPED_MODEL_NODE);

		relEdgeEClass = createEClass(REL_EDGE);

		relInvocationEdgeEClass = createEClass(REL_INVOCATION_EDGE);
		createEReference(relInvocationEdgeEClass, REL_INVOCATION_EDGE__REFERRED_REL_PATTERN_NODE);
		createEReference(relInvocationEdgeEClass, REL_INVOCATION_EDGE__OWNING_REL_INVOCATION_NODE);
		createEReference(relInvocationEdgeEClass, REL_INVOCATION_EDGE__INVOKING_REL_PATTERN_NODE);

		relInvocationNodeEClass = createEClass(REL_INVOCATION_NODE);
		createEAttribute(relInvocationNodeEClass, REL_INVOCATION_NODE__IS_THEN);
		createEReference(relInvocationNodeEClass, REL_INVOCATION_NODE__OWNING_REL_DIAGRAM);
		createEReference(relInvocationNodeEClass, REL_INVOCATION_NODE__OWNED_REL_INVOCATION_EDGES);
		createEReference(relInvocationNodeEClass, REL_INVOCATION_NODE__REFERRED_REL_DIAGRAM);

		relNodeEClass = createEClass(REL_NODE);

		relPatternClassNodeEClass = createEClass(REL_PATTERN_CLASS_NODE);
		createEAttribute(relPatternClassNodeEClass, REL_PATTERN_CLASS_NODE__IS_REQUIRED);
		createEReference(relPatternClassNodeEClass, REL_PATTERN_CLASS_NODE__REFERRED_CLASS);
		createEReference(relPatternClassNodeEClass, REL_PATTERN_CLASS_NODE__REL_DOMAIN_NODE);

		relPatternEdgeEClass = createEClass(REL_PATTERN_EDGE);
		createEAttribute(relPatternEdgeEClass, REL_PATTERN_EDGE__IS_OPPOSITE);
		createEReference(relPatternEdgeEClass, REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE);
		createEReference(relPatternEdgeEClass, REL_PATTERN_EDGE__REFERRED_PROPERTY);
		createEReference(relPatternEdgeEClass, REL_PATTERN_EDGE__SOURCE);
		createEReference(relPatternEdgeEClass, REL_PATTERN_EDGE__TARGET);

		relPatternExpressionNodeEClass = createEClass(REL_PATTERN_EXPRESSION_NODE);
		createEAttribute(relPatternExpressionNodeEClass, REL_PATTERN_EXPRESSION_NODE__EXPRESSION);

		relPatternNodeEClass = createEClass(REL_PATTERN_NODE);
		createEReference(relPatternNodeEClass, REL_PATTERN_NODE__INCOMING);
		createEAttribute(relPatternNodeEClass, REL_PATTERN_NODE__IS_ROOT);
		createEReference(relPatternNodeEClass, REL_PATTERN_NODE__OUTGOING);
		createEReference(relPatternNodeEClass, REL_PATTERN_NODE__OWNING_REL_DOMAIN_NODE);

		txDiagramEClass = createEClass(TX_DIAGRAM);
		createEReference(txDiagramEClass, TX_DIAGRAM__OWNED_REL_DIAGRAMS);
		createEReference(txDiagramEClass, TX_DIAGRAM__OWNED_TX_IMPORT_NODES);
		createEReference(txDiagramEClass, TX_DIAGRAM__OWNED_TX_KEY_NODES);
		createEReference(txDiagramEClass, TX_DIAGRAM__OWNED_TX_TYPED_MODEL_NODES);
		createEAttribute(txDiagramEClass, TX_DIAGRAM__PACKAGE);

		txImportNodeEClass = createEClass(TX_IMPORT_NODE);
		createEReference(txImportNodeEClass, TX_IMPORT_NODE__OWNING_TX_DIAGRAM);
		createEAttribute(txImportNodeEClass, TX_IMPORT_NODE__URI);

		txKeyNodeEClass = createEClass(TX_KEY_NODE);
		createEReference(txKeyNodeEClass, TX_KEY_NODE__OWNED_TX_PART_NODES);
		createEReference(txKeyNodeEClass, TX_KEY_NODE__OWNING_TX_DIAGRAM);
		createEReference(txKeyNodeEClass, TX_KEY_NODE__REFERRED_CLASS);

		txNodeEClass = createEClass(TX_NODE);

		txPackageNodeEClass = createEClass(TX_PACKAGE_NODE);
		createEReference(txPackageNodeEClass, TX_PACKAGE_NODE__REFERRED_PACKAGE);
		createEReference(txPackageNodeEClass, TX_PACKAGE_NODE__OWNING_TX_TYPED_MODEL_NODE);

		txPartNodeEClass = createEClass(TX_PART_NODE);
		createEReference(txPartNodeEClass, TX_PART_NODE__OWNING_TX_KEY_NODE);
		createEAttribute(txPartNodeEClass, TX_PART_NODE__IS_OPPOSITE);
		createEReference(txPartNodeEClass, TX_PART_NODE__REFERRED_PROPERTY);

		txTypedModelNodeEClass = createEClass(TX_TYPED_MODEL_NODE);
		createEAttribute(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__CHECK);
		createEAttribute(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__ENFORCE);
		createEReference(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__OWNED_TX_PACKAGE_NODES);
		createEReference(txTypedModelNodeEClass, TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM);

		umlxElementEClass = createEClass(UMLX_ELEMENT);
		createEAttribute(umlxElementEClass, UMLX_ELEMENT__COMMENTS);

		umlxModelEClass = createEClass(UMLX_MODEL);
		createEReference(umlxModelEClass, UMLX_MODEL__OWNED_TX_DIAGRAMS);

		umlxNamedElementEClass = createEClass(UMLX_NAMED_ELEMENT);
		createEAttribute(umlxNamedElementEClass, UMLX_NAMED_ELEMENT__NAME);
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
		relDiagramEClass.getESuperTypes().add(this.getUMLXNamedElement());
		relDomainNodeEClass.getESuperTypes().add(this.getRelNode());
		relEdgeEClass.getESuperTypes().add(this.getUMLXElement());
		relInvocationEdgeEClass.getESuperTypes().add(this.getRelEdge());
		relInvocationNodeEClass.getESuperTypes().add(this.getRelNode());
		relNodeEClass.getESuperTypes().add(this.getUMLXElement());
		relPatternClassNodeEClass.getESuperTypes().add(this.getRelPatternNode());
		relPatternClassNodeEClass.getESuperTypes().add(this.getUMLXNamedElement());
		relPatternEdgeEClass.getESuperTypes().add(this.getRelEdge());
		relPatternExpressionNodeEClass.getESuperTypes().add(this.getRelPatternNode());
		relPatternNodeEClass.getESuperTypes().add(this.getRelNode());
		txDiagramEClass.getESuperTypes().add(this.getUMLXNamedElement());
		txImportNodeEClass.getESuperTypes().add(this.getTxNode());
		txImportNodeEClass.getESuperTypes().add(this.getUMLXNamedElement());
		txKeyNodeEClass.getESuperTypes().add(this.getTxNode());
		txNodeEClass.getESuperTypes().add(this.getUMLXElement());
		txPackageNodeEClass.getESuperTypes().add(this.getTxNode());
		txPartNodeEClass.getESuperTypes().add(this.getTxNode());
		txTypedModelNodeEClass.getESuperTypes().add(this.getTxNode());
		txTypedModelNodeEClass.getESuperTypes().add(this.getUMLXNamedElement());
		umlxModelEClass.getESuperTypes().add(this.getUMLXElement());
		umlxNamedElementEClass.getESuperTypes().add(this.getUMLXElement());

		// Initialize classes and features; add operations and parameters
		initEClass(relDiagramEClass, RelDiagram.class, "RelDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelDiagram_IsTop(), ecorePackage.getEBoolean(), "isTop", "false", 1, 1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDiagram_OwnedRelDomainNodes(), this.getRelDomainNode(), this.getRelDomainNode_OwningRelDiagram(), "ownedRelDomainNodes", null, 0, -1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDiagram_OwnedRelInvocationNodes(), this.getRelInvocationNode(), this.getRelInvocationNode_OwningRelDiagram(), "ownedRelInvocationNodes", null, 0, -1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDiagram_OwningTxDiagram(), this.getTxDiagram(), this.getTxDiagram_OwnedRelDiagrams(), "owningTxDiagram", null, 1, 1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relDomainNodeEClass, RelDomainNode.class, "RelDomainNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelDomainNode_OwnedRelPatternEdges(), this.getRelPatternEdge(), this.getRelPatternEdge_OwningRelDomainNode(), "ownedRelPatternEdges", null, 0, -1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDomainNode_OwnedRelPatternNodes(), this.getRelPatternNode(), this.getRelPatternNode_OwningRelDomainNode(), "ownedRelPatternNodes", null, 0, -1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDomainNode_OwningRelDiagram(), this.getRelDiagram(), this.getRelDiagram_OwnedRelDomainNodes(), "owningRelDiagram", null, 1, 1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDomainNode_ReferredTxTypedModelNode(), this.getTxTypedModelNode(), null, "referredTxTypedModelNode", null, 0, 1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relEdgeEClass, RelEdge.class, "RelEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relInvocationEdgeEClass, RelInvocationEdge.class, "RelInvocationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelInvocationEdge_ReferredRelPatternNode(), this.getRelPatternClassNode(), null, "referredRelPatternNode", null, 1, 1, RelInvocationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationEdge_OwningRelInvocationNode(), this.getRelInvocationNode(), this.getRelInvocationNode_OwnedRelInvocationEdges(), "owningRelInvocationNode", null, 1, 1, RelInvocationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationEdge_InvokingRelPatternNode(), this.getRelPatternClassNode(), null, "invokingRelPatternNode", null, 1, 1, RelInvocationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relInvocationNodeEClass, RelInvocationNode.class, "RelInvocationNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelInvocationNode_IsThen(), ecorePackage.getEBoolean(), "isThen", "true", 1, 1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationNode_OwningRelDiagram(), this.getRelDiagram(), this.getRelDiagram_OwnedRelInvocationNodes(), "owningRelDiagram", null, 1, 1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationNode_OwnedRelInvocationEdges(), this.getRelInvocationEdge(), this.getRelInvocationEdge_OwningRelInvocationNode(), "ownedRelInvocationEdges", null, 0, -1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationNode_ReferredRelDiagram(), this.getRelDiagram(), null, "referredRelDiagram", null, 1, 1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relNodeEClass, RelNode.class, "RelNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relPatternClassNodeEClass, RelPatternClassNode.class, "RelPatternClassNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelPatternClassNode_IsRequired(), ecorePackage.getEBoolean(), "isRequired", "true", 1, 1, RelPatternClassNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternClassNode_ReferredClass(), ecorePackage.getEClassifier(), null, "referredClass", null, 1, 1, RelPatternClassNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternClassNode_RelDomainNode(), this.getRelDomainNode(), null, "relDomainNode", null, 0, 1, RelPatternClassNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relPatternEdgeEClass, RelPatternEdge.class, "RelPatternEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelPatternEdge_IsOpposite(), ecorePackage.getEBoolean(), "isOpposite", "true", 1, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternEdge_OwningRelDomainNode(), this.getRelDomainNode(), this.getRelDomainNode_OwnedRelPatternEdges(), "owningRelDomainNode", null, 0, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternEdge_ReferredProperty(), ecorePackage.getEStructuralFeature(), null, "referredProperty", null, 1, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternEdge_Source(), this.getRelPatternNode(), this.getRelPatternNode_Outgoing(), "source", null, 1, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternEdge_Target(), this.getRelPatternNode(), this.getRelPatternNode_Incoming(), "target", null, 1, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relPatternExpressionNodeEClass, RelPatternExpressionNode.class, "RelPatternExpressionNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelPatternExpressionNode_Expression(), ecorePackage.getEString(), "expression", null, 1, 1, RelPatternExpressionNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relPatternNodeEClass, RelPatternNode.class, "RelPatternNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelPatternNode_Incoming(), this.getRelPatternEdge(), this.getRelPatternEdge_Target(), "incoming", null, 0, -1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelPatternNode_IsRoot(), ecorePackage.getEBoolean(), "isRoot", "false", 1, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternNode_Outgoing(), this.getRelPatternEdge(), this.getRelPatternEdge_Source(), "outgoing", null, 0, -1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternNode_OwningRelDomainNode(), this.getRelDomainNode(), this.getRelDomainNode_OwnedRelPatternNodes(), "owningRelDomainNode", null, 0, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txDiagramEClass, TxDiagram.class, "TxDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxDiagram_OwnedRelDiagrams(), this.getRelDiagram(), this.getRelDiagram_OwningTxDiagram(), "ownedRelDiagrams", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxDiagram_OwnedTxImportNodes(), this.getTxImportNode(), this.getTxImportNode_OwningTxDiagram(), "ownedTxImportNodes", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxDiagram_OwnedTxKeyNodes(), this.getTxKeyNode(), this.getTxKeyNode_OwningTxDiagram(), "ownedTxKeyNodes", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxDiagram_OwnedTxTypedModelNodes(), this.getTxTypedModelNode(), this.getTxTypedModelNode_OwningTxDiagram(), "ownedTxTypedModelNodes", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxDiagram_Package(), ecorePackage.getEString(), "package", null, 0, 1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txImportNodeEClass, TxImportNode.class, "TxImportNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxImportNode_OwningTxDiagram(), this.getTxDiagram(), this.getTxDiagram_OwnedTxImportNodes(), "owningTxDiagram", null, 1, 1, TxImportNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxImportNode_Uri(), ecorePackage.getEString(), "uri", null, 1, 1, TxImportNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txKeyNodeEClass, TxKeyNode.class, "TxKeyNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxKeyNode_OwnedTxPartNodes(), this.getTxPartNode(), this.getTxPartNode_OwningTxKeyNode(), "ownedTxPartNodes", null, 1, -1, TxKeyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxKeyNode_OwningTxDiagram(), this.getTxDiagram(), this.getTxDiagram_OwnedTxKeyNodes(), "owningTxDiagram", null, 1, 1, TxKeyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxKeyNode_ReferredClass(), ecorePackage.getEClass(), null, "referredClass", null, 1, 1, TxKeyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txNodeEClass, TxNode.class, "TxNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(txPackageNodeEClass, TxPackageNode.class, "TxPackageNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxPackageNode_ReferredPackage(), ecorePackage.getEPackage(), null, "referredPackage", null, 1, 1, TxPackageNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxPackageNode_OwningTxTypedModelNode(), this.getTxTypedModelNode(), this.getTxTypedModelNode_OwnedTxPackageNodes(), "owningTxTypedModelNode", null, 1, 1, TxPackageNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txPartNodeEClass, TxPartNode.class, "TxPartNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxPartNode_OwningTxKeyNode(), this.getTxKeyNode(), this.getTxKeyNode_OwnedTxPartNodes(), "owningTxKeyNode", null, 1, 1, TxPartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxPartNode_IsOpposite(), ecorePackage.getEBoolean(), "isOpposite", "false", 1, 1, TxPartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxPartNode_ReferredProperty(), ecorePackage.getEStructuralFeature(), null, "referredProperty", null, 1, 1, TxPartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txTypedModelNodeEClass, TxTypedModelNode.class, "TxTypedModelNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTxTypedModelNode_Check(), ecorePackage.getEBoolean(), "check", "false", 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxTypedModelNode_Enforce(), ecorePackage.getEBoolean(), "enforce", "false", 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTypedModelNode_OwnedTxPackageNodes(), this.getTxPackageNode(), this.getTxPackageNode_OwningTxTypedModelNode(), "ownedTxPackageNodes", null, 0, -1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTypedModelNode_OwningTxDiagram(), this.getTxDiagram(), this.getTxDiagram_OwnedTxTypedModelNodes(), "owningTxDiagram", null, 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxElementEClass, UMLXElement.class, "UMLXElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUMLXElement_Comments(), ecorePackage.getEString(), "comments", null, 0, -1, UMLXElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxModelEClass, UMLXModel.class, "UMLXModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUMLXModel_OwnedTxDiagrams(), this.getTxDiagram(), null, "ownedTxDiagrams", null, 0, -1, UMLXModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxNamedElementEClass, UMLXNamedElement.class, "UMLXNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUMLXNamedElement_Name(), ecorePackage.getEString(), "name", null, 1, 1, UMLXNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //UMLXPackageImpl
