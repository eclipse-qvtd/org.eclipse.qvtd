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
import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rel Pattern Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternClassNode#isIsRequired <em>Is Required</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternClassNode#getReferredClass <em>Referred Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.umlx.RelPatternClassNode#getRelDomainNode <em>Rel Domain Node</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternClassNode()
 * @generated
 */
public interface RelPatternClassNode extends RelPatternNode, UMLXNamedElement {
	/**
	 * Returns the value of the '<em><b>Is Required</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Required</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Required</em>' attribute.
	 * @see #setIsRequired(boolean)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternClassNode_IsRequired()
	 * @generated
	 */
	boolean isIsRequired();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternClassNode#isIsRequired <em>Is Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Required</em>' attribute.
	 * @see #isIsRequired()
	 * @generated
	 */
	void setIsRequired(boolean value);

	/**
	 * Returns the value of the '<em><b>Referred Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Class</em>' reference.
	 * @see #setReferredClass(EClassifier)
	 * @see org.eclipse.qvtd.umlx.UMLXPackage#getRelPatternClassNode_ReferredClass()
	 * @generated
	 */
	EClassifier getReferredClass();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.umlx.RelPatternClassNode#getReferredClass <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Class</em>' reference.
	 * @see #getReferredClass()
	 * @generated
	 */
	void setReferredClass(EClassifier value);

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
	boolean EClassifierIsInTypedModel(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RelPatternNode
