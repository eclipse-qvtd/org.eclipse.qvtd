/**
 * <copyright>
 * 
 * Copyright (c) 2007, 2008 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * E.D.Willink - initial API and implementation
 * 
 * </copyright>
 *
 * $Id: ObjectTemplateExpImpl.java,v 1.4 2009/12/19 13:38:25 ewillink Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTTemplate.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.ocl.utilities.Visitor;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.ObjectTemplateExp;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.PropertyTemplateItem;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.QVTTemplatePackage;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.util.QVTTemplateToStringVisitor;
import org.eclipse.qvt.declarative.ecore.QVTTemplate.util.QVTTemplateVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Template Exp</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.impl.ObjectTemplateExpImpl#getPart <em>Part</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTTemplate.impl.ObjectTemplateExpImpl#getReferredClass <em>Referred Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectTemplateExpImpl extends TemplateExpImpl implements ObjectTemplateExp {
	/**
	 * The cached value of the '{@link #getPart() <em>Part</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPart()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyTemplateItem> part;

	/**
	 * The cached value of the '{@link #getReferredClass() <em>Referred Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredClass()
	 * @generated
	 * @ordered
	 */
	protected EClass referredClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ObjectTemplateExpImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTTemplatePackage.Literals.OBJECT_TEMPLATE_EXP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyTemplateItem> getPart() {
		if (part == null) {
			part = new EObjectContainmentWithInverseEList<PropertyTemplateItem>(PropertyTemplateItem.class, this, QVTTemplatePackage.OBJECT_TEMPLATE_EXP__PART, QVTTemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER);
		}
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferredClass() {
		if (referredClass != null && referredClass.eIsProxy()) {
			InternalEObject oldReferredClass = (InternalEObject)referredClass;
			referredClass = (EClass)eResolveProxy(oldReferredClass);
			if (referredClass != oldReferredClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTTemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS, oldReferredClass, referredClass));
			}
		}
		return referredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetReferredClass() {
		return referredClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredClass(EClass newReferredClass) {
		EClass oldReferredClass = referredClass;
		referredClass = newReferredClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTTemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS, oldReferredClass, referredClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPart()).basicAdd(otherEnd, msgs);
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
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return ((InternalEList<?>)getPart()).basicRemove(otherEnd, msgs);
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
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return getPart();
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS:
				if (resolve) return getReferredClass();
				return basicGetReferredClass();
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
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				getPart().clear();
				getPart().addAll((Collection<? extends PropertyTemplateItem>)newValue);
				return;
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS:
				setReferredClass((EClass)newValue);
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
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				getPart().clear();
				return;
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS:
				setReferredClass((EClass)null);
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
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__PART:
				return part != null && !part.isEmpty();
			case QVTTemplatePackage.OBJECT_TEMPLATE_EXP__REFERRED_CLASS:
				return referredClass != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) {
			return super.toString();
		}		
		return accept(QVTTemplateToStringVisitor.getInstance(this));
	}

	/**
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	@Override
    public <T, U extends Visitor<T, ?, ?, ?, ?, ?, ?, ?, ?, ?>> T accept(U v) {
		if (v instanceof QVTTemplateVisitor<?>)
			return ((QVTTemplateVisitor<T>) v).visitObjectTemplateExp(this);
		return super.accept(v);
	}
} //ObjectTemplateExpImpl
