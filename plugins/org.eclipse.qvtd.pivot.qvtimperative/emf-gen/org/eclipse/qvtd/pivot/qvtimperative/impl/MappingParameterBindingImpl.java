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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.qvtd.pivot.qvtimperative.MappingCall;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapping Parameter Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl#getMappingCall <em>Mapping Call</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MappingParameterBindingImpl#getBoundVariable <em>Bound Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class MappingParameterBindingImpl extends ElementImpl implements MappingParameterBinding {
	/**
	 * The cached value of the '{@link #getBoundVariable() <em>Bound Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBoundVariable()
	 * @generated
	 * @ordered
	 */
	protected MappingParameter boundVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappingParameterBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MAPPING_PARAMETER_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingCall getMappingCall() {
		if (eContainerFeatureID() != QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL) return null;
		return (MappingCall)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingCall(MappingCall newMappingCall, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappingCall, QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappingCall(MappingCall newMappingCall) {
		if (newMappingCall != eInternalContainer() || (eContainerFeatureID() != QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL && newMappingCall != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL, newMappingCall, newMappingCall));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingParameter getBoundVariable() {
		if (boundVariable != null && boundVariable.eIsProxy()) {
			InternalEObject oldBoundVariable = (InternalEObject)boundVariable;
			boundVariable = (MappingParameter)eResolveProxy(oldBoundVariable);
			if (boundVariable != oldBoundVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE, oldBoundVariable, boundVariable));
			}
		}
		return boundVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingParameter basicGetBoundVariable() {
		return boundVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBoundVariable(MappingParameter newBoundVariable) {
		MappingParameter oldBoundVariable = boundVariable;
		boundVariable = newBoundVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE, oldBoundVariable, boundVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL:
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL:
				return basicSetMappingCall(null, msgs);
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL:
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL:
				return getMappingCall();
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE:
				if (resolve) return getBoundVariable();
				return basicGetBoundVariable();
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL:
				setMappingCall((MappingCall)newValue);
				return;
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE:
				setBoundVariable((MappingParameter)newValue);
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL:
				setMappingCall((MappingCall)null);
				return;
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE:
				setBoundVariable((MappingParameter)null);
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
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__MAPPING_CALL:
				return getMappingCall() != null;
			case QVTimperativePackage.MAPPING_PARAMETER_BINDING__BOUND_VARIABLE:
				return boundVariable != null;
		}
		return super.eIsSet(featureID);
	}


} //MappingParameterBindingImpl
