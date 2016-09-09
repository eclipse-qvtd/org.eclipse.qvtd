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

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;

import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Add Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl#getTargetVariable <em>Target Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.AddStatementImpl#isIsEnforceadUnique <em>Is Enforcead Unique</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AddStatementImpl extends MappingStatementImpl implements AddStatement {
	/**
	 * The cached value of the '{@link #getTargetVariable() <em>Target Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetVariable()
	 * @generated
	 * @ordered
	 */
	protected ConnectionVariable targetVariable;

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
	 * The default value of the '{@link #isIsEnforceadUnique() <em>Is Enforcead Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceadUnique()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCEAD_UNIQUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsEnforceadUnique() <em>Is Enforcead Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceadUnique()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforceadUnique = IS_ENFORCEAD_UNIQUE_EDEFAULT;

	/**
	 * This is true if the Is Enforcead Unique attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforceadUniqueESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AddStatementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.ADD_STATEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConnectionVariable getTargetVariable() {
		if (targetVariable != null && targetVariable.eIsProxy()) {
			InternalEObject oldTargetVariable = (InternalEObject)targetVariable;
			targetVariable = (ConnectionVariable)eResolveProxy(oldTargetVariable);
			if (targetVariable != oldTargetVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
			}
		}
		return targetVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectionVariable basicGetTargetVariable() {
		return targetVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetVariable(ConnectionVariable newTargetVariable) {
		ConnectionVariable oldTargetVariable = targetVariable;
		targetVariable = newTargetVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ADD_STATEMENT__VALUE, oldValue, newValue);
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
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.ADD_STATEMENT__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.ADD_STATEMENT__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ADD_STATEMENT__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsEnforceadUnique() {
		return isEnforceadUnique;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsEnforceadUnique(boolean newIsEnforceadUnique) {
		boolean oldIsEnforceadUnique = isEnforceadUnique;
		isEnforceadUnique = newIsEnforceadUnique;
		boolean oldIsEnforceadUniqueESet = isEnforceadUniqueESet;
		isEnforceadUniqueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.ADD_STATEMENT__IS_ENFORCEAD_UNIQUE, oldIsEnforceadUnique, isEnforceadUnique, !oldIsEnforceadUniqueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsEnforceadUnique() {
		boolean oldIsEnforceadUnique = isEnforceadUnique;
		boolean oldIsEnforceadUniqueESet = isEnforceadUniqueESet;
		isEnforceadUnique = IS_ENFORCEAD_UNIQUE_EDEFAULT;
		isEnforceadUniqueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTimperativePackage.ADD_STATEMENT__IS_ENFORCEAD_UNIQUE, oldIsEnforceadUnique, IS_ENFORCEAD_UNIQUE_EDEFAULT, oldIsEnforceadUniqueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsEnforceadUnique() {
		return isEnforceadUniqueESet;
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
			case QVTimperativePackage.ADD_STATEMENT__VALUE:
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
			case QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE:
				if (resolve) return getTargetVariable();
				return basicGetTargetVariable();
			case QVTimperativePackage.ADD_STATEMENT__VALUE:
				return getValue();
			case QVTimperativePackage.ADD_STATEMENT__IS_ENFORCEAD_UNIQUE:
				return isIsEnforceadUnique();
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
			case QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE:
				setTargetVariable((ConnectionVariable)newValue);
				return;
			case QVTimperativePackage.ADD_STATEMENT__VALUE:
				setValue((OCLExpression)newValue);
				return;
			case QVTimperativePackage.ADD_STATEMENT__IS_ENFORCEAD_UNIQUE:
				setIsEnforceadUnique((Boolean)newValue);
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
			case QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE:
				setTargetVariable((ConnectionVariable)null);
				return;
			case QVTimperativePackage.ADD_STATEMENT__VALUE:
				setValue((OCLExpression)null);
				return;
			case QVTimperativePackage.ADD_STATEMENT__IS_ENFORCEAD_UNIQUE:
				unsetIsEnforceadUnique();
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
			case QVTimperativePackage.ADD_STATEMENT__TARGET_VARIABLE:
				return targetVariable != null;
			case QVTimperativePackage.ADD_STATEMENT__VALUE:
				return value != null;
			case QVTimperativePackage.ADD_STATEMENT__IS_ENFORCEAD_UNIQUE:
				return isSetIsEnforceadUnique();
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
		return (R) ((QVTimperativeVisitor<?>)visitor).visitAddStatement(this);
	}

} //AddStatementImpl
