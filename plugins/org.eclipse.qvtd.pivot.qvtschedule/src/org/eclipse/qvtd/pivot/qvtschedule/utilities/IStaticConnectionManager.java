/*******************************************************************************
 * Copyright (c) 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;

public interface IStaticConnectionManager
{
	//	void rawAddIntermediateConnection(@NonNull Region region, @NonNull NodeConnection connection);
	//	void rawAddRootConnection(@NonNull Region region, @NonNull NodeConnection connection);
	void rawDestroy(@NonNull EdgeConnection edgeConnection);
	void rawDestroy(@NonNull NodeConnection nodeConnection);
	@NonNull Iterable<@NonNull Region> rawGetCallableChildren(@NonNull Region region);
	@NonNull Iterable<@NonNull NodeConnection> rawGetRootConnections(@NonNull Region region);
	@NonNull Iterable<@NonNull ConnectionEnd> rawGetSourceEnds(@NonNull Connection connection);
	@NonNull Iterable<@NonNull NavigableEdge> rawGetSourceEnds(@NonNull EdgeConnection edgeConnection);
	@NonNull Iterable<@NonNull Node> rawGetSourceEnds(@NonNull NodeConnection nodeConnection);
	@NonNull Iterable<@NonNull Node> rawGetSourceNodes(@NonNull Connection connection);
	@NonNull Iterable<@NonNull NavigableEdge> rawGetTargetEdges(@NonNull EdgeConnection edgeConnection);
	@NonNull Iterable<@NonNull Node> rawGetTargetNodes(@NonNull NodeConnection nodeConnection);
	@NonNull Map<@NonNull ConnectionEnd, @NonNull ConnectionRole> rawGetTargets(@NonNull Connection connection);
	@NonNull Map<@NonNull Node, @NonNull ConnectionRole> rawGetTargets(@NonNull NodeConnection nodeConnection);
	boolean rawIsEdge2Edge(@NonNull EdgeConnection edgeConnection);
	boolean rawIsNode2Node(@NonNull NodeConnection nodeConnection);
	boolean rawIsRegion2Region(@NonNull Connection connection, @NonNull Map<@NonNull Region, @NonNull Integer> sourceRegion2count, @NonNull Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles);
	boolean rawIsUsed(@NonNull NodeConnection nodeConnection, @NonNull Node targetNode);

}
