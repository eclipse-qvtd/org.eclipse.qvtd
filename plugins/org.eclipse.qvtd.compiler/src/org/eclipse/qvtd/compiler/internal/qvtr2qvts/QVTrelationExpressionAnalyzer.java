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
package org.eclipse.qvtd.compiler.internal.qvtr2qvts;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.qvtd.compiler.internal.qvtm2qvts.ExpressionAnalyzer;
import org.eclipse.qvtd.compiler.internal.qvtr2qvts.RelationAnalysis.InvocationAnalysis;
import org.eclipse.qvtd.compiler.internal.qvts2trace.NameGenerator;
import org.eclipse.qvtd.compiler.internal.qvts2trace.RuleAnalysis2TraceClass;
import org.eclipse.qvtd.pivot.qvtbase.Pattern;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtrelation.Relation;
import org.eclipse.qvtd.pivot.qvtrelation.RelationCallExp;
import org.eclipse.qvtd.pivot.qvtrelation.utilities.QVTrelationUtil;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvttemplate.TemplateExp;

public class QVTrelationExpressionAnalyzer extends AbstractQVTrelationExpressionAnalyzer
{
	public static class ConditionalExpressionAnalyzer extends QVTrelationExpressionAnalyzer
	{
		protected ConditionalExpressionAnalyzer(@NonNull RelationAnalysis context) {
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

	protected QVTrelationExpressionAnalyzer(@NonNull RelationAnalysis context) {
		super(context);
	}

	@Override
	protected @NonNull ExpressionAnalyzer createConditionalExpressionAnalyzer() {
		return new ConditionalExpressionAnalyzer(getRelationAnalysis());
	}

	public @NonNull RelationAnalysis getRelationAnalysis() {
		return (RelationAnalysis)context;
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
		Relation referredRelation = QVTrelationUtil.getReferredRelation(relationCallExp);
		RuleAnalysis2TraceClass referredRuleAnalysis2TraceClass = context.getTransformationAnalysis2TracePackage().getRuleAnalysis2TraceClass(referredRelation);
		org.eclipse.ocl.pivot.Class invocationInterface = referredRuleAnalysis2TraceClass.getInvocationInterface();
		NameGenerator nameGenerator = context.getNameGenerator();
		String name = isWhen ? nameGenerator.createWhenInvocationPropertyName(referredRelation)
			: nameGenerator.createWhereInvocationPropertyName(referredRelation);
		TypedModel traceTypedModel = scheduleManager.getTraceTypedModel();
		ClassDatum classDatum = scheduleManager.getClassDatum(traceTypedModel, invocationInterface);
		Node invokedNode;
		if (isWhen) {
			invokedNode = context.createPredicatedNode(name, classDatum, true);
		}
		else {
			invokedNode = context.createRealizedNode(name, classDatum, true);
		}
		//
		InvocationAnalysis invocationAnalysis = relationAnalysis.createInvocationAnalysis(referredRuleAnalysis2TraceClass, relationCallExp, invokedNode, isWhen);
		List<@NonNull Variable> rootVariables = QVTrelationUtil.getRootVariables(referredRelation);
		List<@NonNull OCLExpression> ownedArguments = QVTrelationUtil.Internal.getOwnedArgumentsList(relationCallExp);
		int size = rootVariables.size();
		assert size == ownedArguments.size();
		for (int i = 0; i < size; i++) {
			VariableDeclaration rootVariable = rootVariables.get(i);
			OCLExpression ownedArgument = ownedArguments.get(i);
			Node argumentNode = ownedArgument.accept(this);
			assert argumentNode != null;
			invocationAnalysis.add(rootVariable, argumentNode);
		}
		//		for ()
		//		if (referredRuleAnalysis2TraceClass.getStatusInterfaceProperty())
		return null;
	}

	@Override
	public @Nullable Node visitTemplateExp(@NonNull TemplateExp templateExp) {
		VariableDeclaration referredVariable = QVTrelationUtil.getBindsTo(templateExp);
		return context.getReferenceNode(referredVariable);
	}
}