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
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.utilities.NameUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.MappingRegionAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.TransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2trace.RuleAnalysis2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvts2trace.VariableDeclaration2TraceProperty;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

/**
 * A RelationAnalysis provides the analysis a QVTc mapping.
 */
public class RelationAnalysis extends RuleAnalysis
{
	public static class InvocationAnalysis
	{
		protected final @NonNull RelationAnalysis invokingRelationAnalysis;
		protected final @NonNull RuleAnalysis2TraceClass invokedRuleAnalysis2TraceClass;
		protected final @NonNull Node invokedNode;
		protected final boolean isWhen;
		private final @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode = new HashMap<>();

		public InvocationAnalysis(@NonNull RelationAnalysis invokingRelationAnalysis, @NonNull RuleAnalysis2TraceClass invokedRuleAnalysis2TraceClass,
				@NonNull RelationCallExp relationCallExp, @NonNull Node invokedNode, boolean isWhen) {
			this.invokingRelationAnalysis = invokingRelationAnalysis;
			this.invokedRuleAnalysis2TraceClass = invokedRuleAnalysis2TraceClass;
			this.invokedNode = invokedNode;
			this.isWhen = isWhen;
		}

		public void add(@NonNull VariableDeclaration rootVariable, @NonNull Node argumentNode) {
			Node oldNode = rootVariable2argumentNode.put(rootVariable, argumentNode);
			assert oldNode == null;
		}

		public void install() {
			for (@NonNull VariableDeclaration rootVariable : rootVariable2argumentNode.keySet()) {
				Node argumentNode = rootVariable2argumentNode.get(rootVariable);
				assert argumentNode != null;
				Property invocationProperty = invokedRuleAnalysis2TraceClass.getTraceProperty(rootVariable);
				//				if (isWhen) {

				//				}
				//				else {
				invokingRelationAnalysis.createNavigationEdge(invokedNode, invocationProperty, argumentNode, null);
				//				}
			}

		}
	}

	/*	public static @NonNull RelationAnalysis createMappingRegion(@NonNull ScheduleManager scheduleManager, @NonNull RuleRegion ruleRegion) {
		RelationAnalysis mappingAnalysis = new RelationAnalysis(scheduleManager, ruleRegion);
		@SuppressWarnings("unused")String name = mappingAnalysis.getRuleRegion().getName();
		mappingAnalysis.initialize();
		return mappingAnalysis;
	} */

	protected final @NonNull QVTuConfiguration qvtuConfiguration;

	/**
	 * Predicates that are too complex to analyze. i.e. more than a comparison of a bound variable wrt
	 * a property call chain on another bound variable.
	 */
	private final @NonNull Set<@NonNull Predicate> complexPredicates = new HashSet<>();

	private org.eclipse.ocl.pivot.@Nullable Class traceClass = null;
	private Node traceNode = null;

	/**
	 * The variable initializers, simple predicate reference expression and variable assignment values that define a value for each variable.
	 * Variable initializers are populated lazily since not all LetVariables may even exist for an eager population.
	 */
	private @NonNull Map<@NonNull VariableDeclaration, @NonNull List<@NonNull OCLExpression>> variable2expressions = new HashMap<>();

	/**
	 * The expressions that call this relation.
	 */
	private @Nullable List<@NonNull RelationCallExp> incomingInvocations = null;

	/**
	 * The expressions that call this relation from a when clause.
	 */
	private @Nullable List<@NonNull RelationCallExp> incomingWhenInvocations = null;
	private @Nullable List<@NonNull InvocationAnalysis> incomingWhenInvocationAnalyses = null;

	/**
	 * The expressions that call this relation from a where clause.
	 */
	private @Nullable List<@NonNull RelationCallExp> incomingWhereInvocations = null;
	private @Nullable List<@NonNull InvocationAnalysis> incomingWhereInvocationAnalyses = null;

	/**
	 * The expressions that call relations with this relation.
	 */
	private @Nullable List<@NonNull RelationCallExp> outgoingInvocations = null;

	/**
	 * The expressions that call relations with this relation's when clause.
	 */
	private @Nullable List<@NonNull RelationCallExp> outgoingWhenInvocations = null;
	private @Nullable List<@NonNull InvocationAnalysis> outgoingWhenInvocationAnalyses = null;

	/**
	 * The expressions that call relations with this relation's where clause.
	 */
	private @Nullable List<@NonNull RelationCallExp> outgoingWhereInvocations = null;
	private @Nullable List<@NonNull InvocationAnalysis> outgoingWhereInvocationAnalyses = null;

	/**
	 * Closure of all overriding relations or null if not overridden.
	 */
	private @Nullable Set<@NonNull RelationAnalysis> overridingRelationAnalyses = null;

	/**
	 * The output variables that can be reached by a trabsitive composition relationship
	 * from an output root variable. These variables are logically created as a single
	 * composite object.
	 */
	private final @NonNull Set<@NonNull VariableDeclaration> composedOutputVariables = new HashSet<>();

	public RelationAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull QVTuConfiguration qvtuConfiguration, @NonNull RuleRegion ruleRegion) {
		super(transformationAnalysis, ruleRegion);
		this.qvtuConfiguration = qvtuConfiguration;
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

	private void addIncomingRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingInvocations2 = incomingInvocations;
		if (incomingInvocations2 == null) {
			incomingInvocations = incomingInvocations2 = new ArrayList<>();
		}
		incomingInvocations2.add(relationInvocation);
	}

	private void addIncomingWhenRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingWhenInvocations2 = incomingWhenInvocations;
		if (incomingWhenInvocations2 == null) {
			incomingWhenInvocations = incomingWhenInvocations2 = new ArrayList<>();
		}
		incomingWhenInvocations2.add(relationInvocation);
	}

	private void addIncomingWhereRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingWhereInvocations2 = incomingWhereInvocations;
		if (incomingWhereInvocations2 == null) {
			incomingWhereInvocations = incomingWhereInvocations2 = new ArrayList<>();
		}
		incomingWhereInvocations2.add(relationInvocation);
	}

	private void addOutgoingRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingInvocations2 = outgoingInvocations;
		if (outgoingInvocations2 == null) {
			outgoingInvocations = outgoingInvocations2 = new ArrayList<>();
		}
		outgoingInvocations2.add(relationInvocation);
	}

	private void addOutgoingWhenRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingWhenInvocations2 = outgoingWhenInvocations;
		if (outgoingWhenInvocations2 == null) {
			outgoingWhenInvocations = outgoingWhenInvocations2 = new ArrayList<>();
		}
		outgoingWhenInvocations2.add(relationInvocation);
	}

	private void addOutgoingWhereRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingWhereInvocations2 = outgoingWhereInvocations;
		if (outgoingWhereInvocations2 == null) {
			outgoingWhereInvocations = outgoingWhereInvocations2 = new ArrayList<>();
		}
		outgoingWhereInvocations2.add(relationInvocation);
	}

	@Override
	public void analyze() {
		//
		// Create the BLUE/CYAN guard nodes.
		//
		//		analyzeGuardVariables();
		//
		// Create the GREEN realized nodes.
		//
		//		analyzeRealizedVariables();		// FIXME bottom variables too
		//
		// Create the predicate/computation nodes and edges
		//
		//		analyzePredicates(guardPatterns);
		//		analyzePredicates(bottomPatterns);
		//		analyzeAssignmentValues();
		//		analyzeComplexPredicates();
		//		analyzeContainments();
		//
		MappingRegionAnalysis mappingRegionAnalysis = new MappingRegionAnalysis(region);
		List<@NonNull Node> headNodes = mappingRegionAnalysis.initHeadNodes(null);
		mappingRegionAnalysis.computeUtilities(headNodes);
	}

	/**
	 * Create the BLUE/CYAN computations for the RHS of assignments.
	 *
	protected void analyzeAssignmentValues() {
		AssignmentSorter assignmentSorter = new AssignmentSorter();
		for (@NonNull BottomPattern bottomPattern : bottomPatterns) {
			assignmentSorter.addAll(ClassUtil.nullFree(bottomPattern.getAssignment()));
		}
		for (@NonNull Assignment assignment : assignmentSorter.getSortedAssignments()) {
			assignment.accept(expressionAnalyzer);
		}
	} */

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
				Node trueNode = createTrueNode();
				createPredicateEdge(resultNode, null, trueNode);
			}
			// FIXME ?? do includes() here explicitly
		}
	}

	protected void analyzeContainments() {
		for (@NonNull Node node : region.getNewNodes()) {
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
	 *
	protected void analyzeGuardVariables() {
		for (@NonNull GuardPattern guardPattern : guardPatterns) {
			for (@NonNull Variable guardVariable : ClassUtil.nullFree(guardPattern.getVariable())) {
				Node guardNode = ruleRegion.getNode(guardVariable);
				assert guardNode == null;
				guardNode = createOldNode(guardVariable);
				assert guardNode == ruleRegion.getNode(guardVariable);
			}
		}
	} */

	/**
	 * Analyze the predicates to partition the guard variables into the distinct inputs that are not mutually
	 * navigable as a consequence of predicate constraints.
	 * @param bottomPatterns
	 *
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
						VariableDeclaration referredVariable = QVTrelationUtil.getReferredVariable(((VariableExp)boundExpression));
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
	 * @return */

	protected void analyzeInvocations(@NonNull Pattern pattern, boolean isWhen) {
		for (@NonNull Predicate predicate : QVTrelationUtil.getOwnedPredicates(pattern)) {
			OCLExpression predicateExpression = predicate.getConditionExpression();
			if (predicateExpression instanceof RelationCallExp) {
				RelationCallExp relationInvocation = (RelationCallExp) predicateExpression;
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(relationInvocation);
				RelationAnalysis invokedRelationAnalysis = (RelationAnalysis) transformationAnalysis.getRuleAnalysis(invokedRelation);
				RelationAnalysis invokingRelationAnalysis = this;
				if (isWhen) {
					invokedRelationAnalysis.addIncomingWhenRelation(relationInvocation);
					invokingRelationAnalysis.addOutgoingWhenRelation(relationInvocation);
				}
				else {
					invokedRelationAnalysis.addIncomingWhereRelation(relationInvocation);
					invokingRelationAnalysis.addOutgoingWhereRelation(relationInvocation);
				}
			}
		}
	}

	public void analyzePredicate(@NonNull OCLExpression predicateExpression) {
		Node resultNode = predicateExpression.accept(expressionAnalyzer);
		if ((resultNode != null) && !resultNode.isTrue()) {
			Node trueNode = createTrueNode();
			createPredicateEdge(resultNode, null, trueNode);
		}
	}

	public @NonNull OCLExpression analyzePropertyTemplateItem(@NonNull PropertyTemplateItem propertyTemplateItem) {
		ObjectTemplateExp sourceObjectTemplateExp = QVTrelationUtil.getOwningObjectTemplateExp(propertyTemplateItem);
		Variable sourceVariable = QVTrelationUtil.getBindsTo(sourceObjectTemplateExp);
		Node sourceNode = region.getNode(sourceVariable);
		assert sourceNode != null;
		Property source2targetProperty = QVTrelationUtil.getReferredProperty(propertyTemplateItem);
		OCLExpression targetExpression = QVTrelationUtil.getOwnedValue(propertyTemplateItem);
		Node targetNode = expressionAnalyzer.analyze(targetExpression);
		createNavigationEdge(sourceNode, source2targetProperty, targetNode, null);
		return targetExpression;
	}

	@Override
	public void analyzeStructure() {
		Relation relation = getRule();
		for (@NonNull RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			for (@NonNull DomainPattern domainPattern : QVTrelationUtil.getOwnedPatterns(relationDomain)) {
				DomainUsage domainUsage = scheduleManager.getDomainUsage(domainPattern);
				if (domainUsage.isOutput()) {
					TemplateExp templateExpression = QVTrelationUtil.getOwnedTemplateExpression(domainPattern);
					Variable rootVariable = QVTrelationUtil.getBindsTo(templateExpression);
					//					assert rootVariable != null;
					composedOutputVariables.add(rootVariable);
					analyzeTemplateExpression(templateExpression);
				}

			}
		}
	}

	private void analyzeTemplateExpression(@NonNull TemplateExp templateExpression) {
		if (templateExpression instanceof ObjectTemplateExp) {
			for (@NonNull PropertyTemplateItem propertyTemplateItem : QVTrelationUtil.getOwnedParts((ObjectTemplateExp)templateExpression)) {
				OCLExpression value = QVTrelationUtil.getOwnedValue(propertyTemplateItem);
				Property property = QVTrelationUtil.getReferredProperty(propertyTemplateItem);
				boolean isComposed = property.isIsComposite();
				//				if (!isComposed) {
				//					Property oppositeProperty = property.getOpposite();
				//					if ((oppositeProperty != null) && oppositeProperty.isIsComposite()) {
				//						isComposed = true;
				//					}
				//				}
				if (isComposed) {
					if (value instanceof VariableExp) {
						composedOutputVariables.add(QVTrelationUtil.getReferredVariable((VariableExp)value));
						// FIXME composed CollectionLiterals
					}
					else if (value instanceof TemplateExp) {
						composedOutputVariables.add(QVTrelationUtil.getBindsTo((TemplateExp)value));
						analyzeTemplateExpression((TemplateExp)value);
					}
				}
			}
		}
		else if (templateExpression instanceof CollectionTemplateExp) {
			for (@NonNull OCLExpression memberExpression : QVTrelationUtil.getOwnedMembers((CollectionTemplateExp)templateExpression)) {
				if (memberExpression instanceof VariableExp) {
					composedOutputVariables.add(QVTrelationUtil.getReferredVariable((VariableExp)memberExpression));
				}
				else if (memberExpression instanceof TemplateExp) {
					composedOutputVariables.add(QVTrelationUtil.getBindsTo((TemplateExp)memberExpression));
					analyzeTemplateExpression((TemplateExp)memberExpression);
				}
			}
			VariableDeclaration restVariable = ((CollectionTemplateExp)templateExpression).getRest();
			if (restVariable != null) {
				composedOutputVariables.add(restVariable);
			}
		}
	}

	/**
	 * Create a GREEN node for each realized variable.
	 *
	protected void analyzeRealizedVariables() {
		for (@NonNull BottomPattern bottomPattern : bottomPatterns) {
			for (@NonNull RealizedVariable realizedVariable : ClassUtil.nullFree(bottomPattern.getRealizedVariable())) {
				Node realizedNode = ruleRegion.getNode(realizedVariable);
				assert realizedNode == null;
				realizedNode = createRealizedStepNode(realizedVariable);
				assert realizedNode == ruleRegion.getNode(realizedVariable);
			}
		}
	} */

	//
	//	Install the targetVariable2sourceVariable2paths entries for a "boundVariable = referenceExpression" predicate,
	//	where the referenceExpression involves zero or more PropertyCallExps of a VariableExp. boundVariable may be null
	//	for a negative application condition.
	//
	//	A reverse entry is also created if no PropertyCallExp is not to-one.
	/*
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
				Node targetNode = boundVariable != null ? getReferenceNode(boundVariable) : createNullNode(true, null);
				//				assert sourceNode.isGuard();
				//				assert (boundVariable == null) || targetNode.isGuard();
				assert sourceNode.isClass();
				if (!referredProperty.isIsMany()) {
					Edge predicateEdge = sourceNode.getPredicateEdge(referredProperty);
					if (predicateEdge == null) {
						createNavigationEdge(sourceNode, referredProperty, targetNode, false);
					}
					else {
						assert predicateEdge.getEdgeTarget() == targetNode;
					}
				}
			}
		}
		return true;
	} */

	public @Nullable Node analyzeVariable(@NonNull Variable variable /*, @NonNull List<@NonNull OCLExpression> expressions*/) {
		//
		//	Use something hard to compute as the initializer that creates an initNode in the hope that other
		//	initializers might be easier and optimized as simple navigation edges.
		//
		OCLExpression bestInitExpression = variable.getOwnedInit();
		/*		for (@NonNull OCLExpression initExpression : expressions) {
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
		} */
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
			Node castNode = createOldNode(variable);
			Property castProperty = scheduleManager.getCastProperty(PivotUtil.getType(variable));
			expressionAnalyzer.createCastEdge(bestInitNode, castProperty, castNode);
			bestInitNode = castNode;
		}
		bestInitNode.addTypedElement(variable);
		region.addVariableNode(variable, bestInitNode);
		/*		for (@NonNull OCLExpression initExpression : expressions) {
			if (initExpression != bestInitExpression) {
				// FIXME if the extra init is a navigation we can add a navigation to the bestInitNode
				Node initNode = bestInitExpression.accept(expressionAnalyzer);
				assert initNode != null;
				createEqualsEdge(bestInitNode, initNode);
			}
		} */
		return bestInitNode;
	}

	public void analyzeVariableDeclaration(@NonNull VariableDeclaration variableDeclaration) {
		ClassDatum classDatum = scheduleManager.getClassDatum(variableDeclaration);
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		if (qvtuConfiguration.isOutput(typedModel) && composedOutputVariables.contains(variableDeclaration)) {
			createRealizedStepNode(variableDeclaration);
		}
		else if (QVTrelationUtil.isTraceClassVariable(variableDeclaration)) {
			// FIXME create traceClass earlier
			//			variableDeclaration.setType(traceClass);
			//			traceNode = createRealizedStepNode(variableDeclaration);
		}
		else {
			createOldNode(variableDeclaration);
		}
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
	 *
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
	} */

	/**
	 * Return the referenceExpression if conditionExpression is of the form "boundVariable = referenceExpression" or
	 * "referenceExpression = boundVariable". Returns null otherwise.
	 *
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
	 * @param invokedRuleAnalysis */

	public @NonNull InvocationAnalysis createInvocationAnalysis(@NonNull RuleAnalysis2TraceClass invokedRuleAnalysis2TraceClass, @NonNull RelationCallExp relationCallExp, Node invokedNode, boolean isWhen) {
		InvocationAnalysis invocationAnalysis = new InvocationAnalysis(this, invokedRuleAnalysis2TraceClass, relationCallExp, invokedNode, isWhen);
		RelationAnalysis invokedRelationAnalysis = (RelationAnalysis) invokedRuleAnalysis2TraceClass.getRuleAnalysis();
		if (isWhen) {
			List<@NonNull InvocationAnalysis> outgoingWhenInvocationAnalyses2 = outgoingWhenInvocationAnalyses;
			if (outgoingWhenInvocationAnalyses2 == null) {
				outgoingWhenInvocationAnalyses = outgoingWhenInvocationAnalyses2 = new ArrayList<>();
			}
			outgoingWhenInvocationAnalyses2.add(invocationAnalysis);
			List<@NonNull InvocationAnalysis> incomingWhenInvocationAnalyses2 = invokedRelationAnalysis.incomingWhenInvocationAnalyses;
			if (incomingWhenInvocationAnalyses2 == null) {
				invokedRelationAnalysis.incomingWhenInvocationAnalyses = incomingWhenInvocationAnalyses2 = new ArrayList<>();
			}
			incomingWhenInvocationAnalyses2.add(invocationAnalysis);
		}
		else {
			List<@NonNull InvocationAnalysis> outgoingWhereInvocationAnalyses2 = outgoingWhereInvocationAnalyses;
			if (outgoingWhereInvocationAnalyses2 == null) {
				outgoingWhereInvocationAnalyses = outgoingWhereInvocationAnalyses2 = new ArrayList<>();
			}
			outgoingWhereInvocationAnalyses2.add(invocationAnalysis);
			List<@NonNull InvocationAnalysis> incomingWhereInvocationAnalyses2 = invokedRelationAnalysis.incomingWhereInvocationAnalyses;
			if (incomingWhereInvocationAnalyses2 == null) {
				invokedRelationAnalysis.incomingWhereInvocationAnalyses = incomingWhereInvocationAnalyses2 = new ArrayList<>();
			}
			incomingWhereInvocationAnalyses2.add(invocationAnalysis);
		}
		return invocationAnalysis;
	}

	@Override
	public @Nullable Iterable<@NonNull ? extends OCLExpression> getIncomingInvocations() {
		return incomingInvocations;
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getIncomingWhenInvocations() {
		return incomingWhenInvocations;
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getIncomingWhereInvocations() {
		return incomingWhereInvocations;
	}

	@Override
	public @Nullable Iterable<@NonNull ? extends OCLExpression> getOutgoingInvocations() {
		return outgoingInvocations;
	}

	public @Nullable Iterable<@NonNull RelationCallExp> getOutgoingWhenInvocations() {
		return outgoingWhenInvocations;
	}

	@Override
	public @Nullable Iterable<@NonNull ? extends OCLExpression> getOutgoingWhereInvocations() {
		return outgoingWhereInvocations;
	}

	@Override
	public @NonNull Node getReferenceNode(@NonNull VariableDeclaration variableDeclaration) {
		Node node = region.getNode(variableDeclaration);
		/*		if (node == null) {
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
						node = createRealizedStepNode(variable);
					}
					else {
						node = createLoadedStepNode(variable);		// FIXME Predicated ??
					}
				}
			}
		} */
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

	@Override
	public @NonNull Relation getRule() {
		return (Relation) super.getRule();
	}

	@Override
	public @NonNull QVTrelationScheduleManager getScheduleManager() {
		return (QVTrelationScheduleManager)scheduleManager;
	}

	/**
	 * Return true if the navigation from sourceNode using source2targetProperty corresponds to a PropertyAssigmment,
	 */
	@Override
	public boolean isPropertyAssignment(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		/*		if (sourceNode.isRealized()) {
			for (@NonNull NavigationAssignment navigationAssignment : navigationAssignments) {
				Property navigationProperty = QVTrelationUtil.getTargetProperty(navigationAssignment);
				if (source2targetProperty == navigationProperty) {		// ??? opposites ??? do they even exist ???
					Node slotNode = expressionAnalyzer.analyze(navigationAssignment.getSlotExpression());
					if (slotNode == sourceNode) {
						return true;
					}
				}
			}
		} */
		return false;
	}

	public void installInvocations() {
		List<@NonNull InvocationAnalysis> outgoingWhenInvocationAnalyses2 = outgoingWhenInvocationAnalyses;
		if (outgoingWhenInvocationAnalyses2 != null) {
			for (@NonNull InvocationAnalysis invocationAnalysis : outgoingWhenInvocationAnalyses2) {
				invocationAnalysis.install();
			}
		}
		List<@NonNull InvocationAnalysis> outgoingWhereInvocationAnalyses2 = outgoingWhereInvocationAnalyses;
		if (outgoingWhereInvocationAnalyses2 != null) {
			for (@NonNull InvocationAnalysis invocationAnalysis : outgoingWhereInvocationAnalyses2) {
				invocationAnalysis.install();
			}
		}
	}

	@Override
	public void registerConsumptionsAndProductions() {
		installInvocations();
		super.registerConsumptionsAndProductions();
	}

	@Override
	public void synthesizeTraceClass(@NonNull RuleAnalysis2TraceClass ruleAnalysis2traceClass) {
		//		VariableDeclaration traceVariable = QVTrelationFactory.eINSTANCE.createSharedVariable();
		//		traceVariable.setName("trace");
		//		traceVariable.setType(ruleAnalysis2traceClass.getTraceClass());
		//		traceVariable.setIsRequired(true);
		//		region.getAnnotatingComments()
		Variable traceVariable = NameUtil.getNameable(QVTrelationUtil.getOwnedVariables(getRule()), QVTrelationUtil.TRACE_CLASS_NAME);
		assert traceVariable != null;
		traceVariable.setType(ruleAnalysis2traceClass.getTraceClass());
		traceNode = createRealizedStepNode(traceVariable);
		//		Role nodeRole = Role.REALIZED;
		//		PatternVariableNode traceNode = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
		//		ClassDatum classDatum = scheduleManager.getClassDatum(scheduleManager.getDomainUsageAnalysis().getTraceTypedModel(), ruleAnalysis2traceClass.getTraceClass());
		//		traceNode.initialize(nodeRole, region, getName(traceVariable), classDatum);
		//		node.initializeVariable(region, stepVariable);
		//		traceNode.setMatched(true);
		traceNode.setUtility(Node.Utility.STRONGLY_MATCHED);
		//		return node;
		for (@NonNull VariableDeclaration2TraceProperty variableDeclaration2traceProperty : ruleAnalysis2traceClass.getVariableDeclaration2TraceProperties()) {
			Property traceProperty = variableDeclaration2traceProperty.getTraceProperty();
			VariableDeclaration tracedVariable = variableDeclaration2traceProperty.getVariable();
			Node targetNode = region.getNode(tracedVariable);
			assert targetNode != null;
			createRealizedNavigationEdge(traceNode, traceProperty, targetNode, null);
		}
	}
}