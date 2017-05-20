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
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;

import org.eclipse.qvtd.xtext.qvtimperativecs.GuardParameterCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;

import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Parameter CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.GuardParameterCSImpl#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.GuardParameterCSImpl#getSuccessProperty <em>Success Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GuardParameterCSImpl extends MappingParameterCSImpl implements GuardParameterCS {
	/**
	 * The cached value of the '{@link #getReferredTypedModel() <em>Referred Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredTypedModel()
	 * @generated
	 * @ordered
	 */
	protected ImperativeTypedModel referredTypedModel;

	/**
	 * The cached value of the '{@link #getSuccessProperty() <em>Success Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessProperty()
	 * @generated
	 * @ordered
	 */
	protected Property successProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GuardParameterCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.GUARD_PARAMETER_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImperativeTypedModel getReferredTypedModel() {
		if (referredTypedModel != null && referredTypedModel.eIsProxy()) {
			InternalEObject oldReferredTypedModel = (InternalEObject)referredTypedModel;
			referredTypedModel = (ImperativeTypedModel)eResolveProxy(oldReferredTypedModel);
			if (referredTypedModel != oldReferredTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativeCSPackage.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL, oldReferredTypedModel, referredTypedModel));
			}
		}
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImperativeTypedModel basicGetReferredTypedModel() {
		return referredTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredTypedModel(ImperativeTypedModel newReferredTypedModel) {
		ImperativeTypedModel oldReferredTypedModel = referredTypedModel;
		referredTypedModel = newReferredTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL, oldReferredTypedModel, referredTypedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getSuccessProperty() {
		if (successProperty != null && successProperty.eIsProxy()) {
			InternalEObject oldSuccessProperty = (InternalEObject)successProperty;
			successProperty = (Property)eResolveProxy(oldSuccessProperty);
			if (successProperty != oldSuccessProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTimperativeCSPackage.GUARD_PARAMETER_CS__SUCCESS_PROPERTY, oldSuccessProperty, successProperty));
			}
		}
		return successProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetSuccessProperty() {
		return successProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuccessProperty(Property newSuccessProperty) {
		Property oldSuccessProperty = successProperty;
		successProperty = newSuccessProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativeCSPackage.GUARD_PARAMETER_CS__SUCCESS_PROPERTY, oldSuccessProperty, successProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTimperativeCSPackage.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL:
				if (resolve) return getReferredTypedModel();
				return basicGetReferredTypedModel();
			case QVTimperativeCSPackage.GUARD_PARAMETER_CS__SUCCESS_PROPERTY:
				if (resolve) return getSuccessProperty();
				return basicGetSuccessProperty();
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
			case QVTimperativeCSPackage.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL:
				setReferredTypedModel((ImperativeTypedModel)newValue);
				return;
			case QVTimperativeCSPackage.GUARD_PARAMETER_CS__SUCCESS_PROPERTY:
				setSuccessProperty((Property)newValue);
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
			case QVTimperativeCSPackage.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL:
				setReferredTypedModel((ImperativeTypedModel)null);
				return;
			case QVTimperativeCSPackage.GUARD_PARAMETER_CS__SUCCESS_PROPERTY:
				setSuccessProperty((Property)null);
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
			case QVTimperativeCSPackage.GUARD_PARAMETER_CS__REFERRED_TYPED_MODEL:
				return referredTypedModel != null;
			case QVTimperativeCSPackage.GUARD_PARAMETER_CS__SUCCESS_PROPERTY:
				return successProperty != null;
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
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitGuardParameterCS(this);
	}

} //GuardParameterCSImpl
