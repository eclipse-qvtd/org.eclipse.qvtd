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

import org.eclipse.emf.ecore.EClass;

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
 *
 * @generated
 */
public class MicroMappingRegionImpl extends MappingRegionImpl implements MicroMappingRegion {
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
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitMicroMappingRegion(this);
	}

	private MappingRegion mappingRegion;
	private String namePrefix;
	private String symbolSuffix;

	public MicroMappingRegionImpl(@NonNull MappingRegion mappingRegion, @NonNull String namePrefix, @NonNull String symbolSuffix) {
		super(mappingRegion.getMultiRegion());
		assert !(mappingRegion instanceof MicroMappingRegion);
		this.mappingRegion = mappingRegion;
		this.namePrefix = namePrefix;
		this.symbolSuffix = symbolSuffix;
	}

	@Override
	public @NonNull String getName() {
		return namePrefix + " " + mappingRegion.getName();
	}

	@Override
	protected @NonNull String getSymbolNameSuffix() {
		return symbolSuffix;
	}
} //MicroMappingRegionImpl
