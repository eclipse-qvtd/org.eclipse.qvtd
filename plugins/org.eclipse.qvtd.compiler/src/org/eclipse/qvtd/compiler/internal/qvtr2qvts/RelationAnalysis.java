/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
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
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.UtilityAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RegionHelper;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.RuleHeadAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationalTransformationAnalysis2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.VariableDeclaration2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.DispatchClass2TraceProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.Relation2ResultProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2DispatchClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2MiddleType;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceClass;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.DomainPattern;
import org.eclipse.qvtd.pivot.qvtrelation.Key;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.RelationDomain;
import org.eclipse.qvtd.pivot.qvtrelation.SharedVariable;
import org.eclipse.qvtd.pivot.qvtrelation.TemplateVariable;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.VariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.VerdictRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node.Utility;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.DispatchRegion;
import org.eclipse.qvtd.pivot.qvtschedule.KeyedValueNode;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.PropertyDatum;
import org.eclipse.qvtd.pivot.qvtschedule.QVTscheduleFactory;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvttemplate.CollectionTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.ObjectTemplateExp;
import org.eclipse.qvtd.pivot.qvttemplate.PropertyTemplateItem;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A RelationAnalysis provides the analysis a QVTc mapping.
 */
public class RelationAnalysis extends RuleAnalysis
{
	/**
	 * A Dispatch assists in the synthesis of the dispatch for an override hierarchy.
	 */
	protected class Dispatch extends RegionHelper<@NonNull RuleRegion>
	{
		public Dispatch(@NonNull RuleRegion ruleRegion) {
			super(RelationAnalysis.this.getScheduleManager(), ruleRegion);
		}

		public void gatherRuleRegions(@NonNull List<@NonNull RuleRegion> ruleRegions) {
			ruleRegions.add(region);
		}

		protected void synthesizeDispatchHierarchy(@NonNull Node traceNode, @NonNull RelationAnalysis2DispatchClass relationAnalysis2dispatchClass, @NonNull Relation relation) {
			if (!relation.isIsAbstract()) {
				QVTrelationScheduleManager scheduleManager =(QVTrelationScheduleManager)getScheduleManager();
				RelationAnalysis2TraceClass relationAnalysis2TraceClass = scheduleManager.getRuleAnalysis(relation).getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceClass();
				ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(getTraceTypedModel(), relationAnalysis2TraceClass.getMiddleClass());
				Node dispatchedNode = createRealizedNode(getName(relation), dispatchedClassDatum, true);
				DispatchClass2TraceProperty dispatchClass2traceProperty = relationAnalysis2dispatchClass.getDispatchClass2TraceProperty(relation);
				createRealizedNavigationEdge(traceNode, dispatchClass2traceProperty.getTraceProperty(), dispatchedNode, false);
			}
			for (@NonNull Relation overridingRelation : QVTrelationUtil.getOverrides(relation)) {
				synthesizeDispatchHierarchy(traceNode, relationAnalysis2dispatchClass, overridingRelation);
			}
		}

		/**
		 * Create a realized trace node, a predicated guard node per input root variable and a
		 * predicated property edge between them.
		 */
		public void synthesizeElements() {
			RelationAnalysis2DispatchClass relationAnalysis2dispatchClass = getRuleAnalysis2TraceGroup().getRuleAnalysis2DispatchClass();
			//
			//	Create the trace node
			//
			Node traceNode = synthesizeTraceNode(relationAnalysis2dispatchClass);
			//
			//	Create the trace node assignments to guard nodes
			//
			synthesizeTraceEdges(traceNode);
			//
			//	Create the trace node assignments to pattern nodes
			//
			synthesizeDispatchHierarchy(traceNode, relationAnalysis2dispatchClass, getRule());
			//
			//
			//
			//			Iterable<@NonNull Node> headNodes = RuleHeadAnalysis.computeRuleHeadNodes(scheduleManager, region, null);
			//			List<@NonNull Node> headNodesList = QVTscheduleUtil.Internal.getHeadNodesList(region);
			//			headNodesList.clear();
			//			Iterables.addAll(headNodesList, headNodes);
			UtilityAnalysis.assignUtilities(scheduleManager, region);
		}

		/**
		 *	Create the trace node assignments to pattern nodes
		 */
		protected void synthesizeTraceEdges(@NonNull Node traceNode) {
			//			assert region.getHeadNodes().isEmpty();
			Relation relation = getRule();
			boolean isTopLevel = relation.isIsTopLevel();
			RelationAnalysis2TraceGroup ruleAnalysis2TraceGroup = getRuleAnalysis2TraceGroup();
			RelationAnalysis2DispatchClass ruleAnalysis2dispatchClass = ruleAnalysis2TraceGroup.getRuleAnalysis2DispatchClass();
			for (@NonNull RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
				if (scheduleManager.isInput(relationDomain)) {
					for (@NonNull VariableDeclaration variable : QVTrelationUtil.getRootVariables(relationDomain)) {
						VariableDeclaration2TraceProperty variableDeclaration2traceClassProperty = ruleAnalysis2dispatchClass.getVariableDeclaration2TraceProperty(variable);
						//						VariableDeclaration2TraceProperty variableDeclaration2traceInterfaceProperty = ruleAnalysis2traceInterface.getVariableDeclaration2TraceProperty(variable);
						Property traceClassProperty = variableDeclaration2traceClassProperty.getTraceProperty();
						//						Property traceInterfaceProperty = variableDeclaration2traceInterfaceProperty.getTraceProperty();
						Node targetNode = createOldNode(variable);
						createNavigationEdge(traceNode, traceClassProperty, targetNode, null);
						if (isTopLevel) {
							region.getHeadNodes().add(targetNode);
							targetNode.setHead();
						}
					}
				}
			}




			/*			Relation relation = getRule();
			RelationAnalysis relationAnalysis = RelationAnalysis.this.getScheduleManager().getRuleAnalysis(relation);
			RelationAnalysis2TraceGroup relationAnalysis2TraceGroup = relationAnalysis.getRuleAnalysis2TraceGroup();
			RelationAnalysis2MiddleType relationAnalysis2TraceClass = relationAnalysis2TraceGroup.getRuleAnalysis2TraceClass();
			Property successProperty = relationAnalysis2TraceClass.getSuccessProperty();
			Node falseNode = createBooleanValueNode(true, false);
			createNavigationEdge(traceNode, successProperty, falseNode, false); */
		}

		/**
		 *	Create the trace node
		 */
		protected @NonNull Node synthesizeTraceNode(@NonNull RelationAnalysis2DispatchClass relationAnalysis2dispatchClass) {
			Relation relation = getRule();
			TypedModel traceTypedModel = getTraceTypedModel();
			ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(traceTypedModel, relationAnalysis2dispatchClass.getMiddleClass());
			if (relation.isIsTopLevel()) {
				VariableNode realizedDispatchNode = createRealizedNode(QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME, dispatchedClassDatum, true);
				realizedDispatchNode.setUtility(Utility.TRACE);
				return realizedDispatchNode;
			}
			else {
				Node predicatedDispatchNode = createPredicatedNode(QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME, dispatchedClassDatum, true);
				predicatedDispatchNode.setUtility(Utility.TRACE);
				region.getHeadNodes().add(predicatedDispatchNode);
				predicatedDispatchNode.setHead();
				return predicatedDispatchNode;
			}
		}
	}

	/**
	 * A Verdict assists in the synthesis of the base region that assigns the false success once all overrides have failed.
	 */
	protected class Verdict extends RegionHelper<@NonNull RuleRegion>
	{
		public Verdict(@NonNull RuleRegion ruleRegion) {
			super(RelationAnalysis.this.getScheduleManager(), ruleRegion);
		}

		public void gatherRuleRegions(@NonNull List<@NonNull RuleRegion> ruleRegions) {
			ruleRegions.add(getRegion());
		}

		protected void synthesizeDispatchHierarchy(@NonNull Node traceNode, @NonNull RelationAnalysis2DispatchClass relationAnalysis2dispatchClass, @NonNull Relation relation) {
			if (relation.isIsAbstract()) {						// Cannot test abstract -must test all its overrides
				for (@NonNull Relation overridingRelation : QVTrelationUtil.getOverrides(relation)) {
					synthesizeDispatchHierarchy(traceNode, relationAnalysis2dispatchClass, overridingRelation);
				}
			}
			else {
				//
				//	Create a predicated node for the overriding relation's trace
				//
				QVTrelationScheduleManager scheduleManager =(QVTrelationScheduleManager)getScheduleManager();
				RelationAnalysis2TraceClass relationAnalysis2TraceClass = scheduleManager.getRuleAnalysis(relation).getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceClass();
				RelationAnalysis2MiddleType relationAnalysis2TraceInterface = getBaseRelationAnalysis().getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceInterface();
				ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(getTraceTypedModel(), relationAnalysis2TraceClass.getMiddleClass());
				Node dispatchedNode = createPredicatedNode(getName(relation), dispatchedClassDatum, true);
				//
				//	Reached by the appropriate dispatch navigation.
				//
				DispatchClass2TraceProperty dispatchClass2traceProperty = relationAnalysis2dispatchClass.getDispatchClass2TraceProperty(relation);
				createNavigationEdge(traceNode, dispatchClass2traceProperty.getTraceProperty(), dispatchedNode, false);
				//
				//	Require the overriding relation to have failed.
				//
				Property successProperty = relationAnalysis2TraceInterface.getGlobalSuccessProperty();
				createPredicatedSuccess(dispatchedNode, successProperty, false);
			}
		}

		/**
		 * Create a realized trace node, a predicatec guard node per input root variable and a
		 * predicated property edge between them.
		 */
		public void synthesizeElements() {
			RelationAnalysis2DispatchClass relationAnalysis2dispatchClass = getRuleAnalysis2TraceGroup().getRuleAnalysis2DispatchClass();
			//
			//	Create the trace node
			//
			Node traceNode = synthesizeTraceNode(relationAnalysis2dispatchClass);
			//
			//	Create the trace node assignments to pattern nodes
			//
			synthesizeDispatchHierarchy(traceNode, relationAnalysis2dispatchClass, getRule());
			//
			UtilityAnalysis.assignUtilities(scheduleManager, region);
		}

		/**
		 *	Create the trace node
		 */
		protected @NonNull Node synthesizeTraceNode(@NonNull RelationAnalysis2DispatchClass relationAnalysis2dispatchClass) {
			Relation relation = getRule();
			QVTrelationScheduleManager scheduleManager =(QVTrelationScheduleManager)getScheduleManager();
			TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
			ClassDatum dispatchedClassDatum = scheduleManager.getClassDatum(traceTypedModel, relationAnalysis2dispatchClass.getMiddleClass());
			Node traceNode = createPredicatedNode(getName(relation), dispatchedClassDatum, true);
			region.getHeadNodes().add(traceNode);
			traceNode.setHead();

			Property successProperty = relationAnalysis2dispatchClass.getGlobalSuccessProperty();
			createRealizedSuccess(traceNode, successProperty, false);

			return traceNode;
		}
	}

	/**
	 * Sythesizer for the dispatch execution region of an override hierarchy.
	 */
	private final @Nullable Dispatch dispatch;

	/**
	 * Sythesizer for the override verdict region.
	 */
	private final @Nullable Verdict verdict;

	/**
	 * Predicates that are too complex to analyze. i.e. more than a comparison of a bound variable wrt
	 * a property call chain on another bound variable.
	 */
	//	private final @NonNull Set<@NonNull Predicate> complexPredicates = new HashSet<>();

	//	private @Nullable Node traceNode = null;

	/**
	 * The variable initializers, simple predicate reference expression and variable assignment values that define a value for each variable.
	 * Variable initializers are populated lazily since not all LetVariables may even exist for an eager population.
	 */
	private @NonNull Map<@NonNull VariableDeclaration, @NonNull List<@NonNull OCLExpression>> variable2expressions = new HashMap<>();

	/**
	 * The expressions that call this relation.
	 */
	//	private @Nullable List<@NonNull RelationCallExp> incomingInvocations = null;

	/**
	 * The expressions that call this relation from a when clause.
	 */
	private @Nullable List<@NonNull InvocationAnalysis> incomingWhenInvocationAnalyses = null;

	/**
	 * The expressions that call this relation from a where clause.
	 */
	private @Nullable List<@NonNull InvocationAnalysis> incomingWhereInvocationAnalyses = null;

	/**
	 * The expressions that call relations with this relation.
	 */
	//	private @Nullable List<@NonNull RelationCallExp> outgoingInvocations = null;

	/**
	 * The expressions that call relations with this relation's when clause.
	 */
	private @Nullable List<@NonNull InvocationAnalysis> outgoingWhenInvocationAnalyses = null;

	/**
	 * The expressions that call relations with this relation's where clause.
	 */
	private @Nullable List<@NonNull InvocationAnalysis> outgoingWhereInvocationAnalyses = null;

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
	 * The output variables that are assigned by a when invocation.
	 *
	 * Populated by analyzeSourceModel.
	 */
	private @Nullable Set<@NonNull VariableDeclaration> whenedOutputVariables = null;

	public RelationAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull QVTuConfiguration qvtuConfiguration, @NonNull RuleRegion ruleRegion) {
		super(transformationAnalysis, ruleRegion);
		dispatch = createDispatch(qvtuConfiguration);
		verdict = createVerdict(qvtuConfiguration);
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

	private void addIncomingInvocationAnalysis(@NonNull InvocationAnalysis invocationAnalysis) {
		boolean isWhen = invocationAnalysis.isWhen();
		if (isWhen) {
			List<@NonNull InvocationAnalysis> incomingWhenInvocationAnalyses2 = incomingWhenInvocationAnalyses;
			if (incomingWhenInvocationAnalyses2 == null) {
				incomingWhenInvocationAnalyses = incomingWhenInvocationAnalyses2 = new ArrayList<>();
			}
			incomingWhenInvocationAnalyses2.add(invocationAnalysis);
		}
		else {
			List<@NonNull InvocationAnalysis> incomingWhereInvocationAnalyses2 = incomingWhereInvocationAnalyses;
			if (incomingWhereInvocationAnalyses2 == null) {
				incomingWhereInvocationAnalyses = incomingWhereInvocationAnalyses2 = new ArrayList<>();
			}
			incomingWhereInvocationAnalyses2.add(invocationAnalysis);
		}
	}

	private void addOutgoingInvocationAnalysis(@NonNull InvocationAnalysis invocationAnalysis) {
		boolean isWhen = invocationAnalysis.isWhen();
		if (isWhen) {
			List<@NonNull InvocationAnalysis> outgoingWhenInvocationAnalyses2 = outgoingWhenInvocationAnalyses;
			if (outgoingWhenInvocationAnalyses2 == null) {
				outgoingWhenInvocationAnalyses = outgoingWhenInvocationAnalyses2 = new ArrayList<>();
			}
			outgoingWhenInvocationAnalyses2.add(invocationAnalysis);
		}
		else {
			List<@NonNull InvocationAnalysis> outgoingWhereInvocationAnalyses2 = outgoingWhereInvocationAnalyses;
			if (outgoingWhereInvocationAnalyses2 == null) {
				outgoingWhereInvocationAnalyses = outgoingWhereInvocationAnalyses2 = new ArrayList<>();
			}
			outgoingWhereInvocationAnalyses2.add(invocationAnalysis);
		}
	}

	protected void analyzeContainments() {
		for (@NonNull Node node : region.getNewNodes()) {
			boolean isContained = false;
			for (@NonNull NavigableEdge edge : node.getNavigableEdges()) {
				Property property = edge.getProperty();
				Property opposite = property.getOpposite();
				if ((opposite != null) && opposite.isIsComposite() && !edge.getEdgeTarget().isNullLiteral()) {
					isContained = true;
					break;
				}
			}
			if (isContained) {
				node.setContained(true);
			}
		}
	}

	protected @NonNull Set<@NonNull VariableDeclaration> analyzeKeyedOutputVariables(@NonNull RelationDomain relationDomain) {
		RelationalTransformationAnalysis transformationAnalysis2 = getTransformationAnalysis();
		Set<@NonNull VariableDeclaration> whenedOutputVariables = getWhenedOutputVariables();
		Set<@NonNull VariableDeclaration> keyedOutputVariables = new HashSet<>();
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
		return keyedOutputVariables;
	}

	/*	private void addIncomingRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingInvocations2 = incomingInvocations;
		if (incomingInvocations2 == null) {
			incomingInvocations = incomingInvocations2 = new ArrayList<>();
		}
		incomingInvocations2.add(relationInvocation);
	} */

	/*	private void addIncomingWhenRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingWhenInvocations2 = incomingWhenInvocations;
		if (incomingWhenInvocations2 == null) {
			incomingWhenInvocations = incomingWhenInvocations2 = new ArrayList<>();
		}
		incomingWhenInvocations2.add(relationInvocation);
	} */

	/*	private void addIncomingWhereRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingWhereInvocations2 = incomingWhereInvocations;
		if (incomingWhereInvocations2 == null) {
			incomingWhereInvocations = incomingWhereInvocations2 = new ArrayList<>();
		}
		incomingWhereInvocations2.add(relationInvocation);
	} */

	/*	private void addOutgoingRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingInvocations2 = outgoingInvocations;
		if (outgoingInvocations2 == null) {
			outgoingInvocations = outgoingInvocations2 = new ArrayList<>();
		}
		outgoingInvocations2.add(relationInvocation);
	} */

	/*	private void addOutgoingWhenRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingWhenInvocations2 = outgoingWhenInvocations;
		if (outgoingWhenInvocations2 == null) {
			outgoingWhenInvocations = outgoingWhenInvocations2 = new ArrayList<>();
		}
		outgoingWhenInvocations2.add(relationInvocation);
	} */

	/*	private void addOutgoingWhereRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingWhereInvocations2 = outgoingWhereInvocations;
		if (outgoingWhereInvocations2 == null) {
			outgoingWhereInvocations = outgoingWhereInvocations2 = new ArrayList<>();
		}
		outgoingWhereInvocations2.add(relationInvocation);
	} */

	@Override
	public void analyzeMappingRegion() {
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
		List<@NonNull Node> preferredHeadNodes = Lists.newArrayList(QVTscheduleUtil.getHeadNodes(region));
		Iterable<@NonNull Node> headNodes = RuleHeadAnalysis.computeRuleHeadNodes(scheduleManager, region, preferredHeadNodes);
		List<@NonNull Node> headNodesList = QVTscheduleUtil.Internal.getHeadNodesList(region);
		headNodesList.clear();
		Iterables.addAll(headNodesList, headNodes);
		UtilityAnalysis.assignUtilities(scheduleManager, region);
	}

	/*	private void addIncomingRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingInvocations2 = incomingInvocations;
		if (incomingInvocations2 == null) {
			incomingInvocations = incomingInvocations2 = new ArrayList<>();
		}
		incomingInvocations2.add(relationInvocation);
	} */

	/*	private void addIncomingWhenRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingWhenInvocations2 = incomingWhenInvocations;
		if (incomingWhenInvocations2 == null) {
			incomingWhenInvocations = incomingWhenInvocations2 = new ArrayList<>();
		}
		incomingWhenInvocations2.add(relationInvocation);
	} */

	/*	private void addIncomingWhereRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> incomingWhereInvocations2 = incomingWhereInvocations;
		if (incomingWhereInvocations2 == null) {
			incomingWhereInvocations = incomingWhereInvocations2 = new ArrayList<>();
		}
		incomingWhereInvocations2.add(relationInvocation);
	} */

	/*	private void addOutgoingRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingInvocations2 = outgoingInvocations;
		if (outgoingInvocations2 == null) {
			outgoingInvocations = outgoingInvocations2 = new ArrayList<>();
		}
		outgoingInvocations2.add(relationInvocation);
	} */

	/*	private void addOutgoingWhenRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingWhenInvocations2 = outgoingWhenInvocations;
		if (outgoingWhenInvocations2 == null) {
			outgoingWhenInvocations = outgoingWhenInvocations2 = new ArrayList<>();
		}
		outgoingWhenInvocations2.add(relationInvocation);
	} */

	/*	private void addOutgoingWhereRelation(@NonNull RelationCallExp relationInvocation) {
		List<@NonNull RelationCallExp> outgoingWhereInvocations2 = outgoingWhereInvocations;
		if (outgoingWhereInvocations2 == null) {
			outgoingWhereInvocations = outgoingWhereInvocations2 = new ArrayList<>();
		}
		outgoingWhereInvocations2.add(relationInvocation);
	} */

	protected @NonNull Set<@NonNull VariableDeclaration> analyzeRealizedOutputVariables(@NonNull RelationDomain relationDomain) {
		Set<@NonNull VariableDeclaration> realizedOutputVariables = new HashSet<>();
		for (@NonNull DomainPattern domainPattern : QVTrelationUtil.getOwnedPatterns(relationDomain)) {
			TemplateExp templateExpression = QVTrelationUtil.getOwnedTemplateExpression(domainPattern);
			for (@NonNull EObject eObject : new TreeIterable(templateExpression, true)) {
				if (eObject instanceof TemplateExp) {
					TemplateExp templateExp = (TemplateExp)eObject;
					TemplateVariable templateVariable = (TemplateVariable) QVTrelationUtil.getBindsTo(templateExp);
					realizedOutputVariables.add(templateVariable);
				}
			}
		}
		return realizedOutputVariables;
	}

	@Override
	public void analyzeSourceModel() {
		Relation relation = getRule();
		baseRelationAnalysis = getScheduleManager().getRuleAnalysis(QVTrelationUtil.getBaseRelation(relation));
		variable2templateExp = analyzeVariable2TemplateExp();
		whenedOutputVariables = analyzeWhenedOutputVariables();
		for (@NonNull RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			DomainUsage domainUsage = scheduleManager.getDomainUsage(relationDomain);
			if (domainUsage.isOutput()) {
				assert keyedOutputVariables == null;
				keyedOutputVariables = analyzeKeyedOutputVariables(relationDomain);
				assert realizedOutputVariables == null;
				realizedOutputVariables = analyzeRealizedOutputVariables(relationDomain);
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

	protected @NonNull Set<@NonNull VariableDeclaration> analyzeWhenedOutputVariables() {
		Relation relation = getRule();
		Set<@NonNull VariableDeclaration> whenedOutputVariables = new HashSet<>();
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
							DomainUsage domainUsage = scheduleManager.getDomainUsage(domain);
							if (domainUsage.isOutput()) {
								whenedOutputVariables.add(QVTrelationUtil.getReferredVariable(variableExp));
							}
						}
					}
				}
			}
		}
		return whenedOutputVariables;
	}

	public @Nullable Iterable<@NonNull InvocationAnalysis> basicGetIncomingWhenInvocationAnalyses() {
		return incomingWhenInvocationAnalyses;
	}

	public @Nullable Iterable<@NonNull InvocationAnalysis> basicGetIncomingWhereInvocationAnalyses() {
		return incomingWhereInvocationAnalyses;
	}

	public @Nullable Iterable<@NonNull InvocationAnalysis> basicGetOutgoingWhenInvocationAnalyses() {
		return outgoingWhenInvocationAnalyses;
	}

	public @Nullable Iterable<@NonNull InvocationAnalysis> basicGetOutgoingWhereInvocationAnalyses() {
		return outgoingWhereInvocationAnalyses;
	}

	protected @Nullable TemplateExp basicGetTemplateExp(@NonNull VariableDeclaration variable) {
		return ClassUtil.nonNullState(variable2templateExp).get(variable);
	}

	protected @Nullable Dispatch createDispatch(@NonNull QVTuConfiguration qvtuConfiguration) {
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
		dispatchRegion.setName(getNameGenerator().createMappingName(relation, "dispatch", qvtuConfiguration));
		return new Dispatch(dispatchRegion);
	}

	public @NonNull InvocationAnalysis createInvocationAnalysis(@NonNull RelationAnalysis invokedRelationAnalysis, @NonNull RelationCallExp relationCallExp, boolean isWhen) {
		InvocationAnalysis invocationAnalysis = new InvocationAnalysis(this, invokedRelationAnalysis, relationCallExp, isWhen);
		addOutgoingInvocationAnalysis(invocationAnalysis);
		invokedRelationAnalysis.addIncomingInvocationAnalysis(invocationAnalysis);
		RelationAnalysis invokedBaseRelationAnalysis = invokedRelationAnalysis.getBaseRelationAnalysis();
		invokedBaseRelationAnalysis.addIncomingInvocationAnalysis(invocationAnalysis);
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

	protected @Nullable Verdict createVerdict(@NonNull QVTuConfiguration qvtuConfiguration) {
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
		verdictRegion.setName(getNameGenerator().createMappingName(relation, "verdict", qvtuConfiguration));
		return new Verdict(verdictRegion);
	}

	@Override
	public void gatherRuleRegions(@NonNull List<@NonNull RuleRegion> ruleRegions) {
		//	if (!getRule().isIsAbstract()) {
		super.gatherRuleRegions(ruleRegions);
		//}
		if (dispatch != null) {
			dispatch.gatherRuleRegions(ruleRegions);
		}
		if (verdict != null) {
			verdict.gatherRuleRegions(ruleRegions);
		}
	}

	public @NonNull RelationAnalysis getBaseRelationAnalysis() {
		return ClassUtil.nonNullState(baseRelationAnalysis);
	}

	protected @NonNull Set<@NonNull VariableDeclaration> getKeyedOutputVariables() {
		return ClassUtil.nonNullState(keyedOutputVariables);
	}

	@Override
	public @NonNull QVTrelationNameGenerator getNameGenerator() {
		return (QVTrelationNameGenerator) super.getNameGenerator();
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
				node = createOldNode(variableDeclaration);
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
		String name = variable.getName();
		if ("atlHelper".equals(name)) {
			getClass();
		}
		ExpressionSynthesizer expressionSynthesizer2 = expressionSynthesizer;
		if (variable.isIsRequired()) {
			expressionSynthesizer2 = expressionSynthesizer.getRequiredExpressionSynthesizer();
		}
		Node bestInitNode = bestInitExpression.accept(expressionSynthesizer2);
		assert bestInitNode != null;
		if (variable.isIsRequired()) {
			assert bestInitNode.isRequired();
			assert bestInitNode.isMatched();
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
		CompleteClass initCompleteClass = bestInitNode.getCompleteClass();
		ClassDatum variableClassDatum = scheduleManager.getClassDatum(variable);
		CompleteClass variableCompleteClass = QVTscheduleUtil.getCompleteClass(variableClassDatum);
		if (!initCompleteClass.conformsTo(variableCompleteClass)) {
			Node castNode = createOldNode(variable);
			Property castProperty = scheduleManager.getCastProperty(PivotUtil.getType(variable));
			expressionSynthesizer2.createCastEdge(bestInitNode, castProperty, castNode);
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
	public @NonNull RelationAnalysis2TraceGroup getRuleAnalysis2TraceGroup() {
		return (RelationAnalysis2TraceGroup) super.getRuleAnalysis2TraceGroup();
	}

	@Override
	public @NonNull QVTrelationScheduleManager getScheduleManager() {
		return (QVTrelationScheduleManager)scheduleManager;
	}

	//	protected @NonNull TemplateExp getTemplateExp(@NonNull VariableDeclaration variable) {
	//		return ClassUtil.nonNullState(basicGetTemplateExp(variable));
	//	}

	public @NonNull TypedModel getTraceTypedModel() {
		return scheduleManager.getTraceTypedModel();
	}

	@Override
	public @NonNull RelationalTransformationAnalysis getTransformationAnalysis() {
		return (RelationalTransformationAnalysis) transformationAnalysis;
	}

	@Override
	public @NonNull RelationalTransformationAnalysis2TracePackage getTransformationAnalysis2TracePackage() {
		return (RelationalTransformationAnalysis2TracePackage) super.getTransformationAnalysis2TracePackage();
	}

	//	@Override
	//	public @NonNull String getUniqueVariableName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
	//		return QVTrelationNameGenerator.getUniqueName(name2element2traceProperty, name, element2traceProperty);
	//	}

	/*	@Override
	public void initializeHeadNodes() {
		//		Node traceNode2 = traceNode;
		//		assert traceNode2 != null;
		//		if (getRule().isIsTopLevel()) {
		mappingRegionAnalysis.initHeadNodes(null);
		//		}
		//		else {
		//			region.getHeadNodes().add(traceNode);
		//		}
	} */

	protected @NonNull Set<@NonNull VariableDeclaration> getWhenedOutputVariables() {
		return ClassUtil.nonNullState(whenedOutputVariables);
	}

	public boolean hasIncomingWhenInvocationAnalyses() {
		return getBaseRelationAnalysis().basicGetIncomingWhenInvocationAnalyses() != null;
	}

	public boolean hasIncomingWhereInvocationAnalyses() {
		return getBaseRelationAnalysis().basicGetIncomingWhereInvocationAnalyses() != null;
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

	public void synthesizeCollectionTemplate(@NonNull CollectionTemplateExp collectionTemplateExp) {
		boolean isOutput = scheduleManager.getDomainUsage(collectionTemplateExp).isOutput();
		if (isOutput) {
			synthesizeOutputCollectionTemplate(collectionTemplateExp);
		}
		else if (!synthesizeSingleInputCollectionTemplate(collectionTemplateExp)) {
			synthesizeMultipleInputCollectionTemplate(collectionTemplateExp);
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
		RelationAnalysis2DispatchClass relationAnalysis2dispatchClass = getBaseRelationAnalysis().getRuleAnalysis2TraceGroup().getRuleAnalysis2DispatchClass();
		ClassDatum classDatum = scheduleManager.getClassDatum(getTraceTypedModel(), relationAnalysis2dispatchClass.getMiddleClass());
		Node dispatchNode = createPredicatedNode(QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME, classDatum, true);
		dispatchNode.setUtility(Utility.DISPATCH);
		Property doProperty = relationAnalysis2dispatchClass.getDispatchClass2TraceProperty(relation).getTraceProperty();
		createNavigationEdge(dispatchNode, doProperty, traceNode, false);
		//
		//	Set the trace node as the dispatch's result.
		//
		Property resultProperty = relationAnalysis2dispatchClass.getResultProperty();
		createRealizedNavigationEdge(dispatchNode, resultProperty, traceNode, false);
		//
		//	Set the dispatch node success as true.
		//
		Property globalSuccessProperty = relationAnalysis2dispatchClass.getGlobalSuccessProperty();
		createRealizedSuccess(dispatchNode, globalSuccessProperty, true);
		//
		//	dispatch node is the head.
		//
		Node headNode = traceNode.isPredicated() ? traceNode : dispatchNode;
		region.getHeadNodes().clear();
		region.getHeadNodes().add(headNode);
		headNode.setHead();
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
		Variable variable;
		OCLExpression valueExp;
		if (leftExpression instanceof VariableExp) {
			variable = QVTrelationUtil.getReferredVariable((VariableExp)leftExpression);
			valueExp = rightExpression;
		}
		else if (rightExpression instanceof VariableExp) {
			variable = QVTrelationUtil.getReferredVariable((VariableExp)rightExpression);
			valueExp = leftExpression;
		}
		else {
			return false;
		}
		Node variableNode = region.getNode(variable);
		if (variableNode == null) {
			if (variable instanceof SharedVariable) {
				variableNode = getReferenceNodeForSharedVariable((SharedVariable)variable, valueExp);
			}
			if (variableNode != null) {
				return true;
			}
		}
		variableNode = variable.accept(expressionSynthesizer);
		Node expressionNode = valueExp.accept(expressionSynthesizer);
		assert (variableNode != null) && (expressionNode != null);
		createEqualsEdge(expressionNode, variableNode);
		return true;
	}

	/**
	 *	Create the invocation interface for a non-top relation.
	 */
	protected void synthesizeIncomingNonTopInvocation(@NonNull Node traceNode) {
		Relation relation = getRule();
		if (!relation.isIsTopLevel()) {
			if (QVTrelationUtil.hasOverrides(relation)) {
				Relation baseRelation = QVTrelationUtil.getBaseRelation(relation);
				RelationAnalysis baseRelationAnalysis = getBaseRelationAnalysis();
				RelationAnalysis2TraceGroup baseRelationAnalysis2traceGroup = baseRelationAnalysis.getRuleAnalysis2TraceGroup();
				RelationAnalysis2MiddleType baseRelationAnalysis2invocationInterface = baseRelationAnalysis2traceGroup.getRuleAnalysis2InvocationInterface();
				org.eclipse.ocl.pivot.Class baseInvocationClass = baseRelationAnalysis2invocationInterface.getMiddleClass();
				ClassDatum classDatum = scheduleManager.getClassDatum(scheduleManager.getTraceTypedModel(), baseInvocationClass);
				Node invocationNode = createPredicatedNode(QVTrelationNameGenerator.DISPATCHCLASS_SELF_NAME, classDatum, true);
				invocationNode.setUtility(Utility.DISPATCH);
				region.getHeadNodes().add(invocationNode);
				invocationNode.setHead();
				Relation2ResultProperty relation2resultProperty = baseRelationAnalysis2invocationInterface.basicGetRelation2ResultProperty();
				if (relation2resultProperty != null) {
					Property resultProperty = relation2resultProperty.getTraceProperty();
					createRealizedNavigationEdge(invocationNode, resultProperty, traceNode, false);
				}
				for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
					Node rootNode = region.getNode(rootVariable);
					assert rootNode != null;
					VariableDeclaration baseRootVariable = QVTrelationUtil.getOverriddenVariable(baseRelation, rootVariable);
					Property traceProperty = baseRelationAnalysis2invocationInterface.getTraceProperty(baseRootVariable);
					createNavigationEdge(invocationNode, traceProperty, rootNode, false);
				}
			}
			else {
				region.getHeadNodes().add(traceNode);
			}
		}
	}

	protected void synthesizeInterfaceAssignments(@NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup, @NonNull Node traceNode) {
		//		Relation relation = getRule();
		//		RelationAnalysis overriddenRelationAnalysis = getBaseRelationAnalysis();
		//		Relation overriddenRelation = overriddenRelationAnalysis.getRule();
		//		RelationAnalysis2TraceGroup overriddenRelationAnalysis2TraceGroup = overriddenRelationAnalysis.getRuleAnalysis2TraceGroup();
		//		RelationAnalysis2MiddleType overriddenRelationAnalysis2TraceInterface = overriddenRelationAnalysis2TraceGroup.basicGetRuleAnalysis2TraceInterface();
		/*		assert (dispatch != null) == (overriddenRelationAnalysis2TraceInterface != null);
		if (overriddenRelationAnalysis2TraceInterface != null) {
			for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
				Node rootVariableNode = getReferenceNode(rootVariable);
				VariableDeclaration overriddenRootVariable = QVTrelationUtil.getOverriddenVariable(overriddenRelation, rootVariable);
				Property interfaceProperty = overriddenRelationAnalysis2TraceInterface.getTraceProperty(overriddenRootVariable);
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
			PropertyDatum propertyDatum = scheduleManager.getPropertyDatum(classDatum, property);
			createKeyPartEdge(node, propertyDatum, keyNode);
		}
		return null;
	}

	public @NonNull Node synthesizeKeyTemplatePart(@NonNull PropertyTemplateItem propertyTemplateItem) {
		OCLExpression targetExpression = QVTrelationUtil.getOwnedValue(propertyTemplateItem);
		Node partNode = targetExpression.accept(expressionSynthesizer);
		assert partNode != null;
		return partNode;
	}

	protected void synthesizeMultipleInputCollectionTemplate(@NonNull CollectionTemplateExp collectionTemplateExp) {
		Node residueNode = collectionTemplateExp.accept(expressionSynthesizer);
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
				residueNode = createOperationCallNode(isUnconditional(member), null, collectionExcludingOperation, collectionTemplateExp, residueNode, memberNode);
				createOperationSelfEdge(selfNode, QVTrelationUtil.getType(collectionExcludingOperation), residueNode);
				createOperationParameterEdge(memberNode, QVTrelationUtil.getOwnedParameter(collectionExcludingOperation, 0), -1, residueNode);
			}
			memberNode = member.accept(expressionSynthesizer);
			assert memberNode != null;
			//			memberNodes.add(memberNode);
			//			createPredicateEdge(collectionNode, "head-" + i++, memberNode);
			createPredicateEdge(residueNode, INCLUDES_NAME, memberNode);
		}
		Variable rest = collectionTemplateExp.getRest();
		if ((rest != null) && !rest.isIsImplicit()) {
			if (memberNode != null) {
				Node selfNode = residueNode;
				assert selfNode != null;
				residueNode = createOperationCallNode(isUnconditional(rest), null, collectionExcludingOperation, collectionTemplateExp, residueNode, memberNode);
				createOperationSelfEdge(selfNode, QVTrelationUtil.getType(collectionExcludingOperation), residueNode);
				createOperationParameterEdge(memberNode, QVTrelationUtil.getOwnedParameter(collectionExcludingOperation, 0), -1, residueNode);
			}
			Node restNode = rest.accept(expressionSynthesizer);
			assert restNode != null;
			createEqualsEdge(residueNode, restNode);
		}
		if (rest == null) {
			Operation collectionIsEmptyOperation = scheduleManager.getStandardLibraryHelper().getCollectionIsEmptyOperation();
			Node isEmptyNode = createOperationCallNode(isUnconditional(collectionTemplateExp), null, collectionIsEmptyOperation, collectionTemplateExp, residueNode);
			createPredicatedStepNode(isEmptyNode, false);
		}
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
				if (scheduleManager.getDomainUsage(sourceVariable).isOutput() /*&& !propertyTemplateItem.isCheckOnly()*/) {
					createRealizedNavigationEdge(sourceNode, source2targetProperty, targetNode, null);
				}
				else {
					createNavigationEdge(sourceNode, source2targetProperty, targetNode, null);
				}
			}
		}
		else {
			Node targetNode = expressionSynthesizer.synthesize(targetExpression);
			if (scheduleManager.getDomainUsage(sourceVariable).isOutput() /*&& !propertyTemplateItem.isCheckOnly()*/) {
				createRealizedNavigationEdge(sourceNode, source2targetProperty, targetNode, null);
			}
			else {
				createNavigationEdge(sourceNode, source2targetProperty, targetNode, null);
			}
		}
		return targetExpression;
	}

	/**
	 *	Create the nodes for when invocations
	 */
	protected void synthesizeOutgoingWhenInvocations(@NonNull Node traceNode) {
		List<@NonNull InvocationAnalysis> outgoingWhenInvocationAnalyses2 = outgoingWhenInvocationAnalyses;
		if (outgoingWhenInvocationAnalyses2 != null) {
			for (@NonNull InvocationAnalysis invocationAnalysis : outgoingWhenInvocationAnalyses2) {
				invocationAnalysis.synthesizeInvocationNodes(traceNode);
			}
		}
	}

	/**
	 *	Create the nodes for where invocations
	 */
	protected void synthesizeOutgoingWhereInvocations(@NonNull Node traceNode) {
		List<@NonNull InvocationAnalysis> outgoingWhereInvocationAnalyses2 = outgoingWhereInvocationAnalyses;
		if (outgoingWhereInvocationAnalyses2 != null) {
			for (@NonNull InvocationAnalysis invocationAnalysis : outgoingWhereInvocationAnalyses2) {
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
			Node sourceNode = objectTemplateExp.accept(expressionSynthesizer);
			assert sourceNode != null;
			for (@NonNull OCLExpression member : QVTrelationUtil.getOwnedMembers(collectionTemplateExp)) {
				Node memberNode = member.accept(expressionSynthesizer);
				assert memberNode != null;
				createRealizedNavigationEdge(sourceNode, source2target, memberNode, true);
			}
		}
		else {
			// FIXME can this ever happen ?
			Node collectionNode = collectionTemplateExp.accept(expressionSynthesizer);
			assert collectionNode != null;
			for (@NonNull OCLExpression member : QVTrelationUtil.getOwnedMembers(collectionTemplateExp)) {
				Node memberNode = member.accept(expressionSynthesizer);
				assert memberNode != null;
				//			memberNodes.add(memberNode);
				//			createPredicateEdge(collectionNode, "head-" + i++, memberNode);
				createRealizedIncludesEdge(collectionNode, memberNode);
			}
		}
	}

	/**
	 *	Create the guards for overriding relations.
	 */
	protected void synthesizeOverridingGuards(Node traceNode) {
		Relation relation = getRule();
		QVTrelationScheduleManager scheduleManager2 = getScheduleManager();
		TypedModel traceTypedModel = scheduleManager2.getTraceTypedModel();
		Iterable<@NonNull Relation> overridingRelations = QVTrelationUtil.getOverrides(relation);
		if (!Iterables.isEmpty(overridingRelations)) {
			for (@NonNull Relation overridingRelation : overridingRelations) {
				RelationAnalysis overridingRelationAnalysis = scheduleManager2.getRuleAnalysis(overridingRelation);
				RelationAnalysis overriddenRelationAnalysis = overridingRelationAnalysis.getBaseRelationAnalysis();
				//				Relation overriddenRelation = overriddenRelationAnalysis.getRule();
				boolean isWhere = overriddenRelationAnalysis.hasIncomingWhereInvocationAnalyses();
				//				RelationAnalysis2TraceGroup overriddenRelationAnalysis2TraceGroup = overriddenRelationAnalysis.getRuleAnalysis2TraceGroup();
				RelationAnalysis2TraceGroup overridingRelationAnalysis2TraceGroup = overridingRelationAnalysis.getRuleAnalysis2TraceGroup();
				//				RelationAnalysis2MiddleType overriddenRelationAnalysis2TraceInterface = overriddenRelationAnalysis2TraceGroup.getRuleAnalysis2TraceInterface();
				RelationAnalysis2MiddleType overridingRelationAnalysis2TraceInterface = overridingRelationAnalysis2TraceGroup.getRuleAnalysis2TraceInterface();
				RelationAnalysis2MiddleType overridingRelationAnalysis2TraceClass = overridingRelationAnalysis2TraceGroup.getRuleAnalysis2TraceClass();
				ClassDatum overridingClassDatum = scheduleManager2.getClassDatum(traceTypedModel, overridingRelationAnalysis2TraceInterface.getMiddleClass());
				Node guardNode = createPredicatedNode("not_" + overridingRelation.getName(), overridingClassDatum, true);
				Property globalSuccessProperty = overridingRelationAnalysis2TraceClass.getGlobalSuccessProperty();
				createPredicatedSuccess(guardNode, globalSuccessProperty, false);
				for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
					if (isWhere || scheduleManager2.getDomainUsage(rootVariable).isInput()) {
						Node rootVariableNode = getReferenceNode(rootVariable);
						VariableDeclaration overridingRootVariable = QVTrelationUtil.getOverriddenVariable(overridingRelation, rootVariable);
						Property invocationProperty = overridingRelationAnalysis2TraceInterface.getTraceProperty(overridingRootVariable);
						createNavigationEdge(guardNode, invocationProperty, rootVariableNode, null);
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
		if (synthesizeEqualsPredicate(predicateExpression)) {
			return;
		}
		Node resultNode = predicateExpression.accept(expressionSynthesizer);
		if (resultNode != null) {
			Node trueNode = createBooleanLiteralNode(true);
			createPredicateEdge(resultNode, null, trueNode);
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
		Node sourceNode = objectTemplateExp.accept(expressionSynthesizer);
		assert sourceNode != null;
		Node memberNode = members.get(0).accept(expressionSynthesizer);
		assert memberNode != null;
		createNavigationEdge(sourceNode, source2target, memberNode, true);
		return true;
	}

	/**
	 *	Create the trace node assignments to pattern nodes
	 */
	protected void synthesizeTraceEdges(@NonNull Node traceNode, @Nullable Node dispatchNode) {
		Relation relation = getRule();
		if (dispatchNode != null) {
			RelationAnalysis2DispatchClass ruleAnalysis2dispatchClass = getBaseRelationAnalysis().getRuleAnalysis2TraceGroup().getRuleAnalysis2DispatchClass();
			//			RelationAnalysis2TraceClass ruleAnalysis2traceClass = getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceClass();
			Relation baseRelation = getBaseRelationAnalysis().getRule();
			for (@NonNull RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(relation)) {
				Boolean isInput = getScheduleManager().isInput(relationDomain) || !relation.isIsTopLevel();
				for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relationDomain)) {
					VariableDeclaration baseRootVariable = QVTrelationUtil.getOverriddenVariable(baseRelation, rootVariable);
					VariableDeclaration2TraceProperty overriddenVariableDeclaration2traceProperty = ruleAnalysis2dispatchClass.getVariableDeclaration2TraceProperty(baseRootVariable);
					//					VariableDeclaration2TraceProperty overridingVariableDeclaration2traceProperty = ruleAnalysis2traceClass.getVariableDeclaration2TraceProperty(rootVariable);
					Property traceProperty = overriddenVariableDeclaration2traceProperty.getTraceProperty();
					//					VariableDeclaration tracedVariable = overridingVariableDeclaration2traceProperty.getOverridingVariable();
					Node targetNode = region.getNode(rootVariable);
					assert targetNode != null;
					if (isInput) {
						createNavigationEdge(dispatchNode, traceProperty, targetNode, null);
					}
					else {
						createRealizedNavigationEdge(dispatchNode, traceProperty, targetNode, null);
					}
				}
			}
			boolean hasPredicatedTrace = traceNode.isPredicated(); // || traceNode.isSpeculated();
			assert hasPredicatedTrace;
			List<@NonNull ? extends VariableDeclaration> rootVariables = QVTrelationUtil.getRootVariables(relation);
			RelationAnalysis2TraceClass ruleAnalysis2traceClass = getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceClass();
			for (@NonNull VariableDeclaration2TraceProperty variableDeclaration2traceProperty : ruleAnalysis2traceClass.getVariableDeclaration2TraceProperties()) {
				Property traceProperty = variableDeclaration2traceProperty.getTraceProperty();
				VariableDeclaration tracedVariable = variableDeclaration2traceProperty.getOverridingVariable();
				Node targetNode = region.getNode(tracedVariable);
				assert targetNode != null;
				if (!rootVariables.contains(tracedVariable)) {
					createRealizedNavigationEdge(traceNode, traceProperty, targetNode, null);
				}
			}
		}
		else {
			boolean hasPredicatedTrace = traceNode.isPredicated(); // || traceNode.isSpeculated();
			List<@NonNull ? extends VariableDeclaration> rootVariables = QVTrelationUtil.getRootVariables(relation);
			RelationAnalysis2TraceClass ruleAnalysis2traceClass = getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceClass();
			for (@NonNull VariableDeclaration2TraceProperty variableDeclaration2traceProperty : ruleAnalysis2traceClass.getVariableDeclaration2TraceProperties()) {
				Property traceProperty = variableDeclaration2traceProperty.getTraceProperty();
				VariableDeclaration tracedVariable = variableDeclaration2traceProperty.getOverridingVariable();
				Node targetNode = region.getNode(tracedVariable);
				assert targetNode != null;
				if (hasPredicatedTrace && rootVariables.contains(tracedVariable)) {
					createNavigationEdge(traceNode, traceProperty, targetNode, null);
				}
				else {
					createRealizedNavigationEdge(traceNode, traceProperty, targetNode, null);
				}
			}
		}
	}

	/**
	 * Create trace and when/where invocation nodes and their edges.
	 */
	public void synthesizeTraceElements(@NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup) {
		//
		//	Create the dispatch region if needed by an override.
		//
		if (dispatch != null) {
			dispatch.synthesizeElements();
		}
		//
		//	Create the base region if needed by an override.
		//
		if (verdict != null) {
			verdict.synthesizeElements();
		}
		//
		//	Correct type of the trace variable
		//
		Relation relation = getRule();
		if (!relation.isIsAbstract()) {
			RelationAnalysis2TraceClass ruleAnalysis2traceClass = relationAnalysis2traceGroup.getRuleAnalysis2TraceClass();
			VariableDeclaration traceVariable = QVTrelationUtil.getTraceVariable(relation);
			traceVariable.setType(ruleAnalysis2traceClass.getMiddleClass());
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
			synthesizeOverridingGuards(traceNode);
			//
			//	Create the trace status.
			//
			synthesizeTraceGlobalSuccessAssignment(relationAnalysis2traceGroup, traceNode);
			//
			//	Create the interface property and status assignments.
			//
			synthesizeInterfaceAssignments(relationAnalysis2traceGroup, traceNode);
		}
	}

	protected void synthesizeTraceGlobalSuccessAssignment(@NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup, @NonNull Node traceNode) {
		RelationAnalysis2TraceClass relationAnalysis2TraceClass = relationAnalysis2traceGroup.getRuleAnalysis2TraceClass();
		Element2MiddleProperty relation2globalSuccessProperty = relationAnalysis2TraceClass.basicGetRelation2GlobalSuccessProperty();
		if (relation2globalSuccessProperty != null) {
			createRealizedSuccess(traceNode, relation2globalSuccessProperty.getTraceProperty(), null);
		}
	}

	/*	public void synthesizeTraceLocalSuccessAssignment(@NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup, @NonNull Node traceNode) {
		RelationAnalysis2TraceClass relationAnalysis2TraceClass = relationAnalysis2traceGroup.getRuleAnalysis2TraceClass();
		Element2MiddleProperty relation2localSuccessProperty = relationAnalysis2TraceClass.basicGetRelation2LocalSuccessProperty();
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
			traceNode = createOldNode(traceVariable);
		}
		else if (!relation.isIsTopLevel()) {
			//			if (hasOverrides) {
			traceNode = createOldNode(traceVariable);
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
>>>>>>> 5716624 bad wip success checks ***/
		}
		else {
			boolean hasPredicatedTrace = (incomingWhereInvocationAnalyses != null) && !hasOverrides;
			traceNode = hasPredicatedTrace ? createOldNode(traceVariable) : createRealizedStepNode(traceVariable);
			if (!getRule().isIsTopLevel()) {
				region.getHeadNodes().clear();
				//			region.getHeadNodes().add(traceNode);
			}
		}
		traceNode.setUtility(Utility.TRACE);
		return traceNode;
	}

	public void synthesizeVariableDeclaration(@NonNull VariableDeclaration variableDeclaration) {	// FIXME move to derived visitVariableDeclaration
		//		boolean isEnforced = false;
		//		ClassDatum classDatum = scheduleManager.getClassDatum(variableDeclaration);
		//		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(classDatum);
		//		Map<@NonNull TemplateVariable, @NonNull TemplateExp> variable2templateExp2 = variable2templateExp;
		//		assert variable2templateExp2 != null;
		TemplateExp templateExp = basicGetTemplateExp(variableDeclaration);
		if ((variableDeclaration instanceof Variable) && ((Variable)variableDeclaration).isIsImplicit() && (templateExp == null)) {
			return; // implicit CollectionTemplateExp rest nodes are not needed
		}
		else if (QVTrelationUtil.isTraceClassVariable(variableDeclaration)) {
			return; // traceNode created by synthesizeTraceNodes
		}
		else if (getKeyedOutputVariables().contains(variableDeclaration)) {
			boolean isUnconditional = true;
			createKeyedNode(isUnconditional, QVTrelationUtil.getName(variableDeclaration), variableDeclaration);
			return; // keyed object created by synthesizeKeyedObject
		}
		else if (getWhenedOutputVariables().contains(variableDeclaration)) {
			createOldNode(variableDeclaration);		// when output is created by the invoked when
		}
		else if (hasIncomingWhereInvocationAnalyses() && Iterables.contains(QVTrelationUtil.getRootVariables(getRule()), variableDeclaration)) {
			createOldNode(variableDeclaration);		// where 'output' is created by invoker
		}
		else if (getRealizedOutputVariables().contains(variableDeclaration)) {
			createRealizedStepNode(variableDeclaration);
		}
		else {
			if (variableDeclaration instanceof TemplateVariable) {
				assert templateExp != null;
				if (templateExp instanceof CollectionTemplateExp) {
					//					if (scheduleManager.getDomainUsage(templateExp).isOutput()) {
					return; 	// CollectionTemplateExp variables would be bloat
					//					}
				}
				createOldNode(variableDeclaration);
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
				createOldNode(variableDeclaration);		// Never happens
			}
		}
	}
}