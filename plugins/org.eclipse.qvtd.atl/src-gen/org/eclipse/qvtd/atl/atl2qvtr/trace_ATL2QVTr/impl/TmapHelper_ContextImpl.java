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

import org.eclipse.m2m.atl.common.ATL.Helper;

import org.eclipse.m2m.atl.common.OCL.OclContextDefinition;
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.OclType;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Helper Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl#getT1atlContext <em>T1atl Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl#getT1atlDefinition <em>T1atl Definition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl#getT1atlHelper <em>T1atl Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl#getT1atlReturnType <em>T1atl Return Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl#getT2qvtrFunction <em>T2qvtr Function</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl#getT2qvtrParameter <em>T2qvtr Parameter</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_ContextImpl#getWmapVariable <em>Wmap Variable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapHelper_ContextImpl extends ExecutionImpl implements TmapHelper_Context {
	/**
	 * The cached value of the '{@link #getT1atlContext() <em>T1atl Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlContext()
	 * @generated
	 * @ordered
	 */
	protected OclContextDefinition t1atlContext;

	/**
	 * The cached value of the '{@link #getT1atlDefinition() <em>T1atl Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlDefinition()
	 * @generated
	 * @ordered
	 */
	protected OclFeatureDefinition t1atlDefinition;

	/**
	 * The cached value of the '{@link #getT1atlHelper() <em>T1atl Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlHelper()
	 * @generated
	 * @ordered
	 */
	protected Helper t1atlHelper;

	/**
	 * The cached value of the '{@link #getT1atlReturnType() <em>T1atl Return Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlReturnType()
	 * @generated
	 * @ordered
	 */
	protected OclType t1atlReturnType;

	/**
	 * The cached value of the '{@link #getT2qvtrFunction() <em>T2qvtr Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrFunction()
	 * @generated
	 * @ordered
	 */
	protected Function t2qvtrFunction;

	/**
	 * The cached value of the '{@link #getT2qvtrParameter() <em>T2qvtr Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrParameter()
	 * @generated
	 * @ordered
	 */
	protected FunctionParameter t2qvtrParameter;

	/**
	 * The cached value of the '{@link #getWmapVariable() <em>Wmap Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapVariable()
	 * @generated
	 * @ordered
	 */
	protected TmapVariable wmapVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapHelper_ContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_HELPER_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclContextDefinition getT1atlContext() {
		if (t1atlContext != null && t1atlContext.eIsProxy()) {
			InternalEObject oldT1atlContext = (InternalEObject)t1atlContext;
			t1atlContext = (OclContextDefinition)eResolveProxy(oldT1atlContext);
			if (t1atlContext != oldT1atlContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_CONTEXT, oldT1atlContext, t1atlContext));
			}
		}
		return t1atlContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclContextDefinition basicGetT1atlContext() {
		return t1atlContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlContext(OclContextDefinition newT1atlContext) {
		OclContextDefinition oldT1atlContext = t1atlContext;
		t1atlContext = newT1atlContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_CONTEXT, oldT1atlContext, t1atlContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclFeatureDefinition getT1atlDefinition() {
		if (t1atlDefinition != null && t1atlDefinition.eIsProxy()) {
			InternalEObject oldT1atlDefinition = (InternalEObject)t1atlDefinition;
			t1atlDefinition = (OclFeatureDefinition)eResolveProxy(oldT1atlDefinition);
			if (t1atlDefinition != oldT1atlDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_DEFINITION, oldT1atlDefinition, t1atlDefinition));
			}
		}
		return t1atlDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclFeatureDefinition basicGetT1atlDefinition() {
		return t1atlDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlDefinition(OclFeatureDefinition newT1atlDefinition) {
		OclFeatureDefinition oldT1atlDefinition = t1atlDefinition;
		t1atlDefinition = newT1atlDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_DEFINITION, oldT1atlDefinition, t1atlDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Helper getT1atlHelper() {
		if (t1atlHelper != null && t1atlHelper.eIsProxy()) {
			InternalEObject oldT1atlHelper = (InternalEObject)t1atlHelper;
			t1atlHelper = (Helper)eResolveProxy(oldT1atlHelper);
			if (t1atlHelper != oldT1atlHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_HELPER, oldT1atlHelper, t1atlHelper));
			}
		}
		return t1atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper basicGetT1atlHelper() {
		return t1atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlHelper(Helper newT1atlHelper) {
		Helper oldT1atlHelper = t1atlHelper;
		t1atlHelper = newT1atlHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_HELPER, oldT1atlHelper, t1atlHelper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclType getT1atlReturnType() {
		if (t1atlReturnType != null && t1atlReturnType.eIsProxy()) {
			InternalEObject oldT1atlReturnType = (InternalEObject)t1atlReturnType;
			t1atlReturnType = (OclType)eResolveProxy(oldT1atlReturnType);
			if (t1atlReturnType != oldT1atlReturnType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_RETURN_TYPE, oldT1atlReturnType, t1atlReturnType));
			}
		}
		return t1atlReturnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclType basicGetT1atlReturnType() {
		return t1atlReturnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlReturnType(OclType newT1atlReturnType) {
		OclType oldT1atlReturnType = t1atlReturnType;
		t1atlReturnType = newT1atlReturnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_RETURN_TYPE, oldT1atlReturnType, t1atlReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getT2qvtrFunction() {
		if (t2qvtrFunction != null && t2qvtrFunction.eIsProxy()) {
			InternalEObject oldT2qvtrFunction = (InternalEObject)t2qvtrFunction;
			t2qvtrFunction = (Function)eResolveProxy(oldT2qvtrFunction);
			if (t2qvtrFunction != oldT2qvtrFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_FUNCTION, oldT2qvtrFunction, t2qvtrFunction));
			}
		}
		return t2qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetT2qvtrFunction() {
		return t2qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrFunction(Function newT2qvtrFunction) {
		Function oldT2qvtrFunction = t2qvtrFunction;
		t2qvtrFunction = newT2qvtrFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_FUNCTION, oldT2qvtrFunction, t2qvtrFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionParameter getT2qvtrParameter() {
		if (t2qvtrParameter != null && t2qvtrParameter.eIsProxy()) {
			InternalEObject oldT2qvtrParameter = (InternalEObject)t2qvtrParameter;
			t2qvtrParameter = (FunctionParameter)eResolveProxy(oldT2qvtrParameter);
			if (t2qvtrParameter != oldT2qvtrParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_PARAMETER, oldT2qvtrParameter, t2qvtrParameter));
			}
		}
		return t2qvtrParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionParameter basicGetT2qvtrParameter() {
		return t2qvtrParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrParameter(FunctionParameter newT2qvtrParameter) {
		FunctionParameter oldT2qvtrParameter = t2qvtrParameter;
		t2qvtrParameter = newT2qvtrParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_PARAMETER, oldT2qvtrParameter, t2qvtrParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapVariable getWmapVariable() {
		if (wmapVariable != null && wmapVariable.eIsProxy()) {
			InternalEObject oldWmapVariable = (InternalEObject)wmapVariable;
			wmapVariable = (TmapVariable)eResolveProxy(oldWmapVariable);
			if (wmapVariable != oldWmapVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__WMAP_VARIABLE, oldWmapVariable, wmapVariable));
			}
		}
		return wmapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapVariable basicGetWmapVariable() {
		return wmapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapVariable(TmapVariable newWmapVariable) {
		TmapVariable oldWmapVariable = wmapVariable;
		wmapVariable = newWmapVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__WMAP_VARIABLE, oldWmapVariable, wmapVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_CONTEXT:
				if (resolve) return getT1atlContext();
				return basicGetT1atlContext();
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_DEFINITION:
				if (resolve) return getT1atlDefinition();
				return basicGetT1atlDefinition();
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_HELPER:
				if (resolve) return getT1atlHelper();
				return basicGetT1atlHelper();
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_RETURN_TYPE:
				if (resolve) return getT1atlReturnType();
				return basicGetT1atlReturnType();
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_FUNCTION:
				if (resolve) return getT2qvtrFunction();
				return basicGetT2qvtrFunction();
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_PARAMETER:
				if (resolve) return getT2qvtrParameter();
				return basicGetT2qvtrParameter();
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__WMAP_VARIABLE:
				if (resolve) return getWmapVariable();
				return basicGetWmapVariable();
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
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_CONTEXT:
				setT1atlContext((OclContextDefinition)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_DEFINITION:
				setT1atlDefinition((OclFeatureDefinition)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_HELPER:
				setT1atlHelper((Helper)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_RETURN_TYPE:
				setT1atlReturnType((OclType)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_FUNCTION:
				setT2qvtrFunction((Function)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_PARAMETER:
				setT2qvtrParameter((FunctionParameter)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__WMAP_VARIABLE:
				setWmapVariable((TmapVariable)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_CONTEXT:
				setT1atlContext((OclContextDefinition)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_DEFINITION:
				setT1atlDefinition((OclFeatureDefinition)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_HELPER:
				setT1atlHelper((Helper)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_RETURN_TYPE:
				setT1atlReturnType((OclType)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_FUNCTION:
				setT2qvtrFunction((Function)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_PARAMETER:
				setT2qvtrParameter((FunctionParameter)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__WMAP_VARIABLE:
				setWmapVariable((TmapVariable)null);
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
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_CONTEXT:
				return t1atlContext != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_DEFINITION:
				return t1atlDefinition != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_HELPER:
				return t1atlHelper != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T1ATL_RETURN_TYPE:
				return t1atlReturnType != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_FUNCTION:
				return t2qvtrFunction != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__T2QVTR_PARAMETER:
				return t2qvtrParameter != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_CONTEXT__WMAP_VARIABLE:
				return wmapVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //TmapHelper_ContextImpl
