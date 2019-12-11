/*******************************************************************************
 * Copyright (c) 2019 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvts2qvti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.BooleanLiteralExp;
import org.eclipse.ocl.pivot.CallExp;
import org.eclipse.ocl.pivot.CollectionLiteralExp;
import org.eclipse.ocl.pivot.CollectionLiteralPart;
import org.eclipse.ocl.pivot.CollectionRange;
import org.eclipse.ocl.pivot.CollectionType;
import org.eclipse.ocl.pivot.IfExp;
import org.eclipse.ocl.pivot.Iteration;
import org.eclipse.ocl.pivot.LoopExp;
import org.eclipse.ocl.pivot.NullLiteralExp;
import org.eclipse.ocl.pivot.NumericLiteralExp;
import org.eclipse.ocl.pivot.OCLExpression;
import org.eclipse.ocl.pivot.Operation;
import org.eclipse.ocl.pivot.OperationCallExp;
import org.eclipse.ocl.pivot.Parameter;
import org.eclipse.ocl.pivot.Property;
import org.eclipse.ocl.pivot.ShadowPart;
import org.eclipse.ocl.pivot.Type;
import org.eclipse.ocl.pivot.TypedElement;
import org.eclipse.ocl.pivot.Variable;
import org.eclipse.ocl.pivot.VariableDeclaration;
import org.eclipse.ocl.pivot.VariableExp;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.pivot.qvtbase.Function;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtimperative.utilities.QVTimperativeHelper;
import org.eclipse.qvtd.pivot.qvtschedule.BooleanLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.CollectionRangeNode;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.EnumLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.IfNode;
import org.eclipse.qvtd.pivot.qvtschedule.IteratorNode;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.NullLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.NumericLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationCallNode;
import org.eclipse.qvtd.pivot.qvtschedule.OperationParameterEdge;
import org.eclipse.qvtd.pivot.qvtschedule.OperationSelfEdge;
import org.eclipse.qvtd.pivot.qvtschedule.PatternTypedNode;
import org.eclipse.qvtd.pivot.qvtschedule.PatternVariableNode;
import org.eclipse.qvtd.pivot.qvtschedule.Role;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowNode;
import org.eclipse.qvtd.pivot.qvtschedule.ShadowPartEdge;
import org.eclipse.qvtd.pivot.qvtschedule.StringLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.SuccessNode;
import org.eclipse.qvtd.pivot.qvtschedule.TypeLiteralNode;
import org.eclipse.qvtd.pivot.qvtschedule.util.AbstractExtendingQVTscheduleVisitor;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;
import org.eclipse.qvtd.runtime.utilities.QVTruntimeLibraryHelper;

/**
 * QVTs2QVTiNodeVisitor provides the minor Node conversions from QVTs to VQTi.
 */
public class QVTs2QVTiNodeVisitor extends AbstractExtendingQVTscheduleVisitor<@Nullable TypedElement, @NonNull BasicPartition2Mapping>
{
	private static int depth = 0;

	protected final @NonNull QVTimperativeHelper helper;
	protected final @NonNull QVTruntimeLibraryHelper qvtruntimeLibraryHelper;
	protected final @NonNull Set<@NonNull Edge>  resultEdges = new HashSet<>();

	public QVTs2QVTiNodeVisitor(@NonNull BasicPartition2Mapping context) {
		super(context);
		this.helper = context.getHelper();
		this.qvtruntimeLibraryHelper = context.getQVTruntimeLibraryHelper();
	}

	@Deprecated /* @deprecated non-null return should not happen */
	protected @Nullable OCLExpression basicGetExpression(@NonNull Node node) {	// FIXME Bug 552853
		return (OCLExpression)basicGetTypedElement(node);
	}

	protected @Nullable TypedElement basicGetTypedElement(@NonNull Node node) {
		if (++depth > 50) {
			throw new IllegalStateException();								// Crash before a StackOverflow obscures the cause
		}
		try {
			VariableDeclaration variable = context.basicGetVariable(node);
			if (variable != null) {
				assert !node.isNullLiteral();								// null should not be cached in a variable
				return PivotUtil.createVariableExp(variable);
			}
			if (node.isThis()) {			// ?? distinctive Node
				return context.createContextVariableExp();
			}
			return node.accept(this);		// FIXME do depth-first creation of let's rather than breadth-first recursions
		}
		finally {
			--depth;
		}
	}

	protected @Nullable LoopExp doIterationCallNode(@NonNull OperationCallNode node) {
		Parameter loopSourceParameter = qvtruntimeLibraryHelper.getLoopSourceParameter();
		Parameter loopBodyParameter = qvtruntimeLibraryHelper.getLoopBodyParameter();
		Parameter loopIteratorsParameter = qvtruntimeLibraryHelper.getLoopIteratorsParameter();
		Iteration referredIteration = (Iteration)QVTscheduleUtil.getReferredOperation(node);
		OCLExpression sourceExp = null;
		OCLExpression bodyExp = null;
		List<@NonNull Parameter> iterators = QVTbaseUtil.Internal.getOwnedIteratorsList(referredIteration);
		//
		//	Synthesize source expression
		//
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge instanceof OperationParameterEdge) {
				OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
				Parameter referredParameter = operationParameterEdge.getReferredParameter();
				if (referredParameter == loopSourceParameter) {
					Node expNode = operationParameterEdge.getEdgeSource();
					sourceExp = getExpression(expNode);
				}
			}
		}
		//
		//	Create iterator variables
		//
		assert sourceExp != null;
		Type sourceType = PivotUtil.getElementType((CollectionType)PivotUtil.getType(sourceExp));
		List<@NonNull Variable> variables = new ArrayList<>(iterators.size());
		for (int i = 0; i < iterators.size(); i++) {
			Parameter iterator = iterators.get(i);
			Variable variable = helper.createIteratorVariable(PivotUtil.getName(iterator), sourceType, sourceExp.isIsRequired());
			variables.add(variable);
		}
		//
		//	Add iterator variables to context for use by body.
		//
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge instanceof OperationParameterEdge) {
				OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
				Parameter referredParameter = operationParameterEdge.getReferredParameter();
				if (referredParameter == loopIteratorsParameter) {
					int index = operationParameterEdge.getParameterIndex();
					Node expNode = operationParameterEdge.getEdgeSource();
					context.addVariable(expNode, variables.get(index));
				}
			}
		}
		//
		//	Synthesize body expression
		//
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge instanceof OperationParameterEdge) {
				OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
				Parameter referredParameter = operationParameterEdge.getReferredParameter();
				if (referredParameter == loopBodyParameter) {
					Node expNode = operationParameterEdge.getEdgeSource();
					bodyExp = getExpression(expNode);
				}
			}
		}
		assert bodyExp != null;
		//
		//	Remove iterator variables from context.
		//
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge instanceof OperationParameterEdge) {
				OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
				Parameter referredParameter = operationParameterEdge.getReferredParameter();
				if (referredParameter == loopIteratorsParameter) {
					Node expNode = operationParameterEdge.getEdgeSource();
					context.removeVariable(expNode);
				}
			}
		}
		return helper.createIteratorExp(sourceExp, referredIteration, variables, bodyExp);		// FIXME Bug 552827 IterateExp
	}

	protected @Nullable OperationCallExp doOperationCallNode(@NonNull OperationCallNode node) {
		Operation referredOperation = QVTscheduleUtil.getReferredOperation(node);
		OCLExpression sourceExp = null;
		List<@NonNull Parameter> parameters = QVTbaseUtil.Internal.getOwnedParametersList(referredOperation);
		List<@Nullable OCLExpression> argExps = new ArrayList<>(parameters.size());
		for (int i = 0; i < parameters.size(); i++) {
			argExps.add(null);
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isExpression() && (edge instanceof OperationSelfEdge)) {
				OperationSelfEdge operationSelfEdge = (OperationSelfEdge)edge;
				Node expNode = operationSelfEdge.getEdgeSource();
				//	try {
				QVTs2QVTiNodeVisitor expressionCreator = new QVTs2QVTiNodeVisitor(context);
				sourceExp = expressionCreator.getExpression(expNode);
				//	}
				//	catch (IllegalStateException e) {			// FIXME debugging
				//		QVTs2QVTiNodeVisitor expressionCreator = new QVTs2QVTiNodeVisitor(context);
				//		sourceExp = expressionCreator.getExpression(expNode);
				//	}
			}
			else if (edge instanceof OperationParameterEdge) {
				OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
				Node expNode = operationParameterEdge.getEdgeSource();
				//	try {
				QVTs2QVTiNodeVisitor expressionCreator = new QVTs2QVTiNodeVisitor(context);
				OCLExpression nestedExp = expressionCreator.getExpression(expNode);
				int index = parameters.indexOf(operationParameterEdge.getReferredParameter());
				if (0 <= index) {
					OCLExpression oldExpression = argExps.set(index, nestedExp);
					assert oldExpression == null;
				}
				//	}
				//	catch (IllegalStateException e) {			// FIXME debugging
				//		QVTs2QVTiNodeVisitor expressionCreator = new QVTs2QVTiNodeVisitor(context);
				//		OCLExpression nestedExp = expressionCreator.getExpression(expNode);
				//		int index = parameters.indexOf(operationParameterEdge.getReferredParameter());
				//		if (0 <= index) {
				//			OCLExpression oldExpression = argExps.set(index, nestedExp);
				//			assert oldExpression == null;
				//		}
				//	}
			}
		}
		for (OCLExpression exp : argExps) {
			if (exp == null) {
				return null;
			}
		}
		if ((sourceExp == null) && (referredOperation instanceof Function)) {
			sourceExp = context.createContextVariableExp();
		}
		//	if (referredOperation instanceof Function) {
		//		return helper.createFunctionCallExp(sourceExp, referredOperation, ClassUtil.nullFree(argExps));
		//	}
		//	else {
		return helper.createOperationCallExp(sourceExp, referredOperation, ClassUtil.nullFree(argExps));
		//	}
	}

	protected @Nullable TypedElement doPatternNode(@NonNull Node node) {
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isExpression() && resultEdges.add(edge)) {
				Node expNode = edge.getEdgeSource();
				OCLExpression clonedElement = getExpression(expNode);
				if (clonedElement instanceof VariableExp) {
					VariableDeclaration referredVariable = ((VariableExp)clonedElement).getReferredVariable();
					if (referredVariable instanceof Variable) {
						context.addVariable(node, referredVariable);
					}
				}
				return clonedElement;
			}
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			assert !edge.isCast();
			if (edge.isNavigation() && resultEdges.add(edge)) {
				NavigationEdge navigationEdge = (NavigationEdge)edge;
				NavigationEdge oppositeEdge = navigationEdge.getOppositeEdge();
				if ((oppositeEdge == null) || resultEdges.add(oppositeEdge)) {
					Role edgeRole = QVTscheduleUtil.getEdgeRole(edge);
					if (edgeRole == Role.LOADED) {
						OCLExpression source = getExpression(edge.getEdgeSource());
						return helper.createNavigationCallExp(source, QVTscheduleUtil.getReferredProperty(navigationEdge));
					}
					else if (edgeRole == Role.PREDICATED) {
						OCLExpression source = getExpression(edge.getEdgeSource());
						return helper.createNavigationCallExp(source, QVTscheduleUtil.getReferredProperty(navigationEdge));
					}
				}
			}
			else {
				// SharedEdge
			}
		}
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isExpression()) {
				OCLExpression source = getExpression(edge.getEdgeSource());
				return source;
			}
		}
		return null;
	}

	public @NonNull OCLExpression getExpression(@NonNull Node node) {
		return ClassUtil.nonNullState((OCLExpression) basicGetTypedElement(node));
	}

	@Override
	public @NonNull OCLExpression visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @NonNull BooleanLiteralExp visitBooleanLiteralNode(@NonNull BooleanLiteralNode node) {
		return helper.createBooleanLiteralExp(node.isBooleanValue());
	}

	@Override
	public @NonNull CollectionLiteralExp visitCollectionLiteralNode(@NonNull CollectionLiteralNode node) {
		CollectionType asType = (CollectionType) node.getClassDatum().getPrimaryClass();
		final Map<@NonNull CollectionLiteralPart, @NonNull Integer> part2index = new HashMap<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge instanceof CollectionPartEdge) {
				CollectionPartEdge collectionPartEdge = (CollectionPartEdge)edge;
				CollectionLiteralPart oldCollectionLiteralPart = collectionPartEdge.getReferredPart();
				CollectionLiteralExp oldCollectionLiteralExp = (CollectionLiteralExp) oldCollectionLiteralPart.eContainer();
				int index = oldCollectionLiteralExp.getOwnedParts().indexOf(oldCollectionLiteralPart);
				Node expNode = collectionPartEdge.getEdgeSource();
				TypedElement typedElement = ClassUtil.nonNullState(basicGetTypedElement(expNode));
				CollectionLiteralPart collectionLiteralPart = null;
				if (typedElement instanceof CollectionLiteralPart) {
					collectionLiteralPart = (CollectionLiteralPart)typedElement;
				}
				else {
					collectionLiteralPart = helper.createCollectionItem((OCLExpression) typedElement);
				}
				part2index.put(collectionLiteralPart, index);
			}
		}
		List<@NonNull CollectionLiteralPart> asParts = new ArrayList<>(part2index.keySet());
		Collections.sort(asParts, new Comparator<@NonNull CollectionLiteralPart>() {
			@Override
			public int compare(@NonNull CollectionLiteralPart o1, @NonNull CollectionLiteralPart o2) {
				Integer i1 = part2index.get(o1);
				Integer i2 = part2index.get(o2);
				assert (i1 != null) && (i2 != null);
				return i1 - i2;
			}
		});
		return helper.createCollectionLiteralExp(asType, asParts);
	}

	@Override
	public @NonNull CollectionRange visitCollectionRangeNode(@NonNull CollectionRangeNode node) {
		Parameter rangeFirstParameter = qvtruntimeLibraryHelper.getRangeFirstParameter();
		Parameter rangeLastParameter = qvtruntimeLibraryHelper.getRangeLastParameter();
		OCLExpression asFirst = null;
		OCLExpression asLast = null;
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge instanceof OperationParameterEdge) {
				OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
				Parameter referredParameter = operationParameterEdge.getReferredParameter();
				if (referredParameter == rangeFirstParameter) {
					Node expNode = operationParameterEdge.getEdgeSource();
					asFirst = getExpression(expNode);
				}
				else if (referredParameter == rangeLastParameter) {
					Node expNode = operationParameterEdge.getEdgeSource();
					asLast = getExpression(expNode);
				}
			}
		}
		assert (asFirst != null) && (asLast != null);
		return helper.createCollectionRange(asFirst, asLast);
	}

	@Override
	public @Nullable OCLExpression visitEnumLiteralNode(@NonNull EnumLiteralNode node) {
		return helper.createEnumLiteralExp(QVTscheduleUtil.getEnumValue(node));
	}

	@Override
	public @Nullable IfExp visitIfNode(@NonNull IfNode node) {
		OCLExpression conditionExp = null;
		OCLExpression thenExp = null;
		OCLExpression elseExp = null;
		Parameter conditionParameter = qvtruntimeLibraryHelper.getIfConditionParameter();
		Parameter thenParameter = qvtruntimeLibraryHelper.getIfThenParameter();
		Parameter elseParameter = qvtruntimeLibraryHelper.getIfElseParameter();
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge.isExpression() && (edge instanceof OperationParameterEdge)) {
				OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
				Node expNode = operationParameterEdge.getEdgeSource();
				OCLExpression nestedExp = getExpression(expNode);
				Parameter parameter = operationParameterEdge.getReferredParameter();
				if (parameter == conditionParameter) {
					conditionExp = nestedExp;
				}
				else if (parameter == thenParameter) {
					thenExp = nestedExp;
				}
				else if (parameter == elseParameter) {
					elseExp = nestedExp;
				}
			}
		}
		if ((conditionExp != null) && (thenExp != null) && (elseExp != null)) {
			return helper.createIfExp(conditionExp, thenExp, elseExp);
		}
		return null;
	}

	@Override
	public @Nullable TypedElement visitIteratorNode(@NonNull IteratorNode node) {
		Parameter loopIteratorsParameter = qvtruntimeLibraryHelper.getLoopIteratorsParameter();
		for (@NonNull Edge edge : QVTscheduleUtil.getOutgoingEdges(node)) {
			if (edge instanceof OperationParameterEdge) {
				OperationParameterEdge operationParameterEdge = (OperationParameterEdge)edge;
				Parameter referredParameter = operationParameterEdge.getReferredParameter();
				if (referredParameter == loopIteratorsParameter) {
					Node expNode = operationParameterEdge.getEdgeTarget();
					getExpression(expNode);
				}
			}
		}
		VariableDeclaration variable = context.getVariable(node);
		return PivotUtil.createVariableExp(variable);
	}

	@Override
	public @NonNull NullLiteralExp visitNullLiteralNode(@NonNull NullLiteralNode node) {
		return helper.createNullLiteralExp();
	}

	@Override
	public @NonNull NumericLiteralExp visitNumericLiteralNode(@NonNull NumericLiteralNode node) {
		Number numericValue = ClassUtil.nonNullState(node.getNumericValue());
		if ((numericValue instanceof Byte) || (numericValue instanceof Integer) || (numericValue instanceof Long) || (numericValue instanceof Short)) {
			return helper.createIntegerLiteralExp(numericValue);
		}
		else {
			return helper.createRealLiteralExp(numericValue);
		}
	}

	@Override
	public @Nullable CallExp visitOperationCallNode(@NonNull OperationCallNode node) {
		Operation asOperation = node.getReferredOperation();
		if (asOperation instanceof Iteration) {
			return doIterationCallNode(node);
		}
		OperationCallExp asOperationCallExp = doOperationCallNode(node);
		if ((asOperation instanceof Function) && (asOperationCallExp != null)) {
			Operation iOperation = context.createOperation(asOperation);		// Is this really necessary - keep the QVTr reference
			if (iOperation != asOperation) {
				asOperationCallExp.setReferredOperation(iOperation);
			}
		}
		return asOperationCallExp;
	}

	@Override
	public @Nullable TypedElement visitPatternTypedNode(@NonNull PatternTypedNode node) {
		return doPatternNode(node);
	}

	@Override
	public @Nullable TypedElement visitPatternVariableNode(@NonNull PatternVariableNode node) {
		return doPatternNode(node);
	}

	@Override
	public @Nullable TypedElement visitShadowNode(@NonNull ShadowNode node) {
		List<@NonNull ShadowPart> asParts =new ArrayList<>();
		for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(node)) {
			if (edge instanceof ShadowPartEdge) {
				ShadowPartEdge shadowPartEdge = (ShadowPartEdge)edge;
				ShadowPart referredPart = QVTscheduleUtil.getReferredPart(shadowPartEdge);
				Property referredProperty = PivotUtil.getReferredProperty(referredPart);
				Node sourceNode = QVTscheduleUtil.getSourceNode(shadowPartEdge);
				asParts.add(helper.createShadowPart(referredProperty, getExpression(sourceNode)));
			}
		};
		org.eclipse.ocl.pivot.@NonNull Class asClass = node.getClassDatum().getPrimaryClass();
		return helper.createShadowExp(asClass, asParts);
	}

	@Override
	public @NonNull OCLExpression visitStringLiteralNode(@NonNull StringLiteralNode node) {
		return helper.createStringLiteralExp(ClassUtil.nonNullState(node.getStringValue()));
	}

	@Override
	public @Nullable TypedElement visitSuccessNode(@NonNull SuccessNode node) {
		return doPatternNode(node);
	}

	@Override
	public @NonNull OCLExpression visitTypeLiteralNode(@NonNull TypeLiteralNode node) {
		return helper.createTypeExp(ClassUtil.nonNullState(node.getTypeValue()));
	}
}