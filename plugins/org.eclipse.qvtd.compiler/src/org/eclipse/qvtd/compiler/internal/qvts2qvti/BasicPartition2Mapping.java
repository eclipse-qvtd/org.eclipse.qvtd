/*******************************************************************************
 * Copyright (c) 2015, 2020 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedCondition;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.checks.CheckedConditionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.FallibilityAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.MappingPartitionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.PartitionedTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.partitioner.TransformationPartitioner;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.graphs.GraphStringBuilder.GraphElement;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.AddStatement;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.Mapping;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatementPart;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.SpeculateStatement;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Connection;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeLibraryHelper;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class BasicPartition2Mapping extends AbstractPartition2Mapping
{
	/**
	 * The OldEdgeSchedule analyses the old (constant, loaded, speculation, predicated) nodes and edges
	 * to build a linear edge traversal schedule in which unconditional checks that may fail appear
	 * as early as possible.
	 */
	private class OldEdgeSchedule
	{
		/**
		 * The linear execution schedule for edges.
		 */
		private @NonNull List<@NonNull Edge> edgeSchedule = new ArrayList<>();

		/**
		 * The edges (and their opposites) in edgeSchedule.
		 */
		private final @NonNull Set<@NonNull Edge> scheduledEdges = new HashSet<>();

		/**
		 * The nodes at the ends of the edges in edgeSchedule.
		 */
		private final @NonNull Set<@NonNull Node> scheduledNodes;

		public OldEdgeSchedule() {
			this.scheduledNodes = Sets.newHashSet(QVTscheduleUtil.getHeadNodes(partition));  // ?? leaf constants
		}

		private void addEdge(@NonNull Edge edge) {
			assert !edge.isConditional();
			assert partition.getRole(edge) != null;
			if (scheduledEdges.add(edge)) {
				NavigationEdge oppositeEdge = null;
				if (edge instanceof NavigationEdge) {
					oppositeEdge = ((NavigationEdge)edge).getOppositeEdge();
					if (oppositeEdge != null) {
						boolean wasAdded = scheduledEdges.add(oppositeEdge);
						assert wasAdded;
					}
				}
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Role sourceNodeRole = partition.getRole(sourceNode);
				if ((sourceNodeRole != null) && !sourceNode.isDependency()) {
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					Role targetNodeRole = partition.getRole(targetNode);
					if ((targetNodeRole != null) && !targetNode.isDependency()) {
						//	Integer sourceCost = reachabilityForest.getCost(sourceNode);
						//	Integer targetCost = reachabilityForest.getCost(targetNode);
						//	assert (sourceCost != null) && (targetCost != null);// && ((targetCost <= 0) || (sourceCost <= targetCost));
						addNode(sourceNode);
						addNode(targetNode);
						edgeSchedule.add(edge);
					}
				}
			}
		}

		private void addNode(@NonNull Node targetNode) {
			assert partition.getRole(targetNode) != null;
			if (scheduledNodes.add(targetNode)) {
				//	Integer targetCost = reachabilityForest.getCost(targetNode);
				Iterable<@NonNull Edge> reachingEdges = reachabilityForest.getReachingEdges(targetNode);
				int size = Iterables.size(reachingEdges);
				if (size > 0) {
					if (size == 1) {
						Edge edge = reachingEdges.iterator().next();
						assert !edge.isPartial();
						if (!edge.isConditional()) {
							addEdge(edge);
						}
					}
					else {
						List<@NonNull Node> sourceNodes = new ArrayList<>();
						for (Edge edge : reachingEdges) {		// FIXME lowest cost first
							assert !edge.isPartial();
							if (!edge.isConditional()) {
								sourceNodes.add(QVTscheduleUtil.getSourceNode(edge));
							}
						}
						if (sourceNodes.size() > 1) {
							Collections.sort(sourceNodes, reachabilityForest.getNodeCostComparator());
						}
						for (Node sourceNode : sourceNodes) {
							addNode(sourceNode);
						}
						for (Edge edge : reachingEdges) {
							assert !edge.isPartial();
							if (!edge.isConditional()) {
								addEdge(edge);
							}
						}
					}
				}
			}
		}

		public @NonNull Iterable<@NonNull CheckedCondition> analyze() {
			//
			//	A dispatch input node must be checked to confirm the correct derivation.
			//
			Node dispatchNode = regionAnalysis.basicGetDispatchNode();
			if (dispatchNode != null) {
				for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(dispatchNode)) {
					Role edgeRole = partition.getRole(edge);
					if ((edgeRole != null) && edgeRole.isPredicated()) {
						addEdge(edge);
					}
				}
			}
			//
			//	A predicated head node success must be checked before anything else.
			//
			for (@NonNull Node headNode : headNodes) {		// FIXME This should be redundant wrt prioritized CheckConditions
				Edge localSuccessEdge = regionAnalysis.basicGetLocalSuccessEdge(headNode);
				if (localSuccessEdge != null) {
					Role localSuccessEdgeRole = partition.getRole(localSuccessEdge);
					if ((localSuccessEdgeRole != null) && localSuccessEdgeRole.isPredicated()) {
						addEdge(localSuccessEdge);
					}
				}
				Edge globalSuccessEdge = regionAnalysis.basicGetGlobalSuccessEdge(headNode);
				if (globalSuccessEdge != null) {
					Role globalSuccessEdgeRole = partition.getRole(globalSuccessEdge);
					if ((globalSuccessEdgeRole != null) && globalSuccessEdgeRole.isPredicated()) {
						addEdge(globalSuccessEdge);
					}
				}
			}
			//
			//	An unreachable constant may be an outright suppression.
			//
			for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(QVTscheduleUtil.getRegion(partition))) {
				Role role = partition.getRole(node);
				if ((role != null) && role.isConstant()) {
					if (node.getIncomingEdges().isEmpty() && node.getOutgoingEdges().isEmpty()) {
						OCLExpression exp = createVariableExp(node);
						CheckStatement checkStatement = createCheckStatement(exp);
						addTrace(checkStatement, node);
					}
				}
			}
			//
			//	Speculated edges must participate in a global decision before anything else is done.
			/*
			Iterable<@NonNull SuccessEdge> speculatedEdges = checkedConditionAnalysis.getSpeculatedEdges();
			if (speculatedEdges != null) {
				for (@NonNull SuccessEdge speculatedEdge : speculatedEdges) {		// Ensure that all speculated objects are located
					addNode(QVTscheduleUtil.getSourceNode(speculatedEdge));
				}
				for (@NonNull SuccessEdge speculatedEdge : speculatedEdges) {		// then traverse the speculated properties all in sequence
					addEdge(speculatedEdge);
				}
			} */
			Set<@NonNull CheckedCondition> checkedConditions = checkedConditionAnalysis.computeCheckedConditions();
			int checkableSize = checkedConditions.size();
			//			if (checkableSize > 0) {
			List<@NonNull CheckedCondition> sortedCheckedConditions = new ArrayList<>(checkedConditions);
			if (checkableSize > 1) {
				Collections.sort(sortedCheckedConditions, new CheckedConditionWeightComparator(BasicPartition2Mapping.this));
			}
			for (@NonNull CheckedCondition checkedCondition : sortedCheckedConditions) {		// ?? speculated edges first
				Iterable<@NonNull Edge> edges = checkedCondition.getEdges();
				if (edges != null) {
					for (@NonNull Edge edge : edges) {
						if (!edge.isConditional()) {
							addEdge(edge);
						}
					}
				}
				Node node = checkedCondition.getNode();
				if (node != null) {
					addNode(node);
				}
			}
			//			}
			//
			//	Speculated edges must participate in a global decision before anything else is done.
			//
			Iterable<@NonNull SuccessEdge> speculatedEdges = checkedConditionAnalysis.getSpeculatedEdges();
			if (speculatedEdges != null) {
				for (@NonNull SuccessEdge speculatedEdge : speculatedEdges) {		// Ensure that all speculated objects are located
					addNode(QVTscheduleUtil.getSourceNode(speculatedEdge));
				}
				for (@NonNull SuccessEdge speculatedEdge : speculatedEdges) {		// then traverse the speculated properties all in sequence
					addEdge(speculatedEdge);
				}
			}
			//
			List<@NonNull Edge> residualEdges = null;
			for (@NonNull Edge edge : checkedConditionAnalysis.getOldUnconditionalEdges()) {
				if (residualEdges == null) {
					residualEdges = new ArrayList<>();
				}
				residualEdges.add(edge);
			}
			if (residualEdges != null) {
				Collections.sort(residualEdges, reachabilityForest.getEdgeCostComparator());
				for (@NonNull Edge edge : residualEdges) {
					addEdge(edge);
				}
			}
			//			assert edgeSchedule.size() == oldEdges.size();		-- FIXME oppositeEdges inhibit simple equality check
			//			assert new HashSet<>(edgeSchedule).equals(new HashSet<>(oldEdges));
			return sortedCheckedConditions;
		}

		protected void createConstantCheck(@NonNull Edge edge, @NonNull OCLExpression checkExpression) {
			Role edgeRole = partition.getRole(edge);
			assert edgeRole != null;
			if (edgeRole.isSpeculated()) {
				assert edge.isSuccess();
				boolean isInfallible = isInfallible();
				boolean isTerminating = isTerminating();
				if (isInfallible) {				// If cycles are guaranteed not to fail (e.g. Forward2Reverse)
					// Speculation code can be omitted.
				}
				else if (isTerminating) {		// If cycles are guaranteed to terminate (e.g. ATL2QVTr containment ascent)
					CheckStatement checkStatement = createCheckStatement(checkExpression);
					addTrace(checkStatement, edge);
				}
				else {
					QVTruntimeUtil.errPrintln("Speculation code omitted for " + partition);
				}
			}
			else {
				CheckStatement checkStatement = createCheckStatement(checkExpression);
				addTrace(checkStatement, edge);
			}
		}

		public void synthesize(@NonNull Iterable<@NonNull CheckedCondition> checkedConditions) {
			assert mapping.getOwnedStatements().isEmpty();			// Enforce analyze then synthesize design policy
			List<@NonNull OCLExpression> speculatedExpressions = null;
			List<@NonNull Edge> speculatedEdges = null;
			for (@NonNull Edge edge : edgeSchedule) {
				assert !edge.isConditional();
				Role edgeRole = partition.getRole(edge);
				assert edgeRole != null;
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				assert !sourceNode.isConditional();
				Role sourceNodeRole = partition.getRole(sourceNode);
				assert sourceNodeRole != null;
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				assert !targetNode.isConditional();
				Role targetNodeRole = partition.getRole(targetNode);
				assert targetNodeRole != null;
				if (edgeRole.isSpeculated()) {
					if (speculatedExpressions == null) {
						speculatedExpressions = new ArrayList<>();
						speculatedEdges = new ArrayList<>();
					}
					else {
						assert !speculatedExpressions.isEmpty() : "Speculated edges must be scheduled in sequence";
					}
					SuccessEdge speculatedEdge = (SuccessEdge)edge;
					assert speculatedEdges != null;
					speculatedEdges.add(speculatedEdge);
					OCLExpression sourceExp = createVariableExp(sourceNode);
					Property successProperty = QVTscheduleUtil.getReferredProperty(speculatedEdge);
					OCLExpression propertyCallExp = helper.createPropertyCallExp(sourceExp, successProperty);
					addTrace(propertyCallExp, edge);
					if (targetNode instanceof BooleanLiteralNode) {
						if (!((BooleanLiteralNode)targetNode).isBooleanValue()) {
							//	propertyCallExp = helper.createOperationCallExp(propertyCallExp, "not");	// FIXME can we do better than ignoring awkward speculations
						}
						else {
							speculatedExpressions.add(propertyCallExp);
						}
					}
					else {
						OCLExpression valueExp = createVariableExp(targetNode);
						propertyCallExp = helper.createOperationCallExp(propertyCallExp, "=", valueExp);
						speculatedExpressions.add(propertyCallExp);
					}
				}
				else {
					if ((speculatedExpressions != null) && !speculatedExpressions.isEmpty()) {
						assert speculatedEdges != null;
						createSpeculateStatement(speculatedExpressions, speculatedEdges);
						speculatedExpressions = Collections.emptyList();		// Prime assertion bomb for disjoint soeculations
						speculatedEdges = Collections.emptyList();
					}
					if (edge.isNavigation()) {
						NavigationEdge navigationEdge = (NavigationEdge)edge;
						Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
						OCLExpression sourceExp = createVariableExp(sourceNode);
						Type sourceType = sourceExp.getType();
						Type requiredType = property.getOwningClass();
						if ((requiredType != null) && !sourceType.conformsTo(getMetamodelManager().getStandardLibrary(), requiredType)) {
							String castName = "cast_" + sourceNode.getName(); // FIXME BUG 530033 in a closed world this is always a fail
							DeclareStatement castStatement = createCheckedDeclareStatement(castName, sourceExp, requiredType);
							sourceExp = helper.createVariableExp(castStatement);
						}
						OCLExpression source2targetExp = createCallExp(sourceExp, property);
						addTrace(source2targetExp, edge);
						if (targetNode.isNullLiteral()) {
							NullLiteralExp nullLiteralExp = helper.createNullLiteralExp();
							addTrace(nullLiteralExp, targetNode);
							createCheckStatement(source2targetExp, "=", nullLiteralExp, edge);
						}
						else if (targetNodeRole.isConstant() && !sourceNodeRole.isNew()) {
							//						createCheckStatement(source2targetExp);
							VariableDeclaration nodeVariable = node2variable.get(targetNode);
							/*if (nodeVariable == null) {
								VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
								createCheckStatement(targetVariableExp, "=", source2targetExp);
							}
							else*/ if (navigationEdge.isPartial()) {
								OCLExpression targetExpression = getExpression(targetNode);
								createCheckStatement(source2targetExp, "includes", targetExpression, edge);
							}
							else if ((targetNode instanceof BooleanLiteralNode) && ((BooleanLiteralNode)targetNode).isBooleanValue()) {
								createConstantCheck(edge, source2targetExp);
							}
							else if (targetNodeRole == Role.CONSTANT_SUCCESS_TRUE) {
								createConstantCheck(edge, source2targetExp);
							}
							else if (nodeVariable == null) {
								QVTs2QVTiNodeVisitor expressionCreator = new QVTs2QVTiNodeVisitor(BasicPartition2Mapping.this);
								OCLExpression targetExpression = expressionCreator.getExpression(targetNode);
								createCheckStatement(source2targetExp, "=", targetExpression, edge);
							}
							else {
								OCLExpression targetExpression = getExpression(targetNode);
								createCheckStatement(source2targetExp, "=", targetExpression, edge);
							}
						}
						else {
							VariableDeclaration nodeVariable = node2variable.get(targetNode);
							if (nodeVariable == null) {
								createDeclareStatement(targetNode, source2targetExp);
								//	createCastPredicates(targetNode, declareStatement);
							}
							else if (navigationEdge.isPartial()) {
								OCLExpression targetExpression = getExpression(targetNode);
								createCheckStatement(source2targetExp, "includes", targetExpression, edge);
							}
							else if (!edge.isNew()) {		// No need to check predication of a realized edge
								OCLExpression targetExpression = getExpression(targetNode);
								createCheckStatement(targetExpression, "=", source2targetExp, edge);
							}
						}
					}
					else if (edge instanceof PredicateEdge) {
						// FIXME	assert !((PredicateEdge)edge).isPartial();
						OCLExpression sourceExpression = getExpression(sourceNode);
						if (!(targetNode instanceof BooleanLiteralNode)) {
							String edgeName = ClassUtil.nonNullState(edge.getName()).trim();
							if (edgeName.length() >= 2) {
								edgeName = edgeName.substring(1, edgeName.length()-1);		// Lose guillemets
							}
							if ("equals".equals(edgeName)) {
								edgeName = "=";								// FIXME regularize
							}
							OCLExpression targetExpression = getExpression(targetNode);
							createCheckStatement(sourceExpression, edgeName, targetExpression, edge);
						}
						else if (((BooleanLiteralNode)targetNode).isBooleanValue()) {
							createConstantCheck(edge, sourceExpression);
						}
						else {
							createCheckStatement(sourceExpression, "=", helper.createBooleanLiteralExp(false), edge);
						}
					}
					else if (edge instanceof ExpressionEdge) {
						getVariableDeclaration(targetNode);
					}
				}
			}
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			boolean isFirst = true;
			for (@NonNull Edge edge : edgeSchedule) {
				if (!isFirst) {
					s.append("\n");
				}
				s.append(edge);
				isFirst = false;
			}
			return s.toString();
		}
	}

	protected final @NonNull RegionAnalysis regionAnalysis;

	/**
	 * Lazily computed closure of all preceding nodes, icluding the final node, of each node.
	 */
	private @Nullable Map<@NonNull Node, @NonNull Set<@NonNull Node>> node2precedingNodeClosure = null;

	/**
	 * The selected head from each head group that is actually passed. Other heads are computed.
	 */
	private final @NonNull List<@NonNull Node> headNodes = new ArrayList<>();

	/**
	 * The subset of possible guard nodes that all callers can pass.
	 */
	private final @NonNull List<@NonNull Node> guardNodes = new ArrayList<>();

	/**
	 * Mapping from the scheduled Nodes to their QVTi variables.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull VariableDeclaration> node2variable = new HashMap<>();

	/**
	 * The mechanisms to reach required nodes.
	 */
	private final @NonNull ReachabilityForest reachabilityForest;

	/**
	 * The failure mechanisms.
	 */
	private final @NonNull CheckedConditionAnalysis checkedConditionAnalysis;

	public BasicPartition2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Mapping mapping, @NonNull MappingPartitionAnalysis<?> partitionAnalysis) {
		super(visitor, mapping, partitionAnalysis.getPartition());
		this.regionAnalysis = scheduleManager.getRegionAnalysis(QVTscheduleUtil.getRegion(partition));
		this.reachabilityForest = partitionAnalysis.getReachabilityForest();
		this.checkedConditionAnalysis = new CheckedConditionAnalysis(partitionAnalysis, scheduleManager);
		addTrace(mapping, partition);
		StringBuilder s = TransformationPartitioner.PROPERTY_OBSERVE.isActive() ? new StringBuilder() : null;
		if (s != null) {
			s.append("[" + partition.getPassRangeText() + "] " + partition.getName());
		}
		checkedConditionAnalysis.computeCheckedPropertyDatums(s);
		if (s != null) {
			TransformationPartitioner.PROPERTY_OBSERVE.println(s.toString());
		}
	}

	public void addVariable(@NonNull Node node, @NonNull VariableDeclaration variableDeclaration) {
		VariableDeclaration oldVariableDeclaration = node2variable.put(node, variableDeclaration);
		assert oldVariableDeclaration == null;
		addTrace(variableDeclaration, node);
	}

	public @Nullable VariableDeclaration basicGetVariable(@NonNull Node node) {
		return node2variable.get(node);
	}

	/**
	 *	Create accumulation assignments for connections.
	 */
	private void createAddStatements() {
		if (connection2variable != null) {
			List<@NonNull NodeConnection> connections = new ArrayList<>(connection2variable.keySet());
			Collections.sort(connections, NameUtil.NAMEABLE_COMPARATOR);
			for (@NonNull NodeConnection connection : connections) {
				Node sourceNode = connection.getSource(partition);
				OCLExpression variableExpression = createVariableExp(sourceNode);
				ConnectionVariable connectionVariable = connection2variable.get(connection);
				assert connectionVariable != null;
				AddStatement addStatement = createAddStatement(connectionVariable, variableExpression);
				addTrace(addStatement, sourceNode);
			}
		}
	}

	private void createCallStatements(@NonNull Map<@NonNull Partition, @NonNull Map<@NonNull Node, @NonNull Node>> calls) {
		List<@NonNull MappingStatement> mappingStatements = new ArrayList<>();
		Map<@NonNull LoopVariable, @NonNull OCLExpression> loopVariables = null;
		for (Map.Entry<@NonNull Partition, @NonNull Map<@NonNull Node, @NonNull Node>> entry : calls.entrySet()) {
			@NonNull Partition calledPartition = entry.getKey();
			AbstractPartition2Mapping calledRegion2Mapping = visitor.getPartition2Mapping(calledPartition);
			List<@NonNull MappingParameterBinding> mappingParameterBindings = new ArrayList<>();
			for (Map.Entry<@NonNull Node, @NonNull Node> entry2 : entry.getValue().entrySet()) {
				@NonNull Node sourceNode = entry2.getKey();
				@NonNull Node targetNode = entry2.getValue();
				OCLExpression sourceExpression = createVariableExp(sourceNode);
				Type type = sourceExpression.getType();
				if (type instanceof CollectionType) {
					if (loopVariables == null) {
						loopVariables = new HashMap<>();
					}
					Type elementType = ((CollectionType)type).getElementType();
					assert elementType != null;
					LoopVariable loopVariable = helper.createLoopVariable(getSafeName("loop" + loopVariables.size()), elementType);//, true, sourceExpression);
					loopVariables.put(loopVariable, sourceExpression);
					//					sourceExpression = PivotUtil.createVariableExp(loopVariable);
					VariableDeclaration guardVariable = calledRegion2Mapping.getGuardVariable(targetNode);
					mappingParameterBindings.add(helper.createLoopParameterBinding((GuardParameter) guardVariable, loopVariable));
				}
				else {
					VariableDeclaration guardVariable = calledRegion2Mapping.getGuardVariable(targetNode);
					mappingParameterBindings.add(helper.createSimpleParameterBinding((SimpleParameter) guardVariable, sourceExpression));
				}
			}
			Collections.sort(mappingParameterBindings, QVTimperativeUtil.MappingParameterBindingComparator.INSTANCE);
			MappingStatement mappingCallStatement = calledRegion2Mapping.createMappingCall(mappingParameterBindings);
			if (loopVariables != null) {
				for (Map.Entry<@NonNull LoopVariable, @NonNull OCLExpression> loopEntry : loopVariables.entrySet()) {
					@NonNull LoopVariable loopVariable = loopEntry.getKey();
					@NonNull OCLExpression loopSource = loopEntry.getValue();
					mappingCallStatement = helper.createMappingLoop(loopSource, loopVariable, mappingCallStatement);
				}
			}
			mappingStatements.add(mappingCallStatement);
		}
		mapping.getOwnedStatements().addAll(mappingStatements);
	}

	private void createAssignedValues(@NonNull Iterable<@NonNull NavigableEdge> sortedRealizedEdges) {
		for (@NonNull NavigableEdge edge : sortedRealizedEdges) {
			Node sourceNode = edge.getEdgeSource();
			Node targetNode = edge.getEdgeTarget();
			if (sourceNode.isOld() && !sourceNode.isConstant()) {
				getVariableDeclaration(sourceNode);
			}
			if (targetNode.isOld() && !targetNode.isConstant()) {
				getVariableDeclaration(targetNode);
			}
		}
	}

	private @NonNull CheckStatement createCheckStatement(@NonNull OCLExpression booleanExpression) {
		CheckStatement checkStatement = helper.createCheckStatement(booleanExpression);
		mapping.getOwnedStatements().add(checkStatement);
		return checkStatement;
	}

	private void createCheckStatement(@NonNull OCLExpression firstExpression, @NonNull String operatorName, @NonNull OCLExpression secondExpression, @NonNull GraphElement graphElement) {
		OCLExpression booleanExpression = helper.createOperationCallExp(firstExpression, operatorName, secondExpression);
		addTrace(booleanExpression, graphElement);
		CheckStatement checkStatement = createCheckStatement(booleanExpression);
		addTrace(checkStatement, graphElement);
	}

	private @NonNull DeclareStatement createCheckedDeclareStatement(@NonNull String name, @NonNull OCLExpression sourceExp, @NonNull Type requiredType) {
		String safeName = getSafeName(name);
		DeclareStatement castStatement = helper.createDeclareStatement(safeName, requiredType, true, sourceExp);
		mapping.getOwnedStatements().add(castStatement);
		return castStatement;
	}

	private void createClassSetStatement(@Nullable StringBuilder s, @NonNull NavigableEdge edge) {
		if (edge instanceof NavigationEdge) {
			NavigationEdge navigationEdge = (NavigationEdge)edge;
			Node sourceNode = edge.getEdgeSource();
			Node targetNode = edge.getEdgeTarget();
			Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
			boolean isNotify = connectionManager.isHazardousWrite(s, navigationEdge);
			Property setProperty;
			VariableDeclaration slotVariable;
			OCLExpression valueExpression;
			SetStatement setStatement;
			boolean isPartial;
			if (/*!isPartial &&*/ property.isIsImplicit()) {
				slotVariable = getVariableDeclaration(targetNode);
				setProperty = QVTrelationUtil.getOpposite(property);
				valueExpression = createVariableExp(sourceNode);
				isPartial = setProperty.isIsMany();
			}
			else {
				slotVariable = getVariableDeclaration(sourceNode);
				setProperty = property;
				valueExpression = createVariableExp(targetNode);
				isPartial = edge.isPartial();
			}
			if (!sourceNode.isStrict()) {
				setStatement = helper.createSetStatement(slotVariable, setProperty, valueExpression, isPartial, isNotify);
				mapping.getOwnedStatements().add(setStatement);
				addTrace(setStatement, edge);
			}
			else {
				assert !property.isIsImplicit();
				assert !isPartial;
				//	assert !isNotify;
				NewStatement newStatement = (NewStatement)slotVariable;
				NewStatementPart newStatementPart = helper.createNewStatementPart(setProperty, valueExpression); //, isNotify);
				newStatement.getOwnedParts().add(newStatementPart);
				addTrace(newStatementPart, edge);
			}
		}
		else {
			// SharedEdge
		}
	}

	@NonNull VariableExp createContextVariableExp() {
		StandardLibrary standardLibrary = getStandardLibrary();
		Transformation iTransformation = visitor.getImperativeTransformation();
		Transformation asTransformation = visitor.getOriginalTransformation();
		VariableDeclaration contextVariable = QVTbaseUtil.getContextVariable(standardLibrary, iTransformation, asTransformation);
		return helper.createVariableExp(contextVariable);
	}

	private @NonNull DeclareStatement createDeclareStatement(@NonNull Node node, @NonNull OCLExpression initExpression) {
		Type variableType = node.getClassDatum().getPrimaryClass();
		assert variableType != null;
		boolean isRequired = !node.isConditional() && node.isRequired();
		if (initExpression.isIsRequired()) {
			isRequired = true;
		}
		String safeName = getSafeName(node);
		DeclareStatement newVariable = helper.createDeclareStatement(safeName, variableType, isRequired, initExpression);
		List<Statement> ownedStatements = mapping.getOwnedStatements();
		int i = ownedStatements.size();
		while (--i >= 0) {
			Statement statement = ownedStatements.get(i);
			if (!(statement instanceof SetStatement) && !(statement instanceof NewStatement)) {
				break;
			}
		}
		ownedStatements.add(i+1, newVariable);
		addVariable(node, newVariable);
		return newVariable;
	}

	private @NonNull GuardParameter createGuardParameter(@NonNull Node guardNode) {
		ClassDatum classDatum = QVTscheduleUtil.getClassDatum(guardNode);
		Type variableType = guardNode.getClassDatum().getPrimaryClass();
		TypedModel iTypedModel = ClassUtil.nonNullState(visitor.getQVTiTypedModel(classDatum.getReferredTypedModel()));
		GuardParameter guardParameter = helper.createGuardParameter(getSafeName(guardNode), iTypedModel, variableType, true);
		Property successProperty = null;

		Rule2TraceGroup rule2traceGroup = regionAnalysis.basicGetRule2TraceGroup();
		if (rule2traceGroup != null) {
			Element2MiddleProperty relation2globalSuccessProperty = rule2traceGroup.basicGetRelation2GlobalSuccessProperty();
			Property globalSuccessProperty = null;
			if (relation2globalSuccessProperty != null) {
				globalSuccessProperty = relation2globalSuccessProperty.getTraceProperty();
				NavigableEdge globalSuccessEdge = guardNode.getOutgoingNavigableEdge(globalSuccessProperty);
				if (globalSuccessEdge != null) {
					Role globalSuccessEdgeRole = partition.getRole(globalSuccessEdge);
					if (globalSuccessEdgeRole != null) {
						Node globalSuccessNode = QVTscheduleUtil.getTargetNode(globalSuccessEdge);
						if (globalSuccessNode.isSuccess() && !globalSuccessEdgeRole.isPredicated()) {		// Skip predicated success
							assert globalSuccessEdgeRole.isRealized();
							successProperty = globalSuccessProperty;
							//	assert !isHazardousWrite(globalSuccessEdge);
						}
					}
				}
			}
			Property localSuccessProperty = null;
			Element2MiddleProperty relation2localSuccessProperty = rule2traceGroup.basicGetRelation2LocalSuccessProperty();
			if (relation2localSuccessProperty != null) {
				localSuccessProperty = relation2localSuccessProperty.getTraceProperty();
				NavigableEdge localSuccessEdge = guardNode.getOutgoingNavigableEdge(localSuccessProperty);
				if (localSuccessEdge != null) {
					Role localSuccessEdgeRole = partition.getRole(localSuccessEdge);
					if (localSuccessEdgeRole != null) {
						Node localSuccessNode = QVTscheduleUtil.getTargetNode(localSuccessEdge);
						if (localSuccessNode.isSuccess() && !localSuccessEdgeRole.isPredicated()) {		// Skip predicated local-success
							assert localSuccessEdgeRole.isRealized();
							assert successProperty == null;
							successProperty = localSuccessProperty;
							//	assert !isHazardousWrite(localSuccessEdge);
						}
					}
				}
			}
		}
		if (successProperty != null) {
			guardParameter.setSuccessProperty(successProperty);
		}
		mapping.getOwnedMappingParameters().add(guardParameter);
		addVariable(guardNode, guardParameter);
		return guardParameter;
	}

	/**
	 * Identify the headNodes/guardNodes and create a guard variable for each guard node.
	 */
	private void createHeadAndGuardNodeVariables() {
		Set<@NonNull Region> headCallingRegions = new HashSet<@NonNull Region>();
		//		Iterable<@NonNull Edge> recursionEdges = region.getRecursionEdges();
		//		if (Iterables.size(recursionEdges) > 0) {
		//			headCallingRegions.add(region);
		//		}
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(partition)) {		// FIXME Move best bead selection to QVTs2QVTs so that diagrams show best head
			if (!headNode.isDependency() && !headNode.isThis()) {
				Node bestHeadNode = null;
				Iterable<@NonNull Node> callingSources = connectionManager.getPassedBindingSources(headNode);
				if (!Iterables.isEmpty(callingSources)) {
					bestHeadNode = headNode;
				}
				for (@NonNull Node callingSource : callingSources) {
					headCallingRegions.add(QVTscheduleUtil.getOwningRegion(callingSource));
				}
				if (bestHeadNode != null) {
					headNodes.add(bestHeadNode);
				}
				else {
					CompilerUtil.addPartitionError(visitor.getProblemHandler(), partition, "No best head");
				}
			}
		}
		guardNodes.addAll(headNodes);
		Collections.sort(guardNodes, NameUtil.NAMEABLE_COMPARATOR);
		//
		//	Set Mapping useClassMappings if consumes are not inherently unique.
		//		DataTypes are difficuilt to prove uniqueness.
		boolean isStrict = false;
		for (@NonNull Node guardNode : guardNodes) {
			if (!guardNode.isDependency()) {
				createGuardParameter(guardNode);
				for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(guardNode)) {
					if (!edge.isSuccess()) {
						Role role = partition.getRole(edge);
						if ((role != null) && role.isOld()) {
							Node targetNode = QVTscheduleUtil.getTargetNode(edge);
							if (targetNode.isDataType()) {
								isStrict = true;
							}
						}
					}
				}
				Connection connection = guardNode.getIncomingConnection();
				if (connection != null) {
					int lastProducer = connection.getLastPass();
					int lastConsumer = partition.getLastPass();
					if (lastConsumer <= lastProducer) {
						isStrict = true;		// ?? do we need a separate isCyclic
					}
				}
			}
		}
		mapping.setIsStrict(isStrict);
		//
		//	Create any connectionVariable guards
		//
		createAppendParameters();
	}

	private void createObservedProperties() {
		Set<@NonNull PropertyDatum> allCheckedPropertyDatums = checkedConditionAnalysis.getAllCheckedPropertyDatums();
		if (!allCheckedPropertyDatums.isEmpty()) {		// FIXME Use PropertyDatum to handle derived accesses
			//	Set<@NonNull Property> allCheckedProperties = new HashSet<>();
			//	for (@NonNull PropertyDatum propertyDatum : allCheckedPropertyDatums) {
			//		allCheckedProperties.add(QVTscheduleUtil.getReferredProperty(propertyDatum));
			//	}
			//
			// Ideally we could install each observed property as it is actually used. But
			// this needs to be coded in many places.
			//
			for (Statement asStatement : mapping.getOwnedStatements()) {
				if (asStatement instanceof ObservableStatement) {
					List<Property> observedProperties = ((ObservableStatement)asStatement).getObservedProperties();
					for (EObject eObject : new TreeIterable(asStatement, false)) {
						if (eObject instanceof NavigationCallExp) {
							boolean allCheckedPropertyDatumsContainsPropertyDatum = false;
							NavigationCallExp navigationCallExp = (NavigationCallExp) eObject;
							Property property = PivotUtil.getReferredProperty(navigationCallExp);
							for (@NonNull GraphElement graphElement : getTrace(navigationCallExp)) {			// Only one in practice
								if (graphElement instanceof NavigationEdge) {					// Always NavigationEdge
									for (@NonNull PropertyDatum propertyDatum : scheduleManager.getPropertyDatums((NavigationEdge)graphElement)) {
										if (allCheckedPropertyDatums.contains(propertyDatum)) {
											allCheckedPropertyDatumsContainsPropertyDatum = true;
											// FIXME check timing
											int earliestConsumption = mapping.getFirstPass();
											//											connectionManager.get
										}
									}
								}
							}
							//	boolean allCheckedPropertiesContainsProperty = allCheckedProperties.contains(property);
							/*	if (allCheckedPropertiesContainsProperty && !allCheckedPropertyDatumsContainsPropertyDatum) {
								getClass();
								for (@NonNull GraphElement graphElement : getTrace(navigationCallExp)) {			// Only one in parctice
									if (graphElement instanceof NavigationEdge) {					// Always NavigationEdge
										for (@NonNull PropertyDatum propertyDatum : scheduleManager.getPropertyDatums((NavigationEdge)graphElement)) {
											if (allCheckedPropertyDatums.contains(propertyDatum)) {
												allCheckedPropertyDatumsContainsPropertyDatum = true;
											}
										}
									}
								}
							} */
							if (allCheckedPropertyDatumsContainsPropertyDatum && !observedProperties.contains(property)) {
								observedProperties.add(property);
							}
						}
						/*	else if (eObject instanceof OppositePropertyCallExp) {
							Property property = PivotUtil.getReferredProperty((NavigationCallExp) eObject).getOpposite();
							if (allCheckedProperties.contains(property) && !observedProperties.contains(property)) {
								observedProperties.add(property);
							}
						} */
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends Operation> @NonNull T createOperation(@NonNull T operation) {
		Operation newOperation = visitor.create(operation);
		assert newOperation != null;
		return (@NonNull T) newOperation;
	}

	/**
	 * Determine a traversal order for the old edges then synthesize the patttern matching statements.
	 */
	private void createPatternMatch() {
		OldEdgeSchedule oldSchedule = new OldEdgeSchedule();
		Iterable<@NonNull CheckedCondition> checkedConditions = oldSchedule.analyze();
		oldSchedule.synthesize(checkedConditions);
	}

	private void createPropertyAssignments(@NonNull Iterable<@NonNull NavigableEdge> sortedRealizedEdges) {
		StringBuilder s = TransformationPartitioner.PROPERTY_NOTIFY.isActive() ? new StringBuilder() : null;
		if (s != null) {
			s.append("[" + partition.getPassRangeText() + "] " + partition.getName());
		}
		Map<@NonNull Node, @NonNull List<@NonNull NavigationEdge>> classAssignments = null;
		for (@NonNull NavigableEdge edge : sortedRealizedEdges) {
			if ((edge instanceof NavigationEdge) && !(edge instanceof KeyPartEdge)) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				Node sourceNode = edge.getEdgeSource();
				Node targetNode = edge.getEdgeTarget();
				if (targetNode.isSuccess()) {}											// SuccessNode has a 'magic' automatic assignment
				else if (targetNode.isDataType()) {
					VariableDeclaration asVariable = getVariableDeclaration(sourceNode);
					Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
					QVTs2QVTiNodeVisitor expressionCreator = new QVTs2QVTiNodeVisitor(this);
					OCLExpression valueExp = expressionCreator.getExpression(targetNode);
					boolean isNotify = connectionManager.isHazardousWrite(s, navigationEdge);
					boolean isPartial = edge.isPartial();
					if (!sourceNode.isStrict()) {
						SetStatement setStatement = helper.createSetStatement(asVariable, property, valueExp, isPartial, isNotify);
						//					addObservedProperties(setStatement);
						mapping.getOwnedStatements().add(setStatement);
						addTrace(setStatement, edge);
					}
					else {
						assert !isPartial;
						//	assert !isNotify;
						NewStatement newStatement = (NewStatement)asVariable;
						NewStatementPart newStatementPart = helper.createNewStatementPart(property, valueExp);
						newStatement.getOwnedParts().add(newStatementPart);
						addTrace(newStatementPart, edge);
					}
				}
				else {
					if (classAssignments == null) {
						classAssignments = new HashMap<>();
					}
					List<@NonNull NavigationEdge> edges = classAssignments.get(sourceNode);
					if (edges == null) {
						edges = new ArrayList<>();
						classAssignments.put(sourceNode, edges);
					}
					edges.add(navigationEdge);
				}
			}
			else {
				// SharedEdge
			}
		}
		if (classAssignments != null) {
			pruneClassAssignments(classAssignments);
			Set<@NonNull NavigationEdge> classAssignmentEdges = new HashSet<>();
			for (@NonNull List<@NonNull NavigationEdge> values : classAssignments.values()) {
				classAssignmentEdges.addAll(values);
			}
			for (@NonNull NavigableEdge edge : sortedRealizedEdges) {
				if (classAssignmentEdges.contains(edge)) {
					createClassSetStatement(s, edge);
				}
			}
		}
		//		@SuppressWarnings("null")
		//		@NonNull EList<@NonNull Statement> statements = mapping.getOwnedStatements();
		//		ECollections.sort(statements, new StatementComparator(statements));
		if (s != null) {
			TransformationPartitioner.PROPERTY_NOTIFY.println(s.toString());
		}
	}

	/*	private void createRealizedIncludesAssignments() {
		List<@NonNull Edge> realizedIncludesEdges = null;
		for (@NonNull Edge edge : region.getRealizedEdges()) {
			//			if (QVTscheduleUtil.isRealizedIncludes(edge)) {
			//				if (realizedIncludesEdges == null) {
			//					realizedIncludesEdges = new ArrayList<>();
			//				}
			//				realizedIncludesEdges.add(edge);
			//			}
		}
		if (realizedIncludesEdges != null) {
			if (realizedIncludesEdges.size() > 1) {
				Collections.sort(realizedIncludesEdges, ToStringComparator.INSTANCE);
			}
			for (@NonNull Edge edge : realizedIncludesEdges) {
				Node sourceNode = edge.getEdgeSource();
				Node targetNode = edge.getEdgeTarget();
				/ *				if (targetNode.isDataType()) {
					OCLExpression slotVariableExp = createVariableExp(sourceNode);
					Property property = edge.getProperty();
					OCLExpression valueExp = expressionCreator.getExpression(targetNode);
					if (valueExp == null) {
						valueExp = expressionCreator.getExpression(targetNode);		// FIXME debugging
					}
					if (valueExp != null) {
						PropertyAssignment propertyAssignment = QVTimperativeUtil.createPropertyAssignment(slotVariableExp, property, valueExp);
						bottomPattern.getAssignment().add(propertyAssignment);
					}
					else {
						QVTruntimeUtil.errPrintln("No assignment in " + this + " to " + slotVariableExp + "." + property);
	 * /

			}
		}
	} */

	private void createRealizedVariables() {
		List<@NonNull Node> sortedNodes = Lists.newArrayList(partition.getPartialNodes());
		Collections.sort(sortedNodes,NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Node node : sortedNodes) {
			Role nodeRole = partition.getRole(node);
			if ((nodeRole != null) && nodeRole.isNew() && /*newNode.isPattern() &&*/ node.isClass()) {
				OCLExpression constructor = null;
				if (node.isOperation()) {
					if (node instanceof KeyedValueNode) {
						KeyedValueNode keyedValueNode = (KeyedValueNode)node;
						ClassDatum classDatum = keyedValueNode.getClassDatumValue();
						assert classDatum != null;
						Function function = visitor.getKeyFunction(classDatum);
						VariableExp thisExp = createContextVariableExp();
						Map<@NonNull PropertyDatum, @NonNull OCLExpression> propertyDatum2expression = new HashMap<>();
						for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
							if (edge instanceof KeyPartEdge) {
								KeyPartEdge keyPartEdge = (KeyPartEdge)edge;
								PropertyDatum propertyDatum = QVTscheduleUtil.getReferredPart(keyPartEdge);
								Node partNode = QVTscheduleUtil.getSourceNode(edge);
								OCLExpression partExpression = getExpression(partNode);
								propertyDatum2expression.put(propertyDatum, partExpression);
							}
						}
						List<@NonNull OCLExpression> asArguments = new ArrayList<>();
						for (@NonNull PropertyDatum propertyDatum : QVTscheduleUtil.getOwnedPropertyDatums(classDatum)) {
							if (propertyDatum.isKey()) {
								OCLExpression asArgument = propertyDatum2expression.get(propertyDatum);
								if (asArgument == null) {
									asArgument = helper.createInvalidExpression();
								}
								asArguments.add(asArgument);
							}
						}
						constructor = helper.createOperationCallExp(thisExp, function, asArguments);
						addTrace(constructor, node);
					}
					if (constructor == null) {
						QVTs2QVTiNodeVisitor expressionCreator = new QVTs2QVTiNodeVisitor(this);
						constructor = ((OperationCallExp)node.getOriginatingElement()).accept(expressionCreator);
						addTrace(constructor, node);
					}
				}
				ClassDatum classDatum = node.getClassDatum();
				TypedModel pTypedModel = classDatum.getReferredTypedModel();
				TypedModel iTypedModel = ClassUtil.nonNullState(visitor.getQVTiTypedModel(pTypedModel));
				NewStatement newStatement = helper.createNewStatement(getSafeName(node), iTypedModel, classDatum.getPrimaryClass());
				newStatement.setOwnedExpression(constructor);
				newStatement.setIsContained(node.isContained());
				mapping.getOwnedStatements().add(newStatement);
				addVariable(node, newStatement);
			}
		}
	}

	private @NonNull SpeculateStatement createSpeculateStatement(@NonNull Iterable<@NonNull OCLExpression> speculateExpressions, @NonNull Iterable<@NonNull Edge> speculatedEdges) {
		SpeculateStatement speculateStatement = helper.createSpeculateStatement(speculateExpressions);
		mapping.getOwnedStatements().add(speculateStatement);
		for (@NonNull Edge speculatedEdge : speculatedEdges) {
			addTrace(speculateStatement, speculatedEdge);
		}
		return speculateStatement;
	}

	private @NonNull OCLExpression createVariableExp(@NonNull Node node) {
		//	assert !node.isConditional();  -- permitted to avoid Set value expression hazards
		if (node.isNullLiteral()) {
			NullLiteralExp nullLiteralExp = helper.createNullLiteralExp();
			addTrace(nullLiteralExp, node);
			return nullLiteralExp;
		}
		VariableDeclaration variable = getVariableDeclaration(node);
		return PivotUtil.createVariableExp(variable);
	}

	/**
	 * Return the navigable edges that may be used by to locate nodes by this partition.
	 * The default implementation returns all old primary navigable edges
	 * and all already realized navigable edges
	 */
	protected @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges() {
		Set<@NonNull NavigableEdge> oldEdges = new HashSet<>();
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			assert !edge.isCast();
			Role edgeRole = partition.getRole(edge);
			assert edgeRole != null;
			if (edgeRole.isOld() && edge.isNavigation() /*&& edge.isUnconditional()*/) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Role sourceNodeRole = partition.getRole(sourceNode);
				assert sourceNodeRole != null;
				if (sourceNodeRole.isOld()){
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					Role targetNodeRole = partition.getRole(targetNode);
					assert targetNodeRole != null;
					if (targetNodeRole.isOld()) {
						oldEdges.add((NavigableEdge) edge);
					}
				}
			}
		}
		return oldEdges;
	}

	public @NonNull OCLExpression getExpression(@NonNull Node node) {
		VariableDeclaration variable = node2variable.get(node);
		if (variable == null) {
			QVTs2QVTiNodeVisitor expressionCreator = new QVTs2QVTiNodeVisitor(this);
			OCLExpression targetExpression = expressionCreator.getExpression(node);
			if (node.isConditional()) {
				return targetExpression;
			}
			variable = createDeclareStatement(node, targetExpression);
		}
		return helper.createVariableExp(variable);
	}

	@Override
	public @NonNull List<@NonNull Node> getGuardNodes() {
		return guardNodes;
	}

	@Override
	public @NonNull MappingParameter getGuardVariable(@NonNull Node node) {
		VariableDeclaration variable = node2variable.get(node);
		assert variable != null;
		return (MappingParameter) variable;
	}

	public @NonNull QVTimperativeHelper getHelper() {
		return helper;
	}

	public @NonNull Partition getPartition() {
		return partition;
	}

	public @NonNull Set<@NonNull Node> getPrecedingNodes(@NonNull Node targetNode) {
		Map<@NonNull Node, @NonNull Set<@NonNull Node>> node2precedingNodeClosure2 = node2precedingNodeClosure;
		if (node2precedingNodeClosure2 == null) {
			node2precedingNodeClosure = node2precedingNodeClosure2 = new HashMap<>();
		}
		Set<@NonNull Node> precedingNodes = node2precedingNodeClosure2.get(targetNode);
		if (precedingNodes == null) {
			precedingNodes = new HashSet<>();
			node2precedingNodeClosure2.put(targetNode, precedingNodes);
			precedingNodes.add(targetNode);
			for (@NonNull Node sourceNode : reachabilityForest.getPredecessorsClosure(targetNode)) {
				precedingNodes.addAll(getPrecedingNodes(sourceNode));
			}
		}
		assert precedingNodes.size() > 0;
		return precedingNodes;
	}

	public @NonNull QVTruntimeLibraryHelper getQVTruntimeLibraryHelper() {
		return scheduleManager.getQVTruntimeLibraryHelper();
	}

	public @NonNull ReachabilityForest getReachabilityForest() {
		return reachabilityForest;
	}

	protected @NonNull Iterable<@NonNull NavigableEdge> getSortedAssignments() {
		List<@NonNull NavigableEdge> navigableEdges = new ArrayList<>();
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (edge.isNavigation()) {
				Role edgeRole = partition.getRole(edge);
				if ((edgeRole != null) && edgeRole.isRealized()) {
					navigableEdges.add((NavigableEdge)edge);
				}
			}
		}
		return NavigationEdgeSorter.getSortedAssignments(navigableEdges);
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return scheduleManager.getStandardLibrary();
	}

	//	public @NonNull Transformation getTransformation() {
	//		return visitor.getTransformation();
	//	}

	protected @NonNull VariableDeclaration getVariableDeclaration(@NonNull Node node) {
		VariableDeclaration variable = node2variable.get(node);
		if (variable == null) {
			QVTs2QVTiNodeVisitor expressionCreator = new QVTs2QVTiNodeVisitor(this);
			OCLExpression targetExpression = expressionCreator.getExpression(node);
			variable = createDeclareStatement(node, targetExpression);
			//	LetVariable letVariable = helper.createLetVariable(node.getName(), targetExpression.getType(, targetExpression.isIsRequired());
			//	variable = helper.createLetExp(letVariable, targetExpression);
		}
		return variable;
	}

	/*	protected @NonNull VariableDeclaration getVariableDeclaration(@NonNull Node node) {
		return getSubexpressionDeclaration(node);
		/ *		VariableDeclaration variable = node2variable.get(node);
		if (variable == null) {
			ExpressionCreator expressionCreator = new ExpressionCreator();
			TypedElement typedElement = node.getTypedElements().iterator().next();
			OCLExpression initExpression = typedElement.accept(expressionCreator);
			variable = createDeclareStatement(node, initExpression);
		}
		return variable; * /
} */

	private boolean isInfallible() {
		PartitionedTransformationAnalysis partitionedTransformationAnalysis = regionAnalysis.getPartitionedTransformationAnalysis();
		FallibilityAnalysis fallibilityAnalysis = partitionedTransformationAnalysis.getFallibilityAnalysis(partition);
		return fallibilityAnalysis.isInfallible();
	}

	private boolean isTerminating() {
		PartitionedTransformationAnalysis partitionedTransformationAnalysis = regionAnalysis.getPartitionedTransformationAnalysis();
		FallibilityAnalysis fallibilityAnalysis = partitionedTransformationAnalysis.getFallibilityAnalysis(partition);
		return fallibilityAnalysis.isTerminating();
	}

	/**
	 * Filter classAssignments to retain only one of each opposite-property assignment pair.
	 */
	private void pruneClassAssignments(@NonNull Map<@NonNull Node, @NonNull List<@NonNull NavigationEdge>> classAssignments) {
		for (@NonNull Node sourceNode : new ArrayList<>(classAssignments.keySet())) {
			List<@NonNull NavigationEdge> forwardEdges = classAssignments.get(sourceNode);
			assert forwardEdges != null;
			for (int iForward = forwardEdges.size()-1; iForward >= 0; iForward--) {
				NavigationEdge forwardEdge = forwardEdges.get(iForward);
				Node targetNode = forwardEdge.getEdgeTarget();
				List<@NonNull NavigationEdge> reverseEdges = classAssignments.get(targetNode);
				if (reverseEdges != null) {
					for (int iReverse = reverseEdges.size()-1; iReverse >= 0; iReverse--) {
						NavigationEdge reverseEdge = reverseEdges.get(iReverse);
						if (sourceNode == reverseEdge.getEdgeTarget()) {
							Property forwardProperty = QVTscheduleUtil.getReferredProperty(forwardEdge);
							Property reverseProperty = QVTscheduleUtil.getReferredProperty(reverseEdge);
							if (forwardProperty.getOpposite() == reverseProperty) {
								if (forwardProperty.isIsImplicit()) {
									forwardEdges.remove(forwardEdge);
								}
								else if (reverseProperty.isIsImplicit()) {
									reverseEdges.remove(reverseEdge);
								}
								else if (sourceNode.isDependency()) {
									forwardEdges.remove(forwardEdge);
								}
								else if (targetNode.isDependency()) {
									reverseEdges.remove(reverseEdge);
								}
								else {		// FIXME do we prefer either direction ?
									reverseEdges.remove(reverseEdge);
								}
							}
						}
					}
				}
			}
		}
	}

	public void removeVariable(@NonNull Node node) {
		VariableDeclaration oldVariableDeclaration = node2variable.remove(node);
		assert oldVariableDeclaration != null;
	}

	@Override
	public void synthesizeCallStatements() {
		Map<@NonNull Partition, @NonNull Map<@NonNull Node, @NonNull Node>> calls = null;
		for (@NonNull Partition calledPartition : connectionManager.getCallableChildren(partition)) {
			if (calls == null) {
				calls = new HashMap<>();
			}
			Map<@NonNull Node, @NonNull Node> source2target = calls.get(calledPartition);
			if (source2target == null) {
				source2target = new HashMap<>();
				calls.put(calledPartition, source2target);
			}
			AbstractPartition2Mapping calledRegion2Mapping = visitor.getPartition2Mapping(calledPartition);
			for (@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
				for (@NonNull Node callingNode : connectionManager.getPassedBindingSources(calledGuardNode)) {
					if (partition.getRole(callingNode) != null) {
						Node oldNode = source2target.put(callingNode, calledGuardNode);
						assert oldNode == null;
					}
				}
				for (@NonNull Node callingNode : connectionManager.getUsedBindingSources(calledGuardNode)) {
					if (partition.getRole(callingNode) != null) {
						Node oldNode = source2target.put(callingNode, calledGuardNode);
						assert oldNode == null;
					}
				}
			}
		}
		if (calls != null) {
			createCallStatements(calls);
		}
	}

	/**
	 * Create all the statements that support the local content of this micromapping.
	 */
	@Override
	public void synthesizeLocalStatements() {
		createHeadAndGuardNodeVariables();				// BLUE/CYAN guard/append nodes
		createPatternMatch();							// BLUE/CYAN nodes and edges
		Iterable<@NonNull NavigableEdge> sortedRealizedEdges = getSortedAssignments();
		createAssignedValues(sortedRealizedEdges);		// Reify Variables for ends of GREEN edges
		createRealizedVariables();						// GREEN nodes
		createPropertyAssignments(sortedRealizedEdges);	// GREEN edges
		createAddStatements();							// export to append nodes
		//	createRealizedIncludesAssignments();
		checkTrace();
		createObservedProperties();						// wrap observable clauses around hazardous accesses
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(partition);
	}
}