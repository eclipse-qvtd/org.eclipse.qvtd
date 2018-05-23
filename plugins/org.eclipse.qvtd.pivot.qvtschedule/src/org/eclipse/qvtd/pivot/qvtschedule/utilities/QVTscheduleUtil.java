/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtschedule.AbstractDatum;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.ConnectionEnd;
import org.eclipse.qvtd.pivot.qvtschedule.DatumConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EdgeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.LoadingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
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

	public static class Internal
	{
		public static @NonNull List<@NonNull AbstractDatum> getConsumedDatumsList(@NonNull RuleRegion ruleRegion) {
			return ClassUtil.nullFree(ruleRegion.getConsumedDatums());
		}

		public static @NonNull List<@NonNull Node> getHeadNodesList(@NonNull Region region) {
			return ClassUtil.nullFree(region.getHeadNodes());
		}

		public static List<@NonNull ScheduledRegion> getOwnedScheduledRegionsList(@NonNull ScheduleModel scheduleModel) {
			return ClassUtil.nullFree(scheduleModel.getOwnedScheduledRegions());
		}

		public static @NonNull List<@NonNull AbstractDatum> getProducedDatumsList(@NonNull RuleRegion ruleRegion) {
			return ClassUtil.nullFree(ruleRegion.getProducedDatums());
		}

		public static @NonNull List<@NonNull ClassDatum> getSuperClassDatumsList(@NonNull ClassDatum classDatum) {
			return ClassUtil.nullFree(classDatum.getSuperClassDatums());
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

	public static @Nullable ScheduleModel basicGetContainingScheduleModel(@NonNull Element element) {
		for (EObject eObject = element; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ScheduleModel) {
				return (ScheduleModel)eObject;
			}
		}
		return null;
	}

	public static boolean conformsToClassOrBehavioralClass(@NonNull CompleteClass firstType, @NonNull CompleteClass secondType) {
		return firstType.conformsTo(secondType) || firstType.conformsTo(secondType.getBehavioralClass());
	}

	public static boolean containsNone(@NonNull Iterable<@NonNull Node> firstNodes, @NonNull Iterable<@NonNull Node> secondNodes) {
		for (@NonNull Node firstNode : firstNodes) {
			for (@NonNull Node secondNode : secondNodes) {
				if (firstNode == secondNode) {
					return false;
				}
			}
		}
		return true;
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

	public static @NonNull Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> getCompleteClass2Nodes(@NonNull Region region) {
		Map<@NonNull CompleteClass, @NonNull List<@NonNull Node>> completeClass2nodes = new HashMap<>();
		for (@NonNull Node node : getOwnedNodes(region)) {
			CompleteClass completeClass = node.getCompleteClass();
			List<@NonNull Node> mergedNodes = completeClass2nodes.get(completeClass);
			if (mergedNodes == null) {
				mergedNodes = new ArrayList<>();
				completeClass2nodes.put(completeClass, mergedNodes);
			}
			if (!mergedNodes.contains(node)) {
				mergedNodes.add(node);
			}
		}
		return completeClass2nodes;
	}

	public static @NonNull Iterable<@NonNull RuleRegion> getConsumingRegions(@NonNull AbstractDatum abstractDatum) {
		return ClassUtil.nullFree(abstractDatum.getConsumingRegions());
	}

	public static @NonNull ScheduledRegion getContainingScheduledRegion(@NonNull Region region) {
		return ClassUtil.nonNullState(region.getContainingScheduledRegion());
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

	public static @NonNull Iterable<@NonNull MappingRegion> getMappingRegions(@NonNull ScheduledRegion scheduledRegion) {
		return ClassUtil.nullFree(scheduledRegion.getMappingRegions());
	}

	public static @NonNull String getName(@NonNull Nameable nameable) {
		return ClassUtil.nonNullState(nameable.getName());
	}

	public static @NonNull String getName(@NonNull ClassDatum classDatum) {
		return classDatum.getReferredTypedModel().getName() + "!" + classDatum.getCompleteClass().getPrimaryClass().toString();
	}

	public static @NonNull Role getNodeRole(@NonNull Node node) {
		return ClassUtil.nonNullState(node.getNodeRole());
	}

	public static @NonNull Role getOperationNodePhase(@NonNull Region region, @NonNull TypedElement typedElement, @NonNull Node... argNodes) {
		boolean isLoaded = false;
		boolean isPredicated = false;
		boolean isRealized = false;
		if (argNodes != null) {
			for (Node argNode : argNodes) {
				if (argNode.isRealized()) {
					isRealized = true;
				}
				else if (argNode.isPredicated()) {
					isPredicated = true;
				}
				else if (argNode.isLoaded()) {
					isLoaded = true;
				}
			}
		}
		if (typedElement instanceof OperationCallExp) {
			Operation asOperation = ((OperationCallExp)typedElement).getReferredOperation();
			if (QVTbaseUtil.isIdentification(asOperation)) {
				//				DomainUsage usage = getScheduleManager(region).getDomainUsage(typedElement);
				//				if (!usage.isInput()) {
				isRealized = true;
				//				}
			}
		}
		if (isRealized) {
			return Role.REALIZED;
		}
		else if (isPredicated) {
			return Role.PREDICATED;
		}
		else if (isLoaded) {
			return Role.LOADED;
		}
		else {
			return Role.CONSTANT;
		}
	}

	public static @NonNull NavigableEdge getOppositeEdge(@NonNull NavigableEdge navigableEdge) {
		return ClassUtil.nonNullState(navigableEdge.getOppositeEdge());
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

	public static @NonNull Iterable<@NonNull ClassDatum> getOwnedClassDatums(@NonNull ScheduleModel scheduleModel) {
		return ClassUtil.nullFree(scheduleModel.getOwnedClassDatums());
	}

	public static @NonNull Iterable<@NonNull Connection> getOwnedConnections(@NonNull ScheduledRegion scheduledRegion) {
		return ClassUtil.nullFree(scheduledRegion.getOwnedConnections());
	}

	public static @NonNull Iterable<@NonNull Edge> getOwnedEdges(@NonNull Region region) {
		return ClassUtil.nullFree(region.getOwnedEdges());
	}

	public static @NonNull LoadingRegion getOwnedLoadingRegion(@NonNull ScheduledRegion scheduledRegion) {
		return ClassUtil.nonNullState(scheduledRegion.getOwnedLoadingRegion());
	}

	public static @NonNull Iterable<@NonNull Node> getOwnedNodes(@NonNull Region region) {
		return ClassUtil.nullFree(region.getOwnedNodes());
	}

	public static @NonNull Iterable<@NonNull PropertyDatum> getOwnedPropertyDatums(@NonNull ClassDatum classDatum) {
		return ClassUtil.nullFree(classDatum.getOwnedPropertyDatums());
	}

	public static @NonNull Iterable<@NonNull MappingRegion> getOwnedMappingRegions(@NonNull ScheduleModel scheduleModel) {
		return ClassUtil.nullFree(scheduleModel.getOwnedMappingRegions());
	}

	public static @NonNull Iterable<@NonNull OperationRegion> getOwnedOperationRegions(@NonNull ScheduleModel scheduleModel) {
		return ClassUtil.nullFree(scheduleModel.getOwnedOperationRegions());
	}

	public static @NonNull Iterable<@NonNull ScheduledRegion> getOwnedScheduledRegions(@NonNull ScheduleModel scheduleModel) {
		return ClassUtil.nullFree(scheduleModel.getOwnedScheduledRegions());
	}

	public static @NonNull Region getOwningRegion(@NonNull ConnectionEnd connectionEnd) {
		return ClassUtil.nonNullState(connectionEnd.getOwningRegion());
	}

	public static @NonNull Region getOwningRegion(@NonNull Node node) {
		return ClassUtil.nonNullState(node.getOwningRegion());
	}

	public static @NonNull ScheduleModel getOwningScheduleModel(@NonNull ScheduledRegion scheduledRegion) {
		return ClassUtil.nonNullState(scheduledRegion.getOwningScheduleModel());
	}

	public static @NonNull NavigableEdge getPrimaryEdge(@NonNull NavigableEdge navigableEdge) {
		return navigableEdge.isSecondary() ? getOppositeEdge(navigableEdge) : navigableEdge;
	}

	public static @NonNull Iterable<@NonNull RuleRegion> getProducingRegions(@NonNull AbstractDatum abstractDatum) {
		return ClassUtil.nullFree(abstractDatum.getProducingRegions());
	}

	public static @NonNull Property getProperty(@NonNull NavigableEdge navigableEdge) {
		return ClassUtil.nonNullState(navigableEdge.getProperty());
	}

	public static @NonNull Rule getReferredRule(@NonNull RuleRegion ruleRegion) {
		return ClassUtil.nonNullState(ruleRegion.getReferredRule());
	}

	public static @NonNull Transformation getReferredTransformation(@NonNull ScheduledRegion scheduledRegion) {
		return ClassUtil.nonNullState(scheduledRegion.getReferredTransformation());
	}

	public static @NonNull TypedModel getReferredTypedModel(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum.getReferredTypedModel());
	}

	public static @NonNull ScheduleModel getScheduleModel(@NonNull Region region) {
		for (EObject eObject = region; eObject != null; eObject = eObject.eContainer()) {
			if (eObject instanceof ScheduleModel) {
				return (ScheduleModel)eObject;
			}
		}
		return ClassUtil.nonNullState(null);
	}

	public static <CE extends ConnectionEnd> @NonNull Iterable<@NonNull CE> getSourceEnds(@NonNull DatumConnection<CE> datumConnection) {
		return ClassUtil.nullFree(datumConnection.getSourceEnds());
	}

	public static @NonNull Node getSourceNode(@NonNull Edge edge) {
		return ClassUtil.nonNullState(edge.getSourceNode());
	}

	public static @NonNull Iterable<@NonNull ClassDatum> getSuperClassDatums(@NonNull ClassDatum classDatum) {
		return ClassUtil.nullFree(classDatum.getSuperClassDatums());
	}

	public static @NonNull Node getTargetNode(@NonNull Edge edge) {
		return ClassUtil.nonNullState(edge.getTargetNode());
	}

	public static @NonNull TypedModel getTypedModel(@NonNull ClassDatum classDatum) {
		return ClassUtil.nonNullState(classDatum.getReferredTypedModel());
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

	public static boolean isMatched(@NonNull TypedElement typedElement) {
		boolean isMatched = false;
		Type type = typedElement.getType();
		if (type instanceof CollectionType) {
			//			IntegerValue lowerValue = ((CollectionType)type).getLowerValue();
			//			if (lowerValue.signum() > 0) {
			isMatched = true;
			assert typedElement.isIsRequired();
			//			}
		}
		else {
			isMatched = typedElement.isIsRequired();
		}
		if (!isMatched) {
			return false;
		}
		return isUnconditional(typedElement);
	}

	/*	public static boolean isRealizedIncludes(@NonNull Edge edge) {	// FIXME includes should be a pseudo-navigation edge
		if (!edge.isRealized()) {
			return false;
		}
		if (!edge.isComputation()) {
			return false;
		}
		return "«includes»".equals(edge.getName()) || "«includesAll»".equals(edge.getName());
	} */

	public static boolean isUnconditional(@NonNull TypedElement typedElement) {
		EObject eContainer = typedElement.eContainer();
		if (eContainer instanceof IfExp) {
			IfExp ifExp = (IfExp)eContainer;
			if ((typedElement == ifExp.getOwnedThen()) || (typedElement == ifExp.getOwnedElse())) {
				return false;
			}
		}
		else if (eContainer instanceof LoopExp) {
			LoopExp loopExp = (LoopExp)eContainer;
			if (typedElement == loopExp.getOwnedBody()) {
				return false;
			}
		}
		if (eContainer instanceof TypedElement) {
			return isUnconditional((TypedElement) eContainer);
		}
		return true;
	}

	public static boolean isUnconditional(@NonNull Edge edge) {
		for (@NonNull TypedElement typedElement : edge.getEdgeSource().getTypedElements()) {
			if (!isUnconditional(typedElement)) {
				return false;
			}
		}
		return true;
	}

	public static @NonNull Role mergeToLessKnownPhase(Role firstRole, Role secondRole) {
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

	public static Node.@NonNull Utility mergeToStrongerUtility(Node.@NonNull Utility nodeUtility1, Node.@NonNull Utility nodeUtility2) {
		if ((nodeUtility1 == Node.Utility.STRONGLY_MATCHED) || (nodeUtility2 == Node.Utility.STRONGLY_MATCHED)) {
			return Node.Utility.STRONGLY_MATCHED;
		}
		else if ((nodeUtility1 == Node.Utility.WEAKLY_MATCHED) || (nodeUtility2 == Node.Utility.WEAKLY_MATCHED)) {
			return Node.Utility.WEAKLY_MATCHED;
		}
		else if ((nodeUtility1 == Node.Utility.CONDITIONAL) || (nodeUtility2 == Node.Utility.CONDITIONAL)) {
			return Node.Utility.CONDITIONAL;
		}
		else if ((nodeUtility1 == Node.Utility.DEPENDENCY) || (nodeUtility2 == Node.Utility.DEPENDENCY)) {
			return Node.Utility.DEPENDENCY;
		}
		else {
			return Node.Utility.DEAD;
		}
	}
}
