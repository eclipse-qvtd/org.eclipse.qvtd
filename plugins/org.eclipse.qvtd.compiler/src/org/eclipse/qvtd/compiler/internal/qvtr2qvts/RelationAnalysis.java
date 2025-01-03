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
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

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
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.ocl.pivot.utilities.TreeIterable;
import org.eclipse.ocl.pivot.utilities.UniqueList;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleHeadAnalysis;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.common.TypedModelsConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationalTransformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.VariableDeclaration2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvts2qvts.utilities.ReachabilityForest;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.DispatchClass2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2ResultProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2DispatchClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2TraceClass;
import org.eclipse.qvtd.pivot.qvtbase.Domain;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.QVTrelationPackage;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomainAssignment;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;

/**
 * A RelationAnalysis provides the analysis a QVTc mapping.
 */
public class RelationAnalysis extends RuleAnalysis
{
	public static class InvocationAnalysisComparator implements Comparator<@Nullable InvocationAnalysis>
	{
		@Override
		public int compare(@Nullable InvocationAnalysis o1,@Nullable InvocationAnalysis o2) {
			if (o1 == null) {
				if (o2 == null) {
					return 0;
				}
				else {
					return 1;
				}
			}
			else {
				if (o2 == null) {
					return -1;
				}
				else {
					String n1 = o1.getInvokedRelationAnalysis().getName();
					String n2 = o2.getInvokedRelationAnalysis().getName();
					int diff = ClassUtil.safeCompareTo(n1, n2);
					if (diff != 0) {
						return diff;
					}
					return 0;		// FIXME compare arguments
				}
			}
		}

	}

	private static @NonNull InvocationAnalysisComparator iNVOCATION_ANALYSIS_COMPARATOR = new InvocationAnalysisComparator();
	/**
	 * Synthesizer for the dispatch execution region of an override hierarchy.
	 */
	private final @Nullable RelationDispatchAnalysis dispatchAnalysis;

	/**
	 * Synthesizer for the override verdict region.
	 */
	private final @Nullable RelationVerdictAnalysis verdictAnalysis;

	/**
	 * Synthesizer for the override verdict region.
	 */
	private final @NonNull TypedModel targetTypedModel;

	/**
	 * Predicates that are too complex to analyze. i.e. more than a comparison of a bound variable wrt
	 * a property call chain on another bound variable.
	 */
	//	private final @NonNull Set<@NonNull Predicate> complexPredicates = new HashSet<>();

	//	private @Nullable Node traceNode = null;

	private @Nullable Node thisNode = null;

	/**
	 * The variable initializers, simple predicate reference expression and variable assignment values that define a value for each variable.
	 * Variable initializers are populated lazily since not all LetVariables may even exist for an eager population.
	 */
	private @NonNull Map<@NonNull VariableDeclaration, @NonNull List<@NonNull OCLExpression>> variable2expressions = new HashMap<>();

	/**
	 * The expressions that call this relation from a when clause. The corresponding InvocationAnalysis is created lazily.
	 */
	private @Nullable Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> incomingWhenInvocation2invocationAnalysis = null;

	/**
	 * The expressions that call this relation from a where clause. The corresponding InvocationAnalysis is created lazily.
	 */
	private @Nullable Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> incomingWhereInvocation2invocationAnalysis = null;

	/**
	 * The expressions that call relations from a when clause in this relation. The corresponding InvocationAnalysis is created lazily.
	 */
	private @Nullable Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> outgoingWhenInvocation2invocationAnalysis = null;

	/**
	 * The expressions that call relations from a where clause in this relation. The corresponding InvocationAnalysis is created lazily.
	 */
	private @Nullable Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> outgoingWhereInvocation2invocationAnalysis = null;

	/**
	 * Closure of all overriding relations or null if not overridden.
	 */
	//	private @Nullable Set<@NonNull RelationAnalysis> overridingRelationAnalyses = null;

	/**
	 * The RelationAnalysis for the least overridden relationinvoing this relation.
	 *
	 * Populated by analyzeSourceModel.
	 */
	private @Nullable RelationAnalysis baseRelationAnalysis = null;

	/**
	 * The output variables that are realized. These variables are logically created as a single composite object.
	 *
	 * Populated by analyzeSourceModel.
	 */
	private @Nullable Set<@NonNull VariableDeclaration> realizedOutputVariables = null;

	/**
	 * The output variables that are created/shared by a key constructor.
	 *
	 * Populated by analyzeSourceModel.
	 */
	private @Nullable Set<@NonNull VariableDeclaration> keyedOutputVariables = null;

	/**
	 * The TemplateExp that binds each variable
	 *
	 * Populated by analyzeSourceModel.
	 */
	private @Nullable Map<@NonNull TemplateVariable, @NonNull TemplateExp> variable2templateExp = null;

	/**
	 * The output variables that are assigned by a top when invocation.
	 *
	 * Populated by analyzeSourceModel.
	 */
	private @Nullable Set<@NonNull VariableDeclaration> topWhenedOutputVariables = null;

	/**
	 * The output variables that are assigned by a non-top when invocation.
	 *
	 * Populated by analyzeSourceModel.
	 */
	private @Nullable Set<@NonNull VariableDeclaration> nonTopWhenedOutputVariables = null;

	private @Nullable Map<@NonNull Node, @NonNull InvocationAnalysis> invokingNode2invocationAnalysis = null;

	public RelationAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull TypedModelsConfiguration typedModelsConfiguration, @NonNull RuleRegion ruleRegion) {
		super(transformationAnalysis, ruleRegion);
		dispatchAnalysis = createDispatchAnalysis(typedModelsConfiguration);
		verdictAnalysis = createVerdictAnalysis(typedModelsConfiguration);
		targetTypedModel = typedModelsConfiguration.getTargetTypedModel();
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

	private void addIncomingInvocationAnalysis(@NonNull RelationCallExp invocation, @NonNull InvocationAnalysis invocationAnalysis) {
		boolean isWhen = invocationAnalysis.isWhen();
		Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> invocationAnalyses = isWhen ? incomingWhenInvocation2invocationAnalysis : incomingWhereInvocation2invocationAnalysis;
		assert invocationAnalyses != null;
		InvocationAnalysis old = invocationAnalyses.put(invocation, invocationAnalysis);
		assert old == null;
	}

	private void addIncomingWhenInvocation(@NonNull RelationCallExp invocation) {
		Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> incomingWhenInvocation2invocationAnalysis2 = incomingWhenInvocation2invocationAnalysis;
		if (incomingWhenInvocation2invocationAnalysis2 == null) {
			incomingWhenInvocation2invocationAnalysis = incomingWhenInvocation2invocationAnalysis2 = new HashMap<>();
		}
		assert !incomingWhenInvocation2invocationAnalysis2.containsKey(invocation);
		incomingWhenInvocation2invocationAnalysis2.put(invocation, null);
	}

	private void addIncomingWhereInvocation(@NonNull RelationCallExp invocation) {
		Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> incomingWhereInvocation2invocationAnalysis2 = incomingWhereInvocation2invocationAnalysis;
		if (incomingWhereInvocation2invocationAnalysis2 == null) {
			incomingWhereInvocation2invocationAnalysis = incomingWhereInvocation2invocationAnalysis2 = new HashMap<>();
		}
		assert !incomingWhereInvocation2invocationAnalysis2.containsKey(invocation);
		incomingWhereInvocation2invocationAnalysis2.put(invocation, null);
	}

	private void addOutgoingInvocationAnalysis(@NonNull RelationCallExp invocation, @NonNull InvocationAnalysis invocationAnalysis) {
		boolean isWhen = invocationAnalysis.isWhen();
		Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> invocationAnalyses = isWhen ? outgoingWhenInvocation2invocationAnalysis : outgoingWhereInvocation2invocationAnalysis;
		assert invocationAnalyses != null;
		InvocationAnalysis old = invocationAnalyses.put(invocation, invocationAnalysis);
		assert old == null;
	}

	private void addOutgoingWhenInvocation(@NonNull RelationCallExp relationInvocation) {
		Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> outgoingWhenInvocation2invocationAnalysis2 = outgoingWhenInvocation2invocationAnalysis;
		if (outgoingWhenInvocation2invocationAnalysis2 == null) {
			outgoingWhenInvocation2invocationAnalysis2 = outgoingWhenInvocation2invocationAnalysis = new HashMap<>();
		}
		assert !outgoingWhenInvocation2invocationAnalysis2.containsKey(relationInvocation);
		outgoingWhenInvocation2invocationAnalysis2.put(relationInvocation, null);
	}

	private void addOutgoingWhereInvocation(@NonNull RelationCallExp relationInvocation) {
		Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> outgoingWhereInvocation2invocationAnalysis2 = outgoingWhereInvocation2invocationAnalysis;
		if (outgoingWhereInvocation2invocationAnalysis2 == null) {
			outgoingWhereInvocation2invocationAnalysis2 = outgoingWhereInvocation2invocationAnalysis = new HashMap<>();
		}
		assert !outgoingWhereInvocation2invocationAnalysis2.containsKey(relationInvocation);
		outgoingWhereInvocation2invocationAnalysis2.put(relationInvocation, null);
	}

	protected void analyzeContainments() {
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (node.isNew()) {
				boolean isContained = false;
				for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
					if (edge.isNavigation()) {
						NavigationEdge navigationEdge = (NavigationEdge)edge;
						Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
						Property opposite = property.getOpposite();
						if ((opposite != null) && opposite.isIsComposite() && !navigationEdge.getEdgeTarget().isNullLiteral()) {
							isContained = true;
							break;
						}
					}
					else {
						// SharedEdge
					}
				}
				if (isContained) {
					node.setContained(true);
				}
			}
		}
	}

	@Override
	public void analyzeInvocations(@NonNull ProblemHandler problemHandler) {
		for (@NonNull EObject eObject : new TreeIterable(rule, false)) {
			if (eObject instanceof RelationCallExp) {
				RelationCallExp relationInvocation = (RelationCallExp) eObject;
				RelationAnalysis invokedRelationAnalysis = (RelationAnalysis) transformationAnalysis.getRuleAnalysis(QVTrelationUtil.getReferredRelation(relationInvocation));
				//	String name= invokedRelationAnalysis.getName();
				Pattern pattern = QVTrelationUtil.basicGetContainingPattern(eObject);
				if ((pattern != null) && (pattern.eContainmentFeature() == QVTrelationPackage.Literals.RELATION__WHERE)) {
					invokedRelationAnalysis.addIncomingWhereInvocation(relationInvocation);
					addOutgoingWhereInvocation(relationInvocation);
				}
				else {
					invokedRelationAnalysis.addIncomingWhenInvocation(relationInvocation);
					RelationAnalysis invokedBaseRelationAnalysis = getScheduleManager().getRuleAnalysis(QVTrelationUtil.getBaseRelation((Relation) rule));	// FIXME invokedBaseRelationAnalysis not yet valid
					if (invokedBaseRelationAnalysis != invokedRelationAnalysis) {
						invokedBaseRelationAnalysis.addIncomingWhenInvocation(relationInvocation);
					}
					addOutgoingWhenInvocation(relationInvocation);
				}
			}
		}
	}

	protected void analyzeKeyedOutputVariables(@NonNull RelationDomain relationDomain, @NonNull Set<@NonNull VariableDeclaration> keyedOutputVariables) {
		RelationalTransformationAnalysis transformationAnalysis2 = getTransformationAnalysis();
		Set<@NonNull VariableDeclaration> whenedOutputVariables = getTopWhenedOutputVariables();
		for (@NonNull DomainPattern domainPattern : QVTrelationUtil.getOwnedPatterns(relationDomain)) {
			TemplateExp templateExpression = QVTrelationUtil.getOwnedTemplateExpression(domainPattern);
			for (@NonNull EObject eObject : new TreeIterable(templateExpression, true)) {
				if (eObject instanceof TemplateExp) {
					TemplateExp templateExp = (TemplateExp)eObject;
					TemplateVariable templateVariable = (TemplateVariable) QVTrelationUtil.getBindsTo(templateExp);
					if (!whenedOutputVariables.contains(templateVariable)) {
						Key key = transformationAnalysis2.getKeyForType(QVTrelationUtil.getType(templateVariable));
						if (key != null) {
							keyedOutputVariables.add(templateVariable);
						}
					}
				}
			}
		}
	}

	@Override
	public void analyzeMappingRegion() {
		rewriteCastEdges();
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
		Relation relation = getRule();
		boolean hasOverrides = QVTrelationUtil.hasOverrides(relation);
		Relation baseRelation = QVTrelationUtil.getBaseRelation(relation);
		boolean isTop = relation.isIsTopLevel();
		Iterable<@NonNull Node> tracedHeadNodes = QVTscheduleUtil.getHeadNodes(region);
		List<@NonNull Node> preferredHeadNodes = new ArrayList<>();
		if (!Iterables.isEmpty(tracedHeadNodes) && (!isTop || (hasOverrides && (baseRelation != relation)))) {
			// Prefer the trace node that has been specified as the head for a dispatched/invoked relation.
			for (@NonNull Node headNode : tracedHeadNodes) {
				Element originatingElement = headNode.getOriginatingElement();
				if (!scheduleManager.isOutputInRule(relation, originatingElement)) {
					//	if (!headNode.isNew()) {
					preferredHeadNodes.add(headNode);
				}
			}
		}
		else {
			// Prefer the root nodes of input domains as head nodes.
			for (@NonNull RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
				if (getScheduleManager().isInputInRule(relation, relationDomain)) {
					for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relationDomain)) {
						Node rootNode = region.getNode(rootVariable);
						if (rootNode != null) {
							preferredHeadNodes.add(rootNode);
						}
					}
				}
			}
		}
		Iterable<@NonNull Node> headNodes;
		assert baseRelationAnalysis != null;
		if (baseRelationAnalysis != this) {
			headNodes = preferredHeadNodes;
		}
		else {
			headNodes = RuleHeadAnalysis.computeRuleHeadNodes(scheduleManager, region, preferredHeadNodes);
		}
		List<@NonNull Node> headNodesList = QVTscheduleUtil.Internal.getHeadNodesList(region);
		headNodesList.clear();
		Iterables.addAll(headNodesList, headNodes);
		analyzeStrictness();
	}

	@Override
	public void analyzeOverrides(@NonNull ProblemHandler problemHandler) {
		Relation relation = getRule();
		baseRelationAnalysis = getScheduleManager().getRuleAnalysis(QVTrelationUtil.getBaseRelation(relation));
		for (@NonNull TypedModel typedModel : getScheduleManager().getTypedModelsConfiguration().getOutputOnlyTypedModels()) {
			Domain domain = QVTrelationUtil.basicGetDomain(relation, typedModel);
			if ((domain != null) && domain.isNotOutput()) {
				CompilerUtil.addRuleError(problemHandler, relation, "domain ''{0}'' cannot be an output", typedModel.getName());
			}
		}
	}

	protected void analyzeRealizedOutputVariables(@NonNull RelationDomain relationDomain, @NonNull Set<@NonNull VariableDeclaration> realizedOutputVariables) {
		for (@NonNull DomainPattern domainPattern : QVTrelationUtil.getOwnedPatterns(relationDomain)) {
			TemplateExp templateExpression = QVTrelationUtil.getOwnedTemplateExpression(domainPattern);
			boolean isTopLevel = ((Relation)rule).isIsTopLevel();
			boolean hasWhenInvocations = hasIncomingWhenInvocations();
			//			boolean isWhenInvoked = (incomingWhenInvocationAnalyses != null) && !incomingWhenInvocationAnalyses.isEmpty();
			boolean rootIsRealized = isTopLevel || hasWhenInvocations;
			for (@NonNull EObject eObject : new TreeIterable(templateExpression, rootIsRealized)) {
				if (eObject instanceof ObjectTemplateExp) {		// CollectType's are not realized
					ObjectTemplateExp templateExp = (ObjectTemplateExp)eObject;
					TemplateVariable templateVariable = (TemplateVariable) QVTrelationUtil.getBindsTo(templateExp);
					realizedOutputVariables.add(templateVariable);
				}
				else if (eObject instanceof CollectionTemplateExp) {
					//	CollectionTemplateExp templateExp = (CollectionTemplateExp)eObject;
					//	TemplateVariable templateVariable = (TemplateVariable) QVTrelationUtil.getBindsTo(templateExp);
					//	predicatedOutputVariables.add(templateVariable);
				}
			}
		}
	}

	public void analyzeStrictness() {
		List<@NonNull InvocationAnalysis> outgoingInvocationAnalyses = null;
		if (outgoingWhenInvocation2invocationAnalysis != null) {
			List<@Nullable InvocationAnalysis> invocationAnalyses = new ArrayList<>(outgoingWhenInvocation2invocationAnalysis.values());
			Collections.sort(invocationAnalyses, iNVOCATION_ANALYSIS_COMPARATOR);
			for (InvocationAnalysis invocationAnalysis : invocationAnalyses) {
				assert invocationAnalysis != null;
				if (!invocationAnalysis.isTop() && invocationAnalysis.isRealized()) {
					if (outgoingInvocationAnalyses == null) {
						outgoingInvocationAnalyses = new ArrayList<>();
					}
					outgoingInvocationAnalyses.add(invocationAnalysis);
				}
			}
		}
		if (outgoingWhereInvocation2invocationAnalysis != null) {
			List<@Nullable InvocationAnalysis> invocationAnalyses = new ArrayList<>(outgoingWhereInvocation2invocationAnalysis.values());
			Collections.sort(invocationAnalyses, iNVOCATION_ANALYSIS_COMPARATOR);
			for (InvocationAnalysis invocationAnalysis : invocationAnalyses) {
				assert invocationAnalysis != null;
				if (!invocationAnalysis.isTop() && invocationAnalysis.isRealized()) {
					if (outgoingInvocationAnalyses == null) {
						outgoingInvocationAnalyses = new ArrayList<>();
					}
					outgoingInvocationAnalyses.add(invocationAnalysis);
				}
			}
		}
		if (outgoingInvocationAnalyses != null) {
			ReachabilityForest reachabilityForest = null;
			for (@NonNull InvocationAnalysis invocationAnalysis : outgoingInvocationAnalyses) {
				RelationAnalysis invokedRelationAnalysis = invocationAnalysis.getInvokedRelationAnalysis();
				int incomingWhenInvocationCount = invokedRelationAnalysis.getIncomingWhenInvocationCount();
				int incomingWhereInvocationCount = invokedRelationAnalysis.getIncomingWhereInvocationCount();
				int incomingWhenInvocationAnalysisCount = incomingWhenInvocationCount + incomingWhereInvocationCount;
				if (incomingWhenInvocationAnalysisCount > 1) {
					invocationAnalysis.setStrict(true);
					break;
				}
				for (@NonNull Node argumentNode : invocationAnalysis.getArgumentNodes()) {
					if (argumentNode.isDataType()) {
						invocationAnalysis.setStrict(true);
						break;
					}
					if (reachabilityForest == null) {
						Iterable<@NonNull Node> rootNodes = QVTscheduleUtil.getHeadNodes(region);
						List<@NonNull NavigableEdge> navigableEdges = new ArrayList<>();
						for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
							if (edge.isNavigation() /*&& edge.isOld()*/) {
								NavigationEdge navigationEdge = (NavigationEdge)edge;
								Property property = QVTscheduleUtil.getReferredProperty(navigationEdge);
								if (!property.isIsMany()) {
									Property oppositeProperty = property.getOpposite();
									if ((oppositeProperty != null) && !oppositeProperty.isIsMany()) {
										navigableEdges.add(navigationEdge);
									}
								}
							}
						}
						reachabilityForest = new ReachabilityForest(null, rootNodes, navigableEdges);
					}
					Integer cost = reachabilityForest.basicGetCost(argumentNode);
					if (cost == null) {
						invocationAnalysis.setStrict(true);
						break;
					}
				}
			}
		}
	}

	@Override
	public void analyzeSourceModel(@NonNull ProblemHandler problemHandler) {
		QVTrelationDirectedScheduleManager scheduleManager = getScheduleManager();
		Relation relation = getRule();
		variable2templateExp = analyzeVariable2TemplateExp();
		Set<@NonNull VariableDeclaration> topWhenedOutputVariables2 = topWhenedOutputVariables = new HashSet<>();
		Set<@NonNull VariableDeclaration> nonTopWhenedOutputVariables2 = nonTopWhenedOutputVariables = new HashSet<>();
		analyzeWhenedOutputVariables(topWhenedOutputVariables2, nonTopWhenedOutputVariables2);
		Set<@NonNull VariableDeclaration> keyedOutputVariables = this.keyedOutputVariables = new HashSet<>();
		Set<@NonNull VariableDeclaration> realizedOutputVariables = this.realizedOutputVariables = new HashSet<>();
		for (@NonNull RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			if (scheduleManager.isOutputInRule(relation, relationDomain)) {
				//	assert keyedOutputVariables == null;	-- The assumption of a single output domain does not seem to  be justified
				analyzeKeyedOutputVariables(relationDomain, keyedOutputVariables);
				//	assert realizedOutputVariables == null;	-- The assumption of a single output domain does not seem to  be justified
				analyzeRealizedOutputVariables(relationDomain, realizedOutputVariables);
			}
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

	protected @NonNull Map<@NonNull TemplateVariable, @NonNull TemplateExp> analyzeVariable2TemplateExp() {
		Relation relation = getRule();
		Map<@NonNull TemplateVariable, @NonNull TemplateExp> variable2templateExp = new HashMap<>();
		for (@NonNull RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			for (@NonNull DomainPattern domainPattern : QVTrelationUtil.getOwnedPatterns(relationDomain)) {
				for (@NonNull EObject eObject : new TreeIterable(domainPattern, true)) {
					if (eObject instanceof TemplateExp) {
						TemplateExp templateExp = (TemplateExp)eObject;
						TemplateVariable templateVariable = (TemplateVariable) QVTrelationUtil.getBindsTo(templateExp);
						TemplateExp oldTemplateExp = variable2templateExp.put(templateVariable, templateExp);
						assert oldTemplateExp == null;
					}
				}
			}
		}
		return variable2templateExp;
	}

	protected void analyzeWhenedOutputVariables(@NonNull Set<@NonNull VariableDeclaration> topWhenedOutputVariables, @NonNull Set<@NonNull VariableDeclaration> nonTopWhenedOutputVariables) {
		QVTrelationDirectedScheduleManager scheduleManager = getScheduleManager();
		Relation relation = getRule();
		Pattern whenPattern = relation.getWhen();
		if (whenPattern != null) {
			for (@NonNull Predicate whenPredicate : QVTrelationUtil.getOwnedPredicates(whenPattern)) {
				for (@NonNull EObject eObject : new TreeIterable(QVTrelationUtil.getOwnedConditionExpression(whenPredicate), true)) {
					if (eObject instanceof VariableExp) {
						VariableExp variableExp = (VariableExp)eObject;
						EObject eContainer = variableExp.eContainer();
						if (eContainer instanceof RelationCallExp) {
							RelationCallExp invocation = (RelationCallExp)eContainer;
							int argumentIndex = invocation.getArgument().indexOf(variableExp);
							assert argumentIndex >= 0;
							RelationDomain domain = QVTrelationUtil.getRelationCallExpArgumentDomain(invocation, argumentIndex);
							if (scheduleManager.isOutputInRule(QVTrelationUtil.getReferredRelation(invocation), domain)) {
								if (invocation.getReferredRelation().isIsTopLevel()) {
									topWhenedOutputVariables.add(QVTrelationUtil.getReferredVariable(variableExp));
								}
								else {
									nonTopWhenedOutputVariables.add(QVTrelationUtil.getReferredVariable(variableExp));
								}
							}
						}
					}
				}
			}
		}
	}

	public @Nullable Iterable<@Nullable InvocationAnalysis> basicGetOutgoingWhenInvocationAnalyses() {
		return outgoingWhenInvocation2invocationAnalysis != null ? outgoingWhenInvocation2invocationAnalysis.values() : null;
	}

	public @Nullable Iterable<@Nullable InvocationAnalysis> basicGetOutgoingWhereInvocationAnalyses() {
		return outgoingWhereInvocation2invocationAnalysis != null ? outgoingWhereInvocation2invocationAnalysis.values() : null;
	}

	@Override
	public @Nullable Relation2TraceGroup basicGetRule2TraceGroup() {
		return (Relation2TraceGroup) super.basicGetRule2TraceGroup();
	}

	protected @Nullable TemplateExp basicGetTemplateExp(@NonNull VariableDeclaration variable) {
		return ClassUtil.nonNullState(variable2templateExp).get(variable);
	}

	public @NonNull Set<@NonNull Node> computeTraceAndTraceComputationNodes() {
		Set<@NonNull Node> traceAndTraceComputationNodes = new UniqueList<>();
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
			if (node.getClassDatum().getReferredTypedModel().isIsTrace()) {
				traceAndTraceComputationNodes.add(node);
				for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(node)) {
					if (outgoingEdge.isSuccess()) {
						Node targetNode = QVTscheduleUtil.getTargetNode(outgoingEdge);
						if (traceAndTraceComputationNodes.add(targetNode)) {
							computeTraceAndTraceComputationNodes(traceAndTraceComputationNodes, targetNode);
						}
					}
				}
			}
			if (node.isSuccess()) {
				if (traceAndTraceComputationNodes.add(node)) {
					computeTraceAndTraceComputationNodes(traceAndTraceComputationNodes, node);
				}
			}
		}
		return traceAndTraceComputationNodes;
	}
	private void computeTraceAndTraceComputationNodes(@NonNull Set<@NonNull Node> traceAndTraceComputationNodes, @NonNull Node node) {
		for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(node)) {
			if (outgoingEdge.isComputation()) {
				Node targetNode = QVTscheduleUtil.getTargetNode(outgoingEdge);
				if (traceAndTraceComputationNodes.add(targetNode)) {
					computeTraceAndTraceComputationNodes(traceAndTraceComputationNodes, targetNode);
				}
			}
		}
		for (@NonNull Edge incomingEdge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (incomingEdge.isComputation()) {
				Node sourceNode = QVTscheduleUtil.getTargetNode(incomingEdge);
				if (traceAndTraceComputationNodes.add(sourceNode)) {
					computeTraceAndTraceComputationNodes(traceAndTraceComputationNodes, sourceNode);
				}
			}
		}
	}

	protected @Nullable RelationDispatchAnalysis createDispatchAnalysis(@NonNull TypedModelsConfiguration typedModelsConfiguration) {
		Relation relation = getRule();
		if (!QVTrelationUtil.hasOverrides(relation)) {
			return null;
		}
		if (QVTrelationUtil.getBaseRelation(relation) != relation) {
			return null;
		}
		DispatchRegion dispatchRegion = QVTscheduleFactory.eINSTANCE.createDispatchRegion();
		dispatchRegion.setOwningScheduleModel(scheduleManager.getScheduleModel());
		dispatchRegion.setReferredRule(relation);
		dispatchRegion.setReferredRuleRegion(getRegion());
		dispatchRegion.setName(getNameGenerator().createMappingName(relation, "dispatch", typedModelsConfiguration));
		return new RelationDispatchAnalysis(this, dispatchRegion);
	}

	protected @NonNull InvocationAnalysis createOutgoingInvocationAnalysis(@NonNull RelationAnalysis invokedRelationAnalysis, @NonNull RelationCallExp relationCallExp, boolean isWhen,
			@NonNull Utility utility, @NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode) {
		RelationAnalysis invokedBaseRelationAnalysis = invokedRelationAnalysis.getBaseRelationAnalysis();
		InvocationAnalysis invocationAnalysis;
		if (invokedBaseRelationAnalysis.getRule().isIsTopLevel()) {
			if (isWhen) {
				invocationAnalysis = new TopWhenInvocationAnalysis(this, invokedRelationAnalysis, utility, rootVariable2argumentNode);
			}
			else {
				invocationAnalysis = new TopWhereInvocationAnalysis(this, invokedRelationAnalysis, utility, rootVariable2argumentNode);
			}
		}
		else {
			boolean hasWhenInvocations = invokedRelationAnalysis.hasIncomingWhenInvocations();
			boolean hasWhereInvocations = invokedRelationAnalysis.hasIncomingWhereInvocations();
			boolean hasWhenAndWhereInvocations = hasWhenInvocations && hasWhereInvocations;
			if (isWhen) {
				if (hasWhenAndWhereInvocations) {
					invocationAnalysis = new NonTopWhenAfterWhereInvocationAnalysis(this, invokedRelationAnalysis, utility, rootVariable2argumentNode);
				}
				else {
					invocationAnalysis = new NonTopWhenOnlyInvocationAnalysis(this, invokedRelationAnalysis, utility, rootVariable2argumentNode);
				}
			}
			else {
				if (hasWhenAndWhereInvocations) {
					invocationAnalysis = new NonTopWhereBeforeWhenInvocationAnalysis(this, invokedRelationAnalysis, utility.getNullableUtility(), rootVariable2argumentNode);
				}
				else {
					invocationAnalysis = new NonTopWhereOnlyInvocationAnalysis(this, invokedRelationAnalysis, utility.getNullableUtility(), rootVariable2argumentNode);
				}
			}
		}
		addOutgoingInvocationAnalysis(relationCallExp, invocationAnalysis);
		invokedRelationAnalysis.addIncomingInvocationAnalysis(relationCallExp, invocationAnalysis);
		if (invokedBaseRelationAnalysis != invokedRelationAnalysis) {
			invokedBaseRelationAnalysis.addIncomingInvocationAnalysis(relationCallExp, invocationAnalysis);
		}
		return invocationAnalysis;
	}

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

	protected @Nullable RelationVerdictAnalysis createVerdictAnalysis(@NonNull TypedModelsConfiguration typedModelsConfiguration) {
		Relation relation = getRule();
		if (!QVTrelationUtil.hasOverrides(relation)) {
			return null;
		}
		if (QVTrelationUtil.getBaseRelation(relation) != relation) {
			return null;
		}
		VerdictRegion verdictRegion = QVTscheduleFactory.eINSTANCE.createVerdictRegion();
		verdictRegion.setOwningScheduleModel(scheduleManager.getScheduleModel());
		verdictRegion.setReferredRule(relation);
		verdictRegion.setReferredRuleRegion(getRegion());
		verdictRegion.setName(getNameGenerator().createMappingName(relation, "verdict", typedModelsConfiguration));
		return new RelationVerdictAnalysis(this, verdictRegion);
	}

	@Override
	public void gatherRuleRegions(@NonNull List<@NonNull RuleRegion> ruleRegions) {
		super.gatherRuleRegions(ruleRegions);
		if (dispatchAnalysis != null) {
			dispatchAnalysis.gatherRuleRegions(ruleRegions);
		}
		if (verdictAnalysis != null) {
			verdictAnalysis.gatherRuleRegions(ruleRegions);
		}
	}

	private @NonNull RelationAnalysis getBaseRelationAnalysis() {
		return ClassUtil.nonNullState(baseRelationAnalysis);
	}

	public int getIncomingWhenInvocationCount() {
		return incomingWhenInvocation2invocationAnalysis != null ? incomingWhenInvocation2invocationAnalysis.size() : 0;
	}

	public int getIncomingWhereInvocationCount() {
		return incomingWhereInvocation2invocationAnalysis != null ? incomingWhereInvocation2invocationAnalysis.size() : 0;
	}

	@Override
	public @NonNull InvocationAnalysis getInvocationAnalysis(@NonNull Node invokingNode) {
		assert invokingNode2invocationAnalysis != null;
		return ClassUtil.nonNullState(invokingNode2invocationAnalysis.get(invokingNode));
	}

	protected @NonNull Set<@NonNull VariableDeclaration> getKeyedOutputVariables() {
		return ClassUtil.nonNullState(keyedOutputVariables);
	}

	@Override
	public @NonNull QVTrelationNameGenerator getNameGenerator() {
		return (QVTrelationNameGenerator) super.getNameGenerator();
	}
	/**
	 * Return the utility for a give variableDeclaration adjusting the optional multiplicity of the heads an optional
	 * when invocation to non-optional. (See Bug 499432)
	 */
	private @NonNull Utility getOptionalMatchAtRootUtility(@NonNull VariableDeclaration variableDeclaration) {
		boolean anyRequired = false;
		boolean isRootVariable = false;
		for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(getRule())) {
			if (rootVariable == variableDeclaration) {
				isRootVariable = true;
			}
			if (rootVariable.isIsRequired()) {
				anyRequired = true;
			}
		}
		if (!isRootVariable) {						// Non-root is not
			return Utility.getRequiredUtility(variableDeclaration);							//  a root match
		}
		if (anyRequired) {							// If any root cannot be null
			return Utility.getRequiredUtility(variableDeclaration);							//  a match is required
		}
		return Utility.NON_NULL_MATCHED;								// Match can be omitted
	}

	public @NonNull InvocationAnalysis getOutgoingInvocationAnalysis(@NonNull RelationAnalysis invokedRelationAnalysis, @NonNull RelationCallExp invocation, boolean isWhen, @NonNull Utility utility,
			@NonNull Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode) {
		Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> outgoingInvocationAnalyses = isWhen ? outgoingWhenInvocation2invocationAnalysis : outgoingWhereInvocation2invocationAnalysis;
		if (outgoingInvocationAnalyses != null) {
			InvocationAnalysis invocationAnalysis = outgoingInvocationAnalyses.get(invocation);
			if (invocationAnalysis != null) {
				return invocationAnalysis;
			}
		}
		return createOutgoingInvocationAnalysis(invokedRelationAnalysis, invocation, isWhen, utility, rootVariable2argumentNode);
	}

	protected @NonNull Set<@NonNull VariableDeclaration> getRealizedOutputVariables() {
		return ClassUtil.nonNullState(realizedOutputVariables);
	}

	@Override
	public @NonNull Node getReferenceNode(@NonNull VariableDeclaration variableDeclaration) {
		Node node = region.getNode(variableDeclaration);
		if (node == null) {
			if (variableDeclaration instanceof SharedVariable) {
				node = getReferenceNodeForSharedVariable((SharedVariable)variableDeclaration, null);
			}
			if (node == null) {
				node = createOldNode(Utility.getRequiredUtility(variableDeclaration), variableDeclaration);
				if (node.isThis()) {
					setThisNode(node);
				}
			}
		}
		assert node != null : "No variable2simpleNode entry for " + variableDeclaration;
		assert node == region.getNode(variableDeclaration);
		return node;
	}

	private @Nullable Node getReferenceNodeForSharedVariable(@NonNull SharedVariable variable, @Nullable OCLExpression predicatedInit /*, @NonNull List<@NonNull OCLExpression> expressions*/) {
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
			if (predicatedInit != null) {
				bestInitExpression = predicatedInit;
			}
			else {
				return null;
			}
		}
		ExpressionSynthesizer expressionSynthesizer2 = rootExpressionSynthesizer.getRequiredExpressionSynthesizer(variable.isIsRequired());
		Node bestInitNode = bestInitExpression.accept(expressionSynthesizer2);
		assert bestInitNode != null;
		if (variable.isIsRequired()) {
			assert bestInitNode.isRequired();
			//	assert bestInitNode.isMatched();  --not satisfied by a cast to-non-null ATL2QVTr local variable
		}
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
		ClassDatum initClassDatum = QVTscheduleUtil.getClassDatum(bestInitNode);
		ClassDatum variableClassDatum = scheduleManager.getClassDatum(variable);
		if (!QVTscheduleUtil.conformsTo(initClassDatum, variableClassDatum)) {
			Node castNode = createOldNode(Utility.getRequiredUtility(variable), variable);
			expressionSynthesizer2.createCastEdge(bestInitNode, variableClassDatum, castNode);
			bestInitNode = castNode;
		}
		bestInitNode.setOriginatingVariable(variable);
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

	@Override
	public @NonNull Relation getRule() {
		return (Relation) super.getRule();
	}

	@Override
	public @NonNull Relation2TraceGroup getRule2TraceGroup() {
		return (Relation2TraceGroup) super.getRule2TraceGroup();
	}

	@Override
	public @NonNull QVTrelationDirectedScheduleManager getScheduleManager() {
		return (QVTrelationDirectedScheduleManager)scheduleManager;
	}

	//	protected @NonNull TemplateExp getTemplateExp(@NonNull VariableDeclaration variable) {
	//		return ClassUtil.nonNullState(basicGetTemplateExp(variable));
	//	}

	public @NonNull TypedModel getTargetTypedModel() {
		return targetTypedModel;
	}

	public @NonNull TypedModel getTraceTypedModel() {
		return scheduleManager.getTraceTypedModel();
	}

	@Override
	public @NonNull RelationalTransformationAnalysis getTransformationAnalysis() {
		return (RelationalTransformationAnalysis) transformationAnalysis;
	}

	@Override
	public @NonNull RelationalTransformation2TracePackage getTransformation2TracePackage() {
		return (RelationalTransformation2TracePackage) super.getTransformation2TracePackage();
	}

	protected @NonNull Set<@NonNull VariableDeclaration> getNonTopWhenedOutputVariables() {
		return ClassUtil.nonNullState(nonTopWhenedOutputVariables);
	}

	protected @NonNull Set<@NonNull VariableDeclaration> getTopWhenedOutputVariables() {
		return ClassUtil.nonNullState(topWhenedOutputVariables);
	}

	public boolean hasIncomingWhenInvocations() {
		assert baseRelationAnalysis != null;
		if (baseRelationAnalysis != this) {
			return baseRelationAnalysis.hasIncomingWhenInvocations();
		}
		return (incomingWhenInvocation2invocationAnalysis != null) && !incomingWhenInvocation2invocationAnalysis.isEmpty();
	}

	public boolean hasIncomingWhereInvocations() {
		assert baseRelationAnalysis != null;
		if (baseRelationAnalysis != this) {
			return baseRelationAnalysis.hasIncomingWhereInvocations();
		}
		return (incomingWhereInvocation2invocationAnalysis != null) && !incomingWhereInvocation2invocationAnalysis.isEmpty();
	}

	public boolean isKeyedRealization(@NonNull VariableDeclaration variableDeclaration) {
		return getKeyedOutputVariables().contains(variableDeclaration);
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

	/*	public OCLExpression synthesizeKeyTemplate(@NonNull VariableDeclaration templateVariable, @NonNull Node @NonNull [] argNodes) {
		Node keyNode = createOperationNode(true, QVTrelationUtil.getName(templateVariable), templateVariable, argNodes);
		region.addVariableNode(templateVariable, keyNode);
		for (int i = 0; i <= argNodes.length; i++) {
			argNames[i+1] = "«" + referredOperation.getOwnedParameters().get(i).getName() + "»";
			createExpressionEdge(argNodes[i], argNames[i], keyNode);
		}
		return null;
	} */

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

	/*	protected void synthesizeComplexPredicates() {
		/**
	 * Identify any assignments and hidden inputs.
	 * /
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
			else { * /
			Node resultNode = conditionExpression.accept(expressionAnalyzer);
			if ((resultNode != null) && !resultNode.isTrue()) {
				Node trueNode = createTrueNode();
				createPredicateEdge(resultNode, null, trueNode);
			}
			// FIXME ?? do includes() here explicitly
		}
	} */

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

	private void setThisNode(@NonNull Node node) {
		assert thisNode == null;
		this.thisNode  = node;
	}

	public void synthesizeCollectionTemplate(@NonNull CollectionTemplateExp collectionTemplateExp) {
		boolean isOutput = scheduleManager.isOutputInRule(QVTrelationUtil.getContainingRule(collectionTemplateExp), collectionTemplateExp);
		if (isOutput) {
			synthesizeOutputCollectionTemplate(collectionTemplateExp);
		}
		else if (!synthesizeSingleInputCollectionTemplate(collectionTemplateExp)) {
			synthesizeMultipleInputCollectionTemplate(collectionTemplateExp);
		}
	}

	public void synthesizeDefaultValue(@NonNull RelationDomainAssignment relationDomainAssignment) {
		VariableDeclaration variable = QVTrelationUtil.getVariable(relationDomainAssignment);
		OCLExpression valueExp = QVTrelationUtil.getValueExp(relationDomainAssignment);
		Node variableNode = region.getNode(variable);
		if (variableNode != null) {
			CompilerUtil.addRegionWarning(getProblemHandler(), region, "Conflicting default assignment " + relationDomainAssignment);
		}
		else if (!(variable instanceof SharedVariable)) {
			CompilerUtil.addRegionError(getProblemHandler(), region, "Non-SharedVariable for " + relationDomainAssignment);
		}
		else if ((variable instanceof Variable) && (((Variable)variable).getOwnedInit() != null)) {
			CompilerUtil.addRegionError(getProblemHandler(), region, "Default assignment for initialized variable: " + relationDomainAssignment);
		}
		else {
			variableNode = getReferenceNodeForSharedVariable((SharedVariable)variable, valueExp);
		}
	}

	/**
	 *	Create the dispatch node
	 */
	protected @NonNull Node synthesizeDispatchNode(@NonNull Node traceNode) {
		Relation relation = getRule();
		//		assert dispatch != null;
		//
		//	Connect a dispatch node using its do Property.
		//
		Relation2DispatchClass relation2dispatchClass = getRule2TraceGroup().getBaseRelation2TraceGroup().getRule2DispatchClass();
		ClassDatum classDatum = scheduleManager.getClassDatum(getTraceTypedModel(), relation2dispatchClass.getMiddleClass());
		Node dispatchNode = createPredicatedNode(Utility.DISPATCH, QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME, classDatum);
		Property doProperty = relation2dispatchClass.getDispatchClass2TraceProperty(relation).getTraceProperty();
		createNavigationEdge(Utility.NON_NULL_MATCHED, dispatchNode, doProperty, traceNode, false);
		//
		//	Set the trace node as the dispatch's result.
		//
		Property resultProperty = relation2dispatchClass.getResultProperty();
		createRealizedNavigationEdge(Utility.NON_NULL_MATCHED, dispatchNode, resultProperty, traceNode, false);
		//
		//	Set the dispatch node success as true.
		//
		Property dispatchSuccessProperty = relation2dispatchClass.getDispatchSuccessProperty();
		createRealizedSuccess(Utility.NON_NULL_MATCHED, dispatchNode, dispatchSuccessProperty, true);
		//
		//	dispatch node is the head.
		//
		Node headNode = traceNode.isPredicated() ? traceNode : dispatchNode;
		region.getHeadNodes().clear();
		region.getHeadNodes().add(headNode);
		headNode.setHead();
		if (thisNode != null) {
			region.getHeadNodes().add(thisNode);
		}
		return dispatchNode;
	}

	/**
	 * Attempt to synthesize an x=y predicateExpression, returning true if successful.
	 */
	protected boolean synthesizeEqualsPredicate(@NonNull OCLExpression predicateExpression) {
		if (!(predicateExpression instanceof OperationCallExp)) {
			return false;
		}
		OperationCallExp operationCallExp = (OperationCallExp)predicateExpression;
		Operation operation = QVTrelationUtil.getReferredOperation(operationCallExp);
		OperationId oclAnyEqualsId = scheduleManager.getStandardLibraryHelper().getOclAnyEqualsId();
		if (!PivotUtil.isSameOperation(operation.getOperationId(), oclAnyEqualsId)) {
			return false;
		}
		OCLExpression leftExpression = QVTrelationUtil.getOwnedSource(operationCallExp);
		OCLExpression rightExpression = QVTrelationUtil.getOwnedArgument(operationCallExp, 0);
		if (leftExpression instanceof VariableExp) {
			VariableDeclaration leftVariable = QVTrelationUtil.getReferredVariable((VariableExp)leftExpression);
			return synthesizeVariableEqualsPredicate(leftVariable, rightExpression);
		}
		if (rightExpression instanceof VariableExp) {
			VariableDeclaration rightVariable = QVTrelationUtil.getReferredVariable((VariableExp)rightExpression);
			return synthesizeVariableEqualsPredicate(rightVariable, leftExpression);
		}
		if (leftExpression instanceof NavigationCallExp) {
			return synthesizeNavigationCallEqualsPredicate((NavigationCallExp)leftExpression, rightExpression);
		}
		if (rightExpression instanceof NavigationCallExp) {
			return synthesizeNavigationCallEqualsPredicate((NavigationCallExp)rightExpression, leftExpression);
		}
		// FIXME What about OperationCallExp ?? see Bug 547263
		return false;
	}

	/**
	 *	Create the invocation interface for a non-top relation.
	 */
	protected void synthesizeIncomingNonTopInvocation(@NonNull Node traceNode) {
		Relation relation = getRule();
		if (!relation.isIsTopLevel()) {
			if (QVTrelationUtil.hasOverrides(relation)) {
				Relation baseRelation = QVTrelationUtil.getBaseRelation(relation);
				Relation2TraceGroup baseRelation2traceGroup = getRule2TraceGroup().getBaseRelation2TraceGroup();
				Relation2MiddleType baseRelation2invocationInterface = baseRelation2traceGroup.getRule2InvocationInterface();
				org.eclipse.ocl.pivot.Class baseInvocationClass = baseRelation2invocationInterface.getMiddleClass();
				ClassDatum classDatum = scheduleManager.getClassDatum(scheduleManager.getTraceTypedModel(), baseInvocationClass);
				Node invocationNode = createPredicatedNode(Utility.NON_NULL_MATCHED, QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME, classDatum);
				region.getHeadNodes().add(invocationNode);
				invocationNode.setHead();
				Relation2ResultProperty relation2resultProperty = baseRelation2invocationInterface.basicGetRelation2ResultProperty();
				if (relation2resultProperty != null) {
					Property resultProperty = relation2resultProperty.getTraceProperty();
					rootExpressionSynthesizer.createRealizedNavigationEdge(invocationNode, resultProperty, traceNode, false);
				}
				for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
					Node rootNode = region.getNode(rootVariable);
					assert rootNode != null;
					VariableDeclaration baseRootVariable = QVTrelationUtil.getOverriddenVariable(baseRelation, rootVariable);
					Property traceProperty = baseRelation2invocationInterface.getTraceProperty(baseRootVariable);
					rootExpressionSynthesizer.createNavigationEdge(invocationNode, traceProperty, rootNode, false);
				}
			}
			else {
				region.getHeadNodes().add(traceNode);
			}
		}
	}

	protected void synthesizeInterfaceAssignments(@NonNull Relation2TraceGroup relation2traceGroup, @NonNull Node traceNode) {
		//		Relation relation = getRule();
		//		RelationAnalysis overriddenRelationAnalysis = getBaseRelationAnalysis();
		//		Relation overriddenRelation = overriddenRelationAnalysis.getRule();
		//		relation2traceGroup overriddenrelation2traceGroup = overriddenRelationAnalysis.getRule2TraceGroup();
		//		Relation2MiddleType overriddenRelation2TraceInterface = overriddenrelation2traceGroup.basicGetRule2TraceInterface();
		/*		assert (dispatch != null) == (overriddenRelation2TraceInterface != null);
		if (overriddenRelation2TraceInterface != null) {
			for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
				Node rootVariableNode = getReferenceNode(rootVariable);
				VariableDeclaration overriddenRootVariable = QVTrelationUtil.getOverriddenVariable(overriddenRelation, rootVariable);
				Property interfaceProperty = overriddenRelation2TraceInterface.getTraceProperty(overriddenRootVariable);
				createRealizedNavigationEdge(traceNode, interfaceProperty, rootVariableNode, null);
			}
		} */
	}

	public OCLExpression synthesizeKeyTemplate(@NonNull VariableDeclaration templateVariable, @NonNull Map<@NonNull Property, @NonNull Node> property2node) {
		//		List<@NonNull Property> properties = new ArrayList<>(property2node.keySet());
		//		Collections.sort(properties, NameUtil.NAMEABLE_COMPARATOR);
		//		@NonNull Node[] argNodes = new @NonNull Node[properties.size()];
		//		int argIndex = 0;
		//		for (@NonNull Property property : properties) {
		//			Node node = property2node.get(property);
		//			assert node != null;
		//			argNodes[argIndex++] = node;
		//		}
		//		boolean isUnconditional = true;
		Node keyNode = region.getNode(templateVariable); //createKeyedNode(isUnconditional, QVTrelationUtil.getName(templateVariable), templateVariable, argNodes);
		assert keyNode != null;
		ClassDatum classDatum = ((KeyedValueNode)keyNode).getClassDatumValue();
		assert classDatum != null;
		for (@NonNull Property property : property2node.keySet()) {
			Node node = property2node.get(property);
			assert node != null;
			PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(classDatum, property, node.getClassDatum());
			createKeyPartEdge(keyNode.getUtility(), node, propertyDatum, keyNode);
		}
		return null;
	}

	public @NonNull Node synthesizeKeyTemplatePart(@NonNull PropertyTemplateItem propertyTemplateItem) {
		OCLExpression targetExpression = QVTrelationUtil.getOwnedValue(propertyTemplateItem);
		Node partNode = targetExpression.accept(rootExpressionSynthesizer);
		assert partNode != null;
		return partNode;
	}

	protected void synthesizeMultipleInputCollectionTemplate(@NonNull CollectionTemplateExp collectionTemplateExp) {
		Node residueNode = collectionTemplateExp.accept(rootExpressionSynthesizer);
		assert residueNode != null;

		/*		EObject eContainer = collectionTemplateExp.eContainer();
		if (eContainer instanceof PropertyTemplateItem) {

		}
		ObjectTemplateExp objectTemplateExp = QVTrelationUtil.getOwningObjectTemplateExp(propertyTemplateItem);
		Node sourceNode = objectTemplateExp.accept(expressionSynthesizer);
		assert sourceNode != null;
		Node memberNode = members.get(0).accept(expressionSynthesizer);
		assert memberNode != null;
		createNavigationEdge(sourceNode, source2target, memberNode, true); */



		Operation collectionExcludingOperation = scheduleManager.getStandardLibraryHelper().getCollectionExcludingOperation();
		Node memberNode = null;
		//		int i = 1;
		for (@NonNull OCLExpression member : QVTrelationUtil.getOwnedMembers(collectionTemplateExp)) {
			if (memberNode != null) {
				Node selfNode = residueNode;
				assert selfNode != null;
				residueNode = createOperationCallNode(Utility.NON_NULL_MATCHED, null, collectionExcludingOperation, collectionTemplateExp, residueNode, memberNode);
				createOperationSelfEdge(selfNode.getUtility(), selfNode, QVTrelationUtil.getType(collectionExcludingOperation), residueNode);
				createOperationParameterEdge(memberNode.getUtility(), memberNode, QVTrelationUtil.getOwnedParameter(collectionExcludingOperation, 0), -1, residueNode);
			}
			memberNode = member.accept(rootExpressionSynthesizer);
			assert memberNode != null;
			//			memberNodes.add(memberNode);
			//			createPredicateEdge(collectionNode, "head-" + i++, memberNode);
			createPredicateEdge(Utility.NON_NULL_MATCHED, residueNode, memberNode, true);
		}
		Variable rest = collectionTemplateExp.getRest();
		if ((rest != null) && !rest.isIsImplicit()) {
			if (memberNode != null) {
				Node selfNode = residueNode;
				assert selfNode != null;
				residueNode = createOperationCallNode(Utility.NON_NULL_MATCHED, null, collectionExcludingOperation, collectionTemplateExp, residueNode, memberNode);
				createOperationSelfEdge(selfNode.getUtility(), selfNode, QVTrelationUtil.getType(collectionExcludingOperation), residueNode);
				createOperationParameterEdge(memberNode.getUtility(), memberNode, QVTrelationUtil.getOwnedParameter(collectionExcludingOperation, 0), -1, residueNode);
			}
			Node restNode = rest.accept(rootExpressionSynthesizer);
			assert restNode != null;
			createEqualsEdge(Utility.NON_NULL_MATCHED, residueNode, restNode);
		}
		if (rest == null) {
			Operation collectionIsEmptyOperation = scheduleManager.getStandardLibraryHelper().getCollectionIsEmptyOperation();
			Node isEmptyNode = createOperationCallNode(Utility.NON_NULL_MATCHED, null, collectionIsEmptyOperation, collectionTemplateExp, residueNode);
			createPredicatedStepNode(Utility.NON_NULL_MATCHED, isEmptyNode);
		}
	}

	protected boolean synthesizeNavigationCallEqualsPredicate(@NonNull NavigationCallExp navExpression, @NonNull OCLExpression valueExpression) {
		Node valueNode = valueExpression.accept(rootExpressionSynthesizer);
		assert valueNode != null;
		OCLExpression sourceExpression = QVTbaseUtil.getOwnedSource(navExpression);
		Node sourceNode = sourceExpression.accept(rootExpressionSynthesizer);
		assert sourceNode != null;
		Property source2targetProperty = QVTbaseUtil.getReferredProperty(navExpression);
		rootExpressionSynthesizer.createNavigationEdge(sourceNode, source2targetProperty, valueNode, false);
		return true;
	}

	public @NonNull OCLExpression synthesizeObjectTemplatePart(@NonNull PropertyTemplateItem propertyTemplateItem) {
		ObjectTemplateExp sourceObjectTemplateExp = QVTrelationUtil.getOwningObjectTemplateExp(propertyTemplateItem);
		Variable sourceVariable = QVTrelationUtil.getBindsTo(sourceObjectTemplateExp);
		Node sourceNode = region.getNode(sourceVariable);
		assert sourceNode != null;
		Property source2targetProperty = QVTrelationUtil.getReferredProperty(propertyTemplateItem);
		OCLExpression targetExpression = QVTrelationUtil.getOwnedValue(propertyTemplateItem);
		if (targetExpression instanceof CollectionTemplateExp) {
			// The bound variables of CollectionTemplateExp do not need tracing and can generally be bypassed
			Variable targetVariable = QVTrelationUtil.getBindsTo((CollectionTemplateExp) targetExpression);
			Node targetNode = region.getNode(targetVariable);
			if (targetNode != null) {
				boolean isPartial = scheduleManager.computeIsPartial(targetNode, source2targetProperty);
				if (scheduleManager.isOutputInRule(QVTrelationUtil.getContainingRule(propertyTemplateItem), sourceVariable) /*&& !propertyTemplateItem.isCheckOnly()*/) {
					rootExpressionSynthesizer.createRealizedNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
				}
				else {
					rootExpressionSynthesizer.createNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
				}
			}
		}
		else {
			Node targetNode = rootExpressionSynthesizer.getRequiredExpressionSynthesizer(source2targetProperty.isIsRequired()).synthesize(targetExpression);
			boolean isPartial = scheduleManager.computeIsPartial(targetNode, source2targetProperty);
			if (scheduleManager.isOutputInRule(QVTbaseUtil.getContainingRule(sourceVariable), sourceVariable) /*&& !propertyTemplateItem.isCheckOnly()*/) {
				rootExpressionSynthesizer.createRealizedNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
			}
			else {
				rootExpressionSynthesizer.createNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
			}
		}
		return targetExpression;
	}

	/**
	 *	Create the nodes for when invocations
	 */
	protected void synthesizeOutgoingWhenInvocations(@NonNull Node traceNode) {
		Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> outgoingWhenInvocation2invocationAnalysis2 = outgoingWhenInvocation2invocationAnalysis;
		if (outgoingWhenInvocation2invocationAnalysis2 != null) {
			List<@Nullable InvocationAnalysis> invocationAnalyses = new ArrayList<>(outgoingWhenInvocation2invocationAnalysis2.values());
			Collections.sort(invocationAnalyses, iNVOCATION_ANALYSIS_COMPARATOR);
			for (InvocationAnalysis invocationAnalysis : invocationAnalyses) {
				assert invocationAnalysis != null;
				Node invokingNode = invocationAnalysis.synthesizeInvocationNodes(traceNode);
				Map<@NonNull Node, @NonNull InvocationAnalysis> invokingNode2invocationAnalysis2 = invokingNode2invocationAnalysis;
				if (invokingNode2invocationAnalysis2 == null) {
					invokingNode2invocationAnalysis = invokingNode2invocationAnalysis2 = new HashMap<>();
				}
				InvocationAnalysis oldInvocationAnalysis = invokingNode2invocationAnalysis2.put(invokingNode, invocationAnalysis);
				assert oldInvocationAnalysis == null;
			}
		}
	}

	/**
	 *	Create the nodes for where invocations
	 */
	protected void synthesizeOutgoingWhereInvocations(@NonNull Node traceNode) {
		Map<@NonNull RelationCallExp, @Nullable InvocationAnalysis> outgoingWhereInvocation2invocationAnalysis2 = outgoingWhereInvocation2invocationAnalysis;
		if (outgoingWhereInvocation2invocationAnalysis2 != null) {
			List<@Nullable InvocationAnalysis> invocationAnalyses = new ArrayList<>(outgoingWhereInvocation2invocationAnalysis2.values());
			Collections.sort(invocationAnalyses, iNVOCATION_ANALYSIS_COMPARATOR);
			for (InvocationAnalysis invocationAnalysis : invocationAnalyses) {
				assert invocationAnalysis != null;
				invocationAnalysis.synthesizeInvocationNodes(traceNode);
			}
		}
	}

	protected void synthesizeOutputCollectionTemplate(@NonNull CollectionTemplateExp collectionTemplateExp) {
		// FIXME multiples
		EObject eContainer = collectionTemplateExp.eContainer();
		if (eContainer instanceof PropertyTemplateItem) {
			PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem)eContainer;
			Property source2target = QVTrelationUtil.getReferredProperty(propertyTemplateItem);
			ObjectTemplateExp objectTemplateExp = QVTrelationUtil.getOwningObjectTemplateExp(propertyTemplateItem);
			Node sourceNode = objectTemplateExp.accept(rootExpressionSynthesizer);
			assert sourceNode != null;
			for (@NonNull OCLExpression member : QVTrelationUtil.getOwnedMembers(collectionTemplateExp)) {
				Node memberNode = member.accept(rootExpressionSynthesizer);
				assert memberNode != null;
				rootExpressionSynthesizer.createRealizedNavigationEdge(sourceNode, source2target, memberNode, true);
			}
		}
		else {
			// FIXME can this ever happen ?
			Node collectionNode = collectionTemplateExp.accept(rootExpressionSynthesizer);
			assert collectionNode != null;
			for (@NonNull OCLExpression member : QVTrelationUtil.getOwnedMembers(collectionTemplateExp)) {
				Node memberNode = member.accept(rootExpressionSynthesizer);
				assert memberNode != null;
				//			memberNodes.add(memberNode);
				//			createPredicateEdge(collectionNode, "head-" + i++, memberNode);
				createRealizedIncludesEdge(memberNode.getUtility(), collectionNode, memberNode);
			}
		}
	}

	/**
	 *	Create the guards for overriding relations.
	 */
	protected void synthesizeOverridingGuards(@Nullable Node dispatchNode, @NonNull Node traceNode) {
		Relation relation = getRule();
		QVTrelationScheduleManager scheduleManager2 = getScheduleManager();
		TypedModel traceTypedModel = scheduleManager2.getTraceTypedModel();
		Iterable<@NonNull Relation> overridingRelations = QVTrelationUtil.getOverrides(relation);
		if (!Iterables.isEmpty(overridingRelations)) {
			for (@NonNull Relation overridingRelation : overridingRelations) {
				RelationAnalysis overridingRelationAnalysis = scheduleManager2.getRuleAnalysis(overridingRelation);
				RelationAnalysis overriddenRelationAnalysis = overridingRelationAnalysis.getBaseRelationAnalysis();
				boolean isWhere = overriddenRelationAnalysis.hasIncomingWhereInvocations();
				Relation2TraceGroup overridingrelation2traceGroup = overridingRelationAnalysis.getRule2TraceGroup();
				Relation2MiddleType overridingRelation2TraceInterface = overridingrelation2traceGroup.getRule2TraceInterface();
				Relation2MiddleType overridingRelation2TraceClass = overridingrelation2traceGroup.getRule2TraceClass();
				ClassDatum overridingClassDatum = scheduleManager2.getClassDatum(traceTypedModel, overridingRelation2TraceInterface.getMiddleClass());
				Node guardNode = createPredicatedNode(Utility.NON_NULL_MATCHED, "not_" + overridingRelation.getName(), overridingClassDatum);
				Property globalSuccessProperty = overridingRelation2TraceClass.getGlobalSuccessProperty();
				createPredicatedSuccess(Utility.NON_NULL_MATCHED, guardNode, globalSuccessProperty, false);
				if (dispatchNode != null) {
					Relation2DispatchClass relation2dispatchClass = overriddenRelationAnalysis.getRule2TraceGroup().getRule2DispatchClass();
					DispatchClass2TraceProperty dispatchClass2TraceProperty = relation2dispatchClass.getDispatchClass2TraceProperty(overridingRelation);
					Property guardProperty = dispatchClass2TraceProperty.getTraceProperty();
					createNavigationEdge(Utility.NON_NULL_MATCHED, dispatchNode, guardProperty, guardNode, false);
				}
				if (isWhere /*|| scheduleManager2.getDomainUsage(rootVariable).isInput()*/) {
					for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
						Node rootVariableNode = getReferenceNode(rootVariable);
						VariableDeclaration overridingRootVariable = QVTrelationUtil.getOverriddenVariable(overridingRelation, rootVariable);
						Property invocationProperty = overridingRelation2TraceInterface.getTraceProperty(overridingRootVariable);
						boolean isPartial = scheduleManager.computeIsPartial(rootVariableNode, invocationProperty);
						createNavigationEdge(rootVariableNode.getUtility(), guardNode, invocationProperty, rootVariableNode, isPartial);
					}
				}
			}
		}
	}

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

	/*	protected void analyzeInvocations(@NonNull Pattern pattern, boolean isWhen) {
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
	} */

	protected void synthesizePredicate(@NonNull OCLExpression predicateExpression) {
		QVTrelationDirectedScheduleManager scheduleManager = getScheduleManager();
		Domain asDomain = QVTrelationUtil.basicGetContainingDomain(predicateExpression);
		if ((asDomain != null) && scheduleManager.isOutputInRule(QVTrelationUtil.getContainingRule(asDomain), asDomain)) {
			return;
		}
		if (synthesizeEqualsPredicate(predicateExpression)) {
			return;
		}
		Node resultNode = predicateExpression.accept(rootExpressionSynthesizer.getExpressionSynthesizer(Utility.NON_NULL_MATCHED)); //.getConditionalExpressionSynthesizer());	// See Bug 547263
		/*		if (resultNode != null) {
			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(resultNode);
			if (!resultNode.isRequired() || (classDatum != scheduleManager.getBooleanClassDatum())) {
				//	if (!resultNode.isRequired() || !(resultNode instanceof BooleanLiteralNode)) {
				Node trueNode = createBooleanLiteralNode(true);
				createPredicateEdge(resultNode, null, trueNode);
			}
		} */
		if (resultNode != null) {
			//			ClassDatum classDatum = QVTscheduleUtil.getClassDatum(resultNode);
			//			if (!resultNode.isRequired() || (classDatum != scheduleManager.getBooleanClassDatum())) {
			/*if (!resultNode.isRequired()) {
				Node trueNode = createBooleanLiteralNode(resultNode.getUtility(), true);
				createPredicateEdge(resultNode.getUtility(), resultNode, null, trueNode);
			}
			//	else if (classDatum != scheduleManager.getBooleanClassDatum()) {
			//		Node trueNode = createBooleanLiteralNode(true);
			//		createPredicateEdge(resultNode, null, trueNode);
			//	}
			else*/ if (!(resultNode instanceof BooleanLiteralNode)) {
				Node trueNode = createBooleanLiteralNode(resultNode.getUtility(), true);
				createPredicateEdge(resultNode.getUtility(), resultNode, trueNode, false);
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

	/**
	 * Synthesize the simple input CollectionTemplateExp pattern match comprising a single member and no rest.
	 *
	 * Returns false if a more complex multi-member match is needed.
	 */
	protected boolean synthesizeSingleInputCollectionTemplate(@NonNull CollectionTemplateExp collectionTemplateExp) {
		Variable rest = collectionTemplateExp.getRest();
		if ((rest == null) || !rest.isIsImplicit()) {
			return false;
		}
		List<OCLExpression> members = collectionTemplateExp.getMember();
		if (members.size() > 1) {
			return false;
		}
		EObject eContainer = collectionTemplateExp.eContainer();
		if (!(eContainer instanceof PropertyTemplateItem)) {
			return false;				// Can this ever happen?
		}
		PropertyTemplateItem propertyTemplateItem = (PropertyTemplateItem)eContainer;
		Property source2target = QVTrelationUtil.getReferredProperty(propertyTemplateItem);
		ObjectTemplateExp objectTemplateExp = QVTrelationUtil.getOwningObjectTemplateExp(propertyTemplateItem);
		Node sourceNode = objectTemplateExp.accept(rootExpressionSynthesizer);
		assert sourceNode != null;
		Node memberNode = members.get(0).accept(rootExpressionSynthesizer);
		assert memberNode != null;
		rootExpressionSynthesizer.createNavigationEdge(sourceNode, source2target, memberNode, true);
		return true;
	}

	/**
	 *	Create the trace node assignments to pattern nodes
	 */
	protected void synthesizeTraceEdges(@NonNull Node traceNode, @Nullable Node dispatchNode) {
		Relation relation = getRule();
		if (dispatchNode != null) {
			Relation2TraceGroup baseRelation2traceGroup = getRule2TraceGroup().getBaseRelation2TraceGroup();
			Relation2DispatchClass rule2dispatchClass = baseRelation2traceGroup.getRule2DispatchClass();
			//			Relation2TraceClass rule2traceClass = getRule2TraceGroup().getRule2TraceClass();
			Relation baseRelation = baseRelation2traceGroup.getRule();
			for (@NonNull RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
				Boolean isInput = getScheduleManager().isInputInRule(relation, relationDomain) || hasIncomingWhereInvocations();
				for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relationDomain)) {
					VariableDeclaration baseRootVariable = QVTrelationUtil.getOverriddenVariable(baseRelation, rootVariable);
					VariableDeclaration2TraceProperty overriddenVariableDeclaration2traceProperty = rule2dispatchClass.getVariableDeclaration2TraceProperty(baseRootVariable);
					//					VariableDeclaration2TraceProperty overridingVariableDeclaration2traceProperty = rule2traceClass.getVariableDeclaration2TraceProperty(rootVariable);
					Property traceProperty = overriddenVariableDeclaration2traceProperty.getTraceProperty();
					//					VariableDeclaration tracedVariable = overridingVariableDeclaration2traceProperty.getOverridingVariable();
					Node targetNode = region.getNode(rootVariable);
					assert targetNode != null;
					boolean isPartial = scheduleManager.computeIsPartial(dispatchNode, traceProperty);
					if (isInput) {
						createNavigationEdge(targetNode.getUtility(), dispatchNode, traceProperty, targetNode, isPartial);
					}
					else {
						createRealizedNavigationEdge(targetNode.getUtility(), dispatchNode, traceProperty, targetNode, isPartial);
					}
				}
			}
			boolean hasPredicatedTrace = traceNode.isPredicated(); // || traceNode.isSpeculated();
			assert hasPredicatedTrace;
			List<@NonNull ? extends VariableDeclaration> rootVariables = QVTrelationUtil.getRootVariables(relation);
			Relation2TraceClass rule2traceClass = getRule2TraceGroup().getRule2TraceClass();
			for (@NonNull VariableDeclaration2TraceProperty variableDeclaration2traceProperty : rule2traceClass.getVariableDeclaration2TraceProperties()) {
				Property traceProperty = variableDeclaration2traceProperty.getTraceProperty();
				VariableDeclaration tracedVariable = variableDeclaration2traceProperty.getOverridingVariable();
				Node targetNode = region.getNode(tracedVariable);
				assert targetNode != null;
				if (!rootVariables.contains(tracedVariable)) {
					boolean isPartial = scheduleManager.computeIsPartial(targetNode, traceProperty);
					createRealizedNavigationEdge(targetNode.getUtility(), traceNode, traceProperty, targetNode, isPartial);
				}
			}
		}
		else {
			boolean hasPredicatedTrace = traceNode.isPredicated(); // || traceNode.isSpeculated();
			List<@NonNull ? extends VariableDeclaration> rootVariables = QVTrelationUtil.getRootVariables(relation);
			Iterable<@NonNull VariableDeclaration2TraceProperty> variableDeclaration2TraceProperties = null;
			if (!QVTrelationUtil.isAbstract(relation)) {
				Relation2TraceClass rule2traceClass = getRule2TraceGroup().getRule2TraceClass();
				variableDeclaration2TraceProperties = rule2traceClass.getVariableDeclaration2TraceProperties();
			}
			else {
				Relation2DispatchClass rule2dispatchClass = getRule2TraceGroup().getRule2DispatchClass();
				variableDeclaration2TraceProperties = rule2dispatchClass.getVariableDeclaration2TraceProperties();
			}
			for (@NonNull VariableDeclaration2TraceProperty variableDeclaration2traceProperty : variableDeclaration2TraceProperties) {
				Property traceProperty = variableDeclaration2traceProperty.getTraceProperty();
				VariableDeclaration tracedVariable = variableDeclaration2traceProperty.getOverridingVariable();
				Node targetNode = region.getNode(tracedVariable);
				assert targetNode != null;
				boolean isPartial = scheduleManager.computeIsPartial(traceNode, traceProperty);
				if (hasPredicatedTrace && rootVariables.contains(tracedVariable)) {
					createNavigationEdge(Utility.getRequiredUtility(traceProperty), traceNode, traceProperty, targetNode, isPartial);
				}
				else {
					createRealizedNavigationEdge(Utility.getRequiredUtility(traceProperty), traceNode, traceProperty, targetNode, isPartial);
				}
			}
		}
	}

	/**
	 * Create trace and when/where invocation nodes and their edges.
	 */
	public void synthesizeTraceElements(@NonNull Relation2TraceGroup relation2traceGroup) {
		//
		//	Create the dispatch region if needed by an override.
		//
		if (dispatchAnalysis != null) {
			dispatchAnalysis.synthesizeElements();
		}
		//
		//	Create the base region if needed by an override.
		//
		if (verdictAnalysis != null) {
			verdictAnalysis.synthesizeElements();
		}
		//
		//	Correct type of the trace variable
		//
		Relation relation = getRule();
		if (!relation.isIsAbstract()) {
			Relation2TraceClass rule2traceClass = relation2traceGroup.getRule2TraceClass();
			VariableDeclaration traceVariable = QVTrelationUtil.getTraceVariable(relation);
			traceVariable.setType(rule2traceClass.getMiddleClass());
			//
			//	Create the trace node
			//
			Node traceNode = synthesizeTraceNode();
			//
			//	Create the dispatch node
			//
			Node dispatchNode = QVTrelationUtil.hasOverrides(relation) ? synthesizeDispatchNode(traceNode) : null;
			//
			//	Create the trace node assignments to pattern nodes
			//
			synthesizeTraceEdges(traceNode, dispatchNode);
			//
			//	Create the nodes for when invocations
			//
			synthesizeOutgoingWhenInvocations(traceNode);
			//
			//	Create the nodes for where invocations
			//
			synthesizeOutgoingWhereInvocations(traceNode);
			//
			//	Create the invocation interface for a non-top relation.
			//
			//			synthesizeIncomingNonTopInvocation(traceNode);
			//
			//	Create the guards for overriding relations.
			//
			synthesizeOverridingGuards(dispatchNode, traceNode);
			//
			//	Create the trace status.
			//
			synthesizeTraceGlobalSuccessAssignment(relation2traceGroup, traceNode);
			//
			//	Create the interface property and status assignments.
			//
			synthesizeInterfaceAssignments(relation2traceGroup, traceNode);
		}
		else if (!relation.isIsTopLevel()) {
			Relation2MiddleType rule2traceInterface = relation2traceGroup.getRule2TraceInterface();
			VariableDeclaration traceVariable = QVTrelationUtil.getTraceVariable(relation);
			traceVariable.setType(rule2traceInterface.getMiddleClass());
			//
			//	Create the trace node
			//
			Node traceNode = synthesizeTraceNode();
			//
			//	Create the trace node assignments to pattern nodes
			//
			synthesizeTraceEdges(traceNode, null);
		}
	}

	protected void synthesizeTraceGlobalSuccessAssignment(@NonNull Relation2TraceGroup relation2traceGroup, @NonNull Node traceNode) {
		Element2MiddleProperty relation2globalSuccessProperty = relation2traceGroup.basicGetRelation2GlobalSuccessProperty();
		if (relation2globalSuccessProperty != null) {
			createRealizedSuccess(Utility.NON_NULL_MATCHED, traceNode, relation2globalSuccessProperty.getTraceProperty(), null);
		}
	}

	/*	public void synthesizeTraceLocalSuccessAssignment(@NonNull relation2traceGroup relation2traceGroup, @NonNull Node traceNode) {
		Relation2TraceClass relation2TraceClass = relation2traceGroup.getRule2TraceClass();
		Element2MiddleProperty relation2localSuccessProperty = relation2TraceClass.basicGetRelation2LocalSuccessProperty();
		if (relation2localSuccessProperty != null) {
			createRealizedSuccess(traceNode, relation2localSuccessProperty.getTraceProperty(), null);
		}
	} */

	/**
	 *	Create the trace node
	 */
	protected @NonNull Node synthesizeTraceNode() {
		Relation relation = getRule();
		VariableDeclaration traceVariable = QVTrelationUtil.getTraceVariable(relation);
		Node traceNode;
		boolean hasOverrides = QVTrelationUtil.hasOverrides(relation);
		if (hasOverrides) {
			traceNode = createOldNode(Utility.TRACE, traceVariable);
		}
		else if (!relation.isIsTopLevel()) {
			//			if (hasOverrides) {
			traceNode = createOldNode(Utility.TRACE, traceVariable);
			//		DomainUsage domainUsage = scheduleManager.getDomainUsage(traceVariable);
			//		boolean isEnforceable = domainUsage.isOutput() || domainUsage.isMiddle();
			//		Role phase = isEnforceable ? Role.PREDICATED : Role.LOADED;
			//		Role nodeRole = phase;
			//		PatternVariableNode traceNode = QVTscheduleFactory.eINSTANCE.createPatternVariableNode();
			//		traceNode.initialize(nodeRole, region, getName(traceVariable), scheduleManager.getClassDatum(traceVariable));
			//		traceNode.initializeVariable(region, traceVariable);
			//		traceNode.setMatched(true);
			//
			region.getHeadNodes().clear();
			region.getHeadNodes().add(traceNode);
			traceNode.setHead();
			if (thisNode != null) {
				region.getHeadNodes().add(thisNode);
			}
			//			}
			//			else {
			//				traceNode = createRealizedStepNode(traceVariable);
			//			}
			/****
			if (hasIncomingWhereInvocationAnalyses()) {
				traceNode = createOldNode(traceVariable);
				region.getHeadNodes().clear();
				region.getHeadNodes().add(traceNode);
				traceNode.setHead();
			}
			else {
				traceNode = createRealizedStepNode(traceVariable);
			}
			 ***/
		}
		else {
			boolean hasPredicatedTrace = (incomingWhereInvocation2invocationAnalysis != null) && !hasOverrides;
			traceNode = hasPredicatedTrace ? createOldNode(Utility.TRACE, traceVariable) : createRealizedStepNode(Utility.TRACE, traceVariable);
			if (!getRule().isIsTopLevel()) {
				region.getHeadNodes().clear();
				//			region.getHeadNodes().add(traceNode);
			}
		}
		return traceNode;
	}

	public void synthesizeVariableDeclaration(@NonNull VariableDeclaration variableDeclaration) {	// FIXME move to derived visitVariableDeclaration
		//		boolean isEnforced = false;
		//		ClassDatum classDatum = scheduleManager.getClassDatum(variableDeclaration);
		//		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		//		Map<@NonNull TemplateVariable, @NonNull TemplateExp> variable2templateExp2 = variable2templateExp;
		//		assert variable2templateExp2 != null;
		TemplateExp templateExp = basicGetTemplateExp(variableDeclaration);
		if (QVTrelationUtil.isTraceClassVariable(variableDeclaration)) {
			return; // traceNode created by synthesizeTraceNodes
		}
		else if ((variableDeclaration instanceof Variable) && ((Variable)variableDeclaration).isIsImplicit() && (templateExp == null)) {
			return; // implicit CollectionTemplateExp rest nodes are not needed
		}
		else if (getKeyedOutputVariables().contains(variableDeclaration)) {
			createKeyedNode(Utility.NON_NULL_MATCHED, QVTrelationUtil.getName(variableDeclaration), variableDeclaration);
		}
		else if (getTopWhenedOutputVariables().contains(variableDeclaration)) {
			createOldNode(Utility.getRequiredUtility(variableDeclaration), variableDeclaration);		// when output is created by the invoked when
		}
		else if (getNonTopWhenedOutputVariables().contains(variableDeclaration)) {
			createOldNode(Utility.getRequiredUtility(variableDeclaration), variableDeclaration);		// when output is created by the invoked when
			//			createRealizedStepNode(variableDeclaration);		// when output is created by the invoker
		}
		else if (hasIncomingWhereInvocations() && Iterables.contains(QVTrelationUtil.getRootVariables(getRule()), variableDeclaration)) {
			createOldNode(Utility.getRequiredUtility(variableDeclaration), variableDeclaration);		// where 'output' is created by invoker
		}
		else if (getRealizedOutputVariables().contains(variableDeclaration)) {
			Utility utility = getOptionalMatchAtRootUtility(variableDeclaration);
			createRealizedStepNode(utility, variableDeclaration);
		}
		else {
			if (variableDeclaration instanceof TemplateVariable) {
				assert templateExp != null;
				if (templateExp instanceof CollectionTemplateExp) {
					//					if (scheduleManager.getDomainUsage(templateExp).isOutput()) {
					return; 	// CollectionTemplateExp variables would be bloat
					//					}
				}
				Utility utility = getOptionalMatchAtRootUtility(variableDeclaration);
				createOldNode(utility, variableDeclaration);
			}
			else if (variableDeclaration instanceof SharedVariable) {
				SharedVariable sharedVariable = (SharedVariable)variableDeclaration;
				if (sharedVariable.getOwnedInit() != null) {
					//				defer to re-use initializer node -- createOldNode(sharedVariable);
				}
				else {
					// createOldNode(variableDeclaration);	// FIXME defer to avoid unused variable nodes
				}
			}
			else {
				Utility utility = getOptionalMatchAtRootUtility(variableDeclaration);
				createOldNode(utility, variableDeclaration);		// Never happens
			}
		}
	}


	protected boolean synthesizeVariableEqualsPredicate(@NonNull VariableDeclaration variable, @NonNull OCLExpression valueExp) {
		Node variableNode = region.getNode(variable);
		if (variableNode == null) {
			if (variable instanceof SharedVariable) {
				variableNode = getReferenceNodeForSharedVariable((SharedVariable)variable, valueExp);
			}
			if (variableNode != null) {
				return true;
			}
		}
		variableNode = variable.accept(rootExpressionSynthesizer);
		Node expressionNode = valueExp.accept(rootExpressionSynthesizer);
		assert (variableNode != null) && (expressionNode != null);
		createEqualsEdge(Utility.NON_NULL_MATCHED, expressionNode, variableNode);
		return true;
	}
}