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

import org.eclipse.m2m.atl.common.ATL.InPattern;
import org.eclipse.m2m.atl.common.ATL.MatchedRule;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

import org.eclipse.qvtd.runtime.qvttrace.Execution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap In Pattern filter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlExpression <em>T1atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlPattern <em>T1atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlRule <em>T1atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2p <em>T2p</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrDomain <em>T2qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrExpression <em>T2qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrRelation <em>T2qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2w <em>T2w</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapInPattern <em>Wmap In Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapMatchedRule <em>Wmap Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter()
 * @model
 * @generated
 */
public interface TmapInPattern_filter extends Execution {
	/**
	 * Returns the value of the '<em><b>T1atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Expression</em>' reference.
	 * @see #setT1atlExpression(OclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_T1atlExpression()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclExpression getT1atlExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlExpression <em>T1atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Expression</em>' reference.
	 * @see #getT1atlExpression()
	 * @generated
	 */
	void setT1atlExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>T1atl Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Pattern</em>' reference.
	 * @see #setT1atlPattern(InPattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_T1atlPattern()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapInPattern_filter'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	InPattern getT1atlPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlPattern <em>T1atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Pattern</em>' reference.
	 * @see #getT1atlPattern()
	 * @generated
	 */
	void setT1atlPattern(InPattern value);

	/**
	 * Returns the value of the '<em><b>T1atl Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Rule</em>' reference.
	 * @see #setT1atlRule(MatchedRule)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_T1atlRule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	MatchedRule getT1atlRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT1atlRule <em>T1atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Rule</em>' reference.
	 * @see #getT1atlRule()
	 * @generated
	 */
	void setT1atlRule(MatchedRule value);

	/**
	 * Returns the value of the '<em><b>T2p</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2p</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2p</em>' reference.
	 * @see #setT2p(Predicate)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_T2p()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Predicate getT2p();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2p <em>T2p</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2p</em>' reference.
	 * @see #getT2p()
	 * @generated
	 */
	void setT2p(Predicate value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Domain</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Domain</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Domain</em>' reference.
	 * @see #setT2qvtrDomain(RelationDomain)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_T2qvtrDomain()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapInPattern_filter'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationDomain getT2qvtrDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrDomain <em>T2qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Domain</em>' reference.
	 * @see #getT2qvtrDomain()
	 * @generated
	 */
	void setT2qvtrDomain(RelationDomain value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Expression</em>' reference.
	 * @see #setT2qvtrExpression(OCLExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_T2qvtrExpression()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	OCLExpression getT2qvtrExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrExpression <em>T2qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Expression</em>' reference.
	 * @see #getT2qvtrExpression()
	 * @generated
	 */
	void setT2qvtrExpression(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Relation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Relation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Relation</em>' reference.
	 * @see #setT2qvtrRelation(Relation)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_T2qvtrRelation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Relation getT2qvtrRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2qvtrRelation <em>T2qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Relation</em>' reference.
	 * @see #getT2qvtrRelation()
	 * @generated
	 */
	void setT2qvtrRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>T2w</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2w</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2w</em>' reference.
	 * @see #setT2w(Pattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_T2w()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Pattern getT2w();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getT2w <em>T2w</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2w</em>' reference.
	 * @see #getT2w()
	 * @generated
	 */
	void setT2w(Pattern value);

	/**
	 * Returns the value of the '<em><b>Wmap In Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap In Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap In Pattern</em>' reference.
	 * @see #setWmapInPattern(TmapInPattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_WmapInPattern()
	 * @model
	 * @generated
	 */
	TmapInPattern getWmapInPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapInPattern <em>Wmap In Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap In Pattern</em>' reference.
	 * @see #getWmapInPattern()
	 * @generated
	 */
	void setWmapInPattern(TmapInPattern value);

	/**
	 * Returns the value of the '<em><b>Wmap Matched Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Matched Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Matched Rule</em>' reference.
	 * @see #setWmapMatchedRule(TmapMatchedRule)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_WmapMatchedRule()
	 * @model
	 * @generated
	 */
	TmapMatchedRule getWmapMatchedRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapMatchedRule <em>Wmap Matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Matched Rule</em>' reference.
	 * @see #getWmapMatchedRule()
	 * @generated
	 */
	void setWmapMatchedRule(TmapMatchedRule value);

	/**
	 * Returns the value of the '<em><b>Wmap Ocl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Ocl Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Ocl Expression</em>' reference.
	 * @see #setWmapOclExpression(DmapOclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapInPattern_filter_WmapOclExpression()
	 * @model
	 * @generated
	 */
	DmapOclExpression getWmapOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapInPattern_filter#getWmapOclExpression <em>Wmap Ocl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Ocl Expression</em>' reference.
	 * @see #getWmapOclExpression()
	 * @generated
	 */
	void setWmapOclExpression(DmapOclExpression value);

} // TmapInPattern_filter
