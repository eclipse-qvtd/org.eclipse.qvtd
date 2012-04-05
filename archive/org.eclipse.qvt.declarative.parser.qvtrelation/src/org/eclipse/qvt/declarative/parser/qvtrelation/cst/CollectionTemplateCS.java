/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.cst;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS;
import org.eclipse.qvt.declarative.parser.qvt.cst.IdentifierCS;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Template CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getMemberIdentifier <em>Member Identifier</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getReferredCollectionType <em>Referred Collection Type</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getRestIdentifier <em>Rest Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getCollectionTemplateCS()
 * @model
 * @generated
 */
public interface CollectionTemplateCS extends TemplateCS {
	/**
	 * Returns the value of the '<em><b>Member Identifier</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.parser.qvt.cst.IdentifiedCS}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member Identifier</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member Identifier</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getCollectionTemplateCS_MemberIdentifier()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<IdentifiedCS> getMemberIdentifier();

	/**
	 * Returns the value of the '<em><b>Referred Collection Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Collection Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Collection Type</em>' reference.
	 * @see #setReferredCollectionType(EClassifier)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getCollectionTemplateCS_ReferredCollectionType()
	 * @model
	 * @generated
	 */
	EClassifier getReferredCollectionType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getReferredCollectionType <em>Referred Collection Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Collection Type</em>' reference.
	 * @see #getReferredCollectionType()
	 * @generated
	 */
	void setReferredCollectionType(EClassifier value);

	/**
	 * Returns the value of the '<em><b>Rest Identifier</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rest Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rest Identifier</em>' containment reference.
	 * @see #setRestIdentifier(IdentifierCS)
	 * @see org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage#getCollectionTemplateCS_RestIdentifier()
	 * @model containment="true" required="true"
	 * @generated
	 */
	IdentifierCS getRestIdentifier();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.CollectionTemplateCS#getRestIdentifier <em>Rest Identifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rest Identifier</em>' containment reference.
	 * @see #getRestIdentifier()
	 * @generated
	 */
	void setRestIdentifier(IdentifierCS value);

} // CollectionTemplateCS
