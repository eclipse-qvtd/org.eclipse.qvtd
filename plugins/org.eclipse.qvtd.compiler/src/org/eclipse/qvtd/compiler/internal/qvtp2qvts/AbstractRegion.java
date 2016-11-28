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
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.StringUtil;
import org.eclipse.qvtd.compiler.CompilerProblem;
import org.eclipse.qvtd.compiler.internal.qvtp2qvts.analysis.ClassDatumAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvti.QVTs2QVTiVisitor;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.Region2Depth;
import org.eclipse.qvtd.compiler.internal.utilities.SymbolNameBuilder;
import org.eclipse.qvtd.compiler.internal.utilities.ToDOT;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphEdge;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphNode;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public abstract class AbstractRegion implements Region, ToDOT.ToDOTable
{
	public static class EarliestRegionComparator implements Comparator<@NonNull Region>
	{
		public static final @NonNull EarliestRegionComparator INSTANCE = new EarliestRegionComparator();

		public static @NonNull List<@NonNull Region> sort(@NonNull Iterable<@NonNull Region> regions) {
			List<@NonNull Region> sortedRegions = new ArrayList<>();
			Iterables.addAll(sortedRegions, regions);
			Collections.sort(sortedRegions, INSTANCE);
			return sortedRegions;
		}

		@Override
		public int compare(@NonNull Region o1, @NonNull Region o2) {
			int i1 = o1.getInvocationIndex();
			int i2 = o2.getInvocationIndex();
			return i1 - i2;
		}
	}

	public static final class EdgeSourceFunction implements Function<@NonNull Edge, @NonNull Node>
	{
		public static final @NonNull EdgeSourceFunction INSTANCE = new EdgeSourceFunction();

		@Override
		public @NonNull Node apply(@NonNull Edge edge) {
			return edge.getSource();
		}
	}

	public static final class EdgeTargetFunction implements Function<@NonNull Edge, @NonNull Node>
	{
		public static final @NonNull EdgeTargetFunction INSTANCE = new EdgeTargetFunction();

		@Override
		public @NonNull Node apply(@NonNull Edge edge) {
			return edge.getTarget();
		}
	}

	public static final class IsAssignedNodePredicate implements Predicate<@NonNull Node>
	{
		public static final @NonNull IsAssignedNodePredicate INSTANCE = new IsAssignedNodePredicate();

		@Override
		public boolean apply(@NonNull Node node) {
			return node.isRealized() || node.isSpeculation();
		}
	}

	public static final class IsAssignmentEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsAssignmentEdgePredicate INSTANCE = new IsAssignmentEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isRealized();
		}
	}

	public static final class IsCallableRegionPredicate implements Predicate<@NonNull Region>
	{
		public static final @NonNull IsCallableRegionPredicate INSTANCE = new IsCallableRegionPredicate();

		@Override
		public boolean apply(@NonNull Region region) {
			return !region.isOperationRegion();
		}
	}

	public static final class IsCastEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsCastEdgePredicate INSTANCE = new IsCastEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isCast();
		}
	}

	public static final class IsComposedNodePredicate implements Predicate<@NonNull Node>
	{
		public static final @NonNull IsComposedNodePredicate INSTANCE = new IsComposedNodePredicate();

		@Override
		public boolean apply(@NonNull Node node) {
			return node.isComposed();
		}
	}

	public static final class IsComputationEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsComputationEdgePredicate INSTANCE = new IsComputationEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isComputation();
		}
	}

	/*	public static final class IsComputedPredicate implements Predicate<@NonNull Node>
	{
		public static final @NonNull IsComputedPredicate INSTANCE = new IsComputedPredicate();

		@Override
		public boolean apply(@NonNull Node node) {
			return node.isRealized();
		}
	} */

	public static final class IsExpressionEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsExpressionEdgePredicate INSTANCE = new IsExpressionEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isExpression();
		}
	}

	public static final class IsNavigableNodePredicate implements Predicate<@NonNull Node>
	{
		public static final @NonNull IsNavigableNodePredicate INSTANCE = new IsNavigableNodePredicate();

		@Override
		public boolean apply(@NonNull Node node) {
			return node.isMatched();
		}
	}

	public static final class IsNavigationEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsNavigationEdgePredicate INSTANCE = new IsNavigationEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isNavigation();
		}
	}

	public static final class IsNewNodePredicate implements Predicate<@NonNull Node>
	{
		public static final @NonNull IsNewNodePredicate INSTANCE = new IsNewNodePredicate();

		@Override
		public boolean apply(@NonNull Node node) {
			return node.isRealized() || node.isSpeculation();
		}
	}

	public static final class IsOldNodePredicate implements Predicate<@NonNull Node>
	{
		public static final @NonNull IsOldNodePredicate INSTANCE = new IsOldNodePredicate();

		@Override
		public boolean apply(@NonNull Node node) {
			return node.isConstant() || node.isLoaded() || node.isPredicated() || node.isSpeculated();
		}
	}

	public static final class IsPatternNodePredicate implements Predicate<@NonNull Node>
	{
		public static final @NonNull IsPatternNodePredicate INSTANCE = new IsPatternNodePredicate();

		@Override
		public boolean apply(@NonNull Node node) {
			return node.isPattern();
		}
	}

	public static final class IsPredicatedEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsPredicatedEdgePredicate INSTANCE = new IsPredicatedEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isPredicated();
		}
	}

	public static final class IsPredicatedNavigationEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsPredicatedNavigationEdgePredicate INSTANCE = new IsPredicatedNavigationEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isPredicated() && edge.isNavigation();
		}
	}

	public static final class IsRealizedEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsRealizedEdgePredicate INSTANCE = new IsRealizedEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isRealized();
		}
	}

	public static final class IsRealizedNavigationEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsRealizedNavigationEdgePredicate INSTANCE = new IsRealizedNavigationEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isRealized() && edge.isNavigation();
		}
	}

	public static final class IsRecursionEdgePredicate implements Predicate<@NonNull Edge>
	{
		public static final @NonNull IsRecursionEdgePredicate INSTANCE = new IsRecursionEdgePredicate();

		@Override
		public boolean apply(@NonNull Edge edge) {
			return edge.isRecursion();
		}
	}

	public static final class IsTrueNodePredicate implements Predicate<@NonNull Node>
	{
		public static final @NonNull IsTrueNodePredicate INSTANCE = new IsTrueNodePredicate();

		@Override
		public boolean apply(@NonNull Node node) {
			return node.isTrue();
		}
	}

	protected final @NonNull MultiRegion multiRegion;
	private @Nullable ScheduledRegion invokingRegion = null;

	/**
	 * All the edges defined in this region, but not those in nested regions.
	 */
	private final @NonNull List<@NonNull Edge> edges = new ArrayList<>();

	/**
	 * All the nodes defined in this region, but not those in nested regions.
	 */
	private final @NonNull List<@NonNull Node> nodes = new ArrayList<>();

	/**
	 * The indexes in the overall schedule at which this region can be executed. The first index is the index at which ALL
	 * invocations occur. Subsequent indexes are when a referenced value may become available enabling a deferred execution.
	 */
	private final @NonNull List<@NonNull Integer> indexes = new ArrayList<>();

	/**
	 * Ordered list of regions that call this region
	 */
	private final @NonNull List<@NonNull Region> callableParents = new ArrayList<>();

	/**
	 * Ordered list of regions that this region calls. May exclude some children whose dependencies are unsatisfied.
	 * May include non-children whose dependencies are satisfied by earlier child calls.
	 */
	private final @NonNull List<@NonNull Region> callableChildren = new ArrayList<>();

	/**
	 * The per-typed model predicated navigable edges for which an execution may be attempted before assignment.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges = null;

	/**
	 * The per-typed model realized navigable edges for which an execution may be attempted elsewhere before assignment here.
	 */
	private @Nullable Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2enforcedEdges = null;

	private @Nullable String symbolName = null;

	@SuppressWarnings("unused")			// Used in the debugger
	private final @NonNull ToDOT toDot = new ToDOT(this){};

	/**
	 * The connections hosted by this region and passed to child regions.
	 */
	private @NonNull List<@NonNull NodeConnection> rootConnections = new ArrayList<>();

	/**
	 * The connections propagated as middle guards from a hosted by a parent region and to one or more child regions.
	 */
	private @NonNull List<@NonNull NodeConnection> intermediateConnections = new ArrayList<>();

	/**
	 * Set true if this region recurses on its outputs.
	 */
	//	private boolean isCyclic = false;

	protected AbstractRegion(@NonNull MultiRegion multiRegion) {
		this.multiRegion = multiRegion;
		multiRegion.addRegion(this);
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
		for (@NonNull Edge oldEdge : edges) {
			if (oldEdge.getEdgeRole() == edge.getEdgeRole()) {
				//				assert (edge.getSource() != oldEdge.getSource()) || (edge.getTarget() != oldEdge.getTarget());
			}
		}
		edges.add(edge);
	}

	private void addCheckedEdge(@NonNull NavigableEdge predicatedEdge) {
		assert predicatedEdge.isPredicated();
		assert predicatedEdge.getRegion() == this;
		Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2checkedEdges2 = typedModel2checkedEdges;
		assert typedModel2checkedEdges2 != null;
		TypedModel typedModel = predicatedEdge.getSource().getClassDatumAnalysis().getTypedModel();
		Set<@NonNull NavigableEdge> checkedEdges = typedModel2checkedEdges2.get(typedModel);
		if (checkedEdges == null) {
			checkedEdges = new HashSet<>();
			typedModel2checkedEdges2.put(typedModel, checkedEdges);
		}
		checkedEdges.add(predicatedEdge);
		QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    checked " + predicatedEdge.getProperty() +
			" at " + getIndexRangeText() + " in " + typedModel + " for " + this);
	}

	@Override
	public void addEnforcedEdge(@NonNull NavigableEdge realizedEdge) {
		assert realizedEdge.isRealized();
		assert realizedEdge.getRegion() == this;
		Map<@NonNull TypedModel, @NonNull Set<@NonNull NavigableEdge>> typedModel2enforcedEdges2 = typedModel2enforcedEdges;
		assert typedModel2enforcedEdges2 != null;
		TypedModel typedModel = realizedEdge.getSource().getClassDatumAnalysis().getTypedModel();
		Set<@NonNull NavigableEdge> enforcedEdges = typedModel2enforcedEdges2.get(typedModel);
		if (enforcedEdges == null) {
			enforcedEdges = new HashSet<>();
			typedModel2enforcedEdges2.put(typedModel, enforcedEdges);
		}
		enforcedEdges.add(realizedEdge);
		QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    enforced " + realizedEdge.getProperty() +
			" at " + getIndexRangeText() +
			" in " + realizedEdge.getSource().getClassDatumAnalysis().getTypedModel() + " for " + this);
	}

	@Override
	public boolean addIndex(int index) {
		for (int i = 0; i < indexes.size(); i++) {
			Integer anIndex = indexes.get(i);
			if (index == anIndex) {
				return false;
			}
			if (index < anIndex) {
				indexes.add(i, index);
				return true;
			}
		}
		indexes.add(index);
		return true;
	}

	@Override
	public void addIntermediateConnection(@NonNull NodeConnection connection) {
		assert !intermediateConnections.contains(connection);
		intermediateConnections.add(connection);
	}

	@Override
	public void addRootConnection(@NonNull NodeConnection connection) {
		assert !rootConnections.contains(connection);
		rootConnections.add(connection);
	}

	@Override
	public void addNode(@NonNull Node node) {
		assert !nodes.contains(node);
		nodes.add(node);
	}

	@Override
	public void addVariableNode(@NonNull VariableDeclaration typedElement, @NonNull Node simpleNode) {}

	@Override
	public void appendNode(@NonNull GraphStringBuilder s, @NonNull String nodeName) {
		String name = getSymbolName() + "\\n " + getName();
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

	protected @Nullable String basicGetSymbolName() {
		return symbolName;
	}

	@Override
	public void buildPredicatedNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges) {
		for (@NonNull NavigableEdge predicatedEdge : getPredicatedNavigationEdges()) {
			if (!predicatedEdge.isCast()) {
				Property property = predicatedEdge.getProperty();
				Node predicatedNode = predicatedEdge.getSource();
				TypedModel typedModel = predicatedNode.getClassDatumAnalysis().getTypedModel();
				Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2predicatedEdges = typedModel2property2predicatedEdges.get(typedModel);
				if (property2predicatedEdges == null) {
					property2predicatedEdges = new HashMap<>();
					typedModel2property2predicatedEdges.put(typedModel, property2predicatedEdges);
				}
				List<@NonNull NavigableEdge> predicatedEdges = property2predicatedEdges.get(property);
				if (predicatedEdges == null) {
					predicatedEdges = new ArrayList<>();
					property2predicatedEdges.put(property, predicatedEdges);
				}
				predicatedEdges.add(predicatedEdge);
				QVTs2QVTiVisitor.POLLED_PROPERTIES.println("  " + typedModel + " predicated for " + property);
			}
		}
		typedModel2checkedEdges = new HashMap<>();
	}

	@Override
	public void buildRealizedNavigationEdgesIndex(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		for (@NonNull NavigableEdge realizedEdge : getRealizedNavigationEdges()) {
			Property property = realizedEdge.getProperty();
			Node realizedNode = realizedEdge.getSource();
			TypedModel typedModel = realizedNode.getClassDatumAnalysis().getTypedModel();
			Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
			if (property2realizedEdges == null) {
				property2realizedEdges = new HashMap<>();
				typedModel2property2realizedEdges.put(typedModel, property2realizedEdges);
			}
			List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(property);
			if (realizedEdges == null) {
				realizedEdges = new ArrayList<>();
				property2realizedEdges.put(property, realizedEdges);
			}
			realizedEdges.add(realizedEdge);
			QVTs2QVTiVisitor.POLLED_PROPERTIES.println("  " + typedModel + " realized for " + property);
		}
		typedModel2enforcedEdges = new HashMap<>();
	}

	/**
	 * Return true if a navigable path from startNode following the edges of protoPath,
	 * re-using edges and nodes where possible could be created. REturn false if such
	 * a path would violate a null parent requirement.
	 */
	protected boolean canCreatePath(@NonNull Node startNode, @NonNull List<@NonNull NavigableEdge> protoPath) {
		//		Map<Edge, Edge> path = new HashMap<>();
		//		Region region = startNode.getRegion();
		Node sourceNode = startNode;
		for (@NonNull NavigableEdge protoEdge : protoPath) {
			NavigableEdge edge = sourceNode.getNavigationEdge(protoEdge.getProperty());
			if (edge != null) {
				Node protoTarget = protoEdge.getTarget();
				Node target = edge.getTarget();
				if (target.isExplicitNull() != (protoTarget.isExplicitNull())) {
					return false;
				}
				sourceNode = target;
			}
		}
		return true;
	}

	@Override
	public @Nullable Map<@NonNull Node, @NonNull Node> canMerge(@NonNull Region secondaryRegion, @NonNull Region2Depth region2depths, boolean isLateMerge) {
		Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode = null;
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2node = getCompleteClass2Node();
		//
		//	Find the unambiguous head-node matches
		//
		List<@NonNull Node> secondaryHeadNodes = secondaryRegion.getHeadNodes();
		if (secondaryHeadNodes.size() != 1) {
			return null;
		}
		Node secondaryHeadNode = secondaryHeadNodes.get(0);
		CompleteClass completeClass = secondaryHeadNode.getCompleteClass();
		List<@NonNull Node> primaryNodes = completeClass2node.get(completeClass);
		if (primaryNodes != null) {
			Node primaryHeadNode = selectMergedHeadNode(secondaryHeadNode, primaryNodes);
			if (primaryHeadNode == null) {
				return null;
			}
			secondaryNode2primaryNode = new HashMap<>();
			if ("if".equals(secondaryHeadNode.getName())) {
				secondaryHeadNode.getName();
			}
			secondaryNode2primaryNode.put(secondaryHeadNode, primaryHeadNode);
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
		Iterable<@NonNull Node> primaryTrueNodes = this.getTrueNodes();
		Iterable<@NonNull Node> secondaryTrueNodes = secondaryRegion.getTrueNodes();
		if (Iterables.size(primaryTrueNodes) != Iterables.size(secondaryTrueNodes)) {
			return null;
		}
		for (@NonNull Node primaryTrueNode : primaryTrueNodes) {
			boolean gotIt = false;
			for (@NonNull Node secondaryTrueNode : secondaryTrueNodes) {
				assert secondaryTrueNode != null;
				Map<@NonNull Node, @NonNull Node> primary2secondary = new HashMap<>();
				if (isEquivalent(primaryTrueNode, secondaryTrueNode, primary2secondary)) {	// FIXME use hashes
					gotIt = true;
					for (@NonNull Node primaryNode : primary2secondary.keySet()) {
						Node equivalentNode = primary2secondary.get(primaryNode);
						assert equivalentNode != null;
						if ("if".equals(equivalentNode.getName())) {
							equivalentNode.getName();
						}
						secondaryNode2primaryNode.put(equivalentNode, primaryNode);
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
	private boolean canMergeInternal(@NonNull Region secondaryRegion, @NonNull Map<@NonNull Node, @NonNull Node> secondaryNode2primaryNode, @NonNull Region2Depth region2depths, boolean isLateMerge) {
		Set<@NonNull Node> secondaryNodes = new HashSet<>(secondaryNode2primaryNode.keySet());
		List<@NonNull Node> secondaryNodesList = new ArrayList<>(secondaryNodes);
		for (int i = 0; i < secondaryNodesList.size(); i++) {
			@NonNull Node secondarySourceNode = secondaryNodesList.get(i);
			Node primarySourceNode = secondaryNode2primaryNode.get(secondarySourceNode);
			if (primarySourceNode == null) {
				if (secondarySourceNode.isPredicated()) {
					return false;
				}
			}
			for (@NonNull NavigableEdge secondaryEdge : secondarySourceNode.getNavigationEdges()) {
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
						if (primaryTargetNode.isExplicitNull() != secondaryTargetNode.isExplicitNull()) {		// FIXME conforms
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
						if ("if".equals(secondaryTargetNode.getName())) {
							secondaryTargetNode.getName();
						}
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
			if (!isLateMerge && (primarySourceNode != null)) {
				for (@NonNull Edge secondaryEdge : secondarySourceNode.getComputationEdges()) {
					Node secondaryTargetNode = secondaryEdge.getTarget();
					Node primaryTargetNode = null;
					for (@NonNull Edge primaryEdge : primarySourceNode.getComputationEdges()) {
						if (ClassUtil.safeEquals(primaryEdge.getName(), secondaryEdge.getName())) {
							primaryTargetNode = primaryEdge.getTarget();
							if (isEquivalent(secondaryTargetNode, primaryTargetNode, secondaryNode2primaryNode)) {
								secondaryNodesList.add(secondaryTargetNode);
							}
						}
					}
				}
			}
			/*

					}
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
	public void checkIncomingConnections() {
		/*		for (@NonNull Node node : getNodes()) {
			NodeConnection incomingConnection = node.getIncomingConnection();
			int incomingConnectionsSize = incomingConnection != null ? 1 : 0;
			if ((node.getNodeRole() == Nodes.COMPOSING) && node.getRegion().isRootCompositionRegion()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isTrue()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isHead()) {
//				assert incomingConnectionsSize == 1;
				if (incomingConnectionsSize != 1) {
					System.out.println("Inconsistent other incoming connections for " + node + " in " + this);
				}
			}
			else if (node.isAttributeNode()) {
//				assert incomingConnectionsSize == 0;		// ?? should we connect these
			}
			else if (node.isComposed()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isNull()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isOperation()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isRealized()) {
				assert incomingConnectionsSize == 0;
			}
			else if (node.isGuard()) {
				;//assert incomingConnectionsSize == 0;
			}
			else if (node.isLoaded()) {
				;//assert incomingConnectionsSize == 0;
			}
			else {
				if (incomingConnectionsSize != 1) {
					System.out.println("Inconsistent other incoming connections for " + node + " in " + this);
				}
			}
		} */
	}

	@Override
	public void computeCheckedOrEnforcedEdges(@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2predicatedEdges,
			@NonNull Map<@NonNull TypedModel, @NonNull Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>>> typedModel2property2realizedEdges) {
		//		CompleteModel completeModel = getSchedulerConstants().getEnvironmentFactory().getCompleteModel();
		boolean doDebug = QVTs2QVTiVisitor.POLLED_PROPERTIES.isActive();
		if (doDebug) {
			QVTs2QVTiVisitor.POLLED_PROPERTIES.println("analyzing " + this + " (" + getIndexRangeText() + ")");
		}
		for (@NonNull NavigableEdge predicatedEdge : getPredicatedNavigationEdges()) {
			if (!predicatedEdge.isCast()) {
				Property property = predicatedEdge.getProperty();
				if (doDebug) {
					QVTs2QVTiVisitor.POLLED_PROPERTIES.println("  analyzing " + predicatedEdge.getSource().getName() + "::" + property.getName() + " : " + predicatedEdge.getSource().getCompleteClass());
				}
				EdgeConnection edgeConnection = predicatedEdge.getIncomingConnection();
				if (edgeConnection != null) {
					boolean isChecked = false;
					for (@NonNull NavigableEdge usedEdge : edgeConnection.getSources()) {
						Region usedRegion = usedEdge.getRegion();
						usedRegion.addEnforcedEdge(usedEdge);
						if (usedRegion.getFinalExecutionIndex() >= getInvocationIndex()) {
							addCheckedEdge(predicatedEdge);
							isChecked = true;
						}
					}
					if (isChecked) {
						for (@NonNull NavigableEdge usedEdge : edgeConnection.getSources()) {
							Region usedRegion = usedEdge.getRegion();
							usedRegion.addEnforcedEdge(usedEdge);
						}
					}
				}

				Node laterNode = predicatedEdge.getSource();
				Node predicatedSourceNode = predicatedEdge.getSource();
				Node predicatedTargetNode = predicatedEdge.getTarget();
				NodeConnection usedConnection = predicatedTargetNode.getIncomingUsedConnection();
				if (usedConnection != null) {
					for (@NonNull Node usedSourceNode : usedConnection.getSources()) {
						Region usedRegion = usedSourceNode.getRegion();
						if (usedRegion.getFinalExecutionIndex() >= getInvocationIndex()) {			// FIXME =
							CompleteClass predicatedSourceType = predicatedSourceNode.getCompleteClass();
							CompleteClass predicatedTargetType = predicatedTargetNode.getCompleteClass();
							ClassDatumAnalysis classDatumAnalysis = laterNode.getClassDatumAnalysis();
							TypedModel typedModel = classDatumAnalysis.getTypedModel();
							Map<@NonNull Property, @NonNull List<@NonNull NavigableEdge>> property2realizedEdges = typedModel2property2realizedEdges.get(typedModel);
							assert property2realizedEdges != null;
							Property oclContainerProperty = getStandardLibraryHelper().getOclContainerProperty();
							if (property == oclContainerProperty) {
								//								Node containerNode = predicatedEdge.getTarget();
								//								Node containedNode = predicatedEdge.getSource();
								//								CompleteClass containerType = containerNode.getCompleteClass();
								//								CompleteClass containedType = containedNode.getCompleteClass();
								for (@NonNull Property candidateProperty : property2realizedEdges.keySet()) {
									if (candidateProperty.isIsComposite()) {
										//										CompleteClass candidateContainerType = completeModel.getCompleteClass(candidateProperty.getOwningClass());
										//										CompleteClass candidateContainedType = completeModel.getCompleteClass(candidateProperty.getType());
										//									if (candidateContainerType.conformsTo(containerType) && containedType.conformsTo(candidateContainedType)) {
										List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(candidateProperty);
										assert realizedEdges != null;
										for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
											// FIXME recheck for narrower types ??
											Region earlierRegion = realizedEdge.getRegion();
											//												String isNotHazardous;
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
												assert getFinalExecutionIndex() >= earlierRegion.getInvocationIndex();
												//														isNotHazardous = null;
											}
											else {
												//														isNotHazardous = "incompatible";
											}
											assert getFinalExecutionIndex() >= earlierRegion.getInvocationIndex();
											//													isNotHazardous = null;
											//											}
											//												if (isNotHazardous == null) {
											addCheckedEdge(predicatedEdge);
											earlierRegion.addEnforcedEdge(realizedEdge);
											//												}
											//												else if (doDebug) {
											//													QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    ignored " + this + "::" + laterNode.getName() + "(" + getEarliestIndex() + ".." + getLatestIndex() + ")" +
											//															" " + isNotHazardous + " (" + earlierRegion.getEarliestIndex() + ".." + earlierRegion.getLatestIndex() + ")" + earlierRegion + "::" + realizedEdge.getSource().getName());
											//												}
											//										}
										}
									}
								}
							}
							else {
								assert property2realizedEdges != null : "No realized typed model for " + typedModel;
								List<@NonNull NavigableEdge> realizedEdges = property2realizedEdges.get(property);
								if (realizedEdges == null) {
									System.err.println("No realized edges for " + property + " in " + typedModel);
								}
								else {
									for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
										Region earlierRegion = realizedEdge.getRegion();
										String checkIsHazardFreeBecause;
										String enforceIsHazardFreeBecause;
										Node realizedSourceNode = realizedEdge.getSource();
										Node realizedTargetNode = realizedEdge.getTarget();
										CompleteClass realizedSourceType = realizedSourceNode.getCompleteClass();
										CompleteClass realizedTargetType = realizedTargetNode.getCompleteClass();
										if (!realizedSourceType.conformsTo(predicatedSourceType) || !realizedTargetType.conformsTo(predicatedTargetType)) {
											checkIsHazardFreeBecause = "incompatible";
											enforceIsHazardFreeBecause = "incompatible";
										}
										else if (this == earlierRegion) {
											checkIsHazardFreeBecause = null; 		// Same region requires inter-recursion check
											enforceIsHazardFreeBecause = null; 		// Same region requires inter-recursion enforce to be available for check
										}
										else if (earlierRegion.getFinalExecutionIndex() < getInvocationIndex()) {
											checkIsHazardFreeBecause = "later";
											enforceIsHazardFreeBecause = null; 		// Enforce required for later check
										}
										else {
											// The QVTi AS has insufficient precision to identify which of multiple references is hazardous
											checkIsHazardFreeBecause = null;
											enforceIsHazardFreeBecause = null;
										}
										if (checkIsHazardFreeBecause == null) {
											addCheckedEdge(predicatedEdge);
										}
										else if (doDebug) {
											QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    ignored check for " + this + "::" + laterNode.getName() + "(" + getIndexRangeText() + ")" +
													" " + checkIsHazardFreeBecause + " (" + earlierRegion.getIndexRangeText() + ")" + earlierRegion + "::" + realizedEdge.getSource().getName());
										}
										if (enforceIsHazardFreeBecause == null) {
											earlierRegion.addEnforcedEdge(realizedEdge);
										}
										else if (doDebug) {
											QVTs2QVTiVisitor.POLLED_PROPERTIES.println("    ignored enforce " + this + "::" + laterNode.getName() + "(" + getIndexRangeText() + ")" +
													" " + enforceIsHazardFreeBecause + " (" + earlierRegion.getIndexRangeText() + ")" + earlierRegion + "::" + realizedEdge.getSource().getName());
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Recurse over the pattern of navigation edges from calledNode in a called mapping and callingNode in a calling mapping
	 *  to populate called2binding with the pair-wise equivalent nodes. The callingNode may be null for a null navigation.
	 *
	private void computeCompatiblePattern(@NonNull Node calledNode, @Nullable Node callingNode,
			@NonNull Map<@NonNull Node, @Nullable Node> calledNode2callingNode, @NonNull Map<@NonNull NavigationEdge, @Nullable NavigationEdge> calledEdge2callingEdge) {
		Node oldCallingNode = calledNode2callingNode.get(calledNode);
		if (oldCallingNode != null) {					// been here before
			assert (oldCallingNode == callingNode) || (callingNode == null);
			return;
		}
		if ((callingNode == null) && calledNode2callingNode.containsKey(calledNode)) {		// here before and consistently null
			return;
		}
		calledNode2callingNode.put(calledNode, callingNode);
		for (@NonNull NavigationEdge calledEdge : calledNode.getNavigationEdges()) {
			Node nextCalledNode = calledEdge.getTarget();
			if (!nextCalledNode.isRealized() && !nextCalledNode.isAttributeNode()) {
				Property property = calledEdge.getProperty();
				NavigationEdge callingEdge = callingNode != null ? callingNode.getNavigationEdge(property) : null;
				if (!property.isIsImplicit()) {
					calledEdge2callingEdge.put(calledEdge, callingEdge);
				}
				if (callingEdge != null) {
					Node nextCallingNode = callingEdge.getTarget();
					assert nextCallingNode.isNull() == nextCalledNode.isNull();
					if (!nextCalledNode.isNull()) {
						computeCompatiblePattern(nextCalledNode, nextCallingNode, calledNode2callingNode, calledEdge2callingEdge);
					}
				}
				else {
					computeCompatiblePattern(nextCalledNode, null, calledNode2callingNode, calledEdge2callingEdge);
				}
			}
		}
	} */

	protected @NonNull SymbolNameBuilder computeSymbolName() {
		//		List<String> names = new ArrayList<>();
		//		for (@NonNull MappingAction action : getMappingActions()) {
		//			names.add(action.getMapping().getName());
		//		}
		//		Collections.sort(names);
		SymbolNameBuilder s = null;
		Set<@NonNull Node> bestToOneSubRegion = null;
		Node bestNamingNode = null;
		for (@NonNull Node newNode : getNewNodes()) {
			Set<@NonNull Node> toOneSubRegion = computeToOneSubRegion(new HashSet<>(), newNode);
			if ((bestToOneSubRegion == null) || (toOneSubRegion.size() > bestToOneSubRegion.size())) {
				bestToOneSubRegion = toOneSubRegion;
				bestNamingNode = newNode;
			}
			else if ((bestNamingNode != null) && (toOneSubRegion.size() == bestToOneSubRegion.size())) {
				if (ClassUtil.safeCompareTo(bestNamingNode.getCompleteClass().getName(), newNode.getCompleteClass().getName()) > 0) {
					bestToOneSubRegion = toOneSubRegion;
					bestNamingNode = newNode;
				}
			}
		}
		if (bestNamingNode != null) {
			s = new SymbolNameBuilder();
			s.appendString("m_");
			s.appendName(bestNamingNode.getCompleteClass().getName());
			List<@NonNull String> headNames = new ArrayList<>();
			for (@NonNull Node headNode : getHeadNodes()) {
				String name = headNode.getCompleteClass().getName();
				if (name != null) {
					headNames.add(name);
				}
			}
			for (@NonNull String headName : headNames) {
				s.appendString("_");
				s.appendString(headName);
			}
		}
		else {
			for (@NonNull Node headNode : getHeadNodes()) {
				s = new SymbolNameBuilder();
				s.appendString("m_");
				s.appendName(headNode.getCompleteClass().getName());
				List<String> edgeNames = new ArrayList<>();
				for (@NonNull NavigableEdge edge : headNode.getNavigationEdges()) {
					String propertyName = edge.getProperty().getName();
					edgeNames.add(edge.getTarget().isExplicitNull() ? propertyName + "0" : propertyName);
				}
				Collections.sort(edgeNames);
				for (String edgeName : edgeNames) {
					s.appendString("_");
					s.appendName(edgeName);
				}
				break;
			}
		}
		if (s == null) {
			s = new SymbolNameBuilder();
			s.appendString("m_");
		}
		return s;
	}

	private @NonNull Set<@NonNull Node> computeToOneSubRegion(@NonNull Set<@NonNull Node> toOneSubRegion, @NonNull Node atNode) {
		if (toOneSubRegion.add(atNode)) {
			for (@NonNull NavigableEdge edge : atNode.getNavigationEdges()) {
				assert edge.getSource() == atNode;
				Property source2target = edge.getProperty();
				if (!source2target.isIsMany() && !source2target.isIsImplicit()) {
					computeToOneSubRegion(toOneSubRegion, edge.getTarget());
				}
			}
		}
		return toOneSubRegion;
	}

	/**
	 * Create a NodeConnection to the realized node for each attribute.
	 *
	private void createAttributeConnections() {
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		for (@NonNull NavigationEdge predicatedEdge : getPredicatedNavigationEdges()) {
			Node predicatedTarget = predicatedEdge.getTarget();
			if (predicatedEdge.isNavigation()
			 && !predicatedEdge.isCast()
			 && (predicatedTarget.getIncomingConnection() == null)
			 && predicatedTarget.isAttributeNode()) {			// FIXME isCast does not need to be isNavigation now that it can be isNavigable
				Iterable<@NonNull NavigationEdge> realizedEdges = rootScheduledRegion.getRealizedEdges(predicatedEdge);
				if (realizedEdges != null) {
					Property predicatedProperty = predicatedEdge.getProperty();
					assert !predicatedProperty.isIsImplicit();
					ClassDatumAnalysis classDatumAnalysis = predicatedTarget.getClassDatumAnalysis();
					List<@NonNull Node> sourceNodes = new ArrayList<>();
					for (@NonNull NavigationEdge realizedEdge : realizedEdges) {
						sourceNodes.add(realizedEdge.getTarget());
					}
					NodeConnection nodeConnection = invokingRegion2.getNodeConnection(sourceNodes, classDatumAnalysis);
					nodeConnection.addUsedTargetNode(predicatedTarget, false);
					if (Scheduler.CONNECTIONS.isActive()) {
						Scheduler.CONNECTIONS.println("  Attribute NodeConnection to " + predicatedTarget);
					}
				}
			}
		}
	} */

	/**
	 * Create an EdgeConnection for the predicatedEdge and/or its target node.
	 */
	private void createEdgeConnection(@NonNull NavigableEdge predicatedEdge) {
		assert predicatedEdge.isNavigation();
		assert predicatedEdge.getIncomingConnection() == null;
		if (predicatedEdge.isCast()) {
			return;			// casts are handled as an extension of a true navigation
		}
		Property predicatedProperty = predicatedEdge.getProperty();
		if (predicatedProperty.isIsImplicit()) {
			return;			// unnavigable opposites are handled by the navigable property
		}
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		NavigableEdge castEdge = RegionUtil.getCastTarget(predicatedEdge);
		Node castTarget = RegionUtil.getCastTarget(castEdge.getTarget());
		ClassDatumAnalysis classDatumAnalysis = castTarget.getClassDatumAnalysis();
		if (classDatumAnalysis.getCompleteClass().getPrimaryClass() instanceof DataType) {
			Iterable<@NonNull NavigableEdge> realizedEdges = rootScheduledRegion.getRealizedEdges(predicatedEdge, classDatumAnalysis);
			if (realizedEdges != null) {
				List<@NonNull Node> sourceNodes = new ArrayList<>();
				for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
					if (RegionUtil.isElementallyConformantSource(realizedEdge, predicatedEdge) && RegionUtil.isConformantTarget(realizedEdge, predicatedEdge)) {
						sourceNodes.add(realizedEdge.getTarget());
					}
				}
				NodeConnection nodeConnection = invokingRegion2.getAttributeConnection(sourceNodes, predicatedEdge.getSource().getCompleteClass(), predicatedProperty, classDatumAnalysis);
				nodeConnection.addUsedTargetNode(castTarget, false);
				if (QVTp2QVTs.CONNECTION_CREATION.isActive()) {
					QVTp2QVTs.CONNECTION_CREATION.println("  Attribute NodeConnection \"" + nodeConnection + "\" to " + castTarget);
					//					Scheduler.CONNECTIONS.println("    classDatumAnalysis " + classDatumAnalysis);
					//					for (@NonNull Node sourceNode : sourceNodes) {
					//						Scheduler.CONNECTIONS.println("    from " + sourceNode.getRegion());
					//						Scheduler.CONNECTIONS.println("       " + sourceNode);
					//					}
					//					for (@NonNull NavigationEdge realizedEdge : realizedEdges) {
					//						Scheduler.CONNECTIONS.println("    edge " + realizedEdge);
					//					}
				}
			}
		}
		else {
			Iterable<@NonNull Node> sourceNodes = rootScheduledRegion.getIntroducingOrProducingNodes(classDatumAnalysis);
			//			if (sourceNodes != null) {
			Iterable<@NonNull NavigableEdge> realizedEdges = rootScheduledRegion.getRealizedEdges(predicatedEdge, classDatumAnalysis);
			if (realizedEdges != null) {
				Set<@NonNull Region> edgeSourceRegions = new HashSet<>();
				Set<@NonNull Region> nodeSourceRegions = new HashSet<>();
				for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
					edgeSourceRegions.add(realizedEdge.getRegion());
				}
				if (sourceNodes != null) {
					for (@NonNull Node sourceNode : sourceNodes) {
						nodeSourceRegions.add(sourceNode.getRegion());
					}
				}
				//
				// Create an EdgeConnection for the edge realizations unless all edges are sources by node sources.
				//
				if (!nodeSourceRegions.containsAll(edgeSourceRegions)) {	// If edges are assigned independently of their targets.
					Set<@NonNull Region> conformantEdgeSourceRegions = null;
					List<@NonNull NavigableEdge> thoseEdges = null;
					for (@NonNull NavigableEdge realizedEdge : realizedEdges) {
						if (RegionUtil.isElementallyConformantSource(realizedEdge, predicatedEdge) && RegionUtil.isConformantTarget(realizedEdge, predicatedEdge)) {
							if (thoseEdges == null) {
								thoseEdges = new ArrayList<>();
								conformantEdgeSourceRegions = new HashSet<>();
							}
							if (!thoseEdges.contains(realizedEdge)) {
								thoseEdges.add(realizedEdge);
								assert conformantEdgeSourceRegions != null;
								conformantEdgeSourceRegions.add(realizedEdge.getRegion());
							}
						}
					}
					if ((thoseEdges != null) && !nodeSourceRegions.containsAll(conformantEdgeSourceRegions)) {
						EdgeConnection edgeConnection = invokingRegion2.getEdgeConnection(thoseEdges, predicatedProperty);
						if (QVTp2QVTs.CONNECTION_CREATION.isActive()) {
							QVTp2QVTs.CONNECTION_CREATION.println("  EdgeConnection \"" + edgeConnection + "\" to " + predicatedEdge);
						}
						if (!Iterables.contains(edgeConnection.getTargetEdges(), castEdge)) {
							edgeConnection.addUsedTargetEdge(castEdge, false);
							if (QVTp2QVTs.CONNECTION_CREATION.isActive()) {
								for (@NonNull NavigableEdge thatEdge : thoseEdges) {
									QVTp2QVTs.CONNECTION_CREATION.println("    from " + thatEdge.getRegion() + "  : " + thatEdge);
								}
							}
						}
					}
				}
			}
			//
			// Create a NodeConnection for the node realizations.
			//
			if ((sourceNodes != null)
					&& !castTarget.isLoaded()			// WIP and !isOnlyCast
					&& !castTarget.isConstant()
					&& !castTarget.isHead()
					&& !castTarget.isOperation()
					&& !castTarget.isTrue()
					&& (castTarget.getIncomingConnection() == null)
					//			 && !castTarget.isAttributeNode()
					//			 && !rootScheduledRegion.isOnlyCastOrRecursed(predicatedNode)
					//			 && !hasEdgeConnection(predicatedNode)
					) {
				NodeConnection predicatedConnection = invokingRegion2.getNodeConnection(sourceNodes, classDatumAnalysis);
				predicatedConnection.addUsedTargetNode(castTarget, false);
				if (QVTp2QVTs.CONNECTION_CREATION.isActive()) {
					QVTp2QVTs.CONNECTION_CREATION.println("  NodeConnection \"" + predicatedConnection + "\" to " + castTarget);
					for (@NonNull Node sourceNode : sourceNodes) {
						QVTp2QVTs.CONNECTION_CREATION.println("    from " + sourceNode.getRegion() + " : " + sourceNode);
					}
				}
			}
			//			}
		}
	}

	@Override
	public @NonNull RegionProblem createError(@NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.ERROR, this, boundMessage);
	}

	/**
	 * Create and return a NodeConnection to the nodes that can provide the sources for headNode.
	 * Returns null if the pattern surrounding the headNode conflicts with the pattern
	 * surrounding all possible sources.
	 */
	private @Nullable NodeConnection createHeadConnection(@NonNull Node headNode) {
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		ClassDatumAnalysis classDatumAnalysis = headNode.getClassDatumAnalysis();
		List<@NonNull Node> headSources = null;
		//
		//	Locate compatible introducers and non-recursive producers
		//
		Iterable<@NonNull Node> sourceNodes = rootScheduledRegion.getIntroducingOrProducingNodes(headNode);
		if (sourceNodes != null) {
			for (@NonNull Node sourceNode : sourceNodes) {
				Region sourceRegion = sourceNode.getRegion();
				if (sourceRegion != this) {
					Map<@NonNull Node, @NonNull Node> called2calling = new HashMap<>();
					if (isCompatiblePattern(headNode, sourceNode, called2calling)) {
						if (headSources == null) {
							headSources = new ArrayList<>();
						}
						headSources.add(sourceNode);
					}
				}
			}
		}
		if (headSources == null) {
			return null;
		}
		//
		//	Connect up the head
		//
		NodeConnection headConnection = invokingRegion2.getNodeConnection(headSources, classDatumAnalysis);
		if (headNode.isDependency()) {
			headConnection.addUsedTargetNode(headNode, false);
		}
		else {
			headConnection.addPassedTargetNode(headNode);
		}
		if (QVTp2QVTs.CONNECTION_CREATION.isActive()) {
			QVTp2QVTs.CONNECTION_CREATION.println((headNode.isDependency() ? "  Extra NodeConnection " : "  Head NodeConnection \"") + headConnection + "\" to " + headNode);
			for (@NonNull Node sourceNode : headSources) {
				QVTp2QVTs.CONNECTION_CREATION.println("    from " + sourceNode.getRegion() + " : " + sourceNode);
			}
		}
		return headConnection;
	}

	/**
	 * Return the Connections to each of the head nodes. Returns null if the pattern surrounding any headNode conflicts with the pattern
	 * surrounding all its possible sources. (Any head with no sources is a non-invocation.)
	 */
	private @Nullable Iterable<@NonNull NodeConnection> createHeadConnections() {
		List<@NonNull NodeConnection> headConnections = null;
		for (@NonNull Node headNode : getHeadNodes()) {
			if (headNode.isTrue()) { /* true nodes do not need connections. */ }
			else if (headNode.isDependency()) {
				createHeadConnection(headNode);	/** Dependency nodes have extra not-head connections. */
			}
			else {
				NodeConnection headConnection = createHeadConnection(headNode);
				if (headConnection == null) {
					multiRegion.getSchedulerConstants().addProblem(createError("createHeadConnections abandoned for " + headNode));
					headConnection = createHeadConnection(headNode);	// FIXME debugging
					return null;										//  so matching only fails for unmatchable real heads
				}
				else {
					if (headConnections == null) {
						headConnections = new ArrayList<>();
					}
					headConnections.add(headConnection);
				}
				// FIXME. If there are multiple heads and an internal node is reachable from more than one head, then the possible
				// sources for the internal node are the intersection of the alternatives which may eliminate some call paths.
			}
		}
		return headConnections;
	}

	/**
	 * Create the connections that establish the inter-region dependencies.
	 *
	 * Every node/edge must have a connection to all its possible sources to ensure that the compile-time / run-time
	 * scheduler delays the execution of this region until the sources are available.
	 *
	 * Connections may be omitted when we can prove that the connection is available as a consequence of some restriction.
	 * - a connection to a CONSTANT source is unnecessary (always available)
	 * - a connection to a LOADED source is unnecessary (always available)
	 * - a connection to a source whose navigation path is incompatible with the head-to-target path is unnecessary
	 * - a connection to a node that is only used in cast form is unnecessary (the cast node provides more precision)
	 * - a connection to a cast edge is unnecessary (the cast edge extends a navigation edge that has a connection)
	 *
	 * Connections to attribute nodes are connected to just the node; a 'duplicate' edge connection is unnecessary
	 *
	 * Connections to realized nodes can be omitted if they are at one end of a realized edge
	 *
	 * Connections to edges account for type conformance of the nodes ends. The edge ends extend to account for casts.
	 *
	 * Each head node has a passed connection from its sources.
	 * Consistently related nodes navigable from the head have a bindable connection to the correspondingly related sources.
	 * Inconsistently related nodes navigable from the head have a computable connection to all compatibly typed sources.
	 * Unrelated nodes such as the internals of computations are not connected; their dependencies should be in dependency heads.
	 * Edges dependent on realization elsewhere are represented by connection from all head nodes of the dependent region
	 * to all heads of the realizing region.
	 */
	@Override
	public void createIncomingConnections() {
		if (QVTp2QVTs.CONNECTION_CREATION.isActive()) {
			QVTp2QVTs.CONNECTION_CREATION.println("connecting " + this);
		}
		assert !(this instanceof RootCompositionRegion);
		Iterable<@NonNull NodeConnection> headConnections = createHeadConnections();
		if (headConnections != null) {
			for (@NonNull NavigableEdge predicatedEdge : getPredicatedNavigationEdges()) {
				if (!predicatedEdge.isCast()) {
					createEdgeConnection(predicatedEdge);
				}
			}
		}
	}

	/**
	 * Create a NodeConnection to the realized node for each node, unless there is already an EdgeConnection for any edge to/from the node.
	 *
	private void createNodeConnections() {
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		for (@NonNull Node predicatedNode : getPredicatedNodes()) {
			if (!predicatedNode.isLoaded()			// WIP and !isOnlyCast
			 && !predicatedNode.isConstant()
			 && !predicatedNode.isHead()
			 && !predicatedNode.isOperation()
			 && !predicatedNode.isTrue()
			 && (predicatedNode.getIncomingConnection() == null)
			 && !predicatedNode.isAttributeNode()
			 && !rootScheduledRegion.isOnlyCastOrRecursed(predicatedNode)
			 && !hasEdgeConnection(predicatedNode)) {
				ClassDatumAnalysis classDatumAnalysis = predicatedNode.getClassDatumAnalysis();
				Iterable<@NonNull Node> sourceNodes = rootScheduledRegion.getIntroducingOrProducingNodes(classDatumAnalysis);
				if (sourceNodes != null) {
					NodeConnection predicatedConnection = invokingRegion2.getNodeConnection(sourceNodes, classDatumAnalysis);
					predicatedConnection.addUsedTargetNode(predicatedNode, false);
					if (Scheduler.CONNECTIONS.isActive()) {
						Scheduler.CONNECTIONS.println("  NodeConnection from " + predicatedNode);
					}
				}
			}
		}
	} */

	/**
	 * Create a NodeConnection to the realized node for each node in the pattern related to a head node.
	 *
	private void createRelatedConnections(@NonNull NodeConnection headConnection) {
		@NonNull Iterable<@NonNull Node> headSources = headConnection.getSources();
		/**
	 * Each bindable node is navigable within the guard/predicate from the head and has an equivalent node in every possible caller.
	 * A bindable node may therefore by passed by value from each of a known set of calling nodes to each called node.
	 * /
		Map<@NonNull NavigationEdge, @NonNull List<@NonNull NavigationEdge>> related2bindableSources = new HashMap<>();
		/**
	 * Each computable node is navigable within the guard/predicate from the head but does not have an equivalent node in every possible caller.
	 * A computable node cannot always be passed by value. It is therefore recomputed within a known set of calling regions at each called node.
	 * /
		Map<@NonNull Node, @NonNull List<@NonNull Region>> related2computableSources = new HashMap<>();
		ScheduledRegion invokingRegion2 = invokingRegion;
		assert invokingRegion2 != null;
		RootScheduledRegion rootScheduledRegion = invokingRegion2.getRootScheduledRegion();
		//
		//	Categorize the corresponding sources for each related node as uniformly bindable else re-computable.
		//
		for (@NonNull Node headSource : headSources) {
			Region sourceRegion = headSource.getRegion();
			assert this != sourceRegion;
			for (@NonNull Node headNode : headConnection.getTargets()) {
				if ((headNode.getRegion() == this) && headNode.isHead()) {
					Map<@NonNull Node, @Nullable Node> calledNode2callingNode = new HashMap<>();
					Map<@NonNull NavigationEdge, @Nullable NavigationEdge> calledEdge2callingEdge = new HashMap<>();
					computeCompatiblePattern(headNode, headSource, calledNode2callingNode, calledEdge2callingEdge);
					for (Map./*@NonNull* /Entry<@NonNull NavigationEdge, @Nullable NavigationEdge> entry : calledEdge2callingEdge.entrySet()) {
						@NonNull NavigationEdge calledEdge = entry.getKey();
						@NonNull Node calledNode = calledEdge.getTarget();
						assert calledNode.isHead() == (calledNode == headNode);		// FIXME validating more efficient test
						if (!calledNode.isHead()
						 && !calledNode.isLoaded()
						 && !calledNode.isConstant()
						 && !rootScheduledRegion.isOnlyCastOrRecursed(calledNode)) {
							@Nullable NavigationEdge callingEdge = entry.getValue();
							if ((callingEdge != null) && !related2computableSources.containsKey(calledNode)) {
								List<@NonNull NavigationEdge> bindableSources = related2bindableSources.get(calledEdge);
								if (bindableSources == null) {
									bindableSources = new ArrayList<>();
									related2bindableSources.put(calledEdge, bindableSources);
								}
								assert !bindableSources.contains(callingEdge);
								bindableSources.add(callingEdge);
							}
							else {
								List<@NonNull Region> computableSources = related2computableSources.get(calledNode);
								if (computableSources == null) {
									computableSources = new ArrayList<>();
									related2computableSources.put(calledNode, computableSources);
								}
								assert !computableSources.contains(sourceRegion);
								computableSources.add(sourceRegion);
								if (related2bindableSources.containsKey(calledEdge)) {
									List<@NonNull NavigationEdge> bindableSources = related2bindableSources.remove(calledEdge);
									assert bindableSources != null;
									for (@NonNull NavigationEdge bindableSource : bindableSources) {
										Region bindableRegion = bindableSource.getRegion();
										assert !computableSources.contains(sourceRegion);
										computableSources.add(bindableRegion);
									}
								}
							}
						}
					}
				}
			}
		}
		assert Sets.intersection(related2bindableSources.keySet(), related2computableSources.keySet()).isEmpty();
		//
		//	Connect the uniformly bindable calling sources to their called nodes.
		//
		for (Map./*@NonNull* /Entry<@NonNull NavigationEdge, @NonNull List<@NonNull NavigationEdge>> entry : related2bindableSources.entrySet()) {
			@NonNull NavigationEdge calledEdge = entry.getKey();
			@NonNull Node calledNode = calledEdge.getTarget();
			assert !calledNode.isLoaded() && !calledNode.isConstant();
			@NonNull List<@NonNull NavigationEdge> bindableEdges = entry.getValue();
			EdgeConnection bindableConnection = invokingRegion2.getEdgeConnection(bindableEdges, calledEdge.getProperty());
			bindableConnection.addUsedTargetEdge(calledEdge, false);
			if (Scheduler.CONNECTIONS.isActive()) {
				Scheduler.CONNECTIONS.println("  Bindable EdgeConnection to " + calledEdge);
			}
		}
		//
		//	Connect the introducing/producing nodes of the not uniformly bindable calling sources to their called nodes.
		//
		for (Map./*@NonNull* /Entry<@NonNull Node, @NonNull List<@NonNull Region>> entry : related2computableSources.entrySet()) {
			@NonNull Node calledNode = entry.getKey();
			assert !calledNode.isLoaded() && !calledNode.isConstant() && !rootScheduledRegion.isOnlyCastOrRecursed(calledNode);
			ClassDatumAnalysis classDatumAnalysis = calledNode.getClassDatumAnalysis();
			Iterable<@NonNull Node> introducingOrProducingNodes = rootScheduledRegion.getIntroducingOrProducingNodes(classDatumAnalysis);
			if (introducingOrProducingNodes != null) {
				@NonNull List<@NonNull Region> computableRegions = entry.getValue();
				List<@NonNull Node> computableSourceNodes = null;
				assert calledNode.getRegion() == this;		// FIXME just checking simpler test
				for (@NonNull Node computableSourceNode : introducingOrProducingNodes) {
					Region sourceRegion = computableSourceNode.getRegion();
					if ((computableSourceNode.getRegion() != this) && !computableRegions.contains(sourceRegion)) {		// FIXME only if a Recursion Edge
						if (computableSourceNodes == null) {
							computableSourceNodes = new ArrayList<>();
						}
						computableSourceNodes.add(computableSourceNode);
					}
				}
				if (computableSourceNodes != null) {
					NodeConnection computableConnection = invokingRegion2.getNodeConnection(computableSourceNodes, classDatumAnalysis);
					computableConnection.addUsedTargetNode(calledNode, false);
					if (Scheduler.CONNECTIONS.isActive()) {
						Scheduler.CONNECTIONS.println("  Computable NodeConnection to " + calledNode);
					}
				}
			}
		}
	} */

	@Override
	public @NonNull RegionProblem createWarning(@NonNull String messageTemplate, Object... bindings) {
		String boundMessage = StringUtil.bind(messageTemplate, bindings);
		return new RegionProblem(CompilerProblem.Severity.WARNING, this, boundMessage);
	}

	protected @Nullable Map<@NonNull Node, @NonNull Node> expandRecursion(@NonNull Node nextNode, @NonNull Node prevNode, @NonNull Map<@NonNull Node, @NonNull Node> bindings) {
		Node oldPrevNode = bindings.put(nextNode, prevNode);
		if (oldPrevNode != null) {
			assert oldPrevNode == prevNode;
			return bindings;
		}
		for (@NonNull NavigableEdge navigationEdge : prevNode.getNavigationEdges()) {
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
	public @NonNull Iterable<@NonNull Node> getAncestorsOf(@NonNull Node node) {
		List<@NonNull Node> ancestors = new ArrayList<>();
		HashSet<@NonNull Node> ancestorSet = new HashSet<>();
		node.getAllAncestors(ancestorSet);
		for (@NonNull Node ancestor : ancestorSet) {
			if (ancestor.getRegion() == this) {
				ancestors.add(ancestor);
			}
		}
		return ancestors;
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getAssignedNodes() {
		return Iterables.filter(nodes, IsAssignedNodePredicate.INSTANCE);
	}

	public final @NonNull Iterable<@NonNull NavigableEdge> getAssignmentEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(edges, IsAssignmentEdgePredicate.INSTANCE);
		return filter;
	}

	protected @Nullable List<@NonNull NavigableEdge> getBestPath(@Nullable List<@NonNull NavigableEdge> bestPath, @Nullable List<@NonNull NavigableEdge> candidatePath) {
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

	private @NonNull NavigableEdge getBestEdge(@Nullable NavigableEdge bestEdge, @NonNull NavigableEdge candidateEdge) {
		if (bestEdge == null) {
			return candidateEdge;
		}
		if ((bestEdge.getProperty().isIsImplicit() && !candidateEdge.getProperty().isIsImplicit())) {
			return candidateEdge;
		}
		return bestEdge;		// ??? containment
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getCallableChildren() {
		return callableChildren;
	}

	@Override
	public @NonNull Iterable<@NonNull Region> getCallableParents() {
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
	public @NonNull List<@NonNull Region> getCalledRegions() {
		List<@NonNull Region> childRegions = new ArrayList<>();			// FIXME cache
		for (@NonNull NodeConnection childConnection : getOutgoingPassedConnections()) {
			for (@NonNull Node childNode : childConnection.getTargetNodes()) {
				Region childRegion = childNode.getRegion();
				if (!childRegions.contains(childRegion)) {
					childRegions.add(childRegion);
				}
			}
		}
		return childRegions;
	}

	@Override
	public @NonNull List<@NonNull Region> getCallingRegions() {
		List<@NonNull Region> callingRegions = new ArrayList<>();			// FIXME cache
		for (@NonNull NodeConnection callingConnection : getIncomingPassedConnections()) {
			for (@NonNull Node callingNode : callingConnection.getSources()) {
				Region callingRegion = callingNode.getRegion();
				if (!callingRegions.contains(callingRegion)) {
					callingRegions.add(callingRegion);
				}
			}
		}
		return callingRegions;
	}

	@Override
	public @Nullable Set<@NonNull NavigableEdge> getCheckedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2checkedEdges != null;
		return typedModel2checkedEdges.get(typedModel);
	}

	@Override
	public @NonNull ClassDatumAnalysis getClassDatumAnalysis(@NonNull TypedElement typedElement) {
		return getSchedulerConstants().getClassDatumAnalysis(typedElement);
	}

	@Override
	public @NonNull String getColor() {
		return "blue";
	}

	private @NonNull Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> getCompleteClass2Node() {
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2node = new HashMap<>();
		for (@NonNull Node node : getNodes()) {
			CompleteClass completeClass = node.getCompleteClass();
			List<@NonNull Node> mergedNodes = completeClass2node.get(completeClass);
			if (mergedNodes == null) {
				mergedNodes = new ArrayList<>();
				completeClass2node.put(completeClass, mergedNodes);
			}
			if (!mergedNodes.contains(node)) {
				mergedNodes.add(node);
			}
		}
		return completeClass2node;
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getComposedNodes() {
		return Iterables.filter(nodes, IsComposedNodePredicate.INSTANCE);
	}

	/*	public final @NonNull Iterable<@NonNull Node> getComputedNodes() {
		return Iterables.filter(nodes, IsComputedPredicate.INSTANCE);
	} */

	/*	public final @NonNull Iterable<? extends Edge> getConsumedOrderingEdges() {
		@SuppressWarnings("null")
		@NonNull Iterable<Edge> filter = Iterables.filter(edges, IsConsumedOrderingEdgePredicate.INSTANCE);
		return filter;
	} */

	private int getCost(@NonNull List<@NonNull NavigableEdge> path) {
		int cost = 0;
		for (@NonNull NavigableEdge edge : path) {
			if (edge.getProperty().isIsImplicit()) {
				cost++;
			}		// ??? containment
		}
		return cost;
	}

	/*	public int getEarliestPassedConnectionSourceIndex() {
		int earliestPassedConnectionSourceIndex = 0;
		for (@NonNull NodeConnection passedConnection : getIncomingPassedConnections()) {
			for (@NonNull Region sourceRegion : passedConnection.getSourceRegions()) {
				int firstPassedConnectionSourceIndex = sourceRegion.getIndexes().get(0);
				if (firstPassedConnectionSourceIndex > earliestPassedConnectionSourceIndex) { // Latest of multiple passed connections
					earliestPassedConnectionSourceIndex = firstPassedConnectionSourceIndex;
				}
			}
		}
		return earliestPassedConnectionSourceIndex;
	} */

	@Override
	public @NonNull Collection<@NonNull Edge> getEdges() {
		return edges;
	}

	@Override
	public @Nullable Set<@NonNull NavigableEdge> getEnforcedEdges(@NonNull TypedModel typedModel) {
		assert typedModel2enforcedEdges != null;
		return typedModel2enforcedEdges.get(typedModel);
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getExpressionEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(edges, IsExpressionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public int getFinalExecutionIndex() {
		assert indexes.size() > 0;
		return indexes.get(indexes.size()-1);
	}

	@Override
	public @NonNull Iterable<@NonNull DatumConnection> getIncomingConnections() {		// FIXME cache
		List<@NonNull DatumConnection> connections = new ArrayList<>();
		for (@NonNull Node headNode : getHeadNodes()) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if ((connection != null) && !connections.contains(connection)) {
				connections.add(connection);
			}
		}
		for (@NonNull Node node : getNodes()) {
			if (node.isDependency() || node.isPattern()) {
				if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
					NodeConnection connection = node.getIncomingUsedConnection();
					if ((connection != null) && !connections.contains(connection)) {
						connections.add(connection);
					}
				}
			}
		}
		for (@NonNull NavigableEdge edge : getPredicatedNavigationEdges()) {
			EdgeConnection connection = edge.getIncomingConnection();
			if ((connection != null) && !connections.contains(connection)) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getIncomingPassedConnections() {		// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node headNode : getHeadNodes()) {
			NodeConnection connection = headNode.getIncomingPassedConnection();
			if (connection != null) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getIncomingUsedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : getPatternNodes()) {
			if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
				NodeConnection connection = node.getIncomingUsedConnection();
				if (connection != null) {
					connections.add(connection);
				}
			}
		}
		return connections;
	}

	@Override
	public @NonNull String getIndexRangeText() {
		return getInvocationIndex() + ".." + getFinalExecutionIndex();
	}

	public @Nullable String getIndexText() {
		StringBuilder s = null;
		for (@NonNull Integer index : indexes) {
			if (s == null) {
				s = new StringBuilder();
			}
			else {
				s.append(",");
			}
			s.append(index.toString());
		}
		return s != null ? s.toString() : null;
	}

	@Override
	public @NonNull List<@NonNull Integer> getIndexes() {
		return indexes;
	}

	@Override
	public @NonNull List<@NonNull NodeConnection> getIntermediateConnections() {
		return intermediateConnections;
	}

	@Override
	public int getInvocationIndex() {
		assert indexes.size() > 0;
		return indexes.get(0);
	}

	@Override
	public @Nullable ScheduledRegion getInvokingRegion() {
		return invokingRegion;
	}

	@Override
	public @NonNull List<@NonNull DatumConnection> getLoopingConnections() {
		List<@NonNull DatumConnection> loopingConnections = new ArrayList<>();
		for (@NonNull DatumConnection connection : getOutgoingConnections()) {
			for (@NonNull Region sourceRegion : connection.getSourceRegions()) {
				if (this == sourceRegion) {
					for (@NonNull Region targetRegion : connection.getTargetRegions()) {
						if ((this == targetRegion) && !loopingConnections.contains(connection)) {
							loopingConnections.add(connection);
						}
					}
				}
			}
		}
		return loopingConnections;
	}

	@Override
	public @NonNull MultiRegion getMultiRegion() {
		return multiRegion;
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getNavigableNodes() {
		return Iterables.filter(nodes, IsNavigableNodePredicate.INSTANCE);
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getNavigationEdges() {
		@NonNull Iterable<@NonNull NavigableEdge> filter = Iterables.filter(edges, NavigableEdge.class);
		return filter;
	}

	//	@Override
	//	public @Nullable Node getNavigationTarget(@NonNull ClassNode sourceNode, @NonNull Property source2targetProperty) {
	//		NavigationEdge navigationEdge = getNavigationEdge(sourceNode, source2targetProperty);
	//		return navigationEdge !=  null ? navigationEdge.getTarget() : null;
	//	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getNewNodes() {
		return Iterables.filter(nodes, IsNewNodePredicate.INSTANCE);
	}

	@Override
	public @NonNull Collection<@NonNull Node> getNodes() {
		return nodes;
	}

	@Override
	public @NonNull Iterable<@NonNull DatumConnection> getNextConnections() {
		return getOutgoingConnections();
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getOldNodes() {
		return Iterables.filter(nodes, IsOldNodePredicate.INSTANCE);
	}

	@Override
	public @NonNull List<@NonNull DatumConnection> getOutgoingConnections() {			// FIXME cache
		List<@NonNull DatumConnection> connections = new ArrayList<>();
		for (@NonNull Node node : getNodes()) {
			for (@NonNull NodeConnection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
			for (@NonNull NodeConnection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		for (@NonNull NavigableEdge edge : getNavigationEdges()) {
			for (@NonNull EdgeConnection connection : edge.getOutgoingConnections()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getOutgoingPassedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : getNodes()) {
			for (@NonNull NodeConnection connection : node.getOutgoingPassedConnections()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	@Override
	public @NonNull Iterable<@NonNull NodeConnection> getOutgoingUsedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> connections = new ArrayList<>();
		for (@NonNull Node node : getNodes()) {
			for (@NonNull NodeConnection connection : node.getOutgoingUsedBindingEdges()) {
				connections.add(connection);
			}
		}
		return connections;
	}

	protected @Nullable List<@NonNull NavigableEdge> getPath(@NonNull Node sourceNode, @NonNull Node targetNode, @NonNull Set<@NonNull Edge> usedEdges) {
		assert sourceNode.getRegion() == targetNode.getRegion();
		NavigableEdge bestEdge = null;
		List<@NonNull NavigableEdge> bestPath = null;
		for (@NonNull NavigableEdge edge : sourceNode.getNavigationEdges()) {
			if (!usedEdges.contains(edge) && !edge.getProperty().isIsMany() && !edge.isRealized()) {
				if (edge.getTarget() == targetNode) {
					bestEdge = getBestEdge(bestEdge, edge);
				}
				else {
					Set<@NonNull Edge> moreUsedEdges = new HashSet<>(usedEdges);
					moreUsedEdges.add(edge);
					List<@NonNull NavigableEdge> tailPath = getPath(edge.getTarget(), targetNode, moreUsedEdges);
					if (tailPath != null) {
						tailPath = new ArrayList<>(tailPath);
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

	@Override
	public final @NonNull Iterable<@NonNull Node> getPatternNodes() {
		return Iterables.filter(nodes, IsPatternNodePredicate.INSTANCE);
	}

	public final @NonNull Iterable<NavigableEdge> getPredicateEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(edges, IsPredicatedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getPredicatedNavigationEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(edges, IsPredicatedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getRealizedEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(edges, IsRealizedEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull NavigableEdge> getRealizedNavigationEdges() {
		@SuppressWarnings("unchecked")
		@NonNull Iterable<@NonNull NavigableEdge> filter = (Iterable<@NonNull NavigableEdge>)(Object)Iterables.filter(edges, IsRealizedNavigationEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public final @NonNull Iterable<@NonNull Edge> getRecursionEdges() {
		@NonNull Iterable<@NonNull Edge> filter = Iterables.filter(edges, IsRecursionEdgePredicate.INSTANCE);
		return filter;
	}

	@Override
	public @NonNull List<@NonNull NodeConnection> getRootConnections() {
		return rootConnections;
	}

	@Override
	public @NonNull SchedulerConstants getSchedulerConstants() {
		return multiRegion.getSchedulerConstants();
	}

	@Override
	public @Nullable String getShape() {
		return null;
	}

	protected @NonNull StandardLibraryHelper getStandardLibraryHelper() {
		return getSchedulerConstants().getStandardLibraryHelper();
	}

	@Override
	public @Nullable String getStyle() {
		return null;
	}

	@Override
	public final @NonNull String getSymbolName() {
		String symbolName2 = symbolName;
		if (symbolName2 == null) {
			symbolName = symbolName2 = getSchedulerConstants().reserveSymbolName(computeSymbolName(), this);
		}
		return symbolName2;
	}

	@Override
	public final @NonNull Iterable<@NonNull Node> getTrueNodes() {
		return Iterables.filter(nodes, IsTrueNodePredicate.INSTANCE);
	}

	@Override
	public @NonNull List<@NonNull NodeConnection> getUsedConnections() {			// FIXME cache
		List<@NonNull NodeConnection> usedConnections = new ArrayList<>();
		for (@NonNull Node node : getPatternNodes()) {
			if (node.isLoaded() || node.isSpeculated() || node.isPredicated()) {	// A DataType may be loaded but subject to an edge predication
				NodeConnection connection = node.getIncomingUsedConnection();
				if (connection != null) {
					usedConnections.add(connection);
				}
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

	/*	private boolean hasEdgeConnection(@NonNull Node predicatedNode) {
		for (@NonNull Edge edge : predicatedNode.getIncomingEdges()) {
			if ((edge instanceof NavigationEdge) && (((NavigationEdge) edge).getIncomingConnection() != null)) {
				return true;
			}
		}
		for (@NonNull Edge edge : predicatedNode.getOutgoingEdges()) {
			if ((edge instanceof NavigationEdge) && (((NavigationEdge) edge).getIncomingConnection() != null)) {
				return true;
			}
		}
		return false;
	} */

	/**
	 * Return true if the predicates of calledNode are not in conflict with the navigable paths from callingNode.
	 * called2calling identifies already identified conflict free pairs that do not need re-assessment.
	 */
	private boolean isCompatiblePattern(@NonNull Node calledNode, @NonNull Node callingNode, @NonNull Map<@NonNull Node, @NonNull Node> called2calling) {
		Node oldPrevNode = called2calling.put(calledNode, callingNode);
		if (oldPrevNode != null) {
			return oldPrevNode == callingNode;
		}
		for (@NonNull NavigableEdge calledEdge : calledNode.getNavigationEdges()) {
			Node nextCalledNode = calledEdge.getTarget();
			if (!nextCalledNode.isRealized() && !nextCalledNode.isDataType()) {  // FIXME why exclude AttributeNodes?
				Edge nextCallingEdge = callingNode.getNavigationEdge(calledEdge.getProperty());
				if (nextCallingEdge != null) {
					Node nextCallingNode = nextCallingEdge.getTarget();
					if ((nextCallingNode.isExplicitNull() != nextCalledNode.isExplicitNull())) {
						return false;
					}
					if (!isCompatiblePattern(nextCalledNode, nextCallingNode, called2calling)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean isChildCompositionRegion() {
		return false;
	}

	@Override
	public boolean isCyclicScheduledRegion() {
		return false;
	}

	/**
	 * Return true if the operation nodes for primaryNode and secondaryNode are equivalent
	 * assigning equivalences to equivalentNodes.
	 */
	private boolean isEquivalent(@NonNull Node primaryNode, @NonNull Node secondaryNode, @NonNull Map<@NonNull Node, @NonNull Node> primary2secondary) {
		Node node = primary2secondary.get(primaryNode);
		if (node != null) {
			return node == secondaryNode;
		}
		if (primaryNode.getNodeRole() != secondaryNode.getNodeRole()) {
			return false;
		}
		if (!ClassUtil.safeEquals(primaryNode.getName(), secondaryNode.getName())) {		// FIXME stronger e.g. referredOperation
			return false;
		}
		HashMap<@NonNull Node, @NonNull Node> nestedPrimary2secondary = new HashMap<>(primary2secondary);
		nestedPrimary2secondary.put(primaryNode, secondaryNode);
		for (@NonNull Edge primaryEdge : primaryNode.getArgumentEdges()) {
			boolean gotIt = false;
			for (@NonNull Edge secondaryEdge : secondaryNode.getArgumentEdges()) {
				if (ClassUtil.safeEquals(primaryEdge.getName(), secondaryEdge.getName())) {
					if (!isEquivalent(primaryEdge.getSource(), secondaryEdge.getSource(), nestedPrimary2secondary)) {
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
		primary2secondary.putAll(nestedPrimary2secondary);
		return true;
	}

	@Override
	public boolean isOperationRegion() {
		return false;
	}

	@Override
	public boolean isRootCompositionRegion() {
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
		/*		List<Node> predicatedNodes = new ArrayList<>();
		Iterables.addAll(predicatedNodes, getPredicatedNodes());
		for (Node calledNode : predicatedNodes) {
			if (calledNode.isHead() && !calledNode.isAttributeNode()) {
//					for (@SuppressWarnings("null")@NonNull List<Node> headGroup : calledRegion.getHeadNodeGroups()) {
//						for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
						List<Node> resolvedCallingSources = new ArrayList<>();
						boolean prunedOne = false;
						for (@SuppressWarnings("null")@NonNull Node callingSource : calledNode.getPassedBindingSources()) {
							if (canExpandRecursion(callingSource, calledNode, new HashMap<>())) {
								resolvedCallingSources.add(callingSource);
							}
							else {
								prunedOne = true;
							}
						}
						if (prunedOne) {
							List<Edge> deadEdges = new ArrayList<>();
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
						bestPath = getBestPath(bestPath, getPath(headNode, calledNode, new HashSet<>()));
					}
				}
				if (bestPath != null) {
					for (@SuppressWarnings("null")@NonNull List<Node> headGroup : getHeadNodeGroups()) {
						for (@SuppressWarnings("null")@NonNull Node headNode : headGroup) {
							List<Node> resolvedCallingSources = new ArrayList<>();
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
								List<Edge> deadEdges = new ArrayList<>();
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
				List<Node> resolvedCallingSources = new ArrayList<>();
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
					List<Edge> deadEdges = new ArrayList<>();
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

	@Override
	public void resetHead(@NonNull Node headNode) {
		throw new UnsupportedOperationException("resetHead not supported for " + this);
	}

	public void resolveRecursion() {
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2node = getCompleteClass2Node();
		List<@NonNull Node> headNodes = getHeadNodes();
		if (headNodes.size() == 1) {			// FIXME multi-heads
			Node headNode = headNodes.get(0);
			List<@NonNull Node> nodeList = completeClass2node.get(headNode.getCompleteClass());
			assert nodeList != null;
			if (nodeList.size() > 1) {
				for (@NonNull Node node : nodeList) {
					if (node != headNode) {
						Map<@NonNull Node, @NonNull Node> bindings = expandRecursion(headNode, node, new HashMap<>());
						if (bindings != null) {
							//						this.recursiveBindings  = bindings;
							for (Map.@NonNull Entry<@NonNull Node, @NonNull Node> entry : bindings.entrySet()) {
								@NonNull Node prevNode = entry.getKey();
								@NonNull Node nextNode = entry.getValue();
								RegionUtil.createRecursionEdge(prevNode, nextNode, prevNode.isHead());
							}
							return;				// FIXME can we have more than one recursion ??
						}
					}
				}
			}
		}
	}

	/**
	 * Chose the headNode from a group of peer nodes that has the most non-implicit properties targeting its peers.
	 */
	protected @NonNull Node selectBestHeadNode(@NonNull List<@NonNull Node> headNodes) {
		int size = headNodes.size();
		assert size >= 1;
		if (size == 1) {
			return headNodes.get(0);
		}
		Node bestHeadNode = null;
		int bestNonImplicits = -1;
		List<@NonNull Node> sortedHeadNodes = new ArrayList<>(headNodes);
		Collections.sort(sortedHeadNodes, NameUtil.NAMEABLE_COMPARATOR);		// Stabilize order
		for (@NonNull Node thisHeadNode : sortedHeadNodes) {
			int nonImplicits = 0;
			for (@NonNull Node thatHeadNode : sortedHeadNodes) {
				for (@NonNull NavigableEdge edge : thisHeadNode.getNavigationEdges()) {
					if (edge.getTarget() == thatHeadNode) {
						Property property = edge.getProperty();
						if (!property.isIsImplicit()) {
							nonImplicits++;
							break;
						}
					}
				}
			}
			if (nonImplicits > bestNonImplicits) {
				bestHeadNode = thisHeadNode;
				bestNonImplicits = nonImplicits;
			}
		}
		assert bestHeadNode != null;
		return bestHeadNode;
	}

	private @Nullable Node selectMergedHeadNode(@NonNull Node headNode, @NonNull List<@NonNull Node> mergedNodes) {
		if (mergedNodes.size() == 1) {
			Node mergedNode = selectBestHeadNode(mergedNodes);
			if (mergedNode.isIterator()) {
				return null;
			}
			return mergedNode;
		}
		if (mergedNodes.size() == 0) {
			return null;
		}
		Iterable<NavigableEdge> predicateEdges = headNode.getPredicateEdges();
		//		if (predicateEdges == null) {
		//			return null;
		//		}
		for (@NonNull Node mergedNode : mergedNodes) {
			boolean ok = !mergedNode.isIterator();
			if (ok) {
				for (@NonNull NavigableEdge predicateEdge : predicateEdges) {
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
	public void setInvokingRegion(@NonNull ScheduledRegion invokingRegion) {
		this.invokingRegion  = invokingRegion;
	}

	//	@Override
	//	public void setIsCyclic() {
	//		this.isCyclic  = true;
	//	}

	@Override
	public void toCallGraph(@NonNull GraphStringBuilder s) {
		s.appendNode(this);
		for (final @NonNull Region region : getCallableChildren()) {
			GraphEdge graphEdge = new GraphEdge()
			{
				@Override
				public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
					s.appendAttributedEdge(source, this, target);
				}

				@Override
				public @NonNull GraphNode getSource() {
					return AbstractRegion.this;
				}

				@Override
				public @NonNull GraphNode getTarget() {
					return region;
				}
			};
			s.appendEdge(graphEdge.getSource(), graphEdge, graphEdge.getTarget());
		}
		for (final @NonNull NodeConnection connection : getRootConnections())
		{
			GraphEdge graphEdge1 = new GraphEdge() {
				@Override
				public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
					s.appendAttributedEdge(source, this, target);
				}

				@Override
				public @NonNull GraphNode getSource() {
					return AbstractRegion.this;
				}

				@Override
				public @NonNull GraphNode getTarget() {
					return (AbstractConnection<?>)connection;
				}
			};
			s.appendEdge(graphEdge1.getSource(), graphEdge1, graphEdge1.getTarget());
			for (final @NonNull Node targetNode : connection.getTargetNodes())
			{
				GraphEdge graphEdge = new GraphEdge() {
					@Override
					public void appendEdgeAttributes(@NonNull GraphStringBuilder s, @NonNull GraphNode source, @NonNull GraphNode target) {
						s.appendAttributedEdge(source, this, target);
					}

					@Override
					public @NonNull GraphNode getSource() {
						return (AbstractConnection<?>)connection;
					}

					@Override
					public @NonNull GraphNode getTarget() {
						return targetNode.getRegion();
					}
				};
				s.appendEdge(graphEdge.getSource(), graphEdge, graphEdge.getTarget());
			}
		}
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setLabel(getName());
		s.pushCluster();
		for (@NonNull Node node : getNodes()) {
			node.toGraph(s);
			//			s.appendNode(node);
		}
		for (@NonNull Edge edge : getEdges()) {
			edge.toGraph(s);
			//			s.appendEdge(edge.getSource(), edge, edge.getTarget());
		}
		s.popCluster();
	}

	@Override
	public void toRegionGraph(@NonNull GraphStringBuilder s) {
		s.appendNode(this);
		for (@NonNull Edge edge : getRecursionEdges()) {
			s.appendEdge(edge.getSource().getRegion(), edge, edge.getTarget().getRegion());
		}
	}

	@Override
	public @NonNull String toString() {
		return symbolName != null ? (symbolName/* + " - " + getName()*/) : getName();
	}

	public void writeDebugGraphs(@Nullable String context) {
		SchedulerConstants scheduler = getSchedulerConstants();
		scheduler.writeDOTfile(this, context != null ? "-" + context : null);
		scheduler.writeGraphMLfile(this, context != null ? "-" + context : null);
	}
}