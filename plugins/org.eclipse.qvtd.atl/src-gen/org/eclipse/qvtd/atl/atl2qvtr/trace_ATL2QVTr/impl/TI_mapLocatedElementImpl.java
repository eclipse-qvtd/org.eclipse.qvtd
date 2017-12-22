/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.LocatedElement;

import org.eclipse.ocl.pivot.Element;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TI_mapLocatedElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TI map Located Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TI_mapLocatedElementImpl#getAtl_atlElement <em>Atl atl Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TI_mapLocatedElementImpl#getQvtr_qvtrElement <em>Qvtr qvtr Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TI_mapLocatedElementImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class TI_mapLocatedElementImpl extends MinimalEObjectImpl.Container implements TI_mapLocatedElement {
	/**
	 * The cached value of the '{@link #getAtl_atlElement() <em>Atl atl Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlElement()
	 * @generated
	 * @ordered
	 */
	protected LocatedElement atl_atlElement;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrElement() <em>Qvtr qvtr Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrElement()
	 * @generated
	 * @ordered
	 */
	protected Element qvtr_qvtrElement;

	/**
	 * The default value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean STATUS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getStatus() <em>Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatus()
	 * @generated
	 * @ordered
	 */
	protected Boolean status = STATUS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TI_mapLocatedElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TI_MAP_LOCATED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocatedElement getAtl_atlElement() {
		if (atl_atlElement != null && atl_atlElement.eIsProxy()) {
			InternalEObject oldAtl_atlElement = (InternalEObject)atl_atlElement;
			atl_atlElement = (LocatedElement)eResolveProxy(oldAtl_atlElement);
			if (atl_atlElement != oldAtl_atlElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__ATL_ATL_ELEMENT, oldAtl_atlElement, atl_atlElement));
			}
		}
		return atl_atlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LocatedElement basicGetAtl_atlElement() {
		return atl_atlElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtl_atlElement(LocatedElement newAtl_atlElement) {
		LocatedElement oldAtl_atlElement = atl_atlElement;
		atl_atlElement = newAtl_atlElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__ATL_ATL_ELEMENT, oldAtl_atlElement, atl_atlElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element getQvtr_qvtrElement() {
		if (qvtr_qvtrElement != null && qvtr_qvtrElement.eIsProxy()) {
			InternalEObject oldQvtr_qvtrElement = (InternalEObject)qvtr_qvtrElement;
			qvtr_qvtrElement = (Element)eResolveProxy(oldQvtr_qvtrElement);
			if (qvtr_qvtrElement != oldQvtr_qvtrElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__QVTR_QVTR_ELEMENT, oldQvtr_qvtrElement, qvtr_qvtrElement));
			}
		}
		return qvtr_qvtrElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Element basicGetQvtr_qvtrElement() {
		return qvtr_qvtrElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrElement(Element newQvtr_qvtrElement) {
		Element oldQvtr_qvtrElement = qvtr_qvtrElement;
		qvtr_qvtrElement = newQvtr_qvtrElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__QVTR_QVTR_ELEMENT, oldQvtr_qvtrElement, qvtr_qvtrElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatus(Boolean newStatus) {
		Boolean oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__ATL_ATL_ELEMENT:
				if (resolve) return getAtl_atlElement();
				return basicGetAtl_atlElement();
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__QVTR_QVTR_ELEMENT:
				if (resolve) return getQvtr_qvtrElement();
				return basicGetQvtr_qvtrElement();
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__STATUS:
				return getStatus();
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
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__ATL_ATL_ELEMENT:
				setAtl_atlElement((LocatedElement)newValue);
				return;
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__QVTR_QVTR_ELEMENT:
				setQvtr_qvtrElement((Element)newValue);
				return;
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__STATUS:
				setStatus((Boolean)newValue);
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
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__ATL_ATL_ELEMENT:
				setAtl_atlElement((LocatedElement)null);
				return;
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__QVTR_QVTR_ELEMENT:
				setQvtr_qvtrElement((Element)null);
				return;
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__STATUS:
				setStatus(STATUS_EDEFAULT);
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
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__ATL_ATL_ELEMENT:
				return atl_atlElement != null;
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__QVTR_QVTR_ELEMENT:
				return qvtr_qvtrElement != null;
			case trace_ATL2QVTrPackage.TI_MAP_LOCATED_ELEMENT__STATUS:
				return STATUS_EDEFAULT == null ? status != null : !STATUS_EDEFAULT.equals(status);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //TI_mapLocatedElementImpl
