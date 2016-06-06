/**
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.umlx.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.qvtd.umlx.TxPackageNode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tx Package Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.umlx.impl.TxPackageNodeImpl#getReferredPackage <em>Referred Package</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TxPackageNodeImpl extends TxNodeImpl implements TxPackageNode {
	/**
	 * The cached value of the '{@link #getReferredPackage() <em>Referred Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredPackage()
	 * @generated
	 * @ordered
	 */
	protected EPackage referredPackage;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TxPackageNodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UmlxPackageImpl.Literals.TX_PACKAGE_NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage getReferredPackage() {
		if (referredPackage != null && referredPackage.eIsProxy()) {
			InternalEObject oldReferredPackage = (InternalEObject)referredPackage;
			referredPackage = (EPackage)eResolveProxy(oldReferredPackage);
			if (referredPackage != oldReferredPackage) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, UmlxPackageImpl.TX_PACKAGE_NODE__REFERRED_PACKAGE, oldReferredPackage, referredPackage));
			}
		}
		return referredPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EPackage basicGetReferredPackage() {
		return referredPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredPackage(EPackage newReferredPackage) {
		EPackage oldReferredPackage = referredPackage;
		referredPackage = newReferredPackage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UmlxPackageImpl.TX_PACKAGE_NODE__REFERRED_PACKAGE, oldReferredPackage, referredPackage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case UmlxPackageImpl.TX_PACKAGE_NODE__REFERRED_PACKAGE:
				if (resolve) return getReferredPackage();
				return basicGetReferredPackage();
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
			case UmlxPackageImpl.TX_PACKAGE_NODE__REFERRED_PACKAGE:
				setReferredPackage((EPackage)newValue);
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
			case UmlxPackageImpl.TX_PACKAGE_NODE__REFERRED_PACKAGE:
				setReferredPackage((EPackage)null);
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
			case UmlxPackageImpl.TX_PACKAGE_NODE__REFERRED_PACKAGE:
				return referredPackage != null;
		}
		return super.eIsSet(featureID);
	}

} //TxPackageNodeImpl
