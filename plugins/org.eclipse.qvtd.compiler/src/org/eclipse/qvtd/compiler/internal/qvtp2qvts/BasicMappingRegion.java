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
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
import org.eclipse.qvtd.pivot.qvtcore.Assignment;
import org.eclipse.qvtd.pivot.qvtcore.BottomPattern;
import org.eclipse.qvtd.pivot.qvtcore.CoreDomain;
import org.eclipse.qvtd.pivot.qvtcore.CorePattern;
import org.eclipse.qvtd.pivot.qvtcore.GuardPattern;
import org.eclipse.qvtd.pivot.qvtcore.Mapping;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.RealizedVariable;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;

/**
 * A BasicMappingRegion provides the initial QVTs node-edge graph representation of a QVTp mapping.
 */
public class BasicMappingRegion extends AbstractMappingRegion
{
	public static @NonNull BasicMappingRegion createMappingRegion(@NonNull MultiRegion multiRegion, @NonNull Mapping mapping) {
		BasicMappingRegion mappingRegion = new BasicMappingRegion(multiRegion, mapping);
		mappingRegion.initialize();
		return mappingRegion;
	}

	/**
	 * The analyzed mapping.
	 */
	private final @NonNull Mapping mapping;

	/**
	 * Predicates that are too complex to analyze. i.e. more than a comparison of a bound variable wrt
	 * a property call chain on another bound variable.
	 */
	private final @NonNull Set<@NonNull Predicate> complexPredicates = new HashSet<>();

	private final @NonNull ExpressionAnalyzer expressionAnalyzer = new ExpressionAnalyzer(this);

	/**
	 * All the guardpatterns. (domain and mapping).
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
	 * The node for each navigable VariableDeclaration.
	 */
	private final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> variable2node = new HashMap<>();

	/**
	 * The dependency heads to accommodate operation content.
	 */
	private /*@LazyNonNull*/ List<@NonNull Node> dependencyHeadNodes = null;

	private BasicMappingRegion(@NonNull MultiRegion multiRegion, @NonNull Mapping mapping) {
		super(multiRegion);
		this.mapping = mapping;
		assert mapping != null;
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

	@Override
	public void addVariableNode(@NonNull VariableDeclaration typedElement, @NonNull Node simpleNode) {
		//		assert !simpleNode.isOperation();			// FIXME testExample2_V2 violates this for an intermediate "if"
		variable2node.put(typedElement, simpleNode);
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
				if (SchedulerConstants.isSameOperation(operationId, getSchedulerConstants().getOclAnyEqualsId())) {
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
				Node trueNode = RegionUtil.createTrueNode(this);
				RegionUtil.createPredicateEdge(resultNode, null, trueNode);
			}
			else {		// FIXME ?? do includes() here explicitly
				resultNode.destroy();
			}
			//			}
		}
	}

	/**
	 * Create a BLUE/CYAN node for each guard variable.
	 */
	protected void analyzeGuardVariables() {
		for (@NonNull GuardPattern guardPattern : guardPatterns) {
			for (@NonNull Variable guardVariable : ClassUtil.nullFree(guardPattern.getVariable())) {
				Node guardNode = getNode(guardVariable);
				assert guardNode == null;
				guardNode = RegionUtil.createOldNode(this, guardVariable);
				assert guardNode == getNode(guardVariable);
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
				Node realizedNode = getNode(realizedVariable);
				assert realizedNode == null;
				realizedNode = RegionUtil.createRealizedStepNode(this, realizedVariable);
				assert realizedNode == getNode(realizedVariable);
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
				Node targetNode = boundVariable != null ? getReferenceNode(boundVariable) : RegionUtil.createNullNode(this, true, null);
				//				assert sourceNode.isGuard();
				//				assert (boundVariable == null) || targetNode.isGuard();
				assert sourceNode.isClass();
				if (!referredProperty.isIsMany()) {
					Edge predicateEdge = sourceNode.getPredicateEdge(referredProperty);
					if (predicateEdge == null) {
						RegionUtil.createNavigationEdge(sourceNode, referredProperty, targetNode);
					}
					else {
						assert predicateEdge.getTarget() == targetNode;
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
				Node stepNode = RegionUtil.createRealizedStepNode(this, variable);
				RegionUtil.createExpressionEdge(initNode, "«equals»", stepNode);
				initNode = stepNode;
			}
			//			else if (variable.getType() instanceof CollectionType) {
			//				Node stepNode = RegionUtil.ATTRIBUTE.createNode(this, variable, (OperationCallExp)ownedInit);
			//				RegionUtil.RESULT.createEdge(this, initNode, null, stepNode);
			//				initNode = stepNode;
			//			}
			else {
				//				Node stepNode = RegionUtil.STEP.createNode(this, variable.getName(), (OperationCallExp)ownedInit, initNode);
				Node stepNode = RegionUtil.createLoadedStepNode(this, variable);
				RegionUtil.createExpressionEdge(initNode, "«equals»", stepNode);
				initNode = stepNode;
			}
		}
		initNode.addTypedElement(variable);
		addVariableNode(variable, initNode);
		return initNode;
	}

	public @NonNull Node createDependencyHead(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		if (dependencyHeadNodes == null) {
			dependencyHeadNodes = new ArrayList<>();
		}
		Node dependencyHeadNode = RegionUtil.createDependencyNode(this, "«extra-" + (dependencyHeadNodes.size()+1) + "»", classDatumAnalysis);
		dependencyHeadNode.setHead();
		dependencyHeadNodes.add(dependencyHeadNode);
		addHeadNode(dependencyHeadNode);
		return dependencyHeadNode;
	}

	public @Nullable Node getDependencyHead(@NonNull ClassDatumAnalysis classDatumAnalysis) {
		if (dependencyHeadNodes != null) {
			for (@NonNull Node dependencyHeadNode : dependencyHeadNodes) {
				if (dependencyHeadNode.getClassDatumAnalysis() == classDatumAnalysis) {
					return dependencyHeadNode;
				}
			}
		}
		return null;
	}

	public @NonNull Mapping getMapping() {
		return mapping;
	}

	@Override
	public @NonNull Iterable<@NonNull Mapping> getMappings() {
		return Collections.singletonList(mapping);
	}

	@Override
	public @NonNull String getName() {
		return String.valueOf(getMapping().getName());
	}

	public @Nullable Node getNode(@NonNull TypedElement typedElement) {
		return variable2node.get(typedElement);
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

	public @NonNull Node getReferenceNode(@NonNull VariableDeclaration variable) {
		Node node = variable2node.get(variable);
		if (node == null) {
			if (variable instanceof Variable) {
				OCLExpression ownedInit = ((Variable)variable).getOwnedInit();
				if (ownedInit != null) {
					node = analyzeVariable((Variable) variable, ownedInit);
				}
				else if (variable.eContainer() instanceof BottomPattern) {
					node = RegionUtil.createLoadedStepNode(this, variable);		// FIXME Predicated ??
				}
			}
		}
		assert node != null : "No variable2simpleNode entry for " + variable;
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
		Node node = getNode(typedElement);
		if (node == null) {
			node = RegionUtil.createUnknownNode(this, ClassUtil.nonNullState(typedElement.getType().toString()), typedElement);
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
		analyzeRealizedVariables();
		//
		// Create the initialization/predicate/computation nodes and edges
		//
		analyzeInitializers(guardPatterns);
		analyzeInitializers(bottomPatterns);
		analyzePredicates(guardPatterns);
		analyzePredicates(bottomPatterns);
		analyzeAssignmentValues();
		analyzeComplexPredicates();
		//
		getHeadNodes();
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

	public void registerConsumptionsAndProductions() {
		for (@NonNull Node newNode : getNewNodes()) {
			ClassDatumAnalysis classDatumAnalysis = newNode.getClassDatumAnalysis();
			classDatumAnalysis.addProduction(this, newNode);
			for (@NonNull Mapping consumingMapping : classDatumAnalysis.getRequiredBy()) {
				MappingRegion consumingRegion = multiRegion.getMappingRegion(consumingMapping);
				for (@NonNull Node consumingNode : consumingRegion.getOldNodes()) {
					if (consumingNode.getCompleteClass() == classDatumAnalysis.getCompleteClass()) {		// FIXME inheritance
						classDatumAnalysis.addConsumption(consumingRegion, consumingNode);
					}
				}
			}
		}
		for (@NonNull Node predicatedNode : getOldNodes()) {
			ClassDatumAnalysis classDatumAnalysis = predicatedNode.getClassDatumAnalysis();
			classDatumAnalysis.addConsumption(this, predicatedNode);
			for (@NonNull Mapping producingMapping : classDatumAnalysis.getProducedBy()) {
				MappingRegion producingRegion = multiRegion.getMappingRegion(producingMapping);
				assert producingRegion != null;
				for (@NonNull Node newNode : producingRegion.getNewNodes()) {
					if (newNode.getCompleteClass() == classDatumAnalysis.getCompleteClass()) {		// FIXME inheritance
						classDatumAnalysis.addProduction(producingRegion, newNode);
					}
				}
			}
		}
	}
}