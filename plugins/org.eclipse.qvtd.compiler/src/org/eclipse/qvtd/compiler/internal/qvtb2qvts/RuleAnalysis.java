/*******************************************************************************
 * Copyright (c) 2015, 2018 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.RuleAnalysis2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.TransformationAnalysis2TracePackage;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A RuleAnalysis provides the analysis a QVTb rule.
 */
public abstract class RuleAnalysis extends RegionHelper<@NonNull RuleRegion>
{
	protected final @NonNull TransformationAnalysis transformationAnalysis;
	protected final @NonNull Rule rule;
	protected final @NonNull ExpressionSynthesizer expressionSynthesizer;

	private @Nullable RuleAnalysis2TraceGroup relationAnalysis2traceGroup = null;

	/**
	 * The dependency heads to accommodate operation content.
	 */
	private /*@LazyNonNull*/ List<@NonNull Node> dependencyHeadNodes = null;

	protected RuleAnalysis(@NonNull TransformationAnalysis transformationAnalysis, @NonNull RuleRegion ruleRegion) {
		super(transformationAnalysis.getScheduleManager(), ruleRegion);
		this.rule = QVTscheduleUtil.getReferredRule(ruleRegion);
		this.transformationAnalysis = transformationAnalysis;
		this.expressionSynthesizer = scheduleManager.createExpressionSynthesizer(this);
		//		assert !rule.isIsAbstract() == scheduleManager.getScheduleModel().getOwnedMappingRegions().contains(ruleRegion);
	}

	public abstract void analyzeMappingRegion();

	public void analyzeSourceModel() {}

	public @NonNull Node createDependencyHead(@NonNull ClassDatum classDatum) {
		if (dependencyHeadNodes == null) {
			dependencyHeadNodes = new ArrayList<>();
		}
		Node dependencyHeadNode = createDependencyNode("«extra-" + (dependencyHeadNodes.size()+1) + "»", classDatum);
		dependencyHeadNode.setHead();
		dependencyHeadNodes.add(dependencyHeadNode);
		return dependencyHeadNode;
	}

	public void gatherRuleRegions(@NonNull List<@NonNull RuleRegion> ruleRegions) {
		ruleRegions.add(getRegion());
	}

	public @Nullable Node getDependencyHead(@NonNull ClassDatum classDatum) {
		if (dependencyHeadNodes != null) {
			for (@NonNull Node dependencyHeadNode : dependencyHeadNodes) {
				if (QVTscheduleUtil.getClassDatum(dependencyHeadNode) == classDatum) {
					return dependencyHeadNode;
				}
			}
		}
		return null;
	}

	public @NonNull NameGenerator getNameGenerator() {
		return scheduleManager.getNameGenerator();
	}

	public abstract @NonNull Node getReferenceNode(@NonNull VariableDeclaration variableDeclaration);

	public @NonNull Rule getRule() {
		return rule;
	}

	public @NonNull RuleAnalysis2TraceGroup getRuleAnalysis2TraceGroup() {
		RuleAnalysis2TraceGroup relationAnalysis2traceGroup2 = relationAnalysis2traceGroup;
		if (relationAnalysis2traceGroup2 == null) {
			relationAnalysis2traceGroup = relationAnalysis2traceGroup2 = getTransformationAnalysis2TracePackage().getRuleAnalysis2TraceGroup(rule);
		}
		return relationAnalysis2traceGroup2;
	}

	public @NonNull TransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}

	public @NonNull TransformationAnalysis2TracePackage getTransformationAnalysis2TracePackage() {
		return transformationAnalysis.getTransformationAnalysis2TracePackage();
	}

	public @NonNull Node getUnknownNode(@NonNull TypedElement typedElement) {
		assert !(typedElement instanceof Property);		// Property entries should be AttributeNodes
		Node node = region.getNode(typedElement);
		if (node == null) {
			node = createUnknownNode(ClassUtil.nonNullState(typedElement.getType().toString()), typedElement);
			//			node2node.put(typedElement, node);
		}
		return node;
	}

	/**
	 * Return true if the navigation from sourceNode using source2targetProperty corresponds to a PropertyAssigmment,
	 */
	public abstract boolean isPropertyAssignment(@NonNull Node sourceNode, @NonNull Property source2targetProperty);

	@Override
	public @NonNull String toString() {
		return getName();
	}
}