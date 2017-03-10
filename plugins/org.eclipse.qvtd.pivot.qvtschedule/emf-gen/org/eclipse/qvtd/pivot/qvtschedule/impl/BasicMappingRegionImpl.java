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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl#getReferredMapping <em>Referred Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BasicMappingRegionImpl extends MappingRegionImpl implements BasicMappingRegion {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReferredMapping() <em>Referred Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferredMapping()
	 * @generated
	 * @ordered
	 */
	protected Mapping referredMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BasicMappingRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.BASIC_MAPPING_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case QVTschedulePackage.BASIC_MAPPING_REGION__NAME:
				return getName();
			case QVTschedulePackage.BASIC_MAPPING_REGION__REFERRED_MAPPING:
				if (resolve) return getReferredMapping();
				return basicGetReferredMapping();
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
			case QVTschedulePackage.BASIC_MAPPING_REGION__REFERRED_MAPPING:
				setReferredMapping((Mapping)newValue);
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
			case QVTschedulePackage.BASIC_MAPPING_REGION__REFERRED_MAPPING:
				setReferredMapping((Mapping)null);
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
			case QVTschedulePackage.BASIC_MAPPING_REGION__NAME:
				return NAME_EDEFAULT == null ? getName() != null : !NAME_EDEFAULT.equals(getName());
			case QVTschedulePackage.BASIC_MAPPING_REGION__REFERRED_MAPPING:
				return referredMapping != null;
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
		return (R) ((QVTscheduleVisitor<?>)visitor).visitBasicMappingRegion(this);
	}

	/**
	 * The node for each navigable VariableDeclaration.
	 */
	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> variable2node = new HashMap<>();

	@Override
	public void addVariableNode(@NonNull VariableDeclaration variable, @NonNull Node node) {
		variable2node.put(variable, node);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getName() {
		return QVTscheduleUtil.getReferredMapping(this).getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Mapping getReferredMapping() {
		if (referredMapping != null && referredMapping.eIsProxy()) {
			InternalEObject oldReferredMapping = (InternalEObject)referredMapping;
			referredMapping = (Mapping)eResolveProxy(oldReferredMapping);
			if (referredMapping != oldReferredMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, QVTschedulePackage.BASIC_MAPPING_REGION__REFERRED_MAPPING, oldReferredMapping, referredMapping));
			}
		}
		return referredMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping basicGetReferredMapping() {
		return referredMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReferredMapping(Mapping newReferredMapping) {
		Mapping oldReferredMapping = referredMapping;
		referredMapping = newReferredMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QVTschedulePackage.BASIC_MAPPING_REGION__REFERRED_MAPPING, oldReferredMapping, referredMapping));
	}

	public @Nullable Node getNode(@NonNull TypedElement typedElement) {
		return variable2node.get(typedElement);
	}
} //BasicMappingRegionImpl
