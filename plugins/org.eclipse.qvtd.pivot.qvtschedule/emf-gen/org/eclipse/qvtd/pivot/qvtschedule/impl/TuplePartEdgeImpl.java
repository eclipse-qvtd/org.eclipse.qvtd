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
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.jdt.annotation.NonNull;

import org.eclipse.ocl.pivot.TupleLiteralPart;

import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.TuplePartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;
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
	 * The number of structural features of the '<em>Tuple Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TUPLE_PART_EDGE_FEATURE_COUNT = ArgumentEdgeImpl.ARGUMENT_EDGE_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Tuple Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TUPLE_PART_EDGE_OPERATION_COUNT = ArgumentEdgeImpl.ARGUMENT_EDGE_OPERATION_COUNT + 0;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 7, oldReferredPart, referredPart));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 7, oldReferredPart, referredPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 7:
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
		if (visitor instanceof QVTscheduleVisitor) {
			return (R) ((QVTscheduleVisitor<?>)visitor).visitTuplePartEdge(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public @NonNull Edge createEdge(@NonNull Role edgeRole, @NonNull Utility utility, @NonNull Node sourceNode, @NonNull Node targetNode) {
		TuplePartEdge newEdge = (TuplePartEdge) super.createEdge(edgeRole, utility, sourceNode, targetNode);
		newEdge.setReferredPart(getReferredPart());
		return newEdge;
	}
} //TuplePartEdgeImpl
