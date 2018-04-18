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

import org.eclipse.m2m.atl.common.OCL.OclExpression;
import org.eclipse.m2m.atl.common.OCL.OperationCallExp;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.runtime.qvttrace.Execution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tmap Operation Call Exp argument</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT1atlArgument <em>T1atl Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT1atlParent <em>T1atl Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT2qvtrArgument <em>T2qvtr Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT2qvtrParent <em>T2qvtr Parent</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression1 <em>Wmap Ocl Expression1</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOperationCallExp_argument()
 * @model
 * @generated
 */
public interface TmapOperationCallExp_argument extends Execution {
	/**
	 * Returns the value of the '<em><b>T1atl Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Argument</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Argument</em>' reference.
	 * @see #setT1atlArgument(OclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOperationCallExp_argument_T1atlArgument()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapOperationCallExp_argument'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclExpression getT1atlArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT1atlArgument <em>T1atl Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Argument</em>' reference.
	 * @see #getT1atlArgument()
	 * @generated
	 */
	void setT1atlArgument(OclExpression value);

	/**
	 * Returns the value of the '<em><b>T1atl Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T1atl Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T1atl Parent</em>' reference.
	 * @see #setT1atlParent(OperationCallExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOperationCallExp_argument_T1atlParent()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OperationCallExp getT1atlParent();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT1atlParent <em>T1atl Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T1atl Parent</em>' reference.
	 * @see #getT1atlParent()
	 * @generated
	 */
	void setT1atlParent(OperationCallExp value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Argument</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Argument</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Argument</em>' reference.
	 * @see #setT2qvtrArgument(OCLExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOperationCallExp_argument_T2qvtrArgument()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TmapOperationCallExp_argument'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	OCLExpression getT2qvtrArgument();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT2qvtrArgument <em>T2qvtr Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Argument</em>' reference.
	 * @see #getT2qvtrArgument()
	 * @generated
	 */
	void setT2qvtrArgument(OCLExpression value);

	/**
	 * Returns the value of the '<em><b>T2qvtr Parent</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>T2qvtr Parent</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>T2qvtr Parent</em>' reference.
	 * @see #setT2qvtrParent(org.eclipse.ocl.pivot.OperationCallExp)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOperationCallExp_argument_T2qvtrParent()
	 * @model required="true"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.OperationCallExp getT2qvtrParent();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getT2qvtrParent <em>T2qvtr Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>T2qvtr Parent</em>' reference.
	 * @see #getT2qvtrParent()
	 * @generated
	 */
	void setT2qvtrParent(org.eclipse.ocl.pivot.OperationCallExp value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOperationCallExp_argument_WmapOclExpression()
	 * @model
	 * @generated
	 */
	DmapOclExpression getWmapOclExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression <em>Wmap Ocl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Ocl Expression</em>' reference.
	 * @see #getWmapOclExpression()
	 * @generated
	 */
	void setWmapOclExpression(DmapOclExpression value);

	/**
	 * Returns the value of the '<em><b>Wmap Ocl Expression1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Wmap Ocl Expression1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wmap Ocl Expression1</em>' reference.
	 * @see #setWmapOclExpression1(DmapOclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage#getTmapOperationCallExp_argument_WmapOclExpression1()
	 * @model
	 * @generated
	 */
	DmapOclExpression getWmapOclExpression1();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_argument#getWmapOclExpression1 <em>Wmap Ocl Expression1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wmap Ocl Expression1</em>' reference.
	 * @see #getWmapOclExpression1()
	 * @generated
	 */
	void setWmapOclExpression1(DmapOclExpression value);

} // TmapOperationCallExp_argument
