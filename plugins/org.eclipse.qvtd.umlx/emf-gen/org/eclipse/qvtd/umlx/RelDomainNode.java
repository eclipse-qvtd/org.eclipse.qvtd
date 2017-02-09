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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rel Domain Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDomainNode#isIsEnforced <em>Is Enforced</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternEdges <em>Owned Rel Pattern Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternNodes <em>Owned Rel Pattern Nodes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDomainNode#getOwningRelDiagram <em>Owning Rel Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDomainNode#getReferredTxTypedModelNode <em>Referred Tx Typed Model Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDomainNode()
 * @generated
 */
public interface RelDomainNode extends RelNode {
	/**
	 * Returns the value of the '<em><b>Is Enforced</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Enforced</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Enforced</em>' attribute.
	 * @see #setIsEnforced(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDomainNode_IsEnforced()
	 * @generated
	 */
	boolean isIsEnforced();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelDomainNode#isIsEnforced <em>Is Enforced</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Enforced</em>' attribute.
	 * @see #isIsEnforced()
	 * @generated
	 */
	void setIsEnforced(boolean value);

	/**
	 * Returns the value of the '<em><b>Owned Rel Pattern Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.RelPatternEdge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Rel Pattern Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Rel Pattern Edges</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDomainNode_OwnedRelPatternEdges()
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getOwningRelDomainNode
	 * @generated
	 */
	EList<RelPatternEdge> getOwnedRelPatternEdges();

	/**
	 * Returns the value of the '<em><b>Owned Rel Pattern Nodes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.RelPatternNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelPatternNode#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Rel Pattern Nodes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Rel Pattern Nodes</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDomainNode_OwnedRelPatternNodes()
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getOwningRelDomainNode
	 * @generated
	 */
	EList<RelPatternNode> getOwnedRelPatternNodes();

	/**
	 * Returns the value of the '<em><b>Owning Rel Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelDiagram#getOwnedRelDomainNodes <em>Owned Rel Domain Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Rel Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Rel Diagram</em>' container reference.
	 * @see #setOwningRelDiagram(RelDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDomainNode_OwningRelDiagram()
	 * @see org.eclipse.qvtd.umlx.RelDiagram#getOwnedRelDomainNodes
	 * @generated
	 */
	RelDiagram getOwningRelDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelDomainNode#getOwningRelDiagram <em>Owning Rel Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Rel Diagram</em>' container reference.
	 * @see #getOwningRelDiagram()
	 * @generated
	 */
	void setOwningRelDiagram(RelDiagram value);

	/**
	 * Returns the value of the '<em><b>Referred Tx Typed Model Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Tx Typed Model Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Tx Typed Model Node</em>' reference.
	 * @see #setReferredTxTypedModelNode(TxTypedModelNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelDomainNode_ReferredTxTypedModelNode()
	 * @generated
	 */
	TxTypedModelNode getReferredTxTypedModelNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelDomainNode#getReferredTxTypedModelNode <em>Referred Tx Typed Model Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Tx Typed Model Node</em>' reference.
	 * @see #getReferredTxTypedModelNode()
	 * @generated
	 */
	void setReferredTxTypedModelNode(TxTypedModelNode value);

} // RelDomainNode
