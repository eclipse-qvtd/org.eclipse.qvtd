/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: AreaCSImpl.java,v 1.2 2008/08/09 17:42:09 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtcore.cst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvt.declarative.parser.qvt.cst.impl.IdentifiedCSImpl;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.AreaCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.BottomPatternCS;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.QVTcCSTPackage;
import org.eclipse.qvt.declarative.parser.qvtcore.cst.GuardPatternCS;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Area CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AreaCSImpl#getGuardPattern <em>Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtcore.cst.impl.AreaCSImpl#getBottomPattern <em>Bottom Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AreaCSImpl extends IdentifiedCSImpl implements AreaCS {
	/**
	 * The cached value of the '{@link #getGuardPattern() <em>Guard Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardPattern()
	 * @generated
	 * @ordered
	 */
	protected GuardPatternCS guardPattern;

	/**
	 * The cached value of the '{@link #getBottomPattern() <em>Bottom Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottomPattern()
	 * @generated
	 * @ordered
	 */
	protected BottomPatternCS bottomPattern;

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
		return QVTcCSTPackage.Literals.AREA_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BottomPatternCS getBottomPattern() {
		return bottomPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottomPattern(BottomPatternCS newBottomPattern, NotificationChain msgs) {
		BottomPatternCS oldBottomPattern = bottomPattern;
		bottomPattern = newBottomPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.AREA_CS__BOTTOM_PATTERN, oldBottomPattern, newBottomPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomPattern(BottomPatternCS newBottomPattern) {
		if (newBottomPattern != bottomPattern) {
			NotificationChain msgs = null;
			if (bottomPattern != null)
				msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.AREA_CS__BOTTOM_PATTERN, null, msgs);
			if (newBottomPattern != null)
				msgs = ((InternalEObject)newBottomPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.AREA_CS__BOTTOM_PATTERN, null, msgs);
			msgs = basicSetBottomPattern(newBottomPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.AREA_CS__BOTTOM_PATTERN, newBottomPattern, newBottomPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardPatternCS getGuardPattern() {
		return guardPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardPattern(GuardPatternCS newGuardPattern, NotificationChain msgs) {
		GuardPatternCS oldGuardPattern = guardPattern;
		guardPattern = newGuardPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.AREA_CS__GUARD_PATTERN, oldGuardPattern, newGuardPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardPattern(GuardPatternCS newGuardPattern) {
		if (newGuardPattern != guardPattern) {
			NotificationChain msgs = null;
			if (guardPattern != null)
				msgs = ((InternalEObject)guardPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.AREA_CS__GUARD_PATTERN, null, msgs);
			if (newGuardPattern != null)
				msgs = ((InternalEObject)newGuardPattern).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcCSTPackage.AREA_CS__GUARD_PATTERN, null, msgs);
			msgs = basicSetGuardPattern(newGuardPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcCSTPackage.AREA_CS__GUARD_PATTERN, newGuardPattern, newGuardPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcCSTPackage.AREA_CS__GUARD_PATTERN:
				return basicSetGuardPattern(null, msgs);
			case QVTcCSTPackage.AREA_CS__BOTTOM_PATTERN:
				return basicSetBottomPattern(null, msgs);
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
			case QVTcCSTPackage.AREA_CS__GUARD_PATTERN:
				return getGuardPattern();
			case QVTcCSTPackage.AREA_CS__BOTTOM_PATTERN:
				return getBottomPattern();
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
			case QVTcCSTPackage.AREA_CS__GUARD_PATTERN:
				setGuardPattern((GuardPatternCS)newValue);
				return;
			case QVTcCSTPackage.AREA_CS__BOTTOM_PATTERN:
				setBottomPattern((BottomPatternCS)newValue);
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
			case QVTcCSTPackage.AREA_CS__GUARD_PATTERN:
				setGuardPattern((GuardPatternCS)null);
				return;
			case QVTcCSTPackage.AREA_CS__BOTTOM_PATTERN:
				setBottomPattern((BottomPatternCS)null);
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
			case QVTcCSTPackage.AREA_CS__GUARD_PATTERN:
				return guardPattern != null;
			case QVTcCSTPackage.AREA_CS__BOTTOM_PATTERN:
				return bottomPattern != null;
		}
		return super.eIsSet(featureID);
	}

} //AreaCSImpl
