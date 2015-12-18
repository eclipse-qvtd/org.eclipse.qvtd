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
import org.eclipse.ocl.pivot.Property;

public interface NavigationEdgeRole extends EdgeRole
{
//	@NonNull NavigationEdge createEdge(@NonNull Region region, @NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode);
	@NonNull SimpleNavigationEdge createSimpleEdge(@NonNull SimpleRegion region, @NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode);

	@Nullable String getLabel(@NonNull Property source2targetProperty);
}