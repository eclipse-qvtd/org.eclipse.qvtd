/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A MappingAnalysis provides the analysis a QVTc mapping.
 */
public class MappingAnalysis extends RuleAnalysis
{
	public static @NonNull MappingAnalysis createMappingRegion(@NonNull ScheduleManager scheduleManager, @NonNull RuleRegion ruleRegion) {
		MappingAnalysis mappingAnalysis = new MappingAnalysis(scheduleManager, ruleRegion);
		@SuppressWarnings("unused")String name = mappingAnalysis.getRuleRegion().getName();
		mappingAnalysis.initialize();
		return mappingAnalysis;
	}

	/**
	 * Predicates that are too complex to analyze. i.e. more than a comparison of a bound variable wrt
	 * a property call chain on another bound variable.
	 */
	private final @NonNull Set<@NonNull Predicate> complexPredicates = new HashSet<>();

	/**
	 * All the guard patterns. (domain and mapping).
	 */
	private final @NonNull List<@NonNull GuardPattern> guardPatterns = new ArrayList<>();

	/**
	 * All the bottom patterns. (domain and mapping).
	 */
	private final @NonNull List<@NonNull BottomPattern> bottomPatterns = new ArrayList<>();

	/**
	 * The node for each navigable VariableDeclaration.
	 */
	private final @NonNull List<@NonNull NavigationAssignment> navigationAssignments = new ArrayList<>();

	/**
	 * The variable initializers, simple predicate reference expression and variable assignment values that define a value for each variable.
	 * Variable initializers are populated lazily since not all LetVariables may even exist for an eager population.
	 */
	private @NonNull Map<@NonNull VariableDeclaration, @NonNull List<@NonNull OCLExpression>> variable2expressions = new HashMap<>();

	private MappingAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull RuleRegion ruleRegion) {
		super(scheduleManager, ruleRegion);
		//
		Mapping mapping = (Mapping)QVTscheduleUtil.getReferredRule(ruleRegion);
		GuardPattern guardPattern = QVTcoreUtil.getGuardPattern(mapping);
		BottomPattern bottomPattern = QVTcoreUtil.getBottomPattern(mapping);
		guardPatterns.add(guardPattern);
		bottomPatterns.add(bottomPattern);
		for (@NonNull Assignment assignment : QVTcoreUtil.getOwnedAssignments(bottomPattern)) {
			if (assignment instanceof NavigationAssignment) {
				navigationAssignments.add((NavigationAssignment)assignment);
			}
			else if (assignment instanceof VariableAssignment) {
				VariableAssignment variableAssignment = (VariableAssignment)assignment;
				addExpression(QVTcoreUtil.getTargetVariable(variableAssignment), QVTcoreUtil.getValue(variableAssignment));
			}
		}
		for (@NonNull CoreDomain coreDomain : QVTcoreUtil.getOwnedDomains(mapping)) {
			guardPattern = QVTcoreUtil.getGuardPattern(coreDomain);
			bottomPattern = QVTcoreUtil.getBottomPattern(coreDomain);
			guardPatterns.add(guardPattern);
			bottomPatterns.add(bottomPattern);
			for (@NonNull Assignment assignment : QVTcoreUtil.getOwnedAssignments(bottomPattern)) {
				if (assignment instanceof NavigationAssignment) {
					navigationAssignments.add((NavigationAssignment)assignment);
				}
				else if (assignment instanceof VariableAssignment) {
					VariableAssignment variableAssignment = (VariableAssignment)assignment;
					addExpression(QVTcoreUtil.getTargetVariable(variableAssignment), QVTcoreUtil.getValue(variableAssignment));
				}
			}
		}
	}

	protected void addExpression(@NonNull VariableDeclaration variable, @NonNull OCLExpression expression) {
		List<@NonNull OCLExpression> initializers = variable2expressions.get(variable);
		if (initializers == null) {
			initializers = new ArrayList<>();
			variable2expressions.put(variable, initializers);
		}
		if (!initializers.contains(expression)) {	// Shouldn't really happen but variable.ownedIInit is lazy
			initializers.add(expression);
		}
	}

	/**
	 * Create the BLUE/CYAN computations for the RHS of assignments.
	 */
	protected void analyzeAssignmentValues() {
		AssignmentSorter assignmentSorter = new AssignmentSorter();
		for (@NonNull BottomPattern bottomPattern : bottomPatterns) {
			assignmentSorter.addAll(ClassUtil.nullFree(bottomPattern.getAssignment()));
		}
		for (@NonNull Assignment assignment : assignmentSorter.getSortedAssignments()) {
			assignment.accept(expressionAnalyzer);
		}
	}

	protected void analyzeComplexPredicates() {
		/**
		 * Identify any assignments and hidden inputs.
		 */
		for (Predicate predicate : complexPredicates) {
			OCLExpression conditionExpression = predicate.getConditionExpression();
			/*			if (conditionExpression instanceof OperationCallExp) {
				OperationCallExp callExp = (OperationCallExp)conditionExpression;
				OperationId operationId = callExp.getReferredOperation().getOperationId();
				if (ScheduleModel.isSameOperation(operationId, getScheduleModel().getOclAnyEqualsId())) {
					OCLExpression leftExpression = callExp.getOwnedSource();
					OCLExpression rightExpression = callExp.getOwnedArguments().get(0);
					Node leftNode = expressionAnalyzer.analyze(leftExpression);
					Node rightNode = expressionAnalyzer.analyze(rightExpression);
					if (leftNode != rightNode) {
						if (leftNode.isKnown() && !(leftExpression instanceof NavigationCallExp)) {
							QVTscheduleUtil.ARGUMENT.createEdge(this, leftNode, "=", rightNode);
						}
						else if (rightNode.isKnown() && !(rightExpression instanceof NavigationCallExp)) {
							QVTscheduleUtil.ARGUMENT.createEdge(this, rightNode, "=", leftNode);
						}
						else if (leftNode.isKnown()) {
							QVTscheduleUtil.ARGUMENT.createEdge(this, leftNode, "=", rightNode);
						}
						else if (rightNode.isKnown()) {
							QVTscheduleUtil.ARGUMENT.createEdge(this, rightNode, "=", leftNode);
						}
						else {
							QVTscheduleUtil.BINDING.createEdge(this, leftNode, null, rightNode);			// FIXME
							QVTscheduleUtil.BINDING.createEdge(this, rightNode, null, leftNode);
						}
					}
				}
			}
			else { */
			Node resultNode = conditionExpression.accept(expressionAnalyzer);
			if ((resultNode != null) && !resultNode.isTrue()) {
				Node trueNode = regionHelper.createTrueNode();
				regionHelper.createPredicateEdge(resultNode, null, trueNode);
			}
			// FIXME ?? do includes() here explicitly
		}
	}

	protected void analyzeContainments() {
		for (@NonNull Node node : ruleRegion.getNewNodes()) {
			boolean isContained = false;
			for (@NonNull NavigableEdge edge : node.getNavigationEdges()) {
				Property property = edge.getProperty();
				Property opposite = property.getOpposite();
				if ((opposite != null) && opposite.isIsComposite() && !edge.getEdgeTarget().isExplicitNull()) {
					isContained = true;
					break;
				}
			}
			if (isContained) {
				node.setContained(true);
			}
		}
	}

	/**
	 * Create a BLUE/CYAN node for each guard variable.
	 */
	protected void analyzeGuardVariables() {
		for (@NonNull GuardPattern guardPattern : guardPatterns) {
			for (@NonNull Variable guardVariable : ClassUtil.nullFree(guardPattern.getVariable())) {
				Node guardNode = ruleRegion.getNode(guardVariable);
				assert guardNode == null;
				guardNode = regionHelper.createOldNode(guardVariable);
				assert guardNode == ruleRegion.getNode(guardVariable);
			}
		}
	}

	/**
	 * Analyze the predicates to partition the guard variables into the distinct inputs that are not mutually
	 * navigable as a consequence of predicate constraints.
	 * @param bottomPatterns
	 */
	protected void analyzePredicates(@NonNull List<@NonNull ? extends CorePattern> corePatterns) {
		//
		//	Populate the targetVariable2sourceVariable2paths from the simple "a.b = c" style predicates,
		//	and cache those that are too hard to analyze as complex predicates.
		//
		for (@NonNull CorePattern corePattern : corePatterns) {
			for (@NonNull Predicate predicate : ClassUtil.nullFree(corePattern.getPredicate())) {
				OCLExpression conditionExpression = predicate.getConditionExpression();
				if (conditionExpression != null) {
					OCLExpression boundExpression = getPredicateComparisonBoundExpression(conditionExpression);
					if (boundExpression instanceof VariableExp) {
						OCLExpression referenceExpression = getPredicateComparisonReferenceExpression(conditionExpression);
						assert referenceExpression != null;
						VariableDeclaration referredVariable = QVTcoreUtil.getReferredVariable(((VariableExp)boundExpression));
						//						if (referredVariable instanceof BottomVariable) {
						//							addExpression(referredVariable, referenceExpression);
						//						}
						//						else {
						if (!analyzeSimplePredicate(referredVariable, referenceExpression)) {
							complexPredicates.add(predicate);
						}
						//						}
					}
					else if (boundExpression instanceof NullLiteralExp) {
						OCLExpression referenceExpression = getPredicateComparisonReferenceExpression(conditionExpression);
						assert referenceExpression != null;
						if (!analyzeSimplePredicate(null, referenceExpression)) {
							complexPredicates.add(predicate);
						}
					}
					else {
						complexPredicates.add(predicate);
					}
				}
			}
		}
		return;
	}

	/**
	 * Create a GREEN node for each realized variable.
	 */
	protected void analyzeRealizedVariables() {
		for (@NonNull BottomPattern bottomPattern : bottomPatterns) {
			for (@NonNull RealizedVariable realizedVariable : ClassUtil.nullFree(bottomPattern.getRealizedVariable())) {
				Node realizedNode = ruleRegion.getNode(realizedVariable);
				assert realizedNode == null;
				realizedNode = regionHelper.createRealizedStepNode(realizedVariable);
				assert realizedNode == ruleRegion.getNode(realizedVariable);
			}
		}
	}

	//
	//	Install the targetVariable2sourceVariable2paths entries for a "boundVariable = referenceExpression" predicate,
	//	where the referenceExpression involves zero or more PropertyCallExps of a VariableExp. boundVariable may be null
	//	for a negative application condition.
	//
	//	A reverse entry is also created if no PropertyCallExp is not to-one.
	//
	private boolean analyzeSimplePredicate(@Nullable VariableDeclaration boundVariable, @NonNull OCLExpression referenceExpression) {
		boolean isValid = false;
		for (@NonNull OCLExpression expression = referenceExpression; expression instanceof NavigationCallExp; ) {
			NavigationCallExp navigationCallExp = (NavigationCallExp)expression;
			expression = ClassUtil.nonNullState(navigationCallExp.getOwnedSource());
			if (expression instanceof VariableExp) {
				isValid = true;
				break;
			}
		}
		if (!isValid) {
			return false;
		}
		for (@NonNull OCLExpression expression = referenceExpression; expression instanceof NavigationCallExp; ) {
			NavigationCallExp navigationCallExp = (NavigationCallExp)expression;
			Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
			assert referredProperty != null;
			expression = ClassUtil.nonNullState(navigationCallExp.getOwnedSource());
			if (expression instanceof VariableExp) {
				VariableDeclaration sourceVariable = ((VariableExp)expression).getReferredVariable();
				assert sourceVariable != null;
				//		assert guardVariables.contains(targetVariable);
				//		assert guardVariables.contains(sourceVariable);
				Node sourceNode = getReferenceNode(sourceVariable);
				Node targetNode = boundVariable != null ? getReferenceNode(boundVariable) : regionHelper.createNullNode(true, null);
				//				assert sourceNode.isGuard();
				//				assert (boundVariable == null) || targetNode.isGuard();
				assert sourceNode.isClass();
				if (!referredProperty.isIsMany()) {
					Edge predicateEdge = sourceNode.getPredicateEdge(referredProperty);
					if (predicateEdge == null) {
						regionHelper.createNavigationEdge(sourceNode, referredProperty, targetNode, false);
					}
					else {
						assert predicateEdge.getEdgeTarget() == targetNode;
					}
				}
			}
		}
		return true;
	}

	private @Nullable Node analyzeVariable(@NonNull Variable variable, @NonNull List<@NonNull OCLExpression> expressions) {
		//
		//	Use something hard to compute as the initializer that creates an initNode in the hope that other
		//	initializers might be easier and optimized as simple navigation edges.
		//
		OCLExpression bestInitExpression = null;
		for (@NonNull OCLExpression initExpression : expressions) {
			if (initExpression instanceof OperationCallExp ) {
				OperationCallExp operationCallExp = (OperationCallExp)initExpression;
				OperationId operationId = operationCallExp.getReferredOperation().getOperationId();
				if (!PivotUtil.isSameOperation(operationId, OperationId.OCLANY_EQUALS) && !PivotUtil.isSameOperation(operationId, OperationId.OCLANY_NOT_EQUALS)) {
					bestInitExpression = initExpression;
					break;
				}
			}
		}
		if (bestInitExpression == null) {
			bestInitExpression = (expressions.size() > 0) ? expressions.get(0) : null;
		}
		if (bestInitExpression == null) {
			return null;
		}
		Node bestInitNode = bestInitExpression.accept(expressionAnalyzer);
		assert bestInitNode != null;
		/*		if ((ownedInit instanceof OperationCallExp) && initNode.isOperation()) {
			if (QVTbaseUtil.isIdentification(((OperationCallExp)ownedInit).getReferredOperation())) {
				Node stepNode = QVTscheduleUtil.createRealizedStepNode(mappingRegion, variable);
				QVTscheduleUtil.createEqualsEdge(initNode, stepNode);
				initNode = stepNode;
			}
			//			else if (variable.getType() instanceof CollectionType) {
			//				Node stepNode = QVTscheduleUtil.ATTRIBUTE.createNode(this, variable, (OperationCallExp)ownedInit);
			//				QVTscheduleUtil.RESULT.createEdge(this, initNode, null, stepNode);
			//				initNode = stepNode;
			//			}
			else {
				//				Node stepNode = QVTscheduleUtil.STEP.createNode(this, variable.getName(), (OperationCallExp)ownedInit, initNode);
				Node stepNode = QVTscheduleUtil.createLoadedStepNode(mappingRegion, variable);
				QVTscheduleUtil.createEqualsEdge(initNode, stepNode);
				initNode = stepNode;
			}
		} */
		CompleteClass initCompleteClass = bestInitNode.getCompleteClass();
		ClassDatum variableClassDatum = scheduleManager.getClassDatum(variable);
		CompleteClass variableCompleteClass = QVTscheduleUtil.getCompleteClass(variableClassDatum);
		if (!initCompleteClass.conformsTo(variableCompleteClass)) {
			Node castNode = regionHelper.createOldNode(variable);
			Property castProperty = scheduleManager.getCastProperty(PivotUtil.getType(variable));
			expressionAnalyzer.createCastEdge(bestInitNode, castProperty, castNode);
			bestInitNode = castNode;
		}
		bestInitNode.addTypedElement(variable);
		ruleRegion.addVariableNode(variable, bestInitNode);
		for (@NonNull OCLExpression initExpression : expressions) {
			if (initExpression != bestInitExpression) {
				// FIXME if the extra init is a navigation we can add a navigation to the bestInitNode
				Node initNode = bestInitExpression.accept(expressionAnalyzer);
				assert initNode != null;
				regionHelper.createEqualsEdge(bestInitNode, initNode);
			}
		}
		return bestInitNode;
	}

	/**
	 * Return the boundExpression if conditionExpression is of the form
	 * <br>"variable = referenceExpression" => VariableExp(variable)
	 * <br>"referenceExpression = variable" => VariableExp(variable)
	 * <br>"null = referenceExpression" => NullLiteralExp(null)
	 * <br>"referenceExpression = null" => NullLiteralExp(null)
	 * <br>"constant-expression = referenceExpression" => OCLExpression(constant)
	 * <br>"referenceExpression = constant-expression" => OCLExpression(constant)
	 *
	 * <br>Returns null otherwise.
	 */
	private @Nullable OCLExpression getPredicateComparisonBoundExpression(@NonNull OCLExpression conditionExpression) {
		if (conditionExpression instanceof OperationCallExp) {
			OperationCallExp callExp = (OperationCallExp)conditionExpression;
			OperationId operationId = callExp.getReferredOperation().getOperationId();
			if (PivotUtil.isSameOperation(operationId, scheduleManager.getStandardLibraryHelper().getOclAnyEqualsId())) {
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
			if (PivotUtil.isSameOperation(operationId, scheduleManager.getStandardLibraryHelper().getOclAnyEqualsId())) {
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
	public @NonNull Node getReferenceNode(@NonNull VariableDeclaration variableDeclaration) {
		Node node = ruleRegion.getNode(variableDeclaration);
		if (node == null) {
			if (variableDeclaration instanceof Variable) {
				Variable variable = (Variable)variableDeclaration;
				OCLExpression ownedInit = variable.getOwnedInit();
				if (ownedInit != null) {
					addExpression(variable, ownedInit);
				}
				List<@NonNull OCLExpression> expressions = variable2expressions.get(variable);
				if (expressions != null) {
					node = analyzeVariable(variable, expressions);
				}
				else if (variable.eContainer() instanceof BottomPattern) {
					DomainUsage domainUsage = scheduleManager.getDomainUsage(variable);
					boolean isEnforceable = domainUsage.isOutput() || domainUsage.isMiddle();
					if (isEnforceable) {
						//						assert variable instanceof RealizedVariable;
						if (!(variable instanceof RealizedVariable)) {
							scheduleManager.addRegionError(ruleRegion, "Enforceable variable ''{0}'' has not been realized in ''{1}''", variable, ruleRegion);
						}
						node = regionHelper.createRealizedStepNode(variable);
					}
					else {
						node = regionHelper.createLoadedStepNode(variable);		// FIXME Predicated ??
					}
				}
			}
		}
		assert node != null : "No variable2simpleNode entry for " + variableDeclaration;
		return node;
		/*		if (variable instanceof RealizedVariable) {
			return QVTscheduleUtil.REALIZED_VARIABLE.createNode(this, (RealizedVariable)variable);
		}
		else if (variable.eContainer() instanceof BottomPattern) {
			return QVTscheduleUtil.UNREALIZED_VARIABLE.createNode(this, variable);
		}
		else {
			return new GuardVariableNode(this, variable);
		} */
	}

	public void initialize() {
		//
		// Create the BLUE/CYAN guard nodes.
		//
		analyzeGuardVariables();
		//
		// Create the GREEN realized nodes.
		//
		analyzeRealizedVariables();		// FIXME bottom variables too
		//
		// Create the predicate/computation nodes and edges
		//
		analyzePredicates(guardPatterns);
		analyzePredicates(bottomPatterns);
		analyzeAssignmentValues();
		analyzeComplexPredicates();
		analyzeContainments();
		//
		MappingRegionAnalysis mappingRegionAnalysis = new MappingRegionAnalysis(ruleRegion);
		List<@NonNull Node> headNodes = mappingRegionAnalysis.initHeadNodes(null);
		mappingRegionAnalysis.computeUtilities(headNodes);
	}

	/**
	 * Return true if the navigation from sourceNode using source2targetProperty corresponds to a PropertyAssigmment,
	 */
	@Override
	public boolean isPropertyAssignment(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		if (sourceNode.isRealized()) {
			for (@NonNull NavigationAssignment navigationAssignment : navigationAssignments) {
				Property navigationProperty = QVTcoreUtil.getTargetProperty(navigationAssignment);
				if (source2targetProperty == navigationProperty) {		// ??? opposites ??? do they even exist ???
					Node slotNode = expressionAnalyzer.analyze(navigationAssignment.getSlotExpression());
					if (slotNode == sourceNode) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public void registerConsumptionsAndProductions(@NonNull QVTm2QVTs qvtm2qts) {
		for (@NonNull Node newNode : ruleRegion.getNewNodes()) {
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(newNode);
			classDatum.getProducingRegions().add(ruleRegion);
		}
		for (@NonNull Node predicatedNode : ruleRegion.getOldNodes()) {
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(predicatedNode);
			classDatum.getConsumingRegions().add(ruleRegion);
		}
	}
}