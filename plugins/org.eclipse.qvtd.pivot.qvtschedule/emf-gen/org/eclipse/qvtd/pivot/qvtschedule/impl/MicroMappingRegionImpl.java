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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MicroMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Micro Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl#getMappingRegion <em>Mapping Region</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl#getNamePrefix <em>Name Prefix</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.MicroMappingRegionImpl#getSymbolNameSuffix <em>Symbol Name Suffix</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MicroMappingRegionImpl extends MappingRegionImpl implements MicroMappingRegion {
	/**
	 * The cached value of the '{@link #getMappingRegion() <em>Mapping Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappingRegion()
	 * @generated
	 * @ordered
	 */
	protected MappingRegion mappingRegion;
	/**
	 * The default value of the '{@link #getNamePrefix() <em>Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamePrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_PREFIX_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getNamePrefix() <em>Name Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamePrefix()
	 * @generated
	 * @ordered
	 */
	protected String namePrefix = NAME_PREFIX_EDEFAULT;
	/**
	 * The default value of the '{@link #getSymbolNameSuffix() <em>Symbol Name Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbolNameSuffix()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBOL_NAME_SUFFIX_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getSymbolNameSuffix() <em>Symbol Name Suffix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbolNameSuffix()
	 * @generated
	 * @ordered
	 */
	protected String symbolNameSuffix = SYMBOL_NAME_SUFFIX_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MicroMappingRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.MICRO_MAPPING_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappingRegion getMappingRegion() {
		if (mappingRegion != null && mappingRegion.eIsProxy()) {
			InternalEObject oldMappingRegion = (InternalEObject)mappingRegion;
			mappingRegion = (MappingRegion)eResolveProxy(oldMappingRegion);
			if (mappingRegion != oldMappingRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.MICRO_MAPPING_REGION__MAPPING_REGION, oldMappingRegion, mappingRegion));
			}
		}
		return mappingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappingRegion basicGetMappingRegion() {
		return mappingRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappingRegion(MappingRegion newMappingRegion) {
		MappingRegion oldMappingRegion = mappingRegion;
		mappingRegion = newMappingRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.MICRO_MAPPING_REGION__MAPPING_REGION, oldMappingRegion, mappingRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNamePrefix() {
		return namePrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNamePrefix(String newNamePrefix) {
		String oldNamePrefix = namePrefix;
		namePrefix = newNamePrefix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.MICRO_MAPPING_REGION__NAME_PREFIX, oldNamePrefix, namePrefix));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSymbolNameSuffix() {
		return symbolNameSuffix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.MICRO_MAPPING_REGION__MAPPING_REGION:
				if (resolve) return getMappingRegion();
				return basicGetMappingRegion();
			case QVTschedulePackage.MICRO_MAPPING_REGION__NAME_PREFIX:
				return getNamePrefix();
			case QVTschedulePackage.MICRO_MAPPING_REGION__SYMBOL_NAME_SUFFIX:
				return getSymbolNameSuffix();
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
			case QVTschedulePackage.MICRO_MAPPING_REGION__MAPPING_REGION:
				setMappingRegion((MappingRegion)newValue);
				return;
			case QVTschedulePackage.MICRO_MAPPING_REGION__NAME_PREFIX:
				setNamePrefix((String)newValue);
				return;
			case QVTschedulePackage.MICRO_MAPPING_REGION__SYMBOL_NAME_SUFFIX:
				setSymbolNameSuffix((String)newValue);
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
			case QVTschedulePackage.MICRO_MAPPING_REGION__MAPPING_REGION:
				setMappingRegion((MappingRegion)null);
				return;
			case QVTschedulePackage.MICRO_MAPPING_REGION__NAME_PREFIX:
				setNamePrefix(NAME_PREFIX_EDEFAULT);
				return;
			case QVTschedulePackage.MICRO_MAPPING_REGION__SYMBOL_NAME_SUFFIX:
				setSymbolNameSuffix(SYMBOL_NAME_SUFFIX_EDEFAULT);
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
			case QVTschedulePackage.MICRO_MAPPING_REGION__MAPPING_REGION:
				return mappingRegion != null;
			case QVTschedulePackage.MICRO_MAPPING_REGION__NAME_PREFIX:
				return NAME_PREFIX_EDEFAULT == null ? namePrefix != null : !NAME_PREFIX_EDEFAULT.equals(namePrefix);
			case QVTschedulePackage.MICRO_MAPPING_REGION__SYMBOL_NAME_SUFFIX:
				return SYMBOL_NAME_SUFFIX_EDEFAULT == null ? symbolNameSuffix != null : !SYMBOL_NAME_SUFFIX_EDEFAULT.equals(symbolNameSuffix);
		}
		return super.eIsSet(featureID);
	}

	@Override
	public @NonNull String toString() {
		return super.toString();
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitMicroMappingRegion(this);
	}

	@Override
	public @NonNull String getName() {
		return namePrefix + " " + mappingRegion.getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSymbolNameSuffix(String newSymbolNameSuffix) {
		String oldSymbolNameSuffix = symbolNameSuffix;
		symbolNameSuffix = newSymbolNameSuffix;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.MICRO_MAPPING_REGION__SYMBOL_NAME_SUFFIX, oldSymbolNameSuffix, symbolNameSuffix));
	}
} //MicroMappingRegionImpl
