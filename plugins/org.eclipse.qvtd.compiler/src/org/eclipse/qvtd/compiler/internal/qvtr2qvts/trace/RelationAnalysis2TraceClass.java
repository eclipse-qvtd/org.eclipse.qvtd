/*******************************************************************************
 * Copyright (c) 2017, 2019 Willink Transformations and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *     E.D.Willink - initial API and implementation (inspired by Horacio Hoyos' prototype)
 ******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.CompilerChainException;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.HeadNodeGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Element2MiddleProperty;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.InvocationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.QVTrelationNameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

/**
 * A RelationAnalysis2TraceClass supervises the creation of a trace class for a relation, which may be abstract.
 *
 * If the relation participates in an override hierarchy, the trace class specifies the trace intrerface
 * of the base relation as its direct superclass regardless of the complexity of the override hierarchy.
 *
 * The trace class provides a trace property for all traceable properties, including those inherited from
 * the root relation trace interface. This ensures that each of the concrete trace class is navigable via their
 * concrete trace property, while the successful execution is navigabel via the trace interface.
 *
 * The trace class for a relation within an override hierarchy provides a status property to facilitate mediation
 * of the overriding relation executions.
 *
 * The trace class of a relation whose successful execution is monitored by a when predicate also provides
 * a success property.
 */
public class RelationAnalysis2TraceClass extends AbstractRelationAnalysis2MiddleType
{
	private @Nullable Map<@NonNull InvocationAnalysis, @NonNull Invocation2TraceProperty> invocationAnalysis2relation2traceProperty = null;

	/**
	 * Name to corresponding future trace property
	 */
	private final @NonNull Map<@NonNull String, /*@NonNull*/ Element2MiddleProperty> name2element2traceProperty = new HashMap<>();

	public RelationAnalysis2TraceClass(@NonNull RelationAnalysis2TraceGroup relationAnalysis2traceGroup, @NonNull String middleClassName) {
		super(relationAnalysis2traceGroup, middleClassName);
		//		traceClass.setIsAbstract(relation.isIsAbstract());
		//		if (relation.isIsAbstract()) {
		//		middleClass.getOwningPackage().getOwnedClasses().remove(middleClass);
		//		}
	}

	/*	@Override
	public void analyzeInheritance() {
				Relation overriddenRelation = QVTrelationUtil.basicGetOverrides(relation);
				if (overriddenRelation != null) {
					Relation2TraceClass.@NonNull Internal overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation);
					traceClass.getSuperClasses().add(overriddenRelation2TraceClass.getTraceInterface());
				}
	} */

	/*	protected void analyzeNonRootTemplateVariables(boolean manyTraces) {
		//
		//	Traverse the domain patterns to prepare a trace property for each bound variable.
		//
		// FIXME to handle the obscure case of a diamond traversal in which the second path discovers that
		//  unitOpposites apply, we should preferentially descend unit paths, deferring non-unit paths til later.
		//
		/*		for (@NonNull Domain domain : QVTbaseUtil.getOwnedDomains(rule)) {
			for (@NonNull DomainPattern rDomainPattern : QVTbaseUtil.getOwnedPatterns(domain)) {
				TemplateExp rTemplateExp = QVTrelationUtil.getOwnedTemplateExpression(rDomainPattern);
				TypedModel rTypedModel = QVTbaseUtil.getTypedModel(domain);
				analyzeTemplateVariables(rTemplateExp, rTypedModel, !manyTraces);
			}
		} * /
	} */

	/**
	 * Traverse a Pattern hierarchy to prepare/refine a trace property for each invocation argument variable.
	 *
	private void analyzePredicateVariables(@NonNull Pattern rPattern, boolean isWhen) {
		for (@NonNull Predicate rPredicate : QVTrelationUtil.getOwnedPredicates(rPattern)) {
			OCLExpression rConditionExpression = QVTrelationUtil.getConditionExpression(rPredicate);
			if (rConditionExpression instanceof RelationCallExp) {
				RelationCallExp rInvocation = (RelationCallExp)rConditionExpression;
				Relation invokedRelation = QVTrelationUtil.getReferredRelation(rInvocation);
				if (!invokedRelation.isIsTopLevel()) {
					String invocationPropertyName = isWhen ? nameGenerator.createWhenInvocationPropertyName(invokedRelation) : nameGenerator.createWhereInvocationPropertyName(invokedRelation);
					//					getInvocation2TraceProperty(invocationPropertyName, rInvocation);
				}
				else {
					List<@NonNull OCLExpression> rArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(rInvocation);
					for (int i = 0; i < rArguments.size(); i++) {
						OCLExpression rArgument = rArguments.get(i);
						if (rArgument instanceof VariableExp) {
							VariableDeclaration rVariable = QVTrelationUtil.getReferredVariable((VariableExp)rArgument);
							RelationDomain rDomain = QVTrelationUtil.getRelationCallExpArgumentDomain(rInvocation, i);
							getVariableDeclaration2TraceProperty(rDomain.getTypedModel(), rVariable, false);
						}
					}
				}
			}
		}
	} */

	protected void analyzePatternNodes(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups) {
		//	String name = relation.getName();
		boolean manyTracesPerHead = headNodeGroups.size() > 2;
		Set<@NonNull Node> allHeadGroupNodes = new HashSet<>();
		for (@NonNull HeadNodeGroup headNodeGroup : headNodeGroups) {
			Iterables.addAll(allHeadGroupNodes, headNodeGroup.getHeadNodes());
		}
		List<@NonNull Variable> rootVariables = QVTrelationUtil.getRootVariables(relation);
		for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(relationAnalysis.getRegion())) {
			if (node.isPattern() && node.isMatched()) {
				createVariableDeclaration2TraceProperty(node, rootVariables, allHeadGroupNodes, manyTracesPerHead);
			}
		}
		//
		//	Create a trace for all predicated ends of realized edges to ensure that no rediscovery
		//	of predicates is needed after a region is partitioned.
		//
		for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(relationAnalysis.getRegion())) {
			if (edge.isRealized()) {
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				Node targetNode = QVTscheduleUtil.getTargetNode(edge);
				if (sourceNode.isPredicated()) {
					createVariableDeclaration2TraceProperty(sourceNode, rootVariables, allHeadGroupNodes, manyTracesPerHead);
				}
				if (targetNode.isPredicated()) {
					createVariableDeclaration2TraceProperty(targetNode, rootVariables, allHeadGroupNodes, manyTracesPerHead);
				}
			}
		}
		//
		//	Implicit/iterator variables do not have unit trace opposites.
		//
		/*		for (@NonNull Variable rVariable : QVTrelationUtil.getOwnedVariables(rule)) {
			if (!(rVariable instanceof IteratorVariable) && !(rVariable instanceof TemplateVariable) && !rVariable.isIsImplicit()) {
				assert rVariable instanceof SharedVariable;
				getVariableDeclaration2TraceProperty(null, rVariable, false);
			}
		} */
	}

	/*	@Override
		public void analyzeInheritance() {
					Relation overriddenRelation = QVTrelationUtil.basicGetOverrides(relation);
					if (overriddenRelation != null) {
						Relation2TraceClass.@NonNull Internal overriddenRelation2TraceClass = relationalTransformation2tracePackage.getRelation2TraceClass(overriddenRelation);
						traceClass.getSuperClasses().add(overriddenRelation2TraceClass.getTraceInterface());
					}
		} */

	@Override
	public void analyzeTraceElements(@NonNull List<@NonNull HeadNodeGroup> headNodeGroups) throws CompilerChainException {
		//
		// If there is a trace interface, then it is the superclass, otherwise the Execution class.
		//
		RelationAnalysis2TraceGroup baseRelationAnalysis2TraceGroup = relationAnalysis2traceGroup.getBaseRelationAnalysis2TraceGroup();
		RelationAnalysis2TraceInterface baseRelationAnalysis2traceInterface = baseRelationAnalysis2TraceGroup.basicGetRuleAnalysis2TraceInterface();
		if (baseRelationAnalysis2traceInterface != null) {
			middleClass.getSuperClasses().add(baseRelationAnalysis2traceInterface.getMiddleClass());
		}
		else {
			middleClass.getSuperClasses().add(getTransformation2TracePackage().getExecutionClass());
		}
		//
		// If there is a trace interface or a when invocation then there is a trace class success.
		//
		//		if ((baseRelationAnalysis2traceInterface != null) || getRuleAnalysis().hasIncomingWhenInvocationAnalyses()) {
		//			createRelation2StatusProperty(relationAnalysis2traceGroup.getNameGenerator().createInternalTraceStatusPropertyName());
		//		}
		//
		//	No result property.
		//
		//
		//	Create an incoming invocation property for each where invocation.
		//
		Iterable<@NonNull InvocationAnalysis> outgoingWhereInvocationAnalyses = getRuleAnalysis().basicGetOutgoingWhereInvocationAnalyses();
		if (outgoingWhereInvocationAnalyses != null) {
			for (@NonNull InvocationAnalysis outgoingWhereInvocationAnalysis : outgoingWhereInvocationAnalyses) {
				createInvocation2TraceProperty(outgoingWhereInvocationAnalysis);
			}
		}
		//
		//	Create an outgoing invocation property for each when invocation.
		//
		if (relation.isIsTopLevel()) {
			Iterable<@NonNull InvocationAnalysis> outgoingWhenInvocationAnalyses = getRuleAnalysis().basicGetOutgoingWhenInvocationAnalyses();
			if (outgoingWhenInvocationAnalyses != null) {
				for (@NonNull InvocationAnalysis outgoingWhenInvocationAnalysis : outgoingWhenInvocationAnalyses) {
					createInvocation2TraceProperty(outgoingWhenInvocationAnalysis);
				}
			}
		}
		//
		//	Create one trace property per root variable.
		//
		if (!QVTrelationUtil.hasOverrides(relation)) {
			analyzeRootTemplateVariables(headNodeGroups);
		}
		//
		//	??
		//
		//		if (relationAnalysis2traceGroup.basicGetRuleAnalysis2TraceInterface() == null) {
		//		}
		//		else {
		//			installRootVariableTraceProperties();
		//		}

		//		boolean manyTraces = analyzeTraceMultiplicity(headNode2headGroupNodes);
		//		for (@NonNull VariableDeclaration rootVariable : QVTrelationUtil.getRootVariables(relation)) {
		//			Node rootNode = relationAnalysis.getRegion().getNode(rootVariable);
		//			assert rootNode != null;
		//			allHeadGroupNodes.remove(rootNode);
		//		}
		analyzePatternNodes(headNodeGroups);
		//		analyzeSharedVariables();
		//		analyzeNonRootTemplateVariables(manyTraces);
		//		analyzeInvocationVariables();
		//
		// If there is a trace interface or a when invocation then there is a trace class global success.
		//
		analyzeGlobalSuccessNode(baseRelationAnalysis2traceInterface);
	}

	//
	// If there is a trace interface or a when invocation then there is a trace class global success.
	//
	protected void analyzeGlobalSuccessNode(@Nullable RelationAnalysis2TraceInterface baseRelationAnalysis2traceInterface) {
		boolean hasTraceInterface = baseRelationAnalysis2traceInterface != null;
		boolean hasWhenInvocation = getRuleAnalysis().hasIncomingWhenInvocationAnalyses();
		if (hasTraceInterface) {		// FIXME Bug 540797 - this is used by e.g. mapBooleanExp in ATL2QVTr
			return;
		}
		if (!hasWhenInvocation) {		// FIXME enforced guard needs globalSucess
			return;
		}
		if (!QVTrelationUtil.hasOverrides(relation)) {
			boolean hasPredicatedElement = false;
			RuleRegion region = getRuleAnalysis().getRegion();
			for (@NonNull Node node : QVTscheduleUtil.getOwnedNodes(region)) {
				if (node.isPredicated()) {
					hasPredicatedElement = true;
					break;
				}
			}
			if (!hasPredicatedElement) {
				for (@NonNull Edge edge : QVTscheduleUtil.getOwnedEdges(region)) {
					if (edge.isPredicated()) {
						hasPredicatedElement = true;
						break;
					}
				}
			}
			if (!hasPredicatedElement) {
				return;			// extStat is identical to trace class existence
			}
		}
		QVTrelationNameGenerator nameGenerator = relationAnalysis2traceGroup.getNameGenerator();
		String globalSuccessPropertyName = nameGenerator.createTraceGlobalSuccessPropertyName();
		createRelation2GlobalSuccessProperty(globalSuccessPropertyName);
	}

	/*	@Override
	public @Nullable RelationAnalysis2MiddleType getSuperRuleAnalysis2MiddleType() {
		RelationAnalysis2TraceInterface ruleAnalysis2TraceInterface = relationAnalysis2traceGroup.basicGetRuleAnalysis2TraceInterface();
		if (ruleAnalysis2TraceInterface != null) {
			return ruleAnalysis2TraceInterface;
		}
		else {
			Rule overriddenRule = getRule().getOverridden();
			if (overriddenRule != null) {
				return transformationAnalysis2tracePackage.getRuleAnalysis2TraceGroup(overriddenRule).getRuleAnalysis2TraceClass();
			}
			else {
				return null;
			}
		}
	} */

	@Override
	public @Nullable Element2MiddleProperty basicGetRelation2GlobalSuccessProperty() {
		Element2MiddleProperty relation2SuccessProperty = super.basicGetRelation2GlobalSuccessProperty();
		if (relation2SuccessProperty != null) {
			return relation2SuccessProperty;
		}
		RelationAnalysis2TraceGroup baseRelationAnalysis2TraceGroup = relationAnalysis2traceGroup.getBaseRelationAnalysis2TraceGroup();
		RelationAnalysis2TraceInterface baseRelationAnalysis2traceInterface = baseRelationAnalysis2TraceGroup.basicGetRuleAnalysis2TraceInterface();
		if (baseRelationAnalysis2traceInterface != null) {
			return baseRelationAnalysis2traceInterface.basicGetRelation2GlobalSuccessProperty();
		}
		return null;
	}

	/**
	 * Descend the templateExp hierarchy to prepare a trace property for each bound variable.
	 *
	private void analyzeTemplateVariables(@NonNull TemplateExp templateExp, @NonNull TypedModel rTypedModel, boolean isOneToOne) {
		Variable templateVariable = QVTrelationUtil.getBindsTo(templateExp);
		VariableDeclaration2TraceProperty variableDeclaration2TraceProperty = basicGetVariableDeclaration2TraceProperty(templateVariable);
		if (variableDeclaration2TraceProperty != null) {
			if (templateExp instanceof ObjectTemplateExp) {
				for (@NonNull PropertyTemplateItem rPropertyTemplateItem : QVTrelationUtil.getOwnedParts((ObjectTemplateExp)templateExp)) {
					boolean isNestedOneToOne = false;
					Property property = QVTrelationUtil.getReferredProperty(rPropertyTemplateItem);
					if (!property.isIsMany()) {
						Property oppositeProperty = property.getOpposite();
						if ((oppositeProperty != null) && !oppositeProperty.isIsMany()) {
							isNestedOneToOne = isOneToOne;
						}
					}
					OCLExpression valueExpression = QVTrelationUtil.getOwnedValue(rPropertyTemplateItem);
					if (valueExpression instanceof TemplateExp) {
						TemplateExp templateValueExpression = (TemplateExp)valueExpression;
						Variable itemVariable = QVTrelationUtil.getBindsTo(templateValueExpression);
						if (QVTrelationUtil.getElementalType(QVTrelationUtil.getType(itemVariable)) instanceof DataType) {
							getVariableDeclaration2TraceProperty(null, itemVariable, false);
						}
						else {
							assert itemVariable instanceof TemplateVariable;
							getVariableDeclaration2TraceProperty(rTypedModel, itemVariable, isNestedOneToOne);
							analyzeTemplateVariables(templateValueExpression, rTypedModel, isOneToOne);
						}
					}
					else if (valueExpression instanceof VariableExp) {
						VariableExp variableExpression = (VariableExp)valueExpression;
						Variable itemVariable = QVTrelationUtil.getReferredVariable(variableExpression);
						getVariableDeclaration2TraceProperty(null, itemVariable, isNestedOneToOne);
					}
				}
			}
			else if (templateExp instanceof CollectionTemplateExp) {
				for (@NonNull OCLExpression memberExpression : QVTrelationUtil.getOwnedMembers((CollectionTemplateExp)templateExp)) {
					if (memberExpression instanceof TemplateExp) {
						TemplateExp templateValueExpression = (TemplateExp)memberExpression;
						Variable itemVariable = QVTrelationUtil.getBindsTo(templateValueExpression);
						assert itemVariable instanceof TemplateVariable;
						getVariableDeclaration2TraceProperty(rTypedModel, itemVariable, false);
						analyzeTemplateVariables(templateValueExpression, rTypedModel, false);
					}
					else if (memberExpression instanceof VariableExp) {
						VariableExp variableExpression = (VariableExp)memberExpression;
						Variable itemVariable = QVTrelationUtil.getReferredVariable(variableExpression);
						getVariableDeclaration2TraceProperty(null, itemVariable, false);
					}
				}
			}
		}
	} */

	//
	//	Determine the trace variables and whether they have a to-one opposite
	//
	/*	protected boolean analyzeTraceMultiplicity(@NonNull Map<@NonNull Node, @NonNull Set<@NonNull Node>> headNode2headGroupNodes) {
		//
		//	Determine whether a navigation from the trace to an unambiguous left/right object can ever be possible.
		//
		/*		boolean manyTraces = hasManyRootMatches() || hasCollectionMemberMatches() || hasMultiObjectMatches();
		if (!manyTraces) {
			for (@NonNull Variable rVariable : QVTbaseUtil.getOwnedVariables(rule)) {
				if (hasManyVariableMatches(rVariable)) {
					manyTraces = true;
					break;
				}
			}
		}
		return manyTraces; * /
		int maxHeadCount = 0;
		Map<@NonNull TypedModel, @NonNull Integer> typedModel2headCount = new HashMap<>();
		for (@NonNull Node headNode : headNode2headGroupNodes.keySet()) {
			assert headNode.isPattern();
			TypedModel typedModel = QVTscheduleUtil.getTypedModel(headNode);
			Integer headCount = typedModel2headCount.get(typedModel);
			headCount = headCount != null ? headCount+1 : 1;
			typedModel2headCount.put(typedModel, headCount);
			if (headCount > maxHeadCount) {
				maxHeadCount = headCount;
			}
		}
		assert maxHeadCount > 0;
		return maxHeadCount > 1;
	} */

	public @NonNull Invocation2TraceProperty createInvocation2TraceProperty(@NonNull InvocationAnalysis invocationAnalysis) {
		Map<@NonNull InvocationAnalysis, @NonNull Invocation2TraceProperty> invocationAnalysis2relation2traceProperty2 = invocationAnalysis2relation2traceProperty;
		if (invocationAnalysis2relation2traceProperty2 == null) {
			invocationAnalysis2relation2traceProperty = invocationAnalysis2relation2traceProperty2 = new HashMap<>();
		}
		RelationAnalysis invokedRelationAnalysis = invocationAnalysis.getInvokedRelationAnalysis().getBaseRelationAnalysis();
		RelationAnalysis2TraceGroup invokedRule2TraceGroup = invokedRelationAnalysis.getRuleAnalysis2TraceGroup();
		String nameHint = relationAnalysis2traceGroup.getNameGenerator().createInvocationTraceProperty(invokedRelationAnalysis.getRule());
		Invocation2TraceProperty relation2traceProperty = new Invocation2TraceProperty(this, nameHint, invokedRule2TraceGroup.getInvocationClass(), invocationAnalysis.isWhen() && !invocationAnalysis.isTop());
		Invocation2TraceProperty oldRelation2traceProperty = invocationAnalysis2relation2traceProperty2.put(invocationAnalysis, relation2traceProperty);
		assert oldRelation2traceProperty == null;
		return relation2traceProperty;
	}

	public @NonNull Property createProperty(@NonNull String name, @NonNull Type type) {
		String uniqueName = QVTrelationNameGenerator.getUniqueName(name2element2traceProperty.keySet(), name);
		Property property = PivotUtil.createProperty(uniqueName, type);
		//FIXME		name2element2traceProperty.put(uniqueName, property);
		return property;
	}

	@Override
	protected @NonNull String createTracePropertyName(@NonNull TypedModel typedModel, @NonNull VariableDeclaration variable) {
		return getTransformation2TracePackage().getNameGenerator().createTraceClassPropertyName(typedModel, variable);
	}

	protected void createVariableDeclaration2TraceProperty(@NonNull Node node, @NonNull List<@NonNull Variable> rootVariables,
			@NonNull Set<@NonNull Node> allHeadGroupNodes, boolean manyTracesPerHead) {
		boolean unitOpposite = allHeadGroupNodes.contains(node) && !manyTracesPerHead;
		TypedModel typedModel = QVTscheduleUtil.getTypedModel(node);
		VariableDeclaration variable = node.basicGetOriginatingVariable();
		if ((variable != null) && !rootVariables.contains(variable)) {
			VariableDeclaration2TraceProperty variableDeclaration2traceProperty = basicGetVariableDeclaration2TraceProperty(variable);
			if (variableDeclaration2traceProperty == null) {
				createVariableDeclaration2TraceProperty(typedModel, variable, unitOpposite);
			}
		}
	}

	public @NonNull Invocation2TraceProperty getInvocation2TraceProperty(@NonNull InvocationAnalysis invocationAnalysis) {
		return ClassUtil.nonNullState(ClassUtil.nonNullState(invocationAnalysis2relation2traceProperty).get(invocationAnalysis));
	}

	/*	@Override
	public @Nullable RelationAnalysis2MiddleType getSuperRuleAnalysis2MiddleType() {
		RelationAnalysis2TraceInterface ruleAnalysis2TraceInterface = relationAnalysis2traceGroup.basicGetRuleAnalysis2TraceInterface();
		if (ruleAnalysis2TraceInterface != null) {
			return ruleAnalysis2TraceInterface;
		}
		else {
			Rule overriddenRule = getRule().getOverridden();
			if (overriddenRule != null) {
				return transformationAnalysis2tracePackage.getRuleAnalysis2TraceGroup(overriddenRule).getRuleAnalysis2TraceClass();
			}
			else {
				return null;
			}
		}
	} */

	@Override
	public @NonNull String getUniquePropertyName(@NonNull Element2MiddleProperty element2traceProperty, @NonNull String name) {
		return QVTrelationNameGenerator.getUniqueName(name2element2traceProperty, name, element2traceProperty);
	}

	/*	private boolean hasCollectionMemberMatches() {
		for (EObject eObject : new TreeIterable(relation, true)) {
			if (eObject instanceof CollectionTemplateExp) {
				List<OCLExpression> members = ((CollectionTemplateExp)eObject).getMember();
				if (members.size() > 0) {
					return true;
				}
			}
		}
		return false;
	} */

	/**
	 * Return true if there may be more than one trace instance for a given root variable.
	 *
	private boolean hasManyRootMatches() {
		//
		//	Only a single root variable in each of just two domains gurantees just one trace per root variable.
		//
		List<@NonNull Domain> rDomains = QVTrelationUtil.Internal.getOwnedDomainsList(rule);
		if (rDomains.size() > 2) {
			return true;
		}
		else {
			for (@NonNull Domain rDomain : rDomains) {
				List<Variable> rootVariables = ((RelationDomain)rDomain).getRootVariable();
				if (rootVariables.size() > 1) {
					return true;
				}
			}
		}
		return false;
	} */

	/*	private boolean hasManyVariableMatches(@NonNull Variable rVariable) {
		for (@NonNull Domain rDomain : QVTrelationUtil.getOwnedDomains(relation)) {
			Iterable<@NonNull Variable> bindsTo = QVTr2QVTcUtil.getRelationDomainBindsTo((RelationDomain) rDomain);
			if (Iterables.contains(bindsTo, rVariable)) {
				return false;
			}
		}
		for (@NonNull EObject eObject : new TreeIterable(relation, true)) {
			if (eObject instanceof VariableExp) {
				VariableDeclaration referredVariable = ((VariableExp)eObject).getReferredVariable();
				if (referredVariable == rVariable) {
					EObject eContainer = eObject.eContainer();
					if (eContainer instanceof OperationCallExp) {
						OperationCallExp operationCallExp = (OperationCallExp)eContainer;
						Operation referredOperation = operationCallExp.getReferredOperation();
						assert referredOperation != null;
						if (operationCallExp.getOwnedArguments().equals(Collections.singletonList(eObject)) && "includes".equals(referredOperation.getName())) {		// FIXME stronger test
							return true;
						}
					}
					// FIXME more cases
				}
			}
		}
		return false;
	} */

	/*	private boolean hasMultiObjectMatches() {
		for (RelationDomain relationDomain : QVTrelationUtil.getOwnedDomains(rule)) {
			if (!relationDomain.isIsEnforceable()) {
				for (EObject eObject : new TreeIterable(relationDomain, true)) {
					if (eObject instanceof PropertyTemplateItem) {
						Property referredProperty = QVTrelationUtil.getReferredProperty((PropertyTemplateItem)eObject);
						if (referredProperty.isIsMany()) {
							return true;
						}
					}
				}
			}
		}
		return false;
	} */

	protected void reservePropertyName(@NonNull String name) {
		assert !name2element2traceProperty.containsKey(name);
		name2element2traceProperty.put(name, null);
	}

	@Override
	public void synthesizeTraceModel() {
		Map<@NonNull InvocationAnalysis, @NonNull Invocation2TraceProperty> incomingInvocationAnalysis2relation2traceProperty2 = invocationAnalysis2relation2traceProperty;
		if (incomingInvocationAnalysis2relation2traceProperty2 != null) {
			for (@NonNull Invocation2TraceProperty relation2traceProperty : incomingInvocationAnalysis2relation2traceProperty2.values()) {
				relation2traceProperty.synthesizeTraceModel();
			}
		}
		super.synthesizeTraceModel();
	}
}