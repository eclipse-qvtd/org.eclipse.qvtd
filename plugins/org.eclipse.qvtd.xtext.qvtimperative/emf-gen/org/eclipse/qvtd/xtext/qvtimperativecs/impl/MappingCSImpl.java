/*******************************************************************************
 * Copyright (c) 2012, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#isIsDefault <em>Is Default</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedDomains <em>Owned Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedInPathName <em>Owned In Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedKeyExpression <em>Owned Key Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedMappingSequence <em>Owned Mapping Sequence</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedMiddle <em>Owned Middle</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedUsesPathNames <em>Owned Uses Path Names</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingCSImpl extends NamedElementCSImpl implements MappingCS {
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
	 * The cached value of the '{@link #getOwnedKeyExpression() <em>Owned Key Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedKeyExpression()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedKeyExpression;
	/**
	 * The cached value of the '{@link #getOwnedMappingSequence() <em>Owned Mapping Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappingSequence()
	 * @generated
	 * @ordered
	 */
	protected MappingSequenceCS ownedMappingSequence;
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
	 * The cached value of the '{@link #getOwnedUsesPathNames() <em>Owned Uses Path Names</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedUsesPathNames()
	 * @generated
	 * @ordered
	 */
	protected EList<PathNameCS> ownedUsesPathNames;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.MAPPING_CS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__IS_DEFAULT, oldIsDefault, isDefault));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DomainCS> getOwnedDomains() {
		if (ownedDomains == null) {
			ownedDomains = new EObjectContainmentEList<DomainCS>(DomainCS.class, this, QVTimperativeCSPackage.MAPPING_CS__OWNED_DOMAINS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, oldOwnedInPathName, newOwnedInPathName);
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
				msgs = ((InternalEObject)ownedInPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, null, msgs);
			if (newOwnedInPathName != null)
				msgs = ((InternalEObject)newOwnedInPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, null, msgs);
			msgs = basicSetOwnedInPathName(newOwnedInPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, newOwnedInPathName, newOwnedInPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedKeyExpression() {
		return ownedKeyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedKeyExpression(ExpCS newOwnedKeyExpression, NotificationChain msgs) {
		ExpCS oldOwnedKeyExpression = ownedKeyExpression;
		ownedKeyExpression = newOwnedKeyExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_KEY_EXPRESSION, oldOwnedKeyExpression, newOwnedKeyExpression);
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
	public void setOwnedKeyExpression(ExpCS newOwnedKeyExpression) {
		if (newOwnedKeyExpression != ownedKeyExpression) {
			NotificationChain msgs = null;
			if (ownedKeyExpression != null)
				msgs = ((InternalEObject)ownedKeyExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_KEY_EXPRESSION, null, msgs);
			if (newOwnedKeyExpression != null)
				msgs = ((InternalEObject)newOwnedKeyExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_KEY_EXPRESSION, null, msgs);
			msgs = basicSetOwnedKeyExpression(newOwnedKeyExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_KEY_EXPRESSION, newOwnedKeyExpression, newOwnedKeyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingSequenceCS getOwnedMappingSequence() {
		return ownedMappingSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedMappingSequence(MappingSequenceCS newOwnedMappingSequence, NotificationChain msgs) {
		MappingSequenceCS oldOwnedMappingSequence = ownedMappingSequence;
		ownedMappingSequence = newOwnedMappingSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE, oldOwnedMappingSequence, newOwnedMappingSequence);
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
	public void setOwnedMappingSequence(MappingSequenceCS newOwnedMappingSequence) {
		if (newOwnedMappingSequence != ownedMappingSequence) {
			NotificationChain msgs = null;
			if (ownedMappingSequence != null)
				msgs = ((InternalEObject)ownedMappingSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE, null, msgs);
			if (newOwnedMappingSequence != null)
				msgs = ((InternalEObject)newOwnedMappingSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE, null, msgs);
			msgs = basicSetOwnedMappingSequence(newOwnedMappingSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE, newOwnedMappingSequence, newOwnedMappingSequence));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_MIDDLE, oldOwnedMiddle, newOwnedMiddle);
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
				msgs = ((InternalEObject)ownedMiddle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_MIDDLE, null, msgs);
			if (newOwnedMiddle != null)
				msgs = ((InternalEObject)newOwnedMiddle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__OWNED_MIDDLE, null, msgs);
			msgs = basicSetOwnedMiddle(newOwnedMiddle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__OWNED_MIDDLE, newOwnedMiddle, newOwnedMiddle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PathNameCS> getOwnedUsesPathNames() {
		if (ownedUsesPathNames == null) {
			ownedUsesPathNames = new EObjectContainmentEList<PathNameCS>(PathNameCS.class, this, QVTimperativeCSPackage.MAPPING_CS__OWNED_USES_PATH_NAMES);
		}
		return ownedUsesPathNames;
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_DOMAINS:
				return ((InternalEList<?>)getOwnedDomains()).basicRemove(otherEnd, msgs);
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return basicSetOwnedInPathName(null, msgs);
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_KEY_EXPRESSION:
				return basicSetOwnedKeyExpression(null, msgs);
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				return basicSetOwnedMappingSequence(null, msgs);
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MIDDLE:
				return basicSetOwnedMiddle(null, msgs);
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_USES_PATH_NAMES:
				return ((InternalEList<?>)getOwnedUsesPathNames()).basicRemove(otherEnd, msgs);
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
			case QVTimperativeCSPackage.MAPPING_CS__IS_DEFAULT:
				return isIsDefault();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_DOMAINS:
				return getOwnedDomains();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return getOwnedInPathName();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_KEY_EXPRESSION:
				return getOwnedKeyExpression();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				return getOwnedMappingSequence();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MIDDLE:
				return getOwnedMiddle();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_USES_PATH_NAMES:
				return getOwnedUsesPathNames();
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
			case QVTimperativeCSPackage.MAPPING_CS__IS_DEFAULT:
				setIsDefault((Boolean)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_DOMAINS:
				getOwnedDomains().clear();
				getOwnedDomains().addAll((Collection<? extends DomainCS>)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				setOwnedInPathName((PathNameCS)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_KEY_EXPRESSION:
				setOwnedKeyExpression((ExpCS)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				setOwnedMappingSequence((MappingSequenceCS)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MIDDLE:
				setOwnedMiddle((DomainCS)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_USES_PATH_NAMES:
				getOwnedUsesPathNames().clear();
				getOwnedUsesPathNames().addAll((Collection<? extends PathNameCS>)newValue);
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
			case QVTimperativeCSPackage.MAPPING_CS__IS_DEFAULT:
				setIsDefault(IS_DEFAULT_EDEFAULT);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_DOMAINS:
				getOwnedDomains().clear();
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				setOwnedInPathName((PathNameCS)null);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_KEY_EXPRESSION:
				setOwnedKeyExpression((ExpCS)null);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				setOwnedMappingSequence((MappingSequenceCS)null);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MIDDLE:
				setOwnedMiddle((DomainCS)null);
				return;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_USES_PATH_NAMES:
				getOwnedUsesPathNames().clear();
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
			case QVTimperativeCSPackage.MAPPING_CS__IS_DEFAULT:
				return isDefault != IS_DEFAULT_EDEFAULT;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_DOMAINS:
				return ownedDomains != null && !ownedDomains.isEmpty();
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return ownedInPathName != null;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_KEY_EXPRESSION:
				return ownedKeyExpression != null;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				return ownedMappingSequence != null;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MIDDLE:
				return ownedMiddle != null;
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_USES_PATH_NAMES:
				return ownedUsesPathNames != null && !ownedUsesPathNames.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitMappingCS(this);
	}
} //MappingCSImpl
