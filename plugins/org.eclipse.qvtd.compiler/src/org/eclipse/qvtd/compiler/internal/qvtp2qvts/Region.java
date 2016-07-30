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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Region2Depth;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder.GraphNode;

public interface Region extends Visitable, GraphNode, Nameable, Symbolable
{
	void addCallToChild(@NonNull Region region);
	void addEdge(@NonNull Edge edge);
	void addEnforcedEdge(@NonNull NavigationEdge realizedEdge);
	boolean addIndex(int index);
	void addIntermediateConnection(@NonNull NodeConnection connection);
	void addNode(@NonNull Node node);
	void addRootConnection(@NonNull NodeConnection connection);
	void buildPredicatedNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigationEdge>>> typedModel2property2predicatedEdges);
	void buildRealizedNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigationEdge>>> typedModel2property2realizedEdges);
	@Nullable Map<@NonNull Node, @NonNull Node> canMerge(@NonNull Region secondaryRegion, @NonNull Region2Depth region2depths, boolean isLateMerge);
	void checkIncomingConnections();
	void computeCheckedOrEnforcedEdges(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigationEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigationEdge>>> typedModel2property2realizedEdges);
	void createIncomingConnections();
	@NonNull VariableNode createVariableNode(@NonNull NodeRole NodeRole, @NonNull VariableDeclaration variable);

	/**
	 * Return all the nodes in this region that are call-tree ancestors of node.
	 */
	@NonNull Iterable<@NonNull Node> getAncestorsOf(@NonNull Node node);
	@NonNull Iterable<@NonNull Node> getAssignedNodes();

	/**
	 * Return the regions that this region can actually call directly after taking account the connection dependencies.
	 */
	@NonNull Iterable<@NonNull Region> getCallableChildren();

	/**
	 * Return the regions that can actually call this region directly after taking account the connection dependencies.
	 */
	@NonNull Iterable<@NonNull Region> getCallableParents();

	/**
	 * Return the regions that this region calls.
	 */
	@NonNull Iterable<@NonNull Region> getCalledRegions();

	/**
	 * Return the regions the call this region.
	 */
	@NonNull Iterable<@NonNull Region> getCallingRegions();
	@Nullable Iterable<@NonNull NavigationEdge> getCheckedEdges(@NonNull TypedModel typedModel);
	@NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull TypedElement typedElement);
	@NonNull String getColor();
	@NonNull Iterable<@NonNull Node> getComposedNodes();
	@NonNull Collection<@NonNull Edge> getEdges();
	@Nullable Iterable<@NonNull NavigationEdge> getEnforcedEdges(@NonNull TypedModel typedModel);

	@NonNull Iterable<@NonNull Edge> getExpressionEdges();

	/**
	 * The schedule index at which the latest dependent becomes available and consequently the latest that deferred execution may occur.
	 */
	int getFinalExecutionIndex();

	/**
	 * Return the Guard nodes of the region (GuardVariable or Composing)
	 */
	@NonNull Iterable<@NonNull Node> getGuardNodes();

	/**
	 * Return the GuardVariable nodes of the region (not Composing)
	 */
	@NonNull Iterable<@NonNull Node> getGuardVariableNodes();
	//	@NonNull List<@NonNull NodeConnection> getHeadConnections();
	@NonNull List<@NonNull Node> getHeadNodes();
	@NonNull Iterable<@NonNull DatumConnection> getIncomingConnections();
	@NonNull Iterable<@NonNull NodeConnection> getIncomingPassedConnections();
	@NonNull Iterable<@NonNull NodeConnection> getIncomingUsedConnections();
	@NonNull String getIndexRangeText();
	@NonNull List<@NonNull Integer> getIndexes();
	@NonNull List<@NonNull NodeConnection> getIntermediateConnections();

	/**
	 * The schedule index at which ALL invocations of this region occur.
	 */
	int getInvocationIndex();
	@Nullable ScheduledRegion getInvokingRegion();
	@NonNull List<@NonNull DatumConnection> getLoopingConnections();

	/**
	 * Return the nodes that are matched or evaluated by the region's predicate.
	 */
	@NonNull Iterable<@NonNull Node> getMatchableNodes();

	@NonNull MultiRegion getMultiRegion();
	@Override
	@NonNull String getName();
	/**
	 * Return the nodes that are navigated by navigation from the region's guards.
	 */
	@NonNull Iterable<@NonNull Node> getNavigableNodes();
	@NonNull Iterable<@NonNull NavigationEdge> getNavigationEdges();
	/**
	 * Return all the next connections from this region to another region.
	 * Where this is a hierarchical region the connections are those from the hierarchical head to its immediate internal regions.
	 */
	@NonNull Iterable<@NonNull DatumConnection> getNextConnections();

	@NonNull Collection<@NonNull Node> getNodes();

	/**
	 * Return all connections from this (hierarchical) region to another (hierarchical) region.
	 */
	@NonNull Iterable<@NonNull DatumConnection> getOutgoingConnections();
	@NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections();
	@NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedConnections();
	@NonNull Iterable<@NonNull Node> getPredicatedNodes();
	@NonNull Iterable<@NonNull NavigationEdge> getPredicatedNavigationEdges();
	@NonNull Iterable<@NonNull Edge> getRealizedEdges();
	@NonNull Iterable<@NonNull NavigationEdge> getRealizedNavigationEdges();
	@NonNull Iterable<@NonNull Node> getRealizedNodes();
	@NonNull Iterable<@NonNull Node> getRealizedVariableNodes();
	@NonNull Iterable<@NonNull Edge> getRecursionEdges();
	@NonNull List<@NonNull NodeConnection> getRootConnections();
	@NonNull SchedulerConstants getSchedulerConstants();
	@Nullable String getShape();
	@Nullable String getStyle();
	@NonNull Iterable<@NonNull Node> getTrueNodes();

	/**
	 * Return the regions that this region uses and how many times.
	 */
	@NonNull List<@NonNull NodeConnection> getUsedConnections();
	boolean isChildCompositionRegion();
	boolean isCyclicScheduledRegion();
	boolean isOperationRegion();
	boolean isRootCompositionRegion();
	boolean isLateMergeable(@NonNull Region region, @NonNull Region2Depth region2depths);
	void refineBindings(@NonNull Region bindingRegion);
	void removeEdge(@NonNull Edge edge);
	void removeNode(@NonNull Node node);
	void resetHead(@NonNull Node headNode);
	void setInvokingRegion(@NonNull ScheduledRegion invokingRegion);
	//	void setIsCyclic();
	void toCallGraph(@NonNull GraphStringBuilder s);
	void toGraph(@NonNull GraphStringBuilder s);
	void toRegionGraph(@NonNull GraphStringBuilder s);
}