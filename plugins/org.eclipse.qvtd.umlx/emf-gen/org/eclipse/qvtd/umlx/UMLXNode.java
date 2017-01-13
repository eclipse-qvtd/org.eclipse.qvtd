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
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXNode#getDiagram <em>Diagram</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXNode#getIncomingEdges <em>Incoming Edges</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.UMLXNode#getOwnedOutgoingEdges <em>Owned Outgoing Edges</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXNode()
 * @generated
 */
public interface UMLXNode extends UMLXElement {
	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.UMLXDiagram#getOwnedNodes <em>Owned Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram</em>' container reference.
	 * @see #setDiagram(UMLXDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXNode_Diagram()
	 * @see org.eclipse.qvtd.umlx.UMLXDiagram#getOwnedNodes
	 * @generated
	 */
	UMLXDiagram getDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.UMLXNode#getDiagram <em>Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram</em>' container reference.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(UMLXDiagram value);

	/**
	 * Returns the value of the '<em><b>Incoming Edges</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.UMLXEdge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.UMLXEdge#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Edges</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Edges</em>' reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXNode_IncomingEdges()
	 * @see org.eclipse.qvtd.umlx.UMLXEdge#getTarget
	 * @generated
	 */
	EList<UMLXEdge> getIncomingEdges();

	/**
	 * Returns the value of the '<em><b>Owned Outgoing Edges</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.UMLXEdge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.UMLXEdge#getOwningSource <em>Owning Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Outgoing Edges</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Outgoing Edges</em>' containment reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getUMLXNode_OwnedOutgoingEdges()
	 * @see org.eclipse.qvtd.umlx.UMLXEdge#getOwningSource
	 * @generated
	 */
	EList<UMLXEdge> getOwnedOutgoingEdges();

} // Node
