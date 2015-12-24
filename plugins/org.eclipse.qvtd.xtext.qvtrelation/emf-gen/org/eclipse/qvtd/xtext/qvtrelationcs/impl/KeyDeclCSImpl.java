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
package org.eclipse.qvtd.xtext.qvtrelationcs.impl;

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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.xtext.basecs.PathNameCS;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtrelationcs.KeyDeclCS;
import org.eclipse.qvtd.xtext.qvtrelationcs.QVTrelationCSPackage;
import org.eclipse.qvtd.xtext.qvtrelationcs.util.QVTrelationCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key Decl CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.KeyDeclCSImpl#getOwnedPathName <em>Owned Path Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.KeyDeclCSImpl#getPropertyIds <em>Property Ids</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.KeyDeclCSImpl#getOwnedOppositePropertyIds <em>Owned Opposite Property Ids</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtrelationcs.impl.KeyDeclCSImpl#getClassId <em>Class Id</em>}</li>
 * </ul>
 *
 * @generated
 */
public class KeyDeclCSImpl extends ModelElementCSImpl implements KeyDeclCS {
	/**
	 * The cached value of the '{@link #getOwnedPathName() <em>Owned Path Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPathName()
	 * @generated
	 * @ordered
	 */
	protected PathNameCS ownedPathName;

	/**
	 * The cached value of the '{@link #getPropertyIds() <em>Property Ids</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyIds()
	 * @generated
	 * @ordered
	 */
	protected EList<Property> propertyIds;

	/**
	 * The cached value of the '{@link #getOwnedOppositePropertyIds() <em>Owned Opposite Property Ids</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOppositePropertyIds()
	 * @generated
	 * @ordered
	 */
	protected EList<PathNameCS> ownedOppositePropertyIds;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected KeyDeclCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrelationCSPackage.Literals.KEY_DECL_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PathNameCS getOwnedPathName() {
		return ownedPathName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedPathName(PathNameCS newOwnedPathName, NotificationChain msgs) {
		PathNameCS oldOwnedPathName = ownedPathName;
		ownedPathName = newOwnedPathName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.KEY_DECL_CS__OWNED_PATH_NAME, oldOwnedPathName, newOwnedPathName);
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
	public void setOwnedPathName(PathNameCS newOwnedPathName) {
		if (newOwnedPathName != ownedPathName) {
			NotificationChain msgs = null;
			if (ownedPathName != null)
				msgs = ((InternalEObject)ownedPathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.KEY_DECL_CS__OWNED_PATH_NAME, null, msgs);
			if (newOwnedPathName != null)
				msgs = ((InternalEObject)newOwnedPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTrelationCSPackage.KEY_DECL_CS__OWNED_PATH_NAME, null, msgs);
			msgs = basicSetOwnedPathName(newOwnedPathName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrelationCSPackage.KEY_DECL_CS__OWNED_PATH_NAME, newOwnedPathName, newOwnedPathName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Property> getPropertyIds() {
		if (propertyIds == null) {
			propertyIds = new EObjectResolvingEList<Property>(Property.class, this, QVTrelationCSPackage.KEY_DECL_CS__PROPERTY_IDS);
		}
		return propertyIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PathNameCS> getOwnedOppositePropertyIds() {
		if (ownedOppositePropertyIds == null) {
			ownedOppositePropertyIds = new EObjectContainmentEList<PathNameCS>(PathNameCS.class, this, QVTrelationCSPackage.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS);
		}
		return ownedOppositePropertyIds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_PATH_NAME:
				return basicSetOwnedPathName(null, msgs);
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS:
				return ((InternalEList<?>)getOwnedOppositePropertyIds()).basicRemove(otherEnd, msgs);
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
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_PATH_NAME:
				return getOwnedPathName();
			case QVTrelationCSPackage.KEY_DECL_CS__PROPERTY_IDS:
				return getPropertyIds();
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS:
				return getOwnedOppositePropertyIds();
			case QVTrelationCSPackage.KEY_DECL_CS__CLASS_ID:
				return getClassId();
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
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)newValue);
				return;
			case QVTrelationCSPackage.KEY_DECL_CS__PROPERTY_IDS:
				getPropertyIds().clear();
				getPropertyIds().addAll((Collection<? extends Property>)newValue);
				return;
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS:
				getOwnedOppositePropertyIds().clear();
				getOwnedOppositePropertyIds().addAll((Collection<? extends PathNameCS>)newValue);
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
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_PATH_NAME:
				setOwnedPathName((PathNameCS)null);
				return;
			case QVTrelationCSPackage.KEY_DECL_CS__PROPERTY_IDS:
				getPropertyIds().clear();
				return;
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS:
				getOwnedOppositePropertyIds().clear();
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
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_PATH_NAME:
				return ownedPathName != null;
			case QVTrelationCSPackage.KEY_DECL_CS__PROPERTY_IDS:
				return propertyIds != null && !propertyIds.isEmpty();
			case QVTrelationCSPackage.KEY_DECL_CS__OWNED_OPPOSITE_PROPERTY_IDS:
				return ownedOppositePropertyIds != null && !ownedOppositePropertyIds.isEmpty();
			case QVTrelationCSPackage.KEY_DECL_CS__CLASS_ID:
				return getClassId() != null;
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
		return (R) ((QVTrelationCSVisitor<?>)visitor).visitKeyDeclCS(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public org.eclipse.ocl.pivot.Class getClassId() {
		if (ownedPathName == null) {
			return null;
		}
		return (org.eclipse.ocl.pivot.Class) ownedPathName.getReferredElement();
	}
} //KeyDeclCSImpl
