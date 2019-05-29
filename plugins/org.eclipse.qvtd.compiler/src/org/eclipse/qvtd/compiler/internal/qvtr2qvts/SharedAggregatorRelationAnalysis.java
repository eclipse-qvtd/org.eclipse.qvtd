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
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.AbstractTransformationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvtc2qvtu.QVTuConfiguration;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.RelationAnalysis2TraceClass;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.trace.VariableDeclaration2TraceProperty;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Node.Utility;

/**
 * A SharedAggregatorRelationAnalysis provides the analysis of a non-top QVTr mapping with a DataTY[pe roor variable.
 */
public class SharedAggregatorRelationAnalysis extends RelationAnalysis
{
	public SharedAggregatorRelationAnalysis(@NonNull AbstractTransformationAnalysis transformationAnalysis, @NonNull QVTuConfiguration qvtuConfiguration, @NonNull RuleRegion ruleRegion) {
		super(transformationAnalysis, qvtuConfiguration, ruleRegion);
	}

	@Override
	public boolean isSharedAggregator() {
		return true;
	}

	@Override
	protected void synthesizeTraceEdges(@NonNull Node traceNode, @Nullable Node dispatchNode) {
		super.synthesizeTraceEdges(traceNode, dispatchNode);
		RelationAnalysis2TraceClass ruleAnalysis2traceClass = getRuleAnalysis2TraceGroup().getRuleAnalysis2TraceClass();
		for (@NonNull VariableDeclaration2TraceProperty variableDeclaration2traceProperty : ruleAnalysis2traceClass.getVariableDeclaration2TraceProperties()) {
			VariableDeclaration tracedVariable = variableDeclaration2traceProperty.getOverridingVariable();
			Node targetNode = region.getNode(tracedVariable);
			assert targetNode != null;
			if (targetNode.isOld()) {
				Property traceProperty = variableDeclaration2traceProperty.getTraceProperty();
				createSharedEdge(Role.REALIZED, targetNode, traceProperty, traceNode);
			}
		}
	}

	@Override
	protected @NonNull Node synthesizeTraceNode() {
		Relation relation = getRule();
		VariableDeclaration traceVariable = QVTrelationUtil.getTraceVariable(relation);
		Node traceNode = createRealizedStepNode(traceVariable);
		traceNode.setUtility(Utility.TRACE);
		return traceNode;
	}
}