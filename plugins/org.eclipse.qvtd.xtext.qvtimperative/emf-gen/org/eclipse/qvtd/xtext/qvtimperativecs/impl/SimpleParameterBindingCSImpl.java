/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.SimpleParameterBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Simple Parameter Binding CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.SimpleParameterBindingCSImpl#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.SimpleParameterBindingCSImpl#getReferredVariable <em>Referred Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.SimpleParameterBindingCSImpl#isIsCheck <em>Is Check</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleParameterBindingCSImpl extends MappingParameterBindingCSImpl implements SimpleParameterBindingCS {
	/**
	 * The number of structural features of the '<em>Simple Parameter Binding CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SIMPLE_PARAMETER_BINDING_CS_FEATURE_COUNT = MappingParameterBindingCSImpl.MAPPING_PARAMETER_BINDING_CS_FEATURE_COUNT + 3;

	/**
	 * The cached value of the '{@link #getOwnedValue() <em>Owned Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedValue()
	 * @generated
	 * @ordered
	 */
	protected ExpCS ownedValue;

	/**
	 * The cached value of the '{@link #getReferredVariable() <em>Referred Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredVariable()
	 * @generated
	 * @ordered
	 */
	protected SimpleParameter referredVariable;

	/**
	 * The default value of the '{@link #isIsCheck() <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheck()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CHECK_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsCheck() <em>Is Check</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsCheck()
	 * @generated
	 * @ordered
	 */
	protected boolean isCheck = IS_CHECK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleParameterBindingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.SIMPLE_PARAMETER_BINDING_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpCS getOwnedValue() {
		return ownedValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedValue(ExpCS newOwnedValue, NotificationChain msgs) {
		ExpCS oldOwnedValue = ownedValue;
		ownedValue = newOwnedValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 1, oldOwnedValue, newOwnedValue);
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
	public void setOwnedValue(ExpCS newOwnedValue) {
		if (newOwnedValue != ownedValue) {
			NotificationChain msgs = null;
			if (ownedValue != null)
				msgs = ((InternalEObject)ownedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 1), null, msgs);
			if (newOwnedValue != null)
				msgs = ((InternalEObject)newOwnedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - (ExpCSImpl.EXP_CS_FEATURE_COUNT + 1), null, msgs);
			msgs = basicSetOwnedValue(newOwnedValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 1, newOwnedValue, newOwnedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleParameter getReferredVariable() {
		if (referredVariable != null && referredVariable.eIsProxy()) {
			InternalEObject oldReferredVariable = (InternalEObject)referredVariable;
			referredVariable = (SimpleParameter)eResolveProxy(oldReferredVariable);
			if (referredVariable != oldReferredVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpCSImpl.EXP_CS_FEATURE_COUNT + 2, oldReferredVariable, referredVariable));
			}
		}
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleParameter basicGetReferredVariable() {
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredVariable(SimpleParameter newReferredVariable) {
		SimpleParameter oldReferredVariable = referredVariable;
		referredVariable = newReferredVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 2, oldReferredVariable, referredVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsCheck() {
		return isCheck;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsCheck(boolean newIsCheck) {
		boolean oldIsCheck = isCheck;
		isCheck = newIsCheck;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpCSImpl.EXP_CS_FEATURE_COUNT + 3, oldIsCheck, isCheck));
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				return basicSetOwnedValue(null, msgs);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				return getOwnedValue();
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 2:
				if (resolve) return getReferredVariable();
				return basicGetReferredVariable();
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 3:
				return isIsCheck();
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				setOwnedValue((ExpCS)newValue);
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 2:
				setReferredVariable((SimpleParameter)newValue);
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 3:
				setIsCheck((Boolean)newValue);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				setOwnedValue((ExpCS)null);
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 2:
				setReferredVariable((SimpleParameter)null);
				return;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 3:
				setIsCheck(IS_CHECK_EDEFAULT);
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
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 1:
				return ownedValue != null;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 2:
				return referredVariable != null;
			case ExpCSImpl.EXP_CS_FEATURE_COUNT + 3:
				return isCheck != IS_CHECK_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitSimpleParameterBindingCS(this);
	}

} //SimpleParameterBindingCSImpl
