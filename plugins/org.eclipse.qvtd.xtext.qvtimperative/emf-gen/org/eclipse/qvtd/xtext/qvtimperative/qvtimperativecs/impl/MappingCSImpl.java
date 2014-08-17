/*******************************************************************************
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.xtext.base.basecs.util.BaseCSVisitor;
import org.eclipse.qvtd.xtext.qvtcorebase.qvtcorebasecs.impl.AbstractMappingCSImpl;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.MappingSequenceCS;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperative.qvtimperativecs.impl.MappingCSImpl#getMappingSequence <em>Mapping Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappingCSImpl extends AbstractMappingCSImpl implements MappingCS {
	/**
	 * The cached value of the '{@link #getMappingSequence() <em>Mapping Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingSequence()
	 * @generated
	 * @ordered
	 */
	protected MappingSequenceCS mappingSequence;
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
	public MappingSequenceCS getMappingSequence() {
		return mappingSequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingSequence(MappingSequenceCS newMappingSequence, NotificationChain msgs) {
		MappingSequenceCS oldMappingSequence = mappingSequence;
		mappingSequence = newMappingSequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__MAPPING_SEQUENCE, oldMappingSequence, newMappingSequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMappingSequence(MappingSequenceCS newMappingSequence) {
		if (newMappingSequence != mappingSequence) {
			NotificationChain msgs = null;
			if (mappingSequence != null)
				msgs = ((InternalEObject)mappingSequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__MAPPING_SEQUENCE, null, msgs);
			if (newMappingSequence != null)
				msgs = ((InternalEObject)newMappingSequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CS__MAPPING_SEQUENCE, null, msgs);
			msgs = basicSetMappingSequence(newMappingSequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CS__MAPPING_SEQUENCE, newMappingSequence, newMappingSequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSPackage.MAPPING_CS__MAPPING_SEQUENCE:
				return basicSetMappingSequence(null, msgs);
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
			case QVTimperativeCSPackage.MAPPING_CS__MAPPING_SEQUENCE:
				return getMappingSequence();
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
			case QVTimperativeCSPackage.MAPPING_CS__MAPPING_SEQUENCE:
				setMappingSequence((MappingSequenceCS)newValue);
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
			case QVTimperativeCSPackage.MAPPING_CS__MAPPING_SEQUENCE:
				setMappingSequence((MappingSequenceCS)null);
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
			case QVTimperativeCSPackage.MAPPING_CS__MAPPING_SEQUENCE:
				return mappingSequence != null;
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
	public @Nullable <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitMappingCS(this);
	}
} //MappingCSImpl
