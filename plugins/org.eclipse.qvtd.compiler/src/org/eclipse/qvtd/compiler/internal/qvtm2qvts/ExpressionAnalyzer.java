/*******************************************************************************
 * Copyright (c) 2015, 2017 Willink Transformations and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   E.D.Willink - Initial API and implementation
 *******************************************************************************/
package org.eclipse.qvtd.compiler.internal.qvtm2qvts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
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
import org.eclipse.ocl.pivot.internal.prettyprint.PrettyPrinter;
import org.eclipse.ocl.pivot.util.Visitable;
import org.eclipse.ocl.pivot.utilities.ClassUtil;
import org.eclipse.ocl.pivot.utilities.EnvironmentFactory;
import org.eclipse.ocl.pivot.utilities.PivotUtil;
import org.eclipse.qvtd.compiler.internal.utilities.CompilerUtil;
import org.eclipse.qvtd.pivot.qvtbase.Predicate;
import org.eclipse.qvtd.pivot.qvtbase.Transformation;
import org.eclipse.qvtd.pivot.qvtbase.TypedModel;
import org.eclipse.qvtd.pivot.qvtbase.utilities.QVTbaseUtil;
import org.eclipse.qvtd.pivot.qvtbase.utilities.StandardLibraryHelper;
import org.eclipse.qvtd.pivot.qvtcore.NavigationAssignment;
import org.eclipse.qvtd.pivot.qvtcore.OppositePropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.PropertyAssignment;
import org.eclipse.qvtd.pivot.qvtcore.VariableAssignment;
import org.eclipse.qvtd.pivot.qvtcore.util.AbstractExtendingQVTcoreVisitor;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreHelper;
import org.eclipse.qvtd.pivot.qvtcore.utilities.QVTcoreUtil;
import org.eclipse.qvtd.pivot.qvtschedule.RuleRegion;
import org.eclipse.qvtd.pivot.qvtschedule.ClassDatum;
import org.eclipse.qvtd.pivot.qvtschedule.Edge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigableEdge;
import org.eclipse.qvtd.pivot.qvtschedule.NavigationEdge;
import org.eclipse.qvtd.pivot.qvtschedule.Node;
import org.eclipse.qvtd.pivot.qvtschedule.OperationRegion;
import org.eclipse.qvtd.pivot.qvtschedule.impl.RuleRegionImpl;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.DomainUsage;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleConstants;
import org.eclipse.qvtd.pivot.qvtschedule.utilities.QVTscheduleUtil;

import com.google.common.collect.Iterables;

public class ExpressionAnalyzer extends AbstractExtendingQVTcoreVisitor<@Nullable Node, @NonNull RuleAnalysis>
{
	private static final @NonNull String @NonNull [] ifArgNames = new @NonNull String[]{QVTscheduleConstants.IF_CONDITION_NAME, QVTscheduleConstants.IF_THEN_NAME, QVTscheduleConstants.IF_ELSE_NAME};
	private static final @NonNull String @NonNull [] mapArgNames = new @NonNull String[]{"«key»", "«value»"};
	private static final @NonNull String @NonNull [] nullArgNames = new @NonNull String[]{QVTscheduleConstants.EQUALS_NAME};
	private static final @NonNull String @NonNull [] rangeArgNames = new @NonNull String[]{"«first»", "«last»"};
	private static final @NonNull String @NonNull [] srcArgNames = new @NonNull String[]{"«source»", "«arg»"};

	public class ConditionalExpressionAnalyzer extends ExpressionAnalyzer
	{
		protected ConditionalExpressionAnalyzer() {
			super(ExpressionAnalyzer.this.regionHelper, ExpressionAnalyzer.this.context);
		}

		@Override
		protected @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode) {
			return regionHelper.createStepNode(name, callExp, sourceNode, false);
		}

		@Override
		protected boolean isUnconditional() {
			return false;
		}
	}

	protected final @NonNull RegionHelper regionHelper;
	protected final @NonNull ScheduleManager scheduleManager;
	protected final @NonNull EnvironmentFactory environmentFactory;
	protected final @NonNull QVTcoreHelper helper;
	protected final @NonNull StandardLibraryHelper standardLibraryHelper;
	private /*@LazyNonNull*/ ConditionalExpressionAnalyzer conditionalExpressionAnalyzer = null;
	//	private /*@LazyNonNull*/ OperationDependencyAnalysis operationDependencyAnalysis;

	/**
	 * Map from the non-trivial side of an "=" expression to the known node for a variable on the other side. This avoids the need to create a redundant
	 * node for the other side with an «equals» edge to tie them together.
	 */
	private @Nullable Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode;

	protected ExpressionAnalyzer(@NonNull RegionHelper regionHelper, @NonNull RuleAnalysis context) {
		super(context);
		this.regionHelper = regionHelper;
		this.scheduleManager = regionHelper.getScheduleManager();
		this.environmentFactory = scheduleManager.getEnvironmentFactory();
		this.helper = new QVTcoreHelper(environmentFactory);
		this.standardLibraryHelper = new StandardLibraryHelper(environmentFactory.getStandardLibrary());
		//		this.operationDependencyAnalysis = getOperationDependencyAnalysis();
	}

	public @NonNull Node analyze(/*@NonNull*/ Visitable element) {
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
	private @Nullable Node analyzeOperationCallExp_equals(@NonNull OperationCallExp operationCallExp) {
		OCLExpression asSource = QVTcoreUtil.getOwnedSource(operationCallExp);
		OCLExpression asTarget = QVTcoreUtil.getOwnedArgument(operationCallExp, 0);
		Node sourceNode;
		Node targetNode;
		if (asSource instanceof VariableExp) {
			VariableDeclaration referredVariable = QVTcoreUtil.getReferredVariable((VariableExp)asSource);
			RuleRegion ruleRegion = context.getRuleRegion();
			sourceNode = ruleRegion.getNode(referredVariable);
			if (sourceNode != null) {
				Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode2 = expression2knownNode;
				if (expression2knownNode2 == null) {
					expression2knownNode = expression2knownNode2 = new HashMap<>();
				}
				expression2knownNode2.put(asTarget, sourceNode);
			}
			targetNode = analyze(asTarget);
			if (targetNode == sourceNode) {
				return null;
			}
			else {
				//				scheduleManager.addRegionError(ruleRegion, "Failed to unify simple equality predicate " + operationCallExp);
				sourceNode = analyze(asSource);
			}
		}
		else if (asTarget instanceof VariableExp) {
			VariableDeclaration referredVariable = QVTcoreUtil.getReferredVariable((VariableExp)asTarget);
			RuleRegionImpl ruleRegion = (RuleRegionImpl)context.getRuleRegion();
			targetNode = ruleRegion.getNode(referredVariable);
			if (targetNode != null) {
				Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode2 = expression2knownNode;
				if (expression2knownNode2 == null) {
					expression2knownNode = expression2knownNode2 = new HashMap<>();
				}
				expression2knownNode2.put(asSource, targetNode);
			}
			sourceNode = analyze(asSource);
			if (targetNode == sourceNode) {
				return null;
			}
			else {
				//				scheduleManager.addRegionError(ruleRegion, "Failed to unify simple equality predicate " + operationCallExp);
				targetNode = analyze(asTarget);
			}
		}
		else if (asSource instanceof NavigationCallExp) {
			targetNode = analyze(asTarget);
			if (!targetNode.isDataType()) {
				Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode2 = expression2knownNode;
				if (expression2knownNode2 == null) {
					expression2knownNode = expression2knownNode2 = new HashMap<>();
				}
				expression2knownNode2.put(asSource, targetNode);
			}
			sourceNode = analyze(asSource);
			if (targetNode == sourceNode) {
				return null;
			}
			//				scheduleManager.addRegionError(ruleRegion, "Failed to unify simple equality predicate " + operationCallExp);
		}
		else {
			sourceNode = analyze(asSource);
			if (!sourceNode.isDataType()) {
				Map<@NonNull OCLExpression, @NonNull Node> expression2knownNode2 = expression2knownNode;
				if (expression2knownNode2 == null) {
					expression2knownNode = expression2knownNode2 = new HashMap<>();
				}
				expression2knownNode2.put(asTarget, sourceNode);
			}
			targetNode = analyze(asTarget);
			if (targetNode == sourceNode) {
				return null;
			}
			//				scheduleManager.addRegionError(ruleRegion, "Failed to unify simple equality predicate " + operationCallExp);
		}
		//		createPredicateEdge(sourceNode, "«equals»", targetNode);
		createExpressionEdge(targetNode, QVTscheduleConstants.EQUALS_NAME, sourceNode);
		return null;
	}

	private @Nullable Node analyzeOperationCallExp_includes(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		Node targetNode = analyze(operationCallExp.getOwnedArguments().get(0));
		String name = operationCallExp.getReferredOperation().getName();
		createPredicateEdge(sourceNode, "«" + name + "»", targetNode);
		if (sourceNode.isDataType()) {		// expecting a CollectionType
			for (@NonNull Edge edge : QVTscheduleUtil.getIncomingEdges(sourceNode)) {
				if (edge instanceof NavigationEdge) {
					NavigationEdge navigationEdge = (NavigationEdge)edge;
					Property property = navigationEdge.getProperty();
					Property oppositeProperty = property.getOpposite();
					if ((oppositeProperty != null) && !oppositeProperty.isIsMany()) {
						createNavigationEdge(targetNode, oppositeProperty, QVTscheduleUtil.getSourceNode(navigationEdge), false);
					}
				}
			}
		}
		return null;
	}

	private @NonNull Node analyzeOperationCallExp_oclAsType(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		//		if ((operationCallExp.getOwnedSource() instanceof CallExp) && sourceNode.refineClassDatumAnalysis(scheduler.getClassDatumAnalysis(operationCallExp))) {
		//			return sourceNode;
		//		}
		Type castType = QVTcoreUtil.getType(operationCallExp);
		CompleteClass requiredClass = environmentFactory.getCompleteModel().getCompleteClass(castType);
		CompleteClass predicatedClass = sourceNode.getCompleteClass();
		if (predicatedClass.conformsTo(requiredClass)) {
			sourceNode.addTypedElement(operationCallExp);
			return sourceNode;											// Skip cast if already conformant, typically a redundant cast daisy chain
		}
		for (@NonNull NavigableEdge castEdge : sourceNode.getCastEdges()) {
			Node targetNode = castEdge.getEdgeTarget();
			predicatedClass = targetNode.getCompleteClass();
			if (predicatedClass.conformsTo(requiredClass)) {
				targetNode.addTypedElement(operationCallExp);
				return targetNode;										// Re-use a pre-existing class
			}
		}
		Property castProperty = scheduleManager.getCastProperty(castType);
		Edge castEdge = sourceNode.getPredicateEdge(castProperty);
		if (castEdge != null) {
			Node castNode = castEdge.getEdgeTarget();
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
			String name = QVTcoreUtil.getName(QVTcoreUtil.getReferredOperation(operationCallExp));
			Node argumentNode = analyze(argument);
			operationNode = findOperationNode(name, sourceNode, argumentNode);
			if (operationNode == null) {
				operationNode = createConnectedOperationNode(name, srcArgNames, operationCallExp, sourceNode, argumentNode);
			}
		}
		return operationNode;
	}

	private @NonNull Node analyzeOperationCallExp_oclContainer(@NonNull Node sourceNode, @NonNull OperationCallExp operationCallExp) {
		//		Type castType = QVTcoreUtil.getType(operationCallExp);
		Property oclContainerProperty = standardLibraryHelper.getOclContainerProperty();
		Edge oclContainerEdge = sourceNode.getPredicateEdge(oclContainerProperty);
		if (oclContainerEdge != null) {
			return oclContainerEdge.getEdgeTarget();
		}
		String name = QVTcoreUtil.getName(QVTcoreUtil.getReferredOperation(operationCallExp));
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

	protected @NonNull Node createConnectedOperationNode(@NonNull String name, @NonNull String @NonNull[] argNames, @NonNull TypedElement typedElement, @NonNull Node @NonNull ... sourceAndArgumentNodes) {
		assert argNames.length == sourceAndArgumentNodes.length;
		Node reusedNode = findOperationNode(name, sourceAndArgumentNodes);
		if (reusedNode != null) {
			reusedNode.addTypedElement(typedElement);
			return reusedNode;
		}
		boolean isMatched = QVTscheduleUtil.isMatched(typedElement);
		ExpressionAnalyzer nestedAnalyzer = isMatched ? this : getConditionalExpressionAnalyzer();
		String nodeName = CompilerUtil.recoverVariableName(typedElement);
		if (nodeName == null) {
			nodeName = name;
		}
		Node operationNode = nestedAnalyzer.createOperationNode(nodeName, typedElement, sourceAndArgumentNodes);
		for (int i = 0; i < sourceAndArgumentNodes.length; i++) {
			nestedAnalyzer.createExpressionEdge(ClassUtil.nonNullState(sourceAndArgumentNodes[i]), argNames[i], operationNode);
		}
		return operationNode;
	}

	protected @NonNull NavigableEdge createCastEdge(@NonNull Node sourceNode, @NonNull Property castProperty, @NonNull Node castNode) {
		return regionHelper.createCastEdge(sourceNode, castProperty, castNode);
	}

	protected @NonNull Node createDataTypeNode(@NonNull String name, @NonNull Node sourceNode, @NonNull NavigationCallExp navigationCallExp) {
		return regionHelper.createDataTypeNode(name, sourceNode, navigationCallExp);
	}

	protected @NonNull Node createDependencyNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		return regionHelper.createDependencyNode(name, classDatum);
	}

	protected @NonNull Node createErrorNode(@NonNull String name, @NonNull ClassDatum classDatum) {
		return regionHelper.createErrorNode(name, classDatum);
	}

	protected @NonNull Edge createExpressionEdge(@NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		return regionHelper.createExpressionEdge(sourceNode, name, targetNode);
	}

	protected @NonNull Edge createIteratedEdge(@NonNull Node sourceNode, @NonNull String name, @NonNull Node targetNode) {
		return regionHelper.createIteratedEdge(sourceNode, name, targetNode);
	}

	protected @NonNull Node createIteratorNode(@NonNull Variable iterator, @NonNull Node sourceNode) {
		return regionHelper.createIteratorNode(iterator, sourceNode);
	}

	protected @NonNull Node createLetNode(@NonNull Variable letVariable, @NonNull Node inNode) {
		return regionHelper.createLetVariableNode(letVariable, inNode);
	}

	protected @NonNull Node createNavigableDataTypeNode(@NonNull Node targetNode, @NonNull NavigationAssignment navigationAssignment) {
		return regionHelper.createDataTypeNode(targetNode, navigationAssignment);
	}

	protected @NonNull Node createNavigableDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		assert sourceNode.isMatched();
		return regionHelper.createDataTypeNode(sourceNode, source2targetProperty);
	}

	protected @NonNull NavigableEdge createNavigableNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode) {
		return regionHelper.createNavigationEdge(sourceNode, source2targetProperty, targetNode, false);
	}

	protected @NonNull NavigableEdge createNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		return regionHelper.createNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
	}

	protected @NonNull NavigableEdge createNavigationOrRealizedEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		NavigableEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
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

	protected @NonNull Node createNullNode(@NonNull TypedElement typedElement) {
		return regionHelper.createNullNode(isUnconditional(), typedElement);
	}

	protected @NonNull Node createOperationNode(@NonNull String name, @NonNull TypedElement typedElement, @NonNull Node @NonNull ... argNodes) {
		return regionHelper.createOperationNode(isUnconditional(), name, typedElement, argNodes);
	}

	protected @NonNull Edge createPredicateEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		return regionHelper.createPredicateEdge(sourceNode, name, targetNode);
	}

	protected @NonNull Node createPredicatedClassNode(@NonNull Node parentNode, @NonNull NavigationAssignment navigationAssignment) {
		return regionHelper.createDependencyClassNode(parentNode, navigationAssignment);
	}

	protected @NonNull Node createRealizedDataTypeNode(@NonNull Node sourceNode, @NonNull Property source2targetProperty) {
		return regionHelper.createRealizedDataTypeNode(sourceNode, source2targetProperty);
	}

	protected @NonNull Edge createRealizedExpressionEdge(@NonNull Node sourceNode, @Nullable String name, @NonNull Node targetNode) {
		return regionHelper.createRealizedExpressionEdge(sourceNode, name, targetNode);
	}

	protected @NonNull NavigableEdge createRealizedNavigationEdge(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable Boolean isPartial) {
		return regionHelper.createRealizedNavigationEdge(sourceNode, source2targetProperty, targetNode, isPartial);
	}

	protected @NonNull Node createStepNode(@NonNull String name, @NonNull CallExp callExp, @NonNull Node sourceNode) {
		return regionHelper.createStepNode(name, callExp, sourceNode, sourceNode.isMatched() && QVTscheduleUtil.isMatched(callExp));
	}

	protected @Nullable Node findOperationNode(@NonNull String name, @NonNull Node @NonNull ... sourceAndArgumentNodes) {
		if (sourceAndArgumentNodes.length > 0) {
			for (@NonNull Edge searchEdge : sourceAndArgumentNodes[0].getComputationEdges()) {
				Node reusedNode = searchEdge.getEdgeTarget();
				if (reusedNode.isOperation() && name.equals(reusedNode.getName())) {
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
		return null;
	}

	private @NonNull ExpressionAnalyzer getConditionalExpressionAnalyzer() {
		ConditionalExpressionAnalyzer conditionalExpressionAnalyzer2 = conditionalExpressionAnalyzer;
		if (conditionalExpressionAnalyzer2 == null) {
			conditionalExpressionAnalyzer = conditionalExpressionAnalyzer2 = new ConditionalExpressionAnalyzer();
		}
		return conditionalExpressionAnalyzer2;
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
		if (targetNode.isExplicitNull()) {
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
		NavigableEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
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
						regionHelper.createEqualsEdge(targetNode, stepNode);
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
				regionHelper.createEqualsEdge(targetNode, navigationEdge.getEdgeTarget());
			}
		}
		return navigationEdge;
	}

	protected @NonNull NavigableEdge getNavigationEdgeToClass(@NonNull Node sourceNode, @NonNull Property source2targetProperty, @NonNull Node targetNode, @Nullable NavigationAssignment navigationAssignment) {
		assert targetNode.isClass();
		NavigableEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
		if (navigationEdge != null) {
			Node target = navigationEdge.getEdgeTarget();
			if (target != targetNode) {
				regionHelper.createEqualsEdge(targetNode, target);
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
			NavigableEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
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
			NavigableEdge navigationEdge = sourceNode.getNavigationEdge(source2targetProperty);
			if (navigationEdge != null) {
				Node valueNode = navigationEdge.getEdgeTarget();
				assert valueNode.isRealized();
				Type type = source2targetProperty.getType();
				Edge equalsEdge = regionHelper.createEqualsEdge(targetNode, valueNode);
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
		assert targetNode.isExplicitNull();
		return createNavigationOrRealizedEdge(sourceNode, source2targetProperty, targetNode, navigationAssignment);
	}

	private void instantiate(@NonNull Node instantiatedNode, @NonNull Node referenceNode) {
		for (@NonNull NavigableEdge referenceEdge : referenceNode.getNavigationEdges()) {
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

	protected boolean isUnconditional() {
		return true;
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
		Class oclInvalidType = scheduleManager.getStandardLibrary().getOclInvalidType();
		ClassDatum classDatum = scheduleManager.getClassDatum(oclInvalidType, scheduleManager.getDomainAnalysis().getPrimitiveTypeModel());
		Node errorNode = createErrorNode("«error»", classDatum);
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
		Type type = QVTcoreUtil.getType(ownedVariable);
		CompleteClass actualClass = initNode.getCompleteClass();
		ClassDatum classDatum = scheduleManager.getClassDatum(ownedVariable);
		CompleteClass requiredClass = QVTscheduleUtil.getCompleteClass(classDatum);
		if (actualClass.conformsTo(requiredClass)) {
			context.getRuleRegion().addVariableNode(ownedVariable, initNode);
			initNode.addTypedElement(ownedVariable);
		}
		else {
			Node varNode = createLetNode(ownedVariable, initNode);
			Property castProperty = scheduleManager.getCastProperty(type);
			createNavigationEdge(initNode, castProperty, varNode, false);
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
			@SuppressWarnings("unused")
			Type iteratorType = QVTcoreUtil.getType(iterator);
			//			Property iterateProperty = context.getScheduleModel().getIterateProperty(iteratorType);
			createIteratedEdge(sourceNode, QVTscheduleConstants.LOOP_ITERATOR_NAME, iteratorNode);
			argNodes[i++] = iteratorNode;
		}
		if (loopExp instanceof IterateExp) {
			Variable accumulator = QVTcoreUtil.getOwnedResult((IterateExp)loopExp);
			Node iteratorNode = createIteratorNode(accumulator, sourceNode);
			@SuppressWarnings("unused")
			Type iteratorType = QVTcoreUtil.getType(accumulator);
			//			Property iterateProperty = context.getScheduleModel().getIterateProperty(iteratorType);
			createIteratedEdge(sourceNode, QVTscheduleConstants.LOOP_ITERATOR_NAME, iteratorNode);
			argNodes[i++] = iteratorNode;
		}
		Node bodyNode = getConditionalExpressionAnalyzer().analyze(loopExp.getOwnedBody());
		argNodes[0] = bodyNode;
		String iterationName = "«" + loopExp.getReferredIteration().getName() + "»";
		Node accumulateNode = createOperationNode(iterationName, loopExp, argNodes);
		createExpressionEdge(sourceNode, "«source»", accumulateNode);
		createExpressionEdge(bodyNode, QVTscheduleConstants.LOOP_BODY_NAME, accumulateNode);
		i = 1;
		for (@NonNull Variable iterator : ownedIterators) {
			@NonNull Node iteratorNode = argNodes[i++];
			createExpressionEdge(iteratorNode, "«" + iterator.getName() + "»", accumulateNode);
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
		OCLExpression ownedValue = QVTcoreUtil.getOwnedValue(mapLiteralPart);
		Node keyNode = analyze(mapLiteralPart.getOwnedKey());
		Node valueNode = analyze(ownedValue);
		Node operationNode = createConnectedOperationNode("Part", mapArgNames, ownedValue, keyNode, valueNode);
		return operationNode;
	}

	@Override
	public @NonNull Node visitNavigationAssignment(@NonNull NavigationAssignment asNavigationAssignment) {
		Node slotNode = analyze(asNavigationAssignment.getSlotExpression());
		assert slotNode.isClass();
		Property property = QVTcoreUtil.getTargetProperty(asNavigationAssignment);
		OCLExpression value = QVTcoreUtil.getValue(asNavigationAssignment);
		helper.rewriteSafeNavigations(value);
		Node targetNode = analyze(value);
		NavigableEdge navigationEdge = getNavigationEdge(slotNode, property, targetNode, asNavigationAssignment);
		Node valueNode = navigationEdge.getEdgeTarget();
		CompleteClass valueCompleteClass = valueNode.getCompleteClass();
		Type propertyType = PivotUtil.getType(property);
		if (asNavigationAssignment.isIsPartial()) {
			propertyType = PivotUtil.getElementType(((CollectionType)propertyType));
		}
		CompleteClass targetCompleteClass = environmentFactory.getCompleteModel().getCompleteClass(propertyType);
		if (!QVTscheduleUtil.conformsToClassOrBehavioralClass(valueCompleteClass, targetCompleteClass)) {	// Allow value to be physical or behavioral
			// FIXME we could synthesize a cast, but it's easier to do oclAsType() in QVTm
			if (!valueCompleteClass.conformsTo(targetCompleteClass.getBehavioralClass()) && !valueCompleteClass.conformsTo(targetCompleteClass.getBehavioralClass())) {
				throw new IllegalStateException("Incompatible types " + valueCompleteClass + ", " + targetCompleteClass + " for " + asNavigationAssignment);
			}
		}
		return slotNode;
	}

	@Override
	public @NonNull Node visitNavigationCallExp(@NonNull NavigationCallExp navigationCallExp) {
		assert !navigationCallExp.isIsSafe();
		Property referredProperty = PivotUtil.getReferredProperty(navigationCallExp);
		OCLExpression ownedSource = QVTcoreUtil.getOwnedSource(navigationCallExp);
		Node sourceNode = analyze(ownedSource);
		if (sourceNode.isClass()) {
			if (!referredProperty.isIsMany()) {
				NavigableEdge navigationEdge = sourceNode.getNavigationEdge(referredProperty);
				if (navigationEdge != null) {
					return navigationEdge.getEdgeTarget();
				}
			}
			String name = CompilerUtil.recoverVariableName(navigationCallExp);
			if (name == null) {
				name = QVTcoreUtil.getName(referredProperty);
			}
			Type type = QVTcoreUtil.getType(referredProperty);
			Node targetNode = expression2knownNode != null ? expression2knownNode.get(navigationCallExp) : null;
			if (targetNode == null) {
				if (type instanceof DataType) {
					targetNode = sourceNode.getNavigationTarget(referredProperty);
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
	public @Nullable Node visitOperationCallExp(@NonNull OperationCallExp operationCallExp) {
		if (isUnconditional()) {
			boolean isMatched = QVTscheduleUtil.isMatched(operationCallExp);
			if (!isMatched) {
				return getConditionalExpressionAnalyzer().visitOperationCallExp(operationCallExp);
			}
		}
		assert !operationCallExp.isIsSafe();
		Operation referredOperation = operationCallExp.getReferredOperation();
		OCLExpression ownedSource = operationCallExp.getOwnedSource();
		if (ownedSource instanceof VariableExp) {
			Transformation transformation = QVTbaseUtil.getContainingTransformation(operationCallExp);
			Variable thisVariable = QVTbaseUtil.getContextVariable(scheduleManager.getStandardLibrary(), transformation);
			if (((VariableExp)ownedSource).getReferredVariable() == thisVariable) {
				ownedSource = null;
			}
		}
		String operationName = ClassUtil.nonNullState(referredOperation.getName());
		if (ownedSource == null) {
			List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
			int iSize = ownedArguments.size();
			@NonNull Node[] argNodes = new @NonNull Node[iSize];
			@NonNull String [] argNames = new @NonNull String[iSize];
			for (int i = 0; i < iSize; i++) {
				argNodes[i] = analyze(ownedArguments.get(i));
				argNames[i] = "«" + referredOperation.getOwnedParameters().get(i).getName() + "»";
			}
			Node operationNode = createConnectedOperationNode(operationName, argNames, operationCallExp, argNodes);
			return operationNode;
		}
		OperationId operationId = referredOperation.getOperationId();
		//
		//	"=" is best handled as a single multi-constrained node
		//
		if ((operationCallExp.eContainer() instanceof Predicate)
				&& !(ownedSource.getType() instanceof DataType)
				&& PivotUtil.isSameOperation(operationId, standardLibraryHelper.getOclAnyEqualsId())) {
			return analyzeOperationCallExp_equals(operationCallExp);
		}
		Node sourceNode = analyze(ownedSource);
		// FIXME "=" can identify that LHS and RHS can be coalesced
		// FIXME "includes" may also indicate a coalesce
		if (operationId == standardLibraryHelper.getOclAnyOclAsTypeId()) {
			return analyzeOperationCallExp_oclAsType(sourceNode, operationCallExp);
		}
		else if (PivotUtil.isSameOperation(operationId, standardLibraryHelper.getOclElementOclContainerId())) {
			return analyzeOperationCallExp_oclContainer(sourceNode, operationCallExp);
		}
		else if (PivotUtil.isSameOperation(operationId, standardLibraryHelper.getOclAnyOclIsKindOfId())) {
			return analyzeOperationCallExp_oclIsKindOf(sourceNode, operationCallExp);
		}
		else if ((operationCallExp.eContainer() instanceof Predicate)
				&& (sourceNode.getCompleteClass().getPrimaryClass() instanceof CollectionType)
				&& "includes".equals(operationName)) {
			return analyzeOperationCallExp_includes(sourceNode, operationCallExp);
		}
		else {
			List<OCLExpression> ownedArguments = operationCallExp.getOwnedArguments();
			int iSize = ownedArguments.size();
			@NonNull Node[] argNodes = new @NonNull Node[iSize+1];
			@NonNull String [] argNames = new @NonNull String[iSize+1];
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
					QVTm2QVTs qvtm2qvts = (QVTm2QVTs) scheduleManager;		// FIXME cast
					OperationRegion operationRegion = qvtm2qvts.analyzeOperation(scheduleManager, operationCallExp);
					Iterable<@NonNull Node> referenceNodes = QVTscheduleUtil.getDependencyNodes(operationRegion);
					for (@NonNull Node referenceNode : referenceNodes) {
						ClassDatum classDatum = QVTscheduleUtil.getClassDatum(referenceNode);
						Node dependencyHead = context.getDependencyHead(classDatum);
						if (dependencyHead == null) {
							dependencyHead = context.createDependencyHead(classDatum);
							createExpressionEdge(dependencyHead, QVTscheduleUtil.getName(dependencyHead), operationNode);
							instantiate(dependencyHead, referenceNode);
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
		@NonNull String [] partNames = new @NonNull String[iSize];
		for (int i = 0; i < iSize; i++) {
			ShadowPart shadowPart = ownedParts.get(i);
			partNodes[i] = analyze(shadowPart);
			partNames[i] = ClassUtil.nonNullState(shadowPart.getName());
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
	public @NonNull Node visitStringLiteralExp(@NonNull StringLiteralExp stringLiteralExp) {
		Node operationNode = createOperationNode(ClassUtil.nonNullState(stringLiteralExp.getStringSymbol()), stringLiteralExp);
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
		DomainUsage domainUsage = scheduleManager.getDomainUsage(typeExp);
		Type referredType = QVTcoreUtil.getReferredType(typeExp);
		TypedModel typedModel = domainUsage.getTypedModel(typeExp);
		assert typedModel != null;
		ClassDatum classDatum = scheduleManager.getClassDatum((org.eclipse.ocl.pivot.Class)referredType, typedModel);
		String typeName = PrettyPrinter.printType(QVTscheduleUtil.getCompleteClass(classDatum));
		Node operationNode = createConnectedOperationNode(typeName, typeExp);
		return operationNode;
	}

	@Override
	public @Nullable Node visitVariableAssignment(@NonNull VariableAssignment variableAssignment) {
		return null;
	}

	@Override
	public @NonNull Node visitVariableExp(@NonNull VariableExp variableExp) {
		VariableDeclaration referredVariable = QVTcoreUtil.getReferredVariable(variableExp);
		return context.getReferenceNode(referredVariable);
	}
}