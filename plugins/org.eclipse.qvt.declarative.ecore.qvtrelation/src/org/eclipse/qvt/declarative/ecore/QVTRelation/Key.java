/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: Key.java,v 1.3 2008/12/31 17:43:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Key#getIdentifies <em>Identifies</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Key#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Key#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Key#getOppositePart <em>Opposite Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getKey()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='AtLeastOnePart\r\nIdentifiesTypeIsDeclaredByTransformation\r\nEveryPartIsDeclaredByIdentifies\r\nEveryOppositePartReferencesIdentifies\r\n'"
 * @generated
 */
public interface Key extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifies</em>' reference.
	 * @see #setIdentifies(EClass)
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getKey_Identifies()
	 * @model required="true"
	 * @generated
	 */
	EClass getIdentifies();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Key#getIdentifies <em>Identifies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifies</em>' reference.
	 * @see #getIdentifies()
	 * @generated
	 */
	void setIdentifies(EClass value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EStructuralFeature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getKey_Part()
	 * @model ordered="false"
	 * @generated
	 */
	EList<EStructuralFeature> getPart();

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation#getOwnedKey <em>Owned Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(RelationalTransformation)
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getKey_Transformation()
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation#getOwnedKey
	 * @model opposite="ownedKey"
	 * @generated
	 */
	RelationalTransformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Key#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(RelationalTransformation value);

	/**
	 * Returns the value of the '<em><b>Opposite Part</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite Part</em>' reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getKey_OppositePart()
	 * @model ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='oppositeKey'"
	 * @generated
	 */
	EList<EReference> getOppositePart();

} // Key
