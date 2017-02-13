/**
 * <copyright>
 *
 * Copyright (c) 2013, 2017 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *
 * </copyright>
 */
package org.eclipse.qvtd.pivot.qvtschedule;

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * AbstractNode provides the analysis and status of a node in the pattern match or construction of a Mapping
 * or Composite Region.
 * <!-- end-model-doc -->
 *
 *
 * @see org.eclipse.qvtd.pivot.qvtschedule.QVTschedulePackage#getNode()
 * @model abstract="true" superTypes="org.eclipse.ocl.pivot.Element org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd org.eclipse.qvtd.pivot.qvtschedule.GraphNode org.eclipse.ocl.pivot.Nameable"
 * @generated
 */
public interface Node extends Element, ConnectionEnd, GraphNode, Nameable
{
	/**
	 * The prioritized utility of each node.
	 */
	public enum Utility {
		STRONGLY_MATCHED,				// Reachable by to-1 navigation from a head node, or by to-? to an ExplicitNull
		WEAKLY_MATCHED,					// else unconditionally used in a computation or navigation
		//		UNCONDITIONALLY_PREDICATING,	// else always computable as part of a predicate
		//		CONDITIONALLY_PREDICATING,		// else selectively computable as part of a predicate depending on if conditions
		//		UNCONDITIONALLY_COMPUTED,		// else always computable
		CONDITIONAL,					// else selectively computable depending on if conditions / loops
		DEPENDENCY,						// else solely used to establish a dependency
		DEAD							// else never used
	}

	void addIncomingConnection(@NonNull NodeConnection connection);
	void addIncomingEdge(@NonNull Edge edge);
	void addOutgoingConnection(@NonNull NodeConnection connection);
	void addOutgoingEdge(@NonNull Edge edge);
	void addTypedElement(@NonNull TypedElement typedElement);

	/**
	 * Create a new nodeRole node in region with the saem name, type etc as this node.
	 */
	@NonNull Node createNode(@NonNull NodeRole nodeRole, @NonNull Region region);
	void destroy();

	/**
	 * Accumulate this node and all passed binding sources in the call-tree ancestry of this node.
	 * On completion there is exactly one entry per region from each possible call path.
	 */
	void getAllAncestors(@NonNull Set<@NonNull Node> ancestors);
	@NonNull Iterable<@NonNull Edge> getArgumentEdges();
	@NonNull Iterable<@NonNull NavigableEdge> getCastEdges();
	@NonNull ClassDatumAnalysis getClassDatumAnalysis();
	@NonNull CompleteClass getCompleteClass();
	@NonNull Iterable<@NonNull Edge> getComputationEdges();
	@Nullable NodeConnection getIncomingConnection();
	@NonNull List<@NonNull Edge> getIncomingEdges();
	@Nullable NodeConnection getIncomingPassedConnection();
	@Nullable NodeConnection getIncomingUsedConnection();
	@NonNull String getLabel();
	@Override
	@NonNull String getName();
	@Nullable NavigableEdge getNavigationEdge(@NonNull Property source2targetProperty);
	@NonNull Iterable<@NonNull NavigableEdge> getNavigationEdges();
	@Nullable Node getNavigationTarget(@NonNull Property source2targetProperty);
	@NonNull Iterable<@NonNull Node> getNavigationTargets();
	@NonNull NodeRole getNodeRole();
	@NonNull List<@NonNull NodeConnection> getOutgoingConnections();
	@NonNull List<@NonNull Edge> getOutgoingEdges();
	@NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections();
	@NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedBindingEdges();
	//	@Nullable InterRegionEdge getPassedBindingEdge();

	/**
	 * Get all sources that pass a value to this target.
	 */
	@NonNull Iterable<@NonNull Node> getPassedBindingSources();

	/**
	 * Get all targets that are passed a value from this source.
	 */
	@NonNull Iterable<@NonNull Node> getPassedBindingTargets();
	@Nullable Edge getPredicateEdge(@NonNull Property source2targetProperty);
	@NonNull Iterable<@NonNull NavigableEdge> getPredicateEdges();
	@NonNull Iterable<@NonNull NavigableEdge> getRealizedNavigationEdges();
	@NonNull Iterable<@NonNull Edge> getRecursionEdges();

	/**
	 * Get all 'targets' that pass a value to this target recursively.
	 */
	@NonNull Iterable<@NonNull Node> getRecursionSources();

	/**
	 * Get all 'sources' that pass a value to this target recursively.
	 */
	@NonNull Iterable<@NonNull Node> getRecursionTargets();
	@NonNull Iterable<@NonNull ? extends Edge> getResultEdges();
	@NonNull Iterable<@NonNull TypedElement> getTypedElements();
	@NonNull Iterable<@NonNull Node> getUsedBindingSources();
	@NonNull Utility getUtility();

	/**
	 * Return true if this node is a Class object.
	 */
	boolean isClass();

	boolean isComposed();

	/**
	 * Return true if this node is a constant that can be computed at compile time.
	 *
	 * isConstant() is exclusive to isLoaded()/isSpeculation()/isSpeculated()/isPredicated()/isRealized()
	 */
	boolean isConstant();

	/**
	 * Return true if this node is a realized node with a corresponding relaized edge to a container.
	 */
	boolean isContained();

	/**
	 * Return true if this node is a DataType value.
	 */
	boolean isDataType();

	/**
	 * Return true if this node is a dependency; something from another region used by a computation for this node's region.
	 * A tree of dependency nodes and edges may provide an incoming edge for an operation to express the hidden computations of the operation.
	 */
	boolean isDependency();

	/**
	 * Return true if this node is an explicitly null value.
	 */
	boolean isExplicitNull();

	/**
	 * Return true if this node is part of an OCL expression; an iteration or operation other than
	 * oclAsType().
	 */
	boolean isExpression();

	/**
	 * Return true if this node is part of a head group from which many other nodes are navigable.
	 */
	boolean isHead();

	/**
	 * Return true if this node is a LoopExp iterator.
	 */
	boolean isIterator();

	/**
	 * Return true if this node is part of the checkable input domain and so may be loaded at will to satisfy
	 * the requirements of mapping execution.
	 *
	 * isLoaded() is exclusive to isConstant()/isPredicated()/isSpeculation()/isSpeculated()/isRealized()
	 */
	boolean isLoaded();

	/**
	 * Return true if after execution this node exactly corresponds to a non-null object or to a non-null value or to an explicit null.
	 * Conversely return false if this node is optionally null or part of a conditional expression evaluation.
	 * Collections are never null-valued, not even empty collections.
	 *
	 * *deprecated try to use isUnconditional or getUtility
	 */
	boolean isMatched();

	/**
	 * Return true if this node is for a speculation/realized element.
	 */
	boolean isNew();

	/**
	 * Return true if this node is for a constant/loaded/predicated/speculated element.
	 */
	boolean isOld();

	boolean isOperation();

	/**
	 * Return true if this node is a pattern variable (class/datatype/null/true).
	 */
	boolean isPattern();

	/**
	 * Return true if the value of this node is part of the navigation path that must be validated
	 * by predicate matching prior to execution of a mapping.
	 *
	 * isPredicated() is exclusive to isConstant()/isLoaded()/isSpeculation()/isSpeculated()/isRealized()
	 */
	boolean isPredicated();

	/**
	 * Return true if the value of this node is determined by execution of a mapping.
	 *
	 * isRealized() is exclusive to isConstant()/isLoaded()/isSpeculation()/isSpeculated()/isPredicated()
	 */
	boolean isRealized();

	/**
	 * Return true if this is a required element, i.e. it has a TypedElement with a non-zetro lowrr bound.
	 */
	boolean isRequired();

	/**
	 * Return true if this node is a speculated middle trace element that may havew benn created in anticipation
	 * of other dependencies.
	 *
	 * isSpeculated() is exclusive to isConstant()/isLoaded()/isSpeculation()/isPredicated()/isRealized()
	 */
	boolean isSpeculated();

	/**
	 * Return true if this node is a/the speculation of the realized middle trace element that is created in anticipation
	 * of other dependencies.
	 *
	 * isSpeculation() is exclusive to isConstant()/isLoaded()/isPredicated()/isSpeculated()/isPredicated()/isRealized()
	 */
	boolean isSpeculation();

	/**
	 * Return true if this is a TrueNode that terminates a complex predicate expression.
	 */
	boolean isTrue();

	/**
	 * Return true if this node is unconditionally used in a computation of navigation. .e it does not form
	 * part of a loop or a then/else arm.
	 */
	boolean isUnconditional();

	boolean refineClassDatumAnalysis(@NonNull ClassDatumAnalysis newClassDatumAnalysis);
	void removeIncomingConnection(@NonNull NodeConnection connection);
	void removeIncomingEdge(@NonNull Edge edge);
	void removeOutgoingConnection(@NonNull NodeConnection connection);
	void removeOutgoingEdge(@NonNull Edge edge);

	/**
	 * Redesignate a head node as not-a-head, typically following a multi-headed split.
	 */
	void resetHead();

	void setContained(boolean isContained);

	/**
	 * Redesignate a guard node as a head.
	 */
	void setHead();

	void setUtility(@NonNull Utility utility);

	void toGraph(@NonNull GraphStringBuilder s);
} // Node
