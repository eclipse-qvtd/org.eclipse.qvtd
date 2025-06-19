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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.m2m.atl.common.ATL.Binding;
import org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.DmapOclExpression;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapBinding;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TmapSimpleOutPatternElement;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

import org.eclipse.qvtd.runtime.qvttrace.impl.ExecutionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tmap Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getS0global <em>S0global</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT1propertyName <em>T1property Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT3atlBinding <em>T3atl Binding</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT3atlExpression <em>T3atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT3atlOutPatternElement <em>T3atl Out Pattern Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT4qvtrExpression <em>T4qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT4qvtrPart <em>T4qvtr Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT4qvtrTemplate <em>T4qvtr Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getWmapSimpleOutPatternElement <em>Wmap Simple Out Pattern Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapBindingImpl extends ExecutionImpl implements TmapBinding {
	/**
	 * The number of structural features of the '<em>Tmap Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_BINDING_FEATURE_COUNT = ExecutionImpl.EXECUTION_FEATURE_COUNT + 10;

	/**
	 * The number of operations of the '<em>Tmap Binding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TMAP_BINDING_OPERATION_COUNT = ExecutionImpl.EXECUTION_OPERATION_COUNT + 0;


	/**
	 * The default value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean S0GLOBAL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getS0global() <em>S0global</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getS0global()
	 * @generated
	 * @ordered
	 */
	protected Boolean s0global = S0GLOBAL_EDEFAULT;

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
	 * The cached value of the '{@link #getT3atlBinding() <em>T3atl Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlBinding()
	 * @generated
	 * @ordered
	 */
	protected Binding t3atlBinding;

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
	 * The cached value of the '{@link #getT3atlOutPatternElement() <em>T3atl Out Pattern Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT3atlOutPatternElement()
	 * @generated
	 * @ordered
	 */
	protected SimpleOutPatternElement t3atlOutPatternElement;

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
	 * The cached value of the '{@link #getT4qvtrPart() <em>T4qvtr Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrPart()
	 * @generated
	 * @ordered
	 */
	protected PropertyTemplateItem t4qvtrPart;

	/**
	 * The cached value of the '{@link #getT4qvtrTemplate() <em>T4qvtr Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT4qvtrTemplate()
	 * @generated
	 * @ordered
	 */
	protected ObjectTemplateExp t4qvtrTemplate;

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
	 * The cached value of the '{@link #getWmapSimpleOutPatternElement() <em>Wmap Simple Out Pattern Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWmapSimpleOutPatternElement()
	 * @generated
	 * @ordered
	 */
	protected TmapSimpleOutPatternElement wmapSimpleOutPatternElement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TmapBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TMAP_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Boolean getS0global() {
		return s0global;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setS0global(Boolean newS0global) {
		Boolean oldS0global = s0global;
		s0global = newS0global;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 0, oldS0global, s0global));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 1, oldT1propertyName, t1propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Binding getT3atlBinding() {
		if (t3atlBinding != null && t3atlBinding.eIsProxy()) {
			InternalEObject oldT3atlBinding = t3atlBinding;
			t3atlBinding = (Binding)eResolveProxy(oldT3atlBinding);
			if (t3atlBinding != oldT3atlBinding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlBinding, t3atlBinding));
			}
		}
		return t3atlBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding basicGetT3atlBinding() {
		return t3atlBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlBinding(Binding newT3atlBinding) {
		Binding oldT3atlBinding = t3atlBinding;
		t3atlBinding = newT3atlBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 2, oldT3atlBinding, t3atlBinding));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlExpression, t3atlExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 3, oldT3atlExpression, t3atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleOutPatternElement getT3atlOutPatternElement() {
		if (t3atlOutPatternElement != null && t3atlOutPatternElement.eIsProxy()) {
			InternalEObject oldT3atlOutPatternElement = t3atlOutPatternElement;
			t3atlOutPatternElement = (SimpleOutPatternElement)eResolveProxy(oldT3atlOutPatternElement);
			if (t3atlOutPatternElement != oldT3atlOutPatternElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlOutPatternElement, t3atlOutPatternElement));
			}
		}
		return t3atlOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleOutPatternElement basicGetT3atlOutPatternElement() {
		return t3atlOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT3atlOutPatternElement(SimpleOutPatternElement newT3atlOutPatternElement) {
		SimpleOutPatternElement oldT3atlOutPatternElement = t3atlOutPatternElement;
		t3atlOutPatternElement = newT3atlOutPatternElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 4, oldT3atlOutPatternElement, t3atlOutPatternElement));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4qvtrExpression, t4qvtrExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 5, oldT4qvtrExpression, t4qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyTemplateItem getT4qvtrPart() {
		if (t4qvtrPart != null && t4qvtrPart.eIsProxy()) {
			InternalEObject oldT4qvtrPart = (InternalEObject)t4qvtrPart;
			t4qvtrPart = (PropertyTemplateItem)eResolveProxy(oldT4qvtrPart);
			if (t4qvtrPart != oldT4qvtrPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrPart, t4qvtrPart));
			}
		}
		return t4qvtrPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTemplateItem basicGetT4qvtrPart() {
		return t4qvtrPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrPart(PropertyTemplateItem newT4qvtrPart) {
		PropertyTemplateItem oldT4qvtrPart = t4qvtrPart;
		t4qvtrPart = newT4qvtrPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 6, oldT4qvtrPart, t4qvtrPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectTemplateExp getT4qvtrTemplate() {
		if (t4qvtrTemplate != null && t4qvtrTemplate.eIsProxy()) {
			InternalEObject oldT4qvtrTemplate = (InternalEObject)t4qvtrTemplate;
			t4qvtrTemplate = (ObjectTemplateExp)eResolveProxy(oldT4qvtrTemplate);
			if (t4qvtrTemplate != oldT4qvtrTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrTemplate, t4qvtrTemplate));
			}
		}
		return t4qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp basicGetT4qvtrTemplate() {
		return t4qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT4qvtrTemplate(ObjectTemplateExp newT4qvtrTemplate) {
		ObjectTemplateExp oldT4qvtrTemplate = t4qvtrTemplate;
		t4qvtrTemplate = newT4qvtrTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 7, oldT4qvtrTemplate, t4qvtrTemplate));
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
	public TmapSimpleOutPatternElement getWmapSimpleOutPatternElement() {
		if (wmapSimpleOutPatternElement != null && wmapSimpleOutPatternElement.eIsProxy()) {
			InternalEObject oldWmapSimpleOutPatternElement = (InternalEObject)wmapSimpleOutPatternElement;
			wmapSimpleOutPatternElement = (TmapSimpleOutPatternElement)eResolveProxy(oldWmapSimpleOutPatternElement);
			if (wmapSimpleOutPatternElement != oldWmapSimpleOutPatternElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldWmapSimpleOutPatternElement, wmapSimpleOutPatternElement));
			}
		}
		return wmapSimpleOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TmapSimpleOutPatternElement basicGetWmapSimpleOutPatternElement() {
		return wmapSimpleOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWmapSimpleOutPatternElement(TmapSimpleOutPatternElement newWmapSimpleOutPatternElement) {
		TmapSimpleOutPatternElement oldWmapSimpleOutPatternElement = wmapSimpleOutPatternElement;
		wmapSimpleOutPatternElement = newWmapSimpleOutPatternElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExecutionImpl.EXECUTION_FEATURE_COUNT + 9, oldWmapSimpleOutPatternElement, wmapSimpleOutPatternElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return getS0global();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return getT1propertyName();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				if (resolve) return getT3atlBinding();
				return basicGetT3atlBinding();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				if (resolve) return getT3atlExpression();
				return basicGetT3atlExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				if (resolve) return getT3atlOutPatternElement();
				return basicGetT3atlOutPatternElement();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				if (resolve) return getT4qvtrExpression();
				return basicGetT4qvtrExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				if (resolve) return getT4qvtrPart();
				return basicGetT4qvtrPart();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				if (resolve) return getT4qvtrTemplate();
				return basicGetT4qvtrTemplate();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				if (resolve) return getWmapSimpleOutPatternElement();
				return basicGetWmapSimpleOutPatternElement();
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setS0global((Boolean)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1propertyName((String)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlBinding((Binding)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlExpression((OclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlOutPatternElement((SimpleOutPatternElement)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4qvtrExpression((OCLExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrPart((PropertyTemplateItem)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrTemplate((ObjectTemplateExp)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapOclExpression((DmapOclExpression)newValue);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setWmapSimpleOutPatternElement((TmapSimpleOutPatternElement)newValue);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				setS0global(S0GLOBAL_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				setT1propertyName(T1PROPERTY_NAME_EDEFAULT);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				setT3atlBinding((Binding)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				setT3atlExpression((OclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				setT3atlOutPatternElement((SimpleOutPatternElement)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				setT4qvtrExpression((OCLExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				setT4qvtrPart((PropertyTemplateItem)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				setT4qvtrTemplate((ObjectTemplateExp)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				setWmapOclExpression((DmapOclExpression)null);
				return;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				setWmapSimpleOutPatternElement((TmapSimpleOutPatternElement)null);
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
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 0:
				return S0GLOBAL_EDEFAULT == null ? s0global != null : !S0GLOBAL_EDEFAULT.equals(s0global);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 1:
				return T1PROPERTY_NAME_EDEFAULT == null ? t1propertyName != null : !T1PROPERTY_NAME_EDEFAULT.equals(t1propertyName);
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 2:
				return t3atlBinding != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 3:
				return t3atlExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 4:
				return t3atlOutPatternElement != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 5:
				return t4qvtrExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 6:
				return t4qvtrPart != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 7:
				return t4qvtrTemplate != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 8:
				return wmapOclExpression != null;
			case ExecutionImpl.EXECUTION_FEATURE_COUNT + 9:
				return wmapSimpleOutPatternElement != null;
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
		result.append(" (s0global: ");
		result.append(s0global);
		result.append(", t1propertyName: ");
		result.append(t1propertyName);
		result.append(')');
		return result.toString();
	}


} //TmapBindingImpl
