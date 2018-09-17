/*******************************************************************************
 * Copyright (c) 2016, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.AbstractPartialRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphElement;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtbase.graphs.ToDOT;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.ToGraphVisitor;

import com.google.common.collect.Iterables;

abstract class AbstractPartition extends AbstractPartialRegionAnalysis<@NonNull Partition> implements Partition
{
	protected class ToGraphPartitionVisitor extends ToGraphVisitor
	{
		protected ToGraphPartitionVisitor(@NonNull GraphStringBuilder context) {
			super(context);
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
				role = getRole((Node)element);
			}
			else if (element instanceof Edge) {
				role = getRole((Edge)element);
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
		protected boolean isHead(GraphNode graphNode) {
			return Iterables.contains(getHeadNodes(), graphNode);
		}

		public @Nullable String visitPartition(@NonNull Partition partition) {
			context.setLabel(partition.getName());
			context.pushCluster();
			for (@NonNull Node node : partition.getPartialNodes()) {
				node.accept(this);
				//			s.appendNode(node);
			}
			for (@NonNull Edge edge : partition.getPartialEdges()) {
				edge.accept(this);
				//			s.appendEdge(edge.getSource(), edge, edge.getTarget());
			}
			context.popCluster();
			return null;
		}
	}

	protected final @NonNull MappingPartitioner partitioner;
	protected final @NonNull RegionAnalysis regionAnalysis;
	protected final @NonNull Region originalRegion;
	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;
	private int parallelScheduleDepth = -1;

	private @Nullable String symbolName = null;

	@SuppressWarnings("unused")			// Used in the debugger
	private final @NonNull ToDOT toDot = new ToDOT(this){};

	protected AbstractPartition(@NonNull MappingPartitioner partitioner) {
		super(partitioner.getRegionsPartitionAnalysis());
		this.partitioner = partitioner;
		this.regionAnalysis = partitioner.getRegionAnalysis();
		this.originalRegion = regionAnalysis.getRegion();
		this.transformationAnalysis = regionAnalysis.getTransformationAnalysis();
	}

	@Override
	public void analyzePartition() {
		analyze();
	}

	@Override
	public int getDepth() {
		assert parallelScheduleDepth >= 0;
		return parallelScheduleDepth;
	}

	@Override
	public @Nullable Iterable<@NonNull Partition> getExplicitPredecessors() {
		return null;
	}

	protected abstract @NonNull Iterable<@NonNull Node> getHeadNodes();

	@Override
	public @NonNull Region getOriginalRegion() {
		return originalRegion;
	}

	@Override
	public final @NonNull String getSymbolName() {
		String symbolName2 = symbolName;
		if (symbolName2 == null) {
			symbolName = symbolName2 = getName();
			assert symbolName2 != null;
		}
		return symbolName2;
	}

	//	@Override
	//	public @NonNull Region getRegion() {
	//		return region;
	//	}

	@Override
	public void setDepth(int parallelScheduleDepth) {
		this.parallelScheduleDepth = parallelScheduleDepth;
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		ToGraphPartitionVisitor visitor = new ToGraphPartitionVisitor(s);
		visitor.visitPartition(this);
	}

	//	@Override
	//	public String toString() {
	//		return region.toString();
	//	}
}