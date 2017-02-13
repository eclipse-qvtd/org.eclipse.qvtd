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
import org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Basic Mapping Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class BasicMappingRegionImpl extends MappingRegionImpl implements BasicMappingRegion {
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

	protected BasicMappingRegionImpl(@NonNull MultiRegion multiRegion) {
		super(multiRegion);
	}

} //BasicMappingRegionImpl
