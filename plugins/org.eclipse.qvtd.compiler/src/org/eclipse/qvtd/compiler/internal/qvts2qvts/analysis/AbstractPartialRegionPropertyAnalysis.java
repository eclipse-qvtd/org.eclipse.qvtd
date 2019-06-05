/*******************************************************************************
 * Copyright (c) 2016, 2019 Willink Transformations and others.
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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * Each ClassAnalysis identifies the usage of one middle trace class or property.
 */
public abstract class AbstractPartialRegionPropertyAnalysis<@NonNull PRA extends PartialRegionsAnalysis<@NonNull PRA>> extends AbstractPartialRegionElementAnalysis<@NonNull PRA> implements PartialRegionPropertyAnalysis<@NonNull PRA>
{
	protected final @NonNull PartialRegionsAnalysis<@NonNull PRA> partialRegionsAnalysis;
	protected final @NonNull PartialRegionClassAnalysis<PRA> classAnalysis;
	protected final @NonNull PropertyDatum propertyDatum;

	protected AbstractPartialRegionPropertyAnalysis(@NonNull PartialRegionsAnalysis<@NonNull PRA> partialRegionsAnalysis, @NonNull PartialRegionClassAnalysis<PRA> classAnalysis, @NonNull PropertyDatum propertyDatum) {
		this.partialRegionsAnalysis = partialRegionsAnalysis;
		this.classAnalysis = classAnalysis;
		this.propertyDatum = propertyDatum;
		//	assert propertyDatum.getReferredTypedModel() == partialRegionsAnalysis.getScheduleManager().getTraceTypedModel();
		//		ClassDatum classDatum = QVTscheduleUtil.getOwningClassDatum(propertyDatum);
		//	assert partialRegionsAnalysis.getClassAnalysis(QVTscheduleUtil.getOwningClassDatum(propertyDatum)) == classAnalysis;
	}

	public @NonNull PartialRegionClassAnalysis<PRA> getClassAnalysis() {
		return classAnalysis;
	}

	@Override
	public String getName() {
		return propertyDatum.getName();
	}

	public @NonNull Property getProperty() {
		return QVTscheduleUtil.getReferredProperty(propertyDatum);
	}

	@Override
	public @NonNull PropertyDatum getPropertyDatum() {
		return propertyDatum;
	}

	public @NonNull Iterable<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> getSuperPropertyAnalyses() {
		List<@NonNull PartialRegionPropertyAnalysis<@NonNull PRA>> propertyAnalyses = new ArrayList<>();
		//		ClassDatum classDatum = QVTscheduleUtil.getOwningClassDatum(propertyDatum);
		//		ClassAnalysis<@NonNull RA> classAnalysis = regionsAnalysis.getClassAnalysis(classDatum);
		for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> superClassAnalysis : classAnalysis.getSuperClassAnalyses()) {
			ClassDatum superClassDatum = superClassAnalysis.getClassDatum();
			PropertyDatum propertyDatum = NameUtil.getNameable(superClassDatum.getOwnedPropertyDatums(), getName());		// FIXME avoid 'name' usage - use propertyDatum(.referredProperty)
			if (propertyDatum != null) {
				PartialRegionPropertyAnalysis<@NonNull PRA> propertyAnalysis = partialRegionsAnalysis.basicGetPropertyAnalysis(propertyDatum);	// FIXME is missing acceptable
				if ((propertyAnalysis != null) && !propertyAnalyses.contains(propertyAnalysis)) {
					propertyAnalyses.add(propertyAnalysis);
				}
			}
		}
		assert propertyAnalyses.contains(this);
		return propertyAnalyses;
	}

	@Override
	public String toString() {
		return propertyDatum.toString();
	}
}
