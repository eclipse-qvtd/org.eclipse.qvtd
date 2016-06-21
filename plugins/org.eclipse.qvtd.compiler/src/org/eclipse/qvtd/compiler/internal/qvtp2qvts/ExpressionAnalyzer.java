/*******************************************************************************
 * Copyright (c) 2015, 2016 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtp2qvts;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.Class;
import org.eclipse.ocl.pivot.CollectionItem;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.CompleteClass;
import org.eclipse.ocl.pivot.DataType;
import org.eclipse.ocl.pivot.Element;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IterateExp;
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
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtcorebase.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcorebase.analysis.DomainUsage;
import org.eclipse.qvtd.pivot.qvtcorebase.utilities.QVTcoreBaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.util.AbstractExtendingQVTimperativeVisitor;

import com.google.common.collect.Iterables;

public class ExpressionAnalyzer extends AbstractExtendingQVTimperativeVisitor<@NonNull SimpleNode, @NonNull SimpleMappingRegion>
{
	public class ConditionalExpressionAnalyzer extends ExpressionAnalyzer
	{
		protected ConditionalExpressionAnalyzer() {
			super(ExpressionAnalyzer.this.context);
		}

		@Override
		protected @NonNull SimpleEdge createCastEdge(@NonNull SimpleNode sourceNode, @NonNull Property castProperty, @NonNull SimpleNode castNode) {
			return Edges.UNNAVIGABLE_CAST.createSimpleEdge(context, sourceNode, castProperty, castNode);
		}

		@Override
		protected @NonNull SimpleEdge createNavigationEdge(@NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
			return Edges.UNNAVIGABLE_NAVIGATION.createSimpleEdge(context, sourceNode, source2targetProperty, targetNode);
		}

		@Override
		protected @NonNull SimpleNode createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull SimpleNode sourceNode) {
			return Nodes.UNNAVIGABLE_STEP.createSimpleNode(context, name, callExp, sourceNode);
		}
	}
	
	protected final @NonNull SchedulerConstants scheduler;
	private /*@LazyNonNull*/ ConditionalExpressionAnalyzer conditionalExpressionAnalyzer = null;
//	private /*@LazyNonNull*/ DependencyAnalyzer dependencyAnalyzer;
	
	protected ExpressionAnalyzer(@NonNull SimpleMappingRegion context) {
		super(context);
		this.scheduler = context.getSchedulerConstants();
//		this.dependencyAnalyzer = getDependencyAnalyzer();
	}

	protected void addPredicateEdge(@NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
		assert sourceNode.isClassNode();
		SimpleEdge predicateEdge = sourceNode.getPredicateEdge(source2targetProperty);
		if (predicateEdge == null) {
			createNavigationEdge(sourceNode, source2targetProperty, targetNode);
		}
		else {
			assert predicateEdge.getTarget() == targetNode;
		}
	}
	
	public @NonNull SimpleNode analyze(/*@NonNull*/ Visitable element) {
		SimpleNode accept = element.accept(this);
		assert accept != null;
		return accept;
	}

	private @NonNull SimpleNode analyzeOperationCallExp_includes(@NonNull SimpleNode sourceNode, @NonNull OperationCallExp operationCallExp) {
		SimpleNode targetNode = analyze(operationCallExp.getOwnedArguments().get(0));
		String name = operationCallExp.getReferredOperation().getName();
		createPredicateEdge(sourceNode, "«" + name + "»", targetNode);
		return Nodes.TRUE.createSimpleNode(sourceNode.getRegion());
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
		SimpleNode castNode = createStepNode(name, operationCallExp, sourceNode);
		castEdge = createCastEdge(sourceNode, castProperty, castNode);
		OCLExpression argument = operationCallExp.getOwnedArguments().get(0);
		if (!(argument instanceof TypeExp)) {
			SimpleNode argumentNode = analyze(argument);
			createArgumentEdge(argumentNode, "«arg»", castNode);
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
	
	private static final @Nullable String @NonNull [] nullArgNames = new @Nullable String[]{null};
	private static final @Nullable String @NonNull [] srcArgNames = new @Nullable String[]{"«source»", "«arg»"};

	private @NonNull SimpleNode analyzeOperationCallExp_oclIsKindOf(@NonNull SimpleNode sourceNode, @NonNull OperationCallExp operationCallExp) {
		OCLExpression argument = operationCallExp.getOwnedArguments().get(0);
		SimpleNode operationNode = null;
		if (argument instanceof TypeExp) {
			String name = operationCallExp.getReferredOperation().getName() + "\\n" + ((TypeExp)argument).getReferredType().toString();
			operationNode = findOperationNode(name, sourceNode);
			if (operationNode == null) {
				operationNode = createConnectedOperationNode(name, nullArgNames, operationCallExp, sourceNode);
			}
		}
		else {
			String name = operationCallExp.getReferredOperation().getName();
			assert name != null;
			SimpleNode argumentNode = analyze(argument);
			operationNode = findOperationNode(name, sourceNode, argumentNode);
			if (operationNode == null) {
				operationNode = createConnectedOperationNode(name, srcArgNames, operationCallExp, sourceNode, argumentNode);
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
		SimpleNode oclContainerNode = createStepNode(name, operationCallExp, sourceNode);
		oclContainerEdge = createNavigationEdge(sourceNode, oclContainerProperty, oclContainerNode);
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

	protected @NonNull SimpleEdge createArgumentEdge(@NonNull SimpleNode sourceNode, @Nullable String name, @NonNull SimpleNode targetNode) {
		return Edges.ARGUMENT.createSimpleEdge(context, sourceNode, name, targetNode);
	}

	protected @NonNull SimpleNode createConnectedOperationNode(@NonNull String name, @NonNull TypedElement typedElement, @NonNull SimpleNode @NonNull ... sourceAndArgumentNodes) {
		SimpleNode reusedNode = findOperationNode(name, sourceAndArgumentNodes);
		if (reusedNode != null) {
			reusedNode.addTypedElement(typedElement);
			return reusedNode;
		}
		SimpleNode operationNode = createOperationNode(name, typedElement, sourceAndArgumentNodes);
		for (int i = 0; i < sourceAndArgumentNodes.length; i++) {
			createArgumentEdge(ClassUtil.nonNullState(sourceAndArgumentNodes[i]), /*iSize > 1 ?*/ "«arg" + i + "»"/*: null*/, operationNode);
		}
		return operationNode;
	}

	protected @NonNull SimpleNode createConnectedOperationNode(@NonNull String name, @Nullable String @NonNull[] argNames, @NonNull TypedElement typedElement, @NonNull SimpleNode @NonNull ... sourceAndArgumentNodes) {
		assert argNames.length == sourceAndArgumentNodes.length;
		SimpleNode reusedNode = findOperationNode(name, sourceAndArgumentNodes);
		if (reusedNode != null) {
			reusedNode.addTypedElement(typedElement);
			return reusedNode;
		}
		SimpleNode operationNode = createOperationNode(name, typedElement, sourceAndArgumentNodes);
		for (int i = 0; i < sourceAndArgumentNodes.length; i++) {
			createArgumentEdge(ClassUtil.nonNullState(sourceAndArgumentNodes[i]), argNames[i], operationNode);
		}
		return operationNode;
	}

	protected @NonNull SimpleEdge createCastEdge(@NonNull SimpleNode sourceNode, @NonNull Property castProperty, @NonNull SimpleNode castNode) {
		return Edges.CAST.createSimpleEdge(context, sourceNode, castProperty, castNode);
	}

	protected @NonNull SimpleNode createErrorNode(@NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return Nodes.ERROR.createSimpleNode(context, name, classDatumAnalysis);
	}

	protected @NonNull SimpleEdge createIteratedEdge(@NonNull SimpleNode sourceNode, @NonNull SimpleNode targetNode) {
		return Edges.ITERATED.createSimpleEdge(context, sourceNode, targetNode);
	}

	protected @NonNull SimpleNode createIteratorNode(@NonNull Variable iterator, @NonNull SimpleNode sourceNode) {
		return Nodes.ITERATOR.createSimpleNode(context, iterator, sourceNode);
	}

	protected @NonNull SimpleNode createLetNode(@NonNull Variable letVariable, @NonNull SimpleNode inNode) {
		return Nodes.LET.createSimpleNode(context, letVariable, inNode);
	}

	protected @NonNull SimpleEdge createNavigationEdge(@NonNull SimpleNode sourceNode, @NonNull Property source2targetProperty, @NonNull SimpleNode targetNode) {
		return Edges.NAVIGATION.createSimpleEdge(context, sourceNode, source2targetProperty, targetNode);
	}

	protected @NonNull SimpleNode createNullNode(@NonNull TypedElement typedElement) {
		return Nodes.NULL.createSimpleNode(context, typedElement);
	}

	protected @NonNull SimpleNode createOperationNode(@NonNull String name, @NonNull TypedElement typedElement, @NonNull SimpleNode @NonNull ... argNodes) {
		return Nodes.OPERATION.createSimpleNode(context, name, typedElement, argNodes);
	}

	protected @NonNull SimpleEdge createPredicateEdge(@NonNull SimpleNode sourceNode, @Nullable String name, @NonNull SimpleNode targetNode) {
		return Edges.PREDICATE.createSimpleEdge(context, sourceNode, name, targetNode);
	}

	protected @NonNull SimpleNode createPredicatedClassNode(@NonNull SimpleNode parentNode, @NonNull NavigationAssignment navigationAssignment) {
		return Nodes.AttributeNodeRoleFactory.PREDICATED_CLASS.createSimpleNode(context, parentNode, navigationAssignment);
	}

	protected @NonNull SimpleNode createPredicatedClassNode(@NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return Nodes.AttributeNodeRoleFactory.PREDICATED_CLASS.createSimpleNode(context, name, classDatumAnalysis);
	}

	protected @NonNull SimpleEdge createRealizedArgumentEdge(@NonNull SimpleNode sourceNode, @Nullable String name, @NonNull SimpleNode targetNode) {
		return Edges.ArgumentEdgeRoleFactory.REALIZED_ARGUMENT.createEdge(context, sourceNode, name, targetNode);
	}

	protected @NonNull SimpleNode createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull SimpleNode sourceNode) {
		return Nodes.STEP.createSimpleNode(context, name, callExp, sourceNode);
	}

	protected @Nullable SimpleNode findOperationNode(@NonNull String name, @NonNull SimpleNode @NonNull ... sourceAndArgumentNodes) {
		if (sourceAndArgumentNodes.length > 0) {
			for (@NonNull Edge searchEdge : sourceAndArgumentNodes[0].getComputationEdges()) {
				Node reusedNode = searchEdge.getTarget();
				if ((reusedNode instanceof SimpleNode) && reusedNode.isOperation() && name.equals(reusedNode.getName())) {
					Iterable<@NonNull Edge> reusedEdges = reusedNode.getArgumentEdges();
					int iSize = Iterables.size(reusedEdges);
					if (iSize == sourceAndArgumentNodes.length) {
						int i = 0;
						for (@NonNull Edge reusedEdge : reusedEdges) {
							Node reusedArgumentNode = reusedEdge.getSource();
							if (reusedArgumentNode != sourceAndArgumentNodes[i]) {
								break;
							}
							i++;
						}
						if (i == iSize) {
							return (SimpleNode) reusedNode;
						}
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
			SimpleNode instantiatedTargetNode = createPredicatedClassNode(name, classDatumAnalysis);
			createNavigationEdge(instantiatedNode, extraEdge.getProperty(), instantiatedTargetNode);
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
		@NonNull SimpleNode[] partNodes = new @NonNull SimpleNode[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		SimpleNode operationNode = createConnectedOperationNode(ClassUtil.nonNullState(collectionLiteralExp.getKind().toString()), collectionLiteralExp, partNodes);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitCollectionItem(@NonNull CollectionItem collectionItem) {
		return analyze(collectionItem.getOwnedItem());
	}
	
	private static final @Nullable String @NonNull [] rangeArgNames = new @Nullable String[]{"«first»", "«last»"};

	@Override
	public @NonNull SimpleNode visitCollectionRange(@NonNull CollectionRange collectionRange) {
		SimpleNode firstNode = analyze(collectionRange.getOwnedFirst());
		SimpleNode lastNode = analyze(collectionRange.getOwnedLast());
		SimpleNode operationNode = createConnectedOperationNode("..", rangeArgNames, collectionRange, firstNode, lastNode);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitElement(@NonNull Element element) {
		Class oclInvalidType = scheduler.getStandardLibrary().getOclInvalidType();
		ClassDatumAnalysis classDatumAnalysis = scheduler.getClassDatumAnalysis(oclInvalidType, scheduler.getDomainAnalysis().getPrimitiveTypeModel());
		SimpleNode errorNode = createErrorNode("«error»", classDatumAnalysis);
		for (EObject eObject : element.eContents()) {
			SimpleNode node = analyze((Visitable) eObject);
			createArgumentEdge(node, "?", errorNode);
		}
		return errorNode;
	}
	
	private static final @Nullable String @NonNull [] ifArgNames = new @Nullable String[]{"«condition»", "«then»", "«else»"};

	@Override
	public @NonNull SimpleNode visitIfExp(@NonNull IfExp ifExp) {
		ExpressionAnalyzer conditionalExpressionAnalyzer = getConditionalExpressionAnalyzer();
		SimpleNode conditionNode = analyze(ifExp.getOwnedCondition());
		SimpleNode thenNode = conditionalExpressionAnalyzer.analyze(ifExp.getOwnedThen());
		SimpleNode elseNode = conditionalExpressionAnalyzer.analyze(ifExp.getOwnedElse());
		SimpleNode ifNode = createConnectedOperationNode("if", ifArgNames, ifExp, conditionNode, thenNode, elseNode);
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
			SimpleNode varNode = createLetNode(ownedVariable, initNode);
			Property castProperty = scheduler.getCastProperty(type);
			createNavigationEdge(initNode, castProperty, varNode);
		}
		return analyze(letExp.getOwnedIn());
	}

	@Override
	public @NonNull SimpleNode visitLiteralExp(@NonNull LiteralExp literalExp) {
		SimpleNode operationNode = createOperationNode(ClassUtil.nonNullState(literalExp.toString()), literalExp);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitLoopExp(@NonNull LoopExp loopExp) {
		assert !loopExp.isIsSafe();
		SimpleNode sourceNode = analyze(loopExp.getOwnedSource());
		List<@NonNull Variable> ownedIterators = ClassUtil.nullFree(loopExp.getOwnedIterators());
		@NonNull SimpleNode[] argNodes = new @NonNull SimpleNode[1+ownedIterators.size()+(loopExp instanceof IterateExp ? 1 : 0)];
		int i = 1;
		for (@NonNull Variable iterator : ownedIterators) {
			SimpleNode iteratorNode = createIteratorNode(iterator, sourceNode);
			Type iteratorType = iterator.getType();
			assert iteratorType != null;
//			Property iterateProperty = context.getSchedulerConstants().getIterateProperty(iteratorType);
			createIteratedEdge(sourceNode, iteratorNode);
			argNodes[i++] = iteratorNode;
		}
		if (loopExp instanceof IterateExp) {
			Variable accumulator = ((IterateExp)loopExp).getOwnedResult();
			assert accumulator != null;
			SimpleNode iteratorNode = createIteratorNode(accumulator, sourceNode);
			Type iteratorType = accumulator.getType();
			assert iteratorType != null;
//			Property iterateProperty = context.getSchedulerConstants().getIterateProperty(iteratorType);
			createIteratedEdge(sourceNode, iteratorNode);
			argNodes[i++] = iteratorNode;
		}
		SimpleNode bodyNode = analyze(loopExp.getOwnedBody());
		argNodes[0] = bodyNode;
		String iterationName = "«" + loopExp.getReferredIteration().getName() + "»";
		SimpleNode accumulateNode = createOperationNode(iterationName, loopExp, argNodes);
		createArgumentEdge(sourceNode, "«source»", accumulateNode);
		createArgumentEdge(bodyNode, "«body»", accumulateNode);
		i = 1;
		for (@NonNull Variable iterator : ownedIterators) {
			SimpleNode iteratorNode = argNodes[i++];
			assert iteratorNode != null;
			createArgumentEdge(iteratorNode, iterator.getName() , accumulateNode);
		}
//		SimpleNode resultNode = Nodes.RESULT.createSimpleNode(context, "«result»", loopExp, sourceNode);
//		createArgument(accumulateNode, null, resultNode);
		return accumulateNode;
	}

	@Override
	public @NonNull SimpleNode visitMapLiteralExp(@NonNull MapLiteralExp mapLiteralExp) {
		List<MapLiteralPart> ownedParts = mapLiteralExp.getOwnedParts();
		int iSize = ownedParts.size();
		@NonNull SimpleNode[] partNodes = new @NonNull SimpleNode[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		SimpleNode operationNode = createConnectedOperationNode(ClassUtil.nonNullState(mapLiteralExp.getName()), mapLiteralExp, partNodes);
		return operationNode;
	}
	
	private static final @Nullable String @NonNull [] mapArgNames = new @Nullable String[]{"«key»", "«value»"};


	@Override
	public @NonNull SimpleNode visitMapLiteralPart(@NonNull MapLiteralPart mapLiteralPart) {
		OCLExpression ownedValue = mapLiteralPart.getOwnedValue();
		assert ownedValue != null;
		SimpleNode keyNode = analyze(mapLiteralPart.getOwnedKey());
		SimpleNode valueNode = analyze(ownedValue);
		SimpleNode operationNode = createConnectedOperationNode("Part", mapArgNames, ownedValue, keyNode, valueNode);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		Property property = QVTcoreBaseUtil.getTargetProperty(asNavigationAssignment);
		assert property != null;
		SimpleNode slotNode = analyze(asNavigationAssignment.getSlotExpression());
		assert slotNode.isClassNode();
		SimpleNode valueNode = analyze(asNavigationAssignment.getValue());
//		if (!valueNode.isClassNode() && !valueNode.isNull()) {
		if (valueNode.isExpression()) {
			SimpleNode computedValueNode = valueNode;
			Type type = property.getType();
			if (type instanceof DataType) {
				valueNode = context.getAssignedAttributeNode(slotNode, property);
				createRealizedArgumentEdge(computedValueNode, null, valueNode);
			}
			else {
				String name = property.getName();
				assert (name != null) && (type != null);
				valueNode = createPredicatedClassNode(slotNode, asNavigationAssignment);
				createArgumentEdge(computedValueNode, null, valueNode);
			}
		}
		SimpleNavigationEdge navigationEdge = slotNode.getNavigationEdge(property);
		CompleteClass valueCompleteClass = valueNode.getCompleteClass();
		Type propertyType = ClassUtil.nonNullState(property.getType());
		CompleteClass targetCompleteClass = scheduler.getEnvironmentFactory().getCompleteModel().getCompleteClass(propertyType);
		if (!valueCompleteClass.conformsTo(targetCompleteClass)) {
			if (targetCompleteClass.getPrimaryClass().getESObject() != EcorePackage.Literals.EOBJECT) {		// FIXME fudge for Adolfo's suspect tests
				// FIXME we could synthesize a cast, but it's easier to do oclAsType() in QVTm/QVTp
				if (!valueCompleteClass.conformsTo(targetCompleteClass)) {
					throw new IllegalStateException("Incompatible types for " + asNavigationAssignment);
				}
			}
		}
		context.addAssignmentEdge(slotNode, property, valueNode);
		Property oppositeProperty = property.getOpposite();
		if (valueNode.isClassNode() && (oppositeProperty != null) && !oppositeProperty.isIsMany()) {
			context.addAssignmentEdge(valueNode, oppositeProperty, slotNode);
		}
		if (navigationEdge != null) {
			context.mergeInto(navigationEdge.getTarget(), valueNode);
		}
		return slotNode;
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
				addPredicateEdge(sourceReferenceNode, referredProperty, attributeNode);
				return attributeNode;
			}
			else {
				String name = referredProperty.getName();
				assert (name != null) && (type != null);
				SimpleNode targetReferenceNode = createStepNode(name, navigationCallExp, sourceNode);
				addPredicateEdge(sourceReferenceNode, referredProperty, targetReferenceNode);
				return targetReferenceNode;
			}
		}
		return context.getUnknownNode(ownedSource);
	}

	@Override
	public @NonNull SimpleNode visitNullLiteralExp(@NonNull NullLiteralExp nullLiteralExp) {
		return createNullNode(nullLiteralExp);
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
		String operationName = ClassUtil.nonNullState(referredOperation.getName());
		if (ownedSource == null) {
			List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
			int iSize = ownedArguments.size();
			@NonNull SimpleNode[] argNodes = new @NonNull SimpleNode[iSize];
			for (int i = 0; i < iSize; i++) {
				argNodes[i] = analyze(ownedArguments.get(i));
			}
			SimpleNode operationNode = createConnectedOperationNode(operationName, operationCallExp, argNodes);
			return operationNode;
		}
		SimpleNode sourceNode = analyze(ownedSource);
		OperationId operationId = referredOperation.getOperationId();
		// FIXME "=" can identify that LHS and RHS can be coalesced
		// FIXME "includes" may also indicate a coalesce
		if (operationId == scheduler.getOclAnyOclAsTypeId()) {
			return analyzeOperationCallExp_oclAsType(sourceNode, operationCallExp);
		}
		else if (PivotUtil.isSameOperation(operationId, scheduler.getOclElementOclContainerId())) {
			return analyzeOperationCallExp_oclContainer(sourceNode, operationCallExp);
		}
		else if (PivotUtil.isSameOperation(operationId, scheduler.getOclAnyOclIsKindOfId())) {
			return analyzeOperationCallExp_oclIsKindOf(sourceNode, operationCallExp);
		}
		else if ((operationCallExp.eContainer() instanceof Predicate)
			&& (sourceNode.getCompleteClass().getPrimaryClass() instanceof CollectionType)
			&& ("includes".equals(operationName) || "includesAll".equals(operationName))) {
			return analyzeOperationCallExp_includes(sourceNode, operationCallExp);
		}
		else {
			List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
			int iSize = ownedArguments.size();
			@NonNull SimpleNode[] argNodes = new @NonNull SimpleNode[iSize+1];
			argNodes[0] = sourceNode;
			for (int i = 0; i < iSize; i++) {
				argNodes[i+1] = analyze(ownedArguments.get(i));
			}
			if ("<>".equals(operationName)) {
				operationName.toString();
			}
			SimpleNode operationNode = findOperationNode(operationName, argNodes);
			if (operationNode == null) {
				operationNode = createOperationNode(operationName, operationCallExp, argNodes);
				for (int i = 0; i <= iSize; i++) {
					createArgumentEdge(argNodes[i], /*iSize > 1 ?*/ "«arg" + i + "»"/*: null*/, operationNode);
				}
				if (referredOperation.getBodyExpression() != null) {
					OperationRegion operationRegion = context.getSuperRegion().analyzeOperation(operationCallExp);
					List<@NonNull Node> extraNodes = operationRegion.getExtraNodes();
					if (extraNodes.size() > 0) {
						for (@NonNull Node extraNode : extraNodes) {
							ClassDatumAnalysis classDatumAnalysis = extraNode.getClassDatumAnalysis();
							SimpleNode extraGuard = context.getExtraGuard(classDatumAnalysis);
							if (extraGuard == null) {
								extraGuard = context.createExtraGuard(classDatumAnalysis);
								createArgumentEdge(extraGuard, extraGuard.getName(), operationNode);
								instantiate(extraGuard, extraNode);
							}
						}
					}
				}
			}
			else {
				operationNode.addTypedElement(operationCallExp);
				if ("<>".equals(operationName)) {
					operationName.toString();
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
	public @NonNull SimpleNode visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
	}

	@Override
	public @NonNull SimpleNode visitPropertyAssignment(@NonNull PropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
	}

	@Override
	public @NonNull SimpleNode visitShadowExp(@NonNull ShadowExp shadowExp) {
		List<ShadowPart> ownedParts = shadowExp.getOwnedParts();
		int iSize = ownedParts.size();
		@NonNull SimpleNode[] partNodes = new @NonNull SimpleNode[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		SimpleNode operationNode = createConnectedOperationNode(ClassUtil.nonNullState(shadowExp.getType().getName()), shadowExp, partNodes);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitShadowPart(@NonNull ShadowPart shadowPart) {
		SimpleNode partNode = analyze(shadowPart.getOwnedInit());
		SimpleNode operationNode = createConnectedOperationNode(ClassUtil.nonNullState(shadowPart.getName()), shadowPart, partNode);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitTupleLiteralExp(@NonNull TupleLiteralExp tupleLiteralExp) {
		List<TupleLiteralPart> ownedParts = tupleLiteralExp.getOwnedParts();
		int iSize = ownedParts.size();
		@NonNull SimpleNode[] partNodes = new @NonNull SimpleNode[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		SimpleNode operationNode = createConnectedOperationNode(ClassUtil.nonNullState(tupleLiteralExp.getName()), tupleLiteralExp, partNodes);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitTupleLiteralPart(@NonNull TupleLiteralPart tupleLiteralPart) {
		SimpleNode partNode = analyze(tupleLiteralPart.getOwnedInit());
		SimpleNode operationNode = createConnectedOperationNode(ClassUtil.nonNullState(tupleLiteralPart.getName()), tupleLiteralPart, partNode);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitTypeExp(@NonNull TypeExp typeExp) {
		DomainUsage domainUsage = scheduler.getDomainUsage(typeExp);
		Type referredType = typeExp.getReferredType();
		assert referredType != null;
		TypedModel typedModel = domainUsage.getTypedModel(typeExp);
		assert typedModel != null;
		ClassDatumAnalysis classDatumAnalysis = scheduler.getClassDatumAnalysis((org.eclipse.ocl.pivot.Class)referredType, typedModel);
		String typeName = PrettyPrinter.printType(classDatumAnalysis.getCompleteClass());
		SimpleNode operationNode = createConnectedOperationNode(typeName, typeExp);
		return operationNode;
	}

	@Override
	public @NonNull SimpleNode visitVariableExp(@NonNull VariableExp variableExp) {
		VariableDeclaration referredVariable = variableExp.getReferredVariable();
		assert referredVariable != null;
		return context.getReferenceNode(referredVariable);
	}
}