/*******************************************************************************
 * Copyright (c) 2013, 2015 Willink Transformations and others.
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
import org.eclipse.qvtd.codegen.qvticgmodel.CGMappingExp;
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
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getMappingExp <em>Mapping Exp</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getSlotValue <em>Slot Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getInitValue <em>Init Value</em>}</li>
 *   <li>{@link org.eclipse.qvtd.codegen.qvticgmodel.impl.CGPropertyAssignmentImpl#getExecutorProperty <em>Executor Property</em>}</li>
 * </ul>
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
	 * The cached value of the '{@link #getExecutorProperty() <em>Executor Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutorProperty()
	 * @generated
	 * @ordered
	 */
	protected CGExecutorProperty executorProperty;

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
	public CGMappingExp getMappingExp() {
		if (eContainerFeatureID() != QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP) return null;
		return (CGMappingExp)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMappingExp(CGMappingExp newMappingExp, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newMappingExp, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappingExp(CGMappingExp newMappingExp) {
		if (newMappingExp != eInternalContainer() || (eContainerFeatureID() != QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP && newMappingExp != null)) {
			if (EcoreUtil.isAncestor(this, newMappingExp))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newMappingExp != null)
				msgs = ((InternalEObject)newMappingExp).eInverseAdd(this, QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS, CGMappingExp.class, msgs);
			msgs = basicSetMappingExp(newMappingExp, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP, newMappingExp, newMappingExp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
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
	@Override
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
	@Override
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetMappingExp((CGMappingExp)otherEnd, msgs);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP:
				return basicSetMappingExp(null, msgs);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP:
				return eInternalContainer().eInverseRemove(this, QVTiCGModelPackage.CG_MAPPING_EXP__ASSIGNMENTS, CGMappingExp.class, msgs);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP:
				return getMappingExp();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE:
				return getSlotValue();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				return getReferredProperty();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE:
				return getInitValue();
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY:
				return getExecutorProperty();
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP:
				setMappingExp((CGMappingExp)newValue);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY:
				setExecutorProperty((CGExecutorProperty)newValue);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP:
				setMappingExp((CGMappingExp)null);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY:
				setExecutorProperty((CGExecutorProperty)null);
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
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__MAPPING_EXP:
				return getMappingExp() != null;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__SLOT_VALUE:
				return slotValue != null;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__REFERRED_PROPERTY:
				return REFERRED_PROPERTY_EDEFAULT == null ? referredProperty != null : !REFERRED_PROPERTY_EDEFAULT.equals(referredProperty);
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__INIT_VALUE:
				return initValue != null;
			case QVTiCGModelPackage.CG_PROPERTY_ASSIGNMENT__EXECUTOR_PROPERTY:
				return executorProperty != null;
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
		return initValue != null ? initValue.getEcoreClassifier() : null;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isBoxed() {
		return (initValue != null) && initValue.isBoxed();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public boolean isEcore() {
		return (initValue != null) && initValue.isEcore();
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
		return (initValue != null) && initValue.isUnboxed();
	}

} //CGPropertyAssignmentImpl
