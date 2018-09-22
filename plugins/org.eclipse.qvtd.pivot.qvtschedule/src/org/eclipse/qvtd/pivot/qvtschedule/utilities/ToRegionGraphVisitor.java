/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

public class ToRegionGraphVisitor extends AbstractToGraphVisitor
{
	public ToRegionGraphVisitor(@NonNull GraphStringBuilder context) {
		super(context);
	}

	@Override
	public @Nullable String visitConnection(@NonNull Connection connection) {
		ScheduledRegion scheduledRegion = connection.getOwningScheduledRegion();
		Map<@NonNull Region, @NonNull Integer> sourceRegion2count = new HashMap<>();
		for (@NonNull Node source : StaticConnectionManager.INSTANCE.rawGetSourceNodes(connection)) {
			Region sourceRegion = scheduledRegion.getNormalizedRegion(QVTscheduleUtil.getOwningRegion(source));
			if (sourceRegion != null) {
				//				Integer count = sourceRegion2count.get(sourceRegion);
				sourceRegion2count.put(sourceRegion, 1); //(count != null ? count.intValue() : 0) + 1);
			}
		}
		Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles = new HashMap<>();
		for (@NonNull ConnectionEnd target : StaticConnectionManager.INSTANCE.rawGetTargets(connection).keySet()) {
			ConnectionRole role = StaticConnectionManager.INSTANCE.rawGetTargets(connection).get(target);
			assert role != null;
			Region targetRegion = scheduledRegion.getNormalizedRegion(QVTscheduleUtil.getOwningRegion(target));
			if (targetRegion != null) {
				List<@NonNull ConnectionRole> roles = targetRegion2roles.get(targetRegion);
				if (roles == null) {
					roles = new ArrayList<>();
					targetRegion2roles.put(targetRegion, roles);
				}
				if (!roles.contains(role)) {
					roles.add(role);
				}
			}
		}
		if (StaticConnectionManager.INSTANCE.rawIsRegion2Region(connection, sourceRegion2count, targetRegion2roles)) {
			Region sourceRegion = sourceRegion2count.keySet().iterator().next();
			Region targetRegion = targetRegion2roles.keySet().iterator().next();
			appendEdge(sourceRegion, connection, targetRegion);
		}
		else {
			appendNode(connection);
			for (@NonNull Region sourceRegion : sourceRegion2count.keySet()) {
				Integer counts = sourceRegion2count.get(sourceRegion);
				assert counts != null;
				for (int i = counts; i > 0; i--) {
					appendEdge(sourceRegion, connection, connection);
				}
			}
			for (@NonNull Region targetRegion : targetRegion2roles.keySet()) {
				List<@NonNull ConnectionRole> roles = targetRegion2roles.get(targetRegion);
				assert roles != null;
				for (@NonNull ConnectionRole role : roles) {
					appendEdge(connection, role, targetRegion);
					//				GraphNode targetNode = /*targetRegion.isCyclicRegion() ? getTarget(targetRegion) :*/ targetRegion;
					//				for (@SuppressWarnings("null")@NonNull ConnectionRole role : targetRegion2roles.get(targetRegion)) {
					//					s.appendEdge(this, role, targetNode);
				}
			}
			Node headNode = null;
			if (sourceRegion2count.size() == 0) {
				/*				@Nullable ConnectionEnd targetEnd = null;
				for (@NonNull ConnectionEnd end : targetEnd2role.keySet()) {
					if (end.getRegion() == scheduledRegion) {
						assert targetEnd == null;
						targetEnd = end;
					}
				}
				if (targetEnd instanceof Node) {
					Node node = (Node)targetEnd;
					if (node.isHead()) {
						headNode = node;
						s.appendEdge(headNode, this, this);
					}
				} */
				@Nullable ConnectionEnd sourceEnd = null;
				for (@NonNull ConnectionEnd end : StaticConnectionManager.INSTANCE.rawGetSourceEnds(connection)) {
					if (end.getOwningRegion() == scheduledRegion) {
						assert sourceEnd == null;
						sourceEnd = end;
					}
				}
				if (sourceEnd instanceof Node) {
					Node node = (Node)sourceEnd;
					if (node.isHead()) {
						headNode = node;
						appendEdge(headNode, connection, connection);
					}
				}
			}
		}
		return null;
	}

	@Override
	public @Nullable String visitRegion(@NonNull Region region) {
		appendNode(region);
		for (@NonNull Edge edge : region.getRecursionEdges()) {
			appendEdge(QVTscheduleUtil.getOwningRegion(edge.getEdgeSource()), edge, QVTscheduleUtil.getOwningRegion(edge.getEdgeTarget()));
		}
		return null;
	}

	@Override
	public @Nullable String visitScheduledRegion(@NonNull ScheduledRegion scheduledRegion) {
		context.setLabel(scheduledRegion.getName());
		context.pushCluster();
		for (@NonNull Region region : scheduledRegion.getCallableRegions()) {
			//			region.toRegionGraph(s);
			appendNode(region);
			//			for (@SuppressWarnings("null")@NonNull Edge edge : region.getRecursionEdges()) {
			//				s.appendEdge(edge.getSource().getRegion(), edge, edge.getTarget().getRegion());
			//			}
		}
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(scheduledRegion)) {
			appendNode(node);
		}
		for (@NonNull Connection connection : QVTscheduleUtil.getOwnedConnections(scheduledRegion)) {
			connection.accept(this);
		}
		context.popCluster();
		return null;
	}
}