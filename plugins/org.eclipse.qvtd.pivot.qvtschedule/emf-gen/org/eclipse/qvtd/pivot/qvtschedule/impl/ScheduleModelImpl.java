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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.internal.ModelImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Symbolable;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Scheduler Constants</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getCompleteModel <em>Complete Model</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getLoadingRegion <em>Loading Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getScheduledRegion <em>Scheduled Region</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScheduleModelImpl extends ModelImpl implements ScheduleModel {
	/**
	 * The cached value of the '{@link #getCompleteModel() <em>Complete Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCompleteModel()
	 * @generated
	 * @ordered
	 */
	protected CompleteModel completeModel;
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
	public CompleteModel getCompleteModel() {
		if (completeModel != null && completeModel.eIsProxy()) {
			InternalEObject oldCompleteModel = (InternalEObject)completeModel;
			completeModel = (CompleteModel)eResolveProxy(oldCompleteModel);
			if (completeModel != oldCompleteModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.SCHEDULE_MODEL__COMPLETE_MODEL, oldCompleteModel, completeModel));
			}
		}
		return completeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteModel basicGetCompleteModel() {
		return completeModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCompleteModel(CompleteModel newCompleteModel) {
		CompleteModel oldCompleteModel = completeModel;
		completeModel = newCompleteModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.SCHEDULE_MODEL__COMPLETE_MODEL, oldCompleteModel, completeModel));
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
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				if (scheduledRegion != null)
					msgs = ((InternalEObject)scheduledRegion).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION, null, msgs);
				return basicSetScheduledRegion((ScheduledRegion)otherEnd, msgs);
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
			case QVTschedulePackage.SCHEDULE_MODEL__COMPLETE_MODEL:
				if (resolve) return getCompleteModel();
				return basicGetCompleteModel();
			case QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION:
				if (resolve) return getLoadingRegion();
				return basicGetLoadingRegion();
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				return getScheduledRegion();
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
			case QVTschedulePackage.SCHEDULE_MODEL__COMPLETE_MODEL:
				setCompleteModel((CompleteModel)newValue);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION:
				setLoadingRegion((LoadingRegion)newValue);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				setScheduledRegion((ScheduledRegion)newValue);
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
			case QVTschedulePackage.SCHEDULE_MODEL__COMPLETE_MODEL:
				setCompleteModel((CompleteModel)null);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION:
				setLoadingRegion((LoadingRegion)null);
				return;
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				setScheduledRegion((ScheduledRegion)null);
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
			case QVTschedulePackage.SCHEDULE_MODEL__COMPLETE_MODEL:
				return completeModel != null;
			case QVTschedulePackage.SCHEDULE_MODEL__LOADING_REGION:
				return loadingRegion != null;
			case QVTschedulePackage.SCHEDULE_MODEL__SCHEDULED_REGION:
				return scheduledRegion != null;
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

	@Override
	public void addRegionError(@NonNull Region region,
			@NonNull String messageTemplate, Object... bindings) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(
			@NonNull ClassDatum classDatum) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull Property getCastProperty(@NonNull Type type) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull ClassDatum getClassDatum(org.eclipse.ocl.pivot.@NonNull Class asType,
			@NonNull TypedModel typedModel) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull ClassDatum getClassDatum(@NonNull TypedElement typedElement) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull RootDomainUsageAnalysis getDomainAnalysis() {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull DomainUsage getDomainUsage(@NonNull Element element) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull EnvironmentFactory getEnvironmentFactory() {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull Property getIterateProperty(@NonNull Type type) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull StandardLibrary getStandardLibrary() {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull StandardLibraryHelper getStandardLibraryHelper() {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public boolean isDirty(@NonNull Property property) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public boolean isNoLateConsumerMerge() {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public @NonNull String reserveSymbolName(
			@NonNull SymbolNameBuilder symbolNameBuilder,
			@NonNull Symbolable symbolable) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public void writeCallDOTfile(@NonNull ScheduledRegion region,
			@NonNull String suffix) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public void writeCallGraphMLfile(@NonNull ScheduledRegion region,
			@NonNull String suffix) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public void writeDOTfile(@NonNull Region region, @Nullable String suffix) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public void writeGraphMLfile(@NonNull Region region,
			@Nullable String suffix) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public void writeRegionDOTfile(@NonNull ScheduledRegion region,
			@NonNull String suffix) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}

	@Override
	public void writeRegionGraphMLfile(@NonNull ScheduledRegion region,
			@NonNull String suffix) {
		throw new UnsupportedOperationException();		// FIXME move to caller
	}
} //ScheduleModelImpl
