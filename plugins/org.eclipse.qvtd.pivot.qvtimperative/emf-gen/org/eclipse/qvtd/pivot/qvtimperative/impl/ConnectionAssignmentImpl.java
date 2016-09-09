/**
 * <copyright>
 *
 * Copyright (c) 2013, 2016 Willink Transformations and others.
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionAssignmentImpl#getTargetVariable <em>Target Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.ConnectionAssignmentImpl#isIsEnforceadUnqiue <em>Is Enforcead Unqiue</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConnectionAssignmentImpl extends AssignmentImpl implements ConnectionAssignment {
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
	 * The default value of the '{@link #isIsEnforceadUnqiue() <em>Is Enforcead Unqiue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceadUnqiue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENFORCEAD_UNQIUE_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isIsEnforceadUnqiue() <em>Is Enforcead Unqiue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsEnforceadUnqiue()
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforceadUnqiue = IS_ENFORCEAD_UNQIUE_EDEFAULT;
	/**
	 * This is true if the Is Enforcead Unqiue attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isEnforceadUnqiueESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.CONNECTION_ASSIGNMENT;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.CONNECTION_ASSIGNMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.CONNECTION_ASSIGNMENT__TARGET_VARIABLE, oldTargetVariable, targetVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsEnforceadUnqiue() {
		return isEnforceadUnqiue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsEnforceadUnqiue(boolean newIsEnforceadUnqiue) {
		boolean oldIsEnforceadUnqiue = isEnforceadUnqiue;
		isEnforceadUnqiue = newIsEnforceadUnqiue;
		boolean oldIsEnforceadUnqiueESet = isEnforceadUnqiueESet;
		isEnforceadUnqiueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.CONNECTION_ASSIGNMENT__IS_ENFORCEAD_UNQIUE, oldIsEnforceadUnqiue, isEnforceadUnqiue, !oldIsEnforceadUnqiueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsEnforceadUnqiue() {
		boolean oldIsEnforceadUnqiue = isEnforceadUnqiue;
		boolean oldIsEnforceadUnqiueESet = isEnforceadUnqiueESet;
		isEnforceadUnqiue = IS_ENFORCEAD_UNQIUE_EDEFAULT;
		isEnforceadUnqiueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTimperativePackage.CONNECTION_ASSIGNMENT__IS_ENFORCEAD_UNQIUE, oldIsEnforceadUnqiue, IS_ENFORCEAD_UNQIUE_EDEFAULT, oldIsEnforceadUnqiueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsEnforceadUnqiue() {
		return isEnforceadUnqiueESet;
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTimperativePackage.CONNECTION_ASSIGNMENT__TARGET_VARIABLE:
				if (resolve) return getTargetVariable();
				return basicGetTargetVariable();
			case QVTimperativePackage.CONNECTION_ASSIGNMENT__IS_ENFORCEAD_UNQIUE:
				return isIsEnforceadUnqiue();
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
			case QVTimperativePackage.CONNECTION_ASSIGNMENT__TARGET_VARIABLE:
				setTargetVariable((ConnectionVariable)newValue);
				return;
			case QVTimperativePackage.CONNECTION_ASSIGNMENT__IS_ENFORCEAD_UNQIUE:
				setIsEnforceadUnqiue((Boolean)newValue);
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
			case QVTimperativePackage.CONNECTION_ASSIGNMENT__TARGET_VARIABLE:
				setTargetVariable((ConnectionVariable)null);
				return;
			case QVTimperativePackage.CONNECTION_ASSIGNMENT__IS_ENFORCEAD_UNQIUE:
				unsetIsEnforceadUnqiue();
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
			case QVTimperativePackage.CONNECTION_ASSIGNMENT__TARGET_VARIABLE:
				return targetVariable != null;
			case QVTimperativePackage.CONNECTION_ASSIGNMENT__IS_ENFORCEAD_UNQIUE:
				return isSetIsEnforceadUnqiue();
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
		return (R) ((QVTimperativeVisitor<?>)visitor).visitConnectionAssignment(this);
	}

} //ConnectionAssignmentImpl
