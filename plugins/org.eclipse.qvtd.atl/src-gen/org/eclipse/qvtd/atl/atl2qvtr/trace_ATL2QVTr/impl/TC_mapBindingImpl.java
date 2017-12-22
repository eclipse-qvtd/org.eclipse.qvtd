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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.m2m.atl.common.ATL.Binding;
import org.eclipse.m2m.atl.common.ATL.SimpleOutPatternElement;

import org.eclipse.m2m.atl.common.OCL.OclExpression;

import org.eclipse.ocl.pivot.OCLExpression;

import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.TC_mapBinding;
import org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.trace_ATL2QVTrPackage;

import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>TC map Binding</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapBindingImpl#getAtl_atlBinding <em>Atl atl Binding</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapBindingImpl#getAtl_atlExpression <em>Atl atl Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapBindingImpl#getAtl_atlOutPatternElement <em>Atl atl Out Pattern Element</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapBindingImpl#getPrimitive_propertyName <em>Primitive property Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapBindingImpl#getQvtr_qvtrExpression <em>Qvtr qvtr Expression</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapBindingImpl#getQvtr_qvtrPart <em>Qvtr qvtr Part</em>}</li>
 *   <li>{@link org.eclipse.qvtd.atl.atl2qvtr.trace_ATL2QVTr.impl.TC_mapBindingImpl#getQvtr_qvtrTemplate <em>Qvtr qvtr Template</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TC_mapBindingImpl extends MinimalEObjectImpl.Container implements TC_mapBinding {
	/**
	 * The cached value of the '{@link #getAtl_atlBinding() <em>Atl atl Binding</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlBinding()
	 * @generated
	 * @ordered
	 */
	protected Binding atl_atlBinding;

	/**
	 * The cached value of the '{@link #getAtl_atlExpression() <em>Atl atl Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlExpression()
	 * @generated
	 * @ordered
	 */
	protected OclExpression atl_atlExpression;

	/**
	 * The cached value of the '{@link #getAtl_atlOutPatternElement() <em>Atl atl Out Pattern Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtl_atlOutPatternElement()
	 * @generated
	 * @ordered
	 */
	protected SimpleOutPatternElement atl_atlOutPatternElement;

	/**
	 * The default value of the '{@link #getPrimitive_propertyName() <em>Primitive property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_propertyName()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_PROPERTY_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive_propertyName() <em>Primitive property Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive_propertyName()
	 * @generated
	 * @ordered
	 */
	protected String primitive_propertyName = PRIMITIVE_PROPERTY_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrExpression() <em>Qvtr qvtr Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression qvtr_qvtrExpression;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrPart() <em>Qvtr qvtr Part</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrPart()
	 * @generated
	 * @ordered
	 */
	protected PropertyTemplateItem qvtr_qvtrPart;

	/**
	 * The cached value of the '{@link #getQvtr_qvtrTemplate() <em>Qvtr qvtr Template</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQvtr_qvtrTemplate()
	 * @generated
	 * @ordered
	 */
	protected ObjectTemplateExp qvtr_qvtrTemplate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TC_mapBindingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return trace_ATL2QVTrPackage.Literals.TC_MAP_BINDING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding getAtl_atlBinding() {
		if (atl_atlBinding != null && atl_atlBinding.eIsProxy()) {
			InternalEObject oldAtl_atlBinding = (InternalEObject)atl_atlBinding;
			atl_atlBinding = (Binding)eResolveProxy(oldAtl_atlBinding);
			if (atl_atlBinding != oldAtl_atlBinding) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_BINDING, oldAtl_atlBinding, atl_atlBinding));
			}
		}
		return atl_atlBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Binding basicGetAtl_atlBinding() {
		return atl_atlBinding;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtl_atlBinding(Binding newAtl_atlBinding) {
		Binding oldAtl_atlBinding = atl_atlBinding;
		atl_atlBinding = newAtl_atlBinding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_BINDING, oldAtl_atlBinding, atl_atlBinding));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression getAtl_atlExpression() {
		if (atl_atlExpression != null && atl_atlExpression.eIsProxy()) {
			InternalEObject oldAtl_atlExpression = (InternalEObject)atl_atlExpression;
			atl_atlExpression = (OclExpression)eResolveProxy(oldAtl_atlExpression);
			if (atl_atlExpression != oldAtl_atlExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
			}
		}
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclExpression basicGetAtl_atlExpression() {
		return atl_atlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtl_atlExpression(OclExpression newAtl_atlExpression) {
		OclExpression oldAtl_atlExpression = atl_atlExpression;
		atl_atlExpression = newAtl_atlExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_EXPRESSION, oldAtl_atlExpression, atl_atlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleOutPatternElement getAtl_atlOutPatternElement() {
		if (atl_atlOutPatternElement != null && atl_atlOutPatternElement.eIsProxy()) {
			InternalEObject oldAtl_atlOutPatternElement = (InternalEObject)atl_atlOutPatternElement;
			atl_atlOutPatternElement = (SimpleOutPatternElement)eResolveProxy(oldAtl_atlOutPatternElement);
			if (atl_atlOutPatternElement != oldAtl_atlOutPatternElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_OUT_PATTERN_ELEMENT, oldAtl_atlOutPatternElement, atl_atlOutPatternElement));
			}
		}
		return atl_atlOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimpleOutPatternElement basicGetAtl_atlOutPatternElement() {
		return atl_atlOutPatternElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtl_atlOutPatternElement(SimpleOutPatternElement newAtl_atlOutPatternElement) {
		SimpleOutPatternElement oldAtl_atlOutPatternElement = atl_atlOutPatternElement;
		atl_atlOutPatternElement = newAtl_atlOutPatternElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_OUT_PATTERN_ELEMENT, oldAtl_atlOutPatternElement, atl_atlOutPatternElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPrimitive_propertyName() {
		return primitive_propertyName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrimitive_propertyName(String newPrimitive_propertyName) {
		String oldPrimitive_propertyName = primitive_propertyName;
		primitive_propertyName = newPrimitive_propertyName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_BINDING__PRIMITIVE_PROPERTY_NAME, oldPrimitive_propertyName, primitive_propertyName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getQvtr_qvtrExpression() {
		if (qvtr_qvtrExpression != null && qvtr_qvtrExpression.eIsProxy()) {
			InternalEObject oldQvtr_qvtrExpression = (InternalEObject)qvtr_qvtrExpression;
			qvtr_qvtrExpression = (OCLExpression)eResolveProxy(oldQvtr_qvtrExpression);
			if (qvtr_qvtrExpression != oldQvtr_qvtrExpression) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
			}
		}
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression basicGetQvtr_qvtrExpression() {
		return qvtr_qvtrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrExpression(OCLExpression newQvtr_qvtrExpression) {
		OCLExpression oldQvtr_qvtrExpression = qvtr_qvtrExpression;
		qvtr_qvtrExpression = newQvtr_qvtrExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_EXPRESSION, oldQvtr_qvtrExpression, qvtr_qvtrExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTemplateItem getQvtr_qvtrPart() {
		if (qvtr_qvtrPart != null && qvtr_qvtrPart.eIsProxy()) {
			InternalEObject oldQvtr_qvtrPart = (InternalEObject)qvtr_qvtrPart;
			qvtr_qvtrPart = (PropertyTemplateItem)eResolveProxy(oldQvtr_qvtrPart);
			if (qvtr_qvtrPart != oldQvtr_qvtrPart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_PART, oldQvtr_qvtrPart, qvtr_qvtrPart));
			}
		}
		return qvtr_qvtrPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyTemplateItem basicGetQvtr_qvtrPart() {
		return qvtr_qvtrPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrPart(PropertyTemplateItem newQvtr_qvtrPart) {
		PropertyTemplateItem oldQvtr_qvtrPart = qvtr_qvtrPart;
		qvtr_qvtrPart = newQvtr_qvtrPart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_PART, oldQvtr_qvtrPart, qvtr_qvtrPart));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp getQvtr_qvtrTemplate() {
		if (qvtr_qvtrTemplate != null && qvtr_qvtrTemplate.eIsProxy()) {
			InternalEObject oldQvtr_qvtrTemplate = (InternalEObject)qvtr_qvtrTemplate;
			qvtr_qvtrTemplate = (ObjectTemplateExp)eResolveProxy(oldQvtr_qvtrTemplate);
			if (qvtr_qvtrTemplate != oldQvtr_qvtrTemplate) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_TEMPLATE, oldQvtr_qvtrTemplate, qvtr_qvtrTemplate));
			}
		}
		return qvtr_qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp basicGetQvtr_qvtrTemplate() {
		return qvtr_qvtrTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQvtr_qvtrTemplate(ObjectTemplateExp newQvtr_qvtrTemplate) {
		ObjectTemplateExp oldQvtr_qvtrTemplate = qvtr_qvtrTemplate;
		qvtr_qvtrTemplate = newQvtr_qvtrTemplate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_TEMPLATE, oldQvtr_qvtrTemplate, qvtr_qvtrTemplate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_BINDING:
				if (resolve) return getAtl_atlBinding();
				return basicGetAtl_atlBinding();
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_EXPRESSION:
				if (resolve) return getAtl_atlExpression();
				return basicGetAtl_atlExpression();
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_OUT_PATTERN_ELEMENT:
				if (resolve) return getAtl_atlOutPatternElement();
				return basicGetAtl_atlOutPatternElement();
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__PRIMITIVE_PROPERTY_NAME:
				return getPrimitive_propertyName();
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_EXPRESSION:
				if (resolve) return getQvtr_qvtrExpression();
				return basicGetQvtr_qvtrExpression();
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_PART:
				if (resolve) return getQvtr_qvtrPart();
				return basicGetQvtr_qvtrPart();
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_TEMPLATE:
				if (resolve) return getQvtr_qvtrTemplate();
				return basicGetQvtr_qvtrTemplate();
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
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_BINDING:
				setAtl_atlBinding((Binding)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((OclExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_OUT_PATTERN_ELEMENT:
				setAtl_atlOutPatternElement((SimpleOutPatternElement)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__PRIMITIVE_PROPERTY_NAME:
				setPrimitive_propertyName((String)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((OCLExpression)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_PART:
				setQvtr_qvtrPart((PropertyTemplateItem)newValue);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_TEMPLATE:
				setQvtr_qvtrTemplate((ObjectTemplateExp)newValue);
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
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_BINDING:
				setAtl_atlBinding((Binding)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_EXPRESSION:
				setAtl_atlExpression((OclExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_OUT_PATTERN_ELEMENT:
				setAtl_atlOutPatternElement((SimpleOutPatternElement)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__PRIMITIVE_PROPERTY_NAME:
				setPrimitive_propertyName(PRIMITIVE_PROPERTY_NAME_EDEFAULT);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_EXPRESSION:
				setQvtr_qvtrExpression((OCLExpression)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_PART:
				setQvtr_qvtrPart((PropertyTemplateItem)null);
				return;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_TEMPLATE:
				setQvtr_qvtrTemplate((ObjectTemplateExp)null);
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
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_BINDING:
				return atl_atlBinding != null;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_EXPRESSION:
				return atl_atlExpression != null;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__ATL_ATL_OUT_PATTERN_ELEMENT:
				return atl_atlOutPatternElement != null;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__PRIMITIVE_PROPERTY_NAME:
				return PRIMITIVE_PROPERTY_NAME_EDEFAULT == null ? primitive_propertyName != null : !PRIMITIVE_PROPERTY_NAME_EDEFAULT.equals(primitive_propertyName);
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_EXPRESSION:
				return qvtr_qvtrExpression != null;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_PART:
				return qvtr_qvtrPart != null;
			case trace_ATL2QVTrPackage.TC_MAP_BINDING__QVTR_QVTR_TEMPLATE:
				return qvtr_qvtrTemplate != null;
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
		result.append(" (primitive_propertyName: ");
		result.append(primitive_propertyName);
		result.append(')');
		return result.toString();
	}

} //TC_mapBindingImpl
