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
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtcorebasecs.impl.AbstractMappingCSImpl;
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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedMappingSequence <em>Owned Mapping Sequence</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCSImpl#getOwnedUsesPathNames <em>Owned Uses Path Names</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingCSImpl extends AbstractMappingCSImpl implements MappingCS {
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
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				return basicSetOwnedMappingSequence(null, msgs);
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				return getOwnedMappingSequence();
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				setOwnedMappingSequence((MappingSequenceCS)newValue);
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				setOwnedMappingSequence((MappingSequenceCS)null);
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
			case QVTimperativeCSPackage.MAPPING_CS__OWNED_MAPPING_SEQUENCE:
				return ownedMappingSequence != null;
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
