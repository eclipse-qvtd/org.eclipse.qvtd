/**
 * <copyright>
 *
 * Copyright (c) 2013, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ModelImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameAdapter;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler Constants</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getOwnedClassDatums <em>Owned Class Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getOwnedMappingRegions <em>Owned Mapping Regions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getOwnedOperationRegions <em>Owned Operation Regions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getOwnedScheduledRegions <em>Owned Scheduled Regions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScheduleModelImpl extends ModelImpl implements ScheduleModel {
	/**
	 * The cached value of the '{@link #getOwnedClassDatums() <em>Owned Class Datums</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedClassDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassDatum> ownedClassDatums;
	/**
	 * The cached value of the '{@link #getOwnedMappingRegions() <em>Owned Mapping Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMappingRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingRegion> ownedMappingRegions;
	/**
	 * The cached value of the '{@link #getOwnedOperationRegions() <em>Owned Operation Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOperationRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<OperationRegion> ownedOperationRegions;
	/**
	 * The cached value of the '{@link #getOwnedScheduledRegions() <em>Owned Scheduled Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedScheduledRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<ScheduledRegion> ownedScheduledRegions;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScheduleModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.SCHEDULE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassDatum> getOwnedClassDatums() {
		if (ownedClassDatums == null) {
			ownedClassDatums = new EObjectContainmentWithInverseEList<ClassDatum>(ClassDatum.class, this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_CLASS_DATUMS, QVTschedulePackage.CLASS_DATUM__OWNING_SCHEDULE_MODEL);
		}
		return ownedClassDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OperationRegion> getOwnedOperationRegions() {
		if (ownedOperationRegions == null) {
			ownedOperationRegions = new EObjectContainmentWithInverseEList<OperationRegion>(OperationRegion.class, this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS, QVTschedulePackage.OPERATION_REGION__OWNING_SCHEDULE_MODEL);
		}
		return ownedOperationRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ScheduledRegion> getOwnedScheduledRegions() {
		if (ownedScheduledRegions == null) {
			ownedScheduledRegions = new EObjectContainmentWithInverseEList<ScheduledRegion>(ScheduledRegion.class, this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS, QVTschedulePackage.SCHEDULED_REGION__OWNING_SCHEDULE_MODEL);
		}
		return ownedScheduledRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingRegion> getOwnedMappingRegions() {
		if (ownedMappingRegions == null) {
			ownedMappingRegions = new EObjectContainmentWithInverseEList<MappingRegion>(MappingRegion.class, this, QVTschedulePackage.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS, QVTschedulePackage.MAPPING_REGION__OWNING_SCHEDULE_MODEL);
		}
		return ownedMappingRegions;
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
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_CLASS_DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedClassDatums()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMappingRegions()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperationRegions()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedScheduledRegions()).basicAdd(otherEnd, msgs);
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
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_CLASS_DATUMS:
				return ((InternalEList<?>)getOwnedClassDatums()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS:
				return ((InternalEList<?>)getOwnedMappingRegions()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS:
				return ((InternalEList<?>)getOwnedOperationRegions()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS:
				return ((InternalEList<?>)getOwnedScheduledRegions()).basicRemove(otherEnd, msgs);
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
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_CLASS_DATUMS:
				return getOwnedClassDatums();
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS:
				return getOwnedMappingRegions();
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS:
				return getOwnedOperationRegions();
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS:
				return getOwnedScheduledRegions();
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
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_CLASS_DATUMS:
				getOwnedClassDatums().clear();
				getOwnedClassDatums().addAll((Collection<? extends ClassDatum>)newValue);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS:
				getOwnedMappingRegions().clear();
				getOwnedMappingRegions().addAll((Collection<? extends MappingRegion>)newValue);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS:
				getOwnedOperationRegions().clear();
				getOwnedOperationRegions().addAll((Collection<? extends OperationRegion>)newValue);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS:
				getOwnedScheduledRegions().clear();
				getOwnedScheduledRegions().addAll((Collection<? extends ScheduledRegion>)newValue);
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
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_CLASS_DATUMS:
				getOwnedClassDatums().clear();
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS:
				getOwnedMappingRegions().clear();
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS:
				getOwnedOperationRegions().clear();
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS:
				getOwnedScheduledRegions().clear();
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
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_CLASS_DATUMS:
				return ownedClassDatums != null && !ownedClassDatums.isEmpty();
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_MAPPING_REGIONS:
				return ownedMappingRegions != null && !ownedMappingRegions.isEmpty();
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_OPERATION_REGIONS:
				return ownedOperationRegions != null && !ownedOperationRegions.isEmpty();
			case QVTschedulePackage.SCHEDULE_MODEL__OWNED_SCHEDULED_REGIONS:
				return ownedScheduledRegions != null && !ownedScheduledRegions.isEmpty();
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitScheduleModel(this);
	}

	/**
	 * Map reserving a unique symbol name per region or connection.
	 */
	private @Nullable SymbolNameAdapter symbolNameAdapter = null;

	@Override
	public @NonNull SymbolNameAdapter getSymbolNameAdapter() {
		SymbolNameAdapter symbolNameAdapter2 = symbolNameAdapter;
		if (symbolNameAdapter2 == null) {
			symbolNameAdapter = symbolNameAdapter2 = SymbolNameAdapter.get(this);
		}
		return symbolNameAdapter2;
	}

	@Override
	public @NonNull String reserveSymbolName(@NonNull SymbolNameBuilder symbolNameBuilder, @NonNull Object object) {
		return getSymbolNameAdapter().reserveSymbolName(symbolNameBuilder, object);
	}
} //ScheduleModelImpl
