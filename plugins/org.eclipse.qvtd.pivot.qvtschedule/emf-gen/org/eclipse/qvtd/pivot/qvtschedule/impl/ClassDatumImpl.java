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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Datum</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getCompleteClass <em>Complete Class</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getPropertyDatums <em>Property Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ClassDatumImpl#getSuperClassDatums <em>Super Class Datums</em>}</li>
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
	 * The cached value of the '{@link #getSuperClassDatums() <em>Super Class Datums</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperClassDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassDatum> superClassDatums;

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
		return QVTschedulePackage.Literals.CLASS_DATUM;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS, oldCompleteClass, completeClass));
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
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS, oldCompleteClass, completeClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<PropertyDatum> getPropertyDatums() {
		if (propertyDatums == null) {
			propertyDatums = new EObjectContainmentWithInverseEList<PropertyDatum>(PropertyDatum.class, this, QVTschedulePackage.CLASS_DATUM__PROPERTY_DATUMS, QVTschedulePackage.PROPERTY_DATUM__CLASS_DATUM);
		}
		return propertyDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassDatum> getSuperClassDatums() {
		if (superClassDatums == null) {
			superClassDatums = new EObjectResolvingEList<ClassDatum>(ClassDatum.class, this, QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS);
		}
		return superClassDatums;
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
			case QVTschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
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
			case QVTschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
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
			case QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				if (resolve) return getCompleteClass();
				return basicGetCompleteClass();
			case QVTschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return getPropertyDatums();
			case QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS:
				return getSuperClassDatums();
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
			case QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				setCompleteClass((CompleteClass)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				getPropertyDatums().clear();
				getPropertyDatums().addAll((Collection<? extends PropertyDatum>)newValue);
				return;
			case QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS:
				getSuperClassDatums().clear();
				getSuperClassDatums().addAll((Collection<? extends ClassDatum>)newValue);
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
			case QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				setCompleteClass((CompleteClass)null);
				return;
			case QVTschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				getPropertyDatums().clear();
				return;
			case QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS:
				getSuperClassDatums().clear();
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
			case QVTschedulePackage.CLASS_DATUM__COMPLETE_CLASS:
				return completeClass != null;
			case QVTschedulePackage.CLASS_DATUM__PROPERTY_DATUMS:
				return propertyDatums != null && !propertyDatums.isEmpty();
			case QVTschedulePackage.CLASS_DATUM__SUPER_CLASS_DATUMS:
				return superClassDatums != null && !superClassDatums.isEmpty();
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitClassDatum(this);
	}

	@Override
	public String toString() {
		return completeClass.toString();
	}

} //ClassDatumImpl
