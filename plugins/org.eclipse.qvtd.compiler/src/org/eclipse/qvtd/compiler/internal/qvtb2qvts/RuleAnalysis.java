/*******************************************************************************
 * Copyright (c) 2015, 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.compiler.ProblemHandler;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Rule2TraceGroup;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.trace.Transformation2TracePackage;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.InvocationAnalysis;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Rule;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtschedule.CastEdge;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Lists;

/**
 * A RuleAnalysis provides the analysis a QVTb rule.
 */
public abstract class RuleAnalysis extends RegionHelper<@NonNull RuleRegion>
{
	protected static final class DeepestFirstCompleteClassInheritanceComparator implements Comparator<@NonNull CompleteClass>
	{
		public static final @NonNull DeepestFirstCompleteClassInheritanceComparator INSTANCE = new DeepestFirstCompleteClassInheritanceComparator();

		@Override
		public int compare(@NonNull CompleteClass o1, @NonNull CompleteClass o2) {
			int d1 = o1.getCompleteInheritance().getDepth();
			int d2 = o2.getCompleteInheritance().getDepth();
			if (d1 != d2) {
				return d2 - d1;		// Largest first
			}
			return o1.getName().compareTo(o2.getName());
		}
	}

	protected final @NonNull AbstractTransformationAnalysis transformationAnalysis;
	protected final @NonNull Rule rule;
	protected final @NonNull ExpressionSynthesizer unconditionalExpressionSynthesizer;

	private @Nullable Rule2TraceGroup relation2traceGroup = null;

	/**
	 * The dependency heads to accommodate operation content.
	 */
	private /*@LazyNonNull*/ List<@NonNull Node> dependencyHeadNodes = null;

	protected RuleAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull RuleRegion ruleRegion) {
		super(transformationAnalysis.getScheduleManager(), ruleRegion);
		this.rule = QVTscheduleUtil.getReferredRule(ruleRegion);
		this.transformationAnalysis = transformationAnalysis;
		this.unconditionalExpressionSynthesizer = scheduleManager.createUnconditionalExpressionSynthesizer(this);
		//		assert !rule.isIsAbstract() == scheduleManager.getScheduleModel().getOwnedMappingRegions().contains(ruleRegion);
	}

	public void analyzeInvocations(@NonNull ProblemHandler problemHandler) {}

	public abstract void analyzeMappingRegion();

	public void analyzeOverrides(@NonNull ProblemHandler problemHandler) {}

	public void analyzeSourceModel(@NonNull ProblemHandler problemHandler) {}

	public @NonNull Node createDependencyHead(@NonNull ClassDatum classDatum) {
		if (dependencyHeadNodes == null) {
			dependencyHeadNodes = new ArrayList<>();
		}
		Node dependencyHeadNode = createDependencyNode("«extra-" + (dependencyHeadNodes.size()+1) + "»", classDatum);
		dependencyHeadNode.setHead();
		dependencyHeadNodes.add(dependencyHeadNode);
		return dependencyHeadNode;
	}

	public @Nullable Rule2TraceGroup basicGetRule2TraceGroup() {
		return relation2traceGroup;
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

	public @NonNull InvocationAnalysis getInvocationAnalysis(@NonNull Node invokingNode) {
		throw new IllegalStateException();
	}

	public @NonNull NameGenerator getNameGenerator() {
		return scheduleManager.getNameGenerator();
	}

	public abstract @NonNull Node getReferenceNode(@NonNull VariableDeclaration variableDeclaration);

	public @NonNull Rule getRule() {
		return rule;
	}

	public @NonNull Rule2TraceGroup getRule2TraceGroup() {
		Rule2TraceGroup relation2traceGroup2 = relation2traceGroup;
		if (relation2traceGroup2 == null) {
			relation2traceGroup = relation2traceGroup2 = getTransformation2TracePackage().getRule2TraceGroup(rule);
		}
		return relation2traceGroup2;
	}

	public @NonNull AbstractTransformationAnalysis getTransformationAnalysis() {
		return transformationAnalysis;
	}

	public @NonNull Transformation2TracePackage getTransformation2TracePackage() {
		return transformationAnalysis.getTransformation2TracePackage();
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

	/**
	 * Eliminate all CastEdges. Those whose source is used only after casting are merged by accumulating the CastEdge target
	 * to its source may evolve to a multi-CompleteClass ClassDatum. Those whose source must be retained in uncast form for
	 * an expression are changed to an oclAsType call.
	 */
	protected void rewriteCastEdges() {
		for (@NonNull Edge edge : Lists.newArrayList(QVTscheduleUtil.getOwnedEdges(region))) {
			if (edge instanceof CastEdge) {
				//
				//	Cast merging is possible if the cast source is not used in uncast form in an expression or if the
				//	cast target is part of the overall match and so necessarily true.
				//
				boolean allMatched = false;				// True if all outgoing edges of sourceNode are matched.
				Node sourceNode = QVTscheduleUtil.getSourceNode(edge);
				if (sourceNode.isMatched()) {
					allMatched = true;
					for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(sourceNode)) {
						Node targetNode = QVTscheduleUtil.getTargetNode(outgoingEdge);
						if (!targetNode.isMatched()) {
							allMatched = false;
							break;
						}
					}
				}
				//
				//	Compute the merged multi-CompleteClass or null if not mergeable.
				//
				ClassDatum sourceClassDatum = QVTscheduleUtil.getClassDatum(sourceNode);
				Set<@NonNull CompleteClass> allCompleteClasses = new HashSet<>(QVTscheduleUtil.getCompleteClasses(sourceClassDatum));
				for (@NonNull Edge outgoingEdge : QVTscheduleUtil.getOutgoingEdges(sourceNode)) {
					if (outgoingEdge instanceof CastEdge) {
						Node targetNode = QVTscheduleUtil.getTargetNode(outgoingEdge);
						ClassDatum targetClassDatum = QVTscheduleUtil.getClassDatum(targetNode);
						List<@NonNull CompleteClass> targetCompleteClasses = QVTscheduleUtil.getCompleteClasses(targetClassDatum);
						allCompleteClasses.addAll(targetCompleteClasses);
					}
					else if (!allMatched) {
						allCompleteClasses = null;
						break;
					}
				}
				if (allCompleteClasses != null) {
					rewriteCastEdgeAsMergedMultiCompleteClass(sourceNode, allCompleteClasses);
				}
				else {
					assert !edge.isMatched();
					unconditionalExpressionSynthesizer.getExpressionSynthesizer(false).rewriteCastEdgeAsOclAsType((CastEdge)edge);
				}
				assert edge.eContainer() == null;
				assert edge.getSourceNode() == null;
				assert edge.getTargetNode() == null;
			}
		}
	}

	protected void rewriteCastEdgeAsMergedMultiCompleteClass(@NonNull Node sourceNode, @NonNull Set<@NonNull CompleteClass> allCompleteClasses) {
		List<@NonNull CompleteClass> sortedCompleteClasses = new ArrayList<>(allCompleteClasses);
		Collections.sort(sortedCompleteClasses, DeepestFirstCompleteClassInheritanceComparator.INSTANCE);
		List<@NonNull CompleteClass> newCompleteClasses = new ArrayList<>();
		for (@NonNull CompleteClass sortedCompleteClass : sortedCompleteClasses) {
			boolean isRequired = true;
			for (@NonNull CompleteClass newCompleteClass : newCompleteClasses) {
				if (newCompleteClass.conformsTo(sortedCompleteClass)) {
					isRequired = false;
					break;
				}
			}
			if (isRequired) {
				newCompleteClasses.add(sortedCompleteClass);
			}
		}
		ClassDatum sourceClassDatum = QVTscheduleUtil.getClassDatum(sourceNode);
		TypedModel typedModel = QVTscheduleUtil.getReferredTypedModel(sourceClassDatum);
		ClassDatum mergedClassDatum = scheduleManager.getClassDatum(typedModel, newCompleteClasses);
		sourceNode.setClassDatum(mergedClassDatum);
		for (@NonNull Edge sourceOutgoingEdge : Lists.newArrayList(QVTscheduleUtil.getOutgoingEdges(sourceNode))) {
			CompilerUtil.migrateCastEdgeTargetContents((CastEdge)sourceOutgoingEdge, sourceNode);
		}
	}

	@Override
	public @NonNull String toString() {
		return getName();
	}
}