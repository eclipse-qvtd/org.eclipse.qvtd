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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.EntryPointCSImpl#getInputTypedModels <em>Input Typed Models</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.EntryPointCSImpl#getOutputTypedModels <em>Output Typed Models</em>}</li>
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
	public EList<TypedModel> getInputTypedModels() {
		if (inputTypedModels == null) {
			inputTypedModels = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5);
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
			outputTypedModels = new EObjectResolvingEList<TypedModel>(TypedModel.class, this, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6);
		}
		return outputTypedModels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5:
				return getInputTypedModels();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				return getOutputTypedModels();
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5:
				getInputTypedModels().clear();
				getInputTypedModels().addAll((Collection<? extends TypedModel>)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				getOutputTypedModels().clear();
				getOutputTypedModels().addAll((Collection<? extends TypedModel>)newValue);
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5:
				getInputTypedModels().clear();
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				getOutputTypedModels().clear();
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
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 5:
				return inputTypedModels != null && !inputTypedModels.isEmpty();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				return outputTypedModels != null && !outputTypedModels.isEmpty();
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
		if (visitor instanceof QVTimperativeCSVisitor) {
			return (R) ((QVTimperativeCSVisitor<?>)visitor).visitEntryPointCS(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //EntryPointCSImpl
