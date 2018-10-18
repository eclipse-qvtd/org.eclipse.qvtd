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
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.Graphable;

public interface Partition extends Nameable, GraphNode, Graphable
{
	boolean addPass(int passNumber);
	@Nullable Set<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel);
	@Nullable Iterable<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel, @NonNull Property asProperty);
	int getFirstPass();
	@NonNull Iterable<@NonNull Node> getHeadNodes();

	/**
	 * The schedule index at which the latest dependent becomes available and consequently the latest that deferred execution may occur.
	 */
	int getLastPass();
	@Override
	@NonNull String getName();
	@NonNull Iterable<@NonNull Edge> getPartialEdges();
	@NonNull Iterable<@NonNull Node> getPartialNodes();
	@NonNull String getPassRangeText();
	@NonNull Iterable<@NonNull Integer> getPasses();
	@Nullable String getPassesText();
	@NonNull Region getRegion();
	@Nullable Role getRole(@NonNull Edge edge);
	@Nullable Role getRole(@NonNull Node node);
	@NonNull String getSymbolName();
	boolean isHead(@NonNull ConnectionEnd connectionEnd);
	void setPass(int pass);
}