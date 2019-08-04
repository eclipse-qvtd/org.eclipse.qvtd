/*******************************************************************************
 * Copyright (c) 2018, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 */
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.pivot.qvtbase.Rule;

/**
 * QVTrelationScheduleManager defines the common intrerface of a QVTrelationMultipleScheduleManager
 * and QVTrelationDirectedScheduleManager.
 */
public interface QVTrelationScheduleManager extends ScheduleManager
{
	@Override
	@NonNull QVTrelationNameGenerator getNameGenerator();

	@NonNull RelationAnalysis getRuleAnalysis(@NonNull Rule relation);
}