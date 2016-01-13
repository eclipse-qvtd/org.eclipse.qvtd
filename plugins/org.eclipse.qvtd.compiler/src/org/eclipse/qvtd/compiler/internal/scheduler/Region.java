/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder.GraphNode;

public interface Region extends Visitable, GraphNode, Nameable, Schedulable
{		
	void addCallToChild(@NonNull Region region);
	void addEdge(@NonNull Edge edge);
	void addEnforcedEdge(@NonNull NavigationEdge realizedEdge);
	void addIntermediateConnection(@NonNull Connection connection);
	void addNode(@NonNull Node node);
	void addRootConnection(@NonNull Connection connection);
	void buildPredicatedNavigationEdgesIndex(@NonNull Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2predicatedEdges);
	void buildRealizedNavigationEdgesIndex(@NonNull Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2realizedEdges);
	@Nullable Map<Node, Node> canMerge(@NonNull Region secondaryRegion, @NonNull Region2Depth region2depths, boolean isLateMerge);

	void computeCheckedOrEnforcedEdges(@NonNull Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<TypedModel, @NonNull Map<Property, @NonNull List<NavigationEdge>>> typedModel2property2realizedEdges);
	@NonNull Iterable<MappingRegion> getAllMappingRegions();
	
	/**
	 * Return all the nodes in this region that are call-tree ancestors of node.
	 */
	@NonNull Iterable<Node> getAncestorsOf(@NonNull Node node);
	@NonNull Iterable<Node> getAssignedNodes();
	
	/**
	 * Return the regions that this region can actually call directly after taking account the connection dependencies.
	 */
	@NonNull Iterable<Region> getCallableChildren();
	
	/**
	 * Return the regions that can actually call this region directly after taking account the connection dependencies.
	 */
	@NonNull Iterable<Region> getCallableParents();
	
	/**
	 * Return the regions that this region calls.
	 */
	@NonNull Iterable<Region> getCalledRegions();

	/**
	 * Return the regions the call this region.
	 */
	@NonNull Iterable<Region> getCallingRegions();
	@Nullable Iterable<NavigationEdge> getCheckedEdges(@NonNull TypedModel typedModel);
	@NonNull List<Connection> getChildConnections();
	@NonNull List<Connection> getChildPassedConnections();
	@NonNull List<Connection> getChildUsedBindingEdges();
	@NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull TypedElement typedElement);
	@NonNull String getColor();
	@NonNull Iterable<Node> getComposedNodes();
	@NonNull Collection<Edge> getEdges();
	@Nullable Iterable<NavigationEdge> getEnforcedEdges(@NonNull TypedModel typedModel);

	@NonNull Iterable<Edge> getExpressionEdges();
	/**
	 * Return the Guard nodes of the region (GuardVariable or Composing)
	 */
	@NonNull Iterable<Node> getGuardNodes();

	/**
	 * Return the GuardVariable nodes of the region (not Composing)
	 */
	@NonNull Iterable<Node> getGuardVariableNodes();
	@NonNull List<List<Node>> getHeadNodeGroups();
	@NonNull List<Connection> getIntermediateConnections();
	@Nullable Region getInvokingRegion();
	
	/**
	 * Return the nodes that are matched or evaluated by the region's predicate.
	 */
	@NonNull Iterable<Node> getMatchableNodes();
	
	@NonNull Iterable<MergeableRegion> getMergeableRegions();
	
	/**
	 * Return the nodes that are navigated by navigation from the region's guards.
	 */
	@NonNull Iterable<Node> getNavigableNodes();
	@NonNull Iterable<NavigationEdge> getNavigationEdges();
	
	@NonNull Collection<Node> getNodes();
	@NonNull List<Connection> getParentConnections();
	@NonNull List<Connection> getParentPassedConnections();
	@NonNull List<Connection> getParentUsedConnections();
	@NonNull Iterable<Node> getPredicatedNodes();
	@NonNull Iterable<NavigationEdge> getPredicatedNavigationEdges();
	@NonNull Iterable<Edge> getRealizedEdges();
	@NonNull Iterable<NavigationEdge> getRealizedNavigationEdges();
	@NonNull Iterable<Node> getRealizedNodes();
	@NonNull Iterable<Node> getRealizedVariableNodes();
	@NonNull Iterable<Edge> getRecursionEdges();
	@NonNull List<Connection> getRootConnections();
	@NonNull SchedulerConstants getSchedulerConstants();
	@Nullable String getShape();
	@Nullable String getStyle();
	@NonNull SuperRegion getSuperRegion();
	@NonNull Iterable<Node> getTrueNodes();

	/**
	 * Return the regions that this region uses and how many times.
	 */
	@NonNull List<Connection> getUsedConnections();
	boolean isCompositionRegion();
	boolean isOperationRegion();
	boolean isRootRegion();
	boolean isLateMergeable(@NonNull Region region, @NonNull Region2Depth region2depths);
	void refineBindings(@NonNull Region bindingRegion);
	void removeEdge(@NonNull Edge edge);
	void removeNode(@NonNull Node node);
	void setInvokingRegion(@NonNull Region invokingRegion);
	String toDOT();
	void toGraph(@NonNull GraphStringBuilder s);
	String toGraphML();
}