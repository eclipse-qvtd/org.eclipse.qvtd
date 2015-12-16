/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.compiler.internal.qvtcconfig.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.qvtd.compiler.internal.qvtcconfig.Configuration;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Direction;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Mode;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.QVTcConfigPackage;
import org.eclipse.qvtd.compiler.internal.qvtcconfig.Transformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ConfigurationImpl#getInputDirection <em>Input Direction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ConfigurationImpl#getOutputDirection <em>Output Direction</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ConfigurationImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ConfigurationImpl#getTransformation <em>Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.compiler.internal.qvtcconfig.impl.ConfigurationImpl#getMiddle <em>Middle</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConfigurationImpl extends MinimalEObjectImpl.Container implements Configuration {
	/**
	 * The cached value of the '{@link #getInputDirection() <em>Input Direction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputDirection()
	 * @generated
	 * @ordered
	 */
	protected Direction inputDirection;

	/**
	 * The cached value of the '{@link #getOutputDirection() <em>Output Direction</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputDirection()
	 * @generated
	 * @ordered
	 */
	protected EList<Direction> outputDirection;

	/**
	 * The default value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected static final Mode MODE_EDEFAULT = Mode.CHECK;

	/**
	 * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMode()
	 * @generated
	 * @ordered
	 */
	protected Mode mode = MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTransformation() <em>Transformation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformation()
	 * @generated
	 * @ordered
	 */
	protected Transformation transformation;

	/**
	 * The cached value of the '{@link #getMiddle() <em>Middle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMiddle()
	 * @generated
	 * @ordered
	 */
	protected Direction middle;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTcConfigPackage.Literals.CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Direction getInputDirection() {
		if (inputDirection != null && inputDirection.eIsProxy()) {
			InternalEObject oldInputDirection = (InternalEObject)inputDirection;
			inputDirection = (Direction)eResolveProxy(oldInputDirection);
			if (inputDirection != oldInputDirection) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTcConfigPackage.CONFIGURATION__INPUT_DIRECTION, oldInputDirection, inputDirection));
			}
		}
		return inputDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction basicGetInputDirection() {
		return inputDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInputDirection(Direction newInputDirection) {
		Direction oldInputDirection = inputDirection;
		inputDirection = newInputDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcConfigPackage.CONFIGURATION__INPUT_DIRECTION, oldInputDirection, inputDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Direction> getOutputDirection() {
		if (outputDirection == null) {
			outputDirection = new EObjectResolvingEList<Direction>(Direction.class, this, QVTcConfigPackage.CONFIGURATION__OUTPUT_DIRECTION);
		}
		return outputDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mode getMode() {
		return mode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMode(Mode newMode) {
		Mode oldMode = mode;
		mode = newMode == null ? MODE_EDEFAULT : newMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcConfigPackage.CONFIGURATION__MODE, oldMode, mode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Transformation getTransformation() {
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransformation(Transformation newTransformation, NotificationChain msgs) {
		Transformation oldTransformation = transformation;
		transformation = newTransformation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTcConfigPackage.CONFIGURATION__TRANSFORMATION, oldTransformation, newTransformation);
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
	public void setTransformation(Transformation newTransformation) {
		if (newTransformation != transformation) {
			NotificationChain msgs = null;
			if (transformation != null)
				msgs = ((InternalEObject)transformation).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTcConfigPackage.CONFIGURATION__TRANSFORMATION, null, msgs);
			if (newTransformation != null)
				msgs = ((InternalEObject)newTransformation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTcConfigPackage.CONFIGURATION__TRANSFORMATION, null, msgs);
			msgs = basicSetTransformation(newTransformation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcConfigPackage.CONFIGURATION__TRANSFORMATION, newTransformation, newTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Direction getMiddle() {
		if (middle != null && middle.eIsProxy()) {
			InternalEObject oldMiddle = (InternalEObject)middle;
			middle = (Direction)eResolveProxy(oldMiddle);
			if (middle != oldMiddle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTcConfigPackage.CONFIGURATION__MIDDLE, oldMiddle, middle));
			}
		}
		return middle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction basicGetMiddle() {
		return middle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMiddle(Direction newMiddle) {
		Direction oldMiddle = middle;
		middle = newMiddle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTcConfigPackage.CONFIGURATION__MIDDLE, oldMiddle, middle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTcConfigPackage.CONFIGURATION__TRANSFORMATION:
				return basicSetTransformation(null, msgs);
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
			case QVTcConfigPackage.CONFIGURATION__INPUT_DIRECTION:
				if (resolve) return getInputDirection();
				return basicGetInputDirection();
			case QVTcConfigPackage.CONFIGURATION__OUTPUT_DIRECTION:
				return getOutputDirection();
			case QVTcConfigPackage.CONFIGURATION__MODE:
				return getMode();
			case QVTcConfigPackage.CONFIGURATION__TRANSFORMATION:
				return getTransformation();
			case QVTcConfigPackage.CONFIGURATION__MIDDLE:
				if (resolve) return getMiddle();
				return basicGetMiddle();
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
			case QVTcConfigPackage.CONFIGURATION__INPUT_DIRECTION:
				setInputDirection((Direction)newValue);
				return;
			case QVTcConfigPackage.CONFIGURATION__OUTPUT_DIRECTION:
				getOutputDirection().clear();
				getOutputDirection().addAll((Collection<? extends Direction>)newValue);
				return;
			case QVTcConfigPackage.CONFIGURATION__MODE:
				setMode((Mode)newValue);
				return;
			case QVTcConfigPackage.CONFIGURATION__TRANSFORMATION:
				setTransformation((Transformation)newValue);
				return;
			case QVTcConfigPackage.CONFIGURATION__MIDDLE:
				setMiddle((Direction)newValue);
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
			case QVTcConfigPackage.CONFIGURATION__INPUT_DIRECTION:
				setInputDirection((Direction)null);
				return;
			case QVTcConfigPackage.CONFIGURATION__OUTPUT_DIRECTION:
				getOutputDirection().clear();
				return;
			case QVTcConfigPackage.CONFIGURATION__MODE:
				setMode(MODE_EDEFAULT);
				return;
			case QVTcConfigPackage.CONFIGURATION__TRANSFORMATION:
				setTransformation((Transformation)null);
				return;
			case QVTcConfigPackage.CONFIGURATION__MIDDLE:
				setMiddle((Direction)null);
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
			case QVTcConfigPackage.CONFIGURATION__INPUT_DIRECTION:
				return inputDirection != null;
			case QVTcConfigPackage.CONFIGURATION__OUTPUT_DIRECTION:
				return outputDirection != null && !outputDirection.isEmpty();
			case QVTcConfigPackage.CONFIGURATION__MODE:
				return mode != MODE_EDEFAULT;
			case QVTcConfigPackage.CONFIGURATION__TRANSFORMATION:
				return transformation != null;
			case QVTcConfigPackage.CONFIGURATION__MIDDLE:
				return middle != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (mode: ");
		result.append(mode);
		result.append(')');
		return result.toString();
	}

} //ConfigurationImpl
