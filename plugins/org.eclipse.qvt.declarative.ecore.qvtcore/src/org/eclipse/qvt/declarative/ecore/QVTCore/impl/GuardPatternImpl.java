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
 * $Id: GuardPatternImpl.java,v 1.2 2009/02/17 21:44:24 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.qvt.declarative.ecore.QVTCore.Area;
import org.eclipse.qvt.declarative.ecore.QVTCore.GuardPattern;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Pattern</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.GuardPatternImpl#getArea <em>Area</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GuardPatternImpl extends CorePatternImpl implements GuardPattern {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardPatternImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTCorePackage.Literals.GUARD_PATTERN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Area getArea() {
		if (eContainerFeatureID() != QVTCorePackage.GUARD_PATTERN__AREA) return null;
		return (Area)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetArea(Area newArea, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newArea, QVTCorePackage.GUARD_PATTERN__AREA, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArea(Area newArea) {
		if (newArea != eInternalContainer() || (eContainerFeatureID() != QVTCorePackage.GUARD_PATTERN__AREA && newArea != null)) {
			if (EcoreUtil.isAncestor(this, newArea))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newArea != null)
				msgs = ((InternalEObject)newArea).eInverseAdd(this, QVTCorePackage.AREA__GUARD_PATTERN, Area.class, msgs);
			msgs = basicSetArea(newArea, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTCorePackage.GUARD_PATTERN__AREA, newArea, newArea));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTCorePackage.GUARD_PATTERN__AREA:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetArea((Area)otherEnd, msgs);
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
			case QVTCorePackage.GUARD_PATTERN__AREA:
				return basicSetArea(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTCorePackage.GUARD_PATTERN__AREA:
				return eInternalContainer().eInverseRemove(this, QVTCorePackage.AREA__GUARD_PATTERN, Area.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTCorePackage.GUARD_PATTERN__AREA:
				return getArea();
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
			case QVTCorePackage.GUARD_PATTERN__AREA:
				setArea((Area)newValue);
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
			case QVTCorePackage.GUARD_PATTERN__AREA:
				setArea((Area)null);
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
			case QVTCorePackage.GUARD_PATTERN__AREA:
				return getArea() != null;
		}
		return super.eIsSet(featureID);
	}

} //GuardPatternImpl
