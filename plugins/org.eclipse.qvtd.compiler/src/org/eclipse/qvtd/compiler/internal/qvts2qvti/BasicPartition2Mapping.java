/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.NumericLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.util.Visitable;
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
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
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
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.IfNode;
import org.eclipse.qvtd.pivot.qvtschedule.KeyPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Partition;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowNode;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;
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
						Integer sourceCost = reachabilityForest.getCost(sourceNode);
						Integer targetCost = reachabilityForest.getCost(targetNode);
						assert (sourceCost != null) && (targetCost != null);// && ((targetCost <= 0) || (sourceCost <= targetCost));
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
				Subexpression subexpression = node2subexpression.get(targetNode);
				if (subexpression != null) {
					for (@NonNull Node inputNode : subexpression.unconditionalInputNodes) {
						addNode(inputNode);
					}
					targetNode = subexpression.resultNode;
					addNode(targetNode);
				}
				Integer targetCost = reachabilityForest.getCost(targetNode);
				assert targetCost != null;
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(targetNode)) {
					Role edgeRole = partition.getRole(edge);
					if ((edgeRole != null) && edgeRole.isOld() && edge.isUnconditional()) {
						Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
						Integer sourceCost = reachabilityForest.getCost(sourceNode);
						assert sourceCost != null;
						if (sourceCost < targetCost) {
							addEdge(edge);
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
						createCheckStatement(exp);
					}
				}
			}
			Set<@NonNull CheckedCondition> checkedConditions = checkedConditionAnalysis.computeCheckedConditions();
			int checkableSize = checkedConditions.size();
			//			if (checkableSize > 0) {
			List<@NonNull CheckedCondition> sortedCheckedConditions = new ArrayList<>(checkedConditions);
			if (checkableSize > 1) {
				Collections.sort(sortedCheckedConditions, new CheckedConditionWeightComparator(BasicPartition2Mapping.this));
			}
			for (@NonNull CheckedCondition checkedCondition : sortedCheckedConditions) {
				Iterable<@NonNull Edge> edges = checkedCondition.getEdges();
				if (edges != null) {
					for (@NonNull Edge edge : edges) {
						addEdge(edge);
					}
				}
				Node node = checkedCondition.getNode();
				if (node != null) {
					addNode(node);
				}
			}
			//			}
			List<@NonNull Edge> residualEdges = null;
			for (@NonNull Edge edge : checkedConditionAnalysis.getOldUnconditionalEdges()) {
				if (!edge2subexpression.containsKey(edge)) {
					if (residualEdges == null) {
						residualEdges = new ArrayList<>();
					}
					residualEdges.add(edge);
				}
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
					createCheckStatement(checkExpression);
				}
				else {
					QVTruntimeUtil.errPrintln("Speculation code omitted for " + partition);
				}
			}
			else {
				createCheckStatement(checkExpression);
			}
		}

		public void synthesize(@NonNull Iterable<@NonNull CheckedCondition> checkedConditions) {
			for (@NonNull Edge edge : edgeSchedule) {
				assert partition.getRole(edge) != null;;
				assert edge.isUnconditional();
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				assert sourceNode.isUnconditional();
				Role sourceNodeRole = partition.getRole(sourceNode);
				if (sourceNodeRole != null) {
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					assert targetNode.isUnconditional();
					Role targetNodeRole = partition.getRole(targetNode);
					if (targetNodeRole != null) {
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
							if (targetNode.isNullLiteral()) {
								createCheckStatement(source2targetExp, "=", helper.createNullLiteralExp());
							}
							else if (targetNodeRole.isConstant() && !sourceNodeRole.isNew()) {
								//						createCheckStatement(source2targetExp);
								VariableDeclaration nodeVariable = node2variable.get(targetNode);
								/*if (nodeVariable == null) {
							VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
							createCheckStatement(targetVariableExp, "=", source2targetExp);
						}
						else*/ if (navigationEdge.isPartial()) {
							VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
							createCheckStatement(source2targetExp, "includes", targetVariableExp);
						}
						else if ((targetNode instanceof BooleanLiteralNode) && ((BooleanLiteralNode)targetNode).isBooleanValue()) {
							createConstantCheck(edge, source2targetExp);
						}
						else if (targetNodeRole == Role.CONSTANT_SUCCESS_TRUE) {
							createConstantCheck(edge, source2targetExp);
						}
						else if (nodeVariable == null) {
							Node2ExpressionCreator expressionCreator = new Node2ExpressionCreator(BasicPartition2Mapping.this);
							OCLExpression targetExpression = expressionCreator.getExpression(targetNode);
							assert targetExpression != null;
							createCheckStatement(source2targetExp, "=", targetExpression);
						}
						else {
							VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
							createCheckStatement(source2targetExp, "=", targetVariableExp);
						}
							}
							else {
								VariableDeclaration nodeVariable = node2variable.get(targetNode);
								if (nodeVariable == null) {
									createDeclareStatement(targetNode, source2targetExp);
									//	createCastPredicates(targetNode, declareStatement);
								}
								else if (navigationEdge.isPartial()) {
									VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
									createCheckStatement(source2targetExp, "includes", targetVariableExp);
								}
								else {
									VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
									createCheckStatement(targetVariableExp, "=", source2targetExp);
								}
							}
						}
						else if (edge instanceof PredicateEdge) {
							VariableExp sourceVariableExp = getSubexpressionVariableExp(sourceNode);
							if (!(targetNode instanceof BooleanLiteralNode)) {
								String edgeName = ClassUtil.nonNullState(edge.getName()).trim();
								if (edgeName.length() >= 2) {
									edgeName = edgeName.substring(1, edgeName.length()-1);		// Lose guillemets
								}
								if ("equals".equals(edgeName)) {
									edgeName = "=";								// FIXME regularize
								}
								VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
								createCheckStatement(sourceVariableExp, edgeName, targetVariableExp);
							}
							else if (((BooleanLiteralNode)targetNode).isBooleanValue()) {
								createConstantCheck(edge, sourceVariableExp);
							}
							else {
								createCheckStatement(sourceVariableExp, "=", helper.createBooleanLiteralExp(false));
							}
						}
						else if (edge instanceof ExpressionEdge) {
							getSubexpressionDeclaration(targetNode);
						}
					}
					else {
						// SharedEdge
					}
				}
			}
			List<@NonNull Subexpression> subexpressions = new ArrayList<>(resultNode2subexpression.values());
			Collections.sort(subexpressions);
			for (@NonNull Subexpression subexpression : subexpressions) {
				Role resultNodeRole = partition.getRole(subexpression.resultNode);
				if ((resultNodeRole != null) && !resultNodeRole.isNew() && subexpression.resultNode.isUnconditional()) {
					getSubexpressionDeclaration(subexpression.resultNode);
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

	private static class Node2ExpressionCreator extends AbstractExtendingQVTscheduleVisitor<@Nullable TypedElement, @NonNull BasicPartition2Mapping>
	{
		private static int depth = 0;

		protected final @NonNull QVTimperativeHelper helper;
		protected final @NonNull QVTruntimeLibraryHelper qvtruntimeLibraryHelper;

		protected Node2ExpressionCreator(@NonNull BasicPartition2Mapping context) {
			super(context);
			this.helper = context.getHelper();
			this.qvtruntimeLibraryHelper = context.getQVTruntimeLibraryHelper();
		}

		protected @NonNull OCLExpression create(@NonNull Node node) {
			return ClassUtil.nonNullState(getExpression(node));
		}

		protected @Nullable LoopExp doIterationCallNode(@NonNull OperationCallNode node) {
			Parameter loopSourceParameter = qvtruntimeLibraryHelper.getLoopSourceParameter();
			Parameter loopBodyParameter = qvtruntimeLibraryHelper.getLoopBodyParameter();
			Parameter loopIteratorsParameter = qvtruntimeLibraryHelper.getLoopIteratorsParameter();
			Iteration referredIteration = (Iteration)QVTscheduleUtil.getReferredOperation(node);
			OCLExpression sourceExp = null;
			OCLExpression bodyExp = null;
			List<@NonNull Parameter> iterators = QVTbaseUtil.Internal.getOwnedIteratorsList(referredIteration);
			//
			//	Synthesize source expression
			//
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge instanceof OperationParameterEdge) {
					OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
					Parameter referredParameter = operationParameterEdge.getReferredParameter();
					if (referredParameter == loopSourceParameter) {
						Node expNode = operationParameterEdge.getEdgeSource();
						OCLExpression nestedExp = getExpression(expNode);
						if (nestedExp == null) {
							return null;
						}
						sourceExp = nestedExp;
					}
				}
			}
			//
			//	Create iterator variables
			//
			assert sourceExp != null;
			Type sourceType = PivotUtil.getElementType((CollectionType)PivotUtil.getType(sourceExp));
			List<@NonNull Variable> variables = new ArrayList<>(iterators.size());
			for (int i = 0; i < iterators.size(); i++) {
				Parameter iterator = iterators.get(i);
				Variable variable = helper.createIteratorVariable(PivotUtil.getName(iterator), sourceType, sourceExp.isIsRequired());
				variables.add(variable);
			}
			//
			//	Add iterator variables to context for use by body.
			//
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge instanceof OperationParameterEdge) {
					OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
					Parameter referredParameter = operationParameterEdge.getReferredParameter();
					if (referredParameter == loopIteratorsParameter) {
						int index = operationParameterEdge.getParameterIndex();
						Node expNode = operationParameterEdge.getEdgeSource();
						context.addVariable(expNode, variables.get(index));
					}
				}
			}
			//
			//	Synthesize body expression
			//
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge instanceof OperationParameterEdge) {
					OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
					Parameter referredParameter = operationParameterEdge.getReferredParameter();
					if (referredParameter == loopBodyParameter) {
						Node expNode = operationParameterEdge.getEdgeSource();
						OCLExpression nestedExp = getExpression(expNode);
						if (nestedExp == null) {
							return null;
						}
						bodyExp = nestedExp;
					}
				}
			}
			assert bodyExp != null;
			//
			//	Remove iterator variables from context.
			//
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge instanceof OperationParameterEdge) {
					OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
					Parameter referredParameter = operationParameterEdge.getReferredParameter();
					if (referredParameter == loopIteratorsParameter) {
						Node expNode = operationParameterEdge.getEdgeSource();
						context.removeVariable(expNode);
					}
				}
			}
			return helper.createIteratorExp(sourceExp, referredIteration, variables, bodyExp);		// FIXME Bug 552827 IterateExp
		}

		protected @Nullable OperationCallExp doOperationCallNode(@NonNull OperationCallNode node) {
			Operation referredOperation = QVTscheduleUtil.getReferredOperation(node);
			OCLExpression sourceExp = null;
			List<@NonNull Parameter> parameters = QVTbaseUtil.Internal.getOwnedParametersList(referredOperation);
			List<@Nullable OCLExpression> argExps = new ArrayList<>(parameters.size());
			for (int i = 0; i < parameters.size(); i++) {
				argExps.add(null);
			}
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isExpression() && (edge instanceof OperationSelfEdge)) {
					OperationSelfEdge operationSelfEdge = (OperationSelfEdge)edge;
					Node expNode = operationSelfEdge.getEdgeSource();
					OCLExpression nestedExp = getExpression(expNode);
					if (nestedExp == null) {
						return null;
					}
					sourceExp = nestedExp;
				}
				else if (edge instanceof OperationParameterEdge) {
					OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
					Node expNode = operationParameterEdge.getEdgeSource();
					OCLExpression nestedExp = getExpression(expNode);
					if (nestedExp == null) {
						return null;
					}
					int index = parameters.indexOf(operationParameterEdge.getReferredParameter());
					if (0 <= index) {
						OCLExpression oldExpression = argExps.set(index, nestedExp);
						assert oldExpression == null;
					}
				}
			}
			for (OCLExpression exp : argExps) {
				if (exp == null) {
					return null;
				}
			}
			if ((sourceExp == null) && (referredOperation instanceof Function)) {
				sourceExp = context.createContextVariableExp();
			}
			//	if (referredOperation instanceof Function) {
			//		return helper.createFunctionCallExp(sourceExp, referredOperation, ClassUtil.nullFree(argExps));
			//	}
			//	else {
			return helper.createOperationCallExp(sourceExp, referredOperation, ClassUtil.nullFree(argExps));
			//	}
		}

		public @Nullable TypedElement doPatternNode(@NonNull Node node) {
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isExpression()) {
					Node expNode = edge.getEdgeSource();
					OCLExpression clonedElement = create(expNode);
					if (clonedElement instanceof VariableExp) {
						VariableDeclaration referredVariable = ((VariableExp)clonedElement).getReferredVariable();
						if (referredVariable instanceof Variable) {
							context.addVariable(node, referredVariable);
						}
					}
					return clonedElement;
				}
			}
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				assert !edge.isCast();
				if (edge.isNavigation()) {
					NavigationEdge navigationEdge = (NavigationEdge)edge;
					Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
					if (edgeRole == Role.LOADED) {
						OCLExpression source = getExpression(edge.getEdgeSource());
						if (source != null) {
							return helper.createNavigationCallExp(source, QVTscheduleUtil.getReferredProperty(navigationEdge));
						}
					}
					else if (edgeRole == Role.PREDICATED) {
						OCLExpression source = create(edge.getEdgeSource());
						return helper.createNavigationCallExp(source, QVTscheduleUtil.getReferredProperty(navigationEdge));
					}
				}
				else {
					// SharedEdge
				}
			}
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isExpression()) {
					OCLExpression source = create(edge.getEdgeSource());
					return source;
				}
			}
			return null;
		}

		public @Nullable OCLExpression getExpression(@NonNull Node node) {
			if (++depth > 25) {
				throw new IllegalStateException();
			}
			try {
				VariableDeclaration variable = context.basicGetVariable(node);
				if (variable != null) {
					assert !node.isNullLiteral();								// null should not be cached in a variable
					return PivotUtil.createVariableExp(variable);
				}
				if (node.isThis()) {			// ?? distinctive Node
					return context.createContextVariableExp();
				}
				return (OCLExpression) node.accept(this);
			}
			finally {
				--depth;
			}
		}

		@Override
		public @NonNull OCLExpression visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}

		@Override
		public @NonNull BooleanLiteralExp visitBooleanLiteralNode(@NonNull BooleanLiteralNode node) {
			return helper.createBooleanLiteralExp(node.isBooleanValue());
		}

		@Override
		public @NonNull CollectionLiteralExp visitCollectionLiteralNode(@NonNull CollectionLiteralNode node) {
			CollectionType asType = (CollectionType) node.getClassDatum().getPrimaryClass();
			final Map<@NonNull CollectionLiteralPart, @NonNull Integer> part2index = new HashMap<>();
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge instanceof CollectionPartEdge) {
					CollectionPartEdge collectionPartEdge = (CollectionPartEdge)edge;
					CollectionLiteralPart oldCollectionLiteralPart = collectionPartEdge.getReferredPart();
					CollectionLiteralExp oldCollectionLiteralExp = (CollectionLiteralExp) oldCollectionLiteralPart.eContainer();
					int index = oldCollectionLiteralExp.getOwnedParts().indexOf(oldCollectionLiteralPart);
					Node expNode = collectionPartEdge.getEdgeSource();
					OCLExpression nestedExp = getExpression(expNode);
					assert nestedExp != null;
					CollectionLiteralPart newCollectionLiteralPart = helper.createCollectionItem(nestedExp);
					part2index.put(newCollectionLiteralPart, index);
				}
			}
			List<@NonNull CollectionLiteralPart> asParts = new ArrayList<>(part2index.keySet());
			Collections.sort(asParts, new Comparator<@NonNull CollectionLiteralPart>() {
				@Override
				public int compare(@NonNull CollectionLiteralPart o1, @NonNull CollectionLiteralPart o2) {
					Integer i1 = part2index.get(o1);
					Integer i2 = part2index.get(o2);
					assert (i1 != null) && (i2 != null);
					return i1 - i2;
				}
			});
			return helper.createCollectionLiteralExp(asType, asParts);
		}

		@Override
		public @NonNull CollectionRange visitCollectionRangeNode(@NonNull CollectionRangeNode node) {
			Parameter rangeFirstParameter = qvtruntimeLibraryHelper.getRangeFirstParameter();
			Parameter rangeLastParameter = qvtruntimeLibraryHelper.getRangeLastParameter();
			OCLExpression asFirst = null;
			OCLExpression asLast = null;
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge instanceof OperationParameterEdge) {
					OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
					Parameter referredParameter = operationParameterEdge.getReferredParameter();
					if (referredParameter == rangeFirstParameter) {
						Node expNode = operationParameterEdge.getEdgeSource();
						asFirst = getExpression(expNode);
					}
					else if (referredParameter == rangeLastParameter) {
						Node expNode = operationParameterEdge.getEdgeSource();
						asLast = getExpression(expNode);
					}
				}
			}
			assert (asFirst != null) && (asLast != null);
			return helper.createCollectionRange(asFirst, asLast);
		}

		@Override
		public @Nullable OCLExpression visitEnumLiteralNode(@NonNull EnumLiteralNode node) {
			return helper.createEnumLiteralExp(QVTscheduleUtil.getEnumValue(node));
		}

		@Override
		public @Nullable IfExp visitIfNode(@NonNull IfNode node) {
			OCLExpression conditionExp = null;
			OCLExpression thenExp = null;
			OCLExpression elseExp = null;
			Parameter conditionParameter = qvtruntimeLibraryHelper.getIfConditionParameter();
			Parameter thenParameter = qvtruntimeLibraryHelper.getIfThenParameter();
			Parameter elseParameter = qvtruntimeLibraryHelper.getIfElseParameter();
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isExpression() && (edge instanceof OperationParameterEdge)) {
					OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
					Node expNode = operationParameterEdge.getEdgeSource();
					OCLExpression nestedExp = getExpression(expNode);
					if (nestedExp == null) {
						return null;
					}
					Parameter parameter = operationParameterEdge.getReferredParameter();
					if (parameter == conditionParameter) {
						conditionExp = nestedExp;
					}
					else if (parameter == thenParameter) {
						thenExp = nestedExp;
					}
					else if (parameter == elseParameter) {
						elseExp = nestedExp;
					}
				}
			}
			if ((conditionExp != null) && (thenExp != null) && (elseExp != null)) {
				return helper.createIfExp(conditionExp, thenExp, elseExp);
			}
			return null;
		}

		@Override
		public @NonNull NullLiteralExp visitNullLiteralNode(@NonNull NullLiteralNode node) {
			return helper.createNullLiteralExp();
		}

		@Override
		public @NonNull NumericLiteralExp visitNumericLiteralNode(@NonNull NumericLiteralNode node) {
			Number numericValue = ClassUtil.nonNullState(node.getNumericValue());
			if ((numericValue instanceof Byte) || (numericValue instanceof Integer) || (numericValue instanceof Long) || (numericValue instanceof Short)) {
				return helper.createIntegerLiteralExp(numericValue);
			}
			else {
				return helper.createRealLiteralExp(numericValue);
			}
		}

		@Override
		public @Nullable CallExp visitOperationCallNode(@NonNull OperationCallNode node) {
			Operation asOperation = node.getReferredOperation();
			if (asOperation instanceof Iteration) {
				LoopExp asIterationCallExp = doIterationCallNode(node);
				return asIterationCallExp;
			}
			else if (asOperation instanceof Function) {
				OperationCallExp asOperationCallExp = doOperationCallNode(node);
				if (asOperationCallExp != null) {
					Operation iOperation = context.createOperation(asOperation);
					if (iOperation != asOperation) {
						asOperationCallExp.setReferredOperation(iOperation);
					}
				}
				return asOperationCallExp;
			}
			else {
				return doOperationCallNode(node);
			}
		}

		@Override
		public @Nullable TypedElement visitPatternTypedNode(@NonNull PatternTypedNode node) {
			return doPatternNode(node);
		}

		@Override
		public @Nullable TypedElement visitPatternVariableNode(@NonNull PatternVariableNode node) {
			return doPatternNode(node);
		}

		@Override
		public @Nullable TypedElement visitShadowNode(@NonNull ShadowNode node) {
			List<@NonNull ShadowPart> asParts =new ArrayList<>();
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge instanceof ShadowPartEdge) {
					ShadowPartEdge shadowPartEdge = (ShadowPartEdge)edge;
					ShadowPart referredPart = QVTscheduleUtil.getReferredPart(shadowPartEdge);
					Property referredProperty = PivotUtil.getReferredProperty(referredPart);
					Node sourceNode = QVTscheduleUtil.getSourceNode(shadowPartEdge);
					asParts.add(helper.createShadowPart(referredProperty, create(sourceNode)));
				}
			};
			org.eclipse.ocl.pivot.@NonNull Class asClass = node.getClassDatum().getPrimaryClass();
			return helper.createShadowExp(asClass, asParts);
		}

		@Override
		public @NonNull OCLExpression visitStringLiteralNode(@NonNull StringLiteralNode node) {
			return helper.createStringLiteralExp(ClassUtil.nonNullState(node.getStringValue()));
		}

		@Override
		public @NonNull OCLExpression visitTypeLiteralNode(@NonNull TypeLiteralNode node) {
			return helper.createTypeExp(ClassUtil.nonNullState(node.getTypeValue()));
		}
	}

	private class Subexpression implements Comparable<@NonNull Subexpression>
	{
		/**
		 * The subexpression result
		 */
		private final @NonNull OperationNode resultNode;

		/**
		 * External nodes used within the subexpression
		 */
		private final @NonNull Set<@NonNull Node> inputNodes = new HashSet<>();

		/**
		 * External nodes used within the subexpression
		 */
		private final @NonNull Set<@NonNull Node> unconditionalInputNodes = new HashSet<>();

		/**
		 * Nodes within the subexpression
		 */
		private final @NonNull Set<@NonNull Node> contentNodes = new HashSet<>();

		private @Nullable Integer cost = null;

		public Subexpression(@NonNull OperationNode resultNode) {
			this.resultNode = resultNode;
			assert resultNode.isUnconditional();
		}

		public void analyze(@NonNull Set<@NonNull OperationNode> subexpressionResults) {
			computeSubexpressionContent(resultNode, subexpressionResults);
		}

		@Override
		public int compareTo(@NonNull Subexpression e2) {
			Subexpression e1 = this;
			int d1 = e1.getCost();
			int d2 = e2.getCost();
			if (d1 != d2) {
				return d1 - d2;
			}
			return ClassUtil.safeCompareTo(e1.resultNode.getDisplayName(), e2.resultNode.getDisplayName());
		}

		private void computeSubexpressionContent(@NonNull Node node, @NonNull Set<@NonNull OperationNode> subexpressionResults) {
			if (contentNodes.add(node)) {
				Role resultNodeRole = partition.getRole(resultNode);
				assert resultNodeRole != null;
				node2subexpression.put(node, this);
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
					Role edgeRole = partition.getRole(edge);
					if (edgeRole != null) {
						//					if (edge.isUnconditional()) {
						Node sourceNode = edge.getEdgeSource();
						Role sourceNodeRole = partition.getRole(sourceNode);
						if (sourceNodeRole != null) {
							if (subexpressionResults.contains(sourceNode)) {
								if (sourceNodeRole.isOld() || (!edge.isSecondary() && resultNodeRole.isNew())) {
									inputNodes.add(sourceNode);
									if (edge.isUnconditional() && sourceNode.isUnconditional()) {
										unconditionalInputNodes.add(sourceNode);
									}
									//							edge2subexpression.put(edge, this);
								}
							}
							else if (sourceNode.isExpression()) {
								node2subexpression.put(sourceNode, this);
								edge2subexpression.put(edge, this);
								computeSubexpressionContent(sourceNode, subexpressionResults);
							}
							else if (!sourceNode.isUnconditional()) {
								node2subexpression.put(sourceNode, this);
								edge2subexpression.put(edge, this);
								computeSubexpressionContent(sourceNode, subexpressionResults);
							}
							else {
								if (sourceNodeRole.isOld() || resultNodeRole.isNew()) {
									inputNodes.add(sourceNode);
									if (edge.isUnconditional() && sourceNode.isUnconditional()) {
										unconditionalInputNodes.add(sourceNode);
									}
									//							edge2subexpression.put(edge, this);
								}
							}
						}
						//					}
					}
				}
			}
		}

		public int getCost() {
			Integer cost2 = cost;
			if (cost2 == null) {
				cost2 = reachabilityForest.getCost(resultNode);
				if (cost2 == null) {			// Can happen for REALIZED results
					int inputCost = 0;
					for (@NonNull Node inputNode : inputNodes) {
						Subexpression inputSubexpression = resultNode2subexpression.get(inputNode);
						if (inputSubexpression != null) {
							inputCost = Math.max(inputCost, inputSubexpression.getCost()+1);
						}
					}
					cost2 = inputCost;
				}
				cost = cost2;
			}
			return cost2;
		}
		@Override
		public @NonNull String toString() {
			return String.valueOf(resultNode);
		}
	}

	protected final @NonNull RegionAnalysis regionAnalysis;

	/**
	 * Lazily computed closure of all preceding nodes, icluding the final node, of each node.
	 */
	private @Nullable Map<@NonNull Node, @NonNull Set<@NonNull Node>> node2precedingNodeClosure = null;

	/**
	 * Map from each subexpression result node to its contents.
	 */
	private final @NonNull Map<@NonNull OperationNode, @NonNull Subexpression> resultNode2subexpression;

	/**
	 * Map from each subexpression node to its contents.
	 */
	private final @NonNull Map<@NonNull Node, @NonNull Subexpression> node2subexpression = new HashMap<>();

	/**
	 * Map from each subexpression edge to its contents.
	 */
	private final @NonNull Map<@NonNull Edge, @NonNull Subexpression> edge2subexpression = new HashMap<>();

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
		StringBuilder s = TransformationPartitioner.PROPERTY_OBSERVE.isActive() ? new StringBuilder() : null;
		if (s != null) {
			s.append("[" + partition.getPassRangeText() + "] " + partition.getName());
		}
		checkedConditionAnalysis.computeCheckedProperties(s);
		if (s != null) {
			TransformationPartitioner.PROPERTY_OBSERVE.println(s.toString());
		}
		this.resultNode2subexpression = computeSubexpressions();
		//
		//	Gather the subexpression contents.
		//
		Set<@NonNull OperationNode> subexpressionResults = resultNode2subexpression.keySet();
		for (@NonNull Subexpression subexpression : resultNode2subexpression.values()) {
			subexpression.analyze(subexpressionResults);
		}
	}

	public void addVariable(@NonNull Node node, @NonNull VariableDeclaration variableDeclaration) {
		@SuppressWarnings("unused")
		VariableDeclaration oldVariableDeclaration = node2variable.put(node, variableDeclaration);
		// assert oldVariableDeclaration == null;   -- FIXME QVTc test overwrites
	}

	public @Nullable VariableDeclaration basicGetVariable(@NonNull Node node) {
		return node2variable.get(node);
	}

	/**
	 * Return all subexpressions and their content. A subexpression is an OperationNode whose value is consumed by
	 * one (or more) PatternNodes or by two (or more) OperationNodes.
	 */
	private @NonNull Map<@NonNull OperationNode, @NonNull Subexpression> computeSubexpressions() {
		Map<@NonNull OperationNode, @NonNull Subexpression> resultNode2subexpression = new HashMap<>();
		//
		//	Identify the subexpression result nodes
		//
		for (@NonNull Node node : partition.getPartialNodes()) {
			Role nodeRole = partition.getRole(node);
			if (nodeRole != null) {
				if (node.isOperation() && node.isUnconditional() && !node.isPrimitive()) {
					OperationNode resultNode = (OperationNode) node;
					Edge firstEdge = null;
					boolean isSubexpression = false;
					for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
						Role edgeRole = partition.getRole(edge);
						if ((edgeRole != null) && edgeRole.isNew() && !edge.isSecondary()) {
							Node edgeSource = edge.getSourceNode();
							if (edgeSource.isPattern()) {
								resultNode2subexpression.put(resultNode, new Subexpression(resultNode));
								isSubexpression = true;
								break;
							}
						}
					}
					if (!isSubexpression) {
						for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
							Role edgeRole = partition.getRole(edge);
							if (edgeRole != null) {
								Node edgeTarget = edge.getTargetNode();
								if (edgeTarget.isPattern() /*|| edgeTarget.isTrue()*/) {
									resultNode2subexpression.put(resultNode, new Subexpression(resultNode));
									break;
								}
								if (firstEdge == null) {
									firstEdge = edge;
								}
								else {
									resultNode2subexpression.put(resultNode, new Subexpression(resultNode));
									break;
								}
							}
						}
					}
				}
			}
		}
		return resultNode2subexpression;
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
				createAddStatement(connectionVariable, variableExpression);
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

	private @NonNull CheckStatement createCheckStatement(@NonNull OCLExpression booleanExpression) {
		CheckStatement checkStatement = helper.createCheckStatement(booleanExpression);
		mapping.getOwnedStatements().add(checkStatement);
		return checkStatement;
	}

	private @NonNull CheckStatement createCheckStatement(@NonNull OCLExpression firstExpression, @NonNull String operatorName, @NonNull OCLExpression secondExpression) {
		OCLExpression booleanExpression = helper.createOperationCallExp(firstExpression, operatorName, secondExpression);
		CheckStatement checkStatement = createCheckStatement(booleanExpression);
		return checkStatement;
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
			OCLExpression targetVariableExp;
			SetStatement setStatement;
			boolean isPartial;
			if (/*!isPartial &&*/ property.isIsImplicit()) {
				slotVariable = getVariable(targetNode);
				setProperty = QVTrelationUtil.getOpposite(property);
				targetVariableExp = createVariableExp(sourceNode);
				isPartial = setProperty.isIsMany();
			}
			else {
				slotVariable = getVariable(sourceNode);
				setProperty = property;
				targetVariableExp = createVariableExp(targetNode);
				isPartial = edge.isPartial();
			}
			if (!sourceNode.isStrict()) {
				setStatement = helper.createSetStatement(slotVariable, setProperty, targetVariableExp, isPartial, isNotify);
				mapping.getOwnedStatements().add(setStatement);
			}
			else {
				assert !property.isIsImplicit();
				assert !isPartial;
				assert !isNotify;
				NewStatement newStatement = (NewStatement)slotVariable;
				NewStatementPart newStatementPart = helper.createNewStatementPart(setProperty, targetVariableExp);
				newStatement.getOwnedParts().add(newStatementPart);
			}
		}
		else {
			// SharedEdge
		}
	}

	private @NonNull VariableExp createContextVariableExp() {
		StandardLibrary standardLibrary = getStandardLibrary();
		Transformation iTransformation = visitor.getImperativeTransformation();
		Transformation asTransformation = visitor.getOriginalTransformation();
		VariableDeclaration contextVariable = QVTbaseUtil.getContextVariable(standardLibrary, iTransformation, asTransformation);
		return helper.createVariableExp(contextVariable);
	}

	private @NonNull DeclareStatement createDeclareStatement(@NonNull Node node, @NonNull OCLExpression initExpression) {
		Type variableType = node.getClassDatum().getPrimaryClass();
		assert variableType != null;
		boolean isRequired = node.isMatched() && node.isRequired();
		if (initExpression.isIsRequired()) {
			isRequired = true;
		}
		String safeName = getSafeName(node);
		DeclareStatement newVariable = helper.createDeclareStatement(safeName, variableType, isRequired, initExpression);
		mapping.getOwnedStatements().add(newVariable);
		VariableDeclaration oldVariable = node2variable.put(node, newVariable);
		assert oldVariable == null;
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
		VariableDeclaration oldVariable = node2variable.put(guardNode, guardParameter);
		assert oldVariable == null;
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
			}
		}
		mapping.setIsStrict(isStrict);
		//
		//	Create any connectionVariable guards
		//
		createAppendParameters();
	}

	private void createObservedProperties() {
		Set<@NonNull Property> allCheckedProperties = checkedConditionAnalysis.getAllCheckedProperties();
		if (!allCheckedProperties.isEmpty()) {
			//
			// Ideally we could install each observed property as it is actually used. But
			// this needs to be coded in many places.
			//
			for (Statement asStatement : mapping.getOwnedStatements()) {
				if (asStatement instanceof ObservableStatement) {
					List<Property> observedProperties = ((ObservableStatement)asStatement).getObservedProperties();
					for (EObject eObject : new TreeIterable(asStatement, false)) {
						if (eObject instanceof PropertyCallExp) {
							Property property = PivotUtil.getReferredProperty((PropertyCallExp) eObject);
							if (allCheckedProperties.contains(property) && !observedProperties.contains(property)) {
								observedProperties.add(property);
							}
						}
						else if (eObject instanceof OppositePropertyCallExp) {
							Property property = PivotUtil.getReferredProperty((NavigationCallExp) eObject).getOpposite();
							if (allCheckedProperties.contains(property) && !observedProperties.contains(property)) {
								observedProperties.add(property);
							}
						}
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

	private void createPropertyAssignments() {
		StringBuilder s = TransformationPartitioner.PROPERTY_NOTIFY.isActive() ? new StringBuilder() : null;
		if (s != null) {
			s.append("[" + partition.getPassRangeText() + "] " + partition.getName());
		}
		Map<@NonNull Node, @NonNull List<@NonNull NavigationEdge>> classAssignments = null;
		List<@NonNull NavigableEdge> navigableEdges = new ArrayList<>();
		for (@NonNull Edge edge : partition.getPartialEdges()) {
			if (edge.isNavigation()) {
				Role edgeRole = partition.getRole(edge);
				if ((edgeRole != null) && edgeRole.isRealized()) {
					navigableEdges.add((NavigableEdge)edge);
				}
			}
		}
		Iterable<@NonNull NavigableEdge> sortedEdges = NavigationEdgeSorter.getSortedAssignments(navigableEdges);
		for (@NonNull NavigableEdge edge : sortedEdges) {
			if (edge instanceof NavigationEdge) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				Node sourceNode = edge.getEdgeSource();
				Node targetNode = edge.getEdgeTarget();
				if (targetNode.isSuccess()) {}											// SuccessNode has a 'magic' automatic assignment
				else if (targetNode.isDataType()) {
					VariableDeclaration asVariable = getVariable(sourceNode);
					Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
					Node2ExpressionCreator expressionCreator = new Node2ExpressionCreator(this);
					OCLExpression valueExp = expressionCreator.getExpression(targetNode);
					if (valueExp == null) {
						Node2ExpressionCreator expressionCreator2 = new Node2ExpressionCreator(this);
						valueExp = expressionCreator2.getExpression(targetNode);		// FIXME debugging
					}
					if (valueExp != null) {
						boolean isNotify = connectionManager.isHazardousWrite(s, navigationEdge);
						boolean isPartial = edge.isPartial();
						if (!sourceNode.isStrict()) {
							SetStatement setStatement = helper.createSetStatement(asVariable, property, valueExp, isPartial, isNotify);
							//					addObservedProperties(setStatement);
							mapping.getOwnedStatements().add(setStatement);
						}
						else {
							assert !isPartial;
							assert !isNotify;
							NewStatement newStatement = (NewStatement)asVariable;
							NewStatementPart newStatementPart = helper.createNewStatementPart(property, valueExp);
							newStatement.getOwnedParts().add(newStatementPart);
						}
					}
					else {
						QVTruntimeUtil.errPrintln("No assignment in " + this + " to " + asVariable + "." + property);
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
			for (@NonNull NavigableEdge edge : sortedEdges) {
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
				Node2ExpressionCreator expressionCreator = new Node2ExpressionCreator(this);
				OCLExpression constructor = null;
				if (node.isOperation()) {
					if (node instanceof KeyedValueNode) {
						KeyedValueNode keyedValueNode = (KeyedValueNode)node;
						ClassDatum classDatum = keyedValueNode.getClassDatumValue();
						assert classDatum != null;
						Function function = visitor.getKeyFunction(classDatum);
						VariableExp thisExp = createContextVariableExp();
						Map<@NonNull PropertyDatum, @NonNull VariableExp> propertyDatum2expression = new HashMap<>();
						for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
							if (edge instanceof KeyPartEdge) {
								KeyPartEdge keyPartEdge = (KeyPartEdge)edge;
								PropertyDatum propertyDatum = QVTscheduleUtil.getReferredPart(keyPartEdge);
								VariableExp subexpressionNode = getSubexpressionVariableExp(QVTscheduleUtil.getSourceNode(edge));
								propertyDatum2expression.put(propertyDatum, subexpressionNode);
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
					}
					if (constructor == null) {
						constructor = (OCLExpression) ((OperationCallExp)node.getOriginatingElement()).accept(expressionCreator);
					}
				}
				ClassDatum classDatum = node.getClassDatum();
				TypedModel pTypedModel = classDatum.getReferredTypedModel();
				TypedModel iTypedModel = ClassUtil.nonNullState(visitor.getQVTiTypedModel(pTypedModel));
				NewStatement newStatement = helper.createNewStatement(getSafeName(node), iTypedModel, classDatum.getPrimaryClass());
				newStatement.setOwnedExpression(constructor);
				newStatement.setIsContained(node.isContained());
				mapping.getOwnedStatements().add(newStatement);
				VariableDeclaration oldVariable = node2variable.put(node, newStatement);
				assert oldVariable == null;
			}
		}
	}

	private @NonNull OCLExpression createVariableExp(@NonNull Node node) {
		if (node.isNullLiteral()) {
			return helper.createNullLiteralExp();
		}
		else {
			VariableDeclaration variable = getVariable(node);
			return PivotUtil.createVariableExp(variable);
		}
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
			for (@NonNull Node sourceNode : reachabilityForest.getPredecessors(targetNode)) {
				precedingNodes.addAll(getPrecedingNodes(sourceNode));
			}
		}
		assert precedingNodes.size() > 0;
		return precedingNodes;
	}

	public @NonNull QVTruntimeLibraryHelper getQVTruntimeLibraryHelper() {
		return scheduleManager.getQVTruntimeLibraryHelper();
	}

	public @NonNull StandardLibrary getStandardLibrary() {
		return scheduleManager.getStandardLibrary();
	}

	private @NonNull VariableDeclaration getSubexpressionDeclaration(@NonNull Node node) {
		VariableDeclaration variable = node2variable.get(node);
		if (variable == null) {
			Node2ExpressionCreator expressionCreator = new Node2ExpressionCreator(this);
			OCLExpression targetExpression = expressionCreator.getExpression(node);
			assert targetExpression != null;
			variable = createDeclareStatement(node, targetExpression);
		}
		return variable;
	}

	private @NonNull VariableExp getSubexpressionVariableExp(@NonNull Node node) {
		return helper.createVariableExp(getSubexpressionDeclaration(node));
	}

	//	public @NonNull Transformation getTransformation() {
	//		return visitor.getTransformation();
	//	}

	protected @NonNull VariableDeclaration getVariable(@NonNull Node node) {
		return getSubexpressionDeclaration(node);
		/*		VariableDeclaration variable = node2variable.get(node);
		if (variable == null) {
			ExpressionCreator expressionCreator = new ExpressionCreator();
			TypedElement typedElement = node.getTypedElements().iterator().next();
			OCLExpression initExpression = typedElement.accept(expressionCreator);
			variable = createDeclareStatement(node, initExpression);
		}
		return variable; */
	}

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
		@SuppressWarnings("unused") String name = partition.getName();
		createHeadAndGuardNodeVariables();			// BLUE/CYAN guard/append nodes
		createPatternMatch();						// BLUE/CYAN nodes and edges
		createRealizedVariables();					// GREEN nodes
		createPropertyAssignments();				// GREEN edges
		createAddStatements();						// export to append nodes
		//	createRealizedIncludesAssignments();
		createObservedProperties();					// wrap observable clauses around hazardous accesses
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(partition);
	}
}