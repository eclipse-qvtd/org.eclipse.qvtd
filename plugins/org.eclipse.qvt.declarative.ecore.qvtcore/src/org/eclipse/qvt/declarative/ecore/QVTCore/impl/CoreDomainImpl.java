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
 * $Id: CoreDomainImpl.java,v 1.1 2008/07/23 09:43:25 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.ecore.Variable;

import org.eclipse.qvt.declarative.ecore.QVTBase.impl.DomainImpl;

import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.BottomPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.CoreDomain;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Domain</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.CoreDomainImpl#getGuardPattern <em>Guard Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.CoreDomainImpl#getBottomPattern <em>Bottom Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoreDomainImpl extends DomainImpl implements CoreDomain {
	/**
	 * The cached value of the '{@link #getGuardPattern() <em>Guard Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGuardPattern()
	 * @generated
	 * @ordered
	 */
	protected GuardPattern guardPattern;

	/**
	 * The cached value of the '{@link #getBottomPattern() <em>Bottom Pattern</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBottomPattern()
	 * @generated
	 * @ordered
	 */
	protected BottomPattern bottomPattern;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreDomainImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTCorePackage.Literals.CORE_DOMAIN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardPattern getGuardPattern() {
		return guardPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGuardPattern(GuardPattern newGuardPattern, NotificationChain msgs) {
		GuardPattern oldGuardPattern = guardPattern;
		guardPattern = newGuardPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN, oldGuardPattern, newGuardPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGuardPattern(GuardPattern newGuardPattern) {
		if (newGuardPattern != guardPattern) {
			NotificationChain msgs = null;
			if (guardPattern != null)
				msgs = ((InternalEObject)guardPattern).eInverseRemove(this, QVTCorePackage.GUARD_PATTERN__AREA, GuardPattern.class, msgs);
			if (newGuardPattern != null)
				msgs = ((InternalEObject)newGuardPattern).eInverseAdd(this, QVTCorePackage.GUARD_PATTERN__AREA, GuardPattern.class, msgs);
			msgs = basicSetGuardPattern(newGuardPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN, newGuardPattern, newGuardPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BottomPattern getBottomPattern() {
		return bottomPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottomPattern(BottomPattern newBottomPattern, NotificationChain msgs) {
		BottomPattern oldBottomPattern = bottomPattern;
		bottomPattern = newBottomPattern;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN, oldBottomPattern, newBottomPattern);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomPattern(BottomPattern newBottomPattern) {
		if (newBottomPattern != bottomPattern) {
			NotificationChain msgs = null;
			if (bottomPattern != null)
				msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, QVTCorePackage.BOTTOM_PATTERN__AREA, BottomPattern.class, msgs);
			if (newBottomPattern != null)
				msgs = ((InternalEObject)newBottomPattern).eInverseAdd(this, QVTCorePackage.BOTTOM_PATTERN__AREA, BottomPattern.class, msgs);
			msgs = basicSetBottomPattern(newBottomPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN, newBottomPattern, newBottomPattern));
	}


	/**
	 * @generated NOT
	 */
	public EList<Variable> getAllVariables() {
		EList<Variable> variables = ((Area) getRule()).getAllVariables();
		variables.addAll(getGuardPattern().getAllVariables());
		variables.addAll(getBottomPattern().getVariable());
		variables.addAll(getBottomPattern().getRealizedVariable());
		return variables;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN:
				if (guardPattern != null)
					msgs = ((InternalEObject)guardPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN, null, msgs);
				return basicSetGuardPattern((GuardPattern)otherEnd, msgs);
			case QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN:
				if (bottomPattern != null)
					msgs = ((InternalEObject)bottomPattern).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN, null, msgs);
				return basicSetBottomPattern((BottomPattern)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN:
				return basicSetGuardPattern(null, msgs);
			case QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN:
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
			case QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN:
				return getGuardPattern();
			case QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN:
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
			case QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN:
				setGuardPattern((GuardPattern)newValue);
				return;
			case QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)newValue);
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
			case QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN:
				setGuardPattern((GuardPattern)null);
				return;
			case QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)null);
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
			case QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN:
				return guardPattern != null;
			case QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN:
				return bottomPattern != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Area.class) {
			switch (derivedFeatureID) {
				case QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN: return QVTCorePackage.AREA__GUARD_PATTERN;
				case QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN: return QVTCorePackage.AREA__BOTTOM_PATTERN;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Area.class) {
			switch (baseFeatureID) {
				case QVTCorePackage.AREA__GUARD_PATTERN: return QVTCorePackage.CORE_DOMAIN__GUARD_PATTERN;
				case QVTCorePackage.AREA__BOTTOM_PATTERN: return QVTCorePackage.CORE_DOMAIN__BOTTOM_PATTERN;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //CoreDomainImpl
