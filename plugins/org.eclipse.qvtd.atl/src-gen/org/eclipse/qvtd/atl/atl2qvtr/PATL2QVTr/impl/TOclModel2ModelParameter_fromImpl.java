/**
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * ;All rights reserved. This program and the accompanying materials
 * ;are made available under the terms of the Eclipse Public License v1.0
 * ;which accompanies this distribution, and is available at
 * ;http://www.eclipse.org/legal/epl-v10.html
 * ;
 * ;Contributors:
 * ;  E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.Module;

import org.eclipse.m2m.atl.common.OCL.OclModel;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TOclModel2ModelParameter_from;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TOcl Model2 Model Parameter from</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_fromImpl#getAModule <em>AModule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_fromImpl#getOclModel <em>Ocl Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_fromImpl#getRelTM <em>Rel TM</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_fromImpl#getRelTx <em>Rel Tx</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TOclModel2ModelParameter_fromImpl#getTmName <em>Tm Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TOclModel2ModelParameter_fromImpl extends MinimalEObjectImpl.Container implements TOclModel2ModelParameter_from {
	/**
	 * The cached value of the '{@link #getAModule() <em>AModule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAModule()
	 * @generated
	 * @ordered
	 */
	protected Module aModule;

	/**
	 * The cached value of the '{@link #getOclModel() <em>Ocl Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOclModel()
	 * @generated
	 * @ordered
	 */
	protected OclModel oclModel;

	/**
	 * The cached value of the '{@link #getRelTM() <em>Rel TM</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelTM()
	 * @generated
	 * @ordered
	 */
	protected TypedModel relTM;

	/**
	 * The cached value of the '{@link #getRelTx() <em>Rel Tx</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelTx()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation relTx;

	/**
	 * The default value of the '{@link #getTmName() <em>Tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTmName()
	 * @generated
	 * @ordered
	 */
	protected static final String TM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTmName() <em>Tm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTmName()
	 * @generated
	 * @ordered
	 */
	protected String tmName = TM_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TOclModel2ModelParameter_fromImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PATL2QVTrPackage.Literals.TOCL_MODEL2_MODEL_PARAMETER_FROM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module getAModule() {
		if (aModule != null && aModule.eIsProxy()) {
			InternalEObject oldAModule = (InternalEObject)aModule;
			aModule = (Module)eResolveProxy(oldAModule);
			if (aModule != oldAModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__AMODULE, oldAModule, aModule));
			}
		}
		return aModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module basicGetAModule() {
		return aModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAModule(Module newAModule) {
		Module oldAModule = aModule;
		aModule = newAModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__AMODULE, oldAModule, aModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel getOclModel() {
		if (oclModel != null && oclModel.eIsProxy()) {
			InternalEObject oldOclModel = (InternalEObject)oclModel;
			oclModel = (OclModel)eResolveProxy(oldOclModel);
			if (oclModel != oldOclModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__OCL_MODEL, oldOclModel, oclModel));
			}
		}
		return oclModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel basicGetOclModel() {
		return oclModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOclModel(OclModel newOclModel) {
		OclModel oldOclModel = oclModel;
		oclModel = newOclModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__OCL_MODEL, oldOclModel, oclModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel getRelTM() {
		if (relTM != null && relTM.eIsProxy()) {
			InternalEObject oldRelTM = (InternalEObject)relTM;
			relTM = (TypedModel)eResolveProxy(oldRelTM);
			if (relTM != oldRelTM) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TM, oldRelTM, relTM));
			}
		}
		return relTM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypedModel basicGetRelTM() {
		return relTM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelTM(TypedModel newRelTM) {
		TypedModel oldRelTM = relTM;
		relTM = newRelTM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TM, oldRelTM, relTM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation getRelTx() {
		if (relTx != null && relTx.eIsProxy()) {
			InternalEObject oldRelTx = (InternalEObject)relTx;
			relTx = (RelationalTransformation)eResolveProxy(oldRelTx);
			if (relTx != oldRelTx) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TX, oldRelTx, relTx));
			}
		}
		return relTx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetRelTx() {
		return relTx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRelTx(RelationalTransformation newRelTx) {
		RelationalTransformation oldRelTx = relTx;
		relTx = newRelTx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TX, oldRelTx, relTx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTmName() {
		return tmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTmName(String newTmName) {
		String oldTmName = tmName;
		tmName = newTmName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__TM_NAME, oldTmName, tmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__AMODULE:
				if (resolve) return getAModule();
				return basicGetAModule();
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__OCL_MODEL:
				if (resolve) return getOclModel();
				return basicGetOclModel();
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TM:
				if (resolve) return getRelTM();
				return basicGetRelTM();
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TX:
				if (resolve) return getRelTx();
				return basicGetRelTx();
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__TM_NAME:
				return getTmName();
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
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__AMODULE:
				setAModule((Module)newValue);
				return;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__OCL_MODEL:
				setOclModel((OclModel)newValue);
				return;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TM:
				setRelTM((TypedModel)newValue);
				return;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TX:
				setRelTx((RelationalTransformation)newValue);
				return;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__TM_NAME:
				setTmName((String)newValue);
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
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__AMODULE:
				setAModule((Module)null);
				return;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__OCL_MODEL:
				setOclModel((OclModel)null);
				return;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TM:
				setRelTM((TypedModel)null);
				return;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TX:
				setRelTx((RelationalTransformation)null);
				return;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__TM_NAME:
				setTmName(TM_NAME_EDEFAULT);
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
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__AMODULE:
				return aModule != null;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__OCL_MODEL:
				return oclModel != null;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TM:
				return relTM != null;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__REL_TX:
				return relTx != null;
			case PATL2QVTrPackage.TOCL_MODEL2_MODEL_PARAMETER_FROM__TM_NAME:
				return TM_NAME_EDEFAULT == null ? tmName != null : !TM_NAME_EDEFAULT.equals(tmName);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (tmName: ");
		result.append(tmName);
		result.append(')');
		return result.toString();
	}

} //TOclModel2ModelParameter_fromImpl
