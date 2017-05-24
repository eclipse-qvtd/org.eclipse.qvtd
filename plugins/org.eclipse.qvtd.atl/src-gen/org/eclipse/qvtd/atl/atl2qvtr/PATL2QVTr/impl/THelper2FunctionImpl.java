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

import org.eclipse.m2m.atl.common.ATL.Helper;
import org.eclipse.m2m.atl.common.ATL.Module;

import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.Operation;

import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.PATL2QVTrPackage;
import org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.THelper2Function;

import org.eclipse.qvtd.pivot.qvtbase.Function;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>THelper2 Function</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl#getADef <em>ADef</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl#getAFeat <em>AFeat</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl#getAModule <em>AModule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl#getHelper <em>Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl#getOpName <em>Op Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.PATL2QVTr.impl.THelper2FunctionImpl#getRelTx <em>Rel Tx</em>}</li>
 * </ul>
 *
 * @generated
 */
public class THelper2FunctionImpl extends MinimalEObjectImpl.Container implements THelper2Function {
	/**
	 * The cached value of the '{@link #getADef() <em>ADef</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getADef()
	 * @generated
	 * @ordered
	 */
	protected OclFeatureDefinition aDef;

	/**
	 * The cached value of the '{@link #getAFeat() <em>AFeat</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAFeat()
	 * @generated
	 * @ordered
	 */
	protected Operation aFeat;

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
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected Function function;

	/**
	 * The cached value of the '{@link #getHelper() <em>Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHelper()
	 * @generated
	 * @ordered
	 */
	protected Helper helper;

	/**
	 * The default value of the '{@link #getOpName() <em>Op Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpName()
	 * @generated
	 * @ordered
	 */
	protected static final String OP_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOpName() <em>Op Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpName()
	 * @generated
	 * @ordered
	 */
	protected String opName = OP_NAME_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected THelper2FunctionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PATL2QVTrPackage.Literals.THELPER2_FUNCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclFeatureDefinition getADef() {
		if (aDef != null && aDef.eIsProxy()) {
			InternalEObject oldADef = (InternalEObject)aDef;
			aDef = (OclFeatureDefinition)eResolveProxy(oldADef);
			if (aDef != oldADef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.THELPER2_FUNCTION__ADEF, oldADef, aDef));
			}
		}
		return aDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclFeatureDefinition basicGetADef() {
		return aDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setADef(OclFeatureDefinition newADef) {
		OclFeatureDefinition oldADef = aDef;
		aDef = newADef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.THELPER2_FUNCTION__ADEF, oldADef, aDef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getAFeat() {
		if (aFeat != null && aFeat.eIsProxy()) {
			InternalEObject oldAFeat = (InternalEObject)aFeat;
			aFeat = (Operation)eResolveProxy(oldAFeat);
			if (aFeat != oldAFeat) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.THELPER2_FUNCTION__AFEAT, oldAFeat, aFeat));
			}
		}
		return aFeat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetAFeat() {
		return aFeat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAFeat(Operation newAFeat) {
		Operation oldAFeat = aFeat;
		aFeat = newAFeat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.THELPER2_FUNCTION__AFEAT, oldAFeat, aFeat));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.THELPER2_FUNCTION__AMODULE, oldAModule, aModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.THELPER2_FUNCTION__AMODULE, oldAModule, aModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function getFunction() {
		if (function != null && function.eIsProxy()) {
			InternalEObject oldFunction = (InternalEObject)function;
			function = (Function)eResolveProxy(oldFunction);
			if (function != oldFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.THELPER2_FUNCTION__FUNCTION, oldFunction, function));
			}
		}
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFunction(Function newFunction) {
		Function oldFunction = function;
		function = newFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.THELPER2_FUNCTION__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper getHelper() {
		if (helper != null && helper.eIsProxy()) {
			InternalEObject oldHelper = (InternalEObject)helper;
			helper = (Helper)eResolveProxy(oldHelper);
			if (helper != oldHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.THELPER2_FUNCTION__HELPER, oldHelper, helper));
			}
		}
		return helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper basicGetHelper() {
		return helper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHelper(Helper newHelper) {
		Helper oldHelper = helper;
		helper = newHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.THELPER2_FUNCTION__HELPER, oldHelper, helper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOpName() {
		return opName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOpName(String newOpName) {
		String oldOpName = opName;
		opName = newOpName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.THELPER2_FUNCTION__OP_NAME, oldOpName, opName));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PATL2QVTrPackage.THELPER2_FUNCTION__REL_TX, oldRelTx, relTx));
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
			eNotify(new ENotificationImpl(this, Notification.SET, PATL2QVTrPackage.THELPER2_FUNCTION__REL_TX, oldRelTx, relTx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case PATL2QVTrPackage.THELPER2_FUNCTION__ADEF:
				if (resolve) return getADef();
				return basicGetADef();
			case PATL2QVTrPackage.THELPER2_FUNCTION__AFEAT:
				if (resolve) return getAFeat();
				return basicGetAFeat();
			case PATL2QVTrPackage.THELPER2_FUNCTION__AMODULE:
				if (resolve) return getAModule();
				return basicGetAModule();
			case PATL2QVTrPackage.THELPER2_FUNCTION__FUNCTION:
				if (resolve) return getFunction();
				return basicGetFunction();
			case PATL2QVTrPackage.THELPER2_FUNCTION__HELPER:
				if (resolve) return getHelper();
				return basicGetHelper();
			case PATL2QVTrPackage.THELPER2_FUNCTION__OP_NAME:
				return getOpName();
			case PATL2QVTrPackage.THELPER2_FUNCTION__REL_TX:
				if (resolve) return getRelTx();
				return basicGetRelTx();
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
			case PATL2QVTrPackage.THELPER2_FUNCTION__ADEF:
				setADef((OclFeatureDefinition)newValue);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__AFEAT:
				setAFeat((Operation)newValue);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__AMODULE:
				setAModule((Module)newValue);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__FUNCTION:
				setFunction((Function)newValue);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__HELPER:
				setHelper((Helper)newValue);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__OP_NAME:
				setOpName((String)newValue);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__REL_TX:
				setRelTx((RelationalTransformation)newValue);
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
			case PATL2QVTrPackage.THELPER2_FUNCTION__ADEF:
				setADef((OclFeatureDefinition)null);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__AFEAT:
				setAFeat((Operation)null);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__AMODULE:
				setAModule((Module)null);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__FUNCTION:
				setFunction((Function)null);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__HELPER:
				setHelper((Helper)null);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__OP_NAME:
				setOpName(OP_NAME_EDEFAULT);
				return;
			case PATL2QVTrPackage.THELPER2_FUNCTION__REL_TX:
				setRelTx((RelationalTransformation)null);
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
			case PATL2QVTrPackage.THELPER2_FUNCTION__ADEF:
				return aDef != null;
			case PATL2QVTrPackage.THELPER2_FUNCTION__AFEAT:
				return aFeat != null;
			case PATL2QVTrPackage.THELPER2_FUNCTION__AMODULE:
				return aModule != null;
			case PATL2QVTrPackage.THELPER2_FUNCTION__FUNCTION:
				return function != null;
			case PATL2QVTrPackage.THELPER2_FUNCTION__HELPER:
				return helper != null;
			case PATL2QVTrPackage.THELPER2_FUNCTION__OP_NAME:
				return OP_NAME_EDEFAULT == null ? opName != null : !OP_NAME_EDEFAULT.equals(opName);
			case PATL2QVTrPackage.THELPER2_FUNCTION__REL_TX:
				return relTx != null;
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
		result.append(" (opName: ");
		result.append(opName);
		result.append(')');
		return result.toString();
	}

} //THelper2FunctionImpl
