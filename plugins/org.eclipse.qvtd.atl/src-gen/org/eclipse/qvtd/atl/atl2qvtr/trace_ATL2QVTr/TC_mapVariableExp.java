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

import org.eclipse.m2m.atl.common.OCL.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TC map Variable Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp#getAtl_atlVariable <em>Atl atl Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp#getInvocation_mapVariableExp_referredVariable <em>Invocation map Variable Exp referred Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp#getPrimitive_varName <em>Primitive var Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp()
 * @model
 * @generated
 */
public interface TC_mapVariableExp extends TI_mapVariableExp {
	/**
	 * Returns the value of the '<em><b>Atl atl Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Atl atl Variable</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Atl atl Variable</em>' reference.
	 * @see #setAtl_atlVariable(VariableDeclaration)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_Atl_atlVariable()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	VariableDeclaration getAtl_atlVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp#getAtl_atlVariable <em>Atl atl Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Atl atl Variable</em>' reference.
	 * @see #getAtl_atlVariable()
	 * @generated
	 */
	void setAtl_atlVariable(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Invocation map Variable Exp referred Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Invocation map Variable Exp referred Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Invocation map Variable Exp referred Variable</em>' containment reference.
	 * @see #setInvocation_mapVariableExp_referredVariable(WC_mapVariableExp_referredVariable)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_Invocation_mapVariableExp_referredVariable()
	 * @model containment="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TC_mapVariableExp' unique='false' upper='*'"
	 * @generated
	 */
	WC_mapVariableExp_referredVariable getInvocation_mapVariableExp_referredVariable();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp#getInvocation_mapVariableExp_referredVariable <em>Invocation map Variable Exp referred Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Invocation map Variable Exp referred Variable</em>' containment reference.
	 * @see #getInvocation_mapVariableExp_referredVariable()
	 * @generated
	 */
	void setInvocation_mapVariableExp_referredVariable(WC_mapVariableExp_referredVariable value);

	/**
	 * Returns the value of the '<em><b>Primitive var Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Primitive var Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive var Name</em>' attribute.
	 * @see #setPrimitive_varName(String)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTC_mapVariableExp_Primitive_varName()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='$primitive$'"
	 * @generated
	 */
	String getPrimitive_varName();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariableExp#getPrimitive_varName <em>Primitive var Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive var Name</em>' attribute.
	 * @see #getPrimitive_varName()
	 * @generated
	 */
	void setPrimitive_varName(String value);

} // TC_mapVariableExp
