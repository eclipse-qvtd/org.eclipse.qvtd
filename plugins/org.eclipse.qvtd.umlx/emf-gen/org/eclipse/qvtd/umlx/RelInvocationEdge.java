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
 *   <li>{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getReferredRelPatternNode <em>Referred Rel Pattern Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelInvocationEdge()
 * @generated
 */
public interface RelInvocationEdge extends UMLXEdge {

	/**
	 * Returns the value of the '<em><b>Referred Rel Pattern Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Rel Pattern Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Rel Pattern Node</em>' reference.
	 * @see #setReferredRelPatternNode(RelPatternNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelInvocationEdge_ReferredRelPatternNode()
	 * @generated
	 */
	RelPatternNode getReferredRelPatternNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelInvocationEdge#getReferredRelPatternNode <em>Referred Rel Pattern Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Rel Pattern Node</em>' reference.
	 * @see #getReferredRelPatternNode()
	 * @generated
	 */
	void setReferredRelPatternNode(RelPatternNode value);
} // RelInvocationEdge
