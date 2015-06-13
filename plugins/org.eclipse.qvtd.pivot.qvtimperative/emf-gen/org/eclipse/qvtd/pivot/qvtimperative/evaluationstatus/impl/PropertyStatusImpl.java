/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.PropertyStatus;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.PropertyStatusImpl#isIsAssignable <em>Is Assignable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.PropertyStatusImpl#isIsAssigned <em>Is Assigned</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.PropertyStatusImpl#isIsDirty <em>Is Dirty</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.PropertyStatusImpl#isIsError <em>Is Error</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.PropertyStatusImpl#isIsReady <em>Is Ready</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class PropertyStatusImpl extends ElementStatusImpl implements PropertyStatus {
	/**
	 * The default value of the '{@link #isIsAssignable() <em>Is Assignable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAssignable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ASSIGNABLE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAssignable() <em>Is Assignable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAssignable()
	 * @generated
	 * @ordered
	 */
	protected boolean isAssignable = IS_ASSIGNABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsAssigned() <em>Is Assigned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAssigned()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ASSIGNED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsAssigned() <em>Is Assigned</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsAssigned()
	 * @generated
	 * @ordered
	 */
	protected boolean isAssigned = IS_ASSIGNED_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsDirty() <em>Is Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDirty()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_DIRTY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsDirty() <em>Is Dirty</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsDirty()
	 * @generated
	 * @ordered
	 */
	protected boolean isDirty = IS_DIRTY_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsError() <em>Is Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsError()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ERROR_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsError() <em>Is Error</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsError()
	 * @generated
	 * @ordered
	 */
	protected boolean isError = IS_ERROR_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsReady() <em>Is Ready</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReady()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_READY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsReady() <em>Is Ready</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsReady()
	 * @generated
	 * @ordered
	 */
	protected boolean isReady = IS_READY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvaluationStatusPackage.Literals.PROPERTY_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAssignable() {
		return isAssignable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAssignable(boolean newIsAssignable) {
		boolean oldIsAssignable = isAssignable;
		isAssignable = newIsAssignable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNABLE, oldIsAssignable, isAssignable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsAssigned() {
		return isAssigned;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsAssigned(boolean newIsAssigned) {
		boolean oldIsAssigned = isAssigned;
		isAssigned = newIsAssigned;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNED, oldIsAssigned, isAssigned));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsDirty() {
		return isDirty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsDirty(boolean newIsDirty) {
		boolean oldIsDirty = isDirty;
		isDirty = newIsDirty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.PROPERTY_STATUS__IS_DIRTY, oldIsDirty, isDirty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsError() {
		return isError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsError(boolean newIsError) {
		boolean oldIsError = isError;
		isError = newIsError;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.PROPERTY_STATUS__IS_ERROR, oldIsError, isError));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsReady() {
		return isReady;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsReady(boolean newIsReady) {
		boolean oldIsReady = isReady;
		isReady = newIsReady;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.PROPERTY_STATUS__IS_READY, oldIsReady, isReady));
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
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNABLE:
				return isIsAssignable();
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNED:
				return isIsAssigned();
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_DIRTY:
				return isIsDirty();
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ERROR:
				return isIsError();
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_READY:
				return isIsReady();
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
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNABLE:
				setIsAssignable((Boolean)newValue);
				return;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNED:
				setIsAssigned((Boolean)newValue);
				return;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_DIRTY:
				setIsDirty((Boolean)newValue);
				return;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ERROR:
				setIsError((Boolean)newValue);
				return;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_READY:
				setIsReady((Boolean)newValue);
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
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNABLE:
				setIsAssignable(IS_ASSIGNABLE_EDEFAULT);
				return;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNED:
				setIsAssigned(IS_ASSIGNED_EDEFAULT);
				return;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_DIRTY:
				setIsDirty(IS_DIRTY_EDEFAULT);
				return;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ERROR:
				setIsError(IS_ERROR_EDEFAULT);
				return;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_READY:
				setIsReady(IS_READY_EDEFAULT);
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
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNABLE:
				return isAssignable != IS_ASSIGNABLE_EDEFAULT;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ASSIGNED:
				return isAssigned != IS_ASSIGNED_EDEFAULT;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_DIRTY:
				return isDirty != IS_DIRTY_EDEFAULT;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_ERROR:
				return isError != IS_ERROR_EDEFAULT;
			case EvaluationStatusPackage.PROPERTY_STATUS__IS_READY:
				return isReady != IS_READY_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}


} //PropertyStatusImpl
