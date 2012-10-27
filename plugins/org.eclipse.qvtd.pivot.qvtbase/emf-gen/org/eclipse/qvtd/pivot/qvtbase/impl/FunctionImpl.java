/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.pivot.qvtbase.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.internal.impl.OperationImpl;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.FunctionImpl#getQueryExpression <em>Query Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FunctionImpl extends OperationImpl implements Function {
	/**
	 * The cached value of the '{@link #getQueryExpression() <em>Query Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQueryExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression queryExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getQueryExpression() {
		return queryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetQueryExpression(OCLExpression newQueryExpression, NotificationChain msgs) {
		OCLExpression oldQueryExpression = queryExpression;
		queryExpression = newQueryExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTbasePackage.FUNCTION__QUERY_EXPRESSION, oldQueryExpression, newQueryExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQueryExpression(OCLExpression newQueryExpression) {
		if (newQueryExpression != queryExpression) {
			NotificationChain msgs = null;
			if (queryExpression != null)
				msgs = ((InternalEObject)queryExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTbasePackage.FUNCTION__QUERY_EXPRESSION, null, msgs);
			if (newQueryExpression != null)
				msgs = ((InternalEObject)newQueryExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTbasePackage.FUNCTION__QUERY_EXPRESSION, null, msgs);
			msgs = basicSetQueryExpression(newQueryExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTbasePackage.FUNCTION__QUERY_EXPRESSION, newQueryExpression, newQueryExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTbasePackage.FUNCTION__QUERY_EXPRESSION:
				return basicSetQueryExpression(null, msgs);
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
			case QVTbasePackage.FUNCTION__QUERY_EXPRESSION:
				return getQueryExpression();
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
			case QVTbasePackage.FUNCTION__QUERY_EXPRESSION:
				setQueryExpression((OCLExpression)newValue);
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
			case QVTbasePackage.FUNCTION__QUERY_EXPRESSION:
				setQueryExpression((OCLExpression)null);
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
			case QVTbasePackage.FUNCTION__QUERY_EXPRESSION:
				return queryExpression != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return ((QVTbaseVisitor<R>)visitor).visitFunction(this);
	}
} //FunctionImpl
