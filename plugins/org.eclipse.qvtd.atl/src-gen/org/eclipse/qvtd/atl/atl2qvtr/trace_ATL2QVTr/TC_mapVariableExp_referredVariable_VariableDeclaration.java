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
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr;

import org.eclipse.m2m.atl.common.ATL.PatternElement;

import org.eclipse.m2m.atl.common.OCL.VariableExp;

import org.eclipse.ocl.pivot.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC map Variable Exp referred Variable Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getAtl_atlExpression <em>Atl atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getAtl_atlVariable <em>Atl atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getInvocation_mapVariable <em>Invocation map Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getQvtr_qvtrExpression <em>Qvtr qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getQvtr_qvtrVariable <em>Qvtr qvtr Variable</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_referredVariable_VariableDeclaration()
 * @model
 * @generated
 */
public interface TC_mapVariableExp_referredVariable_VariableDeclaration extends TI_mapVariableExp_referredVariable_VariableDeclaration {
	/**
	 * Returns the value of the '<em><b>Atl atl Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Expression</em>' reference.
	 * @see #setAtl_atlExpression(VariableExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_referredVariable_VariableDeclaration_Atl_atlExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapVariableExp_referredVariable_VariableDeclaration'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	VariableExp getAtl_atlExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getAtl_atlExpression <em>Atl atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Expression</em>' reference.
	 * @see #getAtl_atlExpression()
	 * @generated
	 */
	void setAtl_atlExpression(VariableExp value);

	/**
	 * Returns the value of the '<em><b>Atl atl Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Variable</em>' reference.
	 * @see #setAtl_atlVariable(PatternElement)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_referredVariable_VariableDeclaration_Atl_atlVariable()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	PatternElement getAtl_atlVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getAtl_atlVariable <em>Atl atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Variable</em>' reference.
	 * @see #getAtl_atlVariable()
	 * @generated
	 */
	void setAtl_atlVariable(PatternElement value);

	/**
	 * Returns the value of the '<em><b>Invocation map Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation map Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation map Variable</em>' containment reference.
	 * @see #setInvocation_mapVariable(TC_mapVariable)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_referredVariable_VariableDeclaration_Invocation_mapVariable()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapVariableExp_referredVariable_VariableDeclaration' unique='false' upper='*'"
	 * @generated
	 */
	TC_mapVariable getInvocation_mapVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getInvocation_mapVariable <em>Invocation map Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocation map Variable</em>' containment reference.
	 * @see #getInvocation_mapVariable()
	 * @generated
	 */
	void setInvocation_mapVariable(TC_mapVariable value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Expression</em>' reference.
	 * @see #setQvtr_qvtrExpression(org.eclipse.ocl.pivot.VariableExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_referredVariable_VariableDeclaration_Qvtr_qvtrExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapVariableExp_referredVariable_VariableDeclaration'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.VariableExp getQvtr_qvtrExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getQvtr_qvtrExpression <em>Qvtr qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Expression</em>' reference.
	 * @see #getQvtr_qvtrExpression()
	 * @generated
	 */
	void setQvtr_qvtrExpression(org.eclipse.ocl.pivot.VariableExp value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Variable</em>' reference.
	 * @see #setQvtr_qvtrVariable(VariableDeclaration)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_referredVariable_VariableDeclaration_Qvtr_qvtrVariable()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	VariableDeclaration getQvtr_qvtrVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable_VariableDeclaration#getQvtr_qvtrVariable <em>Qvtr qvtr Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Variable</em>' reference.
	 * @see #getQvtr_qvtrVariable()
	 * @generated
	 */
	void setQvtr_qvtrVariable(VariableDeclaration value);

} // TC_mapVariableExp_referredVariable_VariableDeclaration
