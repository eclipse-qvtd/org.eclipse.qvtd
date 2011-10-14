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
 * $Id: PropertyAssignmentImpl.java,v 1.1 2008/07/23 09:43:25 qglineur Exp $
 */
package org.eclipse.qvt.declarative.ecore.QVTCore.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.ocl.ecore.OCLExpression;

import org.eclipse.qvt.declarative.ecore.QVTCore.PropertyAssignment;
import org.eclipse.qvt.declarative.ecore.QVTCore.QVTCorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.PropertyAssignmentImpl#getSlotExpression <em>Slot Expression</em>}</li>
 *   <li>{@link org.eclipse.qvt.declarative.ecore.QVTCore.impl.PropertyAssignmentImpl#getTargetProperty <em>Target Property</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PropertyAssignmentImpl extends AssignmentImpl implements PropertyAssignment {
	/**
	 * The cached value of the '{@link #getSlotExpression() <em>Slot Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlotExpression()
	 * @generated
	 * @ordered
	 */
	protected OCLExpression slotExpression;

	/**
	 * The cached value of the '{@link #getTargetProperty() <em>Target Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetProperty()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature targetProperty;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTCorePackage.Literals.PROPERTY_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OCLExpression getSlotExpression() {
		return slotExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSlotExpression(OCLExpression newSlotExpression, NotificationChain msgs) {
		OCLExpression oldSlotExpression = slotExpression;
		slotExpression = newSlotExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTCorePackage.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION, oldSlotExpression, newSlotExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlotExpression(OCLExpression newSlotExpression) {
		if (newSlotExpression != slotExpression) {
			NotificationChain msgs = null;
			if (slotExpression != null)
				msgs = ((InternalEObject)slotExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTCorePackage.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION, null, msgs);
			if (newSlotExpression != null)
				msgs = ((InternalEObject)newSlotExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTCorePackage.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION, null, msgs);
			msgs = basicSetSlotExpression(newSlotExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTCorePackage.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION, newSlotExpression, newSlotExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getTargetProperty() {
		if (targetProperty != null && targetProperty.eIsProxy()) {
			InternalEObject oldTargetProperty = (InternalEObject)targetProperty;
			targetProperty = (EStructuralFeature)eResolveProxy(oldTargetProperty);
			if (targetProperty != oldTargetProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTCorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
			}
		}
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetTargetProperty() {
		return targetProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetProperty(EStructuralFeature newTargetProperty) {
		EStructuralFeature oldTargetProperty = targetProperty;
		targetProperty = newTargetProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTCorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY, oldTargetProperty, targetProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTCorePackage.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION:
				return basicSetSlotExpression(null, msgs);
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
			case QVTCorePackage.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION:
				return getSlotExpression();
			case QVTCorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
				if (resolve) return getTargetProperty();
				return basicGetTargetProperty();
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
			case QVTCorePackage.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION:
				setSlotExpression((OCLExpression)newValue);
				return;
			case QVTCorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
				setTargetProperty((EStructuralFeature)newValue);
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
			case QVTCorePackage.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION:
				setSlotExpression((OCLExpression)null);
				return;
			case QVTCorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
				setTargetProperty((EStructuralFeature)null);
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
			case QVTCorePackage.PROPERTY_ASSIGNMENT__SLOT_EXPRESSION:
				return slotExpression != null;
			case QVTCorePackage.PROPERTY_ASSIGNMENT__TARGET_PROPERTY:
				return targetProperty != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertyAssignmentImpl
