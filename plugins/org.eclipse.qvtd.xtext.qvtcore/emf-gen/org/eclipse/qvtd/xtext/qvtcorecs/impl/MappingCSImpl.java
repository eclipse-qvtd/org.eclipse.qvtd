/*******************************************************************************
 * Copyright (c) 2012, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtcorecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.xtext.qvtcorecs.DomainCS;
import org.eclipse.qvtd.xtext.qvtcorecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtcorecs.QVTcoreCSPackage;
import org.eclipse.qvtd.xtext.qvtcorecs.util.QVTcoreCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl#isIsAbstract <em>Is Abstract</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl#getOwnedComposedMappings <em>Owned Composed Mappings</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl#getOwnedDomains <em>Owned Domains</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl#getOwnedInPathName <em>Owned In Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl#getOwnedMiddle <em>Owned Middle</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorecs.impl.MappingCSImpl#getRefines <em>Refines</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingCSImpl extends NamedElementCSImpl implements MappingCS {
	/**
	 * The default value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAbstract() <em>Is Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean isAbstract = IS_ABSTRACT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedComposedMappings() <em>Owned Composed Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedComposedMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingCS> ownedComposedMappings;

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
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> refines;

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
		return QVTcoreCSPackage.Literals.MAPPING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAbstract() {
		return isAbstract;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAbstract(boolean newIsAbstract) {
		boolean oldIsAbstract = isAbstract;
		isAbstract = newIsAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.MAPPING_CS__IS_ABSTRACT, oldIsAbstract, isAbstract));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingCS> getOwnedComposedMappings() {
		if (ownedComposedMappings == null) {
			ownedComposedMappings = new EObjectContainmentEList<MappingCS>(MappingCS.class, this, QVTcoreCSPackage.MAPPING_CS__OWNED_COMPOSED_MAPPINGS);
		}
		return ownedComposedMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DomainCS> getOwnedDomains() {
		if (ownedDomains == null) {
			ownedDomains = new EObjectContainmentEList<DomainCS>(DomainCS.class, this, QVTcoreCSPackage.MAPPING_CS__OWNED_DOMAINS);
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, oldOwnedInPathName, newOwnedInPathName);
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
				msgs = ((InternalEObject)ownedInPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, null, msgs);
			if (newOwnedInPathName != null)
				msgs = ((InternalEObject)newOwnedInPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, null, msgs);
			msgs = basicSetOwnedInPathName(newOwnedInPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME, newOwnedInPathName, newOwnedInPathName));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.MAPPING_CS__OWNED_MIDDLE, oldOwnedMiddle, newOwnedMiddle);
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
				msgs = ((InternalEObject)ownedMiddle).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSPackage.MAPPING_CS__OWNED_MIDDLE, null, msgs);
			if (newOwnedMiddle != null)
				msgs = ((InternalEObject)newOwnedMiddle).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreCSPackage.MAPPING_CS__OWNED_MIDDLE, null, msgs);
			msgs = basicSetOwnedMiddle(newOwnedMiddle, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreCSPackage.MAPPING_CS__OWNED_MIDDLE, newOwnedMiddle, newOwnedMiddle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Mapping> getRefines() {
		if (refines == null) {
			refines = new EObjectResolvingEList<Mapping>(Mapping.class, this, QVTcoreCSPackage.MAPPING_CS__REFINES);
		}
		return refines;
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
			case QVTcoreCSPackage.MAPPING_CS__OWNED_COMPOSED_MAPPINGS:
				return ((InternalEList<?>)getOwnedComposedMappings()).basicRemove(otherEnd, msgs);
			case QVTcoreCSPackage.MAPPING_CS__OWNED_DOMAINS:
				return ((InternalEList<?>)getOwnedDomains()).basicRemove(otherEnd, msgs);
			case QVTcoreCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return basicSetOwnedInPathName(null, msgs);
			case QVTcoreCSPackage.MAPPING_CS__OWNED_MIDDLE:
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
			case QVTcoreCSPackage.MAPPING_CS__IS_ABSTRACT:
				return isIsAbstract();
			case QVTcoreCSPackage.MAPPING_CS__OWNED_COMPOSED_MAPPINGS:
				return getOwnedComposedMappings();
			case QVTcoreCSPackage.MAPPING_CS__OWNED_DOMAINS:
				return getOwnedDomains();
			case QVTcoreCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return getOwnedInPathName();
			case QVTcoreCSPackage.MAPPING_CS__OWNED_MIDDLE:
				return getOwnedMiddle();
			case QVTcoreCSPackage.MAPPING_CS__REFINES:
				return getRefines();
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
			case QVTcoreCSPackage.MAPPING_CS__IS_ABSTRACT:
				setIsAbstract((Boolean)newValue);
				return;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_COMPOSED_MAPPINGS:
				getOwnedComposedMappings().clear();
				getOwnedComposedMappings().addAll((Collection<? extends MappingCS>)newValue);
				return;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_DOMAINS:
				getOwnedDomains().clear();
				getOwnedDomains().addAll((Collection<? extends DomainCS>)newValue);
				return;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				setOwnedInPathName((PathNameCS)newValue);
				return;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_MIDDLE:
				setOwnedMiddle((DomainCS)newValue);
				return;
			case QVTcoreCSPackage.MAPPING_CS__REFINES:
				getRefines().clear();
				getRefines().addAll((Collection<? extends Mapping>)newValue);
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
			case QVTcoreCSPackage.MAPPING_CS__IS_ABSTRACT:
				setIsAbstract(IS_ABSTRACT_EDEFAULT);
				return;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_COMPOSED_MAPPINGS:
				getOwnedComposedMappings().clear();
				return;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_DOMAINS:
				getOwnedDomains().clear();
				return;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				setOwnedInPathName((PathNameCS)null);
				return;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_MIDDLE:
				setOwnedMiddle((DomainCS)null);
				return;
			case QVTcoreCSPackage.MAPPING_CS__REFINES:
				getRefines().clear();
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
			case QVTcoreCSPackage.MAPPING_CS__IS_ABSTRACT:
				return isAbstract != IS_ABSTRACT_EDEFAULT;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_COMPOSED_MAPPINGS:
				return ownedComposedMappings != null && !ownedComposedMappings.isEmpty();
			case QVTcoreCSPackage.MAPPING_CS__OWNED_DOMAINS:
				return ownedDomains != null && !ownedDomains.isEmpty();
			case QVTcoreCSPackage.MAPPING_CS__OWNED_IN_PATH_NAME:
				return ownedInPathName != null;
			case QVTcoreCSPackage.MAPPING_CS__OWNED_MIDDLE:
				return ownedMiddle != null;
			case QVTcoreCSPackage.MAPPING_CS__REFINES:
				return refines != null && !refines.isEmpty();
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
		return (R) ((QVTcoreCSVisitor<?>)visitor).visitMappingCS(this);
	}
} //MappingCSImpl
