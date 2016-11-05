/*******************************************************************************
 * Copyright (c) 2013, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.codegen.qvticgmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.examples.codegen.cgmodel.CGExecutorProperty;
import org.eclipse.ocl.examples.codegen.cgmodel.CGValuedElement;
import org.eclipse.ocl.examples.codegen.cgmodel.impl.CGValuedElementImpl;
import org.eclipse.ocl.examples.codegen.cgmodel.util.CGModelVisitor;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.codegen.qvticgmodel.CGMapping;
import org.eclipse.qvtd.codegen.qvticgmodel.CGPropertyAssignment;
import org.eclipse.qvtd.codegen.qvticgmodel.QVTiCGModelPackage;
import org.eclipse.qvtd.codegen.qvticgmodel.util.QVTiCGModelVisitor;
import org.eclipse.qvtd.codegen.utilities.QVTiEquivalenceUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CG Property Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getExecutorProperty <em>Executor Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getOwnedInitValue <em>Owned Init Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getOwnedSlotValue <em>Owned Slot Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getOwningMapping <em>Owning Mapping</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getReferredProperty <em>Referred Property</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CGPropertyAssignmentImpl extends CGValuedElementImpl implements CGPropertyAssignment {
	/**
	 * The cached value of the '{@link #getExecutorProperty() <em>Executor Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutorProperty()
	 * @generated
	 * @ordered
	 */
	protected CGExecutorProperty executorProperty;

	/**
	 * The cached value of the '{@link #getOwnedInitValue() <em>Owned Init Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedInitValue()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement ownedInitValue;

	/**
	 * The cached value of the '{@link #getOwnedSlotValue() <em>Owned Slot Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedSlotValue()
	 * @generated
	 * @ordered
	 */
	protected CGValuedElement ownedSlotValue;

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
	@Override
	public CGMapping getOwningMapping() {
		if (eContainerFeatureID() != QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING) return null;
		return (CGMapping)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningMapping(CGMapping newOwningMapping, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningMapping, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningMapping(CGMapping newOwningMapping) {
		if (newOwningMapping != eInternalContainer() || (eContainerFeatureID() != QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING && newOwningMapping != null)) {
			if (EcoreUtil.isAncestor(this, newOwningMapping))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningMapping != null)
				msgs = ((InternalEObject)newOwningMapping).eInverseAdd(this, QVTiCGModelPackage.CG_MAPPING__OWNED_ASSIGNMENTS, CGMapping.class, msgs);
			msgs = basicSetOwningMapping(newOwningMapping, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING, newOwningMapping, newOwningMapping));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty() {
		return referredProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
	public CGExecutorProperty getExecutorProperty() {
		return executorProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExecutorProperty(CGExecutorProperty newExecutorProperty) {
		CGExecutorProperty oldExecutorProperty = executorProperty;
		executorProperty = newExecutorProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY, oldExecutorProperty, executorProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGValuedElement getOwnedInitValue() {
		return ownedInitValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedInitValue(CGValuedElement newOwnedInitValue, NotificationChain msgs) {
		CGValuedElement oldOwnedInitValue = ownedInitValue;
		ownedInitValue = newOwnedInitValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE, oldOwnedInitValue, newOwnedInitValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedInitValue(CGValuedElement newOwnedInitValue) {
		if (newOwnedInitValue != ownedInitValue) {
			NotificationChain msgs = null;
			if (ownedInitValue != null)
				msgs = ((InternalEObject)ownedInitValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE, null, msgs);
			if (newOwnedInitValue != null)
				msgs = ((InternalEObject)newOwnedInitValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE, null, msgs);
			msgs = basicSetOwnedInitValue(newOwnedInitValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE, newOwnedInitValue, newOwnedInitValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CGValuedElement getOwnedSlotValue() {
		return ownedSlotValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwnedSlotValue(CGValuedElement newOwnedSlotValue, NotificationChain msgs) {
		CGValuedElement oldOwnedSlotValue = ownedSlotValue;
		ownedSlotValue = newOwnedSlotValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE, oldOwnedSlotValue, newOwnedSlotValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwnedSlotValue(CGValuedElement newOwnedSlotValue) {
		if (newOwnedSlotValue != ownedSlotValue) {
			NotificationChain msgs = null;
			if (ownedSlotValue != null)
				msgs = ((InternalEObject)ownedSlotValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE, null, msgs);
			if (newOwnedSlotValue != null)
				msgs = ((InternalEObject)newOwnedSlotValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE, null, msgs);
			msgs = basicSetOwnedSlotValue(newOwnedSlotValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE, newOwnedSlotValue, newOwnedSlotValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningMapping((CGMapping)otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE:
				return basicSetOwnedInitValue(null, msgs);
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE:
				return basicSetOwnedSlotValue(null, msgs);
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING:
				return basicSetOwningMapping(null, msgs);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING:
				return eInternalContainer().eInverseRemove(this, QVTiCGModelPackage.CG_MAPPING__OWNED_ASSIGNMENTS, CGMapping.class, msgs);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY:
				return getExecutorProperty();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE:
				return getOwnedInitValue();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE:
				return getOwnedSlotValue();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING:
				return getOwningMapping();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				return getReferredProperty();
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY:
				setExecutorProperty((CGExecutorProperty)newValue);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE:
				setOwnedInitValue((CGValuedElement)newValue);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE:
				setOwnedSlotValue((CGValuedElement)newValue);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING:
				setOwningMapping((CGMapping)newValue);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY:
				setExecutorProperty((CGExecutorProperty)null);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE:
				setOwnedInitValue((CGValuedElement)null);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE:
				setOwnedSlotValue((CGValuedElement)null);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING:
				setOwningMapping((CGMapping)null);
				return;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				setReferredProperty(REFERRED_PROPERTY_EDEFAULT);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY:
				return executorProperty != null;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_INIT_VALUE:
				return ownedInitValue != null;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNED_SLOT_VALUE:
				return ownedSlotValue != null;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__OWNING_MAPPING:
				return getOwningMapping() != null;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				return REFERRED_PROPERTY_EDEFAULT == null ? referredProperty != null : !REFERRED_PROPERTY_EDEFAULT.equals(referredProperty);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull CGModelVisitor<R> visitor) {
		return (R) ((QVTiCGModelVisitor<?>)visitor).visitCGPropertyAssignment(this);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable EClassifier getEcoreClassifier() {
		return ownedInitValue != null ? ownedInitValue.getEcoreClassifier() : null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isBoxed() {
		return (ownedInitValue != null) && ownedInitValue.isBoxed();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isEcore() {
		return (ownedInitValue != null) && ownedInitValue.isEcore();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public @Nullable Boolean isEquivalentToInternal(@NonNull CGValuedElement thatValue) {
		return (getClass() == thatValue.getClass()) ? QVTiEquivalenceUtil.isEquivalent(this, (CGPropertyAssignment)thatValue) : null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isGlobal() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isUnboxed() {
		return (ownedInitValue != null) && ownedInitValue.isUnboxed();
	}

} //CGPropertyAssignmentImpl
