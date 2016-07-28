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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import org.eclipse.jdt.annotation.NonNull;

public interface Visitor<R>
{
	R visiting(@NonNull Visitable visitable);

	R visitBasicEdge(@NonNull BasicEdge basicEdge);
	R visitBasicEdgeConnection(@NonNull BasicEdgeConnection basicEdgeConnection);
	R visitBasicNodeConnection(@NonNull BasicNodeConnection basicNodeConnection);
	R visitCyclicScheduledRegion(@NonNull CyclicScheduledRegion cyclicScheduledRegion);
	R visitEdge(@NonNull Edge edge);
	R visitMappingRegion(@NonNull MappingRegion mappingRegion);
	R visitNavigationEdge(@NonNull NavigationEdge navigationEdge);
	R visitNode(@NonNull Node node);
	R visitOperationRegion(@NonNull OperationRegion operationRegion);
	R visitRegion(@NonNull Region region);
	R visitRootCompositionRegion(@NonNull RootCompositionRegion rootCompositionRegion);
	R visitRootScheduledRegion(@NonNull RootScheduledRegion rootScheduledRegion);
	R visitTypedNode(@NonNull TypedNode typedNode);
	R visitVariableNode(@NonNull VariableNode variableNode);
}