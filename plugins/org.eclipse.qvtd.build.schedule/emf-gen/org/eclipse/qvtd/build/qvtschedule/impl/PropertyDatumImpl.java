/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.ocl.examples.pivot.Property;

import org.eclipse.qvtd.build.qvtschedule.ClassDatum;
import org.eclipse.qvtd.build.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Property Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.PropertyDatumImpl#getProperty <em>Property</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.PropertyDatumImpl#getClassDatum <em>Class Datum</em>}</li>
 * </ul>
 * </p>
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
		return qvtschedulePackage.Literals.PROPERTY_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Property getProperty() {
		if (property != null && ((EObject)property).eIsProxy()) {
			InternalEObject oldProperty = (InternalEObject)property;
			property = (Property)eResolveProxy(oldProperty);
			if (property != oldProperty) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.PROPERTY_DATUM__PROPERTY, oldProperty, property));
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
	public void setProperty(Property newProperty) {
		Property oldProperty = property;
		property = newProperty;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.PROPERTY_DATUM__PROPERTY, oldProperty, property));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDatum getClassDatum() {
		if (eContainerFeatureID() != qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM) return null;
		return (ClassDatum)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetClassDatum(ClassDatum newClassDatum, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newClassDatum, qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassDatum(ClassDatum newClassDatum) {
		if (newClassDatum != eInternalContainer() || (eContainerFeatureID() != qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM && newClassDatum != null)) {
			if (EcoreUtil.isAncestor(this, newClassDatum))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newClassDatum != null)
				msgs = ((InternalEObject)newClassDatum).eInverseAdd(this, qvtschedulePackage.CLASS_DATUM__PROPERTY_DATUMS, ClassDatum.class, msgs);
			msgs = basicSetClassDatum(newClassDatum, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM, newClassDatum, newClassDatum));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM:
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
			case qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM:
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
			case qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				return eInternalContainer().eInverseRemove(this, qvtschedulePackage.CLASS_DATUM__PROPERTY_DATUMS, ClassDatum.class, msgs);
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
			case qvtschedulePackage.PROPERTY_DATUM__PROPERTY:
				if (resolve) return getProperty();
				return basicGetProperty();
			case qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				return getClassDatum();
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
			case qvtschedulePackage.PROPERTY_DATUM__PROPERTY:
				setProperty((Property)newValue);
				return;
			case qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				setClassDatum((ClassDatum)newValue);
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
			case qvtschedulePackage.PROPERTY_DATUM__PROPERTY:
				setProperty((Property)null);
				return;
			case qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				setClassDatum((ClassDatum)null);
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
			case qvtschedulePackage.PROPERTY_DATUM__PROPERTY:
				return property != null;
			case qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM:
				return getClassDatum() != null;
		}
		return super.eIsSet(featureID);
	}

} //PropertyDatumImpl
