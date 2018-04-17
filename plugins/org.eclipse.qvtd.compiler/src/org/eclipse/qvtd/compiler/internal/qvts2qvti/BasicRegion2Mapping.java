/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.IteratorExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.OppositePropertyCallExp;
import org.eclipse.ocl.pivot.PrimitiveLiteralExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.PropertyCallExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StandardLibrary;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.TupleType;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.manager.PivotMetamodelManager;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.MetamodelManager;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.NameUtil.ToStringComparator;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.RegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.util.AbstractExtendingQVTbaseVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.CheckStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ConnectionVariable;
import org.eclipse.qvtd.pivot.qvtimperative.DeclareStatement;
import org.eclipse.qvtd.pivot.qvtimperative.GuardParameter;
import org.eclipse.qvtd.pivot.qvtimperative.ImperativeTypedModel;
import org.eclipse.qvtd.pivot.qvtimperative.LoopVariable;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameter;
import org.eclipse.qvtd.pivot.qvtimperative.MappingParameterBinding;
import org.eclipse.qvtd.pivot.qvtimperative.MappingStatement;
import org.eclipse.qvtd.pivot.qvtimperative.NewStatement;
import org.eclipse.qvtd.pivot.qvtimperative.ObservableStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SetStatement;
import org.eclipse.qvtd.pivot.qvtimperative.SimpleParameter;
import org.eclipse.qvtd.pivot.qvtimperative.Statement;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeUtil;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.ExpressionEdge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NodeConnection;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.PredicateEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Region;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class BasicRegion2Mapping extends AbstractRegion2Mapping
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
			this.scheduledNodes = Sets.newHashSet(QVTscheduleUtil.getHeadNodes(region));  // ?? leaf constants
		}

		private void addEdge(@NonNull Edge edge) {
			if (scheduledEdges.add(edge)) {
				Edge oppositeEdge = null;
				if (edge instanceof NavigableEdge) {
					oppositeEdge = ((NavigableEdge)edge).getOppositeEdge();
					if (oppositeEdge != null) {
						boolean wasAdded = scheduledEdges.add(oppositeEdge);
						assert wasAdded;
					}
				}
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (!sourceNode.isDependency() && !targetNode.isDependency()) {
					Integer sourceCost = reachabilityForest.getCost(sourceNode);
					Integer targetCost = reachabilityForest.getCost(targetNode);
					assert (sourceCost != null) && (targetCost != null);// && ((targetCost <= 0) || (sourceCost <= targetCost));
					addNode(sourceNode);
					addNode(targetNode);
					edgeSchedule.add(edge);
				}
			}
		}

		private void addNode(@NonNull Node targetNode) {
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
					if (edge.isOld() && edge.isUnconditional()) {
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

		public void analyze() {
			Set<@NonNull CheckedCondition> checkedConditions = computeCheckedConditions();
			int checkableSize = checkedConditions.size();
			if (checkableSize > 0) {
				List<@NonNull CheckedCondition> sortedCheckedConditions = new ArrayList<>(checkedConditions);
				if (checkableSize > 1) {
					Collections.sort(sortedCheckedConditions);
				}
				for (@NonNull CheckedCondition checkedCondition : sortedCheckedConditions) {
					for (@NonNull Edge edge : checkedCondition.getEdges()) {
						addEdge(edge);
					}
				}
			}
			List<@NonNull Edge> residualEdges = null;
			for (@NonNull Edge edge : oldUnconditionalEdges) {
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
		}

		/**
		 * Return all old edges that require a check for readiness or consistency.
		 */
		private @NonNull Set<@NonNull CheckedCondition> computeCheckedConditions() {
			Set<@NonNull Property> allCheckedProperties2 = allCheckedProperties;
			Set<@NonNull CheckedCondition> checkedConditions = new HashSet<>();
			Set<@NonNull NavigableEdge> checkedNavigableEdges = null;
			for (@NonNull Edge edge : oldUnconditionalEdges) {
				CheckedCondition checkedCondition = null;
				if (edge instanceof CastEdge) {
					checkedCondition = new CastEdgeCheckedCondition((CastEdge)edge);
				}
				else if (edge instanceof PredicateEdge) {
					checkedCondition = new PredicateEdgeCheckedCondition((PredicateEdge)edge);
				}
				else if ((edge instanceof NavigationEdge) && isCheckedNavigation((NavigationEdge)edge)) {
					computeOldUnconditionalEdges();
					checkedCondition = new PredicateNavigationEdgeCheckedCondition((NavigationEdge)edge);
				}
				else if (edge instanceof NavigableEdge) {
					NavigableEdge navigableEdge = (NavigableEdge)edge;
					if (allCheckedProperties2 != null) {
						NavigableEdge checkedEdge = QVTscheduleUtil.getPrimaryEdge(navigableEdge);
						NavigableEdge oppositeEdge = checkedEdge.getOppositeEdge();
						if (oppositeEdge != null) {
							Node sourceNode = QVTscheduleUtil.getSourceNode(checkedEdge);
							Node targetNode = QVTscheduleUtil.getTargetNode(checkedEdge);
							Integer sourceCost = reachabilityForest.getCost(sourceNode);
							Integer targetCost = reachabilityForest.getCost(targetNode);
							if ((sourceCost != null) && (targetCost != null) && (0 < targetCost) &&  (targetCost < sourceCost)) {
								checkedEdge = oppositeEdge;
							}
						}


						Property property = checkedEdge.getProperty();
						if (allCheckedProperties2.contains(property)) {
							if (checkedNavigableEdges == null) {
								checkedNavigableEdges = new HashSet<>();
							}
							if (checkedNavigableEdges.add(checkedEdge)) {
								checkedCondition = new NavigableEdgeCheckedCondition(checkedEdge);
							}
						}
					}
					if (checkedCondition == null) {
						Node targetNode = QVTscheduleUtil.getTargetNode(edge);
						if (edge.isPredicated() && targetNode.isConstant()) {
							checkedCondition = new ConstantTargetCheckedCondition((NavigableEdge)edge);
						}
						if ((checkedCondition == null) && edge.isOld()) {
							Property property = QVTscheduleUtil.getProperty(navigableEdge);
							CompleteClass edgeTargetCompleteClass = getMetamodelManager().getCompleteModel().getCompleteClass(QVTrelationUtil.getType(property));
							Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
							Integer sourceCost = reachabilityForest.getCost(sourceNode);
							Integer targetCost = reachabilityForest.getCost(targetNode);
							assert (sourceCost != null) && (targetCost != null);
							if (sourceCost < targetCost) {
								CompleteClass targetNodeCompleteClass = targetNode.getCompleteClass();
								if (!edgeTargetCompleteClass.conformsTo(targetNodeCompleteClass)) {
									checkedCondition = new CastEdgeCheckedCondition(navigableEdge);
								}
							}
						}
					}
				}
				if (checkedCondition != null) {
					checkedConditions.add(checkedCondition);
				}
			}
			//
			//	Multi-input nodes require a consistency check.
			//
			for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
				if (node.isOld() && node.isUnconditional()) {
					Integer targetCost = reachabilityForest.getCost(node);
					assert targetCost != null;
					if (node.isOld()) {
						Edge firstEdge = null;
						MultipleEdgeCheckedCondition checkedCondition = null;
						for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
							if (edge.isOld() && !edge.isExpression()) {		// FIXME why exclude expression?
								Integer sourceCost = reachabilityForest.getCost(QVTscheduleUtil.getSourceNode(edge));
								assert sourceCost != null;
								if (sourceCost <= targetCost) {
									if (firstEdge == null) {
										firstEdge = edge;
									}
									else if (checkedCondition == null){
										checkedCondition = new MultipleEdgeCheckedCondition(firstEdge, edge);
										checkedConditions.add(checkedCondition);
									}
									else {
										checkedCondition.addEdge(edge);
									}
								}
							}
						}
					}
				}
			}
			return checkedConditions;
		}

		private void createCastPredicates(@NonNull Node sourceNode, @NonNull VariableDeclaration sourceVariable) {
			for (@NonNull NavigableEdge edge : sourceNode.getNavigationEdges()) {
				if (edge.isCast() && edge.isUnconditional()) {
					Node targetNode = QVTscheduleUtil.getTargetNode(edge);
					Property castProperty = QVTscheduleUtil.getProperty(edge);
					Type targetType = PivotUtil.getType(castProperty);
					VariableExp sourceExpression = helper.createVariableExp(sourceVariable);
					VariableDeclaration targetVariable = node2variable.get(targetNode);
					if (targetVariable == null) {
						boolean isRequired = sourceVariable.isIsRequired();
						String safeName = getSafeName(PivotUtil.getName(sourceVariable));
						DeclareStatement declareStatement = helper.createDeclareStatement(safeName, targetType, isRequired, sourceExpression);
						declareStatement.setIsCheck(true);
						mapping.getOwnedStatements().add(declareStatement);
						targetVariable = declareStatement;
						node2variable.put(targetNode, targetVariable);
						createCastPredicates(targetNode, targetVariable);
					}
					else {
						createCheckStatement(sourceExpression, "oclIsKindOf", helper.createTypeExp(targetType));
					}
				}
			}
		}

		public void synthesize() {
			for (@NonNull Edge edge : edgeSchedule) {
				assert edge.isUnconditional();
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				assert sourceNode.isUnconditional();
				assert targetNode.isUnconditional();
				if (edge instanceof NavigableEdge) {
					NavigableEdge navigableEdge = (NavigableEdge)edge;
					Property property = QVTscheduleUtil.getProperty(navigableEdge);
					OCLExpression sourceExp = createVariableExp(sourceNode);
					Type sourceType = sourceExp.getType();
					Type requiredType = property.getOwningClass();
					if ((requiredType != null) && !sourceType.conformsTo(getMetamodelManager().getStandardLibrary(), requiredType)) {
						String castName = "cast_" + sourceNode.getName(); // FIXME BUG 530033 in a closed world this is always a fail
						DeclareStatement castStatement = createCheckedDeclareStatement(castName, sourceExp, requiredType);
						sourceExp = helper.createVariableExp(castStatement);
					}
					OCLExpression source2targetExp = createCallExp(sourceExp, property);
					if (targetNode.isExplicitNull()) {
						createCheckStatement(source2targetExp, "=", helper.createNullLiteralExp());
					}
					else if (targetNode.isConstant() && !sourceNode.isNew()) {
						//						createCheckStatement(source2targetExp);
						VariableDeclaration nodeVariable = node2variable.get(targetNode);
						/*if (nodeVariable == null) {
							VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
							createCheckStatement(targetVariableExp, "=", source2targetExp);
						}
						else*/ if (navigableEdge.isPartial()) {
							VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
							createCheckStatement(source2targetExp, "includes", targetVariableExp);
						}
						else if ((targetNode instanceof BooleanValueNode) && ((BooleanValueNode)targetNode).isBooleanValue()) {
							if (edge.isSpeculated()) {
								System.err.println("Speculation code omitted.");
							}
							else {
								createCheckStatement(source2targetExp);
							}
						}
						else if (nodeVariable == null) {
							ExpressionCreator expressionCreator = new ExpressionCreator(BasicRegion2Mapping.this);
							ExpressionCreator inlineExpressionCreator = expressionCreator.getInlineExpressionCreator();
							OCLExpression targetExpression = inlineExpressionCreator.getExpression(targetNode);
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
							DeclareStatement declareStatement = createDeclareStatement(targetNode, source2targetExp);
							createCastPredicates(targetNode, declareStatement);
						}
						else if (navigableEdge.isPartial()) {
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
					if (!(targetNode instanceof BooleanValueNode)) {
						String edgeName = ClassUtil.nonNullState(edge.getName()).trim();
						if (edgeName.length() >= 2) {
							edgeName = edgeName.substring(1, edgeName.length()-1);		// Lose guillemets
						}
						VariableExp targetVariableExp = getSubexpressionVariableExp(targetNode);
						createCheckStatement(sourceVariableExp, edgeName, targetVariableExp);
					}
					else if (((BooleanValueNode)targetNode).isBooleanValue()) {
						if (edge.isSpeculated()) {
							System.err.println("Speculation code omitted.");
						}
						else {
							createCheckStatement(sourceVariableExp);
						}
					}
					else {
						createCheckStatement(sourceVariableExp, "=", helper.createBooleanLiteralExp(false));
					}
				}
				else if (edge instanceof ExpressionEdge) {
					getSubexpressionDeclaration(targetNode);
				}
			}
			List<@NonNull Subexpression> subexpressions = new ArrayList<>(resultNode2subexpression.values());
			Collections.sort(subexpressions);
			for (@NonNull Subexpression subexpression : subexpressions) {
				if (!subexpression.resultNode.isNew() && subexpression.resultNode.isUnconditional()) {
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


	private static class ExpressionCreator extends AbstractExtendingQVTbaseVisitor<@NonNull OCLExpression, @NonNull BasicRegion2Mapping>
	{
		protected final @NonNull QVTimperativeHelper helper;
		protected final @NonNull Set<@NonNull Node> multiAccessedNodes = new HashSet<>();
		protected final @NonNull Set<@NonNull Node> conditionalNodes = new HashSet<>();

		private /*@LazyNonNull*/ ExpressionCreator inlineExpressionCreator = null;

		public ExpressionCreator(@NonNull BasicRegion2Mapping context) {
			super(context);
			this.helper = context.getHelper();
			analyzeExpressions(multiAccessedNodes, conditionalNodes);
		}

		/**
		 * Compute the nodes that are only evaluated if a run-time if-condition is satisfied, and the nodes that are always accessed more than once.
		 */
		private void analyzeExpressions(@NonNull Set<Node> multiAccessedNodes, @NonNull Set<Node> conditionalNodes) {
			Set<@NonNull Node> unconditionalNodes = new HashSet<>();
			for (@NonNull Edge edge : context.getRegion().getRealizedEdges()) {
				analyzeIncomingPath(edge.getEdgeTarget(), unconditionalNodes, conditionalNodes, false);
			}
			conditionalNodes.removeAll(unconditionalNodes);
			for (@NonNull Node node : unconditionalNodes) {
				int accesses = 0;
				for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(node)) {
					if (outgoingEdge.isNavigation() || outgoingEdge.isComputation()) {
						accesses++;
					}
				}
				if (accesses > 1) {
					multiAccessedNodes.add(node);
				}
			}
		}

		private void analyzeIncomingPath(@NonNull Node node, @NonNull Set<Node> unconditionalNodes, @NonNull Set<Node> conditionalNodes, boolean isConditional) {
			if ((isConditional ? conditionalNodes : unconditionalNodes).add(node)) {
				boolean isIf = context.isIfExp(node);
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
					if (edge.isComputation()) {
						boolean isIfThenOrElse = isIf && ("then".equals(edge.getName()) || "else".equals(edge.getName()));
						analyzeIncomingPath(edge.getEdgeSource(), unconditionalNodes, conditionalNodes, isConditional || isIfThenOrElse);
					}
					else if (edge.isNavigation()) {
						analyzeIncomingPath(edge.getEdgeSource(), unconditionalNodes, conditionalNodes, isConditional);
					}
				}
				return;
			}
		}

		protected @NonNull OCLExpression create(/*@NonNull*/ Node node) {
			if (node.isExplicitNull()) {
				return helper.createNullLiteralExp();
			}
			VariableDeclaration theVariable = context.basicGetVariable(node);
			if (theVariable == null) {
				TypedElement oldTypedElement = node.getTypedElements().iterator().next();
				assert oldTypedElement != null;
				OCLExpression initExpression = oldTypedElement.accept(this);
				assert initExpression != null;
				//				Type type = newExpression.getType();
				//				assert type != null;
				//				theVariable = PivotUtil.createVariable(getSafeName(node), type, true, newExpression);
				//				mapping.getBottomPattern().getVariable().add(theVariable);
				//				node2variable.put(node, theVariable);
				if ((initExpression instanceof PrimitiveLiteralExp) || hasRealizedVariableReference(initExpression) || conditionalNodes.contains(node)) {
					return initExpression;
				}
				theVariable = context.createDeclareStatement(node, initExpression);

			}
			return PivotUtil.createVariableExp(theVariable);
		}

		private @Nullable OCLExpression create(@Nullable OCLExpression oldTypedElement) {
			if (oldTypedElement == null) {
				return null;
			}
			Node node = context.getNode(oldTypedElement);
			if (node == null) {
				node = context.getNode(oldTypedElement);		// FIXME debugging
			}
			if (node != null) {
				return create(node);
			}
			else {
				return oldTypedElement.accept(this);
			}
		}

		private @NonNull List<@NonNull OCLExpression> createAll(@NonNull List<@NonNull OCLExpression> oldTypedElements) {
			List<@NonNull OCLExpression> newTypedElements = new ArrayList<>(oldTypedElements.size());
			for (@NonNull OCLExpression oldTypedElement : oldTypedElements) {
				OCLExpression newTypedElement = create(oldTypedElement);
				assert newTypedElement != null;
				newTypedElements.add(newTypedElement);
			}
			return newTypedElements;
		}

		private @NonNull Variable createIteratorVariable(@NonNull Variable oldVariable) {
			String name = oldVariable.getName();
			assert name != null;
			Type type = oldVariable.getType();
			assert type != null;
			assert oldVariable.getOwnedInit() == null;
			Variable newVariable = helper.createIteratorVariable(name, type, oldVariable.isIsRequired());
			Node variableNode = context.getNode(oldVariable);
			if (variableNode != null) {
				context.addVariable(variableNode, newVariable);
			}
			return newVariable;
		}

		private @NonNull List<@NonNull Variable> createIteratorVariables(@NonNull List<@NonNull Variable> oldVariables) {
			List<@NonNull Variable> newVariables = new ArrayList<>(oldVariables.size());
			for (@NonNull Variable oldVariable : oldVariables) {
				Variable newVariable = createIteratorVariable(oldVariable);
				newVariables.add(newVariable);
			}
			return newVariables;
		}

		private @NonNull Variable createLetVariable(@NonNull Variable oldVariable) {
			String name = oldVariable.getName();
			assert name != null;
			Type type = oldVariable.getType();
			assert type != null;
			OCLExpression newInit = ClassUtil.nonNullState(create(oldVariable.getOwnedInit()));
			Variable newVariable = helper.createLetVariable(name, type, oldVariable.isIsRequired(), newInit);
			Node variableNode = context.getNode(oldVariable);
			if (variableNode != null) {
				context.addVariable(variableNode, newVariable);
			}
			return newVariable;
		}

		private @NonNull OCLExpression createNonNull(@Nullable OCLExpression oldTypedElement) {
			assert oldTypedElement != null;
			Node node = context.getNode(oldTypedElement);
			if (node == null) {
				node = context.getNode(oldTypedElement);		// FIXME debugging
			}
			return create(node);
		}

		private @Nullable OCLExpression createOperationCallExp(@NonNull OperationId operationId, @NonNull OperationNode operationNode) {
			OCLExpression asSourceExpression = null;
			List<@NonNull OCLExpression> asArgumentExpressions = new ArrayList<>();
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(operationNode)) {
				if (edge instanceof ExpressionEdge) {
					Node sourceNode = QVTscheduleUtil.getSourceNode(edge);	// FIXME ordering/naming/other edges
					OCLExpression asExpression = getExpression(sourceNode);
					assert asExpression != null;
					if (asSourceExpression == null) {
						asSourceExpression = asExpression;
					}
					else {
						asArgumentExpressions.add(asExpression);
					}
				}
			}
			assert asSourceExpression != null;
			@NonNull OCLExpression[] asArguments = asArgumentExpressions.toArray(new @NonNull OCLExpression[asArgumentExpressions.size()]);
			return helper.createOperationCallExp(asSourceExpression, operationId.getName(), asArguments);
		}

		private @NonNull Variable createResultVariable(@NonNull Variable oldVariable) {
			String name = oldVariable.getName();
			assert name != null;
			Type type = oldVariable.getType();
			assert type != null;
			OCLExpression newInit = ClassUtil.nonNullState(create(oldVariable.getOwnedInit()));
			Variable newVariable = helper.createResultVariable(name, type, oldVariable.isIsRequired(), newInit);
			Node variableNode = context.getNode(oldVariable);
			if (variableNode != null) {
				context.addVariable(variableNode, newVariable);
			}
			return newVariable;
		}

		public @Nullable OCLExpression getExpression(@NonNull Node node) {
			if (node.isExplicitNull()) {
				return helper.createNullLiteralExp();
			}
			VariableDeclaration variable = context.basicGetVariable(node);
			if (variable != null) {
				return PivotUtil.createVariableExp(variable);
			}
			if (node instanceof BooleanValueNode) {
				BooleanValueNode booleanValueNode = (BooleanValueNode)node;
				boolean booleanValue = booleanValueNode.isBooleanValue();
				return helper.createBooleanLiteralExp(booleanValue);
			}
			if (node instanceof OperationValueNode) {
				OperationValueNode operationIdValueNode = (OperationValueNode)node;
				Operation operationValue = operationIdValueNode.getOperationValue();
				return createOperationCallExp(operationValue.getOperationId(), operationIdValueNode);
			}
			if (node.isOperation()) {
				if (node instanceof BooleanValueNode) {
					return helper.createBooleanLiteralExp(((BooleanValueNode)node).isBooleanValue());
				}
				else {
					Iterable<@NonNull TypedElement> typedElements = node.getTypedElements();
					assert Iterables.size(typedElements) >= 1;
					return typedElements.iterator().next().accept(getInlineExpressionCreator());
				}

			}
			for (@NonNull Edge edge : node.getArgumentEdges()) {
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
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
				if (edge.isNavigation()) {
					Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
					if (edgeRole == Role.LOADED) {
						OCLExpression source = getExpression(edge.getEdgeSource());
						if (source != null) {
							return helper.createNavigationCallExp(source, QVTscheduleUtil.getProperty((NavigableEdge)edge));
						}
					}
					else if (edgeRole == Role.PREDICATED) {
						OCLExpression source = create(edge.getEdgeSource());
						return helper.createNavigationCallExp(source, QVTscheduleUtil.getProperty((NavigableEdge)edge));
					}
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

		public @NonNull ExpressionCreator getInlineExpressionCreator() {
			ExpressionCreator inlineExpressionCreator2 = inlineExpressionCreator ;
			if (inlineExpressionCreator2 == null) {
				inlineExpressionCreator = inlineExpressionCreator2 = new InlineExpressionCreator(context);
			}
			return inlineExpressionCreator2;
		}

		private boolean hasRealizedVariableReference(@NonNull OCLExpression oclExpression) {
			for (TreeIterator<EObject> tit = oclExpression.eAllContents(); tit.hasNext(); ) {
				EObject eObject = tit.next();
				if (eObject instanceof VariableExp) {
					if (((VariableExp)eObject).getReferredVariable() instanceof NewStatement) {
						return true;
					}
				}
			}
			return false;
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + " " + context.getRegion();
		}

		@Override
		public @NonNull OCLExpression visiting(@NonNull Visitable visitable) {
			throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
		}



		//		public boolean isConditional(@NonNull Node node) {
		//			return conditionalNodes.contains(node);
		//		}

		@Override
		public @NonNull OCLExpression visitCollectionLiteralExp(@NonNull CollectionLiteralExp pCollectionLiteralExp) {
			List<@NonNull CollectionLiteralPart> clonedParts = new ArrayList<>();
			for (@NonNull CollectionLiteralPart pPart : ClassUtil.nullFree(pCollectionLiteralExp.getOwnedParts())) {
				if (pPart instanceof CollectionItem) {
					OCLExpression item = createNonNull(((CollectionItem)pPart).getOwnedItem());
					clonedParts.add(helper.createCollectionItem(item));
				}
				else {
					CollectionRange pCollectionRange = (CollectionRange)pPart;
					OCLExpression first = createNonNull(pCollectionRange.getOwnedFirst());
					OCLExpression last = createNonNull(pCollectionRange.getOwnedLast());
					clonedParts.add(helper.createCollectionRange(first, last));
				}
			}
			CollectionType collectionType = (CollectionType)pCollectionLiteralExp.getType();
			assert collectionType != null;
			return helper.createCollectionLiteralExp(collectionType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitEnumLiteralExp(@NonNull EnumLiteralExp pEnumLiteralExp) {
			return EcoreUtil.copy(pEnumLiteralExp);
		}

		@Override
		public @NonNull OCLExpression visitIfExp(@NonNull IfExp pIfExp) {
			MetamodelManager metamodelManager = helper.getEnvironmentFactory().getMetamodelManager();
			ExpressionCreator inlineExpressionCreator = getInlineExpressionCreator();
			return ((PivotMetamodelManager)metamodelManager).createIfExp(createNonNull(pIfExp.getOwnedCondition()),
				inlineExpressionCreator.createNonNull(pIfExp.getOwnedThen()),
				inlineExpressionCreator.createNonNull(pIfExp.getOwnedElse()));
		}

		@Override
		public @NonNull OCLExpression visitIterateExp(@NonNull IterateExp pIterateExp) {
			OCLExpression iSource = create(pIterateExp.getOwnedSource());
			assert iSource != null;
			List<@NonNull ? extends Variable> iIterators = createIteratorVariables(ClassUtil.nullFree(pIterateExp.getOwnedIterators()));
			Variable result = createResultVariable(ClassUtil.nonNull(pIterateExp.getOwnedResult()));
			Iteration referredIteration = context.createOperation(QVTrelationUtil.getReferredIteration(pIterateExp));
			assert referredIteration != null;
			OCLExpression iBody = getInlineExpressionCreator().create(pIterateExp.getOwnedBody());
			assert iBody != null;
			return helper.createIterateExp(iSource, referredIteration, iIterators, result, iBody);
		}

		@Override
		public @NonNull OCLExpression visitIteratorExp(@NonNull IteratorExp pIteratorExp) {
			OCLExpression iSource = create(pIteratorExp.getOwnedSource());
			assert iSource != null;
			List<@NonNull ? extends Variable> iIterators = createIteratorVariables(ClassUtil.nullFree(pIteratorExp.getOwnedIterators()));
			Iteration referredIteration = context.createOperation(QVTrelationUtil.getReferredIteration(pIteratorExp));
			assert referredIteration != null;
			OCLExpression iBody = getInlineExpressionCreator().create(pIteratorExp.getOwnedBody());
			assert iBody != null;
			return helper.createIteratorExp(iSource, referredIteration, iIterators, iBody);
		}

		@Override
		public @NonNull OCLExpression visitLetExp(@NonNull LetExp pLetExp) {
			Variable asVariable = createLetVariable(ClassUtil.nonNull(pLetExp.getOwnedVariable()));
			OCLExpression asInExpression = create(pLetExp.getOwnedIn());
			assert asInExpression != null;
			return helper.createLetExp(asVariable, asInExpression);
		}

		@Override
		public @NonNull OCLExpression visitMapLiteralExp(@NonNull MapLiteralExp pMapLiteralExp) {
			List<@NonNull MapLiteralPart> clonedParts = new ArrayList<>();
			for (@NonNull MapLiteralPart pPart : ClassUtil.nullFree(pMapLiteralExp.getOwnedParts())) {
				OCLExpression key = createNonNull(pPart.getOwnedKey());
				OCLExpression value = createNonNull(pPart.getOwnedValue());
				clonedParts.add(helper.createMapLiteralPart(key, value));
			}
			MapType mapType = (MapType)pMapLiteralExp.getType();
			assert mapType != null;
			return helper.createMapLiteralExp(mapType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitOperationCallExp(@NonNull OperationCallExp pOperationCallExp) {
			OCLExpression iSource = create(pOperationCallExp.getOwnedSource());
			List<@NonNull OCLExpression> iArguments = createAll(ClassUtil.nullFree(pOperationCallExp.getOwnedArguments()));
			Operation referredOperation = context.createOperation(QVTrelationUtil.getReferredOperation(pOperationCallExp));
			assert referredOperation != null;
			if ((iSource == null) && (referredOperation instanceof Function)) {
				StandardLibrary standardLibrary = helper.getEnvironmentFactory().getStandardLibrary();
				VariableDeclaration thisVariable = QVTbaseUtil.getContextVariable(standardLibrary, context.getTransformation());
				iSource = PivotUtil.createVariableExp(thisVariable);
			}
			return helper.createOperationCallExp(iSource, referredOperation, iArguments);
		}

		@Override
		public @NonNull OCLExpression visitNavigationCallExp(@NonNull NavigationCallExp pNavigationCallExp) {
			OCLExpression iSource = createNonNull(pNavigationCallExp.getOwnedSource());
			Property referredProperty = PivotUtil.getReferredProperty(pNavigationCallExp);
			return helper.createNavigationCallExp(iSource, referredProperty);
		}

		@Override
		public @NonNull OCLExpression visitPrimitiveLiteralExp(@NonNull PrimitiveLiteralExp pPrimitiveLiteralExp) {
			return EcoreUtil.copy(pPrimitiveLiteralExp);
		}

		@Override
		public @NonNull OCLExpression visitShadowExp(@NonNull ShadowExp pShadowExp) {
			List<@NonNull ShadowPart> clonedParts = new ArrayList<>();
			for (@NonNull ShadowPart pPart : ClassUtil.nullFree(pShadowExp.getOwnedParts())) {
				OCLExpression init = createNonNull(pPart.getOwnedInit());
				String name = pPart.getName();
				Type type = pPart.getType();
				assert (name != null) && (type != null);
				Property referredProperty = pPart.getReferredProperty();
				assert referredProperty != null;
				clonedParts.add(helper.createShadowPart(referredProperty, init));
			}
			org.eclipse.ocl.pivot.Class shadowType = pShadowExp.getType();
			assert shadowType != null;
			return helper.createShadowExp(shadowType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitTupleLiteralExp(@NonNull TupleLiteralExp pTupleLiteralExp) {
			List<@NonNull TupleLiteralPart> clonedParts = new ArrayList<>();
			for (@NonNull TupleLiteralPart pPart : ClassUtil.nullFree(pTupleLiteralExp.getOwnedParts())) {
				OCLExpression init = createNonNull(pPart.getOwnedInit());
				String name = pPart.getName();
				Type type = pPart.getType();
				assert (name != null) && (type != null);
				clonedParts.add(helper.createTupleLiteralPart(name, type, pPart.isIsRequired(), init));
			}
			TupleType tupleType = (TupleType)pTupleLiteralExp.getType();
			assert tupleType != null;
			return helper.createTupleLiteralExp(tupleType, clonedParts);
		}

		@Override
		public @NonNull OCLExpression visitTypeExp(@NonNull TypeExp pTypeExp) {
			Type referredType = pTypeExp.getReferredType();
			assert referredType != null;
			return helper.createTypeExp(referredType);
		}

		//		@Override		-- should not be invoked; results in use of input not output variable
		//		public @NonNull OCLExpression visitVariable(@NonNull Variable pVariable) {
		//			return helper.createVariableExp(pVariable);
		//		}

		@Override
		public @NonNull OCLExpression visitVariableExp(@NonNull VariableExp pVariableExp) {
			VariableDeclaration pVariable = pVariableExp.getReferredVariable();
			Node node = context.getNode(pVariable);
			if (node == null) {
				StandardLibrary standardLibrary = helper.getEnvironmentFactory().getStandardLibrary();
				Transformation pTransformation = QVTbaseUtil.getContainingTransformation(pVariableExp);
				Variable pThisVariable = QVTbaseUtil.getContextVariable(standardLibrary, pTransformation);
				if (pVariableExp.getReferredVariable() == pThisVariable) {
					VariableDeclaration iThisVariable = QVTbaseUtil.getContextVariable(standardLibrary, context.getTransformation());
					return PivotUtil.createVariableExp(iThisVariable);
				}
			}
			if (node != null) {
				VariableDeclaration iVariable = context.basicGetVariable(node);
				assert iVariable != null;
				return PivotUtil.createVariableExp(iVariable);
			}
			else {
				System.err.println("Creating unexpected variable for " + pVariable + " in " + context.getRegion());
				Type variableType = pVariable.getType();
				assert variableType != null;
				String safeName = context.getSafeName(ClassUtil.nonNullState(pVariable.getName()));
				DeclareStatement iVariable = helper.createDeclareStatement(safeName, variableType, pVariable.isIsRequired(), helper.createNullLiteralExp());
				context.getMapping().getOwnedStatements().add(iVariable);
				//				Variable oldVariable = node2variable.put(node, iVariable);
				//				assert oldVariable == null;
				return PivotUtil.createVariableExp(iVariable);
			}
		}
	}

	private static class InlineExpressionCreator extends ExpressionCreator
	{
		private int debugDepth = 0;

		private InlineExpressionCreator(@NonNull BasicRegion2Mapping context) {
			super(context);
		}

		@Override
		public @NonNull OCLExpression create(/*@NonNull*/ Node node) {
			try {
				if (++debugDepth > 100) {
					throw new UnsupportedOperationException();
				}
				if (node.isExplicitNull()) {
					return helper.createNullLiteralExp();
				}
				VariableDeclaration theVariable = context.basicGetVariable(node);
				if (theVariable != null) {
					return PivotUtil.createVariableExp(theVariable);
				}
				TypedElement oldTypedElement = node.getTypedElements().iterator().next();		// FIXME This fallback should be obsolete
				assert oldTypedElement != null;
				if (oldTypedElement instanceof Variable) {
					Variable variable = (Variable)oldTypedElement;
					OCLExpression ownedInit = variable.getOwnedInit();
					if (ownedInit == null) {
						for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {		// FIXME this can pick a downstream rather than upstream edge
							if (edge.isExpression() && QVTscheduleConstants.EQUALS_NAME.equals(edge.getName())) {
								Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
								return create(sourceNode); //createBottomVariable(node, helper.createNullLiteralExp());		// FIXME is this possible?
							}
							else if (edge.isCast()) {
								throw new UnsupportedOperationException();
								//theVariable = createBottomVariable(node, helper.createNullLiteralExp());		// FIXME is this possible?
							}
							else if (edge.isNavigation()) {
								Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
								OCLExpression sourceExpression = create(sourceNode);
								Property referredProperty = QVTscheduleUtil.getProperty((NavigableEdge) edge);
								return helper.createNavigationCallExp(sourceExpression, referredProperty);
							}
						}
					}
					else {
						return ownedInit.accept(this);
					}
				}
				else {
					return oldTypedElement.accept(this);
				}
				throw new UnsupportedOperationException();
			}
			finally {
				debugDepth--;
			}
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
				node2subexpression.put(node, this);
				for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
					//					if (edge.isUnconditional()) {
					Node sourceNode = edge.getEdgeSource();
					if (subexpressionResults.contains(sourceNode)) {
						if (sourceNode.isOld() || (!edge.isSecondary() && resultNode.isNew())) {
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
						if (sourceNode.isOld() || resultNode.isNew()) {
							inputNodes.add(sourceNode);
							if (edge.isUnconditional() && sourceNode.isUnconditional()) {
								unconditionalInputNodes.add(sourceNode);
							}
							//							edge2subexpression.put(edge, this);
						}
					}
					//					}
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

	/**
	 * A CheckedCondition identifies a possible micromapping failure mechanism. QVTi synthesis prioritises
	 * easily computed CheckedConditions to minimize the wasted effort in computing failures.
	 */
	abstract class CheckedCondition implements Comparable<@NonNull CheckedCondition>
	{
		private int weight = -1;

		protected void accumulateNodes(@NonNull Set<@NonNull Node> requiredNodes, @NonNull Edge edge) {
			requiredNodes.addAll(getPrecedingNodes(QVTscheduleUtil.getSourceNode(edge)));
			requiredNodes.addAll(getPrecedingNodes(QVTscheduleUtil.getTargetNode(edge)));
		}

		@Override
		public int compareTo(@NonNull CheckedCondition that) {
			int w1 = this.getWeight();
			int w2 = that.getWeight();
			return w1 - w2;
		}

		protected abstract int computeWeight();

		public abstract @NonNull Iterable<@NonNull Edge> getEdges();

		public int getWeight() {
			if (weight < 0) {
				weight = computeWeight();
			}
			return weight;
		}

		@Override
		public @NonNull String toString() {
			StringBuilder s = new StringBuilder();
			s.append(getClass().getSimpleName());
			s.append("(");
			boolean isFirst = true;
			for (@NonNull Edge edge : getEdges()) {
				if (!isFirst) {
					s.append(",");
				}
				s.append(edge.getDisplayName());
				isFirst = false;
			}
			s.append(")");
			return s.toString();
		}

	}

	/**
	 * A CastEdgeCheckedCondition identifies the failure when a source fails to compky with the required target type.
	 */
	class CastEdgeCheckedCondition extends CheckedCondition
	{
		private final @NonNull NavigableEdge castEdge;

		public CastEdgeCheckedCondition(@NonNull NavigableEdge castEdge) {
			this.castEdge = castEdge;
		}

		@Override
		protected int computeWeight() {
			Set<@NonNull Node> requiredNodes = new HashSet<>();
			accumulateNodes(requiredNodes, castEdge);
			return requiredNodes.size();
		}

		@Override
		public @NonNull Iterable<@NonNull Edge> getEdges() {
			return Collections.singletonList(castEdge);
		}
	}

	/**
	 * A ConstantTargetCheckedCondition identifies the failure when a computation fails to yield the required constant value.
	 */
	class ConstantTargetCheckedCondition extends CheckedCondition
	{
		private final @NonNull NavigableEdge predicateEdge;

		public ConstantTargetCheckedCondition(@NonNull NavigableEdge predicateEdge) {
			this.predicateEdge = predicateEdge;
		}

		@Override
		protected int computeWeight() {
			Set<@NonNull Node> requiredNodes = new HashSet<>();
			requiredNodes.addAll(getPrecedingNodes(QVTscheduleUtil.getSourceNode(predicateEdge)));
			return requiredNodes.size();
		}

		@Override
		public @NonNull Iterable<@NonNull Edge> getEdges() {
			return Collections.singletonList(predicateEdge);
		}
	}

	/**
	 * A MultipleEdgeCheckedCondition identifies the failure when two alternate navigation paths yield inconsistent results.
	 */
	class MultipleEdgeCheckedCondition extends CheckedCondition
	{
		private final @NonNull List<@NonNull Edge> edges = new ArrayList<>();

		public MultipleEdgeCheckedCondition(@NonNull Edge firstEdge, @NonNull Edge secondEdge) {
			addEdge(firstEdge);
			addEdge(secondEdge);
		}

		public boolean addEdge(@NonNull Edge edge) {
			return edges.add(edge);
		}

		@Override
		protected int computeWeight() {
			Set<@NonNull Node> requiredNodes = new HashSet<>();
			for (@NonNull Edge edge : edges) {
				accumulateNodes(requiredNodes, edge);
			}
			return requiredNodes.size();
		}

		@Override
		public @NonNull Iterable<@NonNull Edge> getEdges() {
			return edges;
		}
	}

	/**
	 * A NavigableEdgeCheckedCondition identifies the temporary failure that arises when
	 * observing a property access to a not-yet assigned slot.
	 */
	class NavigableEdgeCheckedCondition extends CheckedCondition
	{
		private final @NonNull NavigableEdge navigableEdge;

		public NavigableEdgeCheckedCondition(@NonNull NavigableEdge navigableEdge) {
			this.navigableEdge = navigableEdge;
		}

		@Override
		protected int computeWeight() {
			Set<@NonNull Node> requiredNodes = new HashSet<>();
			accumulateNodes(requiredNodes, navigableEdge);
			return requiredNodes.size();
		}

		@Override
		public @NonNull Iterable<@NonNull Edge> getEdges() {
			return Collections.singletonList(navigableEdge);
		}
	}

	/**
	 * A PredicateEdgeCheckedCondition identifies the failure of a required consistent computation result.
	 */
	class PredicateEdgeCheckedCondition extends CheckedCondition
	{
		private final @NonNull PredicateEdge predicateEdge;

		public PredicateEdgeCheckedCondition(@NonNull PredicateEdge predicateEdge) {
			this.predicateEdge = predicateEdge;
		}

		@Override
		protected int computeWeight() {
			Set<@NonNull Node> requiredNodes = new HashSet<>();
			accumulateNodes(requiredNodes, predicateEdge);
			return requiredNodes.size();
		}

		@Override
		public @NonNull Iterable<@NonNull Edge> getEdges() {
			return Collections.singletonList(predicateEdge);
		}
	}

	/**
	 * A PredicateNavigationEdgeCheckedCondition identifies the failure of a navigation to lovate ta required constant value.
	 */
	class PredicateNavigationEdgeCheckedCondition extends CheckedCondition
	{
		private final @NonNull NavigationEdge navigationEdge;

		public PredicateNavigationEdgeCheckedCondition(@NonNull NavigationEdge navigationEdge) {
			this.navigationEdge = navigationEdge;
		}

		@Override
		protected int computeWeight() {
			Set<@NonNull Node> requiredNodes = new HashSet<>();
			accumulateNodes(requiredNodes, navigationEdge);
			return requiredNodes.size();
		}

		@Override
		public @NonNull Iterable<@NonNull Edge> getEdges() {
			return Collections.singletonList(navigationEdge);
		}
	}

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
	 * All properties (and their opposites) that need to be checked for readiness before access.
	 */
	private final @Nullable Set<@NonNull Property> allCheckedProperties;

	/**
	 * The unconditional old edges provide the pattern matching workload.
	 * Once cost sorted the list is a sensible residual scheduling order after higher priority checked edges.
	 * Conditional edges should be scheduled as a consequence of an invoking unconditional edge/node.
	 */
	private final @NonNull List<@NonNull Edge> oldUnconditionalEdges;

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

	public BasicRegion2Mapping(@NonNull QVTs2QVTiVisitor visitor, @NonNull Region region) {
		super(visitor, region);
		this.reachabilityForest = new ReachabilityForest(getReachabilityRootNodes(), getAvailableNavigableEdges());
		this.resultNode2subexpression = computeSubexpressions();
		//
		//	Gather the subexpression contents.
		//
		Set<@NonNull OperationNode> subexpressionResults = resultNode2subexpression.keySet();
		for (@NonNull Subexpression subexpression : resultNode2subexpression.values()) {
			subexpression.analyze(subexpressionResults);
		}
		this.allCheckedProperties = computeCheckedProperties();
		this.oldUnconditionalEdges = computeOldUnconditionalEdges();
	}

	private @NonNull Iterable<@NonNull Node> getReachabilityRootNodes() {
		//
		//	The zero-cost nodes are the head nodes ...
		//
		List<@NonNull Node> zeroCostNodes = Lists.newArrayList(QVTscheduleUtil.getHeadNodes(region));
		//
		//	... and the no-input constant nodes
		//
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (node.isExplicitNull() || node.isOperation()) {
				if (node.isConstant()) {
					boolean hasNoComputationInputs = true;
					for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
						if (edge.isComputation()) {
							hasNoComputationInputs = false;
							break;
						}
					}
					if (hasNoComputationInputs) {
						zeroCostNodes.add(node);
					}
				}
			}
		}
		return zeroCostNodes;
	}
	/**
	 * Return the navigable edges that may be used by to locate nodes by this partition.
	 * The default implementation returns all old primary navigable edges
	 * and all already realized navigable edges
	 */
	protected @NonNull Iterable<@NonNull NavigableEdge> getAvailableNavigableEdges() {
		Set<@NonNull NavigableEdge> oldEdges = new HashSet<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (edge.isOld() && edge.isNavigation() /*&& edge.isUnconditional()*/) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (sourceNode.isOld() && targetNode.isOld()) {
					oldEdges.add((NavigableEdge) edge);
				}
			}
		}
		//		List<@NonNull Edge> sortedEdges = new ArrayList<>(oldEdges);
		//		Collections.sort(sortedEdges, reachabilityForest.getEdgeCostComparator());
		return oldEdges;
	}

	public void addVariable(@NonNull Node node, @NonNull VariableDeclaration variableDeclaration) {
		VariableDeclaration oldVariableDeclaration = node2variable.put(node, variableDeclaration);
		// assert oldVariableDeclaration == null;   -- FIXME QVTc test overwrites
	}

	public @Nullable VariableDeclaration basicGetVariable(@NonNull Node node) {
		return node2variable.get(node);
	}

	/**
	 * Return all properties (and their opposites) that need checking for readiness prior to access.
	 */
	private @Nullable Set<@NonNull Property> computeCheckedProperties() {
		//
		// Better, we would not be pessimistic about input/output typedModel ambiguity in endogeneous
		// mappings, but that incurs many typedModel accuracy issues.
		//
		Set<@NonNull Property> allCheckedProperties = null;
		DomainUsage anyUsage = scheduleManager.getDomainUsageAnalysis().getAnyUsage();
		for (@NonNull TypedModel qvtmTypedModel : anyUsage.getTypedModels()) {
			Iterable<@NonNull NavigableEdge> checkedEdges = scheduleManager.getRegionAnalysis(region).getCheckedEdges(qvtmTypedModel);
			if (checkedEdges != null) {
				for (@NonNull NavigableEdge checkedEdge : checkedEdges) {
					Property asProperty = QVTscheduleUtil.getProperty(checkedEdge);
					if (allCheckedProperties == null) {
						allCheckedProperties = new HashSet<>();
					}
					allCheckedProperties.add(asProperty);
					Property asOppositeProperty = asProperty.getOpposite();
					if (asOppositeProperty != null) {
						allCheckedProperties.add(asOppositeProperty);
					}
				}
			}
		}
		return allCheckedProperties;
	}

	private @NonNull List<@NonNull Edge> computeOldUnconditionalEdges() {
		Set<@NonNull Edge> oldEdges = new HashSet<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
			if (edge.isOld() && edge.isUnconditional()) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (sourceNode.isOld() && targetNode.isOld()) {
					oldEdges.add(edge);
				}
			}
		}
		List<@NonNull Edge> sortedEdges = new ArrayList<>(oldEdges);
		Collections.sort(sortedEdges, reachabilityForest.getEdgeCostComparator());
		return sortedEdges;
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
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (node.isOperation() && node.isUnconditional()) {
				OperationNode resultNode = (OperationNode) node;
				boolean isPrimitiveExp = false;
				if (node.isConstant()) {
					if (node instanceof BooleanValueNode) {
						isPrimitiveExp = true;
					}
					else {
						TypedElement oldTypedElement = node.getTypedElements().iterator().next();
						assert oldTypedElement != null;
						if (oldTypedElement instanceof PrimitiveLiteralExp) {
							isPrimitiveExp = true;
						}
					}
				}
				if (!isPrimitiveExp) {
					Edge firstEdge = null;
					boolean isSubexpression = false;
					for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
						if (edge.isNew() && !edge.isSecondary()) {
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
		return resultNode2subexpression;
	}

	/**
	 *	Create accumulation assignments for connections.
	 */
	private void createAddStatements() {
		if (connection2variable != null) {
			for (@NonNull NodeConnection connection : connection2variable.keySet()) {
				Node sourceNode = connection.getSource(region);
				OCLExpression variableExpression = createVariableExp(sourceNode);
				ConnectionVariable connectionVariable = connection2variable.get(connection);
				assert connectionVariable != null;
				createAddStatement(connectionVariable, variableExpression);
			}
		}
	}

	private void createCallStatements(@NonNull Map<@NonNull Region, @NonNull Map<@NonNull Node, @NonNull Node>> calls) {
		List<@NonNull MappingStatement> mappingStatements = new ArrayList<>();
		Map<@NonNull LoopVariable, @NonNull OCLExpression> loopVariables = null;
		for (Map.Entry<@NonNull Region, @NonNull Map<@NonNull Node, @NonNull Node>> entry : calls.entrySet()) {
			@NonNull Region calledRegion = entry.getKey();
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
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

	private void createClassSetStatement(@NonNull NavigableEdge edge) {
		Node sourceNode = edge.getEdgeSource();
		Node targetNode = edge.getEdgeTarget();
		Property property = QVTscheduleUtil.getProperty(edge);
		boolean isNotify = isHazardousWrite(edge);
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
		setStatement = helper.createSetStatement(slotVariable, setProperty, targetVariableExp, isPartial, isNotify);
		mapping.getOwnedStatements().add(setStatement);
	}

	private @NonNull DeclareStatement createDeclareStatement(@NonNull Node node, @NonNull OCLExpression initExpression) {
		Type variableType = node.getCompleteClass().getPrimaryClass();
		assert variableType != null;
		boolean isRequired = node.isMatched();
		for (@NonNull TypedElement typedElement : node.getTypedElements()) {
			if (!typedElement.isIsRequired()) {
				isRequired = false;
			}
		}
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
		Type variableType = guardNode.getCompleteClass().getPrimaryClass();
		ImperativeTypedModel iTypedModel = ClassUtil.nonNullState(visitor.getQVTiTypedModel(classDatum.getReferredTypedModel()));
		GuardParameter guardParameter = helper.createGuardParameter(getSafeName(guardNode), iTypedModel, variableType, true);
		Property successProperty = scheduleManager.basicGetSuccessProperty(guardNode);
		if (successProperty != null) {
			NavigableEdge successEdge = guardNode.getNavigationEdge(successProperty);
			if (successEdge != null) {
				Node successNode = QVTscheduleUtil.getTargetNode(successEdge);
				if (successNode.isSuccess()) {
					assert successEdge.isRealized();
					guardParameter.setSuccessProperty(successProperty);
				}
			}
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
		Iterable<@NonNull Edge> recursionEdges = region.getRecursionEdges();
		if (Iterables.size(recursionEdges) > 0) {
			headCallingRegions.add(region);
		}
		for (@NonNull Node headNode : QVTscheduleUtil.getHeadNodes(region)) {		// FIXME Move best bead selection to QVTs2QVTs so that diagrams show best head
			if (!headNode.isDependency()) {
				Node bestHeadNode = null;
				Iterable<@NonNull Node> callingSources = headNode.getPassedBindingSources();
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
					visitor.addProblem(CompilerUtil.createRegionError(region, "No best head"));
				}
			}
		}
		guardNodes.addAll(headNodes);
		Collections.sort(guardNodes, NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Node guardNode : guardNodes) {
			if (!guardNode.isDependency()) {
				createGuardParameter(guardNode);
			}
		}
		//
		//	Create any connectionVariable guards
		//
		createAppendParameters();
	}

	private void createObservedProperties() {
		Set<@NonNull Property> allCheckedProperties2 = allCheckedProperties;
		if (allCheckedProperties2 != null) {
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
							if (allCheckedProperties2.contains(property) && !observedProperties.contains(property)) {
								observedProperties.add(property);
							}
						}
						else if (eObject instanceof OppositePropertyCallExp) {
							Property property = PivotUtil.getReferredProperty((NavigationCallExp) eObject).getOpposite();
							if (allCheckedProperties2.contains(property) && !observedProperties.contains(property)) {
								observedProperties.add(property);
							}
						}
					}
				}
			}
		}
	}

	public <T extends Operation> @NonNull T createOperation(@NonNull T operation) {
		Operation newOperation = visitor.create(operation);
		assert newOperation != null;
		return (@NonNull T) newOperation;
	}

	/**
	 * Determine a traversal order for the old edges then synthesize the patttern matching statements.
	 */
	private void createPatternMatch() {
		if (mapping.isIsAbstract()) {
			//			mapping.getOwnedStatements().add(createCheckStatement(helper.createBooleanLiteralExp(false)));	// FIXME add a message
			OldEdgeSchedule oldSchedule = new OldEdgeSchedule();
			oldSchedule.analyze();
			oldSchedule.synthesize();
		}
		else {
			OldEdgeSchedule oldSchedule = new OldEdgeSchedule();
			oldSchedule.analyze();
			oldSchedule.synthesize();
		}
	}

	private void createPropertyAssignments() {
		Map<@NonNull Node, @NonNull List<@NonNull NavigableEdge>> classAssignments = null;
		Iterable<@NonNull NavigableEdge> sortedEdges = NavigationEdgeSorter.getSortedAssignments(region.getRealizedNavigationEdges());
		for (@NonNull NavigableEdge edge : sortedEdges) {
			Node sourceNode = edge.getEdgeSource();
			Node targetNode = edge.getEdgeTarget();
			if (targetNode.isSuccess()) {}											// SuccessNode has a 'magic' automatic assignment
			else if (targetNode.isDataType()) {
				VariableDeclaration asVariable = getVariable(sourceNode);
				Property property = QVTscheduleUtil.getProperty(edge);
				ExpressionCreator expressionCreator = new ExpressionCreator(this);
				OCLExpression valueExp = expressionCreator.getExpression(targetNode);
				if (valueExp == null) {
					ExpressionCreator expressionCreator2 = new ExpressionCreator(this);
					valueExp = expressionCreator2.getExpression(targetNode);		// FIXME debugging
				}
				if (valueExp != null) {
					boolean isNotify = isHazardousWrite(edge);
					SetStatement setStatement = helper.createSetStatement(asVariable, property, valueExp, edge.isPartial(), isNotify);
					//					addObservedProperties(setStatement);
					mapping.getOwnedStatements().add(setStatement);
				}
				else {
					System.err.println("No assignment in " + this + " to " + asVariable + "." + property);
				}
			}
			else {
				if (classAssignments == null) {
					classAssignments = new HashMap<>();
				}
				List<@NonNull NavigableEdge> edges = classAssignments.get(sourceNode);
				if (edges == null) {
					edges = new ArrayList<>();
					classAssignments.put(sourceNode, edges);
				}
				edges.add(edge);
			}
		}
		if (classAssignments != null) {
			pruneClassAssignments(classAssignments);
			Set<@NonNull NavigableEdge> classAssignmentEdges = new HashSet<>();
			for (@NonNull List<@NonNull NavigableEdge> values : classAssignments.values()) {
				classAssignmentEdges.addAll(values);
			}
			for (@NonNull NavigableEdge edge : sortedEdges) {
				if (classAssignmentEdges.contains(edge)) {
					createClassSetStatement(edge);
				}
			}
		}
		//		@SuppressWarnings("null")
		//		@NonNull EList<@NonNull Statement> statements = mapping.getOwnedStatements();
		//		ECollections.sort(statements, new StatementComparator(statements));
	}

	private void createRealizedIncludesAssignments() {
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
				/*				if (targetNode.isDataType()) {
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
						System.err.println("No assignment in " + this + " to " + slotVariableExp + "." + property);
				 */

			}
		}
	}

	private void createRealizedVariables() {
		List<@NonNull Node> sortedNodes = Lists.newArrayList(region.getNewNodes());
		Collections.sort(sortedNodes,NameUtil.NAMEABLE_COMPARATOR);
		for (@NonNull Node newNode : sortedNodes) {
			if (/*newNode.isPattern() &&*/ newNode.isClass()) {
				ExpressionCreator expressionCreator = new ExpressionCreator(this);
				OCLExpression constructor = null;
				if (newNode.isOperation()) {
					if (newNode instanceof KeyedValueNode) {
						KeyedValueNode keyedValueNode = (KeyedValueNode)newNode;
						ClassDatum classDatum = keyedValueNode.getClassDatumValue();
						assert classDatum != null;
						Function function = visitor.getKeyFunction(classDatum);
						VariableExp thisExp = helper.createVariableExp(QVTimperativeUtil.getContextVariable(scheduleManager.getStandardLibrary(), getTransformation()));
						Map<@NonNull PropertyDatum, @NonNull VariableExp> propertyDatum2expression = new HashMap<>();
						for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(newNode)) {
							if (edge instanceof ExpressionEdge) {
								ExpressionEdge expressionEdge = (ExpressionEdge)edge;
								Object referredPropertyDatum = expressionEdge.getReferredObject();
								if (referredPropertyDatum instanceof PropertyDatum) {
									PropertyDatum propertyDatum = (PropertyDatum)referredPropertyDatum;
									VariableExp subexpressionNode = getSubexpressionVariableExp(QVTscheduleUtil.getSourceNode(expressionEdge));
									propertyDatum2expression.put(propertyDatum, subexpressionNode);
								}
							}
						}
						List<@NonNull OCLExpression> asArguments = new ArrayList<>();
						for (@NonNull PropertyDatum propertyDatum : classDatum.getOwnedPropertyDatums()) {
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
						constructor = ((OperationCallExp)newNode.getTypedElements().iterator().next()).accept(expressionCreator);
					}
				}
				ClassDatum classDatum = newNode.getClassDatum();
				TypedModel pTypedModel = classDatum.getReferredTypedModel();
				ImperativeTypedModel iTypedModel = ClassUtil.nonNullState(visitor.getQVTiTypedModel(pTypedModel));
				NewStatement newStatement = helper.createNewStatement(getSafeName(newNode), iTypedModel, classDatum.getCompleteClass().getPrimaryClass());
				newStatement.setOwnedExpression(constructor);
				newStatement.setIsContained(newNode.isContained());
				mapping.getOwnedStatements().add(newStatement);
				VariableDeclaration oldVariable = node2variable.put(newNode, newStatement);
				assert oldVariable == null;
			}
		}
	}

	private @NonNull OCLExpression createVariableExp(@NonNull Node node) {
		if (node.isExplicitNull()) {
			return helper.createNullLiteralExp();
		}
		else {
			VariableDeclaration variable = getVariable(node);
			return PivotUtil.createVariableExp(variable);
		}
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

	private @NonNull VariableDeclaration getSubexpressionDeclaration(@NonNull Node node) {
		VariableDeclaration variable = node2variable.get(node);
		if (variable == null) {
			ExpressionCreator expressionCreator = new ExpressionCreator(this);
			ExpressionCreator inlineExpressionCreator = expressionCreator.getInlineExpressionCreator();
			OCLExpression targetExpression = inlineExpressionCreator.getExpression(node);
			assert targetExpression != null;
			variable = createDeclareStatement(node, targetExpression);
		}
		return variable;
	}

	private @NonNull VariableExp getSubexpressionVariableExp(@NonNull Node node) {
		return helper.createVariableExp(getSubexpressionDeclaration(node));
	}

	public @NonNull Transformation getTransformation() {
		return visitor.getTransformation();
	}

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

	private boolean isCheckedNavigation(@NonNull NavigationEdge edge) {
		Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
		Node targetNode = QVTscheduleUtil.getTargetNode(edge);
		return targetNode.isConstant() && !sourceNode.isNew();
	}

	private boolean isHazardousWrite(@NonNull NavigableEdge edge) {
		Node sourceNode = edge.getEdgeSource();
		Property asProperty = QVTscheduleUtil.getProperty(edge);
		TypedModel typedModel = QVTscheduleUtil.getTypedModel(sourceNode);
		RegionAnalysis regionAnalysis = scheduleManager.getRegionAnalysis(region);
		Iterable<@NonNull NavigableEdge> enforcedEdges = regionAnalysis.getEnforcedEdges(typedModel, asProperty);
		return enforcedEdges != null;
	}

	private boolean isIfExp(@NonNull Node node) {
		if (node.isExpression()) {
			for (TypedElement typedElement : node.getTypedElements()) {
				if (typedElement instanceof IfExp) {
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public boolean isInfinite() {
		if (region.getRecursionEdges().iterator().hasNext()) {		// FIXME unduly pessimistic
			return true;
		}
		return false;
	}

	/**
	 * Filter classAssignments to retain only one of each opposite-property assignment pair.
	 */
	private void pruneClassAssignments(@NonNull Map<@NonNull Node, @NonNull List<@NonNull NavigableEdge>> classAssignments) {
		for (@NonNull Node sourceNode : new ArrayList<>(classAssignments.keySet())) {
			List<@NonNull NavigableEdge> forwardEdges = classAssignments.get(sourceNode);
			assert forwardEdges != null;
			for (int iForward = forwardEdges.size()-1; iForward >= 0; iForward--) {
				NavigableEdge forwardEdge = forwardEdges.get(iForward);
				Node targetNode = forwardEdge.getEdgeTarget();
				List<@NonNull NavigableEdge> reverseEdges = classAssignments.get(targetNode);
				if (reverseEdges != null) {
					for (int iReverse = reverseEdges.size()-1; iReverse >= 0; iReverse--) {
						NavigableEdge reverseEdge = reverseEdges.get(iReverse);
						if (sourceNode == reverseEdge.getEdgeTarget()) {
							Property forwardProperty = forwardEdge.getProperty();
							Property reverseProperty = reverseEdge.getProperty();
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

	@Override
	public void synthesizeCallStatements() {
		Map<@NonNull Region, @NonNull Map<@NonNull Node, @NonNull Node>> calls = null;
		for (@NonNull Region calledRegion : region.getCallableChildren()) {
			if (calls == null) {
				calls = new HashMap<>();
			}
			Map<@NonNull Node, @NonNull Node> source2target = calls.get(calledRegion);
			if (source2target == null) {
				source2target = new HashMap<>();
				calls.put(calledRegion, source2target);
			}
			AbstractRegion2Mapping calledRegion2Mapping = visitor.getRegion2Mapping(calledRegion);
			for (@NonNull Node calledGuardNode : calledRegion2Mapping.getGuardNodes()) {
				for (@NonNull Node callingNode : calledGuardNode.getPassedBindingSources()) {
					if (callingNode.getOwningRegion() == region) {
						Node oldNode = source2target.put(callingNode, calledGuardNode);
						assert oldNode == null;
					}
				}
				for (@NonNull Node callingNode : calledGuardNode.getUsedBindingSources()) {
					if (callingNode.getOwningRegion() == region) {
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
		createHeadAndGuardNodeVariables();			// BLUE/CYAN guard/append nodes
		createPatternMatch();						// BLUE/CYAN nodes and edges
		createRealizedVariables();					// GREEN nodes
		createPropertyAssignments();				// GREEN edges
		createAddStatements();						// export to append nodes
		createRealizedIncludesAssignments();
		createObservedProperties();					// wrap observable clauses around hazardous accesses
	}

	@Override
	public @NonNull String toString() {
		return String.valueOf(region);
	}
}