/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
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

import org.eclipse.qvtd.xtext.qvtcorecs.PredicateOrAssignmentCS;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;

import org.eclipse.qvtd.xtext.qvtcorecs.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Predicate Or Assignment CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateOrAssignmentCSImpl#isIsDefault <em>Is Default</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateOrAssignmentCSImpl#isIsPartial <em>Is Partial</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateOrAssignmentCSImpl#getOwnedTarget <em>Owned Target</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.PredicateOrAssignmentCSImpl#getOwnedInitExpression <em>Owned Init Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PredicateOrAssignmentCSImpl extends ExpCSImpl implements PredicateOrAssignmentCS {
	/**
	 * The default value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDefault()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DEFAULT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDefault() <em>Is Default</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDefault()
	 * @generated
	 * @ordered
	 */
	protected boolean isDefault = IS_DEFAULT_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsPartial() <em>Is Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPartial()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_PARTIAL_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPartial() <em>Is Partial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPartial()
	 * @generated
	 * @ordered
	 */
	protected boolean isPartial = IS_PARTIAL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedTarget() <em>Owned Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTarget()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedTarget;

	/**
	 * The cached value of the '{@link #getOwnedInitExpression() <em>Owned Init Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInitExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedInitExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PredicateOrAssignmentCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreCSPackage.Literals.PREDICATE_OR_ASSIGNMENT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsDefault() {
		return isDefault;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsDefault(boolean newIsDefault) {
		boolean oldIsDefault = isDefault;
		isDefault = newIsDefault;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT, oldIsDefault, isDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsPartial() {
		return isPartial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsPartial(boolean newIsPartial) {
		boolean oldIsPartial = isPartial;
		isPartial = newIsPartial;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL, oldIsPartial, isPartial));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedTarget() {
		return ownedTarget;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedTarget(ExpCS newOwnedTarget, NotificationChain msgs) {
		ExpCS oldOwnedTarget = ownedTarget;
		ownedTarget = newOwnedTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, oldOwnedTarget, newOwnedTarget);
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
	public void setOwnedTarget(ExpCS newOwnedTarget) {
		if (newOwnedTarget != ownedTarget) {
			NotificationChain msgs = null;
			if (ownedTarget != null)
				msgs = ((InternalEObject)ownedTarget).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, null, msgs);
			if (newOwnedTarget != null)
				msgs = ((InternalEObject)newOwnedTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, null, msgs);
			msgs = basicSetOwnedTarget(newOwnedTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET, newOwnedTarget, newOwnedTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedInitExpression() {
		return ownedInitExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInitExpression(ExpCS newOwnedInitExpression, NotificationChain msgs) {
		ExpCS oldOwnedInitExpression = ownedInitExpression;
		ownedInitExpression = newOwnedInitExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION, oldOwnedInitExpression, newOwnedInitExpression);
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
	public void setOwnedInitExpression(ExpCS newOwnedInitExpression) {
		if (newOwnedInitExpression != ownedInitExpression) {
			NotificationChain msgs = null;
			if (ownedInitExpression != null)
				msgs = ((InternalEObject)ownedInitExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION, null, msgs);
			if (newOwnedInitExpression != null)
				msgs = ((InternalEObject)newOwnedInitExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION, null, msgs);
			msgs = basicSetOwnedInitExpression(newOwnedInitExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION, newOwnedInitExpression, newOwnedInitExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET:
				return basicSetOwnedTarget(null, msgs);
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION:
				return basicSetOwnedInitExpression(null, msgs);
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
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT:
				return isIsDefault();
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL:
				return isIsPartial();
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET:
				return getOwnedTarget();
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION:
				return getOwnedInitExpression();
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
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT:
				setIsDefault((Boolean)newValue);
				return;
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL:
				setIsPartial((Boolean)newValue);
				return;
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET:
				setOwnedTarget((ExpCS)newValue);
				return;
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION:
				setOwnedInitExpression((ExpCS)newValue);
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
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT:
				setIsDefault(IS_DEFAULT_EDEFAULT);
				return;
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL:
				setIsPartial(IS_PARTIAL_EDEFAULT);
				return;
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET:
				setOwnedTarget((ExpCS)null);
				return;
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION:
				setOwnedInitExpression((ExpCS)null);
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
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_DEFAULT:
				return isDefault != IS_DEFAULT_EDEFAULT;
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__IS_PARTIAL:
				return isPartial != IS_PARTIAL_EDEFAULT;
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_TARGET:
				return ownedTarget != null;
			case QVTcoreCSPackage.PREDICATE_OR_ASSIGNMENT_CS__OWNED_INIT_EXPRESSION:
				return ownedInitExpression != null;
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
		return (R) ((QVTcoreCSVisitor<?>)visitor).visitPredicateOrAssignmentCS(this);
	}

} //PredicateOrAssignmentCSImpl
