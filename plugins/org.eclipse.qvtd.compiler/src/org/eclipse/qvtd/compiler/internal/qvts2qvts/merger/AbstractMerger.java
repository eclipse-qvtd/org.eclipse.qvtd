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
import org.eclipse.ocl.pivot.utilities.TracingOption;
import org.eclipse.qvtd.compiler.CompilerConstants;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RegionUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

/**
 * AbstractMerger shares functionality between EarlyMerger and LateMerger..
 */
public class AbstractMerger
{
	public static final @NonNull TracingOption EARLY = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/merge/early");
	public static final @NonNull TracingOption FAILURE = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/merge/failure");
	public static final @NonNull TracingOption LATE = new TracingOption(CompilerConstants.PLUGIN_ID, "qvts2qvts/merge/late");

	/**
	 * Return true if any primaryRegion head coincides with a secondaryRegion head.
	 */
	protected boolean isSharedHead(@NonNull Region primaryRegion, @NonNull Region secondaryRegion) {
		for (@NonNull Node primaryHead : RegionUtil.getHeadNodes(primaryRegion)) {
			ClassDatumAnalysis primaryClassDatumAnalysis = RegionUtil.getClassDatumAnalysis(primaryHead);
			for (@NonNull Node secondaryHead : RegionUtil.getHeadNodes(secondaryRegion)) {
				if (primaryClassDatumAnalysis == RegionUtil.getClassDatumAnalysis(secondaryHead)) {
					return true;
				}
			}
		}
		return false;
	}
}
