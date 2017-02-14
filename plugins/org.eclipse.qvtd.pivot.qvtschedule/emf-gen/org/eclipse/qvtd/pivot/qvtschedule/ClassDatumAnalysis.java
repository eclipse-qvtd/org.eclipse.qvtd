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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;

/**
 * @generated
 */
public interface ClassDatumAnalysis extends Element
{
	void addConsumption(@NonNull MappingRegion consumer, @NonNull Node consumingNode);
	void addIntroduction(@NonNull Region introducer, @NonNull Node introducingNode);
	void addProduction(@NonNull MappingRegion producer, @NonNull Node producingNode);
	@NonNull ClassDatum getClassDatum();
	@NonNull CompleteClass getCompleteClass();
	List<MappingRegion> getConsumingRegions();
	@NonNull DomainUsage getDomainUsage();
	@NonNull ClassDatum getElementalClassDatum();
	List<Mapping> getProducedBy();
	List<Mapping> getRequiredBy();
	List<ClassDatumAnalysis> getSuperClassDatumAnalyses();
	@NonNull TypedModel getTypedModel();
}