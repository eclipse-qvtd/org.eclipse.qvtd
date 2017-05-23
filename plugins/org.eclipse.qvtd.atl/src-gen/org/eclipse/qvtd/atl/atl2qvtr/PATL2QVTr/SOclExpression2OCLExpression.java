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

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SOcl Expression2 OCL Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression#getAExpression <em>AExpression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression#getRExpression <em>RExpression</em>}</li>
 * </ul>
 *
 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getSOclExpression2OCLExpression()
 * @model
 * @generated
 */
public interface SOclExpression2OCLExpression extends EObject {
	/**
	 * Returns the value of the '<em><b>AExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>AExpression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>AExpression</em>' reference.
	 * @see #setAExpression(OclExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getSOclExpression2OCLExpression_AExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SOclExpression2OCLExpression'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='atl'"
	 * @generated
	 */
	OclExpression getAExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression#getAExpression <em>AExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>AExpression</em>' reference.
	 * @see #getAExpression()
	 * @generated
	 */
	void setAExpression(OclExpression value);

	/**
	 * Returns the value of the '<em><b>RExpression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>RExpression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>RExpression</em>' reference.
	 * @see #setRExpression(OCLExpression)
	 * @see org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage#getSOclExpression2OCLExpression_RExpression()
	 * @model required="true"
	 *        annotation="http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName body='SOclExpression2OCLExpression'"
	 *        annotation="http://www.eclipse.org/qvt#Domains referredDomain='qvtr'"
	 * @generated
	 */
	OCLExpression getRExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression#getRExpression <em>RExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>RExpression</em>' reference.
	 * @see #getRExpression()
	 * @generated
	 */
	void setRExpression(OCLExpression value);

} // SOclExpression2OCLExpression
