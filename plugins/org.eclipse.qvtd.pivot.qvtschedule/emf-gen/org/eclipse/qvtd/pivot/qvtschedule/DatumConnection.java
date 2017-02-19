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
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;

/**
 * @generated
 */
public interface DatumConnection<CE extends ConnectionEnd> extends Connection, GraphEdge, GraphNode
{
	boolean addIndex(int index);
	@NonNull List<@NonNull Integer> getIndexes();
	@NonNull ConnectionEnd getSource(@NonNull Region sourceRegion);
	@NonNull String getSourceDisplayNames();
	@NonNull Iterable<@NonNull Node> getSourceNodes();
	@NonNull Iterable<@NonNull Region> getSourceRegions();
	@NonNull Iterable<@NonNull ? extends ConnectionEnd> getSources();
	@NonNull Iterable<@NonNull Region> getSourceRegions(@NonNull ScheduledRegion scheduledRegion);
	@NonNull ConnectionEnd getTarget(@NonNull Region targetRegion);
	@NonNull Iterable<@NonNull Node> getTargetNodes();
	@NonNull Iterable<@NonNull Region> getTargetRegions();
	@NonNull Iterable<@NonNull Region> getTargetRegions(@NonNull ScheduledRegion scheduledRegion);
	@NonNull Map<@NonNull ? extends ConnectionEnd, @NonNull ConnectionRole> getTargets();

	/**
	 * Return true if this connection is from a nested region input port to the nested region's content.
	 */
	//	boolean isInput();
	boolean isMandatory();
	//	boolean isOutput();

	/**
	 * Return true if this connection passes a value to a region head.
	 */
	boolean isPassed();
	boolean isPassed(@NonNull Region targetRegion);
	void removeTargetRegion(@NonNull Region region);
}