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
import org.eclipse.m2m.atl.common.ATL.OutPattern;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;

import org.eclipse.qvtd.runtime.qvttrace.Execution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap Out Pattern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getSuccess <em>Success</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT1atlPattern <em>T1atl Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT1atlRule <em>T1atl Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrDomain <em>T2qvtr Domain</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrRelation <em>T2qvtr Relation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getWmapMatchedRule <em>Wmap Matched Rule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOutPattern()
 * @model
 * @generated
 */
public interface TmapOutPattern extends Execution {
	/**
	 * Returns the value of the '<em><b>Success</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Success</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Success</em>' attribute.
	 * @see #setSuccess(Boolean)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOutPattern_Success()
	 * @model
	 * @generated
	 */
	Boolean getSuccess();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getSuccess <em>Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Success</em>' attribute.
	 * @see #getSuccess()
	 * @generated
	 */
	void setSuccess(Boolean value);

	/**
	 * Returns the value of the '<em><b>T1atl Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Pattern</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Pattern</em>' reference.
	 * @see #setT1atlPattern(OutPattern)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOutPattern_T1atlPattern()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapOutPattern'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OutPattern getT1atlPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT1atlPattern <em>T1atl Pattern</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Pattern</em>' reference.
	 * @see #getT1atlPattern()
	 * @generated
	 */
	void setT1atlPattern(OutPattern value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOutPattern_T1atlRule()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	MatchedRule getT1atlRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT1atlRule <em>T1atl Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Rule</em>' reference.
	 * @see #getT1atlRule()
	 * @generated
	 */
	void setT1atlRule(MatchedRule value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOutPattern_T2qvtrDomain()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapOutPattern'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	RelationDomain getT2qvtrDomain();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrDomain <em>T2qvtr Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Domain</em>' reference.
	 * @see #getT2qvtrDomain()
	 * @generated
	 */
	void setT2qvtrDomain(RelationDomain value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOutPattern_T2qvtrRelation()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	Relation getT2qvtrRelation();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrRelation <em>T2qvtr Relation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Relation</em>' reference.
	 * @see #getT2qvtrRelation()
	 * @generated
	 */
	void setT2qvtrRelation(Relation value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Typed Model</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Typed Model</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Typed Model</em>' reference.
	 * @see #setT2qvtrTypedModel(TypedModel)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOutPattern_T2qvtrTypedModel()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	TypedModel getT2qvtrTypedModel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Typed Model</em>' reference.
	 * @see #getT2qvtrTypedModel()
	 * @generated
	 */
	void setT2qvtrTypedModel(TypedModel value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOutPattern_WmapMatchedRule()
	 * @model
	 * @generated
	 */
	TmapMatchedRule getWmapMatchedRule();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getWmapMatchedRule <em>Wmap Matched Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Matched Rule</em>' reference.
	 * @see #getWmapMatchedRule()
	 * @generated
	 */
	void setWmapMatchedRule(TmapMatchedRule value);

	/**
	 * Returns the value of the '<em><b>Wmap Ocl Metamodel</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Ocl Metamodel</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Ocl Metamodel</em>' reference.
	 * @see #setWmapOclMetamodel(TmapOclMetamodel)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOutPattern_WmapOclMetamodel()
	 * @model
	 * @generated
	 */
	TmapOclMetamodel getWmapOclMetamodel();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOutPattern#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Ocl Metamodel</em>' reference.
	 * @see #getWmapOclMetamodel()
	 * @generated
	 */
	void setWmapOclMetamodel(TmapOclMetamodel value);

} // TmapOutPattern
