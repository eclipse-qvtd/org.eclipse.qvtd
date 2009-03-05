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
 * $Id: RelationDomain.java,v 1.5 2009/03/05 22:04:41 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTRelation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTBase.Domain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain#getPattern <em>Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain#getRootVariable <em>Root Variable</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain#getDefaultAssignment <em>Default Assignment</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelationDomain()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='WellFormedName\r\nTypedModelExistsWarning\r\nPrimitiveDomainIsUnnamed\r\nRootVariableIsDefinedByRelation\r\nRootVariableTypeIsDeclaredByDomainTypedModel\r\nEveryEnforceableVariableIsMatchedOrAssigned\r\n'"
 * @generated
 */
public interface RelationDomain extends Domain {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' containment reference.
	 * @see #setPattern(DomainPattern)
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelationDomain_Pattern()
	 * @model containment="true"
	 * @generated
	 */
	DomainPattern getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain#getPattern <em>Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' containment reference.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(DomainPattern value);

	/**
	 * Returns the value of the '<em><b>Root Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Root Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Root Variable</em>' reference.
	 * @see #setRootVariable(Variable)
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelationDomain_RootVariable()
	 * @model required="true"
	 * @generated
	 */
	Variable getRootVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomain#getRootVariable <em>Root Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Root Variable</em>' reference.
	 * @see #getRootVariable()
	 * @generated
	 */
	void setRootVariable(Variable value);

	/**
	 * Returns the value of the '<em><b>Default Assignment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.qvt.declarative.ecore.QVTRelation.RelationDomainAssignment}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Assignment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Assignment</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTRelation.QVTRelationPackage#getRelationDomain_DefaultAssignment()
	 * @model containment="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='owner'"
	 * @generated
	 */
	EList<RelationDomainAssignment> getDefaultAssignment();

} // RelationDomain
