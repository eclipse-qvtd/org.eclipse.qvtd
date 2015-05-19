/*******************************************************************************
 * Copyright (c) 2012, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorebasecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AreaCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.BottomPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.GuardPatternCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Area CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.AreaCSImpl#getOwnedGuardPattern <em>Owned Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.AreaCSImpl#getOwnedBottomPattern <em>Owned Bottom Pattern</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AreaCSImpl extends NamedElementCSImpl implements AreaCS {
	/**
	 * The cached value of the '{@link #getOwnedGuardPattern() <em>Owned Guard Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedGuardPattern()
	 * @generated
	 * @ordered
	 */
	protected GuardPatternCS ownedGuardPattern;

	/**
	 * The cached value of the '{@link #getOwnedBottomPattern() <em>Owned Bottom Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedBottomPattern()
	 * @generated
	 * @ordered
	 */
	protected BottomPatternCS ownedBottomPattern;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AreaCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreBaseCSPackage.Literals.AREA_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GuardPatternCS getOwnedGuardPattern() {
		return ownedGuardPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedGuardPattern(GuardPatternCS newOwnedGuardPattern, NotificationChain msgs) {
		GuardPatternCS oldOwnedGuardPattern = ownedGuardPattern;
		ownedGuardPattern = newOwnedGuardPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.AREA_CS__OWNED_GUARD_PATTERN, oldOwnedGuardPattern, newOwnedGuardPattern);
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
	public void setOwnedGuardPattern(GuardPatternCS newOwnedGuardPattern) {
		if (newOwnedGuardPattern != ownedGuardPattern) {
			NotificationChain msgs = null;
			if (ownedGuardPattern != null)
				msgs = ((InternalEObject)ownedGuardPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.AREA_CS__OWNED_GUARD_PATTERN, null, msgs);
			if (newOwnedGuardPattern != null)
				msgs = ((InternalEObject)newOwnedGuardPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.AREA_CS__OWNED_GUARD_PATTERN, null, msgs);
			msgs = basicSetOwnedGuardPattern(newOwnedGuardPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.AREA_CS__OWNED_GUARD_PATTERN, newOwnedGuardPattern, newOwnedGuardPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BottomPatternCS getOwnedBottomPattern() {
		return ownedBottomPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedBottomPattern(BottomPatternCS newOwnedBottomPattern, NotificationChain msgs) {
		BottomPatternCS oldOwnedBottomPattern = ownedBottomPattern;
		ownedBottomPattern = newOwnedBottomPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.AREA_CS__OWNED_BOTTOM_PATTERN, oldOwnedBottomPattern, newOwnedBottomPattern);
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
	public void setOwnedBottomPattern(BottomPatternCS newOwnedBottomPattern) {
		if (newOwnedBottomPattern != ownedBottomPattern) {
			NotificationChain msgs = null;
			if (ownedBottomPattern != null)
				msgs = ((InternalEObject)ownedBottomPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.AREA_CS__OWNED_BOTTOM_PATTERN, null, msgs);
			if (newOwnedBottomPattern != null)
				msgs = ((InternalEObject)newOwnedBottomPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.AREA_CS__OWNED_BOTTOM_PATTERN, null, msgs);
			msgs = basicSetOwnedBottomPattern(newOwnedBottomPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.AREA_CS__OWNED_BOTTOM_PATTERN, newOwnedBottomPattern, newOwnedBottomPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_GUARD_PATTERN:
				return basicSetOwnedGuardPattern(null, msgs);
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_BOTTOM_PATTERN:
				return basicSetOwnedBottomPattern(null, msgs);
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
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_GUARD_PATTERN:
				return getOwnedGuardPattern();
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_BOTTOM_PATTERN:
				return getOwnedBottomPattern();
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
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_GUARD_PATTERN:
				setOwnedGuardPattern((GuardPatternCS)newValue);
				return;
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_BOTTOM_PATTERN:
				setOwnedBottomPattern((BottomPatternCS)newValue);
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
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_GUARD_PATTERN:
				setOwnedGuardPattern((GuardPatternCS)null);
				return;
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_BOTTOM_PATTERN:
				setOwnedBottomPattern((BottomPatternCS)null);
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
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_GUARD_PATTERN:
				return ownedGuardPattern != null;
			case QVTcoreBaseCSPackage.AREA_CS__OWNED_BOTTOM_PATTERN:
				return ownedBottomPattern != null;
		}
		return super.eIsSet(featureID);
	}
} //AreaCSImpl
