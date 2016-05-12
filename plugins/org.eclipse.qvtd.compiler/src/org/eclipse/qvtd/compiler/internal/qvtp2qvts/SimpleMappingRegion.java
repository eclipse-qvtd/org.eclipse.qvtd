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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.AbstractMapping;
import org.eclipse.qvtd.pivot.qvtcorebase.Assignment;
import org.eclipse.qvtd.pivot.qvtcorebase.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcorebase.CorePattern;
import org.eclipse.qvtd.pivot.qvtcorebase.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcorebase.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.DOTStringBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphMLStringBuilder;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.GraphStringBuilder;
import org.eclipse.qvtd.pivot.schedule.AbstractAction;
import org.eclipse.qvtd.pivot.schedule.AbstractDatum;
import org.eclipse.qvtd.pivot.schedule.ClassDatum;
import org.eclipse.qvtd.pivot.schedule.MappingAction;

public class SimpleMappingRegion extends AbstractMappingRegion implements SimpleRegion, Comparable<SimpleMappingRegion>, MergeableRegion, Iterable<@NonNull MergeableRegion>
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
	
	private /*@LazyNonNull*/ List<SimpleMappingRegion> successors;
	
	private final @NonNull ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer(this);

	/**
	 * The node for each navigable VariableDeclaration.
	 */
	private final @NonNull Map<VariableDeclaration, SimpleNode> variable2simpleNode = new HashMap<VariableDeclaration, SimpleNode>();

	/**
	 * The extra guards to accommodate operation content.
	 */
	private /*@LazyNonNull*/ List<@NonNull SimpleNode> extraNodes = null;

	public SimpleMappingRegion(@NonNull SuperRegion superRegion, @NonNull MappingAction mappingAction, int naturalOrder) {
		super(superRegion);
		this.mappingAction = mappingAction;
		this.naturalOrder = naturalOrder;
		AbstractMapping mapping = mappingAction.getMapping();
		assert mapping != null;
		
		List<@NonNull GuardPattern> guardPatterns = new ArrayList<@NonNull GuardPattern>();
		List<@NonNull BottomPattern> bottomPatterns = new ArrayList<@NonNull BottomPattern>();
//
		guardPatterns.add(ClassUtil.nonNull(mapping.getGuardPattern()));
		bottomPatterns.add(ClassUtil.nonNull(mapping.getBottomPattern()));
		for (Domain domain : mapping.getDomain()) {
			if (domain instanceof CoreDomain) {
				CoreDomain coreDomain = (CoreDomain)domain;
//
				guardPatterns.add(ClassUtil.nonNull(coreDomain.getGuardPattern()));
				bottomPatterns.add(ClassUtil.nonNull(coreDomain.getBottomPattern()));
			}
		}
		/**
		 * Extract the reachability constraints from the predicates.
		 */
		analyzePredicates(guardPatterns);
		analyzePredicates(bottomPatterns);
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
//			for (@SuppressWarnings("null")@NonNull Variable variable : bottomPattern.getVariable()) {
//				/*assignedNodes.add(*/Nodes.UNREALIZED_VARIABLE.createSimpleNode(this, variable);
//			}
		}
		//
		for (BottomPattern bottomPattern : bottomPatterns) {
//			for (@SuppressWarnings("null")@NonNull Variable variable : bottomPattern.getVariable()) {
//				SimpleNode variableNode = getReferenceNode(variable);
//				OCLExpression ownedInit = variable.getOwnedInit();
//				if (ownedInit != null) {
//					SimpleNode initNode = ownedInit.accept(expressionAnalyzer);
//					assert initNode != null;
//					variable2simpleNode.put(variable, initNode);
//					Edges.ARGUMENT.createSimpleEdge(this, initNode, null, variableNode);
//					if (initNode.isConstant()) {
//						variableNode.mergeRole(initNode.getNodeRole());
//					}
//				}
//			}
			for (@SuppressWarnings("null")@NonNull Assignment assignment : bottomPattern.getAssignment()) {
				assignment.accept(expressionAnalyzer);
			}
		}
		//
		getHeadNodes();
		toGraph(new DOTStringBuilder());
		toGraph(new GraphMLStringBuilder());
		return;
	}

	@Override
	public <R> R accept(@NonNull Visitor<R> visitor) {
		return visitor.visitSimpleMappingRegion(this);
	}
	
	public void addAssignmentEdge(@NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
		assert sourceNode.isClassNode();
		Edge assignmentEdge = sourceNode.getAssignmentEdge(source2targetProperty);
		if (assignmentEdge == null) {
			Edges.REALIZED.createEdge(this, sourceNode, source2targetProperty, targetNode);
		}
		else {
			assert assignmentEdge.getTarget() == targetNode;
		}
	}

	@Override
	public void addEdge(@NonNull Edge edge) {
		assert (basicGetSymbolName() == null) || !edge.isNavigation();
		super.addEdge(edge);
	}

	@Override
	protected void addHeadNode(@NonNull Node headNode) {
		assert basicGetSymbolName() == null;
		super.addHeadNode(headNode);
	}

	@Override
	public void addNode(@NonNull Node node) {
		assert basicGetSymbolName() == null;
		super.addNode(node);
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
		assert sourceNode.isClassNode();
		if (!property.isIsMany()) {
			SimpleEdge predicateEdge = sourceNode.getPredicateEdge(property);
			if (predicateEdge == null) {
				Edges.NAVIGATION.createSimpleEdge(this, sourceNode, property, targetNode);
			}
			else {
				assert predicateEdge.getTarget() == targetNode;
			}
		}
		Property oppositeProperty = property.getOpposite();
		if ((oppositeProperty != null) && !oppositeProperty.isIsMany()) {
			SimpleEdge predicateEdge = targetNode.getPredicateEdge(oppositeProperty);
			if (predicateEdge == null) {
				Edges.NAVIGATION.createSimpleEdge(this, targetNode, oppositeProperty, sourceNode);
			}
			else {
				assert predicateEdge.getTarget() == sourceNode;
			}
		}
	}

	public void addVariableNode(@NonNull VariableDeclaration typedElement, @NonNull SimpleNode simpleNode) {
//		assert !simpleNode.isOperation();			// FIXME testExample2_V2 violates this for an intermediate "if"
		variable2simpleNode.put(typedElement, simpleNode);
	}

	/**
	 * Analyze the predicates to partition the guard variables into the distinct inputs that are not mutually
	 * navigable as a consequence of predicate constraints.
	 * @param bottomPatterns 
	 */
	private void analyzePredicates(@NonNull List<@NonNull ? extends CorePattern> corePatterns) {
		//
		//	Populate the targetVariable2sourceVariable2paths from the simple "a.b = c" style predicates,
		//	and cache those that are too hard to analyze as complex predicates.
		//
		for (CorePattern corePattern : corePatterns) {
			for (@NonNull Variable variable : ClassUtil.nullFree(corePattern.getVariable())) {
				if (corePattern instanceof GuardPattern) {
					Nodes.GUARD.createSimpleNode(this, variable);
				}
				else {
					OCLExpression ownedInit = variable.getOwnedInit();
					if (ownedInit != null) {
						analyzeVariable(variable, ownedInit);
					}
					else {
						Nodes.GUARD.createSimpleNode(this, variable);		// FIXME ?? should have been guard not bottom
					}
				}
			}
		}
		for (@NonNull CorePattern corePattern : corePatterns) {
		 	for (@NonNull Predicate predicate : ClassUtil.nullFree(corePattern.getPredicate())) {
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
		for (OCLExpression expression = referenceExpression; expression instanceof NavigationCallExp; ) {
			NavigationCallExp navigationCallExp = (NavigationCallExp)expression;
			Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
			assert referredProperty != null;
			path.add(0, referredProperty);
			expression = navigationCallExp.getOwnedSource();
			if (expression instanceof VariableExp) {
				VariableDeclaration sourceVariable = ((VariableExp)expression).getReferredVariable();
				assert sourceVariable != null;
				addPredicateNavigation(sourceVariable, path, boundVariable);
			}
		}
	}

	private @NonNull SimpleNode analyzeVariable(@NonNull Variable variable, @NonNull OCLExpression ownedInit) {
		SimpleNode initNode = ownedInit.accept(expressionAnalyzer);
		assert initNode != null;
		if ((ownedInit instanceof OperationCallExp) && initNode.isOperation()) {
			if (QVTbaseUtil.isIdentification(((OperationCallExp)ownedInit).getReferredOperation())) {
				SimpleNode stepNode = Nodes.REALIZED_VARIABLE.createSimpleNode(this, variable);
				Edges.RESULT.createSimpleEdge(this, initNode, null, stepNode);
				initNode = stepNode;
			}
//			else if (variable.getType() instanceof CollectionType) {
//				SimpleNode stepNode = Nodes.ATTRIBUTE.createSimpleNode(this, variable, (OperationCallExp)ownedInit);
//				Edges.RESULT.createSimpleEdge(this, initNode, null, stepNode);
//				initNode = stepNode;
//			}
			else {
//				SimpleNode stepNode = Nodes.STEP.createSimpleNode(this, variable.getName(), (OperationCallExp)ownedInit, initNode);
				SimpleNode stepNode = Nodes.UNREALIZED_VARIABLE.createSimpleNode(this, variable);
				Edges.RESULT.createSimpleEdge(this, initNode, null, stepNode);
				initNode = stepNode;
			}
		}
		initNode.addTypedElement(variable);
		addVariableNode(variable, initNode);
		return initNode;
	}

	@Override
	public int compareTo(SimpleMappingRegion thatRegion) {
		return Integer.compare(getNaturalOrder(), thatRegion.getNaturalOrder());
	}

	public @NonNull SimpleNode createExtraGuard(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		if (extraNodes == null) {
			extraNodes = new ArrayList<@NonNull SimpleNode>();
		}
		SimpleNode extraGuardNode = Nodes.EXTRA_GUARD.createSimpleNode(this, "«extra-" + (extraNodes.size()+1) + "»", classDatumAnalysis);
		extraNodes.add(extraGuardNode);
		addHeadNode(extraGuardNode);
		return extraGuardNode;
	}
	
	/**
	 * Create a navigable path from startNode following the edges of protoPath, re-using edges and nodes where possible.
	 * Returns a mapping of the proto-edges to the created/re-used edges.
	 *
	protected @NonNull Map<SimpleEdge, SimpleEdge> createPath(@NonNull SimpleNode startNode, @NonNull List<SimpleNavigationEdge> protoPath) {
		Map<SimpleEdge, SimpleEdge> path = new HashMap<SimpleEdge, SimpleEdge>();
		SimpleRegion region = startNode.getRegion();
		SimpleNode sourceNode = startNode;
		for (SimpleNavigationEdge protoEdge : protoPath) {
			SimpleNavigationEdge edge = sourceNode.getNavigationEdge(protoEdge.getProperty());
			if (edge == null) {
				SimpleNode protoTarget = protoEdge.getTarget();
				SimpleNode targetNode = protoTarget.getNodeRole().createSimpleNode(region, protoTarget.getName(), protoTarget.getClassDatumAnalysis());
				edge = ((NavigationEdgeRole)protoEdge.getEdgeRole()).createSimpleEdge(region, sourceNode, protoEdge.getProperty(), targetNode);
			}
			sourceNode = edge.getTarget();
			path.put(protoEdge, edge);
		}
		return path;
	} */

	@Override
	public @NonNull Iterable<@NonNull SimpleMappingRegion> getAllMappingRegions() {
		return Collections.singleton(this);
	}

	public @Nullable SimpleNode getExtraGuard(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		if (extraNodes != null) {
			for (@NonNull SimpleNode extraNode : extraNodes) {
				if (extraNode.getClassDatumAnalysis() == classDatumAnalysis) {
					return extraNode;
				}
			}
		}
		return null;
	}

	@Override
	public @NonNull String getName() {
		AbstractMapping mapping = mappingAction.getMapping();
		return String.valueOf(mapping.getName());
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
	public @NonNull Iterable<@NonNull MergeableRegion> getMergeableRegions() {
		return this;
	}

	public @NonNull SimpleNode getReferenceNode(@NonNull VariableDeclaration variable) {
		SimpleNode node = variable2simpleNode.get(variable);
		if (node == null) {
			if (variable instanceof Variable) {
				OCLExpression ownedInit = ((Variable)variable).getOwnedInit();
				if (ownedInit != null) {
					node = analyzeVariable((Variable) variable, ownedInit);
				}
			}
		}
		assert node != null : "No variable2simpleNode entry for " + variable;
		return node;
/*		if (variable instanceof RealizedVariable) {
			return Nodes.REALIZED_VARIABLE.createNode(this, (RealizedVariable)variable);
		}
		else if (variable.eContainer() instanceof BottomPattern) {
			return Nodes.UNREALIZED_VARIABLE.createNode(this, variable);
		}
		else {
			return new GuardVariableNode(this, variable);
		} */
	}

	public @Nullable SimpleNode getSimpleNode(@NonNull TypedElement typedElement) {
		return variable2simpleNode.get(typedElement);
	}

	public @NonNull List<? extends Region> getSuccessors() {
		List<SimpleMappingRegion> successors2 = successors;
		if (successors2 == null) {
			successors = successors2 = new ArrayList<SimpleMappingRegion>();
			for (AbstractDatum production : mappingAction.getProductions()) {
				for (@SuppressWarnings("null")@NonNull AbstractAction nextAction : production.getRequiredBy()) {
					SimpleMappingRegion nextRegion = getMappingRegion(nextAction);
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
	public Iterator<@NonNull MergeableRegion> iterator() {
		return new SingletonIterator<@NonNull MergeableRegion>(this);
	}

	public void mergeInto(@NonNull SimpleNode unwantedNode, @NonNull SimpleNode wantedNode) {
		// FIXME this should be a deep merge of equivalence
		for (@NonNull Edge unwantedEdge : new ArrayList<@NonNull Edge>(unwantedNode.getIncomingEdges())) {
			boolean moveIt = true;
			if (unwantedEdge instanceof NavigationEdge) {
				NavigationEdge unwantedNavigationEdge = (NavigationEdge)unwantedEdge;
				NavigationEdge wantedNavigationEdge = wantedNode.getNavigationEdge(unwantedNavigationEdge.getProperty());
				if ((wantedNavigationEdge !=  null) && (unwantedNavigationEdge.getSource() == wantedNavigationEdge.getSource())) {
					assert !unwantedNavigationEdge.isRealized();
					moveIt = false;
				}
			}
			if (moveIt) {
				unwantedEdge.setSource(wantedNode);
			}
		}
		for (@NonNull Edge unwantedEdge : new ArrayList<@NonNull Edge>(unwantedNode.getOutgoingEdges())) {
			boolean moveIt = true;
			if (unwantedEdge instanceof NavigationEdge) {
				NavigationEdge unwantedNavigationEdge = (NavigationEdge)unwantedEdge;
				NavigationEdge wantedNavigationEdge = wantedNode.getNavigationEdge(unwantedNavigationEdge.getProperty());
				if ((wantedNavigationEdge !=  null) && (unwantedNavigationEdge.getTarget() == wantedNavigationEdge.getTarget())) {
					assert !unwantedNavigationEdge.isRealized();
					moveIt = false;
				}
			}
			if (moveIt) {
				unwantedEdge.setTarget(wantedNode);
			}
		}
		unwantedNode.destroy();
	}

	public void registerConsumptionsAndProductions() {
		for (@NonNull Node assignedNode : getComputedNodes()) {
			ClassDatumAnalysis classDatumAnalysis = assignedNode.getClassDatumAnalysis();
			classDatumAnalysis.addProduction(this, assignedNode);
			ClassDatum classDatum = classDatumAnalysis.getClassDatum();
			for (@SuppressWarnings("null")@NonNull AbstractAction consumingAction : classDatum.getRequiredBy()) {
				SimpleMappingRegion consumingRegion = superRegion.getMappingRegion(consumingAction);
				assert consumingRegion != null;
				for (@NonNull Node consumingNode : consumingRegion.getMatchableNodes()) {
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
				SimpleMappingRegion producingRegion = superRegion.getMappingRegion(introducingAction);
				assert producingRegion != null;
				for (@NonNull Node assignedNode : producingRegion.getComputedNodes()) {
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