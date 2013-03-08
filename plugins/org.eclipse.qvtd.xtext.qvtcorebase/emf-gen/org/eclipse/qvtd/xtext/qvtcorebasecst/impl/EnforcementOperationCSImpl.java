/**
 * <copyright>
 *
 * Copyright (c) 2012 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.xtext.qvtcorebasecst.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.xtext.base.baseCST.impl.ModelElementCSImpl;
import org.eclipse.ocl.examples.xtext.base.util.BaseCSVisitor;
import org.eclipse.ocl.examples.xtext.essentialocl.essentialOCLCST.InvocationExpCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.EnforcementOperationCS;
import org.eclipse.qvtd.xtext.qvtcorebasecst.QVTcoreBaseCSTPackage;
import org.eclipse.qvtd.xtext.qvtcorebasecst.util.QVTcoreBaseCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enforcement Operation CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecst.impl.EnforcementOperationCSImpl#isDeletion <em>Deletion</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtcorebasecst.impl.EnforcementOperationCSImpl#getOperationCall <em>Operation Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnforcementOperationCSImpl extends ModelElementCSImpl implements EnforcementOperationCS {
	/**
	 * The default value of the '{@link #isDeletion() <em>Deletion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeletion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DELETION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDeletion() <em>Deletion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeletion()
	 * @generated
	 * @ordered
	 */
	protected boolean deletion = DELETION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperationCall() <em>Operation Call</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationCall()
	 * @generated
	 * @ordered
	 */
	protected InvocationExpCS operationCall;

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
		return QVTcoreBaseCSTPackage.Literals.ENFORCEMENT_OPERATION_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeletion() {
		return deletion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeletion(boolean newDeletion) {
		boolean oldDeletion = deletion;
		deletion = newDeletion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION, oldDeletion, deletion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InvocationExpCS getOperationCall() {
		return operationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationCall(InvocationExpCS newOperationCall, NotificationChain msgs) {
		InvocationExpCS oldOperationCall = operationCall;
		operationCall = newOperationCall;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL, oldOperationCall, newOperationCall);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationCall(InvocationExpCS newOperationCall) {
		if (newOperationCall != operationCall) {
			NotificationChain msgs = null;
			if (operationCall != null)
				msgs = ((InternalEObject)operationCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL, null, msgs);
			if (newOperationCall != null)
				msgs = ((InternalEObject)newOperationCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL, null, msgs);
			msgs = basicSetOperationCall(newOperationCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL, newOperationCall, newOperationCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				return basicSetOperationCall(null, msgs);
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
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION:
				return isDeletion();
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				return getOperationCall();
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
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION:
				setDeletion((Boolean)newValue);
				return;
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				setOperationCall((InvocationExpCS)newValue);
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
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION:
				setDeletion(DELETION_EDEFAULT);
				return;
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				setOperationCall((InvocationExpCS)null);
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
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__DELETION:
				return deletion != DELETION_EDEFAULT;
			case QVTcoreBaseCSTPackage.ENFORCEMENT_OPERATION_CS__OPERATION_CALL:
				return operationCall != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return ((QVTcoreBaseCSVisitor<R>)visitor).visitEnforcementOperationCS(this);
	}
} //EnforcementOperationCSImpl
