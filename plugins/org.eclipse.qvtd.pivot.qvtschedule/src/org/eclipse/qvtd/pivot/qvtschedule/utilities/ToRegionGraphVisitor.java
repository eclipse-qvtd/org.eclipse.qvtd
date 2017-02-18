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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;

public class ToRegionGraphVisitor extends AbstractExtendingQVTscheduleVisitor<@Nullable String, @NonNull GraphStringBuilder>
{
	public ToRegionGraphVisitor(@NonNull GraphStringBuilder context) {
		super(context);
	}

	public @NonNull String visit(@NonNull ScheduledRegion region) {
		region.accept(this);
		return context.toString();
	}

	@Override
	public @Nullable String visitDatumConnection(@NonNull DatumConnection<?> datumConnection) {
		ScheduledRegion scheduledRegion = datumConnection.getOwningScheduledRegion();
		Map<@NonNull Region, @NonNull Integer> sourceRegion2count = new HashMap<>();
		for (@NonNull Node source : datumConnection.getSourceNodes()) {
			Region sourceRegion = scheduledRegion.getNormalizedRegion(QVTscheduleUtil.getOwningRegion(source));
			if (sourceRegion != null) {
				//				Integer count = sourceRegion2count.get(sourceRegion);
				sourceRegion2count.put(sourceRegion, 1); //(count != null ? count.intValue() : 0) + 1);
			}
		}
		Map<@NonNull Region, @NonNull List<@NonNull ConnectionRole>> targetRegion2roles = new HashMap<>();
		for (@NonNull ConnectionEnd target : datumConnection.getTargets().keySet()) {
			ConnectionRole role = datumConnection.getTargets().get(target);
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
		if (datumConnection.isRegion2Region(sourceRegion2count, targetRegion2roles)) {
			Region sourceRegion = sourceRegion2count.keySet().iterator().next();
			Region targetRegion = targetRegion2roles.keySet().iterator().next();
			context.appendEdge(sourceRegion, datumConnection, targetRegion);
		}
		else {
			context.appendNode(datumConnection);
			for (@NonNull Region sourceRegion : sourceRegion2count.keySet()) {
				Integer counts = sourceRegion2count.get(sourceRegion);
				assert counts != null;
				for (int i = counts; i > 0; i--) {
					context.appendEdge(sourceRegion, datumConnection, datumConnection);
				}
			}
			for (@NonNull Region targetRegion : targetRegion2roles.keySet()) {
				List<@NonNull ConnectionRole> roles = targetRegion2roles.get(targetRegion);
				assert roles != null;
				for (@NonNull ConnectionRole role : roles) {
					context.appendEdge(datumConnection, role, targetRegion);
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
				for (@NonNull ConnectionEnd end : QVTscheduleUtil.getSourceEnds(datumConnection)) {
					if (end.getOwningRegion() == scheduledRegion) {
						assert sourceEnd == null;
						sourceEnd = end;
					}
				}
				if (sourceEnd instanceof Node) {
					Node node = (Node)sourceEnd;
					if (node.isHead()) {
						headNode = node;
						context.appendEdge(headNode, datumConnection, datumConnection);
					}
				}
			}
		}
		return null;
	}

	@Override
	public @Nullable String visitRegion(@NonNull Region region) {
		context.appendNode(region);
		for (@NonNull Edge edge : region.getRecursionEdges()) {
			context.appendEdge(QVTscheduleUtil.getOwningRegion(edge.getEdgeSource()), edge, QVTscheduleUtil.getOwningRegion(edge.getEdgeTarget()));
		}
		return null;
	}

	@Override
	public @Nullable String visitScheduledRegion(@NonNull ScheduledRegion scheduledRegion) {
		context.setLabel(scheduledRegion.getName());
		context.pushCluster();
		for (@NonNull Region region : scheduledRegion.getCallableRegions()) {
			//			region.toRegionGraph(s);
			context.appendNode(region);
			//			for (@SuppressWarnings("null")@NonNull Edge edge : region.getRecursionEdges()) {
			//				s.appendEdge(edge.getSource().getRegion(), edge, edge.getTarget().getRegion());
			//			}
		}
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(scheduledRegion)) {
			context.appendNode(node);
		}
		for (@NonNull Connection connection : QVTscheduleUtil.getOwnedConnections(scheduledRegion)) {
			connection.accept(this);
		}
		context.popCluster();
		return null;
	}

	@Override
	public @Nullable String visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}
}