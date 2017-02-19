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
package org.eclipse.qvtd.pivot.qvtschedule;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.analysis.RootDomainUsageAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.SymbolNameBuilder;

/**
 * @generated
 */
public interface SchedulerConstants extends Element
{
	void addRegionError(@NonNull Region region, @NonNull String messageTemplate, Object... bindings);
	@NonNull Iterable<@NonNull PropertyDatum> getAllPropertyDatums(@NonNull ClassDatum classDatum);
	@NonNull Property getCastProperty(@NonNull Type type);
	@NonNull ClassDatum getClassDatum(org.eclipse.ocl.pivot.@NonNull Class asType, @NonNull TypedModel typedModel);
	@NonNull Iterable<ClassDatumAnalysis> getClassDatumAnalyses();
	@NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull ClassDatum classDatum);
	@NonNull ClassDatumAnalysis getClassDatumAnalysis(org.eclipse.ocl.pivot.@NonNull Class type, @NonNull TypedModel typedModel);
	@NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull CompleteClass completeClass, @NonNull TypedModel typedModel);
	@NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull TypedElement typedElement);
	@NonNull RootDomainUsageAnalysis getDomainAnalysis();
	@NonNull DomainUsage getDomainUsage(@NonNull Element element);
	@NonNull ClassDatumAnalysis getElementalClassDatumAnalysis(@NonNull Node calledNode);
	@NonNull EnvironmentFactory getEnvironmentFactory();
	@NonNull Property getIterateProperty(@NonNull Type type);
	@NonNull ClassDatumAnalysis getOclVoidClassDatumAnalysis();
	@NonNull StandardLibrary getStandardLibrary();
	@NonNull StandardLibraryHelper getStandardLibraryHelper();
	boolean isDirty(@NonNull Property property);
	boolean isNoLateConsumerMerge();
	@NonNull String reserveSymbolName(@NonNull SymbolNameBuilder symbolNameBuilder, @NonNull Symbolable symbolable);
	void writeCallDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix);
	void writeCallGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix);
	void writeDOTfile(@NonNull Region region, @Nullable String suffix);
	void writeGraphMLfile(@NonNull Region region, @Nullable String suffix);
	void writeRegionDOTfile(@NonNull ScheduledRegion region, @NonNull String suffix);
	void writeRegionGraphMLfile(@NonNull ScheduledRegion region, @NonNull String suffix);
}