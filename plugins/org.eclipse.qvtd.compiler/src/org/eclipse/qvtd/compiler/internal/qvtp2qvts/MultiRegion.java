/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * The MultiRegion supervises the many Region instances that realize a transformation.
 */
public class MultiRegion
{
	protected final @NonNull QVTp2QVTs qvtp2qvts;

	/**
	 * The oclAsType(Type) casting property for each cast in use.
	 */
	//	private final @NonNull Map<Type, Property> type2castProperty = new HashMap<>();

	private final @NonNull List<@NonNull Region> allRegions = new ArrayList<>();

	private @NonNull List<@NonNull Region> activeRegions = Collections.emptyList();

	public MultiRegion(@NonNull QVTp2QVTs qvtp2qvts) {
		this.qvtp2qvts = qvtp2qvts;
	}

	public void addRegion(@NonNull Region region) {
		allRegions.add(region);
	}

	public @NonNull OperationRegion analyzeOperation(@NonNull OperationCallExp operationCallExp) {
		return qvtp2qvts.analyzeOperation(this, operationCallExp);
	}

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

	public @NonNull MappingRegion getMappingRegion(@NonNull AbstractAction action) {
		return qvtp2qvts.getMappingRegion(action);
	}

	public @NonNull Iterable<@NonNull OperationRegion> getOperationRegions() {
		return Iterables.filter(allRegions, OperationRegion.class);
	}

	public @NonNull SchedulerConstants getSchedulerConstants() {
		return qvtp2qvts;
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return qvtp2qvts.getStandardLibrary();
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

	public void setActiveRegions(@NonNull Iterable<@NonNull ? extends Region> activeRegions) {	// FIXME eliminate
		this.activeRegions = Lists.newArrayList(activeRegions);
	}
}
