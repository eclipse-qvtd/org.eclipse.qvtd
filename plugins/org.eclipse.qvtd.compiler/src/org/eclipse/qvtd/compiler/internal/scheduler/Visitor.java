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

public interface Visitor<R>
{
	R visiting(@NonNull Visitable visitable);

	R visitChildCompositionRegion(@NonNull ChildCompositionRegion childCompositionRegion);
	R visitCyclicScheduledRegion(@NonNull CyclicScheduledRegion cyclicScheduledRegion);
	R visitMergedMappingRegion(@NonNull MergedMappingRegion mergedMappingRegion);
	R visitOperationRegion(@NonNull OperationRegion operationRegion);
	R visitRootCompositionRegion(@NonNull RootCompositionRegion rootCompositionRegion);
	R visitRootScheduledRegion(@NonNull RootScheduledRegion rootScheduledRegion);
	R visitSimpleMappingRegion(@NonNull SimpleMappingRegion simpleMappingRegion);
}