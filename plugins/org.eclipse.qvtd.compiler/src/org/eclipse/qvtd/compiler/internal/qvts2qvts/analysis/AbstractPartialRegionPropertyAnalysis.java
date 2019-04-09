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
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class or property.
 */
public abstract class AbstractPartialRegionPropertyAnalysis<PRA extends PartialRegionsAnalysis> extends AbstractPartialRegionElementAnalysis<@NonNull PRA> implements PartialRegionPropertyAnalysis<@NonNull PRA>
{
	protected final @NonNull PartialRegionClassAnalysis<PRA> traceClassAnalysis;
	protected final @NonNull PropertyDatum tracePropertyDatum;

	protected AbstractPartialRegionPropertyAnalysis(@NonNull PartialRegionClassAnalysis<PRA> traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		this.traceClassAnalysis = traceClassAnalysis;
		this.tracePropertyDatum = tracePropertyDatum;
	}

	@Override
	public String getName() {
		return tracePropertyDatum.getName();
	}

	@Override
	public @NonNull PropertyDatum getPropertyDatum() {
		return tracePropertyDatum;
	}

	public @NonNull PartialRegionClassAnalysis<PRA> getTraceClassAnalysis() {
		return traceClassAnalysis;
	}

	public @NonNull Property getTraceProperty() {
		return QVTscheduleUtil.getReferredProperty(tracePropertyDatum);
	}

	@Override
	public String toString() {
		return tracePropertyDatum.toString();
	}
}
