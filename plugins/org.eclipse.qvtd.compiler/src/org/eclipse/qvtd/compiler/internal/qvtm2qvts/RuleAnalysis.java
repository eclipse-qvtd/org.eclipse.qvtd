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
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

/**
 * A RuleAnalysis provides the analysis a QVTb rule.
 */
public abstract class RuleAnalysis extends RegionHelper<@NonNull RuleRegion>
{
	protected final @NonNull ExpressionAnalyzer expressionAnalyzer;

	/**
	 * The dependency heads to accommodate operation content.
	 */
	private /*@LazyNonNull*/ List<@NonNull Node> dependencyHeadNodes = null;

	protected RuleAnalysis(@NonNull ScheduleManager scheduleManager, @NonNull RuleRegion ruleRegion) {
		super(scheduleManager, ruleRegion);
		this.expressionAnalyzer = new ExpressionAnalyzer(this);
		assert scheduleManager.getScheduleModel().getOwnedMappingRegions().contains(ruleRegion);
	}

	public @NonNull Node createDependencyHead(@NonNull ClassDatum classDatum) {
		if (dependencyHeadNodes == null) {
			dependencyHeadNodes = new ArrayList<>();
		}
		Node dependencyHeadNode = createDependencyNode("«extra-" + (dependencyHeadNodes.size()+1) + "»", classDatum);
		dependencyHeadNode.setHead();
		dependencyHeadNodes.add(dependencyHeadNode);
		return dependencyHeadNode;
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

	public abstract @NonNull Node getReferenceNode(@NonNull VariableDeclaration variableDeclaration);

	public @NonNull RuleRegion getRuleRegion() {
		return region;
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