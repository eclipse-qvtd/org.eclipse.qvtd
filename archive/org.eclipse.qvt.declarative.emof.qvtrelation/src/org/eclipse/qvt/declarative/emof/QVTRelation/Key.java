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
 * $Id: Key.java,v 1.2 2008/09/09 21:00:32 ewillink Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTRelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.emof.EMOF.Element;
import org.eclipse.qvt.declarative.emof.EMOF.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTRelation.Key#getIdentifies <em>Identifies</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTRelation.Key#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTRelation.Key#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTRelation.Key#getOppositePart <em>Opposite Part</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getKey()
 * @model
 * @generated
 */
public interface Key extends Element {
	/**
	 * Returns the value of the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifies</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifies</em>' reference.
	 * @see #setIdentifies(org.eclipse.qvt.declarative.emof.EMOF.Class)
	 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getKey_Identifies()
	 * @model required="true"
	 * @generated
	 */
	org.eclipse.qvt.declarative.emof.EMOF.Class getIdentifies();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTRelation.Key#getIdentifies <em>Identifies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifies</em>' reference.
	 * @see #getIdentifies()
	 * @generated
	 */
	void setIdentifies(org.eclipse.qvt.declarative.emof.EMOF.Class value);

	/**
	 * Returns the value of the '<em><b>Part</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Part</em>' reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getKey_Part()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Property> getPart();

	/**
	 * Returns the value of the '<em><b>Transformation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.emof.QVTRelation.RelationalTransformation#getOwnedKey <em>Owned Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation</em>' container reference.
	 * @see #setTransformation(RelationalTransformation)
	 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getKey_Transformation()
	 * @see org.eclipse.qvt.declarative.emof.QVTRelation.RelationalTransformation#getOwnedKey
	 * @model opposite="ownedKey"
	 * @generated
	 */
	RelationalTransformation getTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTRelation.Key#getTransformation <em>Transformation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation</em>' container reference.
	 * @see #getTransformation()
	 * @generated
	 */
	void setTransformation(RelationalTransformation value);

	/**
	 * Returns the value of the '<em><b>Opposite Part</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EMOF.Property}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Opposite Part</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Opposite Part</em>' reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getKey_OppositePart()
	 * @model ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='oppositeKey'"
	 * @generated
	 */
	EList<Property> getOppositePart();

} // Key
