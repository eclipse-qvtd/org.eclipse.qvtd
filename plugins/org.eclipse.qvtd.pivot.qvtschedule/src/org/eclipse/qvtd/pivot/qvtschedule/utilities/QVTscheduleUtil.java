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
package org.eclipse.qvtd.pivot.qvtschedule.utilities;

import java.util.ArrayList;
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
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NodeRole;
import org.eclipse.qvtd.pivot.qvtschedule.Phase;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class QVTscheduleUtil extends QVTscheduleConstants
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
			return edge.getEdgeSource();
		}
	}

	public static final class EdgeTargetFunction implements Function<@NonNull Edge, @NonNull Node>
	{
		public static final @NonNull EdgeTargetFunction INSTANCE = new EdgeTargetFunction();

		@Override
		public @NonNull Node apply(@NonNull Edge edge) {
			return edge.getEdgeTarget();
		}
	}
	/**
	 * HeadComparator supports sorting a list of Head candidates into a most suitable first order.
	 */
	public static final class HeadComparator implements Comparator<@NonNull Node>
	{
		private final @NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure;
		private @Nullable Map<@NonNull Node, @NonNull Integer> node2implicity = null;

		public HeadComparator(@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> targetFromSourceClosure) {
			this.targetFromSourceClosure = targetFromSourceClosure;
		}

		@Override
		public int compare(@NonNull Node o1, @NonNull Node o2) {
			//
			//	Explicit head first
			//
			//			if (o1.isHead() != o2.isHead()) {
			//				return o1.isHead() ? -1 : 1;
			//			}
			//
			//	Speculated first
			//
			if (o1.isSpeculated() != o2.isSpeculated()) {
				return o1.isSpeculated() ? -1 : 1;
			}
			//
			//	Constant first - never happens
			//
			if (o1.isConstant() != o2.isConstant()) {
				return o1.isConstant() ? -1 : 1;
			}
			//
			//	Least reachable first
			//
			Set<@NonNull Node> set1 = targetFromSourceClosure.get(o1);
			Set<@NonNull Node> set2 = targetFromSourceClosure.get(o2);
			assert (set1 != null) && (set2 != null);
			int l1 = set1.size();
			int l2 = set2.size();
			int diff = l1 - l2;
			if (diff != 0) {
				return diff;
			}
			//
			//	Loaded first
			//
			if (o1.isLoaded() != o2.isLoaded()) {
				return o1.isLoaded() ? -1 : 1;
			}
			//
			//	Predicated first
			//
			if (o1.isPredicated() != o2.isPredicated()) {
				return o1.isPredicated() ? -1 : 1;
			}
			//
			//	Least implicit first (prefers middle to output)
			//
			int i1 = getImplicity(o1);
			int i2 = getImplicity(o2);
			diff = i1 - i2;
			if (diff != 0) {
				return diff;
			}
			//
			//	Alphabetical
			//
			String n1 = o1.getName();
			String n2 = o2.getName();
			return n1.compareTo(n2);
		}

		/**
		 * Return the number of outgoing implicit connection from node. A middle model node
		 * has no implicit connections and so is a better candodate for a head than an output
		 * model node which has implicit connections to the trace.
		 */
		private int getImplicity(@NonNull Node node) {
			Map<@NonNull Node, @NonNull Integer> node2implicity2 = node2implicity;
			if (node2implicity2 == null) {
				node2implicity = node2implicity2 = new HashMap<>();
			}
			Integer implicity = node2implicity2.get(node);
			if (implicity == null) {
				implicity = 0;
				for (@NonNull NavigableEdge e : node.getNavigationEdges()) {
					if (e.getProperty().isIsImplicit()) {
						implicity++;
					}
				}
				node2implicity2.put(node, implicity);
			}
			return implicity;
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
			return node.isNew();
		}
	}

	public static final class IsOldNodePredicate implements Predicate<@NonNull Node>
	{
		public static final @NonNull IsOldNodePredicate INSTANCE = new IsOldNodePredicate();

		@Override
		public boolean apply(@NonNull Node node) {
			return node.isOld();
		}
	}

	public static final class IsPassedBindingEdgePredicate implements Predicate<@NonNull NodeConnection>
	{
		public static final @NonNull IsPassedBindingEdgePredicate INSTANCE = new IsPassedBindingEdgePredicate();

		@Override
		public boolean apply(@NonNull NodeConnection connection) {
			return connection.isPassed();
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

	public static final class IsUsedBindingEdgePredicate implements Predicate<@NonNull NodeConnection>
	{
		public static final @NonNull IsUsedBindingEdgePredicate INSTANCE = new IsUsedBindingEdgePredicate();

		@Override
		public boolean apply(@NonNull NodeConnection connection) {
			return connection.isUsed();
		}
	}

	public static final class NodeComparator implements Comparator<@NonNull Node>
	{
		public static final @NonNull NodeComparator INSTANCE = new NodeComparator();

		@Override
		public int compare(@NonNull Node o1, @NonNull Node o2) {
			String n1 = NameUtil.getSafeName(o1);
			String n2 = NameUtil.getSafeName(o2);
			int diff = ClassUtil.safeCompareTo(n1, n2);
			if (diff != 0) {
				return diff;
			}
			n1 = o1.getCompleteClass().getPrimaryClass().toString();
			n2 = o2.getCompleteClass().getPrimaryClass().toString();
			diff = ClassUtil.safeCompareTo(n1, n2);
			if (diff != 0) {
				return diff;
			}
			return diff;
		}
	}

	public static @NonNull NodeRole asPhase(@NonNull NodeRole nodeRole, @NonNull Phase phase) {
		return getNodeRole(phase);
	}

	public static @NonNull NodeRole asPredicated(@NonNull NodeRole nodeRole) {
		return asPhase(nodeRole, Phase.PREDICATED);
	}

	public static @NonNull NodeRole asSpeculated(@NonNull NodeRole nodeRole) {
		return asPhase(nodeRole, Phase.SPECULATED);
	}

	public static @NonNull NodeRole asSpeculation(@NonNull NodeRole nodeRole) {
		return asPhase(nodeRole, Phase.SPECULATION);
	}

	/**
	 * Return the edge unless it is subject to a cast chain in which case return the final cast.
	 */
	public static @NonNull NavigableEdge getCastTarget(@NonNull NavigableEdge edge) {
		@NonNull NavigableEdge sourceEdge = edge;
		while (true) {
			@Nullable NavigableEdge targetEdge = null;
			for (@NonNull Edge nextEdge : sourceEdge.getEdgeTarget().getOutgoingEdges()) {
				if (nextEdge.isRecursion()) {
					continue;
				}
				if (!nextEdge.isCast()) {
					return sourceEdge;
				}
				if (targetEdge != null) {			// FIXME multi-cast support
					return sourceEdge;
				}
				targetEdge = (NavigableEdge) nextEdge;
			}
			if (targetEdge == null) {
				return sourceEdge;
			}
			sourceEdge = targetEdge;
		}
	}

	/**
	 * Return the node unless it is subject to a cast chain in which case return the final cast.
	 */
	public static @NonNull Node getCastTarget(@NonNull Node node) {
		@NonNull Node sourceNode = node;
		while (true) {
			@Nullable Node targetNode = null;
			for (@NonNull Edge edge : sourceNode.getOutgoingEdges()) {
				if (edge.isRecursion() || edge.isSecondary()) {
					continue;
				}
				if (!edge.isCast()) {
					return sourceNode;
				}
				if (targetNode != null) {			// FIXME multi-cast support
					return sourceNode;
				}
				targetNode = edge.getEdgeTarget();
			}
			if (targetNode == null) {
				return sourceNode;
			}
			sourceNode = targetNode;
		}
	}

	/**
	 * Return all nodes to which node is transitively cast or just node in the total absence of casts.
	 * If includeUsedIntermediates is set, cast edge inputs that are used by non-cast edges are also returned.
	 */
	public static @NonNull Iterable<@NonNull Node> getCastTargets(@NonNull Node node, boolean includeUsedIntermediates) {
		for (@NonNull Edge edge : node.getOutgoingEdges()) {
			if (edge.isRecursion() || edge.isSecondary()) {
				continue;
			}
			else if (edge.isCast()) {
				Set<@NonNull Node> castTargets = new HashSet<>();
				getCastTargets(node, includeUsedIntermediates, new HashSet<>(), castTargets);
				return castTargets;
			}
		}
		return Collections.singletonList(node);
	}

	private static void getCastTargets(@NonNull Node sourceNode, boolean includeUsedIntermediates, @NonNull Set<@NonNull Node> castSources, @NonNull Set<@NonNull Node> castTargets) {
		if (castSources.add(sourceNode)) {
			boolean hasCast = false;
			for (@NonNull Edge edge : sourceNode.getOutgoingEdges()) {
				if (edge.isRecursion() || edge.isSecondary()) {
					continue;
				}
				else if (edge.isCast()) {
					hasCast = true;
					getCastTargets(edge.getEdgeTarget(), includeUsedIntermediates, castSources, castTargets);
				}
				else if (includeUsedIntermediates) {
					castTargets.add(sourceNode);
				}
			}
			if (!hasCast) {
				castTargets.add(sourceNode);
			}
		}
	}

	public static @NonNull String getColor(@NonNull Role role) {
		switch (role.getPhase()) {
			case CONSTANT: return QVTscheduleConstants.CONSTANT_COLOR;
			case LOADED: return QVTscheduleConstants.LOADED_COLOR;
			case PREDICATED: return QVTscheduleConstants.PREDICATED_COLOR;
			case REALIZED: return QVTscheduleConstants.REALIZED_COLOR;
			case SPECULATION: return QVTscheduleConstants.SPECULATION_COLOR;
			case SPECULATED: return QVTscheduleConstants.SPECULATED_COLOR;
			default: return QVTscheduleConstants.OTHER_COLOR;
		}
	}

	public static @NonNull String getFillColor(@NonNull NodeRole nodeRole) {
		switch (nodeRole.getPhase()) {
			case CONSTANT: return LIGHT_CONSTANT_COLOR;
			case LOADED: return LIGHT_LOADED_COLOR;
			case PREDICATED: return LIGHT_PREDICATED_COLOR;
			case REALIZED: return LIGHT_REALIZED_COLOR;
			case SPECULATION: return LIGHT_SPECULATION_COLOR;
			case SPECULATED: return LIGHT_SPECULATED_COLOR;
			default: return LIGHT_OTHER_COLOR;
		}
	}

	public static @NonNull Phase getPhase(@NonNull Role role) {
		return ClassUtil.nonNullState(role.getPhase());
	}

	public static @NonNull Region getRegion(@NonNull ConnectionEnd connectionEnd) {
		return ClassUtil.nonNullState(connectionEnd.getRegion());
	}

	public static @NonNull Region getRegion(@NonNull Node node) {
		return ClassUtil.nonNullState(node.getRegion());
	}

	/**
	 * Return true if the target of thatEdge is compatible with the target of thisEdge.
	 */
	public static boolean isConformantTarget(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatTarget = getCastTarget(thatEdge.getEdgeTarget());
		Node thisTarget = getCastTarget(thisEdge.getEdgeTarget());
		CompleteClass thatType = thatTarget.getCompleteClass();
		CompleteClass thisType = thisTarget.getCompleteClass();
		if (thatType.conformsTo(thisType)) {
			return true;
		}
		if (thatTarget.isRealized()) {
			return false;
		}
		if (thisType.conformsTo(thatType)) {
			return true;
		}
		return false;
	}

	/**
	 * Return true if the elemental source type of thatEdge is compatible with the source type of thisEdge.
	 */
	public static boolean isElementallyConformantSource(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatSource = thatEdge.getEdgeSource();
		CompleteClass thatType = ClassUtil.nonNullState(thatSource.getClassDatumAnalysis().getElementalClassDatum().getCompleteClass());
		CompleteClass thisType = ClassUtil.nonNullState(thisEdge.getEdgeSource().getClassDatumAnalysis().getElementalClassDatum().getCompleteClass());
		if (thatType.conformsTo(thisType)) {
			return true;
		}
		if (thatSource.isRealized()) {
			return false;
		}
		if (thisType.conformsTo(thatType)) {
			return true;
		}
		return false;
	}

	public static <@NonNull R extends Role> R mergeToLessKnownPhase(R firstRole, R secondRole) {
		if (firstRole.isRealized()) {
			return firstRole;
		}
		else if (secondRole.isRealized()) {
			return secondRole;
		}
		else if (firstRole.isPredicated()){
			return firstRole;
		}
		else if (secondRole.isPredicated()){
			return secondRole;
		}
		else if (firstRole.isLoaded()) {
			return firstRole;
		}
		else if (secondRole.isLoaded()) {
			return secondRole;
		}
		else if (firstRole.isConstant()) {
			return firstRole;
		}
		else if (secondRole.isConstant()) {
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}

	public static <@NonNull R extends Role> R mergeToMoreKnownPhase(@NonNull R firstRole, @NonNull R secondRole) {
		if (firstRole.isConstant()) {
			return firstRole;
		}
		else if (secondRole.isConstant()) {
			return secondRole;
		}
		else if (firstRole.isLoaded()) {
			return firstRole;
		}
		else if (secondRole.isLoaded()) {
			return secondRole;
		}
		else if (firstRole.isRealized()) {
			return firstRole;
		}
		else if (secondRole.isRealized()) {
			return secondRole;
		}
		else if (firstRole.isSpeculated()) {
			return firstRole;
		}
		else if (secondRole.isSpeculated()) {
			return secondRole;
		}
		else if (firstRole.isSpeculation()) {
			return firstRole;
		}
		else if (secondRole.isSpeculation()) {
			return secondRole;
		}
		else if (firstRole.isPredicated()) {
			return firstRole;
		}
		else if (secondRole.isPredicated()) {
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}
}