/**
 * <copyright>
 * 
 * Copyright (c) 2013 E.D.Willink and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.ocl.examples.pivot.Property;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getMapping <em>Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getSlotValue <em>Slot Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getInitValue <em>Init Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CGPropertyAssignmentImpl extends CGValuedElementImpl implements CGPropertyAssignment {
	/**
	 * The cached value of the '{@link #getSlotValue() <em>Slot Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSlotValue()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement slotValue;
	/**
	 * The default value of the '{@link #getReferredProperty() <em>Referred Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected static final Property REFERRED_PROPERTY_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getReferredProperty() <em>Referred Property</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredProperty()
	 * @generated
	 * @ordered
	 */
	protected Property referredProperty = REFERRED_PROPERTY_EDEFAULT;
	/**
	 * The cached value of the '{@link #getInitValue() <em>Init Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitValue()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement initValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CGPropertyAssignmentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTiCGModelPackage.Literals.CG_PROPERTY_ASSIGNMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGMapping getMapping() {
		if (eContainerFeatureID() != QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING) return null;
		return (CGMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMapping(CGMapping newMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMapping, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMapping(CGMapping newMapping) {
		if (newMapping != eInternalContainer() || (eContainerFeatureID() != QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING && newMapping != null)) {
			if (EcoreUtil.isAncestor(this, newMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMapping != null)
				msgs = ((InternalEObject)newMapping).eInverseAdd(this, QVTiCGModelPackage.CG_MAPPING__ASSIGNMENTS, CGMapping.class, msgs);
			msgs = basicSetMapping(newMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING, newMapping, newMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getSlotValue() {
		return slotValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSlotValue(CGValuedElement newSlotValue, NotificationChain msgs) {
		CGValuedElement oldSlotValue = slotValue;
		slotValue = newSlotValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE, oldSlotValue, newSlotValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSlotValue(CGValuedElement newSlotValue) {
		if (newSlotValue != slotValue) {
			NotificationChain msgs = null;
			if (slotValue != null)
				msgs = ((InternalEObject)slotValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE, null, msgs);
			if (newSlotValue != null)
				msgs = ((InternalEObject)newSlotValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE, null, msgs);
			msgs = basicSetSlotValue(newSlotValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE, newSlotValue, newSlotValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getReferredProperty() {
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CGValuedElement getInitValue() {
		return initValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitValue(CGValuedElement newInitValue, NotificationChain msgs) {
		CGValuedElement oldInitValue = initValue;
		initValue = newInitValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE, oldInitValue, newInitValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitValue(CGValuedElement newInitValue) {
		if (newInitValue != initValue) {
			NotificationChain msgs = null;
			if (initValue != null)
				msgs = ((InternalEObject)initValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE, null, msgs);
			if (newInitValue != null)
				msgs = ((InternalEObject)newInitValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE, null, msgs);
			msgs = basicSetInitValue(newInitValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE, newInitValue, newInitValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMapping((CGMapping)otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING:
				return basicSetMapping(null, msgs);
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE:
				return basicSetSlotValue(null, msgs);
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE:
				return basicSetInitValue(null, msgs);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING:
				return eInternalContainer().eInverseRemove(this, QVTiCGModelPackage.CG_MAPPING__ASSIGNMENTS, CGMapping.class, msgs);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING:
				return getMapping();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE:
				return getSlotValue();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				return getReferredProperty();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE:
				return getInitValue();
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING:
				setMapping((CGMapping)newValue);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE:
				setSlotValue((CGValuedElement)newValue);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE:
				setInitValue((CGValuedElement)newValue);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING:
				setMapping((CGMapping)null);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE:
				setSlotValue((CGValuedElement)null);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				setReferredProperty(REFERRED_PROPERTY_EDEFAULT);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE:
				setInitValue((CGValuedElement)null);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING:
				return getMapping() != null;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE:
				return slotValue != null;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				return REFERRED_PROPERTY_EDEFAULT == null ? referredProperty != null : !REFERRED_PROPERTY_EDEFAULT.equals(referredProperty);
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE:
				return initValue != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (referredProperty: ");
		result.append(referredProperty);
		result.append(')');
		return result.toString();
	}

	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return ((QVTiCGModelVisitor<R>)visitor).visitCGPropertyAssignment(this);
	}

	@Override
	public @NonNull CGValuedElement getReferredValuedElement() {
		return initValue != null ? initValue : this;
	}
} //CGAssignmentImpl
