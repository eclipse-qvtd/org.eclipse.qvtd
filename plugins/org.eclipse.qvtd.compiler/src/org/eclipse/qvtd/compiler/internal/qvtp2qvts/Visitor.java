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

	R visitBasicEdgeConnection(@NonNull BasicEdgeConnection basicEdgeConnection);
	R visitBasicNodeConnection(@NonNull BasicNodeConnection basicNodeConnection);
	R visitBasicSimpleEdge(@NonNull BasicSimpleEdge basicSimpleEdge);
	R visitComplexTypedNode(@NonNull ComplexTypedNode complexTypedNode);
	R visitCyclicScheduledRegion(@NonNull CyclicScheduledRegion cyclicScheduledRegion);
	R visitEdge(@NonNull Edge edge);
	R visitMergedEdge(@NonNull MergedEdge mergedEdge);
	R visitMergedMappingRegion(@NonNull MergedMappingRegion mergedMappingRegion);
	R visitMergedNode(@NonNull MergedNode mergedNode);
	R visitNode(@NonNull Node node);
	R visitOperationRegion(@NonNull OperationRegion operationRegion);
	R visitRegion(@NonNull Region region);
	R visitRootCompositionRegion(@NonNull RootCompositionRegion rootCompositionRegion);
	R visitRootScheduledRegion(@NonNull RootScheduledRegion rootScheduledRegion);
	R visitSimpleNavigationEdge(@NonNull SimpleNavigationEdge simpleNavigationEdge);
	R visitSimpleMappingRegion(@NonNull SimpleMappingRegion simpleMappingRegion);
	R visitSimpleTypedNode(@NonNull SimpleTypedNode simpleTypedNode);
	R visitSimpleVariableNode(@NonNull SimpleVariableNode simpleVariableNode);
}