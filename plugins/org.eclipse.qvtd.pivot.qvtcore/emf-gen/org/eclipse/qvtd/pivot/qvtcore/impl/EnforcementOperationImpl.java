/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
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
package org.eclipse.qvtd.pivot.qvtcore.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.examples.pivot.OperationCallExp;

import org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl;
import org.eclipse.ocl.examples.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementMode;
import org.eclipse.qvtd.pivot.qvtcore.EnforcementOperation;
import org.eclipse.qvtd.pivot.qvtcore.QVTcorePackage;
import org.eclipse.qvtd.pivot.qvtcore.util.QVTcoreVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enforcement Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.EnforcementOperationImpl#getEnforcementMode <em>Enforcement Mode</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.EnforcementOperationImpl#getBottomPattern <em>Bottom Pattern</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtcore.impl.EnforcementOperationImpl#getOperationCallExp <em>Operation Call Exp</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnforcementOperationImpl extends ElementImpl implements EnforcementOperation {
	/**
	 * The default value of the '{@link #getEnforcementMode() <em>Enforcement Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcementMode()
	 * @generated
	 * @ordered
	 */
	protected static final EnforcementMode ENFORCEMENT_MODE_EDEFAULT = EnforcementMode.CREATION;

	/**
	 * The cached value of the '{@link #getEnforcementMode() <em>Enforcement Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcementMode()
	 * @generated
	 * @ordered
	 */
	protected EnforcementMode enforcementMode = ENFORCEMENT_MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOperationCallExp() <em>Operation Call Exp</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationCallExp()
	 * @generated
	 * @ordered
	 */
	protected OperationCallExp operationCallExp;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnforcementOperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcorePackage.Literals.ENFORCEMENT_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnforcementMode getEnforcementMode() {
		return enforcementMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnforcementMode(EnforcementMode newEnforcementMode) {
		EnforcementMode oldEnforcementMode = enforcementMode;
		enforcementMode = newEnforcementMode == null ? ENFORCEMENT_MODE_EDEFAULT : newEnforcementMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.ENFORCEMENT_OPERATION__ENFORCEMENT_MODE, oldEnforcementMode, enforcementMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BottomPattern getBottomPattern() {
		if (eContainerFeatureID() != QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN) return null;
		return (BottomPattern)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBottomPattern(BottomPattern newBottomPattern, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newBottomPattern, QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBottomPattern(BottomPattern newBottomPattern) {
		if (newBottomPattern != eInternalContainer() || (eContainerFeatureID() != QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN && newBottomPattern != null)) {
			if (EcoreUtil.isAncestor(this, newBottomPattern))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newBottomPattern != null)
				msgs = ((InternalEObject)newBottomPattern).eInverseAdd(this, QVTcorePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION, BottomPattern.class, msgs);
			msgs = basicSetBottomPattern(newBottomPattern, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN, newBottomPattern, newBottomPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperationCallExp getOperationCallExp() {
		return operationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationCallExp(OperationCallExp newOperationCallExp, NotificationChain msgs) {
		OperationCallExp oldOperationCallExp = operationCallExp;
		operationCallExp = newOperationCallExp;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcorePackage.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP, oldOperationCallExp, newOperationCallExp);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationCallExp(OperationCallExp newOperationCallExp) {
		if (newOperationCallExp != operationCallExp) {
			NotificationChain msgs = null;
			if (operationCallExp != null)
				msgs = ((InternalEObject)operationCallExp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcorePackage.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP, null, msgs);
			if (newOperationCallExp != null)
				msgs = ((InternalEObject)newOperationCallExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcorePackage.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP, null, msgs);
			msgs = basicSetOperationCallExp(newOperationCallExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcorePackage.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP, newOperationCallExp, newOperationCallExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetBottomPattern((BottomPattern)otherEnd, msgs);
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
			case QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN:
				return basicSetBottomPattern(null, msgs);
			case QVTcorePackage.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP:
				return basicSetOperationCallExp(null, msgs);
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
			case QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN:
				return eInternalContainer().eInverseRemove(this, QVTcorePackage.BOTTOM_PATTERN__ENFORCEMENT_OPERATION, BottomPattern.class, msgs);
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
			case QVTcorePackage.ENFORCEMENT_OPERATION__ENFORCEMENT_MODE:
				return getEnforcementMode();
			case QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN:
				return getBottomPattern();
			case QVTcorePackage.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP:
				return getOperationCallExp();
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
			case QVTcorePackage.ENFORCEMENT_OPERATION__ENFORCEMENT_MODE:
				setEnforcementMode((EnforcementMode)newValue);
				return;
			case QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)newValue);
				return;
			case QVTcorePackage.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP:
				setOperationCallExp((OperationCallExp)newValue);
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
			case QVTcorePackage.ENFORCEMENT_OPERATION__ENFORCEMENT_MODE:
				setEnforcementMode(ENFORCEMENT_MODE_EDEFAULT);
				return;
			case QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN:
				setBottomPattern((BottomPattern)null);
				return;
			case QVTcorePackage.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP:
				setOperationCallExp((OperationCallExp)null);
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
			case QVTcorePackage.ENFORCEMENT_OPERATION__ENFORCEMENT_MODE:
				return enforcementMode != ENFORCEMENT_MODE_EDEFAULT;
			case QVTcorePackage.ENFORCEMENT_OPERATION__BOTTOM_PATTERN:
				return getBottomPattern() != null;
			case QVTcorePackage.ENFORCEMENT_OPERATION__OPERATION_CALL_EXP:
				return operationCallExp != null;
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
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return ((QVTcoreVisitor<R>)visitor).visitEnforcementOperation(this);
	}
} //EnforcementOperationImpl
