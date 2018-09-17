package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

/**
 * A CoreTransformationAnalysis accumulates the tesults of analyzing a Core Transformation and its contents.
 */
public class CoreTransformationAnalysis extends AbstractTransformationAnalysis
{
	public CoreTransformationAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull Transformation transformation, @NonNull ScheduledRegion scheduledRegion) {
		super(scheduleManager, transformation, scheduledRegion);
	}
}
