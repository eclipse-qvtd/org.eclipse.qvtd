/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * Each TracePropertyAnalysis identifies the usage of one middle trace property.
 */
public class TracePropertyPartitionAnalysis extends TraceElementPartitionAnalysis implements CompilerUtil.TraceProperty<@NonNull Partition, @NonNull TraceClassPartitionAnalysis, @NonNull TracePropertyPartitionAnalysis>
{
	protected final @NonNull PartitionedTransformationAnalysis partitionedTransformationAnalysis;
	protected final@NonNull TraceClassPartitionAnalysis traceClassAnalysis;
	protected final @NonNull PropertyDatum tracePropertyDatum;

	public TracePropertyPartitionAnalysis(@NonNull TransformationPartitioner transformationPartitioner, @NonNull TraceClassPartitionAnalysis traceClassAnalysis, @NonNull PropertyDatum tracePropertyDatum) {
		this.partitionedTransformationAnalysis = transformationPartitioner.getPartitionedTransformationAnalysis();
		this.traceClassAnalysis = traceClassAnalysis;
		this.tracePropertyDatum = tracePropertyDatum;
		//	assert tracePropertyDatum.getReferredTypedModel() == regionsAnalysis.getScheduleManager().getTraceTypedModel();
		//		ClassDatum traceClassDatum = QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum);
		//	assert partitionedTransformationAnalysis.getTraceClassAnalysis(QVTscheduleUtil.getOwningClassDatum(tracePropertyDatum)) == traceClassAnalysis;
	}

	@Override
	public String getName() {
		return tracePropertyDatum.getName();
	}

	public @NonNull Property getTraceProperty() {
		return QVTscheduleUtil.getReferredProperty(tracePropertyDatum);
	}

	@Override
	public String toString() {
		return tracePropertyDatum.toString();
	}
}
