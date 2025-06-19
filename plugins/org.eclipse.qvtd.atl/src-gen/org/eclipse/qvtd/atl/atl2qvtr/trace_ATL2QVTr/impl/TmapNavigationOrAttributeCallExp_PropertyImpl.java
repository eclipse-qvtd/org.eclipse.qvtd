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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.m2m.atl.common.OCL.Attribute;
import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapNavigationOrAttributeCallExp_Property;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.runtime.qvttrace.impl.DispatchImpl;
import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Navigation Or Attribute Call Exp Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getDispatcher <em>Dispatcher</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getT1propertyName <em>T1property Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getT3atlAttributes <em>T3atl Attributes</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getT3atlModule <em>T3atl Module</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getT3atlSource <em>T3atl Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getT4qvtrProperty <em>T4qvtr Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getT4qvtrSource <em>T4qvtr Source</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapNavigationOrAttributeCallExp_PropertyImpl#getS0local <em>S0local</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapNavigationOrAttributeCallExp_PropertyImpl extends ImapOclExpressionImpl implements TmapNavigationOrAttributeCallExp_Property {
	/**
	 * The number of structural features of the '<em>Tmap Navigation Or Attribute Call Exp Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY_FEATURE_COUNT = ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Tmap Navigation Or Attribute Call Exp Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY_OPERATION_COUNT = ImapOclExpressionImpl.IMAP_OCL_EXPRESSION_OPERATION_COUNT + 0;


	/**
	 * The default value of the '{@link #getT1propertyName() <em>T1property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1propertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String T1PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT1propertyName() <em>T1property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1propertyName()
	 * @generated
	 * @ordered
	 */
	protected String t1propertyName = T1PROPERTY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT3atlAttributes() <em>T3atl Attributes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> t3atlAttributes;

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
	 * The cached value of the '{@link #getT3atlSource() <em>T3atl Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlSource()
	 * @generated
	 * @ordered
	 */
	protected OclExpression t3atlSource;

	/**
	 * The cached value of the '{@link #getT4qvtrProperty() <em>T4qvtr Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrProperty()
	 * @generated
	 * @ordered
	 */
	protected Property t4qvtrProperty;

	/**
	 * The cached value of the '{@link #getT4qvtrSource() <em>T4qvtr Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrSource()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression t4qvtrSource;

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
	protected TmapNavigationOrAttributeCallExp_PropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_NAVIGATION_OR_ATTRIBUTE_CALL_EXP_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DmapOclExpression getDispatcher() {
		if (eContainerFeatureID() != (ExecutionImpl.EXECUTION_FEATURE_COUNT + 1)) return null;
		return (DmapOclExpression)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDispatcher(DmapOclExpression newDispatcher, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDispatcher, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDispatcher(DmapOclExpression newDispatcher) {
		if (newDispatcher != eInternalContainer() || (eContainerFeatureID() != (ExecutionImpl.EXECUTION_FEATURE_COUNT + 1) && newDispatcher != null)) {
			if (EcoreUtil.isAncestor(this, newDispatcher))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDispatcher != null)
				msgs = ((InternalEObject)newDispatcher).eInverseAdd(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 6, DmapOclExpression.class, msgs);
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
	public String getT1propertyName() {
		return t1propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1propertyName(String newT1propertyName) {
		String oldT1propertyName = t1propertyName;
		t1propertyName = newT1propertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT1propertyName, t1propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getT3atlAttributes() {
		if (t3atlAttributes == null) {
			t3atlAttributes = new EObjectResolvingEList<Attribute>(Attribute.class, this, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3);
		}
		return t3atlAttributes;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlModule, t3atlModule));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlModule, t3atlModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT3atlSource() {
		if (t3atlSource != null && t3atlSource.eIsProxy()) {
			InternalEObject oldT3atlSource = t3atlSource;
			t3atlSource = (OclExpression)eResolveProxy(oldT3atlSource);
			if (t3atlSource != oldT3atlSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT3atlSource, t3atlSource));
			}
		}
		return t3atlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetT3atlSource() {
		return t3atlSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlSource(OclExpression newT3atlSource) {
		OclExpression oldT3atlSource = t3atlSource;
		t3atlSource = newT3atlSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT3atlSource, t3atlSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getT4qvtrProperty() {
		if (t4qvtrProperty != null && t4qvtrProperty.eIsProxy()) {
			InternalEObject oldT4qvtrProperty = (InternalEObject)t4qvtrProperty;
			t4qvtrProperty = (Property)eResolveProxy(oldT4qvtrProperty);
			if (t4qvtrProperty != oldT4qvtrProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrProperty, t4qvtrProperty));
			}
		}
		return t4qvtrProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetT4qvtrProperty() {
		return t4qvtrProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrProperty(Property newT4qvtrProperty) {
		Property oldT4qvtrProperty = t4qvtrProperty;
		t4qvtrProperty = newT4qvtrProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrProperty, t4qvtrProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OCLExpression getT4qvtrSource() {
		if (t4qvtrSource != null && t4qvtrSource.eIsProxy()) {
			InternalEObject oldT4qvtrSource = (InternalEObject)t4qvtrSource;
			t4qvtrSource = (OCLExpression)eResolveProxy(oldT4qvtrSource);
			if (t4qvtrSource != oldT4qvtrSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrSource, t4qvtrSource));
			}
		}
		return t4qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetT4qvtrSource() {
		return t4qvtrSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrSource(OCLExpression newT4qvtrSource) {
		OCLExpression oldT4qvtrSource = t4qvtrSource;
		t4qvtrSource = newT4qvtrSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrSource, t4qvtrSource));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 8, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldS0local, s0local));
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
				return eInternalContainer().eInverseRemove(this, DispatchImpl.DISPATCH_FEATURE_COUNT + 6, DmapOclExpression.class, msgs);
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
				return getT1propertyName();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return getT3atlAttributes();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT3atlModule();
				return basicGetT3atlModule();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT3atlSource();
				return basicGetT3atlSource();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT4qvtrProperty();
				return basicGetT4qvtrProperty();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT4qvtrSource();
				return basicGetT4qvtrSource();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				return getS0local();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setDispatcher((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT1propertyName((String)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				getT3atlAttributes().clear();
				getT3atlAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlModule((org.eclipse.m2m.atl.common.ATL.Module)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT3atlSource((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrProperty((Property)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrSource((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapOclExpression((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
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
				setDispatcher((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT1propertyName(T1PROPERTY_NAME_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				getT3atlAttributes().clear();
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlModule((org.eclipse.m2m.atl.common.ATL.Module)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT3atlSource((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrProperty((Property)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrSource((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapOclExpression((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
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
				return T1PROPERTY_NAME_EDEFAULT == null ? t1propertyName != null : !T1PROPERTY_NAME_EDEFAULT.equals(t1propertyName);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t3atlAttributes != null && !t3atlAttributes.isEmpty();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t3atlModule != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t3atlSource != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t4qvtrProperty != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t4qvtrSource != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				return wmapOclExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
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
		result.append(" (t1propertyName: ");
		result.append(t1propertyName);
		result.append(", s0local: ");
		result.append(s0local);
		result.append(')');
		return result.toString();
	}


} //TmapNavigationOrAttributeCallExp_PropertyImpl
