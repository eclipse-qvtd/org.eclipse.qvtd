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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtb2qvts.ExpressionSynthesizer;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QVTrelationExpressionSynthesizer extends AbstractQVTrelationExpressionSynthesizer
{
	public static class ConditionalExpressionSynthesizer extends QVTrelationExpressionSynthesizer
	{
		protected ConditionalExpressionSynthesizer(@NonNull RelationAnalysis context) {
			super(context);
		}

		@Override
		protected @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode) {
			return context.createStepNode(name, callExp, sourceNode, false);
		}

		@Override
		protected boolean isUnconditional() {
			return false;
		}
	}

	public static class RequiredExpressionSynthesizer extends QVTrelationExpressionSynthesizer
	{
		protected RequiredExpressionSynthesizer(@NonNull RelationAnalysis context) {
			super(context);
		}

		@Override
		protected @NonNull Node createOperationCallNode(@NonNull CallExp callExp, @NonNull Operation operation,@NonNull Node @NonNull [] sourceAndArgumentNodes) {
			Node operationCallNode = super.createOperationCallNode(callExp, operation, sourceAndArgumentNodes);
			operationCallNode.setRequired();
			return operationCallNode;
		}

		@Override
		protected boolean isRequired() {
			return true;
		}
	}

	protected QVTrelationExpressionSynthesizer(@NonNull RelationAnalysis context) {
		super(context);
	}

	@Override
	protected @NonNull ExpressionSynthesizer createConditionalExpressionSynthesizer() {
		return new ConditionalExpressionSynthesizer(getRelationAnalysis());
	}

	@Override
	protected @NonNull ExpressionSynthesizer createRequiredExpressionSynthesizer() {
		return new RequiredExpressionSynthesizer(getRelationAnalysis());
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
		InvocationAnalysis invocationAnalysis = relationAnalysis.getOutgoingInvocationAnalysis(invokedRelationAnalysis, relationCallExp, isWhen);
		List<@NonNull Variable> rootVariables = QVTrelationUtil.getRootVariables(invokedRelation);
		List<@NonNull OCLExpression> ownedArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(relationCallExp);
		int size = rootVariables.size();
		assert size == ownedArguments.size();
		for (int i = 0; i < size; i++) {
			VariableDeclaration rootVariable = rootVariables.get(i);
			OCLExpression ownedArgument = ownedArguments.get(i);
			Node argumentNode = ownedArgument.accept(this);
			assert argumentNode != null;
			invocationAnalysis.addBinding(rootVariable, argumentNode);
		}
		//		for ()
		//		if (referredRule2TraceClass.getStatusInterfaceProperty())
		return null;
	}

	@Override
	public @Nullable Node visitTemplateExp(@NonNull TemplateExp templateExp) {
		VariableDeclaration referredVariable = QVTrelationUtil.getBindsTo(templateExp);
		return context.getReferenceNode(referredVariable);
	}
}