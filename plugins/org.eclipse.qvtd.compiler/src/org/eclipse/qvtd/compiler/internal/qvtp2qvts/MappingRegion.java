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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;

public interface MappingRegion extends Region
{
	//	@NonNull Iterable<@NonNull Node> getComputedNodes();
	@NonNull Iterable<@NonNull Mapping> getMappings();
	//	@NonNull Iterable<@NonNull MappingAction> getMappingActions();
	void writeDebugGraphs(@Nullable String context);
}