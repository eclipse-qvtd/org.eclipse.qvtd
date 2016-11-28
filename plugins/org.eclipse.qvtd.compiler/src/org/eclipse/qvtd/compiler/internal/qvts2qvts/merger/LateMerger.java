/*******************************************************************************
 * Copyright (c) 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.merger;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.RootScheduledRegion;

/**
 * LateMerger replaces one list of MappingRegions by another in which each set of regions that can be merged
 * exploiting knowledge of the schedule is replaced by an equivalent merged region.
 */
public class LateMerger extends AbstractMerger
{
	/**
	 * Replace those inputRegions that may be merged by merged regions.
	 *
	 * inputRegions should be naturally ordered to ensure that non-recursive dependencies are inherently satisfied.
	 *
	 * Returns the inputRegions after replacement of merges.
	 */
	public static void partition(@NonNull RootScheduledRegion rootRegion) {
		// TODO Auto-generated method stub

	}
}
