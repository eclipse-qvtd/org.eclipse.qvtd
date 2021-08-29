/**
 * Copyright (c) 2016, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.qvtd.umlx.RelDiagram;
import org.eclipse.qvtd.umlx.RelDomainNode;
import org.eclipse.qvtd.umlx.RelEdge;
import org.eclipse.qvtd.umlx.RelInvocationEdge;
import org.eclipse.qvtd.umlx.RelInvocationNode;
import org.eclipse.qvtd.umlx.RelNode;
import org.eclipse.qvtd.umlx.RelPatternEdge;
import org.eclipse.qvtd.umlx.RelPatternNode;
import org.eclipse.qvtd.umlx.TxDiagram;
import org.eclipse.qvtd.umlx.TxKeyNode;
import org.eclipse.qvtd.umlx.TxNode;
import org.eclipse.qvtd.umlx.TxPackageNode;
import org.eclipse.qvtd.umlx.TxParameterNode;
import org.eclipse.qvtd.umlx.TxPartNode;
import org.eclipse.qvtd.umlx.TxQueryNode;
import org.eclipse.qvtd.umlx.TxTypedModelNode;
import org.eclipse.qvtd.umlx.UMLXElement;
import org.eclipse.qvtd.umlx.UMLXFactory;
import org.eclipse.qvtd.umlx.UMLXModel;
import org.eclipse.qvtd.umlx.UMLXNamedElement;
import org.eclipse.qvtd.umlx.UMLXPackage;
import org.eclipse.qvtd.umlx.UMLXTypedElement;
import org.eclipse.qvtd.umlx.util.UMLXValidator;

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
	private EClass txQueryNodeEClass = null;

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
	private EClass txParameterNodeEClass = null;

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
	private EClass umlxTypedElementEClass = null;

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
		Object registeredUMLXPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		UMLXPackageImpl theUMLXPackage = registeredUMLXPackage instanceof UMLXPackageImpl ? (UMLXPackageImpl)registeredUMLXPackage : new UMLXPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theUMLXPackage.createPackageContents();

		// Initialize created meta-data
		theUMLXPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theUMLXPackage,
			 new EValidator.Descriptor() {
				 @Override
				 public EValidator getEValidator() {
					 return UMLXValidator.INSTANCE;
				 }
			 });

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
	public EAttribute getRelDiagram_IsAbstract() {
		return (EAttribute)relDiagramEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelDiagram_IsTop() {
		return (EAttribute)relDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDiagram_OwnedRelDomainNodes() {
		return (EReference)relDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDiagram_OwnedRelInvocationNodes() {
		return (EReference)relDiagramEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDiagram_OwningTxDiagram() {
		return (EReference)relDiagramEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelDiagram__ValidateNameIsRequired__DiagnosticChain_Map() {
		return relDiagramEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelDiagram__ValidateRelPatternNodeNamesAreUnique__DiagnosticChain_Map() {
		return relDiagramEClass.getEOperations().get(1);
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
	public EAttribute getRelDomainNode_IsEnforced() {
		return (EAttribute)relDomainNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDomainNode_OwnedRelPatternEdges() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDomainNode_OwnedRelPatternNodes() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDomainNode_OwningRelDiagram() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelDomainNode_ReferredTxTypedModelNode() {
		return (EReference)relDomainNodeEClass.getEStructuralFeatures().get(4);
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
		return (EReference)relInvocationEdgeEClass.getEStructuralFeatures().get(2);
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
		return (EReference)relInvocationEdgeEClass.getEStructuralFeatures().get(0);
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
	public EOperation getRelInvocationNode__ValidateCompatibleEdges__DiagnosticChain_Map() {
		return relInvocationNodeEClass.getEOperations().get(0);
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
	public EReference getRelPatternEdge_Source() {
		return (EReference)relPatternEdgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelPatternEdge_SourceIndex() {
		return (EAttribute)relPatternEdgeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternEdge_OwningRelDomainNode() {
		return (EReference)relPatternEdgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternEdge_ReferredEStructuralFeature() {
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
	public EOperation getRelPatternEdge__ValidateSourceIsEClass__DiagnosticChain_Map() {
		return relPatternEdgeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternEdge__ValidateSourceIsClassNode__DiagnosticChain_Map() {
		return relPatternEdgeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternEdge__ValidateCompatibleEAttributePropertyTarget__DiagnosticChain_Map() {
		return relPatternEdgeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternEdge__ValidateCompatibleSourceMultiplicity__DiagnosticChain_Map() {
		return relPatternEdgeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternEdge__ValidateCompatibleEReferencePropertyTarget__DiagnosticChain_Map() {
		return relPatternEdgeEClass.getEOperations().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternEdge__ValidateCompatiblePropertySource__DiagnosticChain_Map() {
		return relPatternEdgeEClass.getEOperations().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternEdge__ValidateCompatibleSourceIndex__DiagnosticChain_Map() {
		return relPatternEdgeEClass.getEOperations().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternEdge__ValidateCompatibleRestPropertyTarget__DiagnosticChain_Map() {
		return relPatternEdgeEClass.getEOperations().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternEdge__ValidateCompatibleMemberPropertyTarget__DiagnosticChain_Map() {
		return relPatternEdgeEClass.getEOperations().get(8);
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
	public EAttribute getRelPatternNode_InitExpressionLines() {
		return (EAttribute)relPatternNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelPatternNode_IsRoot() {
		return (EAttribute)relPatternNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternNode_Outgoing() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternNode_OwningRelDomainNode() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternNode__IsExpression() {
		return relPatternNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternNode__ValidateAnonIsUnnamed__DiagnosticChain_Map() {
		return relPatternNodeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternNode__ValidateTypeIsRequired__DiagnosticChain_Map() {
		return relPatternNodeEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getRelPatternNode__ValidateEClassifierIsInTypedModel__DiagnosticChain_Map() {
		return relPatternNodeEClass.getEOperations().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelPatternNode_InvokingRelInvocationEdges() {
		return (EReference)relPatternNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelPatternNode_IsAnon() {
		return (EAttribute)relPatternNodeEClass.getEStructuralFeatures().get(3);
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
	public EReference getTxDiagram_OwnedTxKeyNodes() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxDiagram_OwnedTxPackageNodes() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxDiagram_OwnedTxQueryNodes() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxDiagram_OwnedTxTypedModelNodes() {
		return (EReference)txDiagramEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxDiagram_Package() {
		return (EAttribute)txDiagramEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxDiagram__ValidateTxQueryNodeNamesAreUnique__DiagnosticChain_Map() {
		return txDiagramEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxDiagram__ValidateRelDiagramNamesAreUnique__DiagnosticChain_Map() {
		return txDiagramEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxDiagram__ValidateNameIsRequired__DiagnosticChain_Map() {
		return txDiagramEClass.getEOperations().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxDiagram__ValidateTxTypedModelNodeNamesAreUnique__DiagnosticChain_Map() {
		return txDiagramEClass.getEOperations().get(3);
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
	public EReference getTxKeyNode_ReferredEClass() {
		return (EReference)txKeyNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxKeyNode__ValidatePartsAreUnique__DiagnosticChain_Map() {
		return txKeyNodeEClass.getEOperations().get(0);
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
	public EReference getTxPartNode_ReferredEStructuralFeature() {
		return (EReference)txPartNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxPartNode__ValidatePartIsPropertyOfKey__DiagnosticChain_Map() {
		return txPartNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxQueryNode() {
		return txQueryNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxQueryNode_InitExpressionLines() {
		return (EAttribute)txQueryNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxQueryNode_OwnedTxParameterNodes() {
		return (EReference)txQueryNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxQueryNode_OwningTxDiagram() {
		return (EReference)txQueryNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxQueryNode__ValidateNameIsRequired__DiagnosticChain_Map() {
		return txQueryNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxQueryNode__ValidateTypeIsRequired__DiagnosticChain_Map() {
		return txQueryNodeEClass.getEOperations().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxQueryNode__ValidateParametersAreUnique__DiagnosticChain_Map() {
		return txQueryNodeEClass.getEOperations().get(2);
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
	public EAttribute getTxPackageNode_ImportAliases() {
		return (EAttribute)txPackageNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxPackageNode_OwningTxDiagram() {
		return (EReference)txPackageNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxPackageNode_ReferredEPackage() {
		return (EReference)txPackageNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTxParameterNode() {
		return txParameterNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxParameterNode_OwningTxQueryNode() {
		return (EReference)txParameterNodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxParameterNode__ValidateNameIsRequired__DiagnosticChain_Map() {
		return txParameterNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxParameterNode__ValidateTypeIsRequired__DiagnosticChain_Map() {
		return txParameterNodeEClass.getEOperations().get(1);
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
	public EReference getTxTypedModelNode_DependsOns() {
		return (EReference)txTypedModelNodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTxTypedModelNode_Enforce() {
		return (EAttribute)txTypedModelNodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxTypedModelNode_Iterates() {
		return (EReference)txTypedModelNodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxTypedModelNode_OwningTxDiagram() {
		return (EReference)txTypedModelNodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTxTypedModelNode_UsedTxPackageNodes() {
		return (EReference)txTypedModelNodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxTypedModelNode__ValidateTxPackageNodePackagesAreUnique__DiagnosticChain_Map() {
		return txTypedModelNodeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTxTypedModelNode__ValidateNameIsRequired__DiagnosticChain_Map() {
		return txTypedModelNodeEClass.getEOperations().get(1);
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
	public EClass getUMLXTypedElement() {
		return umlxTypedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUMLXTypedElement_IsMany() {
		return (EAttribute)umlxTypedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUMLXTypedElement_IsNullFree() {
		return (EAttribute)umlxTypedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUMLXTypedElement_IsOrdered() {
		return (EAttribute)umlxTypedElementEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUMLXTypedElement_IsRequired() {
		return (EAttribute)umlxTypedElementEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUMLXTypedElement_IsUnique() {
		return (EAttribute)umlxTypedElementEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getUMLXTypedElement_ReferredEClassifier() {
		return (EReference)umlxTypedElementEClass.getEStructuralFeatures().get(5);
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
		relDiagramEClass = createEClass(0);
		createEAttribute(relDiagramEClass, 2);
		createEAttribute(relDiagramEClass, 3);
		createEReference(relDiagramEClass, 4);
		createEReference(relDiagramEClass, 5);
		createEReference(relDiagramEClass, 6);
		createEOperation(relDiagramEClass, 0);
		createEOperation(relDiagramEClass, 1);

		relDomainNodeEClass = createEClass(1);
		createEAttribute(relDomainNodeEClass, 1);
		createEReference(relDomainNodeEClass, 2);
		createEReference(relDomainNodeEClass, 3);
		createEReference(relDomainNodeEClass, 4);
		createEReference(relDomainNodeEClass, 5);

		relEdgeEClass = createEClass(2);

		relInvocationEdgeEClass = createEClass(3);
		createEReference(relInvocationEdgeEClass, 1);
		createEReference(relInvocationEdgeEClass, 2);
		createEReference(relInvocationEdgeEClass, 3);

		relInvocationNodeEClass = createEClass(4);
		createEAttribute(relInvocationNodeEClass, 1);
		createEReference(relInvocationNodeEClass, 2);
		createEReference(relInvocationNodeEClass, 3);
		createEReference(relInvocationNodeEClass, 4);
		createEOperation(relInvocationNodeEClass, 0);

		relNodeEClass = createEClass(5);

		relPatternEdgeEClass = createEClass(6);
		createEReference(relPatternEdgeEClass, 1);
		createEReference(relPatternEdgeEClass, 2);
		createEReference(relPatternEdgeEClass, 3);
		createEAttribute(relPatternEdgeEClass, 4);
		createEReference(relPatternEdgeEClass, 5);
		createEOperation(relPatternEdgeEClass, 0);
		createEOperation(relPatternEdgeEClass, 1);
		createEOperation(relPatternEdgeEClass, 2);
		createEOperation(relPatternEdgeEClass, 3);
		createEOperation(relPatternEdgeEClass, 4);
		createEOperation(relPatternEdgeEClass, 5);
		createEOperation(relPatternEdgeEClass, 6);
		createEOperation(relPatternEdgeEClass, 7);
		createEOperation(relPatternEdgeEClass, 8);

		relPatternNodeEClass = createEClass(7);
		createEReference(relPatternNodeEClass, 8);
		createEAttribute(relPatternNodeEClass, 9);
		createEReference(relPatternNodeEClass, 10);
		createEAttribute(relPatternNodeEClass, 11);
		createEAttribute(relPatternNodeEClass, 12);
		createEReference(relPatternNodeEClass, 13);
		createEReference(relPatternNodeEClass, 14);
		createEOperation(relPatternNodeEClass, 0);
		createEOperation(relPatternNodeEClass, 1);
		createEOperation(relPatternNodeEClass, 2);
		createEOperation(relPatternNodeEClass, 3);

		txDiagramEClass = createEClass(8);
		createEReference(txDiagramEClass, 2);
		createEReference(txDiagramEClass, 3);
		createEReference(txDiagramEClass, 4);
		createEReference(txDiagramEClass, 5);
		createEReference(txDiagramEClass, 6);
		createEAttribute(txDiagramEClass, 7);
		createEOperation(txDiagramEClass, 0);
		createEOperation(txDiagramEClass, 1);
		createEOperation(txDiagramEClass, 2);
		createEOperation(txDiagramEClass, 3);

		txKeyNodeEClass = createEClass(9);
		createEReference(txKeyNodeEClass, 1);
		createEReference(txKeyNodeEClass, 2);
		createEReference(txKeyNodeEClass, 3);
		createEOperation(txKeyNodeEClass, 0);

		txNodeEClass = createEClass(10);

		txPackageNodeEClass = createEClass(11);
		createEAttribute(txPackageNodeEClass, 1);
		createEReference(txPackageNodeEClass, 2);
		createEReference(txPackageNodeEClass, 3);

		txParameterNodeEClass = createEClass(12);
		createEReference(txParameterNodeEClass, 8);
		createEOperation(txParameterNodeEClass, 0);
		createEOperation(txParameterNodeEClass, 1);

		txPartNodeEClass = createEClass(13);
		createEReference(txPartNodeEClass, 1);
		createEAttribute(txPartNodeEClass, 2);
		createEReference(txPartNodeEClass, 3);
		createEOperation(txPartNodeEClass, 0);

		txQueryNodeEClass = createEClass(14);
		createEAttribute(txQueryNodeEClass, 8);
		createEReference(txQueryNodeEClass, 9);
		createEReference(txQueryNodeEClass, 10);
		createEOperation(txQueryNodeEClass, 0);
		createEOperation(txQueryNodeEClass, 1);
		createEOperation(txQueryNodeEClass, 2);

		txTypedModelNodeEClass = createEClass(15);
		createEAttribute(txTypedModelNodeEClass, 2);
		createEReference(txTypedModelNodeEClass, 3);
		createEAttribute(txTypedModelNodeEClass, 4);
		createEReference(txTypedModelNodeEClass, 5);
		createEReference(txTypedModelNodeEClass, 6);
		createEReference(txTypedModelNodeEClass, 7);
		createEOperation(txTypedModelNodeEClass, 0);
		createEOperation(txTypedModelNodeEClass, 1);

		umlxElementEClass = createEClass(16);
		createEAttribute(umlxElementEClass, 0);

		umlxModelEClass = createEClass(17);
		createEReference(umlxModelEClass, 1);

		umlxNamedElementEClass = createEClass(18);
		createEAttribute(umlxNamedElementEClass, 1);

		umlxTypedElementEClass = createEClass(19);
		createEAttribute(umlxTypedElementEClass, 2);
		createEAttribute(umlxTypedElementEClass, 3);
		createEAttribute(umlxTypedElementEClass, 4);
		createEAttribute(umlxTypedElementEClass, 5);
		createEAttribute(umlxTypedElementEClass, 6);
		createEReference(umlxTypedElementEClass, 7);
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
		relPatternEdgeEClass.getESuperTypes().add(this.getRelEdge());
		relPatternNodeEClass.getESuperTypes().add(this.getRelNode());
		relPatternNodeEClass.getESuperTypes().add(this.getUMLXTypedElement());
		txDiagramEClass.getESuperTypes().add(this.getUMLXNamedElement());
		txKeyNodeEClass.getESuperTypes().add(this.getTxNode());
		txNodeEClass.getESuperTypes().add(this.getUMLXElement());
		txPackageNodeEClass.getESuperTypes().add(this.getTxNode());
		txParameterNodeEClass.getESuperTypes().add(this.getTxNode());
		txParameterNodeEClass.getESuperTypes().add(this.getUMLXTypedElement());
		txPartNodeEClass.getESuperTypes().add(this.getTxNode());
		txQueryNodeEClass.getESuperTypes().add(this.getTxNode());
		txQueryNodeEClass.getESuperTypes().add(this.getUMLXTypedElement());
		txTypedModelNodeEClass.getESuperTypes().add(this.getTxNode());
		txTypedModelNodeEClass.getESuperTypes().add(this.getUMLXNamedElement());
		umlxModelEClass.getESuperTypes().add(this.getUMLXElement());
		umlxNamedElementEClass.getESuperTypes().add(this.getUMLXElement());
		umlxTypedElementEClass.getESuperTypes().add(this.getUMLXNamedElement());

		// Initialize classes, features, and operations; add parameters
		initEClass(relDiagramEClass, RelDiagram.class, "RelDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelDiagram_IsAbstract(), ecorePackage.getEBoolean(), "isAbstract", "false", 1, 1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelDiagram_IsTop(), ecorePackage.getEBoolean(), "isTop", "false", 1, 1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDiagram_OwnedRelDomainNodes(), this.getRelDomainNode(), this.getRelDomainNode_OwningRelDiagram(), "ownedRelDomainNodes", null, 0, -1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDiagram_OwnedRelInvocationNodes(), this.getRelInvocationNode(), this.getRelInvocationNode_OwningRelDiagram(), "ownedRelInvocationNodes", null, 0, -1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDiagram_OwningTxDiagram(), this.getTxDiagram(), this.getTxDiagram_OwnedRelDiagrams(), "owningTxDiagram", null, 1, 1, RelDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getRelDiagram__ValidateNameIsRequired__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNameIsRequired", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelDiagram__ValidateRelPatternNodeNamesAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateRelPatternNodeNamesAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relDomainNodeEClass, RelDomainNode.class, "RelDomainNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelDomainNode_IsEnforced(), ecorePackage.getEBoolean(), "isEnforced", "false", 1, 1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDomainNode_OwnedRelPatternEdges(), this.getRelPatternEdge(), this.getRelPatternEdge_OwningRelDomainNode(), "ownedRelPatternEdges", null, 0, -1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDomainNode_OwnedRelPatternNodes(), this.getRelPatternNode(), this.getRelPatternNode_OwningRelDomainNode(), "ownedRelPatternNodes", null, 0, -1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDomainNode_OwningRelDiagram(), this.getRelDiagram(), this.getRelDiagram_OwnedRelDomainNodes(), "owningRelDiagram", null, 1, 1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelDomainNode_ReferredTxTypedModelNode(), this.getTxTypedModelNode(), null, "referredTxTypedModelNode", null, 0, 1, RelDomainNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relEdgeEClass, RelEdge.class, "RelEdge", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relInvocationEdgeEClass, RelInvocationEdge.class, "RelInvocationEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelInvocationEdge_InvokingRelPatternNode(), this.getRelPatternNode(), this.getRelPatternNode_InvokingRelInvocationEdges(), "invokingRelPatternNode", null, 1, 1, RelInvocationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationEdge_OwningRelInvocationNode(), this.getRelInvocationNode(), this.getRelInvocationNode_OwnedRelInvocationEdges(), "owningRelInvocationNode", null, 1, 1, RelInvocationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationEdge_ReferredRelPatternNode(), this.getRelPatternNode(), null, "referredRelPatternNode", null, 1, 1, RelInvocationEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relInvocationNodeEClass, RelInvocationNode.class, "RelInvocationNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRelInvocationNode_IsThen(), ecorePackage.getEBoolean(), "isThen", "true", 1, 1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationNode_OwningRelDiagram(), this.getRelDiagram(), this.getRelDiagram_OwnedRelInvocationNodes(), "owningRelDiagram", null, 1, 1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationNode_OwnedRelInvocationEdges(), this.getRelInvocationEdge(), this.getRelInvocationEdge_OwningRelInvocationNode(), "ownedRelInvocationEdges", null, 0, -1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelInvocationNode_ReferredRelDiagram(), this.getRelDiagram(), null, "referredRelDiagram", null, 1, 1, RelInvocationNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelInvocationNode__ValidateCompatibleEdges__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleEdges", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relNodeEClass, RelNode.class, "RelNode", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(relPatternEdgeEClass, RelPatternEdge.class, "RelPatternEdge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelPatternEdge_OwningRelDomainNode(), this.getRelDomainNode(), this.getRelDomainNode_OwnedRelPatternEdges(), "owningRelDomainNode", null, 0, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternEdge_ReferredEStructuralFeature(), ecorePackage.getEStructuralFeature(), null, "referredEStructuralFeature", null, 0, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternEdge_Source(), this.getRelPatternNode(), this.getRelPatternNode_Outgoing(), "source", null, 1, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelPatternEdge_SourceIndex(), ecorePackage.getEInt(), "sourceIndex", null, 1, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternEdge_Target(), this.getRelPatternNode(), this.getRelPatternNode_Incoming(), "target", null, 1, 1, RelPatternEdge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getRelPatternEdge__ValidateSourceIsEClass__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceIsEClass", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternEdge__ValidateSourceIsClassNode__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateSourceIsClassNode", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternEdge__ValidateCompatibleEAttributePropertyTarget__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleEAttributePropertyTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternEdge__ValidateCompatibleSourceMultiplicity__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleSourceMultiplicity", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternEdge__ValidateCompatibleEReferencePropertyTarget__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleEReferencePropertyTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternEdge__ValidateCompatiblePropertySource__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatiblePropertySource", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternEdge__ValidateCompatibleSourceIndex__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleSourceIndex", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternEdge__ValidateCompatibleRestPropertyTarget__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleRestPropertyTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternEdge__ValidateCompatibleMemberPropertyTarget__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateCompatibleMemberPropertyTarget", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(relPatternNodeEClass, RelPatternNode.class, "RelPatternNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelPatternNode_Incoming(), this.getRelPatternEdge(), this.getRelPatternEdge_Target(), "incoming", null, 0, -1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelPatternNode_InitExpressionLines(), ecorePackage.getEString(), "initExpressionLines", null, 0, -1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternNode_InvokingRelInvocationEdges(), this.getRelInvocationEdge(), this.getRelInvocationEdge_InvokingRelPatternNode(), "invokingRelInvocationEdges", null, 0, -1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelPatternNode_IsAnon(), ecorePackage.getEBoolean(), "isAnon", "false", 1, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelPatternNode_IsRoot(), ecorePackage.getEBoolean(), "isRoot", "false", 1, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternNode_Outgoing(), this.getRelPatternEdge(), this.getRelPatternEdge_Source(), "outgoing", null, 0, -1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelPatternNode_OwningRelDomainNode(), this.getRelDomainNode(), this.getRelDomainNode_OwnedRelPatternNodes(), "owningRelDomainNode", null, 1, 1, RelPatternNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getRelPatternNode__IsExpression(), ecorePackage.getEBooleanObject(), "isExpression", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternNode__ValidateAnonIsUnnamed__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateAnonIsUnnamed", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternNode__ValidateTypeIsRequired__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTypeIsRequired", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getRelPatternNode__ValidateEClassifierIsInTypedModel__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateEClassifierIsInTypedModel", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(txDiagramEClass, TxDiagram.class, "TxDiagram", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxDiagram_OwnedRelDiagrams(), this.getRelDiagram(), this.getRelDiagram_OwningTxDiagram(), "ownedRelDiagrams", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxDiagram_OwnedTxKeyNodes(), this.getTxKeyNode(), this.getTxKeyNode_OwningTxDiagram(), "ownedTxKeyNodes", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxDiagram_OwnedTxPackageNodes(), this.getTxPackageNode(), this.getTxPackageNode_OwningTxDiagram(), "ownedTxPackageNodes", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxDiagram_OwnedTxQueryNodes(), this.getTxQueryNode(), this.getTxQueryNode_OwningTxDiagram(), "ownedTxQueryNodes", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxDiagram_OwnedTxTypedModelNodes(), this.getTxTypedModelNode(), this.getTxTypedModelNode_OwningTxDiagram(), "ownedTxTypedModelNodes", null, 0, -1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxDiagram_Package(), ecorePackage.getEString(), "package", null, 0, 1, TxDiagram.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTxDiagram__ValidateTxQueryNodeNamesAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTxQueryNodeNamesAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTxDiagram__ValidateRelDiagramNamesAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateRelDiagramNamesAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTxDiagram__ValidateNameIsRequired__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNameIsRequired", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTxDiagram__ValidateTxTypedModelNodeNamesAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTxTypedModelNodeNamesAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(txKeyNodeEClass, TxKeyNode.class, "TxKeyNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxKeyNode_OwnedTxPartNodes(), this.getTxPartNode(), this.getTxPartNode_OwningTxKeyNode(), "ownedTxPartNodes", null, 1, -1, TxKeyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxKeyNode_OwningTxDiagram(), this.getTxDiagram(), this.getTxDiagram_OwnedTxKeyNodes(), "owningTxDiagram", null, 1, 1, TxKeyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxKeyNode_ReferredEClass(), ecorePackage.getEClass(), null, "referredEClass", null, 1, 1, TxKeyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTxKeyNode__ValidatePartsAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validatePartsAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(txNodeEClass, TxNode.class, "TxNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(txPackageNodeEClass, TxPackageNode.class, "TxPackageNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTxPackageNode_ImportAliases(), ecorePackage.getEString(), "importAliases", null, 0, -1, TxPackageNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxPackageNode_OwningTxDiagram(), this.getTxDiagram(), this.getTxDiagram_OwnedTxPackageNodes(), "owningTxDiagram", null, 1, 1, TxPackageNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxPackageNode_ReferredEPackage(), ecorePackage.getEPackage(), null, "referredEPackage", null, 1, 1, TxPackageNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(txParameterNodeEClass, TxParameterNode.class, "TxParameterNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxParameterNode_OwningTxQueryNode(), this.getTxQueryNode(), this.getTxQueryNode_OwnedTxParameterNodes(), "owningTxQueryNode", null, 1, 1, TxParameterNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTxParameterNode__ValidateNameIsRequired__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNameIsRequired", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTxParameterNode__ValidateTypeIsRequired__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTypeIsRequired", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(txPartNodeEClass, TxPartNode.class, "TxPartNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTxPartNode_OwningTxKeyNode(), this.getTxKeyNode(), this.getTxKeyNode_OwnedTxPartNodes(), "owningTxKeyNode", null, 1, 1, TxPartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxPartNode_IsOpposite(), ecorePackage.getEBoolean(), "isOpposite", "false", 1, 1, TxPartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxPartNode_ReferredEStructuralFeature(), ecorePackage.getEStructuralFeature(), null, "referredEStructuralFeature", null, 1, 1, TxPartNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTxPartNode__ValidatePartIsPropertyOfKey__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validatePartIsPropertyOfKey", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(txQueryNodeEClass, TxQueryNode.class, "TxQueryNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTxQueryNode_InitExpressionLines(), ecorePackage.getEString(), "initExpressionLines", null, 0, -1, TxQueryNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxQueryNode_OwnedTxParameterNodes(), this.getTxParameterNode(), this.getTxParameterNode_OwningTxQueryNode(), "ownedTxParameterNodes", null, 1, -1, TxQueryNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxQueryNode_OwningTxDiagram(), this.getTxDiagram(), this.getTxDiagram_OwnedTxQueryNodes(), "owningTxDiagram", null, 1, 1, TxQueryNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTxQueryNode__ValidateNameIsRequired__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNameIsRequired", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTxQueryNode__ValidateTypeIsRequired__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTypeIsRequired", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTxQueryNode__ValidateParametersAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateParametersAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(txTypedModelNodeEClass, TxTypedModelNode.class, "TxTypedModelNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTxTypedModelNode_Check(), ecorePackage.getEBoolean(), "check", "false", 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTypedModelNode_DependsOns(), this.getTxTypedModelNode(), null, "dependsOns", null, 0, -1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTxTypedModelNode_Enforce(), ecorePackage.getEBoolean(), "enforce", "false", 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTypedModelNode_Iterates(), this.getTxTypedModelNode(), null, "iterates", null, 0, -1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTypedModelNode_OwningTxDiagram(), this.getTxDiagram(), this.getTxDiagram_OwnedTxTypedModelNodes(), "owningTxDiagram", null, 1, 1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTxTypedModelNode_UsedTxPackageNodes(), this.getTxPackageNode(), null, "usedTxPackageNodes", null, 0, -1, TxTypedModelNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getTxTypedModelNode__ValidateTxPackageNodePackagesAreUnique__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateTxPackageNodePackagesAreUnique", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = initEOperation(getTxTypedModelNode__ValidateNameIsRequired__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "validateNameIsRequired", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(umlxElementEClass, UMLXElement.class, "UMLXElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUMLXElement_Comments(), ecorePackage.getEString(), "comments", null, 0, -1, UMLXElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxModelEClass, UMLXModel.class, "UMLXModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUMLXModel_OwnedTxDiagrams(), this.getTxDiagram(), null, "ownedTxDiagrams", null, 0, -1, UMLXModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxNamedElementEClass, UMLXNamedElement.class, "UMLXNamedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUMLXNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, UMLXNamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(umlxTypedElementEClass, UMLXTypedElement.class, "UMLXTypedElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUMLXTypedElement_IsMany(), ecorePackage.getEBoolean(), "isMany", "false", 1, 1, UMLXTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUMLXTypedElement_IsNullFree(), ecorePackage.getEBoolean(), "isNullFree", "true", 1, 1, UMLXTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUMLXTypedElement_IsOrdered(), ecorePackage.getEBoolean(), "isOrdered", "false", 1, 1, UMLXTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUMLXTypedElement_IsRequired(), ecorePackage.getEBoolean(), "isRequired", "true", 1, 1, UMLXTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUMLXTypedElement_IsUnique(), ecorePackage.getEBoolean(), "isUnique", "true", 1, 1, UMLXTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUMLXTypedElement_ReferredEClassifier(), ecorePackage.getEClassifier(), null, "referredEClassifier", null, 0, 1, UMLXTypedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/uml2/2.0.0/UML
		createUMLAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (relDiagramEClass,
		   source,
		   new String[] {
			   "constraints", "validateRelPatternNodeNamesAreUnique"
		   });
		addAnnotation
		  (relInvocationNodeEClass,
		   source,
		   new String[] {
			   "constraints", "validateCompatibleEdges"
		   });
		addAnnotation
		  (relPatternEdgeEClass,
		   source,
		   new String[] {
			   "constraints", "validateCompatibleMemberPropertyTarget"
		   });
		addAnnotation
		  (relPatternNodeEClass,
		   source,
		   new String[] {
			   "constraints", "validateEClassifierIsInTypedModel"
		   });
		addAnnotation
		  (txDiagramEClass,
		   source,
		   new String[] {
			   "constraints", "validateTxTypedModelNodeNamesAreUnique"
		   });
		addAnnotation
		  (txKeyNodeEClass,
		   source,
		   new String[] {
			   "constraints", "validatePartsAreUnique"
		   });
		addAnnotation
		  (txParameterNodeEClass,
		   source,
		   new String[] {
			   "constraints", "validateTypeIsRequired"
		   });
		addAnnotation
		  (txPartNodeEClass,
		   source,
		   new String[] {
			   "constraints", "validatePartIsPropertyOfKey"
		   });
		addAnnotation
		  (txQueryNodeEClass,
		   source,
		   new String[] {
			   "constraints", "validateParametersAreUnique"
		   });
		addAnnotation
		  (txTypedModelNodeEClass,
		   source,
		   new String[] {
			   "constraints", "validateNameIsRequired"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/uml2/2.0.0/UML</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createUMLAnnotations() {
		String source = "http://www.eclipse.org/uml2/2.0.0/UML";
		addAnnotation
		  (getRelDiagram__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "NameIsRequired"
		   });
		addAnnotation
		  (getRelDiagram__ValidateRelPatternNodeNamesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "RelPatternNodeNamesAreUnique"
		   });
		addAnnotation
		  (getRelInvocationNode__ValidateCompatibleEdges__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleEdges"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateSourceIsEClass__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "SourceIsEClass"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateSourceIsClassNode__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "SourceIsClassNode"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleEAttributePropertyTarget__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleEAttributePropertyTarget"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleSourceMultiplicity__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleSourceMultiplicity"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleEReferencePropertyTarget__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleEReferencePropertyTarget"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatiblePropertySource__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatiblePropertySource"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleSourceIndex__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleSourceIndex"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleRestPropertyTarget__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleRestPropertyTarget"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleMemberPropertyTarget__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "CompatibleMemberPropertyTarget"
		   });
		addAnnotation
		  (getRelPatternNode__ValidateAnonIsUnnamed__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "AnonIsUnnamed"
		   });
		addAnnotation
		  (getRelPatternNode__ValidateTypeIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TypeIsRequired"
		   });
		addAnnotation
		  (getRelPatternNode__ValidateEClassifierIsInTypedModel__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "EClassifierIsInTypedModel"
		   });
		addAnnotation
		  (getTxDiagram__ValidateTxQueryNodeNamesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TxQueryNodeNamesAreUnique"
		   });
		addAnnotation
		  (getTxDiagram__ValidateRelDiagramNamesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "RelDiagramNamesAreUnique"
		   });
		addAnnotation
		  (getTxDiagram__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "NameIsRequired"
		   });
		addAnnotation
		  (getTxDiagram__ValidateTxTypedModelNodeNamesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TxTypedModelNodeNamesAreUnique"
		   });
		addAnnotation
		  (getTxKeyNode__ValidatePartsAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "PartsAreUnique"
		   });
		addAnnotation
		  (getTxParameterNode__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "NameIsRequired"
		   });
		addAnnotation
		  (getTxParameterNode__ValidateTypeIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TypeIsRequired"
		   });
		addAnnotation
		  (getTxPartNode__ValidatePartIsPropertyOfKey__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "PartIsPropertyOfKey"
		   });
		addAnnotation
		  (getTxQueryNode__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "NameIsRequired"
		   });
		addAnnotation
		  (getTxQueryNode__ValidateTypeIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TypeIsRequired"
		   });
		addAnnotation
		  (getTxQueryNode__ValidateParametersAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "ParametersAreUnique"
		   });
		addAnnotation
		  (getTxTypedModelNode__ValidateTxPackageNodePackagesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "TxPackageNodePackagesAreUnique"
		   });
		addAnnotation
		  (getTxTypedModelNode__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "originalName", "NameIsRequired"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (getRelDiagram__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "name <> null"
		   });
		addAnnotation
		  (getRelDiagram__ValidateRelPatternNodeNamesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "let allNames = ownedRelDomainNodes.ownedRelPatternNodes->select(not isExpression())->select(not isAnon).name in\n\t\tTuple{status : Boolean = allNames->isUnique(n | n),\n\t\t\tmessage : String = let repeatedNames = allNames->select(n | allNames->count(n) > 1)->asSet() in\n\t\t\trepeatedNames->iterate(n; acc:String = \'RelDiagram::RelPatternNodeNamesAreUnique:\' | acc + \' \\\'\' + n + \'\\\'\') + \' are not unique for \' + name\n\t\t}.status"
		   });
		addAnnotation
		  (getRelInvocationNode__ValidateCompatibleEdges__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\tlet expectedNodes = referredRelDiagram.ownedRelDomainNodes.ownedRelPatternNodes->select(isRoot)->asSet() in\n\t\t\tlet actualNodes = ownedRelInvocationEdges.referredRelPatternNode->asSet() in\t\t\n\t\t\tTuple{status : Boolean = expectedNodes = actualNodes,\n\t\t\t\tmessage : String = \'RelInvocationNode::CompatibleEdges \' + expectedNodes->size().toString() + \'/\' + expectedNodes->size().toString()\n\t\t\t}.status"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateSourceIsEClass__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\tnot source.isExpression() implies\n\t\t\tsource.referredEClassifier.oclIsKindOf(ecore::EClassifier)"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateSourceIsClassNode__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\tnot source.isExpression()"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleEAttributePropertyTarget__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\treferredEStructuralFeature <> null and\n\t\t\treferredEStructuralFeature.oclIsKindOf(ecore::EAttribute) and\n\t\t\tnot target.isExpression() implies\n\t\t\tlet t1 = referredEStructuralFeature.eType.oclType() in\n\t\t\tlet t2 = target.referredEClassifier.oclType() in\n\t\t\tt1.conformsTo(t2)"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleSourceMultiplicity__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\t(referredEStructuralFeature = null) = source.isMany"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleEReferencePropertyTarget__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\treferredEStructuralFeature <> null and\n\t\t\treferredEStructuralFeature.oclIsKindOf(ecore::EReference) and\n\t\t\tnot target.isExpression() implies\n\t\t\tlet sourceEClass = target.referredEClassifier.oclAsType(ecore::EClass) in\n\t\t\tsourceEClass->closure(eSuperTypes)->includes(referredEStructuralFeature.eType)"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatiblePropertySource__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\treferredEStructuralFeature <> null implies\n\t\t\tsource.referredEClassifier.oclAsType(ecore::EClass)->closure(eSuperTypes)->includes(referredEStructuralFeature.eContainingClass)"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleSourceIndex__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\t(referredEStructuralFeature <> null) = (sourceIndex = 0)"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleRestPropertyTarget__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\treferredEStructuralFeature = null and\n\t\t\tsourceIndex < 0 and\n\t\t\tnot target.isExpression() implies\n\t\t\tlet sourceEClass = source.referredEClassifier.oclAsType(ecore::EClass) in\n\t\t\tlet targetEClass = target.referredEClassifier.oclAsType(ecore::EClass) in\n\t\t\tsourceEClass = targetEClass and\n\t\t\tsource.isMany = target.isMany and\n\t\t\tsource.isNullFree = target.isNullFree and\n\t\t\tsource.isOrdered = target.isOrdered and\n\t\t\tsource.isUnique = target.isUnique"
		   });
		addAnnotation
		  (getRelPatternEdge__ValidateCompatibleMemberPropertyTarget__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\treferredEStructuralFeature = null and\n\t\t\tsourceIndex > 0 and\n\t\t\tnot target.isExpression() implies\n\t\t\tlet sourceEClass = source.referredEClassifier.oclAsType(ecore::EClass) in\n\t\t\tlet targetEClass = target.referredEClassifier.oclAsType(ecore::EClass) in\n\t\t\tsourceEClass->closure(eSuperTypes)->includes(targetEClass) or targetEClass->closure(eSuperTypes)->includes(sourceEClass)"
		   });
		addAnnotation
		  (getRelPatternNode__IsExpression(),
		   source,
		   new String[] {
			   "body", "name = null and initExpressionLines->notEmpty()"
		   });
		addAnnotation
		  (getRelPatternNode__ValidateAnonIsUnnamed__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\tnot isExpression() implies\n\t\tisAnon = (name = \'\')"
		   });
		addAnnotation
		  (getRelPatternNode__ValidateTypeIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\tnot isExpression() implies\n\t\treferredEClassifier <> null"
		   });
		addAnnotation
		  (getRelPatternNode__ValidateEClassifierIsInTypedModel__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\tnot isExpression() implies\n\t\tlet txTypedModelNode = owningRelDomainNode.referredTxTypedModelNode in\n\t\ttxTypedModelNode <> null implies\n\t\ttxTypedModelNode.usedTxPackageNodes.referredEPackage.eClassifiers->includes(referredEClassifier)"
		   });
		addAnnotation
		  (getTxDiagram__ValidateTxQueryNodeNamesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "ownedTxQueryNodes->isUnique(name)"
		   });
		addAnnotation
		  (getTxDiagram__ValidateRelDiagramNamesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "ownedRelDiagrams->isUnique(name)"
		   });
		addAnnotation
		  (getTxDiagram__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "name <> null"
		   });
		addAnnotation
		  (getTxDiagram__ValidateTxTypedModelNodeNamesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "ownedTxTypedModelNodes->isUnique(name)"
		   });
		addAnnotation
		  (getTxKeyNode__ValidatePartsAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "ownedTxPartNodes->isUnique(referredEStructuralFeature)"
		   });
		addAnnotation
		  (getTxParameterNode__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "name <> null"
		   });
		addAnnotation
		  (getTxParameterNode__ValidateTypeIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "referredEClassifier <> null"
		   });
		addAnnotation
		  (getTxPartNode__ValidatePartIsPropertyOfKey__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "owningTxKeyNode.referredEClass.oclAsType(ecore::EClass)->closure(eSuperTypes)->includes(referredEStructuralFeature.eContainingClass)"
		   });
		addAnnotation
		  (getTxQueryNode__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "name <> null"
		   });
		addAnnotation
		  (getTxQueryNode__ValidateTypeIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "referredEClassifier <> null"
		   });
		addAnnotation
		  (getTxQueryNode__ValidateParametersAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "ownedTxParameterNodes->isUnique(name)"
		   });
		addAnnotation
		  (getTxTypedModelNode__ValidateTxPackageNodePackagesAreUnique__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "usedTxPackageNodes->isUnique(referredEPackage)"
		   });
		addAnnotation
		  (getTxTypedModelNode__ValidateNameIsRequired__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "name <> null"
		   });
	}

} //UMLXPackageImpl
