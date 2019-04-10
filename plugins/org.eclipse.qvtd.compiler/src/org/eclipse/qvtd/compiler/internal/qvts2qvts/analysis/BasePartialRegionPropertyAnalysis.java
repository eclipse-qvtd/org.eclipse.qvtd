/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.analysis;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * Each ClassAnalysis identifies the usage of one middle trace class or property.
 */
public class BasePartialRegionPropertyAnalysis<@NonNull PRA extends PartialRegionsAnalysis<@NonNull PRA>> extends AbstractPartialRegionPropertyAnalysis<@NonNull PRA>
{
	protected final @NonNull Map<@NonNull PropertyDatum, @NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA>> propertyDatum2propertyAnalysis = new HashMap<>();

	public BasePartialRegionPropertyAnalysis(@NonNull PartialRegionsAnalysis<@NonNull PRA> partialRegionsAnalysis, @NonNull PartialRegionClassAnalysis<PRA> classAnalysis, @NonNull PropertyDatum propertyDatum) {
		super(partialRegionsAnalysis, classAnalysis, propertyDatum);
	}

	public @NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> createPropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		assert !propertyDatum2propertyAnalysis.containsKey(propertyDatum);
		Property property = QVTscheduleUtil.getReferredProperty(propertyDatum);
		Property oppositeProperty = property.getOpposite();
		ActualPartialRegionPropertyAnalysis<@NonNull PRA> propertyAnalysis;
		if (oppositeProperty == null) {
			if (property.isIsMany()) {
				propertyAnalysis = new OneToManyPartialRegionPropertyAnalysis<@NonNull PRA>(this, propertyDatum);
			}
			else {
				propertyAnalysis = new OneToOnePartialRegionPropertyAnalysis<@NonNull PRA>(this, propertyDatum);
			}
		}
		else if (oppositeProperty.isIsMany()) {
			if (property.isIsMany()) {
				propertyAnalysis = new OneOfManyToManyPartialRegionPropertyAnalysis<@NonNull PRA>(this, propertyDatum);
			}
			else {
				propertyAnalysis = new OneOfManyToOnePartialRegionPropertyAnalysis<@NonNull PRA>(this, propertyDatum);
			}
		}
		else {
			if (property.isIsMany()) {
				propertyAnalysis = new OneToManyPartialRegionPropertyAnalysis<@NonNull PRA>(this, propertyDatum);
			}
			else {
				propertyAnalysis = new OneToOnePartialRegionPropertyAnalysis<@NonNull PRA>(this, propertyDatum);
			}
		}
		propertyDatum2propertyAnalysis.put(propertyDatum, propertyAnalysis);
		return propertyAnalysis;
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getConsumers() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getCompatibleProducers() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getExactProducers() {
		throw new UnsupportedOperationException();
	}
}
