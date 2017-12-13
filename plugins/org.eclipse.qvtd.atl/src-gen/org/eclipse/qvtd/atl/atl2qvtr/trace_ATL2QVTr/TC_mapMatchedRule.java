/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC map Matched Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getAtl_matchedRule <em>Atl matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getPrimitive_ruleName <em>Primitive rule Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapMatchedRule()
 * @model
 * @generated
 */
public interface TC_mapMatchedRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Atl atl Module</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Module</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Module</em>' reference.
	 * @see #setAtl_atlModule(org.eclipse.m2m.atl.common.ATL.Module)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapMatchedRule_Atl_atlModule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	org.eclipse.m2m.atl.common.ATL.Module getAtl_atlModule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getAtl_atlModule <em>Atl atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Module</em>' reference.
	 * @see #getAtl_atlModule()
	 * @generated
	 */
	void setAtl_atlModule(org.eclipse.m2m.atl.common.ATL.Module value);

	/**
	 * Returns the value of the '<em><b>Atl matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl matched Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl matched Rule</em>' reference.
	 * @see #setAtl_matchedRule(MatchedRule)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapMatchedRule_Atl_matchedRule()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapMatchedRule'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	MatchedRule getAtl_matchedRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getAtl_matchedRule <em>Atl matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl matched Rule</em>' reference.
	 * @see #getAtl_matchedRule()
	 * @generated
	 */
	void setAtl_matchedRule(MatchedRule value);

	/**
	 * Returns the value of the '<em><b>Primitive rule Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive rule Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive rule Name</em>' attribute.
	 * @see #setPrimitive_ruleName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapMatchedRule_Primitive_ruleName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getPrimitive_ruleName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getPrimitive_ruleName <em>Primitive rule Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive rule Name</em>' attribute.
	 * @see #getPrimitive_ruleName()
	 * @generated
	 */
	void setPrimitive_ruleName(String value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Relation</em>' reference.
	 * @see #setQvtr_qvtrRelation(Relation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapMatchedRule_Qvtr_qvtrRelation()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapMatchedRule'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Relation getQvtr_qvtrRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Relation</em>' reference.
	 * @see #getQvtr_qvtrRelation()
	 * @generated
	 */
	void setQvtr_qvtrRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Transformation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Transformation</em>' reference.
	 * @see #setQvtr_qvtrTransformation(RelationalTransformation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapMatchedRule_Qvtr_qvtrTransformation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationalTransformation getQvtr_qvtrTransformation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Transformation</em>' reference.
	 * @see #getQvtr_qvtrTransformation()
	 * @generated
	 */
	void setQvtr_qvtrTransformation(RelationalTransformation value);

	/**
	 * Returns the value of the '<em><b>Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Status</em>' attribute.
	 * @see #setStatus(Boolean)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapMatchedRule_Status()
	 * @model
	 * @generated
	 */
	Boolean getStatus();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapMatchedRule#getStatus <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Status</em>' attribute.
	 * @see #getStatus()
	 * @generated
	 */
	void setStatus(Boolean value);

} // TC_mapMatchedRule
