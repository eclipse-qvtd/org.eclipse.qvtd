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
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.RootScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.Visitable2;

public interface Visitor2<R>
{
	R visiting(@NonNull Visitable2 visitable);

	R visitEdge(@NonNull Edge edge);
	R visitEdgeConnection(@NonNull EdgeConnection edgeConnection);
	R visitMappingRegion(@NonNull MappingRegion mappingRegion);
	R visitNavigableEdge(@NonNull NavigableEdge navigableEdge);
	R visitNode(@NonNull Node node);
	R visitNodeConnection(@NonNull NodeConnection nodeConnection);
	R visitOperationRegion(@NonNull OperationRegion operationRegion);
	R visitRegion(@NonNull Region region);
	R visitRootScheduledRegion(@NonNull RootScheduledRegion rootScheduledRegion);
	R visitVariableNode(@NonNull VariableNode variableNode);
}