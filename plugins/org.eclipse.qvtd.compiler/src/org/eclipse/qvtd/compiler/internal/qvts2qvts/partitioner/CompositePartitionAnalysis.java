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

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;

public interface CompositePartitionAnalysis extends PartitionAnalysis
{
	@NonNull Iterable<@NonNull PartitionAnalysis>  getPartitionAnalyses();
	@NonNull List<@NonNull Set<@NonNull PartitionAnalysis>> getPartitionSchedule();
}