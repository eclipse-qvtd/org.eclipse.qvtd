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
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;
import org.eclipse.ocl.xtext.essentialoclcs.ExpCS;
import org.eclipse.ocl.xtext.essentialoclcs.impl.ExpCSImpl;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallBindingCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.MappingCallCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;
import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Call Binding CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallBindingCSImpl#isIsPolled <em>Is Polled</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallBindingCSImpl#getOwnedValue <em>Owned Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallBindingCSImpl#getOwningMappingCall <em>Owning Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.MappingCallBindingCSImpl#getReferredVariable <em>Referred Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MappingCallBindingCSImpl extends ExpCSImpl implements MappingCallBindingCS {
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
	protected Variable referredVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingCallBindingCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.MAPPING_CALL_BINDING_CS;
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
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__IS_POLLED, oldIsPolled, isPolled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingCallCS getOwningMappingCall() {
		if (eContainerFeatureID() != QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL) return null;
		return (MappingCallCS)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningMappingCall(MappingCallCS newOwningMappingCall, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningMappingCall, QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningMappingCall(MappingCallCS newOwningMappingCall) {
		if (newOwningMappingCall != eInternalContainer() || (eContainerFeatureID() != QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL && newOwningMappingCall != null)) {
			if (EcoreUtil.isAncestor(this, newOwningMappingCall))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningMappingCall != null)
				msgs = ((InternalEObject)newOwningMappingCall).eInverseAdd(this, QVTimperativeCSPackage.MAPPING_CALL_CS__OWNED_BINDINGS, MappingCallCS.class, msgs);
			msgs = basicSetOwningMappingCall(newOwningMappingCall, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL, newOwningMappingCall, newOwningMappingCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variable getReferredVariable() {
		if (referredVariable != null && referredVariable.eIsProxy()) {
			InternalEObject oldReferredVariable = (InternalEObject)referredVariable;
			referredVariable = (Variable)eResolveProxy(oldReferredVariable);
			if (referredVariable != oldReferredVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
			}
		}
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable basicGetReferredVariable() {
		return referredVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredVariable(Variable newReferredVariable) {
		Variable oldReferredVariable = referredVariable;
		referredVariable = newReferredVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE, oldReferredVariable, referredVariable));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNED_VALUE, oldOwnedValue, newOwnedValue);
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
				msgs = ((InternalEObject)ownedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNED_VALUE, null, msgs);
			if (newOwnedValue != null)
				msgs = ((InternalEObject)newOwnedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNED_VALUE, null, msgs);
			msgs = basicSetOwnedValue(newOwnedValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNED_VALUE, newOwnedValue, newOwnedValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningMappingCall((MappingCallCS)otherEnd, msgs);
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
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNED_VALUE:
				return basicSetOwnedValue(null, msgs);
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL:
				return basicSetOwningMappingCall(null, msgs);
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
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL:
				return eInternalContainer().eInverseRemove(this, QVTimperativeCSPackage.MAPPING_CALL_CS__OWNED_BINDINGS, MappingCallCS.class, msgs);
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
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__IS_POLLED:
				return isIsPolled();
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNED_VALUE:
				return getOwnedValue();
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL:
				return getOwningMappingCall();
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE:
				if (resolve) return getReferredVariable();
				return basicGetReferredVariable();
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
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__IS_POLLED:
				setIsPolled((Boolean)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNED_VALUE:
				setOwnedValue((ExpCS)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL:
				setOwningMappingCall((MappingCallCS)newValue);
				return;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE:
				setReferredVariable((Variable)newValue);
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
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__IS_POLLED:
				setIsPolled(IS_POLLED_EDEFAULT);
				return;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNED_VALUE:
				setOwnedValue((ExpCS)null);
				return;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL:
				setOwningMappingCall((MappingCallCS)null);
				return;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE:
				setReferredVariable((Variable)null);
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
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__IS_POLLED:
				return isPolled != IS_POLLED_EDEFAULT;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNED_VALUE:
				return ownedValue != null;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__OWNING_MAPPING_CALL:
				return getOwningMappingCall() != null;
			case QVTimperativeCSPackage.MAPPING_CALL_BINDING_CS__REFERRED_VARIABLE:
				return referredVariable != null;
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
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitMappingCallBindingCS(this);
	}
} //MappingCallBindingCSImpl
