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
import org.eclipse.ocl.pivot.Element;

/**
 * <!-- begin-model-doc -->
 * The MultiRegion supervises the many Region instances that realize a transformation
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getMultiRegion()
 * @model
 * @generated
 */
public interface MultiRegion extends Element
{
	void addRegion(@NonNull Region region);
	//	@NonNull OperationRegion analyzeOperation(@NonNull OperationCallExp operationCallExp);
	@NonNull List<@NonNull Region> getActiveRegions();
	//	@NonNull MappingRegion getMappingRegion(@NonNull Mapping mapping);
	//	@NonNull Iterable<@NonNull OperationRegion> getOperationRegions();
	@NonNull SchedulerConstants getSchedulerConstants();
	void setActiveRegions(@NonNull Iterable<@NonNull ? extends Region> activeRegions);	// FIXME eliminate
}
