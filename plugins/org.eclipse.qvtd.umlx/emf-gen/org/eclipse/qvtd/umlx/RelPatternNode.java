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
 * A representation of the model object '<em><b>Rel Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternNode#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternNode#getInitExpressionLines <em>Init Expression Lines</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternNode#isIsRoot <em>Is Root</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternNode#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternNode#getInvokingRelInvocationEdges <em>Invoking Rel Invocation Edges</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternNode()
 * @generated
 */
public interface RelPatternNode extends RelNode {

	/**
	 * Returns the value of the '<em><b>Incoming</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.RelPatternEdge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming</em>' reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternNode_Incoming()
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getTarget
	 * @generated
	 */
	EList<RelPatternEdge> getIncoming();

	/**
	 * Returns the value of the '<em><b>Init Expression Lines</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Expression Lines</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Expression Lines</em>' attribute list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternNode_InitExpressionLines()
	 * @generated
	 */
	EList<String> getInitExpressionLines();

	/**
	 * Returns the value of the '<em><b>Is Root</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Root</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Root</em>' attribute.
	 * @see #setIsRoot(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternNode_IsRoot()
	 * @generated
	 */
	boolean isIsRoot();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternNode#isIsRoot <em>Is Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Root</em>' attribute.
	 * @see #isIsRoot()
	 * @generated
	 */
	void setIsRoot(boolean value);

	/**
	 * Returns the value of the '<em><b>Owning Rel Domain Node</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternNodes <em>Owned Rel Pattern Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Rel Domain Node</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Rel Domain Node</em>' container reference.
	 * @see #setOwningRelDomainNode(RelDomainNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternNode_OwningRelDomainNode()
	 * @see org.eclipse.qvtd.umlx.RelDomainNode#getOwnedRelPatternNodes
	 * @generated
	 */
	RelDomainNode getOwningRelDomainNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternNode#getOwningRelDomainNode <em>Owning Rel Domain Node</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Rel Domain Node</em>' container reference.
	 * @see #getOwningRelDomainNode()
	 * @generated
	 */
	void setOwningRelDomainNode(RelDomainNode value);

	/**
	 * Returns the value of the '<em><b>Invoking Rel Invocation Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.RelInvocationEdge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getInvokingRelPatternNode <em>Invoking Rel Pattern Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invoking Rel Invocation Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invoking Rel Invocation Edges</em>' reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternNode_InvokingRelInvocationEdges()
	 * @see org.eclipse.qvtd.umlx.RelInvocationEdge#getInvokingRelPatternNode
	 * @generated
	 */
	EList<RelInvocationEdge> getInvokingRelInvocationEdges();
} // RelNode
