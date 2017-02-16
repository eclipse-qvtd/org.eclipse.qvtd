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
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.ArrayList;
import java.util.HashSet;
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
import org.eclipse.ocl.pivot.utilities.Nameable;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.ClassDatumAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.MappingRegion;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.ScheduleModel;
import org.eclipse.qvtd.pivot.qvtschedule.impl.BasicMappingRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;

/**
 * A BasicMappingRegion provides the initial QVTs node-edge graph representation of a QVTm mapping.
 */
public class MappingAnalysis implements Nameable
{
	public static @NonNull MappingAnalysis createMappingRegion(@NonNull ScheduleManager scheduleManager, @NonNull Mapping mapping) {
		MappingAnalysis mappingAnalysis = new MappingAnalysis(scheduleManager.getScheduleModel(), mapping);
		@SuppressWarnings("unused")String name = mappingAnalysis.getMappingRegion().getName();
		mappingAnalysis.initialize();
		return mappingAnalysis;
	}

	private final @NonNull BasicMappingRegionImpl mappingRegion;

	/**
	 * Predicates that are too complex to analyze. i.e. more than a comparison of a bound variable wrt
	 * a property call chain on another bound variable.
	 */
	private final @NonNull Set<@NonNull Predicate> complexPredicates = new HashSet<>();

	private final @NonNull ExpressionAnalyzer expressionAnalyzer;

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
	 * The dependency heads to accommodate operation content.
	 */
	private /*@LazyNonNull*/ List<@NonNull Node> dependencyHeadNodes = null;

	private MappingAnalysis(@NonNull ScheduleModel scheduleModel, @NonNull Mapping mapping) {
		this.mappingRegion = (BasicMappingRegionImpl) QVTscheduleFactory.eINSTANCE.createBasicMappingRegion();
		mappingRegion.setFixmeScheduleModel(scheduleModel);
		mappingRegion.setMapping(mapping);
		this.expressionAnalyzer = new ExpressionAnalyzer(this);
		//
		guardPatterns.add(ClassUtil.nonNull(mapping.getGuardPattern()));
		bottomPatterns.add(ClassUtil.nonNull(mapping.getBottomPattern()));
		for (Domain domain : mapping.getDomain()) {
			if (domain instanceof CoreDomain) {
				CoreDomain coreDomain = (CoreDomain)domain;
				//
				GuardPattern guardPattern = ClassUtil.nonNull(coreDomain.getGuardPattern());
				BottomPattern bottomPattern = ClassUtil.nonNull(coreDomain.getBottomPattern());
				guardPatterns.add(guardPattern);
				bottomPatterns.add(bottomPattern);
				for (@NonNull Assignment assignment : ClassUtil.nullFree(bottomPattern.getAssignment())) {
					if (assignment instanceof NavigationAssignment) {
						navigationAssignments.add((NavigationAssignment)assignment);
					}
				}
			}
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
							RegionUtil.ARGUMENT.createEdge(this, leftNode, "=", rightNode);
						}
						else if (rightNode.isKnown() && !(rightExpression instanceof NavigationCallExp)) {
							RegionUtil.ARGUMENT.createEdge(this, rightNode, "=", leftNode);
						}
						else if (leftNode.isKnown()) {
							RegionUtil.ARGUMENT.createEdge(this, leftNode, "=", rightNode);
						}
						else if (rightNode.isKnown()) {
							RegionUtil.ARGUMENT.createEdge(this, rightNode, "=", leftNode);
						}
						else {
							RegionUtil.BINDING.createEdge(this, leftNode, null, rightNode);			// FIXME
							RegionUtil.BINDING.createEdge(this, rightNode, null, leftNode);
						}
					}
				}
			}
			else { */
			Node resultNode = expressionAnalyzer.analyze(conditionExpression);
			if (!resultNode.isTrue()) {
				Node trueNode = RegionUtil.createTrueNode(mappingRegion);
				RegionUtil.createPredicateEdge(resultNode, null, trueNode);
			}
			else {		// FIXME ?? do includes() here explicitly
				resultNode.destroy();
			}
			//			}
		}
	}

	protected void analyzeContainments() {
		for (@NonNull Node node : mappingRegion.getNewNodes()) {
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
				Node guardNode = mappingRegion.getNode(guardVariable);
				assert guardNode == null;
				guardNode = RegionUtil.createOldNode(mappingRegion, guardVariable);
				assert guardNode == mappingRegion.getNode(guardVariable);
			}
		}
	}

	/**
	 * Analyze the initializers to form predicates / computations.
	 */
	protected void analyzeInitializers(@NonNull Iterable<@NonNull ? extends CorePattern> corePatterns) {
		for (@NonNull CorePattern corePattern : corePatterns) {
			for (@NonNull Variable variable : ClassUtil.nullFree(corePattern.getVariable())) {
				OCLExpression ownedInit = variable.getOwnedInit();
				if (ownedInit != null) {
					analyzeVariable(variable, ownedInit);
				}
			}
			if (corePattern instanceof BottomPattern) {
				for (@NonNull RealizedVariable realizedVariable : ClassUtil.nullFree(((BottomPattern)corePattern).getRealizedVariable())) {
					OCLExpression ownedInit = realizedVariable.getOwnedInit();
					if (ownedInit != null) {
						analyzeVariable(realizedVariable, ownedInit);
					}
				}
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

	/**
	 * Create a GREEN node for each realized variable.
	 */
	protected void analyzeRealizedVariables() {
		for (@NonNull BottomPattern bottomPattern : bottomPatterns) {
			for (@NonNull RealizedVariable realizedVariable : ClassUtil.nullFree(bottomPattern.getRealizedVariable())) {
				Node realizedNode = mappingRegion.getNode(realizedVariable);
				assert realizedNode == null;
				realizedNode = RegionUtil.createRealizedStepNode(mappingRegion, realizedVariable);
				assert realizedNode == mappingRegion.getNode(realizedVariable);
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
	private void analyzeSimplePredicate(@Nullable VariableDeclaration boundVariable, @NonNull OCLExpression referenceExpression) {
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
				Node targetNode = boundVariable != null ? getReferenceNode(boundVariable) : RegionUtil.createNullNode(mappingRegion, true, null);
				//				assert sourceNode.isGuard();
				//				assert (boundVariable == null) || targetNode.isGuard();
				assert sourceNode.isClass();
				if (!referredProperty.isIsMany()) {
					Edge predicateEdge = sourceNode.getPredicateEdge(referredProperty);
					if (predicateEdge == null) {
						RegionUtil.createNavigationEdge(sourceNode, referredProperty, targetNode, false);
					}
					else {
						assert predicateEdge.getEdgeTarget() == targetNode;
					}
				}
			}
		}
	}

	private @NonNull Node analyzeVariable(@NonNull Variable variable, @NonNull OCLExpression ownedInit) {
		Node initNode = ownedInit.accept(expressionAnalyzer);
		assert initNode != null;
		if ((ownedInit instanceof OperationCallExp) && initNode.isOperation()) {
			if (QVTbaseUtil.isIdentification(((OperationCallExp)ownedInit).getReferredOperation())) {
				Node stepNode = RegionUtil.createRealizedStepNode(mappingRegion, variable);
				RegionUtil.createExpressionEdge(initNode, QVTscheduleConstants.EQUALS_NAME, stepNode);
				initNode = stepNode;
			}
			//			else if (variable.getType() instanceof CollectionType) {
			//				Node stepNode = RegionUtil.ATTRIBUTE.createNode(this, variable, (OperationCallExp)ownedInit);
			//				RegionUtil.RESULT.createEdge(this, initNode, null, stepNode);
			//				initNode = stepNode;
			//			}
			else {
				//				Node stepNode = RegionUtil.STEP.createNode(this, variable.getName(), (OperationCallExp)ownedInit, initNode);
				Node stepNode = RegionUtil.createLoadedStepNode(mappingRegion, variable);
				RegionUtil.createExpressionEdge(initNode, QVTscheduleConstants.EQUALS_NAME, stepNode);
				initNode = stepNode;
			}
		}
		initNode.addTypedElement(variable);
		mappingRegion.addVariableNode(variable, initNode);
		return initNode;
	}

	public @NonNull Node createDependencyHead(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		if (dependencyHeadNodes == null) {
			dependencyHeadNodes = new ArrayList<>();
		}
		Node dependencyHeadNode = RegionUtil.createDependencyNode(mappingRegion, "«extra-" + (dependencyHeadNodes.size()+1) + "»", classDatumAnalysis);
		dependencyHeadNode.setHead();
		dependencyHeadNodes.add(dependencyHeadNode);
		return dependencyHeadNode;
	}

	public @Nullable Node getDependencyHead(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		if (dependencyHeadNodes != null) {
			for (@NonNull Node dependencyHeadNode : dependencyHeadNodes) {
				if (RegionUtil.getClassDatumAnalysis(dependencyHeadNode) == classDatumAnalysis) {
					return dependencyHeadNode;
				}
			}
		}
		return null;
	}

	public @NonNull MappingRegion getMappingRegion() {
		return mappingRegion;
	}

	@Override
	public @NonNull String getName() {
		return RegionUtil.getName(mappingRegion);
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
			if (PivotUtil.isSameOperation(operationId, RegionUtil.getScheduleManager(mappingRegion).getStandardLibraryHelper().getOclAnyEqualsId())) {
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
			if (PivotUtil.isSameOperation(operationId, RegionUtil.getScheduleManager(mappingRegion).getStandardLibraryHelper().getOclAnyEqualsId())) {
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

	public @NonNull Node getReferenceNode(@NonNull VariableDeclaration variableDeclaration) {
		Node node = mappingRegion.getNode(variableDeclaration);
		if (node == null) {
			if (variableDeclaration instanceof Variable) {
				Variable variable = (Variable)variableDeclaration;
				OCLExpression ownedInit = variable.getOwnedInit();
				if (ownedInit != null) {
					node = analyzeVariable(variable, ownedInit);
				}
				else if (variable.eContainer() instanceof BottomPattern) {
					DomainUsage domainUsage = RegionUtil.getScheduleManager(mappingRegion).getDomainUsage(variable);
					boolean isEnforceable = domainUsage.isOutput() || domainUsage.isMiddle();
					if (isEnforceable) {
						node = RegionUtil.createRealizedStepNode(mappingRegion, variable);
					}
					else {
						node = RegionUtil.createLoadedStepNode(mappingRegion, variable);		// FIXME Predicated ??
					}
				}
			}
		}
		assert node != null : "No variable2simpleNode entry for " + variableDeclaration;
		return node;
		/*		if (variable instanceof RealizedVariable) {
			return RegionUtil.REALIZED_VARIABLE.createNode(this, (RealizedVariable)variable);
		}
		else if (variable.eContainer() instanceof BottomPattern) {
			return RegionUtil.UNREALIZED_VARIABLE.createNode(this, variable);
		}
		else {
			return new GuardVariableNode(this, variable);
		} */
	}

	public @NonNull Node getUnknownNode(@NonNull TypedElement typedElement) {
		assert !(typedElement instanceof Property);		// Property entries should be AttributeNodes
		Node node = mappingRegion.getNode(typedElement);
		if (node == null) {
			node = RegionUtil.createUnknownNode(mappingRegion, ClassUtil.nonNullState(typedElement.getType().toString()), typedElement);
			//			node2node.put(typedElement, node);
		}
		return node;
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
		// Create the initialization/predicate/computation nodes and edges
		//
		analyzeInitializers(guardPatterns);
		analyzeInitializers(bottomPatterns);
		analyzePredicates(guardPatterns);
		analyzePredicates(bottomPatterns);
		analyzeAssignmentValues();
		analyzeComplexPredicates();
		analyzeContainments();
		//
		Iterable<@NonNull Node> headNodes = RegionUtil.getHeadNodes(mappingRegion);
		mappingRegion.computeUtilities(headNodes);
	}

	/**
	 * Return true if the navigation from sourceNode using source2targetProperty corresponds to a PropertyAssigmment,
	 */
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
		for (@NonNull Node newNode : mappingRegion.getNewNodes()) {
			ClassDatumAnalysis classDatumAnalysis = RegionUtil.getClassDatumAnalysis(newNode);
			classDatumAnalysis.addProduction(mappingRegion, newNode);
			for (@NonNull Mapping consumingMapping : classDatumAnalysis.getRequiredBy()) {
				MappingRegion consumingRegion = qvtm2qts.getMappingRegion(consumingMapping);
				for (@NonNull Node consumingNode : consumingRegion.getOldNodes()) {
					if (consumingNode.getCompleteClass() == classDatumAnalysis.getClassDatum().getCompleteClass()) {		// FIXME inheritance
						classDatumAnalysis.addConsumption(consumingRegion, consumingNode);
					}
				}
			}
		}
		for (@NonNull Node predicatedNode : mappingRegion.getOldNodes()) {
			ClassDatumAnalysis classDatumAnalysis = RegionUtil.getClassDatumAnalysis(predicatedNode);
			classDatumAnalysis.addConsumption(mappingRegion, predicatedNode);
			for (@NonNull Mapping producingMapping : classDatumAnalysis.getProducedBy()) {
				MappingRegion producingRegion = qvtm2qts.getMappingRegion(producingMapping);
				assert producingRegion != null;
				for (@NonNull Node newNode : producingRegion.getNewNodes()) {
					if (newNode.getCompleteClass() == classDatumAnalysis.getClassDatum().getCompleteClass()) {		// FIXME inheritance
						classDatumAnalysis.addProduction(producingRegion, newNode);
					}
				}
			}
		}
	}
}