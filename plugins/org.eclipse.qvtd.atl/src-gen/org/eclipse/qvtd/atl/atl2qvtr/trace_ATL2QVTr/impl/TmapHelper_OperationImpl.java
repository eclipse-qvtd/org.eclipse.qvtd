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
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.OclType;
import org.eclipse.m2m.atl.common.OCL.Operation;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Operation;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Helper Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT0operationName <em>T0operation Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT1atlDefinition <em>T1atl Definition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT1atlExpression <em>T1atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT1atlFeature <em>T1atl Feature</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT1atlModule <em>T1atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT1atlType <em>T1atl Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT2qvtrExpression <em>T2qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT2qvtrTransformation <em>T2qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getWmapHelper_Context <em>Wmap Helper Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getWmapModule <em>Wmap Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapHelper_OperationImpl extends ImapHelperImpl implements TmapHelper_Operation {
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
	 * The cached value of the '{@link #getT1atlDefinition() <em>T1atl Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlDefinition()
	 * @generated
	 * @ordered
	 */
	protected OclFeatureDefinition t1atlDefinition;

	/**
	 * The cached value of the '{@link #getT1atlExpression() <em>T1atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t1atlExpression;

	/**
	 * The cached value of the '{@link #getT1atlFeature() <em>T1atl Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlFeature()
	 * @generated
	 * @ordered
	 */
	protected Operation t1atlFeature;

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
	 * The cached value of the '{@link #getT1atlType() <em>T1atl Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlType()
	 * @generated
	 * @ordered
	 */
	protected OclType t1atlType;

	/**
	 * The cached value of the '{@link #getT2qvtrExpression() <em>T2qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t2qvtrExpression;

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
	 * The cached value of the '{@link #getWmapHelper_Context() <em>Wmap Helper Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapHelper_Context()
	 * @generated
	 * @ordered
	 */
	protected TmapHelper_Context wmapHelper_Context;

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
	protected TmapHelper_OperationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_HELPER_OPERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DmapHelper getDispatcher() {
		if (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER) return null;
		return (DmapHelper)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapHelper newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDispatcher(DmapHelper newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, trace_ATL2QVTrPackage.DMAP_HELPER__DOMAP_HELPER_OPERATION, DmapHelper.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER, newDispatcher, newDispatcher));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T0OPERATION_NAME, oldT0operationName, t0operationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclFeatureDefinition getT1atlDefinition() {
		if (t1atlDefinition != null && t1atlDefinition.eIsProxy()) {
			InternalEObject oldT1atlDefinition = (InternalEObject)t1atlDefinition;
			t1atlDefinition = (OclFeatureDefinition)eResolveProxy(oldT1atlDefinition);
			if (t1atlDefinition != oldT1atlDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_DEFINITION, oldT1atlDefinition, t1atlDefinition));
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
	public void setT1atlDefinition(OclFeatureDefinition newT1atlDefinition) {
		OclFeatureDefinition oldT1atlDefinition = t1atlDefinition;
		t1atlDefinition = newT1atlDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_DEFINITION, oldT1atlDefinition, t1atlDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getT1atlExpression() {
		if (t1atlExpression != null && t1atlExpression.eIsProxy()) {
			InternalEObject oldT1atlExpression = (InternalEObject)t1atlExpression;
			t1atlExpression = (OclExpression)eResolveProxy(oldT1atlExpression);
			if (t1atlExpression != oldT1atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_EXPRESSION, oldT1atlExpression, t1atlExpression));
			}
		}
		return t1atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT1atlExpression() {
		return t1atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT1atlExpression(OclExpression newT1atlExpression) {
		OclExpression oldT1atlExpression = t1atlExpression;
		t1atlExpression = newT1atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_EXPRESSION, oldT1atlExpression, t1atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation getT1atlFeature() {
		if (t1atlFeature != null && t1atlFeature.eIsProxy()) {
			InternalEObject oldT1atlFeature = (InternalEObject)t1atlFeature;
			t1atlFeature = (Operation)eResolveProxy(oldT1atlFeature);
			if (t1atlFeature != oldT1atlFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_FEATURE, oldT1atlFeature, t1atlFeature));
			}
		}
		return t1atlFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetT1atlFeature() {
		return t1atlFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT1atlFeature(Operation newT1atlFeature) {
		Operation oldT1atlFeature = t1atlFeature;
		t1atlFeature = newT1atlFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_FEATURE, oldT1atlFeature, t1atlFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module getT1atlModule() {
		if (t1atlModule != null && t1atlModule.eIsProxy()) {
			InternalEObject oldT1atlModule = (InternalEObject)t1atlModule;
			t1atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldT1atlModule);
			if (t1atlModule != oldT1atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_MODULE, oldT1atlModule, t1atlModule));
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
	public void setT1atlModule(org.eclipse.m2m.atl.common.ATL.Module newT1atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldT1atlModule = t1atlModule;
		t1atlModule = newT1atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_MODULE, oldT1atlModule, t1atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclType getT1atlType() {
		if (t1atlType != null && t1atlType.eIsProxy()) {
			InternalEObject oldT1atlType = (InternalEObject)t1atlType;
			t1atlType = (OclType)eResolveProxy(oldT1atlType);
			if (t1atlType != oldT1atlType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_TYPE, oldT1atlType, t1atlType));
			}
		}
		return t1atlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclType basicGetT1atlType() {
		return t1atlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT1atlType(OclType newT1atlType) {
		OclType oldT1atlType = t1atlType;
		t1atlType = newT1atlType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_TYPE, oldT1atlType, t1atlType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getT2qvtrExpression() {
		if (t2qvtrExpression != null && t2qvtrExpression.eIsProxy()) {
			InternalEObject oldT2qvtrExpression = (InternalEObject)t2qvtrExpression;
			t2qvtrExpression = (OCLExpression)eResolveProxy(oldT2qvtrExpression);
			if (t2qvtrExpression != oldT2qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_EXPRESSION, oldT2qvtrExpression, t2qvtrExpression));
			}
		}
		return t2qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT2qvtrExpression() {
		return t2qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setT2qvtrExpression(OCLExpression newT2qvtrExpression) {
		OCLExpression oldT2qvtrExpression = t2qvtrExpression;
		t2qvtrExpression = newT2qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_EXPRESSION, oldT2qvtrExpression, t2qvtrExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION, oldT2qvtrTransformation, t2qvtrTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapHelper_Context getWmapHelper_Context() {
		if (wmapHelper_Context != null && wmapHelper_Context.eIsProxy()) {
			InternalEObject oldWmapHelper_Context = (InternalEObject)wmapHelper_Context;
			wmapHelper_Context = (TmapHelper_Context)eResolveProxy(oldWmapHelper_Context);
			if (wmapHelper_Context != oldWmapHelper_Context) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT, oldWmapHelper_Context, wmapHelper_Context));
			}
		}
		return wmapHelper_Context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapHelper_Context basicGetWmapHelper_Context() {
		return wmapHelper_Context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWmapHelper_Context(TmapHelper_Context newWmapHelper_Context) {
		TmapHelper_Context oldWmapHelper_Context = wmapHelper_Context;
		wmapHelper_Context = newWmapHelper_Context;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT, oldWmapHelper_Context, wmapHelper_Context));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_MODULE, oldWmapModule, wmapModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_MODULE, oldWmapModule, wmapModule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDispatcher((DmapHelper)otherEnd, msgs);
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
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER:
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
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER:
				return eInternalContainer().eInverseRemove(this, trace_ATL2QVTrPackage.DMAP_HELPER__DOMAP_HELPER_OPERATION, DmapHelper.class, msgs);
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
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER:
				return getDispatcher();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T0OPERATION_NAME:
				return getT0operationName();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_DEFINITION:
				if (resolve) return getT1atlDefinition();
				return basicGetT1atlDefinition();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_EXPRESSION:
				if (resolve) return getT1atlExpression();
				return basicGetT1atlExpression();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_FEATURE:
				if (resolve) return getT1atlFeature();
				return basicGetT1atlFeature();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_MODULE:
				if (resolve) return getT1atlModule();
				return basicGetT1atlModule();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_TYPE:
				if (resolve) return getT1atlType();
				return basicGetT1atlType();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_EXPRESSION:
				if (resolve) return getT2qvtrExpression();
				return basicGetT2qvtrExpression();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION:
				if (resolve) return getT2qvtrTransformation();
				return basicGetT2qvtrTransformation();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT:
				if (resolve) return getWmapHelper_Context();
				return basicGetWmapHelper_Context();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_MODULE:
				if (resolve) return getWmapModule();
				return basicGetWmapModule();
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION:
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
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER:
				setDispatcher((DmapHelper)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T0OPERATION_NAME:
				setT0operationName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_DEFINITION:
				setT1atlDefinition((OclFeatureDefinition)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_EXPRESSION:
				setT1atlExpression((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_FEATURE:
				setT1atlFeature((Operation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_MODULE:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_TYPE:
				setT1atlType((OclType)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_EXPRESSION:
				setT2qvtrExpression((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT:
				setWmapHelper_Context((TmapHelper_Context)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_MODULE:
				setWmapModule((TmapModule)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION:
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
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER:
				setDispatcher((DmapHelper)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T0OPERATION_NAME:
				setT0operationName(T0OPERATION_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_DEFINITION:
				setT1atlDefinition((OclFeatureDefinition)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_EXPRESSION:
				setT1atlExpression((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_FEATURE:
				setT1atlFeature((Operation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_MODULE:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_TYPE:
				setT1atlType((OclType)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_EXPRESSION:
				setT2qvtrExpression((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION:
				setT2qvtrTransformation((RelationalTransformation)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT:
				setWmapHelper_Context((TmapHelper_Context)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_MODULE:
				setWmapModule((TmapModule)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION:
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
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__DISPATCHER:
				return getDispatcher() != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T0OPERATION_NAME:
				return T0OPERATION_NAME_EDEFAULT == null ? t0operationName != null : !T0OPERATION_NAME_EDEFAULT.equals(t0operationName);
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_DEFINITION:
				return t1atlDefinition != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_EXPRESSION:
				return t1atlExpression != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_FEATURE:
				return t1atlFeature != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_MODULE:
				return t1atlModule != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T1ATL_TYPE:
				return t1atlType != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_EXPRESSION:
				return t2qvtrExpression != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__T2QVTR_TRANSFORMATION:
				return t2qvtrTransformation != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_HELPER_CONTEXT:
				return wmapHelper_Context != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_MODULE:
				return wmapModule != null;
			case trace_ATL2QVTrPackage.TMAP_HELPER_OPERATION__WMAP_OCL_EXPRESSION:
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

} //TmapHelper_OperationImpl
