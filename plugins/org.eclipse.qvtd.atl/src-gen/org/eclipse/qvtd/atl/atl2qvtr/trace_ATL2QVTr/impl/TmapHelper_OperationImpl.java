/**
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
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

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;
import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Helper Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT1operationName <em>T1operation Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT3atlDefinition <em>T3atl Definition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT3atlExpression <em>T3atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT3atlFeature <em>T3atl Feature</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT3atlModule <em>T3atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT3atlType <em>T3atl Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT4qvtrExpression <em>T4qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getT4qvtrTransformation <em>T4qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getWmapHelper_Context <em>Wmap Helper Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getWmapModule <em>Wmap Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_OperationImpl#getS0local <em>S0local</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapHelper_OperationImpl extends ImapHelperImpl implements TmapHelper_Operation {
	/**
	 * The number of structural features of the '<em>Tmap Helper Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_HELPER_OPERATION_FEATURE_COUNT = ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 13;

	/**
	 * The number of operations of the '<em>Tmap Helper Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_HELPER_OPERATION_OPERATION_COUNT = ImapHelperImpl.IMAP_HELPER_OPERATION_COUNT + 0;


	/**
	 * The default value of the '{@link #getT1operationName() <em>T1operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1operationName()
	 * @generated
	 * @ordered
	 */
	protected static final String T1OPERATION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT1operationName() <em>T1operation Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1operationName()
	 * @generated
	 * @ordered
	 */
	protected String t1operationName = T1OPERATION_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT3atlDefinition() <em>T3atl Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlDefinition()
	 * @generated
	 * @ordered
	 */
	protected OclFeatureDefinition t3atlDefinition;

	/**
	 * The cached value of the '{@link #getT3atlExpression() <em>T3atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t3atlExpression;

	/**
	 * The cached value of the '{@link #getT3atlFeature() <em>T3atl Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlFeature()
	 * @generated
	 * @ordered
	 */
	protected Operation t3atlFeature;

	/**
	 * The cached value of the '{@link #getT3atlModule() <em>T3atl Module</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlModule()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.m2m.atl.common.ATL.Module t3atlModule;

	/**
	 * The cached value of the '{@link #getT3atlType() <em>T3atl Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlType()
	 * @generated
	 * @ordered
	 */
	protected OclType t3atlType;

	/**
	 * The cached value of the '{@link #getT4qvtrExpression() <em>T4qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t4qvtrExpression;

	/**
	 * The cached value of the '{@link #getT4qvtrTransformation() <em>T4qvtr Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrTransformation()
	 * @generated
	 * @ordered
	 */
	protected RelationalTransformation t4qvtrTransformation;

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
	 * The default value of the '{@link #getS0local() <em>S0local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0local()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean S0LOCAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getS0local() <em>S0local</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0local()
	 * @generated
	 * @ordered
	 */
	protected Boolean s0local = S0LOCAL_EDEFAULT;

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
	@Override
	public DmapHelper getDispatcher() {
		if (eContainerFeatureID() != (ExecutionImpl.EXECUTION_FEATURE_COUNT + 1)) return null;
		return (DmapHelper)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapHelper newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapHelper newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != (ExecutionImpl.EXECUTION_FEATURE_COUNT + 1) && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, DmapHelper.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT1operationName() {
		return t1operationName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1operationName(String newT1operationName) {
		String oldT1operationName = t1operationName;
		t1operationName = newT1operationName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT1operationName, t1operationName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclFeatureDefinition getT3atlDefinition() {
		if (t3atlDefinition != null && t3atlDefinition.eIsProxy()) {
			InternalEObject oldT3atlDefinition = t3atlDefinition;
			t3atlDefinition = (OclFeatureDefinition)eResolveProxy(oldT3atlDefinition);
			if (t3atlDefinition != oldT3atlDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlDefinition, t3atlDefinition));
			}
		}
		return t3atlDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclFeatureDefinition basicGetT3atlDefinition() {
		return t3atlDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlDefinition(OclFeatureDefinition newT3atlDefinition) {
		OclFeatureDefinition oldT3atlDefinition = t3atlDefinition;
		t3atlDefinition = newT3atlDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlDefinition, t3atlDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT3atlExpression() {
		if (t3atlExpression != null && t3atlExpression.eIsProxy()) {
			InternalEObject oldT3atlExpression = t3atlExpression;
			t3atlExpression = (OclExpression)eResolveProxy(oldT3atlExpression);
			if (t3atlExpression != oldT3atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlExpression, t3atlExpression));
			}
		}
		return t3atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT3atlExpression() {
		return t3atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlExpression(OclExpression newT3atlExpression) {
		OclExpression oldT3atlExpression = t3atlExpression;
		t3atlExpression = newT3atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlExpression, t3atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation getT3atlFeature() {
		if (t3atlFeature != null && t3atlFeature.eIsProxy()) {
			InternalEObject oldT3atlFeature = t3atlFeature;
			t3atlFeature = (Operation)eResolveProxy(oldT3atlFeature);
			if (t3atlFeature != oldT3atlFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT3atlFeature, t3atlFeature));
			}
		}
		return t3atlFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operation basicGetT3atlFeature() {
		return t3atlFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlFeature(Operation newT3atlFeature) {
		Operation oldT3atlFeature = t3atlFeature;
		t3atlFeature = newT3atlFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT3atlFeature, t3atlFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getT3atlModule() {
		if (t3atlModule != null && t3atlModule.eIsProxy()) {
			InternalEObject oldT3atlModule = t3atlModule;
			t3atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldT3atlModule);
			if (t3atlModule != oldT3atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT3atlModule, t3atlModule));
			}
		}
		return t3atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public org.eclipse.m2m.atl.common.ATL.Module basicGetT3atlModule() {
		return t3atlModule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlModule(org.eclipse.m2m.atl.common.ATL.Module newT3atlModule) {
		org.eclipse.m2m.atl.common.ATL.Module oldT3atlModule = t3atlModule;
		t3atlModule = newT3atlModule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT3atlModule, t3atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclType getT3atlType() {
		if (t3atlType != null && t3atlType.eIsProxy()) {
			InternalEObject oldT3atlType = t3atlType;
			t3atlType = (OclType)eResolveProxy(oldT3atlType);
			if (t3atlType != oldT3atlType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT3atlType, t3atlType));
			}
		}
		return t3atlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclType basicGetT3atlType() {
		return t3atlType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlType(OclType newT3atlType) {
		OclType oldT3atlType = t3atlType;
		t3atlType = newT3atlType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT3atlType, t3atlType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT4qvtrExpression() {
		if (t4qvtrExpression != null && t4qvtrExpression.eIsProxy()) {
			InternalEObject oldT4qvtrExpression = (InternalEObject)t4qvtrExpression;
			t4qvtrExpression = (OCLExpression)eResolveProxy(oldT4qvtrExpression);
			if (t4qvtrExpression != oldT4qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldT4qvtrExpression, t4qvtrExpression));
			}
		}
		return t4qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT4qvtrExpression() {
		return t4qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrExpression(OCLExpression newT4qvtrExpression) {
		OCLExpression oldT4qvtrExpression = t4qvtrExpression;
		t4qvtrExpression = newT4qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldT4qvtrExpression, t4qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationalTransformation getT4qvtrTransformation() {
		if (t4qvtrTransformation != null && t4qvtrTransformation.eIsProxy()) {
			InternalEObject oldT4qvtrTransformation = (InternalEObject)t4qvtrTransformation;
			t4qvtrTransformation = (RelationalTransformation)eResolveProxy(oldT4qvtrTransformation);
			if (t4qvtrTransformation != oldT4qvtrTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldT4qvtrTransformation, t4qvtrTransformation));
			}
		}
		return t4qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalTransformation basicGetT4qvtrTransformation() {
		return t4qvtrTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrTransformation(RelationalTransformation newT4qvtrTransformation) {
		RelationalTransformation oldT4qvtrTransformation = t4qvtrTransformation;
		t4qvtrTransformation = newT4qvtrTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldT4qvtrTransformation, t4qvtrTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TmapHelper_Context getWmapHelper_Context() {
		if (wmapHelper_Context != null && wmapHelper_Context.eIsProxy()) {
			InternalEObject oldWmapHelper_Context = (InternalEObject)wmapHelper_Context;
			wmapHelper_Context = (TmapHelper_Context)eResolveProxy(oldWmapHelper_Context);
			if (wmapHelper_Context != oldWmapHelper_Context) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapHelper_Context, wmapHelper_Context));
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
	@Override
	public void setWmapHelper_Context(TmapHelper_Context newWmapHelper_Context) {
		TmapHelper_Context oldWmapHelper_Context = wmapHelper_Context;
		wmapHelper_Context = newWmapHelper_Context;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 10, oldWmapHelper_Context, wmapHelper_Context));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11, oldWmapModule, wmapModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 11, oldWmapModule, wmapModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getWmapOclExpression() {
		if (wmapOclExpression != null && wmapOclExpression.eIsProxy()) {
			InternalEObject oldWmapOclExpression = (InternalEObject)wmapOclExpression;
			wmapOclExpression = (DmapOclExpression)eResolveProxy(oldWmapOclExpression);
			if (wmapOclExpression != oldWmapOclExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12, oldWmapOclExpression, wmapOclExpression));
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
	@Override
	public void setWmapOclExpression(DmapOclExpression newWmapOclExpression) {
		DmapOclExpression oldWmapOclExpression = wmapOclExpression;
		wmapOclExpression = newWmapOclExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 12, oldWmapOclExpression, wmapOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getS0local() {
		return s0local;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS0local(Boolean newS0local) {
		Boolean oldS0local = s0local;
		s0local = newS0local;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 13, oldS0local, s0local));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 3, DmapHelper.class, msgs);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return getDispatcher();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return getT1operationName();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT3atlDefinition();
				return basicGetT3atlDefinition();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT3atlExpression();
				return basicGetT3atlExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT3atlFeature();
				return basicGetT3atlFeature();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT3atlModule();
				return basicGetT3atlModule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT3atlType();
				return basicGetT3atlType();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				if (resolve) return getT4qvtrExpression();
				return basicGetT4qvtrExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				if (resolve) return getT4qvtrTransformation();
				return basicGetT4qvtrTransformation();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				if (resolve) return getWmapHelper_Context();
				return basicGetWmapHelper_Context();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				if (resolve) return getWmapModule();
				return basicGetWmapModule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 12:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 13:
				return getS0local();
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setDispatcher((DmapHelper)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT1operationName((String)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlDefinition((OclFeatureDefinition)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlExpression((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT3atlFeature((Operation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT3atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT3atlType((OclType)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setT4qvtrExpression((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setT4qvtrTransformation((RelationalTransformation)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapHelper_Context((TmapHelper_Context)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				setWmapModule((TmapModule)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 12:
				setWmapOclExpression((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 13:
				setS0local((Boolean)newValue);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setDispatcher((DmapHelper)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT1operationName(T1OPERATION_NAME_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlDefinition((OclFeatureDefinition)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlExpression((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT3atlFeature((Operation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT3atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT3atlType((OclType)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setT4qvtrExpression((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setT4qvtrTransformation((RelationalTransformation)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				setWmapHelper_Context((TmapHelper_Context)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				setWmapModule((TmapModule)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 12:
				setWmapOclExpression((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 13:
				setS0local(S0LOCAL_EDEFAULT);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return getDispatcher() != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return T1OPERATION_NAME_EDEFAULT == null ? t1operationName != null : !T1OPERATION_NAME_EDEFAULT.equals(t1operationName);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t3atlDefinition != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t3atlExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t3atlFeature != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t3atlModule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t3atlType != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				return t4qvtrExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				return t4qvtrTransformation != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 10:
				return wmapHelper_Context != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 11:
				return wmapModule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 12:
				return wmapOclExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 13:
				return S0LOCAL_EDEFAULT == null ? s0local != null : !S0LOCAL_EDEFAULT.equals(s0local);
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
		result.append(" (t1operationName: ");
		result.append(t1operationName);
		result.append(", s0local: ");
		result.append(s0local);
		result.append(')');
		return result.toString();
	}


} //TmapHelper_OperationImpl
