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

import org.eclipse.m2m.atl.common.OCL.OperationCallExp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>TOperation Call Exp2 Operation Call Exp</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp#getAExpression <em>AExpression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp#getRExpression <em>RExpression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTOperationCallExp2OperationCallExp()
 * @model
 * @generated
 */
public interface TOperationCallExp2OperationCallExp extends EObject {
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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTOperationCallExp2OperationCallExp_AExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TOperationCallExp2OperationCallExp'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OperationCallExp getAExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp#getAExpression <em>AExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AExpression</em>' reference.
	 * @see #getAExpression()
	 * @generated
	 */
	void setAExpression(OperationCallExp value);

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
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getTOperationCallExp2OperationCallExp_RExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='TOperationCallExp2OperationCallExp'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	org.eclipse.ocl.pivot.OperationCallExp getRExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOperationCallExp2OperationCallExp#getRExpression <em>RExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RExpression</em>' reference.
	 * @see #getRExpression()
	 * @generated
	 */
	void setRExpression(org.eclipse.ocl.pivot.OperationCallExp value);

} // TOperationCallExp2OperationCallExp
