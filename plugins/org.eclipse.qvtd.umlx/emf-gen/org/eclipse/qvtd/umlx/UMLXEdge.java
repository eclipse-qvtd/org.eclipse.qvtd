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
 * A representation of the model object '<em><b>Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXEdge#getOwningSource <em>Owning Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXEdge#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXEdge()
 * @generated
 */
public interface UMLXEdge extends UMLXElement {
	/**
	 * Returns the value of the '<em><b>Owning Source</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.UMLXNode#getOwnedOutgoingEdges <em>Owned Outgoing Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Source</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Source</em>' container reference.
	 * @see #setOwningSource(UMLXNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXEdge_OwningSource()
	 * @see org.eclipse.qvtd.umlx.UMLXNode#getOwnedOutgoingEdges
	 * @generated
	 */
	UMLXNode getOwningSource();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.UMLXEdge#getOwningSource <em>Owning Source</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Source</em>' container reference.
	 * @see #getOwningSource()
	 * @generated
	 */
	void setOwningSource(UMLXNode value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.UMLXNode#getIncomingEdges <em>Incoming Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(UMLXNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXEdge_Target()
	 * @see org.eclipse.qvtd.umlx.UMLXNode#getIncomingEdges
	 * @generated
	 */
	UMLXNode getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.UMLXEdge#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(UMLXNode value);

} // Edge
