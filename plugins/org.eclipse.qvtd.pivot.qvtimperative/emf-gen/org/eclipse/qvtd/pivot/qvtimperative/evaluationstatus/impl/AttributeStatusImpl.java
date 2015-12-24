/*******************************************************************************
 * Copyright (c) 2015 E.D.Willink and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.AttributeStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.ClassStatus;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.EvaluationStatusPackage;
import org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.util.EvaluationStatusVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Status</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AttributeStatusImpl#getEFeature <em>EFeature</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AttributeStatusImpl#getObject <em>Object</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtimperative.evaluationstatus.impl.AttributeStatusImpl#getOwningClassStatus <em>Owning Class Status</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeStatusImpl extends PropertyStatusImpl implements AttributeStatus {
	/**
	 * The cached value of the '{@link #getEFeature() <em>EFeature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEFeature()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature eFeature;

	/**
	 * The default value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected static final Object OBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected Object object = OBJECT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeStatusImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return EvaluationStatusPackage.Literals.ATTRIBUTE_STATUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EStructuralFeature getEFeature() {
		if (eFeature != null && eFeature.eIsProxy()) {
			InternalEObject oldEFeature = (InternalEObject)eFeature;
			eFeature = (EStructuralFeature)eResolveProxy(oldEFeature);
			if (eFeature != oldEFeature) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EvaluationStatusPackage.ATTRIBUTE_STATUS__EFEATURE, oldEFeature, eFeature));
			}
		}
		return eFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetEFeature() {
		return eFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEFeature(EStructuralFeature newEFeature) {
		EStructuralFeature oldEFeature = eFeature;
		eFeature = newEFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.ATTRIBUTE_STATUS__EFEATURE, oldEFeature, eFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getObject() {
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setObject(Object newObject) {
		Object oldObject = object;
		object = newObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.ATTRIBUTE_STATUS__OBJECT, oldObject, object));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassStatus getOwningClassStatus() {
		if (eContainerFeatureID() != EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS) return null;
		return (ClassStatus)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningClassStatus(ClassStatus newOwningClassStatus, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningClassStatus, EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningClassStatus(ClassStatus newOwningClassStatus) {
		if (newOwningClassStatus != eInternalContainer() || (eContainerFeatureID() != EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS && newOwningClassStatus != null)) {
			if (EcoreUtil.isAncestor(this, newOwningClassStatus))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningClassStatus != null)
				msgs = ((InternalEObject)newOwningClassStatus).eInverseAdd(this, EvaluationStatusPackage.CLASS_STATUS__OWNED_ATTRIBUTE_STATUSES, ClassStatus.class, msgs);
			msgs = basicSetOwningClassStatus(newOwningClassStatus, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS, newOwningClassStatus, newOwningClassStatus));
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
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningClassStatus((ClassStatus)otherEnd, msgs);
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
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS:
				return basicSetOwningClassStatus(null, msgs);
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
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS:
				return eInternalContainer().eInverseRemove(this, EvaluationStatusPackage.CLASS_STATUS__OWNED_ATTRIBUTE_STATUSES, ClassStatus.class, msgs);
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
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__EFEATURE:
				if (resolve) return getEFeature();
				return basicGetEFeature();
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OBJECT:
				return getObject();
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS:
				return getOwningClassStatus();
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
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__EFEATURE:
				setEFeature((EStructuralFeature)newValue);
				return;
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OBJECT:
				setObject(newValue);
				return;
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS:
				setOwningClassStatus((ClassStatus)newValue);
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
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__EFEATURE:
				setEFeature((EStructuralFeature)null);
				return;
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OBJECT:
				setObject(OBJECT_EDEFAULT);
				return;
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS:
				setOwningClassStatus((ClassStatus)null);
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
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__EFEATURE:
				return eFeature != null;
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OBJECT:
				return OBJECT_EDEFAULT == null ? object != null : !OBJECT_EDEFAULT.equals(object);
			case EvaluationStatusPackage.ATTRIBUTE_STATUS__OWNING_CLASS_STATUS:
				return getOwningClassStatus() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@Override
	public <R> R accept(@NonNull EvaluationStatusVisitor<R> visitor) {
		return visitor.visitAttributeStatus(this);
	}

} //AttributeStatusImpl
