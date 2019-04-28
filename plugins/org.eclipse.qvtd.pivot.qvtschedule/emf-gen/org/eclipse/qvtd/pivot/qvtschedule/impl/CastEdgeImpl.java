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
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Cast Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.CastEdgeImpl#getReferredClassDatum <em>Referred Class Datum</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CastEdgeImpl extends EdgeImpl implements CastEdge {
	/**
	 * The number of structural features of the '<em>Cast Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CAST_EDGE_FEATURE_COUNT = EdgeImpl.EDGE_FEATURE_COUNT + 1;
	/**
	 * The number of operations of the '<em>Cast Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CAST_EDGE_OPERATION_COUNT = EdgeImpl.EDGE_OPERATION_COUNT + 0;

	/**
	 * The cached value of the '{@link #getReferredClassDatum() <em>Referred Class Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredClassDatum()
	 * @generated
	 * @ordered
	 */
	protected ClassDatum referredClassDatum;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CastEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.CAST_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassDatum getReferredClassDatum() {
		if (referredClassDatum != null && referredClassDatum.eIsProxy()) {
			InternalEObject oldReferredClassDatum = (InternalEObject)referredClassDatum;
			referredClassDatum = (ClassDatum)eResolveProxy(oldReferredClassDatum);
			if (referredClassDatum != oldReferredClassDatum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ElementImpl.ELEMENT_FEATURE_COUNT + 6, oldReferredClassDatum, referredClassDatum));
			}
		}
		return referredClassDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDatum basicGetReferredClassDatum() {
		return referredClassDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredClassDatum(ClassDatum newReferredClassDatum) {
		ClassDatum oldReferredClassDatum = referredClassDatum;
		referredClassDatum = newReferredClassDatum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ElementImpl.ELEMENT_FEATURE_COUNT + 6, oldReferredClassDatum, referredClassDatum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				if (resolve) return getReferredClassDatum();
				return basicGetReferredClassDatum();
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				setReferredClassDatum((ClassDatum)newValue);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				setReferredClassDatum((ClassDatum)null);
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
			case ElementImpl.ELEMENT_FEATURE_COUNT + 6:
				return referredClassDatum != null;
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitCastEdge(this);
	}

	@Override
	public @NonNull String getDisplayName() {
		return "«cast»\\n" + name;
	}

	@Override
	public void initialize(@NonNull Role edgeRole, @NonNull Node sourceNode, @NonNull ClassDatum classDatum, @NonNull Node targetNode) {
		super.initialize(edgeRole, sourceNode, classDatum.getName(), targetNode);
		setReferredClassDatum(classDatum);
	}

	@Override
	public final boolean isCast() {
		return true;
	}
} //CastEdgeImpl
