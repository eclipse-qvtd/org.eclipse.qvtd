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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.PropertyDatum;
import org.eclipse.qvtd.pivot.schedule.Schedule;
import org.eclipse.qvtd.pivot.schedule.SchedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.ClassDatumImpl#getCompleteClass <em>Complete Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.ClassDatumImpl#getPropertyDatums <em>Property Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.ClassDatumImpl#getSchedule <em>Schedule</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.schedule.impl.ClassDatumImpl#getSuper <em>Super</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassDatumImpl extends AbstractDatumImpl implements ClassDatum {
	/**
	 * The cached value of the '{@link #getCompleteClass() <em>Complete Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompleteClass()
	 * @generated
	 * @ordered
	 */
	protected CompleteClass completeClass;

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
	 * The cached value of the '{@link #getSuper() <em>Super</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuper()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassDatum> super_;

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
		return SchedulePackage.Literals.CLASS_DATUM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CompleteClass getCompleteClass() {
		if (completeClass != null && completeClass.eIsProxy()) {
			InternalEObject oldCompleteClass = (InternalEObject)completeClass;
			completeClass = (CompleteClass)eResolveProxy(oldCompleteClass);
			if (completeClass != oldCompleteClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SchedulePackage.CLASS_DATUM__COMPLETE_CLASS, oldCompleteClass, completeClass));
			}
		}
		return completeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteClass basicGetCompleteClass() {
		return completeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompleteClass(CompleteClass newCompleteClass) {
		CompleteClass oldCompleteClass = completeClass;
		completeClass = newCompleteClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.CLASS_DATUM__COMPLETE_CLASS, oldCompleteClass, completeClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyDatum> getPropertyDatums() {
		if (propertyDatums == null) {
			propertyDatums = new EObjectContainmentWithInverseEList<PropertyDatum>(PropertyDatum.class, this, SchedulePackage.CLASS_DATUM__PROPERTY_DATUMS, SchedulePackage.PROPERTY_DATUM__CLASS_DATUM);
		}
		return propertyDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Schedule getSchedule() {
		if (eContainerFeatureID() != SchedulePackage.CLASS_DATUM__SCHEDULE) return null;
		return (Schedule)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSchedule(Schedule newSchedule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newSchedule, SchedulePackage.CLASS_DATUM__SCHEDULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSchedule(Schedule newSchedule) {
		if (newSchedule != eInternalContainer() || (eContainerFeatureID() != SchedulePackage.CLASS_DATUM__SCHEDULE && newSchedule != null)) {
			if (EcoreUtil.isAncestor(this, newSchedule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newSchedule != null)
				msgs = ((InternalEObject)newSchedule).eInverseAdd(this, SchedulePackage.SCHEDULE__DATUMS, Schedule.class, msgs);
			msgs = basicSetSchedule(newSchedule, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SchedulePackage.CLASS_DATUM__SCHEDULE, newSchedule, newSchedule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassDatum> getSuper() {
		if (super_ == null) {
			super_ = new EObjectResolvingEList<ClassDatum>(ClassDatum.class, this, SchedulePackage.CLASS_DATUM__SUPER);
		}
		return super_;
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
			case SchedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPropertyDatums()).basicAdd(otherEnd, msgs);
			case SchedulePackage.CLASS_DATUM__SCHEDULE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetSchedule((Schedule)otherEnd, msgs);
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
			case SchedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return ((InternalEList<?>)getPropertyDatums()).basicRemove(otherEnd, msgs);
			case SchedulePackage.CLASS_DATUM__SCHEDULE:
				return basicSetSchedule(null, msgs);
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
			case SchedulePackage.CLASS_DATUM__SCHEDULE:
				return eInternalContainer().eInverseRemove(this, SchedulePackage.SCHEDULE__DATUMS, Schedule.class, msgs);
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
			case SchedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				if (resolve) return getCompleteClass();
				return basicGetCompleteClass();
			case SchedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return getPropertyDatums();
			case SchedulePackage.CLASS_DATUM__SCHEDULE:
				return getSchedule();
			case SchedulePackage.CLASS_DATUM__SUPER:
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
			case SchedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				setCompleteClass((CompleteClass)newValue);
				return;
			case SchedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				getPropertyDatums().clear();
				getPropertyDatums().addAll((Collection<? extends PropertyDatum>)newValue);
				return;
			case SchedulePackage.CLASS_DATUM__SCHEDULE:
				setSchedule((Schedule)newValue);
				return;
			case SchedulePackage.CLASS_DATUM__SUPER:
				getSuper().clear();
				getSuper().addAll((Collection<? extends ClassDatum>)newValue);
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
			case SchedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				setCompleteClass((CompleteClass)null);
				return;
			case SchedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				getPropertyDatums().clear();
				return;
			case SchedulePackage.CLASS_DATUM__SCHEDULE:
				setSchedule((Schedule)null);
				return;
			case SchedulePackage.CLASS_DATUM__SUPER:
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
			case SchedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				return completeClass != null;
			case SchedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return propertyDatums != null && !propertyDatums.isEmpty();
			case SchedulePackage.CLASS_DATUM__SCHEDULE:
				return getSchedule() != null;
			case SchedulePackage.CLASS_DATUM__SUPER:
				return super_ != null && !super_.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public String toString() {
		return completeClass.toString();
	}

} //ClassDatumImpl
