/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtb2qvts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
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
import org.eclipse.ocl.pivot.EnumLiteralExp;
import org.eclipse.ocl.pivot.EnumerationLiteral;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.IntegerLiteralExp;
import org.eclipse.ocl.pivot.IterateExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LetExp;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.MapLiteralExp;
import org.eclipse.ocl.pivot.MapLiteralPart;
import org.eclipse.ocl.pivot.MapType;
import org.eclipse.ocl.pivot.NavigationCallExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.NumericLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.RealLiteralExp;
import org.eclipse.ocl.pivot.ShadowExp;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.StringLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralExp;
import org.eclipse.ocl.pivot.TupleLiteralPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypeExp;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.ids.OperationId;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.util.AbstractExtendingQVTbaseVisitor;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseLibraryHelper;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowNode;
import org.eclipse.qvtd.pivot.qvtschedule.TupleLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.MapLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.MappingNode;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

public abstract class ExpressionSynthesizer extends AbstractExtendingQVTbaseVisitor<@Nullable Node, @NonNull RuleAnalysis>
{
	//	private static final @NonNull String @NonNull [] ifArgNames = new @NonNull String[]{QVTscheduleConstants.IF_CONDITION_NAME, QVTscheduleConstants.IF_THEN_NAME, QVTscheduleConstants.IF_ELSE_NAME};
	//	private static final @NonNull String @NonNull [] mapArgNames = new @NonNull String[]{"«key»", "«value»"};
	//	private static final @NonNull String @NonNull [] nullArgNames = new @NonNull String[]{QVTscheduleConstants.EQUALS_NAME};
	//	private static final @NonNull String @NonNull [] rangeArgNames = new @NonNull String[]{"«first»", "«last»"};
	//	private static final @NonNull String @NonNull [] srcArgNames = new @NonNull String[]{"«source»", "«arg»"};

	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull QVTbaseHelper helper;
	protected final @NonNull StandardLibraryHelper standardLibraryHelper;
	protected final @NonNull QVTbaseLibraryHelper qvtbaseLibraryHelper;
	private /*@LazyNonNull*/ ExpressionSynthesizer conditionalExpressionSynthesizer = null;
	private /*@LazyNonNull*/ ExpressionSynthesizer requiredExpressionSynthesizer = null;
	//	private /*@LazyNonNull*/ OperationDependencyAnalysis operationDependencyAnalysis;

	/**
	 * Map from the non-trivial side of an "=" expression to the known node for a variable on the other side. This avoids the need to create a redundant
	 * node for the other side with an «equals» edge to tie them together.
	 */
	private @Nullable Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode;

	protected ExpressionSynthesizer(@NonNull RuleAnalysis context) {
		super(context);
		this.scheduleManager = context.getScheduleManager();
		this.environmentFactory = scheduleManager.getEnvironmentFactory();
		this.helper = new QVTbaseHelper(environmentFactory);
		this.standardLibraryHelper = scheduleManager.getStandardLibraryHelper();
		this.qvtbaseLibraryHelper = scheduleManager.getQVTbaseLibraryHelper();
		//		this.operationDependencyAnalysis = getOperationDependencyAnalysis();
	}

	protected @NonNull Node createBooleanLiteralNode(boolean booleanValue, @NonNull BooleanLiteralExp booleanLiteralExp) {
		return context.createBooleanLiteralNode(isUnconditional(), booleanValue, booleanLiteralExp);
	}

	public @NonNull NavigableEdge createCastEdge(@NonNull Node sourceNode, @NonNull Property castProperty, @NonNull Node castNode) {
		return context.createCastEdge(sourceNode, castProperty, castNode);
	}

	protected @NonNull Node createCollectionLiteral(@NonNull CollectionLiteralExp collectionLiteralExp, @NonNull CollectionLiteralPart [] collectionParts, @NonNull Node @NonNull [] partNodes) {
		Operation collectionOperation = qvtbaseLibraryHelper.getCollectionOperation();
		assert collectionParts.length == partNodes.length;
		Node reusedNode = findOperationNode(collectionOperation, partNodes);
		if (reusedNode != null) {
			//			reusedNode.addTypedElement(collectionLiteralExp);
			return reusedNode;
		}
		String nodeName = CompilerUtil.recoverVariableName(collectionLiteralExp);
		if (nodeName == null) {
			nodeName = QVTbaseUtil.getName(collectionOperation);
		}
		CollectionLiteralNode collectionLiteralNode = context.createCollectionLiteralNode(isUnconditional(), nodeName, collectionLiteralExp, partNodes);
		for (int i = 0; i < collectionParts.length; i++) {
			context.createCollectionPartEdge(partNodes[i], collectionParts[i], collectionLiteralNode);
		}
		return collectionLiteralNode;
	}

	protected @NonNull Node createCollectionRange(@NonNull CollectionRange collectionRange, @NonNull Node firstNode, @NonNull Node lastNode) {
		Operation rangeOperation = qvtbaseLibraryHelper.getRangeOperation();
		@NonNull Node[] sourceAndArgumentNodes = new @NonNull Node[] { firstNode, lastNode };
		Node reusedNode = findOperationNode(rangeOperation, sourceAndArgumentNodes);
		if (reusedNode != null) {
			//			reusedNode.addTypedElement(collectionRange);
			return reusedNode;
		}
		String nodeName = CompilerUtil.recoverVariableName(collectionRange);
		if (nodeName == null) {
			nodeName = QVTbaseUtil.getName(rangeOperation);
		}
		Node operationNode = context.createCollectionRangeNode(isUnconditional(), nodeName, collectionRange, sourceAndArgumentNodes);
		Parameter firstParameter = qvtbaseLibraryHelper.getRangeFirstParameter();
		Parameter lastParameter = qvtbaseLibraryHelper.getRangeLastParameter();
		createOperationParameterEdge(firstNode, firstParameter, -1, operationNode);
		createOperationParameterEdge(lastNode, lastParameter, -1, operationNode);
		return operationNode;
	}

	protected abstract @NonNull ExpressionSynthesizer createConditionalExpressionSynthesizer();

	protected @NonNull Node createDataTypeNode(@NonNull String name, @NonNull Node sourceNode, @NonNull NavigationCallExp navigationCallExp) {
		return context.createDataTypeNode(name, sourceNode, navigationCallExp);
	}

	protected @NonNull Edge createDependencyEdge(@NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		return context.createDependencyEdge(sourceNode, name, targetNode);
	}

	protected @NonNull Node createDependencyNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		return context.createDependencyNode(name, classDatum);
	}

	protected @NonNull EnumLiteralNode createEnumLiteralNode(@NonNull EnumerationLiteral enumValue, @NonNull EnumLiteralExp enumLiteralExp) {
		return context.createEnumLiteralNode(isUnconditional(), enumValue, enumLiteralExp);
	}

	protected @NonNull Node createErrorNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		return context.createErrorNode(name, classDatum);
	}

	protected @NonNull Edge createEqualsEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		return context.createEqualsEdge(sourceNode, targetNode);
	}

	protected @NonNull Node createIf(@NonNull IfExp ifExp, @NonNull Node selfNode, @NonNull Node thenNode, @NonNull Node elseNode) {
		Operation ifOperation = qvtbaseLibraryHelper.getIfOperation();
		@NonNull Node [] sourceAndArgumentNodes = new @NonNull Node[] { selfNode, thenNode, elseNode };
		Node reusedNode = findOperationNode(ifOperation, sourceAndArgumentNodes);
		if (reusedNode != null) {
			//			reusedNode.addTypedElement(ifExp);
			return reusedNode;
		}
		String nodeName = CompilerUtil.recoverVariableName(ifExp);
		if (nodeName == null) {
			nodeName = QVTbaseUtil.getName(ifOperation);
		}
		//		Node operationNode = nestedAnalyzer.createOperationNode(nodeName, typedElement, sourceAndArgumentNodes);
		Node operationNode = context.createIfNode(isUnconditional(), nodeName, ifExp, sourceAndArgumentNodes);
		//	org.eclipse.ocl.pivot.Class selfType = standardLibraryHelper.getStandardLibrary().getBooleanType();
		Parameter conditionParameter = qvtbaseLibraryHelper.getIfConditionParameter();
		Parameter thenParameter = qvtbaseLibraryHelper.getIfThenParameter();
		Parameter elseParameter = qvtbaseLibraryHelper.getIfElseParameter();
		//		createOperationSelfEdge(selfNode, selfType, operationNode);
		createOperationParameterEdge(selfNode, conditionParameter, -1, operationNode);
		createOperationParameterEdge(thenNode, thenParameter, -1, operationNode);
		createOperationParameterEdge(elseNode, elseParameter, -1, operationNode);
		return operationNode;
	}

	protected @NonNull Edge createIteratedEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		return context.createIteratedEdge(sourceNode, targetNode);
	}

	protected @NonNull Node createIteratorNode(@NonNull Variable iterator, @NonNull Node sourceNode) {
		return context.createIteratorNode(iterator, sourceNode);
	}

	protected @NonNull Node createLetNode(@NonNull Variable letVariable, @NonNull Node inNode) {
		return context.createLetVariableNode(letVariable, inNode);
	}

	protected @NonNull Node createMapLiteral(@NonNull MapLiteralExp mapLiteralExp, @NonNull MapLiteralPart [] mapParts, @NonNull Node @NonNull [] partNodes) {
		assert mapParts.length == partNodes.length;
		Operation mapOperation = qvtbaseLibraryHelper.getMapOperation();
		Node reusedNode = findOperationNode(mapOperation, partNodes);
		if (reusedNode != null) {
			//			reusedNode.addTypedElement(mapLiteralExp);
			return reusedNode;
		}
		String nodeName = CompilerUtil.recoverVariableName(mapLiteralExp);
		if (nodeName == null) {
			nodeName = QVTbaseUtil.getName(mapOperation);
		}
		MapLiteralNode mapLiteralNode = context.createMapLiteralNode(isUnconditional(), nodeName, mapLiteralExp, partNodes);
		for (int i = 0; i < mapParts.length; i++) {
			context.createMapPartEdge(partNodes[i], mapParts[i], mapLiteralNode);
		}
		return mapLiteralNode;
	}

	protected @NonNull Node createNavigableDataTypeNode(@NonNull Node targetNode, @NonNull NavigationAssignment navigationAssignment) {
		return context.createDataTypeNode(targetNode, navigationAssignment);
	}

	protected @NonNull Node createMapPart(@NonNull MapLiteralPart mapLiteralPart, @NonNull Node keyNode, @NonNull Node valueNode) {
		TypedElement typedElement = QVTbaseUtil.getOwnedValue(mapLiteralPart);		// FIXME use real object
		Operation partOperation = qvtbaseLibraryHelper.getMapPartOperation();
		@NonNull Node[] subPartNodes = new @NonNull Node[] { keyNode, valueNode };
		Node reusedNode = findOperationNode(partOperation, subPartNodes);
		if (reusedNode != null) {
			//			reusedNode.addTypedElement(typedElement);
			return reusedNode;
		}
		String nodeName = CompilerUtil.recoverVariableName(typedElement);
		if (nodeName == null) {
			nodeName = QVTbaseUtil.getName(partOperation);
		}
		Node operationNode = context.createMapPartNode(isUnconditional(), nodeName, mapLiteralPart, subPartNodes);
		Parameter keyParameter = qvtbaseLibraryHelper.getMapPartKeyParameter();
		Parameter valueParameter = qvtbaseLibraryHelper.getMapPartValueParameter();
		createOperationParameterEdge(keyNode, keyParameter, -1, operationNode);
		createOperationParameterEdge(valueNode, valueParameter, -1, operationNode);
		return operationNode;
	}

	protected @NonNull Node createNavigableDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		assert sourceNode.isMatched();
		return context.createDataTypeNode(sourceNode, source2targetProperty);
	}

	protected @NonNull NavigableEdge createNavigableNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		return context.createNavigationEdge(sourceNode, source2targetProperty, targetNode, false);
	}

	protected @NonNull NavigableEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		return context.createNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
	}

	protected @NonNull NavigableEdge createNavigationOrRealizedEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		NavigableEdge navigationEdge = sourceNode.getNavigableEdge(source2targetProperty);
		assert navigationEdge == null;
		Boolean isPartial = navigationAssignment != null ? navigationAssignment.isIsPartial() : null;
		if ((navigationAssignment != null) || context.isPropertyAssignment(sourceNode, source2targetProperty)) {
			navigationEdge = createRealizedNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
		}
		else {
			navigationEdge = createNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
		}
		return navigationEdge;
	}

	protected @NonNull Node createNullLiteralNode() {
		return context.createNullLiteralNode(isUnconditional(), null);
	}

	protected @NonNull Node createNullLiteralNode(@NonNull NullLiteralExp nullLiteralExp) {
		return context.createNullLiteralNode(isUnconditional(), nullLiteralExp);
	}

	protected @NonNull Node createNumericLiteralNode(@NonNull Number numberValue, @NonNull NumericLiteralExp numericLiteralExp) {
		return context.createNumericLiteralNode(isUnconditional(), numberValue, numericLiteralExp);
	}

	protected @NonNull Node createOperationCallNode(@NonNull CallExp callExp, @NonNull Operation operation, @NonNull Node @NonNull [] sourceAndArgumentNodes) {
		Node reusedNode = findOperationNode(operation, sourceAndArgumentNodes);
		if (reusedNode != null) {
			//			reusedNode.addTypedElement(callExp);
			return reusedNode;
		}
		String nameHint = CompilerUtil.recoverVariableName(callExp);
		Node operationNode = context.createOperationCallNode(isUnconditional(), nameHint, operation, callExp, sourceAndArgumentNodes);
		return operationNode;
	}
	protected @NonNull Node createOperationCallNode2(@NonNull String nameHint, @NonNull Role nodeRole, @NonNull Operation operation, @NonNull ClassDatum classDatum, @NonNull Node @NonNull ... sourceAndArgumentNodes) {
		Node operationNode = context.createOperationCallNode2(nodeRole, isUnconditional(), nameHint, operation, classDatum, sourceAndArgumentNodes);
		return operationNode;
	}

	protected @NonNull Edge createOperationParameterEdge(@NonNull Node sourceNode, @NonNull Parameter parameter, int parameterIndex, @NonNull Node targetNode) {
		return context.createOperationParameterEdge(sourceNode, parameter, parameterIndex, targetNode);
	}

	protected @NonNull Edge createOperationSelfEdge(@NonNull Node sourceNode, @NonNull Type type, @NonNull Node targetNode) {
		return context.createOperationSelfEdge(sourceNode, type, targetNode);
	}

	protected @NonNull Edge createPredicateEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		return context.createPredicateEdge(sourceNode, name, targetNode);
	}

	protected @NonNull Node createPredicatedClassNode(@NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
		return context.createDependencyClassNode(parentNode, navigationAssignment);
	}

	protected @NonNull Node createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		return context.createRealizedDataTypeNode(sourceNode, source2targetProperty);
	}

	protected @NonNull NavigableEdge createRealizedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		return context.createRealizedNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
	}

	protected abstract @NonNull ExpressionSynthesizer createRequiredExpressionSynthesizer();

	protected @NonNull Node createShadow(@NonNull ShadowExp shadowExp, @NonNull ShadowPart [] shadowParts, @NonNull Node @NonNull [] partNodes) {
		assert shadowParts.length == partNodes.length;
		Operation shadowOperation = qvtbaseLibraryHelper.getShadowOperation();
		Node reusedNode = findOperationNode(shadowOperation, partNodes);
		if (reusedNode != null) {
			//			reusedNode.addTypedElement(shadowExp);
			return reusedNode;
		}
		String nodeName = CompilerUtil.recoverVariableName(shadowExp);
		if (nodeName == null) {
			nodeName = QVTbaseUtil.getName(shadowOperation);
		}
		ShadowNode shadowLiteralNode = context.createShadowNode(isUnconditional(), nodeName, shadowExp, partNodes);
		for (int i = 0; i < shadowParts.length; i++) {
			context.createShadowPartEdge(partNodes[i], shadowParts[i], shadowLiteralNode);
		}
		return shadowLiteralNode;
	}

	protected @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode) {
		return context.createStepNode(name, callExp, sourceNode, sourceNode.isMatched() && QVTscheduleUtil.isMatched(callExp));
	}

	protected @NonNull Node createStringLiteralNode(@NonNull String stringValue, @NonNull StringLiteralExp stringLiteralExp) {
		return context.createStringLiteralNode(isUnconditional(), stringValue, stringLiteralExp);
	}

	protected @NonNull Node createTupleLiteral(@NonNull TupleLiteralExp tupleLiteralExp, @NonNull TupleLiteralPart [] tupleParts, @NonNull Node @NonNull [] partNodes) {
		assert tupleParts.length == partNodes.length;
		Operation tupleOperation = qvtbaseLibraryHelper.getTupleOperation();
		Node reusedNode = findOperationNode(tupleOperation, partNodes);
		if (reusedNode != null) {
			//			reusedNode.addTypedElement(tupleLiteralExp);
			return reusedNode;
		}
		String nodeName = CompilerUtil.recoverVariableName(tupleLiteralExp);
		if (nodeName == null) {
			nodeName = QVTbaseUtil.getName(tupleOperation);
		}
		TupleLiteralNode tupleLiteralNode = context.createTupleLiteralNode(isUnconditional(), nodeName, tupleLiteralExp, partNodes);
		for (int i = 0; i < tupleParts.length; i++) {
			context.createTuplePartEdge(partNodes[i], tupleParts[i], tupleLiteralNode);
		}
		return tupleLiteralNode;
	}

	protected @NonNull TypeLiteralNode createTypeLiteralNode(@NonNull Type typeValue, @NonNull TypeExp typeExp) {
		return context.createTypeLiteralNode(isUnconditional(), typeValue, typeExp);
	}

	protected @NonNull Node doLoopExp(@NonNull LoopExp loopExp, @NonNull Node sourceNode) {
		List<@NonNull Variable> ownedIterators = ClassUtil.nullFree(loopExp.getOwnedIterators());
		@NonNull Node[] argNodes = new @NonNull Node[1+ownedIterators.size()+(loopExp instanceof IterateExp ? 1 : 0)];
		int i = 1;
		for (@NonNull Variable iterator : ownedIterators) {
			Node iteratorNode = createIteratorNode(iterator, sourceNode);
			@SuppressWarnings("unused")
			Type iteratorType = QVTbaseUtil.getType(iterator);
			//			Property iterateProperty = context.getScheduleModel().getIterateProperty(iteratorType);
			createIteratedEdge(sourceNode, iteratorNode);
			argNodes[i++] = iteratorNode;
		}
		if (loopExp instanceof IterateExp) {
			Variable accumulator = QVTbaseUtil.getOwnedResult((IterateExp)loopExp);
			Node iteratorNode = createIteratorNode(accumulator, sourceNode);
			@SuppressWarnings("unused")
			Type iteratorType = QVTbaseUtil.getType(accumulator);
			//			Property iterateProperty = context.getScheduleModel().getIterateProperty(iteratorType);
			createIteratedEdge(sourceNode, iteratorNode);
			argNodes[i++] = iteratorNode;
		}
		Node bodyNode = getConditionalExpressionSynthesizer().synthesize(loopExp.getOwnedBody());
		argNodes[0] = bodyNode;
		Iteration referredIteration = QVTbaseUtil.getReferredIteration(loopExp);
		//		String iterationName = "«" + referredIteration.getName() + "»";
		Node accumulateNode = createOperationCallNode(loopExp, referredIteration, argNodes);
		createOperationParameterEdge(sourceNode, qvtbaseLibraryHelper.getLoopSourceParameter(), -1, accumulateNode);
		createOperationParameterEdge(bodyNode, qvtbaseLibraryHelper.getLoopBodyParameter(), -1, accumulateNode);
		for (int j = 1 ; j <= ownedIterators.size(); j++) {
			@NonNull Node iteratorNode = argNodes[j];
			//			createExpressionEdge(iteratorNode, "«" + iterator.getName() + "»", accumulateNode);
			//			createArgumentEdge(iteratorNode, iterator, -1 accumulateNode);
			createOperationParameterEdge(iteratorNode, qvtbaseLibraryHelper.getLoopIteratorsParameter(), j-1, accumulateNode);
		}
		return accumulateNode;
	}

	protected @NonNull Node doNavigationCallExp(@NonNull NavigationCallExp navigationCallExp, @NonNull Node sourceNode) {
		Property referredProperty = QVTbaseUtil.getReferredProperty(navigationCallExp);
		if (sourceNode.isClass()) {
			if (!referredProperty.isIsMany()) {
				NavigableEdge navigationEdge = sourceNode.getNavigableEdge(referredProperty);
				if (navigationEdge != null) {
					return navigationEdge.getEdgeTarget();
				}
			}
			String name = CompilerUtil.recoverVariableName(navigationCallExp);
			if (name == null) {
				name = QVTbaseUtil.getName(referredProperty);
			}
			Type type = QVTbaseUtil.getType(referredProperty);
			Node targetNode = expression2knownNode != null ? expression2knownNode.get(navigationCallExp) : null;
			if (targetNode == null) {
				if (type instanceof DataType) {
					targetNode = sourceNode.getNavigableTarget(referredProperty);
					if (targetNode == null) {
						targetNode = createDataTypeNode(name, sourceNode, navigationCallExp);
					}
				}
				else {
					targetNode = createStepNode(name, navigationCallExp, sourceNode);
				}
			}
			getNavigationEdge(sourceNode, referredProperty, targetNode, null);
			return targetNode;
		}
		OCLExpression ownedSource = QVTbaseUtil.getOwnedSource(navigationCallExp);
		return context.getUnknownNode(ownedSource);
	}

	protected @Nullable Node doOperationCallExp(@NonNull OperationCallExp operationCallExp, @Nullable Node sourceNode) {
		boolean isMatched = isRequired() || QVTscheduleUtil.isMatched(operationCallExp);
		Operation referredOperation = QVTbaseUtil.getReferredOperation(operationCallExp);
		String operationName = ClassUtil.nonNullState(referredOperation.getName());
		OCLExpression ownedSource = operationCallExp.getOwnedSource();
		if (sourceNode == null) {
			List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
			int iSize = ownedArguments.size();
			@NonNull Node[] argNodes = new @NonNull Node[iSize];
			for (int i = 0; i < iSize; i++) {
				argNodes[i] = synthesize(ownedArguments.get(i));
			}
			ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
			Node operationNode = nestedAnalyzer.createOperationCallNode(operationCallExp, referredOperation, argNodes);
			if (isRequired()) {
				operationNode.setRequired();
			}
			for (int i = 0; i < iSize; i++) {
				Parameter parameter = QVTbaseUtil.getOwnedParameter(referredOperation, i);
				nestedAnalyzer.createOperationParameterEdge(argNodes[i], parameter, -1, operationNode);
			}
			return operationNode;
		}
		assert ownedSource != null;
		OperationId operationId = referredOperation.getOperationId();
		//
		//	"=" is best handled as a single multi-constrained node
		//
		if ((operationCallExp.eContainer() instanceof Predicate)
				&& !(ownedSource.getType() instanceof DataType)
				&& QVTbaseUtil.isSameOperation(operationId, standardLibraryHelper.getOclAnyEqualsId())) {
			return synthesizeOperationCallExp_equals(operationCallExp);
		}
		// FIXME "=" can identify that LHS and RHS can be coalesced
		// FIXME "includes" may also indicate a coalesce
		if (operationId == standardLibraryHelper.getOclAnyOclAsTypeId()) {
			return synthesizeOperationCallExp_oclAsType(sourceNode, operationCallExp);
		}
		else if (QVTbaseUtil.isSameOperation(operationId, standardLibraryHelper.getOclElementOclContainerId())) {
			return synthesizeOperationCallExp_oclContainer(sourceNode, operationCallExp);
		}
		//	else if (QVTbaseUtil.isSameOperation(operationId, standardLibraryHelper.getOclAnyOclIsKindOfId())) {
		//		return synthesizeOperationCallExp_oclIsKindOf(sourceNode, operationCallExp);
		//	}
		else if ((operationCallExp.eContainer() instanceof Predicate)
				&& (sourceNode.getCompleteClass().getPrimaryClass() instanceof CollectionType)
				&& "includes".equals(operationName)) {
			return synthesizeOperationCallExp_includes(sourceNode, operationCallExp);
		}
		else {
			List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
			int iSize = ownedArguments.size();
			@NonNull Node[] argNodes = new @NonNull Node[iSize+1];
			@NonNull String [] argNames = new @NonNull String[iSize+1];
			argNodes[0] = sourceNode;
			argNames[0] = "«self»";
			for (int i = 0; i < iSize; i++) {
				argNodes[i+1] = synthesize(ownedArguments.get(i));
				argNames[i+1] = "«" + referredOperation.getOwnedParameters().get(i).getName() + "»";
			}
			if ("<>".equals(operationName)) {
				operationName.toString();
			}
			Node operationNode = findOperationNode(referredOperation, argNodes);
			if (operationNode == null) {

				operationNode = createOperationCallNode(operationCallExp, referredOperation, argNodes);
				for (int i = 0; i <= iSize; i++) {
					//					createExpressionEdge(argNodes[i], argNames[i], operationNode);
					if (i == 0) {
						createOperationSelfEdge(argNodes[i], QVTbaseUtil.getType(ownedSource), operationNode);
					}
					else {
						createOperationParameterEdge(argNodes[i], QVTbaseUtil.getOwnedParameter(referredOperation, i-1), -1, operationNode);
					}
				}
				if (referredOperation.getBodyExpression() != null) {
					//					QVTm2QVTs qvtm2qvts = (QVTm2QVTs) scheduleManager;		// FIXME cast
					OperationRegion operationRegion = scheduleManager.analyzeOperation(operationCallExp);
					Iterable<@NonNull Node> referenceNodes = QVTscheduleUtil.getDependencyNodes(operationRegion);
					for (@NonNull Node referenceNode : referenceNodes) {
						ClassDatum classDatum = QVTscheduleUtil.getClassDatum(referenceNode);
						Node dependencyHead = context.getDependencyHead(classDatum);
						if (dependencyHead == null) {
							dependencyHead = context.createDependencyHead(classDatum);
							createDependencyEdge(dependencyHead, QVTscheduleUtil.getName(dependencyHead), operationNode);
						}
						instantiate(dependencyHead, referenceNode);
					}
				}
			}
			else {
				operationNode.addOriginatingElement(operationCallExp);
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

	protected @NonNull Node doSafeNavigation(@NonNull CallExp callExp, @NonNull Node sourceNode, @NonNull Node navigationNode) {
		assert callExp.isIsSafe();
		Type unsafeType = callExp.getType();
		assert !(unsafeType instanceof MapType);
		if (unsafeType instanceof CollectionType)  {
			Operation excludingOperation = standardLibraryHelper.getCollectionExcludingOperation();
			Node nullNode = createNullLiteralNode();
			Node excludingNode = createOperationCallNode2("safe"+navigationNode.getName(), QVTscheduleUtil.getNodeRole(navigationNode), excludingOperation, QVTscheduleUtil.getClassDatum(navigationNode), navigationNode, nullNode);
			return excludingNode;
		}
		else {
			Operation equalsOperation = standardLibraryHelper.getOclAnyEqualsOperation();
			Node nullNode1 = createNullLiteralNode();
			Node isNonNullNode = createOperationCallNode2("equals"/*"isSafe"+navigationNode.getName()*/, QVTscheduleUtil.getNodeRole(navigationNode), equalsOperation, scheduleManager.getBooleanClassDatum(), sourceNode, nullNode1);
			createOperationSelfEdge(sourceNode, QVTbaseUtil.getType(QVTbaseUtil.getOwnedSource(callExp)), isNonNullNode);
			createOperationParameterEdge(nullNode1, QVTbaseUtil.getOwnedParameter(equalsOperation, 0), -1, isNonNullNode);
			Node nullNode2 = createNullLiteralNode();
			Operation ifOperation = qvtbaseLibraryHelper.getIfOperation();
			@NonNull Node [] sourceAndArgumentNodes = new @NonNull Node[] { isNonNullNode, navigationNode, nullNode2 };
			String nodeName = QVTbaseUtil.getName(ifOperation);
			Node ifNode = context.createIfNode2(isUnconditional(), nodeName, QVTscheduleUtil.getClassDatum(navigationNode), sourceAndArgumentNodes);
			Parameter conditionParameter = qvtbaseLibraryHelper.getIfConditionParameter();
			Parameter thenParameter = qvtbaseLibraryHelper.getIfThenParameter();
			Parameter elseParameter = qvtbaseLibraryHelper.getIfElseParameter();
			createOperationParameterEdge(isNonNullNode, conditionParameter, -1, ifNode);
			createOperationParameterEdge(nullNode2, thenParameter, -1, ifNode);
			createOperationParameterEdge(navigationNode, elseParameter, -1, ifNode);
			return ifNode;
		}
	}

	// FIXME switch to OPeration argument
	protected @Nullable Node findOperationNode(@NonNull Operation operation, @NonNull Node @NonNull ... sourceAndArgumentNodes) {
		String name = QVTbaseUtil.getName(operation);
		if (sourceAndArgumentNodes.length > 0) {
			for (@NonNull Edge searchEdge : sourceAndArgumentNodes[0].getComputationEdges()) {
				Node reusedNode = searchEdge.getEdgeTarget();
				if (reusedNode.isOperation()) {
					@SuppressWarnings("unused") OperationNode operationNode = (OperationNode)reusedNode;
					boolean equals1 = name.equals(reusedNode.getName());
					//					boolean equals2 = operation == operationNode.getReferredOperation();
					//					assert equals1 == equals2;
					if (equals1) {
						Iterable<@NonNull Edge> reusedEdges = reusedNode.getArgumentEdges();
						int iSize = Iterables.size(reusedEdges);
						if (iSize == sourceAndArgumentNodes.length) {
							int i = 0;
							for (@NonNull Edge reusedEdge : reusedEdges) {
								Node reusedArgumentNode = reusedEdge.getEdgeSource();
								if (reusedArgumentNode != sourceAndArgumentNodes[i]) {
									break;
								}
								i++;
							}
							if (i == iSize) {
								return reusedNode;
							}
						}
					}
				}
			}
		}
		return null;
	}

	private @NonNull ExpressionSynthesizer getConditionalExpressionSynthesizer() {
		ExpressionSynthesizer conditionalExpressionSynthesizer2 = conditionalExpressionSynthesizer;
		if (conditionalExpressionSynthesizer2 == null) {
			conditionalExpressionSynthesizer = conditionalExpressionSynthesizer2 = createConditionalExpressionSynthesizer();
		}
		return conditionalExpressionSynthesizer2;
	}

	/*	protected @NonNull OperationDependencyAnalysis getOperationDependencyAnalysis() {
		OperationDependencyAnalysis operationDependencyAnalysis2 = operationDependencyAnalysis;
		if (operationDependencyAnalysis2 == null) {
			operationDependencyAnalysis = operationDependencyAnalysis2 = new OperationDependencyAnalysis(environmentFactory, scheduler.getDomainAnalysis());
		}
		return operationDependencyAnalysis2;
	} */

	/**
	 * Return the navigation edge suitable for navigating from sourceNode to targetNode via source2targetProperty,
	 * re-using an already created edge if available, otherwise creating the edge.
	 */
	protected @NonNull NavigableEdge getNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		if (targetNode.isNullLiteral()) {
			return getNavigationEdgeToNull(sourceNode, source2targetProperty, targetNode, navigationAssignment);
		}
		else if (targetNode.isClass() && !targetNode.isOperation()) {		// FIXME rationalize isXXX tests
			return getNavigationEdgeToClass(sourceNode, source2targetProperty, targetNode, navigationAssignment);
		}
		else if (targetNode.isDataType()) {
			return getNavigationEdgeToDataType(sourceNode, source2targetProperty, targetNode, navigationAssignment);
		}
		else {
			return getNavigationEdgeToExpression(sourceNode, source2targetProperty, targetNode, navigationAssignment);
		}
	}

	protected @NonNull NavigableEdge getNavigationEdgeToDataType(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		assert targetNode.isDataType();
		Type type = source2targetProperty.getType();
		assert type instanceof DataType;
		NavigableEdge navigationEdge = sourceNode.getNavigableEdge(source2targetProperty);
		if (navigationEdge == null) {
			if (!targetNode.isOperation()) {
				navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
			}
			else {
				CompleteClass propertyCompleteClass = scheduleManager.getClassDatum(source2targetProperty).getCompleteClass();
				CompleteClass valueCompleteClass = targetNode.getCompleteClass();
				if (valueCompleteClass == propertyCompleteClass) {
					navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
				}
				else {
					if (navigationAssignment == null) {
						Node stepNode = createNavigableDataTypeNode(sourceNode, source2targetProperty);
						navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, stepNode, navigationAssignment);
						context.createEqualsEdge(targetNode, stepNode);
					}
					else {
						//						Node stepNode = createNavigableDataTypeNode(targetNode, navigationAssignment);
						navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
						//						QVTscheduleUtil.createEqualsEdge(targetNode, stepNode);
					}
				}
			}
		}
		else {
			//			if (!navigationEdge.isRealized() || targetNode.isRealized()) {
			if (targetNode != navigationEdge.getEdgeTarget()) {
				context.createEqualsEdge(targetNode, navigationEdge.getEdgeTarget());
			}
		}
		return navigationEdge;
	}

	protected @NonNull NavigableEdge getNavigationEdgeToClass(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		assert targetNode.isClass();
		NavigableEdge navigationEdge = sourceNode.getNavigableEdge(source2targetProperty);
		if (navigationEdge != null) {
			Node target = navigationEdge.getEdgeTarget();
			if (target != targetNode) {
				context.createEqualsEdge(targetNode, target);
			}
		}
		else {
			//		navigationEdge = createRealizedEdge(sourceNode, source2targetProperty, targetNode);
			navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
			//			Property target2sourceProperty = source2targetProperty.getOpposite();		// FIXME move to createEdge
			//			if (targetNode.isClassNode() && (target2sourceProperty != null) && !target2sourceProperty.isIsMany()) {
			//			createRealizedEdge(targetNode, target2sourceProperty, sourceNode);
			//				createNavigationOrRealizedEdge(targetNode, target2sourceProperty, sourceNode, isAssignment);
			//			}
		}
		return navigationEdge;
	}

	protected @NonNull NavigableEdge getNavigationEdgeToExpression(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		assert targetNode.isExpression();
		if (navigationAssignment != null) {
			NavigableEdge navigationEdge = sourceNode.getNavigableEdge(source2targetProperty);
			assert navigationEdge == null;
			//			Node valueNode = navigationEdge.getTarget();
			//			assert valueNode.isRealized();
			//			Type type = source2targetProperty.getType();
			/*			if (type instanceof DataType) {
				Node attributeNode = createRealizedDataTypeNode(sourceNode, source2targetProperty);
				createExpressionEdge(targetNode, EQUALS_NAME, attributeNode);
				targetNode = attributeNode;
			}
			else {
				Node stepNode = createPredicatedClassNode(sourceNode, navigationAssignment);
				createExpressionEdge(targetNode, EQUALS_NAME, stepNode);
				targetNode = stepNode;
			} */
			navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
			return navigationEdge;
		}
		else {
			NavigableEdge navigationEdge = sourceNode.getNavigableEdge(source2targetProperty);
			if (navigationEdge != null) {
				Node valueNode = navigationEdge.getEdgeTarget();
				assert valueNode.isRealized();
				Type type = source2targetProperty.getType();
				Edge equalsEdge = context.createEqualsEdge(targetNode, valueNode);
				if (type instanceof DataType) {
					assert equalsEdge.isRealized();			// ?? obsolete legacy check that never seems to be used
				}
				return navigationEdge;
			}
			else {
				navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
				return navigationEdge;
			}
		}
	}

	protected @NonNull NavigableEdge getNavigationEdgeToNull(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		assert targetNode.isNullLiteral();
		return createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
	}

	public @NonNull ExpressionSynthesizer getRequiredExpressionSynthesizer() {
		ExpressionSynthesizer requiredExpressionSynthesizer2 = requiredExpressionSynthesizer;
		if (requiredExpressionSynthesizer2 == null) {
			requiredExpressionSynthesizer = requiredExpressionSynthesizer2 = createRequiredExpressionSynthesizer();
		}
		return requiredExpressionSynthesizer2;
	}

	private void instantiate(@NonNull Node instantiatedNode, @NonNull Node referenceNode) {
		for (@NonNull NavigableEdge referenceEdge : referenceNode.getNavigableEdges()) {
			if (!referenceEdge.isSecondary()) {
				Node referenceTargetNode = referenceEdge.getEdgeTarget();
				String name = QVTscheduleUtil.getName(referenceTargetNode);
				ClassDatum classDatum = QVTscheduleUtil.getClassDatum(referenceTargetNode);
				Node instantiatedTargetNode = createDependencyNode(name, classDatum);
				createNavigationEdge(instantiatedNode, QVTscheduleUtil.getProperty(referenceEdge), instantiatedTargetNode, false);
				instantiate(instantiatedTargetNode, referenceTargetNode);
			}
		}
	}

	protected boolean isRequired() {
		return false;
	}

	protected boolean isUnconditional() {
		return true;
	}

	public @NonNull Node synthesize(/*@NonNull*/ Visitable element) {
		Node accept = element.accept(this);
		assert accept != null;
		return accept;
	}

	/**
	 * Generate the node(s) for xxxx = yyyy where xxxx and yyy are non-trivial expressions
	 *
	 * For the terminal navigation x = yyyy.y, xxxx.x = yyyy, xxxx.x = yyyy.y a node can be shared.
	 *
	 * For terminal operfations xxxx = yyyy.y() etc it cannot (yet).
	 */
	private @Nullable Node synthesizeOperationCallExp_equals(@NonNull OperationCallExp operationCallExp) {
		OCLExpression asSource = QVTbaseUtil.getOwnedSource(operationCallExp);
		OCLExpression asTarget = QVTbaseUtil.getOwnedArgument(operationCallExp, 0);
		Node sourceNode;
		Node targetNode;
		if (asSource instanceof VariableExp) {
			VariableDeclaration referredVariable = QVTbaseUtil.getReferredVariable((VariableExp)asSource);
			RuleRegion ruleRegion = context.getRegion();
			sourceNode = ruleRegion.getNode(referredVariable);
			if (sourceNode != null) {
				Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode2 = expression2knownNode;
				if (expression2knownNode2 == null) {
					expression2knownNode = expression2knownNode2 = new HashMap<>();
				}
				expression2knownNode2.put(asTarget, sourceNode);
			}
			targetNode = synthesize(asTarget);
			if (targetNode == sourceNode) {
				return null;
			}
			else {
				//				scheduleManager.addRegionError(ruleRegion, "Failed to unify simple equality predicate " + operationCallExp);
				sourceNode = synthesize(asSource);
			}
		}
		else if (asTarget instanceof VariableExp) {
			VariableDeclaration referredVariable = QVTbaseUtil.getReferredVariable((VariableExp)asTarget);
			RuleRegionImpl ruleRegion = (RuleRegionImpl)context.getRegion();
			targetNode = ruleRegion.getNode(referredVariable);
			if (targetNode != null) {
				Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode2 = expression2knownNode;
				if (expression2knownNode2 == null) {
					expression2knownNode = expression2knownNode2 = new HashMap<>();
				}
				expression2knownNode2.put(asSource, targetNode);
			}
			sourceNode = synthesize(asSource);
			if (targetNode == sourceNode) {
				return null;
			}
			else {
				//				scheduleManager.addRegionError(ruleRegion, "Failed to unify simple equality predicate " + operationCallExp);
				targetNode = synthesize(asTarget);
			}
		}
		else if (asSource instanceof NavigationCallExp) {
			targetNode = synthesize(asTarget);
			if (!targetNode.isDataType()) {
				Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode2 = expression2knownNode;
				if (expression2knownNode2 == null) {
					expression2knownNode = expression2knownNode2 = new HashMap<>();
				}
				expression2knownNode2.put(asSource, targetNode);
			}
			sourceNode = synthesize(asSource);
			if (targetNode == sourceNode) {
				return null;
			}
			//				scheduleManager.addRegionError(ruleRegion, "Failed to unify simple equality predicate " + operationCallExp);
		}
		else {
			sourceNode = synthesize(asSource);
			if (!sourceNode.isDataType()) {
				Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode2 = expression2knownNode;
				if (expression2knownNode2 == null) {
					expression2knownNode = expression2knownNode2 = new HashMap<>();
				}
				expression2knownNode2.put(asTarget, sourceNode);
			}
			targetNode = synthesize(asTarget);
			if (targetNode == sourceNode) {
				return null;
			}
			//				scheduleManager.addRegionError(ruleRegion, "Failed to unify simple equality predicate " + operationCallExp);
		}
		//		createPredicateEdge(sourceNode, "«equals»", targetNode);
		createEqualsEdge(targetNode, sourceNode);
		return null;
	}

	private @Nullable Node synthesizeOperationCallExp_includes(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		Node targetNode = synthesize(operationCallExp.getOwnedArguments().get(0));
		String name = operationCallExp.getReferredOperation().getName();
		createPredicateEdge(sourceNode, "«" + name + "»", targetNode);
		if (sourceNode.isDataType()) {		// expecting a CollectionType
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(sourceNode)) {
				if (edge instanceof NavigationEdge) {
					NavigationEdge navigationEdge = (NavigationEdge)edge;
					Property property = navigationEdge.getReferredProperty();
					Property oppositeProperty = property.getOpposite();
					if ((oppositeProperty != null) && !oppositeProperty.isIsMany()) {
						createNavigationEdge(targetNode, oppositeProperty, QVTscheduleUtil.getSourceNode(navigationEdge), false);
					}
				}
			}
		}
		return null;
	}

	private @NonNull Node synthesizeOperationCallExp_oclAsType(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		//		if ((operationCallExp.getOwnedSource() instanceof CallExp) && sourceNode.refineClassDatumAnalysis(scheduler.getClassDatumAnalysis(operationCallExp))) {
		//			return sourceNode;
		//		}
		Type castType = QVTbaseUtil.getType(operationCallExp);
		boolean castIsRequired = operationCallExp.isIsRequired();
		CompleteClass requiredClass = environmentFactory.getCompleteModel().getCompleteClass(castType);
		CompleteClass predicatedClass = sourceNode.getCompleteClass();
		boolean sourceIsRequired = sourceNode.isRequired();
		if (predicatedClass.conformsTo(requiredClass) && (sourceIsRequired || !castIsRequired)) {
			sourceNode.addOriginatingElement(operationCallExp);
			return sourceNode;											// Skip cast if already conformant, typically a redundant cast daisy chain
		}
		for (@NonNull NavigableEdge castEdge : sourceNode.getCastEdges()) {
			Node targetNode = castEdge.getEdgeTarget();
			predicatedClass = targetNode.getCompleteClass();
			if (predicatedClass.conformsTo(requiredClass)) {
				targetNode.addOriginatingElement(operationCallExp);
				return targetNode;										// Re-use a pre-existing class
			}
		}
		Property castProperty = scheduleManager.getCastProperty(castType);
		Edge castEdge = sourceNode.getPredicateEdge(castProperty);
		if (castEdge != null) {
			Node castNode = castEdge.getEdgeTarget();
			castNode.addOriginatingElement(operationCallExp);
			return castNode;
		}
		String name = "a" + castType.getName();
		//		assert name != null;
		Node castNode = createStepNode(name, operationCallExp, sourceNode);
		if (castIsRequired) {
			castNode.setRequired();
			if ((castNode instanceof MappingNode) && sourceNode.isMatched()) {
				((MappingNode)castNode).setMatched(true);
			}
		}
		castEdge = createCastEdge(sourceNode, castProperty, castNode);
		OCLExpression argument = operationCallExp.getOwnedArguments().get(0);
		if (!(argument instanceof TypeExp)) {
			Node argumentNode = synthesize(argument);
			//			createExpressionEdge(argumentNode, "«arg»", castNode);
			Operation referredOperation = QVTbaseUtil.getReferredOperation(operationCallExp);
			Parameter firstParameter = QVTbaseUtil.getOwnedParameter(referredOperation, 0);
			createOperationParameterEdge(argumentNode, firstParameter, -1, castNode);
		}
		return castNode;
		/*		OperationNode operationNode = new OperationNode(context, operationCallExp.getReferredOperation().getName(), context.getClassDatumAnalysis(operationCallExp));
		QVTscheduleUtil.ARGUMENT.createEdge(context, sourceNode, "source", operationNode);
		for (@SuppressWarnings("null")@NonNull OCLExpression argument : operationCallExp.getOwnedArguments()) {
			Node argumentNode = analyze(argument);
			QVTscheduleUtil.ARGUMENT.createEdge(context, argumentNode, "arg", operationNode);
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
			QVTscheduleUtil.ARGUMENT.createEdge(context, operationNode, null, resultNode);
			return resultNode;
		} */
	}

	/*	private @NonNull Node synthesizeOperationCallExp_oclIsKindOf(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		Operation referredOperation = QVTbaseUtil.getReferredOperation(operationCallExp);
		OCLExpression source = QVTbaseUtil.getOwnedSource(operationCallExp);
		OCLExpression argument = QVTbaseUtil.getOwnedArgument(operationCallExp, 0);
		Node operationNode = null;
		if (argument instanceof TypeExp) {
			//			String name = referredOperation.getName() + "\\n" + ((TypeExp)argument).getReferredType().toString();
			operationNode = findOperationNode(referredOperation, sourceNode);
			if (operationNode == null) {
				//				operationNode = createConnectedOperationNode(name, nullArgNames, operationCallExp, sourceNode);
				Type selfType = QVTbaseUtil.getType(source);
				@NonNull Node @NonNull [] sourceAndArgumentNodes = new @NonNull Node[] { sourceNode };
				boolean isMatched = QVTscheduleUtil.isMatched(operationCallExp);
				ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
				operationNode = nestedAnalyzer.createOperationCallNode(operationCallExp, referredOperation, sourceAndArgumentNodes);
				nestedAnalyzer.createOperationSelfEdge(sourceAndArgumentNodes[0], selfType, operationNode);

			}
		}
		else {
			Node argumentNode = synthesize(argument);
			operationNode = findOperationNode(referredOperation, sourceNode, argumentNode);
			if (operationNode == null) {
				Type selfType = QVTbaseUtil.getType(source);
				Parameter parameter = QVTbaseUtil.getOwnedParameter(referredOperation, 0);
				@NonNull Node[] sourceAndArgumentNodes = new @NonNull Node[] { sourceNode, argumentNode };
				boolean isMatched = QVTscheduleUtil.isMatched(operationCallExp);
				ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
				operationNode = nestedAnalyzer.createOperationCallNode(operationCallExp, referredOperation, sourceAndArgumentNodes);
				nestedAnalyzer.createOperationSelfEdge(sourceAndArgumentNodes[0], selfType, operationNode);
				nestedAnalyzer.createOperationParameterEdge(sourceAndArgumentNodes[1], parameter, -1, operationNode);
			}
		}
		return operationNode;
	} */

	private @NonNull Node synthesizeOperationCallExp_oclContainer(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		//		Type castType = QVTbaseUtil.getType(operationCallExp);
		Property oclContainerProperty = standardLibraryHelper.getOclContainerProperty();
		Edge oclContainerEdge = sourceNode.getPredicateEdge(oclContainerProperty);
		if (oclContainerEdge != null) {
			return oclContainerEdge.getEdgeTarget();
		}
		String name = QVTbaseUtil.getName(QVTbaseUtil.getReferredOperation(operationCallExp));
		Node oclContainerNode = createStepNode(name, operationCallExp, sourceNode);
		oclContainerEdge = createNavigationEdge(sourceNode, oclContainerProperty, oclContainerNode, false);
		return oclContainerNode;
		/*		String name = operationCallExp.getReferredOperation().getName();
		assert name != null;
		Node operationNode = findOperationNode(sourceNode, name);
		if (operationNode == null) {
			operationNode = QVTscheduleUtil.OPERATION.createNode(context, name, operationCallExp, sourceNode);
			QVTscheduleUtil.ARGUMENT.createEdge(context, sourceNode, null, operationNode);
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

	@Override
	public @NonNull Node visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @NonNull Node visitBooleanLiteralExp(@NonNull BooleanLiteralExp booleanLiteralExp) {
		boolean booleanValue = booleanLiteralExp.isBooleanSymbol();
		Node operationNode = createBooleanLiteralNode(booleanValue, booleanLiteralExp);
		return operationNode;
	}

	@Override
	public @NonNull Node visitCollectionLiteralExp(@NonNull CollectionLiteralExp collectionLiteralExp) {
		List<@NonNull CollectionLiteralPart> ownedParts = QVTbaseUtil.Internal.getOwnedPartsList(collectionLiteralExp);
		int iSize = ownedParts.size();
		@NonNull Node [] partNodes = new @NonNull Node[iSize];
		@NonNull CollectionLiteralPart [] collectionParts = new @NonNull CollectionLiteralPart[iSize];
		for (int i = 0; i < iSize; i++) {
			CollectionLiteralPart collectionPart = ownedParts.get(i);
			partNodes[i] = synthesize(collectionPart);
			collectionParts[i] = collectionPart;
		}
		boolean isMatched = QVTscheduleUtil.isMatched(collectionLiteralExp);
		ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
		return nestedAnalyzer.createCollectionLiteral(collectionLiteralExp, collectionParts, partNodes);
	}

	@Override
	public @NonNull Node visitCollectionItem(@NonNull CollectionItem collectionItem) {
		return synthesize(collectionItem.getOwnedItem());
	}

	@Override
	public @NonNull Node visitCollectionRange(@NonNull CollectionRange collectionRange) {
		Node firstNode = synthesize(collectionRange.getOwnedFirst());
		Node lastNode = synthesize(collectionRange.getOwnedLast());
		boolean isMatched = QVTscheduleUtil.isMatched(collectionRange);
		ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
		return nestedAnalyzer.createCollectionRange(collectionRange, firstNode, lastNode);
	}

	@Override
	public @NonNull Node visitElement(@NonNull Element element) {
		Class oclInvalidType = scheduleManager.getStandardLibrary().getOclInvalidType();
		ClassDatum classDatum = scheduleManager.getClassDatum(scheduleManager.getDomainUsageAnalysis().getPrimitiveTypeModel(), oclInvalidType);
		Node errorNode = createErrorNode("«error»", classDatum);
		int parameterIndex =  0;
		for (EObject eObject : element.eContents()) {
			Node node = synthesize((Element) eObject);
			//			createExpressionEdge(node, "?", errorNode);
			createOperationParameterEdge(node, qvtbaseLibraryHelper.getErrorElementsParameter(), parameterIndex++, errorNode);
		}
		return errorNode;
	}

	@Override
	public @NonNull Node visitEnumLiteralExp(@NonNull EnumLiteralExp enumLiteralExp) {
		EnumerationLiteral referredEnumerationLiteral = QVTbaseUtil.getReferredLiteral(enumLiteralExp);
		Node operationNode = createEnumLiteralNode(referredEnumerationLiteral, enumLiteralExp);
		return operationNode;
	}

	@Override
	public @NonNull Node visitIfExp(@NonNull IfExp ifExp) {
		ExpressionSynthesizer conditionalExpressionSynthesizer = getConditionalExpressionSynthesizer();
		Node selfNode = synthesize(ifExp.getOwnedCondition());
		Node thenNode = conditionalExpressionSynthesizer.synthesize(ifExp.getOwnedThen());
		Node elseNode = conditionalExpressionSynthesizer.synthesize(ifExp.getOwnedElse());
		boolean isMatched = QVTscheduleUtil.isMatched(ifExp);
		ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
		return nestedAnalyzer.createIf(ifExp, selfNode, thenNode, elseNode);
	}

	@Override
	public @NonNull Node visitIntegerLiteralExp(@NonNull IntegerLiteralExp integerLiteralExp) {
		Number numberValue = ClassUtil.nonNullState(integerLiteralExp.getIntegerSymbol());
		Node operationNode = createNumericLiteralNode(numberValue, integerLiteralExp);
		return operationNode;
	}

	@Override
	public @NonNull Node visitLetExp(@NonNull LetExp letExp) {
		Variable ownedVariable = letExp.getOwnedVariable();
		Node initNode = synthesize(ownedVariable.getOwnedInit());
		assert initNode != null;
		Type type = QVTbaseUtil.getType(ownedVariable);
		CompleteClass actualClass = initNode.getCompleteClass();
		ClassDatum classDatum = scheduleManager.getClassDatum(ownedVariable);
		CompleteClass requiredClass = QVTscheduleUtil.getCompleteClass(classDatum);
		if (actualClass.conformsTo(requiredClass)) {
			context.getRegion().addVariableNode(ownedVariable, initNode);
			initNode.setOriginatingVariable(ownedVariable);
		}
		else {
			Node varNode = createLetNode(ownedVariable, initNode);
			Property castProperty = scheduleManager.getCastProperty(type);
			createNavigationEdge(initNode, castProperty, varNode, false);
		}
		return synthesize(letExp.getOwnedIn());
	}

	@Override
	public @NonNull Node visitLoopExp(@NonNull LoopExp loopExp) {
		Node sourceNode = synthesize(loopExp.getOwnedSource());
		Node loopNode = doLoopExp(loopExp, sourceNode);
		boolean isSafe = loopExp.isIsSafe();
		if (isSafe) {
			loopNode = doSafeNavigation(loopExp, sourceNode, loopNode);
		}
		return loopNode;
	}

	@Override
	public @NonNull Node visitMapLiteralExp(@NonNull MapLiteralExp mapLiteralExp) {
		List<@NonNull MapLiteralPart> ownedParts = QVTbaseUtil.Internal.getOwnedPartsList(mapLiteralExp);
		int iSize = ownedParts.size();
		@NonNull Node [] partNodes = new @NonNull Node[iSize];
		@NonNull MapLiteralPart [] mapParts = new @NonNull MapLiteralPart[iSize];
		for (int i = 0; i < iSize; i++) {
			MapLiteralPart mapPart = ownedParts.get(i);
			partNodes[i] = synthesize(mapPart);
			mapParts[i] = mapPart;
		}
		boolean isMatched = QVTscheduleUtil.isMatched(mapLiteralExp);
		ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
		return nestedAnalyzer.createMapLiteral(mapLiteralExp, mapParts, partNodes);
	}

	@Override
	public @NonNull Node visitMapLiteralPart(@NonNull MapLiteralPart mapLiteralPart) {
		Node keyNode = synthesize(QVTbaseUtil.getOwnedKey(mapLiteralPart));
		Node valueNode = synthesize(QVTbaseUtil.getOwnedValue(mapLiteralPart));
		boolean isMatched = QVTscheduleUtil.isMatched(mapLiteralPart);
		ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
		return nestedAnalyzer.createMapPart(mapLiteralPart, keyNode, valueNode);
	}

	@Override
	public @NonNull Node visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
		OCLExpression ownedSource = QVTbaseUtil.getOwnedSource(navigationCallExp);
		Node sourceNode = synthesize(ownedSource);
		Node navigationNode = doNavigationCallExp(navigationCallExp, sourceNode);
		boolean isSafe = navigationCallExp.isIsSafe();
		if (isSafe) {
			navigationNode = doSafeNavigation(navigationCallExp, sourceNode, navigationNode);
		}
		return navigationNode;
	}

	@Override
	public @NonNull Node visitNullLiteralExp(@NonNull NullLiteralExp nullLiteralExp) {
		return createNullLiteralNode(nullLiteralExp);
	}

	@Override
	public @NonNull Node visitOCLExpression(@NonNull OCLExpression oclExpression) {
		return context.getUnknownNode(oclExpression);
	}

	@Override
	public @Nullable Node visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
		boolean isMatched = isRequired() || QVTscheduleUtil.isMatched(operationCallExp);
		if (isUnconditional() && !isMatched) {
			return getConditionalExpressionSynthesizer().visitOperationCallExp(operationCallExp);
		}
		OCLExpression ownedSource = operationCallExp.getOwnedSource();
		if (ownedSource instanceof VariableExp) {
			Transformation transformation = QVTbaseUtil.getContainingTransformation(operationCallExp);
			Variable thisVariable = QVTbaseUtil.getContextVariable(scheduleManager.getStandardLibrary(), transformation);
			if (((VariableExp)ownedSource).getReferredVariable() == thisVariable) {
				ownedSource = null;
			}
		}
		Node sourceNode = ownedSource !=  null ? synthesize(ownedSource) : null;
		Node operationNode = doOperationCallExp(operationCallExp, sourceNode);
		boolean isSafe = operationCallExp.isIsSafe();
		if (isSafe && (sourceNode != null) && (operationNode != null)) {
			operationNode = doSafeNavigation(operationCallExp, sourceNode, operationNode);
		}
		return operationNode;
	}

	@Override
	public @NonNull Node visitRealLiteralExp(@NonNull RealLiteralExp realLiteralExp) {
		Number numberValue = ClassUtil.nonNullState(realLiteralExp.getRealSymbol());
		Node operationNode = createNumericLiteralNode(numberValue, realLiteralExp);
		return operationNode;
	}

	@Override
	public @NonNull Node visitShadowExp(@NonNull ShadowExp shadowExp) {
		List<@NonNull ShadowPart> ownedParts = QVTbaseUtil.Internal.getOwnedPartsList(shadowExp);
		int iSize = ownedParts.size();
		@NonNull Node [] partNodes = new @NonNull Node[iSize];
		@NonNull ShadowPart [] shadowParts = new @NonNull ShadowPart[iSize];
		for (int i = 0; i < iSize; i++) {
			ShadowPart shadowPart = ownedParts.get(i);
			partNodes[i] = synthesize(shadowPart);
			shadowParts[i] = shadowPart;
		}
		boolean isMatched = QVTscheduleUtil.isMatched(shadowExp);
		ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
		return nestedAnalyzer.createShadow(shadowExp, shadowParts, partNodes);
	}

	@Override
	public @NonNull Node visitShadowPart(@NonNull ShadowPart shadowPart) {
		return synthesize(shadowPart.getOwnedInit());
	}

	@Override
	public @NonNull Node visitStringLiteralExp(@NonNull StringLiteralExp stringLiteralExp) {
		String stringValue = ClassUtil.nonNullState(stringLiteralExp.getStringSymbol());
		Node operationNode = createStringLiteralNode(stringValue, stringLiteralExp);
		return operationNode;
	}

	@Override
	public @NonNull Node visitTupleLiteralExp(@NonNull TupleLiteralExp tupleLiteralExp) {
		List<@NonNull TupleLiteralPart> ownedParts = QVTbaseUtil.Internal.getOwnedPartsList(tupleLiteralExp);
		int iSize = ownedParts.size();
		@NonNull Node [] partNodes = new @NonNull Node[iSize];
		@NonNull TupleLiteralPart [] tupleParts = new @NonNull TupleLiteralPart[iSize];
		for (int i = 0; i < iSize; i++) {
			TupleLiteralPart tuplePart = ownedParts.get(i);
			partNodes[i] = synthesize(tuplePart);
			tupleParts[i] = tuplePart;
		}
		boolean isMatched = QVTscheduleUtil.isMatched(tupleLiteralExp);
		ExpressionSynthesizer nestedAnalyzer = isMatched ? this : getConditionalExpressionSynthesizer();
		return nestedAnalyzer.createTupleLiteral(tupleLiteralExp, tupleParts, partNodes);
	}

	@Override
	public @NonNull Node visitTupleLiteralPart(@NonNull TupleLiteralPart tupleLiteralPart) {
		return synthesize(tupleLiteralPart.getOwnedInit());
	}

	@Override
	public @NonNull Node visitTypeExp(@NonNull TypeExp typeExp) {
		Type referredType = QVTbaseUtil.getReferredType(typeExp);
		Node operationNode = createTypeLiteralNode(referredType, typeExp);
		return operationNode;
	}

	@Override
	public @NonNull Node visitVariableDeclaration(@NonNull VariableDeclaration variableDeclaration) {
		return context.getReferenceNode(variableDeclaration);
	}

	@Override
	public @NonNull Node visitVariableExp(@NonNull VariableExp variableExp) {
		VariableDeclaration referredVariable = QVTbaseUtil.getReferredVariable(variableExp);
		return context.getReferenceNode(referredVariable);
	}
}