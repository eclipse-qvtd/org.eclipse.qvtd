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
 * $Id: ObjectTemplateCSImpl.java,v 1.2 2008/08/18 07:55:54 ewillink Exp $
 */
package org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.ObjectTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.PropertyTemplateCS;
import org.eclipse.qvt.declarative.parser.qvtrelation.cst.QVTrCSTPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Object Template CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ObjectTemplateCSImpl#getPropertyTemplate <em>Property Template</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.parser.qvtrelation.cst.impl.ObjectTemplateCSImpl#getReferredClass <em>Referred Class</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ObjectTemplateCSImpl extends TemplateCSImpl implements ObjectTemplateCS {
	/**
	 * The cached value of the '{@link #getPropertyTemplate() <em>Property Template</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyTemplate()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyTemplateCS> propertyTemplate;

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
	protected ObjectTemplateCSImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTrCSTPackage.Literals.OBJECT_TEMPLATE_CS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyTemplateCS> getPropertyTemplate() {
		if (propertyTemplate == null) {
			propertyTemplate = new EObjectContainmentEList<PropertyTemplateCS>(PropertyTemplateCS.class, this, QVTrCSTPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATE);
		}
		return propertyTemplate;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTrCSTPackage.OBJECT_TEMPLATE_CS__REFERRED_CLASS, oldReferredClass, referredClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTrCSTPackage.OBJECT_TEMPLATE_CS__REFERRED_CLASS, oldReferredClass, referredClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATE:
				return ((InternalEList<?>)getPropertyTemplate()).basicRemove(otherEnd, msgs);
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
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATE:
				return getPropertyTemplate();
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS__REFERRED_CLASS:
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
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATE:
				getPropertyTemplate().clear();
				getPropertyTemplate().addAll((Collection<? extends PropertyTemplateCS>)newValue);
				return;
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS__REFERRED_CLASS:
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
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATE:
				getPropertyTemplate().clear();
				return;
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS__REFERRED_CLASS:
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
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS__PROPERTY_TEMPLATE:
				return propertyTemplate != null && !propertyTemplate.isEmpty();
			case QVTrCSTPackage.OBJECT_TEMPLATE_CS__REFERRED_CLASS:
				return referredClass != null;
		}
		return super.eIsSet(featureID);
	}

} //ObjectTemplateCSImpl
