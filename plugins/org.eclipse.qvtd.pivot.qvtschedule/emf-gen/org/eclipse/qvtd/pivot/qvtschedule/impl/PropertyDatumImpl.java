/*******************************************************************************
 * Copyright (c) 2015, 2021 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
/**
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.Collection;

import java.util.List;
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
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl#isKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.PropertyDatumImpl#getTargetClassDatum <em>Target Class Datum</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PropertyDatumImpl extends AbstractDatumImpl implements PropertyDatum {
	/**
	 * The number of structural features of the '<em>Property Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTY_DATUM_FEATURE_COUNT = AbstractDatumImpl.ABSTRACT_DATUM_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Property Datum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PROPERTY_DATUM_OPERATION_COUNT = AbstractDatumImpl.ABSTRACT_DATUM_OPERATION_COUNT + 0;

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
	 * The default value of the '{@link #isKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKey()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isKey() <em>Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKey()
	 * @generated
	 * @ordered
	 */
	protected boolean key = KEY_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetClassDatum() <em>Target Class Datum</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetClassDatum()
	 * @generated
	 * @ordered
	 */
	protected ClassDatum targetClassDatum;

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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, oldOpposite, opposite));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0, oldOpposite, opposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassDatum getOwningClassDatum() {
		if (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1)) return null;
		return (ClassDatum)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningClassDatum(ClassDatum newOwningClassDatum, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningClassDatum, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwningClassDatum(ClassDatum newOwningClassDatum) {
		if (newOwningClassDatum != eInternalContainer() || (eContainerFeatureID() != (NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1) && newOwningClassDatum != null)) {
			if (EcoreUtil.isAncestor(this, newOwningClassDatum))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningClassDatum != null)
				msgs = ((InternalEObject)newOwningClassDatum).eInverseAdd(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, ClassDatum.class, msgs);
			msgs = basicSetOwningClassDatum(newOwningClassDatum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, newOwningClassDatum, newOwningClassDatum));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, oldReferredProperty, referredProperty));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2, oldReferredProperty, referredProperty));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<PropertyDatum> getSuperPropertyDatums() {
		if (superPropertyDatums == null) {
			superPropertyDatums = new EObjectResolvingEList<PropertyDatum>(PropertyDatum.class, this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3);
		}
		return superPropertyDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKey(boolean newKey) {
		boolean oldKey = key;
		key = newKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4, oldKey, key));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassDatum getTargetClassDatum() {
		if (targetClassDatum != null && targetClassDatum.eIsProxy()) {
			InternalEObject oldTargetClassDatum = (InternalEObject)targetClassDatum;
			targetClassDatum = (ClassDatum)eResolveProxy(oldTargetClassDatum);
			if (targetClassDatum != oldTargetClassDatum) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5, oldTargetClassDatum, targetClassDatum));
			}
		}
		return targetClassDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDatum basicGetTargetClassDatum() {
		return targetClassDatum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetClassDatum(ClassDatum newTargetClassDatum) {
		ClassDatum oldTargetClassDatum = targetClassDatum;
		targetClassDatum = newTargetClassDatum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5, oldTargetClassDatum, targetClassDatum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return eInternalContainer().eInverseRemove(this, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1, ClassDatum.class, msgs);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				if (resolve) return getOpposite();
			return basicGetOpposite();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getOwningClassDatum();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				if (resolve) return getReferredProperty();
			return basicGetReferredProperty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return getSuperPropertyDatums();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return isKey();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				if (resolve) return getTargetClassDatum();
			return basicGetTargetClassDatum();
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				setOpposite((PropertyDatum)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setOwningClassDatum((ClassDatum)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setReferredProperty((Property)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				getSuperPropertyDatums().clear();
			getSuperPropertyDatums().addAll((Collection<? extends PropertyDatum>)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setKey((Boolean)newValue);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				setTargetClassDatum((ClassDatum)newValue);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				setOpposite((PropertyDatum)null);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				setOwningClassDatum((ClassDatum)null);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				setReferredProperty((Property)null);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				getSuperPropertyDatums().clear();
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				setKey(KEY_EDEFAULT);
			return;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				setTargetClassDatum((ClassDatum)null);
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
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 0:
				return opposite != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 1:
				return getOwningClassDatum() != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 2:
				return referredProperty != null;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3:
				return superPropertyDatums != null && !superPropertyDatums.isEmpty();
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 4:
				return key != KEY_EDEFAULT;
			case NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 5:
				return targetClassDatum != null;
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
		if (visitor instanceof QVTscheduleVisitor) {
			return (R) ((QVTscheduleVisitor<?>)visitor).visitPropertyDatum(this);
		}
		else {
			return super.accept(visitor);
		}
	}

	@Override
	public String toString() {
		return String.valueOf(getOwningClassDatum()) + "::" + (referredProperty != null ? referredProperty.getName() : "<null>");
	}
} //PropertyDatumImpl
