/**
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rel Pattern Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternEdge#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternEdge#getReferredEStructuralFeature <em>Referred EStructural Feature</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternEdge#getSource <em>Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternEdge#getSourceIndex <em>Source Index</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternEdge#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternEdge()
 * @generated
 */
public interface RelPatternEdge extends RelEdge {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelPatternNode#getOutgoing <em>Outgoing</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(RelPatternNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternEdge_Source()
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getOutgoing
	 * @generated
	 */
	RelPatternNode getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(RelPatternNode value);

	/**
	 * Returns the value of the '<em><b>Source Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source Index</em>' attribute.
	 * @see #setSourceIndex(int)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternEdge_SourceIndex()
	 * @generated
	 */
	int getSourceIndex();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getSourceIndex <em>Source Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source Index</em>' attribute.
	 * @see #getSourceIndex()
	 * @generated
	 */
	void setSourceIndex(int value);

	/**
	 * Returns the value of the '<em><b>Owning Rel Domain Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternEdges <em>Owned Rel Pattern Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Rel Domain Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Rel Domain Node</em>' container reference.
	 * @see #setOwningRelDomainNode(RelDomainNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternEdge_OwningRelDomainNode()
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternEdges
	 * @generated
	 */
	RelDomainNode getOwningRelDomainNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Rel Domain Node</em>' container reference.
	 * @see #getOwningRelDomainNode()
	 * @generated
	 */
	void setOwningRelDomainNode(RelDomainNode value);

	/**
	 * Returns the value of the '<em><b>Referred EStructural Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred EStructural Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred EStructural Feature</em>' reference.
	 * @see #setReferredEStructuralFeature(EStructuralFeature)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternEdge_ReferredEStructuralFeature()
	 * @generated
	 */
	EStructuralFeature getReferredEStructuralFeature();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getReferredEStructuralFeature <em>Referred EStructural Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred EStructural Feature</em>' reference.
	 * @see #getReferredEStructuralFeature()
	 * @generated
	 */
	void setReferredEStructuralFeature(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelPatternNode#getIncoming <em>Incoming</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(RelPatternNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternEdge_Target()
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getIncoming
	 * @generated
	 */
	RelPatternNode getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(RelPatternNode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateSourceIsEClass(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateSourceIsClassNode(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleEAttributePropertyTarget(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleSourceMultiplicity(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleEReferencePropertyTarget(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatiblePropertySource(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleSourceIndex(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleRestPropertyTarget(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateCompatibleMemberPropertyTarget(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RelPatternEdge
