/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public interface Visitor<R>
{
	@Nullable R visiting(@NonNull Visitable visitable);

	@Nullable R visitCompositionRegion(@NonNull CompositionRegion containmentRegion);
	@Nullable R visitMappingRegion(@NonNull MappingRegion mappingRegion);
	@Nullable R visitMergedRegion(@NonNull MergedRegion mergedRegion);
	@Nullable R visitOperationRegion(@NonNull OperationRegion operationRegion);
	@Nullable R visitRootCompositionRegion(@NonNull RootRegion rootContainmentRegion);
	@Nullable R visitRootRegion(@NonNull ScheduledRegion rootRegion);
}