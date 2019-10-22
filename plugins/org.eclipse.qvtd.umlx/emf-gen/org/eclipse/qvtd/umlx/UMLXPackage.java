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
package org.eclipse.qvtd.umlx;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
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
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.qvtd.umlx";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UMLXPackage eINSTANCE = org.eclipse.qvtd.umlx.impl.UMLXPackageImpl.init();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelDiagram#isIsAbstract <em>Is Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Abstract</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDiagram#isIsAbstract()
	 * @see #getRelDiagram()
	 * @generated
	 */
	EAttribute getRelDiagram_IsAbstract();

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
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelDiagram#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Required</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelDiagram#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelDiagram__ValidateNameIsRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelDiagram#validateRelPatternNodeNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Rel Pattern Node Names Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Rel Pattern Node Names Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelDiagram#validateRelPatternNodeNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelDiagram__ValidateRelPatternNodeNamesAreUnique__DiagnosticChain_Map();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelDomainNode#isIsEnforced <em>Is Enforced</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enforced</em>'.
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#isIsEnforced()
	 * @see #getRelDomainNode()
	 * @generated
	 */
	EAttribute getRelDomainNode_IsEnforced();

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
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelInvocationNode#validateCompatibleEdges(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Edges</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Edges</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode#validateCompatibleEdges(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelInvocationNode__ValidateCompatibleEdges__DiagnosticChain_Map();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getSourceIndex <em>Source Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Index</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getSourceIndex()
	 * @see #getRelPatternEdge()
	 * @generated
	 */
	EAttribute getRelPatternEdge_SourceIndex();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getReferredEStructuralFeature <em>Referred EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred EStructural Feature</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getReferredEStructuralFeature()
	 * @see #getRelPatternEdge()
	 * @generated
	 */
	EReference getRelPatternEdge_ReferredEStructuralFeature();

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
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#validateSourceIsEClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Is EClass</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Is EClass</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#validateSourceIsEClass(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternEdge__ValidateSourceIsEClass__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#validateSourceIsClassNode(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Source Is Class Node</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Source Is Class Node</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#validateSourceIsClassNode(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternEdge__ValidateSourceIsClassNode__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleEAttributePropertyTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible EAttribute Property Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible EAttribute Property Target</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleEAttributePropertyTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternEdge__ValidateCompatibleEAttributePropertyTarget__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleSourceMultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Source Multiplicity</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Source Multiplicity</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleSourceMultiplicity(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternEdge__ValidateCompatibleSourceMultiplicity__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleEReferencePropertyTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible EReference Property Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible EReference Property Target</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleEReferencePropertyTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternEdge__ValidateCompatibleEReferencePropertyTarget__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatiblePropertySource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Property Source</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Property Source</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatiblePropertySource(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternEdge__ValidateCompatiblePropertySource__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleSourceIndex(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Source Index</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Source Index</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleSourceIndex(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternEdge__ValidateCompatibleSourceIndex__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleRestPropertyTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Rest Property Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Rest Property Target</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleRestPropertyTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternEdge__ValidateCompatibleRestPropertyTarget__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleMemberPropertyTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Compatible Member Property Target</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Compatible Member Property Target</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#validateCompatibleMemberPropertyTarget(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternEdge__ValidateCompatibleMemberPropertyTarget__DiagnosticChain_Map();

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
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvtd.umlx.RelPatternNode#getInitExpressionLines <em>Init Expression Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Init Expression Lines</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getInitExpressionLines()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EAttribute getRelPatternNode_InitExpressionLines();

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
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternNode#isExpression() <em>Is Expression</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Is Expression</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#isExpression()
	 * @generated
	 */
	EOperation getRelPatternNode__IsExpression();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternNode#validateAnonIsUnnamed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Anon Is Unnamed</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Anon Is Unnamed</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#validateAnonIsUnnamed(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternNode__ValidateAnonIsUnnamed__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternNode#validateTypeIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Required</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#validateTypeIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternNode__ValidateTypeIsRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.RelPatternNode#validateEClassifierIsInTypedModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate EClassifier Is In Typed Model</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate EClassifier Is In Typed Model</em>' operation.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#validateEClassifierIsInTypedModel(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getRelPatternNode__ValidateEClassifierIsInTypedModel__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.RelPatternNode#getInvokingRelInvocationEdges <em>Invoking Rel Invocation Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invoking Rel Invocation Edges</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getInvokingRelInvocationEdges()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EReference getRelPatternNode_InvokingRelInvocationEdges();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.RelPatternNode#isIsAnon <em>Is Anon</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Anon</em>'.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#isIsAnon()
	 * @see #getRelPatternNode()
	 * @generated
	 */
	EAttribute getRelPatternNode_IsAnon();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxPackageNodes <em>Owned Tx Package Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tx Package Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxPackageNodes()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_OwnedTxPackageNodes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxQueryNodes <em>Owned Tx Query Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tx Query Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#getOwnedTxQueryNodes()
	 * @see #getTxDiagram()
	 * @generated
	 */
	EReference getTxDiagram_OwnedTxQueryNodes();

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
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxDiagram#validateTxQueryNodeNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Tx Query Node Names Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Tx Query Node Names Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#validateTxQueryNodeNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxDiagram__ValidateTxQueryNodeNamesAreUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxDiagram#validateRelDiagramNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Rel Diagram Names Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Rel Diagram Names Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#validateRelDiagramNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxDiagram__ValidateRelDiagramNamesAreUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxDiagram#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Required</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxDiagram__ValidateNameIsRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxDiagram#validateTxTypedModelNodeNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Tx Typed Model Node Names Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Tx Typed Model Node Names Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxDiagram#validateTxTypedModelNodeNamesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxDiagram__ValidateTxTypedModelNodeNamesAreUnique__DiagnosticChain_Map();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.TxKeyNode#getReferredEClass <em>Referred EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred EClass</em>'.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#getReferredEClass()
	 * @see #getTxKeyNode()
	 * @generated
	 */
	EReference getTxKeyNode_ReferredEClass();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxKeyNode#validatePartsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Parts Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Parts Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxKeyNode#validatePartsAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxKeyNode__ValidatePartsAreUnique__DiagnosticChain_Map();

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
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.TxPartNode#getReferredEStructuralFeature <em>Referred EStructural Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred EStructural Feature</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPartNode#getReferredEStructuralFeature()
	 * @see #getTxPartNode()
	 * @generated
	 */
	EReference getTxPartNode_ReferredEStructuralFeature();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxPartNode#validatePartIsPropertyOfKey(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Part Is Property Of Key</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Part Is Property Of Key</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxPartNode#validatePartIsPropertyOfKey(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxPartNode__ValidatePartIsPropertyOfKey__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxQueryNode <em>Tx Query Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Query Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxQueryNode
	 * @generated
	 */
	EClass getTxQueryNode();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvtd.umlx.TxQueryNode#getInitExpressionLines <em>Init Expression Lines</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Init Expression Lines</em>'.
	 * @see org.eclipse.qvtd.umlx.TxQueryNode#getInitExpressionLines()
	 * @see #getTxQueryNode()
	 * @generated
	 */
	EAttribute getTxQueryNode_InitExpressionLines();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.qvtd.umlx.TxQueryNode#getOwnedTxParameterNodes <em>Owned Tx Parameter Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Tx Parameter Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxQueryNode#getOwnedTxParameterNodes()
	 * @see #getTxQueryNode()
	 * @generated
	 */
	EReference getTxQueryNode_OwnedTxParameterNodes();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxQueryNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxQueryNode#getOwningTxDiagram()
	 * @see #getTxQueryNode()
	 * @generated
	 */
	EReference getTxQueryNode_OwningTxDiagram();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxQueryNode#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Required</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxQueryNode#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxQueryNode__ValidateNameIsRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxQueryNode#validateTypeIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Required</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxQueryNode#validateTypeIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxQueryNode__ValidateTypeIsRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxQueryNode#validateParametersAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Parameters Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Parameters Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxQueryNode#validateParametersAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxQueryNode__ValidateParametersAreUnique__DiagnosticChain_Map();

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
	 * Returns the meta object for the attribute list '{@link org.eclipse.qvtd.umlx.TxPackageNode#getImportAliases <em>Import Aliases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Import Aliases</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPackageNode#getImportAliases()
	 * @see #getTxPackageNode()
	 * @generated
	 */
	EAttribute getTxPackageNode_ImportAliases();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxPackageNode#getOwningTxDiagram <em>Owning Tx Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Tx Diagram</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPackageNode#getOwningTxDiagram()
	 * @see #getTxPackageNode()
	 * @generated
	 */
	EReference getTxPackageNode_OwningTxDiagram();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.TxPackageNode#getReferredEPackage <em>Referred EPackage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred EPackage</em>'.
	 * @see org.eclipse.qvtd.umlx.TxPackageNode#getReferredEPackage()
	 * @see #getTxPackageNode()
	 * @generated
	 */
	EReference getTxPackageNode_ReferredEPackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.TxParameterNode <em>Tx Parameter Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tx Parameter Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxParameterNode
	 * @generated
	 */
	EClass getTxParameterNode();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.qvtd.umlx.TxParameterNode#getOwningTxQueryNode <em>Owning Tx Query Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Owning Tx Query Node</em>'.
	 * @see org.eclipse.qvtd.umlx.TxParameterNode#getOwningTxQueryNode()
	 * @see #getTxParameterNode()
	 * @generated
	 */
	EReference getTxParameterNode_OwningTxQueryNode();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxParameterNode#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Required</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxParameterNode#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxParameterNode__ValidateNameIsRequired__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxParameterNode#validateTypeIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Type Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Type Is Required</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxParameterNode#validateTypeIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxParameterNode__ValidateTypeIsRequired__DiagnosticChain_Map();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getDependsOns <em>Depends Ons</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Depends Ons</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getDependsOns()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	EReference getTxTypedModelNode_DependsOns();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getIterates <em>Iterates</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Iterates</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getIterates()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	EReference getTxTypedModelNode_Iterates();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#getUsedTxPackageNodes <em>Used Tx Package Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used Tx Package Nodes</em>'.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#getUsedTxPackageNodes()
	 * @see #getTxTypedModelNode()
	 * @generated
	 */
	EReference getTxTypedModelNode_UsedTxPackageNodes();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#validateTxPackageNodePackagesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Tx Package Node Packages Are Unique</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Tx Package Node Packages Are Unique</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#validateTxPackageNodePackagesAreUnique(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxTypedModelNode__ValidateTxPackageNodePackagesAreUnique__DiagnosticChain_Map();

	/**
	 * Returns the meta object for the '{@link org.eclipse.qvtd.umlx.TxTypedModelNode#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Name Is Required</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Validate Name Is Required</em>' operation.
	 * @see org.eclipse.qvtd.umlx.TxTypedModelNode#validateNameIsRequired(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getTxTypedModelNode__ValidateNameIsRequired__DiagnosticChain_Map();

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
	 * Returns the meta object for class '{@link org.eclipse.qvtd.umlx.UMLXTypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typed Element</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXTypedElement
	 * @generated
	 */
	EClass getUMLXTypedElement();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsMany <em>Is Many</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Many</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXTypedElement#isIsMany()
	 * @see #getUMLXTypedElement()
	 * @generated
	 */
	EAttribute getUMLXTypedElement_IsMany();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsNullFree <em>Is Null Free</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Null Free</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXTypedElement#isIsNullFree()
	 * @see #getUMLXTypedElement()
	 * @generated
	 */
	EAttribute getUMLXTypedElement_IsNullFree();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsOrdered <em>Is Ordered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Ordered</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXTypedElement#isIsOrdered()
	 * @see #getUMLXTypedElement()
	 * @generated
	 */
	EAttribute getUMLXTypedElement_IsOrdered();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsRequired <em>Is Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Required</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXTypedElement#isIsRequired()
	 * @see #getUMLXTypedElement()
	 * @generated
	 */
	EAttribute getUMLXTypedElement_IsRequired();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#isIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXTypedElement#isIsUnique()
	 * @see #getUMLXTypedElement()
	 * @generated
	 */
	EAttribute getUMLXTypedElement_IsUnique();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.qvtd.umlx.UMLXTypedElement#getReferredEClassifier <em>Referred EClassifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Referred EClassifier</em>'.
	 * @see org.eclipse.qvtd.umlx.UMLXTypedElement#getReferredEClassifier()
	 * @see #getUMLXTypedElement()
	 * @generated
	 */
	EReference getUMLXTypedElement_ReferredEClassifier();

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
		 * The meta object literal for the '<em><b>Is Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_DIAGRAM__IS_ABSTRACT = eINSTANCE.getRelDiagram_IsAbstract();

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
		 * The meta object literal for the '<em><b>Validate Name Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_DIAGRAM___VALIDATE_NAME_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelDiagram__ValidateNameIsRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Rel Pattern Node Names Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_DIAGRAM___VALIDATE_REL_PATTERN_NODE_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelDiagram__ValidateRelPatternNodeNamesAreUnique__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Is Enforced</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_DOMAIN_NODE__IS_ENFORCED = eINSTANCE.getRelDomainNode_IsEnforced();

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
		 * The meta object literal for the '<em><b>Validate Compatible Edges</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_INVOCATION_NODE___VALIDATE_COMPATIBLE_EDGES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelInvocationNode__ValidateCompatibleEdges__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_EDGE__SOURCE = eINSTANCE.getRelPatternEdge_Source();

		/**
		 * The meta object literal for the '<em><b>Source Index</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_PATTERN_EDGE__SOURCE_INDEX = eINSTANCE.getRelPatternEdge_SourceIndex();

		/**
		 * The meta object literal for the '<em><b>Owning Rel Domain Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_EDGE__OWNING_REL_DOMAIN_NODE = eINSTANCE.getRelPatternEdge_OwningRelDomainNode();

		/**
		 * The meta object literal for the '<em><b>Referred EStructural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_EDGE__REFERRED_ESTRUCTURAL_FEATURE = eINSTANCE.getRelPatternEdge_ReferredEStructuralFeature();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_EDGE__TARGET = eINSTANCE.getRelPatternEdge_Target();

		/**
		 * The meta object literal for the '<em><b>Validate Source Is EClass</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_EDGE___VALIDATE_SOURCE_IS_ECLASS__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternEdge__ValidateSourceIsEClass__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Source Is Class Node</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_EDGE___VALIDATE_SOURCE_IS_CLASS_NODE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternEdge__ValidateSourceIsClassNode__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible EAttribute Property Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_EATTRIBUTE_PROPERTY_TARGET__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternEdge__ValidateCompatibleEAttributePropertyTarget__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Source Multiplicity</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_SOURCE_MULTIPLICITY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternEdge__ValidateCompatibleSourceMultiplicity__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible EReference Property Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_EREFERENCE_PROPERTY_TARGET__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternEdge__ValidateCompatibleEReferencePropertyTarget__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Property Source</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_PROPERTY_SOURCE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternEdge__ValidateCompatiblePropertySource__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Source Index</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_SOURCE_INDEX__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternEdge__ValidateCompatibleSourceIndex__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Rest Property Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_REST_PROPERTY_TARGET__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternEdge__ValidateCompatibleRestPropertyTarget__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Compatible Member Property Target</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_EDGE___VALIDATE_COMPATIBLE_MEMBER_PROPERTY_TARGET__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternEdge__ValidateCompatibleMemberPropertyTarget__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Init Expression Lines</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_PATTERN_NODE__INIT_EXPRESSION_LINES = eINSTANCE.getRelPatternNode_InitExpressionLines();

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
		 * The meta object literal for the '<em><b>Is Expression</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_NODE___IS_EXPRESSION = eINSTANCE.getRelPatternNode__IsExpression();

		/**
		 * The meta object literal for the '<em><b>Validate Anon Is Unnamed</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_NODE___VALIDATE_ANON_IS_UNNAMED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternNode__ValidateAnonIsUnnamed__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_NODE___VALIDATE_TYPE_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternNode__ValidateTypeIsRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate EClassifier Is In Typed Model</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation REL_PATTERN_NODE___VALIDATE_ECLASSIFIER_IS_IN_TYPED_MODEL__DIAGNOSTICCHAIN_MAP = eINSTANCE.getRelPatternNode__ValidateEClassifierIsInTypedModel__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Invoking Rel Invocation Edges</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REL_PATTERN_NODE__INVOKING_REL_INVOCATION_EDGES = eINSTANCE.getRelPatternNode_InvokingRelInvocationEdges();

		/**
		 * The meta object literal for the '<em><b>Is Anon</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REL_PATTERN_NODE__IS_ANON = eINSTANCE.getRelPatternNode_IsAnon();

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
		 * The meta object literal for the '<em><b>Owned Tx Key Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__OWNED_TX_KEY_NODES = eINSTANCE.getTxDiagram_OwnedTxKeyNodes();

		/**
		 * The meta object literal for the '<em><b>Owned Tx Package Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__OWNED_TX_PACKAGE_NODES = eINSTANCE.getTxDiagram_OwnedTxPackageNodes();

		/**
		 * The meta object literal for the '<em><b>Owned Tx Query Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_DIAGRAM__OWNED_TX_QUERY_NODES = eINSTANCE.getTxDiagram_OwnedTxQueryNodes();

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
		 * The meta object literal for the '<em><b>Validate Tx Query Node Names Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_DIAGRAM___VALIDATE_TX_QUERY_NODE_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxDiagram__ValidateTxQueryNodeNamesAreUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Rel Diagram Names Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_DIAGRAM___VALIDATE_REL_DIAGRAM_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxDiagram__ValidateRelDiagramNamesAreUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_DIAGRAM___VALIDATE_NAME_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxDiagram__ValidateNameIsRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Tx Typed Model Node Names Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_DIAGRAM___VALIDATE_TX_TYPED_MODEL_NODE_NAMES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxDiagram__ValidateTxTypedModelNodeNamesAreUnique__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Referred EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_KEY_NODE__REFERRED_ECLASS = eINSTANCE.getTxKeyNode_ReferredEClass();

		/**
		 * The meta object literal for the '<em><b>Validate Parts Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_KEY_NODE___VALIDATE_PARTS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxKeyNode__ValidatePartsAreUnique__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Referred EStructural Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_PART_NODE__REFERRED_ESTRUCTURAL_FEATURE = eINSTANCE.getTxPartNode_ReferredEStructuralFeature();

		/**
		 * The meta object literal for the '<em><b>Validate Part Is Property Of Key</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_PART_NODE___VALIDATE_PART_IS_PROPERTY_OF_KEY__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxPartNode__ValidatePartIsPropertyOfKey__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxQueryNodeImpl <em>Tx Query Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxQueryNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxQueryNode()
		 * @generated
		 */
		EClass TX_QUERY_NODE = eINSTANCE.getTxQueryNode();

		/**
		 * The meta object literal for the '<em><b>Init Expression Lines</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_QUERY_NODE__INIT_EXPRESSION_LINES = eINSTANCE.getTxQueryNode_InitExpressionLines();

		/**
		 * The meta object literal for the '<em><b>Owned Tx Parameter Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_QUERY_NODE__OWNED_TX_PARAMETER_NODES = eINSTANCE.getTxQueryNode_OwnedTxParameterNodes();

		/**
		 * The meta object literal for the '<em><b>Owning Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_QUERY_NODE__OWNING_TX_DIAGRAM = eINSTANCE.getTxQueryNode_OwningTxDiagram();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_QUERY_NODE___VALIDATE_NAME_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxQueryNode__ValidateNameIsRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_QUERY_NODE___VALIDATE_TYPE_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxQueryNode__ValidateTypeIsRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Parameters Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_QUERY_NODE___VALIDATE_PARAMETERS_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxQueryNode__ValidateParametersAreUnique__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Import Aliases</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_PACKAGE_NODE__IMPORT_ALIASES = eINSTANCE.getTxPackageNode_ImportAliases();

		/**
		 * The meta object literal for the '<em><b>Owning Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_PACKAGE_NODE__OWNING_TX_DIAGRAM = eINSTANCE.getTxPackageNode_OwningTxDiagram();

		/**
		 * The meta object literal for the '<em><b>Referred EPackage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_PACKAGE_NODE__REFERRED_EPACKAGE = eINSTANCE.getTxPackageNode_ReferredEPackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl <em>Tx Parameter Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.TxParameterNodeImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getTxParameterNode()
		 * @generated
		 */
		EClass TX_PARAMETER_NODE = eINSTANCE.getTxParameterNode();

		/**
		 * The meta object literal for the '<em><b>Owning Tx Query Node</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_PARAMETER_NODE__OWNING_TX_QUERY_NODE = eINSTANCE.getTxParameterNode_OwningTxQueryNode();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_PARAMETER_NODE___VALIDATE_NAME_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxParameterNode__ValidateNameIsRequired__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Type Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_PARAMETER_NODE___VALIDATE_TYPE_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxParameterNode__ValidateTypeIsRequired__DiagnosticChain_Map();

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
		 * The meta object literal for the '<em><b>Depends Ons</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_TYPED_MODEL_NODE__DEPENDS_ONS = eINSTANCE.getTxTypedModelNode_DependsOns();

		/**
		 * The meta object literal for the '<em><b>Enforce</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TX_TYPED_MODEL_NODE__ENFORCE = eINSTANCE.getTxTypedModelNode_Enforce();

		/**
		 * The meta object literal for the '<em><b>Iterates</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_TYPED_MODEL_NODE__ITERATES = eINSTANCE.getTxTypedModelNode_Iterates();

		/**
		 * The meta object literal for the '<em><b>Owning Tx Diagram</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_TYPED_MODEL_NODE__OWNING_TX_DIAGRAM = eINSTANCE.getTxTypedModelNode_OwningTxDiagram();

		/**
		 * The meta object literal for the '<em><b>Used Tx Package Nodes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TX_TYPED_MODEL_NODE__USED_TX_PACKAGE_NODES = eINSTANCE.getTxTypedModelNode_UsedTxPackageNodes();

		/**
		 * The meta object literal for the '<em><b>Validate Tx Package Node Packages Are Unique</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_TYPED_MODEL_NODE___VALIDATE_TX_PACKAGE_NODE_PACKAGES_ARE_UNIQUE__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxTypedModelNode__ValidateTxPackageNodePackagesAreUnique__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '<em><b>Validate Name Is Required</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TX_TYPED_MODEL_NODE___VALIDATE_NAME_IS_REQUIRED__DIAGNOSTICCHAIN_MAP = eINSTANCE.getTxTypedModelNode__ValidateNameIsRequired__DiagnosticChain_Map();

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
		 * The meta object literal for the '{@link org.eclipse.qvtd.umlx.impl.UMLXTypedElementImpl <em>Typed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.qvtd.umlx.impl.UMLXTypedElementImpl
		 * @see org.eclipse.qvtd.umlx.impl.UMLXPackageImpl#getUMLXTypedElement()
		 * @generated
		 */
		EClass UMLX_TYPED_ELEMENT = eINSTANCE.getUMLXTypedElement();

		/**
		 * The meta object literal for the '<em><b>Is Many</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UMLX_TYPED_ELEMENT__IS_MANY = eINSTANCE.getUMLXTypedElement_IsMany();

		/**
		 * The meta object literal for the '<em><b>Is Null Free</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UMLX_TYPED_ELEMENT__IS_NULL_FREE = eINSTANCE.getUMLXTypedElement_IsNullFree();

		/**
		 * The meta object literal for the '<em><b>Is Ordered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UMLX_TYPED_ELEMENT__IS_ORDERED = eINSTANCE.getUMLXTypedElement_IsOrdered();

		/**
		 * The meta object literal for the '<em><b>Is Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UMLX_TYPED_ELEMENT__IS_REQUIRED = eINSTANCE.getUMLXTypedElement_IsRequired();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UMLX_TYPED_ELEMENT__IS_UNIQUE = eINSTANCE.getUMLXTypedElement_IsUnique();

		/**
		 * The meta object literal for the '<em><b>Referred EClassifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UMLX_TYPED_ELEMENT__REFERRED_ECLASSIFIER = eINSTANCE.getUMLXTypedElement_ReferredEClassifier();

	}

} //UMLXPackage
