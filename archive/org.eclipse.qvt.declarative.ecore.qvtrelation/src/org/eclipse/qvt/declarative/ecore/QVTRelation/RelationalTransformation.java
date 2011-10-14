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
 * $Id: RelationalTransformation.java,v 1.4 2008/12/31 17:43:38 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.ecore.QVTBase.Transformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relational Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationalTransformation#getOwnedKey <em>Owned Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelationalTransformation()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniqueClassifierNames\r\nEveryRuleIsARelation\r\nKeysAreUnique'"
 * @generated
 */
public interface RelationalTransformation extends Transformation {
	/**
	 * Returns the value of the '<em><b>Owned Key</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTRelation.Key}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.Key#getTransformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Key</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Key</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelationalTransformation_OwnedKey()
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.Key#getTransformation
	 * @model opposite="transformation" containment="true" ordered="false"
	 * @generated
	 */
	EList<Key> getOwnedKey();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" nameRequired="true"
	 * @generated
	 */
	Relation getRelation(String name);

} // RelationalTransformation
