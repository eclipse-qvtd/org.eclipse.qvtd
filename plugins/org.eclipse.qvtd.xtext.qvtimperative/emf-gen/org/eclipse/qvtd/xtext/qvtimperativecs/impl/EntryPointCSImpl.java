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

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.xtext.basecs.impl.NamedElementCSImpl;

import org.eclipse.ocl.xtext.basecs.util.BaseCSVisitor;

import org.eclipse.qvtd.xtext.qvtimperativecs.DirectionCS;
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
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.EntryPointCSImpl#getCheckedDirections <em>Checked Directions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.xtext.qvtimperativecs.impl.EntryPointCSImpl#getEnforcedDirections <em>Enforced Directions</em>}</li>
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
	 * The cached value of the '{@link #getCheckedDirections() <em>Checked Directions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckedDirections()
	 * @generated
	 * @ordered
	 */
	protected EList<DirectionCS> checkedDirections;

	/**
	 * The cached value of the '{@link #getEnforcedDirections() <em>Enforced Directions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnforcedDirections()
	 * @generated
	 * @ordered
	 */
	protected EList<DirectionCS> enforcedDirections;

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
	public EList<DirectionCS> getCheckedDirections() {
		if (checkedDirections == null) {
			checkedDirections = new EObjectContainmentEList<DirectionCS>(DirectionCS.class, this, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6);
		}
		return checkedDirections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DirectionCS> getEnforcedDirections() {
		if (enforcedDirections == null) {
			enforcedDirections = new EObjectContainmentEList<DirectionCS>(DirectionCS.class, this, NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7);
		}
		return enforcedDirections;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 6:
				return ((InternalEList<?>)getCheckedDirections()).basicRemove(otherEnd, msgs);
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7:
				return ((InternalEList<?>)getEnforcedDirections()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
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
				return getCheckedDirections();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7:
				return getEnforcedDirections();
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
				getCheckedDirections().clear();
				getCheckedDirections().addAll((Collection<? extends DirectionCS>)newValue);
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7:
				getEnforcedDirections().clear();
				getEnforcedDirections().addAll((Collection<? extends DirectionCS>)newValue);
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
				getCheckedDirections().clear();
				return;
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7:
				getEnforcedDirections().clear();
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
				return checkedDirections != null && !checkedDirections.isEmpty();
			case NamedElementCSImpl.NAMED_ELEMENT_CS_FEATURE_COUNT + 7:
				return enforcedDirections != null && !enforcedDirections.isEmpty();
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
