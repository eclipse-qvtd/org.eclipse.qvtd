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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.EntryPointImpl#getCheckedTypedModels <em>Checked Typed Models</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.EntryPointImpl#getEnforcedTypedModels <em>Enforced Typed Models</em>}</li>
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
	public static final int ENTRY_POINT_FEATURE_COUNT = MappingImpl.MAPPING_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Entry Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ENTRY_POINT_OPERATION_COUNT = MappingImpl.MAPPING_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getCheckedTypedModels() <em>Checked Typed Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckedTypedModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedModel> checkedTypedModels;

	/**
	 * The cached value of the '{@link #getEnforcedTypedModels() <em>Enforced Typed Models</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcedTypedModels()
	 * @generated
	 * @ordered
	 */
	protected EList<TypedModel> enforcedTypedModels;

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
	public EList<TypedModel> getCheckedTypedModels() {
		if (checkedTypedModels == null) {
			checkedTypedModels = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, RuleImpl.RULE_FEATURE_COUNT + 5);
		}
		return checkedTypedModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypedModel> getEnforcedTypedModels() {
		if (enforcedTypedModels == null) {
			enforcedTypedModels = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, RuleImpl.RULE_FEATURE_COUNT + 6);
		}
		return enforcedTypedModels;
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
				return getCheckedTypedModels();
			case RuleImpl.RULE_FEATURE_COUNT + 6:
				return getEnforcedTypedModels();
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
				getCheckedTypedModels().clear();
				getCheckedTypedModels().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 6:
				getEnforcedTypedModels().clear();
				getEnforcedTypedModels().addAll((Collection<? extends TypedModel>)newValue);
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
				getCheckedTypedModels().clear();
				return;
			case RuleImpl.RULE_FEATURE_COUNT + 6:
				getEnforcedTypedModels().clear();
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
				return checkedTypedModels != null && !checkedTypedModels.isEmpty();
			case RuleImpl.RULE_FEATURE_COUNT + 6:
				return enforcedTypedModels != null && !enforcedTypedModels.isEmpty();
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
			return (R) ((QVTimperativeVisitor<?>)visitor).visitEntryPoint(this);
		}
		catch (ClassCastException e) {
			return super.accept(visitor);
		}
	}

} //EntryPointImpl
