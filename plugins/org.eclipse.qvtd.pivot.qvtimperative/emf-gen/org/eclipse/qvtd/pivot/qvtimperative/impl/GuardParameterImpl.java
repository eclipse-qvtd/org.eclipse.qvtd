/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtimperative.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.internal.VariableDeclarationImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Guard Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterImpl#getReferredTypedModel <em>Referred Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.GuardParameterImpl#getSuccessProperty <em>Success Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GuardParameterImpl extends MappingParameterImpl implements GuardParameter {
	/**
	 * The number of structural features of the '<em>Guard Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_PARAMETER_FEATURE_COUNT = MappingParameterImpl.MAPPING_PARAMETER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Guard Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int GUARD_PARAMETER_OPERATION_COUNT = MappingParameterImpl.MAPPING_PARAMETER_OPERATION_COUNT + 0;

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
	protected GuardParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.GUARD_PARAMETER;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1, oldReferredTypedModel, referredTypedModel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1, oldReferredTypedModel, referredTypedModel));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2, oldSuccessProperty, successProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2, oldSuccessProperty, successProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				if (resolve) return getReferredTypedModel();
				return basicGetReferredTypedModel();
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				setReferredTypedModel((ImperativeTypedModel)newValue);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				setReferredTypedModel((ImperativeTypedModel)null);
				return;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
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
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 1:
				return referredTypedModel != null;
			case VariableDeclarationImpl.VARIABLE_DECLARATION_FEATURE_COUNT + 2:
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
	public <R> R accept(@NonNull Visitor<R> visitor) {
		try {
			return (R) ((QVTimperativeVisitor<?>)visitor).visitGuardParameter(this);
		}
		catch (ClassCastException e) {
			return super.accept(visitor);
		}
	}

} //GuardParameterImpl
