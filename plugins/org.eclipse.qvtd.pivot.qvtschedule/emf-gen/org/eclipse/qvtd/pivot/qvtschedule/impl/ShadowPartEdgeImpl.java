/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
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

import org.eclipse.ocl.pivot.ShadowPart;

import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Shadow Part Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ShadowPartEdgeImpl#getReferredPart <em>Referred Part</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ShadowPartEdgeImpl extends ArgumentEdgeImpl implements ShadowPartEdge {
	/**
	 * The number of structural features of the '<em>Shadow Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SHADOW_PART_EDGE_FEATURE_COUNT = ArgumentEdgeImpl.ARGUMENT_EDGE_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Shadow Part Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SHADOW_PART_EDGE_OPERATION_COUNT = ArgumentEdgeImpl.ARGUMENT_EDGE_OPERATION_COUNT + 0;
	/**
	 * The cached value of the '{@link #getReferredPart() <em>Referred Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredPart()
	 * @generated
	 * @ordered
	 */
	protected ShadowPart referredPart;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ShadowPartEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.SHADOW_PART_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ShadowPart getReferredPart() {
		if (referredPart != null && referredPart.eIsProxy()) {
			InternalEObject oldReferredPart = (InternalEObject)referredPart;
			referredPart = (ShadowPart)eResolveProxy(oldReferredPart);
			if (referredPart != oldReferredPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ArgumentEdgeImpl.ARGUMENT_EDGE_FEATURE_COUNT + 0, oldReferredPart, referredPart));
			}
		}
		return referredPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShadowPart basicGetReferredPart() {
		return referredPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredPart(ShadowPart newReferredPart) {
		ShadowPart oldReferredPart = referredPart;
		referredPart = newReferredPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ArgumentEdgeImpl.ARGUMENT_EDGE_FEATURE_COUNT + 0, oldReferredPart, referredPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ArgumentEdgeImpl.ARGUMENT_EDGE_FEATURE_COUNT + 0:
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
			case ArgumentEdgeImpl.ARGUMENT_EDGE_FEATURE_COUNT + 0:
				setReferredPart((ShadowPart)newValue);
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
			case ArgumentEdgeImpl.ARGUMENT_EDGE_FEATURE_COUNT + 0:
				setReferredPart((ShadowPart)null);
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
			case ArgumentEdgeImpl.ARGUMENT_EDGE_FEATURE_COUNT + 0:
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitShadowPartEdge(this);
	}

	@Override
	public @NonNull Edge createEdge(@NonNull Role edgeRole, @NonNull Node sourceNode, @NonNull Node targetNode) {
		ShadowPartEdge newEdge = (ShadowPartEdge) super.createEdge(edgeRole, sourceNode, targetNode);
		newEdge.setReferredPart(getReferredPart());
		return newEdge;
	}
} //ShadowPartEdgeImpl
