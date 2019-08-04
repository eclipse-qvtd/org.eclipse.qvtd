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
package org.eclipse.qvtd.xtext.qvtimperativecs.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.xtext.qvtimperativecs.EntryPointCS;
import org.eclipse.qvtd.xtext.qvtimperativecs.QVTimperativeCSPackage;

import org.eclipse.qvtd.xtext.qvtimperativecs.util.QVTimperativeCSVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Point CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.EntryPointCSImpl#getCheckedTypedModels <em>Checked Typed Models</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.EntryPointCSImpl#getEnforcedTypedModels <em>Enforced Typed Models</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntryPointCSImpl extends MappingCSImpl implements EntryPointCS {
	/**
	 * The number of structural features of the '<em>Entry Point CS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ENTRY_POINT_CS_FEATURE_COUNT = MappingCSImpl.MAPPING_CS_FEATURE_COUNT + 2;


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
	protected EntryPointCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativeCSPackage.Literals.ENTRY_POINT_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TypedModel> getCheckedTypedModels() {
		if (checkedTypedModels == null) {
			checkedTypedModels = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6);
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
			enforcedTypedModels = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7);
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				return getCheckedTypedModels();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7:
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				getCheckedTypedModels().clear();
				getCheckedTypedModels().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7:
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				getCheckedTypedModels().clear();
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7:
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				return checkedTypedModels != null && !checkedTypedModels.isEmpty();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7:
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
	public <R> R accept(@NonNull BaseCSVisitor<R> visitor) {
		return (R) ((QVTimperativeCSVisitor<?>)visitor).visitEntryPointCS(this);
	}

} //EntryPointCSImpl
