/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TIn Pattern2 Relation Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getAPattern <em>APattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getARule <em>ARule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getRDomain <em>RDomain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getRRule <em>RRule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getTmName <em>Tm Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getWhere_InPattern2RelationDomain_guard <em>Where In Pattern2 Relation Domain guard</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain()
 * @model
 * @generated
 */
public interface TInPattern2RelationDomain extends EObject {
	/**
	 * Returns the value of the '<em><b>APattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>APattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>APattern</em>' reference.
	 * @see #setAPattern(InPattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_APattern()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TInPattern2RelationDomain'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	InPattern getAPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getAPattern <em>APattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>APattern</em>' reference.
	 * @see #getAPattern()
	 * @generated
	 */
	void setAPattern(InPattern value);

	/**
	 * Returns the value of the '<em><b>ARule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>ARule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>ARule</em>' reference.
	 * @see #setARule(MatchedRule)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_ARule()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TInPattern2RelationDomain'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	MatchedRule getARule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getARule <em>ARule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>ARule</em>' reference.
	 * @see #getARule()
	 * @generated
	 */
	void setARule(MatchedRule value);

	/**
	 * Returns the value of the '<em><b>RDomain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>RDomain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>RDomain</em>' reference.
	 * @see #setRDomain(RelationDomain)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_RDomain()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TInPattern2RelationDomain'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationDomain getRDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getRDomain <em>RDomain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RDomain</em>' reference.
	 * @see #getRDomain()
	 * @generated
	 */
	void setRDomain(RelationDomain value);

	/**
	 * Returns the value of the '<em><b>RRule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>RRule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>RRule</em>' reference.
	 * @see #setRRule(Relation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_RRule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Relation getRRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getRRule <em>RRule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RRule</em>' reference.
	 * @see #getRRule()
	 * @generated
	 */
	void setRRule(Relation value);

	/**
	 * Returns the value of the '<em><b>Tm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tm Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tm Name</em>' attribute.
	 * @see #setTmName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_TmName()
	 * @model required="true"
	 * @generated
	 */
	String getTmName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getTmName <em>Tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tm Name</em>' attribute.
	 * @see #getTmName()
	 * @generated
	 */
	void setTmName(String value);

	/**
	 * Returns the value of the '<em><b>Where In Pattern2 Relation Domain guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Where In Pattern2 Relation Domain guard</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Where In Pattern2 Relation Domain guard</em>' reference.
	 * @see #setWhere_InPattern2RelationDomain_guard(SInPattern2RelationDomain_guard)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_Where_InPattern2RelationDomain_guard()
	 * @model
	 * @generated
	 */
	SInPattern2RelationDomain_guard getWhere_InPattern2RelationDomain_guard();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain#getWhere_InPattern2RelationDomain_guard <em>Where In Pattern2 Relation Domain guard</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Where In Pattern2 Relation Domain guard</em>' reference.
	 * @see #getWhere_InPattern2RelationDomain_guard()
	 * @generated
	 */
	void setWhere_InPattern2RelationDomain_guard(SInPattern2RelationDomain_guard value);

} // TInPattern2RelationDomain
