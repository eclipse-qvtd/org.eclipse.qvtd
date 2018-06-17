/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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

import org.eclipse.m2m.atl.common.OCL.OclModel;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclMetamodel;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Ocl Metamodel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclMetamodelImpl#getAtl_oclMetamodel <em>Atl ocl Metamodel</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclMetamodelImpl#getPrimitive_tmName <em>Primitive tm Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclMetamodelImpl#getQvtr_qvtrTypedModel <em>Qvtr qvtr Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclMetamodelImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapOclMetamodelImpl extends MinimalEObjectImpl.Container implements TC_mapOclMetamodel {
	/**
	 * The cached value of the '{@link #getAtl_oclMetamodel() <em>Atl ocl Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_oclMetamodel()
	 * @generated
	 * @ordered
	 */
	protected OclModel atl_oclMetamodel;

	/**
	 * The default value of the '{@link #getPrimitive_tmName() <em>Primitive tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_tmName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_TM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_tmName() <em>Primitive tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_tmName()
	 * @generated
	 * @ordered
	 */
	protected String primitive_tmName = PRIMITIVE_TM_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrTypedModel() <em>Qvtr qvtr Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel qvtr_qvtrTypedModel;

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
	protected TC_mapOclMetamodelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_OCL_METAMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclModel getAtl_oclMetamodel() {
		if (atl_oclMetamodel != null && atl_oclMetamodel.eIsProxy()) {
			InternalEObject oldAtl_oclMetamodel = atl_oclMetamodel;
			atl_oclMetamodel = (OclModel)eResolveProxy(oldAtl_oclMetamodel);
			if (atl_oclMetamodel != oldAtl_oclMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__ATL_OCL_METAMODEL, oldAtl_oclMetamodel, atl_oclMetamodel));
			}
		}
		return atl_oclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel basicGetAtl_oclMetamodel() {
		return atl_oclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_oclMetamodel(OclModel newAtl_oclMetamodel) {
		OclModel oldAtl_oclMetamodel = atl_oclMetamodel;
		atl_oclMetamodel = newAtl_oclMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__ATL_OCL_METAMODEL, oldAtl_oclMetamodel, atl_oclMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimitive_tmName() {
		return primitive_tmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive_tmName(String newPrimitive_tmName) {
		String oldPrimitive_tmName = primitive_tmName;
		primitive_tmName = newPrimitive_tmName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__PRIMITIVE_TM_NAME, oldPrimitive_tmName, primitive_tmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getQvtr_qvtrTypedModel() {
		if (qvtr_qvtrTypedModel != null && qvtr_qvtrTypedModel.eIsProxy()) {
			InternalEObject oldQvtr_qvtrTypedModel = (InternalEObject)qvtr_qvtrTypedModel;
			qvtr_qvtrTypedModel = (TypedModel)eResolveProxy(oldQvtr_qvtrTypedModel);
			if (qvtr_qvtrTypedModel != oldQvtr_qvtrTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__QVTR_QVTR_TYPED_MODEL, oldQvtr_qvtrTypedModel, qvtr_qvtrTypedModel));
			}
		}
		return qvtr_qvtrTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetQvtr_qvtrTypedModel() {
		return qvtr_qvtrTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrTypedModel(TypedModel newQvtr_qvtrTypedModel) {
		TypedModel oldQvtr_qvtrTypedModel = qvtr_qvtrTypedModel;
		qvtr_qvtrTypedModel = newQvtr_qvtrTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__QVTR_QVTR_TYPED_MODEL, oldQvtr_qvtrTypedModel, qvtr_qvtrTypedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getStatus() {
		return status;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStatus(Boolean newStatus) {
		Boolean oldStatus = status;
		status = newStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__ATL_OCL_METAMODEL:
				if (resolve) return getAtl_oclMetamodel();
				return basicGetAtl_oclMetamodel();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__PRIMITIVE_TM_NAME:
				return getPrimitive_tmName();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__QVTR_QVTR_TYPED_MODEL:
				if (resolve) return getQvtr_qvtrTypedModel();
				return basicGetQvtr_qvtrTypedModel();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__STATUS:
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
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__ATL_OCL_METAMODEL:
				setAtl_oclMetamodel((OclModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__PRIMITIVE_TM_NAME:
				setPrimitive_tmName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__QVTR_QVTR_TYPED_MODEL:
				setQvtr_qvtrTypedModel((TypedModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__STATUS:
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
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__ATL_OCL_METAMODEL:
				setAtl_oclMetamodel((OclModel)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__PRIMITIVE_TM_NAME:
				setPrimitive_tmName(PRIMITIVE_TM_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__QVTR_QVTR_TYPED_MODEL:
				setQvtr_qvtrTypedModel((TypedModel)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__STATUS:
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
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__ATL_OCL_METAMODEL:
				return atl_oclMetamodel != null;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__PRIMITIVE_TM_NAME:
				return PRIMITIVE_TM_NAME_EDEFAULT == null ? primitive_tmName != null : !PRIMITIVE_TM_NAME_EDEFAULT.equals(primitive_tmName);
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__QVTR_QVTR_TYPED_MODEL:
				return qvtr_qvtrTypedModel != null;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_METAMODEL__STATUS:
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
		result.append(" (primitive_tmName: ");
		result.append(primitive_tmName);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //TC_mapOclMetamodelImpl
