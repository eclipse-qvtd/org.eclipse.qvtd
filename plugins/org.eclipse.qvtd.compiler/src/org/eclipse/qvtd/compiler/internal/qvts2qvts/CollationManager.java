/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.LoadingRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.OriginalContentsAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;

/**
 * CollationManager supervises the collation of elements in ordered slots.
 */
public class CollationManager
{
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull OriginalContentsAnalysis originalContentsAnalysis;

	public CollationManager(@NonNull ProblemHandler problemHandler, @NonNull ScheduleManager scheduleManager, @NonNull LoadingRegionAnalysis loadingRegionAnalysis) {
		//	super(qvtm2qvts.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
		//		this.loadingRegionAnalysis = loadingRegionAnalysis;
		this.originalContentsAnalysis = scheduleManager.getOriginalContentsAnalysis();
	}

	public void createCollations(StringBuilder s, @NonNull RootRegion rootRegion, @NonNull Region region) {
		List<@NonNull PropertyDatum> collations = new ArrayList<>();
		Map<@NonNull PropertyDatum, @NonNull List<@NonNull NavigableEdge>> basePropertyDatum2newEdges = originalContentsAnalysis.getBasePropertyDatum2newEdges();
		for (@NonNull PropertyDatum basePropertyDatum : basePropertyDatum2newEdges.keySet()) {
			Property baseProperty = basePropertyDatum.getReferredProperty();
			Property oppositeProperty = baseProperty.getOpposite();
			if (oppositeProperty != null) {
				Type type = oppositeProperty.getType();
				if (type instanceof CollectionType) {
					CollectionType collectionType = (CollectionType) type;
					if (collectionType.isOrdered()) {
						List<@NonNull NavigableEdge> newEdges = basePropertyDatum2newEdges.get(basePropertyDatum);
						assert newEdges != null;
						for (@NonNull NavigableEdge navigableEdge : newEdges) {
							if (navigableEdge.isPartial()) {
								collations.add(basePropertyDatum);
								break;
							}
						}
					}
				}
			}
		}
		System.out.println("Collations: " + collations);
	}
}
