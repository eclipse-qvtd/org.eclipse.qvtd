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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;

/**
 * Each TraceClassAnalysis identifies the usage of one middle trace class.
 */
public class TraceClassPartitionAnalysis extends TraceClassAnalysis<@NonNull Partition>
{
	public TraceClassPartitionAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull ClassDatum traceClassDatum) {
		super(scheduleManager, traceClassDatum);
	}
}
