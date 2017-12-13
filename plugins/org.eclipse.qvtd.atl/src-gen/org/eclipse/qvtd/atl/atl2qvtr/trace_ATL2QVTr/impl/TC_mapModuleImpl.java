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

import org.eclipse.ocl.pivot.ParameterVariable;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Module</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapModuleImpl#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapModuleImpl#getPrimitive_txName <em>Primitive tx Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapModuleImpl#getQvtr__3 <em>Qvtr 3</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapModuleImpl#getQvtr__4 <em>Qvtr 4</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapModuleImpl#getQvtr__5 <em>Qvtr 5</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapModuleImpl#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapModuleImpl#getStatus <em>Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapModuleImpl extends MinimalEObjectImpl.Container implements TC_mapModule {
	/**
	 * The cached value of the '{@link #getAtl_atlModule() <em>Atl atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlModule()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.m2m.atl.common.ATL.Module atl_atlModule;

	/**
	 * The default value of the '{@link #getPrimitive_txName() <em>Primitive tx Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_txName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_TX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_txName() <em>Primitive tx Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_txName()
	 * @generated
	 * @ordered
	 */
	protected String primitive_txName = PRIMITIVE_TX_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQvtr__3() <em>Qvtr 3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr__3()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Package qvtr__3;

	/**
	 * The cached value of the '{@link #getQvtr__4() <em>Qvtr 4</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr__4()
	 * @generated
	 * @ordered
	 */
	protected RelationModel qvtr__4;

	/**
	 * The cached value of the '{@link #getQvtr__5() <em>Qvtr 5</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr__5()
	 * @generated
	 * @ordered
	 */
	protected ParameterVariable qvtr__5;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrTransformation() <em>Qvtr qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation qvtr_qvtrTransformation;

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
	protected TC_mapModuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_MODULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getAtl_atlModule() {
		if (atl_atlModule != null && atl_atlModule.eIsProxy()) {
			InternalEObject oldAtl_atlModule = atl_atlModule;
			atl_atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldAtl_atlModule);
			if (atl_atlModule != oldAtl_atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MODULE__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
			}
		}
		return atl_atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module basicGetAtl_atlModule() {
		return atl_atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlModule(org.eclipse.m2m.atl.common.ATL.Module newAtl_atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldAtl_atlModule = atl_atlModule;
		atl_atlModule = newAtl_atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MODULE__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimitive_txName() {
		return primitive_txName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive_txName(String newPrimitive_txName) {
		String oldPrimitive_txName = primitive_txName;
		primitive_txName = newPrimitive_txName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MODULE__PRIMITIVE_TX_NAME, oldPrimitive_txName, primitive_txName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Package getQvtr__3() {
		if (qvtr__3 != null && qvtr__3.eIsProxy()) {
			InternalEObject oldQvtr__3 = (InternalEObject)qvtr__3;
			qvtr__3 = (org.eclipse.ocl.pivot.Package)eResolveProxy(oldQvtr__3);
			if (qvtr__3 != oldQvtr__3) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_3, oldQvtr__3, qvtr__3));
			}
		}
		return qvtr__3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Package basicGetQvtr__3() {
		return qvtr__3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr__3(org.eclipse.ocl.pivot.Package newQvtr__3) {
		org.eclipse.ocl.pivot.Package oldQvtr__3 = qvtr__3;
		qvtr__3 = newQvtr__3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_3, oldQvtr__3, qvtr__3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationModel getQvtr__4() {
		if (qvtr__4 != null && qvtr__4.eIsProxy()) {
			InternalEObject oldQvtr__4 = (InternalEObject)qvtr__4;
			qvtr__4 = (RelationModel)eResolveProxy(oldQvtr__4);
			if (qvtr__4 != oldQvtr__4) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_4, oldQvtr__4, qvtr__4));
			}
		}
		return qvtr__4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationModel basicGetQvtr__4() {
		return qvtr__4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr__4(RelationModel newQvtr__4) {
		RelationModel oldQvtr__4 = qvtr__4;
		qvtr__4 = newQvtr__4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_4, oldQvtr__4, qvtr__4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterVariable getQvtr__5() {
		if (qvtr__5 != null && qvtr__5.eIsProxy()) {
			InternalEObject oldQvtr__5 = (InternalEObject)qvtr__5;
			qvtr__5 = (ParameterVariable)eResolveProxy(oldQvtr__5);
			if (qvtr__5 != oldQvtr__5) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_5, oldQvtr__5, qvtr__5));
			}
		}
		return qvtr__5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterVariable basicGetQvtr__5() {
		return qvtr__5;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr__5(ParameterVariable newQvtr__5) {
		ParameterVariable oldQvtr__5 = qvtr__5;
		qvtr__5 = newQvtr__5;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_5, oldQvtr__5, qvtr__5));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getQvtr_qvtrTransformation() {
		if (qvtr_qvtrTransformation != null && qvtr_qvtrTransformation.eIsProxy()) {
			InternalEObject oldQvtr_qvtrTransformation = (InternalEObject)qvtr_qvtrTransformation;
			qvtr_qvtrTransformation = (RelationalTransformation)eResolveProxy(oldQvtr_qvtrTransformation);
			if (qvtr_qvtrTransformation != oldQvtr_qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
			}
		}
		return qvtr_qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetQvtr_qvtrTransformation() {
		return qvtr_qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrTransformation(RelationalTransformation newQvtr_qvtrTransformation) {
		RelationalTransformation oldQvtr_qvtrTransformation = qvtr_qvtrTransformation;
		qvtr_qvtrTransformation = newQvtr_qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_MODULE__STATUS, oldStatus, status));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__ATL_ATL_MODULE:
				if (resolve) return getAtl_atlModule();
				return basicGetAtl_atlModule();
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__PRIMITIVE_TX_NAME:
				return getPrimitive_txName();
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_3:
				if (resolve) return getQvtr__3();
				return basicGetQvtr__3();
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_4:
				if (resolve) return getQvtr__4();
				return basicGetQvtr__4();
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_5:
				if (resolve) return getQvtr__5();
				return basicGetQvtr__5();
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_QVTR_TRANSFORMATION:
				if (resolve) return getQvtr_qvtrTransformation();
				return basicGetQvtr_qvtrTransformation();
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__STATUS:
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
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__PRIMITIVE_TX_NAME:
				setPrimitive_txName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_3:
				setQvtr__3((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_4:
				setQvtr__4((RelationModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_5:
				setQvtr__5((ParameterVariable)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_QVTR_TRANSFORMATION:
				setQvtr_qvtrTransformation((RelationalTransformation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__STATUS:
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
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__PRIMITIVE_TX_NAME:
				setPrimitive_txName(PRIMITIVE_TX_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_3:
				setQvtr__3((org.eclipse.ocl.pivot.Package)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_4:
				setQvtr__4((RelationModel)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_5:
				setQvtr__5((ParameterVariable)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_QVTR_TRANSFORMATION:
				setQvtr_qvtrTransformation((RelationalTransformation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__STATUS:
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
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__ATL_ATL_MODULE:
				return atl_atlModule != null;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__PRIMITIVE_TX_NAME:
				return PRIMITIVE_TX_NAME_EDEFAULT == null ? primitive_txName != null : !PRIMITIVE_TX_NAME_EDEFAULT.equals(primitive_txName);
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_3:
				return qvtr__3 != null;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_4:
				return qvtr__4 != null;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_5:
				return qvtr__5 != null;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__QVTR_QVTR_TRANSFORMATION:
				return qvtr_qvtrTransformation != null;
			case trace_ATL2QVTrPackage.TC_MAP_MODULE__STATUS:
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
		result.append(" (primitive_txName: ");
		result.append(primitive_txName);
		result.append(", status: ");
		result.append(status);
		result.append(')');
		return result.toString();
	}

} //TC_mapModuleImpl
