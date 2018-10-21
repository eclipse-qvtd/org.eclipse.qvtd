/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.utilities;

import java.util.ArrayList;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ScheduleManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ConnectionManager;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.RootPartitionAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphElement;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.AbstractToGraphVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * ToGraphPartitionVisitor refines ToGraphVisitor to display <<success>> nodes in the partition-specific form.
 */
public abstract class ToGraphPartitionVisitor extends AbstractToGraphVisitor
{
	public static @NonNull AbstractToGraphVisitor createVisitor(@NonNull GraphStringBuilder s, @NonNull ScheduleManager scheduleManager, boolean showInternals) {
		if (showInternals) {
			return new ShowInternals(s, scheduleManager);
		}
		else {
			return new HideInternals(s, scheduleManager);
		}
	}

	private static class HideInternals extends ToGraphPartitionVisitor
	{
		protected HideInternals(@NonNull GraphStringBuilder context, @NonNull ScheduleManager scheduleManager) {
			super(context, scheduleManager);
		}

		@Override
		protected void setScope(@Nullable Object scopeObject) {}

		@Override
		protected void showPartitionInternals(@NonNull Partition partition) {
			setScope(null);
			appendNode(partition);
		}

		@Override
		protected void showRegionInternals(@NonNull Region region) {
			setScope(null);
			appendNode(region);
		}

		@Override
		public @Nullable String visitConnection(@NonNull Connection connection) {
			ConnectionManager connectionManager = scheduleManager.getConnectionManager();
			if (hasPartitions) {			// Partition-to-Partition within ScheduledRegion
				appendNode(connection);
				for (@NonNull Partition sourcePartition : connectionManager.getSourcePartitions(connection)) {
					appendEdge(sourcePartition, connection, connection);
				}
				Iterable<@NonNull Partition> targetPartitions = connectionManager.getTargetPartitions(connection);
				for (@NonNull Partition targetPartition : targetPartitions) {
					Iterable<@NonNull ConnectionEnd> connectionEnds = connectionManager.getTargetConnectionEnds(connection, targetPartition);
					for (@NonNull ConnectionEnd connectionEnd : connectionEnds) {
						ConnectionRole connectionRole = connectionManager.getTargetConnectionRole(connection, targetPartition, connectionEnd);
						appendEdge(connection, connectionRole, targetPartition);
					}
				}
			}
			else {							// Region-to-Region within ScheduledRegion
				ScheduledRegion scheduledRegion = connection.getOwningScheduledRegion();
				appendNode(connection);
				for (@NonNull Node sourceNode : connectionManager.getSourceNodes(connection)) {
					Region sourceRegion = scheduledRegion.getNormalizedRegion(QVTscheduleUtil.getOwningRegion(sourceNode));
					if (sourceRegion != null) {
						appendEdge(sourceRegion, connection, connection);
					}
				}
				for (@NonNull ConnectionEnd target : connectionManager.getTargets(connection).keySet()) {
					ConnectionRole role = connectionManager.getTargets(connection).get(target);
					assert role != null;
					Region targetRegion = scheduledRegion.getNormalizedRegion(QVTscheduleUtil.getOwningRegion(target));
					if (targetRegion != null) {
						appendEdge(connection, role, targetRegion);
					}
				}
			}
			return null;
		}
	}

	private static class ShowInternals extends ToGraphPartitionVisitor
	{
		protected ShowInternals(@NonNull GraphStringBuilder context, @NonNull ScheduleManager scheduleManager) {
			super(context, scheduleManager);
		}

		@Override
		protected void setScope(@Nullable Object scopeObject) {
			if (hasPartitions) {
				context.setScope(scopeObject);
			}
		}

		@Override
		protected void showPartitionInternals(@NonNull Partition partition) {
			setScope(partition);
			context.setLabel(partition.getGraphName());
			context.pushCluster();
			for (@NonNull Node node : partition.getPartialNodes()) {
				node.accept(this);
			}
			for (@NonNull Edge edge : partition.getPartialEdges()) {
				edge.accept(this);
			}
			context.popCluster();
			setScope(null);
		}

		@Override
		protected void showRegionInternals(@NonNull Region region) {
			context.setLabel(region.getGraphName());
			context.pushCluster();
			setScope(null);
			for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
				node.accept(this);
			}
			for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
				edge.accept(this);
			}
			context.popCluster();
		}

		@Override
		public @Nullable String visitConnection(@NonNull Connection connection) {
			ConnectionManager connectionManager = scheduleManager.getConnectionManager();
			if (hasPartitions) {			// Node-to-Node within Partition within ScheduledRegion
				setScope(null);
				ScheduledRegion scheduledRegion = connection.getOwningScheduledRegion();
				appendNode(connection);
				for (@NonNull ConnectionEnd sourceEnd : QVTscheduleUtil.getSourceEnds(connection)) {
					Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
					RegionAnalysis sourceRegionAnalysis = scheduleManager.getRegionAnalysis(sourceRegion);
					Iterable<@NonNull Partition> partitions = sourceRegionAnalysis.basicGetPartitions();
					if (partitions != null) {
						for (@NonNull Partition sourcePartition : partitions) {
							Role sourceRole = connectionManager.getRole(sourcePartition, sourceEnd);
							if ((sourceRole != null) && !sourceRole.isAwaited()) { // (sourceRole.isNew() || sourceRole.isLoaded())) {
								Node sourceNode;
								if (sourceEnd instanceof Edge) {
									sourceNode = QVTscheduleUtil.getTargetNode((Edge) sourceEnd);
								}
								else {
									sourceNode = (Node) sourceEnd;
								}
								setScope(sourcePartition);
								appendEdge(sourceNode, connection, connection);
							}
						}
					}
					else {
						Node sourceNode;
						Role sourceRole;
						if (sourceEnd instanceof Edge) {
							sourceNode = QVTscheduleUtil.getTargetNode((Edge) sourceEnd);
							sourceRole = ((Edge)sourceEnd).getEdgeRole();
						}
						else {
							sourceNode = (Node) sourceEnd;
							sourceRole = ((Node)sourceEnd).getNodeRole();
						}
						if (!sourceRole.isAwaited()) { //sourceRole.isNew() || sourceRole.isLoaded()) {
							appendEdge(sourceNode, connection, connection);
						}
					}
				}
				for (@NonNull ConnectionEnd target : connectionManager.getTargets(connection).keySet()) {
					ConnectionRole connectionRole = connectionManager.getTargets(connection).get(target);
					assert connectionRole != null;
					Region targetRegion = scheduledRegion.getNormalizedRegion(QVTscheduleUtil.getOwningRegion(target));
					if (targetRegion != null) {
						RegionAnalysis targetRegionAnalysis = scheduleManager.getRegionAnalysis(targetRegion);
						for (@NonNull Partition targetPartition : targetRegionAnalysis.getPartitions()) {
							ConnectionRole targetConnectionRole = connectionRole;
							Role role;
							Node targetGraphNode;
							if (target instanceof Node) {
								Node targetNode = (Node)target;
								role = targetPartition.getRole(targetNode);
								targetGraphNode = targetNode;
								if (!targetPartition.isHead(targetNode)) {
									targetConnectionRole = ClassUtil.nonNullState(ConnectionRole.PREFERRED_NODE);
								}
							}
							else {
								@NonNull NavigableEdge targetEdge = (NavigableEdge)target;
								role = targetPartition.getRole(targetEdge);
								targetGraphNode = QVTscheduleUtil.getTargetNode(targetEdge);
							}
							if ((role != null) && role.isOld()) {
								setScope(targetPartition);
								assert targetConnectionRole != null;
								appendEdge(connection, targetConnectionRole, targetGraphNode);
							}
						}
					}
				}
				setScope(null);
			}
			else {							// Node-to-Node within Region within ScheduledRegion
				appendNode(connection);
				for (@NonNull Node sourceNode : connectionManager.getSourceNodes(connection)) {
					appendEdge(sourceNode, connection, connection);
				}
				for (@NonNull ConnectionEnd target : connectionManager.getTargets(connection).keySet()) {
					ConnectionRole role = connectionManager.getTargets(connection).get(target);
					assert role != null;
					if (target instanceof Node) {
						appendEdge(connection, role, (Node)target);
					}
					else {
						appendEdge(connection, role, QVTscheduleUtil.getTargetNode((NavigableEdge)target));
					}
				}
			}
			return null;
		}
	}

	protected final @NonNull ScheduleManager scheduleManager;
	protected boolean hasPartitions = false;
	protected @Nullable Partition partition = null;

	protected ToGraphPartitionVisitor(@NonNull GraphStringBuilder context, @NonNull ScheduleManager scheduleManager) {
		super(context);
		this.scheduleManager = scheduleManager;
	}

	@Override
	protected @NonNull String getColor(@NonNull GraphElement element) {
		Role role = getGraphRole(element);
		if (role != null) {
			return QVTscheduleUtil.getColor(role);
		}
		return super.getColor(element);
	}

	protected @Nullable Role getGraphRole(GraphElement element) {
		Role role = null;
		if (element instanceof Node) {
			role = partition != null ? partition.getRole((Node)element) : ((Node)element).getNodeRole();
		}
		else if (element instanceof Edge) {
			role =  partition != null ? partition.getRole((Edge)element) : ((Edge)element).getEdgeRole();
		}
		return role;
	}

	@Override
	protected @NonNull String getLabel(@NonNull GraphNode graphNode) {
		Role role = getGraphRole(graphNode);
		if (role == Role.CONSTANT_SUCCESS_FALSE) {
			return " false \nBoolean";
		}
		else if (role == Role.CONSTANT_SUCCESS_TRUE) {
			return "  true  \nBoolean";
		}
		return super.getLabel(graphNode);
	}

	@Override
	protected @Nullable String getShape(@NonNull GraphNode graphNode) {
		Role role = getGraphRole(graphNode);
		if ((role == Role.CONSTANT_SUCCESS_FALSE) || (role == Role.CONSTANT_SUCCESS_TRUE)) {
			return null;		// rectangle
		}
		return super.getShape(graphNode);
	}

	@Override
	protected @Nullable String getStyle(@NonNull GraphNode graphNode) {
		Role role = getGraphRole(graphNode);
		if ((role == Role.CONSTANT_SUCCESS_FALSE) || (role == Role.CONSTANT_SUCCESS_TRUE)) {
			return "rounded";
		}
		return super.getStyle(graphNode);
	}

	@Override
	protected boolean isHead(@NonNull GraphNode graphNode) {
		if (partition != null) {
			return partition.isHead((Node)graphNode);
		}
		else {
			return ((Node)graphNode).isHead();
		}
	}

	protected abstract void setScope(@Nullable Object scopeObject);

	protected abstract void showPartitionInternals(@NonNull Partition partition);

	protected abstract void showRegionInternals(@NonNull Region region);

	protected void showScheduledRegionInternals(@NonNull ScheduledRegion scheduledRegion) {
		AbstractTransformationAnalysis transformationAnalysis = scheduleManager.getTransformationAnalysis(scheduledRegion);
		RootPartitionAnalysis rootPartitionAnalysis = transformationAnalysis.basicGetRootPartitionAnalysis();
		if (rootPartitionAnalysis == null) {
			for (@NonNull Region region : QVTscheduleUtil.getActiveRegions(scheduledRegion)) {
				region.accept(this);
			}
		}
		else {
			for (@NonNull PartitionAnalysis partitionAnalysis : CompilerUtil.gatherPartitionAnalyses(rootPartitionAnalysis, new ArrayList<>())) {
				Partition partition= partitionAnalysis.getPartition();
				setScope(partition);
				visitPartition(partition);
			}
		}
	}

	@Override
	public @Nullable String visitEdge(@NonNull Edge edge) {
		appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
		return null;
	}

	@Override
	public @Nullable String visitNavigableEdge(@NonNull NavigableEdge navigableEdge) {
		if (!navigableEdge.isSecondary()) {
			return super.visitNavigableEdge(navigableEdge);
		}
		else {
			return null;		// No need to draw edges twice.
		}
	}

	@Override
	public @Nullable String visitNode(@NonNull Node object) {
		appendNode(object);
		return null;
	}

	@Override
	public @Nullable String visitPartition(@NonNull Partition partition) {
		assert this.partition == null;
		try {
			this.partition = partition;
			//	String label = partition.getName();
			//	String passesText = partition.getPassesText();
			//	if (passesText != null) {
			//		label = label + "\\n " + passesText;
			//	}
			//	context.setLabel(label);
			context.setColor(QVTscheduleConstants.REGION_COLOR);
			showPartitionInternals(partition);
			return null;
		}
		finally {
			this.partition = null;
		}
	}

	@Override
	public @Nullable String visitRegion(@NonNull Region region) {
		context.setLabel(region.getName());
		context.setColor(QVTscheduleConstants.REGION_COLOR);
		showRegionInternals(region);
		return null;
	}

	@Override
	public @Nullable String visitScheduledRegion(@NonNull ScheduledRegion scheduledRegion) {
		hasPartitions = scheduleManager.getTransformationAnalysis(scheduledRegion).basicGetRootPartitionAnalysis() != null;
		context.setLabel(scheduledRegion.getName());
		context.setColor(QVTscheduleConstants.REGION_COLOR);
		context.pushCluster();
		for (@NonNull OperationRegion region : QVTscheduleUtil.getOwnedOperationRegions(QVTscheduleUtil.getOwningScheduleModel(scheduledRegion))) {
			region.accept(this);
		}
		//	LoadingRegion loadingRegion = scheduledRegion.getOwnedLoadingRegion();
		//	if (loadingRegion != null) {
		//		loadingRegion.accept(this);
		//	}
		showScheduledRegionInternals(scheduledRegion);
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