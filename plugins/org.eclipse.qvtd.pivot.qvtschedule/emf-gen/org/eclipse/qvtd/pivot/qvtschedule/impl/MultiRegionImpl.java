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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.internal.ElementImpl;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.qvtd.pivot.qvtschedule.MultiRegion;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.SchedulerConstants;

import org.eclipse.qvtd.pivot.qvtschedule.util.QVTscheduleVisitor;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Multi Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class MultiRegionImpl extends ElementImpl implements MultiRegion {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MultiRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QVTschedulePackage.Literals.MULTI_REGION;
	}

	/**
	 * {@inheritDoc}
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return (R) ((QVTscheduleVisitor<?>)visitor).visitMultiRegion(this);
	}

	private SchedulerConstants schedulerConstants;

	/**
	 * The oclAsType(Type) casting property for each cast in use.
	 */
	//	private final @NonNull Map<Type, Property> type2castProperty = new HashMap<>();

	private final @NonNull List<@NonNull Region> allRegions = new ArrayList<>();

	private @NonNull List<@NonNull Region> activeRegions = Collections.emptyList();

	@Override
	public void addRegion(@NonNull Region region) {
		allRegions.add(region);
	}

	@Override
	public @NonNull List<@NonNull Region> getActiveRegions() {
		return activeRegions;
	}

	/*	public @NonNull Property getCastProperty(@NonNull Type type) {
		Property castProperty = type2castProperty.get(type);
		if (castProperty == null) {
			castProperty = PivotFactory.eINSTANCE.createProperty();
			castProperty.setName("as\\n" + type.toString());
			castProperty.setType(type);
			type2castProperty.put(type, castProperty);
		}
		return castProperty;
	} */

	@Override
	public @NonNull Iterable<@NonNull OperationRegion> getOperationRegions() {
		return Iterables.filter(allRegions, OperationRegion.class);
	}

	@Override
	public @NonNull SchedulerConstants getSchedulerConstants() {
		return schedulerConstants;
	}

	/*	private @NonNull List<Region> growSequentialRegions(@NonNull List<Region> orderedRegions) {
		List<Region> regions = new ArrayList<Region>();
		for (@SuppressWarnings("null")@NonNull Region region : orderedRegions) {
			if (region.getInvokingRegion() == null) {
				SequentialRegion sequentialRegion = region.growSequentialRegion(null);
				if (sequentialRegion != null) {
					regions.add(sequentialRegion);
				}
				else {
					regions.add(region);
				}
			}
		}
		return regions;
	} */

	//	public @NonNull List<Region> identifyRegions() {
	//		List<Region> sequentialRegions = growSequentialRegions(guardedRegions);
	//		HierarchicalRegion.growHierarchicalRegions(sequentialRegions);
	//
	//		return allRegions;
	//	}

	@Override
	public void setActiveRegions(@NonNull Iterable<@NonNull ? extends Region> activeRegions) {	// FIXME eliminate
		this.activeRegions = Lists.newArrayList(activeRegions);
	}

	@Override
	public void setSchedulerConstants(@NonNull SchedulerConstants schedulerConstants) {
		this.schedulerConstants = schedulerConstants;
	}
} //MultiRegionImpl
