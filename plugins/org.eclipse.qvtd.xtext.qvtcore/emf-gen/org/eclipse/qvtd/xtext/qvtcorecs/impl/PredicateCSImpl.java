/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtcorecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;

import org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl;

import org.eclipse.qvtd.xtext.qvtcorecs.PredicateCS;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;

import org.eclipse.qvtd.xtext.qvtcorecs.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateCSImpl#getOwnedCondition <em>Owned Condition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PredicateCSImpl extends ExpCSImpl implements PredicateCS {
	/**
	 * The number of structural features of the '<em>Predicate CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PREDICATE_CS_FEATURE_COUNT = ExpCSImpl.EXP_CS_FEATURE_COUNT + 1;
	/**
	 * The cached value of the '{@link #getOwnedCondition() <em>Owned Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedCondition()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedCondition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreCSPackage.Literals.PREDICATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedCondition() {
		return ownedCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedCondition(ExpCS newOwnedCondition, NotificationChain msgs) {
		ExpCS oldOwnedCondition = ownedCondition;
		ownedCondition = newOwnedCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 0, oldOwnedCondition, newOwnedCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedCondition(ExpCS newOwnedCondition) {
		if (newOwnedCondition != ownedCondition) {
			NotificationChain msgs = null;
			if (ownedCondition != null)
				msgs = ((InternalEObject)ownedCondition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 0), null, msgs);
			if (newOwnedCondition != null)
				msgs = ((InternalEObject)newOwnedCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 0), null, msgs);
			msgs = basicSetOwnedCondition(newOwnedCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 0, newOwnedCondition, newOwnedCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				return basicSetOwnedCondition(null, msgs);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				return getOwnedCondition();
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				setOwnedCondition((ExpCS)newValue);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				setOwnedCondition((ExpCS)null);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 0:
				return ownedCondition != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		if (visitor instanceof QVTcoreCSVisitor) {
			return (R) ((QVTcoreCSVisitor<?>)visitor).visitPredicateCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //PredicateCSImpl
