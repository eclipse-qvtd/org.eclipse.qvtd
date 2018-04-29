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

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclMetamodel;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOclModel_IN;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Ocl Model IN</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl#getT0tmName <em>T0tm Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl#getT1atlModule <em>T1atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl#getT1oclMetamodel <em>T1ocl Metamodel</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl#getT1oclModel <em>T1ocl Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl#getT2qvtrTransformation <em>T2qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl#getT2qvtrTypedModel <em>T2qvtr Typed Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl#getWmapModule <em>Wmap Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOclModel_INImpl#getWmapOclMetamodel <em>Wmap Ocl Metamodel</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapOclModel_INImpl extends ExecutionImpl implements TmapOclModel_IN {
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
	 * The cached value of the '{@link #getT1atlModule() <em>T1atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlModule()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.m2m.atl.common.ATL.Module t1atlModule;

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
	 * The cached value of the '{@link #getT1oclModel() <em>T1ocl Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1oclModel()
	 * @generated
	 * @ordered
	 */
	protected OclModel t1oclModel;

	/**
	 * The cached value of the '{@link #getT2qvtrTransformation() <em>T2qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation t2qvtrTransformation;

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
	 * The cached value of the '{@link #getWmapModule() <em>Wmap Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapModule()
	 * @generated
	 * @ordered
	 */
	protected TmapModule wmapModule;

	/**
	 * The cached value of the '{@link #getWmapOclMetamodel() <em>Wmap Ocl Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapOclMetamodel()
	 * @generated
	 * @ordered
	 */
	protected TmapOclMetamodel wmapOclMetamodel;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapOclModel_INImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_OCL_MODEL_IN;
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T0TM_NAME, oldT0tmName, t0tmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getT1atlModule() {
		if (t1atlModule != null && t1atlModule.eIsProxy()) {
			InternalEObject oldT1atlModule = (InternalEObject)t1atlModule;
			t1atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldT1atlModule);
			if (t1atlModule != oldT1atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1ATL_MODULE, oldT1atlModule, t1atlModule));
			}
		}
		return t1atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module basicGetT1atlModule() {
		return t1atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlModule(org.eclipse.m2m.atl.common.ATL.Module newT1atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldT1atlModule = t1atlModule;
		t1atlModule = newT1atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1ATL_MODULE, oldT1atlModule, t1atlModule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_METAMODEL, oldT1oclMetamodel, t1oclMetamodel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_METAMODEL, oldT1oclMetamodel, t1oclMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclModel getT1oclModel() {
		if (t1oclModel != null && t1oclModel.eIsProxy()) {
			InternalEObject oldT1oclModel = (InternalEObject)t1oclModel;
			t1oclModel = (OclModel)eResolveProxy(oldT1oclModel);
			if (t1oclModel != oldT1oclModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_MODEL, oldT1oclModel, t1oclModel));
			}
		}
		return t1oclModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel basicGetT1oclModel() {
		return t1oclModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1oclModel(OclModel newT1oclModel) {
		OclModel oldT1oclModel = t1oclModel;
		t1oclModel = newT1oclModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_MODEL, oldT1oclModel, t1oclModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getT2qvtrTransformation() {
		if (t2qvtrTransformation != null && t2qvtrTransformation.eIsProxy()) {
			InternalEObject oldT2qvtrTransformation = (InternalEObject)t2qvtrTransformation;
			t2qvtrTransformation = (RelationalTransformation)eResolveProxy(oldT2qvtrTransformation);
			if (t2qvtrTransformation != oldT2qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
			}
		}
		return t2qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetT2qvtrTransformation() {
		return t2qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrTransformation(RelationalTransformation newT2qvtrTransformation) {
		RelationalTransformation oldT2qvtrTransformation = t2qvtrTransformation;
		t2qvtrTransformation = newT2qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TYPED_MODEL, oldT2qvtrTypedModel, t2qvtrTypedModel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TYPED_MODEL, oldT2qvtrTypedModel, t2qvtrTypedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapModule getWmapModule() {
		if (wmapModule != null && wmapModule.eIsProxy()) {
			InternalEObject oldWmapModule = (InternalEObject)wmapModule;
			wmapModule = (TmapModule)eResolveProxy(oldWmapModule);
			if (wmapModule != oldWmapModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_MODULE, oldWmapModule, wmapModule));
			}
		}
		return wmapModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapModule basicGetWmapModule() {
		return wmapModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapModule(TmapModule newWmapModule) {
		TmapModule oldWmapModule = wmapModule;
		wmapModule = newWmapModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_MODULE, oldWmapModule, wmapModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapOclMetamodel getWmapOclMetamodel() {
		if (wmapOclMetamodel != null && wmapOclMetamodel.eIsProxy()) {
			InternalEObject oldWmapOclMetamodel = (InternalEObject)wmapOclMetamodel;
			wmapOclMetamodel = (TmapOclMetamodel)eResolveProxy(oldWmapOclMetamodel);
			if (wmapOclMetamodel != oldWmapOclMetamodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL, oldWmapOclMetamodel, wmapOclMetamodel));
			}
		}
		return wmapOclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapOclMetamodel basicGetWmapOclMetamodel() {
		return wmapOclMetamodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapOclMetamodel(TmapOclMetamodel newWmapOclMetamodel) {
		TmapOclMetamodel oldWmapOclMetamodel = wmapOclMetamodel;
		wmapOclMetamodel = newWmapOclMetamodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL, oldWmapOclMetamodel, wmapOclMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T0TM_NAME:
				return getT0tmName();
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1ATL_MODULE:
				if (resolve) return getT1atlModule();
				return basicGetT1atlModule();
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_METAMODEL:
				if (resolve) return getT1oclMetamodel();
				return basicGetT1oclMetamodel();
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_MODEL:
				if (resolve) return getT1oclModel();
				return basicGetT1oclModel();
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TRANSFORMATION:
				if (resolve) return getT2qvtrTransformation();
				return basicGetT2qvtrTransformation();
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TYPED_MODEL:
				if (resolve) return getT2qvtrTypedModel();
				return basicGetT2qvtrTypedModel();
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_MODULE:
				if (resolve) return getWmapModule();
				return basicGetWmapModule();
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL:
				if (resolve) return getWmapOclMetamodel();
				return basicGetWmapOclMetamodel();
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
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T0TM_NAME:
				setT0tmName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1ATL_MODULE:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_METAMODEL:
				setT1oclMetamodel((OclModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_MODEL:
				setT1oclModel((OclModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TYPED_MODEL:
				setT2qvtrTypedModel((TypedModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_MODULE:
				setWmapModule((TmapModule)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL:
				setWmapOclMetamodel((TmapOclMetamodel)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T0TM_NAME:
				setT0tmName(T0TM_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1ATL_MODULE:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_METAMODEL:
				setT1oclMetamodel((OclModel)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_MODEL:
				setT1oclModel((OclModel)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TYPED_MODEL:
				setT2qvtrTypedModel((TypedModel)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_MODULE:
				setWmapModule((TmapModule)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL:
				setWmapOclMetamodel((TmapOclMetamodel)null);
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
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T0TM_NAME:
				return T0TM_NAME_EDEFAULT == null ? t0tmName != null : !T0TM_NAME_EDEFAULT.equals(t0tmName);
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1ATL_MODULE:
				return t1atlModule != null;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_METAMODEL:
				return t1oclMetamodel != null;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T1OCL_MODEL:
				return t1oclModel != null;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TRANSFORMATION:
				return t2qvtrTransformation != null;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__T2QVTR_TYPED_MODEL:
				return t2qvtrTypedModel != null;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_MODULE:
				return wmapModule != null;
			case trace_ATL2QVTrPackage.TMAP_OCL_MODEL_IN__WMAP_OCL_METAMODEL:
				return wmapOclMetamodel != null;
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

} //TmapOclModel_INImpl