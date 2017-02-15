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
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.impl.ScheduledRegionImpl;

public class ScheduledRegion2 extends ScheduledRegionImpl
{
	public ScheduledRegion2(@NonNull String name, @NonNull ScheduleModel scheduleModel) {
		setScheduleModel(scheduleModel);
		setName(name);
	}

	public @NonNull QVTm2QVTs getScheduler() {
		return (QVTm2QVTs)getScheduleModel();
	}
}