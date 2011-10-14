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
 * $Id: RelationCallExp.java,v 1.1 2008/07/23 09:59:44 qglineur Exp $
 */
package org.eclipse.qvt.declarative.emof.QVTRelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTRelation.RelationCallExp#getArgument <em>Argument</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.emof.QVTRelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getRelationCallExp()
 * @model
 * @generated
 */
public interface RelationCallExp extends OclExpression {
	/**
	 * Returns the value of the '<em><b>Argument</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.emof.EssentialOCL.OclExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Argument</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getRelationCallExp_Argument()
	 * @model containment="true" lower="2"
	 * @generated
	 */
	EList<OclExpression> getArgument();

	/**
	 * Returns the value of the '<em><b>Referred Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Relation</em>' reference.
	 * @see #setReferredRelation(Relation)
	 * @see org.eclipse.qvt.declarative.emof.QVTRelation.QVTRelationPackage#getRelationCallExp_ReferredRelation()
	 * @model required="true"
	 * @generated
	 */
	Relation getReferredRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.emof.QVTRelation.RelationCallExp#getReferredRelation <em>Referred Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Relation</em>' reference.
	 * @see #getReferredRelation()
	 * @generated
	 */
	void setReferredRelation(Relation value);

} // RelationCallExp
