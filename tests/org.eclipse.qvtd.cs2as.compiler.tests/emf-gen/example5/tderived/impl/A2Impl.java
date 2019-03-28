/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package example5.tderived.impl;

import example5.tbase.impl.AImpl;

import example5.tderived.A2;
import example5.tderived.D;
import example5.tderived.TderivedPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>A2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link example5.tderived.impl.A2Impl#getOwnsD <em>Owns D</em>}</li>
 * </ul>
 *
 * @generated
 */
public class A2Impl extends AImpl implements A2 {
	/**
	 * The number of structural features of the '<em>A2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int A2_FEATURE_COUNT = AImpl.A_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>A2</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int A2_OPERATION_COUNT = AImpl.A_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getOwnsD() <em>Owns D</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnsD()
	 * @generated
	 * @ordered
	 */
	protected EList<D> ownsD;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected A2Impl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TderivedPackage.Literals.A2;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<D> getOwnsD() {
		if (ownsD == null) {
			ownsD = new EObjectContainmentEList<D>(D.class, this, AImpl.A_FEATURE_COUNT + 0);
		}
		return ownsD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AImpl.A_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnsD()).basicRemove(otherEnd, msgs);
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
			case AImpl.A_FEATURE_COUNT + 0:
				return getOwnsD();
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
			case AImpl.A_FEATURE_COUNT + 0:
				getOwnsD().clear();
				getOwnsD().addAll((Collection<? extends D>)newValue);
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
			case AImpl.A_FEATURE_COUNT + 0:
				getOwnsD().clear();
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
			case AImpl.A_FEATURE_COUNT + 0:
				return ownsD != null && !ownsD.isEmpty();
		}
		return super.eIsSet(featureID);
	}


} //A2Impl
