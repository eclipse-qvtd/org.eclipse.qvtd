/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

/** This code is rescued but has never worked properly */
public class ToGraphVisitor extends AbstractToGraphVisitor
{
	public ToGraphVisitor(@NonNull GraphStringBuilder context) {
		super(context);
	}

	@Override
	public @Nullable String visitConnection(@NonNull Connection connection) {
		appendEdge(connection.getEdgeSource(), connection, connection.getEdgeTarget());
		return null;
	}

	@Override
	public @Nullable String visitEdge(@NonNull Edge edge) {
		appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
		return null;
	}

	//	@Override
	//	public @Nullable String visitEdgeConnection(@NonNull EdgeConnection edgeConnection) {
	/*	if (StaticConnectionManager.INSTANCE.rawIsEdge2Edge(edgeConnection)) {
			NavigableEdge sourceEdge = StaticConnectionManager.INSTANCE.rawGetSourceEnds(edgeConnection).iterator().next();
			NavigableEdge targetEdge = StaticConnectionManager.INSTANCE.rawGetTargetEdges(edgeConnection).iterator().next();
			appendEdge(sourceEdge.getEdgeTarget(), edgeConnection, targetEdge.getEdgeTarget());
		}
		else {
			appendNode(edgeConnection);
			for (@NonNull NavigableEdge source : StaticConnectionManager.INSTANCE.rawGetSourceEnds(edgeConnection)) {
				appendEdge(source.getEdgeTarget(), edgeConnection, edgeConnection);
			}
			for (@NonNull NavigableEdge target : StaticConnectionManager.INSTANCE.rawGetTargetEdges(edgeConnection)) {
				ConnectionRole role = StaticConnectionManager.INSTANCE.rawGetTargets(edgeConnection).get(target);
				assert role != null;
				appendEdge(edgeConnection, role, target.getEdgeTarget());
			}
		} */
	//		return null;
	//	}

	@Override
	public @Nullable String visitLoadingRegion(@NonNull LoadingRegion loadingRegion) {
		context.setLabel(loadingRegion.getName());
		context.setColor("lightblue");
		context.setPenwidth(QVTscheduleConstants.LINE_WIDTH);
		context.pushCluster();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(loadingRegion)) {
			appendNode(node);
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(loadingRegion)) {
			appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
		}
		context.popCluster();
		return null;
	}

	@Override
	public @Nullable String visitMappingRegion(@NonNull MappingRegion object) {
		context.setColor("palegreen");
		context.setPenwidth(QVTscheduleConstants.LINE_WIDTH);
		return super.visitMappingRegion(object);
	}

	@Override
	public @Nullable String visitNavigableEdge(@NonNull NavigableEdge navigableEdge) {
		if (navigableEdge.isSecondary()) {
			// Let primary draw a bidirectional edge
		}
		else if ((navigableEdge.getIncomingConnection() == null) && navigableEdge.getOutgoingConnections().isEmpty()) {
			return super.visitNavigableEdge(navigableEdge);
		}
		else {
			appendEdge(navigableEdge.getEdgeSource(), navigableEdge, navigableEdge.getEdgeTarget());
		}
		return null;
	}

	@Override
	public @Nullable String visitNode(@NonNull Node object) {
		appendNode(object);
		return null;
	}

	//	@Override
	//	public @Nullable String visitNodeConnection(@NonNull NodeConnection nodeConnection) {
	/*	if (StaticConnectionManager.INSTANCE.rawIsNode2Node(nodeConnection)) {
			Node sourceNode = StaticConnectionManager.INSTANCE.rawGetSourceEnds(nodeConnection).iterator().next();
			Node targetNode = StaticConnectionManager.INSTANCE.rawGetTargetNodes(nodeConnection).iterator().next();
			appendEdge(sourceNode, nodeConnection, targetNode);
		}
		else {
			appendNode(nodeConnection);
			for (@NonNull Node source : StaticConnectionManager.INSTANCE.rawGetSourceEnds(nodeConnection)) {
				appendEdge(source, nodeConnection, nodeConnection);
			}
			for (@NonNull Node target : StaticConnectionManager.INSTANCE.rawGetTargetNodes(nodeConnection)) {
				ConnectionRole role = StaticConnectionManager.INSTANCE.rawGetTargets(nodeConnection).get(target);
				assert role != null;
				appendEdge(nodeConnection, role, target);
			}
		} */
	//		return null;
	//	}

	@Override
	public @Nullable String visitOperationRegion(@NonNull OperationRegion object) {
		context.setColor(QVTscheduleConstants.OPERATION_COLOR);
		context.setPenwidth(QVTscheduleConstants.LINE_WIDTH);
		return super.visitOperationRegion(object);
	}

	@Override
	public @Nullable String visitRegion(@NonNull Region region) {
		context.setLabel(region.getName());
		context.pushCluster();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			node.accept(this);
			//			s.appendNode(node);
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			edge.accept(this);
			//			s.appendEdge(edge.getSource(), edge, edge.getTarget());
		}
		context.popCluster();
		return null;
	}

	@Override
	public @Nullable String visitScheduledRegion(@NonNull ScheduledRegion scheduledRegion) {
		context.setLabel(scheduledRegion.getName());
		context.pushCluster();
		for (@NonNull OperationRegion region : QVTscheduleUtil.getOwnedOperationRegions(QVTscheduleUtil.getOwningScheduleModel(scheduledRegion))) {
			region.accept(this);
		}
		LoadingRegion loadingRegion = scheduledRegion.getOwnedLoadingRegion();
		if (loadingRegion != null) {
			loadingRegion.accept(this);
		}
		for (@NonNull Region region : QVTscheduleUtil.getActiveRegions(scheduledRegion)) {
			region.accept(this);
		}
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(scheduledRegion)) {
			appendNode(node);
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(scheduledRegion)) {
			appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
		}
		for (@NonNull Connection connection : QVTscheduleUtil.getOwnedConnections(scheduledRegion)) {
			connection.accept(this);
		}
		context.popCluster();
		return null;
	}
}