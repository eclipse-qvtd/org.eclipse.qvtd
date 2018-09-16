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

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

/** This code is recued but has never worked properly */
public class ToCallGraphVisitor extends AbstractToGraphVisitor
{
	public ToCallGraphVisitor(@NonNull GraphStringBuilder context) {
		super(context);
	}

	@Override
	public @Nullable String visitEdgeConnection(@NonNull EdgeConnection object) {
		/*		if (isNode2Node()) {
				s.appendNode(this);
//				@SuppressWarnings("null")@NonNull Node sourceNode = sourceNodes.iterator().next();
//				@SuppressWarnings("null")@NonNull Node targetNode = targetNode2role.keySet().iterator().next();
//				s.appendEdge(sourceNode, this, targetNode);
			}
			else {
				s.appendNode(this);
//				for (@SuppressWarnings("null")@NonNull Node source : getSources()) {
//					s.appendEdge(source, this, this);
//				}
//				for (@SuppressWarnings("null")@NonNull Node target : getTargets()) {
//					@SuppressWarnings("null")@NonNull ConnectionRole role = targetNode2role.get(target);
//					s.appendEdge(this, role, target);
//				}
			} */
		return null;
	}

	@Override
	public @Nullable String visitNodeConnection(@NonNull NodeConnection nodeConnection) {
		if (nodeConnection.isNode2Node()) {
			appendNode(nodeConnection);
			//			@SuppressWarnings("null")@NonNull Node sourceNode = sourceEnds.iterator().next();
			//			@SuppressWarnings("null")@NonNull Node targetNode = targetEnd2role.keySet().iterator().next();
			//			s.appendEdge(sourceNode, this, targetNode);
		}
		else {
			appendNode(nodeConnection);
			//			for (@SuppressWarnings("null")@NonNull Node source : getSources()) {
			//				s.appendEdge(source, this, this);
			//			}
			//			for (@SuppressWarnings("null")@NonNull Node target : getTargets()) {
			//				@SuppressWarnings("null")@NonNull ConnectionRole role = targetEnd2role.get(target);
			//				s.appendEdge(this, role, target);
			//			}
		}
		return null;
	}

	@Override
	public @Nullable String visitRegion(@NonNull Region region) {
		appendNode(region);
		for (final @NonNull Region childRegion : region.getCallableChildren()) {
			GraphEdge graphEdge = new GraphEdge()
			{
				@Override
				public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull String sourceName, @NonNull String targetName) {
					s.appendAttributedEdge(sourceName, this, targetName);
				}

				@Override
				public @NonNull GraphNode getEdgeSource() {
					return region;
				}

				@Override
				public @NonNull GraphNode getEdgeTarget() {
					return childRegion;
				}
			};
			appendEdge(graphEdge.getEdgeSource(), graphEdge, graphEdge.getEdgeTarget());
		}
		for (final @NonNull NodeConnection connection : region.getRootConnections())
		{
			GraphEdge graphEdge1 = new GraphEdge() {
				@Override
				public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull String sourceName, @NonNull String targetName) {
					s.appendAttributedEdge(sourceName, this, targetName);
				}

				@Override
				public @NonNull GraphNode getEdgeSource() {
					return region;
				}

				@Override
				public @NonNull GraphNode getEdgeTarget() {
					return connection;
				}
			};
			appendEdge(graphEdge1.getEdgeSource(), graphEdge1, graphEdge1.getEdgeTarget());
			for (final @NonNull Node targetNode : connection.getTargetNodes())
			{
				GraphEdge graphEdge = new GraphEdge() {
					@Override
					public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull String sourceName, @NonNull String targetName) {
						s.appendAttributedEdge(sourceName, this, targetName);
					}

					@Override
					public @NonNull GraphNode getEdgeSource() {
						return connection;
					}

					@Override
					public @NonNull GraphNode getEdgeTarget() {
						return QVTscheduleUtil.getOwningRegion(targetNode);
					}
				};
				appendEdge(graphEdge.getEdgeSource(), graphEdge, graphEdge.getEdgeTarget());
			}
		}
		return null;
	}

	@Override
	public @Nullable String visitScheduledRegion(@NonNull ScheduledRegion scheduledRegion) {
		context.setLabel(scheduledRegion.getName());
		context.pushCluster();
		for (@NonNull Region region : scheduledRegion.getCallableRegions()) {
			region.accept(this);
		}
		for (@NonNull Connection connection : QVTscheduleUtil.getOwnedConnections(scheduledRegion)) {
			connection.accept(new ToRegionGraphVisitor(context));
		}
		context.popCluster();
		return null;
	}
}