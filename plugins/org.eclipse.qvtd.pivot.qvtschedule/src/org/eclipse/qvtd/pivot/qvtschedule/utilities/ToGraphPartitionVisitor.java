/*******************************************************************************
 * Copyright (c) 2016, 2020 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.util.Visitor;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphElement;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtschedule.BasicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionRole;
import org.eclipse.qvtd.pivot.qvtschedule.CyclicPartition;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingPartition;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RootPartition;
import org.eclipse.qvtd.pivot.qvtschedule.RootRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;

import com.google.common.collect.Lists;

/**
 * ToGraphPartitionVisitor refines ToGraphVisitor to display <<success>> nodes in the partition-specific form.
 */
public abstract class ToGraphPartitionVisitor extends AbstractToGraphVisitor
{
	public static @NonNull AbstractToGraphVisitor createVisitor(@NonNull GraphStringBuilder s, boolean showInternals) {
		if (showInternals) {
			return new ShowInternals(s);
		}
		else {
			return new HideInternals(s);
		}
	}

	private static class HideInternals extends ToGraphPartitionVisitor
	{
		protected HideInternals(@NonNull GraphStringBuilder context) {
			super(context);
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
			if (hasPartitions) {			// Partition-to-Partition within RootRegion
				appendNode(connection);
				for (@NonNull Partition sourcePartition : connection.getSourcePartitions()) {
					Partition mergedSourcePartition = QVTscheduleUtil.getMergedPartition(sourcePartition);
					if (mergedSourcePartition == sourcePartition) {
						appendEdge(sourcePartition, connection, connection);
					}
				}
				Iterable<@NonNull Partition> targetPartitions = connection.getTargetPartitions();
				for (@NonNull Partition targetPartition : targetPartitions) {
					Partition mergedTargetPartition = QVTscheduleUtil.getMergedPartition(targetPartition);
					if (mergedTargetPartition == targetPartition) {
						Iterable<@NonNull ConnectionEnd> connectionEnds = connection.getTargetConnectionEnds(targetPartition);
						for (@NonNull ConnectionEnd connectionEnd : connectionEnds) {
							ConnectionRole connectionRole = connection.getTargetConnectionRole(targetPartition, connectionEnd);
							appendEdge(connection, connectionRole, targetPartition);
						}
					}
				}
			}
			else {							// Region-to-Region within RootRegion
				RootRegion rootRegion = connection.getOwningRootRegion();
				appendNode(connection);
				for (@NonNull Node sourceNode : connection.getSourceNodes()) {
					Region sourceRegion = rootRegion.getNormalizedRegion(QVTscheduleUtil.getOwningRegion(sourceNode));
					if (sourceRegion != null) {
						appendEdge(sourceRegion, connection, connection);
					}
				}
				for (@NonNull ConnectionEnd target : connection.getTargetEnds()) {
					ConnectionRole role = connection.getTargetRole(target);
					assert role != null;
					Region targetRegion = rootRegion.getNormalizedRegion(QVTscheduleUtil.getOwningRegion(target));
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
		protected ShowInternals(@NonNull GraphStringBuilder context) {
			super(context);
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
			List<@NonNull Node> nodesList = Lists.newArrayList(partition.getPartialNodes());
			Collections.sort(nodesList, NODE_COMPARATOR);
			for (@NonNull Node node : nodesList) {
				node.accept(this);
			}
			List<@NonNull Edge> edgesList = Lists.newArrayList(partition.getPartialEdges());
			Collections.sort(edgesList, EDGE_COMPARATOR);
			for (@NonNull Edge edge : edgesList) {
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
			List<@NonNull Node> nodesList = Lists.newArrayList(QVTscheduleUtil.getOwnedNodes(region));
			Collections.sort(nodesList, NODE_COMPARATOR);
			for (@NonNull Node node : nodesList) {
				node.accept(this);
			}
			List<@NonNull Edge> edgesList = Lists.newArrayList(QVTscheduleUtil.getOwnedEdges(region));
			Collections.sort(edgesList, EDGE_COMPARATOR);
			for (@NonNull Edge edge : edgesList) {
				edge.accept(this);
			}
			context.popCluster();
		}

		@Override
		public @Nullable String visitConnection(@NonNull Connection connection) {
			if (hasPartitions) {			// Node-to-Node within Partition within RootRegion
				setScope(null);
				RootRegion rootRegion = connection.getOwningRootRegion();
				appendNode(connection);
				for (@NonNull ConnectionEnd sourceEnd : QVTscheduleUtil.getSourceEnds(connection)) {
					Region sourceRegion = QVTscheduleUtil.getOwningRegion(sourceEnd);
					Iterable<@NonNull MappingPartition> partitions = null;
					if (sourceRegion instanceof MappingRegion) {
						partitions = QVTscheduleUtil.getMappingPartitions(((MappingRegion)sourceRegion));
					}
					else if (sourceRegion instanceof LoadingRegion) {
						partitions = Collections.singletonList(QVTscheduleUtil.getLoadingPartition(((LoadingRegion)sourceRegion)));
					}
					if (partitions != null) {
						for (@NonNull Partition sourcePartition : partitions) {
							Role sourceRole = QVTscheduleUtil.getRole(sourcePartition, sourceEnd);
							if ((sourceRole != null) && !sourceRole.isChecked() && !sourceRole.isConstant()) { // (sourceRole.isNew() || sourceRole.isLoaded())) {
								Node sourceNode;
								if (sourceEnd instanceof Edge) {
									sourceNode = QVTscheduleUtil.getTargetNode((Edge) sourceEnd);
								}
								else {
									sourceNode = (@NonNull Node) sourceEnd;
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
						if (!sourceRole.isChecked()) { //sourceRole.isNew() || sourceRole.isLoaded()) {
							appendEdge(sourceNode, connection, connection);
						}
					}
				}
				for (@NonNull ConnectionEnd target : connection.getTargetEnds()) {
					ConnectionRole connectionRole = connection.getTargetRole(target);
					assert connectionRole != null;
					Region targetRegion = rootRegion.getNormalizedRegion(QVTscheduleUtil.getOwningRegion(target));
					if (targetRegion != null) {
						Iterable<@NonNull MappingPartition> partitions = null;
						if (targetRegion instanceof MappingRegion) {
							partitions = QVTscheduleUtil.getMappingPartitions((MappingRegion)targetRegion);
						}
						if (partitions != null) {
							for (@NonNull Partition targetPartition : partitions) {
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
				}
				setScope(null);
			}
			else {							// Node-to-Node within Region within RootRegion
				appendNode(connection);
				for (@NonNull Node sourceNode : connection.getSourceNodes()) {
					appendEdge(sourceNode, connection, connection);
				}
				for (@NonNull ConnectionEnd target : connection.getTargetEnds()) {
					ConnectionRole role = connection.getTargetRole(target);
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

	protected boolean hasPartitions = false;
	protected @Nullable Partition partition = null;

	protected ToGraphPartitionVisitor(@NonNull GraphStringBuilder context) {
		super(context);
	}

	@Override
	protected @NonNull String getColor(@NonNull GraphElement element) {
		Utility utility;
		if (element instanceof Node) {
			utility = ((Node)element).getUtility();
		}
		else if (element instanceof Edge) {
			utility = ((Edge)element).getUtility();
		}
		else if (element instanceof Connection) {
			utility = null;
		}
		else if (element instanceof ConnectionRole) {
			utility = null;
		}
		else {
			utility = Utility.NOT_KNOWN;
		}
		if (utility == Utility.NOT_KNOWN) {
			return QVTscheduleUtil.ERROR_COLOR;
		}
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

	protected void showRootRegionInternals(@NonNull RootRegion rootRegion) {
		RootPartition rootPartition = rootRegion.getOwnedRootPartition();
		if (rootPartition == null) {
			for (@NonNull Region region : QVTscheduleUtil.getActiveRegions(rootRegion)) {
				region.accept((Visitor<?>)this);
			}
		}
		else {
			rootPartition.accept((Visitor<?>)this);
		}
	}

	@Override
	public @Nullable String visitBasicPartition(@NonNull BasicPartition basicPartition) {
		if (basicPartition.getOwningMergedPartition() == null) {
			super.visitBasicPartition(basicPartition);
		}
		return null;
	}

	@Override
	public @Nullable String visitCyclicPartition(@NonNull CyclicPartition cyclicPartition) {
		for (@NonNull MappingPartition partition : QVTscheduleUtil.getOwnedMappingPartitions(cyclicPartition)) {
			setScope(partition);
			partition.accept((Visitor<?>)this);
		}
		return null;
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
			context.setColor(QVTscheduleConstants.PARTITION_COLOR);
			showPartitionInternals(partition);
			return null;
		}
		finally {
			this.partition = null;
		}
	}

	@Override
	public @Nullable String visitRootPartition(@NonNull RootPartition rootPartition) {
		for (@NonNull MappingPartition partition : QVTscheduleUtil.getOwnedMappingPartitions(rootPartition)) {
			setScope(partition);
			partition.accept((Visitor<?>)this);
		}
		return null;
	}

	@Override
	public @Nullable String visitRegion(@NonNull Region region) {
		context.setLabel(region.getName());
		context.setColor(QVTscheduleConstants.PARTITION_COLOR);
		showRegionInternals(region);
		return null;
	}

	@Override
	public @Nullable String visitRootRegion(@NonNull RootRegion rootRegion) {
		RootPartition rootPartition = rootRegion.getOwnedRootPartition();
		hasPartitions = rootPartition != null;
		context.setLabel(rootRegion.getName());
		context.setColor(QVTscheduleConstants.PARTITION_COLOR);
		context.pushCluster();
		for (@NonNull OperationRegion region : QVTscheduleUtil.getOwnedOperationRegions(QVTscheduleUtil.getOwningScheduleModel(rootRegion))) {
			region.accept((Visitor<?>)this);
		}
		//	LoadingRegion loadingRegion = rootRegion.getOwnedLoadingRegion();
		//	if (loadingRegion != null) {
		//		loadingRegion.accept(this);
		//	}
		showRootRegionInternals(rootRegion);
		List<@NonNull Node> nodesList = Lists.newArrayList(QVTscheduleUtil.getOwnedNodes(rootRegion));
		Collections.sort(nodesList, NODE_COMPARATOR);
		for (@NonNull Node node : nodesList) {
			appendNode(node);
		}
		List<@NonNull Edge> edgesList = Lists.newArrayList(QVTscheduleUtil.getOwnedEdges(rootRegion));
		Collections.sort(edgesList, EDGE_COMPARATOR);
		for (@NonNull Edge edge : edgesList) {
			appendEdge(edge.getEdgeSource(), edge, edge.getEdgeTarget());
		}
		List<@NonNull Connection> connectionsList = Lists.newArrayList(QVTscheduleUtil.getOwnedConnections(rootRegion));
		Collections.sort(connectionsList, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Connection connection : connectionsList) {
			connection.accept(this);
		}
		context.popCluster();
		return null;
	}
}