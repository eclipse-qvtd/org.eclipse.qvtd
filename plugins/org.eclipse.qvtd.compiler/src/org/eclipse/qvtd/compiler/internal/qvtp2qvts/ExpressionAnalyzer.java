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

public class ExpressionAnalyzer extends AbstractExtendingQVTimperativeVisitor<@NonNull Node, @NonNull BasicMappingRegion>
{
	private static final @Nullable String @NonNull [] ifArgNames = new @Nullable String[]{"«condition»", "«then»", "«else»"};
	private static final @Nullable String @NonNull [] mapArgNames = new @Nullable String[]{"«key»", "«value»"};
	private static final @Nullable String @NonNull [] nullArgNames = new @Nullable String[]{null};
	private static final @Nullable String @NonNull [] rangeArgNames = new @Nullable String[]{"«first»", "«last»"};
	private static final @Nullable String @NonNull [] srcArgNames = new @Nullable String[]{"«source»", "«arg»"};

	public class ConditionalExpressionAnalyzer extends ExpressionAnalyzer
	{
		protected ConditionalExpressionAnalyzer() {
			super(ExpressionAnalyzer.this.context);
		}

		@Override
		protected @NonNull NavigationEdge createCastEdge(@NonNull Node sourceNode, @NonNull Property castProperty, @NonNull Node castNode) {
			EdgeRole.Phase phase = Edges.CastEdgeRole.getCastEdgePhase(sourceNode, castNode);
			Edges.CastEdgeRole edgeRole = Edges.CastEdgeRole.getCastEdgeRole(phase, false);
			return edgeRole.createEdge(sourceNode, castProperty, castNode);
		}

		@Override
		protected @NonNull NavigationEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
			EdgeRole.Phase edgePhase = Edges.NavigationEdgeRole.getNavigationEdgePhase(sourceNode, targetNode);
			Edges.NavigationEdgeRole navigationEdgeRole = Edges.NavigationEdgeRole.getNavigationEdgeRole(edgePhase, false);
			return navigationEdgeRole.createEdge(sourceNode, source2targetProperty, targetNode);
		}

		@Override
		protected @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode) {
			return Nodes.createStepNode(name, callExp, sourceNode, false);
		}
	}

	protected final @NonNull SchedulerConstants scheduler;
	private /*@LazyNonNull*/ ConditionalExpressionAnalyzer conditionalExpressionAnalyzer = null;
	//	private /*@LazyNonNull*/ DependencyAnalyzer dependencyAnalyzer;

	protected ExpressionAnalyzer(@NonNull BasicMappingRegion context) {
		super(context);
		this.scheduler = context.getSchedulerConstants();
		//		this.dependencyAnalyzer = getDependencyAnalyzer();
	}

	public @NonNull Node analyze(/*@NonNull*/ Visitable element) {
		Node accept = element.accept(this);
		return accept;
	}

	private @NonNull Node analyzeOperationCallExp_includes(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		Node targetNode = analyze(operationCallExp.getOwnedArguments().get(0));
		String name = operationCallExp.getReferredOperation().getName();
		createPredicateEdge(sourceNode, "«" + name + "»", targetNode);
		return Nodes.TRUE.createNode(sourceNode.getRegion());
	}

	private @NonNull Node analyzeOperationCallExp_oclAsType(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
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
		for (@NonNull NavigationEdge castEdge : sourceNode.getCastEdges()) {
			Node targetNode = castEdge.getTarget();
			predicatedClass = targetNode.getCompleteClass();
			if (predicatedClass.conformsTo(requiredClass)) {
				targetNode.addTypedElement(operationCallExp);
				return targetNode;										// Re-use a pre-existing class
			}
		}
		Type castType = type;
		assert castType != null;
		Property castProperty = scheduler.getCastProperty(castType);
		Edge castEdge = sourceNode.getPredicateEdge(castProperty);
		if (castEdge != null) {
			Node castNode = castEdge.getTarget();
			castNode.addTypedElement(operationCallExp);
			return castNode;
		}
		String name = "a" + castType.getName();
		//		assert name != null;
		Node castNode = createStepNode(name, operationCallExp, sourceNode);
		castEdge = createCastEdge(sourceNode, castProperty, castNode);
		OCLExpression argument = operationCallExp.getOwnedArguments().get(0);
		if (!(argument instanceof TypeExp)) {
			Node argumentNode = analyze(argument);
			createExpressionEdge(argumentNode, "«arg»", castNode);
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

	private @NonNull Node analyzeOperationCallExp_oclIsKindOf(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		OCLExpression argument = operationCallExp.getOwnedArguments().get(0);
		Node operationNode = null;
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
			Node argumentNode = analyze(argument);
			operationNode = findOperationNode(name, sourceNode, argumentNode);
			if (operationNode == null) {
				operationNode = createConnectedOperationNode(name, srcArgNames, operationCallExp, sourceNode, argumentNode);
			}
		}
		return operationNode;
	}

	private @NonNull Node analyzeOperationCallExp_oclContainer(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		Type castType = operationCallExp.getType();
		assert castType != null;
		Property oclContainerProperty = scheduler.getOclContainerProperty();
		Edge oclContainerEdge = sourceNode.getPredicateEdge(oclContainerProperty);
		if (oclContainerEdge != null) {
			return oclContainerEdge.getTarget();
		}
		String name = operationCallExp.getReferredOperation().getName();
		assert name != null;
		Node oclContainerNode = createStepNode(name, operationCallExp, sourceNode);
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

	protected @NonNull Node createConnectedOperationNode(@NonNull String name, @NonNull TypedElement typedElement, @NonNull Node @NonNull ... sourceAndArgumentNodes) {
		Node reusedNode = findOperationNode(name, sourceAndArgumentNodes);
		if (reusedNode != null) {
			reusedNode.addTypedElement(typedElement);
			return reusedNode;
		}
		Node operationNode = createOperationNode(name, typedElement, sourceAndArgumentNodes);
		for (int i = 0; i < sourceAndArgumentNodes.length; i++) {
			createExpressionEdge(ClassUtil.nonNullState(sourceAndArgumentNodes[i]), /*iSize > 1 ?*/ "«arg" + i + "»"/*: null*/, operationNode);
		}
		return operationNode;
	}

	protected @NonNull Node createConnectedOperationNode(@NonNull String name, @Nullable String @NonNull[] argNames, @NonNull TypedElement typedElement, @NonNull Node @NonNull ... sourceAndArgumentNodes) {
		assert argNames.length == sourceAndArgumentNodes.length;
		Node reusedNode = findOperationNode(name, sourceAndArgumentNodes);
		if (reusedNode != null) {
			reusedNode.addTypedElement(typedElement);
			return reusedNode;
		}
		Node operationNode = createOperationNode(name, typedElement, sourceAndArgumentNodes);
		for (int i = 0; i < sourceAndArgumentNodes.length; i++) {
			createExpressionEdge(ClassUtil.nonNullState(sourceAndArgumentNodes[i]), argNames[i], operationNode);
		}
		return operationNode;
	}

	protected @NonNull NavigationEdge createCastEdge(@NonNull Node sourceNode, @NonNull Property castProperty, @NonNull Node castNode) {
		return Edges.CastEdgeRole.createCastEdge(sourceNode, castProperty, castNode);
	}

	protected @NonNull Node createDataTypeNode(@NonNull Node sourceNode, @NonNull NavigationCallExp callExp) {
		return Nodes.createDataTypeNode(sourceNode, callExp);
	}

	protected @NonNull Node createErrorNode(@NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return Nodes.ERROR.createNode(context, name, classDatumAnalysis);
	}

	protected @NonNull Edge createExpressionEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		return Edges.ExpressionEdgeRole.createExpressionEdge(sourceNode, name, targetNode);
	}

	protected @NonNull Edge createIteratedEdge(@NonNull Node sourceNode, @NonNull Node targetNode) {
		return Edges.IteratedEdgeRole.createIteratedEdge(sourceNode, targetNode);
	}

	protected @NonNull Node createIteratorNode(@NonNull Variable iterator, @NonNull Node sourceNode) {
		return Nodes.createIteratorNode(iterator, sourceNode);
	}

	protected @NonNull Node createLetNode(@NonNull Variable letVariable, @NonNull Node inNode) {
		return Nodes.createLetVariableNode(letVariable, inNode);
	}

	protected @NonNull Node createNavigableDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		assert sourceNode.isNavigable();
		return Nodes.createDataTypeNode(sourceNode, source2targetProperty);
	}

	protected @NonNull NavigationEdge createNavigableNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		EdgeRole.Phase edgePhase = Edges.NavigationEdgeRole.getNavigationEdgePhase(sourceNode, targetNode);
		Edges.NavigationEdgeRole navigationEdgeRole = Edges.NavigationEdgeRole.getNavigationEdgeRole(edgePhase, true);
		return navigationEdgeRole.createEdge(sourceNode, source2targetProperty, targetNode);
	}

	protected @NonNull NavigationEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		return Edges.NavigationEdgeRole.createNavigationEdge(sourceNode, source2targetProperty, targetNode);
	}

	protected @NonNull NavigationEdge createNavigationOrRealizedEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		NavigationEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
		assert navigationEdge == null;
		if ((navigationAssignment != null) || context.isPropertyAssignment(sourceNode, source2targetProperty)) {
			navigationEdge = createRealizedNavigationEdge(sourceNode, source2targetProperty, targetNode);
		}
		else {
			navigationEdge = createNavigationEdge(sourceNode, source2targetProperty, targetNode);
		}
		return navigationEdge;
	}

	protected @NonNull Node createNullNode(@NonNull TypedElement typedElement) {
		return Nodes.NULL.createNode(context, typedElement);
	}

	protected @NonNull Node createOperationNode(@NonNull String name, @NonNull TypedElement typedElement, @NonNull Node @NonNull ... argNodes) {
		return Nodes.createOperationNode(context, name, typedElement, argNodes);
	}

	protected @NonNull Edge createPredicateEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		return Edges.PredicateEdgeRole.createPredicateEdge(sourceNode, name, targetNode);
	}

	protected @NonNull Node createPredicatedClassNode(@NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
		return Nodes.PREDICATED_CLASS.createNode(parentNode, navigationAssignment);
	}

	protected @NonNull Node createPredicatedClassNode(@NonNull String name, @NonNull ClassDatumAnalysis classDatumAnalysis) {
		return Nodes.PREDICATED_CLASS.createNode(context, name, classDatumAnalysis);
	}

	protected @NonNull Node createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		return Nodes.createRealizedDataTypeNode(sourceNode, source2targetProperty);
	}

	protected @NonNull Edge createRealizedExpressionEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		Edges.ExpressionEdgeRole expressionEdgeRole = Edges.ExpressionEdgeRole.getExpressionEdgeRole(Role.Phase.REALIZED);
		return expressionEdgeRole.createEdge(sourceNode, name, targetNode);
	}

	protected @NonNull NavigationEdge createRealizedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		Edges.AbstractNavigationEdgeRole navigationEdgeRole = Edges.NavigationEdgeRole.getNavigationEdgeRole(Role.Phase.REALIZED, true);
		return navigationEdgeRole.createEdge(sourceNode, source2targetProperty, targetNode);
	}

	protected @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode) {
		return Nodes.createStepNode(name, callExp, sourceNode, sourceNode.isNavigable());
	}

	protected @Nullable Node findOperationNode(@NonNull String name, @NonNull Node @NonNull ... sourceAndArgumentNodes) {
		if (sourceAndArgumentNodes.length > 0) {
			for (@NonNull Edge searchEdge : sourceAndArgumentNodes[0].getComputationEdges()) {
				Node reusedNode = searchEdge.getTarget();
				if (reusedNode.isOperation() && name.equals(reusedNode.getName())) {
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
							return reusedNode;
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

	/**
	 * Return the navigation edge suitable for navigating from sourceNode to targetNode via source2targetProperty,
	 * re-using an already created edge if available, otherwise creating the edge.
	 */
	protected @NonNull NavigationEdge getNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		if (targetNode.isNull()) {
			return getNavigationEdgeToNull(sourceNode, source2targetProperty, targetNode, navigationAssignment);
		}
		else if (targetNode.isClass() && !targetNode.isOperation()) {		// FIXME rationalize isXXX tests
			return getNavigationEdgeToClass(sourceNode, source2targetProperty, targetNode, navigationAssignment);
		}
		else if (targetNode.isDataType()) {
			return getNavigationEdgeToAttribute(sourceNode, source2targetProperty, targetNode, navigationAssignment);
		}
		else {
			return getNavigationEdgeToExpression(sourceNode, source2targetProperty, targetNode, navigationAssignment);
		}
	}

	protected @NonNull NavigationEdge getNavigationEdgeToAttribute(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		assert targetNode.isDataType();
		Type type = source2targetProperty.getType();
		assert type instanceof DataType;
		NavigationEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
		if (navigationEdge == null) {
			if (!targetNode.isOperation()) {
				navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
			}
			else {
				Node stepNode;
				if (navigationAssignment != null) {
					stepNode = createRealizedDataTypeNode(sourceNode, source2targetProperty);
				}
				else {
					stepNode = createNavigableDataTypeNode(sourceNode, source2targetProperty);
				}
				navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, stepNode, navigationAssignment);
				createExpressionEdge(targetNode, "«equals»", stepNode);
			}
		}
		else {
			//			if (!navigationEdge.isRealized() || targetNode.isRealized()) {
			if (targetNode != navigationEdge.getTarget()) {
				createExpressionEdge(targetNode, "«equals»", navigationEdge.getTarget());
			}
		}
		return navigationEdge;
	}

	protected @NonNull NavigationEdge getNavigationEdgeToClass(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		assert targetNode.isClass();
		NavigationEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
		if (navigationEdge != null) {
			Node target = navigationEdge.getTarget();
			if (target != targetNode) {
				createExpressionEdge(targetNode, "«equals»", target);
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

	protected @NonNull NavigationEdge getNavigationEdgeToExpression(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		assert targetNode.isExpression();
		if (navigationAssignment != null) {
			NavigationEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
			assert navigationEdge == null;
			//			Node valueNode = navigationEdge.getTarget();
			//			assert valueNode.isRealized();
			Type type = source2targetProperty.getType();
			if (type instanceof DataType) {
				Node attributeNode = createRealizedDataTypeNode(sourceNode, source2targetProperty);
				createExpressionEdge(targetNode, "«equals»", attributeNode);
				targetNode = attributeNode;
			}
			else {
				Node stepNode = createPredicatedClassNode(sourceNode, navigationAssignment);
				createExpressionEdge(targetNode, "«equals»", stepNode);
				targetNode = stepNode;
			}
			navigationEdge = createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
			return navigationEdge;
		}
		else {
			NavigationEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
			assert navigationEdge != null;
			Node valueNode = navigationEdge.getTarget();
			assert valueNode.isRealized();
			Type type = source2targetProperty.getType();
			if (type instanceof DataType) {
				createRealizedExpressionEdge(targetNode, null, valueNode);
			}
			else {
				createExpressionEdge(targetNode, null, valueNode);
			}
			return navigationEdge;
		}
	}

	protected @NonNull NavigationEdge getNavigationEdgeToNull(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		assert targetNode.isNull();
		return createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
	}

	private void instantiate(@NonNull Node instantiatedNode, @NonNull Node extraNode) {
		for (@NonNull NavigationEdge extraEdge : extraNode.getNavigationEdges()) {
			if (!extraEdge.isSecondary()) {
				Node extraTargetNode = extraEdge.getTarget();
				String name = extraTargetNode.getName();
				ClassDatumAnalysis classDatumAnalysis = extraTargetNode.getClassDatumAnalysis();
				Node instantiatedTargetNode = createPredicatedClassNode(name, classDatumAnalysis);
				createNavigationEdge(instantiatedNode, extraEdge.getProperty(), instantiatedTargetNode);
				instantiate(instantiatedTargetNode, extraTargetNode);
			}
		}
	}

	@Override
	public @NonNull Node visiting(@NonNull Visitable visitable) {
		throw new UnsupportedOperationException(getClass().getSimpleName() + ": " + visitable.getClass().getSimpleName());
	}

	@Override
	public @NonNull Node visitCollectionLiteralExp(@NonNull CollectionLiteralExp collectionLiteralExp) {
		List<CollectionLiteralPart> ownedParts = collectionLiteralExp.getOwnedParts();
		int iSize = ownedParts.size();
		@NonNull Node[] partNodes = new @NonNull Node[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		Node operationNode = createConnectedOperationNode(ClassUtil.nonNullState(collectionLiteralExp.getKind().toString()), collectionLiteralExp, partNodes);
		return operationNode;
	}

	@Override
	public @NonNull Node visitCollectionItem(@NonNull CollectionItem collectionItem) {
		return analyze(collectionItem.getOwnedItem());
	}

	@Override
	public @NonNull Node visitCollectionRange(@NonNull CollectionRange collectionRange) {
		Node firstNode = analyze(collectionRange.getOwnedFirst());
		Node lastNode = analyze(collectionRange.getOwnedLast());
		Node operationNode = createConnectedOperationNode("..", rangeArgNames, collectionRange, firstNode, lastNode);
		return operationNode;
	}

	@Override
	public @NonNull Node visitElement(@NonNull Element element) {
		Class oclInvalidType = scheduler.getStandardLibrary().getOclInvalidType();
		ClassDatumAnalysis classDatumAnalysis = scheduler.getClassDatumAnalysis(oclInvalidType, scheduler.getDomainAnalysis().getPrimitiveTypeModel());
		Node errorNode = createErrorNode("«error»", classDatumAnalysis);
		for (EObject eObject : element.eContents()) {
			Node node = analyze((Element) eObject);
			createExpressionEdge(node, "?", errorNode);
		}
		return errorNode;
	}

	@Override
	public @NonNull Node visitIfExp(@NonNull IfExp ifExp) {
		ExpressionAnalyzer conditionalExpressionAnalyzer = getConditionalExpressionAnalyzer();
		Node conditionNode = analyze(ifExp.getOwnedCondition());
		Node thenNode = conditionalExpressionAnalyzer.analyze(ifExp.getOwnedThen());
		Node elseNode = conditionalExpressionAnalyzer.analyze(ifExp.getOwnedElse());
		Node ifNode = createConnectedOperationNode("if", ifArgNames, ifExp, conditionNode, thenNode, elseNode);
		return ifNode;
	}

	@Override
	public @NonNull Node visitLetExp(@NonNull LetExp letExp) {
		Variable ownedVariable = letExp.getOwnedVariable();
		Node initNode = analyze(ownedVariable.getOwnedInit());
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
			Node varNode = createLetNode(ownedVariable, initNode);
			Property castProperty = scheduler.getCastProperty(type);
			createNavigationEdge(initNode, castProperty, varNode);
		}
		return analyze(letExp.getOwnedIn());
	}

	@Override
	public @NonNull Node visitLiteralExp(@NonNull LiteralExp literalExp) {
		Node operationNode = createOperationNode(ClassUtil.nonNullState(literalExp.toString()), literalExp);
		return operationNode;
	}

	@Override
	public @NonNull Node visitLoopExp(@NonNull LoopExp loopExp) {
		assert !loopExp.isIsSafe();
		Node sourceNode = analyze(loopExp.getOwnedSource());
		List<@NonNull Variable> ownedIterators = ClassUtil.nullFree(loopExp.getOwnedIterators());
		@NonNull Node[] argNodes = new @NonNull Node[1+ownedIterators.size()+(loopExp instanceof IterateExp ? 1 : 0)];
		int i = 1;
		for (@NonNull Variable iterator : ownedIterators) {
			Node iteratorNode = createIteratorNode(iterator, sourceNode);
			Type iteratorType = iterator.getType();
			assert iteratorType != null;
			//			Property iterateProperty = context.getSchedulerConstants().getIterateProperty(iteratorType);
			createIteratedEdge(sourceNode, iteratorNode);
			argNodes[i++] = iteratorNode;
		}
		if (loopExp instanceof IterateExp) {
			Variable accumulator = ((IterateExp)loopExp).getOwnedResult();
			assert accumulator != null;
			Node iteratorNode = createIteratorNode(accumulator, sourceNode);
			Type iteratorType = accumulator.getType();
			assert iteratorType != null;
			//			Property iterateProperty = context.getSchedulerConstants().getIterateProperty(iteratorType);
			createIteratedEdge(sourceNode, iteratorNode);
			argNodes[i++] = iteratorNode;
		}
		Node bodyNode = analyze(loopExp.getOwnedBody());
		argNodes[0] = bodyNode;
		String iterationName = "«" + loopExp.getReferredIteration().getName() + "»";
		Node accumulateNode = createOperationNode(iterationName, loopExp, argNodes);
		createExpressionEdge(sourceNode, "«source»", accumulateNode);
		createExpressionEdge(bodyNode, "«body»", accumulateNode);
		i = 1;
		for (@NonNull Variable iterator : ownedIterators) {
			Node iteratorNode = argNodes[i++];
			assert iteratorNode != null;
			createExpressionEdge(iteratorNode, iterator.getName() , accumulateNode);
		}
		return accumulateNode;
	}

	@Override
	public @NonNull Node visitMapLiteralExp(@NonNull MapLiteralExp mapLiteralExp) {
		List<MapLiteralPart> ownedParts = mapLiteralExp.getOwnedParts();
		int iSize = ownedParts.size();
		@NonNull Node[] partNodes = new @NonNull Node[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		Node operationNode = createConnectedOperationNode(ClassUtil.nonNullState(mapLiteralExp.getName()), mapLiteralExp, partNodes);
		return operationNode;
	}

	@Override
	public @NonNull Node visitMapLiteralPart(@NonNull MapLiteralPart mapLiteralPart) {
		OCLExpression ownedValue = mapLiteralPart.getOwnedValue();
		assert ownedValue != null;
		Node keyNode = analyze(mapLiteralPart.getOwnedKey());
		Node valueNode = analyze(ownedValue);
		Node operationNode = createConnectedOperationNode("Part", mapArgNames, ownedValue, keyNode, valueNode);
		return operationNode;
	}

	@Override
	public @NonNull Node visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		Node slotNode = analyze(asNavigationAssignment.getSlotExpression());
		assert slotNode.isClass();
		Property property = QVTcoreBaseUtil.getTargetProperty(asNavigationAssignment);
		assert property != null;
		Node targetNode = analyze(asNavigationAssignment.getValue());
		NavigationEdge navigationEdge = getNavigationEdge(slotNode, property, targetNode, asNavigationAssignment);
		Node valueNode = navigationEdge.getTarget();
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
		return slotNode;
	}

	@Override
	public @NonNull Node visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
		assert !navigationCallExp.isIsSafe();
		Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
		assert referredProperty != null;
		OCLExpression ownedSource = navigationCallExp.getOwnedSource();
		assert ownedSource != null;
		Node sourceNode = analyze(ownedSource);
		if (sourceNode.isClass()) {
			if (!referredProperty.isIsMany()) {
				NavigationEdge navigationEdge = sourceNode.getNavigationEdge(referredProperty);
				if (navigationEdge != null) {
					return navigationEdge.getTarget();
				}
			}
			Type type = referredProperty.getType();
			assert type != null;
			Node targetNode;
			if (type instanceof DataType) {
				targetNode = sourceNode.getNavigationTarget(referredProperty);
				if (targetNode == null) {
					targetNode = createDataTypeNode(sourceNode, navigationCallExp);
				}
			}
			else {
				String name = referredProperty.getName();
				assert name != null;
				targetNode = createStepNode(name, navigationCallExp, sourceNode);
			}
			getNavigationEdge(sourceNode, referredProperty, targetNode, null);
			return targetNode;
		}
		return context.getUnknownNode(ownedSource);
	}

	@Override
	public @NonNull Node visitNullLiteralExp(@NonNull NullLiteralExp nullLiteralExp) {
		return createNullNode(nullLiteralExp);
	}

	@Override
	public @NonNull Node visitOCLExpression(@NonNull OCLExpression oclExpression) {
		return context.getUnknownNode(oclExpression);
	}

	@Override
	public @NonNull Node visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
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
			@NonNull Node[] argNodes = new @NonNull Node[iSize];
			@Nullable String [] argNames = new @Nullable String[iSize];
			for (int i = 0; i < iSize; i++) {
				argNodes[i] = analyze(ownedArguments.get(i));
				argNames[i] = "«" + referredOperation.getOwnedParameters().get(i).getName() + "»";
			}
			Node operationNode = createConnectedOperationNode(operationName, argNames, operationCallExp, argNodes);
			return operationNode;
		}
		Node sourceNode = analyze(ownedSource);
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
			@NonNull Node[] argNodes = new @NonNull Node[iSize+1];
			@Nullable String [] argNames = new @Nullable String[iSize+1];
			argNodes[0] = sourceNode;
			argNames[0] = "«self»";
			for (int i = 0; i < iSize; i++) {
				argNodes[i+1] = analyze(ownedArguments.get(i));
				argNames[i+1] = "«" + referredOperation.getOwnedParameters().get(i).getName() + "»";
			}
			if ("<>".equals(operationName)) {
				operationName.toString();
			}
			Node operationNode = findOperationNode(operationName, argNodes);
			if (operationNode == null) {
				operationNode = createOperationNode(operationName, operationCallExp, argNodes);
				for (int i = 0; i <= iSize; i++) {
					createExpressionEdge(argNodes[i], argNames[i], operationNode);
				}
				if (referredOperation.getBodyExpression() != null) {
					OperationRegion operationRegion = context.getMultiRegion().analyzeOperation(operationCallExp);
					List<@NonNull Node> extraNodes = operationRegion.getExtraNodes();
					if (extraNodes.size() > 0) {
						for (@NonNull Node extraNode : extraNodes) {
							ClassDatumAnalysis classDatumAnalysis = extraNode.getClassDatumAnalysis();
							Node extraGuard = context.getExtraGuard(classDatumAnalysis);
							if (extraGuard == null) {
								extraGuard = context.createExtraGuard(classDatumAnalysis);
								createExpressionEdge(extraGuard, extraGuard.getName(), operationNode);
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
	public @NonNull Node visitOppositePropertyAssignment(@NonNull OppositePropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
	}

	@Override
	public @NonNull Node visitPropertyAssignment(@NonNull PropertyAssignment asNavigationAssignment) {
		return visitNavigationAssignment(asNavigationAssignment);
	}

	@Override
	public @NonNull Node visitShadowExp(@NonNull ShadowExp shadowExp) {
		List<ShadowPart> ownedParts = shadowExp.getOwnedParts();
		int iSize = ownedParts.size();
		@NonNull Node [] partNodes = new @NonNull Node[iSize];
		@Nullable String [] partNames = new @Nullable String[iSize];
		for (int i = 0; i < iSize; i++) {
			ShadowPart shadowPart = ownedParts.get(i);
			partNodes[i] = analyze(shadowPart);
			partNames[i] = shadowPart.getName();
		}
		Node operationNode = createConnectedOperationNode(ClassUtil.nonNullState(shadowExp.getType().getName()), partNames, shadowExp, partNodes);
		return operationNode;
	}

	@Override
	public @NonNull Node visitShadowPart(@NonNull ShadowPart shadowPart) {
		Node partNode = analyze(shadowPart.getOwnedInit());
		Node operationNode = createConnectedOperationNode(ClassUtil.nonNullState(shadowPart.getName()), shadowPart, partNode);
		return operationNode;
	}

	@Override
	public @NonNull Node visitTupleLiteralExp(@NonNull TupleLiteralExp tupleLiteralExp) {
		List<TupleLiteralPart> ownedParts = tupleLiteralExp.getOwnedParts();
		int iSize = ownedParts.size();
		@NonNull Node[] partNodes = new @NonNull Node[iSize];
		for (int i = 0; i < iSize; i++) {
			partNodes[i] = analyze(ownedParts.get(i));
		}
		Node operationNode = createConnectedOperationNode(ClassUtil.nonNullState(tupleLiteralExp.getName()), tupleLiteralExp, partNodes);
		return operationNode;
	}

	@Override
	public @NonNull Node visitTupleLiteralPart(@NonNull TupleLiteralPart tupleLiteralPart) {
		Node partNode = analyze(tupleLiteralPart.getOwnedInit());
		Node operationNode = createConnectedOperationNode(ClassUtil.nonNullState(tupleLiteralPart.getName()), tupleLiteralPart, partNode);
		return operationNode;
	}

	@Override
	public @NonNull Node visitTypeExp(@NonNull TypeExp typeExp) {
		DomainUsage domainUsage = scheduler.getDomainUsage(typeExp);
		Type referredType = typeExp.getReferredType();
		assert referredType != null;
		TypedModel typedModel = domainUsage.getTypedModel(typeExp);
		assert typedModel != null;
		ClassDatumAnalysis classDatumAnalysis = scheduler.getClassDatumAnalysis((org.eclipse.ocl.pivot.Class)referredType, typedModel);
		String typeName = PrettyPrinter.printType(classDatumAnalysis.getCompleteClass());
		Node operationNode = createConnectedOperationNode(typeName, typeExp);
		return operationNode;
	}

	@Override
	public @NonNull Node visitVariableExp(@NonNull VariableExp variableExp) {
		VariableDeclaration referredVariable = variableExp.getReferredVariable();
		assert referredVariable != null;
		return context.getReferenceNode(referredVariable);
	}
}