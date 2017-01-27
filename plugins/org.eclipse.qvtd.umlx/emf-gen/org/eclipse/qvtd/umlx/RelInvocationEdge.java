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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rel Invocation Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getInvokingRelPatternNode <em>Invoking Rel Pattern Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getOwningRelInvocationNode <em>Owning Rel Invocation Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getReferredRelPatternNode <em>Referred Rel Pattern Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelInvocationEdge()
 * @generated
 */
public interface RelInvocationEdge extends RelEdge {

	/**
	 * Returns the value of the '<em><b>Referred Rel Pattern Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Rel Pattern Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Rel Pattern Node</em>' reference.
	 * @see #setReferredRelPatternNode(RelPatternClassNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelInvocationEdge_ReferredRelPatternNode()
	 * @generated
	 */
	RelPatternClassNode getReferredRelPatternNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getReferredRelPatternNode <em>Referred Rel Pattern Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Rel Pattern Node</em>' reference.
	 * @see #getReferredRelPatternNode()
	 * @generated
	 */
	void setReferredRelPatternNode(RelPatternClassNode value);

	/**
	 * Returns the value of the '<em><b>Owning Rel Invocation Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelInvocationNode#getOwnedRelInvocationEdges <em>Owned Rel Invocation Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Rel Invocation Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Rel Invocation Node</em>' container reference.
	 * @see #setOwningRelInvocationNode(RelInvocationNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelInvocationEdge_OwningRelInvocationNode()
	 * @see org.eclipse.qvtd.umlx.RelInvocationNode#getOwnedRelInvocationEdges
	 * @generated
	 */
	RelInvocationNode getOwningRelInvocationNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getOwningRelInvocationNode <em>Owning Rel Invocation Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Rel Invocation Node</em>' container reference.
	 * @see #getOwningRelInvocationNode()
	 * @generated
	 */
	void setOwningRelInvocationNode(RelInvocationNode value);

	/**
	 * Returns the value of the '<em><b>Invoking Rel Pattern Node</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelPatternNode#getInvokingRelInvocationEdges <em>Invoking Rel Invocation Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invoking Rel Pattern Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invoking Rel Pattern Node</em>' reference.
	 * @see #setInvokingRelPatternNode(RelPatternNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelInvocationEdge_InvokingRelPatternNode()
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getInvokingRelInvocationEdges
	 * @generated
	 */
	RelPatternNode getInvokingRelPatternNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getInvokingRelPatternNode <em>Invoking Rel Pattern Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invoking Rel Pattern Node</em>' reference.
	 * @see #getInvokingRelPatternNode()
	 * @generated
	 */
	void setInvokingRelPatternNode(RelPatternNode value);
} // RelInvocationEdge
