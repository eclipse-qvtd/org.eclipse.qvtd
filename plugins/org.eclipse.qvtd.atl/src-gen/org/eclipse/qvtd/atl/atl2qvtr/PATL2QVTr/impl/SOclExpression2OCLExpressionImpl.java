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
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.SOclExpression2OCLExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SOcl Expression2 OCL Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SOclExpression2OCLExpressionImpl#getAExpression <em>AExpression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.SOclExpression2OCLExpressionImpl#getRExpression <em>RExpression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SOclExpression2OCLExpressionImpl extends MinimalEObjectImpl.Container implements SOclExpression2OCLExpression {
	/**
	 * The cached value of the '{@link #getAExpression() <em>AExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression aExpression;

	/**
	 * The cached value of the '{@link #getRExpression() <em>RExpression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression rExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SOclExpression2OCLExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PATL2QVTrPackage.Literals.SOCL_EXPRESSION2_OCL_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getAExpression() {
		if (aExpression != null && aExpression.eIsProxy()) {
			InternalEObject oldAExpression = (InternalEObject)aExpression;
			aExpression = (OclExpression)eResolveProxy(oldAExpression);
			if (aExpression != oldAExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION, oldAExpression, aExpression));
			}
		}
		return aExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetAExpression() {
		return aExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAExpression(OclExpression newAExpression) {
		OclExpression oldAExpression = aExpression;
		aExpression = newAExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION, oldAExpression, aExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getRExpression() {
		if (rExpression != null && rExpression.eIsProxy()) {
			InternalEObject oldRExpression = (InternalEObject)rExpression;
			rExpression = (OCLExpression)eResolveProxy(oldRExpression);
			if (rExpression != oldRExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION, oldRExpression, rExpression));
			}
		}
		return rExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetRExpression() {
		return rExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRExpression(OCLExpression newRExpression) {
		OCLExpression oldRExpression = rExpression;
		rExpression = newRExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION, oldRExpression, rExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION:
				if (resolve) return getAExpression();
				return basicGetAExpression();
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION:
				if (resolve) return getRExpression();
				return basicGetRExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION:
				setAExpression((OclExpression)newValue);
				return;
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION:
				setRExpression((OCLExpression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION:
				setAExpression((OclExpression)null);
				return;
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION:
				setRExpression((OCLExpression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__AEXPRESSION:
				return aExpression != null;
			case PATL2QVTrPackage.SOCL_EXPRESSION2_OCL_EXPRESSION__REXPRESSION:
				return rExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //SOclExpression2OCLExpressionImpl
