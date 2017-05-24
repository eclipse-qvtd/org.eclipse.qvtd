/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
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

import org.eclipse.m2m.atl.common.OCL.OperationCallExp;

import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TIn Pattern2 Relation Domain guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getAExpression <em>AExpression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getAPattern <em>APattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getP <em>P</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getRExpression <em>RExpression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getRRule <em>RRule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getW <em>W</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getWhen_OclExpression2OCLExpression <em>When Ocl Expression2 OCL Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_guard()
 * @model
 * @generated
 */
public interface TInPattern2RelationDomain_guard extends EObject {
	/**
	 * Returns the value of the '<em><b>AExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>AExpression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>AExpression</em>' reference.
	 * @see #setAExpression(OperationCallExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_guard_AExpression()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OperationCallExp getAExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getAExpression <em>AExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AExpression</em>' reference.
	 * @see #getAExpression()
	 * @generated
	 */
	void setAExpression(OperationCallExp value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_guard_APattern()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	InPattern getAPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getAPattern <em>APattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>APattern</em>' reference.
	 * @see #getAPattern()
	 * @generated
	 */
	void setAPattern(InPattern value);

	/**
	 * Returns the value of the '<em><b>P</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>P</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>P</em>' reference.
	 * @see #setP(Predicate)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_guard_P()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Predicate getP();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getP <em>P</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>P</em>' reference.
	 * @see #getP()
	 * @generated
	 */
	void setP(Predicate value);

	/**
	 * Returns the value of the '<em><b>RExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>RExpression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>RExpression</em>' reference.
	 * @see #setRExpression(org.eclipse.ocl.pivot.OperationCallExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_guard_RExpression()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.OperationCallExp getRExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getRExpression <em>RExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RExpression</em>' reference.
	 * @see #getRExpression()
	 * @generated
	 */
	void setRExpression(org.eclipse.ocl.pivot.OperationCallExp value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_guard_RRule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Relation getRRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getRRule <em>RRule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RRule</em>' reference.
	 * @see #getRRule()
	 * @generated
	 */
	void setRRule(Relation value);

	/**
	 * Returns the value of the '<em><b>W</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>W</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>W</em>' reference.
	 * @see #setW(Pattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_guard_W()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Pattern getW();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getW <em>W</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>W</em>' reference.
	 * @see #getW()
	 * @generated
	 */
	void setW(Pattern value);

	/**
	 * Returns the value of the '<em><b>When Ocl Expression2 OCL Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>When Ocl Expression2 OCL Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>When Ocl Expression2 OCL Expression</em>' reference.
	 * @see #setWhen_OclExpression2OCLExpression(TOclExpression2OCLExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTInPattern2RelationDomain_guard_When_OclExpression2OCLExpression()
	 * @model
	 * @generated
	 */
	TOclExpression2OCLExpression getWhen_OclExpression2OCLExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TInPattern2RelationDomain_guard#getWhen_OclExpression2OCLExpression <em>When Ocl Expression2 OCL Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>When Ocl Expression2 OCL Expression</em>' reference.
	 * @see #getWhen_OclExpression2OCLExpression()
	 * @generated
	 */
	void setWhen_OclExpression2OCLExpression(TOclExpression2OCLExpression value);

} // TInPattern2RelationDomain_guard
