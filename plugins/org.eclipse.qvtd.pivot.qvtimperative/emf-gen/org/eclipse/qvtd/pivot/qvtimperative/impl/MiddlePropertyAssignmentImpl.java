/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
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

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtcorebase.impl.PropertyAssignmentImpl;
import org.eclipse.qvtd.pivot.qvtimperative.MiddlePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtimperative.QVTimperativePackage;
import org.eclipse.qvtd.pivot.qvtimperative.util.QVTimperativeVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Middle Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.impl.MiddlePropertyAssignmentImpl#getCacheIndex <em>Cache Index</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MiddlePropertyAssignmentImpl extends PropertyAssignmentImpl implements MiddlePropertyAssignment {
	/**
	 * The default value of the '{@link #getCacheIndex() <em>Cache Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheIndex()
	 * @generated
	 * @ordered
	 */
	protected static final BigInteger CACHE_INDEX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCacheIndex() <em>Cache Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCacheIndex()
	 * @generated
	 * @ordered
	 */
	protected BigInteger cacheIndex = CACHE_INDEX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MiddlePropertyAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTimperativePackage.Literals.MIDDLE_PROPERTY_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BigInteger getCacheIndex() {
		return cacheIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCacheIndex(BigInteger newCacheIndex) {
		BigInteger oldCacheIndex = cacheIndex;
		cacheIndex = newCacheIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTimperativePackage.MIDDLE_PROPERTY_ASSIGNMENT__CACHE_INDEX, oldCacheIndex, cacheIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTimperativePackage.MIDDLE_PROPERTY_ASSIGNMENT__CACHE_INDEX:
				return getCacheIndex();
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
			case QVTimperativePackage.MIDDLE_PROPERTY_ASSIGNMENT__CACHE_INDEX:
				setCacheIndex((BigInteger)newValue);
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
			case QVTimperativePackage.MIDDLE_PROPERTY_ASSIGNMENT__CACHE_INDEX:
				setCacheIndex(CACHE_INDEX_EDEFAULT);
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
			case QVTimperativePackage.MIDDLE_PROPERTY_ASSIGNMENT__CACHE_INDEX:
				return CACHE_INDEX_EDEFAULT == null ? cacheIndex != null : !CACHE_INDEX_EDEFAULT.equals(cacheIndex);
		}
		return super.eIsSet(featureID);
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return ((QVTimperativeVisitor<R>)visitor).visitMiddlePropertyAssignment(this);
	}

	@Override
	public String toString() {
		return super.toString();
	}
} //MiddlePropertyAssignmentImpl
