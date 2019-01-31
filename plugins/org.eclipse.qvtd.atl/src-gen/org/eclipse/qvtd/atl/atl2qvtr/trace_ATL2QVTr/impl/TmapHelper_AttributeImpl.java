/**
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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

import org.eclipse.m2m.atl.common.OCL.Attribute;
import org.eclipse.m2m.atl.common.OCL.OclExpression;
import org.eclipse.m2m.atl.common.OCL.OclFeatureDefinition;
import org.eclipse.m2m.atl.common.OCL.OclType;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapHelper;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Attribute;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapHelper_Context;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapModule;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvtrelation.RelationalTransformation;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Helper Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getT0attributeName <em>T0attribute Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getT1atlDefinition <em>T1atl Definition</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getT1atlExpression <em>T1atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getT1atlFeature <em>T1atl Feature</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getT1atlModule <em>T1atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getT1atlType <em>T1atl Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getT2qvtrExpression <em>T2qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getT2qvtrTransformation <em>T2qvtr Transformation</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getWmapHelper_Context <em>Wmap Helper Context</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getWmapModule <em>Wmap Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapHelper_AttributeImpl#getLocalSuccess <em>Local Success</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapHelper_AttributeImpl extends ImapHelperImpl implements TmapHelper_Attribute {
	/**
	 * The number of structural features of the '<em>Tmap Helper Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_HELPER_ATTRIBUTE_FEATURE_COUNT = ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 13;

	/**
	 * The number of operations of the '<em>Tmap Helper Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_HELPER_ATTRIBUTE_OPERATION_COUNT = ImapHelperImpl.IMAP_HELPER_OPERATION_COUNT + 0;


	/**
	 * The default value of the '{@link #getT0attributeName() <em>T0attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0attributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0attributeName() <em>T0attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0attributeName()
	 * @generated
	 * @ordered
	 */
	protected String t0attributeName = T0ATTRIBUTE_NAME_EDEFAULT;

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
	protected Attribute t1atlFeature;

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
	 * The default value of the '{@link #getLocalSuccess() <em>Local Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalSuccess()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean LOCAL_SUCCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocalSuccess() <em>Local Success</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalSuccess()
	 * @generated
	 * @ordered
	 */
	protected Boolean localSuccess = LOCAL_SUCCESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapHelper_AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_HELPER_ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapHelper getDispatcher() {
		if (eContainerFeatureID() != (ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0)) return null;
		return (DmapHelper)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapHelper newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapHelper newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != (ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0) && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, DmapHelper.class, msgs);
			msgs = basicSetDispatcher(newDispatcher, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0, newDispatcher, newDispatcher));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getT0attributeName() {
		return t0attributeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0attributeName(String newT0attributeName) {
		String oldT0attributeName = t0attributeName;
		t0attributeName = newT0attributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 1, oldT0attributeName, t0attributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclFeatureDefinition getT1atlDefinition() {
		if (t1atlDefinition != null && t1atlDefinition.eIsProxy()) {
			InternalEObject oldT1atlDefinition = t1atlDefinition;
			t1atlDefinition = (OclFeatureDefinition)eResolveProxy(oldT1atlDefinition);
			if (t1atlDefinition != oldT1atlDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 2, oldT1atlDefinition, t1atlDefinition));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 2, oldT1atlDefinition, t1atlDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT1atlExpression() {
		if (t1atlExpression != null && t1atlExpression.eIsProxy()) {
			InternalEObject oldT1atlExpression = t1atlExpression;
			t1atlExpression = (OclExpression)eResolveProxy(oldT1atlExpression);
			if (t1atlExpression != oldT1atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 3, oldT1atlExpression, t1atlExpression));
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
	@Override
	public void setT1atlExpression(OclExpression newT1atlExpression) {
		OclExpression oldT1atlExpression = t1atlExpression;
		t1atlExpression = newT1atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 3, oldT1atlExpression, t1atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Attribute getT1atlFeature() {
		if (t1atlFeature != null && t1atlFeature.eIsProxy()) {
			InternalEObject oldT1atlFeature = t1atlFeature;
			t1atlFeature = (Attribute)eResolveProxy(oldT1atlFeature);
			if (t1atlFeature != oldT1atlFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 4, oldT1atlFeature, t1atlFeature));
			}
		}
		return t1atlFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetT1atlFeature() {
		return t1atlFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlFeature(Attribute newT1atlFeature) {
		Attribute oldT1atlFeature = t1atlFeature;
		t1atlFeature = newT1atlFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 4, oldT1atlFeature, t1atlFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.m2m.atl.common.ATL.Module getT1atlModule() {
		if (t1atlModule != null && t1atlModule.eIsProxy()) {
			InternalEObject oldT1atlModule = t1atlModule;
			t1atlModule = (org.eclipse.m2m.atl.common.ATL.Module)eResolveProxy(oldT1atlModule);
			if (t1atlModule != oldT1atlModule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 5, oldT1atlModule, t1atlModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 5, oldT1atlModule, t1atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclType getT1atlType() {
		if (t1atlType != null && t1atlType.eIsProxy()) {
			InternalEObject oldT1atlType = t1atlType;
			t1atlType = (OclType)eResolveProxy(oldT1atlType);
			if (t1atlType != oldT1atlType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 6, oldT1atlType, t1atlType));
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
	@Override
	public void setT1atlType(OclType newT1atlType) {
		OclType oldT1atlType = t1atlType;
		t1atlType = newT1atlType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 6, oldT1atlType, t1atlType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT2qvtrExpression() {
		if (t2qvtrExpression != null && t2qvtrExpression.eIsProxy()) {
			InternalEObject oldT2qvtrExpression = (InternalEObject)t2qvtrExpression;
			t2qvtrExpression = (OCLExpression)eResolveProxy(oldT2qvtrExpression);
			if (t2qvtrExpression != oldT2qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 7, oldT2qvtrExpression, t2qvtrExpression));
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
	@Override
	public void setT2qvtrExpression(OCLExpression newT2qvtrExpression) {
		OCLExpression oldT2qvtrExpression = t2qvtrExpression;
		t2qvtrExpression = newT2qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 7, oldT2qvtrExpression, t2qvtrExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 8, oldT2qvtrTransformation, t2qvtrTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 8, oldT2qvtrTransformation, t2qvtrTransformation));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 9, oldWmapHelper_Context, wmapHelper_Context));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 9, oldWmapHelper_Context, wmapHelper_Context));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 10, oldWmapModule, wmapModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 10, oldWmapModule, wmapModule));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 11, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 11, oldWmapOclExpression, wmapOclExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getLocalSuccess() {
		return localSuccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocalSuccess(Boolean newLocalSuccess) {
		Boolean oldLocalSuccess = localSuccess;
		localSuccess = newLocalSuccess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 12, oldLocalSuccess, localSuccess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0:
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
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0:
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
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0:
				return eInternalContainer().eInverseRemove(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 2, DmapHelper.class, msgs);
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
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0:
				return getDispatcher();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 1:
				return getT0attributeName();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 2:
				if (resolve) return getT1atlDefinition();
				return basicGetT1atlDefinition();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 3:
				if (resolve) return getT1atlExpression();
				return basicGetT1atlExpression();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 4:
				if (resolve) return getT1atlFeature();
				return basicGetT1atlFeature();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 5:
				if (resolve) return getT1atlModule();
				return basicGetT1atlModule();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 6:
				if (resolve) return getT1atlType();
				return basicGetT1atlType();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 7:
				if (resolve) return getT2qvtrExpression();
				return basicGetT2qvtrExpression();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 8:
				if (resolve) return getT2qvtrTransformation();
				return basicGetT2qvtrTransformation();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 9:
				if (resolve) return getWmapHelper_Context();
				return basicGetWmapHelper_Context();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 10:
				if (resolve) return getWmapModule();
				return basicGetWmapModule();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 11:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 12:
				return getLocalSuccess();
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
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0:
				setDispatcher((DmapHelper)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 1:
				setT0attributeName((String)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 2:
				setT1atlDefinition((OclFeatureDefinition)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 3:
				setT1atlExpression((OclExpression)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 4:
				setT1atlFeature((Attribute)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 5:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 6:
				setT1atlType((OclType)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 7:
				setT2qvtrExpression((OCLExpression)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 8:
				setT2qvtrTransformation((RelationalTransformation)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 9:
				setWmapHelper_Context((TmapHelper_Context)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 10:
				setWmapModule((TmapModule)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 11:
				setWmapOclExpression((DmapOclExpression)newValue);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 12:
				setLocalSuccess((Boolean)newValue);
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
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0:
				setDispatcher((DmapHelper)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 1:
				setT0attributeName(T0ATTRIBUTE_NAME_EDEFAULT);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 2:
				setT1atlDefinition((OclFeatureDefinition)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 3:
				setT1atlExpression((OclExpression)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 4:
				setT1atlFeature((Attribute)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 5:
				setT1atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 6:
				setT1atlType((OclType)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 7:
				setT2qvtrExpression((OCLExpression)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 8:
				setT2qvtrTransformation((RelationalTransformation)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 9:
				setWmapHelper_Context((TmapHelper_Context)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 10:
				setWmapModule((TmapModule)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 11:
				setWmapOclExpression((DmapOclExpression)null);
				return;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 12:
				setLocalSuccess(LOCAL_SUCCESS_EDEFAULT);
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
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 0:
				return getDispatcher() != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 1:
				return T0ATTRIBUTE_NAME_EDEFAULT == null ? t0attributeName != null : !T0ATTRIBUTE_NAME_EDEFAULT.equals(t0attributeName);
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 2:
				return t1atlDefinition != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 3:
				return t1atlExpression != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 4:
				return t1atlFeature != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 5:
				return t1atlModule != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 6:
				return t1atlType != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 7:
				return t2qvtrExpression != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 8:
				return t2qvtrTransformation != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 9:
				return wmapHelper_Context != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 10:
				return wmapModule != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 11:
				return wmapOclExpression != null;
			case ImapHelperImpl.IMAP_HELPER_FEATURE_COUNT + 12:
				return LOCAL_SUCCESS_EDEFAULT == null ? localSuccess != null : !LOCAL_SUCCESS_EDEFAULT.equals(localSuccess);
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
		result.append(" (t0attributeName: ");
		result.append(t0attributeName);
		result.append(", localSuccess: ");
		result.append(localSuccess);
		result.append(')');
		return result.toString();
	}


} //TmapHelper_AttributeImpl
