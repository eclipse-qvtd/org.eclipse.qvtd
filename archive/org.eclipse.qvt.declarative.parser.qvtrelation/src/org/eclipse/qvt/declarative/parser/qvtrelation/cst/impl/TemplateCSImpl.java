/*******************************************************************************
 * Copyright (c) 2007 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.cst.OCLExpressionCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.TemplateCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.TemplateCSImpl#getGuardExpression <em>Guard Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class TemplateCSImpl extends TemplateVariableCSImpl implements TemplateCS {
	/**
	 * The cached value of the '{@link #getGuardExpression() <em>Guard Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpressionCS guardExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TemplateCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrCSTPackage.Literals.TEMPLATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpressionCS getGuardExpression() {
		return guardExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardExpression(OCLExpressionCS newGuardExpression, NotificationChain msgs) {
		OCLExpressionCS oldGuardExpression = guardExpression;
		guardExpression = newGuardExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.TEMPLATE_CS__GUARD_EXPRESSION, oldGuardExpression, newGuardExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardExpression(OCLExpressionCS newGuardExpression) {
		if (newGuardExpression != guardExpression) {
			NotificationChain msgs = null;
			if (guardExpression != null)
				msgs = ((InternalEObject)guardExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.TEMPLATE_CS__GUARD_EXPRESSION, null, msgs);
			if (newGuardExpression != null)
				msgs = ((InternalEObject)newGuardExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrCSTPackage.TEMPLATE_CS__GUARD_EXPRESSION, null, msgs);
			msgs = basicSetGuardExpression(newGuardExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.TEMPLATE_CS__GUARD_EXPRESSION, newGuardExpression, newGuardExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.TEMPLATE_CS__GUARD_EXPRESSION:
				return basicSetGuardExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTrCSTPackage.TEMPLATE_CS__GUARD_EXPRESSION:
				return getGuardExpression();
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
			case QVTrCSTPackage.TEMPLATE_CS__GUARD_EXPRESSION:
				setGuardExpression((OCLExpressionCS)newValue);
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
			case QVTrCSTPackage.TEMPLATE_CS__GUARD_EXPRESSION:
				setGuardExpression((OCLExpressionCS)null);
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
			case QVTrCSTPackage.TEMPLATE_CS__GUARD_EXPRESSION:
				return guardExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //TemplateCSImpl
