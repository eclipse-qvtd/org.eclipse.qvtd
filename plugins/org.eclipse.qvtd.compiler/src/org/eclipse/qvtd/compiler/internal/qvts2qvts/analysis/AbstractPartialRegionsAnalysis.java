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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * AbstractPartialRegionsAnalysis<PRA> provides the mandatory default management of ClassDatum and PropertyDatum usage for a PartialRegionsAnalysis.
 */
public abstract class AbstractPartialRegionsAnalysis<@NonNull PRA extends PartialRegionsAnalysis<PRA>> extends QVTbaseHelper implements PartialRegionsAnalysis<PRA>
{
	/**
	 * The supervising ScheduleManager.
	 */
	protected final @NonNull ScheduleManager scheduleManager;

	/**
	 * The ClassAnalysis for each trace class.
	 */
	protected final @NonNull Map<@NonNull ClassDatum, @NonNull PartialRegionClassAnalysis<@NonNull PRA>> classDatum2classAnalysis = new HashMap<>();

	/**
	 * The PropertyAnalysis for each trace property.
	 */
	protected final @NonNull Map<@NonNull PropertyDatum, @NonNull BasePartialRegionPropertyAnalysis<@NonNull PRA>> propertyDatum2basePropertyAnalysis = new HashMap<>();
	protected final @NonNull Map<@NonNull PropertyDatum, @NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA>> propertyDatum2actualPropertyAnalysis = new HashMap<>();

	protected AbstractPartialRegionsAnalysis(@NonNull ScheduleManager scheduleManager) {
		super(scheduleManager.getEnvironmentFactory());
		this.scheduleManager = scheduleManager;
	}

	@Override
	public @NonNull PartialRegionClassAnalysis<@NonNull PRA> addConsumer(@NonNull ClassDatum classDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> consumer) {
		PartialRegionClassAnalysis<@NonNull PRA> classAnalysis = lazyCreateClassAnalysis(classDatum);
		classAnalysis.addConsumer(consumer);
		return classAnalysis;
	}

	@Override
	public @NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> addConsumer(@NonNull PropertyDatum propertyDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> consumer) {
		ActualPartialRegionPropertyAnalysis<@NonNull PRA> propertyAnalysis = lazyCreatePropertyAnalysis(propertyDatum);
		propertyAnalysis.addConsumer(consumer);
		return propertyAnalysis;
	}

	@Override
	public @NonNull PartialRegionClassAnalysis<@NonNull PRA> addProducer(@NonNull ClassDatum classDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> producer) {
		PartialRegionClassAnalysis<@NonNull PRA> classAnalysis = lazyCreateClassAnalysis(classDatum);
		classAnalysis.addProducer(producer);
		return classAnalysis;
	}

	@Override
	public @NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> addProducer(@NonNull PropertyDatum propertyDatum, @NonNull PartialRegionAnalysis<@NonNull PRA> producer) {
		//		if (this instanceof AbstractTransformationAnalysis) {		// FIXME irregular for ATL2QVTr --- why??
		ActualPartialRegionPropertyAnalysis<@NonNull PRA> propertyAnalysis = lazyCreatePropertyAnalysis(propertyDatum);
		propertyAnalysis.addProducer(producer);
		return propertyAnalysis;
		//		}
		//		for (@NonNull PropertyDatum superPropertyDatum : QVTscheduleUtil.getSuperPropertyDatums(propertyDatum)) {
		//			ActualPartialRegionPropertyAnalysis<@NonNull PRA> superPropertyAnalysis = lazyCreatePropertyAnalysis(superPropertyDatum);
		//			superPropertyAnalysis.addProducer(producer);
		//		}
		//		return getPropertyAnalysis(propertyDatum);
	}

	public @Nullable PartialRegionClassAnalysis<@NonNull PRA> basicGetClassAnalysis(@NonNull ClassDatum classDatum) {
		return classDatum2classAnalysis.get(classDatum);
	}

	@Override
	public @Nullable ActualPartialRegionPropertyAnalysis<@NonNull PRA> basicGetPropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		return propertyDatum2actualPropertyAnalysis.get(propertyDatum);
	}

	protected void computeTraceClassDiscrimination() throws CompilerChainException {
		for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> classAnalysis : classDatum2classAnalysis.values()) {
			classAnalysis.discriminate();
		}
	}

	public void computeTraceClassInheritance() {
		Set<@NonNull ClassDatum> missingClassDatums = new HashSet<>();
		for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> subClassRegionAnalysis : classDatum2classAnalysis.values()) {
			ClassDatum classDatum = subClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					PartialRegionClassAnalysis<@NonNull PRA> superClassRegionAnalysis = classDatum2classAnalysis.get(superClassDatum);
					if (superClassRegionAnalysis == null) {
						missingClassDatums.add(superClassDatum);
					}
				}
			}
		}
		for (@NonNull ClassDatum missingClassDatum : missingClassDatums) {
			lazyCreateClassAnalysis(missingClassDatum);
		}
		for (@NonNull PartialRegionClassAnalysis<@NonNull PRA> subClassRegionAnalysis : classDatum2classAnalysis.values()) {
			ClassDatum classDatum = subClassRegionAnalysis.getClassDatum();
			for (@NonNull ClassDatum superClassDatum : QVTscheduleUtil.getSuperClassDatums(classDatum)) {
				if (superClassDatum != classDatum) {
					PartialRegionClassAnalysis<@NonNull PRA> superClassRegionAnalysis = classDatum2classAnalysis.get(superClassDatum);
					assert superClassRegionAnalysis != null;
					superClassRegionAnalysis.addSubClassAnalysis(subClassRegionAnalysis);
					subClassRegionAnalysis.addSuperClassAnalysis(superClassRegionAnalysis);
				}
			}
		}
	}

	protected abstract @NonNull PartialRegionClassAnalysis<@NonNull PRA> createClassAnalysis(@NonNull ClassDatum classDatum);

	protected @NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> createPropertyAnalysis(@NonNull PartialRegionClassAnalysis<@NonNull PRA> classAnalysis, @NonNull PropertyDatum propertyDatum) {
		ActualPartialRegionPropertyAnalysis<@NonNull PRA> propertyAnalysis = propertyDatum2actualPropertyAnalysis.get(propertyDatum);
		assert propertyAnalysis == null;
		PropertyDatum basePropertyDatum = scheduleManager.getBasePropertyDatum(propertyDatum);
		BasePartialRegionPropertyAnalysis<@NonNull PRA> basePropertyAnalysis = propertyDatum2basePropertyAnalysis.get(basePropertyDatum);
		if (basePropertyAnalysis == null) {
			ClassDatum baseClassDatum = QVTscheduleUtil.getOwningClassDatum(basePropertyDatum);
			PartialRegionClassAnalysis<@NonNull PRA> baseClassAnalysis = lazyCreateClassAnalysis(baseClassDatum);
			basePropertyAnalysis = new BasePartialRegionPropertyAnalysis<@NonNull PRA>(this, baseClassAnalysis, basePropertyDatum);
			propertyDatum2basePropertyAnalysis.put(basePropertyDatum, basePropertyAnalysis);
		}
		propertyAnalysis = basePropertyAnalysis.createPropertyAnalysis(classAnalysis, propertyDatum);
		propertyDatum2actualPropertyAnalysis.put(propertyDatum, propertyAnalysis);
		return propertyAnalysis;
	}

	@Override
	public @NonNull PartialRegionClassAnalysis<@NonNull PRA> getClassAnalysis(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum2classAnalysis.get(classDatum));
	}

	@Override
	public @NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> getPropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		return ClassUtil.nonNullState(propertyDatum2actualPropertyAnalysis.get(propertyDatum));
	}

	@Override
	public @NonNull ScheduleManager getScheduleManager() {
		return scheduleManager;
	}

	private @NonNull PartialRegionClassAnalysis<@NonNull PRA> lazyCreateClassAnalysis(@NonNull ClassDatum classDatum) {
		PartialRegionClassAnalysis<@NonNull PRA> classAnalysis = classDatum2classAnalysis.get(classDatum);
		if (classAnalysis == null) {
			classAnalysis = createClassAnalysis(classDatum);
			classDatum2classAnalysis.put(classDatum, classAnalysis);
		}
		return classAnalysis;
	}

	private @NonNull ActualPartialRegionPropertyAnalysis<@NonNull PRA> lazyCreatePropertyAnalysis(@NonNull PropertyDatum propertyDatum) {
		ActualPartialRegionPropertyAnalysis<@NonNull PRA> propertyAnalysis = propertyDatum2actualPropertyAnalysis.get(propertyDatum);
		if (propertyAnalysis == null) {
			ClassDatum classDatum = QVTscheduleUtil.getOwningClassDatum(propertyDatum);
			PartialRegionClassAnalysis<@NonNull PRA> classAnalysis = lazyCreateClassAnalysis(classDatum);
			propertyAnalysis = createPropertyAnalysis(classAnalysis, propertyDatum);
			//	propertyDatum2propertyAnalysis.put(propertyDatum, propertyAnalysis);
		}
		return propertyAnalysis;
	}
}