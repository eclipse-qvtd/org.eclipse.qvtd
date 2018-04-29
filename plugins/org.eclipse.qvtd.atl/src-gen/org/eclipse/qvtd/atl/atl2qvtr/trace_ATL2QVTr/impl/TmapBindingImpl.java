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
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT0propertyName <em>T0property Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT1atlBinding <em>T1atl Binding</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT1atlExpression <em>T1atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT1atlOutPatternElement <em>T1atl Out Pattern Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT2qvtrExpression <em>T2qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT2qvtrPart <em>T2qvtr Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getT2qvtrTemplate <em>T2qvtr Template</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getWmapOclExpression <em>Wmap Ocl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TmapBindingImpl#getWmapSimpleOutPatternElement <em>Wmap Simple Out Pattern Element</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TmapBindingImpl extends ExecutionImpl implements TmapBinding {
	/**
	 * The default value of the '{@link #getT0propertyName() <em>T0property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0propertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String T0PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getT0propertyName() <em>T0property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT0propertyName()
	 * @generated
	 * @ordered
	 */
	protected String t0propertyName = T0PROPERTY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getT1atlBinding() <em>T1atl Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlBinding()
	 * @generated
	 * @ordered
	 */
	protected Binding t1atlBinding;

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
	 * The cached value of the '{@link #getT1atlOutPatternElement() <em>T1atl Out Pattern Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT1atlOutPatternElement()
	 * @generated
	 * @ordered
	 */
	protected SimpleOutPatternElement t1atlOutPatternElement;

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
	 * The cached value of the '{@link #getT2qvtrPart() <em>T2qvtr Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrPart()
	 * @generated
	 * @ordered
	 */
	protected PropertyTemplateItem t2qvtrPart;

	/**
	 * The cached value of the '{@link #getT2qvtrTemplate() <em>T2qvtr Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getT2qvtrTemplate()
	 * @generated
	 * @ordered
	 */
	protected ObjectTemplateExp t2qvtrTemplate;

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
	public String getT0propertyName() {
		return t0propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT0propertyName(String newT0propertyName) {
		String oldT0propertyName = t0propertyName;
		t0propertyName = newT0propertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_BINDING__T0PROPERTY_NAME, oldT0propertyName, t0propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Binding getT1atlBinding() {
		if (t1atlBinding != null && t1atlBinding.eIsProxy()) {
			InternalEObject oldT1atlBinding = (InternalEObject)t1atlBinding;
			t1atlBinding = (Binding)eResolveProxy(oldT1atlBinding);
			if (t1atlBinding != oldT1atlBinding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_BINDING, oldT1atlBinding, t1atlBinding));
			}
		}
		return t1atlBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding basicGetT1atlBinding() {
		return t1atlBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlBinding(Binding newT1atlBinding) {
		Binding oldT1atlBinding = t1atlBinding;
		t1atlBinding = newT1atlBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_BINDING, oldT1atlBinding, t1atlBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclExpression getT1atlExpression() {
		if (t1atlExpression != null && t1atlExpression.eIsProxy()) {
			InternalEObject oldT1atlExpression = (InternalEObject)t1atlExpression;
			t1atlExpression = (OclExpression)eResolveProxy(oldT1atlExpression);
			if (t1atlExpression != oldT1atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_EXPRESSION, oldT1atlExpression, t1atlExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_EXPRESSION, oldT1atlExpression, t1atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SimpleOutPatternElement getT1atlOutPatternElement() {
		if (t1atlOutPatternElement != null && t1atlOutPatternElement.eIsProxy()) {
			InternalEObject oldT1atlOutPatternElement = (InternalEObject)t1atlOutPatternElement;
			t1atlOutPatternElement = (SimpleOutPatternElement)eResolveProxy(oldT1atlOutPatternElement);
			if (t1atlOutPatternElement != oldT1atlOutPatternElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_OUT_PATTERN_ELEMENT, oldT1atlOutPatternElement, t1atlOutPatternElement));
			}
		}
		return t1atlOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleOutPatternElement basicGetT1atlOutPatternElement() {
		return t1atlOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT1atlOutPatternElement(SimpleOutPatternElement newT1atlOutPatternElement) {
		SimpleOutPatternElement oldT1atlOutPatternElement = t1atlOutPatternElement;
		t1atlOutPatternElement = newT1atlOutPatternElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_OUT_PATTERN_ELEMENT, oldT1atlOutPatternElement, t1atlOutPatternElement));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_EXPRESSION, oldT2qvtrExpression, t2qvtrExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_EXPRESSION, oldT2qvtrExpression, t2qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyTemplateItem getT2qvtrPart() {
		if (t2qvtrPart != null && t2qvtrPart.eIsProxy()) {
			InternalEObject oldT2qvtrPart = (InternalEObject)t2qvtrPart;
			t2qvtrPart = (PropertyTemplateItem)eResolveProxy(oldT2qvtrPart);
			if (t2qvtrPart != oldT2qvtrPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_PART, oldT2qvtrPart, t2qvtrPart));
			}
		}
		return t2qvtrPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTemplateItem basicGetT2qvtrPart() {
		return t2qvtrPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrPart(PropertyTemplateItem newT2qvtrPart) {
		PropertyTemplateItem oldT2qvtrPart = t2qvtrPart;
		t2qvtrPart = newT2qvtrPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_PART, oldT2qvtrPart, t2qvtrPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ObjectTemplateExp getT2qvtrTemplate() {
		if (t2qvtrTemplate != null && t2qvtrTemplate.eIsProxy()) {
			InternalEObject oldT2qvtrTemplate = (InternalEObject)t2qvtrTemplate;
			t2qvtrTemplate = (ObjectTemplateExp)eResolveProxy(oldT2qvtrTemplate);
			if (t2qvtrTemplate != oldT2qvtrTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_TEMPLATE, oldT2qvtrTemplate, t2qvtrTemplate));
			}
		}
		return t2qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp basicGetT2qvtrTemplate() {
		return t2qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setT2qvtrTemplate(ObjectTemplateExp newT2qvtrTemplate) {
		ObjectTemplateExp oldT2qvtrTemplate = t2qvtrTemplate;
		t2qvtrTemplate = newT2qvtrTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_TEMPLATE, oldT2qvtrTemplate, t2qvtrTemplate));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_OCL_EXPRESSION, oldWmapOclExpression, wmapOclExpression));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT, oldWmapSimpleOutPatternElement, wmapSimpleOutPatternElement));
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
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT, oldWmapSimpleOutPatternElement, wmapSimpleOutPatternElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TMAP_BINDING__T0PROPERTY_NAME:
				return getT0propertyName();
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_BINDING:
				if (resolve) return getT1atlBinding();
				return basicGetT1atlBinding();
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_EXPRESSION:
				if (resolve) return getT1atlExpression();
				return basicGetT1atlExpression();
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_OUT_PATTERN_ELEMENT:
				if (resolve) return getT1atlOutPatternElement();
				return basicGetT1atlOutPatternElement();
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_EXPRESSION:
				if (resolve) return getT2qvtrExpression();
				return basicGetT2qvtrExpression();
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_PART:
				if (resolve) return getT2qvtrPart();
				return basicGetT2qvtrPart();
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_TEMPLATE:
				if (resolve) return getT2qvtrTemplate();
				return basicGetT2qvtrTemplate();
			case trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_OCL_EXPRESSION:
				if (resolve) return getWmapOclExpression();
				return basicGetWmapOclExpression();
			case trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT:
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
			case trace_ATL2QVTrPackage.TMAP_BINDING__T0PROPERTY_NAME:
				setT0propertyName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_BINDING:
				setT1atlBinding((Binding)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_EXPRESSION:
				setT1atlExpression((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_OUT_PATTERN_ELEMENT:
				setT1atlOutPatternElement((SimpleOutPatternElement)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_EXPRESSION:
				setT2qvtrExpression((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_PART:
				setT2qvtrPart((PropertyTemplateItem)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_TEMPLATE:
				setT2qvtrTemplate((ObjectTemplateExp)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_OCL_EXPRESSION:
				setWmapOclExpression((DmapOclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT:
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
			case trace_ATL2QVTrPackage.TMAP_BINDING__T0PROPERTY_NAME:
				setT0propertyName(T0PROPERTY_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_BINDING:
				setT1atlBinding((Binding)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_EXPRESSION:
				setT1atlExpression((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_OUT_PATTERN_ELEMENT:
				setT1atlOutPatternElement((SimpleOutPatternElement)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_EXPRESSION:
				setT2qvtrExpression((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_PART:
				setT2qvtrPart((PropertyTemplateItem)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_TEMPLATE:
				setT2qvtrTemplate((ObjectTemplateExp)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_OCL_EXPRESSION:
				setWmapOclExpression((DmapOclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT:
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
			case trace_ATL2QVTrPackage.TMAP_BINDING__T0PROPERTY_NAME:
				return T0PROPERTY_NAME_EDEFAULT == null ? t0propertyName != null : !T0PROPERTY_NAME_EDEFAULT.equals(t0propertyName);
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_BINDING:
				return t1atlBinding != null;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_EXPRESSION:
				return t1atlExpression != null;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T1ATL_OUT_PATTERN_ELEMENT:
				return t1atlOutPatternElement != null;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_EXPRESSION:
				return t2qvtrExpression != null;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_PART:
				return t2qvtrPart != null;
			case trace_ATL2QVTrPackage.TMAP_BINDING__T2QVTR_TEMPLATE:
				return t2qvtrTemplate != null;
			case trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_OCL_EXPRESSION:
				return wmapOclExpression != null;
			case trace_ATL2QVTrPackage.TMAP_BINDING__WMAP_SIMPLE_OUT_PATTERN_ELEMENT:
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
		result.append(" (t0propertyName: ");
		result.append(t0propertyName);
		result.append(')');
		return result.toString();
	}

} //TmapBindingImpl