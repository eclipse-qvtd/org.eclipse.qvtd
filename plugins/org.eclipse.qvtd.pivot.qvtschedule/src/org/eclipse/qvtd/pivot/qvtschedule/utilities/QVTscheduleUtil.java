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
import java.util.function.BinaryOperator;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtschedule.BasicMappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduledRegion;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

public class QVTscheduleUtil extends QVTscheduleConstants
{
	public static @NonNull BinaryOperator<@NonNull String> stringJoin(@NonNull String delimiter) {
		return (a, b) -> String.valueOf(a) + delimiter + String.valueOf(b);
	}

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
			return node == Role.REALIZED;
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

	public static final class MultiOppositeComparator implements Comparator<@NonNull Property>
	{
		public static final Comparator<@NonNull ? super Property> INSTANCE = new MultiOppositeComparator();

		@Override
		public int compare(@NonNull Property o1, @NonNull Property o2) {
			boolean c1 = o1.isIsComposite();
			boolean c2 = o1.isIsComposite();
			if (c1 != c2) {
				return Boolean.compare(c1, c2);
			}
			else {
				return ClassUtil.safeCompareTo(o1.getName(), o2.getName());
			}
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

	public static @NonNull Role asPhase(@NonNull Role nodeRole, @NonNull Role phase) {
		return phase;
	}

	public static @NonNull Role asPredicated(@NonNull Role nodeRole) {
		return asPhase(nodeRole, Role.PREDICATED);
	}

	public static @NonNull Role asSpeculated(@NonNull Role nodeRole) {
		return asPhase(nodeRole, Role.SPECULATED);
	}

	public static @NonNull Role asSpeculation(@NonNull Role nodeRole) {
		return asPhase(nodeRole, Role.SPECULATION);
	}

	public static boolean conformsToClassOrBehavioralClass(@NonNull CompleteClass firstType, @NonNull CompleteClass secondType) {
		return firstType.conformsTo(secondType) || firstType.conformsTo(secondType.getBehavioralClass());
	}

	/**
	 * Return the edge unless it is subject to a cast chain in which case return the final cast.
	 */
	public static @NonNull NavigableEdge getCastTarget(@NonNull NavigableEdge edge) {
		@NonNull NavigableEdge sourceEdge = edge;
		while (true) {
			@Nullable NavigableEdge targetEdge = null;
			for (@NonNull Edge nextEdge : getOutgoingEdges(sourceEdge.getEdgeTarget())) {
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
			for (@NonNull Edge edge : getOutgoingEdges(sourceNode)) {
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
		for (@NonNull Edge edge : getOutgoingEdges(node)) {
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
			for (@NonNull Edge edge : getOutgoingEdges(sourceNode)) {
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

	public static @NonNull ClassDatum getClassDatum(@NonNull Node node) {
		return ClassUtil.nonNullState(node.getClassDatum());
	}

	public static @NonNull ClassDatum getClassDatum(@NonNull NodeConnection connection) {
		return ClassUtil.nonNullState(connection.getClassDatum());
	}

	public static @NonNull String getColor(@NonNull Role role) {
		switch (role) {
			case CONSTANT: return QVTscheduleConstants.CONSTANT_COLOR;
			case LOADED: return QVTscheduleConstants.LOADED_COLOR;
			case PREDICATED: return QVTscheduleConstants.PREDICATED_COLOR;
			case REALIZED: return QVTscheduleConstants.REALIZED_COLOR;
			case SPECULATION: return QVTscheduleConstants.SPECULATION_COLOR;
			case SPECULATED: return QVTscheduleConstants.SPECULATED_COLOR;
			default: return QVTscheduleConstants.OTHER_COLOR;
		}
	}

	public static @NonNull CompleteClass getCompleteClass(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum.getCompleteClass());
	}

	public static @NonNull Iterable<@NonNull Node> getDependencyNodes(@NonNull OperationRegion operationRegion) {
		return ClassUtil.nullFree(operationRegion.getDependencyNodes());
	}

	public static @NonNull Role getEdgeRole(@NonNull Edge edge) {
		return ClassUtil.nonNullState(edge.getEdgeRole());
	}

	public static @NonNull String getFillColor(@NonNull Role nodeRole) {
		switch (nodeRole) {
			case CONSTANT: return LIGHT_CONSTANT_COLOR;
			case LOADED: return LIGHT_LOADED_COLOR;
			case PREDICATED: return LIGHT_PREDICATED_COLOR;
			case REALIZED: return LIGHT_REALIZED_COLOR;
			case SPECULATION: return LIGHT_SPECULATION_COLOR;
			case SPECULATED: return LIGHT_SPECULATED_COLOR;
			default: return LIGHT_OTHER_COLOR;
		}
	}

	public static @NonNull Iterable<@NonNull Node> getHeadNodes(@NonNull Region region) {
		return ClassUtil.nullFree(region.getHeadNodes());
	}

	public static @NonNull Iterable<@NonNull Edge> getIncomingEdges(@NonNull Node node) {
		return ClassUtil.nullFree(node.getIncomingEdges());
	}

	public static @NonNull String getName(@NonNull Nameable nameable) {
		return ClassUtil.nonNullState(nameable.getName());
	}

	public static @NonNull Role getNodeRole(@NonNull Node node) {
		return ClassUtil.nonNullState(node.getNodeRole());
	}

	public static @NonNull Iterable<@NonNull EdgeConnection> getOutgoingConnections(@NonNull NavigableEdge navigableEdge) {
		return ClassUtil.nullFree(navigableEdge.getOutgoingConnections());
	}

	public static @NonNull Iterable<@NonNull NodeConnection> getOutgoingConnections(@NonNull Node node) {
		return ClassUtil.nullFree(node.getOutgoingConnections());
	}

	public static @NonNull Iterable<@NonNull Edge> getOutgoingEdges(@NonNull Node node) {
		return ClassUtil.nullFree(node.getOutgoingEdges());
	}

	public static @NonNull Iterable<@NonNull Connection> getOwnedConnections(@NonNull ScheduledRegion scheduledRegion) {
		return ClassUtil.nullFree(scheduledRegion.getOwnedConnections());
	}

	public static @NonNull Iterable<@NonNull Edge> getOwnedEdges(@NonNull Region region) {
		return ClassUtil.nullFree(region.getOwnedEdges());
	}

	public static @NonNull Iterable<@NonNull Node> getOwnedNodes(@NonNull Region region) {
		return ClassUtil.nullFree(region.getOwnedNodes());
	}

	public static @NonNull Iterable<@NonNull Region> getOwnedRegions(@NonNull ScheduledRegion scheduledRegion) {
		return ClassUtil.nullFree(scheduledRegion.getOwnedRegions());
	}

	public static @NonNull ScheduledRegion getOwningScheduledRegion(@NonNull Region region) {
		return ClassUtil.nonNullState(region.getOwningScheduledRegion());
	}

	public static @NonNull Property getProperty(@NonNull NavigableEdge navigableEdge) {
		return ClassUtil.nonNullState(navigableEdge.getProperty());
	}

	public static @NonNull Region getOwningRegion(@NonNull ConnectionEnd connectionEnd) {
		return ClassUtil.nonNullState(connectionEnd.getOwningRegion());
	}

	public static @NonNull Region getOwningRegion(@NonNull Node node) {
		return ClassUtil.nonNullState(node.getOwningRegion());
	}

	public static @NonNull Mapping getReferredMapping(@NonNull BasicMappingRegion basicMappingRegion) {
		return ClassUtil.nonNullState(basicMappingRegion.getReferredMapping());
	}

	public static @NonNull TypedModel getReferredTypedModel(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum.getReferredTypedModel());
	}

	public static @NonNull ScheduleModel getScheduleModel(@NonNull Region region) {
		return ClassUtil.nonNullState(region.getScheduleModel());
	}

	public static <CE extends ConnectionEnd> @NonNull Iterable<@NonNull CE> getSourceEnds(@NonNull DatumConnection<CE> datumConnection) {
		return ClassUtil.nullFree(datumConnection.getSourceEnds());
	}

	public static @NonNull Node getSourceNode(@NonNull Edge edge) {
		return ClassUtil.nonNullState(edge.getSourceNode());
	}

	public static @NonNull Node getTargetNode(@NonNull Edge edge) {
		return ClassUtil.nonNullState(edge.getTargetNode());
	}

	/**
	 * Return true if the target of thatEdge is compatible with the target of thisEdge.
	 */
	public static boolean isConformantTarget(@NonNull NavigableEdge thatEdge, @NonNull NavigableEdge thisEdge) {
		Node thatTarget = getCastTarget(thatEdge.getEdgeTarget());
		Node thisTarget = getCastTarget(thisEdge.getEdgeTarget());
		CompleteClass thatType = thatTarget.getCompleteClass();
		CompleteClass thisType = thisTarget.getCompleteClass();
		if (conformsToClassOrBehavioralClass(thatType, thisType)) {
			return true;
		}
		if (thatTarget.isRealized()) {
			return false;
		}
		if (conformsToClassOrBehavioralClass(thisType, thatType)) {
			return true;
		}
		return false;
	}

	public static Role mergeToLessKnownPhase(Role firstRole, Role secondRole) {
		if (firstRole == Role.REALIZED) {
			return firstRole;
		}
		else if (secondRole == Role.REALIZED) {
			return secondRole;
		}
		else if (firstRole == Role.PREDICATED){
			return firstRole;
		}
		else if (secondRole == Role.PREDICATED){
			return secondRole;
		}
		else if (firstRole == Role.LOADED) {
			return firstRole;
		}
		else if (secondRole == Role.LOADED) {
			return secondRole;
		}
		else if (firstRole == Role.CONSTANT) {
			return firstRole;
		}
		else if (secondRole == Role.CONSTANT) {
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}

	public static @NonNull Role mergeToMoreKnownPhase(@NonNull Role firstRole, @NonNull Role secondRole) {
		if (firstRole == Role.CONSTANT) {
			return firstRole;
		}
		else if (secondRole == Role.CONSTANT) {
			return secondRole;
		}
		else if (firstRole == Role.LOADED) {
			return firstRole;
		}
		else if (secondRole == Role.LOADED) {
			return secondRole;
		}
		else if (firstRole == Role.REALIZED) {
			return firstRole;
		}
		else if (secondRole == Role.REALIZED) {
			return secondRole;
		}
		else if (firstRole == Role.SPECULATED) {
			return firstRole;
		}
		else if (secondRole == Role.SPECULATED) {
			return secondRole;
		}
		else if (firstRole == Role.SPECULATION) {
			return firstRole;
		}
		else if (secondRole == Role.SPECULATION) {
			return secondRole;
		}
		else if (firstRole == Role.PREDICATED) {
			return firstRole;
		}
		else if (secondRole == Role.PREDICATED) {
			return secondRole;
		}
		throw new UnsupportedOperationException();
	}
}