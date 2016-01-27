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
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;
import org.eclipse.qvtd.pivot.schedule.utilities.GraphStringBuilder;

public class MappingRegion extends AbstractMappingRegion implements Comparable<MappingRegion>, MergeableRegion, Iterable<MergeableRegion>
{
	/**
	 * The analyzed action.
	 */
	private final @NonNull MappingAction mappingAction;

	/**
	 * The original ordering.
	 */
	private final int naturalOrder;
	
	/**
	 * Predicates that are too complex to analyze. i.e. more than a comparison of a bound variable wrt
	 * a property call chain on another bound variable.
	 */
	private final @NonNull Set<Predicate> complexPredicates = new HashSet<Predicate>();
	
	private /*@LazyNonNull*/ List<MappingRegion> successors;
	
	private final @NonNull ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer(this);

	/**
	 * The extra guards to accommodate operation content.
	 */
	private /*@LazyNonNull*/ List<Node> extraNodes = null;

	public MappingRegion(@NonNull SuperRegion superRegion, @NonNull MappingAction mappingAction, int naturalOrder) {
		super(superRegion);
		this.mappingAction = mappingAction;
		this.naturalOrder = naturalOrder;
		AbstractMapping mapping = mappingAction.getMapping();
		assert mapping != null;
		
		List<GuardPattern> guardPatterns = new ArrayList<GuardPattern>();
		List<BottomPattern> bottomPatterns = new ArrayList<BottomPattern>();
//
		guardPatterns.add(mapping.getGuardPattern());
		bottomPatterns.add(mapping.getBottomPattern());
		for (Domain domain : mapping.getDomain()) {
			if (domain instanceof CoreDomain) {
				CoreDomain coreDomain = (CoreDomain)domain;
//
				guardPatterns.add(coreDomain.getGuardPattern());
				bottomPatterns.add(coreDomain.getBottomPattern());
			}
		}
		/**
		 * Extract the reachability constraints from the predicates.
		 */
		analyzePredicates(guardPatterns);
		/**
		 * Identify any assignments and hidden inputs.
		 */
		for (Predicate predicate : complexPredicates) {
			OCLExpression conditionExpression = predicate.getConditionExpression();
/*			if (conditionExpression instanceof OperationCallExp) {
				OperationCallExp callExp = (OperationCallExp)conditionExpression;
				OperationId operationId = callExp.getReferredOperation().getOperationId();
				if (SchedulerConstants.isSameOperation(operationId, getSchedulerConstants().getOclAnyEqualsId())) {
					OCLExpression leftExpression = callExp.getOwnedSource();
					OCLExpression rightExpression = callExp.getOwnedArguments().get(0);
					Node leftNode = expressionAnalyzer.analyze(leftExpression);
					Node rightNode = expressionAnalyzer.analyze(rightExpression);
					if (leftNode != rightNode) {
						if (leftNode.isKnown() && !(leftExpression instanceof NavigationCallExp)) {
							Edges.ARGUMENT.createEdge(this, leftNode, "=", rightNode);
						}
						else if (rightNode.isKnown() && !(rightExpression instanceof NavigationCallExp)) {
							Edges.ARGUMENT.createEdge(this, rightNode, "=", leftNode);
						}
						else if (leftNode.isKnown()) {
							Edges.ARGUMENT.createEdge(this, leftNode, "=", rightNode);
						}
						else if (rightNode.isKnown()) {
							Edges.ARGUMENT.createEdge(this, rightNode, "=", leftNode);
						}
						else {				
							Edges.BINDING.createEdge(this, leftNode, null, rightNode);			// FIXME
							Edges.BINDING.createEdge(this, rightNode, null, leftNode);
						}
					}
				}
			}
			else { */
			SimpleNode resultNode = expressionAnalyzer.analyze(conditionExpression);
			SimpleNode trueNode = Nodes.TRUE.createSimpleNode(this);
			Edges.ARGUMENT.createSimpleEdge(this, resultNode, null, trueNode);
//			}
		}
		//
		for (BottomPattern bottomPattern : bottomPatterns) {
			for (@SuppressWarnings("null")@NonNull RealizedVariable realizedVariable : bottomPattern.getRealizedVariable()) {
				/*assignedNodes.add(*/Nodes.REALIZED_VARIABLE.createSimpleNode(this, realizedVariable);
			}
			for (@SuppressWarnings("null")@NonNull Variable variable : bottomPattern.getVariable()) {
				/*assignedNodes.add(*/Nodes.UNREALIZED_VARIABLE.createSimpleNode(this, variable);
			}
		}
		//
		for (BottomPattern bottomPattern : bottomPatterns) {
			for (@SuppressWarnings("null")@NonNull Variable variable : bottomPattern.getVariable()) {
				SimpleNode variableNode = getReferenceNode(variable);
				OCLExpression ownedInit = variable.getOwnedInit();
				if (ownedInit != null) {
					SimpleNode initNode = ownedInit.accept(expressionAnalyzer);
					assert initNode != null;
					Edges.ARGUMENT.createSimpleEdge(this, initNode, null, variableNode);
				}
			}
			for (@SuppressWarnings("null")@NonNull Assignment assignment : bottomPattern.getAssignment()) {
				assignment.accept(expressionAnalyzer);
			}
		}
		//
		getHeadNodeGroups();
		toDOT();
		toGraphML();
		return;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitMappingRegion(this);
	}

	/**
	 * Install the path equivalence that navigation of the successive path elements starting from sourceVariable reaches targetVariable.
	 */
	private void addPredicateNavigation(@NonNull VariableDeclaration sourceVariable, @NonNull List<Property> path, @Nullable VariableDeclaration targetVariable) {
//		assert guardVariables.contains(targetVariable);
//		assert guardVariables.contains(sourceVariable);
		assert path.size() == 1;		// FIXME multi-step paths
		Property property = path.get(0);
		assert property != null;
		SimpleNode sourceNode = getReferenceNode(sourceVariable);
		SimpleNode targetNode = targetVariable != null ? getReferenceNode(targetVariable) : Nodes.NULL.createSimpleNode(this);
		assert sourceNode.isGuardVariable();
		assert (targetVariable == null) || targetNode.isGuardVariable();
		addPredicateEdge(sourceNode, property, targetNode);
	}

	/**
	 * Analyze the predicates to partition the guard variables into the distinct inputs that are not mutually
	 * navigable as a consequence of predicate constraints.
	 */
	private void analyzePredicates(@NonNull List<GuardPattern> guardPatterns) {
		//
		//	Populate the targetVariable2sourceVariable2paths from the simple "a.b = c" style predicates,
		//	and cache those that are too hard to analyze as complex predicates.
		//
		for (GuardPattern guardPattern : guardPatterns) {
			for (@SuppressWarnings("null")@NonNull VariableDeclaration guardVariable : guardPattern.getVariable()) {
				Nodes.GUARD.createSimpleNode(this, guardVariable);
			}
		}
		for (GuardPattern guardPattern : guardPatterns) {
		 	for (Predicate predicate : guardPattern.getPredicate()) {
				OCLExpression conditionExpression = predicate.getConditionExpression();
				if (conditionExpression != null) {
					OCLExpression boundExpression = getPredicateComparisonBoundExpression(conditionExpression);
					if (boundExpression instanceof VariableExp) {
						OCLExpression referenceExpression = getPredicateComparisonReferenceExpression(conditionExpression);
						assert referenceExpression != null;
						analyzeSimplePredicate(((VariableExp)boundExpression).getReferredVariable(), referenceExpression);				
					}
					else if (boundExpression instanceof NullLiteralExp) {
						OCLExpression referenceExpression = getPredicateComparisonReferenceExpression(conditionExpression);
						assert referenceExpression != null;
						analyzeSimplePredicate(null, referenceExpression);				
					}
					else {
						complexPredicates.add(predicate);
					}
				}
			}
		}
		return;
	}

	//
	//	Install the targetVariable2sourceVariable2paths entries for a "boundVariable = referenceExpression" predicate,
	//	where the referenceExpression involves zero or more PropertyCallExps of a VariableExp. boundVariable may be null
	//	for a negative application condition.
	//
	//	A reverse entry is also created if no PropertCallExp is not to-one.
	//
	private void analyzeSimplePredicate(@Nullable VariableDeclaration boundVariable, @NonNull OCLExpression referenceExpression) {
		List<Property> path = new ArrayList<Property>();
		boolean isReversible = true;
		for (OCLExpression expression = referenceExpression; expression instanceof NavigationCallExp; ) {
			NavigationCallExp navigationCallExp = (NavigationCallExp)expression;
			Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
			assert referredProperty != null;
			path.add(0, referredProperty);
			if ((referredProperty.getOpposite() == null) || referredProperty.getOpposite().isIsMany()) {
				isReversible = false;
			}
			expression = navigationCallExp.getOwnedSource();
			if (expression instanceof VariableExp) {
				VariableDeclaration sourceVariable = ((VariableExp)expression).getReferredVariable();
				assert sourceVariable != null;
				addPredicateNavigation(sourceVariable, path, boundVariable);
				if (isReversible && (boundVariable != null)) {
					List<Property> oppositePath = new ArrayList<Property>();
					for (Property property : path) {
						oppositePath.add(0, property.getOpposite());
					}
					addPredicateNavigation(boundVariable, oppositePath, sourceVariable);
				}
			}
		}
	}

	@Override
	public int compareTo(MappingRegion thatRegion) {
		return Integer.compare(getNaturalOrder(), thatRegion.getNaturalOrder());
	}

	@Override
	public @NonNull SimpleNode createExtraGuard(@NonNull Node extraNode) {
		if (extraNodes == null) {
			extraNodes = new ArrayList<Node>();
		}
		SimpleNode extraGuardNode = Nodes.EXTRA_GUARD.createSimpleNode(this, "«extra-" + (extraNodes.size()+1) + "»", extraNode.getClassDatumAnalysis());
		extraNodes.add(extraGuardNode);
		@NonNull List<Node> extraGuardNodeList = Collections.<Node>singletonList(extraGuardNode);
		addHeadGroup(extraGuardNodeList);
		return extraGuardNode;
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull Iterable<MappingRegion> getAllMappingRegions() {
		return Collections.singleton(this);
	}

	@SuppressWarnings("null")
	@Override
	public @NonNull String getName() {
		AbstractMapping mapping = mappingAction.getMapping();
		return mapping.getName();
	}	
	
	public int getNaturalOrder() {
		return naturalOrder;
	}

	/**
	 * Return the boundExpression if conditionExpression is of the form
	 * <br>"boundVariable = referenceExpression"
	 * <br>"referenceExpression = boundVariable".
	 * <br>"null = referenceExpression"
	 * <br>"referenceExpression = null".
	 * <br>"constant-expression = referenceExpression"
	 * <br>"referenceExpression = constant-expression".
	 * 
	 * Returns null otherwise.
	 */
	private @Nullable OCLExpression getPredicateComparisonBoundExpression(@NonNull OCLExpression conditionExpression) {
		if (conditionExpression instanceof OperationCallExp) {
			OperationCallExp callExp = (OperationCallExp)conditionExpression;
			OperationId operationId = callExp.getReferredOperation().getOperationId();
			if (PivotUtil.isSameOperation(operationId, getSchedulerConstants().getOclAnyEqualsId())) {
				OCLExpression leftExp = callExp.getOwnedSource();
				if (leftExp instanceof VariableExp) {
					return leftExp;
				}
				OCLExpression rightExp = callExp.getOwnedArguments().get(0);
				if (rightExp instanceof VariableExp) {
					return rightExp;
				}
				IsConstantExpressionVisitor isConstantExpressionVisitor = new IsConstantExpressionVisitor(null);
				if (isConstantExpressionVisitor.isConstant(leftExp)) {
					return leftExp;
				}
				if (isConstantExpressionVisitor.isConstant(rightExp)) {
					return rightExp;
				}
			}
		}
		return null;
	}

	/**
	 * Return the referenceExpression if conditionExpression is of the form "boundVariable = referenceExpression" or
	 * "referenceExpression = boundVariable". Returns null otherwise.
	 */
	private @Nullable OCLExpression getPredicateComparisonReferenceExpression(@NonNull OCLExpression conditionExpression) {
		if (conditionExpression instanceof OperationCallExp) {
			OperationCallExp callExp = (OperationCallExp)conditionExpression;
			OperationId operationId = callExp.getReferredOperation().getOperationId();
			if (PivotUtil.isSameOperation(operationId, getSchedulerConstants().getOclAnyEqualsId())) {
				OCLExpression leftExp = callExp.getOwnedSource();
				OCLExpression rightExp = callExp.getOwnedArguments().get(0);
				if (leftExp instanceof VariableExp) {
					return rightExp;
				}
				else if (rightExp instanceof VariableExp) {
					return leftExp;
				}
				IsConstantExpressionVisitor isConstantExpressionVisitor = new IsConstantExpressionVisitor(null);
				if (isConstantExpressionVisitor.isConstant(leftExp)) {
					return rightExp;
				}
				if (isConstantExpressionVisitor.isConstant(rightExp)) {
					return leftExp;
				}
			}
		}
		return null;
	}
	
	@Override
	public @NonNull String getColor() {
		return "green";
	}

	@Override
	public @NonNull Iterable<MergeableRegion> getMergeableRegions() {
		return this;
	}

	public @NonNull List<? extends Region> getSuccessors() {
		List<MappingRegion> successors2 = successors;
		if (successors2 == null) {
			successors = successors2 = new ArrayList<MappingRegion>();
			for (AbstractDatum production : mappingAction.getProductions()) {
				for (@SuppressWarnings("null")@NonNull AbstractAction nextAction : production.getRequiredBy()) {
					MappingRegion nextRegion = getMappingRegion(nextAction);
					assert nextRegion != null;
					if (!successors2.contains(nextRegion)) {
						successors2.add(nextRegion);
					}
				}
			}
			Collections.sort(successors);
		}
		return successors2;
	}
	
	@Override
	public @NonNull SimpleNode getUnknownNode(@NonNull TypedElement typedElement) {
		assert !(typedElement instanceof Property);		// Property entries should be AttributeNodes
		SimpleNode node = getSimpleNode(typedElement);
		if (node == null) {
			node = Nodes.UNKNOWN.createSimpleNode(this, ClassUtil.nonNullState(typedElement.getType().toString()), typedElement);
//			node2node.put(typedElement, node);
		}
		return node;
	}

	@Override
	public Iterator<MergeableRegion> iterator() {
		return new SingletonIterator<MergeableRegion>(this);
	}

	public void registerConsumptionsAndProductions() {
		for (Node assignedNode : getComputedNodes()) {
			ClassDatumAnalysis classDatumAnalysis = assignedNode.getClassDatumAnalysis();
			classDatumAnalysis.addProduction(this, assignedNode);
			ClassDatum classDatum = classDatumAnalysis.getClassDatum();
			for (@SuppressWarnings("null")@NonNull AbstractAction consumingAction : classDatum.getRequiredBy()) {
				MappingRegion consumingRegion = superRegion.getMappingRegion(consumingAction);
				assert consumingRegion != null;
				for (@SuppressWarnings("null")@NonNull Node consumingNode : consumingRegion.getMatchableNodes()) {
					if (consumingNode.getCompleteClass() == classDatumAnalysis.getCompleteClass()) {		// FIXME inheritance
						classDatumAnalysis.addConsumption(consumingRegion, consumingNode);
					}
				}
			}
		}
		for (Node predicatedNode : getMatchableNodes()) {
			ClassDatumAnalysis classDatumAnalysis = predicatedNode.getClassDatumAnalysis();
			classDatumAnalysis.addConsumption(this, predicatedNode);
			ClassDatum classDatum = classDatumAnalysis.getClassDatum();
			for (@SuppressWarnings("null")@NonNull AbstractAction introducingAction : classDatum.getProducedBy()) {
				MappingRegion producingRegion = superRegion.getMappingRegion(introducingAction);
				assert producingRegion != null;
				for (@SuppressWarnings("null")@NonNull Node assignedNode : producingRegion.getComputedNodes()) {
					if (assignedNode.getCompleteClass() == classDatumAnalysis.getCompleteClass()) {		// FIXME inheritance
						classDatumAnalysis.addProduction(producingRegion, assignedNode);
					}
				}
			}
		}
	}

	@Override
	public void toGraph(@NonNull GraphStringBuilder s) {
		s.setColor("palegreen");
		s.setPenwidth(Role.LINE_WIDTH);
		super.toGraph(s);
	}
}