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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.impl.ModelElementCSImpl;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.NameExpCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecs.QVTcoreBaseCSPackage;
import org.eclipse.qvtd.xtext.qvtcorebasecs.util.QVTcoreBaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enforcement Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.EnforcementOperationCSImpl#isIsDeletion <em>Is Deletion</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecs.impl.EnforcementOperationCSImpl#getOwnedOperationCall <em>Owned Operation Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EnforcementOperationCSImpl extends ModelElementCSImpl implements EnforcementOperationCS {
	/**
	 * The default value of the '{@link #isIsDeletion() <em>Is Deletion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDeletion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DELETION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDeletion() <em>Is Deletion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDeletion()
	 * @generated
	 * @ordered
	 */
	protected boolean isDeletion = IS_DELETION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOwnedOperationCall() <em>Owned Operation Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperationCall()
	 * @generated
	 * @ordered
	 */
	protected NameExpCS ownedOperationCall;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnforcementOperationCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcoreBaseCSPackage.Literals.ENFORCEMENT_OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsDeletion() {
		return isDeletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsDeletion(boolean newIsDeletion) {
		boolean oldIsDeletion = isDeletion;
		isDeletion = newIsDeletion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__IS_DELETION, oldIsDeletion, isDeletion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NameExpCS getOwnedOperationCall() {
		return ownedOperationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedOperationCall(NameExpCS newOwnedOperationCall, NotificationChain msgs) {
		NameExpCS oldOwnedOperationCall = ownedOperationCall;
		ownedOperationCall = newOwnedOperationCall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL, oldOwnedOperationCall, newOwnedOperationCall);
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
	public void setOwnedOperationCall(NameExpCS newOwnedOperationCall) {
		if (newOwnedOperationCall != ownedOperationCall) {
			NotificationChain msgs = null;
			if (ownedOperationCall != null)
				msgs = ((InternalEObject)ownedOperationCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL, null, msgs);
			if (newOwnedOperationCall != null)
				msgs = ((InternalEObject)newOwnedOperationCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL, null, msgs);
			msgs = basicSetOwnedOperationCall(newOwnedOperationCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL, newOwnedOperationCall, newOwnedOperationCall));
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
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL:
				return basicSetOwnedOperationCall(null, msgs);
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
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__IS_DELETION:
				return isIsDeletion();
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL:
				return getOwnedOperationCall();
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
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__IS_DELETION:
				setIsDeletion((Boolean)newValue);
				return;
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL:
				setOwnedOperationCall((NameExpCS)newValue);
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
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__IS_DELETION:
				setIsDeletion(IS_DELETION_EDEFAULT);
				return;
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL:
				setOwnedOperationCall((NameExpCS)null);
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
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__IS_DELETION:
				return isDeletion != IS_DELETION_EDEFAULT;
			case QVTcoreBaseCSPackage.ENFORCEMENT_OPERATION_CS__OWNED_OPERATION_CALL:
				return ownedOperationCall != null;
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
		return (R) ((QVTcoreBaseCSVisitor<?>)visitor).visitEnforcementOperationCS(this);
	}
} //EnforcementOperationCSImpl
