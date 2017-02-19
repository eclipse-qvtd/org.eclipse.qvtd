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
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BasicMappingRegionImpl extends MappingRegionImpl implements BasicMappingRegion {
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
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitBasicMappingRegion(this);
	}

	/**
	 * The analyzed mapping.
	 */
	private  Mapping mapping;

	public BasicMappingRegionImpl(@NonNull MultiRegion multiRegion, @NonNull Mapping mapping) {
		super(multiRegion);
		this.mapping = mapping;
		assert mapping != null;
	}

	@Override
	public void computeUtilities(@NonNull Iterable<@NonNull Node> headNodes) {
		super.computeUtilities(headNodes);
	}

	//	@Override
	public @NonNull Mapping getMapping() {
		return mapping;
	}

	@Override
	public @NonNull String getName() {
		return String.valueOf(getMapping().getName());
	}
} //BasicMappingRegionImpl
