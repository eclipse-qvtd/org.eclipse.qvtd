/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.NodeConnectionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;

/** This code is rescued but has never worked properly */
public class ToGraphVisitor extends AbstractExtendingQVTscheduleVisitor<@Nullable String, @NonNull GraphStringBuilder>
{
	public ToGraphVisitor(@NonNull GraphStringBuilder context) {
		super(context);
	}

	public @NonNull String visit(@NonNull ScheduledRegion region) {
		region.accept(this);
		return context.toString();
	}

	@Override
	public @Nullable String visitDatumConnection(@NonNull DatumConnection<?> datumConnection) {
		context.appendEdge(datumConnection.getEdgeSource(), datumConnection, datumConnection.getEdgeTarget());
		return null;
	}

	@Override
	public @Nullable String visitEdge(@NonNull Edge edge) {
		context.appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
		return null;
	}

	@Override
	public @Nullable String visitEdgeConnection(@NonNull EdgeConnection edgeConnection) {
		if (edgeConnection.isEdge2Edge()) {
			NavigableEdge sourceEdge = edgeConnection.getSourceEnds().iterator().next();
			NavigableEdge targetEdge = edgeConnection.getTargetEdges().iterator().next();
			context.appendEdge(sourceEdge.getEdgeTarget(), edgeConnection, targetEdge.getEdgeTarget());
		}
		else {
			context.appendNode(edgeConnection);
			for (@NonNull NavigableEdge source : QVTscheduleUtil.getSourceEnds(edgeConnection)) {
				context.appendEdge(source.getEdgeTarget(), edgeConnection, edgeConnection);
			}
			for (@NonNull NavigableEdge target : edgeConnection.getTargetEdges()) {
				ConnectionRole role = edgeConnection.getTargets().get(target);
				assert role != null;
				context.appendEdge(edgeConnection, role, target.getEdgeTarget());
			}
		}
		return null;
	}

	@Override
	public @Nullable String visitLoadingRegion(@NonNull LoadingRegion loadingRegion) {
		context.setLabel(loadingRegion.getName());
		context.setColor("lightblue");
		context.setPenwidth(QVTscheduleConstants.LINE_WIDTH);
		context.pushCluster();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(loadingRegion)) {
			context.appendNode(node);
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(loadingRegion)) {
			context.appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
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
			context.appendEdge(navigableEdge.getEdgeSource(), navigableEdge, navigableEdge.getEdgeTarget());
		}
		return null;
	}

	@Override
	public @Nullable String visitNode(@NonNull Node object) {
		context.appendNode(object);
		return null;
	}

	@Override
	public @Nullable String visitNodeConnection(@NonNull NodeConnection nodeConnection) {
		if (nodeConnection.isNode2Node()) {
			Node sourceNode = QVTscheduleUtil.getSourceEnds(nodeConnection).iterator().next();
			Node targetNode = nodeConnection.getTargetNodes().iterator().next();
			context.appendEdge(sourceNode, nodeConnection, targetNode);
		}
		else {
			context.appendNode(nodeConnection);
			for (@NonNull Node source : QVTscheduleUtil.getSourceEnds(nodeConnection)) {
				context.appendEdge(source, nodeConnection, nodeConnection);
			}
			for (@NonNull Node target : nodeConnection.getTargetNodes()) {
				ConnectionRole role = ((NodeConnectionImpl)nodeConnection).getTargets().get(target);
				assert role != null;
				context.appendEdge(nodeConnection, role, target);
			}
		}
		return null;
	}

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
		for (@NonNull Region region : QVTscheduleUtil.getOwnedRegions(scheduledRegion)) {
			region.accept(this);
		}
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(scheduledRegion)) {
			context.appendNode(node);
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(scheduledRegion)) {
			context.appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
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