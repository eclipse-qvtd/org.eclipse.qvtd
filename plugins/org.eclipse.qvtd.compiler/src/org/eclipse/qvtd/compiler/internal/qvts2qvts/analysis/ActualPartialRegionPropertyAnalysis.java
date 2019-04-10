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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;

/**
 * Each ClassAnalysis identifies the usage of one middle trace class or property.
 */
public abstract class ActualPartialRegionPropertyAnalysis<@NonNull PRA extends PartialRegionsAnalysis<@NonNull PRA>> extends AbstractPartialRegionPropertyAnalysis<@NonNull PRA>
{
	protected final @NonNull BasePartialRegionPropertyAnalysis<@NonNull PRA> basePropertyAnalysis;

	protected ActualPartialRegionPropertyAnalysis(@NonNull BasePartialRegionPropertyAnalysis<PRA> basePropertyAnalysis, @NonNull PropertyDatum propertyDatum) {
		super(basePropertyAnalysis.partialRegionsAnalysis, basePropertyAnalysis.classAnalysis, propertyDatum);
		this.basePropertyAnalysis = basePropertyAnalysis;
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getCompatibleProducers() {
		List<@NonNull PartialRegionAnalysis<@NonNull PRA>> compatibleProducers = new ArrayList<>();
		Property compatibleProperty = propertyDatum.getReferredProperty();
		ClassDatum owningClassDatum = propertyDatum.getOwningClassDatum();
		CompleteClass owningCompleteClass = owningClassDatum.getCompleteClass();
		Property compatibleOppositeProperty = compatibleProperty.getOpposite();
		for (@NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> actualPropertyAnalysis : basePropertyAnalysis.propertyDatum2propertyAnalysis.values()) {
			for (@NonNull PartialRegionAnalysis<@NonNull PRA> actualProducer : actualPropertyAnalysis.getExactProducers()) {
				boolean isCompatible = false;
				PropertyDatum actualPropertyDatum = actualPropertyAnalysis.getPropertyDatum();
				Property actualProperty = actualPropertyDatum.getReferredProperty();
				if (actualProperty == compatibleOppositeProperty) {
					isCompatible = true;
				}
				else {
					assert actualProperty == compatibleProperty;
					ClassDatum actualOwningClassDatum = actualPropertyDatum.getOwningClassDatum();
					CompleteClass actualOwningCompleteClass = actualOwningClassDatum.getCompleteClass();
					if (actualOwningCompleteClass.conformsTo(owningCompleteClass) || owningCompleteClass.conformsTo(actualOwningCompleteClass)) {
						isCompatible = true;
					}
				}
				if (isCompatible && !compatibleProducers.contains(actualProducer)) {
					compatibleProducers.add(actualProducer);
				}
			}
		}
		assert compatibleProducers.containsAll(producers);
		return compatibleProducers;
	}
}
