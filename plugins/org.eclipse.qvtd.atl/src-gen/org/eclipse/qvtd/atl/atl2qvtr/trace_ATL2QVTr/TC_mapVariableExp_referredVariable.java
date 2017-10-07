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

import org.eclipse.m2m.atl.common.OCL.VariableExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC map Variable Exp referred Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable#getAtl_atlExpression1 <em>Atl atl Expression1</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable#getQvtr_qvtrExpression1 <em>Qvtr qvtr Expression1</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_referredVariable()
 * @model
 * @generated
 */
public interface TC_mapVariableExp_referredVariable extends TI_mapVariableExp_referredVariable {
	/**
	 * Returns the value of the '<em><b>Atl atl Expression1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Expression1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Expression1</em>' reference.
	 * @see #setAtl_atlExpression1(VariableExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_referredVariable_Atl_atlExpression1()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapVariableExp_referredVariable'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	VariableExp getAtl_atlExpression1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable#getAtl_atlExpression1 <em>Atl atl Expression1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Expression1</em>' reference.
	 * @see #getAtl_atlExpression1()
	 * @generated
	 */
	void setAtl_atlExpression1(VariableExp value);

	/**
	 * Returns the value of the '<em><b>Qvtr qvtr Expression1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qvtr qvtr Expression1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qvtr qvtr Expression1</em>' reference.
	 * @see #setQvtr_qvtrExpression1(org.eclipse.ocl.pivot.VariableExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_referredVariable_Qvtr_qvtrExpression1()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapVariableExp_referredVariable'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.VariableExp getQvtr_qvtrExpression1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp_referredVariable#getQvtr_qvtrExpression1 <em>Qvtr qvtr Expression1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qvtr qvtr Expression1</em>' reference.
	 * @see #getQvtr_qvtrExpression1()
	 * @generated
	 */
	void setQvtr_qvtrExpression1(org.eclipse.ocl.pivot.VariableExp value);

} // TC_mapVariableExp_referredVariable
