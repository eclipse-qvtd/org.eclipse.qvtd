/**
 */
package org.eclipse.qvtd.build.qvtschedule.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.examples.pivot.Type;
import org.eclipse.qvtd.build.qvtschedule.ClassDatum;
import org.eclipse.qvtd.build.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.build.qvtschedule.qvtschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.ClassDatumImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.qvtd.build.qvtschedule.impl.ClassDatumImpl#getPropertyDatums <em>Property Datums</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassDatumImpl extends AbstractDatumImpl implements ClassDatum {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;
	/**
	 * The cached value of the '{@link #getPropertyDatums() <em>Property Datums</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<PropertyDatum> propertyDatums;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassDatumImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return qvtschedulePackage.Literals.CLASS_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && ((EObject)type).eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, qvtschedulePackage.CLASS_DATUM__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, qvtschedulePackage.CLASS_DATUM__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PropertyDatum> getPropertyDatums() {
		if (propertyDatums == null) {
			propertyDatums = new EObjectContainmentWithInverseEList<PropertyDatum>(PropertyDatum.class, this, qvtschedulePackage.CLASS_DATUM__PROPERTY_DATUMS, qvtschedulePackage.PROPERTY_DATUM__CLASS_DATUM);
		}
		return propertyDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case qvtschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPropertyDatums()).basicAdd(otherEnd, msgs);
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
			case qvtschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return ((InternalEList<?>)getPropertyDatums()).basicRemove(otherEnd, msgs);
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
			case qvtschedulePackage.CLASS_DATUM__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case qvtschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return getPropertyDatums();
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
			case qvtschedulePackage.CLASS_DATUM__TYPE:
				setType((Type)newValue);
				return;
			case qvtschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				getPropertyDatums().clear();
				getPropertyDatums().addAll((Collection<? extends PropertyDatum>)newValue);
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
			case qvtschedulePackage.CLASS_DATUM__TYPE:
				setType((Type)null);
				return;
			case qvtschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				getPropertyDatums().clear();
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
			case qvtschedulePackage.CLASS_DATUM__TYPE:
				return type != null;
			case qvtschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return propertyDatums != null && !propertyDatums.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ClassDatumImpl
