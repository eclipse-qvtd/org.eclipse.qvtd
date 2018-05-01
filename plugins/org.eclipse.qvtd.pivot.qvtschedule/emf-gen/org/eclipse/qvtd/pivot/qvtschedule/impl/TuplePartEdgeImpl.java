/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.TupleLiteralPart;

import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tuple Part Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.TuplePartEdgeImpl#getReferredPart <em>Referred Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TuplePartEdgeImpl extends ArgumentEdgeImpl implements TuplePartEdge {
	/**
	 * The cached value of the '{@link #getReferredPart() <em>Referred Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredPart()
	 * @generated
	 * @ordered
	 */
	protected TupleLiteralPart referredPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TuplePartEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.TUPLE_PART_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TupleLiteralPart getReferredPart() {
		if (referredPart != null && referredPart.eIsProxy()) {
			InternalEObject oldReferredPart = (InternalEObject)referredPart;
			referredPart = (TupleLiteralPart)eResolveProxy(oldReferredPart);
			if (referredPart != oldReferredPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.TUPLE_PART_EDGE__REFERRED_PART, oldReferredPart, referredPart));
			}
		}
		return referredPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TupleLiteralPart basicGetReferredPart() {
		return referredPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredPart(TupleLiteralPart newReferredPart) {
		TupleLiteralPart oldReferredPart = referredPart;
		referredPart = newReferredPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.TUPLE_PART_EDGE__REFERRED_PART, oldReferredPart, referredPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.TUPLE_PART_EDGE__REFERRED_PART:
				if (resolve) return getReferredPart();
				return basicGetReferredPart();
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
			case QVTschedulePackage.TUPLE_PART_EDGE__REFERRED_PART:
				setReferredPart((TupleLiteralPart)newValue);
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
			case QVTschedulePackage.TUPLE_PART_EDGE__REFERRED_PART:
				setReferredPart((TupleLiteralPart)null);
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
			case QVTschedulePackage.TUPLE_PART_EDGE__REFERRED_PART:
				return referredPart != null;
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitTuplePartEdge(this);
	}

	@Override
	public @NonNull Edge createEdge(@NonNull Role edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode) {
		TuplePartEdge newEdge = (TuplePartEdge) super.createEdge(edgeRole, sourceNode, targetNode);
		newEdge.setReferredPart(getReferredPart());
		return newEdge;
	}
} //TuplePartEdgeImpl
