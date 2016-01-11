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

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

/**
 * Node provides the analysis and status of a node in the pattern match or construction of a Mapping
 * or Composite Region.
 */
public interface Node extends GraphStringBuilder.GraphNode, Nameable
{
	void addIncomingConnection(@NonNull Connection connection);
	void addIncomingEdge(@NonNull Edge edge);
	void addOutgoingConnection(@NonNull Connection connection);
	void addOutgoingEdge(@NonNull Edge edge);
//	void cloneIn(@NonNull Region clonedRegion, @NonNull Map<Node, Node> node2clone);
	void destroy();
	
	/**
	 * Accumulate this node and all passed binding sources in the call-tree ancestry of this node.
	 * On completion there is exactly one entry per region from each possible call path.
	 */
	void getAllAncestors(@NonNull Set<Node> ancestors);
	@NonNull Iterable<Edge> getArgumentEdges();
	@Nullable Edge getAssignmentEdge(@NonNull Property source2targetProperty);
	@NonNull Iterable<NavigationEdge> getAssignmentEdges();
	@NonNull ClassDatumAnalysis getClassDatumAnalysis();
	@NonNull CompleteClass getCompleteClass();
	@NonNull Iterable<Edge> getComputationEdges();
	@NonNull Iterable<NavigationEdge> getContainerEdges();
	@NonNull Iterable<NavigationEdge> getContainmentEdges();
	@NonNull String getDisplayName();
	@NonNull List<Connection> getIncomingConnections();
	@NonNull List<Edge> getIncomingEdges();
//	@Nullable InterRegionEdge getIncomingPassedBindingEdge();
	@NonNull Iterable<Connection> getIncomingPassedConnections();
	@NonNull Iterable<Connection> getIncomingUsedConnections();
	@NonNull String getLabel();
	@NonNull Iterable<Edge> getMergeableEdges();
	@Override
	@NonNull String getName();
	@Nullable NavigationEdge getNavigationEdge(@NonNull Property source2targetProperty);
	@NonNull Iterable<NavigationEdge> getNavigationEdges();
	@Nullable Node getNavigationTarget(@NonNull Property source2targetProperty);
	@NonNull Iterable<Node> getNavigationTargets();
	@NonNull NodeRole getNodeRole();
	@NonNull List<Connection> getOutgoingConnections();
	@NonNull List<Edge> getOutgoingEdges();
//	@Nullable InterRegionEdge getPassedBindingEdge();
	@NonNull Iterable<Connection> getOutgoingPassedConnections();
	@NonNull Iterable<Connection> getOutgoingUsedBindingEdges();
	
	/**
	 * Get all sources that pass a value to this target.
	 */
	@NonNull Iterable<Node> getPassedBindingSources();
	
	/**
	 * Get all targets that are passed a value from this source.
	 */
	@NonNull Iterable<Node> getPassedBindingTargets();
	@NonNull Iterable<NavigationEdge> getPredicateEdges();
	@NonNull Iterable<Edge> getRecursionEdges();
	
	/**
	 * Get all 'targets' that pass a value to this target recursively.
	 */
	@NonNull Iterable<Node> getRecursionSources();
	
	/**
	 * Get all 'sources' that pass a value to this target recursively.
	 */
	@NonNull Iterable<Node> getRecursionTargets();
	@NonNull Region getRegion();
	@NonNull SchedulerConstants getSchedulerConstants();
	@NonNull Iterable<SimpleNode> getSimpleNodes();
	@NonNull Iterable<TypedElement> getTypedElements();
	@NonNull Iterable<Node> getUsedBindingSources();

	/**
	 * Return true if this node is an attribute value.
	 */
	boolean isAttributeNode();

	/**
	 * Return true if this node is a class value.
	 */
	boolean isClassNode();
	
	boolean isComposed();

	/**
	 * Return true if this node is a constant that can be computed at compile time.
	 * 
	 * isConstant() is exclusive to isLoaded()/isPredicated()/isRealized()
	 */
	boolean isConstant();
	
	/**
	 * Return true if this node is an OCL expression.
	 */
	boolean isExpression();

	/**
	 * Return true if this node is a guard variable or composing head.
	 */
	boolean isGuard();

	/**
	 * Return true if this node is a guard variable.
	 */
	boolean isGuardVariable();

	/**
	 * Return true if this node is part of a head group from which many other nodes are navigable.
	 */
	boolean isHead();

	/**
	 * Return true if this node's dependencies can be resolved within the containing region.
	 * This occurs for 1:N navigations such as an iteration result that computes multiple
	 * results dependent on multiple internally navigable inputs. No need for extra inputs to
	 * be passed; just a need for the navigable inputs to exist.
	 */
	boolean isInternal();

	/**
	 * Return true if this node is a LoopExp iterator.
	 */
	boolean isIterator();

	/**
	 * Return true if this node has a known value, because it is inherently constant, or
	 * is available once sufficient input models have been loaded.
	 */
	boolean isKnown();

	/**
	 * Return true if this node is part of the checkable input domain and so may be loaded at will to satisfy
	 * the requirements of mapping execution.
	 * 
	 * isLoaded() is exclusive to isConstant()/isPredicated()/isRealized()
	 */
	boolean isLoaded();
	
	/**
	 * Return true if this node is part of the to-one navigation path that is matched as part of a mapping's predicate.
	 * 
	 * Regions with conflicting isMatchable() nodes cannot be merged.
	 * 
	 * ?? isConstant() || isLoaded() || isPredicated()
	 */
	boolean isMatchable();
	
	/**
	 * Return true if this node is part of the to-one navigation path that is navigated to determine the navigation heads.
	 */
	boolean isNavigable();

	/**
	 * Return true if this node is a null value.
	 */
	boolean isNull();

	boolean isOperation();

	/**
	 * Return true if the value of this node is part of the navigation path that must be validated
	 * by predicate matching prior to execution of a mapping.
	 * 
	 * isPredicated() is exclusive to isConstant()/isLoaded()/isRealized()
	 */
	boolean isPredicated();

	/**
	 * Return true if the value of this node is determined by execution of a mapping.
	 * 
	 * isRealized() is exclusive to isConstant()/isLoaded()/isPredicated()
	 */
	boolean isRealized();

	/**
	 * Return true if this is a RealizedVariableNode
	 */
	boolean isRealizedVariable();
	
	/**
	 * Return true if this is a ResultNode computed by some expression.
	 */
	boolean isResult();

	/**
	 * Return true if this is a TrueNode that terminates a complex predicate expression.
	 */
	boolean isTrue();
	
	boolean refineClassDatumAnalysis(@NonNull ClassDatumAnalysis newClassDatumAnalysis);
	void removeIncomingConnection(@NonNull Connection connection);
	void removeIncomingEdge(@NonNull Edge edge);
	void removeOutgoingConnection(@NonNull Connection connection);
	void removeOutgoingEdge(@NonNull Edge edge);
	
	void setHead();
}