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
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.VariableExp;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapOperationCallExp_Helper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Operation Call Exp Helper</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getT0operationName <em>T0operation Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getT1atlSource <em>T1atl Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getT2qvtrOperation <em>T2qvtr Operation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getT2qvtrSource <em>T2qvtr Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getT2qvtrSourceArgument <em>T2qvtr Source Argument</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getT2qvtrTransformation <em>T2qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getWmapHelper <em>Wmap Helper</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getWmapModule <em>Wmap Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapOperationCallExp_HelperImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapOperationCallExp_HelperImpl extends ImapOclExpressionImpl implements TmapOperationCallExp_Helper {
	/**
	 * The default value of the '{@link #getT0operationName() <em>T0operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0operationName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0OPERATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0operationName() <em>T0operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0operationName()
	 * @generated
	 * @ordered
	 */
	protected String t0operationName = T0OPERATION_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT1atlSource() <em>T1atl Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlSource()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t1atlSource;

	/**
	 * The cached value of the '{@link #getT2qvtrOperation() <em>T2qvtr Operation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrOperation()
	 * @generated
	 * @ordered
	 */
	protected Operation t2qvtrOperation;

	/**
	 * The cached value of the '{@link #getT2qvtrSource() <em>T2qvtr Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrSource()
	 * @generated
	 * @ordered
	 */
	protected VariableExp t2qvtrSource;

	/**
	 * The cached value of the '{@link #getT2qvtrSourceArgument() <em>T2qvtr Source Argument</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrSourceArgument()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t2qvtrSourceArgument;

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
	 * The cached value of the '{@link #getWmapHelper() <em>Wmap Helper</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapHelper()
	 * @generated
	 * @ordered
	 */
	protected DmapHelper wmapHelper;

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
	 * The cached value of the '{@link #getWmapOclExpression() <em>Wmap Ocl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapOclExpression()
	 * @generated
	 * @ordered
	 */
	protected DmapOclExpression wmapOclExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapOperationCallExp_HelperImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_OPERATION_CALL_EXP_HELPER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression getDispatcher() {
		if (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER) return null;
		return (DmapOclExpression)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapOclExpression newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDispatcher(DmapOclExpression newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER, DmapOclExpression.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getT0operationName() {
		return t0operationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT0operationName(String newT0operationName) {
		String oldT0operationName = t0operationName;
		t0operationName = newT0operationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME, oldT0operationName, t0operationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getT1atlSource() {
		if (t1atlSource != null && t1atlSource.eIsProxy()) {
			InternalEObject oldT1atlSource = (InternalEObject)t1atlSource;
			t1atlSource = (OclExpression)eResolveProxy(oldT1atlSource);
			if (t1atlSource != oldT1atlSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T1ATL_SOURCE, oldT1atlSource, t1atlSource));
			}
		}
		return t1atlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT1atlSource() {
		return t1atlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT1atlSource(OclExpression newT1atlSource) {
		OclExpression oldT1atlSource = t1atlSource;
		t1atlSource = newT1atlSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T1ATL_SOURCE, oldT1atlSource, t1atlSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getT2qvtrOperation() {
		if (t2qvtrOperation != null && t2qvtrOperation.eIsProxy()) {
			InternalEObject oldT2qvtrOperation = (InternalEObject)t2qvtrOperation;
			t2qvtrOperation = (Operation)eResolveProxy(oldT2qvtrOperation);
			if (t2qvtrOperation != oldT2qvtrOperation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_OPERATION, oldT2qvtrOperation, t2qvtrOperation));
			}
		}
		return t2qvtrOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetT2qvtrOperation() {
		return t2qvtrOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT2qvtrOperation(Operation newT2qvtrOperation) {
		Operation oldT2qvtrOperation = t2qvtrOperation;
		t2qvtrOperation = newT2qvtrOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_OPERATION, oldT2qvtrOperation, t2qvtrOperation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp getT2qvtrSource() {
		if (t2qvtrSource != null && t2qvtrSource.eIsProxy()) {
			InternalEObject oldT2qvtrSource = (InternalEObject)t2qvtrSource;
			t2qvtrSource = (VariableExp)eResolveProxy(oldT2qvtrSource);
			if (t2qvtrSource != oldT2qvtrSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE, oldT2qvtrSource, t2qvtrSource));
			}
		}
		return t2qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableExp basicGetT2qvtrSource() {
		return t2qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT2qvtrSource(VariableExp newT2qvtrSource) {
		VariableExp oldT2qvtrSource = t2qvtrSource;
		t2qvtrSource = newT2qvtrSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE, oldT2qvtrSource, t2qvtrSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getT2qvtrSourceArgument() {
		if (t2qvtrSourceArgument != null && t2qvtrSourceArgument.eIsProxy()) {
			InternalEObject oldT2qvtrSourceArgument = (InternalEObject)t2qvtrSourceArgument;
			t2qvtrSourceArgument = (OCLExpression)eResolveProxy(oldT2qvtrSourceArgument);
			if (t2qvtrSourceArgument != oldT2qvtrSourceArgument) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT, oldT2qvtrSourceArgument, t2qvtrSourceArgument));
			}
		}
		return t2qvtrSourceArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT2qvtrSourceArgument() {
		return t2qvtrSourceArgument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT2qvtrSourceArgument(OCLExpression newT2qvtrSourceArgument) {
		OCLExpression oldT2qvtrSourceArgument = t2qvtrSourceArgument;
		t2qvtrSourceArgument = newT2qvtrSourceArgument;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT, oldT2qvtrSourceArgument, t2qvtrSourceArgument));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation getT2qvtrTransformation() {
		if (t2qvtrTransformation != null && t2qvtrTransformation.eIsProxy()) {
			InternalEObject oldT2qvtrTransformation = (InternalEObject)t2qvtrTransformation;
			t2qvtrTransformation = (RelationalTransformation)eResolveProxy(oldT2qvtrTransformation);
			if (t2qvtrTransformation != oldT2qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
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
	public void setT2qvtrTransformation(RelationalTransformation newT2qvtrTransformation) {
		RelationalTransformation oldT2qvtrTransformation = t2qvtrTransformation;
		t2qvtrTransformation = newT2qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapHelper getWmapHelper() {
		if (wmapHelper != null && wmapHelper.eIsProxy()) {
			InternalEObject oldWmapHelper = (InternalEObject)wmapHelper;
			wmapHelper = (DmapHelper)eResolveProxy(oldWmapHelper);
			if (wmapHelper != oldWmapHelper) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER, oldWmapHelper, wmapHelper));
			}
		}
		return wmapHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapHelper basicGetWmapHelper() {
		return wmapHelper;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWmapHelper(DmapHelper newWmapHelper) {
		DmapHelper oldWmapHelper = wmapHelper;
		wmapHelper = newWmapHelper;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER, oldWmapHelper, wmapHelper));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapModule getWmapModule() {
		if (wmapModule != null && wmapModule.eIsProxy()) {
			InternalEObject oldWmapModule = (InternalEObject)wmapModule;
			wmapModule = (TmapModule)eResolveProxy(oldWmapModule);
			if (wmapModule != oldWmapModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE, oldWmapModule, wmapModule));
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
	public void setWmapModule(TmapModule newWmapModule) {
		TmapModule oldWmapModule = wmapModule;
		wmapModule = newWmapModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE, oldWmapModule, wmapModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression getWmapOclExpression() {
		if (wmapOclExpression != null && wmapOclExpression.eIsProxy()) {
			InternalEObject oldWmapOclExpression = (InternalEObject)wmapOclExpression;
			wmapOclExpression = (DmapOclExpression)eResolveProxy(oldWmapOclExpression);
			if (wmapOclExpression != oldWmapOclExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
			}
		}
		return wmapOclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapOclExpression basicGetWmapOclExpression() {
		return wmapOclExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWmapOclExpression(DmapOclExpression newWmapOclExpression) {
		DmapOclExpression oldWmapOclExpression = wmapOclExpression;
		wmapOclExpression = newWmapOclExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDispatcher((DmapOclExpression)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER:
				return basicSetDispatcher(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER:
				return eInternalContainer().eInverseRemove(this, trace_ATL2QVTrPackage.DMAP_OCL_EXPRESSION__DOMAP_OPERATION_CALL_EXP_HELPER, DmapOclExpression.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER:
				return getDispatcher();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME:
				return getT0operationName();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T1ATL_SOURCE:
				if (resolve) return getT1atlSource();
				return basicGetT1atlSource();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_OPERATION:
				if (resolve) return getT2qvtrOperation();
				return basicGetT2qvtrOperation();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE:
				if (resolve) return getT2qvtrSource();
				return basicGetT2qvtrSource();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT:
				if (resolve) return getT2qvtrSourceArgument();
				return basicGetT2qvtrSourceArgument();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION:
				if (resolve) return getT2qvtrTransformation();
				return basicGetT2qvtrTransformation();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER:
				if (resolve) return getWmapHelper();
				return basicGetWmapHelper();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE:
				if (resolve) return getWmapModule();
				return basicGetWmapModule();
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
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
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER:
				setDispatcher((DmapOclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME:
				setT0operationName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T1ATL_SOURCE:
				setT1atlSource((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_OPERATION:
				setT2qvtrOperation((Operation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE:
				setT2qvtrSource((VariableExp)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT:
				setT2qvtrSourceArgument((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER:
				setWmapHelper((DmapHelper)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE:
				setWmapModule((TmapModule)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION:
				setWmapOclExpression((DmapOclExpression)newValue);
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
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER:
				setDispatcher((DmapOclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME:
				setT0operationName(T0OPERATION_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T1ATL_SOURCE:
				setT1atlSource((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_OPERATION:
				setT2qvtrOperation((Operation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE:
				setT2qvtrSource((VariableExp)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT:
				setT2qvtrSourceArgument((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER:
				setWmapHelper((DmapHelper)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE:
				setWmapModule((TmapModule)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION:
				setWmapOclExpression((DmapOclExpression)null);
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
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__DISPATCHER:
				return getDispatcher() != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T0OPERATION_NAME:
				return T0OPERATION_NAME_EDEFAULT == null ? t0operationName != null : !T0OPERATION_NAME_EDEFAULT.equals(t0operationName);
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T1ATL_SOURCE:
				return t1atlSource != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_OPERATION:
				return t2qvtrOperation != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE:
				return t2qvtrSource != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_SOURCE_ARGUMENT:
				return t2qvtrSourceArgument != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__T2QVTR_TRANSFORMATION:
				return t2qvtrTransformation != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_HELPER:
				return wmapHelper != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_MODULE:
				return wmapModule != null;
			case trace_ATL2QVTrPackage.TMAP_OPERATION_CALL_EXP_HELPER__WMAP_OCL_EXPRESSION:
				return wmapOclExpression != null;
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
		result.append(" (t0operationName: ");
		result.append(t0operationName);
		result.append(')');
		return result.toString();
	}

} //TmapOperationCallExp_HelperImpl
