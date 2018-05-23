/**
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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

import org.eclipse.m2m.atl.common.OCL.OclModel;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapOclModel_IN;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.TypedModel;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Ocl Model IN</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclModel_INImpl#getAtl_atlModule <em>Atl atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclModel_INImpl#getAtl_oclMetamodel <em>Atl ocl Metamodel</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclModel_INImpl#getAtl_oclModel <em>Atl ocl Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclModel_INImpl#getPrimitive_tmName <em>Primitive tm Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclModel_INImpl#getQvtr_qvtrTransformation <em>Qvtr qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapOclModel_INImpl#getQvtr_qvtrTypedModel <em>Qvtr qvtr Typed Model</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapOclModel_INImpl extends MinimalEObjectImpl.Container implements TC_mapOclModel_IN {
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
	 * The cached value of the '{@link #getAtl_oclMetamodel() <em>Atl ocl Metamodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_oclMetamodel()
	 * @generated
	 * @ordered
	 */
	protected OclModel atl_oclMetamodel;

	/**
	 * The cached value of the '{@link #getAtl_oclModel() <em>Atl ocl Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_oclModel()
	 * @generated
	 * @ordered
	 */
	protected OclModel atl_oclModel;

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
	 * The cached value of the '{@link #getQvtr_qvtrTransformation() <em>Qvtr qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation qvtr_qvtrTransformation;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapOclModel_INImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_OCL_MODEL_IN;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_ATL_MODULE, oldAtl_atlModule, atl_atlModule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_METAMODEL, oldAtl_oclMetamodel, atl_oclMetamodel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_METAMODEL, oldAtl_oclMetamodel, atl_oclMetamodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclModel getAtl_oclModel() {
		if (atl_oclModel != null && atl_oclModel.eIsProxy()) {
			InternalEObject oldAtl_oclModel = atl_oclModel;
			atl_oclModel = (OclModel)eResolveProxy(oldAtl_oclModel);
			if (atl_oclModel != oldAtl_oclModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_MODEL, oldAtl_oclModel, atl_oclModel));
			}
		}
		return atl_oclModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclModel basicGetAtl_oclModel() {
		return atl_oclModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_oclModel(OclModel newAtl_oclModel) {
		OclModel oldAtl_oclModel = atl_oclModel;
		atl_oclModel = newAtl_oclModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_MODEL, oldAtl_oclModel, atl_oclModel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__PRIMITIVE_TM_NAME, oldPrimitive_tmName, primitive_tmName));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TRANSFORMATION, oldQvtr_qvtrTransformation, qvtr_qvtrTransformation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TYPED_MODEL, oldQvtr_qvtrTypedModel, qvtr_qvtrTypedModel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TYPED_MODEL, oldQvtr_qvtrTypedModel, qvtr_qvtrTypedModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_ATL_MODULE:
				if (resolve) return getAtl_atlModule();
				return basicGetAtl_atlModule();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_METAMODEL:
				if (resolve) return getAtl_oclMetamodel();
				return basicGetAtl_oclMetamodel();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_MODEL:
				if (resolve) return getAtl_oclModel();
				return basicGetAtl_oclModel();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__PRIMITIVE_TM_NAME:
				return getPrimitive_tmName();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TRANSFORMATION:
				if (resolve) return getQvtr_qvtrTransformation();
				return basicGetQvtr_qvtrTransformation();
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TYPED_MODEL:
				if (resolve) return getQvtr_qvtrTypedModel();
				return basicGetQvtr_qvtrTypedModel();
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
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_METAMODEL:
				setAtl_oclMetamodel((OclModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_MODEL:
				setAtl_oclModel((OclModel)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__PRIMITIVE_TM_NAME:
				setPrimitive_tmName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TRANSFORMATION:
				setQvtr_qvtrTransformation((RelationalTransformation)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TYPED_MODEL:
				setQvtr_qvtrTypedModel((TypedModel)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_ATL_MODULE:
				setAtl_atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_METAMODEL:
				setAtl_oclMetamodel((OclModel)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_MODEL:
				setAtl_oclModel((OclModel)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__PRIMITIVE_TM_NAME:
				setPrimitive_tmName(PRIMITIVE_TM_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TRANSFORMATION:
				setQvtr_qvtrTransformation((RelationalTransformation)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TYPED_MODEL:
				setQvtr_qvtrTypedModel((TypedModel)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_ATL_MODULE:
				return atl_atlModule != null;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_METAMODEL:
				return atl_oclMetamodel != null;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__ATL_OCL_MODEL:
				return atl_oclModel != null;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__PRIMITIVE_TM_NAME:
				return PRIMITIVE_TM_NAME_EDEFAULT == null ? primitive_tmName != null : !PRIMITIVE_TM_NAME_EDEFAULT.equals(primitive_tmName);
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TRANSFORMATION:
				return qvtr_qvtrTransformation != null;
			case trace_ATL2QVTrPackage.TC_MAP_OCL_MODEL_IN__QVTR_QVTR_TYPED_MODEL:
				return qvtr_qvtrTypedModel != null;
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
		result.append(')');
		return result.toString();
	}

} //TC_mapOclModel_INImpl
