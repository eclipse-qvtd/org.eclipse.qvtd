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

import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC map Out Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern#getAtl_atlRule <em>Atl atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern#getQvtr_qvtrTypedModel <em>Qvtr qvtr Typed Model</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapOutPattern()
 * @model
 * @generated
 */
public interface TC_mapOutPattern extends TI_mapOutPattern {
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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapOutPattern_Atl_atlModule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	org.eclipse.m2m.atl.common.ATL.Module getAtl_atlModule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern#getAtl_atlModule <em>Atl atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Module</em>' reference.
	 * @see #getAtl_atlModule()
	 * @generated
	 */
	void setAtl_atlModule(org.eclipse.m2m.atl.common.ATL.Module value);

	/**
	 * Returns the value of the '<em><b>Atl atl Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Rule</em>' reference.
	 * @see #setAtl_atlRule(MatchedRule)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapOutPattern_Atl_atlRule()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapOutPattern'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	MatchedRule getAtl_atlRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern#getAtl_atlRule <em>Atl atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Rule</em>' reference.
	 * @see #getAtl_atlRule()
	 * @generated
	 */
	void setAtl_atlRule(MatchedRule value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapOutPattern_Qvtr_qvtrRelation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Relation getQvtr_qvtrRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern#getQvtr_qvtrRelation <em>Qvtr qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Relation</em>' reference.
	 * @see #getQvtr_qvtrRelation()
	 * @generated
	 */
	void setQvtr_qvtrRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Typed Model</em>' reference.
	 * @see #setQvtr_qvtrTypedModel(TypedModel)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapOutPattern_Qvtr_qvtrTypedModel()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	TypedModel getQvtr_qvtrTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOutPattern#getQvtr_qvtrTypedModel <em>Qvtr qvtr Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Typed Model</em>' reference.
	 * @see #getQvtr_qvtrTypedModel()
	 * @generated
	 */
	void setQvtr_qvtrTypedModel(TypedModel value);

} // TC_mapOutPattern
