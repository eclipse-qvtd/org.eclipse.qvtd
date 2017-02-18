/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ModelImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingAction;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getLoadingRegion <em>Loading Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getScheduledRegion <em>Scheduled Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getClassDatums <em>Class Datums</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getOtherMappingRegions <em>Other Mapping Regions</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getMappingActions <em>Mapping Actions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScheduleModelImpl extends ModelImpl implements ScheduleModel {
	/**
	 * The cached value of the '{@link #getLoadingRegion() <em>Loading Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoadingRegion()
	 * @generated
	 * @ordered
	 */
	protected LoadingRegion loadingRegion;
	/**
	 * The cached value of the '{@link #getScheduledRegion() <em>Scheduled Region</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScheduledRegion()
	 * @generated
	 * @ordered
	 */
	protected ScheduledRegion scheduledRegion;
	/**
	 * The cached value of the '{@link #getClassDatums() <em>Class Datums</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassDatums()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassDatum> classDatums;
	/**
	 * The cached value of the '{@link #getOtherMappingRegions() <em>Other Mapping Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOtherMappingRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingRegion> otherMappingRegions;
	/**
	 * The cached value of the '{@link #getMappingActions() <em>Mapping Actions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingActions()
	 * @generated
	 * @ordered
	 */
	protected EList<MappingAction> mappingActions;
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
	public LoadingRegion getLoadingRegion() {
		if (loadingRegion != null && loadingRegion.eIsProxy()) {
			InternalEObject oldLoadingRegion = (InternalEObject)loadingRegion;
			loadingRegion = (LoadingRegion)eResolveProxy(oldLoadingRegion);
			if (loadingRegion != oldLoadingRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION, oldLoadingRegion, loadingRegion));
			}
		}
		return loadingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoadingRegion basicGetLoadingRegion() {
		return loadingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoadingRegion(LoadingRegion newLoadingRegion) {
		LoadingRegion oldLoadingRegion = loadingRegion;
		loadingRegion = newLoadingRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION, oldLoadingRegion, loadingRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScheduledRegion getScheduledRegion() {
		return scheduledRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetScheduledRegion(ScheduledRegion newScheduledRegion, NotificationChain msgs) {
		ScheduledRegion oldScheduledRegion = scheduledRegion;
		scheduledRegion = newScheduledRegion;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION, oldScheduledRegion, newScheduledRegion);
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
	public void setScheduledRegion(ScheduledRegion newScheduledRegion) {
		if (newScheduledRegion != scheduledRegion) {
			NotificationChain msgs = null;
			if (scheduledRegion != null)
				msgs = ((InternalEObject)scheduledRegion).eInverseRemove(this, QVTschedulePackage.SCHEDULED_REGION__SCHEDULE_MODEL, ScheduledRegion.class, msgs);
			if (newScheduledRegion != null)
				msgs = ((InternalEObject)newScheduledRegion).eInverseAdd(this, QVTschedulePackage.SCHEDULED_REGION__SCHEDULE_MODEL, ScheduledRegion.class, msgs);
			msgs = basicSetScheduledRegion(newScheduledRegion, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION, newScheduledRegion, newScheduledRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ClassDatum> getClassDatums() {
		if (classDatums == null) {
			classDatums = new EObjectContainmentWithInverseEList<ClassDatum>(ClassDatum.class, this, QVTschedulePackage.SCHEDULE_MODEL__CLASS_DATUMS, QVTschedulePackage.CLASS_DATUM__SCHEDULE_MODEL);
		}
		return classDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingRegion> getOtherMappingRegions() {
		if (otherMappingRegions == null) {
			otherMappingRegions = new EObjectContainmentEList<MappingRegion>(MappingRegion.class, this, QVTschedulePackage.SCHEDULE_MODEL__OTHER_MAPPING_REGIONS);
		}
		return otherMappingRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MappingAction> getMappingActions() {
		if (mappingActions == null) {
			mappingActions = new EObjectContainmentWithInverseEList<MappingAction>(MappingAction.class, this, QVTschedulePackage.SCHEDULE_MODEL__MAPPING_ACTIONS, QVTschedulePackage.MAPPING_ACTION__SCHEDULE_MODEL);
		}
		return mappingActions;
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
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				if (scheduledRegion != null)
					msgs = ((InternalEObject)scheduledRegion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION, null, msgs);
				return basicSetScheduledRegion((ScheduledRegion)otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__CLASS_DATUMS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getClassDatums()).basicAdd(otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__MAPPING_ACTIONS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getMappingActions()).basicAdd(otherEnd, msgs);
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
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				return basicSetScheduledRegion(null, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__CLASS_DATUMS:
				return ((InternalEList<?>)getClassDatums()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__OTHER_MAPPING_REGIONS:
				return ((InternalEList<?>)getOtherMappingRegions()).basicRemove(otherEnd, msgs);
			case QVTschedulePackage.SCHEDULE_MODEL__MAPPING_ACTIONS:
				return ((InternalEList<?>)getMappingActions()).basicRemove(otherEnd, msgs);
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
			case QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION:
				if (resolve) return getLoadingRegion();
				return basicGetLoadingRegion();
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				return getScheduledRegion();
			case QVTschedulePackage.SCHEDULE_MODEL__CLASS_DATUMS:
				return getClassDatums();
			case QVTschedulePackage.SCHEDULE_MODEL__OTHER_MAPPING_REGIONS:
				return getOtherMappingRegions();
			case QVTschedulePackage.SCHEDULE_MODEL__MAPPING_ACTIONS:
				return getMappingActions();
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
			case QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION:
				setLoadingRegion((LoadingRegion)newValue);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				setScheduledRegion((ScheduledRegion)newValue);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__CLASS_DATUMS:
				getClassDatums().clear();
				getClassDatums().addAll((Collection<? extends ClassDatum>)newValue);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__OTHER_MAPPING_REGIONS:
				getOtherMappingRegions().clear();
				getOtherMappingRegions().addAll((Collection<? extends MappingRegion>)newValue);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__MAPPING_ACTIONS:
				getMappingActions().clear();
				getMappingActions().addAll((Collection<? extends MappingAction>)newValue);
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
			case QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION:
				setLoadingRegion((LoadingRegion)null);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				setScheduledRegion((ScheduledRegion)null);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__CLASS_DATUMS:
				getClassDatums().clear();
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__OTHER_MAPPING_REGIONS:
				getOtherMappingRegions().clear();
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__MAPPING_ACTIONS:
				getMappingActions().clear();
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
			case QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION:
				return loadingRegion != null;
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				return scheduledRegion != null;
			case QVTschedulePackage.SCHEDULE_MODEL__CLASS_DATUMS:
				return classDatums != null && !classDatums.isEmpty();
			case QVTschedulePackage.SCHEDULE_MODEL__OTHER_MAPPING_REGIONS:
				return otherMappingRegions != null && !otherMappingRegions.isEmpty();
			case QVTschedulePackage.SCHEDULE_MODEL__MAPPING_ACTIONS:
				return mappingActions != null && !mappingActions.isEmpty();
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
