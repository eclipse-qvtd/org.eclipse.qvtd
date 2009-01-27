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
 * $Id: CollectionTemplateExp.java,v 1.3 2009/01/27 21:17:48 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate;

import org.eclipse.emf.common.util.EList;

import org.eclipse.ocl.ecore.CollectionType;
import org.eclipse.ocl.ecore.OCLExpression;
import org.eclipse.ocl.ecore.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Template Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp#getMember <em>Member</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp#getReferredCollectionType <em>Referred Collection Type</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp#getRest <em>Rest</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getCollectionTemplateExp()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ReferredCollectionElementTypeIsDeclaredByDomain\r\nEveryMemberTypeMatchesElementType\r\nEveryMemberExpressionVariableIsBoundByPattern\r\nRestTypeMatchesCollectionType\r\nRestVariableIsBoundByPattern\r\nMemberCountSatifiesLowerBound\r\nEveryEnforceableItemIsEnforced\r\n'"
 * @generated
 */
public interface CollectionTemplateExp extends TemplateExp {
	/**
	 * Returns the value of the '<em><b>Member</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ocl.ecore.OCLExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Member</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Member</em>' containment reference list.
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getCollectionTemplateExp_Member()
	 * @model containment="true" ordered="false"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='listContainer'"
	 * @generated
	 */
	EList<OCLExpression> getMember();

	/**
	 * Returns the value of the '<em><b>Referred Collection Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Referred Collection Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Referred Collection Type</em>' reference.
	 * @see #setReferredCollectionType(CollectionType)
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getCollectionTemplateExp_ReferredCollectionType()
	 * @model required="true"
	 * @generated
	 */
	CollectionType getReferredCollectionType();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp#getReferredCollectionType <em>Referred Collection Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Referred Collection Type</em>' reference.
	 * @see #getReferredCollectionType()
	 * @generated
	 */
	void setReferredCollectionType(CollectionType value);

	/**
	 * Returns the value of the '<em><b>Rest</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rest</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rest</em>' reference.
	 * @see #setRest(Variable)
	 * @see org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage#getCollectionTemplateExp_Rest()
	 * @model annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='matchingExp'"
	 * @generated
	 */
	Variable getRest();

	/**
	 * Sets the value of the '{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.CollectionTemplateExp#getRest <em>Rest</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rest</em>' reference.
	 * @see #getRest()
	 * @generated
	 */
	void setRest(Variable value);

} // CollectionTemplateExp
