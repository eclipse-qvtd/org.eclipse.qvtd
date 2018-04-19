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

import org.eclipse.m2m.atl.common.OCL.OclModel;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Ocl Metamodel</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclMetamodelImpl#getT0tmName <em>T0tm Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclMetamodelImpl#getT1oclMetamodel <em>T1ocl Metamodel</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclMetamodelImpl#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapOclMetamodelImpl extends ExecutionImpl implements TmapOclMetamodel {
	/**
	 * The default value of the '{@link #getT0tmName() <em>T0tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0tmName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0TM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0tmName() <em>T0tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0tmName()
	 * @generated
	 * @ordered
	 */
	protected String t0tmName = T0TM_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT1oclMetamodel() <em>T1ocl Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1oclMetamodel()
	 * @generated
	 * @ordered
	 */
	protected OclModel t1oclMetamodel;

	/**
	 * The cached value of the '{@link #getT2qvtrTypedModel() <em>T2qvtr Typed Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrTypedModel()
	 * @generated
	 * @ordered
	 */
	protected TypedModel t2qvtrTypedModel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapOclMetamodelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_OCL_METAMODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT0tmName() {
		return t0tmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0tmName(String newT0tmName) {
		String oldT0tmName = t0tmName;
		t0tmName = newT0tmName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T0TM_NAME, oldT0tmName, t0tmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclModel getT1oclMetamodel() {
		if (t1oclMetamodel != null && t1oclMetamodel.eIsProxy()) {
			InternalEObject oldT1oclMetamodel = (InternalEObject)t1oclMetamodel;
			t1oclMetamodel = (OclModel)eResolveProxy(oldT1oclMetamodel);
			if (t1oclMetamodel != oldT1oclMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T1OCL_METAMODEL, oldT1oclMetamodel, t1oclMetamodel));
			}
		}
		return t1oclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel basicGetT1oclMetamodel() {
		return t1oclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1oclMetamodel(OclModel newT1oclMetamodel) {
		OclModel oldT1oclMetamodel = t1oclMetamodel;
		t1oclMetamodel = newT1oclMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T1OCL_METAMODEL, oldT1oclMetamodel, t1oclMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypedModel getT2qvtrTypedModel() {
		if (t2qvtrTypedModel != null && t2qvtrTypedModel.eIsProxy()) {
			InternalEObject oldT2qvtrTypedModel = (InternalEObject)t2qvtrTypedModel;
			t2qvtrTypedModel = (TypedModel)eResolveProxy(oldT2qvtrTypedModel);
			if (t2qvtrTypedModel != oldT2qvtrTypedModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T2QVTR_TYPED_MODEL, oldT2qvtrTypedModel, t2qvtrTypedModel));
			}
		}
		return t2qvtrTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetT2qvtrTypedModel() {
		return t2qvtrTypedModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrTypedModel(TypedModel newT2qvtrTypedModel) {
		TypedModel oldT2qvtrTypedModel = t2qvtrTypedModel;
		t2qvtrTypedModel = newT2qvtrTypedModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T2QVTR_TYPED_MODEL, oldT2qvtrTypedModel, t2qvtrTypedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T0TM_NAME:
				return getT0tmName();
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T1OCL_METAMODEL:
				if (resolve) return getT1oclMetamodel();
				return basicGetT1oclMetamodel();
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T2QVTR_TYPED_MODEL:
				if (resolve) return getT2qvtrTypedModel();
				return basicGetT2qvtrTypedModel();
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
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T0TM_NAME:
				setT0tmName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T1OCL_METAMODEL:
				setT1oclMetamodel((OclModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T2QVTR_TYPED_MODEL:
				setT2qvtrTypedModel((TypedModel)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T0TM_NAME:
				setT0tmName(T0TM_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T1OCL_METAMODEL:
				setT1oclMetamodel((OclModel)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T2QVTR_TYPED_MODEL:
				setT2qvtrTypedModel((TypedModel)null);
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
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T0TM_NAME:
				return T0TM_NAME_EDEFAULT == null ? t0tmName != null : !T0TM_NAME_EDEFAULT.equals(t0tmName);
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T1OCL_METAMODEL:
				return t1oclMetamodel != null;
			case trace_ATL2QVTrPackage.TMAP_OCL_METAMODEL__T2QVTR_TYPED_MODEL:
				return t2qvtrTypedModel != null;
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
		result.append(" (t0tmName: ");
		result.append(t0tmName);
		result.append(')');
		return result.toString();
	}

} //TmapOclMetamodelImpl
