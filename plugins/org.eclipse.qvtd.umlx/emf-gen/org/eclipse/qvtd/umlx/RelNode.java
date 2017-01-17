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
 * A representation of the model object '<em><b>Rel Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelNode#getDiagram <em>Diagram</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelNode()
 * @generated
 */
public interface RelNode extends UMLXNode {

	/**
	 * Returns the value of the '<em><b>Diagram</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelDiagram#getOwnedNodes <em>Owned Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Diagram</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagram</em>' container reference.
	 * @see #setDiagram(RelDiagram)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelNode_Diagram()
	 * @see org.eclipse.qvtd.umlx.RelDiagram#getOwnedNodes
	 * @generated
	 */
	RelDiagram getDiagram();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelNode#getDiagram <em>Diagram</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagram</em>' container reference.
	 * @see #getDiagram()
	 * @generated
	 */
	void setDiagram(RelDiagram value);
} // RelNode
