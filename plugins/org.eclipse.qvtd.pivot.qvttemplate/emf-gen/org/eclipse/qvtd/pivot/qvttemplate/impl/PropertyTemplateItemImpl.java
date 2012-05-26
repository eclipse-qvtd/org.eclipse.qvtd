/**
 * <copyright>
 *
 * Copyright (c) 2011 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.qvtd.pivot.qvttemplate.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.examples.pivot.OCLExpression;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.ocl.examples.pivot.internal.impl.ElementImpl;
import org.eclipse.ocl.examples.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.QVTtemplatePackage;
import org.eclipse.qvtd.pivot.qvttemplate.util.QVTtemplateVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Template Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl#getObjContainer <em>Obj Container</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvttemplate.impl.PropertyTemplateItemImpl#isIsOpposite <em>Is Opposite</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyTemplateItemImpl extends ElementImpl implements PropertyTemplateItem {
	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression value;

	/**
	 * The default value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OPPOSITE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOpposite() <em>Is Opposite</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOpposite()
	 * @generated
	 * @ordered
	 */
	protected boolean isOpposite = IS_OPPOSITE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyTemplateItemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTtemplatePackage.Literals.PROPERTY_TEMPLATE_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectTemplateExp getObjContainer() {
		if (eContainerFeatureID() != QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER) return null;
		return (ObjectTemplateExp)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetObjContainer(ObjectTemplateExp newObjContainer, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newObjContainer, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setObjContainer(ObjectTemplateExp newObjContainer) {
		if (newObjContainer != eInternalContainer() || (eContainerFeatureID() != QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER && newObjContainer != null)) {
			if (EcoreUtil.isAncestor(this, newObjContainer))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newObjContainer != null)
				msgs = ((InternalEObject)newObjContainer).eInverseAdd(this, QVTtemplatePackage.OBJECT_TEMPLATE_EXP__PART, ObjectTemplateExp.class, msgs);
			msgs = basicSetObjContainer(newObjContainer, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER, newObjContainer, newObjContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getReferredProperty() {
		if (referredProperty != null && ((EObject)referredProperty).eIsProxy()) {
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
			}
		}
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValue(OCLExpression newValue, NotificationChain msgs) {
		OCLExpression oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(OCLExpression newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE, newValue, newValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsOpposite() {
		return isOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsOpposite(boolean newIsOpposite) {
		boolean oldIsOpposite = isOpposite;
		isOpposite = newIsOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE, oldIsOpposite, isOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetObjContainer((ObjectTemplateExp)otherEnd, msgs);
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				return basicSetObjContainer(null, msgs);
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
				return basicSetValue(null, msgs);
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				return eInternalContainer().eInverseRemove(this, QVTtemplatePackage.OBJECT_TEMPLATE_EXP__PART, ObjectTemplateExp.class, msgs);
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				return getObjContainer();
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
				return getValue();
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE:
				return isIsOpposite();
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				setObjContainer((ObjectTemplateExp)newValue);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
				setValue((OCLExpression)newValue);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE:
				setIsOpposite((Boolean)newValue);
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				setObjContainer((ObjectTemplateExp)null);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
				setValue((OCLExpression)null);
				return;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE:
				setIsOpposite(IS_OPPOSITE_EDEFAULT);
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
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__OBJ_CONTAINER:
				return getObjContainer() != null;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__REFERRED_PROPERTY:
				return referredProperty != null;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__VALUE:
				return value != null;
			case QVTtemplatePackage.PROPERTY_TEMPLATE_ITEM__IS_OPPOSITE:
				return isOpposite != IS_OPPOSITE_EDEFAULT;
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
		return super.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(Visitor<R> visitor) {
		return (R) visitor.getAdapter(QVTtemplateVisitor.class).visitPropertyTemplateItem(this);
	}
} //PropertyTemplateItemImpl
