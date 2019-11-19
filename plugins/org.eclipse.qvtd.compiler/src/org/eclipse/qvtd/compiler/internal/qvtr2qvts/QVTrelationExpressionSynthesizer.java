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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessEdge;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.InitUtility;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QVTrelationExpressionSynthesizer extends AbstractQVTrelationExpressionSynthesizer
{
	protected QVTrelationExpressionSynthesizer(@NonNull RelationAnalysis context, @Nullable QVTrelationExpressionSynthesizer unconditionalExpressionSynthesizer, @NonNull InitUtility initUtility) {
		super(context, unconditionalExpressionSynthesizer, initUtility);
	}

	@Override
	protected @NonNull ExpressionSynthesizer createExpressionSynthesizer(@NonNull InitUtility initUtility) {
		return new QVTrelationExpressionSynthesizer(getRelationAnalysis(), this, initUtility);
	}

	public @NonNull RelationAnalysis getRelationAnalysis() {
		return (RelationAnalysis)context;
	}

	@Override
	public @Nullable Node visitEnumerationLiteral(@NonNull EnumerationLiteral object) {
		return visiting(object);
	}

	@Override
	public @Nullable Node visitRelationCallExp(@NonNull RelationCallExp relationCallExp) {
		RelationAnalysis relationAnalysis = getRelationAnalysis();
		Relation relation = relationAnalysis.getRule();
		boolean isWhen = false;
		Pattern containingPattern = QVTrelationUtil.basicGetContainingPattern(relationCallExp);
		if (containingPattern !=null) {
			if (relation.getWhen() == containingPattern) {
				isWhen = true;
			}
		}
		Relation invokedRelation = QVTrelationUtil.getReferredRelation(relationCallExp);
		RelationAnalysis invokedRelationAnalysis = (RelationAnalysis) context.getTransformationAnalysis().getRuleAnalysis(invokedRelation);
		//
		Map<@NonNull VariableDeclaration, @NonNull Node> rootVariable2argumentNode = new HashMap<>();
		List<@NonNull VariableDeclaration> rootVariables = QVTrelationUtil.getRootVariables(invokedRelation);
		List<@NonNull OCLExpression> ownedArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(relationCallExp);
		int size = rootVariables.size();
		assert size == ownedArguments.size();
		for (int i = 0; i < size; i++) {
			VariableDeclaration rootVariable = rootVariables.get(i);
			OCLExpression ownedArgument = ownedArguments.get(i);
			Node argumentNode = ownedArgument.accept(this);
			assert argumentNode != null;
			rootVariable2argumentNode.put(rootVariable, argumentNode);
		}
		InvocationAnalysis invocationAnalysis = relationAnalysis.getOutgoingInvocationAnalysis(invokedRelationAnalysis, relationCallExp, isWhen, getRequiredInitUtility(true), rootVariable2argumentNode);
		//		for ()
		//		if (referredRule2TraceClass.getStatusInterfaceProperty())
		invocationAnalysis.getInvokingNode();
		EObject eContainer = relationCallExp.eContainer();
		boolean isDirectCall = eContainer instanceof Predicate;
		//	if (!isDirectCall) {
		//		getClass();
		//	}
		SuccessEdge globalSuccessEdge = invocationAnalysis.getGlobalSuccessEdge(isDirectCall ? Boolean.TRUE : null);
		return globalSuccessEdge != null ? QVTscheduleUtil.getTargetNode(globalSuccessEdge) : isDirectCall ? null : relationAnalysis.createBooleanLiteralNode(getNonNullUtility(), true);
	}

	@Override
	public @Nullable Node visitTemplateExp(@NonNull TemplateExp templateExp) {
		VariableDeclaration referredVariable = QVTrelationUtil.getBindsTo(templateExp);
		return context.getReferenceNode(referredVariable);
	}
}