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

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.TModel2RelationalTransformation;

import org.eclipse.qvtd.pivot.qvtrelation.RelationModel;
import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TModel2 Relational Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl#get_3 <em>3</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl#get_4 <em>4</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl#getModule <em>Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl#getRelModel <em>Rel Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.TModel2RelationalTransformationImpl#getTxName <em>Tx Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TModel2RelationalTransformationImpl extends MinimalEObjectImpl.Container implements TModel2RelationalTransformation {
	/**
	 * The cached value of the '{@link #get_3() <em>3</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_3()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.ocl.pivot.Package _3;

	/**
	 * The cached value of the '{@link #get_4() <em>4</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #get_4()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation _4;

	/**
	 * The cached value of the '{@link #getModule() <em>Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModule()
	 * @generated
	 * @ordered
	 */
	protected Module module;

	/**
	 * The cached value of the '{@link #getRelModel() <em>Rel Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelModel()
	 * @generated
	 * @ordered
	 */
	protected RelationModel relModel;

	/**
	 * The default value of the '{@link #getTxName() <em>Tx Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTxName()
	 * @generated
	 * @ordered
	 */
	protected static final String TX_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTxName() <em>Tx Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTxName()
	 * @generated
	 * @ordered
	 */
	protected String txName = TX_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TModel2RelationalTransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PATL2QVTrPackage.Literals.TMODEL2_RELATIONAL_TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.ocl.pivot.Package get_3() {
		if (_3 != null && _3.eIsProxy()) {
			InternalEObject old_3 = (InternalEObject)_3;
			_3 = (org.eclipse.ocl.pivot.Package)eResolveProxy(old_3);
			if (_3 != old_3) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__3, old_3, _3));
			}
		}
		return _3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.ocl.pivot.Package basicGet_3() {
		return _3;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void set_3(org.eclipse.ocl.pivot.Package new_3) {
		org.eclipse.ocl.pivot.Package old_3 = _3;
		_3 = new_3;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__3, old_3, _3));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation get_4() {
		if (_4 != null && _4.eIsProxy()) {
			InternalEObject old_4 = (InternalEObject)_4;
			_4 = (RelationalTransformation)eResolveProxy(old_4);
			if (_4 != old_4) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__4, old_4, _4));
			}
		}
		return _4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGet_4() {
		return _4;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void set_4(RelationalTransformation new_4) {
		RelationalTransformation old_4 = _4;
		_4 = new_4;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__4, old_4, _4));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Module getModule() {
		if (module != null && module.eIsProxy()) {
			InternalEObject oldModule = module;
			module = (Module)eResolveProxy(oldModule);
			if (module != oldModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__MODULE, oldModule, module));
			}
		}
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module basicGetModule() {
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModule(Module newModule) {
		Module oldModule = module;
		module = newModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__MODULE, oldModule, module));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationModel getRelModel() {
		if (relModel != null && relModel.eIsProxy()) {
			InternalEObject oldRelModel = (InternalEObject)relModel;
			relModel = (RelationModel)eResolveProxy(oldRelModel);
			if (relModel != oldRelModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__REL_MODEL, oldRelModel, relModel));
			}
		}
		return relModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationModel basicGetRelModel() {
		return relModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelModel(RelationModel newRelModel) {
		RelationModel oldRelModel = relModel;
		relModel = newRelModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__REL_MODEL, oldRelModel, relModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTxName() {
		return txName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTxName(String newTxName) {
		String oldTxName = txName;
		txName = newTxName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME, oldTxName, txName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__3:
				if (resolve) return get_3();
				return basicGet_3();
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__4:
				if (resolve) return get_4();
				return basicGet_4();
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__MODULE:
				if (resolve) return getModule();
				return basicGetModule();
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__REL_MODEL:
				if (resolve) return getRelModel();
				return basicGetRelModel();
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME:
				return getTxName();
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
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__3:
				set_3((org.eclipse.ocl.pivot.Package)newValue);
				return;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__4:
				set_4((RelationalTransformation)newValue);
				return;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__MODULE:
				setModule((Module)newValue);
				return;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__REL_MODEL:
				setRelModel((RelationModel)newValue);
				return;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME:
				setTxName((String)newValue);
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
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__3:
				set_3((org.eclipse.ocl.pivot.Package)null);
				return;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__4:
				set_4((RelationalTransformation)null);
				return;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__MODULE:
				setModule((Module)null);
				return;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__REL_MODEL:
				setRelModel((RelationModel)null);
				return;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME:
				setTxName(TX_NAME_EDEFAULT);
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
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__3:
				return _3 != null;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__4:
				return _4 != null;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__MODULE:
				return module != null;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__REL_MODEL:
				return relModel != null;
			case PATL2QVTrPackage.TMODEL2_RELATIONAL_TRANSFORMATION__TX_NAME:
				return TX_NAME_EDEFAULT == null ? txName != null : !TX_NAME_EDEFAULT.equals(txName);
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
		result.append(" (txName: ");
		result.append(txName);
		result.append(')');
		return result.toString();
	}

} //TModel2RelationalTransformationImpl
