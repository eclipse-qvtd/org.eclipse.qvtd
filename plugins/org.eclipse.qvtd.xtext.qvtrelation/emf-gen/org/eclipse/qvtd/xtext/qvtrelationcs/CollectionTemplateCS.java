/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtrelationcs;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Template CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS#getOwnedMemberIdentifiers <em>Owned Member Identifiers</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS#getOwnedRestIdentifier <em>Owned Rest Identifier</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getCollectionTemplateCS()
 * @model
 * @generated
 */
public interface CollectionTemplateCS extends TemplateCS {
	/**
	 * Returns the value of the '<em><b>Owned Member Identifiers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvtd.xtext.qvtrelationcs.TemplateVariableCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Member Identifiers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Member Identifiers</em>' containment reference list.
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getCollectionTemplateCS_OwnedMemberIdentifiers()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TemplateVariableCS> getOwnedMemberIdentifiers();

	/**
	 * Returns the value of the '<em><b>Owned Rest Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Rest Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Rest Identifier</em>' containment reference.
	 * @see #setOwnedRestIdentifier(ElementTemplateCS)
	 * @see org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage#getCollectionTemplateCS_OwnedRestIdentifier()
	 * @model containment="true"
	 * @generated
	 */
	ElementTemplateCS getOwnedRestIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.xtext.qvtrelationcs.CollectionTemplateCS#getOwnedRestIdentifier <em>Owned Rest Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Rest Identifier</em>' containment reference.
	 * @see #getOwnedRestIdentifier()
	 * @generated
	 */
	void setOwnedRestIdentifier(ElementTemplateCS value);

} // CollectionTemplateCS
