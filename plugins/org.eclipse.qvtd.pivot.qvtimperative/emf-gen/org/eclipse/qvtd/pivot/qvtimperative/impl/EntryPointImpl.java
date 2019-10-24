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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.pivot.qvtbase.impl.RuleImpl;

import org.eclipse.qvtd.pivot.qvtimperative.EntryPoint;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;

import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Point</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.EntryPointImpl#getInputTypedModels <em>Input Typed Models</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.EntryPointImpl#getOutputTypedModels <em>Output Typed Models</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.EntryPointImpl#getTargetName <em>Target Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntryPointImpl extends MappingImpl implements EntryPoint {
	/**
	 * The number of structural features of the '<em>Entry Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ENTRY_POINT_FEATURE_COUNT = MappingImpl.MAPPING_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Entry Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ENTRY_POINT_OPERATION_COUNT = MappingImpl.MAPPING_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getInputTypedModels() <em>Input Typed Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputTypedModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedModel> inputTypedModels;

	/**
	 * The cached value of the '{@link #getOutputTypedModels() <em>Output Typed Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputTypedModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedModel> outputTypedModels;

	/**
	 * The default value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetName()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetName() <em>Target Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetName()
	 * @generated
	 * @ordered
	 */
	protected String targetName = TARGET_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntryPointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.ENTRY_POINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypedModel> getInputTypedModels() {
		if (inputTypedModels == null) {
			inputTypedModels = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, RuleImpl.RULE_FEATURE_COUNT + 5);
		}
		return inputTypedModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypedModel> getOutputTypedModels() {
		if (outputTypedModels == null) {
			outputTypedModels = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, RuleImpl.RULE_FEATURE_COUNT + 6);
		}
		return outputTypedModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTargetName() {
		return targetName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetName(String newTargetName) {
		String oldTargetName = targetName;
		targetName = newTargetName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RuleImpl.RULE_FEATURE_COUNT + 7, oldTargetName, targetName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				return getInputTypedModels();
			case RuleImpl.RULE_FEATURE_COUNT + 6:
				return getOutputTypedModels();
			case RuleImpl.RULE_FEATURE_COUNT + 7:
				return getTargetName();
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
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				getInputTypedModels().clear();
			getInputTypedModels().addAll((Collection<? extends TypedModel>)newValue);
			return;
			case RuleImpl.RULE_FEATURE_COUNT + 6:
				getOutputTypedModels().clear();
			getOutputTypedModels().addAll((Collection<? extends TypedModel>)newValue);
			return;
			case RuleImpl.RULE_FEATURE_COUNT + 7:
				setTargetName((String)newValue);
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
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				getInputTypedModels().clear();
			return;
			case RuleImpl.RULE_FEATURE_COUNT + 6:
				getOutputTypedModels().clear();
			return;
			case RuleImpl.RULE_FEATURE_COUNT + 7:
				setTargetName(TARGET_NAME_EDEFAULT);
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
			case RuleImpl.RULE_FEATURE_COUNT + 5:
				return inputTypedModels != null && !inputTypedModels.isEmpty();
			case RuleImpl.RULE_FEATURE_COUNT + 6:
				return outputTypedModels != null && !outputTypedModels.isEmpty();
			case RuleImpl.RULE_FEATURE_COUNT + 7:
				return TARGET_NAME_EDEFAULT == null ? targetName != null : !TARGET_NAME_EDEFAULT.equals(targetName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		if (visitor instanceof QVTimperativeVisitor) {
			return (R) ((QVTimperativeVisitor<?>)visitor).visitEntryPoint(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //EntryPointImpl
