/*******************************************************************************
 * Copyright (c) 2015 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.scheduler;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LiteralExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;

public class ExpressionAnalyzer extends AbstractExtendingQVTimperativeVisitor<@NonNull SimpleNode, @NonNull AbstractMappingRegion>
{
	public class ConditionalExpressionAnalyzer extends ExpressionAnalyzer
	{
		protected ConditionalExpressionAnalyzer() {
			super(ExpressionAnalyzer.this.context);
		}

		@Override
		public @NonNull SimpleNode visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
			return super.visitNavigationCallExp(navigationCallExp);
		}
	}
	
	protected final @NonNull SchedulerConstants scheduler;
	private /*@LazyNonNull*/ ConditionalExpressionAnalyzer conditionalExpressionAnalyzer = null;
//	private /*@LazyNonNull*/ DependencyAnalyzer dependencyAnalyzer;
	
	protected ExpressionAnalyzer(@NonNull AbstractMappingRegion context) {
		super(context);
		this.scheduler = context.getSchedulerConstants();
//		this.dependencyAnalyzer = getDependencyAnalyzer();
	}
	
	public @NonNull SimpleNode analyze(/*@NonNull*/ Visitable element) {
		SimpleNode accept = element.accept(this);
		assert accept != null;
		return accept;
	}

	private @NonNull SimpleNode analyzeOperationCallExp_oclAsType(@NonNull SimpleNode sourceNode, @NonNull OperationCallExp operationCallExp) {
//		if ((operationCallExp.getOwnedSource() instanceof CallExp) && sourceNode.refineClassDatumAnalysis(scheduler.getClassDatumAnalysis(operationCallExp))) {
//			return sourceNode;
//		}
		Type type = operationCallExp.getType();
		assert type != null;
		CompleteClass requiredClass = scheduler.getEnvironmentFactory().getCompleteModel().getCompleteClass(type);
		CompleteClass predicatedClass = sourceNode.getCompleteClass();
		if (predicatedClass.conformsTo(requiredClass)) {
			sourceNode.addTypedElement(operationCallExp);
			return sourceNode;											// Skip cast if already conformant, typically a redundant cast daisy chain
		}
		for (SimpleNavigationEdge castEdge : sourceNode.getCastEdges()) {
			SimpleNode targetNode = castEdge.getTarget();
			predicatedClass = targetNode.getCompleteClass();
			if (predicatedClass.conformsTo(requiredClass)) {
				targetNode.addTypedElement(operationCallExp);
				return targetNode;										// Re-use a pre-existing class
			}
		}
		Type castType = type;
		assert castType != null;
		Property castProperty = scheduler.getCastProperty(castType);
		SimpleEdge castEdge = sourceNode.getPredicateEdge(castProperty);
		if (castEdge != null) {
			SimpleNode castNode = castEdge.getTarget();
			castNode.addTypedElement(operationCallExp);
			return castNode;
		}
		String name = "a" + castType.getName();
//		assert name != null;
		SimpleNode castNode = Nodes.STEP.createSimpleNode(context, name, operationCallExp, sourceNode);
		castEdge = Edges.CAST.createSimpleEdge(context, sourceNode, castProperty, castNode);
		OCLExpression argument = operationCallExp.getOwnedArguments().get(0);
		if (!(argument instanceof TypeExp)) {
			SimpleNode argumentNode = analyze(argument);
			Edges.ARGUMENT.createSimpleEdge(context, argumentNode, "«arg»", castNode);
		}
		return castNode;
/*		OperationNode operationNode = new OperationNode(context, operationCallExp.getReferredOperation().getName(), context.getClassDatumAnalysis(operationCallExp));
		Edges.ARGUMENT.createEdge(context, sourceNode, "source", operationNode);
		for (@SuppressWarnings("null")@NonNull OCLExpression argument : operationCallExp.getOwnedArguments()) {
			Node argumentNode = analyze(argument);
			Edges.ARGUMENT.createEdge(context, argumentNode, "arg", operationNode);
		}
		Type returnType = operationCallExp.getType();
		if (returnType instanceof DataType) {
			return operationNode;
		}
		else {
//			Variable resultVariable = PivotUtil.createVariable("-result-", returnType, operationCallExp.isIsRequired(), null);
//			GuardNode resultNode = context.getGuardNode(resultVariable);
			ClassDatumAnalysis classDatumAnalysis = scheduler.getClassDatumAnalysis(operationCallExp);
			DomainClassNode resultNode = new DomainClassNode(context, "-result-", classDatumAnalysis);
//			resultNode.setResult();
			Edges.ARGUMENT.createEdge(context, operationNode, null, resultNode);
			return resultNode;
		} */
	}

	private @NonNull SimpleNode analyzeOperationCallExp_oclIsKindOf(@NonNull SimpleNode sourceNode, @NonNull OperationCallExp operationCallExp) {
		OCLExpression argument = operationCallExp.getOwnedArguments().get(0);
		SimpleNode operationNode = null;
		if (argument instanceof TypeExp) {
			String name = operationCallExp.getReferredOperation().getName() + "\\n" + ((TypeExp)argument).getReferredType().toString();
			operationNode = findOperationNode(sourceNode, name);
			if (operationNode == null) {
				operationNode = Nodes.OPERATION.createSimpleNode(context, name, operationCallExp, sourceNode);
				Edges.ARGUMENT.createSimpleEdge(context, sourceNode, null, operationNode);
			}
		}
		else {
			String name = operationCallExp.getReferredOperation().getName();
			assert name != null;
			SimpleNode argumentNode = analyze(argument);
			operationNode = findOperationNode(sourceNode, name, argumentNode);
			if (operationNode == null) {
				operationNode = Nodes.OPERATION.createSimpleNode(context, name, operationCallExp, sourceNode, argumentNode);
				Edges.ARGUMENT.createSimpleEdge(context, sourceNode, "«source»", operationNode);
				Edges.ARGUMENT.createSimpleEdge(context, argumentNode, "«arg»", operationNode);
			}
		}
		return operationNode;
	}

	private @NonNull SimpleNode analyzeOperationCallExp_oclContainer(@NonNull SimpleNode sourceNode, @NonNull OperationCallExp operationCallExp) {
		Type castType = operationCallExp.getType();
		assert castType != null;
		Property oclContainerProperty = scheduler.getOclContainerProperty();
		SimpleEdge oclContainerEdge = sourceNode.getPredicateEdge(oclContainerProperty);
		if (oclContainerEdge != null) {
			return oclContainerEdge.getTarget();
		}
		String name = operationCallExp.getReferredOperation().getName();
		assert name != null;
		SimpleNode oclContainerNode = Nodes.STEP.createSimpleNode(context, name, operationCallExp, sourceNode);
		oclContainerEdge = Edges.NAVIGATION.createSimpleEdge(context, sourceNode, oclContainerProperty, oclContainerNode);
		return oclContainerNode;
/*		String name = operationCallExp.getReferredOperation().getName();
		assert name != null;
		Node operationNode = findOperationNode(sourceNode, name);
		if (operationNode == null) {
			operationNode = Nodes.OPERATION.createNode(context, name, operationCallExp, sourceNode);
			Edges.ARGUMENT.createEdge(context, sourceNode, null, operationNode);
		}
		return operationNode; */
/*		Type type = operationCallExp.getType();
		assert type != null;
		Property oclContainerProperty = scheduler.getOclContainerProperty();
		NavigationEdge navigationEdge = sourceNode.getNavigationEdge(oclContainerProperty);
		if (navigationEdge != null) {
			Node targetNode = navigationEdge.getTarget();
//			if (targetNode instanceof ClassNode) {
			return targetNode;
//			}
//			else {
//			return null;
//			}
		}
		String name = oclContainerProperty.getName();
		assert (name != null) && (type != null);
		FutureVariable variable = new FutureVariable("-container-", type, oclContainerProperty.isIsRequired(), sourceNode.getClassDatumAnalysis().getDomainUsage());
		ClassNode targetReferenceNode = context.getReferenceNode(variable);
		context.addPredicateEdge((ClassNode) sourceNode, oclContainerProperty, targetReferenceNode);
		return targetReferenceNode; */
/*		PredicateEdge predicateEdge = getPredicateEdge((ClassNode) sourceNode, oclContainerProperty);
		if (predicateEdge != null) {
			return predicateEdge.getTarget();
		}
		else {
			AbstractRegion region =  sourceNode.getRegion();
			Node targetNode = new CastClassNode(region, (ClassNode) sourceNode, region.getClassDatum(operationCallExp));
			addPredicateEdge((ClassNode) sourceNode, oclAsTypeProperty, targetNode);
			return targetNode;
		} */
	}

	private @Nullable SimpleNode findOperationNode(@NonNull SimpleNode sourceNode, @NonNull String name, SimpleNode... argumentNodes) {
		for (SimpleEdge resultEdge : sourceNode.getResultEdges()) {
			SimpleNode targetNode = resultEdge.getTarget();
			if (targetNode.isExpression()) {
				SimpleNode operationNode = targetNode;
				if (operationNode.getName().equals(name)) {
					int argIndex = -1;
					for (Edge argumentEdge : targetNode.getArgumentEdges()) {
						if (argIndex == -1) {
							if (argumentEdge != resultEdge) {
								operationNode = null;
								break;
							}
						}
						else {
							if ((argumentNodes == null) || (argumentNodes.length <= argIndex) || (argumentNodes[argIndex] != argumentEdge.getSource())) {
								operationNode = null;
								break;
							}
						}
						argIndex++;
					}
					if ((operationNode != null) && ((argumentNodes == null) || (argIndex == argumentNodes.length))) {
						return operationNode;
					}
				}
			}
		}
		return null;
	}

	private @NonNull ExpressionAnalyzer getConditionalExpressionAnalyzer() {
		ConditionalExpressionAnalyzer conditionalExpressionAnalyzer2 = conditionalExpressionAnalyzer;
		if (conditionalExpressionAnalyzer2 == null) {
			conditionalExpressionAnalyzer = conditionalExpressionAnalyzer2 = new ConditionalExpressionAnalyzer();
		}
		return conditionalExpressionAnalyzer2;
	}

/*	protected @NonNull DependencyAnalyzer getDependencyAnalyzer() {
		DependencyAnalyzer dependencyAnalyzer2 = dependencyAnalyzer;
		if (dependencyAnalyzer2 == null) {
			dependencyAnalyzer = dependencyAnalyzer2 = new DependencyAnalyzer(scheduler.getEnvironmentFactory(), scheduler.getDomainAnalysis());
		}
		return dependencyAnalyzer2;
	} */

	private void instantiate(@NonNull SimpleNode instantiatedNode, @NonNull Node extraNode) {
		for (NavigationEdge extraEdge : extraNode.getNavigationEdges()) {
			Node extraTargetNode = extraEdge.getTarget();
			String name = extraTargetNode.getName();
			ClassDatumAnalysis classDatumAnalysis = extraTargetNode.getClassDatumAnalysis();
			SimpleNode instantiatedTargetNode = Nodes.AttributeNodeRoleFactory.PREDICATED_CLASS.createSimpleNode(context, name, classDatumAnalysis);
			Edges.NAVIGATION.createSimpleEdge(context, instantiatedNode, extraEdge.getProperty(), instantiatedTargetNode);
			instantiate(instantiatedTargetNode, extraTargetNode);
		}
	}

	@Override
	public @NonNull SimpleNode visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @NonNull SimpleNode visitCollectionLiteralExp(@NonNull CollectionLiteralExp collectionLiteralExp) {
		List<CollectionLiteralPart> ownedParts = collectionLiteralExp.getOwnedParts();
		int iSize = ownedParts.size();
		SimpleNode[] partNodes = new SimpleNode[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, ClassUtil.nonNullState(collectionLiteralExp.getKind().toString()), collectionLiteralExp, partNodes);
		for (int i = 0; i < iSize; i++) {
			Edges.ARGUMENT.createSimpleEdge(context, ClassUtil.nonNullState(partNodes[i]), "«arg" + i + "»", operationNode);
		}
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitCollectionItem(@NonNull CollectionItem collectionItem) {
		return analyze(collectionItem.getOwnedItem());
	}

	@Override
	public @NonNull SimpleNode visitCollectionRange(@NonNull CollectionRange collectionRange) {
		SimpleNode firstNode = analyze(collectionRange.getOwnedFirst());
		SimpleNode lastNode = analyze(collectionRange.getOwnedLast());
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, "..", collectionRange, firstNode, lastNode);
		Edges.ARGUMENT.createSimpleEdge(context, firstNode, "first", operationNode);
		Edges.ARGUMENT.createSimpleEdge(context, lastNode, "last", operationNode);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitElement(@NonNull Element element) {
		Class oclInvalidType = scheduler.getStandardLibrary().getOclInvalidType();
		ClassDatumAnalysis classDatumAnalysis = scheduler.getClassDatumAnalysis(oclInvalidType, scheduler.getDomainAnalysis().getPrimitiveTypeModel());
		SimpleNode errorNode = Nodes.ERROR.createSimpleNode(context, "«error»", classDatumAnalysis);
		for (EObject eObject : element.eContents()) {
			SimpleNode node = analyze((Visitable) eObject);
			Edges.ARGUMENT.createSimpleEdge(context, node, "?", errorNode);
		}
		return errorNode;
	}

	@Override
	public @NonNull SimpleNode visitIfExp(@NonNull IfExp ifExp) {
		ExpressionAnalyzer conditionalExpressionAnalyzer = getConditionalExpressionAnalyzer();
		SimpleNode conditionNode = analyze(ifExp.getOwnedCondition());
		SimpleNode thenNode = conditionalExpressionAnalyzer.analyze(ifExp.getOwnedThen());
		SimpleNode elseNode = conditionalExpressionAnalyzer.analyze(ifExp.getOwnedElse());
		SimpleNode ifNode = Nodes.OPERATION.createSimpleNode(context, "if", ifExp, conditionNode, thenNode, elseNode);
		Edges.ARGUMENT.createSimpleEdge(context, conditionNode, "condition", ifNode);
		Edges.ARGUMENT.createSimpleEdge(context, thenNode, "then", ifNode);
		Edges.ARGUMENT.createSimpleEdge(context, elseNode, "else", ifNode);
		return ifNode;
	}

	@Override
	public @NonNull SimpleNode visitLetExp(@NonNull LetExp letExp) {
		Variable ownedVariable = letExp.getOwnedVariable();
		SimpleNode initNode = analyze(ownedVariable.getOwnedInit());
		assert initNode != null;
		Type type = ownedVariable.getType();
		assert type != null;
		CompleteClass actualClass = initNode.getCompleteClass();
		CompleteClass requiredClass = context.getClassDatumAnalysis(ownedVariable).getCompleteClass();
		if (actualClass.conformsTo(requiredClass)) {
			context.addVariableNode(ownedVariable, initNode);
			initNode.addTypedElement(ownedVariable);
		}
		else {
			SimpleNode varNode = Nodes.LET.createSimpleNode(context, ownedVariable, initNode);
			Property castProperty = scheduler.getCastProperty(type);
			Edges.NAVIGATION.createSimpleEdge(context, initNode, castProperty, varNode);
		}
		return analyze(letExp.getOwnedIn());
	}

	@Override
	public @NonNull SimpleNode visitLiteralExp(@NonNull LiteralExp literalExp) {
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, ClassUtil.nonNullState(literalExp.toString()), literalExp);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitLoopExp(@NonNull LoopExp loopExp) {
		assert !loopExp.isIsSafe();
		SimpleNode sourceNode = analyze(loopExp.getOwnedSource());
		List<Variable> ownedIterators = loopExp.getOwnedIterators();
		SimpleNode[] argNodes = new SimpleNode[1+ownedIterators.size()];
		int i = 1;
		for (@SuppressWarnings("null")@NonNull Variable iterator : ownedIterators) {
			SimpleNode iteratorNode = Nodes.ITERATOR.createSimpleNode(context, iterator, sourceNode);
			Type iteratorType = iterator.getType();
			assert iteratorType != null;
//			Property iterateProperty = context.getSchedulerConstants().getIterateProperty(iteratorType);
			Edges.ITERATED.createSimpleEdge(context, sourceNode, iteratorNode);
			argNodes[i++] = iteratorNode;
		}
		SimpleNode bodyNode = analyze(loopExp.getOwnedBody());
		argNodes[0] = bodyNode;
		String iterationName = "«" + loopExp.getReferredIteration().getName() + "»";
		SimpleNode accumulateNode = Nodes.OPERATION.createSimpleNode(context, iterationName, loopExp, argNodes);
		Edges.ARGUMENT.createSimpleEdge(context, sourceNode, "«source»", accumulateNode);
		Edges.ARGUMENT.createSimpleEdge(context, bodyNode, "«body»", accumulateNode);
		i = 1;
		for (@SuppressWarnings("null")@NonNull Variable iterator : ownedIterators) {
			SimpleNode iteratorNode = argNodes[i++];
			assert iteratorNode != null;
			Edges.ARGUMENT.createSimpleEdge(context, iteratorNode, iterator.getName() , accumulateNode);
		}
//		SimpleNode resultNode = Nodes.RESULT.createSimpleNode(context, "«result»", loopExp, sourceNode);
//		Edges.ARGUMENT.createSimpleEdge(context, accumulateNode, null, resultNode);
		return accumulateNode;
	}

	@Override
	public @NonNull SimpleNode visitMapLiteralExp(@NonNull MapLiteralExp mapLiteralExp) {
		List<MapLiteralPart> ownedParts = mapLiteralExp.getOwnedParts();
		int iSize = ownedParts.size();
		SimpleNode[] partNodes = new SimpleNode[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, ClassUtil.nonNullState(mapLiteralExp.getName()), mapLiteralExp, partNodes);
		for (int i = 0; i < iSize; i++) {
			Edges.ARGUMENT.createSimpleEdge(context, ClassUtil.nonNullState(partNodes[i]), "«arg" + i + "»", operationNode);
		}
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitMapLiteralPart(@NonNull MapLiteralPart mapLiteralPart) {
		OCLExpression ownedValue = mapLiteralPart.getOwnedValue();
		assert ownedValue != null;
		SimpleNode keyNode = analyze(mapLiteralPart.getOwnedKey());
		SimpleNode valueNode = analyze(ownedValue);
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, "Part", ownedValue, keyNode, valueNode);
		Edges.ARGUMENT.createSimpleEdge(context, keyNode, "key", operationNode);
		Edges.ARGUMENT.createSimpleEdge(context, valueNode, "value", operationNode);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
		assert !navigationCallExp.isIsSafe();
		Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
		assert referredProperty != null;
		OCLExpression ownedSource = navigationCallExp.getOwnedSource();
		assert ownedSource != null;
		SimpleNode sourceNode = analyze(ownedSource);
		if (sourceNode.isClassNode()) {
			SimpleNode sourceReferenceNode = sourceNode;
			if (!referredProperty.isIsMany()) {
				SimpleNavigationEdge navigationEdge = sourceReferenceNode.getNavigationEdge(referredProperty);
				if (navigationEdge != null) {
					SimpleNode targetNode = navigationEdge.getTarget();
//					if (targetNode instanceof ClassNode) {
						return targetNode;
//					}
//					else {
//						return null;
//					}
				}
			}
			Type type = referredProperty.getType();
			if (type instanceof DataType) {
				SimpleNode attributeNode = context.getPredicatedAttributeNode(sourceReferenceNode, navigationCallExp);
				context.addPredicateEdge(sourceReferenceNode, referredProperty, attributeNode);
				return attributeNode;
			}
			else {
				String name = referredProperty.getName();
				assert (name != null) && (type != null);
				SimpleNode targetReferenceNode = Nodes.STEP.createSimpleNode(context, name, navigationCallExp, sourceNode);
				context.addPredicateEdge(sourceReferenceNode, referredProperty, targetReferenceNode);
				return targetReferenceNode;
			}
		}
		return context.getUnknownNode(ownedSource);
	}

	@Override
	public @NonNull SimpleNode visitNullLiteralExp(@NonNull NullLiteralExp nullLiteralExp) {
		return Nodes.NULL.createSimpleNode(context, nullLiteralExp);
	}

	@Override
	public @NonNull SimpleNode visitOCLExpression(@NonNull OCLExpression oclExpression) {
		return context.getUnknownNode(oclExpression);
	}

	@Override
	public @NonNull SimpleNode visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
		assert !operationCallExp.isIsSafe();
		Operation referredOperation = operationCallExp.getReferredOperation();
		OCLExpression ownedSource = operationCallExp.getOwnedSource();
		if (ownedSource instanceof VariableExp) {
			Transformation transformation = QVTbaseUtil.getContainingTransformation(operationCallExp);
			if (transformation != null) {
				Variable thisVariable = QVTbaseUtil.getContextVariable(scheduler.getStandardLibrary(), transformation);
				if (((VariableExp)ownedSource).getReferredVariable() == thisVariable) {
					ownedSource = null;
				}
			}
		}
		if (ownedSource == null) {
			List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
			int iSize = ownedArguments.size();
			SimpleNode[] argNodes = new SimpleNode[iSize];
			for (int i = 0; i < iSize; i++) {
				argNodes[i] = analyze(ownedArguments.get(i));
			}
			SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, ClassUtil.nonNullState(referredOperation.getName()), operationCallExp, argNodes);
			for (int i = 0; i < iSize; i++) {
				Edges.ARGUMENT.createSimpleEdge(context, ClassUtil.nonNullState(argNodes[i]), /*iSize > 1 ?*/ "«arg" + i + "»"/*: null*/, operationNode);
			}
			return operationNode;
		}
		SimpleNode sourceNode = analyze(ownedSource);
		OperationId operationId = referredOperation.getOperationId();
		if (operationId == scheduler.getOclAnyOclAsTypeId()) {
			return analyzeOperationCallExp_oclAsType(sourceNode, operationCallExp);
		}
		else if (PivotUtil.isSameOperation(operationId, scheduler.getOclElementOclContainerId())) {
			return analyzeOperationCallExp_oclContainer(sourceNode, operationCallExp);
		}
		else if (PivotUtil.isSameOperation(operationId, scheduler.getOclAnyOclIsKindOfId())) {
			return analyzeOperationCallExp_oclIsKindOf(sourceNode, operationCallExp);
		}
		else {
			List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
			int iSize = ownedArguments.size();
			SimpleNode[] argNodes = new SimpleNode[iSize+1];
			argNodes[0] = sourceNode;
			for (int i = 0; i < iSize; i++) {
				argNodes[i+1] = analyze(ownedArguments.get(i));
			}
			SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, ClassUtil.nonNullState(referredOperation.getName()), operationCallExp, argNodes);
			for (int i = 0; i <= iSize; i++) {
				Edges.ARGUMENT.createSimpleEdge(context, ClassUtil.nonNullState(argNodes[i]), /*iSize > 1 ?*/ "«arg" + i + "»"/*: null*/, operationNode);
			}
			if (referredOperation.getBodyExpression() != null) {
				OperationRegion operationRegion = context.getSuperRegion().analyzeOperation(operationCallExp);
				for (@SuppressWarnings("null")@NonNull Node extraNode : operationRegion.getExtraNodes()) {
					SimpleNode instantiatedNode = context.createExtraGuard(extraNode);
					Edges.ARGUMENT.createSimpleEdge(context, instantiatedNode, instantiatedNode.getName(), operationNode);
					instantiate(instantiatedNode, extraNode);
				}
			}
			Type returnType = operationCallExp.getType();
			if (returnType instanceof DataType) {
				return operationNode;
			}
			else {
				return operationNode;
			}
		}
	}

	@Override
	public @NonNull SimpleNode visitPropertyAssignment(@NonNull PropertyAssignment propertyAssignment) {
		Property property = propertyAssignment.getTargetProperty();
		assert property != null;
		SimpleNode slotNode = analyze(propertyAssignment.getSlotExpression());
		assert slotNode.isClassNode();
		SimpleNode valueNode = analyze(propertyAssignment.getValue());
//		if (!valueNode.isClassNode() && !valueNode.isNull()) {
		if (valueNode.isExpression()) {
			SimpleNode computedValueNode = valueNode;
			Type type = property.getType();
			if (type instanceof DataType) {
				valueNode = context.getAssignedAttributeNode(slotNode, property);
				Edges.ArgumentEdgeRoleFactory.REALIZED_ARGUMENT.createEdge(context, computedValueNode, null, valueNode);
			}
			else {
				String name = property.getName();
				assert (name != null) && (type != null);
				valueNode = Nodes.AttributeNodeRoleFactory.PREDICATED_CLASS.createSimpleNode(context, slotNode, propertyAssignment);
				Edges.ARGUMENT.createSimpleEdge(context, computedValueNode, null, valueNode);
			}
		}
		context.addAssignmentEdge(slotNode, property, valueNode);
		Property oppositeProperty = property.getOpposite();
		if (valueNode.isClassNode() && (oppositeProperty != null) && !oppositeProperty.isIsMany()) {
			context.addAssignmentEdge(valueNode, oppositeProperty, slotNode);
		}
		return slotNode;
	}

	@Override
	public @NonNull SimpleNode visitShadowExp(@NonNull ShadowExp shadowExp) {
		List<ShadowPart> ownedParts = shadowExp.getOwnedParts();
		int iSize = ownedParts.size();
		SimpleNode[] partNodes = new SimpleNode[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, ClassUtil.nonNullState(shadowExp.getType().getName()), shadowExp, partNodes);
		for (int i = 0; i < iSize; i++) {
			Edges.ARGUMENT.createSimpleEdge(context, ClassUtil.nonNullState(partNodes[i]), "«arg" + i + "»", operationNode);
		}
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitShadowPart(@NonNull ShadowPart shadowPart) {
		SimpleNode partNode = analyze(shadowPart.getOwnedInit());
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, ClassUtil.nonNullState(shadowPart.getName()), shadowPart, partNode);
		Edges.ARGUMENT.createSimpleEdge(context, partNode, "«arg»", operationNode);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitTupleLiteralExp(@NonNull TupleLiteralExp tupleLiteralExp) {
		List<TupleLiteralPart> ownedParts = tupleLiteralExp.getOwnedParts();
		int iSize = ownedParts.size();
		SimpleNode[] partNodes = new SimpleNode[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, ClassUtil.nonNullState(tupleLiteralExp.getName()), tupleLiteralExp, partNodes);
		for (int i = 0; i < iSize; i++) {
			Edges.ARGUMENT.createSimpleEdge(context, ClassUtil.nonNullState(partNodes[i]), "«arg" + i + "»", operationNode);
		}
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitTupleLiteralPart(@NonNull TupleLiteralPart tupleLiteralPart) {
		SimpleNode partNode = analyze(tupleLiteralPart.getOwnedInit());
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, ClassUtil.nonNullState(tupleLiteralPart.getName()), tupleLiteralPart, partNode);
		Edges.ARGUMENT.createSimpleEdge(context, partNode, "«arg»", operationNode);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitTypeExp(@NonNull TypeExp typeExp) {
		DomainUsage domainUsage = scheduler.getDomainUsage(typeExp);
		Type referredType = typeExp.getReferredType();
		assert referredType != null;
		TypedModel typedModel = domainUsage.getTypedModel();
		assert typedModel != null;
		ClassDatumAnalysis classDatumAnalysis = scheduler.getClassDatumAnalysis((org.eclipse.ocl.pivot.Class)referredType, typedModel);
		String typeName = PrettyPrinter.printType(classDatumAnalysis.getCompleteClass());
		SimpleNode operationNode = Nodes.OPERATION.createSimpleNode(context, typeName, typeExp);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitVariableExp(@NonNull VariableExp variableExp) {
		VariableDeclaration referredVariable = variableExp.getReferredVariable();
		assert referredVariable != null;
		return context.getReferenceNode(referredVariable);
	}
}