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
package org.eclipse.qvtd.pivot.schedule.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.SchedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.PropertyDatumImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.PropertyDatumImpl#getClassDatum <em>Class Datum</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.PropertyDatumImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.PropertyDatumImpl#getSuper <em>Super</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDatumImpl extends AbstractDatumImpl implements PropertyDatum {
	/**
	 * The cached value of the '{@link #getProperty() <em>Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperty()
	 * @generated
	 * @ordered
	 */
	protected Property property;

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
	 * The cached value of the '{@link #getSuper() <em>Super</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuper()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyDatum> super_;

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
		return SchedulePackage.Literals.PROPERTY_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property getProperty() {
		if (property != null && property.eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (Property)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.PROPERTY_DATUM__PROPERTY, oldProperty, property));
			}
		}
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property basicGetProperty() {
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.PROPERTY_DATUM__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassDatum getClassDatum() {
		if (eContainerFeatureID() != SchedulePackage.PROPERTY_DATUM__CLASS_DATUM) return null;
		return (ClassDatum)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassDatum(ClassDatum newClassDatum, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClassDatum, SchedulePackage.PROPERTY_DATUM__CLASS_DATUM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassDatum(ClassDatum newClassDatum) {
		if (newClassDatum != eInternalContainer() || (eContainerFeatureID() != SchedulePackage.PROPERTY_DATUM__CLASS_DATUM && newClassDatum != null)) {
			if (EcoreUtil.isAncestor(this, newClassDatum))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newClassDatum != null)
				msgs = ((InternalEObject)newClassDatum).eInverseAdd(this, SchedulePackage.CLASS_DATUM__PROPERTY_DATUMS, ClassDatum.class, msgs);
			msgs = basicSetClassDatum(newClassDatum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.PROPERTY_DATUM__CLASS_DATUM, newClassDatum, newClassDatum));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.PROPERTY_DATUM__OPPOSITE, oldOpposite, opposite));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.PROPERTY_DATUM__OPPOSITE, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyDatum> getSuper() {
		if (super_ == null) {
			super_ = new EObjectResolvingEList<PropertyDatum>(PropertyDatum.class, this, SchedulePackage.PROPERTY_DATUM__SUPER);
		}
		return super_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SchedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetClassDatum((ClassDatum)otherEnd, msgs);
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
			case SchedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				return basicSetClassDatum(null, msgs);
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
			case SchedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				return eInternalContainer().eInverseRemove(this, SchedulePackage.CLASS_DATUM__PROPERTY_DATUMS, ClassDatum.class, msgs);
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
			case SchedulePackage.PROPERTY_DATUM__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case SchedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				return getClassDatum();
			case SchedulePackage.PROPERTY_DATUM__OPPOSITE:
				if (resolve) return getOpposite();
				return basicGetOpposite();
			case SchedulePackage.PROPERTY_DATUM__SUPER:
				return getSuper();
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
			case SchedulePackage.PROPERTY_DATUM__PROPERTY:
				setProperty((Property)newValue);
				return;
			case SchedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				setClassDatum((ClassDatum)newValue);
				return;
			case SchedulePackage.PROPERTY_DATUM__OPPOSITE:
				setOpposite((PropertyDatum)newValue);
				return;
			case SchedulePackage.PROPERTY_DATUM__SUPER:
				getSuper().clear();
				getSuper().addAll((Collection<? extends PropertyDatum>)newValue);
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
			case SchedulePackage.PROPERTY_DATUM__PROPERTY:
				setProperty((Property)null);
				return;
			case SchedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				setClassDatum((ClassDatum)null);
				return;
			case SchedulePackage.PROPERTY_DATUM__OPPOSITE:
				setOpposite((PropertyDatum)null);
				return;
			case SchedulePackage.PROPERTY_DATUM__SUPER:
				getSuper().clear();
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
			case SchedulePackage.PROPERTY_DATUM__PROPERTY:
				return property != null;
			case SchedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				return getClassDatum() != null;
			case SchedulePackage.PROPERTY_DATUM__OPPOSITE:
				return opposite != null;
			case SchedulePackage.PROPERTY_DATUM__SUPER:
				return super_ != null && !super_.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		return String.valueOf(getClassDatum()) + "::" + (property != null ? property.getName() : "<null>");
	}

} //PropertyDatumImpl
