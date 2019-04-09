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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

public abstract class AbstractPartialRegionAnalysis<@NonNull PRA extends PartialRegionsAnalysis> implements PartialRegionAnalysis<@NonNull PRA>
{
	@Override
	public @NonNull Partition getPartition() {
		throw new UnsupportedOperationException();
	}

	@Override
	public @NonNull Region getRegion() {
		throw new UnsupportedOperationException();
	}
}