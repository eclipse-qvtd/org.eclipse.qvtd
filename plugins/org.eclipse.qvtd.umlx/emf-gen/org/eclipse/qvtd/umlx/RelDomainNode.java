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
 *   <li>{@link org.eclipse.qvtd.umlx.RelDomainNode#getReferredTypedModelNode <em>Referred Typed Model Node</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelDomainNode#getRootPatternNodes <em>Root Pattern Nodes</em>}</li>
 * </ul>
 *
 * @generated
 */
public interface RelDomainNode extends Node {
	/**
	 * Returns the value of the '<em><b>Referred Typed Model Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Typed Model Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Typed Model Node</em>' reference.
	 * @see #setReferredTypedModelNode(TxTypedModelNode)
	 * @generated
	 */
	TxTypedModelNode getReferredTypedModelNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelDomainNode#getReferredTypedModelNode <em>Referred Typed Model Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Typed Model Node</em>' reference.
	 * @see #getReferredTypedModelNode()
	 * @generated
	 */
	void setReferredTypedModelNode(TxTypedModelNode value);

	/**
	 * Returns the value of the '<em><b>Root Pattern Nodes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.RelPatternNode}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelPatternNode#getRelDomainNode <em>Rel Domain Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Pattern Nodes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Pattern Nodes</em>' reference list.
	 * @see org.eclipse.qvtd.umlx.RelPatternNode#getRelDomainNode
	 * @generated
	 */
	EList<RelPatternNode> getRootPatternNodes();

} // RelDomainNode
