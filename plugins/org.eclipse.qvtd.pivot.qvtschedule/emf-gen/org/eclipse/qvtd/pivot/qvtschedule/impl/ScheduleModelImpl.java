/**
 * <copyright>
 *
 * Copyright (c) 2013, 2019 Willink Transformations and others.
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
import java.util.List;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.internal.ModelImpl;
import org.eclipse.ocl.pivot.internal.NamedElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
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
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduleModelImpl#getOwnedRootRegions <em>Owned Root Regions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ScheduleModelImpl extends ModelImpl implements ScheduleModel {
	/**
	 * The number of structural features of the '<em>Schedule Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SCHEDULE_MODEL_FEATURE_COUNT = ModelImpl.MODEL_FEATURE_COUNT + 4;
	/**
	 * The number of operations of the '<em>Schedule Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int SCHEDULE_MODEL_OPERATION_COUNT = ModelImpl.MODEL_OPERATION_COUNT + 0;
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
	 * The cached value of the '{@link #getOwnedRootRegions() <em>Owned Root Regions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedRootRegions()
	 * @generated
	 * @ordered
	 */
	protected EList<RootRegion> ownedRootRegions;
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
	public List<ClassDatum> getOwnedClassDatums() {
		if (ownedClassDatums == null) {
			ownedClassDatums = new EObjectContainmentWithInverseEList<ClassDatum>(ClassDatum.class, this, ModelImpl.MODEL_FEATURE_COUNT + 0, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 3);
		}
		return ownedClassDatums;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<OperationRegion> getOwnedOperationRegions() {
		if (ownedOperationRegions == null) {
			ownedOperationRegions = new EObjectContainmentWithInverseEList<OperationRegion>(OperationRegion.class, this, ModelImpl.MODEL_FEATURE_COUNT + 2, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 9);
		}
		return ownedOperationRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<RootRegion> getOwnedRootRegions() {
		if (ownedRootRegions == null) {
			ownedRootRegions = new EObjectContainmentWithInverseEList<RootRegion>(RootRegion.class, this, ModelImpl.MODEL_FEATURE_COUNT + 3, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 8);
		}
		return ownedRootRegions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<MappingRegion> getOwnedMappingRegions() {
		if (ownedMappingRegions == null) {
			ownedMappingRegions = new EObjectContainmentWithInverseEList<MappingRegion>(MappingRegion.class, this, ModelImpl.MODEL_FEATURE_COUNT + 1, NamedElementImpl.NAMED_ELEMENT_FEATURE_COUNT + 7);
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
			case ModelImpl.MODEL_FEATURE_COUNT + 0:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedClassDatums()).basicAdd(otherEnd, msgs);
			case ModelImpl.MODEL_FEATURE_COUNT + 1:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedMappingRegions()).basicAdd(otherEnd, msgs);
			case ModelImpl.MODEL_FEATURE_COUNT + 2:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedOperationRegions()).basicAdd(otherEnd, msgs);
			case ModelImpl.MODEL_FEATURE_COUNT + 3:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOwnedRootRegions()).basicAdd(otherEnd, msgs);
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
			case ModelImpl.MODEL_FEATURE_COUNT + 0:
				return ((InternalEList<?>)getOwnedClassDatums()).basicRemove(otherEnd, msgs);
			case ModelImpl.MODEL_FEATURE_COUNT + 1:
				return ((InternalEList<?>)getOwnedMappingRegions()).basicRemove(otherEnd, msgs);
			case ModelImpl.MODEL_FEATURE_COUNT + 2:
				return ((InternalEList<?>)getOwnedOperationRegions()).basicRemove(otherEnd, msgs);
			case ModelImpl.MODEL_FEATURE_COUNT + 3:
				return ((InternalEList<?>)getOwnedRootRegions()).basicRemove(otherEnd, msgs);
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
			case ModelImpl.MODEL_FEATURE_COUNT + 0:
				return getOwnedClassDatums();
			case ModelImpl.MODEL_FEATURE_COUNT + 1:
				return getOwnedMappingRegions();
			case ModelImpl.MODEL_FEATURE_COUNT + 2:
				return getOwnedOperationRegions();
			case ModelImpl.MODEL_FEATURE_COUNT + 3:
				return getOwnedRootRegions();
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
			case ModelImpl.MODEL_FEATURE_COUNT + 0:
				getOwnedClassDatums().clear();
				getOwnedClassDatums().addAll((Collection<? extends ClassDatum>)newValue);
				return;
			case ModelImpl.MODEL_FEATURE_COUNT + 1:
				getOwnedMappingRegions().clear();
				getOwnedMappingRegions().addAll((Collection<? extends MappingRegion>)newValue);
				return;
			case ModelImpl.MODEL_FEATURE_COUNT + 2:
				getOwnedOperationRegions().clear();
				getOwnedOperationRegions().addAll((Collection<? extends OperationRegion>)newValue);
				return;
			case ModelImpl.MODEL_FEATURE_COUNT + 3:
				getOwnedRootRegions().clear();
				getOwnedRootRegions().addAll((Collection<? extends RootRegion>)newValue);
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
			case ModelImpl.MODEL_FEATURE_COUNT + 0:
				getOwnedClassDatums().clear();
				return;
			case ModelImpl.MODEL_FEATURE_COUNT + 1:
				getOwnedMappingRegions().clear();
				return;
			case ModelImpl.MODEL_FEATURE_COUNT + 2:
				getOwnedOperationRegions().clear();
				return;
			case ModelImpl.MODEL_FEATURE_COUNT + 3:
				getOwnedRootRegions().clear();
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
			case ModelImpl.MODEL_FEATURE_COUNT + 0:
				return ownedClassDatums != null && !ownedClassDatums.isEmpty();
			case ModelImpl.MODEL_FEATURE_COUNT + 1:
				return ownedMappingRegions != null && !ownedMappingRegions.isEmpty();
			case ModelImpl.MODEL_FEATURE_COUNT + 2:
				return ownedOperationRegions != null && !ownedOperationRegions.isEmpty();
			case ModelImpl.MODEL_FEATURE_COUNT + 3:
				return ownedRootRegions != null && !ownedRootRegions.isEmpty();
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
			return (R) ((QVTscheduleVisitor<?>)visitor).visitScheduleModel(this);
		}
		else {
			return super.accept(visitor);
		}
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
