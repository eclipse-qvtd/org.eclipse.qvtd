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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.Helper;

import org.eclipse.m2m.atl.common.OCL.OclContextDefinition;
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.OclType;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapHelper_Context;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapVariable;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.FunctionParameter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Helper Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_ContextImpl#getAtl_atlContext <em>Atl atl Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_ContextImpl#getAtl_atlDefinition <em>Atl atl Definition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_ContextImpl#getAtl_atlHelper <em>Atl atl Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_ContextImpl#getAtl_atlReturnType <em>Atl atl Return Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_ContextImpl#getInvocation_mapVariable <em>Invocation map Variable</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_ContextImpl#getQvtr_qvtrFunction <em>Qvtr qvtr Function</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapHelper_ContextImpl#getQvtr_qvtrParameter <em>Qvtr qvtr Parameter</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapHelper_ContextImpl extends MinimalEObjectImpl.Container implements TC_mapHelper_Context {
	/**
	 * The cached value of the '{@link #getAtl_atlContext() <em>Atl atl Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlContext()
	 * @generated
	 * @ordered
	 */
	protected OclContextDefinition atl_atlContext;

	/**
	 * The cached value of the '{@link #getAtl_atlDefinition() <em>Atl atl Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlDefinition()
	 * @generated
	 * @ordered
	 */
	protected OclFeatureDefinition atl_atlDefinition;

	/**
	 * The cached value of the '{@link #getAtl_atlHelper() <em>Atl atl Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlHelper()
	 * @generated
	 * @ordered
	 */
	protected Helper atl_atlHelper;

	/**
	 * The cached value of the '{@link #getAtl_atlReturnType() <em>Atl atl Return Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlReturnType()
	 * @generated
	 * @ordered
	 */
	protected OclType atl_atlReturnType;

	/**
	 * The cached value of the '{@link #getInvocation_mapVariable() <em>Invocation map Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInvocation_mapVariable()
	 * @generated
	 * @ordered
	 */
	protected TC_mapVariable invocation_mapVariable;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrFunction() <em>Qvtr qvtr Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrFunction()
	 * @generated
	 * @ordered
	 */
	protected Function qvtr_qvtrFunction;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrParameter() <em>Qvtr qvtr Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrParameter()
	 * @generated
	 * @ordered
	 */
	protected FunctionParameter qvtr_qvtrParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapHelper_ContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_HELPER_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclContextDefinition getAtl_atlContext() {
		if (atl_atlContext != null && atl_atlContext.eIsProxy()) {
			InternalEObject oldAtl_atlContext = atl_atlContext;
			atl_atlContext = (OclContextDefinition)eResolveProxy(oldAtl_atlContext);
			if (atl_atlContext != oldAtl_atlContext) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_CONTEXT, oldAtl_atlContext, atl_atlContext));
			}
		}
		return atl_atlContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclContextDefinition basicGetAtl_atlContext() {
		return atl_atlContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlContext(OclContextDefinition newAtl_atlContext) {
		OclContextDefinition oldAtl_atlContext = atl_atlContext;
		atl_atlContext = newAtl_atlContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_CONTEXT, oldAtl_atlContext, atl_atlContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclFeatureDefinition getAtl_atlDefinition() {
		if (atl_atlDefinition != null && atl_atlDefinition.eIsProxy()) {
			InternalEObject oldAtl_atlDefinition = atl_atlDefinition;
			atl_atlDefinition = (OclFeatureDefinition)eResolveProxy(oldAtl_atlDefinition);
			if (atl_atlDefinition != oldAtl_atlDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_DEFINITION, oldAtl_atlDefinition, atl_atlDefinition));
			}
		}
		return atl_atlDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclFeatureDefinition basicGetAtl_atlDefinition() {
		return atl_atlDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlDefinition(OclFeatureDefinition newAtl_atlDefinition) {
		OclFeatureDefinition oldAtl_atlDefinition = atl_atlDefinition;
		atl_atlDefinition = newAtl_atlDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_DEFINITION, oldAtl_atlDefinition, atl_atlDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Helper getAtl_atlHelper() {
		if (atl_atlHelper != null && atl_atlHelper.eIsProxy()) {
			InternalEObject oldAtl_atlHelper = atl_atlHelper;
			atl_atlHelper = (Helper)eResolveProxy(oldAtl_atlHelper);
			if (atl_atlHelper != oldAtl_atlHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_HELPER, oldAtl_atlHelper, atl_atlHelper));
			}
		}
		return atl_atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Helper basicGetAtl_atlHelper() {
		return atl_atlHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlHelper(Helper newAtl_atlHelper) {
		Helper oldAtl_atlHelper = atl_atlHelper;
		atl_atlHelper = newAtl_atlHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_HELPER, oldAtl_atlHelper, atl_atlHelper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclType getAtl_atlReturnType() {
		if (atl_atlReturnType != null && atl_atlReturnType.eIsProxy()) {
			InternalEObject oldAtl_atlReturnType = atl_atlReturnType;
			atl_atlReturnType = (OclType)eResolveProxy(oldAtl_atlReturnType);
			if (atl_atlReturnType != oldAtl_atlReturnType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_RETURN_TYPE, oldAtl_atlReturnType, atl_atlReturnType));
			}
		}
		return atl_atlReturnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclType basicGetAtl_atlReturnType() {
		return atl_atlReturnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAtl_atlReturnType(OclType newAtl_atlReturnType) {
		OclType oldAtl_atlReturnType = atl_atlReturnType;
		atl_atlReturnType = newAtl_atlReturnType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_RETURN_TYPE, oldAtl_atlReturnType, atl_atlReturnType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TC_mapVariable getInvocation_mapVariable() {
		return invocation_mapVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInvocation_mapVariable(TC_mapVariable newInvocation_mapVariable, NotificationChain msgs) {
		TC_mapVariable oldInvocation_mapVariable = invocation_mapVariable;
		invocation_mapVariable = newInvocation_mapVariable;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE, oldInvocation_mapVariable, newInvocation_mapVariable);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInvocation_mapVariable(TC_mapVariable newInvocation_mapVariable) {
		if (newInvocation_mapVariable != invocation_mapVariable) {
			NotificationChain msgs = null;
			if (invocation_mapVariable != null)
				msgs = ((InternalEObject)invocation_mapVariable).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE, null, msgs);
			if (newInvocation_mapVariable != null)
				msgs = ((InternalEObject)newInvocation_mapVariable).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE, null, msgs);
			msgs = basicSetInvocation_mapVariable(newInvocation_mapVariable, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE, newInvocation_mapVariable, newInvocation_mapVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function getQvtr_qvtrFunction() {
		if (qvtr_qvtrFunction != null && qvtr_qvtrFunction.eIsProxy()) {
			InternalEObject oldQvtr_qvtrFunction = (InternalEObject)qvtr_qvtrFunction;
			qvtr_qvtrFunction = (Function)eResolveProxy(oldQvtr_qvtrFunction);
			if (qvtr_qvtrFunction != oldQvtr_qvtrFunction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_FUNCTION, oldQvtr_qvtrFunction, qvtr_qvtrFunction));
			}
		}
		return qvtr_qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function basicGetQvtr_qvtrFunction() {
		return qvtr_qvtrFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrFunction(Function newQvtr_qvtrFunction) {
		Function oldQvtr_qvtrFunction = qvtr_qvtrFunction;
		qvtr_qvtrFunction = newQvtr_qvtrFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_FUNCTION, oldQvtr_qvtrFunction, qvtr_qvtrFunction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FunctionParameter getQvtr_qvtrParameter() {
		if (qvtr_qvtrParameter != null && qvtr_qvtrParameter.eIsProxy()) {
			InternalEObject oldQvtr_qvtrParameter = (InternalEObject)qvtr_qvtrParameter;
			qvtr_qvtrParameter = (FunctionParameter)eResolveProxy(oldQvtr_qvtrParameter);
			if (qvtr_qvtrParameter != oldQvtr_qvtrParameter) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_PARAMETER, oldQvtr_qvtrParameter, qvtr_qvtrParameter));
			}
		}
		return qvtr_qvtrParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionParameter basicGetQvtr_qvtrParameter() {
		return qvtr_qvtrParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQvtr_qvtrParameter(FunctionParameter newQvtr_qvtrParameter) {
		FunctionParameter oldQvtr_qvtrParameter = qvtr_qvtrParameter;
		qvtr_qvtrParameter = newQvtr_qvtrParameter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_PARAMETER, oldQvtr_qvtrParameter, qvtr_qvtrParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE:
				return basicSetInvocation_mapVariable(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_CONTEXT:
				if (resolve) return getAtl_atlContext();
				return basicGetAtl_atlContext();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_DEFINITION:
				if (resolve) return getAtl_atlDefinition();
				return basicGetAtl_atlDefinition();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_HELPER:
				if (resolve) return getAtl_atlHelper();
				return basicGetAtl_atlHelper();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_RETURN_TYPE:
				if (resolve) return getAtl_atlReturnType();
				return basicGetAtl_atlReturnType();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE:
				return getInvocation_mapVariable();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_FUNCTION:
				if (resolve) return getQvtr_qvtrFunction();
				return basicGetQvtr_qvtrFunction();
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_PARAMETER:
				if (resolve) return getQvtr_qvtrParameter();
				return basicGetQvtr_qvtrParameter();
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
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_CONTEXT:
				setAtl_atlContext((OclContextDefinition)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_DEFINITION:
				setAtl_atlDefinition((OclFeatureDefinition)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_HELPER:
				setAtl_atlHelper((Helper)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_RETURN_TYPE:
				setAtl_atlReturnType((OclType)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE:
				setInvocation_mapVariable((TC_mapVariable)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_FUNCTION:
				setQvtr_qvtrFunction((Function)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_PARAMETER:
				setQvtr_qvtrParameter((FunctionParameter)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_CONTEXT:
				setAtl_atlContext((OclContextDefinition)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_DEFINITION:
				setAtl_atlDefinition((OclFeatureDefinition)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_HELPER:
				setAtl_atlHelper((Helper)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_RETURN_TYPE:
				setAtl_atlReturnType((OclType)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE:
				setInvocation_mapVariable((TC_mapVariable)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_FUNCTION:
				setQvtr_qvtrFunction((Function)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_PARAMETER:
				setQvtr_qvtrParameter((FunctionParameter)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_CONTEXT:
				return atl_atlContext != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_DEFINITION:
				return atl_atlDefinition != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_HELPER:
				return atl_atlHelper != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__ATL_ATL_RETURN_TYPE:
				return atl_atlReturnType != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__INVOCATION_MAP_VARIABLE:
				return invocation_mapVariable != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_FUNCTION:
				return qvtr_qvtrFunction != null;
			case trace_ATL2QVTrPackage.TC_MAP_HELPER_CONTEXT__QVTR_QVTR_PARAMETER:
				return qvtr_qvtrParameter != null;
		}
		return super.eIsSet(featureID);
	}

} //TC_mapHelper_ContextImpl
