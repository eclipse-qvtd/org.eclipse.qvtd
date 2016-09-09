/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableExp;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;

import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#getSlotExpression <em>Slot Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#getTargetProperty <em>Target Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.SetStatementImpl#isIsOpposite <em>Is Opposite</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SetStatementImpl extends BottomStatementImpl implements SetStatement {
	/**
	 * The cached value of the '{@link #getSlotExpression() <em>Slot Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlotExpression()
	 * @generated
	 * @ordered
	 */
	protected VariableExp slotExpression;

	/**
	 * The cached value of the '{@link #getTargetProperty() <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProperty()
	 * @generated
	 * @ordered
	 */
	protected Property targetProperty;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression value;

	/**
	 * The default value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OPPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected boolean isOpposite = IS_OPPOSITE_EDEFAULT;

	/**
	 * This is true if the Is Opposite attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isOppositeESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SetStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.SET_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableExp getSlotExpression() {
		return slotExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSlotExpression(VariableExp newSlotExpression, NotificationChain msgs) {
		VariableExp oldSlotExpression = slotExpression;
		slotExpression = newSlotExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__SLOT_EXPRESSION, oldSlotExpression, newSlotExpression);
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
	public void setSlotExpression(VariableExp newSlotExpression) {
		if (newSlotExpression != slotExpression) {
			NotificationChain msgs = null;
			if (slotExpression != null)
				msgs = ((InternalEObject)slotExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.SET_STATEMENT__SLOT_EXPRESSION, null, msgs);
			if (newSlotExpression != null)
				msgs = ((InternalEObject)newSlotExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.SET_STATEMENT__SLOT_EXPRESSION, null, msgs);
			msgs = basicSetSlotExpression(newSlotExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__SLOT_EXPRESSION, newSlotExpression, newSlotExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getTargetProperty() {
		if (targetProperty != null && targetProperty.eIsProxy()) {
			InternalEObject oldTargetProperty = (InternalEObject)targetProperty;
			targetProperty = (Property)eResolveProxy(oldTargetProperty);
			if (targetProperty != oldTargetProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
			}
		}
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetTargetProperty() {
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetProperty(Property newTargetProperty) {
		Property oldTargetProperty = targetProperty;
		targetProperty = newTargetProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(OCLExpression newValue, NotificationChain msgs) {
		OCLExpression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__VALUE, oldValue, newValue);
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
	public void setValue(OCLExpression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.SET_STATEMENT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.SET_STATEMENT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOpposite() {
		return isOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOpposite(boolean newIsOpposite) {
		boolean oldIsOpposite = isOpposite;
		isOpposite = newIsOpposite;
		boolean oldIsOppositeESet = isOppositeESet;
		isOppositeESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE, oldIsOpposite, isOpposite, !oldIsOppositeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsOpposite() {
		boolean oldIsOpposite = isOpposite;
		boolean oldIsOppositeESet = isOppositeESet;
		isOpposite = IS_OPPOSITE_EDEFAULT;
		isOppositeESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE, oldIsOpposite, IS_OPPOSITE_EDEFAULT, oldIsOppositeESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsOpposite() {
		return isOppositeESet;
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
			case QVTimperativePackage.SET_STATEMENT__SLOT_EXPRESSION:
				return basicSetSlotExpression(null, msgs);
			case QVTimperativePackage.SET_STATEMENT__VALUE:
				return basicSetValue(null, msgs);
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
			case QVTimperativePackage.SET_STATEMENT__SLOT_EXPRESSION:
				return getSlotExpression();
			case QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY:
				if (resolve) return getTargetProperty();
				return basicGetTargetProperty();
			case QVTimperativePackage.SET_STATEMENT__VALUE:
				return getValue();
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				return isIsOpposite();
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
			case QVTimperativePackage.SET_STATEMENT__SLOT_EXPRESSION:
				setSlotExpression((VariableExp)newValue);
				return;
			case QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY:
				setTargetProperty((Property)newValue);
				return;
			case QVTimperativePackage.SET_STATEMENT__VALUE:
				setValue((OCLExpression)newValue);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				setIsOpposite((Boolean)newValue);
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
			case QVTimperativePackage.SET_STATEMENT__SLOT_EXPRESSION:
				setSlotExpression((VariableExp)null);
				return;
			case QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY:
				setTargetProperty((Property)null);
				return;
			case QVTimperativePackage.SET_STATEMENT__VALUE:
				setValue((OCLExpression)null);
				return;
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				unsetIsOpposite();
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
			case QVTimperativePackage.SET_STATEMENT__SLOT_EXPRESSION:
				return slotExpression != null;
			case QVTimperativePackage.SET_STATEMENT__TARGET_PROPERTY:
				return targetProperty != null;
			case QVTimperativePackage.SET_STATEMENT__VALUE:
				return value != null;
			case QVTimperativePackage.SET_STATEMENT__IS_OPPOSITE:
				return isSetIsOpposite();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitSetStatement(this);
	}

} //SetStatementImpl
