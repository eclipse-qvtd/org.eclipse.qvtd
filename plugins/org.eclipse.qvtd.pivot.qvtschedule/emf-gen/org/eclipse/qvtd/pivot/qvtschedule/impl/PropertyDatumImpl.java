/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl#getOwningClassDatum <em>Owning Class Datum</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl#getReferredProperty <em>Referred Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl#getSuperPropertyDatums <em>Super Property Datums</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDatumImpl extends AbstractDatumImpl implements PropertyDatum {
	/**
	 * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpposite()
	 * @generated
	 * @ordered
	 */
	protected PropertyDatum opposite;

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
	 * The cached value of the '{@link #getSuperPropertyDatums() <em>Super Property Datums</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperPropertyDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyDatum> superPropertyDatums;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PropertyDatumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.PROPERTY_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyDatum getOpposite() {
		if (opposite != null && opposite.eIsProxy()) {
			InternalEObject oldOpposite = (InternalEObject)opposite;
			opposite = (PropertyDatum)eResolveProxy(oldOpposite);
			if (opposite != oldOpposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.PROPERTY_DATUM__OPPOSITE, oldOpposite, opposite));
			}
		}
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PropertyDatum basicGetOpposite() {
		return opposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpposite(PropertyDatum newOpposite) {
		PropertyDatum oldOpposite = opposite;
		opposite = newOpposite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.PROPERTY_DATUM__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassDatum getOwningClassDatum() {
		if (eContainerFeatureID() != QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM) return null;
		return (ClassDatum)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningClassDatum(ClassDatum newOwningClassDatum, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningClassDatum, QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningClassDatum(ClassDatum newOwningClassDatum) {
		if (newOwningClassDatum != eInternalContainer() || (eContainerFeatureID() != QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM && newOwningClassDatum != null)) {
			if (EcoreUtil.isAncestor(this, newOwningClassDatum))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningClassDatum != null)
				msgs = ((InternalEObject)newOwningClassDatum).eInverseAdd(this, QVTschedulePackage.CLASS_DATUM__OWNING_PROPERTY_DATUMS, ClassDatum.class, msgs);
			msgs = basicSetOwningClassDatum(newOwningClassDatum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM, newOwningClassDatum, newOwningClassDatum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getReferredProperty() {
		if (referredProperty != null && referredProperty.eIsProxy()) {
			InternalEObject oldReferredProperty = (InternalEObject)referredProperty;
			referredProperty = (Property)eResolveProxy(oldReferredProperty);
			if (referredProperty != oldReferredProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.PROPERTY_DATUM__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
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
	@Override
	public void setReferredProperty(Property newReferredProperty) {
		Property oldReferredProperty = referredProperty;
		referredProperty = newReferredProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.PROPERTY_DATUM__REFERRED_PROPERTY, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyDatum> getSuperPropertyDatums() {
		if (superPropertyDatums == null) {
			superPropertyDatums = new EObjectResolvingEList<PropertyDatum>(PropertyDatum.class, this, QVTschedulePackage.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS);
		}
		return superPropertyDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningClassDatum((ClassDatum)otherEnd, msgs);
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
			case QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM:
				return basicSetOwningClassDatum(null, msgs);
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
			case QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM:
				return eInternalContainer().eInverseRemove(this, QVTschedulePackage.CLASS_DATUM__OWNING_PROPERTY_DATUMS, ClassDatum.class, msgs);
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
			case QVTschedulePackage.PROPERTY_DATUM__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM:
				return getOwningClassDatum();
			case QVTschedulePackage.PROPERTY_DATUM__REFERRED_PROPERTY:
				if (resolve) return getReferredProperty();
				return basicGetReferredProperty();
			case QVTschedulePackage.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS:
				return getSuperPropertyDatums();
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
			case QVTschedulePackage.PROPERTY_DATUM__OPPOSITE:
				setOpposite((PropertyDatum)newValue);
				return;
			case QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM:
				setOwningClassDatum((ClassDatum)newValue);
				return;
			case QVTschedulePackage.PROPERTY_DATUM__REFERRED_PROPERTY:
				setReferredProperty((Property)newValue);
				return;
			case QVTschedulePackage.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS:
				getSuperPropertyDatums().clear();
				getSuperPropertyDatums().addAll((Collection<? extends PropertyDatum>)newValue);
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
			case QVTschedulePackage.PROPERTY_DATUM__OPPOSITE:
				setOpposite((PropertyDatum)null);
				return;
			case QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM:
				setOwningClassDatum((ClassDatum)null);
				return;
			case QVTschedulePackage.PROPERTY_DATUM__REFERRED_PROPERTY:
				setReferredProperty((Property)null);
				return;
			case QVTschedulePackage.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS:
				getSuperPropertyDatums().clear();
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
			case QVTschedulePackage.PROPERTY_DATUM__OPPOSITE:
				return opposite != null;
			case QVTschedulePackage.PROPERTY_DATUM__OWNING_CLASS_DATUM:
				return getOwningClassDatum() != null;
			case QVTschedulePackage.PROPERTY_DATUM__REFERRED_PROPERTY:
				return referredProperty != null;
			case QVTschedulePackage.PROPERTY_DATUM__SUPER_PROPERTY_DATUMS:
				return superPropertyDatums != null && !superPropertyDatums.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitPropertyDatum(this);
	}

	@Override
	public String toString() {
		return String.valueOf(getOwningClassDatum()) + "::" + (referredProperty != null ? referredProperty.getName() : "<null>");
	}

} //PropertyDatumImpl
