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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.qvtd.xtext.qvtcorebasecs.AbstractMappingCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.AbstractMappingCSImpl#isIsDefault <em>Is Default</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.AbstractMappingCSImpl#getOwnedDomains <em>Owned Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.AbstractMappingCSImpl#getOwnedInPathName <em>Owned In Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.AbstractMappingCSImpl#getOwnedMiddle <em>Owned Middle</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class AbstractMappingCSImpl extends NamedElementCSImpl implements AbstractMappingCS {
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
	 * The cached value of the '{@link #getOwnedDomains() <em>Owned Domains</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedDomains()
	 * @generated
	 * @ordered
	 */
	protected EList<DomainCS> ownedDomains;

	/**
	 * The cached value of the '{@link #getOwnedInPathName() <em>Owned In Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS ownedInPathName;

	/**
	 * The cached value of the '{@link #getOwnedMiddle() <em>Owned Middle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMiddle()
	 * @generated
	 * @ordered
	 */
	protected DomainCS ownedMiddle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractMappingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreBaseCSPackage.Literals.ABSTRACT_MAPPING_CS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__IS_DEFAULT, oldIsDefault, isDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DomainCS> getOwnedDomains() {
		if (ownedDomains == null) {
			ownedDomains = new EObjectContainmentEList<DomainCS>(DomainCS.class, this, QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_DOMAINS);
		}
		return ownedDomains;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getOwnedInPathName() {
		return ownedInPathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInPathName(PathNameCS newOwnedInPathName, NotificationChain msgs) {
		PathNameCS oldOwnedInPathName = ownedInPathName;
		ownedInPathName = newOwnedInPathName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_IN_PATH_NAME, oldOwnedInPathName, newOwnedInPathName);
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
	public void setOwnedInPathName(PathNameCS newOwnedInPathName) {
		if (newOwnedInPathName != ownedInPathName) {
			NotificationChain msgs = null;
			if (ownedInPathName != null)
				msgs = ((InternalEObject)ownedInPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_IN_PATH_NAME, null, msgs);
			if (newOwnedInPathName != null)
				msgs = ((InternalEObject)newOwnedInPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_IN_PATH_NAME, null, msgs);
			msgs = basicSetOwnedInPathName(newOwnedInPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_IN_PATH_NAME, newOwnedInPathName, newOwnedInPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DomainCS getOwnedMiddle() {
		return ownedMiddle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedMiddle(DomainCS newOwnedMiddle, NotificationChain msgs) {
		DomainCS oldOwnedMiddle = ownedMiddle;
		ownedMiddle = newOwnedMiddle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_MIDDLE, oldOwnedMiddle, newOwnedMiddle);
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
	public void setOwnedMiddle(DomainCS newOwnedMiddle) {
		if (newOwnedMiddle != ownedMiddle) {
			NotificationChain msgs = null;
			if (ownedMiddle != null)
				msgs = ((InternalEObject)ownedMiddle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_MIDDLE, null, msgs);
			if (newOwnedMiddle != null)
				msgs = ((InternalEObject)newOwnedMiddle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_MIDDLE, null, msgs);
			msgs = basicSetOwnedMiddle(newOwnedMiddle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_MIDDLE, newOwnedMiddle, newOwnedMiddle));
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
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_DOMAINS:
				return ((InternalEList<?>)getOwnedDomains()).basicRemove(otherEnd, msgs);
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_IN_PATH_NAME:
				return basicSetOwnedInPathName(null, msgs);
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_MIDDLE:
				return basicSetOwnedMiddle(null, msgs);
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
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__IS_DEFAULT:
				return isIsDefault();
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_DOMAINS:
				return getOwnedDomains();
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_IN_PATH_NAME:
				return getOwnedInPathName();
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_MIDDLE:
				return getOwnedMiddle();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__IS_DEFAULT:
				setIsDefault((Boolean)newValue);
				return;
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_DOMAINS:
				getOwnedDomains().clear();
				getOwnedDomains().addAll((Collection<? extends DomainCS>)newValue);
				return;
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_IN_PATH_NAME:
				setOwnedInPathName((PathNameCS)newValue);
				return;
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_MIDDLE:
				setOwnedMiddle((DomainCS)newValue);
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
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__IS_DEFAULT:
				setIsDefault(IS_DEFAULT_EDEFAULT);
				return;
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_DOMAINS:
				getOwnedDomains().clear();
				return;
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_IN_PATH_NAME:
				setOwnedInPathName((PathNameCS)null);
				return;
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_MIDDLE:
				setOwnedMiddle((DomainCS)null);
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
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__IS_DEFAULT:
				return isDefault != IS_DEFAULT_EDEFAULT;
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_DOMAINS:
				return ownedDomains != null && !ownedDomains.isEmpty();
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_IN_PATH_NAME:
				return ownedInPathName != null;
			case QVTcoreBaseCSPackage.ABSTRACT_MAPPING_CS__OWNED_MIDDLE:
				return ownedMiddle != null;
		}
		return super.eIsSet(featureID);
	}
} //MappingCSImpl
