/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCallBinding;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Call Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl#getBoundVariable <em>Bound Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl#isIsPolled <em>Is Polled</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl#getMappingCall <em>Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingCallBindingImpl#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingCallBindingImpl extends ElementImpl implements MappingCallBinding {
	/**
	 * The cached value of the '{@link #getBoundVariable() <em>Bound Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundVariable()
	 * @generated
	 * @ordered
	 */
	protected Variable boundVariable;

	/**
	 * The default value of the '{@link #isIsPolled() <em>Is Polled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPolled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_POLLED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsPolled() <em>Is Polled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsPolled()
	 * @generated
	 * @ordered
	 */
	protected boolean isPolled = IS_POLLED_EDEFAULT;

	/**
	 * This is true if the Is Polled attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean isPolledESet;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingCallBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING_CALL_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingCall getMappingCall() {
		if (eContainerFeatureID() != QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL) return null;
		return (MappingCall)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingCall(MappingCall newMappingCall, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappingCall, QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappingCall(MappingCall newMappingCall) {
		if (newMappingCall != eInternalContainer() || (eContainerFeatureID() != QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL && newMappingCall != null)) {
			if (EcoreUtil.isAncestor(this, newMappingCall))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappingCall != null)
				msgs = ((InternalEObject)newMappingCall).eInverseAdd(this, QVTimperativePackage.MAPPING_CALL__BINDING, MappingCall.class, msgs);
			msgs = basicSetMappingCall(newMappingCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL, newMappingCall, newMappingCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getBoundVariable() {
		if (boundVariable != null && boundVariable.eIsProxy()) {
			InternalEObject oldBoundVariable = (InternalEObject)boundVariable;
			boundVariable = (Variable)eResolveProxy(oldBoundVariable);
			if (boundVariable != oldBoundVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.MAPPING_CALL_BINDING__BOUND_VARIABLE, oldBoundVariable, boundVariable));
			}
		}
		return boundVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetBoundVariable() {
		return boundVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoundVariable(Variable newBoundVariable) {
		Variable oldBoundVariable = boundVariable;
		boundVariable = newBoundVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_CALL_BINDING__BOUND_VARIABLE, oldBoundVariable, boundVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsPolled() {
		return isPolled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsPolled(boolean newIsPolled) {
		boolean oldIsPolled = isPolled;
		isPolled = newIsPolled;
		boolean oldIsPolledESet = isPolledESet;
		isPolledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_CALL_BINDING__IS_POLLED, oldIsPolled, isPolled, !oldIsPolledESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetIsPolled() {
		boolean oldIsPolled = isPolled;
		boolean oldIsPolledESet = isPolledESet;
		isPolled = IS_POLLED_EDEFAULT;
		isPolledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, QVTimperativePackage.MAPPING_CALL_BINDING__IS_POLLED, oldIsPolled, IS_POLLED_EDEFAULT, oldIsPolledESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetIsPolled() {
		return isPolledESet;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_CALL_BINDING__VALUE, oldValue, newValue);
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
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING_CALL_BINDING__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativePackage.MAPPING_CALL_BINDING__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_CALL_BINDING__VALUE, newValue, newValue));
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappingCall((MappingCall)otherEnd, msgs);
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
			case QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL:
				return basicSetMappingCall(null, msgs);
			case QVTimperativePackage.MAPPING_CALL_BINDING__VALUE:
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
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL:
				return eInternalContainer().eInverseRemove(this, QVTimperativePackage.MAPPING_CALL__BINDING, MappingCall.class, msgs);
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
			case QVTimperativePackage.MAPPING_CALL_BINDING__BOUND_VARIABLE:
				if (resolve) return getBoundVariable();
				return basicGetBoundVariable();
			case QVTimperativePackage.MAPPING_CALL_BINDING__IS_POLLED:
				return isIsPolled();
			case QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL:
				return getMappingCall();
			case QVTimperativePackage.MAPPING_CALL_BINDING__VALUE:
				return getValue();
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
			case QVTimperativePackage.MAPPING_CALL_BINDING__BOUND_VARIABLE:
				setBoundVariable((Variable)newValue);
				return;
			case QVTimperativePackage.MAPPING_CALL_BINDING__IS_POLLED:
				setIsPolled((Boolean)newValue);
				return;
			case QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL:
				setMappingCall((MappingCall)newValue);
				return;
			case QVTimperativePackage.MAPPING_CALL_BINDING__VALUE:
				setValue((OCLExpression)newValue);
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
			case QVTimperativePackage.MAPPING_CALL_BINDING__BOUND_VARIABLE:
				setBoundVariable((Variable)null);
				return;
			case QVTimperativePackage.MAPPING_CALL_BINDING__IS_POLLED:
				unsetIsPolled();
				return;
			case QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL:
				setMappingCall((MappingCall)null);
				return;
			case QVTimperativePackage.MAPPING_CALL_BINDING__VALUE:
				setValue((OCLExpression)null);
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
			case QVTimperativePackage.MAPPING_CALL_BINDING__BOUND_VARIABLE:
				return boundVariable != null;
			case QVTimperativePackage.MAPPING_CALL_BINDING__IS_POLLED:
				return isSetIsPolled();
			case QVTimperativePackage.MAPPING_CALL_BINDING__MAPPING_CALL:
				return getMappingCall() != null;
			case QVTimperativePackage.MAPPING_CALL_BINDING__VALUE:
				return value != null;
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
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTimperativeVisitor<?>)visitor).visitMappingCallBinding(this);
	}
} //MappingCallBindingImpl
