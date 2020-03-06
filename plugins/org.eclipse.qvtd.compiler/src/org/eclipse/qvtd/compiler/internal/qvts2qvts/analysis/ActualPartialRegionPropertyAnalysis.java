/*******************************************************************************
 * Copyright (c) 2019, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.UniqueList;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * Each ClassAnalysis identifies the usage of one middle trace class or property.
 */
public abstract class ActualPartialRegionPropertyAnalysis<@NonNull PRA extends PartialRegionsAnalysis<@NonNull PRA>> extends AbstractPartialRegionPropertyAnalysis<@NonNull PRA>
{
	protected final @NonNull BasePartialRegionPropertyAnalysis<@NonNull PRA> basePropertyAnalysis;

	protected ActualPartialRegionPropertyAnalysis(@NonNull BasePartialRegionPropertyAnalysis<PRA> basePropertyAnalysis, @NonNull PartialRegionClassAnalysis<@NonNull PRA> classAnalysis, @NonNull PropertyDatum propertyDatum) {
		super(basePropertyAnalysis.partialRegionsAnalysis, classAnalysis, propertyDatum);
		this.basePropertyAnalysis = basePropertyAnalysis;
	}

	@Override
	public @NonNull BasePartialRegionPropertyAnalysis<@NonNull PRA> getBasePropertyAnalysis() {
		return basePropertyAnalysis;
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getCompatibleProducers() {
		UniqueList<@NonNull PartialRegionAnalysis<@NonNull PRA>> compatibleProducers = new UniqueList<>();
		ClassDatum owningClassDatum = QVTscheduleUtil.getOwningClassDatum(propertyDatum);
		ClassDatum targetClassDatum = propertyDatum.getTargetClassDatum();
		Property referredProperty = propertyDatum.getReferredProperty();
		Property oppositeProperty = referredProperty.getOpposite();
		// Many oppositePropertyDatum do not exist - too lazy / problematic symmetry
		//	PropertyDatum oppositePropertyDatum = oppositeProperty != null ? scheduleManager.getOppositePropertyDatum(propertyDatum) : null;
		for (@NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> actualPropertyAnalysis : basePropertyAnalysis.propertyDatum2propertyAnalysis.values()) {
			PropertyDatum actualPropertyDatum = actualPropertyAnalysis.getPropertyDatum();
			ClassDatum actualOwningClassDatum = QVTscheduleUtil.getOwningClassDatum(actualPropertyDatum);
			ClassDatum actualTargetClassDatum = actualPropertyDatum.getTargetClassDatum();
			Property actualProperty = actualPropertyDatum.getReferredProperty();
			//
			//	There is a distinct PropertyDatum for each direction of a bidirectional navigation,
			//	but there is only one PropertyAnalysis which might be 'backward'.
			//
			boolean isCompatible = false;
			if (actualProperty == oppositeProperty) {
				isCompatible = QVTscheduleUtil.conformsTo(owningClassDatum, actualOwningClassDatum);		// FIXME target
			}
			else {
				assert actualProperty == referredProperty : "Inconsistent producer property " + actualProperty;
				if (QVTscheduleUtil.conformsTo(actualOwningClassDatum, owningClassDatum)) {
					isCompatible = (targetClassDatum == null) || (actualTargetClassDatum == null) || QVTscheduleUtil.conformsTo(actualTargetClassDatum, targetClassDatum);
				}
			}
			if (isCompatible) {
				//	for (@NonNull PartialRegionPropertyAnalysis<@NonNull PRA> actualSuperPropertyAnalysis : actualPropertyAnalysis.basicGetSuperPropertyAnalyses()) {
				@NonNull PartialRegionPropertyAnalysis<@NonNull PRA> actualSuperPropertyAnalysis = actualPropertyAnalysis;
				for (@NonNull PartialRegionAnalysis<@NonNull PRA> actualProducer : actualSuperPropertyAnalysis.getExactProducers()) {
					compatibleProducers.add(actualProducer);
				}
				//	}
			}
		}
		assert compatibleProducers.containsAll(producers);
		return compatibleProducers;
	}
}
