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
package org.eclipse.qvtd.pivot.qvtbase.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.internal.ElementImpl;

import org.eclipse.ocl.pivot.util.Visitor;

import org.eclipse.qvtd.pivot.qvtbase.CompoundTargetElement;
import org.eclipse.qvtd.pivot.qvtbase.QVTbasePackage;
import org.eclipse.qvtd.pivot.qvtbase.SimpleTargetElement;

import org.eclipse.qvtd.pivot.qvtbase.util.QVTbaseVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Compound Target Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtbase.impl.CompoundTargetElementImpl#getOwnedTargetElements <em>Owned Target Elements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CompoundTargetElementImpl extends TargetElementImpl implements CompoundTargetElement {
	/**
	 * The number of structural features of the '<em>Compound Target Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOUND_TARGET_ELEMENT_FEATURE_COUNT = TargetElementImpl.TARGET_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Compound Target Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int COMPOUND_TARGET_ELEMENT_OPERATION_COUNT = TargetElementImpl.TARGET_ELEMENT_OPERATION_COUNT + 0;


	/**
	 * The cached value of the '{@link #getOwnedTargetElements() <em>Owned Target Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedTargetElements()
	 * @generated
	 * @ordered
	 */
	protected EList<SimpleTargetElement> ownedTargetElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CompoundTargetElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTbasePackage.Literals.COMPOUND_TARGET_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SimpleTargetElement> getOwnedTargetElements() {
		if (ownedTargetElements == null) {
			ownedTargetElements = new EObjectContainmentEList<SimpleTargetElement>(SimpleTargetElement.class, this, ElementImpl.ELEMENT_FEATURE_COUNT + 0);
		}
		return ownedTargetElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedTargetElements()).basicRemove(otherEnd, msgs);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return getOwnedTargetElements();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				getOwnedTargetElements().clear();
			getOwnedTargetElements().addAll((Collection<? extends SimpleTargetElement>)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				getOwnedTargetElements().clear();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 0:
				return ownedTargetElements != null && !ownedTargetElements.isEmpty();
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
		if (visitor instanceof QVTbaseVisitor) {
			return (R) ((QVTbaseVisitor<?>)visitor).visitCompoundTargetElement(this);
		}
		else {
			return super.accept(visitor);
		}
	}

} //CompoundTargetElementImpl
