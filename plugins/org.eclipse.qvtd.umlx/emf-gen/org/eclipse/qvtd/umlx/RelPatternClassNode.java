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

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rel Pattern Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternClassNode#isIsAnon <em>Is Anon</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternClassNode#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternClassNode#getRelDomainNode <em>Rel Domain Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternClassNode()
 * @generated
 */
public interface RelPatternClassNode extends RelPatternNode, UMLXTypedElement {
	/**
	 * Returns the value of the '<em><b>Is Anon</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Anon</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Anon</em>' attribute.
	 * @see #setIsAnon(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternClassNode_IsAnon()
	 * @generated
	 */
	boolean isIsAnon();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternClassNode#isIsAnon <em>Is Anon</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Anon</em>' attribute.
	 * @see #isIsAnon()
	 * @generated
	 */
	void setIsAnon(boolean value);

	/**
	 * Returns the value of the '<em><b>Outgoing</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.umlx.RelPatternEdge}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvtd.umlx.RelPatternEdge#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing</em>' reference list.
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternClassNode_Outgoing()
	 * @see org.eclipse.qvtd.umlx.RelPatternEdge#getSource
	 * @generated
	 */
	EList<RelPatternEdge> getOutgoing();

	/**
	 * Returns the value of the '<em><b>Rel Domain Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rel Domain Node</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rel Domain Node</em>' reference.
	 * @see #setRelDomainNode(RelDomainNode)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternClassNode_RelDomainNode()
	 * @generated
	 */
	RelDomainNode getRelDomainNode();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternClassNode#getRelDomainNode <em>Rel Domain Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rel Domain Node</em>' reference.
	 * @see #getRelDomainNode()
	 * @generated
	 */
	void setRelDomainNode(RelDomainNode value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateAnonIsUnnamed(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	boolean validateEClassifierIsInTypedModel(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RelPatternNode
