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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.CompleteModel;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.schedule2qvti.QVTs2QVTiVisitor;
import org.eclipse.qvtd.compiler.internal.utilities.ToDOT;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.utilities.DOTStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public abstract class AbstractRegion implements Region, ToDOT.ToDOTable
{		
	public static class EarliestRegionComparator implements Comparator<Region>
	{
		public static final @NonNull EarliestRegionComparator INSTANCE = new EarliestRegionComparator();

		public static @NonNull List<Region> sort(@NonNull Iterable<Region> regions) {
			List<Region> sortedRegions = new ArrayList<Region>();
			Iterables.addAll(sortedRegions, regions);
			Collections.sort(sortedRegions, INSTANCE);
			return sortedRegions;
		}
		
		@Override
		public int compare(Region o1, Region o2) {
			int i1 = o1.getEarliestIndex();
			int i2 = o2.getEarliestIndex();
			return i1 - i2;
		}
	}

	public static final class EdgeSourceFunction implements Function<Edge, Node>
	{
		public static final @NonNull EdgeSourceFunction INSTANCE = new EdgeSourceFunction();

		@Override
		public Node apply(Edge edge) {
			return edge.getSource();
		}
	}

	public static final class EdgeTargetFunction implements Function<Edge, Node>
	{
		public static final @NonNull EdgeTargetFunction INSTANCE = new EdgeTargetFunction();

		@Override
		public Node apply(Edge edge) {
			return edge.getTarget();
		}
	}

	public static final class IsAssignedNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsAssignedNodePredicate INSTANCE = new IsAssignedNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isRealized();
		}
	}

	public static final class IsAssignmentEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsAssignmentEdgePredicate INSTANCE = new IsAssignmentEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isRealized();
		}
	}

	public static final class IsCastEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsCastEdgePredicate INSTANCE = new IsCastEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isCast();
		}
	}

	public static final class IsComposedNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsComposedNodePredicate INSTANCE = new IsComposedNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isComposed();
		}
	}

/*	public static final class IsComposedOrderingEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsComposedOrderingEdgePredicate INSTANCE = new IsComposedOrderingEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isComposedOrdering();
		}
	} */

	public static final class IsComputationEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsComputationEdgePredicate INSTANCE = new IsComputationEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isComputation();
		}
	}

	public static final class IsComputedPredicate implements Predicate<Node>
	{
		public static final @NonNull IsComputedPredicate INSTANCE = new IsComputedPredicate();

		@Override
		public boolean apply(Node node) {
			return node.isRealized();
		}
	}

/*	public static final class IsConsumedOrderingEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsConsumedOrderingEdgePredicate INSTANCE = new IsConsumedOrderingEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isConsumedOrdering();
		}
	} */

	public static final class IsContainerEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsContainerEdgePredicate INSTANCE = new IsContainerEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isContainer();
		}
	}

	public static final class IsContainmentEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsContainmentEdgePredicate INSTANCE = new IsContainmentEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isContainment();
		}
	}
	
	public static final class IsExpressionEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsExpressionEdgePredicate INSTANCE = new IsExpressionEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isArgument();
		}
	}

	public static final class IsGuardNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsGuardNodePredicate INSTANCE = new IsGuardNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isGuard();
		}
	}

	public static final class IsGuardVariableNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsGuardVariableNodePredicate INSTANCE = new IsGuardVariableNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isGuardVariable();
		}
	}

	public static final class IsMatchableNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsMatchableNodePredicate INSTANCE = new IsMatchableNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isMatchable();
		}
	}

	public static final class IsMergeableEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsMergeableEdgePredicate INSTANCE = new IsMergeableEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isMergeable();
		}
	}

	public static final class IsNavigableNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsNavigableNodePredicate INSTANCE = new IsNavigableNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isNavigable();
		}
	}

	public static final class IsNavigationEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsNavigationEdgePredicate INSTANCE = new IsNavigationEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isNavigation();
		}
	}

	public static final class IsPredicatedEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsPredicatedEdgePredicate INSTANCE = new IsPredicatedEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isPredicated();
		}
	}

	public static final class IsPredicatedNavigationEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsPredicatedNavigationEdgePredicate INSTANCE = new IsPredicatedNavigationEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isPredicated() && edge.isNavigation();
		}
	}

	public static final class IsPredicatedNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsPredicatedNodePredicate INSTANCE = new IsPredicatedNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isPredicated();
		}
	}

	public static final class IsRealizedEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsRealizedEdgePredicate INSTANCE = new IsRealizedEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isRealized();
		}
	}

	public static final class IsRealizedNavigationEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsRealizedNavigationEdgePredicate INSTANCE = new IsRealizedNavigationEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isRealized() && edge.isNavigation();
		}
	}

	public static final class IsRealizedNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsRealizedNodePredicate INSTANCE = new IsRealizedNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isRealized();
		}
	}

	public static final class IsRealizedVariableNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsRealizedVariableNodePredicate INSTANCE = new IsRealizedVariableNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isRealizedVariable();
		}
	}

	public static final class IsRecursionEdgePredicate implements Predicate<Edge>
	{
		public static final @NonNull IsRecursionEdgePredicate INSTANCE = new IsRecursionEdgePredicate();

		@Override
		public boolean apply(Edge edge) {
			return edge.isRecursion();
		}
	}

	public static final class IsTrueNodePredicate implements Predicate<Node>
	{
		public static final @NonNull IsTrueNodePredicate INSTANCE = new IsTrueNodePredicate();

		@Override
		public boolean apply(Node node) {
			return node.isTrue();
		}
	}
	
	public static final @NonNull List<MergeableRegion> EMPTY_MERGEABLE_REGIONS = Collections.emptyList();

	protected final @NonNull SuperRegion superRegion;
	private @Nullable Region invokingRegion = null;

	/**
	 * All the edges defined in this region, but not those in nested regions.
	 */
	private @NonNull List<Edge> edges = new ArrayList<Edge>();

	/**
	 * All the nodes defined in this region, but not those in nested regions.
	 */
	private @NonNull List<Node> nodes = new ArrayList<Node>();
	
	/**
	 * The subsets of guardVariables from which all guardVariables are to-one navigable.
	 * The inner lists form a mutually to-one navigable head group typically mutual opposites.
	 * The outer lists identify distinct external inputs.
	 */
	private /*@LazyNonNull*/ @Nullable List<List<Node>> headNodeGroups = null;
	
	/**
	 * The earliest index in the overall schedule at which this region can be executed.
	 */
	private @Nullable Integer earliestIndex = null;

	/**
	 * The latest index in the overall schedule at which this region can be executed.
	 */
	private @Nullable Integer latestIndex = null;
	
	/**
	 * Ordered list of regions that call this region
	 */
	private final @NonNull List<Region> callableParents = new ArrayList<Region>();
	
	/**
	 * Ordered list of regions that this region calls. May exclude some children whose dependencies are unsatisfied.
	 * May include non-children whose dependencies are satisfied by earlier child calls.
	 */
	private final @NonNull List<Region> callableChildren = new ArrayList<Region>();
	
	/**
	 * The per-typed model predicated navigable edges for which an execution may be attempted before assignment.
	 */
	private @Nullable Map<TypedModel, Set<NavigationEdge>> typedModel2checkedEdges = null;
	
	/**
	 * The per-typed model realized navigable edges for which an execution may be attempted elsewhere before assignment here.
	 */
	private @Nullable Map<TypedModel, Set<NavigationEdge>> typedModel2enforcedEdges = null;
	
	@SuppressWarnings("unused")			// Used in the debugger
	private final @NonNull ToDOT toDot = new ToDOT(this){};

	/**
	 * The connections hosted by this region and passed to child regions.
	 */
	private @NonNull List<Connection> rootConnections = new ArrayList<Connection>();

	/**
	 * The connections hosted by a parent region and passed to child regions.
	 */
	private @NonNull List<Connection> intermediateConnections = new ArrayList<Connection>();
	
	protected AbstractRegion(@NonNull SuperRegion superRegion) {
		this.superRegion = superRegion;
		superRegion.addRegion(this);
	}

/*	protected void addBindingEdges(@NonNull Map<Node, Node> invokingBindings) {
		for (Map.Entry<Node, Node> entry : invokingBindings.entrySet()) {
			@SuppressWarnings("null")@NonNull Node invokingNode = entry.getValue();
			@SuppressWarnings("null")@NonNull Node invokedNode = entry.getKey();
			EdgeRole.BINDING.createEdge(this, invokingNode, invokedNode);
		}
	} */

	@Override
	public void addCallToChild(@NonNull Region region) {
		callableChildren.add(region);
		((AbstractRegion)region).callableParents.add(this);
	}

	@Override
	public void addEdge(@NonNull Edge edge) {
		assert !edges.contains(edge);
		for (Edge oldEdge : edges) {
			if (oldEdge.getEdgeRole() == edge.getEdgeRole()) {
//				assert (edge.getSource() != oldEdge.getSource()) || (edge.getTarget() != oldEdge.getTarget());
			}
		}
		edges.add(edge);
	}

	private void addCheckedEdge(@NonNull NavigationEdge predicatedEdge) {
		assert predicatedEdge.isPredicated();
		assert predicatedEdge.getRegion() == this;
		Map<TypedModel, Set<NavigationEdge>> typedModel2checkedEdges2 = typedModel2checkedEdges;
		assert typedModel2checkedEdges2 != null;
		TypedModel typedModel = predicatedEdge.getSource().getClassDatumAnalysis().getTypedModel();
		Set<NavigationEdge> checkedEdges = typedModel2checkedEdges2.get(typedModel);
		if (checkedEdges == null) {
			checkedEdges = new HashSet<NavigationEdge>();
			typedModel2checkedEdges2.put(typedModel, checkedEdges);
		}
		checkedEdges.add(predicatedEdge);
		QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    checked " + predicatedEdge.getProperty() +
			" at " + getEarliestIndex() + ".." + getLatestIndex() +
			" in " + typedModel + " for " + this);
	}

	@Override
	public void addEnforcedEdge(@NonNull NavigationEdge realizedEdge) {
		assert realizedEdge.isRealized();
		assert realizedEdge.getRegion() == this;
		Map<TypedModel, Set<NavigationEdge>> typedModel2enforcedEdges2 = typedModel2enforcedEdges;
		assert typedModel2enforcedEdges2 != null;
		TypedModel typedModel = realizedEdge.getSource().getClassDatumAnalysis().getTypedModel();
		Set<NavigationEdge> enforcedEdges = typedModel2enforcedEdges2.get(typedModel);
		if (enforcedEdges == null) {
			enforcedEdges = new HashSet<NavigationEdge>();
			typedModel2enforcedEdges2.put(typedModel, enforcedEdges);
		}
		enforcedEdges.add(realizedEdge);
		QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    enforced " + realizedEdge.getProperty() +
			" at " + getEarliestIndex() + ".." + getLatestIndex() +
			" in " + realizedEdge.getSource().getClassDatumAnalysis().getTypedModel() + " for " + this);
	}

	protected void addHeadGroup(@NonNull List<Node> headGroup) {
		getHeadNodeGroups().add(headGroup);
//		for (@SuppressWarnings("null")@NonNull ClassNode head : headGroup) {
//			if (head instanceof GuardNode) {
//				((GuardNode)head).setIsHead();
//			}
//		}
	}

	@Override
	public void addIntermediateConnection(@NonNull Connection connection) {
		assert !intermediateConnections .contains(connection);
		intermediateConnections.add(connection);
	}

	@Override
	public void addRootConnection(@NonNull Connection connection) {
		assert !rootConnections.contains(connection);
		rootConnections.add(connection);
	}
	
	@Override
	public void addNode(@NonNull Node node) {
		assert !nodes.contains(node);
		nodes.add(node);
	}

	@Override
	public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
		String name = getName();
		String indexText = getIndexText();
		if (indexText != null) {
			name = name + "\\n " + indexText;
		}
		s.setLabel(name);
		String shape = getShape();
		if (shape != null) {
			s.setShape(shape);
		}
		String style = getStyle();
		if (style != null) {
			s.setStyle(style);
		}
		s.setColor(getColor());
//		s.setPenwidth(getPenwidth());
		s.appendAttributedNode(nodeName);
//		if (isHead) {
//			s.append("}");
//		}
	}

	@Override
	public void buildPredicatedNavigationEdgesIndex(@NonNull Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2predicatedEdges) {
		for (NavigationEdge predicatedEdge : getPredicatedNavigationEdges()) {
			if (!predicatedEdge.isCast()) {
				Property property = predicatedEdge.getProperty();
				Node predicatedNode = predicatedEdge.getSource();
				TypedModel typedModel = predicatedNode.getClassDatumAnalysis().getTypedModel();
				Map<Property, List<NavigationEdge>> property2predicatedEdges = typedModel2property2predicatedEdges.get(typedModel);
				if (property2predicatedEdges == null) {
					property2predicatedEdges = new HashMap<Property, List<NavigationEdge>>();
					typedModel2property2predicatedEdges.put(typedModel, property2predicatedEdges);
				}
				List<NavigationEdge> predicatedEdges = property2predicatedEdges.get(property);
				if (predicatedEdges == null) {
					predicatedEdges = new ArrayList<NavigationEdge>();
					property2predicatedEdges.put(property, predicatedEdges);
				}
				predicatedEdges.add(predicatedEdge);
				QVTs2QVTiVisitor.POLLED_PROPERTIES.println("  " + typedModel + " predicated for " + property);
			}
		}
		typedModel2checkedEdges = new HashMap<TypedModel, Set<NavigationEdge>>();
	}

	@Override
	public void buildRealizedNavigationEdgesIndex(@NonNull Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2realizedEdges) {
		for (NavigationEdge realizedEdge : getRealizedNavigationEdges()) {
			Property property = realizedEdge.getProperty();
			Node realizedNode = realizedEdge.getSource();
			TypedModel typedModel = realizedNode.getClassDatumAnalysis().getTypedModel();
			Map<Property, List<NavigationEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
			if (property2realizedEdges == null) {
				property2realizedEdges = new HashMap<Property, List<NavigationEdge>>();
				typedModel2property2realizedEdges.put(typedModel, property2realizedEdges);
			}
			List<NavigationEdge> realizedEdges = property2realizedEdges.get(property);
			if (realizedEdges == null) {
				realizedEdges = new ArrayList<NavigationEdge>();
				property2realizedEdges.put(property, realizedEdges);
			}
			realizedEdges.add(realizedEdge);
			QVTs2QVTiVisitor.POLLED_PROPERTIES.println("  " + typedModel + " realized for " + property);
		}
		typedModel2enforcedEdges = new HashMap<TypedModel, Set<NavigationEdge>>();
	}

	/**
	 * Return true if a navigable path from startNode following the edges of protoPath,
	 * re-using edges and nodes where possible could be created. REturn false if such
	 * a path would violate a null parent requirement.
	 */
	protected boolean canCreatePath(@NonNull Node startNode, @NonNull List<NavigationEdge> protoPath) {
//		Map<Edge, Edge> path = new HashMap<Edge, Edge>();
//		Region region = startNode.getRegion();
		Node sourceNode = startNode;
		for (NavigationEdge protoEdge : protoPath) {
			NavigationEdge edge = sourceNode.getNavigationEdge(protoEdge.getProperty());
			if (edge != null) {
				Node protoTarget = protoEdge.getTarget();
				Node target = edge.getTarget();
				if (target.isNull() != (protoTarget.isNull())) {
					return false;
				}
				sourceNode = target;
			}
		}
		return true;
	}

	@Override
	public @Nullable Map<Node, Node> canMerge(@NonNull Region secondaryRegion, @NonNull Region2Depth region2depths, boolean isLateMerge) {
		Map<Node, Node> secondaryNode2primaryNode = null;
		Map<CompleteClass, List<Node>> completeClass2node = getCompleteClass2Node();
		//
		//	Find the unambiguous head-node matches
		//
		List<List<Node>> secondaryHeadNodeGroups = secondaryRegion.getHeadNodeGroups();
		assert secondaryHeadNodeGroups.size() == 1;
		List<Node> secondaryHeadNodes = secondaryHeadNodeGroups.get(0);
		for (Node secondaryHeadNode : secondaryHeadNodes) {
			CompleteClass completeClass = secondaryHeadNode.getCompleteClass();
			List<Node> primaryNodes = completeClass2node.get(completeClass);
			if (primaryNodes != null) {
				Node primaryHeadNode = selectMergedHeadNode(secondaryHeadNode, primaryNodes);
				if (primaryHeadNode == null) {
					return null;
				}
				if (secondaryNode2primaryNode == null) {
					secondaryNode2primaryNode = new HashMap<Node, Node>();
				}
				secondaryNode2primaryNode.put(secondaryHeadNode, primaryHeadNode);
			}
		}
		if (secondaryNode2primaryNode == null) {
			return null;
		}
		//
		//	Validate the transitive navigation from the head nodes. All common navigation edges must have compatible node types.
		//
		if (!canMergeInternal(secondaryRegion, secondaryNode2primaryNode, region2depths, isLateMerge)) {
			return null;
		}
		//FIXME Must be symmetrically mergeable; do tests before creating MergedRegion 
		//
		//	Validate the true node predicate compatibility
		//
		Iterable<Node> primaryTrueNodes = this.getTrueNodes();
		Iterable<Node> secondaryTrueNodes = secondaryRegion.getTrueNodes();
		if (Iterables.size(primaryTrueNodes) != Iterables.size(secondaryTrueNodes)) {
			return null;
		}
		for (@SuppressWarnings("null")@NonNull Node primaryTrueNode : primaryTrueNodes) {
			boolean gotIt = false;
			for (Node secondaryTrueNode : secondaryTrueNodes) {
				assert secondaryTrueNode != null;
				Map<Node,Node> equivalentNodes = new HashMap<Node,Node>();
				if (isEquivalent(primaryTrueNode, secondaryTrueNode, equivalentNodes)) {	// FIXME use hashes
					gotIt = true;
					for (Node primaryNode : equivalentNodes.keySet()) {
						secondaryNode2primaryNode.put(equivalentNodes.get(primaryNode), primaryNode);
					}
					break;
				}
			}
			if (!gotIt) {
				return null;
			}
		}
		return secondaryNode2primaryNode;
	}
	private boolean canMergeInternal(@NonNull Region secondaryRegion, @NonNull Map<Node, Node> secondaryNode2primaryNode, @NonNull Region2Depth region2depths, boolean isLateMerge) {
		Set<Node> secondaryNodes = new HashSet<Node>(secondaryNode2primaryNode.keySet());
		List<Node> secondaryNodesList = new ArrayList<Node>(secondaryNodes);
		for (int i = 0; i < secondaryNodesList.size(); i++) {
			@SuppressWarnings("null")@NonNull Node secondarySourceNode = secondaryNodesList.get(i);
			Node primarySourceNode = secondaryNode2primaryNode.get(secondarySourceNode);
			if (primarySourceNode == null) {
				if (secondarySourceNode.isPredicated()) {
					return false;
				}
			}
			for (@SuppressWarnings("null")@NonNull NavigationEdge secondaryEdge : secondarySourceNode.getNavigationEdges()) {
				Node secondaryTargetNode = secondaryEdge.getTarget();
				Node primaryTargetNode = null;
				if (primarySourceNode != null) {
					Edge primaryEdge = primarySourceNode.getNavigationEdge(secondaryEdge.getProperty());
					if (primaryEdge != null) {
						primaryTargetNode = primaryEdge.getTarget();
//						primaryTargetNode = primaryTargetNode.getCastEquivalentNode();
//						secondaryTargetNode = secondaryTargetNode.getCastEquivalentNode();
						if (primaryTargetNode.getCompleteClass() != secondaryTargetNode.getCompleteClass()) {		// FIXME conforms
							return false;
						}
						if (primaryTargetNode.isNull() != secondaryTargetNode.isNull()) {		// FIXME conforms
							return false;
						}
					}
					else {
						if (secondaryEdge.isPredicated()) {	
							if (!isLateMerge) {		// FIXME must locate in ancestry; if present can merge, if not cannot
								return false;
							}
							for (@SuppressWarnings("unused") Node secondaryOriginNode : secondaryTargetNode.getUsedBindingSources()) {
								return false;
							}
						}
					}
				}
				if (primaryTargetNode != null) {
					Node primaryTargetNode2 = secondaryNode2primaryNode.get(secondaryTargetNode);
					if (primaryTargetNode2 == null) {
						secondaryNode2primaryNode.put(secondaryTargetNode, primaryTargetNode);
					}
				}
				assert secondaryTargetNode != null;
				if (secondaryNodes.add(secondaryTargetNode)) {
	//					if (mergedTargetNode != null) {
//						if (!secondaryTargetNode.isAttributeNode()) {
						secondaryNodesList.add(secondaryTargetNode);
//						}
				}
				
			}
/*			if (!isLateMerge) {
				for (@SuppressWarnings("null")@NonNull Edge secondaryEdge : secondarySourceNode.getComputationEdges()) {
					// FXME Change argumentNode / isMatchable
				Node secondaryTargetNode = secondaryEdge.getTarget();
				Node primaryTargetNode = null;
				if (primarySourceNode != null) {
					if (secondaryEdge instanceof NavigationEdge) {
						Edge primaryEdge = primarySourceNode.getNavigationEdge(((NavigationEdge)secondaryEdge).getProperty());
						if (primaryEdge != null) {
							primaryTargetNode = primaryEdge.getTarget();
//							primaryTargetNode = primaryTargetNode.getCastEquivalentNode();
//							secondaryTargetNode = secondaryTargetNode.getCastEquivalentNode();
							if (primaryTargetNode.getCompleteClass() != secondaryTargetNode.getCompleteClass()) {		// FIXME conforms
								return false;
							}
						}
						else {
							if (secondaryEdge.isPredicated()) {	
								if (!isLateMerge) {		// FIXME must locate in ancestry; if present can merge, if not cannot
									return false;
								}
								for (@SuppressWarnings("null")@NonNull Node secondaryOriginNode : secondaryTargetNode.getUsedBindingSources()) {
									if (!region2depths.isAfter(secondaryOriginNode, this)) {
										return false;
									}
								}
							}
						}
					}
					else {} // FIXME???
				}
				if (primaryTargetNode != null) {
					Node primaryTargetNode2 = secondaryNode2primaryNode.get(secondaryTargetNode);
					if (primaryTargetNode2 == null) {
						secondaryNode2primaryNode.put(secondaryTargetNode, primaryTargetNode);
					}
					if (secondaryNodes.add(secondaryTargetNode)) {
	//					if (mergedTargetNode != null) {
						if (!secondaryTargetNode.isAttributeNode()) {
							secondaryNodesList.add(secondaryTargetNode);
						}
					}
				}
			} */
		}
		return true;
	}

	@Override
	public void computeCheckedOrEnforcedEdges(@NonNull Map<TypedModel, Map<Property, List<NavigationEdge>>> typedModel2property2predicatedEdges,
				@NonNull Map<TypedModel, @NonNull Map<Property, @NonNull List<NavigationEdge>>> typedModel2property2realizedEdges) {
		CompleteModel completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
		boolean doDebug = QVTs2QVTiVisitor.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTs2QVTiVisitor.POLLED_PROPERTIES.println("analyzing " + this + " (" + getEarliestIndex() + ".." + getLatestIndex() + ")");
		}
		for (NavigationEdge predicatedEdge : getPredicatedNavigationEdges()) {
			if (!predicatedEdge.isCast()) {
				Property property = predicatedEdge.getProperty();
				if (doDebug) {
					QVTs2QVTiVisitor.POLLED_PROPERTIES.println("  analyzing " + predicatedEdge.getSource().getName() + "::" + property.getName() + " : " + predicatedEdge.getSource().getCompleteClass());
				}
				Node laterNode = predicatedEdge.getSource();
				Node predicatedSourceNode = predicatedEdge.getSource();
				Node predicatedTargetNode = predicatedEdge.getTarget();
				for (Connection usedConnection : predicatedTargetNode.getIncomingUsedConnections()) {
					for (Node usedSourceNode : usedConnection.getSources()) {
						Region usedRegion = usedSourceNode.getRegion();
						if (usedRegion.getLatestIndex() > getEarliestIndex()) {			// FIXME =
							CompleteClass predicatedSourceType = predicatedSourceNode.getCompleteClass();
							CompleteClass predicatedTargetType = predicatedTargetNode.getCompleteClass();
							ClassDatumAnalysis classDatumAnalysis = laterNode.getClassDatumAnalysis();
							TypedModel typedModel = classDatumAnalysis.getTypedModel();
							Map<Property, @NonNull List<NavigationEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
							assert property2realizedEdges != null;
							Property oclContainerProperty = getSchedulerConstants().getOclContainerProperty();
							if (property == oclContainerProperty) {
								Node containerNode = predicatedEdge.getTarget();
								Node containedNode = predicatedEdge.getSource();
								CompleteClass containerType = containerNode.getCompleteClass();
								CompleteClass containedType = containedNode.getCompleteClass();
								for (Property candidateProperty : property2realizedEdges.keySet()) {
									if (candidateProperty.isIsComposite()) {
										CompleteClass candidateContainerType = completeModel.getCompleteClass(candidateProperty.getOwningClass());
										CompleteClass candidateContainedType = completeModel.getCompleteClass(candidateProperty.getType());
	//									if (candidateContainerType.conformsTo(containerType) && containedType.conformsTo(candidateContainedType)) {
										List<NavigationEdge> realizedEdges = property2realizedEdges.get(candidateProperty);
										assert realizedEdges != null;
											for (NavigationEdge realizedEdge : realizedEdges) {
												// FIXME recheck for narrower types ??
												Region earlierRegion = realizedEdge.getRegion();
												String isNotHazardous;
	//											if (this == earlierRegion) {
	//												isNotHazardous = "same region";	// FIXME must handle recursion
	//											}
	//											else if (earlierRegion.getLatestIndex() < getEarliestIndex()) {
	//												isNotHazardous = "later";// FIXME must handle any possible reads of any possible write
	//											}
	//											else {
													Node realizedSourceNode = realizedEdge.getSource();
													Node realizedTargetNode = realizedEdge.getTarget();
													CompleteClass realizedSourceType = realizedSourceNode.getCompleteClass();
													CompleteClass realizedTargetType = realizedTargetNode.getCompleteClass();
													if (realizedSourceType.conformsTo(predicatedSourceType) && realizedTargetType.conformsTo(predicatedTargetType)) {
														assert getLatestIndex() >= earlierRegion.getEarliestIndex();
														isNotHazardous = null;
													}
													else {
														isNotHazardous = "incompatible";
													}
													assert getLatestIndex() >= earlierRegion.getEarliestIndex();
													isNotHazardous = null;
	//											}
												if (isNotHazardous == null) {
													addCheckedEdge(predicatedEdge);
													earlierRegion.addEnforcedEdge(realizedEdge);
												}
												else if (doDebug) {
													QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    ignored " + this + "::" + laterNode.getName() + "(" + getEarliestIndex() + ".." + getLatestIndex() + ")" + 
															" " + isNotHazardous + " (" + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + ")" + earlierRegion + "::" + realizedEdge.getSource().getName());
												}
	//										}
										}
									}
								}
							}
							else {
								assert property2realizedEdges != null : "No realized typed model for " + typedModel;
								List<NavigationEdge> realizedEdges = property2realizedEdges.get(property);
								assert realizedEdges != null : "No realized edges for " + property + " in " + typedModel;
								for (NavigationEdge realizedEdge : realizedEdges) {
									Region earlierRegion = realizedEdge.getRegion();
									String isNotHazardous;
	//								if (this == earlierRegion) {
	//									isNotHazardous = "same region";
	//								}
	//								else if (earlierRegion.getLatestIndex() < getEarliestIndex()) {
	//									isNotHazardous = "later";
	//								}
	//								else {
										Node realizedSourceNode = realizedEdge.getSource();
										Node realizedTargetNode = realizedEdge.getTarget();
										CompleteClass realizedSourceType = realizedSourceNode.getCompleteClass();
										CompleteClass realizedTargetType = realizedTargetNode.getCompleteClass();
										if (realizedSourceType.conformsTo(predicatedSourceType) && realizedTargetType.conformsTo(predicatedTargetType)) {
											assert getLatestIndex() >= earlierRegion.getEarliestIndex();
											isNotHazardous = null;
										}
										else {
											isNotHazardous = "incompatible";
										}
	//								}
									if (isNotHazardous == null) {
										addCheckedEdge(predicatedEdge);
										earlierRegion.addEnforcedEdge(realizedEdge);
									}
									else if (doDebug) {
										QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    ignored " + this + "::" + laterNode.getName() + "(" + getEarliestIndex() + ".." + getLatestIndex() + ")" + 
											" " + isNotHazardous + " (" + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + ")" + earlierRegion + "::" + realizedEdge.getSource().getName());
									}
								}
							}
						}
					}
				}
			}
		}
	}

	protected @NonNull List<List<Node>> computeHeadNodeGroups() {
		List<List<Node>> headNodeGroups = new ArrayList<List<Node>>();
		Iterable<Node> navigableNodes = getNavigableNodes();		// Excludes, null, attributes, constants, operations
		//
		//	Compute the Set of all target nodes that can be reached by transitive to-one navigation from a particular source node.
		//
		Map<Node,Set<Node>> source2targetClosure = new HashMap<Node,Set<Node>>();
		for (@SuppressWarnings("null")@NonNull Node navigableNode : navigableNodes) {
			Set<Node> targetClosure = new HashSet<Node>();
			source2targetClosure.put(navigableNode, targetClosure);
			targetClosure.add(navigableNode);
			for (Edge navigationEdge : navigableNode.getNavigationEdges()) {
				if (!navigationEdge.isRealized()) {
					targetClosure.add(navigationEdge.getTarget());
				}
			}
			for (Edge computationEdge : navigableNode.getComputationEdges()) {
				targetClosure.add(computationEdge.getSource());
			}
		}
		boolean isChanged = true;
		while (isChanged) {
			isChanged = false;
			for (Node sourceNode : navigableNodes) {
				Set<Node> targetClosure = source2targetClosure.get(sourceNode);
				if (targetClosure != null) {
					for (Node nextNode : new ArrayList<Node>(targetClosure)) {
						Set<Node> nextTargetClosure = source2targetClosure.get(nextNode);
						if ((nextTargetClosure != null) && targetClosure.addAll(nextTargetClosure)) {
							isChanged = true;
						}
					}
				}
			}
		}
		//
		//	Compute the inverse Set of all source nodes from which a particular target node can be reached by transitive to-one navigation.
		//
		final Map<Node, @NonNull Set<Node>> target2sourceClosure = new HashMap<Node, @NonNull Set<Node>>();
		for (Node targetNode : navigableNodes) {
			Set<Node> sourceClosure = new HashSet<Node>();
			target2sourceClosure.put(targetNode, sourceClosure);
			sourceClosure.add(targetNode);
		}
		for (Node sourceNode : navigableNodes) {
			Set<Node> targetClosure = source2targetClosure.get(sourceNode);
			assert targetClosure != null;
			for (Node targetNode : targetClosure) {
				Set<Node> sourceClosure = target2sourceClosure.get(targetNode);
				if (sourceClosure != null) {
					sourceClosure.add(sourceNode);
				}
			}
		}
		//
		//	Sort the guardNodes into least reachable first order enabling the heads to be identified
		//	by successive removal from the start of the list.
		//
		List<Node> headLessNodes = new ArrayList<Node>();
		Iterables.addAll(headLessNodes, navigableNodes);
		Collections.sort(headLessNodes, new Comparator<Node>()
		{
			@Override
			public int compare(Node o1, Node o2) {
				Set<Node> set1 = target2sourceClosure.get(o1);
				Set<Node> set2 = target2sourceClosure.get(o2);
				assert (set1 != null) && (set2 != null);
				int l1 = set1.size();
				int l2 = set2.size();
				return l1 - l2;
			}
		});
		//
		//	Loop to keep removing distinct inputs until all guard nodes are reachable from some head, taking
		//	care to group mutually reachable heads as a single input.
		//
		while (!headLessNodes.isEmpty()) {
			Node headNode = headLessNodes.remove(0);
			assert headNode != null;
			Set<Node> sourceClosure = target2sourceClosure.get(headNode);
			assert sourceClosure != null;
			Set<Node> targetClosure = source2targetClosure.get(headNode);
			assert targetClosure != null;
			List<Node> headGroup = new ArrayList<Node>();
			headNode.setHead();
			headGroup.add(headNode);
			for (int i = 0; i < headLessNodes.size(); i++) {
				Node nextNode = headLessNodes.get(i);
				assert nextNode != null;
				Set<Node> nextClosure = target2sourceClosure.get(nextNode);
				assert nextClosure != null;
				if (nextClosure.size() > sourceClosure.size()) {
					break;
				}
				if (nextClosure.equals(sourceClosure)) {
					headNode.setHead();
					headGroup.add(headNode);
					headLessNodes.remove(nextNode);
				}
			}
			headLessNodes.removeAll(targetClosure);
			targetClosure.removeAll(headGroup);
			headNodeGroups.add(headGroup);
		}
		return headNodeGroups;
	}

/*	protected @NonNull PredicateEdge createPredicateEdge(@NonNull ClassNode sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		PredicateEdge predicateEdge = new PredicateEdge(this, sourceNode, source2targetProperty, targetNode);
		Property target2sourceProperty = source2targetProperty.getOpposite();
		if ((target2sourceProperty != null) && target2sourceProperty.isIsComposite()) {
			ClassNode composedNode = sourceNode;
			Node composingNode = targetNode;			// May be NullNode
			Property composingProperty = target2sourceProperty;
			if (composingNode instanceof ClassNode) {
				((ClassNode)composingNode).addComposingProperty2composedNode(composingProperty, composedNode);
			}
			composedNode.addComposingProperty2composingNode(composingProperty, composingNode);
		}
		return predicateEdge;
	} */
	
	protected @Nullable Map<Node, Node> expandRecursion(@NonNull Node nextNode, @NonNull Node prevNode, @NonNull Map<Node, Node> bindings) {
		Node oldPrevNode = bindings.put(nextNode, prevNode);
		if (oldPrevNode != null) {
			assert oldPrevNode == prevNode;
			return bindings;
		}
		for (NavigationEdge navigationEdge : prevNode.getNavigationEdges()) {
			Node nextTarget = nextNode.getNavigationTarget(navigationEdge.getProperty());
			if (nextTarget == null) {
				return null;
			}
			Node prevTarget = navigationEdge.getTarget();
			if (expandRecursion(nextTarget, prevTarget, bindings) == null) {
				return null;
			}
		}
		return bindings;
	}

	@Override
	public @NonNull Iterable<MappingRegion> getAllMappingRegions() {
		return SchedulerConstants.EMPTY_MAPPING_REGION_SET;
	}

	@Override
	public @NonNull Iterable<Node> getAncestorsOf(@NonNull Node node) {
		List<Node> ancestors = new ArrayList<Node>();
		HashSet<Node> ancestorSet = new HashSet<Node>();
		node.getAllAncestors(ancestorSet);
		for (Node ancestor : ancestorSet) {
			if (ancestor.getRegion() == this) {
				ancestors.add(ancestor);
			}
		}
		return ancestors;
	}

	public @NonNull SimpleNode getAssignedAttributeNode(@NonNull SimpleNode parentNode, @NonNull Property property) {
		assert parentNode.isClassNode();
		assert property.getType() instanceof DataType;
		SimpleNode node = parentNode.getNavigationTarget(property);
//		AbstractAttributeNode node = (AbstractAttributeNode)node2node.get(property);
		if (node == null) {
			node = Nodes.REALIZED_ATTRIBUTE.createSimpleNode(parentNode.getRegion(), parentNode, property);
//			node2node.put(property, node);
		}
		return node;
	}

/*	public @NonNull SimpleNode getAssignedClassNode(@NonNull SimpleNode parentNode, @NonNull Property property) {
		assert parentNode.isClassNode();
		assert !(property.getType() instanceof DataType);
		SimpleNode node = parentNode.getNavigationTarget(property);
//		AbstractAttributeNode node = (AbstractAttributeNode)node2node.get(property);
		if (node == null) {
			node = Nodes.NAV.createSimpleNode(region, parentNode, navigationCallExp)SimpleNode(parentNode.getRegion(), parentNode, property);
//			node2node.put(property, node);
		}
		return node;
	} */

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getAssignedNodes() {
		return Iterables.filter(nodes, IsAssignedNodePredicate.INSTANCE);
	}

	public final @NonNull Iterable<NavigationEdge> getAssignmentEdges() {
		@SuppressWarnings({"unchecked", "null"})
		@NonNull Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(edges, IsAssignmentEdgePredicate.INSTANCE);
		return filter;
	}

	protected @Nullable List<NavigationEdge> getBestPath(@Nullable List<NavigationEdge> bestPath, @Nullable List<NavigationEdge> candidatePath) {
		if (bestPath == null) {
			return candidatePath;
		}
		if (candidatePath == null) {
			return bestPath;
		}
		int bestCost = getCost(bestPath);
		int candidateCost = getCost(candidatePath);
		if (candidateCost < bestCost) {
			return candidatePath;
		}
		return bestPath;
	}

	private @NonNull NavigationEdge getBestEdge(@Nullable NavigationEdge bestEdge, @NonNull NavigationEdge candidateEdge) {
		if (bestEdge == null) {
			return candidateEdge;
		}
		if ((bestEdge.getProperty().isIsImplicit() && !candidateEdge.getProperty().isIsImplicit())) {
			return candidateEdge;
		}
		return bestEdge;		// ??? containment
	}
	
	@Override
	public @NonNull Iterable<Region> getCallableChildren() {
		return callableChildren;
	}
	
	@Override
	public @NonNull Iterable<Region> getCallableParents() {
		return callableParents;
	}

//	@Override
//	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull Type type) {
//		return getSchedulerConstants().getClassDatumAnalysis(type);
//	}

/*	@Override
	public final @NonNull Iterable<Edge> getCastEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(edges, IsCastEdgePredicate.INSTANCE);
		return filter;
	} */

	@Override
	public @NonNull List<Region> getCalledRegions() {
		List<Region> childRegions = new ArrayList<Region>();			// FIXME cache
		for (Connection childConnection : getChildPassedConnections()) {
			for (Node childNode : childConnection.getTargets()) {
				Region childRegion = childNode.getRegion();
				if (!childRegions.contains(childRegion)) {
					childRegions.add(childRegion);
				}
			}
		}
		return childRegions;
	}

	@Override
	public @NonNull List<Region> getCallingRegions() {
		List<Region> callingRegions = new ArrayList<Region>();			// FIXME cache
		for (Connection callingConnection : getParentPassedConnections()) {
			for (Node callingNode : callingConnection.getSources()) {
				Region callingRegion = callingNode.getRegion();
				if (!callingRegions.contains(callingRegion)) {
					callingRegions.add(callingRegion);
				}
			}
		}
		return callingRegions;
	}
	
	@Override
	public @Nullable Set<NavigationEdge> getCheckedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2checkedEdges != null;
		return typedModel2checkedEdges.get(typedModel);
	}

	@Override
	public @NonNull List<Connection> getChildConnections() {			// FIXME cache
		List<Connection> connections = new ArrayList<Connection>();
		for (Node node : getNodes()) {
			for (Connection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
			for (Connection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull List<Connection> getChildPassedConnections() {			// FIXME cache
		List<Connection> connections = new ArrayList<Connection>();
		for (Node node : getNodes()) {
			for (Connection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull List<Connection> getChildUsedBindingEdges() {			// FIXME cache
		List<Connection> connections = new ArrayList<Connection>();
		for (Node node : getNodes()) {
			for (Connection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull TypedElement typedElement) {
		return getSchedulerConstants().getClassDatumAnalysis(typedElement);
	}

	@Override
	public @NonNull String getColor() {
		return "blue";
	}

	private @NonNull Map<CompleteClass, List<Node>> getCompleteClass2Node() {
		Map<CompleteClass, List<Node>> completeClass2node = new HashMap<CompleteClass, List<Node>>();
		for (Node node : getNodes()) {
			CompleteClass completeClass = node.getCompleteClass();
			List<Node> mergedNodes = completeClass2node.get(completeClass);
			if (mergedNodes == null) {
				mergedNodes = new ArrayList<Node>();
				completeClass2node.put(completeClass, mergedNodes);
			}
			if (!mergedNodes.contains(node)) {
				mergedNodes.add(node);
			}
		}
		return completeClass2node;
	}

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getComposedNodes() {
		return Iterables.filter(nodes, IsComposedNodePredicate.INSTANCE);
	}

	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getComputedNodes() {
		return Iterables.filter(nodes, IsComputedPredicate.INSTANCE);
	}

/*	public final @NonNull Iterable<? extends Edge> getConsumedOrderingEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(edges, IsConsumedOrderingEdgePredicate.INSTANCE);
		return filter;
	} */

	public final @NonNull Iterable<? extends NavigationEdge> getContainmentEdges() {
		@SuppressWarnings({"unchecked", "null"})
		@NonNull Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(edges, IsContainmentEdgePredicate.INSTANCE);
		return filter;
	}

	public final @NonNull Iterable<? extends NavigationEdge> getContainerEdges() {
		@SuppressWarnings({"unchecked", "null"})
		@NonNull Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(edges, IsContainerEdgePredicate.INSTANCE);
		return filter;
	}

	private int getCost(@NonNull List<NavigationEdge> path) {
		int cost = 0;
		for (NavigationEdge edge : path) {
			if (edge.getProperty().isIsImplicit()) {
				cost++;
			}		// ??? containment
		}
		return cost;
	}
	
	@Override
	public int getEarliestIndex() {
		assert earliestIndex != null;
		return earliestIndex;
	}

	@Override
	public @NonNull Collection<Edge> getEdges() {
		return edges;
	}
	
	@Override
	public @Nullable Set<NavigationEdge> getEnforcedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2enforcedEdges != null;
		return typedModel2enforcedEdges.get(typedModel);
	}

	@Override
	public final @NonNull Iterable<Edge> getExpressionEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(edges, IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getGuardNodes() {
		return Iterables.filter(nodes, IsGuardNodePredicate.INSTANCE);
	}

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getGuardVariableNodes() {
		return Iterables.filter(nodes, IsGuardVariableNodePredicate.INSTANCE);
	}

	@Override
	public @NonNull List<List<Node>> getHeadNodeGroups() {
		List<List<Node>> headNodeGroups2 = headNodeGroups;
		if (headNodeGroups2 == null) {
			headNodeGroups = headNodeGroups2 = computeHeadNodeGroups();
		}
		return headNodeGroups2;
	}

	@Override
	public @Nullable String getIndexText() {
		Integer earliestIndex2 = earliestIndex;
		if (earliestIndex2 == null) {
			return null;
		}
		else if (latestIndex == earliestIndex2) {
			return earliestIndex2.toString();
		}
		else {
			return earliestIndex2 + " ... " + latestIndex + " ";
		}
	}

	@Override
	public @NonNull List<Connection> getIntermediateConnections() {
		return intermediateConnections;
	}

	@Override
	public @Nullable Region getInvokingRegion() {
		return invokingRegion;
	}

	@Override
	public int getLatestIndex() {
		assert latestIndex != null;
		return latestIndex;
	}

	public @NonNull MappingRegion getMappingRegion(@NonNull AbstractAction action) {
		return superRegion.getMappingRegion(action);
	}

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getMatchableNodes() {
		return Iterables.filter(nodes, IsMatchableNodePredicate.INSTANCE);
	}
	
	@Override
	public @NonNull Iterable<MergeableRegion> getMergeableRegions() {
		return EMPTY_MERGEABLE_REGIONS;
	}
	
	@Override
	public @NonNull String getName() {
		List<String> names = new ArrayList<String>();
		for (Region action : getAllMappingRegions()) {
			names.add(action.getName());
		}
		Collections.sort(names);;
		StringBuilder s = new StringBuilder();
		s.append(getClass().getSimpleName());
		for (String name : names) {
			s.append("\n");
			s.append(name);
		}
		return s.toString();
	}

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getNavigableNodes() {
		return Iterables.filter(nodes, IsNavigableNodePredicate.INSTANCE);
	}

	@Override
	public final @NonNull Iterable<NavigationEdge> getNavigationEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<NavigationEdge> filter = Iterables.filter(edges, NavigationEdge.class);
		return filter;
	}

//	@Override
//	public @Nullable Node getNavigationTarget(@NonNull ClassNode sourceNode, @NonNull Property source2targetProperty) {
//		NavigationEdge navigationEdge = getNavigationEdge(sourceNode, source2targetProperty);
//		return navigationEdge !=  null ? navigationEdge.getTarget() : null;
//	}

	@Override
	public @NonNull Collection<Node> getNodes() {
		return nodes;
	}

	@Override
	public @NonNull List<Connection> getParentConnections() {		// FIXME cache
		List<Connection> connections = new ArrayList<Connection>();
		for (List<Node> headGroup : getHeadNodeGroups()) {
			for (Node head : headGroup) {
				for (Connection connection : head.getIncomingPassedConnections()) {
					connections.add(connection);
				}
			}
		}
		for (Node node : getPredicatedNodes()) {
			for (Connection connection : node.getIncomingUsedConnections()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull List<Connection> getParentPassedConnections() {		// FIXME cache
		List<Connection> connections = new ArrayList<Connection>();
		for (List<Node> headGroup : getHeadNodeGroups()) {
			for (Node head : headGroup) {
				for (Connection connection : head.getIncomingPassedConnections()) {
					connections.add(connection);
				}
			}
		}
		return connections;
	}

	@Override
	public @NonNull List<Connection> getParentUsedConnections() {			// FIXME cache
		List<Connection> connections = new ArrayList<Connection>();
		for (Node node : getPredicatedNodes()) {
			for (Connection connection : node.getIncomingUsedConnections()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	protected @Nullable List<NavigationEdge> getPath(@NonNull Node sourceNode, @NonNull Node targetNode, @NonNull Set<Edge> usedEdges) {
		assert sourceNode.getRegion() == targetNode.getRegion();
		NavigationEdge bestEdge = null; 
		List<NavigationEdge> bestPath = null;
		for (@SuppressWarnings("null")@NonNull NavigationEdge edge : sourceNode.getNavigationEdges()) {
			if (!usedEdges.contains(edge) && !edge.getProperty().isIsMany() && !edge.isRealized()) {
				if (edge.getTarget() == targetNode) {
					bestEdge = getBestEdge(bestEdge, edge);
				}
				else {
					Set<Edge> moreUsedEdges = new HashSet<Edge>(usedEdges);
					moreUsedEdges.add(edge);		
					List<NavigationEdge> tailPath = getPath(edge.getTarget(), targetNode, moreUsedEdges);
					if (tailPath != null) {
						tailPath = new ArrayList<NavigationEdge>(tailPath);
						tailPath.add(0, edge);
					}
					bestPath = getBestPath(bestPath, tailPath);
				}
			}
		}
		if (bestEdge == null) {
			return bestPath;
		}
		else if (bestPath == null) {
			return Collections.singletonList(bestEdge);
		}
		else {
			return getBestPath(Collections.singletonList(bestEdge), bestPath);
		}
	}
	
	public @NonNull SimpleNode getPredicatedAttributeNode(@NonNull SimpleNode parentNode, @NonNull NavigationCallExp navigationCallExp) {
		assert parentNode.isClassNode();
		Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
		assert referredProperty != null;
		SimpleNode node = parentNode.getNavigationTarget(referredProperty);
//		AbstractAttributeNode node = (AbstractAttributeNode)node2node.get(property);
		if (node == null) {
			node = Nodes.ATTRIBUTE.createSimpleNode(parentNode.getRegion(), parentNode, navigationCallExp);
		}
		return node;
	}
	
//	@Override
//	public @Nullable PredicateEdge getPredicateEdge(@NonNull ClassNode sourceNode, @NonNull Property source2targetProperty) {
//		Map<Property, PredicateEdge> property2predicateEdge = node2property2predicateEdge.get(sourceNode);
//		return property2predicateEdge != null ? property2predicateEdge.get(source2targetProperty) : null;
//	}
	
//	@Override
//	public @Nullable Map<Property, PredicateEdge> getPredicateEdges(@NonNull ClassNode sourceNode) {
//		return node2property2predicateEdge.get(sourceNode);
//	}

	public final @NonNull Iterable<NavigationEdge> getPredicateEdges() {
		@SuppressWarnings({"unchecked", "null"})
		@NonNull Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(edges, IsPredicatedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<NavigationEdge> getPredicatedNavigationEdges() {
		@SuppressWarnings({"null", "unchecked"})
		@NonNull Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(edges, IsPredicatedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getPredicatedNodes() {
		return Iterables.filter(nodes, IsPredicatedNodePredicate.INSTANCE);
	}

	@Override
	public final @NonNull Iterable<Edge> getRealizedEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(edges, IsRealizedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<NavigationEdge> getRealizedNavigationEdges() {
		@SuppressWarnings({"null", "unchecked"})
		@NonNull Iterable<NavigationEdge> filter = (Iterable<NavigationEdge>)(Object)Iterables.filter(edges, IsRealizedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getRealizedNodes() {
		return Iterables.filter(nodes, IsRealizedNodePredicate.INSTANCE);
	}

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getRealizedVariableNodes() {
		return Iterables.filter(nodes, IsRealizedVariableNodePredicate.INSTANCE);
	}

	@Override
	public final @NonNull Iterable<Edge> getRecursionEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(edges, IsRecursionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull List<Connection> getRootConnections() {
		return rootConnections;
	}

	@Override
	public @NonNull SchedulerConstants getSchedulerConstants() {
		return superRegion.getSchedulerConstants();
	}
	
	@Override
	public @Nullable String getShape() {
		return null;
	}

	@Override
	public @Nullable String getStyle() {
		return null;
	}

	@Override
	public @NonNull SuperRegion getSuperRegion() {
		return superRegion;
	}

	@Override
	@SuppressWarnings("null")
	public final @NonNull Iterable<Node> getTrueNodes() {
		return Iterables.filter(nodes, IsTrueNodePredicate.INSTANCE);
	}

	@Override
	public @NonNull List<Connection> getUsedConnections() {			// FIXME cache
		List<Connection> usedConnections = new ArrayList<Connection>();
		for (Node node : getPredicatedNodes()) {
			for (Connection usedBindingEdge : node.getIncomingUsedConnections()) {
			usedConnections.add(usedBindingEdge);
			}
		}
		return usedConnections;
	}

	/**
	 * Expand/create and return sequentialRegion to cascade thisAction and its transitive
	 * successors as possible into a sequentially scheduled region. The invocation only makes a
	 * single attempt to cascade each successor, so it is possible that initial failures could
	 * succeed following further growth.
	 *
	@Override
	public @Nullable HierarchicalRegion growHierarchicalRegion(@Nullable HierarchicalRegion hierarchicalRegion) {
		for (@SuppressWarnings("null")@NonNull Region nextRegion : getSuccessors()) {
			Map<Node, Node> bindings = HierarchicalRegion.getHierarchicalBinding(nextRegion, this);
			if (bindings != null) {
				if (hierarchicalRegion == null) {
					hierarchicalRegion = new HierarchicalRegion(this);
//					this.setInvokingRegion(hierarchicalRegion);
				}
				resolveFutureNodes(hierarchicalRegion, bindings);
				hierarchicalRegion.addAction(this, nextRegion, bindings);
//				nextRegion.setInvokingRegion(hierarchicalRegion);
//				hierarchicalRegion = nextRegion.growhierarchicalRegion(hierarchicalRegion);
			}
		}
		if (hierarchicalRegion != null) {
			hierarchicalRegion.toDOT();
		}
		return hierarchicalRegion;
	} */

	/**
	 * Expand/create and return sequentialRegion to cascade thisAction and its transitive
	 * successors as possible into a sequentially scheduled region. The invocation only makes a
	 * single attempt to cascade each successor, so it is possible that initial failures could
	 * succeed following further growth.
	 *
	@Override
	public @Nullable SequentialRegion growSequentialRegion(@Nullable SequentialRegion sequentialRegion) {
		for (@SuppressWarnings("null")@NonNull Region nextRegion : getSuccessors()) {
			Map<Node, Node> bindings = SequentialRegion.getSequentialBinding(nextRegion, this);
			if (bindings != null) {
				if (sequentialRegion == null) {
					sequentialRegion = new SequentialRegion(this);
//					this.setInvokingRegion(sequentialRegion);
				}
				resolveFutureNodes(sequentialRegion, bindings);
				sequentialRegion.addAction(this, nextRegion, bindings);
//				nextRegion.setInvokingRegion(sequentialRegion);
				sequentialRegion = nextRegion.growSequentialRegion(sequentialRegion);
			}
		}
		return sequentialRegion;
	} */

	@Override
	public boolean isLateMergeable(@NonNull Region consumerRegion, @NonNull Region2Depth region2depths) {
/*		for (Node consumerNode : consumerRegion.getPredicatedNodes()) {
			for (Node producerNode : consumerNode.getUsedBindingSources()) {
				Region producerRegion = producerNode.getRegion();
				if ((producerRegion != this) && (producerRegion != consumerRegion)) {
					Region commonRegion = region2depths.getCommonRegion(consumerRegion, producerRegion);
//					if (commonRegion != producerRegion) {
						if (commonRegion == null) {
							return false;
						}
						int consumerIndex = region2depths.getChildIndexOf(commonRegion, consumerRegion);
						if (consumerIndex < 0) {
							return false;
						}
						int producerIndex = region2depths.getChildIndexOf(commonRegion, producerRegion);
						if (producerIndex < 0) {
							return false;
						}
						if (producerIndex > consumerIndex) {
							return false;
						}
//					}
				}
			}
		} */
		return true;
	} 
	
/*	@Override
	public void removeNode(@NonNull FutureNode futureNode) {
		boolean removedNode = nodes.remove(futureNode);
		assert removedNode;
	} */

/*	private void resolveFutureNodes(@NonNull CompositeStartRegion compositeRegion, @NonNull Map<Node, Node> bindings) {
		for (Map.Entry<Node, Node> entry : bindings.entrySet()) {
			Node invokingNode = entry.getValue();
			if (invokingNode instanceof FutureNode) {
				invokingNode = ((FutureNode)invokingNode).resolveFutureNode(compositeRegion);
				bindings.put(entry.getKey(), invokingNode);
			}
		}
	} */

	/**
	 * Return true if the operation nodes for primaryNode and secondaryNode are equivalent
	 * assigning equivalences to equivalentNodes.
	 */
	private boolean isEquivalent(@NonNull Node primaryNode, @NonNull Node secondaryNode, @NonNull Map<Node, Node> equivalentNodes) {
		Node node = equivalentNodes.get(primaryNode);
		if (node != null) {
			return node == secondaryNode;
		}
		if (primaryNode.getNodeRole() != secondaryNode.getNodeRole()) {
			return false;
		}
		if (!ClassUtil.safeEquals(primaryNode.getName(), secondaryNode.getName())) {		// FIXME stronger e.g. referredOperation
			return false;
		}
		equivalentNodes.put(primaryNode, secondaryNode);
		for (Edge primaryEdge : primaryNode.getArgumentEdges()) {
			boolean gotIt = false;
			for (Edge secondaryEdge : secondaryNode.getArgumentEdges()) {
				if (ClassUtil.safeEquals(primaryEdge.getName(), secondaryEdge.getName())) {
					if (!isEquivalent(primaryEdge.getSource(), secondaryEdge.getSource(), equivalentNodes)) {
						return false;
					}
					gotIt = true;
					break;
				}
			}
			if (!gotIt) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isCompositionRegion() {
		return false;
	}

	@Override
	public boolean isOperationRegion() {
		return false;
	}

	@Override
	public boolean isRootRegion() {
		return false;
	}

	/**
	 * Refine the call bindings of a mapping so that:
	 * 
	 * Passed Bindings to the head that violate the head's predicates are removed, and in the case of a single caller
	 * the passed binding is redirected direct to the caller to facilitate re-use of the calling context.
	 */
	@Override
	public void refineBindings(@NonNull Region bindingRegion) {
		refineHeadBindings(bindingRegion);
/*		List<Node> predicatedNodes = new ArrayList<Node>();
		Iterables.addAll(predicatedNodes, getPredicatedNodes());
		for (Node calledNode : predicatedNodes) {
			if (calledNode.isHead() && !calledNode.isAttributeNode()) {
//					for (@SuppressWarnings("null")@NonNull List<Node> headGroup : calledRegion.getHeadNodeGroups()) {
//						for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
						List<Node> resolvedCallingSources = new ArrayList<Node>();
						boolean prunedOne = false;
						for (@SuppressWarnings("null")@NonNull Node callingSource : calledNode.getPassedBindingSources()) {
							if (canExpandRecursion(callingSource, calledNode, new HashMap<Node, Node>())) {
								resolvedCallingSources.add(callingSource);
							}
							else {
								prunedOne = true;
							}
						}
						if (prunedOne) {
							List<Edge> deadEdges = new ArrayList<Edge>();
							Iterables.addAll(deadEdges, calledNode.getIncomingPassedBindingEdges());
							for (@SuppressWarnings("null")@NonNull Edge deadEdge : deadEdges) {
								deadEdge.destroy();
							}
							Node targetNode = calledNode;
							if (resolvedCallingSources.size() > 1) {
								targetNode = Nodes.JOIN.createNode(this, "-join-", targetNode.getClassDatumAnalysis());
								Edges.PASSED_BINDING.createEdge(this, targetNode, null, calledNode);
							}
							for (@SuppressWarnings("null")@NonNull Node resolvedCallingSource : resolvedCallingSources) {
								Edges.PASSED_BINDING.createEdge(this, resolvedCallingSource, null, targetNode);
							}
						}
//						}
//					}
			}
			else if (!calledNode.isHead() && !calledNode.isAttributeNode()) {
				List<NavigationEdge> bestPath = null;
				for (@SuppressWarnings("null")@NonNull List<Node> headGroup : getHeadNodeGroups()) {
					for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
						bestPath = getBestPath(bestPath, getPath(headNode, calledNode, new HashSet<Edge>()));
					}
				}
				if (bestPath != null) {
					for (@SuppressWarnings("null")@NonNull List<Node> headGroup : getHeadNodeGroups()) {
						for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
							List<Node> resolvedCallingSources = new ArrayList<Node>();
							for (@SuppressWarnings("null")@NonNull Node callingSource : headNode.getPassedBindingSources()) {
								Region callingRegion = callingSource.getRegion();
								boolean isRecursion = false;
								if (callingRegion == this) {
									for (Edge edge : calledNode.getRecursionEdges()) {
										if (edge.getTarget() == headNode) {
											isRecursion= true;
										}
									}
								}
								if (!isRecursion) {
									if (canCreatePath(callingSource, bestPath)) {
										resolvedCallingSources.add(callingSource);
									}
								}
							}
							for (@SuppressWarnings("null")@NonNull Node callingSource : resolvedCallingSources) {
								Map<Edge, Edge> innerEdge2outerEdge = createPath(callingSource, bestPath);
								List<Edge> deadEdges = new ArrayList<Edge>();
								for (@SuppressWarnings("null")@NonNull Map.Entry<Edge, Edge> entry : innerEdge2outerEdge.entrySet()) {
									Edge innerEdge2 = entry.getKey();
									Node innerTarget = innerEdge2.getTarget();
									for (Edge bindingEdge : innerTarget.getIncomingUsedBindingEdges()) {
										deadEdges.add(bindingEdge);
									}
									Edge outerEdge = entry.getValue();
									Edges.USED_BINDING.createEdge(this, outerEdge.getTarget(), innerEdge2.getName(), innerTarget);
								}
								for (@SuppressWarnings("null")@NonNull Edge deadEdge : deadEdges) {
									deadEdge.destroy();
								}
							}
						}
					}
				}
			}
		} */
	}

	/**
	 * Refine the call bindings of a mapping so that:
	 * 
	 * Passed Bindings to the head that violate the head's predicates are removed, and in the case of a single caller
	 * the passed binding is redirected direct to the caller to facilitate re-use of the calling context.
	 */
	protected void refineHeadBindings(@NonNull Region bindingRegion) {
/*		for (@SuppressWarnings("null")@NonNull List<Node> headGroup : getHeadNodeGroups()) {
			for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
				List<Node> resolvedCallingSources = new ArrayList<Node>();
				boolean prunedOne = false;
				for (@SuppressWarnings("null")@NonNull Node callingSource : headNode.getPassedBindingSources()) {
					if (isConflictFree(callingSource, headNode)) {
						resolvedCallingSources.add(callingSource);
					}
					else {
						prunedOne = true;
					}
				}
				if (prunedOne) {
					List<Edge> deadEdges = new ArrayList<Edge>();
					Iterables.addAll(deadEdges, headNode.getIncomingPassedBindingEdges());
					for (@SuppressWarnings("null")@NonNull Edge deadEdge : deadEdges) {
						deadEdge.destroy();
					}
					Node targetNode = headNode;
					if (resolvedCallingSources.size() > 1) {
						targetNode = Nodes.JOIN.createNode(this, "-join-", targetNode.getClassDatumAnalysis());
						Edges.PASSED_BINDING.createEdge(bindingRegion, targetNode, null, headNode);
					}
					for (@SuppressWarnings("null")@NonNull Node resolvedCallingSource : resolvedCallingSources) {
						Edges.PASSED_BINDING.createEdge(bindingRegion, resolvedCallingSource, null, targetNode);
					}
				}
			}
		} */
	}

	@Override
	public void removeEdge(@NonNull Edge edge) {
		boolean wasRemoved = edges.remove(edge);
		assert wasRemoved;
	}

	@Override
	public void removeNode(@NonNull Node node) {
		boolean wasRemoved = nodes.remove(node);
		assert wasRemoved;
	}

	public void resolveRecursion() {
		Map<CompleteClass, List<Node>> completeClass2node = getCompleteClass2Node();
		List<List<Node>> headNodeGroups = getHeadNodeGroups();
		if (headNodeGroups.size() == 1) {			// FIXME multi-heads
			for (Node headNode : headNodeGroups.get(0)) {
				List<Node> nodeList = completeClass2node.get(headNode.getCompleteClass());
				assert nodeList != null;
				if (nodeList.size() <= 1) {
					break;
				}
				for (@SuppressWarnings("null")@NonNull Node node : nodeList) {
					if (node != headNode) {
						Map<Node, Node> bindings = expandRecursion(headNode, node, new HashMap<Node, Node>());
						if (bindings != null) {
	//						this.recursiveBindings  = bindings;
							for (Map.Entry<Node, Node> entry : bindings.entrySet()) {
								@SuppressWarnings("null")@NonNull Node prevNode = entry.getKey();
								@SuppressWarnings("null")@NonNull Node nextNode = entry.getValue();
								(prevNode.isHead() ? Edges.PRIMARY_RECURSION : Edges.SECONDARY_RECURSION).createEdge(this, prevNode, nextNode);
							}
							return;				// FIXME can we have more than one recursion ??
						}
					}
				}
			}
		}
	}

	private @Nullable Node selectMergedHeadNode(@NonNull Node headNode, @NonNull List<Node> mergedNodes) {
		if (mergedNodes.size() == 1) {
			Node mergedNode = mergedNodes.get(0);
			if (mergedNode.isIterator()) {
				return null;
			}
			return mergedNode;
		}
		if (mergedNodes.size() == 0) {
			return null;
		}
		Iterable<NavigationEdge> predicateEdges = headNode.getPredicateEdges();
//		if (predicateEdges == null) {
//			return null;
//		}
		for (Node mergedNode : mergedNodes) {
			boolean ok = !mergedNode.isIterator();
			if (ok) {
				for (NavigationEdge predicateEdge : predicateEdges) {
					Property property = predicateEdge.getProperty();
					Node navigation = mergedNode.getNavigationTarget(property);
					if (navigation == null) {
						ok = false;
						break;
					}
				}
			}
			if (ok) {						// FIXME stronger checking
				return mergedNode;
			}
		}
		return null;
	}

	@Override
	public void setInvokingRegion(@NonNull Region invokingRegion) {
		this.invokingRegion  = invokingRegion;
	}
	
	@Override
	public void setIndexes(int earliestIndex, int latestIndex) {
		this.earliestIndex = earliestIndex;
		this.latestIndex = latestIndex;
	}

	@Override
	public String toDOT() {
		DOTStringBuilder s = new DOTStringBuilder();
		toGraph(s);
		return s.toString();
	}
	
	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@SuppressWarnings("null")@NonNull Node node : getNodes()) {
			s.appendNode(node);
		}
		for (@SuppressWarnings("null")@NonNull Edge edge : getEdges()) {
			s.appendEdge(edge);
		}
		s.popCluster();
	}

	@Override
	public String toGraphML() {
		GraphMLStringBuilder s = new GraphMLStringBuilder();
		toGraph(s);
		return s.toString();
	}

	@Override
	public String toString() {
		return getName();
	}

//	@Override
//	public void writeDOTfile(@NonNull String suffix) {
//		getSchedulerConstants().writeDOTfile(this, suffix);
//	}

//	@Override
//	public void writeGraphMLfile(@NonNull String suffix) {
//		getSchedulerConstants().writeGraphMLfile(this, suffix);
//	}
}