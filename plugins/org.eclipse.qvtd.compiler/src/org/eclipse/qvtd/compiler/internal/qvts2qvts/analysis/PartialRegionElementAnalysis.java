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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.utilities.Nameable;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class or property.
 */
public interface PartialRegionElementAnalysis<PRA extends PartialRegionsAnalysis<@NonNull PRA>> extends Nameable
{
	void addConsumer(@NonNull PartialRegionAnalysis<@NonNull PRA> consumer);
	void addProducer(@NonNull PartialRegionAnalysis<@NonNull PRA> producer);
	@NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getConsumers();
	@NonNull Iterable<@NonNull PartialRegionAnalysis<@NonNull PRA>> getProducers();
}
